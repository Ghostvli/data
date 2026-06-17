package okhttp3.internal;

import defpackage.hp1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class EmptyTags extends Tags {
    public static final EmptyTags INSTANCE = new EmptyTags();

    private EmptyTags() {
        super(null);
    }

    @Override // okhttp3.internal.Tags
    public <T> T get(hp1 hp1Var) {
        hp1Var.getClass();
        return null;
    }

    @Override // okhttp3.internal.Tags
    public <T> Tags plus(hp1 hp1Var, T t) {
        hp1Var.getClass();
        return t != null ? new LinkedTags(hp1Var, t, this) : this;
    }

    public String toString() {
        return "{}";
    }
}
