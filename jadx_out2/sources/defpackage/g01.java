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
import com.github.catvod.utils.Path;
import j$.net.URLDecoder;
import java.io.File;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class g01 {
    public final q3 a;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g01(q3 q3Var) {
        this.a = q3Var;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0050, code lost:
    
        if (r9 != null) goto L10;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context, Uri uri) {
        Cursor cursorQuery;
        String[] strArr = {"_display_name"};
        try {
            cursorQuery = context.getContentResolver().query(uri, strArr, null, null, null);
        } catch (Exception unused) {
        }
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    InputStream inputStreamOpenInputStream = context.getContentResolver().openInputStream(uri);
                    if (inputStreamOpenInputStream != null) {
                        File fileCache = Path.cache(cursorQuery.getString(cursorQuery.getColumnIndexOrThrow(strArr[0])));
                        Path.copy(inputStreamOpenInputStream, fileCache);
                        String absolutePath = fileCache.getAbsolutePath();
                        cursorQuery.close();
                        return absolutePath;
                    }
                    cursorQuery.close();
                    return null;
                }
                return null;
            } finally {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static g01 b(q3 q3Var) {
        return new g01(q3Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Uri c() {
        return Build.VERSION.SDK_INT >= 29 ? MediaStore.Audio.Media.getContentUri("external") : MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Uri e() {
        return Build.VERSION.SDK_INT >= 29 ? MediaStore.Files.getContentUri("external") : MediaStore.Files.getContentUri("external");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Uri f() {
        return Build.VERSION.SDK_INT >= 29 ? MediaStore.Images.Media.getContentUri("external") : MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[THROW, INVOKE, MOVE_EXCEPTION, THROW, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String j(String str, String[] strArr) {
        if (!"primary".equalsIgnoreCase(strArr[0])) {
            return "/storage/" + str.replace(":", ServiceReference.DELIMITER);
        }
        if (strArr.length <= 1) {
            return Environment.getExternalStorageDirectory() + ServiceReference.DELIMITER;
        }
        return Environment.getExternalStorageDirectory() + ServiceReference.DELIMITER + strArr[1];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String m(Uri uri) {
        return l(App.b(), uri);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Uri n() {
        return Build.VERSION.SDK_INT >= 29 ? MediaStore.Video.Media.getContentUri("external") : MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean o(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean p(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean q(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void s() {
        t("*/*");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void t(String str) {
        u(str, new String[]{"*/*"});
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void v(String[] strArr) {
        u("*/*", strArr);
    }
}
