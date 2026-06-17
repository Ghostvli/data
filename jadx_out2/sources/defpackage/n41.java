package defpackage;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.net.Uri;
import android.os.IBinder;
import android.os.SystemClock;
import com.fongmi.android.tv.App;
import defpackage.db4;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Map;
import java.util.regex.Pattern;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class n41 implements db4.a, ServiceConnection {
    public static final Pattern g = Pattern.compile("(?i)(p[2-9]p|mitv)");
    public final HashSet f = new HashSet();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:16:0x0000 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: n41 */
    /* JADX DEBUG: Multi-variable search result rejected for r1v1, resolved type: n41 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.util.HashSet] */
    @Override // db4.a
    public void a() {
        try {
            try {
                if (!this.f.isEmpty()) {
                    App.b().unbindService(this);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            this.f.clear();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // db4.a
    public boolean b(Uri uri) {
        return g.matcher(qx4.i(uri)).find();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // db4.a
    public String c(String str) {
        String strD = ky4.d(str);
        if (!this.f.contains(strD)) {
            d(strD);
        }
        while (!this.f.contains(strD)) {
            SystemClock.sleep(10L);
        }
        Uri uri = Uri.parse(str);
        int iC = ky4.c(strD);
        String lastPathSegment = uri.getLastPathSegment();
        q53.F("http://127.0.0.1:" + iC + "/cmd.xml?cmd=switch_chan&server=" + uri.getHost() + ":" + uri.getPort() + "&id=" + lastPathSegment, m41.a(new Map.Entry[]{new AbstractMap.SimpleEntry("User-Agent", "MTV")}));
        return "http://127.0.0.1:" + iC + ServiceReference.DELIMITER + lastPathSegment;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void d(String str) {
        App.b().bindService(ky4.b(App.b(), str), this, 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f.add(ky4.e(componentName));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f.remove(ky4.e(componentName));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // db4.a
    public void stop() {
    }
}
