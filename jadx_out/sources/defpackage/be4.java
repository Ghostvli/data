package defpackage;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class be4 extends to3 {
    public final a a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum a {
        EMPTY,
        PROGRESS,
        CONTENT
    }

    public be4(a aVar) {
        this.a = aVar;
    }

    private /* synthetic */ boolean a(Object obj) {
        return (obj instanceof be4) && Objects.equals(this.a, ((be4) obj).a);
    }

    private /* synthetic */ Object[] b() {
        return new Object[]{this.a};
    }

    public static void c() {
        uu0.d().l(new be4(a.EMPTY));
    }

    public a d() {
        return this.a;
    }

    public final boolean equals(Object obj) {
        return a(obj);
    }

    public final int hashCode() {
        return Objects.hashCode(this.a);
    }

    public final String toString() {
        return yq.a(b(), be4.class, "a");
    }
}
