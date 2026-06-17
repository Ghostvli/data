package defpackage;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.os.Build;
import defpackage.pe0;
import defpackage.uc;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class me0 implements pe0.b {
    public final Context a;
    public Boolean b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public me0(Context context) {
        this.a = context == null ? null : context.getApplicationContext();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static uc b(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z) {
        return !AudioManager.isOffloadedPlaybackSupported(audioFormat, audioAttributes) ? uc.d : new uc.b().e(true).g(z).d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static uc c(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z) {
        int playbackOffloadSupport = AudioManager.getPlaybackOffloadSupport(audioFormat, audioAttributes);
        if (playbackOffloadSupport == 0) {
            return uc.d;
        }
        return new uc.b().e(true).f(Build.VERSION.SDK_INT > 32 && playbackOffloadSupport == 2).g(z).d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static uc d(AudioFormat audioFormat, AudioAttributes audioAttributes, boolean z) {
        int directPlaybackSupport = AudioManager.getDirectPlaybackSupport(audioFormat, audioAttributes);
        if ((directPlaybackSupport & 1) == 0) {
            return uc.d;
        }
        return new uc.b().e(true).f((directPlaybackSupport & 3) == 3).g(z).d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // pe0.b
    public uc a(t41 t41Var, yb ybVar) {
        gg3.q(t41Var);
        gg3.q(ybVar);
        int i = Build.VERSION.SDK_INT;
        if (i < 29 || t41Var.I == -1) {
            return uc.d;
        }
        boolean zE = e(this.a);
        int iF = nt2.f((String) gg3.q(t41Var.p), t41Var.k);
        if (iF == 0 || i < fy4.Q(iF)) {
            return uc.d;
        }
        int iS = fy4.S(t41Var.H);
        if (iS == 0) {
            return uc.d;
        }
        try {
            AudioFormat audioFormatR = fy4.R(t41Var.I, iS, iF);
            return i >= 33 ? d(audioFormatR, ybVar.c(), zE) : i >= 31 ? c(audioFormatR, ybVar.c(), zE) : b(audioFormatR, ybVar.c(), zE);
        } catch (IllegalArgumentException unused) {
            return uc.d;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean e(Context context) {
        Boolean bool = this.b;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (context != null) {
            String parameters = tc.c(context).getParameters("offloadVariableRateSupported");
            this.b = Boolean.valueOf(parameters != null && parameters.equals("offloadVariableRateSupported=1"));
        } else {
            this.b = Boolean.FALSE;
        }
        return this.b.booleanValue();
    }
}
