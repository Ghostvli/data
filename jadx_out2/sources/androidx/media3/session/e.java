package androidx.media3.session;

import android.app.NotificationManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import androidx.core.graphics.drawable.IconCompat;
import androidx.media3.session.a;
import androidx.media3.session.e;
import androidx.media3.session.s;
import androidx.media3.session.u;
import defpackage.ce;
import defpackage.dl3;
import defpackage.e43;
import defpackage.eo;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.hd3;
import defpackage.i94;
import defpackage.jk;
import defpackage.lu1;
import defpackage.nm3;
import defpackage.nr2;
import defpackage.ph2;
import defpackage.v81;
import defpackage.x81;
import defpackage.xi1;
import defpackage.xi4;
import defpackage.xz1;
import defpackage.zi4;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import okhttp3.internal.ws.WebSocketProtocol;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class e implements s.b {
    public static final int j = nm3.a;
    public static final xi4 k = zi4.a(new xi4() { // from class: mg0
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.xi4
        public final Object get() {
            return Integer.valueOf(e.h());
        }
    });
    public final Context a;
    public final d b;
    public final String c;
    public final int d;
    public final NotificationManager e;
    public C0028e f;
    public int g;
    public jk h;
    public jk i;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void a(e43.c cVar) {
            cVar.j(1);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public final Context a;
        public d b = new d() { // from class: ng0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // androidx.media3.session.e.d
            public final int a(u uVar) {
                return WebSocketProtocol.CLOSE_CLIENT_GOING_AWAY;
            }
        };
        public String c = "default_channel_id";
        public int d = e.j;
        public boolean e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(Context context) {
            this.a = context;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e f() {
            gg3.v(!this.e);
            e eVar = new e(this);
            this.e = true;
            return eVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
        int a(u uVar);
    }

    /* JADX INFO: renamed from: androidx.media3.session.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class C0028e implements v81 {
        public final int a;
        public final e43.c b;
        public final s.b.a c;
        public boolean d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public C0028e(int i, e43.c cVar, s.b.a aVar) {
            this.a = i;
            this.b = cVar;
            this.c = aVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.v81
        public void b(Throwable th) {
            if (this.d) {
                return;
            }
            xz1.i("NotificationProvider", e.g(th));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c() {
            this.d = true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)V */
        @Override // defpackage.v81
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(Bitmap bitmap) {
            if (this.d) {
                return;
            }
            this.b.l(bitmap);
            this.c.a(new s(this.a, this.b.b()));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public e(Context context, d dVar, String str, int i) {
        this.a = context;
        this.b = dVar;
        this.c = str;
        this.d = i;
        this.e = (NotificationManager) gg3.q((NotificationManager) context.getSystemService("notification"));
        this.g = dl3.v0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String g(Throwable th) {
        return "Failed to load bitmap: " + th.getMessage();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int h() {
        Resources system = Resources.getSystem();
        try {
            int dimensionPixelSize = system.getDimensionPixelSize(system.getIdentifier("notification_right_icon_size", "dimen", "android"));
            if (Build.VERSION.SDK_INT < 31) {
                return Integer.max(Integer.max(dimensionPixelSize, system.getDimensionPixelSize(system.getIdentifier("notification_media_image_max_width", "dimen", "android"))), system.getDimensionPixelSize(system.getIdentifier("notification_media_image_max_height", "dimen", "android")));
            }
            return dimensionPixelSize;
        } catch (Resources.NotFoundException unused) {
            return (int) ((Build.VERSION.SDK_INT < 31 ? 280 : 48) * system.getDisplayMetrics().density);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long l(hd3 hd3Var) {
        if (!hd3Var.isPlaying() || hd3Var.isPlayingAd() || hd3Var.isCurrentMediaItemDynamic() || hd3Var.getPlaybackParameters().a != 1.0f) {
            return -9223372036854775807L;
        }
        return System.currentTimeMillis() - hd3Var.getContentPosition();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.s.b
    public final boolean a(u uVar, String str, Bundle bundle) {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.s.b
    public s.b.C0033b b() {
        return new s.b.C0033b(this.c, this.a.getString(this.d));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.session.s.b
    public final s c(u uVar, xi1 xi1Var, s.a aVar, s.b.a aVar2) {
        fy4.K(this.e, this.c, this.a.getString(this.d));
        hd3 hd3VarM = uVar.m();
        e43.c cVar = new e43.c(this.a, this.c);
        int iA = this.b.a(uVar);
        nr2 nr2Var = new nr2(uVar);
        nr2Var.h(f(uVar, i(uVar, hd3VarM.getAvailableCommands(), xi1Var, !fy4.D1(hd3VarM, uVar.o())), cVar, aVar));
        if (hd3VarM.isCommandAvailable(18)) {
            ph2 mediaMetadata = hd3VarM.getMediaMetadata();
            cVar.g(k(mediaMetadata)).f(j(mediaMetadata));
            jk jkVarD = uVar.d();
            if (this.i == null || !jkVarD.equals(this.h)) {
                this.h = jkVarD;
                this.i = new eo(new i94(jkVarD, ((Integer) k.get()).intValue(), true));
            }
            lu1 lu1VarB = this.i.b(mediaMetadata);
            if (lu1VarB != null) {
                C0028e c0028e = this.f;
                if (c0028e != null) {
                    c0028e.c();
                }
                if (lu1VarB.isDone()) {
                    try {
                        cVar.l((Bitmap) x81.c(lu1VarB));
                    } catch (CancellationException | ExecutionException e) {
                        xz1.i("NotificationProvider", g(e));
                    }
                } else {
                    C0028e c0028e2 = new C0028e(iA, cVar, aVar2);
                    this.f = c0028e2;
                    Handler handlerE0 = uVar.h().e0();
                    Objects.requireNonNull(handlerE0);
                    x81.a(lu1VarB, c0028e2, new ce(handlerE0));
                }
            }
        }
        long jL = l(hd3VarM);
        boolean z = jL != -9223372036854775807L;
        if (!z) {
            jL = 0;
        }
        cVar.t(jL).o(z).r(z);
        if (Build.VERSION.SDK_INT >= 31) {
            b.a(cVar);
        }
        return new s(iA, cVar.e(uVar.n()).h(aVar.b(uVar)).n(true).p(this.g).q(nr2Var).s(1).m(false).k("media3_group_key").b());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int[] f(u uVar, xi1 xi1Var, e43.c cVar, s.a aVar) {
        int[] iArr = new int[3];
        int[] iArr2 = new int[3];
        Arrays.fill(iArr, -1);
        Arrays.fill(iArr2, -1);
        boolean z = false;
        for (int i = 0; i < xi1Var.size(); i++) {
            androidx.media3.session.a aVar2 = (androidx.media3.session.a) xi1Var.get(i);
            if (aVar2.a != null) {
                cVar.a(aVar.c(uVar, aVar2));
            } else {
                gg3.v(aVar2.b != -1);
                cVar.a(aVar.a(uVar, IconCompat.e(this.a, aVar2.d), aVar2.f, aVar2.b));
            }
            int i2 = aVar2.g.getInt("androidx.media3.session.command.COMPACT_VIEW_INDEX", -1);
            if (i2 >= 0 && i2 < 3) {
                iArr[i2] = i;
                z = true;
            } else if (aVar2.h.c(0) == 2) {
                iArr2[0] = i;
            } else if (aVar2.h.c(0) == 1) {
                iArr2[1] = i;
            } else if (aVar2.h.c(0) == 3) {
                iArr2[2] = i;
            }
        }
        if (!z) {
            int i3 = 0;
            for (int i4 = 0; i4 < 3; i4++) {
                int i5 = iArr2[i4];
                if (i5 != -1) {
                    iArr[i3] = i5;
                    i3++;
                }
            }
        }
        for (int i6 = 0; i6 < 3; i6++) {
            if (iArr[i6] == -1) {
                return Arrays.copyOf(iArr, i6);
            }
        }
        return iArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xi1 i(u uVar, hd3.b bVar, xi1 xi1Var, boolean z) {
        xi1 xi1VarM = androidx.media3.session.a.m(xi1Var, true, true, 9);
        boolean zE = androidx.media3.session.a.e(xi1VarM, 2);
        boolean zE2 = androidx.media3.session.a.e(xi1VarM, 3);
        xi1.a aVar = new xi1.a();
        int i = 0;
        if (zE) {
            aVar.a((androidx.media3.session.a) xi1VarM.get(0));
            i = 1;
        } else if (bVar.d(7, 6)) {
            aVar.a(new a.b(57413).f(6).b(this.a.getString(nm3.v)).a());
        }
        if (bVar.c(1)) {
            if (z) {
                aVar.a(new a.b(57396).f(1).b(this.a.getString(nm3.s)).a());
            } else {
                aVar.a(new a.b(57399).f(1).b(this.a.getString(nm3.t)).a());
            }
        }
        if (zE2) {
            aVar.a((androidx.media3.session.a) xi1VarM.get(i));
            i++;
        } else if (bVar.d(9, 8)) {
            aVar.a(new a.b(57412).f(8).b(this.a.getString(nm3.u)).a());
        }
        while (i < xi1VarM.size()) {
            aVar.a((androidx.media3.session.a) xi1VarM.get(i));
            i++;
        }
        return aVar.k();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CharSequence j(ph2 ph2Var) {
        return ph2Var.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CharSequence k(ph2 ph2Var) {
        return ph2Var.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m(int i) {
        this.g = i;
    }

    public e(c cVar) {
        this(cVar.a, cVar.b, cVar.c, cVar.d);
    }
}
