package defpackage;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import android.view.inputmethod.InputContentInfo;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ik1 {
    public final c a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements c {
        public final Uri a;
        public final ClipDescription b;
        public final Uri c;

        public b(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.a = uri;
            this.b = clipDescription;
            this.c = uri2;
        }

        @Override // ik1.c
        public Uri a() {
            return this.a;
        }

        @Override // ik1.c
        public void b() {
        }

        @Override // ik1.c
        public Uri c() {
            return this.c;
        }

        @Override // ik1.c
        public Object d() {
            return null;
        }

        @Override // ik1.c
        public ClipDescription getDescription() {
            return this.b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface c {
        Uri a();

        void b();

        Uri c();

        Object d();

        ClipDescription getDescription();
    }

    public ik1(Uri uri, ClipDescription clipDescription, Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.a = new a(uri, clipDescription, uri2);
        } else {
            this.a = new b(uri, clipDescription, uri2);
        }
    }

    public static ik1 f(Object obj) {
        if (obj != null && Build.VERSION.SDK_INT >= 25) {
            return new ik1(new a(obj));
        }
        return null;
    }

    public Uri a() {
        return this.a.a();
    }

    public ClipDescription b() {
        return this.a.getDescription();
    }

    public Uri c() {
        return this.a.c();
    }

    public void d() {
        this.a.b();
    }

    public Object e() {
        return this.a.d();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements c {
        public final InputContentInfo a;

        public a(Uri uri, ClipDescription clipDescription, Uri uri2) {
            this.a = new InputContentInfo(uri, clipDescription, uri2);
        }

        @Override // ik1.c
        public Uri a() {
            return this.a.getContentUri();
        }

        @Override // ik1.c
        public void b() {
            this.a.requestPermission();
        }

        @Override // ik1.c
        public Uri c() {
            return this.a.getLinkUri();
        }

        @Override // ik1.c
        public Object d() {
            return this.a;
        }

        @Override // ik1.c
        public ClipDescription getDescription() {
            return this.a.getDescription();
        }

        public a(Object obj) {
            this.a = (InputContentInfo) obj;
        }
    }

    public ik1(c cVar) {
        this.a = cVar;
    }
}
