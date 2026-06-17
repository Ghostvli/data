package defpackage;

import android.graphics.Bitmap;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.ki4;
import defpackage.p50;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class xa3 implements ki4 {
    public final r73 a = new r73();
    public final r73 b = new r73();
    public final a c = new a();
    public Inflater d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final r73 a = new r73();
        public final int[] b = new int[Buffer.DEFAULT_SIZE];
        public boolean c;
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;
        public int i;

        public p50 d() {
            int i;
            if (this.d == 0 || this.e == 0 || this.h == 0 || this.i == 0 || this.a.j() == 0 || this.a.g() != this.a.j() || !this.c) {
                return null;
            }
            this.a.f0(0);
            int i2 = this.h * this.i;
            int[] iArr = new int[i2];
            int i3 = 0;
            while (i3 < i2) {
                int iQ = this.a.Q();
                if (iQ != 0) {
                    i = i3 + 1;
                    iArr[i3] = this.b[iQ];
                } else {
                    int iQ2 = this.a.Q();
                    if (iQ2 != 0) {
                        int iQ3 = (iQ2 & 64) == 0 ? iQ2 & 63 : ((iQ2 & 63) << 8) | this.a.Q();
                        int i4 = iQ2 & 128;
                        int[] iArr2 = this.b;
                        i = iQ3 + i3;
                        Arrays.fill(iArr, i3, i, i4 == 0 ? iArr2[0] : iArr2[this.a.Q()]);
                    }
                }
                i3 = i;
            }
            return new p50.b().f(Bitmap.createBitmap(iArr, this.h, this.i, Bitmap.Config.ARGB_8888)).k(this.f / this.d).l(0).h(this.g / this.e, 0).i(0).n(this.h / this.d).g(this.i / this.e).a();
        }

        public final void e(r73 r73Var, int i) {
            int iT;
            if (i < 4) {
                return;
            }
            r73Var.g0(3);
            int i2 = i - 4;
            if ((r73Var.Q() & 128) != 0) {
                if (i2 < 7 || (iT = r73Var.T()) < 4) {
                    return;
                }
                this.h = r73Var.Y();
                this.i = r73Var.Y();
                this.a.b0(iT - 4);
                i2 = i - 11;
            }
            int iG = this.a.g();
            int iJ = this.a.j();
            if (iG >= iJ || i2 <= 0) {
                return;
            }
            int iMin = Math.min(i2, iJ - iG);
            r73Var.u(this.a.f(), iG, iMin);
            this.a.f0(iG + iMin);
        }

        public final void f(r73 r73Var, int i) {
            if (i < 19) {
                return;
            }
            this.d = r73Var.Y();
            this.e = r73Var.Y();
            r73Var.g0(11);
            this.f = r73Var.Y();
            this.g = r73Var.Y();
        }

        public final void g(r73 r73Var, int i) {
            if (i % 5 != 2) {
                return;
            }
            r73Var.g0(2);
            Arrays.fill(this.b, 0);
            int i2 = i / 5;
            for (int i3 = 0; i3 < i2; i3++) {
                int iQ = r73Var.Q();
                int iQ2 = r73Var.Q();
                int iQ3 = r73Var.Q();
                int iQ4 = r73Var.Q();
                double d = iQ2;
                double d2 = iQ3 - 128;
                double d3 = iQ4 - 128;
                this.b[iQ] = (fy4.s((int) ((d - (0.34414d * d3)) - (d2 * 0.71414d)), 0, 255) << 8) | (r73Var.Q() << 24) | (fy4.s((int) ((1.402d * d2) + d), 0, 255) << 16) | fy4.s((int) (d + (d3 * 1.772d)), 0, 255);
            }
            this.c = true;
        }

        public void h() {
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.a.b0(0);
            this.c = false;
        }
    }

    public static p50 d(r73 r73Var, a aVar) {
        int iJ = r73Var.j();
        int iQ = r73Var.Q();
        int iY = r73Var.Y();
        int iG = r73Var.g() + iY;
        p50 p50VarD = null;
        if (iG > iJ) {
            r73Var.f0(iJ);
            return null;
        }
        if (iQ != 128) {
            switch (iQ) {
                case 20:
                    aVar.g(r73Var, iY);
                    break;
                case 21:
                    aVar.e(r73Var, iY);
                    break;
                case 22:
                    aVar.f(r73Var, iY);
                    break;
            }
        } else {
            p50VarD = aVar.d();
            aVar.h();
        }
        r73Var.f0(iG);
        return p50VarD;
    }

    @Override // defpackage.ki4
    public void b(byte[] bArr, int i, int i2, ki4.b bVar, g20 g20Var) {
        this.a.d0(bArr, i2 + i);
        this.a.f0(i);
        if (this.d == null) {
            this.d = new Inflater();
        }
        if (fy4.Z0(this.a, this.b, this.d)) {
            this.a.d0(this.b.f(), this.b.j());
        }
        this.c.h();
        ArrayList arrayList = new ArrayList();
        while (this.a.a() >= 3) {
            p50 p50VarD = d(this.a, this.c);
            if (p50VarD != null) {
                arrayList.add(p50VarD);
            }
        }
        g20Var.accept(new y50(arrayList, -9223372036854775807L, -9223372036854775807L));
    }

    @Override // defpackage.ki4
    public int c() {
        return 2;
    }
}
