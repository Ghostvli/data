package defpackage;

import android.net.Uri;
import android.os.SystemClock;
import com.fongmi.android.tv.bean.Episode;
import com.github.catvod.utils.Path;
import com.github.catvod.utils.Util;
import com.xunlei.downloadlib.XLTaskHelper;
import com.xunlei.downloadlib.parameter.GetTaskId;
import com.xunlei.downloadlib.parameter.TorrentFileInfo;
import com.xunlei.downloadlib.parameter.XLTaskInfo;
import defpackage.db4;
import j$.util.stream.Stream$EL;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class bo4 implements db4.a {
    public GetTaskId f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends to3 implements Callable {
        public static final Pattern b = Pattern.compile("(magnet|thunder|ed2k):.*");
        public final String a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(String str) {
            this.a = str;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private /* synthetic */ boolean b(Object obj) {
            return (obj instanceof a) && Objects.equals(this.a, ((a) obj).a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private /* synthetic */ Object[] c() {
            return new Object[]{this.a};
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static a g(String str) {
            return new a(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static boolean h(String str) {
            return !str.startsWith("magnet") && str.split(";")[0].toLowerCase().endsWith(".torrent");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static boolean i(String str) {
            return b.matcher(str).find() || h(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: call()Ljava/lang/Object; */
        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public List call() {
            boolean zH = h(this.a);
            XLTaskHelper xLTaskHelper = XLTaskHelper.get();
            String str = this.a;
            GetTaskId getTaskId = xLTaskHelper.parse(str, Path.thunder(Util.md5(str)));
            if (!zH && !getTaskId.getRealUrl().startsWith("magnet")) {
                return Arrays.asList(e(getTaskId));
            }
            if (zH && this.a.startsWith("http")) {
                fn0.a(this.a, getTaskId.getSaveFile()).d();
            }
            if (!zH) {
                j(getTaskId);
            }
            try {
                return Stream$EL.toList(XLTaskHelper.get().getTorrentInfo(getTaskId.getSaveFile()).getMedias().stream().map(new Function() { // from class: ao4
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.f((TorrentFileInfo) obj);
                    }
                }));
            } finally {
                XLTaskHelper.get().stopTask(getTaskId);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Episode e(GetTaskId getTaskId) {
            return Episode.create(getTaskId.getFileName(), getTaskId.getRealUrl());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean equals(Object obj) {
            return b(obj);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Episode f(TorrentFileInfo torrentFileInfo) {
            return Episode.create(torrentFileInfo.getFileName(), torrentFileInfo.getSize(), torrentFileInfo.getPlayUrl());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int hashCode() {
            return Objects.hashCode(this.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void j(GetTaskId getTaskId) {
            for (int i = 0; i < 100 && XLTaskHelper.get().getTaskInfo(getTaskId).getTaskStatus() != 2; i++) {
                SystemClock.sleep(100L);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final String toString() {
            return yq.a(c(), a.class, "a");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // db4.a
    public void a() {
        XLTaskHelper.get().release();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // db4.a
    public boolean b(Uri uri) {
        return av4.a(new Object[]{"magnet", "ed2k"}).contains(qx4.i(uri));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // db4.a
    public String c(String str) {
        return str.startsWith("magnet") ? e(Uri.parse(str)) : d(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String d(String str) {
        this.f = XLTaskHelper.get().addThunderTask(str, Path.thunder(Util.md5(str)));
        return XLTaskHelper.get().getLocalUrl(this.f.getSaveFile());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String e(Uri uri) throws ez0 {
        File file = new File(uri.getPath());
        File parentFile = file.getParentFile();
        String queryParameter = uri.getQueryParameter("name");
        int i = Integer.parseInt(uri.getQueryParameter("index"));
        this.f = XLTaskHelper.get().addTorrentTask(file, parentFile, i);
        for (int i2 = 0; i2 < 100; i2++) {
            XLTaskInfo xLTaskInfo = XLTaskHelper.get().getBtSubTaskInfo(this.f, i).mTaskInfo;
            int i3 = xLTaskInfo.mTaskStatus;
            if (i3 == 3) {
                throw new ez0(xLTaskInfo.getErrorMsg());
            }
            if (i3 != 0) {
                return XLTaskHelper.get().getLocalUrl(new File(parentFile, queryParameter));
            }
            SystemClock.sleep(100L);
        }
        throw new ez0(vr3.l(sm3.G));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // db4.a
    public void stop() {
        if (this.f == null) {
            return;
        }
        XLTaskHelper.get().deleteTask(this.f);
        XLTaskHelper.get().release();
        this.f = null;
    }
}
