package androidx.media3.session;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.text.TextUtils;
import androidx.media3.session.MediaLibraryService;
import androidx.media3.session.j;
import androidx.media3.session.u;
import defpackage.fg2;
import defpackage.fy4;
import defpackage.gb;
import defpackage.gg3;
import defpackage.hd3;
import defpackage.jk;
import defpackage.lu1;
import defpackage.x81;
import defpackage.xi1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class MediaLibraryService extends x {
    public static final String SERVICE_INTERFACE = "androidx.media3.session.MediaLibraryService";

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public static final String e = fy4.N0(0);
        public static final String f = fy4.N0(1);
        public static final String g = fy4.N0(2);
        public static final String h = fy4.N0(3);
        public final Bundle a;
        public final boolean b;
        public final boolean c;
        public final boolean d;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a {
            public boolean a;
            public boolean b;
            public boolean c;
            public Bundle d = Bundle.EMPTY;

            public b a() {
                return new b(this.d, this.a, this.b, this.c);
            }

            public a b(Bundle bundle) {
                this.d = (Bundle) gg3.q(bundle);
                return this;
            }

            public a c(boolean z) {
                this.b = z;
                return this;
            }

            public a d(boolean z) {
                this.a = z;
                return this;
            }

            public a e(boolean z) {
                this.c = z;
                return this;
            }
        }

        public b(Bundle bundle, boolean z, boolean z2, boolean z3) {
            this.a = new Bundle(bundle);
            this.b = z;
            this.c = z2;
            this.d = z3;
        }

        public static b a(Bundle bundle) {
            Bundle bundleY = fy4.y(bundle.getBundle(e));
            boolean z = bundle.getBoolean(f, false);
            boolean z2 = bundle.getBoolean(g, false);
            boolean z3 = bundle.getBoolean(h, false);
            if (bundleY == null) {
                bundleY = Bundle.EMPTY;
            }
            return new b(bundleY, z, z2, z3);
        }

        public Bundle b() {
            Bundle bundle = new Bundle();
            bundle.putBundle(e, this.a);
            bundle.putBoolean(f, this.b);
            bundle.putBoolean(g, this.c);
            bundle.putBoolean(h, this.d);
            return bundle;
        }
    }

    @Override // androidx.media3.session.x, defpackage.ft1, android.app.Service
    public IBinder onBind(Intent intent) {
        if (intent == null) {
            return null;
        }
        return SERVICE_INTERFACE.equals(intent.getAction()) ? getServiceBinder() : super.onBind(intent);
    }

    @Override // androidx.media3.session.x
    public abstract c onGetSession(u.g gVar);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends u {

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public interface b extends u.d {
            static /* synthetic */ lu1 a(u.g gVar, c cVar, String str, b bVar, j jVar) {
                Object obj;
                Boolean bool;
                if (jVar.a == 0 && (obj = jVar.c) != null && (bool = ((fg2) obj).e.r) != null && bool.booleanValue()) {
                    if (gVar.d() != 0) {
                        cVar.z(gVar, str, Integer.MAX_VALUE, bVar);
                    }
                    return x81.e(j.j());
                }
                int i = jVar.a;
                if (i == 0) {
                    i = -3;
                }
                return x81.e(j.e(i));
            }

            lu1 onGetChildren(c cVar, u.g gVar, String str, int i, int i2, b bVar);

            lu1 onGetItem(c cVar, u.g gVar, String str);

            lu1 onGetLibraryRoot(c cVar, u.g gVar, b bVar);

            lu1 onGetSearchResult(c cVar, u.g gVar, String str, int i, int i2, b bVar);

            lu1 onSearch(c cVar, u.g gVar, String str, b bVar);

            default lu1 onSubscribe(final c cVar, final u.g gVar, final String str, final b bVar) {
                return fy4.Q1(onGetItem(cVar, gVar, str), new gb() { // from class: lg2
                    @Override // defpackage.gb
                    public final lu1 apply(Object obj) {
                        return MediaLibraryService.c.b.a(gVar, cVar, str, bVar, (j) obj);
                    }
                });
            }

            default lu1 onUnsubscribe(c cVar, u.g gVar, String str) {
                return x81.e(j.j());
            }
        }

        public c(Context context, String str, hd3 hd3Var, PendingIntent pendingIntent, xi1 xi1Var, xi1 xi1Var2, xi1 xi1Var3, u.d dVar, Bundle bundle, Bundle bundle2, jk jkVar, boolean z, boolean z2, int i) {
            super(context, str, hd3Var, pendingIntent, xi1Var, xi1Var2, xi1Var3, dVar, bundle, bundle2, jkVar, z, z2, i, false);
        }

        public void A(String str, int i, b bVar) {
            gg3.d(!TextUtils.isEmpty(str));
            gg3.d(i >= 0);
            h().E1(str, i, bVar);
        }

        public void B(u.g gVar, String str, int i, b bVar) {
            gg3.d(!TextUtils.isEmpty(str));
            gg3.d(i >= 0);
            h().F1((u.g) gg3.q(gVar), str, i, bVar);
        }

        @Override // androidx.media3.session.u
        /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
        public r b(Context context, String str, hd3 hd3Var, PendingIntent pendingIntent, xi1 xi1Var, xi1 xi1Var2, xi1 xi1Var3, u.d dVar, Bundle bundle, Bundle bundle2, jk jkVar, boolean z, boolean z2, int i, boolean z3) {
            return new r(this, context, str, hd3Var, pendingIntent, xi1Var, xi1Var2, xi1Var3, (b) dVar, bundle, bundle2, jkVar, z, z2, i);
        }

        @Override // androidx.media3.session.u
        /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
        public r h() {
            return (r) super.h();
        }

        public void z(u.g gVar, String str, int i, b bVar) {
            gg3.d(i >= 0);
            gg3.d(true ^ TextUtils.isEmpty(str));
            h().D1((u.g) gg3.q(gVar), str, i, bVar);
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a extends u.c {
            public int o;
            public boolean p;

            public a(Context context, hd3 hd3Var, b bVar) {
                super(context, hd3Var, bVar);
                this.o = 2;
            }

            public c c() {
                gg3.v(!this.p);
                this.p = true;
                a();
                return new c(this.a, this.c, this.b, this.e, this.j, this.k, this.l, this.d, this.f, this.g, this.h, this.i, this.m, this.o);
            }

            public a(MediaLibraryService mediaLibraryService, hd3 hd3Var, b bVar) {
                this((Context) mediaLibraryService, hd3Var, bVar);
            }
        }
    }
}
