package defpackage;

import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.media.Rating;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class qh2 implements Parcelable {
    public static final Parcelable.Creator<qh2> CREATOR;
    public static final la i;
    public static final String[] j;
    public final Bundle f;
    public MediaMetadata g;
    public byte[] h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Parcelable.Creator {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object; */
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public qh2 createFromParcel(Parcel parcel) {
            return new qh2(parcel);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: newArray(I)[Ljava/lang/Object; */
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public qh2[] newArray(int i) {
            return new qh2[i];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final Bundle a = new Bundle();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public qh2 a() {
            return new qh2(this.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b b(String str, Bitmap bitmap) {
            Integer num = (Integer) qh2.i.get(str);
            if (num == null || num.intValue() == 2) {
                this.a.putParcelable(str, bitmap);
                return this;
            }
            f02.a("The ", str, " key cannot be used to put a Bitmap");
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b c(String str, long j) {
            Integer num = (Integer) qh2.i.get(str);
            if (num == null || num.intValue() == 0) {
                this.a.putLong(str, j);
                return this;
            }
            f02.a("The ", str, " key cannot be used to put a long");
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b d(String str, zn3 zn3Var) {
            Integer num = (Integer) qh2.i.get(str);
            if (num == null || num.intValue() == 3) {
                this.a.putParcelable(str, (Parcelable) zn3Var.s());
                return this;
            }
            f02.a("The ", str, " key cannot be used to put a Rating");
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b e(String str, String str2) {
            Integer num = (Integer) qh2.i.get(str);
            if (num == null || num.intValue() == 1) {
                this.a.putCharSequence(str, str2);
                return this;
            }
            f02.a("The ", str, " key cannot be used to put a String");
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b f(String str, CharSequence charSequence) {
            Integer num = (Integer) qh2.i.get(str);
            if (num == null || num.intValue() == 1) {
                this.a.putCharSequence(str, charSequence);
                return this;
            }
            f02.a("The ", str, " key cannot be used to put a CharSequence");
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        la laVar = new la();
        i = laVar;
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
        j = new String[]{"android.media.metadata.TITLE", "android.media.metadata.ARTIST", "android.media.metadata.ALBUM", "android.media.metadata.ALBUM_ARTIST", "android.media.metadata.WRITER", "android.media.metadata.AUTHOR", "android.media.metadata.COMPOSER", "android.media.metadata.DISPLAY_SUBTITLE", "android.media.metadata.DISPLAY_DESCRIPTION"};
        CREATOR = new a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public qh2(Parcel parcel) {
        this.f = (Bundle) gg3.q(parcel.readBundle(pi2.class.getClassLoader()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static qh2 d(Object obj) {
        if (obj == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        mediaMetadata.writeToParcel(parcelObtain, 0);
        parcelObtain.setDataPosition(0);
        qh2 qh2VarCreateFromParcel = CREATOR.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        qh2VarCreateFromParcel.g = mediaMetadata;
        return qh2VarCreateFromParcel;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] A() {
        Bitmap bitmapZ = z();
        if (bitmapZ == null) {
            return null;
        }
        if (this.h == null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    bitmapZ.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                    this.h = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } finally {
                }
            } catch (IOException e) {
                xz1.j("MediaMetadata", "Failed to compress MediaMetadataCompat artwork", e);
            }
        }
        return this.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Uri B() {
        String strW = w("android.media.metadata.DISPLAY_ICON_URI", "android.media.metadata.ALBUM_ART_URI", "android.media.metadata.ART_URI");
        if (strW != null) {
            return Uri.parse(strW);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public zn3 C(String str) {
        try {
            return zn3.c(this.f.getParcelable(str));
        } catch (Exception e) {
            xz1.j("MediaMetadata", "Failed to retrieve a key as Rating.", e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String D(String str) {
        CharSequence charSequence = this.f.getCharSequence(str);
        if (charSequence != null) {
            return charSequence.toString();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CharSequence E(String str) {
        return this.f.getCharSequence(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void F(qh2 qh2Var) {
        Bitmap bitmapZ;
        Bitmap bitmapZ2;
        if (qh2Var.h == null || (bitmapZ = z()) == null || (bitmapZ2 = qh2Var.z()) == null || !bitmapZ.sameAs(bitmapZ2)) {
            return;
        }
        this.h = qh2Var.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean c(String str) {
        return this.f.containsKey(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Bitmap s(String str) {
        try {
            return (Bitmap) this.f.getParcelable(str);
        } catch (Exception e) {
            xz1.j("MediaMetadata", "Failed to retrieve a key as Bitmap.", e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Bundle u() {
        return new Bundle(this.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Bitmap v(String... strArr) {
        for (String str : strArr) {
            if (c(str)) {
                return s(str);
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String w(String... strArr) {
        for (String str : strArr) {
            if (c(str)) {
                return D(str);
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeBundle(this.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long x(String str) {
        return this.f.getLong(str, 0L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public MediaMetadata y() {
        if (this.g == null) {
            MediaMetadata.Builder builder = new MediaMetadata.Builder();
            for (String str : this.f.keySet()) {
                Integer num = (Integer) i.get(str);
                if (num == null) {
                    num = -1;
                }
                int iIntValue = num.intValue();
                if (iIntValue == 0) {
                    builder.putLong(str, this.f.getLong(str));
                } else if (iIntValue == 1) {
                    builder.putText(str, this.f.getCharSequence(str));
                } else if (iIntValue != 2) {
                    Bundle bundle = this.f;
                    if (iIntValue != 3) {
                        Object obj = bundle.get(str);
                        if (obj == null || (obj instanceof CharSequence)) {
                            builder.putText(str, (CharSequence) obj);
                        } else if (obj instanceof Long) {
                            builder.putLong(str, ((Long) obj).longValue());
                        }
                    } else {
                        builder.putRating(str, (Rating) bundle.getParcelable(str));
                    }
                } else {
                    builder.putBitmap(str, (Bitmap) this.f.getParcelable(str));
                }
            }
            this.g = builder.build();
        }
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Bitmap z() {
        return v("android.media.metadata.DISPLAY_ICON", "android.media.metadata.ALBUM_ART", "android.media.metadata.ART");
    }

    public qh2(Bundle bundle) {
        Bundle bundle2 = new Bundle(bundle);
        this.f = bundle2;
        pi2.a(bundle2);
    }
}
