package com.hierynomus.smbj.share;

import com.hierynomus.mssmb2.SMB2FileId;
import com.hierynomus.mssmb2.messages.SMB2WriteResponse;
import com.hierynomus.protocol.commons.concurrent.AFuture;
import com.hierynomus.protocol.commons.concurrent.Futures;
import com.hierynomus.smbj.ProgressListener;
import com.hierynomus.smbj.common.SMBRuntimeException;
import com.hierynomus.smbj.io.ArrayByteChunkProvider;
import com.hierynomus.smbj.io.ByteChunkProvider;
import defpackage.j02;
import defpackage.n02;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMB2Writer {
    private static final j02 logger = n02.k(SMB2Writer.class);
    private String entryName;
    private SMB2FileId fileId;
    private Share share;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMB2Writer(Share share, SMB2FileId sMB2FileId, String str) {
        this.share = share;
        this.fileId = sMB2FileId;
        this.entryName = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public OutputStream getOutputStream(ProgressListener progressListener, long j) {
        return new FileOutputStream(this, this.share.getWriteBufferSize(), j, progressListener);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long write(ByteChunkProvider byteChunkProvider, ProgressListener progressListener) {
        int bytesWritten = 0;
        while (byteChunkProvider.isAvailable()) {
            logger.f("Writing to {} from offset {}", this.entryName, Long.valueOf(byteChunkProvider.getOffset()));
            bytesWritten += this.share.write(this.fileId, byteChunkProvider).getBytesWritten();
            if (progressListener != null) {
                progressListener.onProgressChanged(r1.getBytesWritten(), byteChunkProvider.getOffset());
            }
        }
        return bytesWritten;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Future<Long> writeAsync(ByteChunkProvider byteChunkProvider) {
        ArrayList arrayList = new ArrayList();
        while (byteChunkProvider.isAvailable()) {
            logger.f("Sending async write request to {} from offset {}", this.entryName, Long.valueOf(byteChunkProvider.getOffset()));
            Future<SMB2WriteResponse> futureWriteAsync = this.share.writeAsync(this.fileId, byteChunkProvider);
            final long lastWriteSize = byteChunkProvider.getLastWriteSize();
            arrayList.add(Futures.transform(futureWriteAsync, new AFuture.Function<SMB2WriteResponse, Long>() { // from class: com.hierynomus.smbj.share.SMB2Writer.1
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                /* JADX DEBUG: Method merged with bridge method: apply(Ljava/lang/Object;)Ljava/lang/Object; */
                @Override // com.hierynomus.protocol.commons.concurrent.AFuture.Function
                public Long apply(SMB2WriteResponse sMB2WriteResponse) {
                    long bytesWritten = sMB2WriteResponse.getBytesWritten();
                    long j = lastWriteSize;
                    if (bytesWritten == j) {
                        return Long.valueOf(j);
                    }
                    throw new SMBRuntimeException("Possible remote file corruption detected, server wrote less bytes (" + bytesWritten + ") in async mode than we sent (" + lastWriteSize + ").");
                }
            }));
        }
        return Futures.transform(Futures.sequence(arrayList), new AFuture.Function<List<Long>, Long>() { // from class: com.hierynomus.smbj.share.SMB2Writer.2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: apply(Ljava/lang/Object;)Ljava/lang/Object; */
            @Override // com.hierynomus.protocol.commons.concurrent.AFuture.Function
            public Long apply(List<Long> list) {
                Iterator<Long> it = list.iterator();
                long jLongValue = 0;
                while (it.hasNext()) {
                    jLongValue += it.next().longValue();
                }
                return Long.valueOf(jLongValue);
            }
        });
    }

    public OutputStream getOutputStream() {
        return getOutputStream(null, 0L);
    }

    public long write(byte[] bArr, long j, int i, int i2) {
        return write(new ArrayByteChunkProvider(bArr, i, i2, j), (ProgressListener) null);
    }

    public long write(ByteChunkProvider byteChunkProvider) {
        return write(byteChunkProvider, (ProgressListener) null);
    }

    public long write(byte[] bArr, long j) {
        return write(bArr, j, 0, bArr.length);
    }

    public Future<Long> writeAsync(byte[] bArr, long j, int i, int i2) {
        return writeAsync(new ArrayByteChunkProvider(bArr, i, i2, j));
    }
}
