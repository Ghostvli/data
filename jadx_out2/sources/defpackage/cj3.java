package defpackage;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import defpackage.t90;
import defpackage.vt2;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class cj3 implements vt2 {
    public final Context a;
    public final vt2 b;
    public final vt2 c;
    public final Class d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class a implements wt2 {
        public final Context a;
        public final Class b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(Context context, Class cls) {
            this.a = context;
            this.b = cls;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.wt2
        public final void d() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.wt2
        public final vt2 e(bw2 bw2Var) {
            return new cj3(this.a, bw2Var.d(File.class, this.b), bw2Var.d(Uri.class, this.b), this.b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends a {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends a {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d implements t90 {
        public static final String[] p = {"_data"};
        public final Context f;
        public final vt2 g;
        public final vt2 h;
        public final Uri i;
        public final int j;
        public final int k;
        public final u63 l;
        public final Class m;
        public volatile boolean n;
        public volatile t90 o;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(Context context, vt2 vt2Var, vt2 vt2Var2, Uri uri, int i, int i2, u63 u63Var, Class cls) {
            this.f = context.getApplicationContext();
            this.g = vt2Var;
            this.h = vt2Var2;
            this.i = uri;
            this.j = i;
            this.k = i2;
            this.l = u63Var;
            this.m = cls;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.t90
        public Class a() {
            return this.m;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.t90
        public void b() {
            t90 t90Var = this.o;
            if (t90Var != null) {
                t90Var.b();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.t90
        public void c(ug3 ug3Var, t90.a aVar) {
            try {
                t90 t90VarF = f();
                if (t90VarF == null) {
                    aVar.d(new IllegalArgumentException("Failed to build fetcher for: " + this.i));
                } else {
                    this.o = t90VarF;
                    if (this.n) {
                        cancel();
                    } else {
                        t90VarF.c(ug3Var, aVar);
                    }
                }
            } catch (FileNotFoundException e) {
                aVar.d(e);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.t90
        public void cancel() {
            this.n = true;
            t90 t90Var = this.o;
            if (t90Var != null) {
                t90Var.cancel();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final vt2.a d() {
            if (Environment.isExternalStorageLegacy()) {
                return this.g.b(h(this.i), this.j, this.k, this.l);
            }
            if (kr2.a(this.i)) {
                return this.h.b(this.i, this.j, this.k, this.l);
            }
            boolean zG = g();
            Uri requireOriginal = this.i;
            if (zG) {
                requireOriginal = MediaStore.setRequireOriginal(requireOriginal);
            }
            return this.h.b(requireOriginal, this.j, this.k, this.l);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.t90
        public ba0 e() {
            return ba0.LOCAL;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final t90 f() {
            vt2.a aVarD = d();
            if (aVarD != null) {
                return aVarD.c;
            }
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean g() {
            return this.f.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
        public final File h(Uri uri) {
            try {
                Cursor cursorQuery = this.f.getContentResolver().query(uri, p, null, null, null);
                if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                    throw new FileNotFoundException("Failed to media store entry for: " + uri);
                }
                String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                if (TextUtils.isEmpty(string)) {
                    throw new FileNotFoundException("File path was empty in media store for: " + uri);
                }
                File file = new File(string);
                cursorQuery.close();
                return file;
            } finally {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public cj3(Context context, vt2 vt2Var, vt2 vt2Var2, Class cls) {
        this.a = context.getApplicationContext();
        this.b = vt2Var;
        this.c = vt2Var2;
        this.d = cls;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: b(Ljava/lang/Object;IILu63;)Lvt2$a; */
    @Override // defpackage.vt2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public vt2.a b(Uri uri, int i, int i2, u63 u63Var) {
        return new vt2.a(new t43(uri), new d(this.a, this.b, this.c, uri, i, i2, u63Var, this.d));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)Z */
    @Override // defpackage.vt2
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && kr2.d(uri);
    }
}
