package defpackage;

import android.content.ComponentName;
import android.content.Context;
import android.media.browse.MediaBrowser;
import android.os.BadParcelableException;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import defpackage.lh1;
import defpackage.pi2;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class z62 {
    public final c a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends Handler {
        public final WeakReference a;
        public WeakReference b;

        public a(f fVar) {
            this.a = new WeakReference(fVar);
        }

        public void a(Messenger messenger) {
            this.b = new WeakReference(messenger);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            WeakReference weakReference = this.b;
            if (weakReference == null) {
                return;
            }
            Messenger messenger = (Messenger) weakReference.get();
            f fVar = (f) this.a.get();
            if (messenger == null || fVar == null) {
                return;
            }
            Bundle data = message.getData();
            pi2.a(data);
            try {
                if (message.what == 3) {
                    fVar.c(messenger, data.getString("data_media_item_id"), ps1.b(data.getParcelableArrayList("data_media_item_list"), g.CREATOR), fy4.y(data.getBundle("data_options")), fy4.y(data.getBundle("data_notify_children_changed_options")));
                } else {
                    xz1.i("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                }
            } catch (BadParcelableException unused) {
                xz1.d("MediaBrowserCompat", "Could not unparcel the data.");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public final MediaBrowser.ConnectionCallback a = new a();
        public InterfaceC0139b b;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a extends MediaBrowser.ConnectionCallback {
            public a() {
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnected() {
                InterfaceC0139b interfaceC0139b = b.this.b;
                if (interfaceC0139b != null) {
                    interfaceC0139b.e();
                }
                b.this.a();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionFailed() {
                InterfaceC0139b interfaceC0139b = b.this.b;
                if (interfaceC0139b != null) {
                    interfaceC0139b.f();
                }
                b.this.b();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionSuspended() {
                InterfaceC0139b interfaceC0139b = b.this.b;
                if (interfaceC0139b != null) {
                    interfaceC0139b.d();
                }
                b.this.c();
            }
        }

        /* JADX INFO: renamed from: z62$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public interface InterfaceC0139b {
            void d();

            void e();

            void f();
        }

        public abstract void a();

        public abstract void b();

        public abstract void c();

        public void d(InterfaceC0139b interfaceC0139b) {
            this.b = interfaceC0139b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface c {
        pi2.h a();

        void b();

        void disconnect();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d implements c, f, b.InterfaceC0139b {
        public final Context a;
        public final MediaBrowser b;
        public final Bundle c;
        public final a d = new a(this);
        public final la e = new la();
        public int f;
        public h g;
        public Messenger h;
        public pi2.h i;

        public d(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            this.a = context;
            Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
            this.c = bundle2;
            bundle2.putInt("extra_client_version", 1);
            bundle2.putInt("extra_calling_pid", Process.myPid());
            bVar.d(this);
            this.b = new MediaBrowser(context, componentName, (MediaBrowser.ConnectionCallback) gg3.q(bVar.a), bundle2);
        }

        @Override // z62.c
        public pi2.h a() {
            if (this.i == null) {
                this.i = pi2.h.c(this.b.getSessionToken());
            }
            return this.i;
        }

        @Override // z62.c
        public void b() {
            this.b.connect();
        }

        @Override // z62.f
        public void c(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2) {
            if (this.h != messenger) {
                return;
            }
            if (str != null) {
                w82.a(this.e.get(str));
            }
            xz1.b("MediaBrowserCompat", "onLoadChildren for id that isn't subscribed id=" + str);
        }

        @Override // z62.b.InterfaceC0139b
        public void d() {
            this.g = null;
            this.h = null;
            this.i = null;
            this.d.a(null);
        }

        @Override // z62.c
        public void disconnect() {
            Messenger messenger;
            h hVar = this.g;
            if (hVar != null && (messenger = this.h) != null) {
                try {
                    hVar.c(messenger);
                } catch (RemoteException unused) {
                    xz1.g("MediaBrowserCompat", "Remote error unregistering client messenger.");
                }
            }
            this.b.disconnect();
        }

        @Override // z62.b.InterfaceC0139b
        public void e() {
            try {
                Bundle bundleY = fy4.y(this.b.getExtras());
                if (bundleY == null) {
                    return;
                }
                this.f = bundleY.getInt("extra_service_version", 0);
                IBinder binder = bundleY.getBinder("extra_messenger");
                if (binder != null) {
                    h hVar = new h(binder, this.c);
                    this.g = hVar;
                    Messenger messenger = new Messenger(this.d);
                    this.h = messenger;
                    this.d.a(messenger);
                    try {
                        hVar.a(this.a, messenger);
                    } catch (RemoteException unused) {
                        xz1.g("MediaBrowserCompat", "Remote error registering client messenger.");
                    }
                }
                lh1 lh1VarZ0 = lh1.a.Z0(bundleY.getBinder("extra_session_binder"));
                if (lh1VarZ0 != null) {
                    this.i = pi2.h.d(this.b.getSessionToken(), lh1VarZ0);
                }
            } catch (IllegalStateException e) {
                xz1.e("MediaBrowserCompat", "Unexpected IllegalStateException", e);
            }
        }

        @Override // z62.b.InterfaceC0139b
        public void f() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e extends d {
        public e(Context context, ComponentName componentName, b bVar, Bundle bundle) {
            super(context, componentName, bVar, bundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface f {
        void c(Messenger messenger, String str, List list, Bundle bundle, Bundle bundle2);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class h {
        public final Messenger a;
        public final Bundle b;

        public h(IBinder iBinder, Bundle bundle) {
            this.a = new Messenger(iBinder);
            this.b = bundle;
        }

        public void a(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString("data_package_name", context.getPackageName());
            bundle.putInt("data_calling_pid", Process.myPid());
            bundle.putBundle("data_root_hints", this.b);
            b(6, bundle, messenger);
        }

        public final void b(int i, Bundle bundle, Messenger messenger) throws RemoteException {
            Message messageObtain = Message.obtain();
            messageObtain.what = i;
            messageObtain.arg1 = 1;
            if (bundle != null) {
                messageObtain.setData(bundle);
            }
            messageObtain.replyTo = messenger;
            this.a.send(messageObtain);
        }

        public void c(Messenger messenger) throws RemoteException {
            b(7, null, messenger);
        }
    }

    public z62(Context context, ComponentName componentName, b bVar, Bundle bundle) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.a = new e(context, componentName, bVar, bundle);
        } else {
            this.a = new d(context, componentName, bVar, bundle);
        }
    }

    public void a() {
        xz1.b("MediaBrowserCompat", "Connecting to a MediaBrowserService.");
        this.a.b();
    }

    public void b() {
        this.a.disconnect();
    }

    public pi2.h c() {
        return this.a.a();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class g implements Parcelable {
        public static final Parcelable.Creator<g> CREATOR = new a();
        public final int f;
        public final zf2 g;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements Parcelable.Creator {
            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public g createFromParcel(Parcel parcel) {
                return new g(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public g[] newArray(int i) {
                return new g[i];
            }
        }

        public g(zf2 zf2Var, int i) {
            if (zf2Var == null) {
                jl.a("description cannot be null");
                throw null;
            }
            if (TextUtils.isEmpty(zf2Var.y())) {
                jl.a("description must have a non-empty media id");
                throw null;
            }
            this.f = i;
            this.g = zf2Var;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaItem{mFlags=" + this.f + ", mDescription=" + this.g + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.f);
            this.g.writeToParcel(parcel, i);
        }

        public g(Parcel parcel) {
            this.f = parcel.readInt();
            this.g = zf2.CREATOR.createFromParcel(parcel);
        }
    }
}
