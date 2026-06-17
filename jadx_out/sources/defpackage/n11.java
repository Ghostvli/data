package defpackage;

import android.content.Context;
import android.hardware.fingerprint.FingerprintManager;
import android.os.CancellationSignal;
import android.os.Handler;
import java.security.Signature;
import javax.crypto.Cipher;
import javax.crypto.Mac;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class n11 {
    public final Context a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends FingerprintManager.AuthenticationCallback {
        public final /* synthetic */ c a;

        public a(c cVar) {
            this.a = cVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public static void a(Object obj, Object obj2, CancellationSignal cancellationSignal, int i, Object obj3, Handler handler) {
            ((FingerprintManager) obj).authenticate((FingerprintManager.CryptoObject) obj2, cancellationSignal, i, (FingerprintManager.AuthenticationCallback) obj3, handler);
        }

        public static FingerprintManager b(Context context) {
            if (context.getPackageManager().hasSystemFeature("android.hardware.fingerprint")) {
                return (FingerprintManager) context.getSystemService(FingerprintManager.class);
            }
            return null;
        }

        public static boolean c(Object obj) {
            return ((FingerprintManager) obj).hasEnrolledFingerprints();
        }

        public static boolean d(Object obj) {
            return ((FingerprintManager) obj).isHardwareDetected();
        }

        public static FingerprintManager.CryptoObject e(d dVar) {
            if (dVar == null) {
                return null;
            }
            if (dVar.a() != null) {
                return new FingerprintManager.CryptoObject(dVar.a());
            }
            if (dVar.c() != null) {
                return new FingerprintManager.CryptoObject(dVar.c());
            }
            if (dVar.b() != null) {
                return new FingerprintManager.CryptoObject(dVar.b());
            }
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class c {
    }

    public n11(Context context) {
        this.a = context;
    }

    public static n11 c(Context context) {
        return new n11(context);
    }

    public static FingerprintManager d(Context context) {
        return b.b(context);
    }

    public static FingerprintManager.AuthenticationCallback g(c cVar) {
        return new a(cVar);
    }

    public static FingerprintManager.CryptoObject h(d dVar) {
        return b.e(dVar);
    }

    public void a(d dVar, int i, wp wpVar, c cVar, Handler handler) {
        b(dVar, i, wpVar != null ? (CancellationSignal) wpVar.b() : null, cVar, handler);
    }

    public void b(d dVar, int i, CancellationSignal cancellationSignal, c cVar, Handler handler) {
        FingerprintManager fingerprintManagerD = d(this.a);
        if (fingerprintManagerD != null) {
            b.a(fingerprintManagerD, h(dVar), cancellationSignal, i, g(cVar), handler);
        }
    }

    public boolean e() {
        FingerprintManager fingerprintManagerD = d(this.a);
        return fingerprintManagerD != null && b.c(fingerprintManagerD);
    }

    public boolean f() {
        FingerprintManager fingerprintManagerD = d(this.a);
        return fingerprintManagerD != null && b.d(fingerprintManagerD);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d {
        public final Signature a;
        public final Cipher b;
        public final Mac c;

        public d(Signature signature) {
            this.a = signature;
            this.b = null;
            this.c = null;
        }

        public Cipher a() {
            return this.b;
        }

        public Mac b() {
            return this.c;
        }

        public Signature c() {
            return this.a;
        }

        public d(Cipher cipher) {
            this.b = cipher;
            this.a = null;
            this.c = null;
        }

        public d(Mac mac) {
            this.c = mac;
            this.b = null;
            this.a = null;
        }
    }
}
