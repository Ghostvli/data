package androidx.media3.exoplayer;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Looper;
import androidx.media3.exoplayer.q;
import defpackage.gg3;
import defpackage.p81;
import defpackage.tc;
import defpackage.xf;
import defpackage.xz1;
import defpackage.zu;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class q {
    public final Context a;
    public final b b;
    public final xf c;
    public AudioManager d;
    public d e;
    public int f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void B(int i, boolean z);

        void s(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public final int a;
        public final int b;
        public final boolean c;
        public final int d;
        public final int e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(int i, int i2, boolean z, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = z;
            this.d = i3;
            this.e = i4;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class d extends BroadcastReceiver {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ void a(d dVar) {
            if (q.this.e == null) {
                return;
            }
            q.this.c.g(q.this.s(((c) q.this.c.d()).a));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            q.this.c.e(new Runnable() { // from class: vf4
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    q.d.a(this.f);
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public q(Context context, b bVar, final int i, Looper looper, Looper looper2, zu zuVar) {
        this.a = context.getApplicationContext();
        this.b = bVar;
        xf xfVar = new xf(new c(i, 0, false, 0, 0), looper, looper2, zuVar, new xf.a() { // from class: hf4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // xf.a
            public final void a(Object obj, Object obj2) {
                this.a.y((q.c) obj, (q.c) obj2);
            }
        });
        this.c = xfVar;
        xfVar.e(new Runnable() { // from class: mf4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                q.m(this.f, i);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ c a(q qVar, boolean z, c cVar) {
        qVar.getClass();
        return new c(cVar.a, cVar.c == z ? cVar.b : z ? 0 : qVar.f, z, cVar.d, cVar.e);
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x000b: CONSTRUCTOR 
      (r6v0 int)
      (wrap:int:0x0002: IGET (r7v0 androidx.media3.exoplayer.q$c) A[WRAPPED] (LINE:3) androidx.media3.exoplayer.q.c.b int)
      (wrap:boolean:0x0004: IGET (r7v0 androidx.media3.exoplayer.q$c) A[WRAPPED] (LINE:5) androidx.media3.exoplayer.q.c.c boolean)
      (wrap:int:0x0006: IGET (r7v0 androidx.media3.exoplayer.q$c) A[WRAPPED] (LINE:7) androidx.media3.exoplayer.q.c.d int)
      (wrap:int:0x0008: IGET (r7v0 androidx.media3.exoplayer.q$c) A[WRAPPED] (LINE:9) androidx.media3.exoplayer.q.c.e int)
     A[MD:(int, int, boolean, int, int):void (m)] (LINE:12) call: androidx.media3.exoplayer.q.c.<init>(int, int, boolean, int, int):void type: CONSTRUCTOR */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ c b(int i, c cVar) {
        return new c(i, cVar.b, cVar.c, cVar.d, cVar.e);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ c c(c cVar) {
        return cVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ c d(int i, c cVar) {
        int i2 = cVar.a;
        int i3 = cVar.d;
        return new c(i2, (i < i3 || i > cVar.e) ? cVar.b : i, i == 0, i3, cVar.e);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ c e(c cVar) {
        int i = cVar.a;
        int i2 = cVar.b;
        int i3 = cVar.d;
        return new c(i, i2 > i3 ? i2 - 1 : i3, i2 <= 1, i3, cVar.e);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ c f(q qVar, int i, c cVar) {
        qVar.getClass();
        if (cVar.b <= cVar.d) {
            return cVar;
        }
        ((AudioManager) gg3.q(qVar.d)).adjustStreamVolume(cVar.a, -1, i);
        return qVar.s(cVar.a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ c g(q qVar, int i, int i2, c cVar) {
        qVar.getClass();
        if (i == cVar.b || i < cVar.d || i > cVar.e) {
            return cVar;
        }
        ((AudioManager) gg3.q(qVar.d)).setStreamVolume(cVar.a, i, i2);
        return qVar.s(cVar.a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ c h(q qVar, int i, c cVar) {
        qVar.getClass();
        return cVar.a == i ? cVar : qVar.s(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ c i(q qVar, c cVar) {
        d dVar = qVar.e;
        if (dVar != null) {
            try {
                qVar.a.unregisterReceiver(dVar);
            } catch (RuntimeException e) {
                xz1.j("StreamVolumeManager", "Error unregistering stream volume receiver", e);
            }
            qVar.e = null;
        }
        return cVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ c j(q qVar, boolean z, int i, c cVar) {
        qVar.getClass();
        if (cVar.c == z) {
            return cVar;
        }
        gg3.q(qVar.d);
        qVar.d.adjustStreamVolume(cVar.a, z ? -100 : 100, i);
        return qVar.s(cVar.a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ c k(q qVar, int i, c cVar) {
        qVar.getClass();
        if (cVar.b >= cVar.e) {
            return cVar;
        }
        ((AudioManager) gg3.q(qVar.d)).adjustStreamVolume(cVar.a, 1, i);
        return qVar.s(cVar.a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void m(q qVar, int i) {
        qVar.d = (AudioManager) gg3.q((AudioManager) qVar.a.getSystemService("audio"));
        d dVar = new d();
        try {
            qVar.a.registerReceiver(dVar, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            qVar.e = dVar;
        } catch (RuntimeException e) {
            xz1.j("StreamVolumeManager", "Error registering stream volume receiver", e);
        }
        qVar.c.g(qVar.s(i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ c n(c cVar) {
        int i = cVar.a;
        int i2 = cVar.b;
        int i3 = cVar.e;
        return new c(i, i2 < i3 ? i2 + 1 : i3, false, cVar.d, i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void A(final boolean z, final int i) {
        this.c.h(new p81() { // from class: tf4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return q.a(this.f, z, (q.c) obj);
            }
        }, new p81() { // from class: uf4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return q.j(this.f, z, i, (q.c) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void B(final int i) {
        this.c.h(new p81() { // from class: rf4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return q.b(i, (q.c) obj);
            }
        }, new p81() { // from class: sf4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return q.h(this.f, i, (q.c) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void C(final int i, final int i2) {
        this.c.h(new p81() { // from class: pf4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return q.d(i, (q.c) obj);
            }
        }, new p81() { // from class: qf4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return q.g(this.f, i, i2, (q.c) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void r(final int i) {
        this.c.h(new p81() { // from class: nf4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return q.e((q.c) obj);
            }
        }, new p81() { // from class: of4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return q.f(this.f, i, (q.c) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final c s(int i) {
        gg3.q(this.d);
        return new c(i, tc.f(this.d, i), tc.g(this.d, i), tc.e(this.d, i), tc.d(this.d, i));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int t() {
        return ((c) this.c.d()).e;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int u() {
        return ((c) this.c.d()).d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int v() {
        return ((c) this.c.d()).b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void w(final int i) {
        this.c.h(new p81() { // from class: kf4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return q.n((q.c) obj);
            }
        }, new p81() { // from class: lf4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return q.k(this.f, i, (q.c) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean x() {
        return ((c) this.c.d()).c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void y(c cVar, c cVar2) {
        boolean z = cVar.c;
        if (!z && cVar2.c) {
            this.f = cVar.b;
        }
        int i = cVar.b;
        int i2 = cVar2.b;
        if (i != i2 || z != cVar2.c) {
            this.b.B(i2, cVar2.c);
        }
        int i3 = cVar.a;
        int i4 = cVar2.a;
        if (i3 == i4 && cVar.d == cVar2.d && cVar.e == cVar2.e) {
            return;
        }
        this.b.s(i4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void z() {
        this.c.h(new p81() { // from class: if4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return q.c((q.c) obj);
            }
        }, new p81() { // from class: jf4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return q.i(this.f, (q.c) obj);
            }
        });
    }
}
