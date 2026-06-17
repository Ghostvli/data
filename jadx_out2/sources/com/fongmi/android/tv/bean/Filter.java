package com.fongmi.android.tv.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Value;
import com.github.catvod.utils.Trans;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import defpackage.jg3;
import defpackage.km1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.mozilla.javascript.ES6Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Filter implements Parcelable {
    public static final Parcelable.Creator<Filter> CREATOR = new Parcelable.Creator<Filter>() { // from class: com.fongmi.android.tv.bean.Filter.2
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object; */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Filter createFromParcel(Parcel parcel) {
            return new Filter(parcel);
        }

        /* JADX DEBUG: Method merged with bridge method: newArray(I)[Ljava/lang/Object; */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Filter[] newArray(int i) {
            return new Filter[i];
        }
    };

    @SerializedName("init")
    private String init;

    @SerializedName("key")
    private String key;

    @SerializedName("name")
    private String name;

    @SerializedName(ES6Iterator.VALUE_PROPERTY)
    private List<Value> value;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Filter(Parcel parcel) {
        this.key = parcel.readString();
        this.name = parcel.readString();
        this.init = parcel.readString();
        ArrayList arrayList = new ArrayList();
        this.value = arrayList;
        parcel.readList(arrayList, Value.class.getClassLoader());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List<Filter> arrayFrom(String str) {
        List<Filter> list = (List) App.c().fromJson(str, new TypeToken<List<Filter>>() { // from class: com.fongmi.android.tv.bean.Filter.1
        }.getType());
        return list == null ? Collections.EMPTY_LIST : list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Filter objectFrom(JsonElement jsonElement) {
        return (Filter) App.c().fromJson(jsonElement, Filter.class);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Filter check() {
        km1.h(getValue(), jg3.e());
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Filter copy() {
        final Filter filter = new Filter();
        filter.key = this.key;
        filter.name = this.name;
        filter.init = this.init;
        filter.value = new ArrayList();
        getValue().forEach(new Consumer() { // from class: b11
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.value.add(((Value) obj).copy());
            }
        });
        return filter;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getInit() {
        return this.init;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getKey() {
        return this.key;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getName() {
        return TextUtils.isEmpty(this.name) ? "" : this.name;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List<Value> getValue() {
        List<Value> list = this.value;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String setActivated(final String str) {
        getValue().stream().filter(new Predicate() { // from class: c11
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Value) obj).equals(Value.create(str));
            }
        }).findFirst().ifPresent(new Consumer() { // from class: d11
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Value) obj).setActivated(true);
            }
        });
        return str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Filter trans() {
        if (Trans.pass()) {
            return this;
        }
        getValue().forEach(new Consumer() { // from class: e11
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Value) obj).trans();
            }
        });
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.key);
        parcel.writeString(this.name);
        parcel.writeString(this.init);
        parcel.writeList(this.value);
    }

    public Filter() {
    }
}
