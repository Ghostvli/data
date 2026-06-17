package com.fongmi.android.tv.bean;

import android.text.TextUtils;
import androidx.media3.session.x;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.History;
import com.fongmi.android.tv.db.AppDatabase;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import defpackage.b75;
import defpackage.f10;
import defpackage.nl0;
import defpackage.sm3;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.ToLongFunction;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class History implements nl0 {

    @SerializedName("cid")
    private int cid;

    @SerializedName("createTime")
    private long createTime;

    @SerializedName("episodeUrl")
    private String episodeUrl;

    @SerializedName("key")
    private String key;

    @SerializedName("revPlay")
    private boolean revPlay;

    @SerializedName("revSort")
    private boolean revSort;
    private transient long updateTime;

    @SerializedName("vodFlag")
    private String vodFlag;

    @SerializedName("vodName")
    private String vodName;

    @SerializedName("vodPic")
    private String vodPic;

    @SerializedName("vodRemarks")
    private String vodRemarks;

    @SerializedName("speed")
    private float speed = 1.0f;

    @SerializedName("scale")
    private int scale = -1;

    @SerializedName("ending")
    private long ending = -9223372036854775807L;

    @SerializedName("opening")
    private long opening = -9223372036854775807L;

    @SerializedName("position")
    private long position = -9223372036854775807L;

    @SerializedName("duration")
    private long duration = -9223372036854775807L;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(History history) {
        try {
            List<History> listFindByName = findByName(history.getVodName());
            if (listFindByName.isEmpty()) {
                history.cid(b75.K()).save();
                return;
            }
            if (history.getCreateTime() > listFindByName.stream().mapToLong(new ToLongFunction() { // from class: rd1
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.util.function.ToLongFunction
                public final long applyAsLong(Object obj) {
                    return ((History) obj).getCreateTime();
                }
            }).max().orElse(0L)) {
                history.cid(b75.K()).merge(listFindByName, true).save();
            }
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List<History> arrayFrom(String str) {
        List<History> list = (List) App.c().fromJson(str, new TypeToken<List<History>>() { // from class: com.fongmi.android.tv.bean.History.1
        }.getType());
        return list == null ? Collections.EMPTY_LIST : list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private History copyTo(History history) {
        if (getOpening() > 0) {
            history.setOpening(getOpening());
        }
        if (getEnding() > 0) {
            history.setEnding(getEnding());
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static History find(String str) {
        try {
            return AppDatabase.Q().T().i(b75.K(), str);
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List<History> findByName(String str) {
        try {
            return AppDatabase.Q().T().l(b75.K(), str);
        } catch (Exception unused) {
            return Collections.EMPTY_LIST;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List<History> get(int i) {
        try {
            return AppDatabase.Q().T().j(i, System.currentTimeMillis() - f10.m);
        } catch (Exception unused) {
            return Collections.EMPTY_LIST;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private History merge(List<History> list, boolean z) {
        for (History history : list) {
            if (history.shouldMerge(this, z)) {
                history.copyTo(this).delete();
            }
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static History objectFrom(String str) {
        return (History) App.c().fromJson(str, History.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean shouldMerge(History history, boolean z) {
        if (z || !getKey().equals(history.getKey())) {
            return getDuration() <= 0 || history.getDuration() <= 0 || Math.abs(getDuration() - history.getDuration()) <= x.DEFAULT_FOREGROUND_SERVICE_TIMEOUT_MS;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void sync(List<History> list) {
        list.forEach(new Consumer() { // from class: qd1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                History.a((History) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean canSave() {
        return getPosition() > 0 && getDuration() > 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean canSync() {
        return System.currentTimeMillis() - getUpdateTime() > 5000;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public History cid(int i) {
        setCid(i);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public History delete() {
        try {
            AppDatabase.Q().T().h(b75.K(), getKey());
            AppDatabase.Q().X().g(getKey());
        } catch (Exception unused) {
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof History) {
            return Objects.equals(getKey(), ((History) obj).getKey());
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void findEpisode(List<Flag> list) {
        if (list.isEmpty()) {
            return;
        }
        setVodFlag(list.get(0).getFlag());
        if (!list.get(0).getEpisodes().isEmpty()) {
            setVodRemarks(list.get(0).getEpisodes().get(0).getName());
        }
        try {
            for (History history : findByName(getVodName())) {
                if (getPosition() > 0) {
                    return;
                }
                Iterator<Flag> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Flag next = it.next();
                    Episode episodeFind = next.find(history.getVodRemarks(), true);
                    if (episodeFind != null) {
                        history.copyTo(this);
                        setVodFlag(next.getFlag());
                        setPosition(history.getPosition());
                        setVodRemarks(episodeFind.getName());
                        break;
                    }
                }
            }
        } catch (Exception unused) {
        }
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
    public long getDuration() {
        return this.duration;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getEnding() {
        return this.ending;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Episode getEpisode() {
        return Episode.create(getVodRemarks(), getEpisodeUrl());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getEpisodeUrl() {
        String str = this.episodeUrl;
        return str == null ? "" : str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Flag getFlag() {
        return Flag.create(getVodFlag());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getKey() {
        return this.key;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getOpening() {
        return this.opening;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getPosition() {
        return this.position;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getRevPlayHint() {
        return isRevPlay() ? sm3.U : sm3.Z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getRevPlayText() {
        return isRevPlay() ? sm3.T : sm3.Y;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getScale() {
        return this.scale;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getSiteKey() {
        return getKey().split("@@@")[0];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getSiteName() {
        return b75.I().W(getSiteKey()).getName();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getSiteVisible() {
        return TextUtils.isEmpty(getSiteName()) ? 8 : 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float getSpeed() {
        return this.speed;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getUpdateTime() {
        return this.updateTime;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getVodFlag() {
        return this.vodFlag;
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
    public String getVodRemarks() {
        String str = this.vodRemarks;
        return str == null ? "" : str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return Objects.hash(getKey());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isRevPlay() {
        return this.revPlay;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isRevSort() {
        return this.revSort;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: isSameContent(Ljava/lang/Object;)Z */
    @Override // defpackage.nl0
    public boolean isSameContent(History history) {
        return getVodName().equals(history.getVodName()) && getVodPic().equals(history.getVodPic()) && getCreateTime() == history.getCreateTime();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void replace(String str) {
        delete();
        setKey(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public History save() {
        try {
            this.updateTime = System.currentTimeMillis();
            AppDatabase.Q().T().c(this);
        } catch (Exception unused) {
        }
        return this;
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
    public void setDuration(long j) {
        this.duration = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setEnding(long j) {
        this.ending = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setEpisodeUrl(String str) {
        this.episodeUrl = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setKey(String str) {
        this.key = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setOpening(long j) {
        this.opening = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setPosition(long j) {
        this.position = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setRevPlay(boolean z) {
        this.revPlay = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setRevSort(boolean z) {
        this.revSort = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setScale(int i) {
        this.scale = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setSpeed(float f) {
        this.speed = f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setVodFlag(String str) {
        this.vodFlag = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setVodName(String str) {
        this.vodName = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setVodPic(String str) {
        this.vodPic = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setVodRemarks(String str) {
        this.vodRemarks = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return App.c().toJson(this);
    }

    /* JADX DEBUG: Method merged with bridge method: isSameItem(Ljava/lang/Object;)Z */
    @Override // defpackage.nl0
    public boolean isSameItem(History history) {
        return equals(history);
    }

    public History save(int i) {
        return cid(i).merge(true).save();
    }

    public static List<History> get() {
        return get(b75.K());
    }

    private History merge(boolean z) {
        return merge(findByName(getVodName()), z);
    }

    public History merge() {
        merge(false);
        return this;
    }

    public static void delete(int i) {
        try {
            AppDatabase.Q().T().g(i);
        } catch (Exception unused) {
        }
    }
}
