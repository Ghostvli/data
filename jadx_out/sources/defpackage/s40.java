package defpackage;

import defpackage.g40;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class s40 extends x {
    public static final a h = new a(null);
    public final String g;

    public s40(String str) {
        super(h);
        this.g = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof s40) && il1.a(this.g, ((s40) obj).g);
    }

    public int hashCode() {
        return this.g.hashCode();
    }

    public String toString() {
        return "CoroutineName(" + this.g + ')';
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements g40.c {
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        public a() {
        }
    }
}
