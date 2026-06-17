package defpackage;

import android.os.CancellationSignal;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class xp {
    public final c a = new a();
    public CancellationSignal b;
    public wp c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements c {
        public a() {
        }

        @Override // xp.c
        public wp a() {
            return new wp();
        }

        @Override // xp.c
        public CancellationSignal b() {
            return b.b();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public static void a(CancellationSignal cancellationSignal) {
            cancellationSignal.cancel();
        }

        public static CancellationSignal b() {
            return new CancellationSignal();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface c {
        wp a();

        CancellationSignal b();
    }

    public void a() {
        CancellationSignal cancellationSignal = this.b;
        if (cancellationSignal != null) {
            try {
                b.a(cancellationSignal);
            } catch (NullPointerException e) {
                Log.e("CancelSignalProvider", "Got NPE while canceling biometric authentication.", e);
            }
            this.b = null;
        }
        wp wpVar = this.c;
        if (wpVar != null) {
            try {
                wpVar.a();
            } catch (NullPointerException e2) {
                Log.e("CancelSignalProvider", "Got NPE while canceling fingerprint authentication.", e2);
            }
            this.c = null;
        }
    }

    public CancellationSignal b() {
        if (this.b == null) {
            this.b = this.a.b();
        }
        return this.b;
    }

    public wp c() {
        if (this.c == null) {
            this.c = this.a.a();
        }
        return this.c;
    }
}
