package com.hierynomus.smbj.share;

import com.hierynomus.mserref.NtStatus;
import com.hierynomus.msfscc.fileinformation.FileEndOfFileInformation;
import com.hierynomus.msfscc.fileinformation.FileStandardInformation;
import com.hierynomus.mssmb2.SMB2FileId;
import com.hierynomus.mssmb2.SMBApiException;
import com.hierynomus.mssmb2.copy.CopyChunkRequest;
import com.hierynomus.mssmb2.copy.CopyChunkResponse;
import com.hierynomus.mssmb2.messages.SMB2IoctlResponse;
import com.hierynomus.mssmb2.messages.SMB2ReadResponse;
import com.hierynomus.smb.SMBBuffer;
import com.hierynomus.smbj.ProgressListener;
import com.hierynomus.smbj.common.SMBRuntimeException;
import com.hierynomus.smbj.common.SmbPath;
import com.hierynomus.smbj.io.ArrayByteChunkProvider;
import com.hierynomus.smbj.io.ByteBufferByteChunkProvider;
import com.hierynomus.smbj.io.ByteChunkProvider;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class File extends DiskEntry {
    private static final StatusHandler COPY_CHUNK_ALLOWED_STATUS_VALUES = new StatusHandler() { // from class: com.hierynomus.smbj.share.File.1
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.smbj.share.StatusHandler
        public boolean isSuccess(long j) {
            return j == NtStatus.STATUS_SUCCESS.getValue() || j == NtStatus.STATUS_INVALID_PARAMETER.getValue();
        }
    };
    private static final int FSCTL_SRV_REQUEST_RESUME_KEY = 1310840;
    private final SMB2Writer writer;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public File(SMB2FileId sMB2FileId, DiskShare diskShare, SmbPath smbPath) {
        super(sMB2FileId, diskShare, smbPath);
        this.writer = new SMB2Writer(diskShare, sMB2FileId, smbPath.toUncPath());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static SMB2IoctlResponse copyChunk(Share share, File file, CopyChunkRequest copyChunkRequest) {
        SMBBuffer sMBBuffer = new SMBBuffer();
        copyChunkRequest.write(sMBBuffer);
        byte[] compactData = sMBBuffer.getCompactData();
        SMB2IoctlResponse sMB2IoctlResponse = (SMB2IoctlResponse) share.receive(share.ioctlAsync(file.fileId, CopyChunkRequest.getCtlCode(), true, new ArrayByteChunkProvider(compactData, 0, compactData.length, 0L), 12), "IOCTL", file.fileId, COPY_CHUNK_ALLOWED_STATUS_VALUES, share.getReadTimeout());
        if (sMB2IoctlResponse.getError() == null) {
            return sMB2IoctlResponse;
        }
        throw new SMBApiException(sMB2IoctlResponse.getHeader(), "FSCTL_SRV_COPYCHUNK failed");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static List<CopyChunkRequest.Chunk> createCopyChunks(long j, long j2, long j3, long j4, long j5, long j6) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        long j7 = j;
        long j8 = j2;
        long j9 = j3;
        int i2 = 0;
        while (j9 > 0 && i < j4) {
            long j10 = i2;
            if (j10 >= j6) {
                break;
            }
            long jMin = Math.min(j9, j5);
            arrayList.add(new CopyChunkRequest.Chunk(j7, j8, jMin));
            i++;
            i2 = (int) (j10 + jMin);
            j7 += jMin;
            j8 += jMin;
            j9 -= jMin;
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private byte[] getResumeKey() {
        return Arrays.copyOf(ioctl(FSCTL_SRV_REQUEST_RESUME_KEY, true, new byte[0], 0, 0, 32), 24);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void remoteFileCopy(File file, long j, File file2, long j2, long j3) {
        byte[] resumeKey = file.getResumeKey();
        long j4 = j;
        long j5 = j2;
        long j6 = j3;
        long jMin = 1048576;
        long j7 = 16;
        while (j6 > 0) {
            SMB2IoctlResponse sMB2IoctlResponseCopyChunk = copyChunk(file.share, file2, new CopyChunkRequest(resumeKey, createCopyChunks(j4, j5, j6, j7, jMin, 16777216L)));
            CopyChunkResponse copyChunkResponse = new CopyChunkResponse();
            byte[] bArr = resumeKey;
            copyChunkResponse.read(new SMBBuffer(sMB2IoctlResponseCopyChunk.getOutputBuffer()));
            if (sMB2IoctlResponseCopyChunk.getHeader().getStatusCode() == NtStatus.STATUS_INVALID_PARAMETER.getValue()) {
                long chunksWritten = copyChunkResponse.getChunksWritten();
                jMin = Math.min(copyChunkResponse.getChunkBytesWritten(), copyChunkResponse.getTotalBytesWritten());
                j7 = chunksWritten;
            } else {
                long totalBytesWritten = copyChunkResponse.getTotalBytesWritten();
                j4 += totalBytesWritten;
                j5 += totalBytesWritten;
                j6 -= totalBytesWritten;
            }
            resumeKey = bArr;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public InputStream getInputStream(ProgressListener progressListener) {
        return new FileInputStream(this, ((DiskShare) this.share).getReadBufferSize(), ((DiskShare) this.share).getReadTimeout(), progressListener);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public OutputStream getOutputStream(ProgressListener progressListener, boolean z) {
        return this.writer.getOutputStream(progressListener, z ? ((FileStandardInformation) getFileInformation(FileStandardInformation.class)).getEndOfFile() : 0L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long read(ByteBuffer byteBuffer, long j) {
        int iRemaining = byteBuffer.remaining();
        SMB2ReadResponse sMB2ReadResponse = ((DiskShare) this.share).read(this.fileId, j, iRemaining);
        if (sMB2ReadResponse.getHeader().getStatusCode() == NtStatus.STATUS_END_OF_FILE.getValue()) {
            return -1L;
        }
        byte[] data = sMB2ReadResponse.getData();
        int iMin = Math.min(iRemaining, data.length);
        byteBuffer.put(data, 0, iMin);
        return iMin;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Future<SMB2ReadResponse> readAsync(long j, int i) {
        return ((DiskShare) this.share).readAsync(this.fileId, j, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void remoteCopyTo(File file) {
        if (file.share != this.share) {
            throw new SMBRuntimeException("Remote copy is only possible between files on the same server");
        }
        remoteCopyTo(0L, file, 0L, ((FileStandardInformation) getFileInformation(FileStandardInformation.class)).getEndOfFile());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setLength(long j) {
        setFileInformation(new FileEndOfFileInformation(j));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "File{fileId=" + this.fileId + ", fileName='" + this.name.toUncPath() + "'}";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long write(ByteBuffer byteBuffer, long j) {
        return write(new ByteBufferByteChunkProvider(byteBuffer, j));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Future<Long> writeAsync(byte[] bArr, long j, int i, int i2) {
        return this.writer.writeAsync(bArr, j, i, i2);
    }

    public Future<Long> writeAsync(ByteChunkProvider byteChunkProvider) {
        return this.writer.writeAsync(byteChunkProvider);
    }

    public long write(byte[] bArr, long j, int i, int i2) {
        return this.writer.write(bArr, j, i, i2);
    }

    public long write(ByteChunkProvider byteChunkProvider) {
        return this.writer.write(byteChunkProvider);
    }

    public long write(ByteChunkProvider byteChunkProvider, ProgressListener progressListener) {
        return this.writer.write(byteChunkProvider, progressListener);
    }

    public long write(byte[] bArr, long j) {
        return this.writer.write(bArr, j);
    }

    public InputStream getInputStream() {
        return getInputStream(null);
    }

    public OutputStream getOutputStream(boolean z) {
        return getOutputStream(null, z);
    }

    public OutputStream getOutputStream(ProgressListener progressListener) {
        return getOutputStream(progressListener, false);
    }

    public OutputStream getOutputStream() {
        return getOutputStream(false);
    }

    public void remoteCopyTo(long j, File file, long j2, long j3) {
        if (file.share == this.share) {
            remoteFileCopy(this, j, file, j2, j3);
            return;
        }
        throw new SMBRuntimeException("Remote copy is only possible between files on the same server");
    }

    public int read(byte[] bArr, long j, int i, int i2) {
        SMB2ReadResponse sMB2ReadResponse = ((DiskShare) this.share).read(this.fileId, j, i2);
        if (sMB2ReadResponse.getHeader().getStatusCode() == NtStatus.STATUS_END_OF_FILE.getValue()) {
            return -1;
        }
        byte[] data = sMB2ReadResponse.getData();
        int iMin = Math.min(i2, data.length);
        System.arraycopy(data, 0, bArr, i, iMin);
        return iMin;
    }

    public void read(OutputStream outputStream) throws IOException {
        read(outputStream, (ProgressListener) null);
    }

    public void read(OutputStream outputStream, ProgressListener progressListener) throws IOException {
        InputStream inputStream = getInputStream(progressListener);
        byte[] bArr = new byte[((DiskShare) this.share).getReadBufferSize()];
        while (true) {
            int i = inputStream.read(bArr);
            if (i != -1) {
                outputStream.write(bArr, 0, i);
            } else {
                inputStream.close();
                return;
            }
        }
    }

    public int read(byte[] bArr, long j) {
        return read(bArr, j, 0, bArr.length);
    }
}
