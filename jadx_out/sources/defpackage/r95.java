package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Callback;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import defpackage.w95;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class r95 {
    public e a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class b {
        public w95 a;
        public final int b;

        public b(int i) {
            this.b = i;
        }

        public final int a() {
            return this.b;
        }

        public abstract void b(r95 r95Var);

        public abstract void c(r95 r95Var);

        public abstract w95 d(w95 w95Var, List list);

        public abstract a e(r95 r95Var, a aVar);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends e {
        public static final Interpolator f = new PathInterpolator(0.0f, 1.1f, 0.0f, 1.0f);
        public static final Interpolator g = new xz0();
        public static final Interpolator h = new DecelerateInterpolator(1.5f);
        public static final Interpolator i = new AccelerateInterpolator(1.5f);

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static class a implements View.OnApplyWindowInsetsListener {
            public final b a;
            public w95 b;

            /* JADX INFO: renamed from: r95$c$a$a, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public class C0116a implements ValueAnimator.AnimatorUpdateListener {
                public final /* synthetic */ r95 a;
                public final /* synthetic */ w95 b;
                public final /* synthetic */ w95 c;
                public final /* synthetic */ int d;
                public final /* synthetic */ View e;

                public C0116a(r95 r95Var, w95 w95Var, w95 w95Var2, int i, View view) {
                    this.a = r95Var;
                    this.b = w95Var;
                    this.c = w95Var2;
                    this.d = i;
                    this.e = view;
                }

                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    this.a.f(valueAnimator.getAnimatedFraction());
                    c.l(this.e, c.p(this.b, this.c, this.a.c(), this.d), Collections.singletonList(this.a));
                }
            }

            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public class b extends AnimatorListenerAdapter {
                public final /* synthetic */ r95 a;
                public final /* synthetic */ View b;

                public b(r95 r95Var, View view) {
                    this.a = r95Var;
                    this.b = view;
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    this.a.f(1.0f);
                    c.j(this.b, this.a);
                }
            }

            /* JADX INFO: renamed from: r95$c$a$c, reason: collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
            public class RunnableC0117c implements Runnable {
                public final /* synthetic */ View f;
                public final /* synthetic */ r95 g;
                public final /* synthetic */ a h;
                public final /* synthetic */ ValueAnimator i;

                public RunnableC0117c(View view, r95 r95Var, a aVar, ValueAnimator valueAnimator) {
                    this.f = view;
                    this.g = r95Var;
                    this.h = aVar;
                    this.i = valueAnimator;
                }

                @Override // java.lang.Runnable
                public void run() {
                    c.m(this.f, this.g, this.h);
                    this.i.start();
                }
            }

            public a(View view, b bVar) {
                this.a = bVar;
                w95 w95VarD = l35.D(view);
                this.b = w95VarD != null ? new w95.a(w95VarD).a() : null;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                if (!view.isLaidOut()) {
                    this.b = w95.x(windowInsets, view);
                    return c.n(view, windowInsets);
                }
                w95 w95VarX = w95.x(windowInsets, view);
                if (this.b == null) {
                    this.b = l35.D(view);
                }
                if (this.b == null) {
                    this.b = w95VarX;
                    return c.n(view, windowInsets);
                }
                b bVarO = c.o(view);
                if (bVarO != null && Objects.equals(bVarO.a, w95VarX)) {
                    return c.n(view, windowInsets);
                }
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                c.f(w95VarX, this.b, iArr, iArr2);
                int i = iArr[0];
                int i2 = iArr2[0];
                int i3 = i | i2;
                if (i3 == 0) {
                    this.b = w95VarX;
                    return c.n(view, windowInsets);
                }
                w95 w95Var = this.b;
                r95 r95Var = new r95(i3, c.h(i, i2), (w95.n.a() & i3) != 0 ? 160L : 250L);
                r95Var.f(0.0f);
                ValueAnimator duration = ValueAnimator.ofFloat(0.0f, 1.0f).setDuration(r95Var.b());
                a aVarG = c.g(w95VarX, w95Var, i3);
                c.k(view, r95Var, w95VarX, false);
                duration.addUpdateListener(new C0116a(r95Var, w95VarX, w95Var, i3, view));
                duration.addListener(new b(r95Var, view));
                q63.a(view, new RunnableC0117c(view, r95Var, aVarG, duration));
                this.b = w95VarX;
                return c.n(view, windowInsets);
            }
        }

        public c(int i2, Interpolator interpolator, long j) {
            super(i2, interpolator, j);
        }

        public static void f(w95 w95Var, w95 w95Var2, int[] iArr, int[] iArr2) {
            for (int i2 = 1; i2 <= 512; i2 <<= 1) {
                lk1 lk1VarF = w95Var.f(i2);
                lk1 lk1VarF2 = w95Var2.f(i2);
                int i3 = lk1VarF.a;
                int i4 = lk1VarF2.a;
                boolean z = i3 > i4 || lk1VarF.b > lk1VarF2.b || lk1VarF.c > lk1VarF2.c || lk1VarF.d > lk1VarF2.d;
                if (z != (i3 < i4 || lk1VarF.b < lk1VarF2.b || lk1VarF.c < lk1VarF2.c || lk1VarF.d < lk1VarF2.d)) {
                    if (z) {
                        iArr[0] = iArr[0] | i2;
                    } else {
                        iArr2[0] = iArr2[0] | i2;
                    }
                }
            }
        }

        public static a g(w95 w95Var, w95 w95Var2, int i2) {
            lk1 lk1VarF = w95Var.f(i2);
            lk1 lk1VarF2 = w95Var2.f(i2);
            return new a(lk1.c(Math.min(lk1VarF.a, lk1VarF2.a), Math.min(lk1VarF.b, lk1VarF2.b), Math.min(lk1VarF.c, lk1VarF2.c), Math.min(lk1VarF.d, lk1VarF2.d)), lk1.c(Math.max(lk1VarF.a, lk1VarF2.a), Math.max(lk1VarF.b, lk1VarF2.b), Math.max(lk1VarF.c, lk1VarF2.c), Math.max(lk1VarF.d, lk1VarF2.d)));
        }

        public static Interpolator h(int i2, int i3) {
            if ((w95.n.a() & i2) != 0) {
                return f;
            }
            if ((w95.n.a() & i3) != 0) {
                return g;
            }
            if ((i2 & w95.n.e()) != 0) {
                return h;
            }
            if ((w95.n.e() & i3) != 0) {
                return i;
            }
            return null;
        }

        public static View.OnApplyWindowInsetsListener i(View view, b bVar) {
            return new a(view, bVar);
        }

        public static void j(View view, r95 r95Var) {
            b bVarO = o(view);
            if (bVarO != null) {
                bVarO.b(r95Var);
                if (bVarO.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    j(viewGroup.getChildAt(i2), r95Var);
                }
            }
        }

        public static void k(View view, r95 r95Var, w95 w95Var, boolean z) {
            b bVarO = o(view);
            if (bVarO != null) {
                bVarO.a = w95Var;
                if (!z) {
                    bVarO.c(r95Var);
                    z = bVarO.a() == 0;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    k(viewGroup.getChildAt(i2), r95Var, w95Var, z);
                }
            }
        }

        public static void l(View view, w95 w95Var, List list) {
            b bVarO = o(view);
            if (bVarO != null) {
                w95Var = bVarO.d(w95Var, list);
                if (bVarO.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    l(viewGroup.getChildAt(i2), w95Var, list);
                }
            }
        }

        public static void m(View view, r95 r95Var, a aVar) {
            b bVarO = o(view);
            if (bVarO != null) {
                bVarO.e(r95Var, aVar);
                if (bVarO.a() == 0) {
                    return;
                }
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                    m(viewGroup.getChildAt(i2), r95Var, aVar);
                }
            }
        }

        public static WindowInsets n(View view, WindowInsets windowInsets) {
            return view.getTag(rl3.M) != null ? windowInsets : view.onApplyWindowInsets(windowInsets);
        }

        public static b o(View view) {
            Object tag = view.getTag(rl3.U);
            if (tag instanceof a) {
                return ((a) tag).a;
            }
            return null;
        }

        public static w95 p(w95 w95Var, w95 w95Var2, float f2, int i2) {
            w95.a aVar = new w95.a(w95Var);
            for (int i3 = 1; i3 <= 512; i3 <<= 1) {
                if ((i2 & i3) == 0) {
                    aVar.b(i3, w95Var.f(i3));
                } else {
                    lk1 lk1VarF = w95Var.f(i3);
                    lk1 lk1VarF2 = w95Var2.f(i3);
                    float f3 = 1.0f - f2;
                    aVar.b(i3, w95.n(lk1VarF, (int) (((double) ((lk1VarF.a - lk1VarF2.a) * f3)) + 0.5d), (int) (((double) ((lk1VarF.b - lk1VarF2.b) * f3)) + 0.5d), (int) (((double) ((lk1VarF.c - lk1VarF2.c) * f3)) + 0.5d), (int) (((double) ((lk1VarF.d - lk1VarF2.d) * f3)) + 0.5d)));
                }
            }
            return aVar.a();
        }

        public static void q(View view, b bVar) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListenerI = bVar != null ? i(view, bVar) : null;
            view.setTag(rl3.U, onApplyWindowInsetsListenerI);
            if (view.getTag(rl3.L) == null && view.getTag(rl3.M) == null) {
                view.setOnApplyWindowInsetsListener(onApplyWindowInsetsListenerI);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e {
        public final int a;
        public float b;
        public final Interpolator c;
        public final long d;
        public float e = 1.0f;

        public e(int i, Interpolator interpolator, long j) {
            this.a = i;
            this.c = interpolator;
            this.d = j;
        }

        public float a() {
            return this.e;
        }

        public long b() {
            return this.d;
        }

        public float c() {
            Interpolator interpolator = this.c;
            float f = this.b;
            return interpolator != null ? interpolator.getInterpolation(f) : f;
        }

        public int d() {
            return this.a;
        }

        public void e(float f) {
            this.b = f;
        }
    }

    public r95(int i, Interpolator interpolator, long j) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.a = new d(i, interpolator, j);
        } else {
            this.a = new c(i, interpolator, j);
        }
    }

    public static void e(View view, b bVar) {
        if (Build.VERSION.SDK_INT >= 30) {
            d.i(view, bVar);
        } else {
            c.q(view, bVar);
        }
    }

    public static r95 g(WindowInsetsAnimation windowInsetsAnimation) {
        return new r95(windowInsetsAnimation);
    }

    public float a() {
        return this.a.a();
    }

    public long b() {
        return this.a.b();
    }

    public float c() {
        return this.a.c();
    }

    public int d() {
        return this.a.d();
    }

    public void f(float f) {
        this.a.e(f);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d extends e {
        public final WindowInsetsAnimation f;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static class a extends WindowInsetsAnimation$Callback {
            public final b a;
            public List b;
            public ArrayList c;
            public final HashMap d;

            public a(b bVar) {
                super(bVar.a());
                this.d = new HashMap();
                this.a = bVar;
            }

            public final r95 a(WindowInsetsAnimation windowInsetsAnimation) {
                r95 r95Var = (r95) this.d.get(windowInsetsAnimation);
                if (r95Var != null) {
                    return r95Var;
                }
                r95 r95VarG = r95.g(windowInsetsAnimation);
                this.d.put(windowInsetsAnimation, r95VarG);
                return r95VarG;
            }

            public void onEnd(WindowInsetsAnimation windowInsetsAnimation) {
                this.a.b(a(windowInsetsAnimation));
                this.d.remove(windowInsetsAnimation);
            }

            public void onPrepare(WindowInsetsAnimation windowInsetsAnimation) {
                this.a.c(a(windowInsetsAnimation));
            }

            public WindowInsets onProgress(WindowInsets windowInsets, List list) {
                ArrayList arrayList = this.c;
                if (arrayList == null) {
                    ArrayList arrayList2 = new ArrayList(list.size());
                    this.c = arrayList2;
                    this.b = Collections.unmodifiableList(arrayList2);
                } else {
                    arrayList.clear();
                }
                for (int size = list.size() - 1; size >= 0; size--) {
                    WindowInsetsAnimation windowInsetsAnimationA = v95.a(list.get(size));
                    r95 r95VarA = a(windowInsetsAnimationA);
                    r95VarA.f(windowInsetsAnimationA.getFraction());
                    this.c.add(r95VarA);
                }
                return this.a.d(w95.w(windowInsets), this.b).v();
            }

            public WindowInsetsAnimation.Bounds onStart(WindowInsetsAnimation windowInsetsAnimation, WindowInsetsAnimation.Bounds bounds) {
                return this.a.e(a(windowInsetsAnimation), a.d(bounds)).c();
            }
        }

        public d(WindowInsetsAnimation windowInsetsAnimation) {
            super(0, null, 0L);
            this.f = windowInsetsAnimation;
        }

        public static WindowInsetsAnimation.Bounds f(a aVar) {
            u95.a();
            return t95.a(aVar.a().f(), aVar.b().f());
        }

        public static lk1 g(WindowInsetsAnimation.Bounds bounds) {
            return lk1.e(bounds.getUpperBound());
        }

        public static lk1 h(WindowInsetsAnimation.Bounds bounds) {
            return lk1.e(bounds.getLowerBound());
        }

        public static void i(View view, b bVar) {
            view.setWindowInsetsAnimationCallback(bVar != null ? new a(bVar) : null);
        }

        @Override // r95.e
        public float a() {
            return this.f.getAlpha();
        }

        @Override // r95.e
        public long b() {
            return this.f.getDurationMillis();
        }

        @Override // r95.e
        public float c() {
            return this.f.getInterpolatedFraction();
        }

        @Override // r95.e
        public int d() {
            return this.f.getTypeMask();
        }

        @Override // r95.e
        public void e(float f) {
            this.f.setFraction(f);
        }

        public d(int i, Interpolator interpolator, long j) {
            this(s95.a(i, interpolator, j));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final lk1 a;
        public final lk1 b;

        public a(WindowInsetsAnimation.Bounds bounds) {
            this.a = d.h(bounds);
            this.b = d.g(bounds);
        }

        public static a d(WindowInsetsAnimation.Bounds bounds) {
            return new a(bounds);
        }

        public lk1 a() {
            return this.a;
        }

        public lk1 b() {
            return this.b;
        }

        public WindowInsetsAnimation.Bounds c() {
            return d.f(this);
        }

        public String toString() {
            return "Bounds{lower=" + this.a + " upper=" + this.b + "}";
        }

        public a(lk1 lk1Var, lk1 lk1Var2) {
            this.a = lk1Var;
            this.b = lk1Var2;
        }
    }

    public r95(WindowInsetsAnimation windowInsetsAnimation) {
        this(0, null, 0L);
        if (Build.VERSION.SDK_INT >= 30) {
            this.a = new d(windowInsetsAnimation);
        }
    }
}
