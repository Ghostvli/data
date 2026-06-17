package defpackage;

import android.content.Context;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.Spatializer;
import android.media.Spatializer$OnSpatializerStateChangedListener;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class pb4 {
    public final Spatializer a;
    public final boolean b;
    public final Handler c;
    public final Spatializer$OnSpatializerStateChangedListener d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Spatializer$OnSpatializerStateChangedListener {
        public final /* synthetic */ Runnable a;

        public a(Runnable runnable) {
            this.a = runnable;
        }

        public void onSpatializerAvailableChanged(Spatializer spatializer, boolean z) {
            this.a.run();
        }

        public void onSpatializerEnabledChanged(Spatializer spatializer, boolean z) {
            this.a.run();
        }
    }

    public pb4(Context context, Runnable runnable, Boolean bool) {
        AudioManager audioManagerC = context == null ? null : tc.c(context);
        if (audioManagerC == null || (bool != null && bool.booleanValue())) {
            this.a = null;
            this.b = false;
            this.c = null;
            this.d = null;
            return;
        }
        Spatializer spatializer = audioManagerC.getSpatializer();
        this.a = spatializer;
        this.b = spatializer.getImmersiveAudioLevel() != 0;
        if (runnable == null) {
            this.c = null;
            this.d = null;
            return;
        }
        Handler handler = new Handler((Looper) gg3.q(Looper.myLooper()));
        this.c = handler;
        a aVar = new a(runnable);
        this.d = aVar;
        Objects.requireNonNull(handler);
        spatializer.addOnSpatializerStateChangedListener(new ce(handler), aVar);
    }

    public boolean a(yb ybVar, t41 t41Var) {
        int i;
        if (!f()) {
            return false;
        }
        if (Objects.equals(t41Var.p, "audio/eac3-joc")) {
            i = t41Var.H;
            if (i == 16) {
                i = 12;
            }
        } else if (Objects.equals(t41Var.p, "audio/iamf")) {
            i = t41Var.H;
            if (i == -1) {
                i = 6;
            }
        } else {
            boolean zEquals = Objects.equals(t41Var.p, "audio/ac4");
            int i2 = t41Var.H;
            i = (zEquals && (i2 == 18 || i2 == 21)) ? 24 : i2;
        }
        int iS = fy4.S(i);
        if (iS == 0) {
            return false;
        }
        AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(iS);
        int i3 = t41Var.I;
        if (i3 != -1) {
            channelMask.setSampleRate(i3);
        }
        return ob4.a(gg3.q(this.a)).canBeSpatialized(ybVar.c(), channelMask.build());
    }

    public List b() {
        return !f() ? xi1.u() : Build.VERSION.SDK_INT >= 36 ? ob4.a(gg3.q(this.a)).getSpatializedChannelMasks() : xi1.w(252);
    }

    public boolean c() {
        Spatializer spatializer = this.a;
        return spatializer != null && spatializer.isAvailable();
    }

    public boolean d() {
        Spatializer spatializer = this.a;
        return spatializer != null && spatializer.isEnabled();
    }

    public boolean e() {
        return this.b;
    }

    public boolean f() {
        return this.a != null && this.b && c() && d();
    }

    public void g() {
        Spatializer$OnSpatializerStateChangedListener spatializer$OnSpatializerStateChangedListener;
        Spatializer spatializer = this.a;
        if (spatializer == null || (spatializer$OnSpatializerStateChangedListener = this.d) == null || this.c == null) {
            return;
        }
        spatializer.removeOnSpatializerStateChangedListener(spatializer$OnSpatializerStateChangedListener);
        this.c.removeCallbacksAndMessages(null);
    }
}
