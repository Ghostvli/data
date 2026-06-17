package com.fongmi.android.tv.bean;

import com.fongmi.android.tv.App;
import com.fongmi.android.tv.db.AppDatabase;
import com.github.catvod.utils.Prefers;
import com.google.gson.GsonBuilder;
import com.google.gson.ToNumberPolicy;
import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Backup {

    @SerializedName("config")
    private List<Config> config;

    @SerializedName("history")
    private List<History> history;

    @SerializedName("keep")
    private List<Keep> keep;

    @SerializedName("live")
    private List<Live> live;

    @SerializedName("prefers")
    private Map<String, ?> prefers;

    @SerializedName("site")
    private List<Site> site;

    public static Backup create() {
        Backup backup = new Backup();
        backup.setPrefers(Prefers.getPrefers().getAll());
        backup.setSite(AppDatabase.Q().W().g());
        backup.setLive(AppDatabase.Q().V().h());
        backup.setKeep(AppDatabase.Q().U().m());
        backup.setConfig(AppDatabase.Q().R().j());
        backup.setHistory(AppDatabase.Q().T().k());
        return backup;
    }

    public static Backup objectFrom(String str) {
        try {
            Backup backup = (Backup) new GsonBuilder().setObjectToNumberStrategy(ToNumberPolicy.LAZILY_PARSED_NUMBER).create().fromJson(str, Backup.class);
            return backup == null ? new Backup() : backup;
        } catch (Exception unused) {
            return new Backup();
        }
    }

    public List<Config> getConfig() {
        List<Config> list = this.config;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public List<History> getHistory() {
        List<History> list = this.history;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public List<Keep> getKeep() {
        List<Keep> list = this.keep;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public List<Live> getLive() {
        List<Live> list = this.live;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public Map<String, ?> getPrefers() {
        Map<String, ?> map = this.prefers;
        return map == null ? new HashMap() : map;
    }

    public List<Site> getSite() {
        List<Site> list = this.site;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public void restore() {
        AppDatabase.Q().g();
        AppDatabase.Q().W().d(getSite());
        AppDatabase.Q().V().d(getLive());
        AppDatabase.Q().U().d(getKeep());
        AppDatabase.Q().R().d(getConfig());
        AppDatabase.Q().T().d(getHistory());
        for (Map.Entry<String, ?> entry : getPrefers().entrySet()) {
            Prefers.put(entry.getKey(), entry.getValue());
        }
    }

    public void setConfig(List<Config> list) {
        this.config = list;
    }

    public void setHistory(List<History> list) {
        this.history = list;
    }

    public void setKeep(List<Keep> list) {
        this.keep = list;
    }

    public void setLive(List<Live> list) {
        this.live = list;
    }

    public void setPrefers(Map<String, ?> map) {
        this.prefers = map;
    }

    public void setSite(List<Site> list) {
        this.site = list;
    }

    public String toString() {
        return App.c().toJson(this);
    }
}
