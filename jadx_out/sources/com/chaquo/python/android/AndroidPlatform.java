package com.chaquo.python.android;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.os.Build;
import com.chaquo.python.Python;
import com.chaquo.python.internal.Common;
import defpackage.ib3;
import defpackage.we5;
import defpackage.wg1;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class AndroidPlatform extends Python.Platform {
    public static String ABI;
    private AssetManager am;
    private JSONObject buildJson;
    public Application mContext;
    private SharedPreferences sp;
    private static final String[] OBSOLETE_FILES = {"app.zip", "requirements.zip", "chaquopy.mp3", "stdlib.mp3", "chaquopy.zip", "lib-dynload", "stdlib.zip", "bootstrap.zip", "stdlib-common.zip", "ticket.txt"};
    private static final String[] OBSOLETE_CACHE = {"AssetFinder"};

    public AndroidPlatform(Context context) {
        Application application = (Application) context.getApplicationContext();
        this.mContext = application;
        this.sp = application.getSharedPreferences(Common.ASSET_DIR, 0);
        this.am = this.mContext.getAssets();
        try {
            this.buildJson = new JSONObject(streamToString(this.am.open("chaquopy/build.json")));
            loadNativeLibs();
            for (String str : Build.SUPPORTED_ABIS) {
                try {
                    this.am.open("chaquopy/" + Common.assetZip(Common.ASSET_STDLIB, str));
                    ABI = str;
                    break;
                } catch (IOException unused) {
                }
            }
            if (ABI != null) {
                return;
            }
            throw new RuntimeException("None of this device's ABIs " + Arrays.toString(Build.SUPPORTED_ABIS) + " are supported by this app.");
        } catch (IOException | JSONException e) {
            wg1.a(e);
            throw null;
        }
    }

    private void cleanExtractedDir(String str, JSONObject jSONObject) {
        File file = new File(this.mContext.getFilesDir(), "chaquopy/" + str);
        for (String str2 : file.list()) {
            File file2 = new File(file, str2);
            if (file2.isDirectory()) {
                cleanExtractedDir(str + ServiceReference.DELIMITER + str2, jSONObject);
            } else {
                if (!jSONObject.has(str + ServiceReference.DELIMITER + str2)) {
                    file2.delete();
                }
            }
        }
    }

    private void deleteObsolete(File file, String[] strArr) {
        for (String str : strArr) {
            deleteRecursive(new File(file, "chaquopy/" + str.replace("<abi>", ABI)));
        }
    }

    private void deleteRecursive(File file) {
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles != null) {
            for (File file2 : fileArrListFiles) {
                deleteRecursive(file2);
            }
        }
        file.delete();
    }

    private void extractAsset(JSONObject jSONObject, SharedPreferences.Editor editor, String str) throws IOException {
        String str2 = "chaquopy/" + str;
        File file = new File(this.mContext.getFilesDir(), str2);
        String str3 = "asset." + str;
        String string = jSONObject.getString(str);
        if (file.exists() && this.sp.getString(str3, "").equals(string)) {
            return;
        }
        file.delete();
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            parentFile.mkdirs();
            if (!parentFile.isDirectory()) {
                we5.a("Failed to create ", parentFile);
                return;
            }
        }
        InputStream inputStreamOpen = this.am.open(str2);
        File file2 = new File(parentFile, file.getName() + ".tmp");
        file2.delete();
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            transferStream(inputStreamOpen, fileOutputStream);
            fileOutputStream.close();
            if (file2.renameTo(file)) {
                editor.putString(str3, string);
            } else {
                we5.a("Failed to create ", file);
            }
        } catch (Throwable th) {
            fileOutputStream.close();
            throw th;
        }
    }

    private void extractAssets(List<String> list) throws IOException {
        JSONObject jSONObject = this.buildJson.getJSONObject("assets");
        HashSet hashSet = new HashSet(list);
        HashSet hashSet2 = new HashSet();
        SharedPreferences.Editor editorEdit = this.sp.edit();
        Iterator<String> itKeys = jSONObject.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            for (String str : list) {
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
        Iterator it = hashSet2.iterator();
        while (it.hasNext()) {
            cleanExtractedDir((String) it.next(), jSONObject);
        }
        editorEdit.apply();
    }

    private void loadNativeLibs() {
        for (String str : Arrays.asList(Common.ASSET_DIR, "python")) {
            System.loadLibrary("crypto_" + str);
            System.loadLibrary("ssl_" + str);
            System.loadLibrary("sqlite3_" + str);
        }
        System.loadLibrary("python" + this.buildJson.getString("python_version"));
        System.loadLibrary("chaquopy_java");
    }

    private String streamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                return sb.toString();
            }
            sb.append(line);
            sb.append("\n");
        }
    }

    private void transferStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[1048576];
        int i = inputStream.read(bArr);
        while (i != -1) {
            outputStream.write(bArr, 0, i);
            i = inputStream.read(bArr);
        }
    }

    public Application getApplication() {
        return this.mContext;
    }

    @Override // com.chaquo.python.Python.Platform
    public String getPath() {
        String str = this.mContext.getFilesDir() + "/chaquopy";
        ArrayList arrayList = new ArrayList(Arrays.asList(Common.assetZip(Common.ASSET_STDLIB, Common.ABI_COMMON), Common.assetZip(Common.ASSET_BOOTSTRAP), "bootstrap-native/" + ABI));
        String strConcat = "";
        for (int i = 0; i < arrayList.size(); i++) {
            strConcat = strConcat + str + ServiceReference.DELIMITER + arrayList.get(i);
            if (i < arrayList.size() - 1) {
                strConcat = strConcat.concat(":");
            }
        }
        Collections.addAll(arrayList, Common.ASSET_CACERT);
        try {
            deleteObsolete(this.mContext.getFilesDir(), OBSOLETE_FILES);
            deleteObsolete(this.mContext.getCacheDir(), OBSOLETE_CACHE);
            extractAssets(arrayList);
            return strConcat;
        } catch (IOException | JSONException e) {
            wg1.a(e);
            return null;
        }
    }

    @Override // com.chaquo.python.Python.Platform
    public void onStart(Python python) {
        python.getModule("java.android").callAttr("initialize", this.mContext, this.buildJson, new String[]{Common.ASSET_APP, Common.ASSET_REQUIREMENTS, "stdlib-" + ABI});
    }

    public native void redirectStdioToLogcat();
}
