package defpackage;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import defpackage.t90;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class un4 implements t90 {
    public final Uri f;
    public final zn4 g;
    public InputStream h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a implements xn4 {
        public static final String[] b = {"_data"};
        public final ContentResolver a;

        public a(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // defpackage.xn4
        public Cursor a(Uri uri) {
            return this.a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b implements xn4 {
        public static final String[] b = {"_data"};
        public final ContentResolver a;

        public b(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // defpackage.xn4
        public Cursor a(Uri uri) {
            return this.a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    public un4(Uri uri, zn4 zn4Var) {
        this.f = uri;
        this.g = zn4Var;
    }

    public static un4 d(Context context, Uri uri, xn4 xn4Var) {
        return new un4(uri, new zn4(com.bumptech.glide.a.c(context).j().g(), xn4Var, com.bumptech.glide.a.c(context).e(), context.getContentResolver()));
    }

    public static un4 f(Context context, Uri uri) {
        return d(context, uri, new a(context.getContentResolver()));
    }

    public static un4 g(Context context, Uri uri) {
        return d(context, uri, new b(context.getContentResolver()));
    }

    @Override // defpackage.t90
    public Class a() {
        return InputStream.class;
    }

    @Override // defpackage.t90
    public void b() {
        InputStream inputStream = this.h;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // defpackage.t90
    public void c(ug3 ug3Var, t90.a aVar) throws Throwable {
        try {
            InputStream inputStreamH = h();
            this.h = inputStreamH;
            aVar.f(inputStreamH);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e);
            }
            aVar.d(e);
        }
    }

    @Override // defpackage.t90
    public void cancel() {
    }

    @Override // defpackage.t90
    public ba0 e() {
        return ba0.LOCAL;
    }

    public final InputStream h() throws Throwable {
        InputStream inputStreamD = this.g.d(this.f);
        int iA = inputStreamD != null ? this.g.a(this.f) : -1;
        return iA != -1 ? new xv0(inputStreamD, iA) : inputStreamD;
    }
}
