package defpackage;

import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.os.Build;
import android.util.Pair;
import android.util.Range;
import java.util.Objects;
import okhttp3.internal.http2.Http2;
import okio.internal.Buffer;
import org.jupnp.support.model.dlna.DLNAProfiles;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class c82 {
    public final String a;
    public final String b;
    public final String c;
    public final MediaCodecInfo.CodecCapabilities d;
    public final boolean e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final boolean i;
    public final boolean j;
    public final boolean k;
    public final boolean l;
    public float o = -3.4028235E38f;
    public int m = -1;
    public int n = -1;

    public c82(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        this.a = (String) gg3.q(str);
        this.b = str2;
        this.c = str3;
        this.d = codecCapabilities;
        this.h = z;
        this.i = z2;
        this.j = z3;
        this.e = z4;
        this.f = z5;
        this.g = z6;
        this.k = z7;
        this.l = nt2.t(str2);
    }

    public static boolean A(String str) {
        return Build.MODEL.startsWith("SM-T230") && "OMX.MARVELL.VIDEO.HW.CODA7542DECODER".equals(str);
    }

    public static boolean B() {
        String str = Build.MANUFACTURER;
        return str.equals("Xiaomi") || str.equals("OPPO") || str.equals("realme") || str.equals("motorola") || str.equals("LENOVO");
    }

    public static boolean C(String str, int i) {
        if (!"video/hevc".equals(str) || 2 != i) {
            return false;
        }
        String str2 = Build.DEVICE;
        return "sailfish".equals(str2) || "marlin".equals(str2);
    }

    public static boolean D(String str) {
        return ("OMX.MTK.VIDEO.DECODER.HEVC".equals(str) && "mcv5a".equals(Build.DEVICE)) ? false : true;
    }

    public static c82 E(String str, String str2, String str3, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return new c82(str, str2, str3, codecCapabilities, z, z2, z3, (z4 || codecCapabilities == null || !j(codecCapabilities)) ? false : true, codecCapabilities != null && v(codecCapabilities), z5 || (codecCapabilities != null && u(codecCapabilities)), o(codecCapabilities));
    }

    public static int a(String str, String str2, int i) {
        if (i > 1 || ((Build.VERSION.SDK_INT >= 26 && i > 0) || DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_MPEG.equals(str2) || DLNAProfiles.DLNAMimeTypes.MIME_AUDIO_3GP.equals(str2) || "audio/amr-wb".equals(str2) || "audio/mp4a-latm".equals(str2) || "audio/vorbis".equals(str2) || "audio/opus".equals(str2) || "audio/raw".equals(str2) || "audio/flac".equals(str2) || "audio/g711-alaw".equals(str2) || "audio/g711-mlaw".equals(str2) || "audio/gsm".equals(str2))) {
            return i;
        }
        int i2 = "audio/ac3".equals(str2) ? 6 : "audio/eac3".equals(str2) ? 16 : 30;
        xz1.i("MediaCodecInfo", "AssumedMaxChannelAdjustment: " + str + ", [" + i + " to " + i2 + "]");
        return i2;
    }

    public static Point b(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2) {
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(fy4.n(i, widthAlignment) * widthAlignment, fy4.n(i2, heightAlignment) * heightAlignment);
    }

    public static boolean d(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        Point pointB = b(videoCapabilities, i, i2);
        int i3 = pointB.x;
        int i4 = pointB.y;
        if (d == -1.0d || d < 1.0d) {
            return videoCapabilities.isSizeSupported(i3, i4);
        }
        double dFloor = Math.floor(d);
        if (!videoCapabilities.areSizeAndRateSupported(i3, i4, dFloor)) {
            return false;
        }
        Range<Double> achievableFrameRatesFor = videoCapabilities.getAchievableFrameRatesFor(i3, i4);
        return achievableFrameRatesFor == null || dFloor <= ((Double) achievableFrameRatesFor.getUpper()).doubleValue();
    }

    public static MediaCodecInfo.CodecProfileLevel[] g(Context context, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        MediaCodecInfo.AudioCapabilities audioCapabilities;
        int i = ((codecCapabilities == null || (audioCapabilities = codecCapabilities.getAudioCapabilities()) == null) ? 2 : audioCapabilities.getMaxInputChannelCount()) > 18 ? 16 : 8;
        return fy4.O0(context) ? new MediaCodecInfo.CodecProfileLevel[]{q82.f(1026, i)} : new MediaCodecInfo.CodecProfileLevel[]{q82.f(257, i), q82.f(513, i), q82.f(514, i), q82.f(1026, i), q82.f(1028, i)};
    }

    public static boolean j(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("adaptive-playback");
    }

    public static boolean o(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return Build.VERSION.SDK_INT >= 35 && codecCapabilities != null && codecCapabilities.isFeatureSupported("detached-surface") && !B();
    }

    public static boolean u(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    public static boolean v(MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("tunneled-playback");
    }

    public static boolean z(String str) {
        return "audio/opus".equals(str);
    }

    public Point c(int i, int i2) {
        MediaCodecInfo.VideoCapabilities videoCapabilities;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        if (codecCapabilities == null || (videoCapabilities = codecCapabilities.getVideoCapabilities()) == null) {
            return null;
        }
        return b(videoCapabilities, i, i2);
    }

    public lb0 e(t41 t41Var, t41 t41Var2) {
        t41 t41Var3;
        t41 t41Var4;
        int i;
        int i2 = !Objects.equals(t41Var.p, t41Var2.p) ? 8 : 0;
        if (this.l) {
            if (t41Var.B != t41Var2.B) {
                i2 |= 1024;
            }
            boolean z = (t41Var.w == t41Var2.w && t41Var.x == t41Var2.x) ? false : true;
            if (!this.e && z) {
                i2 |= 512;
            }
            if ((!bx.i(t41Var.F) || !bx.i(t41Var2.F)) && !Objects.equals(t41Var.F, t41Var2.F)) {
                i2 |= 2048;
            }
            if (A(this.a) && !t41Var.h(t41Var2)) {
                i2 |= 2;
            }
            int i3 = t41Var.y;
            if (i3 != -1 && (i = t41Var.z) != -1 && i3 == t41Var2.y && i == t41Var2.z && z) {
                i2 |= 2;
            }
            if (i2 == 0 && Objects.equals(t41Var2.p, "video/dolby-vision")) {
                Pair pairU = gv.u(t41Var);
                Pair pairU2 = gv.u(t41Var2);
                if (pairU == null || pairU2 == null || !((Integer) pairU.first).equals(pairU2.first)) {
                    i2 |= 2;
                }
            }
            if (i2 == 0) {
                return new lb0(this.a, t41Var, t41Var2, t41Var.h(t41Var2) ? 3 : 2, 0);
            }
            t41Var3 = t41Var;
            t41Var4 = t41Var2;
        } else {
            t41Var3 = t41Var;
            t41Var4 = t41Var2;
            if (t41Var3.H != t41Var4.H) {
                i2 |= Buffer.SEGMENTING_THRESHOLD;
            }
            if (t41Var3.I != t41Var4.I) {
                i2 |= 8192;
            }
            if (t41Var3.J != t41Var4.J) {
                i2 |= Http2.INITIAL_MAX_FRAME_SIZE;
            }
            if (i2 == 0 && (this.b.equals("audio/mp4a-latm") || this.b.equals("audio/ac4"))) {
                Pair pairU3 = gv.u(t41Var3);
                Pair pairU4 = gv.u(t41Var4);
                if (pairU3 != null && pairU4 != null) {
                    int iIntValue = ((Integer) pairU3.first).intValue();
                    int iIntValue2 = ((Integer) pairU4.first).intValue();
                    if (iIntValue == 42 && iIntValue2 == 42) {
                        return new lb0(this.a, t41Var3, t41Var4, 3, 0);
                    }
                    if (this.b.equals("audio/ac4") && pairU3.equals(pairU4)) {
                        return new lb0(this.a, t41Var3, t41Var4, 3, 0);
                    }
                }
            }
            if (i2 == 0 && (this.b.equals("audio/eac3-joc") || this.b.equals("audio/eac3"))) {
                return new lb0(this.a, t41Var3, t41Var4, 3, 0);
            }
            if (!t41Var3.h(t41Var4)) {
                i2 |= 32;
            }
            if (z(this.b)) {
                i2 |= 2;
            }
            if (i2 == 0) {
                return new lb0(this.a, t41Var3, t41Var4, 1, 0);
            }
        }
        return new lb0(this.a, t41Var3, t41Var4, 0, i2);
    }

    public final float f(int i, int i2) {
        float f = 1024.0f;
        if (w(i, i2, 1024.0d)) {
            return 1024.0f;
        }
        float f2 = 0.0f;
        while (true) {
            float f3 = f - f2;
            if (Math.abs(f3) <= 5.0f) {
                return f2;
            }
            float f4 = (f3 / 2.0f) + f2;
            if (w(i, i2, f4)) {
                f2 = f4;
            } else {
                f = f4;
            }
        }
    }

    public float h(int i, int i2) {
        if (!this.l) {
            return -3.4028235E38f;
        }
        float f = this.o;
        if (f != -3.4028235E38f && this.m == i && this.n == i2) {
            return f;
        }
        float f2 = f(i, i2);
        this.o = f2;
        this.m = i;
        this.n = i2;
        return f2;
    }

    public MediaCodecInfo.CodecProfileLevel[] i() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    public boolean k(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        if (codecCapabilities == null) {
            y("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            y("channelCount.aCaps");
            return false;
        }
        if (a(this.a, this.b, audioCapabilities.getMaxInputChannelCount()) >= i) {
            return true;
        }
        y("channelCount.support, " + i);
        return false;
    }

    public boolean l(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        if (codecCapabilities == null) {
            y("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            y("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i)) {
            return true;
        }
        y("sampleRate.support, " + i);
        return false;
    }

    public final boolean m(Context context, t41 t41Var, boolean z) {
        Pair pairU = gv.u(t41Var);
        String str = t41Var.p;
        if (str != null && str.equals("video/mv-hevc")) {
            String strU = nt2.u(this.c);
            if (strU.equals("video/mv-hevc")) {
                return true;
            }
            if (strU.equals("video/hevc")) {
                pairU = q82.q(t41Var);
            }
        }
        if (pairU == null) {
            return true;
        }
        int iIntValue = ((Integer) pairU.first).intValue();
        int iIntValue2 = ((Integer) pairU.second).intValue();
        if ("video/dolby-vision".equals(t41Var.p)) {
            String str2 = this.b;
            str2.getClass();
            switch (str2) {
                case "video/av01":
                case "video/hevc":
                    iIntValue2 = 0;
                    iIntValue = 2;
                    break;
                case "video/avc":
                    iIntValue = 8;
                    iIntValue2 = 0;
                    break;
            }
        }
        if (!this.l && !this.b.equals("audio/ac4") && iIntValue != 42) {
            return true;
        }
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrI = i();
        if (this.b.equals("audio/ac4") && codecProfileLevelArrI.length == 0) {
            codecProfileLevelArrI = g(context, this.d);
        }
        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : codecProfileLevelArrI) {
            if (codecProfileLevel.profile == iIntValue && ((codecProfileLevel.level >= iIntValue2 || !z) && !C(this.b, iIntValue))) {
                return true;
            }
        }
        y("codec.profileLevel, " + t41Var.k + ", " + this.c);
        return false;
    }

    public final boolean n(t41 t41Var) {
        return (Objects.equals(t41Var.p, "audio/flac") && t41Var.J == 22 && Build.VERSION.SDK_INT < 34 && this.a.equals("c2.android.flac.decoder")) ? false : true;
    }

    public boolean p(Context context, t41 t41Var) {
        return s(t41Var) && m(context, t41Var, false) && n(t41Var);
    }

    public boolean q(Context context, t41 t41Var) {
        int i;
        int i2;
        if (!s(t41Var) || !m(context, t41Var, true) || !n(t41Var)) {
            return false;
        }
        if (!this.l) {
            int i3 = t41Var.I;
            return (i3 == -1 || l(i3)) && ((i = t41Var.H) == -1 || k(i));
        }
        int i4 = t41Var.w;
        if (i4 <= 0 || (i2 = t41Var.x) <= 0) {
            return true;
        }
        return w(i4, i2, t41Var.A);
    }

    public boolean r() {
        if (Build.VERSION.SDK_INT >= 29 && "video/x-vnd.on2.vp9".equals(this.b)) {
            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : i()) {
                if (codecProfileLevel.profile == 16384) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean s(t41 t41Var) {
        return this.b.equals(t41Var.p) || this.b.equals(q82.g(t41Var));
    }

    public boolean t(t41 t41Var) {
        if (this.l) {
            return this.e;
        }
        Pair pairU = gv.u(t41Var);
        return pairU != null && ((Integer) pairU.first).intValue() == 42;
    }

    public String toString() {
        return this.a;
    }

    public boolean w(int i, int i2, double d) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.d;
        if (codecCapabilities == null) {
            y("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            y("sizeAndRate.vCaps");
            return false;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            int iC = g82.c(videoCapabilities, i, i2, d);
            if (iC == 2) {
                return true;
            }
            if (iC == 1) {
                y("sizeAndRate.cover, " + i + "x" + i2 + "@" + d);
                return false;
            }
        }
        if (!d(videoCapabilities, i, i2, d)) {
            if (i >= i2 || !D(this.a) || !d(videoCapabilities, i2, i, d)) {
                y("sizeAndRate.support, " + i + "x" + i2 + "@" + d);
                return false;
            }
            x("sizeAndRate.rotated, " + i + "x" + i2 + "@" + d);
        }
        return true;
    }

    public final void x(String str) {
        xz1.b("MediaCodecInfo", "AssumedSupport [" + str + "] [" + this.a + ", " + this.b + "] [" + fy4.e + "]");
    }

    public final void y(String str) {
        xz1.b("MediaCodecInfo", "NoSupport [" + str + "] [" + this.a + ", " + this.b + "] [" + fy4.e + "]");
    }
}
