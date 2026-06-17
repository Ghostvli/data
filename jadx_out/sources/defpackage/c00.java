package defpackage;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class c00 extends to3 {
    public final a a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum a {
        COMMON,
        VOD,
        LIVE,
        WALL,
        BOOT
    }

    public c00(a aVar) {
        this.a = aVar;
    }

    private /* synthetic */ boolean a(Object obj) {
        return (obj instanceof c00) && Objects.equals(this.a, ((c00) obj).a);
    }

    private /* synthetic */ Object[] b() {
        return new Object[]{this.a};
    }

    public static void c() {
        uu0.d().l(new c00(a.BOOT));
        q24.S(false);
    }

    public static void d() {
        uu0.d().l(new c00(a.COMMON));
    }

    public static void g() {
        uu0.d().l(new c00(a.LIVE));
    }

    public static void i() {
        uu0.d().l(new c00(a.VOD));
    }

    public static void j() {
        uu0.d().l(new c00(a.WALL));
    }

    public boolean e() {
        return this.a == a.LIVE;
    }

    public final boolean equals(Object obj) {
        return a(obj);
    }

    public boolean f() {
        return this.a == a.VOD;
    }

    public a h() {
        return this.a;
    }

    public final int hashCode() {
        return Objects.hashCode(this.a);
    }

    public final String toString() {
        return yq.a(b(), c00.class, "a");
    }
}
