package com.fongmi.android.tv.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.thegrizzlylabs.sardineandroid.DavPrincipal;
import defpackage.nl0;
import defpackage.sm3;
import defpackage.vr3;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class Collect implements Parcelable, nl0 {
    public static final Parcelable.Creator<Collect> CREATOR = new Parcelable.Creator<Collect>() { // from class: com.fongmi.android.tv.bean.Collect.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Collect createFromParcel(Parcel parcel) {
            return new Collect(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public Collect[] newArray(int i) {
            return new Collect[i];
        }
    };
    private boolean activated;
    private List<Vod> list;
    private int page;
    private Site site;

    public Collect(Parcel parcel) {
        this.activated = parcel.readByte() != 0;
        this.list = parcel.createTypedArrayList(Vod.CREATOR);
        this.site = (Site) parcel.readParcelable(Site.class.getClassLoader());
        this.page = parcel.readInt();
    }

    public static Collect all() {
        Collect collect = new Collect(Site.get(DavPrincipal.KEY_ALL, vr3.l(sm3.a)), new ArrayList());
        collect.setActivated(true);
        return collect;
    }

    public static Collect create(List<Vod> list) {
        return new Collect(list.get(0).getSite(), list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Collect) {
            return Objects.equals(getSite(), ((Collect) obj).getSite());
        }
        return false;
    }

    public List<Vod> getList() {
        List<Vod> list = this.list;
        return list == null ? new ArrayList() : list;
    }

    public int getPage() {
        return Math.max(1, this.page);
    }

    public Site getSite() {
        Site site = this.site;
        return site == null ? new Site() : site;
    }

    public int hashCode() {
        return Objects.hashCode(getSite());
    }

    public boolean isActivated() {
        return this.activated;
    }

    public void setActivated(boolean z) {
        this.activated = z;
    }

    public void setPage(int i) {
        this.page = i;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeByte(this.activated ? (byte) 1 : (byte) 0);
        parcel.writeTypedList(this.list);
        parcel.writeParcelable(this.site, i);
        parcel.writeInt(this.page);
    }

    @Override // defpackage.nl0
    public boolean isSameContent(Collect collect) {
        return equals(collect);
    }

    @Override // defpackage.nl0
    public boolean isSameItem(Collect collect) {
        return equals(collect);
    }

    public Collect(Site site, List<Vod> list) {
        this.site = site;
        this.list = list;
    }
}
