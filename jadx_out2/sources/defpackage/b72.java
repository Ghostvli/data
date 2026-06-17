package defpackage;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.text.TextUtils;
import defpackage.fm2;
import defpackage.pi2;
import defpackage.z62;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b72 extends Service {
    public g f;
    public f k;
    public pi2.h m;
    public final m g = new m();
    public final f h = new f("android.media.session.MediaController", -1, -1, null, null);
    public final ArrayList i = new ArrayList();
    public final la j = new la();
    public final p l = new p(this);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends k {
        public final /* synthetic */ f f;
        public final /* synthetic */ String g;
        public final /* synthetic */ Bundle h;
        public final /* synthetic */ Bundle i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Object obj, f fVar, String str, Bundle bundle, Bundle bundle2) {
            super(obj);
            this.f = fVar;
            this.g = str;
            this.h = bundle;
            this.i = bundle2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: e(Ljava/lang/Object;)V */
        @Override // b72.k
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void e(List list) {
            if (b72.this.j.get(((n) gg3.q(this.f.f)).asBinder()) != this.f) {
                xz1.b("MBServiceCompat", "Not sending onLoadChildren result for connection that has been disconnected. pkg=" + this.f.a + " id=" + this.g);
                return;
            }
            if ((b() & 1) != 0) {
                list = b72.this.b(list, this.h);
            }
            try {
                this.f.f.a(this.g, list, this.h, this.i);
            } catch (RemoteException unused) {
                xz1.i("MBServiceCompat", "Calling onLoadChildren() failed for id=" + this.g + " package=" + this.f.a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends k {
        public final /* synthetic */ mt3 f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Object obj, mt3 mt3Var) {
            super(obj);
            this.f = mt3Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: e(Ljava/lang/Object;)V */
        @Override // b72.k
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void e(z62.g gVar) {
            if ((b() & 2) != 0) {
                this.f.d(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelable("media_item", ps1.a(gVar, MediaBrowserCompat$MediaItem.CREATOR));
            this.f.d(0, bundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends k {
        public final /* synthetic */ mt3 f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Object obj, mt3 mt3Var) {
            super(obj);
            this.f = mt3Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: e(Ljava/lang/Object;)V */
        @Override // b72.k
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void e(List list) {
            if ((b() & 4) != 0 || list == null) {
                this.f.d(-1, null);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putParcelableArray("search_results", (Parcelable[]) ps1.b(list, MediaBrowserCompat$MediaItem.CREATOR).toArray(new MediaBrowserCompat$MediaItem[0]));
            this.f.d(0, bundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d extends k {
        public final /* synthetic */ mt3 f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Object obj, mt3 mt3Var) {
            super(obj);
            this.f = mt3Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // b72.k
        public void d(Bundle bundle) {
            this.f.d(-1, bundle);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: e(Ljava/lang/Object;)V */
        @Override // b72.k
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public void e(Bundle bundle) {
            this.f.d(0, bundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e {
        public final String a;
        public final Bundle b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(String str, Bundle bundle) {
            if (str == null) {
                jl.a("The root id in BrowserRoot cannot be null. Use null for BrowserRoot instead");
                throw null;
            }
            this.a = str;
            this.b = bundle;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Bundle c() {
            return this.b;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String d() {
            return this.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class f implements IBinder.DeathRecipient {
        public final String a;
        public final int b;
        public final int c;
        public final fm2.b d;
        public final Bundle e;
        public final n f;
        public final HashMap g = new HashMap();

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Runnable {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a() {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public void run() {
                f fVar = f.this;
                b72.this.j.remove(((n) gg3.q(fVar.f)).asBinder());
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f(String str, int i, int i2, Bundle bundle, n nVar) {
            this.a = str;
            this.b = i;
            this.c = i2;
            this.d = new fm2.b(str, i, i2);
            this.e = bundle;
            this.f = nVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            b72.this.l.post(new a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface g {
        void a();

        void b(fm2.b bVar, String str, Bundle bundle);

        void c(pi2.h hVar);

        fm2.b d();

        IBinder e(Intent intent);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class h implements g {
        public final List a = new ArrayList();
        public MediaBrowserService b;
        public Messenger c;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Runnable {
            public final /* synthetic */ pi2.h f;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a(pi2.h hVar) {
                this.f = hVar;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public void run() {
                h.this.k(this.f);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class b extends k {
            public final /* synthetic */ l f;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Object obj, l lVar) {
                super(obj);
                this.f = lVar;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // b72.k
            public void a() {
                this.f.a();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: e(Ljava/lang/Object;)V */
            @Override // b72.k
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public void e(List list) {
                ArrayList arrayList;
                if (list == null) {
                    arrayList = null;
                } else {
                    ArrayList arrayList2 = new ArrayList(list.size());
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        z62.g gVar = (z62.g) it.next();
                        Parcel parcelObtain = Parcel.obtain();
                        gVar.writeToParcel(parcelObtain, 0);
                        arrayList2.add(parcelObtain);
                    }
                    arrayList = arrayList2;
                }
                this.f.c(arrayList);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class c implements Runnable {
            public final /* synthetic */ fm2.b f;
            public final /* synthetic */ String g;
            public final /* synthetic */ Bundle h;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public c(fm2.b bVar, String str, Bundle bundle) {
                this.f = bVar;
                this.g = str;
                this.h = bundle;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public void run() {
                for (int i = 0; i < b72.this.j.size(); i++) {
                    f fVar = (f) b72.this.j.j(i);
                    if (fVar.d.equals(this.f)) {
                        h.this.g(fVar, this.g, this.h);
                    }
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class d extends k {
            public final /* synthetic */ l f;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public d(Object obj, l lVar) {
                super(obj);
                this.f = lVar;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // b72.k
            public void a() {
                this.f.a();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: e(Ljava/lang/Object;)V */
            @Override // b72.k
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public void e(z62.g gVar) {
                if (gVar == null) {
                    this.f.c(null);
                    return;
                }
                Parcel parcelObtain = Parcel.obtain();
                gVar.writeToParcel(parcelObtain, 0);
                this.f.c(parcelObtain);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class e extends MediaBrowserService {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public e(Context context) {
                attachBaseContext(context);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.service.media.MediaBrowserService
            public MediaBrowserService.BrowserRoot onGetRoot(String str, int i, Bundle bundle) {
                Bundle bundleY = fy4.y(bundle);
                e eVarH = h.this.h(str, i, bundleY == null ? null : new Bundle(bundleY));
                if (eVarH == null) {
                    return null;
                }
                return new MediaBrowserService.BrowserRoot(eVarH.a, eVarH.b);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.service.media.MediaBrowserService
            public void onLoadChildren(String str, MediaBrowserService.Result result) {
                h.this.i(str, new l(result));
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.service.media.MediaBrowserService
            public void onLoadItem(String str, MediaBrowserService.Result result) {
                h.this.j(str, new l(result));
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public h() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // b72.g
        public void a() {
            e eVar = new e(b72.this);
            this.b = eVar;
            eVar.onCreate();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // b72.g
        public void b(fm2.b bVar, String str, Bundle bundle) {
            f(bVar, str, bundle);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // b72.g
        public void c(pi2.h hVar) {
            b72.this.l.a(new a(hVar));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // b72.g
        public fm2.b d() {
            f fVar = b72.this.k;
            if (fVar != null) {
                return fVar.d;
            }
            e04.a("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // b72.g
        public IBinder e(Intent intent) {
            return ((MediaBrowserService) gg3.q(this.b)).onBind(intent);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void f(fm2.b bVar, String str, Bundle bundle) {
            b72.this.l.post(new c(bVar, str, bundle));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void g(f fVar, String str, Bundle bundle) {
            List<k73> list = (List) fVar.g.get(str);
            if (list != null) {
                for (k73 k73Var : list) {
                    if (a72.b(bundle, (Bundle) k73Var.b)) {
                        b72.this.p(str, fVar, (Bundle) k73Var.b, bundle);
                    }
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e h(String str, int i, Bundle bundle) {
            Bundle bundle2;
            int i2 = -1;
            if (bundle == null || bundle.getInt("extra_client_version", 0) == 0) {
                bundle2 = null;
            } else {
                bundle.remove("extra_client_version");
                this.c = new Messenger(b72.this.l);
                bundle2 = new Bundle();
                bundle2.putInt("extra_service_version", 2);
                bundle2.putBinder("extra_messenger", this.c.getBinder());
                pi2.h hVar = b72.this.m;
                if (hVar != null) {
                    lh1 lh1VarS = hVar.s();
                    bundle2.putBinder("extra_session_binder", lh1VarS == null ? null : lh1VarS.asBinder());
                } else {
                    this.a.add(bundle2);
                }
                i2 = bundle.getInt("extra_calling_pid", -1);
                bundle.remove("extra_calling_pid");
            }
            f fVar = b72.this.new f(str, i2, i, bundle, null);
            b72 b72Var = b72.this;
            b72Var.k = fVar;
            e eVarH = b72Var.h(str, i, bundle);
            b72 b72Var2 = b72.this;
            b72Var2.k = null;
            if (eVarH == null) {
                return null;
            }
            if (this.c != null) {
                b72Var2.i.add(fVar);
            }
            Bundle bundleC = eVarH.c();
            if (bundle2 == null) {
                bundle2 = bundleC;
            } else if (bundleC != null) {
                bundle2.putAll(bundleC);
            }
            return new e(eVarH.d(), bundle2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void i(String str, l lVar) {
            b bVar = new b(str, lVar);
            b72 b72Var = b72.this;
            b72Var.k = b72Var.h;
            b72Var.i(str, bVar);
            b72.this.k = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void j(String str, l lVar) {
            d dVar = new d(str, lVar);
            b72 b72Var = b72.this;
            b72Var.k = b72Var.h;
            b72Var.k(str, dVar);
            b72.this.k = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void k(pi2.h hVar) {
            if (!this.a.isEmpty()) {
                lh1 lh1VarS = hVar.s();
                if (lh1VarS != null) {
                    Iterator it = this.a.iterator();
                    while (it.hasNext()) {
                        ((Bundle) it.next()).putBinder("extra_session_binder", lh1VarS.asBinder());
                    }
                }
                this.a.clear();
            }
            ((MediaBrowserService) gg3.q(this.b)).setSessionToken(hVar.v());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class i extends h {

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a extends k {
            public final /* synthetic */ l f;
            public final /* synthetic */ Bundle g;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(Object obj, l lVar, Bundle bundle) {
                super(obj);
                this.f = lVar;
                this.g = bundle;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // b72.k
            public void a() {
                this.f.a();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: e(Ljava/lang/Object;)V */
            @Override // b72.k
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public void e(List list) {
                if (list == null) {
                    this.f.c(null);
                    return;
                }
                if ((b() & 1) != 0) {
                    list = b72.this.b(list, this.g);
                }
                ArrayList arrayList = new ArrayList(list == null ? 0 : list.size());
                if (list != null) {
                    for (z62.g gVar : list) {
                        Parcel parcelObtain = Parcel.obtain();
                        gVar.writeToParcel(parcelObtain, 0);
                        arrayList.add(parcelObtain);
                    }
                }
                this.f.c(arrayList);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class b extends h.e {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public b(Context context) {
                super(context);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.service.media.MediaBrowserService
            public void onLoadChildren(String str, MediaBrowserService.Result result, Bundle bundle) {
                Bundle bundleY = fy4.y(bundle);
                i iVar = i.this;
                b72 b72Var = b72.this;
                b72Var.k = b72Var.h;
                iVar.l(str, new l(result), bundleY);
                b72.this.k = null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public i() {
            super();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // b72.h, b72.g
        public void a() {
            b bVar = new b(b72.this);
            this.b = bVar;
            bVar.onCreate();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void l(String str, l lVar, Bundle bundle) {
            a aVar = new a(str, lVar, bundle);
            b72 b72Var = b72.this;
            b72Var.k = b72Var.h;
            b72Var.j(str, aVar, bundle);
            b72.this.k = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class j extends i {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public j() {
            super();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // b72.h, b72.g
        public fm2.b d() {
            b72 b72Var = b72.this;
            f fVar = b72Var.k;
            if (fVar != null) {
                return fVar == b72Var.h ? new fm2.b(((MediaBrowserService) gg3.q(this.b)).getCurrentBrowserInfo()) : fVar.d;
            }
            e04.a("This should be called inside of onGetRoot, onLoadChildren, onLoadItem, onSearch, or onCustomAction methods");
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class k {
        public final Object a;
        public boolean b;
        public boolean c;
        public boolean d;
        public int e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public k(Object obj) {
            this.a = obj;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a() {
            if (this.b) {
                defpackage.d.a("detach() called when detach() had already been called for: ", this.a);
                return;
            }
            if (this.c) {
                defpackage.d.a("detach() called when sendResult() had already been called for: ", this.a);
            } else if (this.d) {
                defpackage.d.a("detach() called when sendError() had already been called for: ", this.a);
            } else {
                this.b = true;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int b() {
            return this.e;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean c() {
            return this.b || this.c || this.d;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d(Bundle bundle) {
            throw new UnsupportedOperationException("It is not supported to send an error for " + this.a);
        }

        public abstract void e(Object obj);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void f(Bundle bundle) {
            if (this.c || this.d) {
                defpackage.d.a("sendError() called when either sendResult() or sendError() had already been called for: ", this.a);
            } else {
                this.d = true;
                d(bundle);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void g(Object obj) {
            if (this.c || this.d) {
                defpackage.d.a("sendResult() called when either sendResult() or sendError() had already been called for: ", this.a);
            } else {
                this.c = true;
                e(obj);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class l {
        public MediaBrowserService.Result a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public l(MediaBrowserService.Result result) {
            this.a = result;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a() {
            this.a.detach();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public List b(List list) {
            if (list == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList(list.size());
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Parcel parcel = (Parcel) it.next();
                parcel.setDataPosition(0);
                arrayList.add((MediaBrowser.MediaItem) MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
                parcel.recycle();
            }
            return arrayList;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c(Object obj) {
            if (obj instanceof List) {
                this.a.sendResult(b((List) obj));
                return;
            }
            if (!(obj instanceof Parcel)) {
                this.a.sendResult(null);
                return;
            }
            Parcel parcel = (Parcel) obj;
            parcel.setDataPosition(0);
            this.a.sendResult(MediaBrowser.MediaItem.CREATOR.createFromParcel(parcel));
            parcel.recycle();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class m {

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Runnable {
            public final /* synthetic */ n f;
            public final /* synthetic */ String g;
            public final /* synthetic */ IBinder h;
            public final /* synthetic */ Bundle i;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a(n nVar, String str, IBinder iBinder, Bundle bundle) {
                this.f = nVar;
                this.g = str;
                this.h = iBinder;
                this.i = bundle;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) b72.this.j.get(this.f.asBinder());
                if (fVar != null) {
                    b72.this.a(this.g, fVar, this.h, this.i);
                    return;
                }
                xz1.i("MBServiceCompat", "addSubscription for callback that isn't registered id=" + this.g);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class b implements Runnable {
            public final /* synthetic */ n f;
            public final /* synthetic */ String g;
            public final /* synthetic */ IBinder h;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public b(n nVar, String str, IBinder iBinder) {
                this.f = nVar;
                this.g = str;
                this.h = iBinder;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) b72.this.j.get(this.f.asBinder());
                if (fVar == null) {
                    xz1.i("MBServiceCompat", "removeSubscription for callback that isn't registered id=" + this.g);
                } else {
                    if (b72.this.s(this.g, fVar, this.h)) {
                        return;
                    }
                    xz1.i("MBServiceCompat", "removeSubscription called for " + this.g + " which is not subscribed");
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class c implements Runnable {
            public final /* synthetic */ n f;
            public final /* synthetic */ String g;
            public final /* synthetic */ mt3 h;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public c(n nVar, String str, mt3 mt3Var) {
                this.f = nVar;
                this.g = str;
                this.h = mt3Var;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) b72.this.j.get(this.f.asBinder());
                if (fVar != null) {
                    b72.this.q(this.g, fVar, this.h);
                    return;
                }
                xz1.i("MBServiceCompat", "getMediaItem for callback that isn't registered id=" + this.g);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class d implements Runnable {
            public final /* synthetic */ n f;
            public final /* synthetic */ int g;
            public final /* synthetic */ String h;
            public final /* synthetic */ int i;
            public final /* synthetic */ Bundle j;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public d(n nVar, int i, String str, int i2, Bundle bundle) {
                this.f = nVar;
                this.g = i;
                this.h = str;
                this.i = i2;
                this.j = bundle;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public void run() {
                f fVar;
                IBinder iBinderAsBinder = this.f.asBinder();
                b72.this.j.remove(iBinderAsBinder);
                Iterator it = b72.this.i.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    f fVar2 = (f) it.next();
                    if (fVar2.c == this.g) {
                        fVar = (TextUtils.isEmpty(this.h) || this.i <= 0) ? b72.this.new f(fVar2.a, fVar2.b, fVar2.c, this.j, this.f) : null;
                        it.remove();
                    }
                }
                if (fVar == null) {
                    fVar = b72.this.new f(this.h, this.i, this.g, this.j, this.f);
                }
                b72.this.j.put(iBinderAsBinder, fVar);
                try {
                    iBinderAsBinder.linkToDeath(fVar, 0);
                } catch (RemoteException unused) {
                    xz1.i("MBServiceCompat", "IBinder is already dead.");
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class e implements Runnable {
            public final /* synthetic */ n f;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public e(n nVar) {
                this.f = nVar;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public void run() {
                IBinder iBinderAsBinder = this.f.asBinder();
                f fVar = (f) b72.this.j.remove(iBinderAsBinder);
                if (fVar != null) {
                    iBinderAsBinder.unlinkToDeath(fVar, 0);
                }
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class f implements Runnable {
            public final /* synthetic */ n f;
            public final /* synthetic */ String g;
            public final /* synthetic */ Bundle h;
            public final /* synthetic */ mt3 i;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public f(n nVar, String str, Bundle bundle, mt3 mt3Var) {
                this.f = nVar;
                this.g = str;
                this.h = bundle;
                this.i = mt3Var;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) b72.this.j.get(this.f.asBinder());
                if (fVar != null) {
                    b72.this.r(this.g, this.h, fVar, this.i);
                    return;
                }
                xz1.i("MBServiceCompat", "search for callback that isn't registered query=" + this.g);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class g implements Runnable {
            public final /* synthetic */ n f;
            public final /* synthetic */ String g;
            public final /* synthetic */ Bundle h;
            public final /* synthetic */ mt3 i;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public g(n nVar, String str, Bundle bundle, mt3 mt3Var) {
                this.f = nVar;
                this.g = str;
                this.h = bundle;
                this.i = mt3Var;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public void run() {
                f fVar = (f) b72.this.j.get(this.f.asBinder());
                if (fVar != null) {
                    b72.this.o(this.g, this.h, fVar, this.i);
                    return;
                }
                xz1.i("MBServiceCompat", "sendCustomAction for callback that isn't registered action=" + this.g + ", extras=" + this.h);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public m() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a(String str, IBinder iBinder, Bundle bundle, n nVar) {
            b72.this.l.a(new a(nVar, str, iBinder, bundle));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b(String str, mt3 mt3Var, n nVar) {
            if (TextUtils.isEmpty(str) || mt3Var == null) {
                return;
            }
            b72.this.l.a(new c(nVar, str, mt3Var));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c(n nVar, String str, int i, int i2, Bundle bundle) {
            b72.this.l.a(new d(nVar, i2, str, i, bundle));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d(String str, IBinder iBinder, n nVar) {
            b72.this.l.a(new b(nVar, str, iBinder));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void e(String str, Bundle bundle, mt3 mt3Var, n nVar) {
            if (TextUtils.isEmpty(str) || mt3Var == null) {
                return;
            }
            b72.this.l.a(new f(nVar, str, bundle, mt3Var));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void f(String str, Bundle bundle, mt3 mt3Var, n nVar) {
            if (TextUtils.isEmpty(str) || mt3Var == null) {
                return;
            }
            b72.this.l.a(new g(nVar, str, bundle, mt3Var));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void g(n nVar) {
            b72.this.l.a(new e(nVar));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface n {
        void a(String str, List list, Bundle bundle, Bundle bundle2);

        IBinder asBinder();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class o implements n {
        public final Messenger a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public o(Messenger messenger) {
            this.a = messenger;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // b72.n
        public void a(String str, List list, Bundle bundle, Bundle bundle2) throws RemoteException {
            Bundle bundle3 = new Bundle();
            bundle3.putString("data_media_item_id", str);
            bundle3.putBundle("data_options", bundle);
            bundle3.putBundle("data_notify_children_changed_options", bundle2);
            if (list != null) {
                bundle3.putParcelableArrayList("data_media_item_list", ps1.b(list, MediaBrowserCompat$MediaItem.CREATOR));
            }
            b(3, bundle3);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // b72.n
        public IBinder asBinder() {
            return this.a.getBinder();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void b(int i, Bundle bundle) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = i;
            messageObtain.arg1 = 2;
            if (bundle != null) {
                messageObtain.setData(bundle);
            }
            this.a.send(messageObtain);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class p extends Handler {
        public b72 a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public p(b72 b72Var) {
            super((Looper) gg3.q(Looper.myLooper()));
            this.a = b72Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a(Runnable runnable) {
            if (Thread.currentThread() == getLooper().getThread()) {
                runnable.run();
            } else {
                post(runnable);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b() {
            this.a = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            b72 b72Var = this.a;
            if (b72Var != null) {
                b72Var.e(message);
            } else {
                removeCallbacksAndMessages(null);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.os.Handler
        public boolean sendMessageAtTime(Message message, long j) {
            Bundle data = message.getData();
            data.setClassLoader((ClassLoader) gg3.q(z62.class.getClassLoader()));
            data.putInt("data_calling_uid", Binder.getCallingUid());
            int callingPid = Binder.getCallingPid();
            if (callingPid > 0) {
                data.putInt("data_calling_pid", callingPid);
            } else if (!data.containsKey("data_calling_pid")) {
                data.putInt("data_calling_pid", -1);
            }
            return super.sendMessageAtTime(message, j);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a(String str, f fVar, IBinder iBinder, Bundle bundle) {
        List<k73> arrayList = (List) fVar.g.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        for (k73 k73Var : arrayList) {
            if (iBinder == k73Var.a && a72.a(bundle, (Bundle) k73Var.b)) {
                return;
            }
        }
        arrayList.add(new k73(iBinder, bundle));
        fVar.g.put(str, arrayList);
        p(str, fVar, bundle, null);
        this.k = fVar;
        m(str, bundle);
        this.k = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List b(List list, Bundle bundle) {
        if (list == null) {
            return null;
        }
        if (bundle != null) {
            int i2 = bundle.getInt("android.media.browse.extra.PAGE", -1);
            int i3 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
            if (i2 != -1 || i3 != -1) {
                int i4 = i3 * i2;
                int size = i4 + i3;
                if (i2 < 0 || i3 < 1 || i4 >= list.size()) {
                    return Collections.EMPTY_LIST;
                }
                if (size > list.size()) {
                    size = list.size();
                }
                return list.subList(i4, size);
            }
        }
        return list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c(Context context) {
        attachBaseContext(context);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final fm2.b d() {
        return ((g) gg3.q(this.f)).d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Service
    public void dump(FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e(Message message) {
        Bundle data = message.getData();
        switch (message.what) {
            case 3:
                this.g.a(data.getString("data_media_item_id"), data.getBinder("data_callback_token"), fy4.y(data.getBundle("data_options")), new o(message.replyTo));
                break;
            case 4:
                this.g.d(data.getString("data_media_item_id"), data.getBinder("data_callback_token"), new o(message.replyTo));
                break;
            case 5:
                this.g.b(data.getString("data_media_item_id"), (mt3) data.getParcelable("data_result_receiver"), new o(message.replyTo));
                break;
            case 6:
                this.g.c(new o(message.replyTo), data.getString("data_package_name"), data.getInt("data_calling_pid"), data.getInt("data_calling_uid"), fy4.y(data.getBundle("data_root_hints")));
                break;
            case 7:
                this.g.g(new o(message.replyTo));
                break;
            case 8:
                this.g.e(data.getString("data_search_query"), fy4.y(data.getBundle("data_search_extras")), (mt3) data.getParcelable("data_result_receiver"), new o(message.replyTo));
                break;
            case 9:
                this.g.f(data.getString("data_custom_action"), fy4.y(data.getBundle("data_custom_action_extras")), (mt3) data.getParcelable("data_result_receiver"), new o(message.replyTo));
                break;
            default:
                xz1.i("MBServiceCompat", "Unhandled message: " + message + "\n  Service version: 2\n  Client version: " + message.arg1);
                break;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f(fm2.b bVar, String str, Bundle bundle) {
        if (bVar == null) {
            jl.a("remoteUserInfo cannot be null in notifyChildrenChanged");
            return;
        }
        if (str == null) {
            jl.a("parentId cannot be null in notifyChildrenChanged");
        } else if (bundle != null) {
            ((g) gg3.q(this.f)).b(bVar, str, bundle);
        } else {
            jl.a("options cannot be null in notifyChildrenChanged");
        }
    }

    public abstract void g(String str, Bundle bundle, k kVar);

    public abstract e h(String str, int i2, Bundle bundle);

    public abstract void i(String str, k kVar);

    public abstract void j(String str, k kVar, Bundle bundle);

    public abstract void k(String str, k kVar);

    public abstract void l(String str, Bundle bundle, k kVar);

    public abstract void m(String str, Bundle bundle);

    public abstract void n(String str);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void o(String str, Bundle bundle, f fVar, mt3 mt3Var) {
        d dVar = new d(str, mt3Var);
        this.k = fVar;
        g(str, bundle == null ? Bundle.EMPTY : bundle, dVar);
        this.k = null;
        if (dVar.c()) {
            return;
        }
        throw new IllegalStateException("onCustomAction must call detach() or sendResult() or sendError() before returning for action=" + str + " extras=" + bundle);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return ((g) gg3.q(this.f)).e(intent);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 28) {
            this.f = new j();
        } else if (i2 >= 26) {
            this.f = new i();
        } else {
            this.f = new h();
        }
        this.f.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.app.Service
    public void onDestroy() {
        this.l.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void p(String str, f fVar, Bundle bundle, Bundle bundle2) {
        a aVar = new a(str, fVar, str, bundle, bundle2);
        this.k = fVar;
        if (bundle == null) {
            i(str, aVar);
        } else {
            j(str, aVar, bundle);
        }
        this.k = null;
        if (aVar.c()) {
            return;
        }
        vh.a("onLoadChildren must call detach() or sendResult() before returning for package=", fVar.a, " id=", str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void q(String str, f fVar, mt3 mt3Var) {
        b bVar = new b(str, mt3Var);
        this.k = fVar;
        k(str, bVar);
        this.k = null;
        if (bVar.c()) {
            return;
        }
        ho1.a("onLoadItem must call detach() or sendResult() before returning for id=", str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void r(String str, Bundle bundle, f fVar, mt3 mt3Var) {
        c cVar = new c(str, mt3Var);
        this.k = fVar;
        l(str, bundle, cVar);
        this.k = null;
        if (cVar.c()) {
            return;
        }
        ho1.a("onSearch must call detach() or sendResult() before returning for query=", str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean s(String str, f fVar, IBinder iBinder) {
        boolean z = false;
        try {
            if (iBinder != null) {
                List list = (List) fVar.g.get(str);
                if (list != null) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        if (iBinder == ((k73) it.next()).a) {
                            it.remove();
                            z = true;
                        }
                    }
                    if (list.isEmpty()) {
                        fVar.g.remove(str);
                    }
                }
            } else if (fVar.g.remove(str) != null) {
                z = true;
            }
            return z;
        } finally {
            this.k = fVar;
            n(str);
            this.k = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void t(pi2.h hVar) {
        if (hVar == null) {
            jl.a("Session token may not be null");
        } else if (this.m != null) {
            e04.a("The session token has already been set");
        } else {
            this.m = hVar;
            ((g) gg3.q(this.f)).c(hVar);
        }
    }
}
