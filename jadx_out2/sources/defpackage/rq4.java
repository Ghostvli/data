package defpackage;

import com.fongmi.android.tv.bean.Track;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function1;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class rq4 extends kq4 {
    public final bu3 a;
    public final ft0 b = new a();
    public final ft0 c = new b();
    public final et0 d = new c();
    public final et0 e = new d();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends ft0 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ft0
        public String b() {
            return "INSERT OR IGNORE INTO `Track` (`id`,`type`,`key`,`name`,`format`,`selected`) VALUES (nullif(?, 0),?,?,?,?,?)";
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Low3;Ljava/lang/Object;)V */
        @Override // defpackage.ft0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(ow3 ow3Var, Track track) {
            ow3Var.d(1, track.getId());
            ow3Var.d(2, track.getType());
            if (track.getKey() == null) {
                ow3Var.e(3);
            } else {
                ow3Var.w(3, track.getKey());
            }
            if (track.getName() == null) {
                ow3Var.e(4);
            } else {
                ow3Var.w(4, track.getName());
            }
            if (track.getFormat() == null) {
                ow3Var.e(5);
            } else {
                ow3Var.w(5, track.getFormat());
            }
            ow3Var.d(6, track.isSelected() ? 1L : 0L);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends ft0 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ft0
        public String b() {
            return "INSERT OR REPLACE INTO `Track` (`id`,`type`,`key`,`name`,`format`,`selected`) VALUES (nullif(?, 0),?,?,?,?,?)";
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Low3;Ljava/lang/Object;)V */
        @Override // defpackage.ft0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(ow3 ow3Var, Track track) {
            ow3Var.d(1, track.getId());
            ow3Var.d(2, track.getType());
            if (track.getKey() == null) {
                ow3Var.e(3);
            } else {
                ow3Var.w(3, track.getKey());
            }
            if (track.getName() == null) {
                ow3Var.e(4);
            } else {
                ow3Var.w(4, track.getName());
            }
            if (track.getFormat() == null) {
                ow3Var.e(5);
            } else {
                ow3Var.w(5, track.getFormat());
            }
            ow3Var.d(6, track.isSelected() ? 1L : 0L);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends et0 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.et0
        public String b() {
            return "UPDATE OR REPLACE `Track` SET `id` = ?,`type` = ?,`key` = ?,`name` = ?,`format` = ?,`selected` = ? WHERE `id` = ?";
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Low3;Ljava/lang/Object;)V */
        @Override // defpackage.et0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(ow3 ow3Var, Track track) {
            ow3Var.d(1, track.getId());
            ow3Var.d(2, track.getType());
            if (track.getKey() == null) {
                ow3Var.e(3);
            } else {
                ow3Var.w(3, track.getKey());
            }
            if (track.getName() == null) {
                ow3Var.e(4);
            } else {
                ow3Var.w(4, track.getName());
            }
            if (track.getFormat() == null) {
                ow3Var.e(5);
            } else {
                ow3Var.w(5, track.getFormat());
            }
            ow3Var.d(6, track.isSelected() ? 1L : 0L);
            ow3Var.d(7, track.getId());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d extends et0 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.et0
        public String b() {
            return "UPDATE OR ABORT `Track` SET `id` = ?,`type` = ?,`key` = ?,`name` = ?,`format` = ?,`selected` = ? WHERE `id` = ?";
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Low3;Ljava/lang/Object;)V */
        @Override // defpackage.et0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(ow3 ow3Var, Track track) {
            ow3Var.d(1, track.getId());
            ow3Var.d(2, track.getType());
            if (track.getKey() == null) {
                ow3Var.e(3);
            } else {
                ow3Var.w(3, track.getKey());
            }
            if (track.getName() == null) {
                ow3Var.e(4);
            } else {
                ow3Var.w(4, track.getName());
            }
            if (track.getFormat() == null) {
                ow3Var.e(5);
            } else {
                ow3Var.w(5, track.getFormat());
            }
            ow3Var.d(6, track.isSelected() ? 1L : 0L);
            ow3Var.d(7, track.getId());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public rq4(bu3 bu3Var) {
        this.a = bu3Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ List k(String str, lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("SELECT * FROM Track WHERE `key` = ?");
        try {
            if (str == null) {
                ow3VarA0.e(1);
            } else {
                ow3VarA0.w(1, str);
            }
            int iC = pw3.c(ow3VarA0, Name.MARK);
            int iC2 = pw3.c(ow3VarA0, "type");
            int iC3 = pw3.c(ow3VarA0, "key");
            int iC4 = pw3.c(ow3VarA0, "name");
            int iC5 = pw3.c(ow3VarA0, "format");
            int iC6 = pw3.c(ow3VarA0, "selected");
            ArrayList arrayList = new ArrayList();
            while (ow3VarA0.Y()) {
                String strI = null;
                Track track = new Track((int) ow3VarA0.getLong(iC2), ow3VarA0.isNull(iC4) ? null : ow3VarA0.I(iC4), ow3VarA0.isNull(iC5) ? null : ow3VarA0.I(iC5));
                track.setId((int) ow3VarA0.getLong(iC));
                if (!ow3VarA0.isNull(iC3)) {
                    strI = ow3VarA0.I(iC3);
                }
                track.setKey(strI);
                track.setSelected(((int) ow3VarA0.getLong(iC6)) != 0);
                arrayList.add(track);
            }
            ow3VarA0.close();
            return arrayList;
        } catch (Throwable th) {
            ow3VarA0.close();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Object l(String str, lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("DELETE FROM Track WHERE `key` = ?");
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List p() {
        return Collections.EMPTY_LIST;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object t(List list, lw3 lw3Var) throws Exception {
        this.e.d(lw3Var, list);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.kh
    public List b(final List list) {
        return (List) j70.b(this.a, false, true, new Function1() { // from class: oq4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.q(list, (lw3) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.kh
    public void f(final List list) {
        j70.b(this.a, false, true, new Function1() { // from class: qq4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.t(list, (lw3) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.kq4
    public void g(final String str) {
        j70.b(this.a, false, true, new Function1() { // from class: mq4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return rq4.l(str, (lw3) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.kq4
    public List h(final String str) {
        return (List) j70.b(this.a, true, false, new Function1() { // from class: lq4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return rq4.k(str, (lw3) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)Ljava/lang/Long; */
    @Override // defpackage.kh
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public Long a(final Track track) {
        return (Long) j70.b(this.a, false, true, new Function1() { // from class: nq4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.r(track, (lw3) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ List q(List list, lw3 lw3Var) {
        return this.b.d(lw3Var, list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ Long r(Track track, lw3 lw3Var) {
        return Long.valueOf(this.c.c(lw3Var, track));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ Object s(Track track, lw3 lw3Var) throws Exception {
        this.d.c(lw3Var, track);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: e(Ljava/lang/Object;)V */
    @Override // defpackage.kh
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public void e(final Track track) {
        j70.b(this.a, false, true, new Function1() { // from class: pq4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.s(track, (lw3) obj);
            }
        });
    }
}
