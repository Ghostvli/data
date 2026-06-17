package defpackage;

import okhttp3.internal.http2.Settings;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class cv3 {
    public static final byte[] l = new byte[0];
    public final byte a;
    public final boolean b;
    public final boolean c;
    public final byte d;
    public final boolean e;
    public final byte f;
    public final int g;
    public final long h;
    public final int i;
    public final byte[] j;
    public final byte[] k;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public boolean a;
        public boolean b;
        public byte c;
        public int d;
        public long e;
        public int f;
        public byte[] g = cv3.l;
        public byte[] h = cv3.l;

        public cv3 i() {
            return new cv3(this);
        }

        public b j(byte[] bArr) {
            gg3.q(bArr);
            this.g = bArr;
            return this;
        }

        public b k(boolean z) {
            this.b = z;
            return this;
        }

        public b l(boolean z) {
            this.a = z;
            return this;
        }

        public b m(byte[] bArr) {
            gg3.q(bArr);
            this.h = bArr;
            return this;
        }

        public b n(byte b) {
            this.c = b;
            return this;
        }

        public b o(int i) {
            gg3.d(i >= 0 && i <= 65535);
            this.d = i & Settings.DEFAULT_INITIAL_WINDOW_SIZE;
            return this;
        }

        public b p(int i) {
            this.f = i;
            return this;
        }

        public b q(long j) {
            this.e = j;
            return this;
        }
    }

    public cv3(b bVar) {
        this.a = (byte) 2;
        this.b = bVar.a;
        this.c = false;
        this.e = bVar.b;
        this.f = bVar.c;
        this.g = bVar.d;
        this.h = bVar.e;
        this.i = bVar.f;
        byte[] bArr = bVar.g;
        this.j = bArr;
        this.d = (byte) (bArr.length / 4);
        this.k = bVar.h;
    }

    public static int b(int i) {
        return pk1.f(i + 1, 65536);
    }

    public static int c(int i) {
        return pk1.f(i - 1, 65536);
    }

    public static cv3 d(r73 r73Var) {
        byte[] bArr;
        if (r73Var.a() < 12) {
            return null;
        }
        int iQ = r73Var.Q();
        byte b2 = (byte) (iQ >> 6);
        boolean z = ((iQ >> 5) & 1) == 1;
        byte b3 = (byte) (iQ & 15);
        boolean z2 = ((iQ >> 4) & 1) == 1;
        if (b2 != 2) {
            return null;
        }
        int iQ2 = r73Var.Q();
        boolean z3 = ((iQ2 >> 7) & 1) == 1;
        byte b4 = (byte) (iQ2 & 127);
        int iY = r73Var.Y();
        long jS = r73Var.S();
        int iZ = r73Var.z();
        if (b3 > 0) {
            bArr = new byte[b3 * 4];
            for (int i = 0; i < b3; i++) {
                r73Var.u(bArr, i * 4, 4);
            }
        } else {
            bArr = l;
        }
        if (z2) {
            r73Var.g0(2);
            short sM = r73Var.M();
            if (sM != 0) {
                r73Var.g0(sM * 4);
            }
        }
        byte[] bArr2 = new byte[r73Var.a()];
        r73Var.u(bArr2, 0, r73Var.a());
        return new b().l(z).k(z3).n(b4).o(iY).q(jS).p(iZ).j(bArr).m(bArr2).i();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && cv3.class == obj.getClass()) {
            cv3 cv3Var = (cv3) obj;
            if (this.f == cv3Var.f && this.g == cv3Var.g && this.e == cv3Var.e && this.h == cv3Var.h && this.i == cv3Var.i) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int i = (((((527 + this.f) * 31) + this.g) * 31) + (this.e ? 1 : 0)) * 31;
        long j = this.h;
        return ((i + ((int) (j ^ (j >>> 32)))) * 31) + this.i;
    }

    public String toString() {
        return fy4.M("RtpPacket(payloadType=%d, seq=%d, timestamp=%d, ssrc=%x, marker=%b)", Byte.valueOf(this.f), Integer.valueOf(this.g), Long.valueOf(this.h), Integer.valueOf(this.i), Boolean.valueOf(this.e));
    }
}
