package com.fongmi.android.tv.bean;

import android.text.TextUtils;
import com.fongmi.android.tv.App;
import com.github.catvod.utils.Json;
import com.google.gson.annotations.SerializedName;
import defpackage.w41;
import defpackage.yt0;
import j$.time.LocalDateTime;
import j$.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Epg {

    @SerializedName("date")
    private String date;

    @SerializedName("key")
    private String key;

    @SerializedName("epg_data")
    private List<EpgData> list;
    private int width;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Epg create(String str, String str2) {
        Epg epg = new Epg();
        epg.setKey(str);
        epg.setDate(str2);
        epg.setList(new ArrayList());
        return epg;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Epg objectFrom(String str, String str2, ZoneId zoneId) {
        if (!Json.isObj(str)) {
            return yt0.l(str, str2, zoneId);
        }
        try {
            Epg epg = (Epg) App.c().fromJson(str, Epg.class);
            epg.setTime(zoneId);
            epg.setKey(str2);
            return epg;
        } catch (Exception unused) {
            return new Epg();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private long parseEpgTime(String str, ZoneId zoneId) {
        try {
            return LocalDateTime.parse(str, str.length() > 16 ? w41.f : w41.e).M(zoneId).toInstant().toEpochMilli();
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void setTime(ZoneId zoneId) {
        setList(new ArrayList(new LinkedHashSet(getList())));
        for (EpgData epgData : getList()) {
            epgData.setStartTime(parseEpgTime(getDate().concat(epgData.getStart()), zoneId));
            epgData.setEndTime(parseEpgTime(getDate().concat(epgData.getEnd()), zoneId));
            if (epgData.getEndTime() < epgData.getStartTime()) {
                epgData.checkDay(zoneId);
            }
            epgData.trans();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equal(String str) {
        return getDate().equals(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getDate() {
        return TextUtils.isEmpty(this.date) ? "" : this.date;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public EpgData getEpgData() {
        for (EpgData epgData : getList()) {
            if (epgData.isSelected()) {
                return epgData;
            }
        }
        return new EpgData();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getInRange() {
        for (int i = 0; i < getList().size(); i++) {
            if (getList().get(i).isInRange()) {
                return i;
            }
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getKey() {
        return TextUtils.isEmpty(this.key) ? "" : this.key;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<EpgData> getList() {
        List<EpgData> list = this.list;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getSelected() {
        for (int i = 0; i < getList().size(); i++) {
            if (getList().get(i).isSelected()) {
                return i;
            }
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getWidth() {
        return this.width;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Epg selected() {
        for (EpgData epgData : getList()) {
            epgData.setSelected(epgData.isInRange());
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setDate(String str) {
        this.date = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setKey(String str) {
        this.key = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setList(List<EpgData> list) {
        this.list = list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setWidth(int i) {
        this.width = i;
    }
}
