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

        public a(String str) {
            this.a = str;
        }

        private /* synthetic */ boolean b(Object obj) {
            return (obj instanceof a) && Objects.equals(this.a, ((a) obj).a);
        }

        private /* synthetic */ Object[] c() {
            return new Object[]{this.a};
        }

        public static a g(String str) {
            return new a(str);
        }

        public static boolean h(String str) {
            return !str.startsWith("magnet") && str.split(";")[0].toLowerCase().endsWith(".torrent");
        }

        public static boolean i(String str) {
            return b.matcher(str).find() || h(str);
        }

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
                    @Override // java.util.function.Function
                    public final Object apply(Object obj) {
                        return this.a.f((TorrentFileInfo) obj);
                    }
                }));
            } finally {
                XLTaskHelper.get().stopTask(getTaskId);
            }
        }

        public final Episode e(GetTaskId getTaskId) {
            return Episode.create(getTaskId.getFileName(), getTaskId.getRealUrl());
        }

        public final boolean equals(Object obj) {
            return b(obj);
        }

        public final Episode f(TorrentFileInfo torrentFileInfo) {
            return Episode.create(torrentFileInfo.getFileName(), torrentFileInfo.getSize(), torrentFileInfo.getPlayUrl());
        }

        public final int hashCode() {
            return Objects.hashCode(this.a);
        }

        public final void j(GetTaskId getTaskId) {
            for (int i = 0; i < 100 && XLTaskHelper.get().getTaskInfo(getTaskId).getTaskStatus() != 2; i++) {
                SystemClock.sleep(100L);
            }
        }

        public final String toString() {
            return yq.a(c(), a.class, "a");
        }
    }

    @Override // db4.a
    public void a() {
        XLTaskHelper.get().release();
    }

    @Override // db4.a
    public boolean b(Uri uri) {
        return av4.a(new Object[]{"magnet", "ed2k"}).contains(qx4.i(uri));
    }

    @Override // db4.a
    public String c(String str) {
        return str.startsWith("magnet") ? e(Uri.parse(str)) : d(str);
    }

    public final String d(String str) {
        this.f = XLTaskHelper.get().addThunderTask(str, Path.thunder(Util.md5(str)));
        return XLTaskHelper.get().getLocalUrl(this.f.getSaveFile());
    }

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
