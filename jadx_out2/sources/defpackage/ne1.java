package defpackage;

import android.net.Uri;
import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.exoplayer.j;
import defpackage.fv;
import defpackage.ja0;
import defpackage.sy1;
import defpackage.we1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import okhttp3.internal.http2.Http2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ne1 {
    public final pe1 a;
    public final aa0 b;
    public final aa0 c;
    public final zo4 d;
    public final ef1[] e;
    public final t41[] f;
    public final df1 g;
    public final br4 h;
    public final List i;
    public final ie3 k;
    public final long l;
    public boolean m;
    public IOException o;
    public Uri p;
    public Uri q;
    public boolean r;
    public jy0 s;
    public long u = -9223372036854775807L;
    public final l81 j = new l81(4);
    public byte[] n = fy4.f;
    public long t = -9223372036854775807L;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends s90 {
        public byte[] l;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(aa0 aa0Var, ja0 ja0Var, t41 t41Var, int i, Object obj, byte[] bArr) {
            super(aa0Var, ja0Var, 3, t41Var, i, obj, bArr);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.s90
        public void g(byte[] bArr, int i) {
            this.l = Arrays.copyOf(bArr, i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public byte[] j() {
            return this.l;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public pt a;
        public boolean b;
        public Uri c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
            a();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a() {
            this.a = null;
            this.b = false;
            this.c = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends hi {
        public final List e;
        public final long f;
        public final String g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(String str, long j, List list) {
            super(0L, list.size() - 1);
            this.g = str;
            this.f = j;
            this.e = list;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.w72
        public long a() {
            c();
            return this.f + ((we1.g) this.e.get((int) d())).j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.w72
        public long b() {
            c();
            we1.g gVar = (we1.g) this.e.get((int) d());
            return this.f + gVar.j + gVar.h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends bj {
        public int i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(br4 br4Var, int[] iArr) {
            super(br4Var, iArr);
            this.i = e(br4Var.c(iArr[0]));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jy0
        public void b(long j, long j2, long j3, List list, w72[] w72VarArr) {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            if (a(this.i, jElapsedRealtime)) {
                for (int i = this.b - 1; i >= 0; i--) {
                    if (!a(i, jElapsedRealtime)) {
                        this.i = i;
                        return;
                    }
                }
                z20.a();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jy0
        public int d() {
            return this.i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jy0
        public int m() {
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jy0
        public Object p() {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e {
        public final we1.g a;
        public final long b;
        public final int c;
        public final boolean d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(we1.g gVar, long j, int i) {
            this.a = gVar;
            this.b = j;
            this.c = i;
            this.d = (gVar instanceof we1.d) && ((we1.d) gVar).r;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ne1(pe1 pe1Var, df1 df1Var, ef1[] ef1VarArr, t41[] t41VarArr, oe1 oe1Var, hs4 hs4Var, zo4 zo4Var, long j, List list, ie3 ie3Var, ev evVar) {
        this.a = pe1Var;
        this.g = df1Var;
        this.e = ef1VarArr;
        this.f = t41VarArr;
        this.d = zo4Var;
        this.l = j;
        this.i = list;
        this.k = ie3Var;
        aa0 aa0VarA = oe1Var.a(1);
        this.b = aa0VarA;
        if (hs4Var != null) {
            aa0VarA.f(hs4Var);
        }
        this.c = oe1Var.a(3);
        this.h = new br4(t41VarArr);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < ef1VarArr.length; i++) {
            if ((t41VarArr[i].f & Http2.INITIAL_MAX_FRAME_SIZE) == 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        this.s = new d(this.h, ll1.n(arrayList));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean C(boolean z, we1 we1Var, long j, int i, se1 se1Var, long j2, long j3) {
        if (!z || se1Var == null) {
            return false;
        }
        if (j < we1Var.k) {
            return true;
        }
        e eVarJ = j(we1Var, j, i);
        return eVarJ != null && j2 + eVarJ.a.j < j3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Uri g(we1 we1Var, we1.g gVar) {
        String str;
        if (gVar == null || (str = gVar.l) == null) {
            return null;
        }
        return kx4.g(we1Var.a, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static e j(we1 we1Var, long j, int i) {
        int i2 = (int) (j - we1Var.k);
        if (i2 == we1Var.r.size()) {
            if (i == -1) {
                i = 0;
            }
            if (i < we1Var.s.size()) {
                return new e((we1.g) we1Var.s.get(i), j, i);
            }
            return null;
        }
        we1.f fVar = (we1.f) we1Var.r.get(i2);
        if (i == -1) {
            return new e(fVar, j, -1);
        }
        if (i < fVar.r.size()) {
            return new e((we1.g) fVar.r.get(i), j, i);
        }
        int i3 = i2 + 1;
        if (i3 < we1Var.r.size()) {
            return new e((we1.g) we1Var.r.get(i3), j + 1, -1);
        }
        if (we1Var.s.isEmpty()) {
            return null;
        }
        return new e((we1.g) we1Var.s.get(0), j + 1, 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List m(we1 we1Var, long j, int i) {
        int i2 = (int) (j - we1Var.k);
        if (i2 < 0 || we1Var.r.size() < i2) {
            return xi1.u();
        }
        ArrayList arrayList = new ArrayList();
        if (i2 < we1Var.r.size()) {
            if (i != -1) {
                we1.f fVar = (we1.f) we1Var.r.get(i2);
                if (i == 0) {
                    arrayList.add(fVar);
                } else if (i < fVar.r.size()) {
                    List list = fVar.r;
                    arrayList.addAll(list.subList(i, list.size()));
                }
                i2++;
            }
            List list2 = we1Var.r;
            arrayList.addAll(list2.subList(i2, list2.size()));
            i = 0;
        }
        if (we1Var.n != -9223372036854775807L) {
            int i3 = i != -1 ? i : 0;
            if (i3 < we1Var.s.size()) {
                List list3 = we1Var.s;
                arrayList.addAll(list3.subList(i3, list3.size()));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean q(e eVar, we1 we1Var) {
        we1.g gVar = eVar.a;
        if (!(gVar instanceof we1.d)) {
            return we1Var.c;
        }
        if (((we1.d) gVar).q) {
            return true;
        }
        return eVar.c == 0 && we1Var.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void A(jy0 jy0Var) {
        d();
        this.s = jy0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean B(long j, pt ptVar, List list) {
        if (this.o != null) {
            return false;
        }
        return this.s.f(j, ptVar, list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void D(we1 we1Var) {
        this.t = we1Var.o ? -9223372036854775807L : we1Var.e() - this.g.i();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public sy1.a a(pt ptVar) {
        if (ptVar instanceof se1) {
            return b(((se1) ptVar).m);
        }
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        jy0 jy0VarO = o();
        int length = jy0VarO.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (jy0VarO.a(i2, jElapsedRealtime) || this.g.b(this.e[i2], jElapsedRealtime)) {
                i++;
            }
        }
        return new sy1.a(1, 0, length, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public sy1.a b(Uri uri) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        ef1 ef1Var = (ef1) gg3.q(this.g.q(uri));
        int iK = ef1Var.k();
        pw4 it = ef1Var.d().iterator();
        int i = 0;
        while (it.hasNext()) {
            if (this.g.d((Uri) it.next(), jElapsedRealtime)) {
                i++;
            }
        }
        int length = this.s.length();
        jy0 jy0VarO = o();
        int i2 = 0;
        for (int i3 = 0; i3 < this.e.length; i3++) {
            if (jy0VarO.a(i3, jElapsedRealtime) || this.g.b(this.e[i3], jElapsedRealtime)) {
                i2++;
            }
        }
        return new sy1.a(iK, i, length, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public w72[] c(se1 se1Var, long j) {
        int iD = se1Var == null ? -1 : this.h.d(se1Var.d);
        int length = this.s.length();
        w72[] w72VarArr = new w72[length];
        for (int i = 0; i < length; i++) {
            int i2 = this.s.i(i);
            Uri uriF = this.e[i2].f();
            if (this.g.c(uriF)) {
                we1 we1VarR = this.g.r(uriF, false);
                gg3.q(we1VarR);
                long jI = we1VarR.h - this.g.i();
                Pair pairI = i(se1Var, i2 != iD, we1VarR, jI, j);
                w72VarArr[i] = new c(we1VarR.a, jI, m(we1VarR, ((Long) pairI.first).longValue(), ((Integer) pairI.second).intValue()));
            } else {
                w72VarArr[i] = w72.a;
            }
        }
        return w72VarArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void d() {
        this.g.e(this.e[this.s.k()].f());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long e(long j, zz3 zz3Var) {
        int iD = this.s.d();
        ef1[] ef1VarArr = this.e;
        we1 we1VarR = (iD >= ef1VarArr.length || iD == -1) ? null : this.g.r(ef1VarArr[this.s.k()].f(), true);
        if (we1VarR == null || we1VarR.r.isEmpty()) {
            return j;
        }
        long jI = we1VarR.h - this.g.i();
        long j2 = j - jI;
        int i = fy4.i(we1VarR.r, Long.valueOf(j2), true, true);
        long j3 = ((we1.f) we1VarR.r.get(i)).j;
        return zz3Var.a(j2, j3, (!we1VarR.c || i == we1VarR.r.size() - 1) ? j3 : ((we1.f) we1VarR.r.get(i + 1)).j) + jI;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int f(se1 se1Var) {
        if (se1Var.o == -1) {
            return 1;
        }
        we1 we1Var = (we1) gg3.q(this.g.r(se1Var.m, false));
        int i = (int) (se1Var.j - we1Var.k);
        if (i < 0) {
            return 1;
        }
        List list = i < we1Var.r.size() ? ((we1.f) we1Var.r.get(i)).r : we1Var.s;
        if (se1Var.o >= list.size()) {
            return 2;
        }
        we1.d dVar = (we1.d) list.get(se1Var.o);
        if (dVar.r) {
            return 0;
        }
        return Objects.equals(Uri.parse(kx4.f(we1Var.a, dVar.f)), se1Var.b.a) ? 1 : 2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h(j jVar, long j, long j2, List list, boolean z, b bVar) {
        int i;
        boolean z2;
        Uri uri;
        long j3;
        boolean z3;
        e eVar;
        se1 se1Var = list.isEmpty() ? null : (se1) km1.d(list);
        int iD = se1Var == null ? -1 : this.h.d(se1Var.d);
        long j4 = jVar.a;
        long jMax = j - j4;
        long jY = y(j4);
        if (se1Var != null && !this.r) {
            long jD = se1Var.d();
            jMax = Math.max(0L, jMax - jD);
            if (jY != -9223372036854775807L) {
                jY = Math.max(0L, jY - jD);
            }
        }
        this.s.b(j4, jMax, jY, list, c(se1Var, j));
        int iK = this.s.k();
        boolean z4 = iD != iK;
        Uri uriF = this.e[iK].f();
        if (!this.g.c(uriF)) {
            bVar.c = uriF;
            this.q = uriF;
            return;
        }
        we1 we1VarR = this.g.r(uriF, true);
        gg3.q(we1VarR);
        this.r = we1VarR.c;
        D(we1VarR);
        long jI = we1VarR.h - this.g.i();
        Pair pairI = i(se1Var, z4, we1VarR, jI, j);
        long jLongValue = ((Long) pairI.first).longValue();
        int iIntValue = ((Integer) pairI.second).intValue();
        boolean z5 = z4;
        int i2 = iD;
        we1 we1Var = we1VarR;
        se1 se1Var2 = se1Var;
        long j5 = jLongValue;
        if (C(z5, we1Var, j5, iIntValue, se1Var2, jI, j2)) {
            Uri uriF2 = this.e[i2].f();
            we1 we1VarR2 = this.g.r(uriF2, true);
            gg3.q(we1VarR2);
            long jI2 = we1VarR2.h - this.g.i();
            i = i2;
            z2 = false;
            Pair pairI2 = i(se1Var2, false, we1VarR2, jI2, j);
            long jLongValue2 = ((Long) pairI2.first).longValue();
            iIntValue = ((Integer) pairI2.second).intValue();
            we1Var = we1VarR2;
            uri = uriF2;
            j5 = jLongValue2;
            j3 = jI2;
            iK = i;
        } else {
            i = i2;
            z2 = false;
            uri = uriF;
            j3 = jI;
        }
        if (iK != i && i != -1) {
            this.g.e(this.e[i].f());
        }
        if (j5 < we1Var.k) {
            this.o = new oj();
            return;
        }
        e eVarJ = j(we1Var, j5, iIntValue);
        if (eVarJ != null) {
            z3 = true;
            eVar = eVarJ;
        } else if (!we1Var.o) {
            bVar.c = uri;
            this.q = uri;
            return;
        } else if (z || we1Var.r.isEmpty()) {
            bVar.b = true;
            return;
        } else {
            eVar = new e((we1.g) km1.d(we1Var.r), (we1Var.k + ((long) we1Var.r.size())) - 1, -1);
            z3 = true;
        }
        this.q = null;
        this.u = SystemClock.elapsedRealtime();
        Uri uriG = g(we1Var, eVar.a.g);
        pt ptVarR = r(uriG, iK, z3, null);
        bVar.a = ptVarR;
        if (ptVarR != null) {
            return;
        }
        Uri uriG2 = g(we1Var, eVar.a);
        pt ptVarR2 = r(uriG2, iK, z2, null);
        bVar.a = ptVarR2;
        if (ptVarR2 != null) {
            return;
        }
        boolean zQ = q(eVar, we1Var);
        boolean z6 = se1.z(se1Var2, j, uri, zQ, eVar, j3);
        Uri uri2 = uri;
        if (z6 && eVar.d) {
            return;
        }
        bVar.a = se1.l(this.a, this.b, this.f[iK], j3, we1Var, eVar, uri2, this.i, this.s.m(), this.s.p(), this.m, this.d, this.l, se1Var2, this.j.a(uriG2), this.j.a(uriG), z6, zQ, this.k, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Pair i(se1 se1Var, boolean z, we1 we1Var, long j, long j2) {
        List list;
        if (se1Var != null && !z) {
            if (!se1Var.h()) {
                return new Pair(Long.valueOf(se1Var.j), Integer.valueOf(se1Var.o));
            }
            Long lValueOf = Long.valueOf(se1Var.o == -1 ? se1Var.g() : se1Var.j);
            int i = se1Var.o;
            return new Pair(lValueOf, Integer.valueOf(i != -1 ? i + 1 : -1));
        }
        long j3 = we1Var.u + j;
        if (se1Var != null && !this.r) {
            j2 = se1Var.g;
        }
        if (!we1Var.o && j2 >= j3) {
            return new Pair(Long.valueOf(we1Var.k + ((long) we1Var.r.size())), -1);
        }
        long j4 = j2 - j;
        int i2 = 0;
        int i3 = fy4.i(we1Var.r, Long.valueOf(j4), true, !this.g.a() || se1Var == null);
        long j5 = ((long) i3) + we1Var.k;
        if (!this.g.a()) {
            return new Pair(Long.valueOf(j5), -1);
        }
        if (i3 >= 0) {
            if (we1Var.r.isEmpty()) {
                list = we1Var.s;
            } else {
                we1.f fVar = (we1.f) we1Var.r.get(i3);
                list = j4 < fVar.j + fVar.h ? fVar.r : we1Var.s;
            }
            while (true) {
                if (i2 >= list.size()) {
                    break;
                }
                we1.d dVar = (we1.d) list.get(i2);
                if (j4 >= dVar.j + dVar.h) {
                    i2++;
                } else if (dVar.q) {
                    j5 += (list != we1Var.s || we1Var.r.isEmpty()) ? 0L : 1L;
                    i = i2;
                }
            }
        }
        return new Pair(Long.valueOf(j5), Integer.valueOf(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int k(long j, List list) {
        return (this.o != null || this.s.length() < 2) ? list.size() : this.s.j(j, list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long l(se1 se1Var) {
        gg3.v(se1Var.o != -1);
        we1 we1Var = (we1) gg3.q(this.g.r(se1Var.m, false));
        int i = (int) (se1Var.j - we1Var.k);
        if (i < 0) {
            return 0L;
        }
        return ((we1.d) (i < we1Var.r.size() ? ((we1.f) we1Var.r.get(i)).r : we1Var.s).get(se1Var.o)).h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public br4 n() {
        return this.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public jy0 o() {
        return this.s;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean p() {
        return this.r;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final pt r(Uri uri, int i, boolean z, fv.a aVar) {
        if (uri == null) {
            return null;
        }
        byte[] bArrC = this.j.c(uri);
        if (bArrC != null) {
            this.j.b(uri, bArrC);
            return null;
        }
        return new a(this.c, new ja0.b().i(uri).b(1).a(), this.f[i], this.s.m(), this.s.p(), this.n);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void s() throws IOException {
        IOException iOException = this.o;
        if (iOException != null) {
            throw iOException;
        }
        Uri uri = this.p;
        if (uri == null || !uri.equals(this.q)) {
            return;
        }
        this.g.f(this.p);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean t(Uri uri) {
        for (ef1 ef1Var : this.e) {
            if (ef1Var.equals(this.g.q(uri))) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean u(pt ptVar, sy1.b bVar) {
        int iS;
        if (bVar == null) {
            return false;
        }
        long j = bVar.b;
        int i = bVar.a;
        if (i == 1) {
            if (ptVar instanceof se1) {
                return this.g.m(((se1) ptVar).m, j);
            }
            return false;
        }
        if (i != 2) {
            jr1.a("Invalid fallback selection type: ", bVar.a);
            return false;
        }
        int iD = this.h.d(ptVar.d);
        if (iD == -1 || (iS = this.s.s(iD)) == -1) {
            return false;
        }
        return this.s.n(iS, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void v(pt ptVar) {
        if (ptVar instanceof a) {
            a aVar = (a) ptVar;
            this.n = aVar.h();
            this.j.b(aVar.b.a, (byte[]) gg3.q(aVar.j()));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean w(Uri uri, sy1.b bVar) {
        int iS;
        this.p = uri;
        if (bVar == null) {
            return false;
        }
        long j = bVar.b;
        int i = bVar.a;
        if (i == 1) {
            return this.g.m(uri, j);
        }
        if (i != 2) {
            jr1.a("Invalid fallback selection type: ", bVar.a);
            return false;
        }
        int i2 = 0;
        while (true) {
            ef1[] ef1VarArr = this.e;
            if (i2 >= ef1VarArr.length) {
                i2 = -1;
                break;
            }
            if (ef1VarArr[i2].equals(this.g.q(uri))) {
                break;
            }
            i2++;
        }
        return i2 != -1 && (iS = this.s.s(i2)) != -1 && this.s.n(iS, j) && this.g.m(uri, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void x() {
        d();
        this.o = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long y(long j) {
        long j2 = this.t;
        if (j2 != -9223372036854775807L) {
            return j2 - j;
        }
        return -9223372036854775807L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void z(boolean z) {
        this.m = z;
    }
}
