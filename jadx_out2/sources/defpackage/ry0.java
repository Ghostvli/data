package defpackage;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.s31;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ry0 extends r1 {
    public static final Rect n = new Rect(Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE);
    public static final s31.a o = new a();
    public static final s31.b p = new b();
    public final AccessibilityManager h;
    public final View i;
    public c j;
    public final Rect d = new Rect();
    public final Rect e = new Rect();
    public final Rect f = new Rect();
    public final int[] g = new int[2];
    public int k = Integer.MIN_VALUE;
    public int l = Integer.MIN_VALUE;
    public int m = Integer.MIN_VALUE;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements s31.a {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;Landroid/graphics/Rect;)V */
        @Override // s31.a
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(g2 g2Var, Rect rect) {
            g2Var.m(rect);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements s31.b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;I)Ljava/lang/Object; */
        @Override // s31.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public g2 a(mb4 mb4Var, int i) {
            return (g2) mb4Var.i(i);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: b(Ljava/lang/Object;)I */
        @Override // s31.b
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public int b(mb4 mb4Var) {
            return mb4Var.h();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends h2 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.h2
        public g2 b(int i) {
            return g2.Z(ry0.this.J(i));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.h2
        public g2 d(int i) {
            ry0 ry0Var = ry0.this;
            int i2 = i == 2 ? ry0Var.k : ry0Var.l;
            if (i2 == Integer.MIN_VALUE) {
                return null;
            }
            return b(i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.h2
        public boolean f(int i, int i2, Bundle bundle) {
            return ry0.this.R(i, i2, bundle);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ry0(View view) {
        if (view == null) {
            jl.a("View may not be null");
            throw null;
        }
        this.i = view;
        this.h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        view.setFocusable(true);
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Rect D(View view, int i, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i == 17) {
            rect.set(width, 0, width, height);
            return rect;
        }
        if (i == 33) {
            rect.set(0, height, width, height);
            return rect;
        }
        if (i == 66) {
            rect.set(-1, 0, -1, height);
            return rect;
        }
        if (i == 130) {
            rect.set(0, -1, width, -1);
            return rect;
        }
        jl.a("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int H(int i) {
        if (i == 19) {
            return 33;
        }
        if (i != 21) {
            return i != 22 ? 130 : 66;
        }
        return 17;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int A() {
        return this.l;
    }

    public abstract int B(float f, float f2);

    public abstract void C(List list);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void E(int i) {
        F(i, 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.h.isEnabled() || (parent = this.i.getParent()) == null) {
            return;
        }
        AccessibilityEvent accessibilityEventQ = q(i, 2048);
        s1.b(accessibilityEventQ, i2);
        parent.requestSendAccessibilityEvent(this.i, accessibilityEventQ);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean G(Rect rect) {
        if (rect == null || rect.isEmpty() || this.i.getWindowVisibility() != 0) {
            return false;
        }
        Object parent = this.i.getParent();
        while (parent instanceof View) {
            View view = (View) parent;
            if (view.getAlpha() <= 0.0f || view.getVisibility() != 0) {
                return false;
            }
            parent = view.getParent();
        }
        return parent != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean I(int i, Rect rect) {
        g2 g2Var;
        mb4 mb4VarY = y();
        int i2 = this.l;
        g2 g2Var2 = i2 == Integer.MIN_VALUE ? null : (g2) mb4VarY.d(i2);
        if (i == 1 || i == 2) {
            g2Var = (g2) s31.d(mb4VarY, p, o, g2Var2, i, this.i.getLayoutDirection() == 1, false);
        } else {
            if (i != 17 && i != 33 && i != 66 && i != 130) {
                jl.a("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                return false;
            }
            Rect rect2 = new Rect();
            int i3 = this.l;
            if (i3 != Integer.MIN_VALUE) {
                z(i3, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                D(this.i, i, rect2);
            }
            g2Var = (g2) s31.c(mb4VarY, p, o, g2Var2, rect2, i);
        }
        return V(g2Var != null ? mb4VarY.f(mb4VarY.e(g2Var)) : Integer.MIN_VALUE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g2 J(int i) {
        return i == -1 ? u() : t(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void K(boolean z, int i, Rect rect) {
        int i2 = this.l;
        if (i2 != Integer.MIN_VALUE) {
            o(i2);
        }
        if (z) {
            I(i, rect);
        }
    }

    public abstract boolean L(int i, int i2, Bundle bundle);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void M(AccessibilityEvent accessibilityEvent) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void N(int i, AccessibilityEvent accessibilityEvent) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void O(g2 g2Var) {
    }

    public abstract void P(int i, g2 g2Var);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Q(int i, boolean z) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean R(int i, int i2, Bundle bundle) {
        return i != -1 ? S(i, i2, bundle) : T(i2, bundle);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean S(int i, int i2, Bundle bundle) {
        return i2 != 1 ? i2 != 2 ? i2 != 64 ? i2 != 128 ? L(i, i2, bundle) : n(i) : U(i) : o(i) : V(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean T(int i, Bundle bundle) {
        return this.i.performAccessibilityAction(i, bundle);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean U(int i) {
        int i2;
        if (!this.h.isEnabled() || !this.h.isTouchExplorationEnabled() || (i2 = this.k) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            n(i2);
        }
        this.k = i;
        this.i.invalidate();
        W(i, 32768);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean V(int i) {
        int i2;
        if ((!this.i.isFocused() && !this.i.requestFocus()) || (i2 = this.l) == i) {
            return false;
        }
        if (i2 != Integer.MIN_VALUE) {
            o(i2);
        }
        if (i == Integer.MIN_VALUE) {
            return false;
        }
        this.l = i;
        Q(i, true);
        W(i, 8);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean W(int i, int i2) {
        ViewParent parent;
        if (i == Integer.MIN_VALUE || !this.h.isEnabled() || (parent = this.i.getParent()) == null) {
            return false;
        }
        return parent.requestSendAccessibilityEvent(this.i, q(i, i2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void X(g2 g2Var, Rect rect) {
        g2Var.h0(rect);
        Rect rect2 = new Rect();
        rect2.set(rect);
        if (g2Var.b != -1) {
            g2 g2VarY = g2.Y();
            Rect rect3 = new Rect();
            for (int i = g2Var.b; i != -1; i = g2VarY.b) {
                g2VarY.D0(this.i, -1);
                g2VarY.h0(n);
                P(i, g2VarY);
                g2VarY.l(rect3);
                rect2.offset(rect3.left, rect3.top);
            }
            g2VarY.c0();
        }
        this.i.getLocationOnScreen(this.g);
        rect2.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
        g2Var.i0(rect2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Y(int i) {
        int i2 = this.m;
        if (i2 == i) {
            return;
        }
        this.m = i;
        W(i, 128);
        W(i2, Buffer.DEFAULT_SIZE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.r1
    public h2 b(View view) {
        if (this.j == null) {
            this.j = new c();
        }
        return this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.r1
    public void f(View view, AccessibilityEvent accessibilityEvent) {
        super.f(view, accessibilityEvent);
        M(accessibilityEvent);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.r1
    public void g(View view, g2 g2Var) {
        super.g(view, g2Var);
        O(g2Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean n(int i) {
        if (this.k != i) {
            return false;
        }
        this.k = Integer.MIN_VALUE;
        this.i.invalidate();
        W(i, 65536);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean o(int i) {
        if (this.l != i) {
            return false;
        }
        this.l = Integer.MIN_VALUE;
        Q(i, false);
        W(i, 8);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean p() {
        int i = this.l;
        return i != Integer.MIN_VALUE && L(i, 16, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final AccessibilityEvent q(int i, int i2) {
        return i != -1 ? r(i, i2) : s(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final AccessibilityEvent r(int i, int i2) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i2);
        g2 g2VarJ = J(i);
        accessibilityEventObtain.getText().add(g2VarJ.A());
        accessibilityEventObtain.setContentDescription(g2VarJ.s());
        accessibilityEventObtain.setScrollable(g2VarJ.T());
        accessibilityEventObtain.setPassword(g2VarJ.S());
        accessibilityEventObtain.setEnabled(g2VarJ.L());
        accessibilityEventObtain.setChecked(g2VarJ.I());
        N(i, accessibilityEventObtain);
        if (accessibilityEventObtain.getText().isEmpty() && accessibilityEventObtain.getContentDescription() == null) {
            zt2.a("Callbacks must add text or a content description in populateEventForVirtualViewId()");
            return null;
        }
        accessibilityEventObtain.setClassName(g2VarJ.p());
        i2.c(accessibilityEventObtain, this.i, i);
        accessibilityEventObtain.setPackageName(this.i.getContext().getPackageName());
        return accessibilityEventObtain;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final AccessibilityEvent s(int i) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(i);
        this.i.onInitializeAccessibilityEvent(accessibilityEventObtain);
        return accessibilityEventObtain;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final g2 t(int i) {
        g2 g2VarY = g2.Y();
        g2VarY.r0(true);
        g2VarY.t0(true);
        g2VarY.l0("android.view.View");
        Rect rect = n;
        g2VarY.h0(rect);
        g2VarY.i0(rect);
        g2VarY.C0(this.i);
        P(i, g2VarY);
        if (g2VarY.A() == null && g2VarY.s() == null) {
            zt2.a("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
            return null;
        }
        g2VarY.l(this.e);
        g2VarY.m(this.d);
        if (this.e.equals(rect) && this.d.equals(rect)) {
            zt2.a("Callbacks must set parent bounds or screen bounds in populateNodeForVirtualViewId()");
            return null;
        }
        int iJ = g2VarY.j();
        if ((iJ & 64) != 0) {
            zt2.a("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            return null;
        }
        if ((iJ & 128) != 0) {
            zt2.a("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            return null;
        }
        g2VarY.A0(this.i.getContext().getPackageName());
        g2VarY.J0(this.i, i);
        if (this.k == i) {
            g2VarY.f0(true);
            g2VarY.a(128);
        } else {
            g2VarY.f0(false);
            g2VarY.a(64);
        }
        boolean z = this.l == i;
        if (z) {
            g2VarY.a(2);
        } else if (g2VarY.N()) {
            g2VarY.a(1);
        }
        g2VarY.u0(z);
        this.i.getLocationOnScreen(this.g);
        if (this.d.equals(rect)) {
            X(g2VarY, this.e);
            g2VarY.m(this.d);
        }
        if (this.i.getLocalVisibleRect(this.f)) {
            this.f.offset(this.g[0] - this.i.getScrollX(), this.g[1] - this.i.getScrollY());
            if (this.d.intersect(this.f)) {
                g2VarY.i0(this.d);
                if (G(this.d)) {
                    g2VarY.N0(true);
                }
            }
        }
        return g2VarY;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final g2 u() {
        g2 g2VarA0 = g2.a0(this.i);
        l35.U(this.i, g2VarA0);
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        if (g2VarA0.o() > 0 && arrayList.size() > 0) {
            zt2.a("Views cannot have both real and virtual children");
            return null;
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            g2VarA0.c(this.i, ((Integer) arrayList.get(i)).intValue());
        }
        return g2VarA0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean v(MotionEvent motionEvent) {
        if (this.h.isEnabled() && this.h.isTouchExplorationEnabled()) {
            int action = motionEvent.getAction();
            if (action != 7 && action != 9) {
                if (action != 10 || this.m == Integer.MIN_VALUE) {
                    return false;
                }
                Y(Integer.MIN_VALUE);
                return true;
            }
            int iB = B(motionEvent.getX(), motionEvent.getY());
            Y(iB);
            if (iB != Integer.MIN_VALUE) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean w(KeyEvent keyEvent) {
        int i = 0;
        if (keyEvent.getAction() != 1) {
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 61) {
                if (keyCode != 66) {
                    switch (keyCode) {
                        case 19:
                        case 20:
                        case 21:
                        case 22:
                            if (keyEvent.hasNoModifiers()) {
                                int iH = H(keyCode);
                                int repeatCount = keyEvent.getRepeatCount() + 1;
                                boolean z = false;
                                while (i < repeatCount && I(iH, null)) {
                                    i++;
                                    z = true;
                                }
                                return z;
                            }
                            break;
                        case 23:
                            if (keyEvent.hasNoModifiers() && keyEvent.getRepeatCount() == 0) {
                                p();
                                return true;
                            }
                            break;
                    }
                }
            } else {
                if (keyEvent.hasNoModifiers()) {
                    return I(2, null);
                }
                if (keyEvent.hasModifiers(1)) {
                    return I(1, null);
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int x() {
        return this.k;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final mb4 y() {
        ArrayList arrayList = new ArrayList();
        C(arrayList);
        mb4 mb4Var = new mb4();
        for (int i = 0; i < arrayList.size(); i++) {
            mb4Var.g(((Integer) arrayList.get(i)).intValue(), t(((Integer) arrayList.get(i)).intValue()));
        }
        return mb4Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void z(int i, Rect rect) {
        J(i).m(rect);
    }
}
