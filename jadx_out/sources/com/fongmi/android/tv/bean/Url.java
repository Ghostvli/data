package com.fongmi.android.tv.bean;

import android.net.Uri;
import android.text.TextUtils;
import com.fongmi.android.tv.App;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Url {

    @SerializedName("position")
    private int position;

    @SerializedName("values")
    private List<Value> values;

    public static Url create() {
        return new Url();
    }

    public static Url objectFrom(JsonElement jsonElement) {
        try {
            return (Url) App.c().fromJson(jsonElement, Url.class);
        } catch (Exception unused) {
            return create();
        }
    }

    public Url add(String str) {
        getValues().add(Value.create(str));
        return this;
    }

    public int getPosition() {
        return this.position;
    }

    public List<Value> getValues() {
        List<Value> arrayList = this.values;
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        this.values = arrayList;
        return arrayList;
    }

    public boolean isEmpty() {
        return getValues().isEmpty() || TextUtils.isEmpty(v());
    }

    public boolean isMulti() {
        return getValues().size() > 1;
    }

    public String n(int i) {
        return i >= getValues().size() ? "" : getValues().get(i).getN();
    }

    public Url replace(String str) {
        if (getValues().isEmpty()) {
            add(str);
            return this;
        }
        getValues().get(getPosition()).setV(str);
        return this;
    }

    public Url set(int i) {
        this.position = Math.min(i, getValues().size() - 1);
        return this;
    }

    public Uri uri() {
        return Uri.parse(v());
    }

    public String v(int i) {
        return i >= getValues().size() ? "" : getValues().get(i).getV();
    }

    public Url add(String str, String str2) {
        getValues().add(Value.create(str, str2));
        return this;
    }

    public String v() {
        return v(getPosition());
    }
}
