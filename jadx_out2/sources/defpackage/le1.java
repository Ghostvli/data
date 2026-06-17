package defpackage;

import com.fongmi.android.tv.bean.History;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class le1 extends yd1 {
    public final bu3 a;
    public final ft0 b = new a();
    public final et0 c = new b();
    public final et0 d = new c();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends ft0 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.ft0
        public String b() {
            return "INSERT OR IGNORE INTO `History` (`key`,`vodPic`,`vodName`,`vodFlag`,`vodRemarks`,`episodeUrl`,`revSort`,`revPlay`,`createTime`,`opening`,`ending`,`position`,`duration`,`speed`,`scale`,`cid`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Low3;Ljava/lang/Object;)V */
        @Override // defpackage.ft0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(ow3 ow3Var, History history) {
            if (history.getKey() == null) {
                ow3Var.e(1);
            } else {
                ow3Var.w(1, history.getKey());
            }
            if (history.getVodPic() == null) {
                ow3Var.e(2);
            } else {
                ow3Var.w(2, history.getVodPic());
            }
            if (history.getVodName() == null) {
                ow3Var.e(3);
            } else {
                ow3Var.w(3, history.getVodName());
            }
            if (history.getVodFlag() == null) {
                ow3Var.e(4);
            } else {
                ow3Var.w(4, history.getVodFlag());
            }
            if (history.getVodRemarks() == null) {
                ow3Var.e(5);
            } else {
                ow3Var.w(5, history.getVodRemarks());
            }
            if (history.getEpisodeUrl() == null) {
                ow3Var.e(6);
            } else {
                ow3Var.w(6, history.getEpisodeUrl());
            }
            ow3Var.d(7, history.isRevSort() ? 1L : 0L);
            ow3Var.d(8, history.isRevPlay() ? 1L : 0L);
            ow3Var.d(9, history.getCreateTime());
            ow3Var.d(10, history.getOpening());
            ow3Var.d(11, history.getEnding());
            ow3Var.d(12, history.getPosition());
            ow3Var.d(13, history.getDuration());
            ow3Var.b(14, history.getSpeed());
            ow3Var.d(15, history.getScale());
            ow3Var.d(16, history.getCid());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends et0 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.et0
        public String b() {
            return "UPDATE OR REPLACE `History` SET `key` = ?,`vodPic` = ?,`vodName` = ?,`vodFlag` = ?,`vodRemarks` = ?,`episodeUrl` = ?,`revSort` = ?,`revPlay` = ?,`createTime` = ?,`opening` = ?,`ending` = ?,`position` = ?,`duration` = ?,`speed` = ?,`scale` = ?,`cid` = ? WHERE `key` = ?";
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Low3;Ljava/lang/Object;)V */
        @Override // defpackage.et0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(ow3 ow3Var, History history) {
            if (history.getKey() == null) {
                ow3Var.e(1);
            } else {
                ow3Var.w(1, history.getKey());
            }
            if (history.getVodPic() == null) {
                ow3Var.e(2);
            } else {
                ow3Var.w(2, history.getVodPic());
            }
            if (history.getVodName() == null) {
                ow3Var.e(3);
            } else {
                ow3Var.w(3, history.getVodName());
            }
            if (history.getVodFlag() == null) {
                ow3Var.e(4);
            } else {
                ow3Var.w(4, history.getVodFlag());
            }
            if (history.getVodRemarks() == null) {
                ow3Var.e(5);
            } else {
                ow3Var.w(5, history.getVodRemarks());
            }
            if (history.getEpisodeUrl() == null) {
                ow3Var.e(6);
            } else {
                ow3Var.w(6, history.getEpisodeUrl());
            }
            ow3Var.d(7, history.isRevSort() ? 1L : 0L);
            ow3Var.d(8, history.isRevPlay() ? 1L : 0L);
            ow3Var.d(9, history.getCreateTime());
            ow3Var.d(10, history.getOpening());
            ow3Var.d(11, history.getEnding());
            ow3Var.d(12, history.getPosition());
            ow3Var.d(13, history.getDuration());
            ow3Var.b(14, history.getSpeed());
            ow3Var.d(15, history.getScale());
            ow3Var.d(16, history.getCid());
            if (history.getKey() == null) {
                ow3Var.e(17);
            } else {
                ow3Var.w(17, history.getKey());
            }
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
            return "UPDATE OR ABORT `History` SET `key` = ?,`vodPic` = ?,`vodName` = ?,`vodFlag` = ?,`vodRemarks` = ?,`episodeUrl` = ?,`revSort` = ?,`revPlay` = ?,`createTime` = ?,`opening` = ?,`ending` = ?,`position` = ?,`duration` = ?,`speed` = ?,`scale` = ?,`cid` = ? WHERE `key` = ?";
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Low3;Ljava/lang/Object;)V */
        @Override // defpackage.et0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void a(ow3 ow3Var, History history) {
            if (history.getKey() == null) {
                ow3Var.e(1);
            } else {
                ow3Var.w(1, history.getKey());
            }
            if (history.getVodPic() == null) {
                ow3Var.e(2);
            } else {
                ow3Var.w(2, history.getVodPic());
            }
            if (history.getVodName() == null) {
                ow3Var.e(3);
            } else {
                ow3Var.w(3, history.getVodName());
            }
            if (history.getVodFlag() == null) {
                ow3Var.e(4);
            } else {
                ow3Var.w(4, history.getVodFlag());
            }
            if (history.getVodRemarks() == null) {
                ow3Var.e(5);
            } else {
                ow3Var.w(5, history.getVodRemarks());
            }
            if (history.getEpisodeUrl() == null) {
                ow3Var.e(6);
            } else {
                ow3Var.w(6, history.getEpisodeUrl());
            }
            ow3Var.d(7, history.isRevSort() ? 1L : 0L);
            ow3Var.d(8, history.isRevPlay() ? 1L : 0L);
            ow3Var.d(9, history.getCreateTime());
            ow3Var.d(10, history.getOpening());
            ow3Var.d(11, history.getEnding());
            ow3Var.d(12, history.getPosition());
            ow3Var.d(13, history.getDuration());
            ow3Var.b(14, history.getSpeed());
            ow3Var.d(15, history.getScale());
            ow3Var.d(16, history.getCid());
            if (history.getKey() == null) {
                ow3Var.e(17);
            } else {
                ow3Var.w(17, history.getKey());
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public le1(bu3 bu3Var) {
        this.a = bu3Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List A() {
        return Collections.EMPTY_LIST;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ List E(List list, lw3 lw3Var) {
        return this.b.d(lw3Var, list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ fw4 G(List list, lw3 lw3Var) {
        super.d(list);
        return fw4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Object I(List list, lw3 lw3Var) throws Exception {
        this.d.d(lw3Var, list);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ List m(lw3 lw3Var) {
        int i;
        String strI;
        ow3 ow3VarA0 = lw3Var.a0("SELECT * FROM History");
        try {
            int iC = pw3.c(ow3VarA0, "key");
            int iC2 = pw3.c(ow3VarA0, "vodPic");
            int iC3 = pw3.c(ow3VarA0, "vodName");
            int iC4 = pw3.c(ow3VarA0, "vodFlag");
            int iC5 = pw3.c(ow3VarA0, "vodRemarks");
            int iC6 = pw3.c(ow3VarA0, "episodeUrl");
            int iC7 = pw3.c(ow3VarA0, "revSort");
            int iC8 = pw3.c(ow3VarA0, "revPlay");
            int iC9 = pw3.c(ow3VarA0, "createTime");
            int iC10 = pw3.c(ow3VarA0, "opening");
            int iC11 = pw3.c(ow3VarA0, "ending");
            int iC12 = pw3.c(ow3VarA0, "position");
            int iC13 = pw3.c(ow3VarA0, "duration");
            int iC14 = pw3.c(ow3VarA0, "speed");
            int iC15 = pw3.c(ow3VarA0, "scale");
            int iC16 = pw3.c(ow3VarA0, "cid");
            ArrayList arrayList = new ArrayList();
            while (ow3VarA0.Y()) {
                ArrayList arrayList2 = arrayList;
                History history = new History();
                if (ow3VarA0.isNull(iC)) {
                    i = iC;
                    strI = null;
                } else {
                    i = iC;
                    strI = ow3VarA0.I(iC);
                }
                history.setKey(strI);
                history.setVodPic(ow3VarA0.isNull(iC2) ? null : ow3VarA0.I(iC2));
                history.setVodName(ow3VarA0.isNull(iC3) ? null : ow3VarA0.I(iC3));
                history.setVodFlag(ow3VarA0.isNull(iC4) ? null : ow3VarA0.I(iC4));
                history.setVodRemarks(ow3VarA0.isNull(iC5) ? null : ow3VarA0.I(iC5));
                history.setEpisodeUrl(ow3VarA0.isNull(iC6) ? null : ow3VarA0.I(iC6));
                int i2 = iC2;
                int i3 = iC3;
                history.setRevSort(((int) ow3VarA0.getLong(iC7)) != 0);
                int i4 = iC4;
                history.setRevPlay(((int) ow3VarA0.getLong(iC8)) != 0);
                history.setCreateTime(ow3VarA0.getLong(iC9));
                history.setOpening(ow3VarA0.getLong(iC10));
                history.setEnding(ow3VarA0.getLong(iC11));
                history.setPosition(ow3VarA0.getLong(iC12));
                history.setDuration(ow3VarA0.getLong(iC13));
                history.setSpeed((float) ow3VarA0.getDouble(iC14));
                int i5 = iC15;
                int i6 = iC5;
                history.setScale((int) ow3VarA0.getLong(i5));
                int i7 = iC16;
                history.setCid((int) ow3VarA0.getLong(i7));
                arrayList2.add(history);
                iC5 = i6;
                iC15 = i5;
                iC16 = i7;
                iC4 = i4;
                arrayList = arrayList2;
                iC3 = i3;
                iC2 = i2;
                iC = i;
            }
            return arrayList;
        } finally {
            ow3VarA0.close();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ List q(int i, long j, lw3 lw3Var) {
        int i2;
        String strI;
        ow3 ow3VarA0 = lw3Var.a0("SELECT * FROM History WHERE cid = ? AND createTime >= ? ORDER BY createTime DESC LIMIT 60");
        try {
            ow3VarA0.d(1, i);
            ow3VarA0.d(2, j);
            int iC = pw3.c(ow3VarA0, "key");
            int iC2 = pw3.c(ow3VarA0, "vodPic");
            int iC3 = pw3.c(ow3VarA0, "vodName");
            int iC4 = pw3.c(ow3VarA0, "vodFlag");
            int iC5 = pw3.c(ow3VarA0, "vodRemarks");
            int iC6 = pw3.c(ow3VarA0, "episodeUrl");
            int iC7 = pw3.c(ow3VarA0, "revSort");
            int iC8 = pw3.c(ow3VarA0, "revPlay");
            int iC9 = pw3.c(ow3VarA0, "createTime");
            int iC10 = pw3.c(ow3VarA0, "opening");
            int iC11 = pw3.c(ow3VarA0, "ending");
            int iC12 = pw3.c(ow3VarA0, "position");
            int iC13 = pw3.c(ow3VarA0, "duration");
            int iC14 = pw3.c(ow3VarA0, "speed");
            int iC15 = pw3.c(ow3VarA0, "scale");
            int iC16 = pw3.c(ow3VarA0, "cid");
            ArrayList arrayList = new ArrayList();
            while (ow3VarA0.Y()) {
                ArrayList arrayList2 = arrayList;
                History history = new History();
                if (ow3VarA0.isNull(iC)) {
                    i2 = iC;
                    strI = null;
                } else {
                    i2 = iC;
                    strI = ow3VarA0.I(iC);
                }
                history.setKey(strI);
                history.setVodPic(ow3VarA0.isNull(iC2) ? null : ow3VarA0.I(iC2));
                history.setVodName(ow3VarA0.isNull(iC3) ? null : ow3VarA0.I(iC3));
                history.setVodFlag(ow3VarA0.isNull(iC4) ? null : ow3VarA0.I(iC4));
                history.setVodRemarks(ow3VarA0.isNull(iC5) ? null : ow3VarA0.I(iC5));
                history.setEpisodeUrl(ow3VarA0.isNull(iC6) ? null : ow3VarA0.I(iC6));
                int i3 = iC2;
                history.setRevSort(((int) ow3VarA0.getLong(iC7)) != 0);
                int i4 = iC3;
                history.setRevPlay(((int) ow3VarA0.getLong(iC8)) != 0);
                history.setCreateTime(ow3VarA0.getLong(iC9));
                history.setOpening(ow3VarA0.getLong(iC10));
                history.setEnding(ow3VarA0.getLong(iC11));
                history.setPosition(ow3VarA0.getLong(iC12));
                history.setDuration(ow3VarA0.getLong(iC13));
                history.setSpeed((float) ow3VarA0.getDouble(iC14));
                int i5 = iC15;
                int i6 = iC4;
                history.setScale((int) ow3VarA0.getLong(i5));
                int i7 = iC16;
                history.setCid((int) ow3VarA0.getLong(i7));
                arrayList2.add(history);
                iC4 = i6;
                iC15 = i5;
                iC3 = i4;
                iC16 = i7;
                arrayList = arrayList2;
                iC2 = i3;
                iC = i2;
            }
            return arrayList;
        } finally {
            ow3VarA0.close();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Object r(int i, lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("DELETE FROM History WHERE cid = ?");
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ History s(int i, String str, lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("SELECT * FROM History WHERE cid = ? AND `key` = ?");
        try {
            ow3VarA0.d(1, i);
            if (str == null) {
                ow3VarA0.e(2);
            } else {
                ow3VarA0.w(2, str);
            }
            int iC = pw3.c(ow3VarA0, "key");
            int iC2 = pw3.c(ow3VarA0, "vodPic");
            int iC3 = pw3.c(ow3VarA0, "vodName");
            int iC4 = pw3.c(ow3VarA0, "vodFlag");
            int iC5 = pw3.c(ow3VarA0, "vodRemarks");
            int iC6 = pw3.c(ow3VarA0, "episodeUrl");
            int iC7 = pw3.c(ow3VarA0, "revSort");
            int iC8 = pw3.c(ow3VarA0, "revPlay");
            int iC9 = pw3.c(ow3VarA0, "createTime");
            int iC10 = pw3.c(ow3VarA0, "opening");
            int iC11 = pw3.c(ow3VarA0, "ending");
            int iC12 = pw3.c(ow3VarA0, "position");
            int iC13 = pw3.c(ow3VarA0, "duration");
            int iC14 = pw3.c(ow3VarA0, "speed");
            int iC15 = pw3.c(ow3VarA0, "scale");
            int iC16 = pw3.c(ow3VarA0, "cid");
            History history = null;
            if (ow3VarA0.Y()) {
                History history2 = new History();
                history2.setKey(ow3VarA0.isNull(iC) ? null : ow3VarA0.I(iC));
                history2.setVodPic(ow3VarA0.isNull(iC2) ? null : ow3VarA0.I(iC2));
                history2.setVodName(ow3VarA0.isNull(iC3) ? null : ow3VarA0.I(iC3));
                history2.setVodFlag(ow3VarA0.isNull(iC4) ? null : ow3VarA0.I(iC4));
                history2.setVodRemarks(ow3VarA0.isNull(iC5) ? null : ow3VarA0.I(iC5));
                history2.setEpisodeUrl(ow3VarA0.isNull(iC6) ? null : ow3VarA0.I(iC6));
                history2.setRevSort(((int) ow3VarA0.getLong(iC7)) != 0);
                history2.setRevPlay(((int) ow3VarA0.getLong(iC8)) != 0);
                history2.setCreateTime(ow3VarA0.getLong(iC9));
                history2.setOpening(ow3VarA0.getLong(iC10));
                history2.setEnding(ow3VarA0.getLong(iC11));
                history2.setPosition(ow3VarA0.getLong(iC12));
                history2.setDuration(ow3VarA0.getLong(iC13));
                history2.setSpeed((float) ow3VarA0.getDouble(iC14));
                history2.setScale((int) ow3VarA0.getLong(iC15));
                history2.setCid((int) ow3VarA0.getLong(iC16));
                history = history2;
            }
            ow3VarA0.close();
            return history;
        } catch (Throwable th) {
            ow3VarA0.close();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Object t(int i, String str, lw3 lw3Var) {
        ow3 ow3VarA0 = lw3Var.a0("DELETE FROM History WHERE cid = ? AND `key` = ?");
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ List x(int i, String str, lw3 lw3Var) {
        int i2;
        String strI;
        ow3 ow3VarA0 = lw3Var.a0("SELECT * FROM History WHERE cid = ? AND vodName = ? ORDER BY createTime DESC");
        try {
            ow3VarA0.d(1, i);
            if (str == null) {
                ow3VarA0.e(2);
            } else {
                ow3VarA0.w(2, str);
            }
            int iC = pw3.c(ow3VarA0, "key");
            int iC2 = pw3.c(ow3VarA0, "vodPic");
            int iC3 = pw3.c(ow3VarA0, "vodName");
            int iC4 = pw3.c(ow3VarA0, "vodFlag");
            int iC5 = pw3.c(ow3VarA0, "vodRemarks");
            int iC6 = pw3.c(ow3VarA0, "episodeUrl");
            int iC7 = pw3.c(ow3VarA0, "revSort");
            int iC8 = pw3.c(ow3VarA0, "revPlay");
            int iC9 = pw3.c(ow3VarA0, "createTime");
            int iC10 = pw3.c(ow3VarA0, "opening");
            int iC11 = pw3.c(ow3VarA0, "ending");
            int iC12 = pw3.c(ow3VarA0, "position");
            int iC13 = pw3.c(ow3VarA0, "duration");
            int iC14 = pw3.c(ow3VarA0, "speed");
            int iC15 = pw3.c(ow3VarA0, "scale");
            int iC16 = pw3.c(ow3VarA0, "cid");
            ArrayList arrayList = new ArrayList();
            while (ow3VarA0.Y()) {
                ArrayList arrayList2 = arrayList;
                History history = new History();
                if (ow3VarA0.isNull(iC)) {
                    i2 = iC;
                    strI = null;
                } else {
                    i2 = iC;
                    strI = ow3VarA0.I(iC);
                }
                history.setKey(strI);
                history.setVodPic(ow3VarA0.isNull(iC2) ? null : ow3VarA0.I(iC2));
                history.setVodName(ow3VarA0.isNull(iC3) ? null : ow3VarA0.I(iC3));
                history.setVodFlag(ow3VarA0.isNull(iC4) ? null : ow3VarA0.I(iC4));
                history.setVodRemarks(ow3VarA0.isNull(iC5) ? null : ow3VarA0.I(iC5));
                history.setEpisodeUrl(ow3VarA0.isNull(iC6) ? null : ow3VarA0.I(iC6));
                int i3 = iC2;
                int i4 = iC3;
                history.setRevSort(((int) ow3VarA0.getLong(iC7)) != 0);
                history.setRevPlay(((int) ow3VarA0.getLong(iC8)) != 0);
                history.setCreateTime(ow3VarA0.getLong(iC9));
                history.setOpening(ow3VarA0.getLong(iC10));
                history.setEnding(ow3VarA0.getLong(iC11));
                history.setPosition(ow3VarA0.getLong(iC12));
                history.setDuration(ow3VarA0.getLong(iC13));
                history.setSpeed((float) ow3VarA0.getDouble(iC14));
                int i5 = iC15;
                int i6 = iC4;
                history.setScale((int) ow3VarA0.getLong(i5));
                int i7 = iC16;
                int i8 = iC5;
                history.setCid((int) ow3VarA0.getLong(i7));
                arrayList2.add(history);
                iC5 = i8;
                iC2 = i3;
                iC16 = i7;
                arrayList = arrayList2;
                iC = i2;
                iC4 = i6;
                iC15 = i5;
                iC3 = i4;
            }
            ArrayList arrayList3 = arrayList;
            ow3VarA0.close();
            return arrayList3;
        } catch (Throwable th) {
            ow3VarA0.close();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)Ljava/lang/Long; */
    @Override // defpackage.kh
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public Long a(final History history) {
        return (Long) j70.b(this.a, false, true, new Function1() { // from class: be1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.D(history, (lw3) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: c(Ljava/lang/Object;)V */
    @Override // defpackage.kh
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public void c(final History history) {
        j70.b(this.a, false, true, new Function1() { // from class: ce1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.F(history, (lw3) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ Long D(History history, lw3 lw3Var) {
        return Long.valueOf(this.b.c(lw3Var, history));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ fw4 F(History history, lw3 lw3Var) {
        super.c(history);
        return fw4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ Object H(History history, lw3 lw3Var) throws Exception {
        this.c.c(lw3Var, history);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: e(Ljava/lang/Object;)V */
    @Override // defpackage.kh
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public void e(final History history) {
        j70.b(this.a, false, true, new Function1() { // from class: ke1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.H(history, (lw3) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.kh
    public List b(final List list) {
        return (List) j70.b(this.a, false, true, new Function1() { // from class: je1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.E(list, (lw3) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.kh
    public void d(final List list) {
        j70.b(this.a, false, true, new Function1() { // from class: ee1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.G(list, (lw3) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.kh
    public void f(final List list) {
        j70.b(this.a, false, true, new Function1() { // from class: ae1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return this.f.I(list, (lw3) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yd1
    public void g(final int i) {
        j70.b(this.a, false, true, new Function1() { // from class: de1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return le1.r(i, (lw3) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yd1
    public void h(final int i, final String str) {
        j70.b(this.a, false, true, new Function1() { // from class: ge1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return le1.t(i, str, (lw3) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yd1
    public History i(final int i, final String str) {
        return (History) j70.b(this.a, true, false, new Function1() { // from class: fe1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return le1.s(i, str, (lw3) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yd1
    public List j(final int i, final long j) {
        return (List) j70.b(this.a, true, false, new Function1() { // from class: he1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return le1.q(i, j, (lw3) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yd1
    public List k() {
        return (List) j70.b(this.a, true, false, new Function1() { // from class: zd1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return le1.m((lw3) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yd1
    public List l(final int i, final String str) {
        return (List) j70.b(this.a, true, false, new Function1() { // from class: ie1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return le1.x(i, str, (lw3) obj);
            }
        });
    }
}
