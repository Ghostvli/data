package defpackage;

import android.content.ContentUris;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.ui.activity.FileActivity;
import j$.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class g01 {
    public final q3 a;

    public g01(q3 q3Var) {
        this.a = q3Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
    
        if (r9 != null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String a(android.content.Context r8, android.net.Uri r9) {
        /*
            java.lang.String r0 = "_display_name"
            java.lang.String[] r3 = new java.lang.String[]{r0}
            r7 = 0
            android.content.ContentResolver r1 = r8.getContentResolver()     // Catch: java.lang.Exception -> L53
            r5 = 0
            r6 = 0
            r4 = 0
            r2 = r9
            android.database.Cursor r9 = r1.query(r2, r3, r4, r5, r6)     // Catch: java.lang.Exception -> L53
            if (r9 == 0) goto L50
            boolean r0 = r9.moveToFirst()     // Catch: java.lang.Throwable -> L44
            if (r0 != 0) goto L1c
            goto L50
        L1c:
            android.content.ContentResolver r8 = r8.getContentResolver()     // Catch: java.lang.Throwable -> L44
            java.io.InputStream r8 = r8.openInputStream(r2)     // Catch: java.lang.Throwable -> L44
            if (r8 != 0) goto L2a
        L26:
            r9.close()     // Catch: java.lang.Exception -> L53
            return r7
        L2a:
            r0 = 0
            r0 = r3[r0]     // Catch: java.lang.Throwable -> L44
            int r0 = r9.getColumnIndexOrThrow(r0)     // Catch: java.lang.Throwable -> L44
            java.lang.String r0 = r9.getString(r0)     // Catch: java.lang.Throwable -> L44
            java.io.File r0 = com.github.catvod.utils.Path.cache(r0)     // Catch: java.lang.Throwable -> L44
            com.github.catvod.utils.Path.copy(r8, r0)     // Catch: java.lang.Throwable -> L44
            java.lang.String r8 = r0.getAbsolutePath()     // Catch: java.lang.Throwable -> L44
            r9.close()     // Catch: java.lang.Exception -> L53
            return r8
        L44:
            r0 = move-exception
            r8 = r0
            r9.close()     // Catch: java.lang.Throwable -> L4a
            goto L4f
        L4a:
            r0 = move-exception
            r9 = r0
            r8.addSuppressed(r9)     // Catch: java.lang.Exception -> L53
        L4f:
            throw r8     // Catch: java.lang.Exception -> L53
        L50:
            if (r9 == 0) goto L53
            goto L26
        L53:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.g01.a(android.content.Context, android.net.Uri):java.lang.String");
    }

    public static g01 b(q3 q3Var) {
        return new g01(q3Var);
    }

    public static Uri c() {
        return Build.VERSION.SDK_INT >= 29 ? MediaStore.Audio.Media.getContentUri("external") : MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    }

    public static String d(Context context, Uri uri) {
        Cursor cursorQuery;
        String[] strArr = {"_data"};
        try {
            cursorQuery = context.getContentResolver().query(uri, strArr, null, null, null);
        } catch (Exception unused) {
        }
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(strArr[0]));
                    cursorQuery.close();
                    return string;
                }
                return null;
            } finally {
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    public static Uri e() {
        return Build.VERSION.SDK_INT >= 29 ? MediaStore.Files.getContentUri("external") : MediaStore.Files.getContentUri("external");
    }

    public static Uri f() {
        return Build.VERSION.SDK_INT >= 29 ? MediaStore.Images.Media.getContentUri("external") : MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }

    public static String g(Context context, Uri uri) {
        Cursor cursorQuery;
        String[] strArr = {"_display_name"};
        try {
            cursorQuery = context.getContentResolver().query(uri, strArr, null, null, null);
        } catch (Exception unused) {
        }
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(strArr[0]));
                    cursorQuery.close();
                    return string;
                }
                return null;
            } finally {
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    public static String h(Context context, Uri uri, String str) {
        String strG = g(context, uri);
        if (str.startsWith("raw:")) {
            return str.replaceFirst("raw:", "");
        }
        if (strG == null) {
            return d(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.parseLong(str)));
        }
        return Environment.getExternalStorageDirectory() + "/Download/" + strG;
    }

    public static String i(Context context, String[] strArr) {
        String str = strArr[0];
        str.getClass();
        switch (str) {
            case "audio":
                return d(context, ContentUris.withAppendedId(c(), Long.parseLong(strArr[1])));
            case "image":
                return d(context, ContentUris.withAppendedId(f(), Long.parseLong(strArr[1])));
            case "video":
                return d(context, ContentUris.withAppendedId(n(), Long.parseLong(strArr[1])));
            default:
                return d(context, ContentUris.withAppendedId(e(), Long.parseLong(strArr[1])));
        }
    }

    public static String j(String str, String[] strArr) {
        if (!"primary".equalsIgnoreCase(strArr[0])) {
            return "/storage/" + str.replace(":", ServiceReference.DELIMITER);
        }
        if (strArr.length <= 1) {
            return Environment.getExternalStorageDirectory() + ServiceReference.DELIMITER;
        }
        return Environment.getExternalStorageDirectory() + ServiceReference.DELIMITER + strArr[1];
    }

    public static String k(Context context, Uri uri) {
        String documentId = DocumentsContract.getDocumentId(uri);
        String[] strArrSplit = documentId.split(":");
        if (p(uri)) {
            return j(documentId, strArrSplit);
        }
        if (o(uri)) {
            return h(context, uri, documentId);
        }
        if (q(uri)) {
            return i(context, strArrSplit);
        }
        return null;
    }

    public static String l(Context context, Uri uri) {
        String path = null;
        if (uri == null) {
            return null;
        }
        if (DocumentsContract.isDocumentUri(context, uri)) {
            path = k(context, uri);
        } else if ("content".equals(uri.getScheme())) {
            path = d(context, uri);
        } else if ("file".equalsIgnoreCase(uri.getScheme())) {
            path = uri.getPath();
        }
        return path != null ? URLDecoder.decode(path, StandardCharsets.UTF_8) : a(context, uri);
    }

    public static String m(Uri uri) {
        return l(App.b(), uri);
    }

    public static Uri n() {
        return Build.VERSION.SDK_INT >= 29 ? MediaStore.Video.Media.getContentUri("external") : MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    }

    public static boolean o(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean p(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean q(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    public static boolean r(Context context, Uri uri) {
        try {
            if (DocumentsContract.isDocumentUri(context, uri) || "content".equals(uri.getScheme())) {
                return true;
            }
            return "file".equalsIgnoreCase(uri.getScheme());
        } catch (Exception unused) {
            return false;
        }
    }

    public void s() {
        t("*/*");
    }

    public void t(String str) {
        u(str, new String[]{"*/*"});
    }

    public void u(String str, String[] strArr) {
        Intent intent = new Intent("android.intent.action.OPEN_DOCUMENT");
        intent.setType(str);
        intent.addCategory("android.intent.category.OPENABLE");
        intent.putExtra("android.intent.extra.MIME_TYPES", strArr);
        intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", false);
        intent.putExtra("android.content.extra.SHOW_ADVANCED", true);
        List<ResolveInfo> listQueryIntentActivities = App.b().getPackageManager().queryIntentActivities(intent, 65536);
        if (jy4.o() || listQueryIntentActivities.isEmpty() || listQueryIntentActivities.get(0).activityInfo.packageName.contains("frameworkpackagestubs")) {
            this.a.a(new Intent(App.b(), (Class<?>) FileActivity.class));
        } else {
            this.a.a(Intent.createChooser(intent, ""));
        }
    }

    public void v(String[] strArr) {
        u("*/*", strArr);
    }
}
