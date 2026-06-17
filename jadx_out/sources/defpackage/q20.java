package defpackage;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class q20 {
    public final f a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final c a;

        public a(ClipData clipData, int i) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.a = new b(clipData, i);
            } else {
                this.a = new d(clipData, i);
            }
        }

        public q20 a() {
            return this.a.build();
        }

        public a b(Bundle bundle) {
            this.a.setExtras(bundle);
            return this;
        }

        public a c(int i) {
            this.a.b(i);
            return this;
        }

        public a d(Uri uri) {
            this.a.c(uri);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements c {
        public final ContentInfo.Builder a;

        public b(ClipData clipData, int i) {
            this.a = r20.a(clipData, i);
        }

        @Override // q20.c
        public void b(int i) {
            this.a.setFlags(i);
        }

        @Override // q20.c
        public q20 build() {
            return new q20(new e(this.a.build()));
        }

        @Override // q20.c
        public void c(Uri uri) {
            this.a.setLinkUri(uri);
        }

        @Override // q20.c
        public void setExtras(Bundle bundle) {
            this.a.setExtras(bundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface c {
        void b(int i);

        q20 build();

        void c(Uri uri);

        void setExtras(Bundle bundle);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d implements c {
        public ClipData a;
        public int b;
        public int c;
        public Uri d;
        public Bundle e;

        public d(ClipData clipData, int i) {
            this.a = clipData;
            this.b = i;
        }

        @Override // q20.c
        public void b(int i) {
            this.c = i;
        }

        @Override // q20.c
        public q20 build() {
            return new q20(new g(this));
        }

        @Override // q20.c
        public void c(Uri uri) {
            this.d = uri;
        }

        @Override // q20.c
        public void setExtras(Bundle bundle) {
            this.e = bundle;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e implements f {
        public final ContentInfo a;

        public e(ContentInfo contentInfo) {
            this.a = p20.a(hg3.g(contentInfo));
        }

        @Override // q20.f
        public int a() {
            return this.a.getFlags();
        }

        @Override // q20.f
        public ClipData b() {
            return this.a.getClip();
        }

        @Override // q20.f
        public ContentInfo c() {
            return this.a;
        }

        @Override // q20.f
        public int getSource() {
            return this.a.getSource();
        }

        public String toString() {
            return "ContentInfoCompat{" + this.a + "}";
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface f {
        int a();

        ClipData b();

        ContentInfo c();

        int getSource();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g implements f {
        public final ClipData a;
        public final int b;
        public final int c;
        public final Uri d;
        public final Bundle e;

        public g(d dVar) {
            this.a = (ClipData) hg3.g(dVar.a);
            this.b = hg3.c(dVar.b, 0, 5, "source");
            this.c = hg3.f(dVar.c, 1);
            this.d = dVar.d;
            this.e = dVar.e;
        }

        @Override // q20.f
        public int a() {
            return this.c;
        }

        @Override // q20.f
        public ClipData b() {
            return this.a;
        }

        @Override // q20.f
        public ContentInfo c() {
            return null;
        }

        @Override // q20.f
        public int getSource() {
            return this.b;
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder("ContentInfoCompat{clip=");
            sb.append(this.a.getDescription());
            sb.append(", source=");
            sb.append(q20.e(this.b));
            sb.append(", flags=");
            sb.append(q20.a(this.c));
            if (this.d == null) {
                str = "";
            } else {
                str = ", hasLinkUri(" + this.d.toString().length() + ")";
            }
            sb.append(str);
            sb.append(this.e != null ? ", hasExtras" : "");
            sb.append("}");
            return sb.toString();
        }
    }

    public q20(f fVar) {
        this.a = fVar;
    }

    public static String a(int i) {
        return (i & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i);
    }

    public static String e(int i) {
        return i != 0 ? i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? String.valueOf(i) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    public static q20 g(ContentInfo contentInfo) {
        return new q20(new e(contentInfo));
    }

    public ClipData b() {
        return this.a.b();
    }

    public int c() {
        return this.a.a();
    }

    public int d() {
        return this.a.getSource();
    }

    public ContentInfo f() {
        ContentInfo contentInfoC = this.a.c();
        Objects.requireNonNull(contentInfoC);
        p20.a(contentInfoC);
        return contentInfoC;
    }

    public String toString() {
        return this.a.toString();
    }
}
