package defpackage;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Build;
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
import java.util.Collections;
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
    */
    public pb3() {
        Context contextA = yj1.a();
        this.d = contextA;
        this.a = contextA.getSharedPreferences(Common.ASSET_DIR, 0);
        AssetManager assets = contextA.getAssets();
        this.c = assets;
        try {
            InputStream inputStreamOpen = assets.open("chaquopy/build.json");
            try {
                this.b = new JSONObject(streamToString(inputStreamOpen));
                if (inputStreamOpen != null) {
                    inputStreamOpen.close();
                }
                loadNativeLibs();
                ArrayList arrayList = new ArrayList();
                Collections.addAll(arrayList, Build.SUPPORTED_ABIS);
                Collections.addAll(arrayList, Build.CPU_ABI, Build.CPU_ABI2);
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String str = (String) it.next();
                    try {
                        InputStream inputStreamOpen2 = this.c.open("chaquopy/" + Common.assetZip(Common.ASSET_STDLIB, str));
                        try {
                            continue;
                            this.e = str;
                            if (inputStreamOpen2 != null) {
                                inputStreamOpen2.close();
                            }
                        } finally {
                            if (inputStreamOpen2 == null) {
                                break;
                            } else {
                                try {
                                    break;
                                } catch (Throwable th) {
                                }
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            } catch (Throwable th2) {
                if (inputStreamOpen != null) {
                    try {
                        inputStreamOpen.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                }
                throw th2;
            }
        } catch (IOException e) {
            e = e;
            wg1.a(e);
            throw null;
        } catch (JSONException e2) {
            e = e2;
            wg1.a(e);
            throw null;
        }
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: STR_CONCAT 
      (r1v0 java.lang.String)
      (wrap:java.lang.String:SGET  A[WRAPPED] org.jupnp.model.ServiceReference.DELIMITER java.lang.String)
      (r2v0 java.lang.String)
     A[MD:():java.lang.String (c), SYNTHETIC] (LINE:17) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ String a(String str, String str2) {
        return str + ServiceReference.DELIMITER + str2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static pb3 d() {
        return new pb3();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void cleanExtractedDir(final String str, final JSONObject jSONObject) {
        File[] fileArrListFiles = new File(this.d.getFilesDir(), "chaquopy/" + str).listFiles();
        if (fileArrListFiles == null) {
            return;
        }
        Arrays.stream(fileArrListFiles).forEach(new Consumer() { // from class: kb3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.e(str, jSONObject, (File) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void deleteObsolete(File file, String[] strArr) {
        for (String str : strArr) {
            deleteRecursive(new File(file, "chaquopy/" + str.replace("<abi>", this.e)));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void deleteRecursive(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            Arrays.stream(fileArrListFiles).forEach(new Consumer() { // from class: lb3
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.deleteRecursive((File) obj);
                }
            });
        }
        file.delete();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[INVOKE, MOVE_EXCEPTION, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.chaquo.python.Python.Platform
    public String getPath() {
        final String absolutePath = new File(this.d.getFilesDir(), Common.ASSET_DIR).getAbsolutePath();
        List listAsList = Arrays.asList(Common.assetZip(Common.ASSET_STDLIB, Common.ABI_COMMON), Common.assetZip(Common.ASSET_BOOTSTRAP), "bootstrap-native/" + this.e);
        String str = (String) listAsList.stream().map(new Function() { // from class: jb3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void loadNativeLibs() {
        String[] strArr = {"crypto_chaquopy", "ssl_chaquopy", "sqlite3_chaquopy", "python" + this.b.getString("python_version"), "chaquopy_java"};
        for (int i = 0; i < 5; i++) {
            System.loadLibrary(strArr[i]);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.chaquo.python.Python.Platform
    public void onStart(Python python) {
        python.getModule("java.android").callAttr("initialize", this.d, this.b, new String[]{Common.ASSET_APP, Common.ASSET_REQUIREMENTS, "stdlib-" + this.e});
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String streamToString(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        transferStream(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
