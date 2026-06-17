package defpackage;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.a;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class zn4 {
    public static final r01 f = new r01();
    public final r01 a;
    public final xn4 b;
    public final ma c;
    public final ContentResolver d;
    public final List e;

    public zn4(List list, r01 r01Var, xn4 xn4Var, ma maVar, ContentResolver contentResolver) {
        this.a = r01Var;
        this.b = xn4Var;
        this.c = maVar;
        this.d = contentResolver;
        this.e = list;
    }

    public int a(Uri uri) {
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = this.d.openInputStream(uri);
                int iB = a.b(this.e, inputStreamOpenInputStream, this.c);
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return iB;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException | NullPointerException e) {
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e);
            }
            if (inputStreamOpenInputStream == null) {
                return -1;
            }
            try {
                inputStreamOpenInputStream.close();
                return -1;
            } catch (IOException unused3) {
                return -1;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0049  */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r2v2 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String b(android.net.Uri r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.String r0 = "ThumbStreamOpener"
            java.lang.String r1 = "Failed to query for thumbnail for Uri: "
            r2 = 0
            xn4 r5 = r5.b     // Catch: java.lang.Throwable -> L27 java.lang.SecurityException -> L29
            android.database.Cursor r5 = r5.a(r6)     // Catch: java.lang.Throwable -> L27 java.lang.SecurityException -> L29
            if (r5 == 0) goto L21
            boolean r3 = r5.moveToFirst()     // Catch: java.lang.Throwable -> L1c java.lang.SecurityException -> L1f
            if (r3 == 0) goto L21
            r3 = 0
            java.lang.String r6 = r5.getString(r3)     // Catch: java.lang.Throwable -> L1c java.lang.SecurityException -> L1f
            r5.close()
            return r6
        L1c:
            r6 = move-exception
            r2 = r5
            goto L47
        L1f:
            r3 = move-exception
            goto L2b
        L21:
            if (r5 == 0) goto L26
            r5.close()
        L26:
            return r2
        L27:
            r6 = move-exception
            goto L47
        L29:
            r3 = move-exception
            r5 = r2
        L2b:
            r4 = 3
            boolean r4 = android.util.Log.isLoggable(r0, r4)     // Catch: java.lang.Throwable -> L1c
            if (r4 == 0) goto L41
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L1c
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L1c
            r4.append(r6)     // Catch: java.lang.Throwable -> L1c
            java.lang.String r6 = r4.toString()     // Catch: java.lang.Throwable -> L1c
            android.util.Log.d(r0, r6, r3)     // Catch: java.lang.Throwable -> L1c
        L41:
            if (r5 == 0) goto L46
            r5.close()
        L46:
            return r2
        L47:
            if (r2 == 0) goto L4c
            r2.close()
        L4c:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.zn4.b(android.net.Uri):java.lang.String");
    }

    public final boolean c(File file) {
        return this.a.a(file) && 0 < this.a.c(file);
    }

    public InputStream d(Uri uri) throws Throwable {
        String strB = b(uri);
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        File fileB = this.a.b(strB);
        if (!c(fileB)) {
            return null;
        }
        Uri uriFromFile = Uri.fromFile(fileB);
        try {
            return this.d.openInputStream(uriFromFile);
        } catch (NullPointerException e) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + uriFromFile).initCause(e));
        }
    }

    public zn4(List list, xn4 xn4Var, ma maVar, ContentResolver contentResolver) {
        this(list, f, xn4Var, maVar, contentResolver);
    }
}
