package defpackage;

import defpackage.ki4;
import defpackage.t41;
import defpackage.yz3;
import java.util.Objects;
import org.jupnp.support.model.dlna.DLNAProfiles;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class yn1 implements hz0 {
    public mz0 b;
    public int c;
    public int d;
    public int e;
    public iu2 g;
    public jz0 h;
    public wd4 i;
    public yu2 j;
    public final r73 a = new r73(2);
    public long f = -1;

    private void g() {
        ((mz0) gg3.q(this.b)).o();
        this.b.u(new yz3.b(-9223372036854775807L));
        this.c = 6;
    }

    public static iu2 h(String str, long j) {
        gu2 gu2VarB;
        if (j == -1 || (gu2VarB = pa5.b(str)) == null) {
            return null;
        }
        return gu2VarB.a(j);
    }

    private void j(iu2 iu2Var) {
        ((mz0) gg3.q(this.b)).e(1024, 4).g(new t41.b().X(DLNAProfiles.DLNAMimeTypes.MIME_IMAGE_JPEG).s0(new xs2(iu2Var)).Q());
    }

    private void n(jz0 jz0Var) {
        String strK;
        if (this.d == 65505) {
            r73 r73Var = new r73(this.e);
            jz0Var.readFully(r73Var.f(), 0, this.e);
            if (this.g == null && "http://ns.adobe.com/xap/1.0/".equals(r73Var.K()) && (strK = r73Var.K()) != null) {
                iu2 iu2VarH = h(strK, jz0Var.getLength());
                this.g = iu2VarH;
                if (iu2VarH != null) {
                    this.f = iu2VarH.d;
                }
            }
        } else {
            jz0Var.q(this.e);
        }
        this.c = 0;
    }

    private void p(jz0 jz0Var) {
        if (!jz0Var.j(this.a.f(), 0, 1, true)) {
            g();
            return;
        }
        jz0Var.p();
        if (this.j == null) {
            this.j = new yu2(ki4.a.a, 8);
        }
        wd4 wd4Var = new wd4(jz0Var, this.f);
        this.i = wd4Var;
        if (!this.j.e(wd4Var)) {
            g();
        } else {
            this.j.b(new xd4(this.f, (mz0) gg3.q(this.b)));
            q();
        }
    }

    @Override // defpackage.hz0
    public void a(long j, long j2) {
        if (j == 0) {
            this.c = 0;
            this.j = null;
        } else if (this.c == 5) {
            ((yu2) gg3.q(this.j)).a(j, j2);
        }
    }

    @Override // defpackage.hz0
    public void b(mz0 mz0Var) {
        this.b = mz0Var;
    }

    @Override // defpackage.hz0
    public int d(jz0 jz0Var, yf3 yf3Var) {
        int i = this.c;
        if (i == 0) {
            m(jz0Var);
            return 0;
        }
        if (i == 1) {
            o(jz0Var);
            return 0;
        }
        if (i == 2) {
            n(jz0Var);
            return 0;
        }
        if (i == 4) {
            long position = jz0Var.getPosition();
            long j = this.f;
            if (position != j) {
                yf3Var.a = j;
                return 1;
            }
            p(jz0Var);
            return 0;
        }
        if (i != 5) {
            if (i == 6) {
                return -1;
            }
            z20.a();
            return 0;
        }
        if (this.i == null || jz0Var != this.h) {
            this.h = jz0Var;
            this.i = new wd4(jz0Var, this.f);
        }
        int iD = ((yu2) gg3.q(this.j)).d(this.i, yf3Var);
        if (iD == 1) {
            yf3Var.a += this.f;
        }
        return iD;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        return false;
     */
    @Override // defpackage.hz0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean e(defpackage.jz0 r5) {
        /*
            r4 = this;
            int r0 = r4.k(r5)
            r1 = 65496(0xffd8, float:9.178E-41)
            r2 = 0
            if (r0 == r1) goto Lb
            return r2
        Lb:
            int r0 = r4.k(r5)
            r4.d = r0
            r1 = 65498(0xffda, float:9.1782E-41)
            if (r0 != r1) goto L17
            goto L1d
        L17:
            int r0 = r4.l(r5)
            if (r0 >= 0) goto L1e
        L1d:
            return r2
        L1e:
            int r1 = r4.d
            r3 = 65505(0xffe1, float:9.1792E-41)
            if (r1 == r3) goto L29
            r5.m(r0)
            goto Lb
        L29:
            r73 r1 = r4.a
            r1.b0(r0)
            r73 r1 = r4.a
            byte[] r1 = r1.f()
            r5.s(r1, r2, r0)
            r73 r0 = r4.a
            boolean r0 = r4.i(r0)
            if (r0 == 0) goto Lb
            r4 = 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yn1.e(jz0):boolean");
    }

    public final boolean i(r73 r73Var) {
        if (Objects.equals(r73Var.K(), "http://ns.adobe.com/xap/1.0/")) {
            return pa5.a(r73Var.K());
        }
        return false;
    }

    public final int k(jz0 jz0Var) {
        this.a.b0(2);
        jz0Var.s(this.a.f(), 0, 2);
        return this.a.Y();
    }

    public final int l(jz0 jz0Var) {
        this.a.b0(2);
        jz0Var.s(this.a.f(), 0, 2);
        return this.a.Y() - 2;
    }

    public final void m(jz0 jz0Var) {
        this.a.b0(2);
        jz0Var.readFully(this.a.f(), 0, 2);
        int iY = this.a.Y();
        this.d = iY;
        if (iY == 65498) {
            if (this.f != -1) {
                this.c = 4;
                return;
            } else {
                g();
                return;
            }
        }
        if ((iY < 65488 || iY > 65497) && iY != 65281) {
            this.c = 1;
        }
    }

    public final void o(jz0 jz0Var) {
        this.e = l(jz0Var);
        jz0Var.q(2);
        this.c = 2;
    }

    public final void q() {
        j((iu2) gg3.q(this.g));
        this.c = 5;
    }

    @Override // defpackage.hz0
    public void release() {
        yu2 yu2Var = this.j;
        if (yu2Var != null) {
            yu2Var.release();
        }
    }
}
