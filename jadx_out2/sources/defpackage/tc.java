package defpackage;

import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class tc {
    public static AudioManager a;
    public static Context b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(Context context, cz czVar) {
        a = (AudioManager) context.getSystemService("audio");
        czVar.f();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int b(AudioManager audioManager, qc qcVar) {
        return Build.VERSION.SDK_INT >= 26 ? audioManager.abandonAudioFocusRequest(qcVar.c()) : audioManager.abandonAudioFocus(qcVar.f());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static synchronized AudioManager c(Context context) {
        try {
            final Context applicationContext = context.getApplicationContext();
            if (b != applicationContext) {
                a = null;
            }
            AudioManager audioManager = a;
            if (audioManager != null) {
                return audioManager;
            }
            Looper looperMyLooper = Looper.myLooper();
            if (looperMyLooper != null && looperMyLooper != Looper.getMainLooper()) {
                final cz czVar = new cz();
                sf.a().execute(new Runnable() { // from class: sc
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        tc.a(applicationContext, czVar);
                    }
                });
                czVar.b();
                return (AudioManager) gg3.q(a);
            }
            AudioManager audioManager2 = (AudioManager) applicationContext.getSystemService("audio");
            a = audioManager2;
            return (AudioManager) gg3.q(audioManager2);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int d(AudioManager audioManager, int i) {
        return audioManager.getStreamMaxVolume(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int e(AudioManager audioManager, int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            return audioManager.getStreamMinVolume(i);
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int f(AudioManager audioManager, int i) {
        try {
            return audioManager.getStreamVolume(i);
        } catch (RuntimeException e) {
            xz1.j("AudioManagerCompat", "Could not retrieve stream volume for stream type " + i, e);
            return audioManager.getStreamMaxVolume(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean g(AudioManager audioManager, int i) {
        return audioManager.isStreamMute(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int h(AudioManager audioManager, qc qcVar) {
        return Build.VERSION.SDK_INT >= 26 ? audioManager.requestAudioFocus(qcVar.c()) : audioManager.requestAudioFocus(qcVar.f(), qcVar.b().e(), qcVar.e());
    }
}
