package defpackage;

import android.net.Uri;
import defpackage.we1;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class we1 extends af1 {
    public final int d;
    public final long e;
    public final boolean f;
    public final boolean g;
    public final long h;
    public final boolean i;
    public final int j;
    public final long k;
    public final int l;
    public final long m;
    public final long n;
    public final boolean o;
    public final boolean p;
    public final oo0 q;
    public final List r;
    public final List s;
    public final Map t;
    public final long u;
    public final h v;
    public final xi1 w;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public final String a;
        public final Uri b;
        public final Uri c;
        public final long d;
        public final long e;
        public final long f;
        public final long g;
        public final List h;
        public final boolean i;
        public final long j;
        public final long k;
        public final xi1 l;
        public final xi1 m;
        public final xi1 n;
        public final boolean o;
        public final String p;
        public final String q;
        public final long r;
        public final long s;
        public final String t;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a {
            public final String a;
            public Uri c;
            public Uri d;
            public boolean j;
            public Boolean o;
            public String p;
            public String q;
            public String t;
            public final Map b = new HashMap();
            public long e = -9223372036854775807L;
            public long f = -9223372036854775807L;
            public long g = -9223372036854775807L;
            public long h = -9223372036854775807L;
            public List i = new ArrayList();
            public long k = -9223372036854775807L;
            public long l = -9223372036854775807L;
            public List m = new ArrayList();
            public List n = new ArrayList();
            public long r = -9223372036854775807L;
            public long s = -9223372036854775807L;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a(String str) {
                this.a = str;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public c a() {
                Uri uri = this.d;
                if ((uri != null || this.c == null) && (uri == null || this.c != null)) {
                    return null;
                }
                long j = this.e;
                if (j == -9223372036854775807L) {
                    return null;
                }
                String str = this.a;
                Uri uri2 = this.c;
                long j2 = this.f;
                long j3 = this.g;
                long j4 = this.h;
                List list = this.i;
                boolean z = this.j;
                long j5 = this.k;
                long j6 = this.l;
                List list2 = this.m;
                List list3 = this.n;
                ArrayList arrayList = new ArrayList(this.b.values());
                Boolean bool = this.o;
                boolean z2 = bool == null || bool.booleanValue();
                String str2 = this.p;
                if (str2 == null) {
                    str2 = "POINT";
                }
                String str3 = str2;
                String str4 = this.q;
                if (str4 == null) {
                    str4 = "HIGHLIGHT";
                }
                return new c(str, uri2, uri, j, j2, j3, j4, list, z, j5, j6, list2, list3, arrayList, z2, str3, str4, this.r, this.s, this.t);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a b(Uri uri) {
                if (uri == null) {
                    return this;
                }
                Uri uri2 = this.d;
                if (uri2 != null) {
                    gg3.m(uri2.equals(uri), "Can't change assetListUri from %s to %s", this.d, uri);
                }
                this.d = uri;
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a c(Uri uri) {
                if (uri == null) {
                    return this;
                }
                Uri uri2 = this.c;
                if (uri2 != null) {
                    gg3.m(uri2.equals(uri), "Can't change assetUri from %s to %s", this.c, uri);
                }
                this.c = uri;
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a d(List list) {
                if (!list.isEmpty()) {
                    for (int i = 0; i < list.size(); i++) {
                        b bVar = (b) list.get(i);
                        String str = bVar.a;
                        b bVar2 = (b) this.b.get(str);
                        if (bVar2 != null) {
                            gg3.n(bVar2.equals(bVar), "Can't change %s from %s %s to %s %s", str, bVar2.d, Double.valueOf(bVar2.c), bVar.d, Double.valueOf(bVar.c));
                        }
                        this.b.put(str, bVar);
                    }
                }
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a e(Boolean bool) {
                if (bool == null) {
                    return this;
                }
                Boolean bool2 = this.o;
                if (bool2 != null) {
                    gg3.m(bool2.equals(bool), "Can't change contentMayVary from %s to %s", this.o, bool);
                }
                this.o = bool;
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a f(List list) {
                if (list.isEmpty()) {
                    return this;
                }
                if (!this.i.isEmpty()) {
                    gg3.e(this.i.equals(list), "Can't change cue from " + ye1.a(", ", this.i) + " to " + ye1.a(", ", list));
                }
                this.i = list;
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a g(long j) {
                long j2;
                if (j == -9223372036854775807L) {
                    return this;
                }
                long j3 = this.g;
                if (j3 != -9223372036854775807L) {
                    j2 = j;
                    gg3.j(j3 == j, "Can't change durationUs from %s to %s", j3, j2);
                } else {
                    j2 = j;
                }
                this.g = j2;
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a h(long j) {
                long j2;
                if (j == -9223372036854775807L) {
                    return this;
                }
                long j3 = this.f;
                if (j3 != -9223372036854775807L) {
                    j2 = j;
                    gg3.j(j3 == j, "Can't change endDateUnixUs from %s to %s", j3, j2);
                } else {
                    j2 = j;
                }
                this.f = j2;
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a i(boolean z) {
                if (!z) {
                    return this;
                }
                this.j = true;
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a j(long j) {
                long j2;
                if (j == -9223372036854775807L) {
                    return this;
                }
                long j3 = this.h;
                if (j3 != -9223372036854775807L) {
                    j2 = j;
                    gg3.j(j3 == j, "Can't change plannedDurationUs from %s to %s", j3, j2);
                } else {
                    j2 = j;
                }
                this.h = j2;
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a k(long j) {
                long j2;
                if (j == -9223372036854775807L) {
                    return this;
                }
                long j3 = this.l;
                if (j3 != -9223372036854775807L) {
                    j2 = j;
                    gg3.j(j3 == j, "Can't change playoutLimitUs from %s to %s", j3, j2);
                } else {
                    j2 = j;
                }
                this.l = j2;
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a l(List list) {
                if (list.isEmpty()) {
                    return this;
                }
                if (!this.n.isEmpty()) {
                    gg3.e(this.n.equals(list), "Can't change restrictions from " + ye1.a(", ", this.n) + " to " + ye1.a(", ", list));
                }
                this.n = list;
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a m(long j) {
                long j2;
                if (j == -9223372036854775807L) {
                    return this;
                }
                long j3 = this.k;
                if (j3 != -9223372036854775807L) {
                    j2 = j;
                    gg3.j(j3 == j, "Can't change resumeOffsetUs from %s to %s", j3, j2);
                } else {
                    j2 = j;
                }
                this.k = j2;
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a n(long j) {
                long j2;
                if (j == -9223372036854775807L) {
                    return this;
                }
                long j3 = this.s;
                if (j3 != -9223372036854775807L) {
                    j2 = j;
                    gg3.j(j3 == j, "Can't change skipControlDurationUs from %s to %s", j3, j2);
                } else {
                    j2 = j;
                }
                this.s = j2;
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a o(String str) {
                if (str == null) {
                    return this;
                }
                String str2 = this.t;
                if (str2 != null) {
                    gg3.m(str2.equals(str), "Can't change skipControlLabelId from %s to %s", this.t, str);
                }
                this.t = str;
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a p(long j) {
                long j2;
                if (j == -9223372036854775807L) {
                    return this;
                }
                long j3 = this.r;
                if (j3 != -9223372036854775807L) {
                    j2 = j;
                    gg3.j(j3 == j, "Can't change skipControlOffsetUs from %s to %s", j3, j2);
                } else {
                    j2 = j;
                }
                this.r = j2;
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a q(List list) {
                if (list.isEmpty()) {
                    return this;
                }
                if (!this.m.isEmpty()) {
                    gg3.e(this.m.equals(list), "Can't change snapTypes from " + ye1.a(", ", this.m) + " to " + ye1.a(", ", list));
                }
                this.m = list;
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a r(long j) {
                long j2;
                if (j == -9223372036854775807L) {
                    return this;
                }
                long j3 = this.e;
                if (j3 != -9223372036854775807L) {
                    j2 = j;
                    gg3.j(j3 == j, "Can't change startDateUnixUs from %s to %s", j3, j2);
                } else {
                    j2 = j;
                }
                this.e = j2;
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a s(String str) {
                if (str == null) {
                    return this;
                }
                String str2 = this.p;
                if (str2 != null) {
                    gg3.m(str2.equals(str), "Can't change timelineOccupies from %s to %s", this.p, str);
                }
                this.p = str;
                return this;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a t(String str) {
                if (str == null) {
                    return this;
                }
                String str2 = this.q;
                if (str2 != null) {
                    gg3.m(str2.equals(str), "Can't change timelineStyle from %s to %s", this.q, str);
                }
                this.q = str;
                return this;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(String str, Uri uri, Uri uri2, long j, long j2, long j3, long j4, List list, boolean z, long j5, long j6, List list2, List list3, List list4, boolean z2, String str2, String str3, long j7, long j8, String str4) {
            gg3.d((uri == null || uri2 == null) && !(uri == null && uri2 == null));
            this.a = str;
            this.b = uri;
            this.c = uri2;
            this.d = j;
            this.e = j2;
            this.f = j3;
            this.g = j4;
            this.h = list;
            this.i = z;
            this.j = j5;
            this.k = j6;
            this.l = xi1.p(list2);
            this.m = xi1.p(list3);
            this.n = xi1.E(new Comparator() { // from class: xe1
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ((we1.b) obj).a.compareTo(((we1.b) obj2).a);
                }
            }, list4);
            this.o = z2;
            this.p = str2;
            this.q = str3;
            this.r = j7;
            this.s = j8;
            this.t = str4;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.d == cVar.d && this.e == cVar.e && this.f == cVar.f && this.g == cVar.g && this.i == cVar.i && this.j == cVar.j && this.k == cVar.k && this.o == cVar.o && this.r == cVar.r && this.s == cVar.s && Objects.equals(this.a, cVar.a) && Objects.equals(this.b, cVar.b) && Objects.equals(this.c, cVar.c) && Objects.equals(this.h, cVar.h) && Objects.equals(this.l, cVar.l) && Objects.equals(this.m, cVar.m) && Objects.equals(this.n, cVar.n) && Objects.equals(this.p, cVar.p) && Objects.equals(this.q, cVar.q) && Objects.equals(this.t, cVar.t);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int hashCode() {
            return Objects.hash(this.a, this.b, this.c, Long.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.f), Long.valueOf(this.g), this.h, Boolean.valueOf(this.i), Long.valueOf(this.j), Long.valueOf(this.k), this.l, this.m, this.n, Boolean.valueOf(this.o), this.p, this.q, Long.valueOf(this.r), Long.valueOf(this.s), this.t);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends g {
        public final boolean q;
        public final boolean r;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(String str, f fVar, long j, int i, long j2, oo0 oo0Var, String str2, String str3, long j3, long j4, boolean z, boolean z2, boolean z3) {
            super(str, fVar, j, i, j2, oo0Var, str2, str3, j3, j4, z);
            this.q = z2;
            this.r = z3;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d b(long j, int i) {
            return new d(this.f, this.g, this.h, i, j, this.k, this.l, this.m, this.n, this.o, this.p, this.q, this.r);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e {
        public final Uri a;
        public final long b;
        public final int c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(Uri uri, long j, int i) {
            this.a = uri;
            this.b = j;
            this.c = i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class g implements Comparable {
        public final String f;
        public final f g;
        public final long h;
        public final int i;
        public final long j;
        public final oo0 k;
        public final String l;
        public final String m;
        public final long n;
        public final long o;
        public final boolean p;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g(String str, f fVar, long j, int i, long j2, oo0 oo0Var, String str2, String str3, long j3, long j4, boolean z) {
            this.f = str;
            this.g = fVar;
            this.h = j;
            this.i = i;
            this.j = j2;
            this.k = oo0Var;
            this.l = str2;
            this.m = str3;
            this.n = j3;
            this.o = j4;
            this.p = z;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: compareTo(Ljava/lang/Object;)I */
        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(Long l) {
            if (this.j > l.longValue()) {
                return 1;
            }
            return this.j < l.longValue() ? -1 : 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class h {
        public final long a;
        public final boolean b;
        public final long c;
        public final long d;
        public final boolean e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public h(long j, boolean z, long j2, long j3, boolean z2) {
            this.a = j;
            this.b = z;
            this.c = j2;
            this.d = j3;
            this.e = z2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public we1(int i, String str, List list, long j, boolean z, long j2, boolean z2, int i2, long j3, int i3, long j4, long j5, boolean z3, boolean z4, boolean z5, oo0 oo0Var, List list2, List list3, h hVar, Map map, List list4) {
        super(str, list, z3);
        this.d = i;
        this.h = j2;
        this.g = z;
        this.i = z2;
        this.j = i2;
        this.k = j3;
        this.l = i3;
        this.m = j4;
        this.n = j5;
        this.o = z4;
        this.p = z5;
        this.q = oo0Var;
        this.r = xi1.p(list2);
        this.s = xi1.p(list3);
        this.t = zi1.c(map);
        this.w = xi1.p(list4);
        if (!list3.isEmpty()) {
            d dVar = (d) km1.d(list3);
            this.u = dVar.j + dVar.h;
        } else if (list2.isEmpty()) {
            this.u = 0L;
        } else {
            f fVar = (f) km1.d(list2);
            this.u = fVar.j + fVar.h;
        }
        long jMin = -9223372036854775807L;
        if (j != -9223372036854775807L) {
            long j6 = this.u;
            jMin = j >= 0 ? Math.min(j6, j) : Math.max(0L, j6 + j);
        }
        this.e = jMin;
        this.f = j >= 0;
        this.v = hVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a(Ljava/util/List;)Ljava/lang/Object; */
    @Override // defpackage.j11
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public we1 a(List list) {
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public we1 c(long j, int i) {
        return new we1(this.d, this.a, this.b, this.e, this.g, j, true, i, this.k, this.l, this.m, this.n, this.c, this.o, this.p, this.q, this.r, this.s, this.v, this.t, this.w);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public we1 d() {
        return this.o ? this : new we1(this.d, this.a, this.b, this.e, this.g, this.h, this.i, this.j, this.k, this.l, this.m, this.n, this.c, true, this.p, this.q, this.r, this.s, this.v, this.t, this.w);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long e() {
        return this.h + this.u;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean f(we1 we1Var) {
        if (we1Var != null) {
            long j = this.k;
            long j2 = we1Var.k;
            if (j <= j2) {
                if (j < j2) {
                    return false;
                }
                int size = this.r.size() - we1Var.r.size();
                if (size != 0) {
                    return size > 0;
                }
                int size2 = this.s.size();
                int size3 = we1Var.s.size();
                if (size2 <= size3 && (size2 != size3 || !this.o || we1Var.o)) {
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public final String a;
        public final int b;
        public final double c;
        public final String d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(String str, String str2, int i) {
            boolean z = true;
            if (i == 1 && !str2.startsWith("0x") && !str2.startsWith("0X")) {
                z = false;
            }
            gg3.v(z);
            this.a = str;
            this.b = i;
            this.d = str2;
            this.c = 0.0d;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            return this.b == bVar.b && Double.compare(this.c, bVar.c) == 0 && Objects.equals(this.a, bVar.a) && Objects.equals(this.d, bVar.d);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int hashCode() {
            return Objects.hash(this.a, Integer.valueOf(this.b), Double.valueOf(this.c), this.d);
        }

        public b(String str, double d) {
            this.a = str;
            this.b = 2;
            this.c = d;
            this.d = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f extends g {
        public final String q;
        public final List r;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f(String str, f fVar, String str2, long j, int i, long j2, oo0 oo0Var, String str3, String str4, long j3, long j4, boolean z, List list) {
            super(str, fVar, j, i, j2, oo0Var, str3, str4, j3, j4, z);
            this.q = str2;
            this.r = xi1.p(list);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f b(long j, int i) {
            ArrayList arrayList = new ArrayList();
            long j2 = j;
            for (int i2 = 0; i2 < this.r.size(); i2++) {
                d dVar = (d) this.r.get(i2);
                arrayList.add(dVar.b(j2, i));
                j2 += dVar.h;
            }
            return new f(this.f, this.g, this.q, this.h, i, j, this.k, this.l, this.m, this.n, this.o, this.p, arrayList);
        }

        public f(String str, long j, long j2, String str2, String str3) {
            this(str, null, "", 0L, -1, -9223372036854775807L, null, str2, str3, j, j2, false, xi1.u());
        }
    }
}
