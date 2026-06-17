package defpackage;

import androidx.media3.decoder.DecoderInputBuffer;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class kj extends DecoderInputBuffer {
    public long f;
    public int g;
    public int h;

    public kj() {
        super(2);
        this.h = 32;
    }

    @Override // androidx.media3.decoder.DecoderInputBuffer, defpackage.ol
    public void clear() {
        super.clear();
        this.g = 0;
    }

    public boolean g(DecoderInputBuffer decoderInputBuffer) {
        gg3.d(!decoderInputBuffer.isEncrypted());
        gg3.d(!decoderInputBuffer.hasSupplementalData());
        gg3.d(!decoderInputBuffer.isEndOfStream());
        if (!h(decoderInputBuffer)) {
            return false;
        }
        int i = this.g;
        this.g = i + 1;
        if (i == 0) {
            this.timeUs = decoderInputBuffer.timeUs;
            if (decoderInputBuffer.isKeyFrame()) {
                setFlags(1);
            }
        }
        ByteBuffer byteBuffer = decoderInputBuffer.data;
        if (byteBuffer != null) {
            ensureSpaceForWrite(byteBuffer.remaining());
            this.data.put(byteBuffer);
        }
        this.f = decoderInputBuffer.timeUs;
        return true;
    }

    public final boolean h(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        if (!l()) {
            return true;
        }
        if (this.g >= this.h) {
            return false;
        }
        ByteBuffer byteBuffer2 = decoderInputBuffer.data;
        return byteBuffer2 == null || (byteBuffer = this.data) == null || byteBuffer.position() + byteBuffer2.remaining() <= 3072000;
    }

    public long i() {
        return this.timeUs;
    }

    public long j() {
        return this.f;
    }

    public int k() {
        return this.g;
    }

    public boolean l() {
        return this.g > 0;
    }

    public void m(int i) {
        gg3.d(i > 0);
        this.h = i;
    }
}
