package com.fongmi.android.tv.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.github.catvod.utils.Trans;
import com.google.gson.annotations.SerializedName;
import defpackage.jy4;
import defpackage.nl0;
import defpackage.to3;
import defpackage.yq;
import defpackage.zt0;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Episode implements Parcelable, nl0 {
    public static final Parcelable.Creator<Episode> CREATOR = new Parcelable.Creator<Episode>() { // from class: com.fongmi.android.tv.bean.Episode.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Episode createFromParcel(Parcel parcel) {
            return new Episode(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Episode[] newArray(int i) {
            return new Episode[i];
        }
    };
    private boolean activated;

    @SerializedName("desc")
    private String desc;
    private int index;

    @SerializedName("name")
    private String name;
    private int number;
    private boolean selected;

    @SerializedName("url")
    private String url;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Rule extends to3 {
        private final Episode episode;
        private final int score;

        public Rule(Episode episode, int i) {
            this.episode = episode;
            this.score = i;
        }

        private /* synthetic */ boolean a(Object obj) {
            if (!(obj instanceof Rule)) {
                return false;
            }
            Rule rule = (Rule) obj;
            return this.score == rule.score && Objects.equals(this.episode, rule.episode);
        }

        private /* synthetic */ Object[] b() {
            return new Object[]{this.episode, Integer.valueOf(this.score)};
        }

        public Episode episode() {
            return this.episode;
        }

        public final boolean equals(Object obj) {
            return a(obj);
        }

        public boolean find() {
            return this.score > 0;
        }

        public final int hashCode() {
            return zt0.a(this.score, this.episode);
        }

        public int score() {
            return this.score;
        }

        public final String toString() {
            return yq.a(b(), Rule.class, "episode;score");
        }
    }

    public Episode(Parcel parcel) {
        this.name = parcel.readString();
        this.desc = parcel.readString();
        this.url = parcel.readString();
        this.number = parcel.readInt();
        this.activated = parcel.readByte() != 0;
        this.selected = parcel.readByte() != 0;
    }

    public static Episode create(String str, String str2) {
        return new Episode(str, "", str2).trans();
    }

    public void deactivated() {
        setActivated(false);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Episode) {
            Episode episode = (Episode) obj;
            if (Objects.equals(getName(), episode.getName()) && Objects.equals(getUrl(), episode.getUrl())) {
                return true;
            }
        }
        return false;
    }

    public String getDesc() {
        return TextUtils.isEmpty(this.desc) ? "" : this.desc;
    }

    public int getIndex() {
        return this.index;
    }

    public String getName() {
        return TextUtils.isEmpty(this.name) ? "" : this.name;
    }

    public int getNumber() {
        return this.number;
    }

    public int getScore(String str, int i) {
        if (getName().equalsIgnoreCase(str)) {
            return 100;
        }
        if (i != -1 && getNumber() == i) {
            return 80;
        }
        if (i == -1 && str.length() >= 2 && getName().toLowerCase().contains(str.toLowerCase())) {
            return 70;
        }
        return (i == -1 && getName().length() >= 2 && str.toLowerCase().contains(getName().toLowerCase())) ? 60 : 0;
    }

    public String getUrl() {
        return TextUtils.isEmpty(this.url) ? "" : this.url;
    }

    public int hashCode() {
        return Objects.hash(getName(), getUrl());
    }

    public boolean isActivated() {
        return this.activated;
    }

    @Override // defpackage.nl0
    public boolean isSameContent(Episode episode) {
        return getUrl().equals(episode.getUrl()) && getDesc().equals(episode.getDesc());
    }

    public boolean isSelected() {
        return this.selected;
    }

    public boolean matchesName(Episode episode) {
        if (episode == null) {
            return false;
        }
        return getName().equalsIgnoreCase(episode.getName());
    }

    public void setActivated(boolean z) {
        this.activated = z;
        this.selected = z;
    }

    public void setIndex(int i) {
        this.index = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setSelected(boolean z) {
        this.selected = z;
    }

    public Episode trans() {
        if (Trans.pass()) {
            return this;
        }
        this.name = Trans.s2t(this.name);
        this.desc = Trans.s2t(this.desc);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.name);
        parcel.writeString(this.desc);
        parcel.writeString(this.url);
        parcel.writeInt(this.number);
        parcel.writeByte(this.activated ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.selected ? (byte) 1 : (byte) 0);
    }

    @Override // defpackage.nl0
    public boolean isSameItem(Episode episode) {
        return equals(episode);
    }

    public static Episode create(String str, String str2, String str3) {
        return new Episode(str, str2, str3).trans();
    }

    public Episode() {
    }

    private Episode(String str, String str2, String str3) {
        this.number = jy4.j(str);
        this.name = str;
        this.desc = str2;
        this.url = str3;
    }
}
