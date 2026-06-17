package android.support.v4.media;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.MediaSessionCompat;
import defpackage.la;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR;
    public static final la g;
    public static final String[] h;
    public static final String[] i;
    public static final String[] j;
    public final Bundle f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public MediaMetadataCompat createFromParcel(Parcel parcel) {
            return new MediaMetadataCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public MediaMetadataCompat[] newArray(int i) {
            return new MediaMetadataCompat[i];
        }
    }

    static {
        la laVar = new la();
        g = laVar;
        laVar.put("android.media.metadata.TITLE", 1);
        laVar.put("android.media.metadata.ARTIST", 1);
        laVar.put("android.media.metadata.DURATION", 0);
        laVar.put("android.media.metadata.ALBUM", 1);
        laVar.put("android.media.metadata.AUTHOR", 1);
        laVar.put("android.media.metadata.WRITER", 1);
        laVar.put("android.media.metadata.COMPOSER", 1);
        laVar.put("android.media.metadata.COMPILATION", 1);
        laVar.put("android.media.metadata.DATE", 1);
        laVar.put("android.media.metadata.YEAR", 0);
        laVar.put("android.media.metadata.GENRE", 1);
        laVar.put("android.media.metadata.TRACK_NUMBER", 0);
        laVar.put("android.media.metadata.NUM_TRACKS", 0);
        laVar.put("android.media.metadata.DISC_NUMBER", 0);
        laVar.put("android.media.metadata.ALBUM_ARTIST", 1);
        laVar.put("android.media.metadata.ART", 2);
        laVar.put("android.media.metadata.ART_URI", 1);
        laVar.put("android.media.metadata.ALBUM_ART", 2);
        laVar.put("android.media.metadata.ALBUM_ART_URI", 1);
        laVar.put("android.media.metadata.USER_RATING", 3);
        laVar.put("android.media.metadata.RATING", 3);
        laVar.put("android.media.metadata.DISPLAY_TITLE", 1);
        laVar.put("android.media.metadata.DISPLAY_SUBTITLE", 1);
        laVar.put("android.media.metadata.DISPLAY_DESCRIPTION", 1);
        laVar.put("android.media.metadata.DISPLAY_ICON", 2);
        laVar.put("android.media.metadata.DISPLAY_ICON_URI", 1);
        laVar.put("android.media.metadata.MEDIA_ID", 1);
        laVar.put("android.media.metadata.BT_FOLDER_TYPE", 0);
        laVar.put("android.media.metadata.MEDIA_URI", 1);
        laVar.put("android.media.metadata.ADVERTISEMENT", 0);
        laVar.put("android.media.metadata.DOWNLOAD_STATUS", 0);
        h = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER"};
        i = new String[]{"android.media.metadata.DISPLAY_ICON", "android.media.metadata.ART", "android.media.metadata.ALBUM_ART"};
        j = new String[]{"android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ART_URI", "android.media.metadata.ALBUM_ART_URI"};
        CREATOR = new a();
    }

    public MediaMetadataCompat(Parcel parcel) {
        this.f = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeBundle(this.f);
    }
}
