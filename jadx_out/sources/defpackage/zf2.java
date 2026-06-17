package defpackage;

import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class zf2 implements Parcelable {
    public static final Parcelable.Creator<zf2> CREATOR = new a();
    public final String f;
    public final CharSequence g;
    public final CharSequence h;
    public final CharSequence i;
    public final Bitmap j;
    public byte[] k;
    public final Uri l;
    public final Bundle m;
    public final Uri n;
    public MediaDescription o;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Parcelable.Creator {
        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public zf2 createFromParcel(Parcel parcel) {
            return zf2.c((MediaDescription) MediaDescription.CREATOR.createFromParcel(parcel));
        }

        @Override // android.os.Parcelable.Creator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public zf2[] newArray(int i) {
            return new zf2[i];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public String a;
        public CharSequence b;
        public CharSequence c;
        public CharSequence d;
        public Bitmap e;
        public Uri f;
        public Bundle g;
        public Uri h;

        public zf2 a() {
            return new zf2(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h);
        }

        public b b(CharSequence charSequence) {
            this.d = charSequence;
            return this;
        }

        public b c(Bundle bundle) {
            this.g = bundle;
            return this;
        }

        public b d(Bitmap bitmap) {
            this.e = bitmap;
            return this;
        }

        public b e(Uri uri) {
            this.f = uri;
            return this;
        }

        public b f(String str) {
            this.a = str;
            return this;
        }

        public b g(Uri uri) {
            this.h = uri;
            return this;
        }

        public b h(CharSequence charSequence) {
            this.c = charSequence;
            return this;
        }

        public b i(CharSequence charSequence) {
            this.b = charSequence;
            return this;
        }
    }

    public zf2(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f = str;
        this.g = charSequence;
        this.h = charSequence2;
        this.i = charSequence3;
        this.j = bitmap;
        this.l = uri;
        this.m = bundle;
        this.n = uri2;
    }

    public static zf2 c(MediaDescription mediaDescription) {
        b bVar = new b();
        bVar.f(mediaDescription.getMediaId());
        bVar.i(mediaDescription.getTitle());
        bVar.h(mediaDescription.getSubtitle());
        bVar.b(mediaDescription.getDescription());
        bVar.d(mediaDescription.getIconBitmap());
        bVar.e(mediaDescription.getIconUri());
        Bundle bundleY = fy4.y(mediaDescription.getExtras());
        if (bundleY != null) {
            bundleY = new Bundle(bundleY);
        }
        Uri uri = null;
        if (bundleY != null) {
            Uri uri2 = (Uri) bundleY.getParcelable("android.support.v4.media.description.MEDIA_URI");
            if (uri2 != null) {
                if (bundleY.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && bundleY.size() == 2) {
                    bundleY = null;
                } else {
                    bundleY.remove("android.support.v4.media.description.MEDIA_URI");
                    bundleY.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
                }
            }
            uri = uri2;
        }
        bVar.c(bundleY);
        if (uri != null) {
            bVar.g(uri);
        } else {
            bVar.g(mediaDescription.getMediaUri());
        }
        zf2 zf2VarA = bVar.a();
        zf2VarA.o = mediaDescription;
        return zf2VarA;
    }

    public CharSequence A() {
        return this.h;
    }

    public CharSequence B() {
        return this.g;
    }

    public void C(zf2 zf2Var) {
        Bitmap bitmap;
        Bitmap bitmap2;
        if (zf2Var.k == null || (bitmap = this.j) == null || (bitmap2 = zf2Var.j) == null || !bitmap.sameAs(bitmap2)) {
            return;
        }
        this.k = zf2Var.k;
    }

    public CharSequence d() {
        return this.i;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public Bundle s() {
        return this.m;
    }

    public String toString() {
        return ((Object) this.g) + ", " + ((Object) this.h) + ", " + ((Object) this.i);
    }

    public Bitmap u() {
        return this.j;
    }

    public byte[] v() {
        if (this.j == null) {
            return null;
        }
        if (this.k == null) {
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    this.j.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                    this.k = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                } finally {
                }
            } catch (IOException e) {
                xz1.j("MediaDescriptionCompat", "Failed to compress MediaDescriptionCompat artwork", e);
            }
        }
        return this.k;
    }

    public Uri w() {
        return this.l;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        x().writeToParcel(parcel, i);
    }

    public MediaDescription x() {
        MediaDescription mediaDescription = this.o;
        if (mediaDescription != null) {
            return mediaDescription;
        }
        MediaDescription.Builder builder = new MediaDescription.Builder();
        builder.setMediaId(this.f);
        builder.setTitle(this.g);
        builder.setSubtitle(this.h);
        builder.setDescription(this.i);
        builder.setIconBitmap(this.j);
        builder.setIconUri(this.l);
        builder.setExtras(this.m);
        builder.setMediaUri(this.n);
        MediaDescription mediaDescriptionBuild = builder.build();
        this.o = mediaDescriptionBuild;
        return mediaDescriptionBuild;
    }

    public String y() {
        return this.f;
    }

    public Uri z() {
        return this.n;
    }
}
