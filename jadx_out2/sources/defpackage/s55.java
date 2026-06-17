package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import defpackage.ss4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class s55 extends ss4 {
    public static final String[] S = {"android:visibility:visibility", "android:visibility:parent"};
    public int R = 3;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public boolean a;
        public boolean b;
        public int c;
        public int d;
        public ViewGroup e;
        public ViewGroup f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void g0(gt4 gt4Var) {
        gt4Var.a.put("android:visibility:visibility", Integer.valueOf(gt4Var.b.getVisibility()));
        gt4Var.a.put("android:visibility:parent", gt4Var.b.getParent());
        int[] iArr = new int[2];
        gt4Var.b.getLocationOnScreen(iArr);
        gt4Var.a.put("android:visibility:screenLocation", iArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ss4
    public String[] F() {
        return S;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ss4
    public boolean H(gt4 gt4Var, gt4 gt4Var2) {
        if (gt4Var == null && gt4Var2 == null) {
            return false;
        }
        if (gt4Var != null && gt4Var2 != null && gt4Var2.a.containsKey("android:visibility:visibility") != gt4Var.a.containsKey("android:visibility:visibility")) {
            return false;
        }
        c cVarH0 = h0(gt4Var, gt4Var2);
        return cVarH0.a && (cVarH0.c == 0 || cVarH0.d == 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ss4
    public void f(gt4 gt4Var) {
        g0(gt4Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final c h0(gt4 gt4Var, gt4 gt4Var2) {
        c cVar = new c();
        cVar.a = false;
        cVar.b = false;
        if (gt4Var == null || !gt4Var.a.containsKey("android:visibility:visibility")) {
            cVar.c = -1;
            cVar.e = null;
        } else {
            cVar.c = ((Integer) gt4Var.a.get("android:visibility:visibility")).intValue();
            cVar.e = (ViewGroup) gt4Var.a.get("android:visibility:parent");
        }
        if (gt4Var2 == null || !gt4Var2.a.containsKey("android:visibility:visibility")) {
            cVar.d = -1;
            cVar.f = null;
        } else {
            cVar.d = ((Integer) gt4Var2.a.get("android:visibility:visibility")).intValue();
            cVar.f = (ViewGroup) gt4Var2.a.get("android:visibility:parent");
        }
        if (gt4Var != null && gt4Var2 != null) {
            int i = cVar.c;
            int i2 = cVar.d;
            if (i != i2 || cVar.e != cVar.f) {
                if (i != i2) {
                    if (i == 0) {
                        cVar.b = false;
                        cVar.a = true;
                        return cVar;
                    }
                    if (i2 == 0) {
                        cVar.b = true;
                        cVar.a = true;
                        return cVar;
                    }
                } else {
                    if (cVar.f == null) {
                        cVar.b = false;
                        cVar.a = true;
                        return cVar;
                    }
                    if (cVar.e == null) {
                        cVar.b = true;
                        cVar.a = true;
                        return cVar;
                    }
                }
            }
        } else {
            if (gt4Var == null && cVar.d == 0) {
                cVar.b = true;
                cVar.a = true;
                return cVar;
            }
            if (gt4Var2 == null && cVar.c == 0) {
                cVar.b = false;
                cVar.a = true;
            }
        }
        return cVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ss4
    public void i(gt4 gt4Var) {
        g0(gt4Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Animator i0(ViewGroup viewGroup, gt4 gt4Var, int i, gt4 gt4Var2, int i2) {
        if ((this.R & 1) != 1 || gt4Var2 == null) {
            return null;
        }
        if (gt4Var == null) {
            View view = (View) gt4Var2.b.getParent();
            if (h0(u(view, false), G(view, false)).a) {
                return null;
            }
        }
        return j0(viewGroup, gt4Var2.b, gt4Var, gt4Var2);
    }

    public abstract Animator j0(ViewGroup viewGroup, View view, gt4 gt4Var, gt4 gt4Var2);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0069 A[PHI: r2
      0x0069: PHI (r2v3 android.view.View) = 
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v2 android.view.View)
      (r2v6 android.view.View)
     binds: [B:26:0x003e, B:31:0x004d, B:37:0x0076, B:39:0x0079, B:41:0x007f, B:43:0x0083, B:34:0x0065] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Animator k0(ViewGroup viewGroup, gt4 gt4Var, int i, gt4 gt4Var2, int i2) {
        View view;
        boolean z;
        View view2;
        boolean z2;
        if ((this.R & 2) != 2 || gt4Var == null) {
            return null;
        }
        View view3 = gt4Var.b;
        View viewA = gt4Var2 != null ? gt4Var2.b : null;
        View view4 = (View) view3.getTag(kl3.a);
        if (view4 != null) {
            view2 = null;
            z2 = true;
        } else if (viewA == null || viewA.getParent() == null) {
            if (viewA != null) {
                view = null;
                z = false;
            } else {
                viewA = null;
                view = null;
                z = true;
            }
            if (z) {
                if (view3.getParent() != null) {
                    if (view3.getParent() instanceof View) {
                        View view5 = (View) view3.getParent();
                        if (h0(G(view5, true), u(view5, true)).a) {
                            int id = view5.getId();
                            if (view5.getParent() != null || id == -1 || viewGroup.findViewById(id) == null || !this.B) {
                            }
                        } else {
                            viewA = ft4.a(viewGroup, view3, view5);
                        }
                    }
                    View view6 = view;
                    view4 = viewA;
                    view2 = view6;
                    z2 = false;
                }
                view2 = view;
                z2 = false;
                view4 = view3;
            } else {
                View view62 = view;
                view4 = viewA;
                view2 = view62;
                z2 = false;
            }
        } else {
            if (i2 == 4 || view3 == viewA) {
                view = viewA;
                z = false;
                viewA = null;
            }
            if (z) {
            }
        }
        if (view4 == null) {
            if (view2 == null) {
                return null;
            }
            int visibility = view2.getVisibility();
            g55.f(view2, 0);
            Animator animatorL0 = l0(viewGroup, view2, gt4Var, gt4Var2);
            if (animatorL0 == null) {
                g55.f(view2, visibility);
                return animatorL0;
            }
            a aVar = new a(view2, i2, true);
            animatorL0.addListener(aVar);
            y().a(aVar);
            return animatorL0;
        }
        if (!z2) {
            int[] iArr = (int[]) gt4Var.a.get("android:visibility:screenLocation");
            int i3 = iArr[0];
            int i4 = iArr[1];
            int[] iArr2 = new int[2];
            viewGroup.getLocationOnScreen(iArr2);
            view4.offsetLeftAndRight((i3 - iArr2[0]) - view4.getLeft());
            view4.offsetTopAndBottom((i4 - iArr2[1]) - view4.getTop());
            viewGroup.getOverlay().add(view4);
        }
        Animator animatorL02 = l0(viewGroup, view4, gt4Var, gt4Var2);
        if (!z2) {
            if (animatorL02 == null) {
                viewGroup.getOverlay().remove(view4);
                return animatorL02;
            }
            view3.setTag(kl3.a, view4);
            b bVar = new b(viewGroup, view4, view3);
            animatorL02.addListener(bVar);
            animatorL02.addPauseListener(bVar);
            y().a(bVar);
        }
        return animatorL02;
    }

    public abstract Animator l0(ViewGroup viewGroup, View view, gt4 gt4Var, gt4 gt4Var2);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ss4
    public Animator m(ViewGroup viewGroup, gt4 gt4Var, gt4 gt4Var2) {
        c cVarH0 = h0(gt4Var, gt4Var2);
        if (!cVarH0.a) {
            return null;
        }
        if (cVarH0.e == null && cVarH0.f == null) {
            return null;
        }
        boolean z = cVarH0.b;
        int i = cVarH0.c;
        return z ? i0(viewGroup, gt4Var, i, gt4Var2, cVarH0.d) : k0(viewGroup, gt4Var, i, gt4Var2, cVarH0.d);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m0(int i) {
        if ((i & (-4)) == 0) {
            this.R = i;
        } else {
            jl.a("Only MODE_IN and MODE_OUT flags are allowed");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends AnimatorListenerAdapter implements ss4.g {
        public final View a;
        public final int b;
        public final ViewGroup c;
        public final boolean d;
        public boolean e;
        public boolean f = false;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(View view, int i, boolean z) {
            this.a = view;
            this.b = i;
            this.c = (ViewGroup) view.getParent();
            this.d = z;
            i(true);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ss4.g
        public void a(ss4 ss4Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ss4.g
        public void b(ss4 ss4Var) {
            i(true);
            if (this.f) {
                return;
            }
            g55.f(this.a, 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ss4.g
        public void c(ss4 ss4Var) {
            ss4Var.T(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ss4.g
        public void e(ss4 ss4Var) {
            i(false);
            if (this.f) {
                return;
            }
            g55.f(this.a, this.b);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ss4.g
        public void g(ss4 ss4Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void h() {
            if (!this.f) {
                g55.f(this.a, this.b);
                ViewGroup viewGroup = this.c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            i(false);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void i(boolean z) {
            ViewGroup viewGroup;
            if (!this.d || this.e == z || (viewGroup = this.c) == null) {
                return;
            }
            this.e = z;
            z35.b(viewGroup, z);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.f = true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z) {
            if (z) {
                return;
            }
            h();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z) {
            if (z) {
                g55.f(this.a, 0);
                ViewGroup viewGroup = this.c;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends AnimatorListenerAdapter implements ss4.g {
        public final ViewGroup a;
        public final View b;
        public final View c;
        public boolean d = true;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(ViewGroup viewGroup, View view, View view2) {
            this.a = viewGroup;
            this.b = view;
            this.c = view2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ss4.g
        public void a(ss4 ss4Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ss4.g
        public void b(ss4 ss4Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ss4.g
        public void c(ss4 ss4Var) {
            ss4Var.T(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ss4.g
        public void e(ss4 ss4Var) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // ss4.g
        public void g(ss4 ss4Var) {
            if (this.d) {
                h();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void h() {
            this.c.setTag(kl3.a, null);
            this.a.getOverlay().remove(this.b);
            this.d = false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator, boolean z) {
            if (z) {
                return;
            }
            h();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationPause(Animator animator) {
            this.a.getOverlay().remove(this.b);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
        public void onAnimationResume(Animator animator) {
            if (this.b.getParent() == null) {
                this.a.getOverlay().add(this.b);
            } else {
                s55.this.cancel();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator, boolean z) {
            if (z) {
                this.c.setTag(kl3.a, this.b);
                this.a.getOverlay().add(this.b);
                this.d = true;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            h();
        }
    }
}
