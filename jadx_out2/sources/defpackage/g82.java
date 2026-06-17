package defpackage;

import android.media.MediaCodecInfo;
import android.os.Build;
import defpackage.q82;
import defpackage.t41;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g82 {
    public static Boolean a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static int a(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
            List<MediaCodecInfo.VideoCapabilities.PerformancePoint> supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints();
            if (supportedPerformancePoints == null || supportedPerformancePoints.isEmpty()) {
                return 0;
            }
            e82.a();
            int iC = c(supportedPerformancePoints, d82.a(i, i2, (int) d));
            if (iC == 1 && g82.a == null) {
                Boolean unused = g82.a = Boolean.valueOf(d());
                if (g82.a.booleanValue()) {
                    return 0;
                }
            }
            return iC;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static int b(boolean z) {
            MediaCodecInfo.VideoCapabilities videoCapabilities;
            List<MediaCodecInfo.VideoCapabilities.PerformancePoint> supportedPerformancePoints;
            try {
                t41 t41VarQ = new t41.b().A0("video/avc").Q();
                if (t41VarQ.p != null) {
                    List listM = q82.m(l82.a, t41VarQ, z, false);
                    for (int i = 0; i < listM.size(); i++) {
                        if (((c82) listM.get(i)).d != null && (videoCapabilities = ((c82) listM.get(i)).d.getVideoCapabilities()) != null && (supportedPerformancePoints = videoCapabilities.getSupportedPerformancePoints()) != null && !supportedPerformancePoints.isEmpty()) {
                            e82.a();
                            return c(supportedPerformancePoints, d82.a(1280, 720, 60));
                        }
                    }
                }
            } catch (q82.c unused) {
            }
            return 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static int c(List list, MediaCodecInfo.VideoCapabilities.PerformancePoint performancePoint) {
            for (int i = 0; i < list.size(); i++) {
                if (f82.a(list.get(i)).covers(performancePoint)) {
                    return 2;
                }
            }
            return 1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static boolean d() {
            int i = Build.VERSION.SDK_INT;
            if (i >= 37) {
                return false;
            }
            int iB = b(true);
            return i >= 35 ? iB == 1 : b(false) != 2 || iB == 1;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int c(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d) {
        if (Build.VERSION.SDK_INT < 29) {
            return 0;
        }
        Boolean bool = a;
        if (bool == null || !bool.booleanValue()) {
            return a.a(videoCapabilities, i, i2, d);
        }
        return 0;
    }
}
