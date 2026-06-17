package defpackage;

import defpackage.pe0;
import java.math.RoundingMode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class qe0 implements pe0.d {
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public int a = 250000;
        public int b = 750000;
        public int c = 4;
        public int d = 250000;
        public int e = 50000000;
        public int f = 2;
        public int g = 4;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public qe0 h() {
            return new qe0(this);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public qe0(a aVar) {
        this.b = aVar.a;
        this.c = aVar.b;
        this.d = aVar.c;
        this.e = aVar.d;
        this.f = aVar.e;
        this.g = aVar.f;
        this.h = aVar.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int b(int i, int i2, int i3) {
        return ll1.e(((((long) i) * ((long) i2)) * ((long) i3)) / 1000000);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int d(int i) {
        int iB = nz0.b(i);
        gg3.v(iB != -2147483647);
        return iB;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // pe0.d
    public int a(int i, int i2, int i3, int i4, int i5, int i6, double d) {
        return (((Math.max(i, (int) (((double) c(i, i2, i3, i4, i5, i6)) * d)) + i4) - 1) / i4) * i4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int c(int i, int i2, int i3, int i4, int i5, int i6) {
        if (i3 == 0) {
            return g(i, i5, i4);
        }
        if (i3 == 1) {
            return e(i2);
        }
        if (i3 == 2) {
            return f(i2, i6);
        }
        d04.a();
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int e(int i) {
        return ll1.e((((long) this.f) * ((long) d(i))) / 1000000);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int f(int i, int i2) {
        int i3;
        int i4 = this.e;
        if (i != 5) {
            if (i == 8) {
                i3 = this.h;
            }
            return ll1.e((((long) i4) * ((long) (i2 == -1 ? pk1.b(i2, 8, RoundingMode.CEILING) : d(i)))) / 1000000);
        }
        i3 = this.g;
        i4 *= i3;
        return ll1.e((((long) i4) * ((long) (i2 == -1 ? pk1.b(i2, 8, RoundingMode.CEILING) : d(i)))) / 1000000);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int g(int i, int i2, int i3) {
        return fy4.s(i * this.d, b(this.b, i2, i3), b(this.c, i2, i3));
    }
}
