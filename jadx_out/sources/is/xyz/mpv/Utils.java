package is.xyz.mpv;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.os.storage.StorageManager;
import android.os.storage.StorageVolume;
import android.provider.Settings;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.chaquo.python.internal.Common;
import defpackage.d63;
import defpackage.en;
import defpackage.fw4;
import defpackage.gm;
import defpackage.hp1;
import defpackage.il1;
import defpackage.l35;
import defpackage.lk1;
import defpackage.mp3;
import defpackage.nl;
import defpackage.np3;
import defpackage.o24;
import defpackage.ok1;
import defpackage.pw;
import defpackage.sg4;
import defpackage.sk1;
import defpackage.w95;
import defpackage.wg4;
import defpackage.xn3;
import defpackage.z01;
import is.xyz.mpv.MPV;
import is.xyz.mpv.Utils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import kotlin.jvm.functions.Function1;
import org.jupnp.model.Namespace;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class Utils {
    public static final Utils INSTANCE = new Utils();
    private static final String TAG = "mpv";
    private static final Set<String> MEDIA_EXTENSIONS = o24.f("cue", "m3u", "m3u8", "pls", "vlc", "3ga", "3ga2", "a52", "aac", "ac3", "ac4", "adt", "adts", "aif", "aifc", "aiff", "alac", "amr", "ape", "au", "awb", "dsf", "dts", "dts-hd", "dtshd", "eac3", "f4a", "flac", "lc3", "lpcm", "m1a", "m2a", "m4a", "mka", "mlp", "mp+", "mp1", "mp2", "mp3", "mpa", "mpc", "mpga", "mpp", "oga", "ogg", "opus", "pcm", "qoa", "ra", "ram", "rax", "shn", "snd", "spx", "tak", "thd", "thd+ac3", "true-hd", "truehd", "tta", "wav", "weba", "wma", "wv", "wvp", "264", "265", "266", "3g2", "3ga", "3gp", "3gp2", "3gpp", "3gpp2", "amr", "asf", "asx", "av1", "avc", "avf", "avi", "bdm", "bdmv", "clpi", "cpi", "divx", "dv", "evo", "evob", "f4v", "flc", "fli", "flic", "flv", "gxf", "h264", "h265", "h266", "hdmov", "hdv", "hevc", "lrv", "m1u", "m1v", "m2t", "m2ts", "m2v", "m4u", "m4v", "mk3d", "mkv", "mj2", "mov", "mp2", "mp2v", "mp4", "mp4v", "mpe", "mpeg", "mpeg2", "mpeg4", "mpg", "mpg4", "mpl", TAG, "mpv2", "mts", "mtv", "mxf", "mxu", "nsv", "nut", "ogg", "ogm", "ogv", "ogx", "qt", "qtvr", "rm", "rmj", "rmm", "rms", "rmvb", "rmx", "rv", "rvx", "sdp", "tod", "trp", "ts", "tsa", "tsv", "tts", "vc1", "vfw", "vob", "vro", "vvc", "webm", "wm", "wmv", "wmx", "x264", "x265", "xvid", "y4m", "yuv", "apng", "avif", "bmp", "exr", "gif", "heic", "heif", "j2c", "j2k", "jfif", "jp2", "jpc", "jpe", "jpeg", "jpg", "jpg2", "png", "qoi", "tga", "tif", "tiff", "webp");
    private static final Set<String> PROTOCOLS = o24.f("file", "content", "http", "https", "data", "ftp", "rtmp", "rtmps", "rtp", "rtsp", "mms", "mmst", "mmsh", "tcp", "udp", "lavf");
    private static final Versions VERSIONS = new Versions("v0.41.0-174-g76a5eba99", "\u0002\u00054(", "v7.360.0 (v7.360.0)", "a7522f3fef");

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class StoragePath {
        private final String description;
        private final File path;

        public StoragePath(File file, String str) {
            file.getClass();
            str.getClass();
            this.path = file;
            this.description = str;
        }

        public static /* synthetic */ StoragePath copy$default(StoragePath storagePath, File file, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                file = storagePath.path;
            }
            if ((i & 2) != 0) {
                str = storagePath.description;
            }
            return storagePath.copy(file, str);
        }

        public final File component1() {
            return this.path;
        }

        public final String component2() {
            return this.description;
        }

        public final StoragePath copy(File file, String str) {
            file.getClass();
            str.getClass();
            return new StoragePath(file, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof StoragePath)) {
                return false;
            }
            StoragePath storagePath = (StoragePath) obj;
            return il1.a(this.path, storagePath.path) && il1.a(this.description, storagePath.description);
        }

        public final String getDescription() {
            return this.description;
        }

        public final File getPath() {
            return this.path;
        }

        public int hashCode() {
            return (this.path.hashCode() * 31) + this.description.hashCode();
        }

        public String toString() {
            return "StoragePath(path=" + this.path + ", description=" + this.description + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Versions {
        private final String buildDate;
        private final String ffmpeg;
        private final String libPlacebo;
        private final String mpv;

        public Versions(String str, String str2, String str3, String str4) {
            str.getClass();
            str2.getClass();
            str3.getClass();
            str4.getClass();
            this.mpv = str;
            this.buildDate = str2;
            this.libPlacebo = str3;
            this.ffmpeg = str4;
        }

        public static /* synthetic */ Versions copy$default(Versions versions, String str, String str2, String str3, String str4, int i, Object obj) {
            if ((i & 1) != 0) {
                str = versions.mpv;
            }
            if ((i & 2) != 0) {
                str2 = versions.buildDate;
            }
            if ((i & 4) != 0) {
                str3 = versions.libPlacebo;
            }
            if ((i & 8) != 0) {
                str4 = versions.ffmpeg;
            }
            return versions.copy(str, str2, str3, str4);
        }

        public final String component1() {
            return this.mpv;
        }

        public final String component2() {
            return this.buildDate;
        }

        public final String component3() {
            return this.libPlacebo;
        }

        public final String component4() {
            return this.ffmpeg;
        }

        public final Versions copy(String str, String str2, String str3, String str4) {
            str.getClass();
            str2.getClass();
            str3.getClass();
            str4.getClass();
            return new Versions(str, str2, str3, str4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Versions)) {
                return false;
            }
            Versions versions = (Versions) obj;
            return il1.a(this.mpv, versions.mpv) && il1.a(this.buildDate, versions.buildDate) && il1.a(this.libPlacebo, versions.libPlacebo) && il1.a(this.ffmpeg, versions.ffmpeg);
        }

        public final String getBuildDate() {
            return this.buildDate;
        }

        public final String getFfmpeg() {
            return this.ffmpeg;
        }

        public final String getLibPlacebo() {
            return this.libPlacebo;
        }

        public final String getMpv() {
            return this.mpv;
        }

        public int hashCode() {
            return (((((this.mpv.hashCode() * 31) + this.buildDate.hashCode()) * 31) + this.libPlacebo.hashCode()) * 31) + this.ffmpeg.hashCode();
        }

        public String toString() {
            return "Versions(mpv=" + this.mpv + ", buildDate=" + this.buildDate + ", libPlacebo=" + this.libPlacebo + ", ffmpeg=" + this.ffmpeg + ")";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Padding {
        private final int bottom;
        private final int left;
        private final int right;
        private final int top;

        public Padding(int i, int i2, int i3, int i4) {
            this.left = i;
            this.top = i2;
            this.right = i3;
            this.bottom = i4;
        }

        public static /* synthetic */ Padding copy$default(Padding padding, int i, int i2, int i3, int i4, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                i = padding.left;
            }
            if ((i5 & 2) != 0) {
                i2 = padding.top;
            }
            if ((i5 & 4) != 0) {
                i3 = padding.right;
            }
            if ((i5 & 8) != 0) {
                i4 = padding.bottom;
            }
            return padding.copy(i, i2, i3, i4);
        }

        public final int component1() {
            return this.left;
        }

        public final int component2() {
            return this.top;
        }

        public final int component3() {
            return this.right;
        }

        public final int component4() {
            return this.bottom;
        }

        public final Padding copy(int i, int i2, int i3, int i4) {
            return new Padding(i, i2, i3, i4);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Padding)) {
                return false;
            }
            Padding padding = (Padding) obj;
            return this.left == padding.left && this.top == padding.top && this.right == padding.right && this.bottom == padding.bottom;
        }

        public final int getBottom() {
            return this.bottom;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getRight() {
            return this.right;
        }

        public final int getTop() {
            return this.top;
        }

        public int hashCode() {
            return (((((Integer.hashCode(this.left) * 31) + Integer.hashCode(this.top)) * 31) + Integer.hashCode(this.right)) * 31) + Integer.hashCode(this.bottom);
        }

        public String toString() {
            return "Padding(left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + ")";
        }
    }

    private Utils() {
    }

    public static StorageVolume a(StorageManager storageManager, File file) {
        file.getClass();
        try {
            return storageManager.getStorageVolume(file);
        } catch (SecurityException unused) {
            return null;
        }
    }

    public static w95 b(mp3 mp3Var, View view, View view2, w95 w95Var) {
        view2.getClass();
        w95Var.getClass();
        lk1 lk1VarF = w95Var.f(w95.n.e());
        lk1VarF.getClass();
        if (mp3Var.f == null) {
            mp3Var.f = new Padding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
        }
        Object obj = mp3Var.f;
        obj.getClass();
        Padding padding = (Padding) obj;
        view.setPadding(padding.getLeft() + lk1VarF.a, padding.getTop() + lk1VarF.b, padding.getRight() + lk1VarF.c, padding.getBottom() + lk1VarF.d);
        return w95Var;
    }

    public static fw4 c(List list, String str) {
        str.getClass();
        String str2 = (String) wg4.C0(str, new char[]{' '}, false, 0, 6, null).get(1);
        if (sg4.K(str2, "/proc", false, 2, null) || sg4.K(str2, "/sys", false, 2, null) || sg4.K(str2, Namespace.DEVICE, false, 2, null) || sg4.K(str2, "/apex", false, 2, null)) {
            return fw4.a;
        }
        list.add(str2);
        return fw4.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [android.content.res.AssetManager] */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v3, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.io.InputStream] */
    private final boolean copyAssetFile(AssetManager assetManager, String str, File file) throws Throwable {
        FileOutputStream fileOutputStream = null;
        try {
            try {
                assetManager = assetManager.open(str, 2);
                try {
                    long jAvailable = assetManager.available();
                    if (file.length() == jAvailable) {
                        Log.v(TAG, "Skipping copy of asset file (exists same size): " + str);
                        assetManager.close();
                        return true;
                    }
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        en.b(assetManager, fileOutputStream2, 0, 2, null);
                        Log.w(TAG, "Copied asset file (" + jAvailable + " bytes): " + str);
                        fileOutputStream2.close();
                        assetManager.close();
                        return true;
                    } catch (IOException e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        Log.e(TAG, "Failed to copy asset file: " + str, e);
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (assetManager != 0) {
                            assetManager.close();
                        }
                        return false;
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        if (assetManager != 0) {
                            assetManager.close();
                        }
                        throw th;
                    }
                } catch (IOException e2) {
                    e = e2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        } catch (IOException e3) {
            e = e3;
            assetManager = 0;
        } catch (Throwable th3) {
            th = th3;
            assetManager = 0;
        }
    }

    public static /* synthetic */ String prettyTime$default(Utils utils, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return utils.prettyTime(i, z);
    }

    public final int convertDp(Context context, float f) {
        context.getClass();
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public final void copyAssets(Context context) throws Throwable {
        context.getClass();
        AssetManager assets = context.getAssets();
        String[] strArr = {"subfont.ttf", Common.ASSET_CACERT};
        String path = context.getFilesDir().getPath();
        for (int i = 0; i < 2; i++) {
            String str = strArr[i];
            assets.getClass();
            copyAssetFile(assets, str, new File(path + ServiceReference.DELIMITER + str));
        }
    }

    public final String fileBasename(String str) {
        str.getClass();
        boolean z = wg4.a0(str, "://", 0, false, 6, null) != -1;
        String strQ0 = wg4.Q0(wg4.x0(str, '/', "", null, 4, null), '/');
        if (!z) {
            return strQ0;
        }
        String strDecode = Uri.decode(wg4.P0(wg4.v0(strQ0, '?', "", null, 4, null), '?'));
        strDecode.getClass();
        return strDecode;
    }

    public final String findRealPath(int i) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            String canonicalPath = new File("/proc/self/fd/" + i).getCanonicalPath();
            canonicalPath.getClass();
            if (!sg4.K(canonicalPath, "/proc", false, 2, null) && new File(canonicalPath).canRead()) {
                fileInputStream = new FileInputStream(canonicalPath);
                try {
                    fileInputStream.read();
                    fileInputStream.close();
                    return canonicalPath;
                } catch (Exception unused) {
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    return null;
                } catch (Throwable th) {
                    th = th;
                    fileInputStream2 = fileInputStream;
                    if (fileInputStream2 != null) {
                        fileInputStream2.close();
                    }
                    throw th;
                }
            }
        } catch (Exception unused2) {
            fileInputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
        return null;
    }

    public final Set<String> getMEDIA_EXTENSIONS() {
        return MEDIA_EXTENSIONS;
    }

    public final Set<String> getPROTOCOLS() {
        return PROTOCOLS;
    }

    public final /* synthetic */ <T extends Parcelable> T[] getParcelableArray(Bundle bundle, String str) {
        bundle.getClass();
        str.getClass();
        il1.d(4, "T");
        Parcelable[] parcelableArrA = gm.a(bundle, str, Parcelable.class);
        if (parcelableArrA == null) {
            il1.d(0, "T");
            return (T[]) new Parcelable[0];
        }
        ArrayList arrayList = new ArrayList();
        for (Parcelable parcelable : parcelableArrA) {
            il1.d(2, "T");
            if (parcelable != null) {
                arrayList.add(parcelable);
            }
        }
        il1.d(0, "T?");
        return (T[]) ((Parcelable[]) arrayList.toArray(new Object[0]));
    }

    public final Float getScreenBrightness(Activity activity) {
        activity.getClass();
        float f = activity.getWindow().getAttributes().screenBrightness;
        if (f >= 0.0f) {
            return Float.valueOf(f);
        }
        try {
            return Float.valueOf(Settings.System.getInt(activity.getContentResolver(), "screen_brightness") / 255.0f);
        } catch (Settings.SettingNotFoundException unused) {
            return null;
        }
    }

    @SuppressLint({"NewApi"})
    public final List<StoragePath> getStorageVolumes(Context context) throws IllegalAccessException, IOException, InvocationTargetException {
        context.getClass();
        ArrayList arrayList = new ArrayList();
        Object systemService = context.getSystemService("storage");
        systemService.getClass();
        final StorageManager storageManager = (StorageManager) systemService;
        final ArrayList arrayList2 = new ArrayList();
        File[] externalMediaDirs = context.getExternalMediaDirs();
        externalMediaDirs.getClass();
        for (File file : externalMediaDirs) {
            if (file != null) {
                String absolutePath = file.getAbsolutePath();
                absolutePath.getClass();
                arrayList2.add(absolutePath);
            }
        }
        z01.b(new File("/proc/mounts"), null, new Function1() { // from class: oy4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Utils.c(arrayList2, (String) obj);
            }
        }, 1, null);
        Function1 function1 = new Function1() { // from class: qy4
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return Utils.a(storageManager, (File) obj);
            }
        };
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            File file2 = new File((String) it.next());
            StorageVolume storageVolume = (StorageVolume) function1.invoke(file2);
            if (storageVolume != null && (il1.a(storageVolume.getState(), "mounted") || il1.a(storageVolume.getState(), "mounted_ro"))) {
                while (true) {
                    File parentFile = file2.getParentFile();
                    if (parentFile == null || !il1.a(function1.invoke(parentFile), storageVolume)) {
                        break;
                    }
                    file2 = parentFile;
                }
                if (!arrayList.isEmpty()) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        if (il1.a(((StoragePath) it2.next()).getPath(), file2)) {
                            break;
                        }
                    }
                }
                String description = storageVolume.getDescription(context);
                description.getClass();
                arrayList.add(new StoragePath(file2, description));
            }
        }
        return arrayList;
    }

    public final Versions getVERSIONS() {
        return VERSIONS;
    }

    public final void handleInsetsAsPadding(final View view) {
        view.getClass();
        final mp3 mp3Var = new mp3();
        l35.p0(view, new d63() { // from class: sy4
            @Override // defpackage.d63
            public final w95 a(View view2, w95 w95Var) {
                return Utils.b(mp3Var, view, view2, w95Var);
            }
        });
    }

    public final boolean isXLargeTablet(Context context) {
        context.getClass();
        return (context.getResources().getConfiguration().screenLayout & 15) >= 4;
    }

    public final String prettyTime(int i, boolean z) {
        if (!z) {
            int i2 = i / 3600;
            int i3 = (i % 3600) / 60;
            int i4 = i % 60;
            return i2 == 0 ? String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i3), Integer.valueOf(i4)}, 2)) : String.format("%d:%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}, 3));
        }
        return (i >= 0 ? "+" : "-") + prettyTime$default(this, Math.abs(i), false, 2, null);
    }

    public final void viewGroupMove(ViewGroup viewGroup, int i, ViewGroup viewGroup2, int i2) {
        Object next;
        viewGroup.getClass();
        viewGroup2.getClass();
        sk1 sk1VarJ = xn3.j(0, viewGroup.getChildCount());
        ArrayList arrayList = new ArrayList(pw.t(sk1VarJ, 10));
        Iterator it = sk1VarJ.iterator();
        while (it.hasNext()) {
            arrayList.add(viewGroup.getChildAt(((ok1) it).nextInt()));
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (!it2.hasNext()) {
                next = null;
                break;
            } else {
                next = it2.next();
                if (((View) next).getId() == i) {
                    break;
                }
            }
        }
        View view = (View) next;
        if (view != null) {
            viewGroup.removeView(view);
            if (i2 < 0) {
                i2 += viewGroup2.getChildCount() + 1;
            }
            viewGroup2.addView(view, i2);
            return;
        }
        throw new IllegalStateException((viewGroup + " does not have child with id=" + i).toString());
    }

    public final void viewGroupReorder(ViewGroup viewGroup, Integer[] numArr) {
        viewGroup.getClass();
        numArr.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            linkedHashMap.put(Integer.valueOf(childAt.getId()), childAt);
        }
        viewGroup.removeAllViews();
        for (Integer num : numArr) {
            int iIntValue = num.intValue();
            View view = (View) linkedHashMap.remove(num);
            if (view == null) {
                throw new IllegalStateException((viewGroup + " did not have child with id=" + iIntValue).toString());
            }
            view.setVisibility(0);
            viewGroup.addView(view);
        }
        for (View view2 : linkedHashMap.values()) {
            view2.setVisibility(8);
            viewGroup.addView(view2);
        }
    }

    public final int visibleChildren(View view) {
        view.getClass();
        int iVisibleChildren = 0;
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getVisibility() == 0) {
                Iterator it = xn3.j(0, viewGroup.getChildCount()).iterator();
                while (it.hasNext()) {
                    int iNextInt = ((ok1) it).nextInt();
                    Utils utils = INSTANCE;
                    View childAt = viewGroup.getChildAt(iNextInt);
                    childAt.getClass();
                    iVisibleChildren += utils.visibleChildren(childAt);
                }
                return iVisibleChildren;
            }
        }
        return view.getVisibility() == 0 ? 1 : 0;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class AudioMetadata {
        private String mediaAlbum;
        private String mediaArtist;
        private String mediaTitle;

        public final String formatArtistAlbum() {
            String str = this.mediaArtist;
            boolean z = true;
            boolean z2 = str == null || str.length() == 0;
            String str2 = this.mediaAlbum;
            if (str2 != null && str2.length() != 0) {
                z = false;
            }
            if (z2 || z) {
                if (!z2) {
                    return this.mediaAlbum;
                }
                if (z) {
                    return null;
                }
                return this.mediaArtist;
            }
            return this.mediaArtist + " / " + this.mediaAlbum;
        }

        public final String formatTitle() {
            String str = this.mediaTitle;
            if (str == null || str.length() == 0) {
                return null;
            }
            return this.mediaTitle;
        }

        public final String getMediaAlbum() {
            return this.mediaAlbum;
        }

        public final String getMediaArtist() {
            return this.mediaArtist;
        }

        public final String getMediaTitle() {
            return this.mediaTitle;
        }

        public final void readAll(MPV mpv) {
            Object propertyNode;
            String str;
            mpv.getClass();
            MPV.PropertyAccessor prop = mpv.getProp();
            if (MPV.this.isInitialized()) {
                hp1 hp1VarB = np3.b(String.class);
                if (il1.a(hp1VarB, np3.b(Integer.TYPE))) {
                    propertyNode = MPV.this.getPropertyInt("media-title");
                } else if (il1.a(hp1VarB, np3.b(Long.TYPE))) {
                    propertyNode = MPV.this.getPropertyLong("media-title");
                } else if (il1.a(hp1VarB, np3.b(Float.TYPE))) {
                    propertyNode = MPV.this.getPropertyFloat("media-title");
                } else if (il1.a(hp1VarB, np3.b(Double.TYPE))) {
                    propertyNode = MPV.this.getPropertyDouble("media-title");
                } else if (il1.a(hp1VarB, np3.b(Boolean.TYPE))) {
                    propertyNode = MPV.this.getPropertyBoolean("media-title");
                } else if (il1.a(hp1VarB, np3.b(String.class))) {
                    propertyNode = MPV.this.getPropertyString("media-title");
                } else {
                    if (!il1.a(hp1VarB, np3.b(MPVNode.class))) {
                        nl.a("Unsupported property type: ", np3.b(String.class));
                        return;
                    }
                    propertyNode = MPV.this.getPropertyNode("media-title");
                }
                str = (String) propertyNode;
            } else {
                str = null;
            }
            this.mediaTitle = str;
            update("metadata", mpv);
        }

        public final boolean update(String str, MPV mpv) {
            Object propertyNode;
            String str2;
            Object propertyNode2;
            str.getClass();
            mpv.getClass();
            if (il1.a(str, "metadata")) {
                MPV.PropertyAccessor prop = mpv.getProp();
                boolean zIsInitialized = MPV.this.isInitialized();
                Class cls = Boolean.TYPE;
                Class cls2 = Double.TYPE;
                Class cls3 = Float.TYPE;
                Class cls4 = Long.TYPE;
                Class cls5 = Integer.TYPE;
                String str3 = null;
                if (zIsInitialized) {
                    hp1 hp1VarB = np3.b(String.class);
                    if (il1.a(hp1VarB, np3.b(cls5))) {
                        propertyNode = MPV.this.getPropertyInt("metadata/by-key/Artist");
                    } else if (il1.a(hp1VarB, np3.b(cls4))) {
                        propertyNode = MPV.this.getPropertyLong("metadata/by-key/Artist");
                    } else if (il1.a(hp1VarB, np3.b(cls3))) {
                        propertyNode = MPV.this.getPropertyFloat("metadata/by-key/Artist");
                    } else if (il1.a(hp1VarB, np3.b(cls2))) {
                        propertyNode = MPV.this.getPropertyDouble("metadata/by-key/Artist");
                    } else if (il1.a(hp1VarB, np3.b(cls))) {
                        propertyNode = MPV.this.getPropertyBoolean("metadata/by-key/Artist");
                    } else if (il1.a(hp1VarB, np3.b(String.class))) {
                        propertyNode = MPV.this.getPropertyString("metadata/by-key/Artist");
                    } else if (il1.a(hp1VarB, np3.b(MPVNode.class))) {
                        propertyNode = MPV.this.getPropertyNode("metadata/by-key/Artist");
                    } else {
                        nl.a("Unsupported property type: ", np3.b(String.class));
                    }
                    str2 = (String) propertyNode;
                } else {
                    str2 = null;
                }
                this.mediaArtist = str2;
                MPV.PropertyAccessor prop2 = mpv.getProp();
                if (MPV.this.isInitialized()) {
                    hp1 hp1VarB2 = np3.b(String.class);
                    if (il1.a(hp1VarB2, np3.b(cls5))) {
                        propertyNode2 = MPV.this.getPropertyInt("metadata/by-key/Album");
                    } else if (il1.a(hp1VarB2, np3.b(cls4))) {
                        propertyNode2 = MPV.this.getPropertyLong("metadata/by-key/Album");
                    } else if (il1.a(hp1VarB2, np3.b(cls3))) {
                        propertyNode2 = MPV.this.getPropertyFloat("metadata/by-key/Album");
                    } else if (il1.a(hp1VarB2, np3.b(cls2))) {
                        propertyNode2 = MPV.this.getPropertyDouble("metadata/by-key/Album");
                    } else if (il1.a(hp1VarB2, np3.b(cls))) {
                        propertyNode2 = MPV.this.getPropertyBoolean("metadata/by-key/Album");
                    } else if (il1.a(hp1VarB2, np3.b(String.class))) {
                        propertyNode2 = MPV.this.getPropertyString("metadata/by-key/Album");
                    } else {
                        if (!il1.a(hp1VarB2, np3.b(MPVNode.class))) {
                            nl.a("Unsupported property type: ", np3.b(String.class));
                            return false;
                        }
                        propertyNode2 = MPV.this.getPropertyNode("metadata/by-key/Album");
                    }
                    str3 = (String) propertyNode2;
                }
                this.mediaAlbum = str3;
                return true;
            }
            return false;
        }

        public final boolean update(String str, String str2) {
            str.getClass();
            str2.getClass();
            if (!il1.a(str, "media-title")) {
                return false;
            }
            this.mediaTitle = str2;
            return true;
        }
    }
}
