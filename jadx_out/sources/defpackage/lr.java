package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.graphics.PointF;
import android.graphics.Rect;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import defpackage.ss4;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class lr extends ss4 {
    public static final String[] S = {"android:changeBounds:bounds", "android:changeBounds:clip", "android:changeBounds:parent", "android:changeBounds:windowX", "android:changeBounds:windowY"};
    public static final Property T = new a(PointF.class, "topLeft");
    public static final Property U = new b(PointF.class, "bottomRight");
    public static final Property V = new c(PointF.class, "bottomRight");
    public static final Property W = new d(PointF.class, "topLeft");
    public static final Property X = new e(PointF.class, "position");
    public static final zo3 Y = new zo3();
    public boolean R = false;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends Property {
        public a(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(i iVar) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(i iVar, PointF pointF) {
            iVar.c(pointF);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends Property {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(i iVar) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(i iVar, PointF pointF) {
            iVar.a(pointF);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends Property {
        public c(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            g55.d(view, view.getLeft(), view.getTop(), Math.round(pointF.x), Math.round(pointF.y));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d extends Property {
        public d(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            g55.d(view, Math.round(pointF.x), Math.round(pointF.y), view.getRight(), view.getBottom());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e extends Property {
        public e(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public PointF get(View view) {
            return null;
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(View view, PointF pointF) {
            int iRound = Math.round(pointF.x);
            int iRound2 = Math.round(pointF.y);
            g55.d(view, iRound, iRound2, view.getWidth() + iRound, view.getHeight() + iRound2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class f extends AnimatorListenerAdapter {
        public final /* synthetic */ i a;
        private final i mViewBounds;

        public f(i iVar) {
            this.a = iVar;
            this.mViewBounds = iVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class h extends at4 {
        public boolean a = false;
        public final ViewGroup b;

        public h(ViewGroup viewGroup) {
            this.b = viewGroup;
        }

        @Override // defpackage.at4, ss4.g
        public void b(ss4 ss4Var) {
            z35.b(this.b, true);
        }

        @Override // ss4.g
        public void c(ss4 ss4Var) {
            if (!this.a) {
                z35.b(this.b, false);
            }
            ss4Var.T(this);
        }

        @Override // defpackage.at4, ss4.g
        public void e(ss4 ss4Var) {
            z35.b(this.b, false);
        }

        @Override // defpackage.at4, ss4.g
        public void g(ss4 ss4Var) {
            z35.b(this.b, false);
            this.a = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class i {
        public int a;
        public int b;
        public int c;
        public int d;
        public final View e;
        public int f;
        public int g;

        public i(View view) {
            this.e = view;
        }

        public void a(PointF pointF) {
            this.c = Math.round(pointF.x);
            this.d = Math.round(pointF.y);
            int i = this.g + 1;
            this.g = i;
            if (this.f == i) {
                b();
            }
        }

        public final void b() {
            g55.d(this.e, this.a, this.b, this.c, this.d);
            this.f = 0;
            this.g = 0;
        }

        public void c(PointF pointF) {
            this.a = Math.round(pointF.x);
            this.b = Math.round(pointF.y);
            int i = this.f + 1;
            this.f = i;
            if (i == this.g) {
                b();
            }
        }
    }

    @Override // defpackage.ss4
    public String[] F() {
        return S;
    }

    @Override // defpackage.ss4
    public void f(gt4 gt4Var) {
        g0(gt4Var);
    }

    public final void g0(gt4 gt4Var) {
        View view = gt4Var.b;
        if (!view.isLaidOut() && view.getWidth() == 0 && view.getHeight() == 0) {
            return;
        }
        gt4Var.a.put("android:changeBounds:bounds", new Rect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()));
        gt4Var.a.put("android:changeBounds:parent", gt4Var.b.getParent());
        if (this.R) {
            gt4Var.a.put("android:changeBounds:clip", view.getClipBounds());
        }
    }

    @Override // defpackage.ss4
    public void i(gt4 gt4Var) {
        Rect rect;
        g0(gt4Var);
        if (!this.R || (rect = (Rect) gt4Var.b.getTag(kl3.b)) == null) {
            return;
        }
        gt4Var.a.put("android:changeBounds:clip", rect);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.ss4
    public Animator m(ViewGroup viewGroup, gt4 gt4Var, gt4 gt4Var2) {
        int i2;
        int i3;
        int i4;
        int i5;
        ObjectAnimator objectAnimatorA;
        int i6;
        Rect rect;
        ObjectAnimator objectAnimatorOfObject;
        Animator animatorC;
        if (gt4Var == null || gt4Var2 == null) {
            return null;
        }
        Map map = gt4Var.a;
        Map map2 = gt4Var2.a;
        ViewGroup viewGroup2 = (ViewGroup) map.get("android:changeBounds:parent");
        ViewGroup viewGroup3 = (ViewGroup) map2.get("android:changeBounds:parent");
        if (viewGroup2 == null || viewGroup3 == null) {
            return null;
        }
        View view = gt4Var2.b;
        Rect rect2 = (Rect) gt4Var.a.get("android:changeBounds:bounds");
        Rect rect3 = (Rect) gt4Var2.a.get("android:changeBounds:bounds");
        int i7 = rect2.left;
        int i8 = rect3.left;
        int i9 = rect2.top;
        int i10 = rect3.top;
        int i11 = rect2.right;
        int i12 = rect3.right;
        int i13 = rect2.bottom;
        int i14 = rect3.bottom;
        int i15 = i11 - i7;
        int i16 = i13 - i9;
        int i17 = i12 - i8;
        int i18 = i14 - i10;
        Rect rect4 = (Rect) gt4Var.a.get("android:changeBounds:clip");
        Rect rect5 = (Rect) gt4Var2.a.get("android:changeBounds:clip");
        if ((i15 == 0 || i16 == 0) && (i17 == 0 || i18 == 0)) {
            i2 = 0;
        } else {
            i2 = (i7 == i8 && i9 == i10) ? 0 : 1;
            if (i11 != i12 || i13 != i14) {
                i2++;
            }
        }
        if ((rect4 != null && !rect4.equals(rect5)) || (rect4 == null && rect5 != null)) {
            i2++;
        }
        int i19 = i2;
        if (i19 <= 0) {
            return null;
        }
        if (this.R) {
            g55.d(view, i7, i9, Math.max(i15, i17) + i7, i9 + Math.max(i16, i18));
            if (i7 == i8 && i9 == i10) {
                objectAnimatorA = null;
                i3 = i14;
                i5 = i8;
                i4 = i12;
            } else {
                i3 = i14;
                i4 = i12;
                i5 = i8;
                objectAnimatorA = q43.a(view, X, w().a(i7, i9, i8, i10));
            }
            boolean z = rect4 == null;
            if (z) {
                i6 = 0;
                rect = new Rect(0, 0, i15, i16);
            } else {
                i6 = 0;
                rect = rect4;
            }
            int i20 = rect5 == null ? 1 : i6;
            Rect rect6 = i20 != 0 ? new Rect(i6, i6, i17, i18) : rect5;
            if (rect.equals(rect6)) {
                objectAnimatorOfObject = null;
            } else {
                view.setClipBounds(rect);
                objectAnimatorOfObject = ObjectAnimator.ofObject(view, "clipBounds", Y, rect, rect6);
                g gVar = new g(view, rect, z, rect6, i20, i7, i9, i11, i13, i5, i10, i4, i3);
                objectAnimatorOfObject.addListener(gVar);
                a(gVar);
            }
            animatorC = ft4.c(objectAnimatorA, objectAnimatorOfObject);
        } else {
            g55.d(view, i7, i9, i11, i13);
            if (i19 != 2) {
                animatorC = (i7 == i8 && i9 == i10) ? q43.a(view, V, w().a(i11, i13, i12, i14)) : q43.a(view, W, w().a(i7, i9, i8, i10));
            } else if (i15 == i17 && i16 == i18) {
                animatorC = q43.a(view, X, w().a(i7, i9, i8, i10));
            } else {
                i iVar = new i(view);
                ObjectAnimator objectAnimatorA2 = q43.a(iVar, T, w().a(i7, i9, i8, i10));
                ObjectAnimator objectAnimatorA3 = q43.a(iVar, U, w().a(i11, i13, i12, i14));
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(objectAnimatorA2, objectAnimatorA3);
                animatorSet.addListener(new f(iVar));
                animatorC = animatorSet;
            }
        }
        if (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup4 = (ViewGroup) view.getParent();
            z35.b(viewGroup4, true);
            y().a(new h(viewGroup4));
        }
        return animatorC;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class g extends AnimatorListenerAdapter implements ss4.g {
        public final View a;
        public final Rect b;
        public final boolean c;
        public final Rect d;
        public final boolean e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final int j;
        public final int k;
        public final int l;
        public final int m;
        public boolean n;

        public g(View view, Rect rect, boolean z, Rect rect2, boolean z2, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            this.a = view;
            this.b = rect;
            this.c = z;
            this.d = rect2;
            this.e = z2;
            this.f = i;
            this.g = i2;
            this.h = i3;
            this.i = i4;
            this.j = i5;
            this.k = i6;
            this.l = i7;
            this.m = i8;
        }

        @Override // ss4.g
        public void a(ss4 ss4Var) {
        }

        @Override // ss4.g
        public void b(ss4 ss4Var) {
            Rect rect = (Rect) this.a.getTag(kl3.b);
            this.a.setTag(kl3.b, null);
            this.a.setClipBounds(rect);
        }

        @Override // ss4.g
        public void c(ss4 ss4Var) {
        }

        @Override // ss4.g
        public void e(ss4 ss4Var) {
            this.a.setTag(kl3.b, this.a.getClipBounds());
            this.a.setClipBounds(this.e ? null : this.d);
        }

        @Override // ss4.g
        public void g(ss4 ss4Var) {
            this.n = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z) {
            if (this.n) {
                return;
            }
            Rect rect = null;
            if (z) {
                if (!this.c) {
                    rect = this.b;
                }
            } else if (!this.e) {
                rect = this.d;
            }
            this.a.setClipBounds(rect);
            View view = this.a;
            if (z) {
                g55.d(view, this.f, this.g, this.h, this.i);
            } else {
                g55.d(view, this.j, this.k, this.l, this.m);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z) {
            int iMax = Math.max(this.h - this.f, this.l - this.j);
            int iMax2 = Math.max(this.i - this.g, this.m - this.k);
            int i = z ? this.j : this.f;
            int i2 = z ? this.k : this.g;
            g55.d(this.a, i, i2, iMax + i, iMax2 + i2);
            this.a.setClipBounds(z ? this.d : this.b);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            onAnimationEnd(animator, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            onAnimationStart(animator, false);
        }
    }
}
