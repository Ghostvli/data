package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import defpackage.t90;
import defpackage.vt2;
import java.io.File;
import java.io.FileNotFoundException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ir2 implements vt2 {
    public final Context a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements wt2 {
        public final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // defpackage.wt2
        public void d() {
        }

        @Override // defpackage.wt2
        public vt2 e(bw2 bw2Var) {
            return new ir2(this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b implements t90 {
        public static final String[] h = {"_data"};
        public final Context f;
        public final Uri g;

        public b(Context context, Uri uri) {
            this.f = context;
            this.g = uri;
        }

        @Override // defpackage.t90
        public Class a() {
            return File.class;
        }

        @Override // defpackage.t90
        public void b() {
        }

        @Override // defpackage.t90
        public void c(ug3 ug3Var, t90.a aVar) {
            Cursor cursorQuery = this.f.getContentResolver().query(this.g, h, null, null, null);
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                    cursorQuery.close();
                } catch (Throwable th) {
                    cursorQuery.close();
                    throw th;
                }
            }
            if (!TextUtils.isEmpty(string)) {
                aVar.f(new File(string));
                return;
            }
            aVar.d(new FileNotFoundException("Failed to find file path for: " + this.g));
        }

        @Override // defpackage.t90
        public void cancel() {
        }

        @Override // defpackage.t90
        public ba0 e() {
            return ba0.LOCAL;
        }
    }

    public ir2(Context context) {
        this.a = context;
    }

    @Override // defpackage.vt2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public vt2.a b(Uri uri, int i, int i2, u63 u63Var) {
        return new vt2.a(new t43(uri), new b(this.a, uri));
    }

    @Override // defpackage.vt2
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return kr2.d(uri);
    }
}
