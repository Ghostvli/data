package androidx.media3.session;

import android.app.PendingIntent;
import android.media.session.MediaSession;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import androidx.media3.session.a;
import androidx.media3.session.g;
import defpackage.fm;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.hd3;
import defpackage.hm;
import defpackage.p81;
import defpackage.xi1;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public final int a;
    public final int b;
    public final g c;
    public final PendingIntent d;
    public final d0 e;
    public final hd3.b f;
    public final hd3.b g;
    public final Bundle h;
    public final Bundle i;
    public final b0 j;
    public final xi1 k;
    public final xi1 l;
    public final MediaSession.Token m;
    public final xi1 n;
    public static final String o = fy4.N0(0);
    public static final String p = fy4.N0(1);
    public static final String q = fy4.N0(2);
    public static final String r = fy4.N0(9);
    public static final String s = fy4.N0(14);
    public static final String t = fy4.N0(13);
    public static final String u = fy4.N0(3);
    public static final String v = fy4.N0(4);
    public static final String w = fy4.N0(5);
    public static final String x = fy4.N0(6);
    public static final String y = fy4.N0(11);
    public static final String z = fy4.N0(7);
    public static final String A = fy4.N0(8);
    public static final String B = fy4.N0(10);
    public static final String C = fy4.N0(12);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class b extends Binder {
        public b() {
        }

        public c a() {
            return c.this;
        }
    }

    public c(int i, int i2, g gVar, PendingIntent pendingIntent, xi1 xi1Var, xi1 xi1Var2, xi1 xi1Var3, d0 d0Var, hd3.b bVar, hd3.b bVar2, Bundle bundle, Bundle bundle2, b0 b0Var, MediaSession.Token token) {
        this.a = i;
        this.b = i2;
        this.c = gVar;
        this.d = pendingIntent;
        this.k = xi1Var;
        this.l = xi1Var2;
        this.n = xi1Var3;
        this.e = d0Var;
        this.f = bVar;
        this.g = bVar2;
        this.h = bundle;
        this.i = bundle2;
        this.j = b0Var;
        this.m = token;
    }

    public static c h(Bundle bundle) {
        IBinder binder = bundle.getBinder(B);
        if (binder instanceof b) {
            return ((b) binder).a();
        }
        int i = bundle.getInt(o, 0);
        final int i2 = bundle.getInt(A, 0);
        IBinder iBinder = (IBinder) gg3.q(hm.a(bundle, p));
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable(q);
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(r);
        xi1 xi1VarD = parcelableArrayList != null ? fm.d(new p81() { // from class: z00
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return a.l((Bundle) obj, i2);
            }
        }, parcelableArrayList) : xi1.u();
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(s);
        xi1 xi1VarD2 = parcelableArrayList2 != null ? fm.d(new p81() { // from class: a10
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return a.l((Bundle) obj, i2);
            }
        }, parcelableArrayList2) : xi1.u();
        ArrayList parcelableArrayList3 = bundle.getParcelableArrayList(t);
        xi1 xi1VarD3 = parcelableArrayList3 != null ? fm.d(new p81() { // from class: b10
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return a.l((Bundle) obj, i2);
            }
        }, parcelableArrayList3) : xi1.u();
        Bundle bundle2 = bundle.getBundle(u);
        d0 d0VarD = bundle2 == null ? d0.b : d0.d(bundle2);
        Bundle bundle3 = bundle.getBundle(w);
        hd3.b bVarE = bundle3 == null ? hd3.b.b : hd3.b.e(bundle3);
        Bundle bundle4 = bundle.getBundle(v);
        hd3.b bVarE2 = bundle4 == null ? hd3.b.b : hd3.b.e(bundle4);
        Bundle bundleY = fy4.y(bundle.getBundle(x));
        Bundle bundleY2 = fy4.y(bundle.getBundle(y));
        Bundle bundle5 = bundle.getBundle(z);
        b0 b0VarD = bundle5 == null ? b0.H : b0.D(bundle5, i2);
        MediaSession.Token token = (MediaSession.Token) bundle.getParcelable(C);
        Bundle bundle6 = bundleY2;
        g gVarZ0 = g.a.Z0(iBinder);
        if (bundleY == null) {
            bundleY = Bundle.EMPTY;
        }
        Bundle bundle7 = bundleY;
        if (bundle6 == null) {
            bundle6 = Bundle.EMPTY;
        }
        return new c(i, i2, gVarZ0, pendingIntent, xi1VarD, xi1VarD2, xi1VarD3, d0VarD, bVarE2, bVarE, bundle7, bundle6, b0VarD, token);
    }

    public Bundle i(final int i) {
        Bundle bundle = new Bundle();
        bundle.putInt(o, this.a);
        hm.b(bundle, p, this.c.asBinder());
        bundle.putParcelable(q, this.d);
        if (!this.k.isEmpty()) {
            bundle.putParcelableArrayList(r, fm.h(this.k, new p81() { // from class: v00
                @Override // defpackage.p81
                public final Object apply(Object obj) {
                    return ((a) obj).z(i);
                }
            }));
        }
        if (!this.l.isEmpty()) {
            xi1 xi1Var = this.l;
            if (i >= 7) {
                bundle.putParcelableArrayList(s, fm.h(xi1Var, new p81() { // from class: w00
                    @Override // defpackage.p81
                    public final Object apply(Object obj) {
                        return ((a) obj).z(i);
                    }
                }));
            } else {
                bundle.putParcelableArrayList(r, fm.h(androidx.media3.session.a.m(xi1Var, true, true, 9), new p81() { // from class: x00
                    @Override // defpackage.p81
                    public final Object apply(Object obj) {
                        return ((a) obj).z(i);
                    }
                }));
            }
        }
        if (!this.n.isEmpty()) {
            bundle.putParcelableArrayList(t, fm.h(this.n, new p81() { // from class: y00
                @Override // defpackage.p81
                public final Object apply(Object obj) {
                    return ((a) obj).z(i);
                }
            }));
        }
        bundle.putBundle(u, this.e.e());
        bundle.putBundle(v, this.f.h());
        bundle.putBundle(w, this.g.h());
        bundle.putBundle(x, this.h);
        bundle.putBundle(y, this.i);
        bundle.putBundle(z, this.j.C(a0.f(this.f, this.g), false, false).G(i));
        bundle.putInt(A, this.b);
        MediaSession.Token token = this.m;
        if (token != null) {
            bundle.putParcelable(C, token);
        }
        return bundle;
    }

    public Bundle j() {
        Bundle bundle = new Bundle();
        bundle.putBinder(B, new b());
        return bundle;
    }
}
