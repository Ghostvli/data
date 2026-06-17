package defpackage;

import android.util.Log;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class e02 implements n22 {
    public static final Set a = new HashSet();

    @Override // defpackage.n22
    public void a(String str, Throwable th) {
        if (or1.a) {
            Log.d("LOTTIE", str, th);
        }
    }

    @Override // defpackage.n22
    public void b(String str) {
        e(str, null);
    }

    @Override // defpackage.n22
    public void c(String str, Throwable th) {
        Set set = a;
        if (set.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str, th);
        set.add(str);
    }

    @Override // defpackage.n22
    public void d(String str) {
        c(str, null);
    }

    public void e(String str, Throwable th) {
        if (or1.a) {
            Log.d("LOTTIE", str, th);
        }
    }
}
