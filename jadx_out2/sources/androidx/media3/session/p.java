package androidx.media3.session;

import android.app.PendingIntent;
import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.a;
import androidx.media3.session.b0;
import androidx.media3.session.f;
import androidx.media3.session.n;
import androidx.media3.session.p;
import defpackage.b24;
import defpackage.c24;
import defpackage.cc2;
import defpackage.d24;
import defpackage.fm;
import defpackage.fy4;
import defpackage.hd3;
import defpackage.p81;
import defpackage.xi1;
import defpackage.xz1;
import defpackage.y14;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class p extends f.a {
    public final WeakReference d;
    public int e = -1;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void a(n nVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public p(n nVar) {
        this.d = new WeakReference(nVar);
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0001: THROW (null java.lang.Throwable) (LINE:2) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a1(String str, int i, MediaLibraryService.b bVar, k kVar) {
        throw null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void b1(n nVar, a aVar) {
        if (nVar.h2()) {
            return;
        }
        aVar.a(nVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void k1(n nVar) {
        l lVarY1 = nVar.Y1();
        l lVarY12 = nVar.Y1();
        Objects.requireNonNull(lVarY12);
        lVarY1.n(new cc2(lVarY12));
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0001: THROW (null java.lang.Throwable) (LINE:2) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void m1(String str, int i, MediaLibraryService.b bVar, k kVar) {
        throw null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.f
    public void D0(int i, Bundle bundle) {
        final Bundle bundleY = fy4.y(bundle);
        if (bundleY == null) {
            xz1.i("MediaControllerStub", "Ignoring null Bundle for extras");
        } else {
            u1(new a() { // from class: ff2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.p.a
                public final void a(n nVar) {
                    nVar.x2(bundleY);
                }
            });
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.f
    public void E(final int i, Bundle bundle) {
        try {
            final b24 b24VarA = b24.a(bundle);
            u1(new a() { // from class: qf2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.p.a
                public final void a(n nVar) {
                    nVar.w2(i, b24VarA);
                }
            });
        } catch (RuntimeException e) {
            xz1.j("MediaControllerStub", "Ignoring malformed Bundle for SessionError", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.f
    public void F(int i, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            final c cVarH = c.h(bundle);
            this.e = cVarH.b;
            u1(new a() { // from class: hf2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.p.a
                public final void a(n nVar) {
                    nVar.t2(cVarH);
                }
            });
        } catch (RuntimeException e) {
            xz1.j("MediaControllerStub", "Malformed Bundle for ConnectionResult. Disconnected from the session.", e);
            a(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.f
    public void K0(final int i, Bundle bundle, final Bundle bundle2, final Bundle bundle3) {
        if (bundle == null || bundle2 == null) {
            xz1.i("MediaControllerStub", "Ignoring custom command progress update with null args.");
            return;
        }
        try {
            final y14 y14VarA = y14.a(bundle);
            u1(new a() { // from class: gf2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.p.a
                public final void a(n nVar) {
                    nVar.v2(i, y14VarA, bundle2, bundle3);
                }
            });
        } catch (RuntimeException e) {
            xz1.j("MediaControllerStub", "Ignoring malformed Bundle for SessionCommand", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.f
    public void L0(int i, Bundle bundle, boolean z) {
        T(i, bundle, new b0.c(z, true).b());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.f
    public void M0(int i, final String str, final int i2, Bundle bundle) {
        final MediaLibraryService.b bVarA;
        if (TextUtils.isEmpty(str)) {
            xz1.i("MediaControllerStub", "onChildrenChanged(): Ignoring empty parentId");
            return;
        }
        if (i2 < 0) {
            xz1.i("MediaControllerStub", "onChildrenChanged(): Ignoring negative itemCount: " + i2);
            return;
        }
        if (bundle == null) {
            bVarA = null;
        } else {
            try {
                bVarA = MediaLibraryService.b.a(bundle);
            } catch (RuntimeException e) {
                xz1.j("MediaControllerStub", "Ignoring malformed Bundle for LibraryParams", e);
                return;
            }
        }
        u1(new a() { // from class: vf2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.p.a
            public final void a(n nVar) {
                String str2 = str;
                int i3 = i2;
                MediaLibraryService.b bVar = bVarA;
                w82.a(nVar);
                p.a1(str2, i3, bVar, null);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.f
    public void N(int i, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            final hd3.b bVarE = hd3.b.e(bundle);
            u1(new a() { // from class: mf2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.p.a
                public final void a(n nVar) {
                    nVar.r2(bVarE);
                }
            });
        } catch (RuntimeException e) {
            xz1.j("MediaControllerStub", "Ignoring malformed Bundle for Commands", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.f
    public void Q(int i, Bundle bundle) {
        int i2;
        if (bundle == null || (i2 = this.e) == -1) {
            return;
        }
        try {
            final c24 c24VarB = c24.b(bundle, i2);
            u1(new a() { // from class: if2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.p.a
                public final void a(n nVar) {
                    nVar.o2(c24VarB);
                }
            });
        } catch (RuntimeException e) {
            xz1.j("MediaControllerStub", "Ignoring malformed Bundle for SessionPositionInfo", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.f
    public void R(final int i, Bundle bundle, final Bundle bundle2) {
        if (bundle == null || bundle2 == null) {
            xz1.i("MediaControllerStub", "Ignoring custom command with null args.");
            return;
        }
        try {
            final y14 y14VarA = y14.a(bundle);
            u1(new a() { // from class: xf2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.p.a
                public final void a(n nVar) {
                    nVar.u2(i, y14VarA, bundle2);
                }
            });
        } catch (RuntimeException e) {
            xz1.j("MediaControllerStub", "Ignoring malformed Bundle for SessionCommand", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.f
    public void T(int i, Bundle bundle, Bundle bundle2) {
        int i2;
        if (bundle == null || bundle2 == null || (i2 = this.e) == -1) {
            return;
        }
        try {
            final b0 b0VarD = b0.D(bundle, i2);
            try {
                final b0.c cVarA = b0.c.a(bundle2);
                u1(new a() { // from class: nf2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // androidx.media3.session.p.a
                    public final void a(n nVar) {
                        nVar.y2(b0VarD, cVarA);
                    }
                });
            } catch (RuntimeException e) {
                xz1.j("MediaControllerStub", "Ignoring malformed Bundle for BundlingExclusions", e);
            }
        } catch (RuntimeException e2) {
            xz1.j("MediaControllerStub", "Ignoring malformed Bundle for PlayerInfo", e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.f
    public void X0(int i, Bundle bundle) {
        if (bundle == null) {
            return;
        }
        try {
            v1(i, d24.a(bundle));
        } catch (RuntimeException e) {
            xz1.j("MediaControllerStub", "Ignoring malformed Bundle for SessionResult", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.f
    public void a(int i) {
        u1(new a() { // from class: uf2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.p.a
            public final void a(n nVar) {
                p.k1(nVar);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.f
    public void a0(final int i, List list) {
        if (list == null || this.e == -1) {
            return;
        }
        try {
            final xi1 xi1VarD = fm.d(new p81() { // from class: ef2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.p81
                public final Object apply(Object obj) {
                    return a.l((Bundle) obj, this.f.e);
                }
            }, list);
            u1(new a() { // from class: pf2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.p.a
                public final void a(n nVar) {
                    nVar.B2(i, xi1VarD);
                }
            });
        } catch (RuntimeException e) {
            xz1.j("MediaControllerStub", "Ignoring malformed Bundle for CommandButton", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.f
    public void b(int i) {
        u1(new a() { // from class: sf2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.p.a
            public final void a(n nVar) {
                nVar.z2();
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.f
    public void c(int i, final int i2, final int i3) {
        u1(new a() { // from class: rf2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.p.a
            public final void a(n nVar) {
                nVar.D2(i2, i3);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.f
    public void c0(int i, Bundle bundle) {
        int i2;
        if (bundle == null || (i2 = this.e) == -1) {
            return;
        }
        try {
            v1(i, j.d(bundle, i2));
        } catch (RuntimeException e) {
            xz1.j("MediaControllerStub", "Ignoring malformed Bundle for LibraryResult", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.f
    public void d(final int i, final PendingIntent pendingIntent) {
        u1(new a() { // from class: wf2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.p.a
            public final void a(n nVar) {
                nVar.C2(i, pendingIntent);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.f
    public void d0(int i, final String str, final int i2, Bundle bundle) {
        final MediaLibraryService.b bVarA;
        if (TextUtils.isEmpty(str)) {
            xz1.i("MediaControllerStub", "onSearchResultChanged(): Ignoring empty query");
            return;
        }
        if (i2 < 0) {
            xz1.i("MediaControllerStub", "onSearchResultChanged(): Ignoring negative itemCount: " + i2);
            return;
        }
        if (bundle == null) {
            bVarA = null;
        } else {
            try {
                bVarA = MediaLibraryService.b.a(bundle);
            } catch (RuntimeException e) {
                xz1.j("MediaControllerStub", "Ignoring malformed Bundle for LibraryParams", e);
                return;
            }
        }
        u1(new a() { // from class: lf2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.p.a
            public final void a(n nVar) {
                String str2 = str;
                int i3 = i2;
                MediaLibraryService.b bVar = bVarA;
                w82.a(nVar);
                p.m1(str2, i3, bVar, null);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.f
    public void g(final int i, List list) {
        if (list == null || this.e == -1) {
            return;
        }
        try {
            final xi1 xi1VarD = fm.d(new p81() { // from class: jf2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.p81
                public final Object apply(Object obj) {
                    return a.l((Bundle) obj, this.f.e);
                }
            }, list);
            u1(new a() { // from class: kf2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // androidx.media3.session.p.a
                public final void a(n nVar) {
                    nVar.A2(i, xi1VarD);
                }
            });
        } catch (RuntimeException e) {
            xz1.j("MediaControllerStub", "Ignoring malformed Bundle for CommandButton", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.f
    public void g0(int i, Bundle bundle, Bundle bundle2) {
        if (bundle == null || bundle2 == null) {
            return;
        }
        try {
            final d0 d0VarD = d0.d(bundle);
            try {
                final hd3.b bVarE = hd3.b.e(bundle2);
                u1(new a() { // from class: tf2
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // androidx.media3.session.p.a
                    public final void a(n nVar) {
                        nVar.s2(d0VarD, bVarE);
                    }
                });
            } catch (RuntimeException e) {
                xz1.j("MediaControllerStub", "Ignoring malformed Bundle for Commands", e);
            }
        } catch (RuntimeException e2) {
            xz1.j("MediaControllerStub", "Ignoring malformed Bundle for SessionCommands", e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void t1() {
        this.d.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u1(final a aVar) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            final n nVar = (n) this.d.get();
            if (nVar == null) {
                return;
            }
            fy4.o1(nVar.Y1().e, new Runnable() { // from class: of2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    p.b1(nVar, aVar);
                }
            });
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void v1(int i, Object obj) {
        long jClearCallingIdentity = Binder.clearCallingIdentity();
        try {
            n nVar = (n) this.d.get();
            if (nVar == null) {
                return;
            }
            nVar.S2(i, obj);
        } finally {
            Binder.restoreCallingIdentity(jClearCallingIdentity);
        }
    }
}
