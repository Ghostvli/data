package defpackage;

import java.util.concurrent.TimeUnit;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class xp0 {
    public static final xp0 g = new xp0("NANOSECONDS", 0, TimeUnit.NANOSECONDS);
    public static final xp0 h = new xp0("MICROSECONDS", 1, TimeUnit.MICROSECONDS);
    public static final xp0 i = new xp0("MILLISECONDS", 2, TimeUnit.MILLISECONDS);
    public static final xp0 j = new xp0("SECONDS", 3, TimeUnit.SECONDS);
    public static final xp0 k = new xp0("MINUTES", 4, TimeUnit.MINUTES);
    public static final xp0 l = new xp0("HOURS", 5, TimeUnit.HOURS);
    public static final xp0 m = new xp0("DAYS", 6, TimeUnit.DAYS);
    public static final /* synthetic */ xp0[] n;
    public static final /* synthetic */ gt0 o;
    public final TimeUnit f;

    static {
        xp0[] xp0VarArrA = a();
        n = xp0VarArrA;
        o = ht0.a(xp0VarArrA);
    }

    public xp0(String str, int i2, TimeUnit timeUnit) {
        this.f = timeUnit;
    }

    public static final /* synthetic */ xp0[] a() {
        return new xp0[]{g, h, i, j, k, l, m};
    }

    public static xp0 valueOf(String str) {
        return (xp0) Enum.valueOf(xp0.class, str);
    }

    public static xp0[] values() {
        return (xp0[]) n.clone();
    }

    public final TimeUnit b() {
        return this.f;
    }
}
