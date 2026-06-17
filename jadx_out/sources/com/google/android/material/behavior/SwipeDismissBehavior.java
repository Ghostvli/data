package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import defpackage.g2;
import defpackage.j2;
import defpackage.l35;
import defpackage.u35;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class SwipeDismissBehavior<V extends View> extends CoordinatorLayout.c {
    public u35 f;
    public boolean g;
    public boolean h;
    public boolean j;
    public float i = 0.0f;
    public int k = 2;
    public float l = 0.5f;
    public float m = 0.0f;
    public float n = 0.5f;
    public final u35.d o = new a();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends u35.d {
        public int a;
        public int b = -1;

        public a() {
        }

        @Override // u35.d
        public int a(View view, int i, int i2) {
            int width;
            int width2;
            int width3;
            boolean z = view.getLayoutDirection() == 1;
            int i3 = SwipeDismissBehavior.this.k;
            if (i3 == 0) {
                width = this.a;
                if (z) {
                    width -= view.getWidth();
                    width2 = this.a;
                } else {
                    width3 = view.getWidth();
                    width2 = width3 + width;
                }
            } else if (i3 == 1) {
                width = this.a;
                if (z) {
                    width3 = view.getWidth();
                    width2 = width3 + width;
                } else {
                    width -= view.getWidth();
                    width2 = this.a;
                }
            } else {
                width = this.a - view.getWidth();
                width2 = this.a + view.getWidth();
            }
            return SwipeDismissBehavior.N(width, i, width2);
        }

        @Override // u35.d
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // u35.d
        public int d(View view) {
            return view.getWidth();
        }

        @Override // u35.d
        public void i(View view, int i) {
            this.b = i;
            this.a = view.getLeft();
            ViewParent parent = view.getParent();
            if (parent != null) {
                SwipeDismissBehavior.this.h = true;
                parent.requestDisallowInterceptTouchEvent(true);
                SwipeDismissBehavior.this.h = false;
            }
        }

        @Override // u35.d
        public void j(int i) {
            SwipeDismissBehavior.this.getClass();
        }

        @Override // u35.d
        public void k(View view, int i, int i2, int i3, int i4) {
            float width = view.getWidth() * SwipeDismissBehavior.this.m;
            float width2 = view.getWidth() * SwipeDismissBehavior.this.n;
            float fAbs = Math.abs(i - this.a);
            if (fAbs <= width) {
                view.setAlpha(1.0f);
            } else if (fAbs >= width2) {
                view.setAlpha(0.0f);
            } else {
                view.setAlpha(SwipeDismissBehavior.M(0.0f, 1.0f - SwipeDismissBehavior.P(width, width2, fAbs), 1.0f));
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
        @Override // u35.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public void l(android.view.View r3, float r4, float r5) {
            /*
                r2 = this;
                r5 = -1
                r2.b = r5
                int r5 = r3.getWidth()
                boolean r0 = r2.n(r3, r4)
                if (r0 == 0) goto L23
                r0 = 0
                int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
                if (r4 < 0) goto L1d
                int r4 = r3.getLeft()
                int r0 = r2.a
                if (r4 >= r0) goto L1b
                goto L1d
            L1b:
                int r0 = r0 + r5
                goto L21
            L1d:
                int r4 = r2.a
                int r0 = r4 - r5
            L21:
                r4 = 1
                goto L26
            L23:
                int r0 = r2.a
                r4 = 0
            L26:
                com.google.android.material.behavior.SwipeDismissBehavior r5 = com.google.android.material.behavior.SwipeDismissBehavior.this
                u35 r5 = r5.f
                int r1 = r3.getTop()
                boolean r5 = r5.H(r0, r1)
                if (r5 == 0) goto L3f
                com.google.android.material.behavior.SwipeDismissBehavior$c r5 = new com.google.android.material.behavior.SwipeDismissBehavior$c
                com.google.android.material.behavior.SwipeDismissBehavior r2 = com.google.android.material.behavior.SwipeDismissBehavior.this
                r5.<init>(r3, r4)
                r3.postOnAnimation(r5)
                return
            L3f:
                if (r4 == 0) goto L46
                com.google.android.material.behavior.SwipeDismissBehavior r2 = com.google.android.material.behavior.SwipeDismissBehavior.this
                r2.getClass()
            L46:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.behavior.SwipeDismissBehavior.a.l(android.view.View, float, float):void");
        }

        @Override // u35.d
        public boolean m(View view, int i) {
            int i2 = this.b;
            return (i2 == -1 || i2 == i) && SwipeDismissBehavior.this.L(view);
        }

        public final boolean n(View view, float f) {
            if (f == 0.0f) {
                return Math.abs(view.getLeft() - this.a) >= Math.round(((float) view.getWidth()) * SwipeDismissBehavior.this.l);
            }
            boolean z = view.getLayoutDirection() == 1;
            int i = SwipeDismissBehavior.this.k;
            if (i == 2) {
                return true;
            }
            if (i == 0) {
                return z ? f < 0.0f : f > 0.0f;
            }
            if (i == 1) {
                if (z) {
                    return f > 0.0f;
                }
                if (f < 0.0f) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements j2 {
        public b() {
        }

        @Override // defpackage.j2
        public boolean a(View view, j2.a aVar) {
            if (!SwipeDismissBehavior.this.L(view)) {
                return false;
            }
            boolean z = view.getLayoutDirection() == 1;
            int i = SwipeDismissBehavior.this.k;
            l35.R(view, (!(i == 0 && z) && (i != 1 || z)) ? view.getWidth() : -view.getWidth());
            view.setAlpha(0.0f);
            SwipeDismissBehavior.this.getClass();
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements Runnable {
        public final View f;
        public final boolean g;

        public c(View view, boolean z) {
            this.f = view;
            this.g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            u35 u35Var = SwipeDismissBehavior.this.f;
            if (u35Var != null && u35Var.l(true)) {
                this.f.postOnAnimation(this);
            } else if (this.g) {
                SwipeDismissBehavior.this.getClass();
            }
        }
    }

    public static float M(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    public static int N(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    public static float P(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean J(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        if (this.f == null) {
            return false;
        }
        if (this.h && motionEvent.getActionMasked() == 3) {
            return true;
        }
        this.f.A(motionEvent);
        return true;
    }

    public boolean L(View view) {
        return true;
    }

    public final void O(ViewGroup viewGroup) {
        if (this.f == null) {
            this.f = this.j ? u35.m(viewGroup, this.i, this.o) : u35.n(viewGroup, this.o);
        }
    }

    public void Q(float f) {
        this.n = M(0.0f, f, 1.0f);
    }

    public void R(float f) {
        this.m = M(0.0f, f, 1.0f);
    }

    public void S(int i) {
        this.k = i;
    }

    public final void T(View view) {
        l35.a0(view, 1048576);
        if (L(view)) {
            l35.c0(view, g2.a.y, null, new b());
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean q(CoordinatorLayout coordinatorLayout, View view, MotionEvent motionEvent) {
        boolean zB = this.g;
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            zB = coordinatorLayout.B(view, (int) motionEvent.getX(), (int) motionEvent.getY());
            this.g = zB;
        } else if (actionMasked == 1 || actionMasked == 3) {
            this.g = false;
        }
        if (zB) {
            O(coordinatorLayout);
            if (!this.h && this.f.I(motionEvent)) {
                return true;
            }
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean r(CoordinatorLayout coordinatorLayout, View view, int i) {
        boolean zR = super.r(coordinatorLayout, view, i);
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
            T(view);
        }
        return zR;
    }
}
