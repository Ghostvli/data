package defpackage;

import android.util.SparseArray;
import defpackage.gr4;
import defpackage.ki4;
import defpackage.nm;
import defpackage.qt;
import defpackage.t41;
import java.util.List;
import java.util.Objects;
import org.jupnp.support.model.dlna.DLNAProfiles;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class nm implements mz0, qt {
    public static final c p = new c();
    public static final yf3 q = new yf3();
    public final hz0 f;
    public final int g;
    public final t41 h;
    public final SparseArray i;
    public final d j;
    public boolean k;
    public qt.b l;
    public long m;
    public yz3 n;
    public t41[] o;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements gr4 {
        public final int a;
        public final int b;
        public final t41 c;
        public final wl0 d;
        public final d e;
        public t41 f;
        public gr4 g;
        public long h;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(int i, int i2, t41 t41Var, d dVar) {
            this.a = i;
            this.b = i2;
            this.c = t41Var;
            this.d = new wl0();
            this.e = dVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.gr4
        public void b(long j, int i, int i2, int i3, gr4.a aVar) {
            long j2 = this.h;
            if (j2 != -9223372036854775807L && j >= j2) {
                this.g = this.d;
            }
            ((gr4) fy4.l(this.g)).b(j, i, i2, i3, aVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.gr4
        public void c(r73 r73Var, int i, int i2) {
            ((gr4) fy4.l(this.g)).a(r73Var, i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.gr4
        public int f(x90 x90Var, int i, boolean z, int i2) {
            return ((gr4) fy4.l(this.g)).d(x90Var, i, z);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.gr4
        public void g(t41 t41Var) {
            this.f = this.e.b(t41Var, this.c);
            ((gr4) fy4.l(this.g)).g(this.f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void h(qt.b bVar, long j) {
            if (bVar == null) {
                this.g = this.d;
                return;
            }
            this.h = j;
            gr4 gr4VarE = bVar.e(this.a, this.b);
            this.g = gr4VarE;
            t41 t41Var = this.f;
            if (t41Var != null) {
                gr4VarE.g(t41Var);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c implements qt.a {
        public boolean b;
        public ki4.a a = new qh0();
        public int c = 3;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // qt.a
        public t41 d(t41 t41Var) {
            String str;
            if (!this.b || !this.a.a(t41Var)) {
                return t41Var;
            }
            t41.b bVarZ = t41Var.b().A0("application/x-media3-cues").Z(this.a.c(t41Var));
            StringBuilder sb = new StringBuilder();
            sb.append(t41Var.p);
            if (t41Var.k != null) {
                str = " " + t41Var.k;
            } else {
                str = "";
            }
            sb.append(str);
            return bVarZ.V(sb.toString()).E0(Long.MAX_VALUE).Q();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // qt.a
        public qt e(int i, t41 t41Var, boolean z, List list, gr4 gr4Var, ie3 ie3Var) {
            hz0 q71Var;
            String str = t41Var.o;
            if (!nt2.s(str)) {
                if (nt2.r(str)) {
                    q71Var = new u62(this.a, this.b ? 1 : 3);
                } else if (Objects.equals(str, DLNAProfiles.DLNAMimeTypes.MIME_IMAGE_JPEG)) {
                    q71Var = new xn1(1);
                } else if (Objects.equals(str, DLNAProfiles.DLNAMimeTypes.MIME_IMAGE_PNG)) {
                    q71Var = new cf3();
                } else {
                    int i2 = z ? 4 : 0;
                    if (!this.b) {
                        i2 |= 32;
                    }
                    q71Var = new q71(this.a, i2 | q71.k(this.c), null, null, list, gr4Var);
                }
            } else {
                if (!this.b) {
                    return null;
                }
                q71Var = new fi4(this.a.b(t41Var), t41Var);
            }
            return new nm(q71Var, i, t41Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: b(Z)Lqt$a; */
        @Override // qt.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public c b(boolean z) {
            this.b = z;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: c(I)Lqt$a; */
        @Override // qt.a
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public c c(int i) {
            this.c = i;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Lki4$a;)Lqt$a; */
        @Override // qt.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public c a(ki4.a aVar) {
            this.a = (ki4.a) gg3.q(aVar);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
        public static final d a = new d() { // from class: om
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // nm.d
            public final t41 b(t41 t41Var, t41 t41Var2) {
                return nm.d.a(t41Var, t41Var2);
            }
        };

        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: ?: TERNARY null = ((r1v0 t41) != (null t41)) ? (wrap:t41:0x0002: INVOKE (r0v0 t41), (r1v0 t41) VIRTUAL call: t41.m(t41):t41 A[MD:(t41):t41 (m), WRAPPED] (LINE:3)) : (r0v0 t41) */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static /* synthetic */ t41 a(t41 t41Var, t41 t41Var2) {
            return t41Var2 != null ? t41Var.m(t41Var2) : t41Var;
        }

        t41 b(t41 t41Var, t41 t41Var2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public nm(hz0 hz0Var, int i, t41 t41Var, d dVar) {
        this.f = hz0Var;
        this.g = i;
        this.h = t41Var;
        this.i = new SparseArray();
        this.j = dVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qt
    public boolean a(jz0 jz0Var) {
        int iD = this.f.d(jz0Var, q);
        gg3.v(iD != 1);
        return iD == 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qt
    public st b() {
        yz3 yz3Var = this.n;
        if (yz3Var instanceof st) {
            return (st) yz3Var;
        }
        if (yz3Var instanceof ut) {
            return ((ut) yz3Var).b();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qt
    public void c(qt.b bVar, long j, long j2) {
        this.l = bVar;
        this.m = j2;
        boolean z = this.k;
        hz0 hz0Var = this.f;
        if (!z) {
            hz0Var.b(this);
            if (j != -9223372036854775807L) {
                this.f.a(0L, j);
            }
            this.k = true;
            return;
        }
        if (j == -9223372036854775807L) {
            j = 0;
        }
        hz0Var.a(0L, j);
        for (int i = 0; i < this.i.size(); i++) {
            ((b) this.i.valueAt(i)).h(bVar, j2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qt
    public t41[] d() {
        return this.o;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mz0
    public gr4 e(int i, int i2) {
        b bVar = (b) this.i.get(i);
        if (bVar != null) {
            return bVar;
        }
        gg3.v(this.o == null);
        b bVar2 = new b(i, i2, i2 == this.g ? this.h : null, this.j);
        bVar2.h(this.l, this.m);
        this.i.put(i, bVar2);
        return bVar2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mz0
    public void o() {
        t41[] t41VarArr = new t41[this.i.size()];
        for (int i = 0; i < this.i.size(); i++) {
            t41VarArr[i] = (t41) gg3.q(((b) this.i.valueAt(i)).f);
        }
        this.o = t41VarArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.qt
    public void release() {
        this.f.release();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.mz0
    public void u(yz3 yz3Var) {
        this.n = yz3Var;
    }

    public nm(hz0 hz0Var, int i, t41 t41Var) {
        this(hz0Var, i, t41Var, d.a);
    }
}
