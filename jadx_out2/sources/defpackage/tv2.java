package defpackage;

import android.util.Log;
import android.view.Surface;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Track;
import com.github.catvod.utils.ZteNatPuncher;
import com.thegrizzlylabs.sardineandroid.DavPrincipal;
import defpackage.ee3;
import defpackage.hd3;
import defpackage.t41;
import defpackage.tv2;
import defpackage.xr4;
import is.xyz.mpv.MPV;
import is.xyz.mpv.MPVNode;
import j$.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.HTTP;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class tv2 implements ee3 {
    public volatile MPV a;
    public volatile Surface b;
    public volatile boolean c;
    public volatile boolean d;
    public volatile boolean e;
    public volatile boolean f;
    public volatile boolean g;
    public volatile String h;
    public volatile vb3 l;
    public volatile boolean m;
    public volatile boolean n;
    public volatile String o;
    public volatile ZteNatPuncher p;
    public vb3 r;
    public hd3.d s;
    public volatile float i = 1.0f;
    public volatile int j = -1;
    public volatile long k = -9223372036854775807L;
    public int q = q24.h();
    public final a t = new a();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public tv2(hd3.d dVar) {
        this.s = dVar;
        O();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: T(Lis/xyz/mpv/MPV;I)V */
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public final void T(MPV mpv, int i) {
        try {
            mpv.getPropertyString("vo");
            if (i == 0) {
                Integer propertyInt = mpv.getPropertyInt("width");
                Integer propertyInt2 = mpv.getPropertyInt("height");
                if (propertyInt == null || propertyInt.intValue() <= 0 || propertyInt2 == null || propertyInt2.intValue() <= 0) {
                    mpv.setPropertyString("video-aspect-override", "no");
                } else {
                    mpv.setPropertyDouble("video-aspect-override", ((double) propertyInt.intValue()) / ((double) propertyInt2.intValue()));
                }
            } else if (i == 1) {
                mpv.setPropertyDouble("video-aspect-override", 1.7777777777777777d);
                V(16, 9);
            } else if (i == 2) {
                mpv.setPropertyDouble("video-aspect-override", 1.3333333333333333d);
                V(4, 3);
            } else if (i == 3) {
                mpv.setPropertyString("video-aspect-override", "no");
                mpv.command("set", "panscan", "1.0");
            } else if (i != 4) {
                mpv.setPropertyString("video-aspect-override", "no");
                mpv.command("set", "panscan", "0.0");
            } else {
                mpv.setPropertyString("video-aspect-override", "no");
                mpv.command("set", "panscan", "0.5");
            }
            if (i < 3) {
                mpv.command("set", "panscan", "0.0");
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void J() {
        MPV mpv = this.a;
        if (mpv == null) {
            return;
        }
        String strS = q24.s();
        if (strS.isEmpty()) {
            strS = ge3.c();
        }
        mpv.setOptionString("demuxer-lavf-o", "stimeout=15000000,headers=User-Agent: " + strS + HTTP.CRLF);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void K() {
        MPV mpv = this.a;
        if (mpv == null) {
            return;
        }
        if (q24.m() == 1) {
            mpv.setOptionString("rtsp-transport", "udp");
        } else {
            mpv.setOptionString("rtsp-transport", "tcp");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String L(String str, String str2, String str3, Integer num, Integer num2, Double d) {
        StringBuilder sb = new StringBuilder();
        if (str2 != null && !str2.isEmpty()) {
            sb.append(str2);
        } else if (str != null && !str.isEmpty()) {
            sb.append(str);
        }
        if (str3 != null && !str3.isEmpty()) {
            if (sb.length() > 0) {
                sb.append(" | ");
            }
            sb.append(str3);
        }
        if (num != null && num.intValue() > 0) {
            if (sb.length() > 0) {
                sb.append(" | ");
            }
            sb.append(num);
            sb.append("ch");
        }
        if (num2 != null && num2.intValue() > 0) {
            if (sb.length() > 0) {
                sb.append(" | ");
            }
            sb.append(num2.intValue() / 1000);
            sb.append("kHz");
        }
        if (d != null && d.doubleValue() > 0.0d) {
            if (sb.length() > 0) {
                sb.append(" | ");
            }
            if (d.doubleValue() >= 1000000.0d) {
                sb.append(String.format(Locale.getDefault(), "%.1f", Double.valueOf(d.doubleValue() / 1000000.0d)));
                sb.append("Mbps");
            } else if (d.doubleValue() >= 1000.0d) {
                sb.append(String.format(Locale.getDefault(), "%.0f", Double.valueOf(d.doubleValue() / 1000.0d)));
                sb.append("kbps");
            } else {
                sb.append(String.format(Locale.getDefault(), "%.0f", d));
                sb.append("bps");
            }
        }
        return sb.length() > 0 ? sb.toString() : "Unknown";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String M(String str, String str2, String str3, Integer num, Integer num2, Double d, String str4, Double d2) {
        StringBuilder sb = new StringBuilder();
        if (str2 != null && !str2.isEmpty()) {
            sb.append(str2);
        }
        if (str3 != null && !str3.isEmpty()) {
            if (sb.length() > 0) {
                sb.append(" | ");
            }
            sb.append(str3);
        }
        if (num != null && num.intValue() > 0 && num2 != null && num2.intValue() > 0) {
            if (sb.length() > 0) {
                sb.append(" | ");
            }
            sb.append(num);
            sb.append("x");
            sb.append(num2);
        }
        if (d != null && d.doubleValue() > 0.0d) {
            if (sb.length() > 0) {
                sb.append(" | ");
            }
            sb.append(String.format(Locale.getDefault(), "%.2f", d));
            sb.append("fps");
        }
        if (d2 != null && d2.doubleValue() > 0.0d) {
            if (sb.length() > 0) {
                sb.append(" | ");
            }
            if (d2.doubleValue() >= 1000000.0d) {
                sb.append(String.format(Locale.getDefault(), "%.1f", Double.valueOf(d2.doubleValue() / 1000000.0d)));
                sb.append("Mbps");
            } else if (d2.doubleValue() >= 1000.0d) {
                sb.append(String.format(Locale.getDefault(), "%.0f", Double.valueOf(d2.doubleValue() / 1000.0d)));
                sb.append("kbps");
            } else {
                sb.append(String.format(Locale.getDefault(), "%.0f", d2));
                sb.append("bps");
            }
        }
        if (str4 != null && !str4.isEmpty()) {
            if (sb.length() > 0) {
                sb.append(" | ");
            }
            sb.append(str4.toUpperCase(Locale.getDefault()));
        }
        return sb.length() > 0 ? sb.toString() : "Unknown";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void N() {
        this.b = null;
        this.m = false;
        MPV mpv = this.a;
        if (mpv == null) {
            return;
        }
        try {
            mpv.detachSurface();
        } catch (Throwable unused) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void O() {
        this.a = new MPV();
        this.a.create(App.b());
        this.a.setOptionString("vo", "gpu");
        this.a.setOptionString("gpu-context", "android");
        this.a.setOptionString("hwdec", this.q == 1 ? "mediacodec" : "no");
        this.a.setOptionString("gpu-hwdecode-interop", "auto");
        this.a.setOptionString("opengl-swapinterval", "1");
        this.a.setOptionString("opengl-pbo", "yes");
        this.o = "gpu";
        this.a.setOptionString("hwdec-codecs", DavPrincipal.KEY_ALL);
        this.a.setOptionString("keep-open", "yes");
        this.a.setOptionString("force-seekable", "yes");
        this.a.setOptionString("keepaspect", "yes");
        this.a.setOptionString("keepaspect-window", "no");
        this.a.setOptionString("audio-pitch-correction", "yes");
        this.a.setOptionString("af", "scaletempo2");
        this.a.setOptionString("cache", "yes");
        this.a.setOptionString("demuxer-max-bytes", "150MiB");
        this.a.setOptionString("demuxer-max-back-bytes", "75MiB");
        this.a.setOptionString("cache-secs", "30");
        this.a.setOptionString("cache-pause-initial", "yes");
        this.a.setOptionString("cache-on-disk", "no");
        this.a.setOptionString("video-sync", "audio");
        this.a.setOptionString("interpolation", "no");
        this.a.setOptionString("framedrop", "vo");
        this.a.setOptionString("hr-seek", "no");
        this.a.setOptionString("hr-seek-framedrop", "yes");
        this.a.setOptionString("osd-level", "0");
        this.a.setOptionString("osd-duration", "500");
        this.a.setOptionString("vd-lavc-skiploopfilter", DavPrincipal.KEY_ALL);
        this.a.setOptionString("vd-lavc-skipframe", "nonref");
        this.a.setOptionString("ad-lavc-ac3drc", "0");
        this.a.setOptionString("audio-buffer", "0.25");
        this.a.setOptionString("demuxer-lavf-error-resilient", "yes");
        this.a.setOptionString("demuxer-lavf-allow-mimetype", "no");
        this.a.setOptionString("demuxer-lavf-analyzeduration", "3000000");
        this.a.setOptionString("demuxer-lavf-probesize", "10000000");
        K();
        J();
        this.a.addObserver(this.t);
        this.a.init();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void P(MPV mpv) {
        if (mpv == null) {
            return;
        }
        this.m = false;
        try {
            mpv.removeObserver(this.t);
        } catch (Throwable unused) {
        }
        try {
            mpv.command("stop");
        } catch (Throwable unused2) {
        }
        try {
            mpv.setPropertyString("vo", "null");
        } catch (Throwable unused3) {
        }
        try {
            mpv.setPropertyString("force-window", "no");
        } catch (Throwable unused4) {
        }
        try {
            Thread.sleep(100L);
        } catch (InterruptedException unused5) {
        }
        try {
            mpv.detachSurface();
        } catch (Throwable unused6) {
        }
        try {
            mpv.destroy();
        } catch (Throwable unused7) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Q(MPV mpv, String str, Map map, boolean z) {
        String str2 = "MpvEngine";
        try {
            String strTrim = str.trim();
            if (!this.m && this.b != null) {
                mpv.attachSurface(this.b);
                this.m = true;
            }
            try {
                mpv.command("set", "pause", "no");
            } catch (Throwable unused) {
            }
            mpv.setPropertyDouble("speed", 1.0d);
            Log.d("MpvEngine", "doLoadFile origUrl=" + strTrim + " spider=" + z);
            try {
                if (h()) {
                    mpv.setOptionString("hwdec", "mediacodec");
                    mpv.setOptionString("vf", "format=yuv420p");
                } else {
                    mpv.setOptionString("vf", "");
                }
            } catch (Throwable unused2) {
            }
            boolean z2 = !z && (strTrim.contains("m3u8") || strTrim.contains(".m3u8") || strTrim.contains("rtmp"));
            boolean z3 = strTrim.contains("m3u8") || strTrim.contains(".m3u8");
            try {
                if (z2) {
                    mpv.setOptionString("demuxer-lavf-format", "hls");
                    mpv.setOptionString("demuxer-lavf-analyzeduration", "100000");
                    mpv.setOptionString("demuxer-lavf-probesize", "300000");
                    mpv.setOptionString("cache-pause-initial", "no");
                    mpv.setOptionString("cache-secs", "2");
                    mpv.setOptionString("demuxer-max-bytes", "10MiB");
                    mpv.setOptionString("demuxer-max-back-bytes", "2MiB");
                    mpv.setOptionString("cache", "yes");
                    strTrim = h0(strTrim, map);
                } else {
                    try {
                        mpv.setOptionString("demuxer-lavf-format", "");
                    } catch (Throwable unused3) {
                    }
                    if (!z) {
                        mpv.setOptionString("demuxer-lavf-analyzeduration", "3000000");
                        mpv.setOptionString("demuxer-lavf-probesize", "10000000");
                        mpv.setOptionString("cache-pause-initial", "yes");
                        mpv.setOptionString("cache-secs", "30");
                    } else if (z3) {
                        mpv.setOptionString("demuxer-lavf-format", "hls");
                        strTrim = h0(strTrim, map);
                        mpv.setOptionString("demuxer-lavf-analyzeduration", "100000");
                        mpv.setOptionString("demuxer-lavf-probesize", "500000");
                        mpv.setOptionString("cache-pause-initial", "no");
                        mpv.setOptionString("cache-secs", "8");
                        mpv.setOptionString("demuxer-max-bytes", "100MiB");
                        mpv.setOptionString("demuxer-max-back-bytes", "50MiB");
                        mpv.setOptionString("cache", "yes");
                    } else {
                        mpv.setOptionString("demuxer-lavf-analyzeduration", "1000000");
                        mpv.setOptionString("demuxer-lavf-probesize", "5000000");
                        mpv.setOptionString("cache-pause-initial", "no");
                        mpv.setOptionString("cache-secs", "15");
                        mpv.setOptionString("demuxer-max-bytes", "100MiB");
                        mpv.setOptionString("demuxer-max-back-bytes", "50MiB");
                        mpv.setOptionString("cache", "yes");
                    }
                }
                str2 = "MpvEngine";
                Log.d(str2, "doLoadFile finalUrl=" + strTrim);
                a0(mpv, map);
                boolean zStartsWith = strTrim.startsWith("rtsp://");
                this.n = zStartsWith;
                if (zStartsWith) {
                    boolean z4 = map != null && "true".equalsIgnoreCase((String) map.get("X-ZTE-NAT"));
                    if (z4 || q24.N()) {
                        f0();
                        this.p = new ZteNatPuncher();
                        this.p.start(strTrim, z4);
                        strTrim = this.p.getProxyUrl(strTrim);
                        mpv.setOptionString("rtsp-transport", "tcp");
                        mpv.setOptionString("demuxer-lavf-o", "fflags=+nofillin");
                        Log.d(str2, "ZTE NAT: proxy url=" + strTrim + " zteNat=" + z4);
                    } else {
                        mpv.setOptionString("demuxer-lavf-o", "fflags=+nofillin");
                    }
                } else {
                    b0(mpv, map);
                }
                mpv.command("loadfile", strTrim, "replace");
            } catch (Throwable th) {
                th = th;
                str2 = "MpvEngine";
                Log.e(str2, "doLoadFile error", th);
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String R() {
        return this.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean S() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void U() {
        hd3.d dVar = this.s;
        if (dVar != null) {
            dVar.onPlaybackStateChanged(2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void V(final int i, final int i2) {
        final hd3.d dVar = this.s;
        if (dVar != null) {
            App.d(new Runnable() { // from class: kv2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    dVar.onVideoSizeChanged(new e35(i, i2));
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void W(int i, int i2) {
        MPV mpv = this.a;
        if (mpv == null || i <= 0 || i2 <= 0) {
            return;
        }
        try {
            mpv.setPropertyString("android-surface-size", i + "x" + i2);
        } catch (Throwable unused) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void X() {
        int i = this.j;
        if (i < 0) {
            i = 0;
        }
        MPV mpv = this.a;
        if (mpv == null || !this.c) {
            return;
        }
        T(mpv, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public hd3 Y(hd3.d dVar) {
        this.s = dVar;
        this.l = null;
        P(this.a);
        this.c = false;
        this.d = false;
        this.e = false;
        this.f = false;
        this.g = false;
        this.i = 1.0f;
        this.m = false;
        O();
        if (this.b != null && this.a != null) {
            this.a.attachSurface(this.b);
            this.a.setOptionString("force-window", "yes");
            if (this.o != null && !this.o.isEmpty()) {
                try {
                    this.a.setPropertyString("vo", this.o);
                } catch (Throwable unused) {
                }
            }
            g0();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Z() {
        this.l = null;
        f0();
        MPV mpv = this.a;
        this.a = null;
        P(mpv);
        this.s = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ee3
    public boolean a() {
        MPV mpv = this.a;
        if (mpv == null) {
            return false;
        }
        try {
            Long propertyLong = mpv.getPropertyLong("duration");
            if (propertyLong != null) {
                return propertyLong.longValue() <= 0;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a0(MPV mpv, Map map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            try {
                String lowerCase = ((String) entry.getKey()).toLowerCase(Locale.ROOT);
                if (lowerCase.equals("user-agent")) {
                    mpv.setPropertyString("user-agent", (String) entry.getValue());
                } else if (lowerCase.equals("referer") || lowerCase.equals("referrer")) {
                    mpv.setPropertyString("referrer", (String) entry.getValue());
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ee3
    public boolean b() {
        return !a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void b0(MPV mpv, Map map) {
        String str;
        try {
            StringBuilder sb = new StringBuilder();
            String strC = null;
            if (map != null) {
                str = null;
                for (Map.Entry entry : map.entrySet()) {
                    String lowerCase = ((String) entry.getKey()).toLowerCase(Locale.ROOT);
                    if (lowerCase.equals("user-agent")) {
                        strC = (String) entry.getValue();
                    } else if (lowerCase.equals("referer") || lowerCase.equals("referrer")) {
                        str = (String) entry.getValue();
                    }
                }
            } else {
                str = null;
            }
            if (strC == null) {
                strC = q24.s();
            }
            if (strC.isEmpty()) {
                strC = ge3.c();
            }
            sb.append("User-Agent: ");
            sb.append(strC);
            sb.append(HTTP.CRLF);
            if (str != null && !str.isEmpty()) {
                sb.append("Referer: ");
                sb.append(str);
                sb.append(HTTP.CRLF);
            }
            mpv.setOptionString("demuxer-lavf-o", "stimeout=15000000,headers=" + ((Object) sb));
        } catch (Throwable unused) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ee3
    public float c() {
        return this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c0(Surface surface) {
        this.b = surface;
        MPV mpv = this.a;
        if (mpv == null) {
            return;
        }
        try {
            if (surface == null) {
                mpv.detachSurface();
                this.m = false;
                return;
            }
            mpv.attachSurface(surface);
            this.m = true;
            mpv.setOptionString("force-window", "yes");
            if (this.o != null && !this.o.isEmpty()) {
                String propertyString = mpv.getPropertyString("vo");
                if ("null".equals(propertyString) || propertyString == null) {
                    mpv.setPropertyString("vo", this.o);
                }
            }
            g0();
        } catch (Throwable unused) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ee3
    public String d(ac3 ac3Var) {
        return ac3Var != null ? ac3Var.getMessage() : "MPV playback error";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d0(final int i) {
        this.j = i;
        final MPV mpv = this.a;
        if (mpv != null && this.c) {
            if (i == 0) {
                T(mpv, i);
            } else {
                App.e(new Runnable() { // from class: jv2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f.T(mpv, i);
                    }
                }, 50L);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ee3
    public void e() {
        MPV mpv = this.a;
        if (mpv == null) {
            return;
        }
        try {
            mpv.setPropertyString("aid", "auto");
            mpv.setPropertyString("vid", "auto");
        } catch (Throwable unused) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e0() {
        MPV mpv = this.a;
        if (mpv == null) {
            return;
        }
        try {
            mpv.setPropertyString("vo", "null");
            mpv.setPropertyString("force-window", "no");
        } catch (Throwable unused) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ee3
    public void f(int i) {
        this.q = i;
        q24.h0(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f0() {
        ZteNatPuncher zteNatPuncher = this.p;
        if (zteNatPuncher != null) {
            zteNatPuncher.stop();
            this.p = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ee3
    public ee3.a g(ac3 ac3Var) {
        return ee3.a.FATAL;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g0() {
        MPV mpv;
        vb3 vb3Var = this.l;
        if (vb3Var == null || (mpv = this.a) == null || this.b == null) {
            return;
        }
        this.l = null;
        Q(mpv, vb3Var.m(), vb3Var.h(), vb3Var.n());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r6v8, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.ee3
    public xr4 getCurrentTracks() {
        Integer propertyInt;
        int i;
        t41 t41VarQ;
        Integer num;
        Integer num2;
        int i2;
        ArrayList arrayList = new ArrayList();
        tv2 tv2Var = this;
        MPV mpv = tv2Var.a;
        if (mpv == null) {
            return new xr4(arrayList);
        }
        try {
            propertyInt = mpv.getPropertyInt("track-list/count");
        } catch (Throwable unused) {
        }
        if (propertyInt == null) {
            return new xr4(arrayList);
        }
        int i3 = 0;
        while (i3 < propertyInt.intValue()) {
            String propertyString = mpv.getPropertyString("track-list/" + i3 + "/type");
            if (propertyString != null) {
                Integer propertyInt2 = mpv.getPropertyInt("track-list/" + i3 + "/id");
                String propertyString2 = mpv.getPropertyString("track-list/" + i3 + "/lang");
                String propertyString3 = mpv.getPropertyString("track-list/" + i3 + "/title");
                String propertyString4 = mpv.getPropertyString("track-list/" + i3 + "/codec");
                Boolean propertyBoolean = mpv.getPropertyBoolean("track-list/" + i3 + "/selected");
                boolean z = propertyBoolean != null && propertyBoolean.booleanValue();
                int iIntValue = propertyInt2 != null ? propertyInt2.intValue() : i3 + 1;
                Double propertyDouble = null;
                if ("audio".equals(propertyString)) {
                    Integer propertyInt3 = mpv.getPropertyInt("track-list/" + i3 + "/demux-channels");
                    StringBuilder sb = new StringBuilder();
                    sb.append("track-list/");
                    sb.append(i3);
                    i = 0;
                    sb.append("/demux-samplerate");
                    Integer propertyInt4 = mpv.getPropertyInt(sb.toString());
                    try {
                        propertyDouble = mpv.getPropertyDouble("track-list/" + i3 + "/demux-bitrate");
                    } catch (Throwable unused2) {
                    }
                    if (propertyDouble == null || propertyDouble.doubleValue() <= 0.0d) {
                        try {
                            propertyDouble = mpv.getPropertyDouble("track-list/" + i3 + "/codec-bitrate");
                        } catch (Throwable unused3) {
                        }
                    }
                    Double d = propertyDouble;
                    String strL = tv2Var.L(propertyString2, propertyString3, propertyString4, propertyInt3, propertyInt4, d);
                    if (d == null || d.doubleValue() <= 0.0d) {
                        num = propertyInt3;
                        num2 = propertyInt4;
                        i2 = -1;
                    } else {
                        double dDoubleValue = d.doubleValue();
                        num = propertyInt3;
                        num2 = propertyInt4;
                        i2 = (int) (dDoubleValue / 1000.0d);
                    }
                    t41VarQ = new t41.b().j0(iIntValue).A0("audio/raw").o0(propertyString2).m0(strL).V(propertyString4).U(num != null ? num.intValue() : -1).B0(num2 != null ? num2.intValue() : -1).T(i2).Q();
                } else {
                    i = 0;
                    if ("video".equals(propertyString)) {
                        Integer propertyInt5 = mpv.getPropertyInt("track-list/" + i3 + "/demux-w");
                        Integer propertyInt6 = mpv.getPropertyInt("track-list/" + i3 + "/demux-h");
                        Double propertyDouble2 = mpv.getPropertyDouble("track-list/" + i3 + "/demux-fps");
                        String propertyString5 = mpv.getPropertyString("track-list/" + i3 + "/demux-signal");
                        try {
                            propertyDouble = mpv.getPropertyDouble("track-list/" + i3 + "/demux-bitrate");
                        } catch (Throwable unused4) {
                        }
                        if (propertyDouble == null || propertyDouble.doubleValue() <= 0.0d) {
                            try {
                                propertyDouble = mpv.getPropertyDouble("track-list/" + i3 + "/codec-bitrate");
                            } catch (Throwable unused5) {
                            }
                        }
                        Double d2 = propertyDouble;
                        t41VarQ = new t41.b().j0(iIntValue).A0("video/avc").V(propertyString4).H0(propertyInt5 != null ? propertyInt5.intValue() : 0).i0(propertyInt6 != null ? propertyInt6.intValue() : 0).m0(M(propertyString2, propertyString3, propertyString4, propertyInt5, propertyInt6, propertyDouble2, propertyString5, d2)).g0(propertyDouble2 != null ? propertyDouble2.floatValue() : -1.0f).T((d2 == null || d2.doubleValue() <= 0.0d) ? -1 : (int) (d2.doubleValue() / 1000.0d)).Q();
                    }
                }
                boolean[] zArr = new boolean[1];
                zArr[i] = z;
                arrayList.add(new xr4.a(new br4(t41VarQ), i, new int[]{i}, zArr));
            }
            i3++;
            tv2Var = this;
        }
        return new xr4(arrayList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ee3
    public long getDuration() {
        MPV mpv = this.a;
        if (mpv == null) {
            return 0L;
        }
        try {
            Double propertyDouble = mpv.getPropertyDouble("duration");
            if (propertyDouble != null) {
                return (long) (propertyDouble.doubleValue() * 1000.0d);
            }
            return -9223372036854775807L;
        } catch (Throwable unused) {
            return -9223372036854775807L;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ee3
    public int getPlaybackState() {
        if (this.f) {
            return 4;
        }
        if (this.d) {
            return 2;
        }
        return this.c ? 3 : 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ee3
    public long getPosition() {
        MPV mpv = this.a;
        if (mpv == null) {
            return 0L;
        }
        try {
            Double propertyDouble = mpv.getPropertyDouble("time-pos");
            if (propertyDouble != null) {
                return (long) (propertyDouble.doubleValue() * 1000.0d);
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ee3
    public int getType() {
        return 2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ee3
    public boolean h() {
        return this.q == 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String h0(String str, Map map) {
        String str2;
        if (!str.startsWith("http://127.0.0.1") && !str.startsWith("http://localhost")) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(t14.b().e(true));
                sb.append("/proxy?do=m3u8&url=");
                sb.append(URLEncoder.encode(str, "UTF-8"));
                if (map != null) {
                    Iterator it = map.entrySet().iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            str2 = null;
                            break;
                        }
                        Map.Entry entry = (Map.Entry) it.next();
                        if ("User-Agent".equalsIgnoreCase((String) entry.getKey())) {
                            str2 = (String) entry.getValue();
                            break;
                        }
                    }
                    if (str2 != null && !str2.isEmpty()) {
                        sb.append("&ua=");
                        sb.append(URLEncoder.encode(str2, "UTF-8"));
                    }
                }
                return sb.toString();
            } catch (Throwable unused) {
            }
        }
        return str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ee3
    public void i(List list) {
        String key;
        MPV mpv = this.a;
        if (mpv == null) {
            return;
        }
        try {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Track track = (Track) it.next();
                if (track.isSelected()) {
                    int type = track.getType();
                    String str = type == 1 ? "aid" : type == 2 ? "vid" : null;
                    if (str != null && (key = track.getKey()) != null) {
                        mpv.setPropertyInt(str, Integer.parseInt(key));
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ee3
    public boolean isPlaying() {
        return (!this.c || this.e || this.d || this.f) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ee3
    public String j() {
        return vr3.l(h() ? sm3.V : sm3.d0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ee3
    public void k() {
        this.l = null;
        f0();
        MPV mpv = this.a;
        if (mpv == null) {
            return;
        }
        try {
            this.g = true;
            mpv.command("stop");
            this.c = false;
            this.d = false;
            this.e = false;
            this.f = false;
        } catch (Throwable unused) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ee3
    public void l(vb3 vb3Var) {
        this.r = vb3Var;
        this.c = false;
        this.d = true;
        this.e = false;
        this.f = false;
        this.i = 1.0f;
        this.k = -9223372036854775807L;
        MPV mpv = this.a;
        if (mpv == null) {
            return;
        }
        if (this.b != null) {
            this.l = null;
            Q(mpv, vb3Var.m(), vb3Var.h(), vb3Var.n());
        } else {
            this.l = vb3Var;
        }
        App.d(new Runnable() { // from class: hv2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.U();
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ee3
    public void m(ph2 ph2Var) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ee3
    public boolean n(int i) {
        MPV mpv = this.a;
        if (mpv == null) {
            return false;
        }
        try {
            Integer propertyInt = mpv.getPropertyInt("track-list/count");
            if (propertyInt == null) {
                return false;
            }
            String str = i == 1 ? "audio" : i == 2 ? "video" : "sub";
            int i2 = 0;
            for (int i3 = 0; i3 < propertyInt.intValue(); i3++) {
                if (str.equals(mpv.getPropertyString("track-list/" + i3 + "/type"))) {
                    i2++;
                }
            }
            if (i2 > 0) {
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ee3
    public void pause() {
        MPV mpv = this.a;
        if (mpv == null) {
            return;
        }
        try {
            mpv.command("set", "pause", "yes");
            this.e = true;
            final hd3.d dVar = this.s;
            if (dVar != null) {
                App.d(new Runnable() { // from class: gv2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        dVar.onIsPlayingChanged(false);
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ee3
    public void play() {
        MPV mpv = this.a;
        if (mpv == null) {
            return;
        }
        try {
            mpv.command("set", "pause", "no");
            this.e = false;
            final hd3.d dVar = this.s;
            if (dVar != null) {
                App.d(new Runnable() { // from class: iv2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        dVar.onIsPlayingChanged(true);
                    }
                });
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ee3
    public void seekTo(long j) {
        MPV mpv = this.a;
        if (mpv == null) {
            return;
        }
        if (!this.c) {
            this.k = j;
        } else {
            try {
                mpv.command("seek", String.valueOf(j / 1000.0d), "absolute+keyframes");
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ee3
    public void setPlaybackSpeed(float f) {
        MPV mpv = this.a;
        if (mpv == null) {
            return;
        }
        try {
            mpv.setPropertyDouble("speed", f);
            this.i = f;
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements MPV.EventObserver {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ void c(hd3.d dVar) {
            try {
                dVar.onPlaybackStateChanged(4);
                dVar.onIsPlayingChanged(false);
            } catch (Throwable unused) {
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ void h(hd3.d dVar) {
            try {
                dVar.onPlaybackStateChanged(4);
                dVar.onIsPlayingChanged(false);
            } catch (Throwable unused) {
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // is.xyz.mpv.MPV.EventObserver
        public void event(int i, MPVNode mPVNode) {
            try {
                if (i == 8) {
                    o();
                } else if (i == 7) {
                    n(mPVNode);
                }
            } catch (Throwable unused) {
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // is.xyz.mpv.MPV.EventObserver
        public void eventProperty(String str, boolean z) {
            try {
                if ("eof-reached".equals(str) && z) {
                    m();
                }
            } catch (Throwable unused) {
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void i(MPV mpv) {
            if (mpv == null) {
                return;
            }
            try {
                String propertyString = mpv.getPropertyString("hwdec-current");
                if (propertyString != null && !propertyString.isEmpty() && !"no".equals(propertyString)) {
                    return;
                }
                Integer propertyInt = mpv.getPropertyInt("width");
                Integer propertyInt2 = mpv.getPropertyInt("height");
                if (propertyInt != null && propertyInt2 != null && propertyInt.intValue() > 1280) {
                    String str = "dsize=1280:" + ((((propertyInt2.intValue() * 1280) / propertyInt.intValue()) + 1) & (-2));
                    mpv.getPropertyString("vf");
                    String strConcat = "format=yuv420p,".concat(str);
                    Log.d("MpvEngine", "Soft decode fallback for " + propertyInt + "x" + propertyInt2 + ", adding downscale filter: " + strConcat);
                    mpv.setPropertyString("vf", strConcat);
                }
            } catch (Throwable th) {
                Log.e("MpvEngine", "checkSoftDecodeFallback error", th);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final /* synthetic */ void j(MPV mpv, int i) {
            tv2.this.T(mpv, i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final /* synthetic */ void k(hd3.d dVar) {
            try {
                dVar.onPlaybackStateChanged(3);
                dVar.onIsPlayingChanged(true);
                dVar.onTracksChanged(tv2.this.getCurrentTracks());
            } catch (Throwable unused) {
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final /* synthetic */ void l() {
            MPV mpv = tv2.this.a;
            if (mpv == null || !tv2.this.c) {
                return;
            }
            try {
                String propertyString = mpv.getPropertyString("video-format");
                if (propertyString == null || propertyString.isEmpty()) {
                    Log.e("MpvEngine", "RTSP video chain failed, triggering fallback");
                    tv2.this.g = true;
                    tv2.this.h = "MPV_ENGINE_ERROR";
                    tv2.this.c = false;
                    tv2.this.f = true;
                    tv2.this.d = false;
                    try {
                        mpv.command("stop");
                    } catch (Throwable unused) {
                    }
                    final hd3.d dVar = tv2.this.s;
                    if (dVar != null) {
                        App.d(new Runnable() { // from class: sv2
                            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                            @Override // java.lang.Runnable
                            public final void run() {
                                tv2.a.c(dVar);
                            }
                        });
                    }
                }
            } catch (Throwable unused2) {
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void m() {
            n(null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Removed duplicated region for block: B:14:0x002b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final void n(MPVNode mPVNode) {
            MPVNode mPVNode2;
            boolean zEquals;
            boolean z = tv2.this.g;
            tv2 tv2Var = tv2.this;
            if (z) {
                tv2Var.g = false;
                return;
            }
            MPV mpv = tv2Var.a;
            if (mpv == null) {
                return;
            }
            if (mPVNode != null) {
                try {
                    mPVNode2 = mPVNode.get("reason");
                } catch (Throwable unused) {
                }
                zEquals = mPVNode2 != null ? "error".equals(mPVNode2.asString()) : false;
            }
            try {
                Boolean propertyBoolean = mpv.getPropertyBoolean("eof-reached");
                if (propertyBoolean != null) {
                    if (propertyBoolean.booleanValue()) {
                        tv2.this.f = true;
                        tv2.this.c = false;
                        tv2.this.d = false;
                        final hd3.d dVar = tv2.this.s;
                        if (dVar != null) {
                            App.d(new Runnable() { // from class: lv2
                                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                                @Override // java.lang.Runnable
                                public final void run() {
                                    tv2.a.h(dVar);
                                }
                            });
                        }
                        if (zEquals) {
                            tv2.this.h = "MPV_ENGINE_ERROR";
                        }
                    }
                }
            } catch (Throwable unused2) {
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void o() {
            tv2.this.c = true;
            tv2.this.d = false;
            tv2.this.f = false;
            tv2.this.h = null;
            tv2.this.V(-1, -1);
            final int i = tv2.this.j;
            final MPV mpv = tv2.this.a;
            final hd3.d dVar = tv2.this.s;
            if (mpv != null) {
                final long j = tv2.this.k;
                if (j != -9223372036854775807L && j > 0) {
                    tv2.this.k = -9223372036854775807L;
                    App.e(new Runnable() { // from class: mv2
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // java.lang.Runnable
                        public final void run() {
                            mpv.command("seek", String.valueOf(j / 1000.0d), "absolute+keyframes");
                        }
                    }, 200L);
                }
                try {
                    Integer propertyInt = mpv.getPropertyInt("width");
                    Integer propertyInt2 = mpv.getPropertyInt("height");
                    if (propertyInt != null && propertyInt.intValue() > 0 && propertyInt2 != null && propertyInt2.intValue() > 0) {
                        if (dVar != null) {
                            final int iIntValue = propertyInt.intValue();
                            final int iIntValue2 = propertyInt2.intValue();
                            App.d(new Runnable() { // from class: nv2
                                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                                @Override // java.lang.Runnable
                                public final void run() {
                                    dVar.onVideoSizeChanged(new e35(iIntValue, iIntValue2));
                                }
                            });
                        }
                        if (i == 0) {
                            final double dIntValue = ((double) propertyInt.intValue()) / ((double) propertyInt2.intValue());
                            App.e(new Runnable() { // from class: ov2
                                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                                @Override // java.lang.Runnable
                                public final void run() {
                                    mpv.setPropertyDouble("video-aspect-override", dIntValue);
                                }
                            }, 100L);
                        }
                    }
                } catch (Throwable unused) {
                }
                if (i > 0) {
                    App.e(new Runnable() { // from class: pv2
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f.j(mpv, i);
                        }
                    }, 100L);
                }
            }
            if (dVar != null) {
                App.d(new Runnable() { // from class: qv2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f.k(dVar);
                    }
                });
            }
            if (tv2.this.n && tv2.this.h()) {
                p();
            }
            if (tv2.this.h()) {
                i(mpv);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void p() {
            App.e(new Runnable() { // from class: rv2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.l();
                }
            }, 300L);
        }

        @Override // is.xyz.mpv.MPV.EventObserver
        public void eventProperty(String str, long j) {
        }

        @Override // is.xyz.mpv.MPV.EventObserver
        public void eventProperty(String str) {
        }

        @Override // is.xyz.mpv.MPV.EventObserver
        public void eventProperty(String str, String str2) {
        }

        @Override // is.xyz.mpv.MPV.EventObserver
        public void eventProperty(String str, double d) {
        }

        @Override // is.xyz.mpv.MPV.EventObserver
        public void eventProperty(String str, MPVNode mPVNode) {
        }
    }
}
