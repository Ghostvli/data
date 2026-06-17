package defpackage;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e43 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public static Notification.BubbleMetadata a(b bVar) {
            return null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public boolean A;
        public boolean B;
        public String C;
        public Bundle D;
        public Notification G;
        public RemoteViews H;
        public RemoteViews I;
        public RemoteViews J;
        public String K;
        public String M;
        public wz1 N;
        public long O;
        public boolean R;
        public Notification S;
        public boolean T;
        public Object U;
        public ArrayList V;
        public Context a;
        public CharSequence e;
        public CharSequence f;
        public PendingIntent g;
        public PendingIntent h;
        public RemoteViews i;
        public IconCompat j;
        public CharSequence k;
        public int l;
        public int m;
        public boolean o;
        public d p;
        public CharSequence q;
        public CharSequence r;
        public CharSequence[] s;
        public int t;
        public int u;
        public boolean v;
        public String w;
        public boolean x;
        public String y;
        public ArrayList b = new ArrayList();
        public ArrayList c = new ArrayList();
        public ArrayList d = new ArrayList();
        public boolean n = true;
        public boolean z = false;
        public int E = 0;
        public int F = 0;
        public int L = 0;
        public int P = 0;
        public int Q = 0;

        public c(Context context, String str) {
            Notification notification = new Notification();
            this.S = notification;
            this.a = context;
            this.K = str;
            notification.when = System.currentTimeMillis();
            this.S.audioStreamType = -1;
            this.m = 0;
            this.V = new ArrayList();
            this.R = true;
        }

        public static CharSequence d(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        public c a(a aVar) {
            if (aVar != null) {
                this.b.add(aVar);
            }
            return this;
        }

        public Notification b() {
            return new f43(this).c();
        }

        public Bundle c() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        public c e(PendingIntent pendingIntent) {
            this.g = pendingIntent;
            return this;
        }

        public c f(CharSequence charSequence) {
            this.f = d(charSequence);
            return this;
        }

        public c g(CharSequence charSequence) {
            this.e = d(charSequence);
            return this;
        }

        public c h(PendingIntent pendingIntent) {
            this.S.deleteIntent = pendingIntent;
            return this;
        }

        public final void i(int i, boolean z) {
            Notification notification = this.S;
            if (z) {
                notification.flags = i | notification.flags;
            } else {
                notification.flags = (~i) & notification.flags;
            }
        }

        public c j(int i) {
            this.Q = i;
            return this;
        }

        public c k(String str) {
            this.w = str;
            return this;
        }

        public c l(Bitmap bitmap) {
            this.j = bitmap == null ? null : IconCompat.d(e43.b(this.a, bitmap));
            return this;
        }

        public c m(boolean z) {
            i(2, z);
            return this;
        }

        public c n(boolean z) {
            i(8, z);
            return this;
        }

        public c o(boolean z) {
            this.n = z;
            return this;
        }

        public c p(int i) {
            this.S.icon = i;
            return this;
        }

        public c q(d dVar) {
            if (this.p != dVar) {
                this.p = dVar;
                if (dVar != null) {
                    dVar.g(this);
                }
            }
            return this;
        }

        public c r(boolean z) {
            this.o = z;
            return this;
        }

        public c s(int i) {
            this.F = i;
            return this;
        }

        public c t(long j) {
            this.S.when = j;
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class d {
        public c a;
        public CharSequence b;
        public CharSequence c;
        public boolean d = false;

        public void a(Bundle bundle) {
            if (this.d) {
                bundle.putCharSequence("android.summaryText", this.c);
            }
            CharSequence charSequence = this.b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String strC = c();
            if (strC != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", strC);
            }
        }

        public abstract void b(c43 c43Var);

        public String c() {
            return null;
        }

        public RemoteViews d(c43 c43Var) {
            return null;
        }

        public RemoteViews e(c43 c43Var) {
            return null;
        }

        public RemoteViews f(c43 c43Var) {
            return null;
        }

        public void g(c cVar) {
            if (this.a != cVar) {
                this.a = cVar;
                if (cVar != null) {
                    cVar.q(this);
                }
            }
        }
    }

    public static Bundle a(Notification notification) {
        return notification.extras;
    }

    public static Bitmap b(Context context, Bitmap bitmap) {
        if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
            return bitmap;
        }
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(uk3.b);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(uk3.a);
        if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
            return bitmap;
        }
        double dMin = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
        return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * dMin), (int) Math.ceil(((double) bitmap.getHeight()) * dMin), true);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public final Bundle a;
        public IconCompat b;
        public final fq3[] c;
        public final fq3[] d;
        public boolean e;
        public boolean f;
        public final int g;
        public final boolean h;
        public int i;
        public CharSequence j;
        public PendingIntent k;
        public boolean l;

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, fq3[] fq3VarArr, fq3[] fq3VarArr2, boolean z, int i, boolean z2, boolean z3, boolean z4) {
            this.f = true;
            this.b = iconCompat;
            if (iconCompat != null && iconCompat.j() == 2) {
                this.i = iconCompat.g();
            }
            this.j = c.d(charSequence);
            this.k = pendingIntent;
            this.a = bundle == null ? new Bundle() : bundle;
            this.c = fq3VarArr;
            this.d = fq3VarArr2;
            this.e = z;
            this.g = i;
            this.f = z2;
            this.h = z3;
            this.l = z4;
        }

        public PendingIntent a() {
            return this.k;
        }

        public boolean b() {
            return this.e;
        }

        public Bundle c() {
            return this.a;
        }

        public IconCompat d() {
            int i;
            if (this.b == null && (i = this.i) != 0) {
                this.b = IconCompat.f(null, "", i);
            }
            return this.b;
        }

        public fq3[] e() {
            return this.c;
        }

        public int f() {
            return this.g;
        }

        public boolean g() {
            return this.f;
        }

        public CharSequence h() {
            return this.j;
        }

        public boolean i() {
            return this.l;
        }

        public boolean j() {
            return this.h;
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), null, null, true, 0, true, false, false);
        }
    }
}
