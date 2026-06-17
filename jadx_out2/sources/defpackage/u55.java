package defpackage;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.hierynomus.msdtyp.FileTime;
import defpackage.ki4;
import defpackage.p50;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.zip.Inflater;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class u55 implements ki4 {
    public static final y50 e = new y50(xi1.u(), -9223372036854775807L, -9223372036854775807L);
    public final r73 a = new r73();
    public final r73 b = new r73();
    public final b c;
    public Inflater d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public boolean d;
        public boolean e;
        public int[] f;
        public int g;
        public int h;
        public Rect i;
        public long b = -9223372036854775807L;
        public long c = -9223372036854775807L;
        public final int[] a = new int[4];
        public int j = -1;
        public int k = -1;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a {
            public int a;
            public int b;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a() {
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static int e(int[] iArr, int i) {
            return (i < 0 || i >= iArr.length) ? iArr[0] : iArr[i];
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static int f(String str) {
            try {
                return Integer.parseInt(str, 16);
            } catch (RuntimeException e) {
                xz1.j("VobsubParser", "Parsing color failed", e);
                return 0;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void o(q73 q73Var, int i, a aVar) {
            int iH = 0;
            for (int i2 = 1; iH < i2 && i2 <= 64; i2 <<= 2) {
                if (q73Var.b() < 4) {
                    aVar.a = -1;
                    aVar.b = 0;
                    return;
                }
                iH = (iH << 4) | q73Var.h(4);
            }
            aVar.a = iH & 3;
            if (iH >= 4) {
                i = iH >> 2;
            }
            aVar.b = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static int r(int i, int i2) {
            return (i & 16777215) | ((i2 * 17) << 24);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public p50 d(r73 r73Var) {
            Rect rect;
            if (this.f == null || !this.d || !this.e || (rect = this.i) == null || this.j == -1 || this.k == -1 || rect.width() < 2 || this.i.height() < 2) {
                return null;
            }
            Rect rect2 = this.i;
            int[] iArr = new int[rect2.width() * rect2.height()];
            q73 q73Var = new q73();
            r73Var.f0(this.j);
            q73Var.m(r73Var);
            n(q73Var, true, rect2, iArr);
            r73Var.f0(this.k);
            q73Var.m(r73Var);
            n(q73Var, false, rect2, iArr);
            return new p50.b().f(Bitmap.createBitmap(iArr, rect2.width(), rect2.height(), Bitmap.Config.ARGB_8888)).k(rect2.left / this.g).l(0).h(rect2.top / this.h, 0).i(0).n(rect2.width() / this.g).g(rect2.height() / this.h).a();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean g(long j, r73 r73Var) {
            int iQ = r73Var.Q();
            if (iQ == 255) {
                return false;
            }
            switch (iQ) {
                case 1:
                    this.b = j;
                case 0:
                    return true;
                case 2:
                    this.c = j;
                    return true;
                case 3:
                    return j(r73Var);
                case 4:
                    return h(r73Var);
                case 5:
                    return i(r73Var);
                case 6:
                    return k(r73Var);
                default:
                    xz1.i("VobsubParser", "Unrecognized command: " + iQ);
                    return false;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean h(r73 r73Var) {
            if (r73Var.a() < 2) {
                xz1.i("VobsubParser", "Incomplete alpha command");
                return false;
            }
            if (!this.e) {
                xz1.i("VobsubParser", "Ignoring alpha command before color command");
                return false;
            }
            int iQ = r73Var.Q();
            int iQ2 = r73Var.Q();
            int[] iArr = this.a;
            iArr[3] = r(iArr[3], iQ >> 4);
            int[] iArr2 = this.a;
            iArr2[2] = r(iArr2[2], iQ & 15);
            int[] iArr3 = this.a;
            iArr3[1] = r(iArr3[1], iQ2 >> 4);
            int[] iArr4 = this.a;
            iArr4[0] = r(iArr4[0], iQ2 & 15);
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean i(r73 r73Var) {
            if (r73Var.a() < 6) {
                xz1.i("VobsubParser", "Incomplete area command");
                return false;
            }
            int iQ = r73Var.Q();
            int iQ2 = r73Var.Q();
            int i = (iQ << 4) | (iQ2 >> 4);
            int iQ3 = ((iQ2 & 15) << 8) | r73Var.Q();
            int iQ4 = r73Var.Q();
            int iQ5 = r73Var.Q();
            this.i = new Rect(i, (iQ4 << 4) | (iQ5 >> 4), iQ3 + 1, (r73Var.Q() | ((iQ5 & 15) << 8)) + 1);
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean j(r73 r73Var) {
            if (r73Var.a() < 2) {
                xz1.i("VobsubParser", "Incomplete color command");
                return false;
            }
            int iQ = r73Var.Q();
            int iQ2 = r73Var.Q();
            this.a[3] = e(this.f, iQ >> 4);
            this.a[2] = e(this.f, iQ & 15);
            this.a[1] = e(this.f, iQ2 >> 4);
            this.a[0] = e(this.f, iQ2 & 15);
            this.e = true;
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean k(r73 r73Var) {
            if (r73Var.a() < 4) {
                xz1.i("VobsubParser", "Incomplete offsets command");
                return false;
            }
            this.j = r73Var.Y();
            this.k = r73Var.Y();
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean l(r73 r73Var, int i) {
            boolean z = false;
            if (r73Var.a() < 4) {
                return false;
            }
            int iG = r73Var.g();
            int iY = r73Var.Y() * FileTime.NANO100_TO_MILLI;
            int iY2 = i + r73Var.Y();
            boolean zG = true;
            if (iY2 != iG && iY2 < r73Var.j()) {
                z = true;
            }
            int iJ = z ? iY2 : r73Var.j();
            while (r73Var.g() < iJ && zG) {
                zG = g(iY, r73Var);
            }
            if (z) {
                r73Var.f0(iY2);
            }
            return z;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void m(String str) {
            for (String str2 : fy4.G1(str.trim(), "\\r?\\n")) {
                if (str2.startsWith("palette: ")) {
                    String[] strArrG1 = fy4.G1(str2.substring(9), ",");
                    this.f = new int[strArrG1.length];
                    for (int i = 0; i < strArrG1.length; i++) {
                        this.f[i] = f(strArrG1[i].trim());
                    }
                } else if (str2.startsWith("size: ")) {
                    String[] strArrG12 = fy4.G1(str2.substring(6).trim(), "x");
                    if (strArrG12.length != 2) {
                        xz1.i("VobsubParser", "Ignoring malformed IDX size line: '" + str2 + "'");
                    } else {
                        try {
                            this.g = Integer.parseInt(strArrG12[0]);
                            this.h = Integer.parseInt(strArrG12[1]);
                            this.d = true;
                        } catch (RuntimeException e) {
                            xz1.j("VobsubParser", "Parsing IDX failed", e);
                        }
                    }
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void n(q73 q73Var, boolean z, Rect rect, int[] iArr) {
            int iWidth = rect.width();
            int iHeight = rect.height();
            int i = !z ? 1 : 0;
            int i2 = i * iWidth;
            a aVar = new a();
            while (true) {
                int i3 = 0;
                do {
                    o(q73Var, iWidth, aVar);
                    int iMin = Math.min(aVar.b, iWidth - i3);
                    if (iMin > 0) {
                        int i4 = i2 + iMin;
                        Arrays.fill(iArr, i2, i4, this.a[aVar.a]);
                        i3 += iMin;
                        i2 = i4;
                    }
                } while (i3 < iWidth);
                i += 2;
                if (i >= iHeight) {
                    return;
                }
                i2 = i * iWidth;
                q73Var.c();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void p(r73 r73Var) {
            if (this.f == null) {
                xz1.i("VobsubParser", "Skipping SPU (no palette)");
            } else {
                if (!this.d) {
                    xz1.i("VobsubParser", "Skipping SPU (no plane)");
                    return;
                }
                int iG = r73Var.g() - 2;
                r73Var.f0(r73Var.Y() + iG);
                while (l(r73Var, iG)) {
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void q() {
            this.b = -9223372036854775807L;
            this.c = -9223372036854775807L;
            this.e = false;
            this.i = null;
            this.j = -1;
            this.k = -1;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public u55(List list) {
        b bVar = new b();
        this.c = bVar;
        bVar.m(new String((byte[]) list.get(0), StandardCharsets.UTF_8));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ki4
    public void b(byte[] bArr, int i, int i2, ki4.b bVar, g20 g20Var) {
        this.a.d0(bArr, i2 + i);
        this.a.f0(i);
        g20Var.accept(d());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ki4
    public int c() {
        return 2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final y50 d() {
        if (this.d == null) {
            this.d = new Inflater();
        }
        if (fy4.Z0(this.a, this.b, this.d)) {
            this.a.d0(this.b.f(), this.b.j());
        }
        this.c.q();
        int iA = this.a.a();
        if (iA < 2 || this.a.Y() != iA) {
            return e;
        }
        this.c.p(this.a);
        p50 p50VarD = this.c.d(this.a);
        return new y50(p50VarD != null ? xi1.w(p50VarD) : xi1.u(), this.c.b, this.c.c != -9223372036854775807L ? (this.c.b == -9223372036854775807L || this.c.c <= this.c.b) ? this.c.c : this.c.c - this.c.b : -9223372036854775807L);
    }
}
