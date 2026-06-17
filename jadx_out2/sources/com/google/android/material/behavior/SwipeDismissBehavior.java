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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // u35.d
        public int b(View view, int i, int i2) {
            return view.getTop();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // u35.d
        public int d(View view) {
            return view.getWidth();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // u35.d
        public void j(int i) {
            SwipeDismissBehavior.this.getClass();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Removed duplicated region for block: B:10:0x001d  */
        @Override // u35.d
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void l(View view, float f, float f2) {
            int i;
            boolean z;
            this.b = -1;
            int width = view.getWidth();
            if (!n(view, f)) {
                i = this.a;
                z = false;
            } else if (f >= 0.0f) {
                int left = view.getLeft();
                int i2 = this.a;
                i = left < i2 ? this.a - width : i2 + width;
                z = true;
            }
            if (SwipeDismissBehavior.this.f.H(i, view.getTop())) {
                view.postOnAnimation(new c(view, z));
            } else if (z) {
                SwipeDismissBehavior.this.getClass();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // u35.d
        public boolean m(View view, int i) {
            int i2 = this.b;
            return (i2 == -1 || i2 == i) && SwipeDismissBehavior.this.L(view);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(View view, boolean z) {
            this.f = view;
            this.g = z;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static float M(float f, float f2, float f3) {
        return Math.min(Math.max(f, f2), f3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int N(int i, int i2, int i3) {
        return Math.min(Math.max(i, i2), i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static float P(float f, float f2, float f3) {
        return (f3 - f) / (f2 - f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean L(View view) {
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void O(ViewGroup viewGroup) {
        if (this.f == null) {
            this.f = this.j ? u35.m(viewGroup, this.i, this.o) : u35.n(viewGroup, this.o);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Q(float f) {
        this.n = M(0.0f, f, 1.0f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void R(float f) {
        this.m = M(0.0f, f, 1.0f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void S(int i) {
        this.k = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void T(View view) {
        l35.a0(view, 1048576);
        if (L(view)) {
            l35.c0(view, g2.a.y, null, new b());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
