package androidx.media3.exoplayer.smoothstreaming;

import android.net.Uri;
import android.os.SystemClock;
import androidx.media3.exoplayer.j;
import androidx.media3.exoplayer.smoothstreaming.b;
import defpackage.aa0;
import defpackage.bz1;
import defpackage.ev;
import defpackage.fd4;
import defpackage.fv;
import defpackage.gg3;
import defpackage.hi;
import defpackage.hs4;
import defpackage.iq4;
import defpackage.j20;
import defpackage.ja0;
import defpackage.jy0;
import defpackage.ki4;
import defpackage.nm;
import defpackage.oj;
import defpackage.pt;
import defpackage.q71;
import defpackage.qh0;
import defpackage.qt;
import defpackage.rt;
import defpackage.sy1;
import defpackage.t41;
import defpackage.v72;
import defpackage.w72;
import defpackage.xi1;
import defpackage.yq4;
import defpackage.zz3;
import java.io.IOException;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class a implements androidx.media3.exoplayer.smoothstreaming.b {
    public final bz1 a;
    public final int b;
    public final qt[] c;
    public final aa0 d;
    public jy0 e;
    public fd4 f;
    public int g;
    public IOException h;
    public long i = -9223372036854775807L;

    /* JADX INFO: renamed from: androidx.media3.exoplayer.smoothstreaming.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class C0025a implements b.a {
        public final aa0.a a;
        public ki4.a b = new qh0();
        public boolean c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public C0025a(aa0.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.exoplayer.smoothstreaming.b.a
        public androidx.media3.exoplayer.smoothstreaming.b c(bz1 bz1Var, fd4 fd4Var, int i, jy0 jy0Var, hs4 hs4Var, ev evVar) {
            aa0 aa0VarB = this.a.b();
            if (hs4Var != null) {
                aa0VarB.f(hs4Var);
            }
            return new a(bz1Var, fd4Var, i, jy0Var, aa0VarB, evVar, this.b, this.c);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.exoplayer.smoothstreaming.b.a
        public t41 d(t41 t41Var) {
            String str;
            if (!this.c || !this.b.a(t41Var)) {
                return t41Var;
            }
            t41.b bVarZ = t41Var.b().A0("application/x-media3-cues").Z(this.b.c(t41Var));
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
        /* JADX DEBUG: Method merged with bridge method: b(Z)Landroidx/media3/exoplayer/smoothstreaming/b$a; */
        @Override // androidx.media3.exoplayer.smoothstreaming.b.a
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public C0025a b(boolean z) {
            this.c = z;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Lki4$a;)Landroidx/media3/exoplayer/smoothstreaming/b$a; */
        @Override // androidx.media3.exoplayer.smoothstreaming.b.a
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public C0025a a(ki4.a aVar) {
            this.b = aVar;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends hi {
        public final fd4.b e;
        public final int f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(fd4.b bVar, int i, int i2) {
            super(i2, bVar.k - 1);
            this.e = bVar;
            this.f = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.w72
        public long a() {
            c();
            return this.e.e((int) d());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.w72
        public long b() {
            return a() + this.e.c((int) d());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public a(bz1 bz1Var, fd4 fd4Var, int i, jy0 jy0Var, aa0 aa0Var, ev evVar, ki4.a aVar, boolean z) {
        this.a = bz1Var;
        this.f = fd4Var;
        this.b = i;
        this.e = jy0Var;
        this.d = aa0Var;
        fd4.b bVar = fd4Var.f[i];
        this.c = new qt[jy0Var.length()];
        for (int i2 = 0; i2 < this.c.length; i2++) {
            int i3 = jy0Var.i(i2);
            t41 t41Var = bVar.j[i3];
            yq4[] yq4VarArr = t41Var.t != null ? ((fd4.a) gg3.q(fd4Var.e)).c : null;
            int i4 = bVar.a;
            int i5 = i4 == 2 ? 4 : 0;
            long j = bVar.c;
            long j2 = fd4Var.g;
            this.c[i2] = new nm(new q71(aVar, !z ? 35 : 3, null, new iq4(i3, i4, j, -9223372036854775807L, j2, j2, t41Var, 0, yq4VarArr, i5, null, null), xi1.u(), null), bVar.a, t41Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static v72 k(t41 t41Var, aa0 aa0Var, Uri uri, int i, long j, long j2, long j3, int i2, Object obj, qt qtVar, fv.a aVar) {
        return new j20(aa0Var, new ja0.b().i(uri).a(), t41Var, i2, obj, j, j2, j3, -9223372036854775807L, i, 1, j, qtVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xt
    public void a() throws IOException {
        IOException iOException = this.h;
        if (iOException != null) {
            throw iOException;
        }
        this.a.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.smoothstreaming.b
    public void b(jy0 jy0Var) {
        this.e = jy0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xt
    public long d(long j, zz3 zz3Var) {
        fd4.b bVar = this.f.f[this.b];
        int iD = bVar.d(j);
        long jE = bVar.e(iD);
        return zz3Var.a(j, jE, (jE >= j || iD >= bVar.k + (-1)) ? jE : bVar.e(iD + 1));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xt
    public void e(pt ptVar) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xt
    public boolean f(pt ptVar, boolean z, sy1.c cVar, sy1 sy1Var) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        int length = this.e.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.e.a(i2, jElapsedRealtime)) {
                i++;
            }
        }
        sy1.b bVarB = sy1Var.b(new sy1.a(1, 0, length, i), cVar);
        if (z && bVarB != null && bVarB.a == 2) {
            jy0 jy0Var = this.e;
            if (jy0Var.n(jy0Var.e(ptVar.d), bVarB.b)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xt
    public boolean g(long j, pt ptVar, List list) {
        if (this.h != null) {
            return false;
        }
        return this.e.f(j, ptVar, list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xt
    public int h(long j, List list) {
        return (this.h != null || this.e.length() < 2) ? list.size() : this.e.j(j, list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xt
    public final void i(j jVar, long j, List list, rt rtVar) {
        List list2;
        int iG;
        jy0 jy0Var;
        if (this.h != null) {
            return;
        }
        fd4.b bVar = this.f.f[this.b];
        if (bVar.k == 0) {
            rtVar.b = !r4.d;
            return;
        }
        if (list.isEmpty()) {
            iG = bVar.d(j);
            list2 = list;
        } else {
            list2 = list;
            iG = (int) (((v72) list2.get(list.size() - 1)).g() - ((long) this.g));
            if (iG < 0) {
                this.h = new oj();
                return;
            }
        }
        if (iG >= bVar.k) {
            rtVar.b = !this.f.d;
            return;
        }
        long j2 = jVar.a;
        long j3 = j - j2;
        long jL = l(j2);
        int length = this.e.length();
        w72[] w72VarArr = new w72[length];
        int i = 0;
        while (true) {
            jy0Var = this.e;
            if (i >= length) {
                break;
            }
            w72VarArr[i] = new b(bVar, jy0Var.i(i), iG);
            i++;
        }
        jy0Var.b(j2, j3, jL, list2, w72VarArr);
        long jE = bVar.e(iG);
        long jC = jE + bVar.c(iG);
        long j4 = list.isEmpty() ? j : -9223372036854775807L;
        int i2 = iG + this.g;
        int iD = this.e.d();
        qt qtVar = this.c[iD];
        Uri uriA = bVar.a(this.e.i(iD), iG);
        this.i = SystemClock.elapsedRealtime();
        rtVar.a = k(this.e.l(), this.d, uriA, i2, jE, jC, j4, this.e.m(), this.e.p(), qtVar, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.smoothstreaming.b
    public void j(fd4 fd4Var) {
        fd4.b[] bVarArr = this.f.f;
        int i = this.b;
        fd4.b bVar = bVarArr[i];
        int i2 = bVar.k;
        fd4.b bVar2 = fd4Var.f[i];
        if (i2 == 0 || bVar2.k == 0) {
            this.g += i2;
        } else {
            int i3 = i2 - 1;
            long jE = bVar.e(i3) + bVar.c(i3);
            long jE2 = bVar2.e(0);
            int i4 = this.g;
            if (jE <= jE2) {
                this.g = i4 + i2;
            } else {
                this.g = i4 + bVar.d(jE2);
            }
        }
        this.f = fd4Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long l(long j) {
        fd4 fd4Var = this.f;
        if (!fd4Var.d) {
            return -9223372036854775807L;
        }
        fd4.b bVar = fd4Var.f[this.b];
        int i = bVar.k - 1;
        return (bVar.e(i) + bVar.c(i)) - j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xt
    public void release() {
        for (qt qtVar : this.c) {
            qtVar.release();
        }
    }
}
