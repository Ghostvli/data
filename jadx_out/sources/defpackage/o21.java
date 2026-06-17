package defpackage;

import android.util.SparseBooleanArray;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class o21 {
    public final SparseBooleanArray a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final SparseBooleanArray a = new SparseBooleanArray();
        public boolean b;

        public b a(int i) {
            gg3.v(!this.b);
            this.a.append(i, true);
            return this;
        }

        public b b(o21 o21Var) {
            for (int i = 0; i < o21Var.d(); i++) {
                a(o21Var.c(i));
            }
            return this;
        }

        public b c(int... iArr) {
            for (int i : iArr) {
                a(i);
            }
            return this;
        }

        public b d(int i, boolean z) {
            return z ? a(i) : this;
        }

        public o21 e() {
            gg3.v(!this.b);
            this.b = true;
            return new o21(this.a);
        }

        public b f(int i) {
            gg3.v(!this.b);
            this.a.delete(i);
            return this;
        }

        public b g(int i, boolean z) {
            return z ? f(i) : this;
        }
    }

    public o21(SparseBooleanArray sparseBooleanArray) {
        this.a = sparseBooleanArray;
    }

    public boolean a(int i) {
        return this.a.get(i);
    }

    public boolean b(int... iArr) {
        for (int i : iArr) {
            if (a(i)) {
                return true;
            }
        }
        return false;
    }

    public int c(int i) {
        gg3.o(i, d());
        return this.a.keyAt(i);
    }

    public int d() {
        return this.a.size();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o21) {
            return this.a.equals(((o21) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}
