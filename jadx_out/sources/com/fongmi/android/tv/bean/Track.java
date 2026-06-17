package com.fongmi.android.tv.bean;

import android.text.TextUtils;
import com.fongmi.android.tv.db.AppDatabase;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Track {
    private String format;
    private int id;
    private String key;
    private String name;
    private boolean selected;
    private int type;

    public Track(int i, String str, String str2) {
        this.type = i;
        this.name = str;
        this.format = str2;
    }

    public static void delete(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        AppDatabase.Q().X().g(str);
    }

    public static List<Track> find(String str) {
        return TextUtils.isEmpty(str) ? Collections.EMPTY_LIST : AppDatabase.Q().X().h(str);
    }

    public String getFormat() {
        return this.format;
    }

    public int getId() {
        return this.id;
    }

    public String getKey() {
        return this.key;
    }

    public String getName() {
        return this.name;
    }

    public int getType() {
        return this.type;
    }

    public boolean isSelected() {
        return this.selected;
    }

    public Track key(String str) {
        setKey(str);
        return this;
    }

    public Track save() {
        if (TextUtils.isEmpty(getKey())) {
            return this;
        }
        AppDatabase.Q().X().i(this);
        return this;
    }

    public void setFormat(String str) {
        this.format = str;
    }

    public void setId(int i) {
        this.id = i;
    }

    public void setKey(String str) {
        this.key = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSelected(boolean z) {
        this.selected = z;
    }

    public void setType(int i) {
        this.type = i;
    }

    public Track toggle() {
        setSelected(!isSelected());
        return this;
    }
}
