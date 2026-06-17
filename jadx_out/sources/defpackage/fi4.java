package defpackage;

import defpackage.ki4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class fi4 implements hz0 {
    public final ki4 a;
    public final t41 c;
    public final List d;
    public gr4 g;
    public int h;
    public int i;
    public long[] j;
    public long k;
    public final s50 b = new s50();
    public byte[] f = fy4.f;
    public final r73 e = new r73();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b implements Comparable {
        public final long f;
        public final byte[] g;

        public b(long j, byte[] bArr) {
            this.f = j;
            this.g = bArr;
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            return Long.compare(this.f, bVar.f);
        }
    }

    public fi4(ki4 ki4Var, t41 t41Var) {
        this.a = ki4Var;
        this.c = t41Var != null ? t41Var.b().A0("application/x-media3-cues").V(t41Var.p).Z(ki4Var.c()).Q() : null;
        this.d = new ArrayList();
        this.i = 0;
        this.j = fy4.g;
        this.k = -9223372036854775807L;
    }

    public static /* synthetic */ void g(fi4 fi4Var, y50 y50Var) {
        fi4Var.getClass();
        b bVar = new b(y50Var.b, fi4Var.b.a(y50Var.a, y50Var.c));
        fi4Var.d.add(bVar);
        long j = fi4Var.k;
        if (j == -9223372036854775807L || y50Var.d >= j) {
            fi4Var.l(bVar);
        }
    }

    @Override // defpackage.hz0
    public void a(long j, long j2) {
        int i = this.i;
        gg3.v((i == 0 || i == 5) ? false : true);
        this.k = j2;
        if (this.i == 2) {
            this.i = 1;
        }
        if (this.i == 4) {
            this.i = 3;
        }
    }

    @Override // defpackage.hz0
    public void b(mz0 mz0Var) {
        gg3.v(this.i == 0);
        gr4 gr4VarE = mz0Var.e(0, 3);
        this.g = gr4VarE;
        t41 t41Var = this.c;
        if (t41Var != null) {
            gr4VarE.g(t41Var);
            mz0Var.o();
            mz0Var.u(new mj1(new long[]{0}, new long[]{0}, -9223372036854775807L));
        }
        this.i = 1;
    }

    @Override // defpackage.hz0
    public int d(jz0 jz0Var, yf3 yf3Var) throws r83 {
        int i = this.i;
        gg3.v((i == 0 || i == 5) ? false : true);
        if (this.i == 1) {
            int iE = jz0Var.getLength() != -1 ? ll1.e(jz0Var.getLength()) : 1024;
            if (iE > this.f.length) {
                this.f = new byte[iE];
            }
            this.h = 0;
            this.i = 2;
        }
        if (this.i == 2 && i(jz0Var)) {
            h();
            this.i = 4;
        }
        if (this.i == 3 && j(jz0Var)) {
            k();
            this.i = 4;
        }
        return this.i == 4 ? -1 : 0;
    }

    @Override // defpackage.hz0
    public boolean e(jz0 jz0Var) {
        return true;
    }

    public final void h() throws r83 {
        try {
            long j = this.k;
            this.a.b(this.f, 0, this.h, j != -9223372036854775807L ? ki4.b.c(j) : ki4.b.b(), new g20() { // from class: ei4
                @Override // defpackage.g20
                public final void accept(Object obj) {
                    fi4.g(this.a, (y50) obj);
                }
            });
            Collections.sort(this.d);
            this.j = new long[this.d.size()];
            for (int i = 0; i < this.d.size(); i++) {
                this.j[i] = ((b) this.d.get(i)).f;
            }
            this.f = fy4.f;
        } catch (RuntimeException e) {
            throw r83.a("SubtitleParser failed.", e);
        }
    }

    public final boolean i(jz0 jz0Var) {
        byte[] bArr = this.f;
        if (bArr.length == this.h) {
            this.f = Arrays.copyOf(bArr, bArr.length + 1024);
        }
        byte[] bArr2 = this.f;
        int i = this.h;
        int i2 = jz0Var.read(bArr2, i, bArr2.length - i);
        if (i2 != -1) {
            this.h += i2;
        }
        long length = jz0Var.getLength();
        return (length != -1 && ((long) this.h) == length) || i2 == -1;
    }

    public final boolean j(jz0 jz0Var) {
        return jz0Var.b((jz0Var.getLength() > (-1L) ? 1 : (jz0Var.getLength() == (-1L) ? 0 : -1)) != 0 ? ll1.e(jz0Var.getLength()) : 1024) == -1;
    }

    public final void k() {
        long j = this.k;
        for (int iK = j == -9223372036854775807L ? 0 : fy4.k(this.j, j, true, true); iK < this.d.size(); iK++) {
            l((b) this.d.get(iK));
        }
    }

    public final void l(b bVar) {
        gg3.q(this.g);
        int length = bVar.g.length;
        this.e.c0(bVar.g);
        this.g.a(this.e, length);
        this.g.b(bVar.f, 1, length, 0, null);
    }

    @Override // defpackage.hz0
    public void release() {
        if (this.i == 5) {
            return;
        }
        this.a.reset();
        this.i = 5;
    }
}
