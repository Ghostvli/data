package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Looper;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class bc {
    public final Context a;
    public final b b;
    public final mc1 c;
    public boolean d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class b extends BroadcastReceiver {
        public final c a;
        public final mc1 b;

        public b(mc1 mc1Var, c cVar) {
            this.b = mc1Var;
            this.a = cVar;
        }

        public final void b() {
            if (bc.this.d) {
                this.a.v();
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.b.d(new Runnable() { // from class: cc
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f.b();
                    }
                });
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface c {
        void v();
    }

    public bc(Context context, Looper looper, Looper looper2, c cVar, zu zuVar) {
        this.a = context.getApplicationContext();
        this.c = zuVar.c(looper, null);
        this.b = new b(zuVar.c(looper2, null), cVar);
    }

    public void d(boolean z) {
        if (z == this.d) {
            return;
        }
        mc1 mc1Var = this.c;
        if (z) {
            mc1Var.d(new Runnable() { // from class: zb
                @Override // java.lang.Runnable
                public final void run() {
                    bc bcVar = this.f;
                    bcVar.a.registerReceiver(bcVar.b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
                }
            });
            this.d = true;
        } else {
            mc1Var.d(new Runnable() { // from class: ac
                @Override // java.lang.Runnable
                public final void run() {
                    bc bcVar = this.f;
                    bcVar.a.unregisterReceiver(bcVar.b);
                }
            });
            this.d = false;
        }
    }
}
