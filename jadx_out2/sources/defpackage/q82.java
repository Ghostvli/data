package defpackage;

import android.content.Context;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class q82 {
    public static final HashMap a = new HashMap();
    public static int b = -1;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final String a;
        public final boolean b;
        public final boolean c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(String str, boolean z, boolean z2) {
            this.a = str;
            this.b = z;
            this.c = z2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == b.class) {
                b bVar = (b) obj;
                if (TextUtils.equals(this.a, bVar.a) && this.b == bVar.b && this.c == bVar.c) {
                    return true;
                }
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int hashCode() {
            return ((((this.a.hashCode() + 31) * 31) + (this.b ? 1231 : 1237)) * 31) + (this.c ? 1231 : 1237);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends Exception {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(Throwable th) {
            super("Failed to query underlying media codecs", th);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
        MediaCodecInfo a(int i);

        boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities);

        int d();

        boolean e();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e implements d {
        public final int a;
        public MediaCodecInfo[] b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(boolean z, boolean z2, boolean z3) {
            this.a = (z || z2 || z3) ? 1 : 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // q82.d
        public MediaCodecInfo a(int i) {
            f();
            return this.b[i];
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // q82.d
        public boolean b(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureSupported(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // q82.d
        public boolean c(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities) {
            return codecCapabilities.isFeatureRequired(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // q82.d
        public int d() {
            f();
            return this.b.length;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // q82.d
        public boolean e() {
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void f() {
            if (this.b == null) {
                this.b = new MediaCodecList(this.a).getCodecInfos();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface f {
        int a(Object obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void A(List list, final f fVar) {
        Collections.sort(list, new Comparator() { // from class: p82
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return q82.a(fVar, obj, obj2);
            }
        });
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0008: ARITH (wrap:int:0x0000: INVOKE (r0v0 q82$f), (r2v0 java.lang.Object) INTERFACE call: q82.f.a(java.lang.Object):int A[MD:(java.lang.Object):int (m), WRAPPED] (LINE:1)) - (wrap:int:0x0004: INVOKE (r0v0 q82$f), (r1v0 java.lang.Object) INTERFACE call: q82.f.a(java.lang.Object):int A[MD:(java.lang.Object):int (m), WRAPPED] (LINE:5)) (LINE:9) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ int a(f fVar, Object obj, Object obj2) {
        return fVar.a(obj2) - fVar.a(obj);
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x000b: ARITH (wrap:int:?: TERNARY null = ((wrap:boolean:0x0000: IGET (r1v0 c82) A[WRAPPED] (LINE:1) c82.i boolean) != false) ? (2 int) : (0 int)) + (wrap:int:0x0009: TERNARY null = ((wrap:boolean:NOT (wrap:boolean:0x0007: IGET (r1v0 c82) A[WRAPPED] (LINE:8) c82.j boolean) A[SYNTHETIC, WRAPPED] (LINE:8)) == true) ? (1 int) : (0 int)) (LINE:12) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ int b(c82 c82Var) {
        return (c82Var.i ? 2 : 0) + (!c82Var.j ? 1 : 0);
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: ?: TERNARY null = ((wrap:boolean:0x0000: INVOKE (r2v0 c82), (r0v0 android.content.Context), (r1v0 t41) VIRTUAL call: c82.p(android.content.Context, t41):boolean A[MD:(android.content.Context, t41):boolean (m), WRAPPED] (LINE:1)) == true) ? (1 int) : (0 int) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ int c(Context context, t41 t41Var, c82 c82Var) {
        return c82Var.p(context, t41Var) ? 1 : 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ int d(c82 c82Var) {
        String str = c82Var.a;
        if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
            return 1;
        }
        return (Build.VERSION.SDK_INT >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) ? 0 : -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void e(String str, List list) {
        if ("audio/raw".equals(str)) {
            if (Build.VERSION.SDK_INT < 26 && Build.DEVICE.equals("R9") && list.size() == 1 && ((c82) list.get(0)).a.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                list.add(c82.E("OMX.google.raw.decoder", "audio/raw", "audio/raw", null, false, true, false, false, false));
            }
            A(list, new f() { // from class: n82
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // q82.f
                public final int a(Object obj) {
                    return q82.d((c82) obj);
                }
            });
        }
        if (Build.VERSION.SDK_INT >= 32 || list.size() <= 1 || !"OMX.qti.audio.decoder.flac".equals(((c82) list.get(0)).a)) {
            return;
        }
        list.add((c82) list.remove(0));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static MediaCodecInfo.CodecProfileLevel f(int i, int i2) {
        MediaCodecInfo.CodecProfileLevel codecProfileLevel = new MediaCodecInfo.CodecProfileLevel();
        codecProfileLevel.profile = i;
        codecProfileLevel.level = i2;
        return codecProfileLevel;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String g(t41 t41Var) {
        Pair pairU;
        if ("audio/eac3-joc".equals(t41Var.p)) {
            return "audio/eac3";
        }
        if ("video/dolby-vision".equals(t41Var.p) && (pairU = gv.u(t41Var)) != null) {
            int iIntValue = ((Integer) pairU.first).intValue();
            if (iIntValue == 16 || iIntValue == 256) {
                return "video/hevc";
            }
            if (iIntValue == 512) {
                return "video/avc";
            }
            if (iIntValue == 1024) {
                bx bxVar = t41Var.F;
                if (bxVar != null && bxVar.c == 6 && bxVar.b == 1) {
                    return null;
                }
                return "video/av01";
            }
        }
        if ("video/mv-hevc".equals(t41Var.p)) {
            return "video/hevc";
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List h(l82 l82Var, t41 t41Var, boolean z, boolean z2) {
        String strG = g(t41Var);
        return strG == null ? xi1.u() : l82Var.b(strG, z, z2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String i(MediaCodecInfo mediaCodecInfo, String str, String str2) {
        for (String str3 : mediaCodecInfo.getSupportedTypes()) {
            if (str3.equalsIgnoreCase(str2)) {
                return str3;
            }
        }
        if (str2.equals("video/dolby-vision")) {
            if ("OMX.MS.HEVCDV.Decoder".equals(str)) {
                return "video/hevcdv";
            }
            if ("OMX.RTK.video.decoder".equals(str) || "OMX.realtek.video.decoder.tunneled".equals(str)) {
                return "video/dv_hevc";
            }
            return null;
        }
        if (str2.equals("video/mv-hevc")) {
            if ("c2.qti.mvhevc.decoder".equals(str) || "c2.qti.mvhevc.decoder.secure".equals(str)) {
                return "video/x-mvhevc";
            }
            return null;
        }
        if (str2.equals("audio/alac") && "OMX.lge.alac.decoder".equals(str)) {
            return "audio/x-lg-alac";
        }
        if (str2.equals("audio/flac") && "OMX.lge.flac.decoder".equals(str)) {
            return "audio/x-lg-flac";
        }
        if (str2.equals("audio/ac3") && "OMX.lge.ac3.decoder".equals(str)) {
            return "audio/lg-ac3";
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static c82 j(String str, boolean z, boolean z2) {
        List listK = k(str, z, z2);
        if (listK.isEmpty()) {
            return null;
        }
        return (c82) listK.get(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static synchronized List k(String str, boolean z, boolean z2) {
        try {
            b bVar = new b(str, z, z2);
            HashMap map = a;
            List list = (List) map.get(bVar);
            if (list != null) {
                return list;
            }
            ArrayList arrayListL = l(bVar, new e(z, z2, str.equals("video/mv-hevc")));
            if (z) {
                arrayListL.isEmpty();
            }
            e(str, arrayListL);
            xi1 xi1VarP = xi1.p(arrayListL);
            map.put(bVar, xi1VarP);
            return xi1VarP;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList l(b bVar, d dVar) throws c {
        String strI;
        String str;
        int i;
        d dVar2 = dVar;
        try {
            ArrayList arrayList = new ArrayList();
            String str2 = bVar.a;
            int iD = dVar2.d();
            boolean zE = dVar2.e();
            int i2 = 0;
            while (i2 < iD) {
                MediaCodecInfo mediaCodecInfoA = dVar2.a(i2);
                if (r(mediaCodecInfoA)) {
                    i = i2;
                } else {
                    int i3 = i2;
                    String name = mediaCodecInfoA.getName();
                    if (t(mediaCodecInfoA, name, zE, str2) && (strI = i(mediaCodecInfoA, name, str2)) != null) {
                        try {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfoA.getCapabilitiesForType(strI);
                            boolean zB = dVar2.b("tunneled-playback", strI, capabilitiesForType);
                            boolean zC = dVar2.c("tunneled-playback", strI, capabilitiesForType);
                            boolean z = bVar.c;
                            if ((z || !zC) && (!z || zB)) {
                                boolean zB2 = dVar2.b("secure-playback", strI, capabilitiesForType);
                                boolean zC2 = dVar2.c("secure-playback", strI, capabilitiesForType);
                                boolean z2 = bVar.b;
                                if ((z2 || !zC2) && (!z2 || zB2)) {
                                    try {
                                        boolean zU = u(mediaCodecInfoA, str2);
                                        boolean zW = w(mediaCodecInfoA, str2);
                                        boolean zY = y(mediaCodecInfoA);
                                        try {
                                            if (zE) {
                                                if (bVar.b != zB2) {
                                                }
                                                str = strI;
                                                i = i3;
                                                arrayList.add(c82.E(name, str2, str, capabilitiesForType, zU, zW, zY, false, false));
                                            }
                                            arrayList.add(c82.E(name, str2, str, capabilitiesForType, zU, zW, zY, false, false));
                                        } catch (Exception e2) {
                                            e = e2;
                                            xz1.d("MediaCodecUtil", "Failed to query codec " + name + " (" + str + ")");
                                            throw e;
                                        }
                                        if (zE || bVar.b) {
                                            str = strI;
                                            i = i3;
                                            if (!zE && zB2) {
                                                try {
                                                    try {
                                                        arrayList.add(c82.E(name + ".secure", str2, str, capabilitiesForType, zU, zW, zY, false, true));
                                                        return arrayList;
                                                    } catch (Exception e3) {
                                                        e = e3;
                                                        name = name;
                                                        xz1.d("MediaCodecUtil", "Failed to query codec " + name + " (" + str + ")");
                                                        throw e;
                                                    }
                                                } catch (Exception e4) {
                                                    e = e4;
                                                }
                                            }
                                        }
                                        str = strI;
                                        i = i3;
                                    } catch (Exception e5) {
                                        e = e5;
                                        str = strI;
                                    }
                                } else {
                                    i = i3;
                                }
                            }
                        } catch (Exception e6) {
                            e = e6;
                            str = strI;
                        }
                    } else {
                        i = i3;
                    }
                }
                i2 = i + 1;
                dVar2 = dVar;
            }
            return arrayList;
        } catch (Exception e7) {
            throw new c(e7);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List m(l82 l82Var, t41 t41Var, boolean z, boolean z2) {
        List listB = l82Var.b(t41Var.p, z, z2);
        return xi1.m().j(listB).j(h(l82Var, t41Var, z, z2)).k();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List n(final Context context, List list, final t41 t41Var) {
        ArrayList arrayList = new ArrayList(list);
        A(arrayList, new f() { // from class: m82
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // q82.f
            public final int a(Object obj) {
                return q82.c(context, t41Var, (c82) obj);
            }
        });
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List o(List list) {
        ArrayList arrayList = new ArrayList(list);
        A(arrayList, new f() { // from class: o82
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // q82.f
            public final int a(Object obj) {
                return q82.b((c82) obj);
            }
        });
        return xi1.p(arrayList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static c82 p() {
        return j("audio/raw", false, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Pair q(t41 t41Var) {
        String strH = dx2.h(t41Var.s);
        if (strH == null) {
            return null;
        }
        return gv.x(strH, fy4.G1(strH.trim(), "\\."), t41Var.F);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean r(MediaCodecInfo mediaCodecInfo) {
        return Build.VERSION.SDK_INT >= 29 && s(mediaCodecInfo);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean s(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isAlias();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean t(MediaCodecInfo mediaCodecInfo, String str, boolean z, String str2) {
        if (mediaCodecInfo.isEncoder()) {
            return false;
        }
        return z || !str.endsWith(".secure");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean u(MediaCodecInfo mediaCodecInfo, String str) {
        return Build.VERSION.SDK_INT >= 29 ? v(mediaCodecInfo) : !w(mediaCodecInfo, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean v(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isHardwareAccelerated();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean w(MediaCodecInfo mediaCodecInfo, String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            return x(mediaCodecInfo);
        }
        if (nt2.o(str)) {
            return true;
        }
        String strF = xa.f(mediaCodecInfo.getName());
        if (strF.startsWith("arc.")) {
            return false;
        }
        return strF.startsWith("omx.google.") || strF.startsWith("omx.ffmpeg.") || (strF.startsWith("omx.sec.") && strF.contains(".sw.")) || strF.equals("omx.qcom.video.decoder.hevcswvdec") || strF.startsWith("c2.android.") || strF.startsWith("c2.google.") || !(strF.startsWith("omx.") || strF.startsWith("c2."));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean x(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isSoftwareOnly();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean y(MediaCodecInfo mediaCodecInfo) {
        if (Build.VERSION.SDK_INT >= 29) {
            return z(mediaCodecInfo);
        }
        String strF = xa.f(mediaCodecInfo.getName());
        return (strF.startsWith("omx.google.") || strF.startsWith("c2.android.") || strF.startsWith("c2.google.")) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean z(MediaCodecInfo mediaCodecInfo) {
        return mediaCodecInfo.isVendor();
    }
}
