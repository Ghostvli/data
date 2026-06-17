package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.media.session.MediaSession;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.RemoteException;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.media3.session.b0;
import androidx.media3.session.c0;
import androidx.media3.session.u;
import androidx.media3.session.v;
import defpackage.ac3;
import defpackage.c24;
import defpackage.d24;
import defpackage.dc3;
import defpackage.e04;
import defpackage.e24;
import defpackage.e35;
import defpackage.fg2;
import defpackage.fm2;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.hd3;
import defpackage.jk;
import defpackage.jr1;
import defpackage.kg2;
import defpackage.kk0;
import defpackage.lr4;
import defpackage.lu1;
import defpackage.no4;
import defpackage.ph2;
import defpackage.pi2;
import defpackage.ue3;
import defpackage.v81;
import defpackage.vo;
import defpackage.w50;
import defpackage.x81;
import defpackage.xi1;
import defpackage.xi4;
import defpackage.xr4;
import defpackage.xz1;
import defpackage.y14;
import defpackage.yb;
import defpackage.yn3;
import defpackage.zi4;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class v {
    public static final d24 H = new d24(1);
    public static final xi4 I = zi4.a(new xi4() { // from class: qj2
        @Override // defpackage.xi4
        public final Object get() {
            return Integer.valueOf(v.p0());
        }
    });
    public boolean A;
    public long B;
    public boolean C;
    public xi1 D;
    public xi1 E;
    public Bundle F;
    public ac3 G;
    public final Object a = new Object();
    public final Uri b;
    public final c c;
    public final b d;
    public final u.d e;
    public final Context f;
    public final z g;
    public final w h;
    public final String i;
    public final e24 j;
    public final u k;
    public final Handler l;
    public final jk m;
    public final Runnable n;
    public final Handler o;
    public final boolean p;
    public final boolean q;
    public final boolean r;
    public final xi1 s;
    public b0 t;
    public ue3 u;
    public PendingIntent v;
    public d w;
    public u.h x;
    public u.g y;
    public y z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements v81 {
        public final /* synthetic */ u.g a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ hd3.b c;

        public a(u.g gVar, boolean z, hd3.b bVar) {
            this.a = gVar;
            this.b = z;
            this.c = bVar;
        }

        public static /* synthetic */ void c(a aVar, u.i iVar, boolean z, u.g gVar, hd3.b bVar) {
            a0.i(v.this.u, iVar);
            fy4.H0(v.this.u);
            if (z) {
                v.this.T0(gVar, bVar);
            }
        }

        @Override // defpackage.v81
        public void b(Throwable th) {
            if (th instanceof UnsupportedOperationException) {
                xz1.j("MediaSessionImpl", "UnsupportedOperationException: Make sure to implement MediaSession.Callback.onPlaybackResumption() if you add a media button receiver to your manifest or if you implement the recent media item contract with your MediaLibraryService.", th);
            } else {
                xz1.e("MediaSessionImpl", "Failure calling MediaSession.Callback.onPlaybackResumption(): " + th.getMessage(), th);
            }
            fy4.H0(v.this.u);
            if (this.b) {
                v.this.T0(this.a, this.c);
            }
        }

        @Override // defpackage.v81
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(final u.i iVar) {
            v vVar = v.this;
            final u.g gVar = this.a;
            final boolean z = this.b;
            final hd3.b bVar = this.c;
            vVar.Q(gVar, new Runnable() { // from class: tj2
                @Override // java.lang.Runnable
                public final void run() {
                    v.a.c(this.f, iVar, z, gVar, bVar);
                }
            }).run();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends Handler {
        public Runnable a;

        public b(Looper looper) {
            super(looper);
        }

        public static /* synthetic */ void a(b bVar, u.g gVar, KeyEvent keyEvent) {
            boolean zF0 = v.this.F0(gVar);
            v vVar = v.this;
            if (zF0) {
                vVar.P(keyEvent, false, false);
            } else {
                vVar.h.O0((fm2.b) gg3.q(gVar.g()));
            }
            bVar.a = null;
        }

        public Runnable b() {
            Runnable runnable = this.a;
            if (runnable == null) {
                return null;
            }
            removeCallbacks(runnable);
            Runnable runnable2 = this.a;
            this.a = null;
            return runnable2;
        }

        public void c() {
            Runnable runnableB = b();
            if (runnableB != null) {
                fy4.o1(this, runnableB);
            }
        }

        public boolean d() {
            return this.a != null;
        }

        public void e(final u.g gVar, final KeyEvent keyEvent) {
            Runnable runnable = new Runnable() { // from class: uj2
                @Override // java.lang.Runnable
                public final void run() {
                    v.b.a(this.f, gVar, keyEvent);
                }
            };
            this.a = runnable;
            postDelayed(runnable, ViewConfiguration.getDoubleTapTimeout());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends Handler {
        public boolean a;
        public boolean b;

        public c(Looper looper) {
            super(looper);
            this.a = true;
            this.b = true;
        }

        public boolean a() {
            return hasMessages(1);
        }

        public void b(boolean z, boolean z2) {
            boolean z3 = false;
            this.a = this.a && z;
            if (this.b && z2) {
                z3 = true;
            }
            this.b = z3;
            if (hasMessages(1)) {
                return;
            }
            sendEmptyMessage(1);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what != 1) {
                jr1.a("Invalid message what=", message.what);
                return;
            }
            v vVar = v.this;
            vVar.t = vVar.t.x(v.this.v0().h(), v.this.v0().d(), v.this.t.k);
            v vVar2 = v.this;
            vVar2.Z(vVar2.t, this.a, this.b);
            this.a = true;
            this.b = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d implements hd3.d {
        public final WeakReference f;
        public final WeakReference g;

        public d(v vVar, ue3 ue3Var) {
            this.f = new WeakReference(vVar);
            this.g = new WeakReference(ue3Var);
        }

        public final v T() {
            return (v) this.f.get();
        }

        @Override // hd3.d
        public void onAudioAttributesChanged(final yb ybVar) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            if (((ue3) this.g.get()) == null) {
                return;
            }
            vVarT.t = vVarT.t.a(ybVar);
            vVarT.c.b(true, true);
            vVarT.b0(new e() { // from class: bk2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i) {
                    fVar.u(i, ybVar);
                }
            });
        }

        @Override // hd3.d
        public void onAudioSessionIdChanged(final int i) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            if (((ue3) this.g.get()) == null) {
                return;
            }
            vVarT.t = vVarT.t.b(i);
            vVarT.c.b(true, true);
            vVarT.b0(new e() { // from class: ik2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i2) {
                    fVar.o(i2, i);
                }
            });
        }

        @Override // hd3.d
        public void onAvailableCommandsChanged(hd3.b bVar) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            if (((ue3) this.g.get()) == null) {
                return;
            }
            vVarT.C0(bVar);
        }

        @Override // hd3.d
        public void onCues(w50 w50Var) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            if (((ue3) this.g.get()) == null) {
                return;
            }
            vVarT.t = new b0.b(vVarT.t).d(w50Var).a();
            vVarT.c.b(true, true);
        }

        @Override // hd3.d
        public void onDeviceInfoChanged(final kk0 kk0Var) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            if (((ue3) this.g.get()) == null) {
                return;
            }
            vVarT.t = vVarT.t.d(kk0Var);
            vVarT.c.b(true, true);
            vVarT.b0(new e() { // from class: jk2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i) {
                    fVar.l(i, kk0Var);
                }
            });
        }

        @Override // hd3.d
        public void onDeviceVolumeChanged(final int i, final boolean z) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            if (((ue3) this.g.get()) == null) {
                return;
            }
            vVarT.t = vVarT.t.e(i, z);
            vVarT.c.b(true, true);
            vVarT.b0(new e() { // from class: hk2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i2) {
                    fVar.E(i2, i, z);
                }
            });
        }

        @Override // hd3.d
        public void onIsLoadingChanged(final boolean z) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            if (((ue3) this.g.get()) == null) {
                return;
            }
            vVarT.t = vVarT.t.f(z);
            vVarT.c.b(true, true);
            vVarT.b0(new e() { // from class: uk2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i) {
                    fVar.K(i, z);
                }
            });
            vVarT.b1();
        }

        @Override // hd3.d
        public void onIsPlayingChanged(final boolean z) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            if (((ue3) this.g.get()) == null) {
                return;
            }
            vVarT.t = vVarT.t.g(z);
            vVarT.c.b(true, true);
            vVarT.b0(new e() { // from class: gk2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i) {
                    fVar.e(i, z);
                }
            });
            vVarT.b1();
        }

        @Override // hd3.d
        public void onMaxSeekToPreviousPositionChanged(long j) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            if (((ue3) this.g.get()) == null) {
                return;
            }
            vVarT.t = vVarT.t.h(j);
            vVarT.c.b(true, true);
        }

        @Override // hd3.d
        public void onMediaItemTransition(final fg2 fg2Var, final int i) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            if (((ue3) this.g.get()) == null) {
                return;
            }
            vVarT.t = vVarT.t.i(i);
            vVarT.c.b(true, true);
            vVarT.b0(new e() { // from class: nk2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i2) {
                    fVar.p(i2, fg2Var, i);
                }
            });
        }

        @Override // hd3.d
        public void onMediaMetadataChanged(final ph2 ph2Var) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            if (((ue3) this.g.get()) == null) {
                return;
            }
            vVarT.t = vVarT.t.j(ph2Var);
            vVarT.c.b(true, true);
            vVarT.b0(new e() { // from class: fk2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i) {
                    fVar.J(i, ph2Var);
                }
            });
        }

        @Override // hd3.d
        public void onPlayWhenReadyChanged(final boolean z, final int i) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            if (((ue3) this.g.get()) == null) {
                return;
            }
            vVarT.t = vVarT.t.k(z, i, vVarT.t.z);
            vVarT.c.b(true, true);
            vVarT.b0(new e() { // from class: qk2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i2) {
                    fVar.B(i2, z, i);
                }
            });
        }

        @Override // hd3.d
        public void onPlaybackParametersChanged(final dc3 dc3Var) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            if (((ue3) this.g.get()) == null) {
                return;
            }
            vVarT.t = vVarT.t.l(dc3Var);
            vVarT.c.b(true, true);
            vVarT.b0(new e() { // from class: dk2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i) {
                    fVar.F(i, dc3Var);
                }
            });
        }

        @Override // hd3.d
        public void onPlaybackStateChanged(final int i) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            final ue3 ue3Var = (ue3) this.g.get();
            if (ue3Var == null) {
                return;
            }
            vVarT.t = vVarT.t.m(i, ue3Var.getPlayerError());
            vVarT.c.b(true, true);
            vVarT.b0(new e() { // from class: yj2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i2) {
                    fVar.G(i2, i, ue3Var.getPlayerError());
                }
            });
        }

        @Override // hd3.d
        public void onPlaybackSuppressionReasonChanged(final int i) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            if (((ue3) this.g.get()) == null) {
                return;
            }
            vVarT.t = vVarT.t.k(vVarT.t.v, vVarT.t.w, i);
            vVarT.c.b(true, true);
            vVarT.b0(new e() { // from class: sk2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i2) {
                    fVar.z(i2, i);
                }
            });
        }

        @Override // hd3.d
        public void onPlayerError(final ac3 ac3Var) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            if (((ue3) this.g.get()) == null) {
                return;
            }
            vVarT.t = vVarT.t.n(ac3Var);
            vVarT.c.b(true, true);
            vVarT.b0(new e() { // from class: pk2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i) {
                    fVar.C(i, ac3Var);
                }
            });
        }

        @Override // hd3.d
        public void onPlaylistMetadataChanged(final ph2 ph2Var) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            vVarT.t = vVarT.t.o(ph2Var);
            vVarT.c.b(true, true);
            vVarT.b0(new e() { // from class: vj2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i) {
                    fVar.q(i, ph2Var);
                }
            });
        }

        @Override // hd3.d
        public void onPositionDiscontinuity(final hd3.e eVar, final hd3.e eVar2, final int i) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            if (((ue3) this.g.get()) == null) {
                return;
            }
            vVarT.t = vVarT.t.p(eVar, eVar2, i);
            vVarT.c.b(true, true);
            vVarT.b0(new e() { // from class: ok2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i2) {
                    fVar.n(i2, eVar, eVar2, i);
                }
            });
        }

        @Override // hd3.d
        public void onRenderedFirstFrame() {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            androidx.media3.session.b bVarM2 = vVarT.g.M2();
            xi1 xi1VarJ = bVarM2.j();
            for (int i = 0; i < xi1VarJ.size(); i++) {
                u.g gVar = (u.g) xi1VarJ.get(i);
                if (bVarM2.l(gVar) == null) {
                    vVarT.c0(gVar, new e() { // from class: kk2
                        @Override // androidx.media3.session.v.e
                        public final void a(u.f fVar, int i2) {
                            fVar.b(i2);
                        }
                    });
                }
            }
        }

        @Override // hd3.d
        public void onRepeatModeChanged(final int i) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            if (((ue3) this.g.get()) == null) {
                return;
            }
            vVarT.t = vVarT.t.q(i);
            vVarT.c.b(true, true);
            vVarT.b0(new e() { // from class: ek2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i2) {
                    fVar.m(i2, i);
                }
            });
        }

        @Override // hd3.d
        public void onSeekBackIncrementChanged(final long j) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            if (((ue3) this.g.get()) == null) {
                return;
            }
            vVarT.t = vVarT.t.r(j);
            vVarT.c.b(true, true);
            vVarT.b0(new e() { // from class: lk2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i) {
                    fVar.j(i, j);
                }
            });
        }

        @Override // hd3.d
        public void onSeekForwardIncrementChanged(final long j) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            if (((ue3) this.g.get()) == null) {
                return;
            }
            vVarT.t = vVarT.t.s(j);
            vVarT.c.b(true, true);
            vVarT.b0(new e() { // from class: mk2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i) {
                    fVar.k(i, j);
                }
            });
        }

        @Override // hd3.d
        public void onShuffleModeEnabledChanged(final boolean z) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            if (((ue3) this.g.get()) == null) {
                return;
            }
            vVarT.t = vVarT.t.u(z);
            vVarT.c.b(true, true);
            vVarT.b0(new e() { // from class: wj2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i) {
                    fVar.L(i, z);
                }
            });
        }

        @Override // hd3.d
        public void onSurfaceSizeChanged(final int i, final int i2) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            if (((ue3) this.g.get()) == null) {
                return;
            }
            vVarT.d0(new e() { // from class: zj2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i3) {
                    fVar.c(i3, i, i2);
                }
            });
        }

        @Override // hd3.d
        public void onTimelineChanged(final no4 no4Var, final int i) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            ue3 ue3Var = (ue3) this.g.get();
            if (ue3Var == null) {
                return;
            }
            vVarT.t = vVarT.t.x(no4Var, ue3Var.d(), i);
            vVarT.c.b(false, true);
            vVarT.b0(new e() { // from class: ak2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i2) {
                    fVar.f(i2, no4Var, i);
                }
            });
        }

        @Override // hd3.d
        public void onTrackSelectionParametersChanged(final lr4 lr4Var) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            if (((ue3) this.g.get()) == null) {
                return;
            }
            vVarT.t = vVarT.t.y(lr4Var);
            vVarT.c.b(true, true);
            vVarT.d0(new e() { // from class: tk2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i) {
                    fVar.w(i, lr4Var);
                }
            });
        }

        @Override // hd3.d
        public void onTracksChanged(final xr4 xr4Var) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            if (((ue3) this.g.get()) == null) {
                return;
            }
            vVarT.t = vVarT.t.c(xr4Var);
            vVarT.c.b(true, false);
            vVarT.d0(new e() { // from class: xj2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i) {
                    fVar.x(i, xr4Var);
                }
            });
        }

        @Override // hd3.d
        public void onVideoSizeChanged(final e35 e35Var) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            vVarT.t = vVarT.t.A(e35Var);
            vVarT.c.b(true, true);
            vVarT.b0(new e() { // from class: rk2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i) {
                    fVar.r(i, e35Var);
                }
            });
        }

        @Override // hd3.d
        public void onVolumeChanged(final float f) {
            v vVarT = T();
            if (vVarT == null) {
                return;
            }
            vVarT.m1();
            vVarT.t = vVarT.t.B(f);
            vVarT.c.b(true, true);
            vVarT.b0(new e() { // from class: ck2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i) {
                    fVar.v(i, f);
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface e {
        void a(u.f fVar, int i);
    }

    public v(u uVar, Context context, String str, hd3 hd3Var, PendingIntent pendingIntent, xi1 xi1Var, xi1 xi1Var2, xi1 xi1Var3, u.d dVar, Bundle bundle, Bundle bundle2, jk jkVar, boolean z, boolean z2, boolean z3) {
        xz1.g("MediaSessionImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.10.0] [" + fy4.e + "]");
        this.k = uVar;
        this.f = context;
        this.i = str;
        this.v = pendingIntent;
        this.D = xi1Var;
        this.E = xi1Var2;
        this.s = xi1Var3;
        this.e = dVar;
        this.F = bundle2;
        this.m = jkVar;
        this.p = z;
        this.q = z2;
        this.r = z3;
        z zVar = new z(this);
        this.g = zVar;
        this.o = new Handler(Looper.getMainLooper());
        Looper applicationLooper = hd3Var.getApplicationLooper();
        Handler handler = new Handler(applicationLooper);
        this.l = handler;
        this.t = b0.H;
        this.c = new c(applicationLooper);
        this.d = new b(applicationLooper);
        Uri uriX = X(str);
        this.b = uriX;
        u.e eVarA = new u.e.a(uVar).a();
        w wVar = new w(this, uriX, handler, bundle, z, xi1Var, xi1Var2, eVarA.b, eVarA.c, bundle2);
        this.h = wVar;
        this.j = new e24(Process.myUid(), 0, 1010000300, 9, context.getPackageName(), zVar, bundle, wVar.N0().e().v());
        final ue3 ue3Var = new ue3(hd3Var);
        this.u = ue3Var;
        fy4.o1(handler, new Runnable() { // from class: nj2
            @Override // java.lang.Runnable
            public final void run() {
                this.f.g1(null, ue3Var);
            }
        });
        this.B = 3000L;
        this.n = new Runnable() { // from class: oj2
            @Override // java.lang.Runnable
            public final void run() {
                this.f.J0();
            }
        };
        fy4.o1(handler, new Runnable() { // from class: pj2
            @Override // java.lang.Runnable
            public final void run() {
                this.f.b1();
            }
        });
    }

    public static hd3.b V(hd3.b bVar) {
        if (bVar == null) {
            return null;
        }
        hd3.b.a aVarB = hd3.b.b.b();
        if (bVar.c(16)) {
            aVarB.a(16);
        }
        if (bVar.c(17)) {
            aVarB.a(17);
        }
        if (bVar.c(18)) {
            aVarB.a(18);
        }
        if (bVar.c(21)) {
            aVarB.a(21);
        }
        if (bVar.c(22)) {
            aVarB.a(22);
        }
        if (bVar.c(23)) {
            aVarB.a(23);
        }
        if (bVar.c(30)) {
            aVarB.a(30);
        }
        if (bVar.c(32)) {
            aVarB.a(32);
        }
        return aVarB.f();
    }

    public static b0 W(b0 b0Var, ac3 ac3Var) {
        b0 b0VarM = b0Var.m(1, ac3Var);
        c24 c24Var = b0Var.c;
        return b0VarM.t(new c24(c24Var.a, c24Var.b, c24Var.c, c24Var.d, 0L, 0, 0L, c24Var.h, c24Var.i, 0L));
    }

    public static Uri X(String str) {
        Uri.Builder builderAuthority = new Uri.Builder().scheme("androidx").authority("media3.session");
        if (str == null) {
            str = "";
        }
        return builderAuthority.appendPath(str).build();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Y0(Runnable runnable) {
        fy4.o1(e0(), runnable);
    }

    public static int f0(Context context) {
        int iIntValue = ((Integer) I.get()).intValue();
        return Build.VERSION.SDK_INT < 27 ? Math.max(iIntValue, (int) TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics())) : iIntValue;
    }

    public static /* synthetic */ void h(v vVar) {
        d dVar = vVar.w;
        if (dVar != null) {
            vVar.u.removeListener(dVar);
        }
    }

    public static /* synthetic */ void i(v vVar) {
        u.h hVar = vVar.x;
        if (hVar != null) {
            hVar.a(vVar.k);
        }
    }

    public static /* synthetic */ Object l(final v vVar, final vo.a aVar) {
        vVar.o.post(new Runnable() { // from class: kj2
            @Override // java.lang.Runnable
            public final void run() {
                aVar.b(Boolean.valueOf(this.f.R0()));
            }
        });
        return "onPlayRequested";
    }

    public static int p0() {
        Resources system = Resources.getSystem();
        try {
            return system.getDimensionPixelSize(system.getIdentifier("config_mediaMetadataBitmapMaxSize", "dimen", "android"));
        } catch (Resources.NotFoundException unused) {
            return system.getDisplayMetrics().widthPixels;
        }
    }

    public static /* synthetic */ void v(v vVar, u.g gVar, Runnable runnable) {
        vVar.y = gVar;
        runnable.run();
        vVar.y = null;
    }

    public static String y0(Uri uri) {
        List<String> pathSegments = uri.getPathSegments();
        return (Objects.equals(uri.getScheme(), "androidx") && Objects.equals(uri.getAuthority(), "media3.session") && !pathSegments.isEmpty()) ? pathSegments.get(0) : "";
    }

    public static /* synthetic */ void z(v vVar, boolean z, u.g gVar, Runnable runnable) {
        vVar.getClass();
        if (z) {
            Bundle bundle = Bundle.EMPTY;
            vVar.c1(gVar, new y14("androidx.media3.session.NOTIFICATION_DISMISSED_EVENT_KEY", bundle), bundle);
        }
        runnable.run();
        vVar.g.M2().h(gVar);
    }

    public e24 A0() {
        return this.j;
    }

    public Uri B0() {
        return this.b;
    }

    public final void C0(final hd3.b bVar) {
        this.c.b(false, false);
        d0(new e() { // from class: dj2
            @Override // androidx.media3.session.v.e
            public final void a(u.f fVar, int i) {
                fVar.A(i, bVar);
            }
        });
        b0(new e() { // from class: ej2
            @Override // androidx.media3.session.v.e
            public final void a(u.f fVar, int i) {
                fVar.l(i, this.a.t.s);
            }
        });
    }

    public void D0(u.g gVar, boolean z) {
        if (R0()) {
            boolean z2 = this.u.isCommandAvailable(16) && this.u.getCurrentMediaItem() != null;
            boolean z3 = this.u.isCommandAvailable(31) || this.u.isCommandAvailable(20);
            u.g gVarA1 = a1(gVar);
            hd3.b bVarF = new hd3.b.a().a(1).f();
            if (!z2 && z3) {
                x81.a((lu1) gg3.r(this.e.onPlaybackResumption(this.k, gVarA1, true), "Callback.onPlaybackResumption must return a non-null future"), new a(gVarA1, z, bVarF), new Executor() { // from class: hj2
                    @Override // java.util.concurrent.Executor
                    public final void execute(Runnable runnable) {
                        this.f.Y0(runnable);
                    }
                });
                return;
            }
            if (!z2) {
                xz1.i("MediaSessionImpl", "Play requested without current MediaItem, but playback resumption prevented by missing available commands");
            }
            fy4.H0(this.u);
            if (z) {
                T0(gVarA1, bVarF);
            }
        }
    }

    public boolean E0(u.g gVar) {
        return this.g.M2().p(gVar) || this.h.J0().p(gVar);
    }

    public boolean F0(u.g gVar) {
        return Objects.equals(gVar.f(), this.f.getPackageName()) && gVar.d() != 0 && gVar.b().getBoolean("androidx.media3.session.MediaNotificationManager", false);
    }

    public boolean G0() {
        return this.C;
    }

    public boolean H0() {
        boolean z;
        synchronized (this.a) {
            z = this.A;
        }
        return z;
    }

    public boolean I0(u.g gVar) {
        return gVar != null && Objects.equals(gVar.f(), "com.android.systemui");
    }

    public final void J0() {
        synchronized (this.a) {
            try {
                if (this.A) {
                    return;
                }
                c24 c24VarD = this.u.d();
                if (!this.c.a() && a0.b(c24VarD, this.t.c)) {
                    Y(c24VarD);
                }
                b1();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public lu1 K0(u.g gVar, List list) {
        return (lu1) gg3.r(this.e.onAddMediaItems(this.k, a1(gVar), list), "Callback.onAddMediaItems must return a non-null future");
    }

    public u.e L0(u.g gVar) {
        if (this.C && I0(gVar)) {
            return this.h.L0(this.k);
        }
        u.e eVar = (u.e) gg3.r(this.e.onConnect(this.k, gVar), "Callback.onConnect must return non-null future");
        if (F0(gVar) && eVar.a) {
            this.C = true;
            xi1 xi1VarJ = eVar.e;
            if (xi1VarJ == null) {
                xi1VarJ = this.k.j();
            }
            boolean zIsEmpty = xi1VarJ.isEmpty();
            w wVar = this.h;
            if (zIsEmpty) {
                xi1 xi1VarF = eVar.d;
                if (xi1VarF == null) {
                    xi1VarF = this.k.f();
                }
                wVar.f1(xi1VarF);
            } else {
                wVar.g1(xi1VarJ);
            }
            this.h.b1(eVar.b, eVar.c);
        }
        return eVar;
    }

    public lu1 M0(u.g gVar, u.j jVar, y14 y14Var, Bundle bundle) {
        return (lu1) gg3.r(this.e.onCustomCommand(this.k, a1(gVar), y14Var, bundle, jVar), "Callback.onCustomCommandOnHandler must return non-null future");
    }

    public final void N0(u.g gVar) {
        this.g.M2().t(gVar);
    }

    public void O0(u.g gVar) {
        if (this.C) {
            if (I0(gVar)) {
                return;
            }
            if (F0(gVar)) {
                this.C = false;
            }
        }
        this.e.onDisconnected(this.k, gVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x005d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean P(android.view.KeyEvent r4, boolean r5, final boolean r6) {
        /*
            r3 = this;
            androidx.media3.session.u r0 = r3.k
            androidx.media3.session.u$g r0 = r0.k()
            java.lang.Object r0 = defpackage.gg3.q(r0)
            androidx.media3.session.u$g r0 = (androidx.media3.session.u.g) r0
            int r4 = r4.getKeyCode()
            r1 = 85
            r2 = 79
            if (r4 == r1) goto L18
            if (r4 != r2) goto L1c
        L18:
            if (r5 == 0) goto L1c
            r4 = 87
        L1c:
            if (r4 == r2) goto L5d
            r5 = 126(0x7e, float:1.77E-43)
            if (r4 == r5) goto L57
            r5 = 127(0x7f, float:1.78E-43)
            if (r4 == r5) goto L51
            r5 = 272(0x110, float:3.81E-43)
            if (r4 == r5) goto L4b
            r5 = 273(0x111, float:3.83E-43)
            if (r4 == r5) goto L45
            switch(r4) {
                case 85: goto L5d;
                case 86: goto L3f;
                case 87: goto L4b;
                case 88: goto L45;
                case 89: goto L39;
                case 90: goto L33;
                default: goto L31;
            }
        L31:
            r3 = 0
            return r3
        L33:
            xi2 r4 = new xi2
            r4.<init>()
            goto L72
        L39:
            yi2 r4 = new yi2
            r4.<init>()
            goto L72
        L3f:
            zi2 r4 = new zi2
            r4.<init>()
            goto L72
        L45:
            wi2 r4 = new wi2
            r4.<init>()
            goto L72
        L4b:
            vi2 r4 = new vi2
            r4.<init>()
            goto L72
        L51:
            ui2 r4 = new ui2
            r4.<init>()
            goto L72
        L57:
            ti2 r4 = new ti2
            r4.<init>()
            goto L72
        L5d:
            ue3 r4 = r3.v0()
            boolean r4 = r4.getPlayWhenReady()
            if (r4 == 0) goto L6d
            sj2 r4 = new sj2
            r4.<init>()
            goto L72
        L6d:
            si2 r4 = new si2
            r4.<init>()
        L72:
            android.os.Handler r5 = r3.e0()
            aj2 r1 = new aj2
            r1.<init>()
            defpackage.fy4.o1(r5, r1)
            r3 = 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.v.P(android.view.KeyEvent, boolean, boolean):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x00a7  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00c8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean P0(androidx.media3.session.u.g r9, android.content.Intent r10) {
        /*
            Method dump skipped, instruction units count: 238
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.session.v.P0(androidx.media3.session.u$g, android.content.Intent):boolean");
    }

    public Runnable Q(final u.g gVar, final Runnable runnable) {
        return new Runnable() { // from class: ij2
            @Override // java.lang.Runnable
            public final void run() {
                v.v(this.f, gVar, runnable);
            }
        };
    }

    public void Q0() {
        fy4.o1(this.o, new Runnable() { // from class: gj2
            @Override // java.lang.Runnable
            public final void run() {
                v.i(this.f);
            }
        });
    }

    public boolean R() {
        return this.h.w0();
    }

    public boolean R0() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            try {
                return ((Boolean) vo.a(new vo.c() { // from class: jj2
                    @Override // vo.c
                    public final Object a(vo.a aVar) {
                        return v.l(this.a, aVar);
                    }
                }).get()).booleanValue();
            } catch (InterruptedException | ExecutionException e2) {
                throw new IllegalStateException(e2);
            }
        }
        u.h hVar = this.x;
        if (hVar != null) {
            return hVar.b(this.k);
        }
        return true;
    }

    public void S() {
        this.x = null;
    }

    public int S0(u.g gVar, int i) {
        return this.e.onPlayerCommandRequest(this.k, a1(gVar), i);
    }

    public void T(f fVar, u.g gVar) {
        this.g.F2(fVar, gVar);
    }

    public void T0(u.g gVar, hd3.b bVar) {
        this.e.onPlayerInteractionFinished(this.k, a1(gVar), bVar);
    }

    public abstract y U(pi2.h hVar);

    public void U0(u.g gVar) {
        if (this.C && I0(gVar)) {
            return;
        }
        this.e.onPostConnect(this.k, gVar);
    }

    public lu1 V0(u.g gVar, List list, int i, long j) {
        return (lu1) gg3.r(this.e.onSetMediaItems(this.k, a1(gVar), list, i, j), "Callback.onSetMediaItems must return a non-null future");
    }

    public lu1 W0(u.g gVar, yn3 yn3Var) {
        return (lu1) gg3.r(this.e.onSetRating(this.k, a1(gVar), yn3Var), "Callback.onSetRating must return non-null future");
    }

    public lu1 X0(u.g gVar, String str, yn3 yn3Var) {
        return (lu1) gg3.r(this.e.onSetRating(this.k, a1(gVar), str, yn3Var), "Callback.onSetRating must return non-null future");
    }

    public final void Y(final c24 c24Var) {
        androidx.media3.session.b bVarM2 = this.g.M2();
        xi1 xi1VarJ = bVarM2.j();
        for (int i = 0; i < xi1VarJ.size(); i++) {
            final u.g gVar = (u.g) xi1VarJ.get(i);
            if (bVarM2.l(gVar) == null) {
                final boolean zQ = bVarM2.q(gVar, 16);
                final boolean zQ2 = bVarM2.q(gVar, 17);
                c0(gVar, new e() { // from class: bj2
                    @Override // androidx.media3.session.v.e
                    public final void a(u.f fVar, int i2) {
                        fVar.I(i2, c24Var, zQ, zQ2, gVar.e());
                    }
                });
            }
        }
        try {
            this.h.K0().I(0, c24Var, true, true, 0);
        } catch (RemoteException e2) {
            xz1.e("MediaSessionImpl", "Exception in using media1 API", e2);
        }
    }

    public final void Z(b0 b0Var, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        int iC;
        b0 b0VarJ3 = this.g.j3(b0Var);
        xi1 xi1VarJ = this.g.M2().j();
        int i = 0;
        while (i < xi1VarJ.size()) {
            u.g gVar = (u.g) xi1VarJ.get(i);
            try {
                androidx.media3.session.b bVarM2 = this.g.M2();
                c0 c0VarN = bVarM2.n(gVar);
                if (c0VarN != null) {
                    iC = c0VarN.c();
                } else if (!E0(gVar)) {
                    return;
                } else {
                    iC = 0;
                }
                b0 b0VarM = bVarM2.m(gVar);
                if (b0VarM != null) {
                    z3 = z;
                    z4 = z2;
                } else {
                    ac3 ac3VarL = bVarM2.l(gVar);
                    if (ac3VarL != null) {
                        b0VarM = W(b0VarJ3, ac3VarL);
                        bVarM2.w(gVar, b0VarM);
                    }
                    z3 = z;
                    z4 = z2;
                    try {
                        ((u.f) gg3.q(gVar.c())).y(iC, b0VarM == null ? b0VarJ3 : b0VarM, a0.f(bVarM2.i(gVar), v0().getAvailableCommands()), z3, z4);
                    } catch (DeadObjectException unused) {
                        N0(gVar);
                    } catch (RemoteException e2) {
                        e = e2;
                        xz1.j("MediaSessionImpl", "Exception in " + gVar, e);
                    }
                }
            } catch (DeadObjectException unused2) {
                z3 = z;
                z4 = z2;
            } catch (RemoteException e3) {
                e = e3;
                z3 = z;
                z4 = z2;
            }
            i++;
            z = z3;
            z2 = z4;
        }
    }

    public void Z0() {
        xz1.g("MediaSessionImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.10.0] [" + fy4.e + "] [" + kg2.b() + "]");
        synchronized (this.a) {
            try {
                if (this.A) {
                    return;
                }
                this.A = true;
                this.d.b();
                this.l.removeCallbacksAndMessages(null);
                try {
                    fy4.o1(this.l, new Runnable() { // from class: ri2
                        @Override // java.lang.Runnable
                        public final void run() {
                            v.h(this.f);
                        }
                    });
                } catch (Exception e2) {
                    xz1.j("MediaSessionImpl", "Exception thrown while closing", e2);
                }
                this.h.Z0();
                this.g.V2();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final lu1 a0(u.g gVar, e eVar) {
        int iS;
        lu1 lu1VarE;
        try {
            c0 c0VarN = this.g.M2().n(gVar);
            if (c0VarN != null) {
                c0.a aVarA = c0VarN.a(H);
                iS = aVarA.S();
                lu1VarE = aVarA;
            } else {
                if (!E0(gVar)) {
                    return x81.e(new d24(-100));
                }
                iS = 0;
                lu1VarE = x81.e(new d24(0));
            }
            u.f fVarC = gVar.c();
            if (fVarC != null) {
                eVar.a(fVarC, iS);
            }
            return lu1VarE;
        } catch (DeadObjectException unused) {
            N0(gVar);
            return x81.e(new d24(-100));
        } catch (RemoteException e2) {
            xz1.j("MediaSessionImpl", "Exception in " + gVar, e2);
            return x81.e(new d24(-1));
        }
    }

    public u.g a1(u.g gVar) {
        return (this.C && I0(gVar)) ? (u.g) gg3.q(q0()) : gVar;
    }

    public final void b0(e eVar) {
        try {
            eVar.a(this.h.K0(), 0);
        } catch (RemoteException e2) {
            xz1.e("MediaSessionImpl", "Exception in using media1 API", e2);
        }
    }

    public final void b1() {
        this.l.removeCallbacks(this.n);
        if (!this.q || this.B <= 0) {
            return;
        }
        if (this.u.isPlaying() || this.u.isLoading()) {
            this.l.postDelayed(this.n, this.B);
        }
    }

    public final void c0(u.g gVar, e eVar) {
        int iC;
        try {
            c0 c0VarN = this.g.M2().n(gVar);
            if (c0VarN != null) {
                iC = c0VarN.c();
            } else if (!E0(gVar)) {
                return;
            } else {
                iC = 0;
            }
            u.f fVarC = gVar.c();
            if (fVarC != null) {
                eVar.a(fVarC, iC);
            }
        } catch (DeadObjectException unused) {
            N0(gVar);
        } catch (RemoteException e2) {
            xz1.j("MediaSessionImpl", "Exception in " + gVar, e2);
        }
    }

    public lu1 c1(u.g gVar, final y14 y14Var, final Bundle bundle) {
        return a0(gVar, new e() { // from class: fj2
            @Override // androidx.media3.session.v.e
            public final void a(u.f fVar, int i) {
                fVar.h(i, y14Var, bundle);
            }
        });
    }

    public final void d0(e eVar) {
        xi1 xi1VarJ = this.g.M2().j();
        for (int i = 0; i < xi1VarJ.size(); i++) {
            c0((u.g) xi1VarJ.get(i), eVar);
        }
        try {
            eVar.a(this.h.K0(), 0);
        } catch (RemoteException e2) {
            xz1.e("MediaSessionImpl", "Exception in using media1 API", e2);
        }
    }

    public void d1(final xi1 xi1Var) {
        this.E = xi1Var;
        this.h.g1(xi1Var);
        d0(new e() { // from class: cj2
            @Override // androidx.media3.session.v.e
            public final void a(u.f fVar, int i) {
                fVar.i(i, xi1Var);
            }
        });
    }

    public Handler e0() {
        return this.l;
    }

    public void e1(u.h hVar) {
        this.x = hVar;
    }

    public void f1(hd3 hd3Var) {
        if (hd3Var == this.u.getWrappedPlayer()) {
            return;
        }
        g1(this.u, new ue3(hd3Var));
    }

    public jk g0() {
        return this.m;
    }

    public final void g1(final ue3 ue3Var, final ue3 ue3Var2) {
        this.u = ue3Var2;
        if (ue3Var != null) {
            ue3Var.removeListener((hd3.d) gg3.q(this.w));
        }
        d dVar = new d(this, ue3Var2);
        ue3Var2.addListener(dVar);
        this.w = dVar;
        b0(new e() { // from class: rj2
            @Override // androidx.media3.session.v.e
            public final void a(u.f fVar, int i) {
                fVar.g(i, ue3Var, ue3Var2);
            }
        });
        if (ue3Var == null) {
            this.h.j1();
        }
        this.t = ue3Var2.b();
        C0(ue3Var2.getAvailableCommands());
    }

    public xi1 h0() {
        return this.s;
    }

    public void h1(PendingIntent pendingIntent) {
        this.v = pendingIntent;
        xi1 xi1VarJ = this.g.M2().j();
        for (int i = 0; i < xi1VarJ.size(); i++) {
            i1((u.g) xi1VarJ.get(i), pendingIntent);
        }
    }

    public List i0() {
        xi1 xi1VarJ = this.g.M2().j();
        xi1 xi1VarJ2 = this.h.J0().j();
        xi1.a aVarN = xi1.n(xi1VarJ.size() + xi1VarJ2.size());
        if (!this.C) {
            return aVarN.j(xi1VarJ).j(xi1VarJ2).k();
        }
        for (int i = 0; i < xi1VarJ.size(); i++) {
            u.g gVar = (u.g) xi1VarJ.get(i);
            if (!I0(gVar)) {
                aVarN.a(gVar);
            }
        }
        for (int i2 = 0; i2 < xi1VarJ2.size(); i2++) {
            u.g gVar2 = (u.g) xi1VarJ2.get(i2);
            if (!I0(gVar2)) {
                aVarN.a(gVar2);
            }
        }
        return aVarN.k();
    }

    public void i1(u.g gVar, final PendingIntent pendingIntent) {
        if (gVar.d() < 3 || !this.g.M2().p(gVar)) {
            return;
        }
        c0(gVar, new e() { // from class: lj2
            @Override // androidx.media3.session.v.e
            public final void a(u.f fVar, int i) {
                fVar.d(i, pendingIntent);
            }
        });
        if (F0(gVar)) {
            b0(new e() { // from class: mj2
                @Override // androidx.media3.session.v.e
                public final void a(u.f fVar, int i) {
                    fVar.d(i, pendingIntent);
                }
            });
        }
    }

    public Context j0() {
        return this.f;
    }

    public boolean j1() {
        return this.p;
    }

    public xi1 k0() {
        return this.D;
    }

    public boolean k1() {
        return this.r;
    }

    public String l0() {
        return this.i;
    }

    public void l1() {
        this.c.b(true, true);
    }

    public y m0() {
        y yVar;
        synchronized (this.a) {
            yVar = this.z;
        }
        return yVar;
    }

    public final void m1() {
        if (Looper.myLooper() == this.l.getLooper()) {
            return;
        }
        e04.a("Player callback method is called from a wrong thread. See javadoc of MediaSession for details.");
    }

    public IBinder n0() {
        y yVar;
        synchronized (this.a) {
            try {
                if (this.z == null) {
                    this.z = U(this.h.N0().e());
                }
                yVar = this.z;
            } catch (Throwable th) {
                throw th;
            }
        }
        return yVar.onBind(new Intent("android.media.browse.MediaBrowserService"));
    }

    public xi1 o0() {
        return this.E;
    }

    public u.g q0() {
        xi1 xi1VarJ = this.g.M2().j();
        for (int i = 0; i < xi1VarJ.size(); i++) {
            u.g gVar = (u.g) xi1VarJ.get(i);
            if (F0(gVar)) {
                return gVar;
            }
        }
        return null;
    }

    public w r0() {
        return this.h;
    }

    public MediaSession.Token s0() {
        return this.h.N0().e().v();
    }

    public ac3 t0() {
        return this.G;
    }

    public b0 u0() {
        return this.t;
    }

    public ue3 v0() {
        return this.u;
    }

    public PendingIntent w0() {
        return this.v;
    }

    public Bundle x0() {
        return this.F;
    }

    public u.g z0() {
        xi1 xi1VarJ = this.h.J0().j();
        for (int i = 0; i < xi1VarJ.size(); i++) {
            u.g gVar = (u.g) xi1VarJ.get(i);
            if (I0(gVar)) {
                return gVar;
            }
        }
        xi1 xi1VarJ2 = this.g.M2().j();
        for (int i2 = 0; i2 < xi1VarJ2.size(); i2++) {
            u.g gVar2 = (u.g) xi1VarJ2.get(i2);
            if (I0(gVar2)) {
                return gVar2;
            }
        }
        return null;
    }
}
