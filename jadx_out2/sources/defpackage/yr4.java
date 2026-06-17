package defpackage;

import android.net.TrafficStats;
import android.widget.TextView;
import com.fongmi.android.tv.App;
import java.text.DecimalFormat;
import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class yr4 {
    public static final DecimalFormat a = new DecimalFormat("#.0");
    public static final int b = App.b().getApplicationInfo().uid;
    public static long c;
    public static long d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String a() {
        StringBuilder sb;
        String str;
        long jCurrentTimeMillis = System.currentTimeMillis();
        long uidRxBytes = TrafficStats.getUidRxBytes(b) / RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        long jMax = ((uidRxBytes - c) * 1000) / Math.max(jCurrentTimeMillis - d, 1L);
        d = jCurrentTimeMillis;
        c = uidRxBytes;
        if (jMax < 1000) {
            sb = new StringBuilder();
            sb.append(jMax);
            str = " KB/s";
        } else {
            sb = new StringBuilder();
            sb.append(a.format(jMax / 1024.0f));
            str = " MB/s";
        }
        sb.append(str);
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void b() {
        c = 0L;
        d = 0L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void c(TextView textView) {
        if (TrafficStats.getUidRxBytes(b) == -1) {
            return;
        }
        textView.setVisibility(0);
        textView.setText(a());
    }
}
