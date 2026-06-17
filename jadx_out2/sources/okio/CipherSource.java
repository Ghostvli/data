package okio;

import defpackage.e04;
import defpackage.eb3;
import defpackage.zt;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class CipherSource implements Source {
    private final int blockSize;
    private final Buffer buffer;
    private final Cipher cipher;
    private boolean closed;

    /* JADX INFO: renamed from: final, reason: not valid java name */
    private boolean f0final;
    private final BufferedSource source;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CipherSource(BufferedSource bufferedSource, Cipher cipher) {
        bufferedSource.getClass();
        cipher.getClass();
        this.source = bufferedSource;
        this.cipher = cipher;
        int blockSize = cipher.getBlockSize();
        this.blockSize = blockSize;
        this.buffer = new Buffer();
        if (blockSize > 0) {
            return;
        }
        zt.a("Block cipher required ", cipher);
        throw null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final void doFinal() throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        int outputSize = this.cipher.getOutputSize(0);
        if (outputSize == 0) {
            return;
        }
        Segment segmentWritableSegment$okio = this.buffer.writableSegment$okio(outputSize);
        int iDoFinal = this.cipher.doFinal(segmentWritableSegment$okio.data, segmentWritableSegment$okio.pos);
        segmentWritableSegment$okio.limit += iDoFinal;
        Buffer buffer = this.buffer;
        buffer.setSize$okio(buffer.size() + ((long) iDoFinal));
        if (segmentWritableSegment$okio.pos == segmentWritableSegment$okio.limit) {
            this.buffer.head = segmentWritableSegment$okio.pop();
            SegmentPool.recycle(segmentWritableSegment$okio);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final void refill() throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        while (this.buffer.size() == 0 && !this.f0final) {
            if (this.source.exhausted()) {
                this.f0final = true;
                doFinal();
                return;
            }
            update();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final void update() throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        Segment segment = this.source.getBuffer().head;
        segment.getClass();
        int i = segment.limit - segment.pos;
        int outputSize = this.cipher.getOutputSize(i);
        int i2 = i;
        while (outputSize > 8192) {
            int i3 = this.blockSize;
            if (i2 <= i3) {
                this.f0final = true;
                Buffer buffer = this.buffer;
                byte[] bArrDoFinal = this.cipher.doFinal(this.source.readByteArray());
                bArrDoFinal.getClass();
                buffer.write(bArrDoFinal);
                return;
            }
            i2 -= i3;
            outputSize = this.cipher.getOutputSize(i2);
        }
        Segment segmentWritableSegment$okio = this.buffer.writableSegment$okio(outputSize);
        int iUpdate = this.cipher.update(segment.data, segment.pos, i2, segmentWritableSegment$okio.data, segmentWritableSegment$okio.pos);
        this.source.skip(i2);
        segmentWritableSegment$okio.limit += iUpdate;
        Buffer buffer2 = this.buffer;
        buffer2.setSize$okio(buffer2.size() + ((long) iUpdate));
        if (segmentWritableSegment$okio.pos == segmentWritableSegment$okio.limit) {
            this.buffer.head = segmentWritableSegment$okio.pop();
            SegmentPool.recycle(segmentWritableSegment$okio);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.closed = true;
        this.source.close();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Cipher getCipher() {
        return this.cipher;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okio.Source
    public long read(Buffer buffer, long j) throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        buffer.getClass();
        if (j < 0) {
            eb3.a("byteCount < 0: ", j);
            return 0L;
        }
        if (this.closed) {
            e04.a("closed");
            return 0L;
        }
        if (j == 0) {
            return 0L;
        }
        refill();
        return this.buffer.read(buffer, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okio.Source
    public Timeout timeout() {
        return this.source.timeout();
    }
}
