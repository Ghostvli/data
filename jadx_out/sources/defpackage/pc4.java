package defpackage;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.window.SplashScreenView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class pc4 {
    public static final a b = new a(null);
    public final c a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends c {
        public boolean h;
        public final ViewGroup.OnHierarchyChangeListener i;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a implements ViewGroup.OnHierarchyChangeListener {
            public final /* synthetic */ Activity g;

            public a(Activity activity) {
                this.g = activity;
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewAdded(View view, View view2) {
                if (sc4.a(view2)) {
                    b bVar = b.this;
                    bVar.e(bVar.d(tc4.a(view2)));
                    View decorView = this.g.getWindow().getDecorView();
                    decorView.getClass();
                    ((ViewGroup) decorView).setOnHierarchyChangeListener(null);
                }
            }

            @Override // android.view.ViewGroup.OnHierarchyChangeListener
            public void onChildViewRemoved(View view, View view2) {
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Activity activity) {
            super(activity);
            activity.getClass();
            this.h = true;
            this.i = new a(activity);
        }

        @Override // pc4.c
        public void b() {
            Resources.Theme theme = a().getTheme();
            theme.getClass();
            c(theme, new TypedValue());
            if (Build.VERSION.SDK_INT < 33) {
                View decorView = a().getWindow().getDecorView();
                decorView.getClass();
                ((ViewGroup) decorView).setOnHierarchyChangeListener(this.i);
            }
        }

        public final boolean d(SplashScreenView splashScreenView) {
            splashScreenView.getClass();
            WindowInsets windowInsetsBuild = rc4.a().build();
            windowInsetsBuild.getClass();
            Rect rect = new Rect(Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
            return (windowInsetsBuild == splashScreenView.getRootView().computeSystemWindowInsets(windowInsetsBuild, rect) && rect.isEmpty()) ? false : true;
        }

        public final void e(boolean z) {
            this.h = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public final Activity a;
        public int b;
        public Integer c;
        public Integer d;
        public Drawable e;
        public boolean f;
        public d g;

        public c(Activity activity) {
            activity.getClass();
            this.a = activity;
            this.g = new d() { // from class: qc4
            };
        }

        public final Activity a() {
            return this.a;
        }

        public void b() {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = this.a.getTheme();
            if (theme.resolveAttribute(ik3.d, typedValue, true)) {
                this.c = Integer.valueOf(typedValue.resourceId);
                this.d = Integer.valueOf(typedValue.data);
            }
            if (theme.resolveAttribute(ik3.c, typedValue, true)) {
                this.e = e9.b(this.a, typedValue.resourceId);
            }
            if (theme.resolveAttribute(ik3.b, typedValue, true)) {
                this.f = typedValue.resourceId == vk3.a;
            }
            c(theme, typedValue);
        }

        public final void c(Resources.Theme theme, TypedValue typedValue) {
            theme.getClass();
            typedValue.getClass();
            if (theme.resolveAttribute(ik3.a, typedValue, true)) {
                int i = typedValue.resourceId;
                this.b = i;
                if (i != 0) {
                    this.a.setTheme(i);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
    }

    public pc4(Activity activity) {
        this.a = Build.VERSION.SDK_INT >= 31 ? new b(activity) : new c(activity);
    }

    public static final pc4 c(Activity activity) {
        return b.a(activity);
    }

    public final void b() {
        this.a.b();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        public final pc4 a(Activity activity) {
            activity.getClass();
            pc4 pc4Var = new pc4(activity, null);
            pc4Var.b();
            return pc4Var;
        }

        public a() {
        }
    }

    public /* synthetic */ pc4(Activity activity, we0 we0Var) {
        this(activity);
    }
}
