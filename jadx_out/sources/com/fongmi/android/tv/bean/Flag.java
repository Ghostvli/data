package com.fongmi.android.tv.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Episode;
import com.fongmi.android.tv.bean.Flag;
import com.github.catvod.utils.Trans;
import com.google.gson.annotations.SerializedName;
import defpackage.jy4;
import defpackage.nl0;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Text;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Flag implements Parcelable, nl0 {
    public static final Parcelable.Creator<Flag> CREATOR = new Parcelable.Creator<Flag>() { // from class: com.fongmi.android.tv.bean.Flag.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Flag createFromParcel(Parcel parcel) {
            return new Flag(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Flag[] newArray(int i) {
            return new Flag[i];
        }
    };
    private boolean activated;

    @SerializedName("episodes")
    private List<Episode> episodes;

    @SerializedName("flag")
    @Attribute(name = "flag", required = false)
    private String flag;
    private int position;
    private String show;

    @Text
    private String urls;

    public Flag(Parcel parcel) {
        this.flag = parcel.readString();
        this.show = parcel.readString();
        this.urls = parcel.readString();
        this.episodes = parcel.createTypedArrayList(Episode.CREATOR);
        this.activated = parcel.readByte() != 0;
        this.position = parcel.readInt();
    }

    public static Flag create(String str) {
        return new Flag(str).trans();
    }

    public static /* synthetic */ Episode.Rule d(String str, int i, Episode episode) {
        return new Episode.Rule(episode, episode.getScore(str, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ Episode lambda$find$1(boolean z) {
        Episode episode;
        if (getPosition() != -1) {
            episode = getEpisodes().get(getPosition());
        } else {
            if (z) {
                return null;
            }
            episode = getEpisodes().get(0);
        }
        return episode;
    }

    private void setActivated(Episode episode) {
        setPosition(getEpisodes().indexOf(episode));
        int i = 0;
        while (i < getEpisodes().size()) {
            getEpisodes().get(i).setActivated(i == getPosition());
            i++;
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Flag) {
            return Objects.equals(getFlag(), ((Flag) obj).getFlag());
        }
        return false;
    }

    public Episode find(final String str, final boolean z) {
        if (getEpisodes().isEmpty()) {
            return null;
        }
        if (getEpisodes().size() == 1) {
            return getEpisodes().get(0);
        }
        final int iJ = jy4.j(str);
        return (Episode) getEpisodes().stream().map(new Function() { // from class: h21
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Flag.d(str, iJ, (Episode) obj);
            }
        }).filter(new Predicate() { // from class: i21
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Episode.Rule) obj).find();
            }
        }).max(Comparator.comparingInt(new ToIntFunction() { // from class: j21
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return ((Episode.Rule) obj).score();
            }
        })).map(new Function() { // from class: k21
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Episode.Rule) obj).episode();
            }
        }).orElseGet(new Supplier() { // from class: l21
            @Override // java.util.function.Supplier
            public final Object get() {
                return this.a.lambda$find$1(z);
            }
        });
    }

    public List<Episode> getEpisodes() {
        return this.episodes;
    }

    public String getFlag() {
        return TextUtils.isEmpty(this.flag) ? "" : this.flag;
    }

    public int getPosition() {
        return this.position;
    }

    public String getShow() {
        return TextUtils.isEmpty(this.show) ? getFlag() : this.show;
    }

    public String getUrls() {
        return TextUtils.isEmpty(this.urls) ? "" : this.urls;
    }

    public int hashCode() {
        return Objects.hash(getFlag());
    }

    public boolean isActivated() {
        return this.activated;
    }

    public void mergeEpisodes(List<Episode> list, boolean z) {
        for (Episode episode : list) {
            if (!getEpisodes().contains(episode)) {
                if (z) {
                    getEpisodes().add(0, episode);
                } else {
                    getEpisodes().add(episode);
                }
            }
        }
    }

    public void setEpisodes(String str) {
        String str2;
        String[] strArrSplit = str.contains("#") ? str.split("#") : new String[]{str};
        int i = 0;
        while (i < strArrSplit.length) {
            String[] strArrSplit2 = strArrSplit[i].split("\\$", 2);
            int i2 = i + 1;
            String strTrim = String.format(Locale.getDefault(), "%02d", Integer.valueOf(i2));
            if (strArrSplit2.length > 1) {
                if (!strArrSplit2[0].isEmpty()) {
                    strTrim = strArrSplit2[0].trim();
                }
                str2 = strArrSplit2[1];
            } else {
                str2 = strArrSplit[i];
            }
            Episode episodeCreate = Episode.create(strTrim, str2);
            if (!getEpisodes().contains(episodeCreate)) {
                getEpisodes().add(episodeCreate);
            }
            i = i2;
        }
    }

    public void setFlag(String str) {
        this.flag = str;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public String toString() {
        return App.c().toJson(this);
    }

    public void toggle(boolean z, Episode episode) {
        if (z) {
            setActivated(episode);
        } else {
            getEpisodes().forEach(new Consumer() { // from class: g21
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    ((Episode) obj).deactivated();
                }
            });
        }
    }

    public Flag trans() {
        if (Trans.pass()) {
            return this;
        }
        this.show = Trans.s2t(this.flag);
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.flag);
        parcel.writeString(this.show);
        parcel.writeString(this.urls);
        parcel.writeTypedList(this.episodes);
        parcel.writeByte(this.activated ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.position);
    }

    @Override // defpackage.nl0
    public boolean isSameContent(Flag flag) {
        return equals(flag);
    }

    @Override // defpackage.nl0
    public boolean isSameItem(Flag flag) {
        return equals(flag);
    }

    public static Flag create(String str, String str2) {
        Flag flagCreate = create(str);
        flagCreate.setEpisodes(str2);
        return flagCreate;
    }

    public Flag(String str) {
        this.flag = str;
        this.position = -1;
        this.episodes = new ArrayList();
    }

    public void setActivated(Flag flag) {
        boolean zEquals = flag.equals(this);
        this.activated = zEquals;
        if (zEquals) {
            flag.episodes = this.episodes;
        }
    }

    public Flag() {
        this.position = -1;
        this.episodes = new ArrayList();
    }
}
