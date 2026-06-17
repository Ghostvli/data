package defpackage;

import android.util.Log;
import java.util.logging.Level;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class e6 implements h02 {
    public final String a;

    public e6(String str) {
        this.a = str;
    }

    @Override // defpackage.h02
    public void a(Level level, String str) {
        if (level != Level.OFF) {
            Log.println(c(level), this.a, str);
        }
    }

    @Override // defpackage.h02
    public void b(Level level, String str, Throwable th) {
        if (level != Level.OFF) {
            Log.println(c(level), this.a, str + "\n" + Log.getStackTraceString(th));
        }
    }

    public final int c(Level level) {
        int iIntValue = level.intValue();
        if (iIntValue < 800) {
            return iIntValue < 500 ? 2 : 3;
        }
        if (iIntValue < 900) {
            return 4;
        }
        return iIntValue < 1000 ? 5 : 6;
    }
}
