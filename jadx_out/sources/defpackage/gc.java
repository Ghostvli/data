package defpackage;

import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.media.AudioDeviceCallback;
import android.media.AudioDeviceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class gc {
    public final Context a;
    public final e b;
    public final Handler c;
    public final b d;
    public final BroadcastReceiver e;
    public final c f;
    public pb4 g;
    public ec h;
    public AudioDeviceInfo i;
    public yb j;
    public boolean k;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class b extends AudioDeviceCallback {
        public b() {
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesAdded(AudioDeviceInfo[] audioDeviceInfoArr) {
            gc.this.o();
        }

        @Override // android.media.AudioDeviceCallback
        public void onAudioDevicesRemoved(AudioDeviceInfo[] audioDeviceInfoArr) {
            if (fy4.v(audioDeviceInfoArr, gc.this.i)) {
                gc.this.i = null;
            }
            gc.this.o();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class c extends ContentObserver {
        public final ContentResolver a;
        public final Uri b;

        public c(Handler handler, ContentResolver contentResolver, Uri uri) {
            super(handler);
            this.a = contentResolver;
            this.b = uri;
        }

        public void a() {
            this.a.registerContentObserver(this.b, false, this);
        }

        public void b() {
            this.a.unregisterContentObserver(this);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            gc.this.o();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (isInitialStickyBroadcast()) {
                return;
            }
            List listH = gc.this.h();
            gc gcVar = gc.this;
            gcVar.i(ec.f(context, intent, gcVar.j, gc.this.i, listH));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface e {
        void a(ec ecVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public gc(Context context, e eVar, yb ybVar, AudioDeviceInfo audioDeviceInfo) {
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.b = (e) gg3.q(eVar);
        this.j = ybVar;
        this.i = audioDeviceInfo;
        Handler handlerG = fy4.G();
        this.c = handlerG;
        this.d = new b();
        this.e = new d();
        Uri uriI = ec.i();
        this.f = uriI != null ? new c(handlerG, applicationContext.getContentResolver(), uriI) : null;
    }

    public final List h() {
        pb4 pb4Var;
        return (Build.VERSION.SDK_INT < 32 || (pb4Var = this.g) == null) ? xi1.u() : pb4Var.b();
    }

    public final void i(ec ecVar) {
        if (!this.k || ecVar.equals(this.h)) {
            return;
        }
        this.h = ecVar;
        this.b.a(ecVar);
    }

    public void j(ec ecVar) {
        i(ecVar);
    }

    public ec k() {
        if (this.k) {
            return (ec) gg3.q(this.h);
        }
        this.k = true;
        c cVar = this.f;
        if (cVar != null) {
            cVar.a();
        }
        tc.c(this.a).registerAudioDeviceCallback(this.d, this.c);
        if (Build.VERSION.SDK_INT >= 32 && this.g == null) {
            this.g = new pb4(this.a, new Runnable() { // from class: fc
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.o();
                }
            }, Boolean.valueOf(fy4.W0(this.a)));
        }
        ec ecVarF = ec.f(this.a, this.a.registerReceiver(this.e, new IntentFilter("android.media.action.HDMI_AUDIO_PLUG"), null, this.c), this.j, this.i, h());
        this.h = ecVarF;
        return ecVarF;
    }

    public void l(yb ybVar) {
        if (Objects.equals(ybVar, this.j)) {
            return;
        }
        this.j = ybVar;
        i(ec.e(this.a, ybVar, this.i, h()));
    }

    public void m(AudioDeviceInfo audioDeviceInfo) {
        if (Objects.equals(audioDeviceInfo, this.i)) {
            return;
        }
        this.i = audioDeviceInfo;
        i(ec.e(this.a, this.j, audioDeviceInfo, h()));
    }

    public void n() {
        pb4 pb4Var;
        if (this.k) {
            this.h = null;
            tc.c(this.a).unregisterAudioDeviceCallback(this.d);
            if (Build.VERSION.SDK_INT >= 32 && (pb4Var = this.g) != null) {
                pb4Var.g();
                this.g = null;
            }
            this.a.unregisterReceiver(this.e);
            c cVar = this.f;
            if (cVar != null) {
                cVar.b();
            }
            this.k = false;
        }
    }

    public final void o() {
        i(ec.e(this.a, this.j, this.i, h()));
    }
}
