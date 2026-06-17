package com.hierynomus.smbj.share;

import com.hierynomus.msfscc.fsctl.FsCtlPipePeekResponse;
import com.hierynomus.mssmb2.SMB2FileId;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.smb.SMBBuffer;
import com.hierynomus.smbj.common.SMBRuntimeException;
import com.hierynomus.smbj.common.SmbPath;
import com.hierynomus.smbj.io.ArrayByteChunkProvider;
import defpackage.j02;
import defpackage.n02;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NamedPipe extends Open<PipeShare> {
    private static final long FSCTL_PIPE_PEEK = 1130508;
    private static final long FSCTL_PIPE_TRANSCEIVE = 1163287;
    protected final j02 logger;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NamedPipe(SMB2FileId sMB2FileId, PipeShare pipeShare, SmbPath smbPath) {
        super(sMB2FileId, smbPath, pipeShare);
        this.logger = n02.k(getClass());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getName() {
        return this.name.getPath();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int ioctl(long j, boolean z, byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        return ((PipeShare) this.share).ioctl(this.fileId, j, z, bArr, i, i2, bArr2, i3, i4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FsCtlPipePeekResponse peek(int i) {
        try {
            SMBBuffer sMBBuffer = new SMBBuffer(((PipeShare) this.share).ioctl(this.fileId, FSCTL_PIPE_PEEK, true, null, 0, 0, i + 24));
            FsCtlPipePeekResponse fsCtlPipePeekResponse = new FsCtlPipePeekResponse();
            fsCtlPipePeekResponse.read(sMBBuffer);
            return fsCtlPipePeekResponse;
        } catch (Buffer.BufferException e) {
            throw new SMBRuntimeException(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int read(byte[] bArr, int i, int i2) {
        byte[] data = ((PipeShare) this.share).read(this.fileId, 0L, i2).getData();
        int iMin = Math.min(i2, data.length);
        System.arraycopy(data, 0, bArr, i, iMin);
        return iMin;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int transact(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        return ioctl(FSCTL_PIPE_TRANSCEIVE, true, bArr, i, i2, bArr2, i3, i4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int write(byte[] bArr, int i, int i2) {
        ArrayByteChunkProvider arrayByteChunkProvider = new ArrayByteChunkProvider(bArr, i, i2, 0L);
        this.logger.f("Writing to {} from offset {}", this.name, Long.valueOf(arrayByteChunkProvider.getOffset()));
        return ((PipeShare) this.share).write(this.fileId, arrayByteChunkProvider).getBytesWritten();
    }

    public int transact(byte[] bArr, byte[] bArr2) {
        return transact(bArr, 0, bArr.length, bArr2, 0, bArr2.length);
    }

    public byte[] transact(byte[] bArr) {
        return ioctl(FSCTL_PIPE_TRANSCEIVE, true, bArr, 0, bArr.length);
    }

    public byte[] ioctl(long j, boolean z, byte[] bArr, int i, int i2) {
        return ((PipeShare) this.share).ioctl(this.fileId, j, z, bArr, i, i2);
    }

    public int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public FsCtlPipePeekResponse peek() {
        return peek(0);
    }

    public int write(byte[] bArr) {
        return write(bArr, 0, bArr.length);
    }
}
