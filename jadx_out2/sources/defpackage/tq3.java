package defpackage;

import android.net.Uri;
import defpackage.g04;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class tq3 {
    public final long a;
    public final t41 b;
    public final xi1 c;
    public final long d;
    public final List e;
    public final List f;
    public final List g;
    public final vn3 h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b extends tq3 implements m90 {
        public final g04.a i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(long j, t41 t41Var, List list, g04.a aVar, List list2, List list3, List list4) {
            super(j, t41Var, list, aVar, list2, list3, list4);
            this.i = aVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.m90
        public long a(long j) {
            return this.i.j(j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.m90
        public long b(long j, long j2) {
            return this.i.h(j, j2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.m90
        public long c(long j, long j2) {
            return this.i.d(j, j2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.m90
        public long d(long j, long j2) {
            return this.i.f(j, j2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.m90
        public vn3 e(long j) {
            return this.i.k(this, j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.m90
        public long f(long j, long j2) {
            return this.i.i(j, j2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.m90
        public boolean g() {
            return this.i.l();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.m90
        public long h() {
            return this.i.e();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.m90
        public long i(long j) {
            return this.i.g(j);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.m90
        public long j(long j, long j2) {
            return this.i.c(j, j2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.tq3
        public String k() {
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.tq3
        public m90 l() {
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.tq3
        public vn3 m() {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends tq3 {
        public final Uri i;
        public final long j;
        public final String k;
        public final vn3 l;
        public final o74 m;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(long j, t41 t41Var, List list, g04.e eVar, List list2, List list3, List list4, String str, long j2) {
            super(j, t41Var, list, eVar, list2, list3, list4);
            this.i = Uri.parse(((dj) list.get(0)).a);
            vn3 vn3VarC = eVar.c();
            this.l = vn3VarC;
            this.k = str;
            this.j = j2;
            this.m = vn3VarC != null ? null : new o74(new vn3(null, 0L, j2));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.tq3
        public String k() {
            return this.k;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.tq3
        public m90 l() {
            return this.m;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.tq3
        public vn3 m() {
            return this.l;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public tq3(long j, t41 t41Var, List list, g04 g04Var, List list2, List list3, List list4) {
        gg3.d(!list.isEmpty());
        this.a = j;
        this.b = t41Var;
        this.c = xi1.p(list);
        this.e = list2 == null ? Collections.EMPTY_LIST : Collections.unmodifiableList(list2);
        this.f = list3;
        this.g = list4;
        this.h = g04Var.a(this);
        this.d = g04Var.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static tq3 o(long j, t41 t41Var, List list, g04 g04Var, List list2, List list3, List list4, String str) {
        if (g04Var instanceof g04.e) {
            return new c(j, t41Var, list, (g04.e) g04Var, list2, list3, list4, str, -1L);
        }
        if (g04Var instanceof g04.a) {
            return new b(j, t41Var, list, (g04.a) g04Var, list2, list3, list4);
        }
        jl.a("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
        return null;
    }

    public abstract String k();

    public abstract m90 l();

    public abstract vn3 m();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public vn3 n() {
        return this.h;
    }
}
