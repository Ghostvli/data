package com.hierynomus.smbj.share;

import com.hierynomus.msdtyp.AccessMask;
import com.hierynomus.msdtyp.SecurityInformation;
import com.hierynomus.mserref.NtStatus;
import com.hierynomus.msfscc.FileAttributes;
import com.hierynomus.msfscc.FileInformationClass;
import com.hierynomus.msfscc.FileSystemInformationClass;
import com.hierynomus.mssmb2.SMB2ChangeNotifyFlags;
import com.hierynomus.mssmb2.SMB2CompletionFilter;
import com.hierynomus.mssmb2.SMB2CreateDisposition;
import com.hierynomus.mssmb2.SMB2CreateOptions;
import com.hierynomus.mssmb2.SMB2Dialect;
import com.hierynomus.mssmb2.SMB2FileId;
import com.hierynomus.mssmb2.SMB2ImpersonationLevel;
import com.hierynomus.mssmb2.SMB2Packet;
import com.hierynomus.mssmb2.SMB2PacketHeader;
import com.hierynomus.mssmb2.SMB2ShareAccess;
import com.hierynomus.mssmb2.SMBApiException;
import com.hierynomus.mssmb2.messages.SMB2ChangeNotifyRequest;
import com.hierynomus.mssmb2.messages.SMB2ChangeNotifyResponse;
import com.hierynomus.mssmb2.messages.SMB2Close;
import com.hierynomus.mssmb2.messages.SMB2CreateRequest;
import com.hierynomus.mssmb2.messages.SMB2CreateResponse;
import com.hierynomus.mssmb2.messages.SMB2Flush;
import com.hierynomus.mssmb2.messages.SMB2IoctlRequest;
import com.hierynomus.mssmb2.messages.SMB2IoctlResponse;
import com.hierynomus.mssmb2.messages.SMB2LockRequest;
import com.hierynomus.mssmb2.messages.SMB2LockResponse;
import com.hierynomus.mssmb2.messages.SMB2QueryDirectoryRequest;
import com.hierynomus.mssmb2.messages.SMB2QueryDirectoryResponse;
import com.hierynomus.mssmb2.messages.SMB2QueryInfoRequest;
import com.hierynomus.mssmb2.messages.SMB2QueryInfoResponse;
import com.hierynomus.mssmb2.messages.SMB2ReadRequest;
import com.hierynomus.mssmb2.messages.SMB2ReadResponse;
import com.hierynomus.mssmb2.messages.SMB2SetInfoRequest;
import com.hierynomus.mssmb2.messages.SMB2WriteRequest;
import com.hierynomus.mssmb2.messages.SMB2WriteResponse;
import com.hierynomus.mssmb2.messages.submodule.SMB2LockElement;
import com.hierynomus.protocol.commons.concurrent.Futures;
import com.hierynomus.protocol.transport.TransportException;
import com.hierynomus.smbj.SmbConfig;
import com.hierynomus.smbj.common.SMBRuntimeException;
import com.hierynomus.smbj.common.SmbPath;
import com.hierynomus.smbj.connection.NegotiatedProtocol;
import com.hierynomus.smbj.io.ArrayByteChunkProvider;
import com.hierynomus.smbj.io.ByteChunkProvider;
import com.hierynomus.smbj.io.EmptyByteChunkProvider;
import com.hierynomus.smbj.session.Session;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Share implements AutoCloseable {
    private final SMB2Dialect dialect;
    private final AtomicBoolean disconnected = new AtomicBoolean(false);
    private final int readBufferSize;
    private final long readTimeout;
    protected Session session;
    private final long sessionId;
    protected final SmbPath smbPath;
    private final int transactBufferSize;
    private final long transactTimeout;
    protected final TreeConnect treeConnect;
    private final long treeId;
    private final int writeBufferSize;
    private final long writeTimeout;
    private static final SMB2FileId ROOT_ID = new SMB2FileId(new byte[]{-1, -1, -1, -1, -1, -1, -1, -1}, new byte[]{-1, -1, -1, -1, -1, -1, -1, -1});
    private static final StatusHandler SUCCESS_OR_SYMLINK = new StatusHandler() { // from class: com.hierynomus.smbj.share.Share.1
        @Override // com.hierynomus.smbj.share.StatusHandler
        public boolean isSuccess(long j) {
            return j == NtStatus.STATUS_SUCCESS.getValue() || j == NtStatus.STATUS_STOPPED_ON_SYMLINK.getValue();
        }
    };
    private static final StatusHandler SUCCESS_OR_NO_MORE_FILES_OR_NO_SUCH_FILE = new StatusHandler() { // from class: com.hierynomus.smbj.share.Share.2
        @Override // com.hierynomus.smbj.share.StatusHandler
        public boolean isSuccess(long j) {
            return j == NtStatus.STATUS_SUCCESS.getValue() || j == NtStatus.STATUS_NO_MORE_FILES.getValue() || j == NtStatus.STATUS_NO_SUCH_FILE.getValue();
        }
    };
    private static final StatusHandler SUCCESS_OR_EOF = new StatusHandler() { // from class: com.hierynomus.smbj.share.Share.3
        @Override // com.hierynomus.smbj.share.StatusHandler
        public boolean isSuccess(long j) {
            return j == NtStatus.STATUS_SUCCESS.getValue() || j == NtStatus.STATUS_END_OF_FILE.getValue();
        }
    };
    private static final StatusHandler SUCCESS_OR_CLOSED = new StatusHandler() { // from class: com.hierynomus.smbj.share.Share.4
        @Override // com.hierynomus.smbj.share.StatusHandler
        public boolean isSuccess(long j) {
            return j == NtStatus.STATUS_SUCCESS.getValue() || j == NtStatus.STATUS_FILE_CLOSED.getValue();
        }
    };
    private static final EmptyByteChunkProvider EMPTY = new EmptyByteChunkProvider(0);

    public Share(SmbPath smbPath, TreeConnect treeConnect) {
        this.smbPath = smbPath;
        this.treeConnect = treeConnect;
        this.session = treeConnect.getSession();
        NegotiatedProtocol negotiatedProtocol = treeConnect.getNegotiatedProtocol();
        this.dialect = negotiatedProtocol.getDialect();
        SmbConfig config = treeConnect.getConfig();
        this.readBufferSize = Math.min(config.getReadBufferSize(), negotiatedProtocol.getMaxReadSize());
        this.readTimeout = config.getReadTimeout();
        this.writeBufferSize = Math.min(config.getWriteBufferSize(), negotiatedProtocol.getMaxWriteSize());
        this.writeTimeout = config.getWriteTimeout();
        this.transactBufferSize = Math.min(config.getTransactBufferSize(), negotiatedProtocol.getMaxTransactSize());
        this.transactTimeout = config.getTransactTimeout();
        this.sessionId = this.session.getSessionId();
        this.treeId = treeConnect.getTreeId();
    }

    private <T extends SMB2Packet> Future<T> send(SMB2Packet sMB2Packet) {
        if (!isConnected()) {
            throw new SMBRuntimeException(getClass().getSimpleName().concat(" has already been closed"));
        }
        try {
            return this.session.send(sMB2Packet);
        } catch (TransportException e) {
            throw new SMBRuntimeException(e);
        }
    }

    private <T extends SMB2Packet> T sendReceive(SMB2Packet sMB2Packet, String str, Object obj, StatusHandler statusHandler, long j) {
        return (T) receive(send(sMB2Packet), str, obj, statusHandler, j);
    }

    public Future<SMB2ChangeNotifyResponse> changeNotifyAsync(SMB2FileId sMB2FileId, Set<SMB2CompletionFilter> set, Set<SMB2ChangeNotifyFlags> set2) {
        return send(new SMB2ChangeNotifyRequest(this.dialect, this.sessionId, this.treeId, sMB2FileId, set, set2, this.transactBufferSize));
    }

    @Override // java.lang.AutoCloseable
    public void close() {
        if (this.disconnected.getAndSet(true)) {
            return;
        }
        this.treeConnect.close();
    }

    public void closeFileId(SMB2FileId sMB2FileId) {
        sendReceive(new SMB2Close(this.dialect, this.sessionId, this.treeId, sMB2FileId), "Close", sMB2FileId, SUCCESS_OR_CLOSED, this.transactTimeout);
    }

    public Future<SMB2Close> closeFileIdNoWait(SMB2FileId sMB2FileId) {
        return send(new SMB2Close(this.dialect, this.sessionId, this.treeId, sMB2FileId));
    }

    public SMB2CreateResponse createFile(SmbPath smbPath, SMB2ImpersonationLevel sMB2ImpersonationLevel, Set<AccessMask> set, Set<FileAttributes> set2, Set<SMB2ShareAccess> set3, SMB2CreateDisposition sMB2CreateDisposition, Set<SMB2CreateOptions> set4) {
        return (SMB2CreateResponse) sendReceive(new SMB2CreateRequest(this.dialect, this.sessionId, this.treeId, sMB2ImpersonationLevel, set, set2, set3, sMB2CreateDisposition, set4, smbPath), "Create", smbPath, getCreateStatusHandler(), this.transactTimeout);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SmbPath smbPath = this.smbPath;
        SmbPath smbPath2 = ((Share) obj).smbPath;
        if (smbPath == null) {
            if (smbPath2 != null) {
                return false;
            }
        } else if (!smbPath.equals(smbPath2)) {
            return false;
        }
        return true;
    }

    public void flush(SMB2FileId sMB2FileId) {
        sendReceive(new SMB2Flush(this.dialect, sMB2FileId, this.sessionId, this.treeId), "Flush", sMB2FileId, StatusHandler.SUCCESS, this.writeTimeout);
    }

    public StatusHandler getCreateStatusHandler() {
        return SUCCESS_OR_SYMLINK;
    }

    public SMB2Dialect getDialect() {
        return this.dialect;
    }

    public int getReadBufferSize() {
        return this.readBufferSize;
    }

    public long getReadTimeout() {
        return this.readTimeout;
    }

    public SmbPath getSmbPath() {
        return this.smbPath;
    }

    public TreeConnect getTreeConnect() {
        return this.treeConnect;
    }

    public int getWriteBufferSize() {
        return this.writeBufferSize;
    }

    public int hashCode() {
        SmbPath smbPath = this.smbPath;
        return 31 + (smbPath == null ? 0 : smbPath.hashCode());
    }

    public int ioctl(SMB2FileId sMB2FileId, long j, boolean z, byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        SMB2IoctlResponse sMB2IoctlResponseIoctl = ioctl(sMB2FileId, j, z, new ArrayByteChunkProvider(bArr, i, i2, 0L), i4);
        if (bArr2 == null) {
            return 0;
        }
        byte[] outputBuffer = sMB2IoctlResponseIoctl.getOutputBuffer();
        int iMin = Math.min(i4, outputBuffer.length);
        System.arraycopy(outputBuffer, 0, bArr2, i3, iMin);
        return iMin;
    }

    public Future<SMB2IoctlResponse> ioctlAsync(SMB2FileId sMB2FileId, long j, boolean z, ByteChunkProvider byteChunkProvider, int i) {
        int i2;
        ByteChunkProvider byteChunkProvider2 = byteChunkProvider == null ? EMPTY : byteChunkProvider;
        byteChunkProvider2.prepareWrite(this.transactBufferSize + 1);
        int iBytesLeft = byteChunkProvider2.bytesLeft();
        int i3 = this.transactBufferSize;
        if (iBytesLeft > i3) {
            throw new SMBRuntimeException("Input data size exceeds maximum allowed by server: " + byteChunkProvider2.bytesLeft() + " > " + this.transactBufferSize);
        }
        if (i < 0) {
            i2 = i3;
        } else {
            if (i > i3) {
                throw new SMBRuntimeException("Output data size exceeds maximum allowed by server: " + i + " > " + this.transactBufferSize);
            }
            i2 = i;
        }
        return send(new SMB2IoctlRequest(this.dialect, this.sessionId, this.treeId, j, sMB2FileId, byteChunkProvider2, z, i2));
    }

    public boolean isConnected() {
        return !this.disconnected.get();
    }

    public SMB2FileId openFileId(SmbPath smbPath, SMB2ImpersonationLevel sMB2ImpersonationLevel, Set<AccessMask> set, Set<FileAttributes> set2, Set<SMB2ShareAccess> set3, SMB2CreateDisposition sMB2CreateDisposition, Set<SMB2CreateOptions> set4) {
        return createFile(smbPath, sMB2ImpersonationLevel, set, set2, set3, sMB2CreateDisposition, set4).getFileId();
    }

    public SMB2QueryDirectoryResponse queryDirectory(SMB2FileId sMB2FileId, Set<SMB2QueryDirectoryRequest.SMB2QueryDirectoryFlags> set, FileInformationClass fileInformationClass, String str) {
        return (SMB2QueryDirectoryResponse) sendReceive(new SMB2QueryDirectoryRequest(this.dialect, this.sessionId, this.treeId, sMB2FileId, fileInformationClass, set, 0L, str, this.transactBufferSize), "Query directory", sMB2FileId, SUCCESS_OR_NO_MORE_FILES_OR_NO_SUCH_FILE, this.transactTimeout);
    }

    public SMB2QueryInfoResponse queryInfo(SMB2FileId sMB2FileId, SMB2QueryInfoRequest.SMB2QueryInfoType sMB2QueryInfoType, Set<SecurityInformation> set, FileInformationClass fileInformationClass, FileSystemInformationClass fileSystemInformationClass) {
        return (SMB2QueryInfoResponse) sendReceive(new SMB2QueryInfoRequest(this.dialect, this.sessionId, this.treeId, sMB2FileId, sMB2QueryInfoType, fileInformationClass, fileSystemInformationClass, null, set), "QueryInfo", sMB2FileId, StatusHandler.SUCCESS, this.transactTimeout);
    }

    public SMB2ReadResponse read(SMB2FileId sMB2FileId, long j, int i) {
        return (SMB2ReadResponse) receive(readAsync(sMB2FileId, j, i), "Read", sMB2FileId, SUCCESS_OR_EOF, this.readTimeout);
    }

    public Future<SMB2ReadResponse> readAsync(SMB2FileId sMB2FileId, long j, int i) {
        return send(new SMB2ReadRequest(this.dialect, sMB2FileId, this.sessionId, this.treeId, j, Math.min(i, this.readBufferSize)));
    }

    public <T extends SMB2Packet> T receive(Future<T> future, String str, Object obj, StatusHandler statusHandler, long j) {
        T t = (T) receive(future, j);
        if (statusHandler.isSuccess(((SMB2PacketHeader) t.getHeader()).getStatusCode())) {
            return t;
        }
        throw new SMBApiException((SMB2PacketHeader) t.getHeader(), str + " failed for " + obj);
    }

    public SMB2LockResponse sendLockRequest(SMB2FileId sMB2FileId, short s, int i, List<SMB2LockElement> list) {
        return (SMB2LockResponse) sendReceive(new SMB2LockRequest(this.dialect, this.sessionId, this.treeId, s, i, sMB2FileId, list), "Lock", sMB2FileId, StatusHandler.SUCCESS, this.transactTimeout);
    }

    public void setInfo(SMB2FileId sMB2FileId, SMB2SetInfoRequest.SMB2InfoType sMB2InfoType, Set<SecurityInformation> set, FileInformationClass fileInformationClass, byte[] bArr) {
        sendReceive(new SMB2SetInfoRequest(this.dialect, this.sessionId, this.treeId, sMB2InfoType, sMB2FileId, fileInformationClass, set, bArr), "SetInfo", sMB2FileId, StatusHandler.SUCCESS, this.transactTimeout);
    }

    public SMB2WriteResponse write(SMB2FileId sMB2FileId, ByteChunkProvider byteChunkProvider) {
        return (SMB2WriteResponse) receive(writeAsync(sMB2FileId, byteChunkProvider), "Write", sMB2FileId, StatusHandler.SUCCESS, this.writeTimeout);
    }

    public Future<SMB2WriteResponse> writeAsync(SMB2FileId sMB2FileId, ByteChunkProvider byteChunkProvider) {
        byteChunkProvider.prepareWrite(this.writeBufferSize);
        return send(new SMB2WriteRequest(this.dialect, sMB2FileId, this.sessionId, this.treeId, byteChunkProvider, this.writeBufferSize));
    }

    public byte[] ioctl(long j, boolean z, byte[] bArr, int i, int i2) {
        return ioctl(ROOT_ID, j, z, bArr, i, i2);
    }

    public int ioctl(long j, boolean z, byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        return ioctl(ROOT_ID, j, z, bArr, i, i2, bArr2, i3, i4);
    }

    public byte[] ioctl(SMB2FileId sMB2FileId, long j, boolean z, byte[] bArr, int i, int i2) {
        return ioctl(sMB2FileId, j, z, bArr, i, i2, -1);
    }

    public byte[] ioctl(SMB2FileId sMB2FileId, long j, boolean z, byte[] bArr, int i, int i2, int i3) {
        return ioctl(sMB2FileId, j, z, new ArrayByteChunkProvider(bArr, i, i2, 0L), i3).getOutputBuffer();
    }

    public byte[] ioctl(long j, boolean z, byte[] bArr) {
        return ioctl(ROOT_ID, j, z, bArr, 0, bArr.length);
    }

    public SMB2IoctlResponse ioctl(SMB2FileId sMB2FileId, long j, boolean z, ByteChunkProvider byteChunkProvider, int i) {
        return (SMB2IoctlResponse) receive(ioctlAsync(sMB2FileId, j, z, byteChunkProvider, i), "IOCTL", sMB2FileId, StatusHandler.SUCCESS, this.transactTimeout);
    }

    public <T extends SMB2Packet> T receive(Future<T> future, long j) {
        try {
            if (j > 0) {
                return (T) Futures.get(future, j, TimeUnit.MILLISECONDS, TransportException.Wrapper);
            }
            return (T) Futures.get(future, TransportException.Wrapper);
        } catch (TransportException e) {
            throw new SMBRuntimeException(e);
        }
    }

    public Future<SMB2IoctlResponse> ioctlAsync(long j, boolean z, ByteChunkProvider byteChunkProvider) {
        return ioctlAsync(ROOT_ID, j, z, byteChunkProvider, -1);
    }
}
