package defpackage;

import defpackage.xh1;
import java.io.EOFException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class zh1 {
    public final r73 a = new r73(10);

    public xs2 a(jz0 jz0Var, xh1.a aVar, int i) throws Throwable {
        xs2 xs2VarE = null;
        int i2 = 0;
        while (b(jz0Var, i)) {
            int iG = this.a.g();
            this.a.g0(6);
            int iP = this.a.P();
            int i3 = iP + 10;
            if (xs2VarE == null) {
                byte[] bArr = new byte[i3];
                System.arraycopy(this.a.f(), iG, bArr, 0, 10);
                jz0Var.s(bArr, 10, iP);
                xs2VarE = new xh1(aVar).e(bArr, i3);
            } else {
                jz0Var.m(iP);
            }
            i2 += i3;
        }
        jz0Var.p();
        jz0Var.m(i2);
        return xs2VarE;
    }

    public final boolean b(jz0 jz0Var, int i) {
        int i2 = 0;
        do {
            int i3 = i2 % 10;
            int i4 = i3 + 10;
            if (i3 == 0 && i2 != 0) {
                System.arraycopy(this.a.f(), 10, this.a.f(), 0, 9);
            }
            int i5 = i2 != 0 ? 1 : 10;
            try {
                jz0Var.s(this.a.f(), i4 - i5, i5);
                this.a.f0(i3);
                this.a.e0(i4);
                if (this.a.r() == 4801587) {
                    return true;
                }
                if (dv2.j(this.a.p()) != -1) {
                    return false;
                }
                if (i2 == 0) {
                    this.a.d(20);
                }
                i2++;
            } catch (EOFException unused) {
            }
        } while (i2 <= i);
        return false;
    }
}
