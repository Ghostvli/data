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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public qp3(a aVar, String str) {
        this.a = aVar;
        this.b = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void a() {
        uu0.d().l(new qp3(a.CATEGORY));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void b(String str) {
        uu0.d().l(new qp3(a.DANMAKU, str));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void c() {
        uu0.d().l(new qp3(a.DETAIL));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void g() {
        uu0.d().l(new qp3(a.HISTORY));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void h() {
        uu0.d().l(new qp3(a.HOME));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void i() {
        uu0.d().l(new qp3(a.KEEP));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void j() {
        uu0.d().l(new qp3(a.LIVE));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void k() {
        uu0.d().l(new qp3(a.PLAYER));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void l() {
        uu0.d().l(new qp3(a.SIZE));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void m(String str) {
        uu0.d().l(new qp3(a.SUBTITLE, str));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void n(Vod vod) {
        uu0.d().l(new qp3(a.VOD, vod));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String d() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public a e() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
