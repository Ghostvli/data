package defpackage;

import defpackage.ef4;
import defpackage.t41;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class v63 extends ef4 {
    public static final byte[] o = {79, 112, 117, 115, 72, 101, 97, 100};
    public static final byte[] p = {79, 112, 117, 115, 84, 97, 103, 115};
    public boolean n;

    public static boolean n(r73 r73Var, byte[] bArr) {
        if (r73Var.a() < bArr.length) {
            return false;
        }
        int iG = r73Var.g();
        byte[] bArr2 = new byte[bArr.length];
        r73Var.u(bArr2, 0, bArr.length);
        r73Var.f0(iG);
        return Arrays.equals(bArr2, bArr);
    }

    public static boolean o(r73 r73Var) {
        return n(r73Var, o);
    }

    @Override // defpackage.ef4
    public long f(r73 r73Var) {
        return c(w63.e(r73Var.f()));
    }

    @Override // defpackage.ef4
    public boolean i(r73 r73Var, long j, ef4.b bVar) {
        if (n(r73Var, o)) {
            byte[] bArrCopyOf = Arrays.copyOf(r73Var.f(), r73Var.j());
            int iC = w63.c(bArrCopyOf);
            List listA = w63.a(bArrCopyOf);
            if (bVar.a != null) {
                return true;
            }
            bVar.a = new t41.b().X("audio/ogg").A0("audio/opus").U(iC).B0(48000).l0(listA).Q();
            return true;
        }
        byte[] bArr = p;
        if (!n(r73Var, bArr)) {
            gg3.q(bVar.a);
            return false;
        }
        gg3.q(bVar.a);
        if (this.n) {
            return true;
        }
        this.n = true;
        r73Var.g0(bArr.length);
        xs2 xs2VarD = d85.d(xi1.q(d85.k(r73Var, false, false).b));
        if (xs2VarD == null) {
            return true;
        }
        bVar.a = bVar.a.b().s0(xs2VarD.b(bVar.a.l)).Q();
        return true;
    }

    @Override // defpackage.ef4
    public void l(boolean z) {
        super.l(z);
        if (z) {
            this.n = false;
        }
    }
}
