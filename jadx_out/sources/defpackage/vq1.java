package defpackage;

import com.fongmi.android.tv.bean.Keep;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class vq1 extends fq1 {
    public final bu3 a;
    public final ft0 b = new a();
    public final et0 c = new b();
    public final et0 d = new c();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends ft0 {
        public a() {
        }

        @Override // defpackage.ft0
        public String b() {
            return "INSERT OR IGNORE INTO `Keep` (`key`,`siteName`,`vodName`,`vodPic`,`createTime`,`type`,`cid`) VALUES (?,?,?,?,?,?,?)";
        }

        @Override // defpackage.ft0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(ow3 ow3Var, Keep keep) {
            if (keep.getKey() == null) {
                ow3Var.e(1);
            } else {
                ow3Var.w(1, keep.getKey());
            }
            if (keep.getSiteName() == null) {
                ow3Var.e(2);
            } else {
                ow3Var.w(2, keep.getSiteName());
            }
            if (keep.getVodName() == null) {
                ow3Var.e(3);
            } else {
                ow3Var.w(3, keep.getVodName());
            }
            if (keep.getVodPic() == null) {
                ow3Var.e(4);
            } else {
                ow3Var.w(4, keep.getVodPic());
            }
            ow3Var.d(5, keep.getCreateTime());
            ow3Var.d(6, keep.getType());
            ow3Var.d(7, keep.getCid());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends et0 {
        public b() {
        }

        @Override // defpackage.et0
        public String b() {
            return "UPDATE OR REPLACE `Keep` SET `key` = ?,`siteName` = ?,`vodName` = ?,`vodPic` = ?,`createTime` = ?,`type` = ?,`cid` = ? WHERE `key` = ?";
        }

        @Override // defpackage.et0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(ow3 ow3Var, Keep keep) {
            if (keep.getKey() == null) {
                ow3Var.e(1);
            } else {
                ow3Var.w(1, keep.getKey());
            }
            if (keep.getSiteName() == null) {
                ow3Var.e(2);
            } else {
                ow3Var.w(2, keep.getSiteName());
            }
            if (keep.getVodName() == null) {
                ow3Var.e(3);
            } else {
                ow3Var.w(3, keep.getVodName());
            }
            if (keep.getVodPic() == null) {
                ow3Var.e(4);
            } else {
                ow3Var.w(4, keep.getVodPic());
            }
            ow3Var.d(5, keep.getCreateTime());
            ow3Var.d(6, keep.getType());
            ow3Var.d(7, keep.getCid());
            if (keep.getKey() == null) {
                ow3Var.e(8);
            } else {
                ow3Var.w(8, keep.getKey());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends et0 {
        public c() {
        }

        @Override // defpackage.et0
        public String b() {
            return "UPDATE OR ABORT `Keep` SET `key` = ?,`siteName` = ?,`vodName` = ?,`vodPic` = ?,`createTime` = ?,`type` = ?,`cid` = ? WHERE `key` = ?";
        }

        @Override // defpackage.et0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(ow3 ow3Var, Keep keep) {
            if (keep.getKey() == null) {
                ow3Var.e(1);
            } else {
                ow3Var.w(1, keep.getKey());
            }
            if (keep.getSiteName() == null) {
                ow3Var.e(2);
            } else {
                ow3Var.w(2, keep.getSiteName());
            }
            if (keep.getVodName() == null) {
                ow3Var.e(3);
            } else {
                ow3Var.w(3, keep.getVodName());
            }
            if (keep.getVodPic() == null) {
                ow3Var.e(4);
            } else {
                ow3Var.w(4, keep.getVodPic());
            }
            ow3Var.d(5, keep.getCreateTime());
            ow3Var.d(6, keep.getType());
            ow3Var.d(7, keep.getCid());
            if (keep.getKey() == null) {
                ow3Var.e(8);
            } else {
                ow3Var.w(8, keep.getKey());
            }
        }
    }

    public vq1(bu3 bu3Var) {
        this.a = bu3Var;
    }

    public static /* synthetic */ Object B(int i, String str, lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("DELETE FROM Keep WHERE type = 0 AND cid = ? AND `key` = ?");
        try {
            ow3VarA0.d(1, i);
            if (str == null) {
                ow3VarA0.e(2);
            } else {
                ow3VarA0.w(2, str);
            }
            ow3VarA0.Y();
            ow3VarA0.close();
            return null;
        } catch (Throwable th) {
            ow3VarA0.close();
            throw th;
        }
    }

    public static /* synthetic */ Keep C(String str, lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("SELECT * FROM Keep WHERE type = 1 AND `key` = ?");
        try {
            if (str == null) {
                ow3VarA0.e(1);
            } else {
                ow3VarA0.w(1, str);
            }
            int iC = pw3.c(ow3VarA0, "key");
            int iC2 = pw3.c(ow3VarA0, "siteName");
            int iC3 = pw3.c(ow3VarA0, "vodName");
            int iC4 = pw3.c(ow3VarA0, "vodPic");
            int iC5 = pw3.c(ow3VarA0, "createTime");
            int iC6 = pw3.c(ow3VarA0, "type");
            int iC7 = pw3.c(ow3VarA0, "cid");
            Keep keep = null;
            String strI = null;
            if (ow3VarA0.Y()) {
                Keep keep2 = new Keep();
                keep2.setKey(ow3VarA0.isNull(iC) ? null : ow3VarA0.I(iC));
                keep2.setSiteName(ow3VarA0.isNull(iC2) ? null : ow3VarA0.I(iC2));
                keep2.setVodName(ow3VarA0.isNull(iC3) ? null : ow3VarA0.I(iC3));
                if (!ow3VarA0.isNull(iC4)) {
                    strI = ow3VarA0.I(iC4);
                }
                keep2.setVodPic(strI);
                keep2.setCreateTime(ow3VarA0.getLong(iC5));
                keep2.setType((int) ow3VarA0.getLong(iC6));
                keep2.setCid((int) ow3VarA0.getLong(iC7));
                keep = keep2;
            }
            ow3VarA0.close();
            return keep;
        } catch (Throwable th) {
            ow3VarA0.close();
            throw th;
        }
    }

    public static /* synthetic */ Keep D(int i, String str, lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("SELECT * FROM Keep WHERE type = 0 AND cid = ? AND `key` = ?");
        try {
            ow3VarA0.d(1, i);
            if (str == null) {
                ow3VarA0.e(2);
            } else {
                ow3VarA0.w(2, str);
            }
            int iC = pw3.c(ow3VarA0, "key");
            int iC2 = pw3.c(ow3VarA0, "siteName");
            int iC3 = pw3.c(ow3VarA0, "vodName");
            int iC4 = pw3.c(ow3VarA0, "vodPic");
            int iC5 = pw3.c(ow3VarA0, "createTime");
            int iC6 = pw3.c(ow3VarA0, "type");
            int iC7 = pw3.c(ow3VarA0, "cid");
            Keep keep = null;
            String strI = null;
            if (ow3VarA0.Y()) {
                Keep keep2 = new Keep();
                keep2.setKey(ow3VarA0.isNull(iC) ? null : ow3VarA0.I(iC));
                keep2.setSiteName(ow3VarA0.isNull(iC2) ? null : ow3VarA0.I(iC2));
                keep2.setVodName(ow3VarA0.isNull(iC3) ? null : ow3VarA0.I(iC3));
                if (!ow3VarA0.isNull(iC4)) {
                    strI = ow3VarA0.I(iC4);
                }
                keep2.setVodPic(strI);
                keep2.setCreateTime(ow3VarA0.getLong(iC5));
                keep2.setType((int) ow3VarA0.getLong(iC6));
                keep2.setCid((int) ow3VarA0.getLong(iC7));
                keep = keep2;
            }
            ow3VarA0.close();
            return keep;
        } catch (Throwable th) {
            ow3VarA0.close();
            throw th;
        }
    }

    public static List G() {
        return Collections.EMPTY_LIST;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List K(List list, lw3 lw3Var) {
        return this.b.d(lw3Var, list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ fw4 M(List list, lw3 lw3Var) {
        super.d(list);
        return fw4.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object O(List list, lw3 lw3Var) throws Exception {
        this.d.d(lw3Var, list);
        return null;
    }

    public static /* synthetic */ Object p(lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("DELETE FROM Keep WHERE type = 0");
        try {
            ow3VarA0.Y();
            ow3VarA0.close();
            return null;
        } catch (Throwable th) {
            ow3VarA0.close();
            throw th;
        }
    }

    public static /* synthetic */ Object s(String str, lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("DELETE FROM Keep WHERE type = 1 AND `key` = ?");
        try {
            if (str == null) {
                ow3VarA0.e(1);
            } else {
                ow3VarA0.w(1, str);
            }
            ow3VarA0.Y();
            ow3VarA0.close();
            return null;
        } catch (Throwable th) {
            ow3VarA0.close();
            throw th;
        }
    }

    public static /* synthetic */ List t(lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("SELECT * FROM Keep WHERE type = 1 ORDER BY createTime DESC");
        try {
            int iC = pw3.c(ow3VarA0, "key");
            int iC2 = pw3.c(ow3VarA0, "siteName");
            int iC3 = pw3.c(ow3VarA0, "vodName");
            int iC4 = pw3.c(ow3VarA0, "vodPic");
            int iC5 = pw3.c(ow3VarA0, "createTime");
            int iC6 = pw3.c(ow3VarA0, "type");
            int iC7 = pw3.c(ow3VarA0, "cid");
            ArrayList arrayList = new ArrayList();
            while (ow3VarA0.Y()) {
                Keep keep = new Keep();
                String strI = null;
                keep.setKey(ow3VarA0.isNull(iC) ? null : ow3VarA0.I(iC));
                keep.setSiteName(ow3VarA0.isNull(iC2) ? null : ow3VarA0.I(iC2));
                keep.setVodName(ow3VarA0.isNull(iC3) ? null : ow3VarA0.I(iC3));
                if (!ow3VarA0.isNull(iC4)) {
                    strI = ow3VarA0.I(iC4);
                }
                keep.setVodPic(strI);
                keep.setCreateTime(ow3VarA0.getLong(iC5));
                keep.setType((int) ow3VarA0.getLong(iC6));
                keep.setCid((int) ow3VarA0.getLong(iC7));
                arrayList.add(keep);
            }
            return arrayList;
        } finally {
            ow3VarA0.close();
        }
    }

    public static /* synthetic */ List v(lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("SELECT * FROM Keep WHERE type = 0 ORDER BY createTime DESC");
        try {
            int iC = pw3.c(ow3VarA0, "key");
            int iC2 = pw3.c(ow3VarA0, "siteName");
            int iC3 = pw3.c(ow3VarA0, "vodName");
            int iC4 = pw3.c(ow3VarA0, "vodPic");
            int iC5 = pw3.c(ow3VarA0, "createTime");
            int iC6 = pw3.c(ow3VarA0, "type");
            int iC7 = pw3.c(ow3VarA0, "cid");
            ArrayList arrayList = new ArrayList();
            while (ow3VarA0.Y()) {
                Keep keep = new Keep();
                String strI = null;
                keep.setKey(ow3VarA0.isNull(iC) ? null : ow3VarA0.I(iC));
                keep.setSiteName(ow3VarA0.isNull(iC2) ? null : ow3VarA0.I(iC2));
                keep.setVodName(ow3VarA0.isNull(iC3) ? null : ow3VarA0.I(iC3));
                if (!ow3VarA0.isNull(iC4)) {
                    strI = ow3VarA0.I(iC4);
                }
                keep.setVodPic(strI);
                keep.setCreateTime(ow3VarA0.getLong(iC5));
                keep.setType((int) ow3VarA0.getLong(iC6));
                keep.setCid((int) ow3VarA0.getLong(iC7));
                arrayList.add(keep);
            }
            return arrayList;
        } finally {
            ow3VarA0.close();
        }
    }

    public static /* synthetic */ Object x(int i, lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("DELETE FROM Keep WHERE type = 0 AND cid = ?");
        try {
            ow3VarA0.d(1, i);
            ow3VarA0.Y();
            ow3VarA0.close();
            return null;
        } catch (Throwable th) {
            ow3VarA0.close();
            throw th;
        }
    }

    public static /* synthetic */ List y(lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("SELECT * FROM Keep");
        try {
            int iC = pw3.c(ow3VarA0, "key");
            int iC2 = pw3.c(ow3VarA0, "siteName");
            int iC3 = pw3.c(ow3VarA0, "vodName");
            int iC4 = pw3.c(ow3VarA0, "vodPic");
            int iC5 = pw3.c(ow3VarA0, "createTime");
            int iC6 = pw3.c(ow3VarA0, "type");
            int iC7 = pw3.c(ow3VarA0, "cid");
            ArrayList arrayList = new ArrayList();
            while (ow3VarA0.Y()) {
                Keep keep = new Keep();
                String strI = null;
                keep.setKey(ow3VarA0.isNull(iC) ? null : ow3VarA0.I(iC));
                keep.setSiteName(ow3VarA0.isNull(iC2) ? null : ow3VarA0.I(iC2));
                keep.setVodName(ow3VarA0.isNull(iC3) ? null : ow3VarA0.I(iC3));
                if (!ow3VarA0.isNull(iC4)) {
                    strI = ow3VarA0.I(iC4);
                }
                keep.setVodPic(strI);
                keep.setCreateTime(ow3VarA0.getLong(iC5));
                keep.setType((int) ow3VarA0.getLong(iC6));
                keep.setCid((int) ow3VarA0.getLong(iC7));
                arrayList.add(keep);
            }
            return arrayList;
        } finally {
            ow3VarA0.close();
        }
    }

    @Override // defpackage.kh
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public Long a(final Keep keep) {
        return (Long) j70.b(this.a, false, true, new Function1() { // from class: kq1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.J(keep, (lw3) obj);
            }
        });
    }

    @Override // defpackage.kh
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public void c(final Keep keep) {
        j70.b(this.a, false, true, new Function1() { // from class: uq1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.L(keep, (lw3) obj);
            }
        });
    }

    public final /* synthetic */ Long J(Keep keep, lw3 lw3Var) {
        return Long.valueOf(this.b.c(lw3Var, keep));
    }

    public final /* synthetic */ fw4 L(Keep keep, lw3 lw3Var) {
        super.c(keep);
        return fw4.a;
    }

    public final /* synthetic */ Object N(Keep keep, lw3 lw3Var) throws Exception {
        this.c.c(lw3Var, keep);
        return null;
    }

    @Override // defpackage.kh
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public void e(final Keep keep) {
        j70.b(this.a, false, true, new Function1() { // from class: iq1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.N(keep, (lw3) obj);
            }
        });
    }

    @Override // defpackage.kh
    public List b(final List list) {
        return (List) j70.b(this.a, false, true, new Function1() { // from class: lq1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.K(list, (lw3) obj);
            }
        });
    }

    @Override // defpackage.kh
    public void d(final List list) {
        j70.b(this.a, false, true, new Function1() { // from class: tq1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.M(list, (lw3) obj);
            }
        });
    }

    @Override // defpackage.kh
    public void f(final List list) {
        j70.b(this.a, false, true, new Function1() { // from class: jq1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.O(list, (lw3) obj);
            }
        });
    }

    @Override // defpackage.fq1
    public void g() {
        j70.b(this.a, false, true, new Function1() { // from class: gq1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return vq1.p((lw3) obj);
            }
        });
    }

    @Override // defpackage.fq1
    public void h(final int i) {
        j70.b(this.a, false, true, new Function1() { // from class: sq1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return vq1.x(i, (lw3) obj);
            }
        });
    }

    @Override // defpackage.fq1
    public void i(final int i, final String str) {
        j70.b(this.a, false, true, new Function1() { // from class: rq1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return vq1.B(i, str, (lw3) obj);
            }
        });
    }

    @Override // defpackage.fq1
    public void j(final String str) {
        j70.b(this.a, false, true, new Function1() { // from class: hq1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return vq1.s(str, (lw3) obj);
            }
        });
    }

    @Override // defpackage.fq1
    public Keep k(final int i, final String str) {
        return (Keep) j70.b(this.a, true, false, new Function1() { // from class: oq1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return vq1.D(i, str, (lw3) obj);
            }
        });
    }

    @Override // defpackage.fq1
    public Keep l(final String str) {
        return (Keep) j70.b(this.a, true, false, new Function1() { // from class: qq1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return vq1.C(str, (lw3) obj);
            }
        });
    }

    @Override // defpackage.fq1
    public List m() {
        return (List) j70.b(this.a, true, false, new Function1() { // from class: mq1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return vq1.y((lw3) obj);
            }
        });
    }

    @Override // defpackage.fq1
    public List n() {
        return (List) j70.b(this.a, true, false, new Function1() { // from class: pq1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return vq1.t((lw3) obj);
            }
        });
    }

    @Override // defpackage.fq1
    public List o() {
        return (List) j70.b(this.a, true, false, new Function1() { // from class: nq1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return vq1.v((lw3) obj);
            }
        });
    }
}
