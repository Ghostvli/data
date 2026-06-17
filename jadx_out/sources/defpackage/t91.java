package defpackage;

import android.util.Log;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class t91 implements gs3 {
    @Override // defpackage.gs3
    public ms0 b(u63 u63Var) {
        return ms0.SOURCE;
    }

    @Override // defpackage.ns0
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(yr3 yr3Var, File file, u63 u63Var) throws Throwable {
        try {
            bn.f(((r91) yr3Var.get()).c(), file);
            return true;
        } catch (IOException e) {
            if (!Log.isLoggable("GifEncoder", 5)) {
                return false;
            }
            Log.w("GifEncoder", "Failed to encode GIF drawable data", e);
            return false;
        }
    }
}
