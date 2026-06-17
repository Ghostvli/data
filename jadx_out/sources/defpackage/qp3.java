package defpackage;

import com.fongmi.android.tv.bean.Vod;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class qp3 {
    public final a a;
    public String b;
    public Vod c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum a {
        HOME,
        CATEGORY,
        HISTORY,
        KEEP,
        SIZE,
        LIVE,
        DETAIL,
        PLAYER,
        SUBTITLE,
        DANMAKU,
        VOD,
        FILTER
    }

    public qp3(a aVar, String str) {
        this.a = aVar;
        this.b = str;
    }

    public static void a() {
        uu0.d().l(new qp3(a.CATEGORY));
    }

    public static void b(String str) {
        uu0.d().l(new qp3(a.DANMAKU, str));
    }

    public static void c() {
        uu0.d().l(new qp3(a.DETAIL));
    }

    public static void g() {
        uu0.d().l(new qp3(a.HISTORY));
    }

    public static void h() {
        uu0.d().l(new qp3(a.HOME));
    }

    public static void i() {
        uu0.d().l(new qp3(a.KEEP));
    }

    public static void j() {
        uu0.d().l(new qp3(a.LIVE));
    }

    public static void k() {
        uu0.d().l(new qp3(a.PLAYER));
    }

    public static void l() {
        uu0.d().l(new qp3(a.SIZE));
    }

    public static void m(String str) {
        uu0.d().l(new qp3(a.SUBTITLE, str));
    }

    public static void n(Vod vod) {
        uu0.d().l(new qp3(a.VOD, vod));
    }

    public String d() {
        return this.b;
    }

    public a e() {
        return this.a;
    }

    public Vod f() {
        return this.c;
    }

    public qp3(a aVar) {
        this.a = aVar;
    }

    public qp3(a aVar, Vod vod) {
        this.a = aVar;
        this.c = vod;
    }
}
