package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import com.chaquo.python.Python;
import com.chaquo.python.internal.Common;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.json.JSONException;
import org.json.JSONObject;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class pb3 extends Python.Platform {
    public static final String[] f = {"app.zip", "requirements.zip", "chaquopy.mp3", "stdlib.mp3", "chaquopy.zip", "lib-dynload", "stdlib.zip", "bootstrap.zip", "stdlib-common.zip", "ticket.txt"};
    public static final String[] g = {"AssetFinder"};
    public final SharedPreferences a;
    public final JSONObject b;
    public final AssetManager c;
    public final Context d;
    public String e;

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0090, code lost:
    
        if (r7.e == null) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0092, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0093, code lost:
    
        defpackage.ib3.a("No supported ABI found in: ", r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0098, code lost:
    
        throw null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public pb3() {
        /*
            r7 = this;
            r7.<init>()
            android.content.Context r0 = defpackage.yj1.a()
            r7.d = r0
            java.lang.String r1 = "chaquopy"
            r2 = 0
            android.content.SharedPreferences r1 = r0.getSharedPreferences(r1, r2)
            r7.a = r1
            android.content.res.AssetManager r0 = r0.getAssets()
            r7.c = r0
            r1 = 0
            java.lang.String r2 = "chaquopy/build.json"
            java.io.InputStream r0 = r0.open(r2)     // Catch: org.json.JSONException -> L30 java.io.IOException -> L33
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Throwable -> L99
            java.lang.String r3 = r7.streamToString(r0)     // Catch: java.lang.Throwable -> L99
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L99
            r7.b = r2     // Catch: java.lang.Throwable -> L99
            if (r0 == 0) goto L35
            r0.close()     // Catch: org.json.JSONException -> L30 java.io.IOException -> L33
            goto L35
        L30:
            r7 = move-exception
            goto La5
        L33:
            r7 = move-exception
            goto La5
        L35:
            r7.loadNativeLibs()     // Catch: org.json.JSONException -> L30 java.io.IOException -> L33
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String[] r2 = android.os.Build.SUPPORTED_ABIS
            java.util.Collections.addAll(r0, r2)
            java.lang.String r2 = android.os.Build.CPU_ABI
            java.lang.String r3 = android.os.Build.CPU_ABI2
            java.lang.String[] r2 = new java.lang.String[]{r2, r3}
            java.util.Collections.addAll(r0, r2)
            java.util.Iterator r2 = r0.iterator()
        L51:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L8e
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            android.content.res.AssetManager r4 = r7.c     // Catch: java.io.IOException -> L51
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.io.IOException -> L51
            r5.<init>()     // Catch: java.io.IOException -> L51
            java.lang.String r6 = "chaquopy/"
            r5.append(r6)     // Catch: java.io.IOException -> L51
            java.lang.String r6 = "stdlib"
            java.lang.String r6 = com.chaquo.python.internal.Common.assetZip(r6, r3)     // Catch: java.io.IOException -> L51
            r5.append(r6)     // Catch: java.io.IOException -> L51
            java.lang.String r5 = r5.toString()     // Catch: java.io.IOException -> L51
            java.io.InputStream r4 = r4.open(r5)     // Catch: java.io.IOException -> L51
            r7.e = r3     // Catch: java.lang.Throwable -> L82
            if (r4 == 0) goto L8e
            r4.close()     // Catch: java.io.IOException -> L51
            goto L8e
        L82:
            r3 = move-exception
            if (r4 == 0) goto L8d
            r4.close()     // Catch: java.lang.Throwable -> L89
            goto L8d
        L89:
            r4 = move-exception
            r3.addSuppressed(r4)     // Catch: java.io.IOException -> L51
        L8d:
            throw r3     // Catch: java.io.IOException -> L51
        L8e:
            java.lang.String r7 = r7.e
            if (r7 == 0) goto L93
            return
        L93:
            java.lang.String r7 = "No supported ABI found in: "
            defpackage.ib3.a(r7, r0)
            throw r1
        L99:
            r7 = move-exception
            if (r0 == 0) goto La4
            r0.close()     // Catch: java.lang.Throwable -> La0
            goto La4
        La0:
            r0 = move-exception
            r7.addSuppressed(r0)     // Catch: org.json.JSONException -> L30 java.io.IOException -> L33
        La4:
            throw r7     // Catch: org.json.JSONException -> L30 java.io.IOException -> L33
        La5:
            defpackage.wg1.a(r7)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pb3.<init>():void");
    }

    public static /* synthetic */ String a(String str, String str2) {
        return str + ServiceReference.DELIMITER + str2;
    }

    public static pb3 d() {
        return new pb3();
    }

    public final void cleanExtractedDir(final String str, final JSONObject jSONObject) {
        File[] fileArrListFiles = new File(this.d.getFilesDir(), "chaquopy/" + str).listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        Arrays.stream(fileArrListFiles).forEach(new Consumer() { // from class: kb3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.e(str, jSONObject, (File) obj);
            }
        });
    }

    public final void deleteObsolete(File file, String[] strArr) {
        for (String str : strArr) {
            deleteRecursive(new File(file, "chaquopy/" + str.replace("<abi>", this.e)));
        }
    }

    public final void deleteRecursive(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            Arrays.stream(fileArrListFiles).forEach(new Consumer() { // from class: lb3
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.deleteRecursive((File) obj);
                }
            });
        }
        file.delete();
    }

    public final /* synthetic */ void e(String str, JSONObject jSONObject, File file) {
        String name = file.getName();
        if (file.isDirectory()) {
            cleanExtractedDir(str + ServiceReference.DELIMITER + name, jSONObject);
            return;
        }
        if (jSONObject.has(str + ServiceReference.DELIMITER + name)) {
            return;
        }
        file.delete();
    }

    public final void extractAsset(JSONObject jSONObject, SharedPreferences.Editor editor, String str) throws IOException {
        String str2 = "chaquopy/" + str;
        File file = new File(this.d.getFilesDir(), str2);
        String str3 = "asset." + str;
        String string = jSONObject.getString(str);
        if (file.exists() && this.a.getString(str3, "").equals(string)) {
            return;
        }
        file.delete();
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs()) {
            we5.a("Failed to create ", parentFile);
            return;
        }
        File file2 = new File(parentFile, file.getName() + ".tmp");
        file2.delete();
        InputStream inputStreamOpen = this.c.open(str2);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                transferStream(inputStreamOpen, fileOutputStream);
                fileOutputStream.close();
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                if (file2.renameTo(file)) {
                    editor.putString(str3, string);
                } else {
                    we5.a("Failed to rename ", file2);
                }
            } finally {
            }
        } catch (Throwable th) {
            if (inputStreamOpen != null) {
                try {
                    inputStreamOpen.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public final void extractAssets(List list) throws IOException {
        JSONObject jSONObject = this.b.getJSONObject("assets");
        HashSet hashSet = new HashSet(list);
        HashSet hashSet2 = new HashSet();
        SharedPreferences.Editor editorEdit = this.a.edit();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                if (!next.equals(str)) {
                    if (next.startsWith(str + ServiceReference.DELIMITER)) {
                    }
                }
                extractAsset(jSONObject, editorEdit, next);
                hashSet.remove(str);
                if (next.startsWith(str + ServiceReference.DELIMITER)) {
                    hashSet2.add(str);
                }
            }
        }
        if (!hashSet.isEmpty()) {
            ib3.a("Failed to find assets: ", hashSet);
            return;
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            cleanExtractedDir((String) it2.next(), jSONObject);
        }
        editorEdit.apply();
    }

    @Override // com.chaquo.python.Python.Platform
    public String getPath() {
        final String absolutePath = new File(this.d.getFilesDir(), Common.ASSET_DIR).getAbsolutePath();
        List listAsList = Arrays.asList(Common.assetZip(Common.ASSET_STDLIB, Common.ABI_COMMON), Common.assetZip(Common.ASSET_BOOTSTRAP), "bootstrap-native/" + this.e);
        String str = (String) listAsList.stream().map(new Function() { // from class: jb3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return pb3.a(absolutePath, (String) obj);
            }
        }).collect(Collectors.joining(":"));
        ArrayList arrayList = new ArrayList(listAsList);
        arrayList.add(Common.ASSET_CACERT);
        try {
            deleteObsolete(this.d.getFilesDir(), f);
            deleteObsolete(this.d.getCacheDir(), g);
            extractAssets(arrayList);
            return str;
        } catch (IOException | JSONException e) {
            wg1.a(e);
            return null;
        }
    }

    public final void loadNativeLibs() {
        String[] strArr = {"crypto_chaquopy", "ssl_chaquopy", "sqlite3_chaquopy", "python" + this.b.getString("python_version"), "chaquopy_java"};
        for (int i = 0; i < 5; i++) {
            System.loadLibrary(strArr[i]);
        }
    }

    @Override // com.chaquo.python.Python.Platform
    public void onStart(Python python) {
        python.getModule("java.android").callAttr("initialize", this.d, this.b, new String[]{Common.ASSET_APP, Common.ASSET_REQUIREMENTS, "stdlib-" + this.e});
    }

    public final String streamToString(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        transferStream(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
    }

    public final void transferStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        while (true) {
            int i = inputStream.read(bArr);
            if (i == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, i);
            }
        }
    }
}
