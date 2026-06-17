package com.fongmi.android.tv.bean;

import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Config;
import com.fongmi.android.tv.bean.Keep;
import com.fongmi.android.tv.db.AppDatabase;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import defpackage.b75;
import defpackage.nl0;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Keep implements nl0 {

    @SerializedName("cid")
    private int cid;

    @SerializedName("createTime")
    private long createTime;

    @SerializedName("key")
    private String key;

    @SerializedName("siteName")
    private String siteName;

    @SerializedName("type")
    private int type;

    @SerializedName("vodName")
    private String vodName;

    @SerializedName("vodPic")
    private String vodPic;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List<Keep> arrayFrom(String str) {
        List<Keep> list = (List) App.c().fromJson(str, new TypeToken<List<Keep>>() { // from class: com.fongmi.android.tv.bean.Keep.1
        }.getType());
        return list == null ? Collections.EMPTY_LIST : list;
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: ?: TERNARY null = ((wrap:int:0x0000: INVOKE (r0v0 com.fongmi.android.tv.bean.Keep) VIRTUAL call: com.fongmi.android.tv.bean.Keep.getCid():int A[MD:():int (m), WRAPPED] (LINE:1)) == (wrap:int:0x0004: INVOKE (r1v0 com.fongmi.android.tv.bean.Config) VIRTUAL call: com.fongmi.android.tv.bean.Config.getId():int A[MD:():int (m), WRAPPED] (LINE:5))) ? true : false */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean b(Keep keep, Config config) {
        return keep.getCid() == config.getId();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void deleteAll() {
        AppDatabase.Q().U().g();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean exist(String str) {
        return AppDatabase.Q().U().l(str) != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Keep find(int i, String str) {
        return AppDatabase.Q().U().k(i, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List<Keep> getLive() {
        return AppDatabase.Q().U().n();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List<Keep> getVod() {
        return AppDatabase.Q().U().o();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void sync(final List<Config> list, List<Keep> list2) {
        list2.forEach(new Consumer() { // from class: xp1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                Keep keep = (Keep) obj;
                list.stream().filter(new Predicate() { // from class: vp1
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj2) {
                        return Keep.b(this.a, (Config) obj2);
                    }
                }).findFirst().ifPresent(new Consumer() { // from class: wp1
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.util.function.Consumer
                    public final void accept(Object obj2) {
                        this.a.save(Config.find((Config) obj2).getId());
                    }
                });
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Keep delete() {
        AppDatabase.Q().U().i(getCid(), getKey());
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Keep) {
            return Objects.equals(getKey(), ((Keep) obj).getKey());
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getCid() {
        return this.cid;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getCreateTime() {
        return this.createTime;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getKey() {
        return this.key;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getSiteKey() {
        return getKey().split("@@@")[0];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getSiteName() {
        return this.siteName;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getType() {
        return this.type;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getVodId() {
        return getKey().split("@@@")[1];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getVodName() {
        return this.vodName;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getVodPic() {
        return this.vodPic;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return Objects.hash(getKey());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: isSameContent(Ljava/lang/Object;)Z */
    @Override // defpackage.nl0
    public boolean isSameContent(Keep keep) {
        return getVodName().equals(keep.getVodName()) && getVodPic().equals(keep.getVodPic()) && getCreateTime() == keep.getCreateTime();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void save() {
        AppDatabase.Q().U().c(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCid(int i) {
        this.cid = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCreateTime(long j) {
        this.createTime = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setKey(String str) {
        this.key = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setSiteName(String str) {
        this.siteName = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setType(int i) {
        this.type = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setVodName(String str) {
        this.vodName = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setVodPic(String str) {
        this.vodPic = str;
    }

    /* JADX DEBUG: Method merged with bridge method: isSameItem(Ljava/lang/Object;)Z */
    @Override // defpackage.nl0
    public boolean isSameItem(Keep keep) {
        return equals(keep);
    }

    public void save(int i) {
        setCid(i);
        save();
    }

    public static Keep find(String str) {
        return find(b75.K(), str);
    }

    public static void delete(String str) {
        AppDatabase.Q().U().j(str);
    }

    public static void delete(int i) {
        AppDatabase.Q().U().h(i);
    }
}
