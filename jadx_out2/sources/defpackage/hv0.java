package defpackage;

import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class hv0 implements gx3 {
    public final t41 f;
    public long[] h;
    public boolean i;
    public iv0 j;
    public boolean k;
    public int l;
    public final fv0 g = new fv0();
    public long m = -9223372036854775807L;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public hv0(iv0 iv0Var, t41 t41Var, boolean z) {
        this.f = t41Var;
        this.j = iv0Var;
        this.h = iv0Var.b;
        d(iv0Var, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gx3
    public void a() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String b() {
        return this.j.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c(long j) {
        int iG = fy4.g(this.h, j, true, false);
        this.l = iG;
        if (!this.i || iG != this.h.length) {
            j = -9223372036854775807L;
        }
        this.m = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d(iv0 iv0Var, boolean z) {
        int i = this.l;
        long j = i == 0 ? -9223372036854775807L : this.h[i - 1];
        this.i = z;
        this.j = iv0Var;
        long[] jArr = iv0Var.b;
        this.h = jArr;
        long j2 = this.m;
        if (j2 != -9223372036854775807L) {
            c(j2);
        } else if (j != -9223372036854775807L) {
            this.l = fy4.g(jArr, j, false, false);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gx3
    public int e(long j) {
        int iMax = Math.max(this.l, fy4.g(this.h, j, true, false));
        int i = iMax - this.l;
        this.l = iMax;
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gx3
    public boolean isReady() {
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gx3
    public int o(u41 u41Var, DecoderInputBuffer decoderInputBuffer, int i) {
        int i2 = this.l;
        boolean z = i2 == this.h.length;
        if (z && !this.i) {
            decoderInputBuffer.setFlags(4);
            return -4;
        }
        if ((i & 2) != 0 || !this.k) {
            u41Var.b = this.f;
            this.k = true;
            return -5;
        }
        if (z) {
            return -3;
        }
        if ((i & 1) == 0) {
            this.l = i2 + 1;
        }
        if ((i & 4) == 0) {
            byte[] bArrA = this.g.a(this.j.a[i2]);
            decoderInputBuffer.ensureSpaceForWrite(bArrA.length);
            decoderInputBuffer.data.put(bArrA);
        }
        decoderInputBuffer.timeUs = this.h[i2];
        decoderInputBuffer.setFlags(1);
        return -4;
    }
}
