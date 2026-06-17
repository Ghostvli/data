package defpackage;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.util.Log;
import defpackage.t90;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class hz1 implements t90 {
    public final boolean f;
    public final Uri g;
    public final ContentResolver h;
    public Object i;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public hz1(ContentResolver contentResolver, Uri uri, boolean z) {
        this.h = contentResolver;
        this.g = uri;
        this.f = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.t90
    public void b() {
        Object obj = this.i;
        if (obj != null) {
            try {
                d(obj);
            } catch (IOException unused) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.t90
    public final void c(ug3 ug3Var, t90.a aVar) {
        try {
            Object objF = f(this.g, this.h);
            this.i = objF;
            aVar.f(objF);
        } catch (FileNotFoundException e) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e);
            }
            aVar.d(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.t90
    public void cancel() {
    }

    public abstract void d(Object obj);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.t90
    public ba0 e() {
        return ba0.LOCAL;
    }

    public abstract Object f(Uri uri, ContentResolver contentResolver);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AssetFileDescriptor g(Uri uri) {
        return (this.f && kr2.d(uri) && kr2.c()) ? kr2.h(uri, this.h) : this.h.openAssetFileDescriptor(uri, "r");
    }
}
