package defpackage;

import defpackage.kw2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class aq3 extends bj1 {
    public static final aq3 l = new aq3(s43.a());
    public final transient s43 i;
    public final transient int j;
    public transient dj1 k;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class b extends oj1 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.vi1, java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return aq3.this.contains(obj);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.vi1
        public boolean g() {
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.oj1
        public Object get(int i) {
            return aq3.this.i.h(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return aq3.this.i.v();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public aq3(s43 s43Var) {
        this.i = s43Var;
        long j = 0;
        for (int i = 0; i < s43Var.v(); i++) {
            j += (long) s43Var.j(i);
        }
        this.j = ll1.m(j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.vi1
    public boolean g() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: i()Ljava/util/Set; */
    @Override // defpackage.kw2
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public dj1 i() {
        dj1 dj1Var = this.k;
        if (dj1Var != null) {
            return dj1Var;
        }
        b bVar = new b();
        this.k = bVar;
        return bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bj1
    public kw2.a o(int i) {
        return this.i.f(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.AbstractCollection, java.util.Collection, defpackage.kw2
    public int size() {
        return this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.kw2
    public int t(Object obj) {
        return this.i.e(obj);
    }
}
