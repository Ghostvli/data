package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.ContentInfo;
import android.view.Display;
import android.view.KeyEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import defpackage.g2;
import defpackage.r1;
import defpackage.r95;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l35 {
    public static WeakHashMap a;
    public static Field b;
    public static boolean c;
    public static final int[] d = {rl3.b, rl3.c, rl3.n, rl3.y, rl3.B, rl3.C, rl3.D, rl3.E, rl3.F, rl3.G, rl3.d, rl3.e, rl3.f, rl3.g, rl3.h, rl3.i, rl3.j, rl3.k, rl3.l, rl3.m, rl3.o, rl3.p, rl3.q, rl3.r, rl3.s, rl3.t, rl3.u, rl3.v, rl3.w, rl3.x, rl3.z, rl3.A};
    public static final n63 e = new n63() { // from class: k35
        @Override // defpackage.n63
        public final q20 a(q20 q20Var) {
            return l35.a(q20Var);
        }
    };
    public static final e f = new e();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends f {
        public a(int i, Class cls, int i2) {
            super(i, cls, i2);
        }

        @Override // l35.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(l.c(view));
        }

        @Override // l35.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            l.f(view, bool.booleanValue());
        }

        @Override // l35.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends f {
        public b(int i, Class cls, int i2, int i3) {
            super(i, cls, i2, i3);
        }

        @Override // l35.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return l.a(view);
        }

        @Override // l35.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            l.e(view, charSequence);
        }

        @Override // l35.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends f {
        public c(int i, Class cls, int i2, int i3) {
            super(i, cls, i2, i3);
        }

        @Override // l35.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public CharSequence c(View view) {
            return n.b(view);
        }

        @Override // l35.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, CharSequence charSequence) {
            n.c(view, charSequence);
        }

        @Override // l35.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(CharSequence charSequence, CharSequence charSequence2) {
            return !TextUtils.equals(charSequence, charSequence2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d extends f {
        public d(int i, Class cls, int i2) {
            super(i, cls, i2);
        }

        @Override // l35.f
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public Boolean c(View view) {
            return Boolean.valueOf(l.b(view));
        }

        @Override // l35.f
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public void d(View view, Boolean bool) {
            l.d(view, bool.booleanValue());
        }

        @Override // l35.f
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public boolean g(Boolean bool, Boolean bool2) {
            return !a(bool, bool2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e implements ViewTreeObserver.OnGlobalLayoutListener, View.OnAttachStateChangeListener {
        public final WeakHashMap f = new WeakHashMap();

        public void a(View view) {
            this.f.put(view, Boolean.valueOf(view.isShown() && view.getWindowVisibility() == 0));
            view.addOnAttachStateChangeListener(this);
            if (view.isAttachedToWindow()) {
                c(view);
            }
        }

        public final void b(Map.Entry entry) {
            View view = (View) entry.getKey();
            boolean zBooleanValue = ((Boolean) entry.getValue()).booleanValue();
            boolean z = view.isShown() && view.getWindowVisibility() == 0;
            if (zBooleanValue != z) {
                l35.Q(view, z ? 16 : 32);
                entry.setValue(Boolean.valueOf(z));
            }
        }

        public final void c(View view) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(this);
        }

        public void d(View view) {
            this.f.remove(view);
            view.removeOnAttachStateChangeListener(this);
            e(view);
        }

        public final void e(View view) {
            view.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (Build.VERSION.SDK_INT < 28) {
                Iterator it = this.f.entrySet().iterator();
                while (it.hasNext()) {
                    b((Map.Entry) it.next());
                }
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            c(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class g {
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            return x35.b ? x35.b(view, windowInsets) : view.dispatchApplyWindowInsets(windowInsets);
        }

        public static WindowInsets b(View view, WindowInsets windowInsets) {
            return view.onApplyWindowInsets(windowInsets);
        }

        public static void c(View view) {
            view.requestApplyInsets();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class h {

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements View.OnApplyWindowInsetsListener {
            public w95 a = null;
            public final /* synthetic */ View b;
            public final /* synthetic */ d63 c;

            public a(View view, d63 d63Var) {
                this.b = view;
                this.c = d63Var;
            }

            @Override // android.view.View.OnApplyWindowInsetsListener
            public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                w95 w95VarX = w95.x(windowInsets, view);
                int i = Build.VERSION.SDK_INT;
                if (i < 30) {
                    h.a(windowInsets, this.b);
                    if (w95VarX.equals(this.a)) {
                        return this.c.a(view, w95VarX).v();
                    }
                }
                this.a = w95VarX;
                w95 w95VarA = this.c.a(view, w95VarX);
                if (i >= 30) {
                    return w95VarA.v();
                }
                l35.d0(view);
                return w95VarA.v();
            }
        }

        public static void a(WindowInsets windowInsets, View view) {
            View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(rl3.U);
            if (onApplyWindowInsetsListener != null) {
                onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
            }
        }

        public static w95 b(View view, w95 w95Var, Rect rect) {
            WindowInsets windowInsetsV = w95Var.v();
            if (windowInsetsV != null) {
                return w95.x(view.computeSystemWindowInsets(windowInsetsV, rect), view);
            }
            rect.setEmpty();
            return w95Var;
        }

        public static ColorStateList c(View view) {
            return view.getBackgroundTintList();
        }

        public static PorterDuff.Mode d(View view) {
            return view.getBackgroundTintMode();
        }

        public static String e(View view) {
            return view.getTransitionName();
        }

        public static float f(View view) {
            return view.getTranslationZ();
        }

        public static float g(View view) {
            return view.getZ();
        }

        public static boolean h(View view) {
            return view.isNestedScrollingEnabled();
        }

        public static void i(View view, ColorStateList colorStateList) {
            view.setBackgroundTintList(colorStateList);
        }

        public static void j(View view, PorterDuff.Mode mode) {
            view.setBackgroundTintMode(mode);
        }

        public static void k(View view, float f) {
            view.setElevation(f);
        }

        public static void l(View view, d63 d63Var) {
            a aVar = d63Var != null ? new a(view, d63Var) : null;
            if (Build.VERSION.SDK_INT < 30) {
                view.setTag(rl3.M, aVar);
            }
            if (view.getTag(rl3.L) != null) {
                return;
            }
            if (aVar != null) {
                view.setOnApplyWindowInsetsListener(aVar);
            } else {
                view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(rl3.U));
            }
        }

        public static void m(View view, String str) {
            view.setTransitionName(str);
        }

        public static void n(View view, float f) {
            view.setTranslationZ(f);
        }

        public static void o(View view, float f) {
            view.setZ(f);
        }

        public static void p(View view) {
            view.stopNestedScroll();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class i {
        public static w95 a(View view) {
            WindowInsets rootWindowInsets = view.getRootWindowInsets();
            if (rootWindowInsets == null) {
                return null;
            }
            w95 w95VarW = w95.w(rootWindowInsets);
            w95VarW.s(w95VarW);
            w95VarW.d(view.getRootView());
            return w95VarW;
        }

        public static void b(View view, int i, int i2) {
            view.setScrollIndicators(i, i2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class j {
        public static void a(View view, PointerIcon pointerIcon) {
            view.setPointerIcon(pointerIcon);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class k {
        public static int a(View view) {
            return view.getImportantForAutofill();
        }

        public static void b(View view, int i) {
            view.setImportantForAutofill(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class l {
        public static CharSequence a(View view) {
            return view.getAccessibilityPaneTitle();
        }

        public static boolean b(View view) {
            return view.isAccessibilityHeading();
        }

        public static boolean c(View view) {
            return view.isScreenReaderFocusable();
        }

        public static void d(View view, boolean z) {
            view.setAccessibilityHeading(z);
        }

        public static void e(View view, CharSequence charSequence) {
            view.setAccessibilityPaneTitle(charSequence);
        }

        public static void f(View view, boolean z) {
            view.setScreenReaderFocusable(z);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class m {
        public static View.AccessibilityDelegate a(View view) {
            return view.getAccessibilityDelegate();
        }

        public static void b(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i, int i2) {
            view.saveAttributeDataForStyleable(context, iArr, attributeSet, typedArray, i, i2);
        }

        public static void c(View view, List<Rect> list) {
            view.setSystemGestureExclusionRects(list);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class n {
        public static WindowInsets a(View view, WindowInsets windowInsets) {
            return view.dispatchApplyWindowInsets(windowInsets);
        }

        public static CharSequence b(View view) {
            return view.getStateDescription();
        }

        public static void c(View view, CharSequence charSequence) {
            view.setStateDescription(charSequence);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class o {
        public static String[] a(View view) {
            return view.getReceiveContentMimeTypes();
        }

        public static q20 b(View view, q20 q20Var) {
            ContentInfo contentInfoF = q20Var.f();
            ContentInfo contentInfoPerformReceiveContent = view.performReceiveContent(contentInfoF);
            if (contentInfoPerformReceiveContent == null) {
                return null;
            }
            return contentInfoPerformReceiveContent == contentInfoF ? q20Var : q20.g(contentInfoPerformReceiveContent);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class p {
        public static final ArrayList d = new ArrayList();
        public WeakHashMap a = null;
        public SparseArray b = null;
        public WeakReference c = null;

        public static p a(View view) {
            p pVar = (p) view.getTag(rl3.S);
            if (pVar != null) {
                return pVar;
            }
            p pVar2 = new p();
            view.setTag(rl3.S, pVar2);
            return pVar2;
        }

        public boolean b(View view, KeyEvent keyEvent) {
            if (keyEvent.getAction() == 0) {
                g();
            }
            View viewC = c(view, keyEvent);
            if (keyEvent.getAction() == 0) {
                int keyCode = keyEvent.getKeyCode();
                if (viewC != null && !KeyEvent.isModifierKey(keyCode)) {
                    d().put(keyCode, new WeakReference(viewC));
                }
            }
            return viewC != null;
        }

        public final View c(View view, KeyEvent keyEvent) {
            WeakHashMap weakHashMap = this.a;
            if (weakHashMap != null && weakHashMap.containsKey(view)) {
                if (view instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                        View viewC = c(viewGroup.getChildAt(childCount), keyEvent);
                        if (viewC != null) {
                            return viewC;
                        }
                    }
                }
                if (e(view, keyEvent)) {
                    return view;
                }
            }
            return null;
        }

        public final SparseArray d() {
            if (this.b == null) {
                this.b = new SparseArray();
            }
            return this.b;
        }

        public final boolean e(View view, KeyEvent keyEvent) {
            int size;
            ArrayList arrayList = (ArrayList) view.getTag(rl3.T);
            if (arrayList == null || arrayList.size() - 1 < 0) {
                return false;
            }
            w82.a(arrayList.get(size));
            throw null;
        }

        public boolean f(KeyEvent keyEvent) {
            WeakReference weakReference;
            int iIndexOfKey;
            WeakReference weakReference2 = this.c;
            if (weakReference2 != null && weakReference2.get() == keyEvent) {
                return false;
            }
            this.c = new WeakReference(keyEvent);
            SparseArray sparseArrayD = d();
            if (keyEvent.getAction() != 1 || (iIndexOfKey = sparseArrayD.indexOfKey(keyEvent.getKeyCode())) < 0) {
                weakReference = null;
            } else {
                weakReference = (WeakReference) sparseArrayD.valueAt(iIndexOfKey);
                sparseArrayD.removeAt(iIndexOfKey);
            }
            if (weakReference == null) {
                weakReference = (WeakReference) sparseArrayD.get(keyEvent.getKeyCode());
            }
            if (weakReference == null) {
                return false;
            }
            View view = (View) weakReference.get();
            if (view != null && view.isAttachedToWindow()) {
                e(view, keyEvent);
            }
            return true;
        }

        public final void g() {
            WeakHashMap weakHashMap = this.a;
            if (weakHashMap != null) {
                weakHashMap.clear();
            }
            ArrayList arrayList = d;
            if (arrayList.isEmpty()) {
                return;
            }
            synchronized (arrayList) {
                try {
                    if (this.a == null) {
                        this.a = new WeakHashMap();
                    }
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        ArrayList arrayList2 = d;
                        View view = (View) ((WeakReference) arrayList2.get(size)).get();
                        if (view == null) {
                            arrayList2.remove(size);
                        } else {
                            this.a.put(view, Boolean.TRUE);
                            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                                this.a.put((View) parent, Boolean.TRUE);
                            }
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static String[] A(View view) {
        return Build.VERSION.SDK_INT >= 31 ? o.a(view) : (String[]) view.getTag(rl3.O);
    }

    public static void A0(View view) {
        h.p(view);
    }

    public static int B(View view) {
        return view.getPaddingEnd();
    }

    public static int C(View view) {
        return view.getPaddingStart();
    }

    public static w95 D(View view) {
        return i.a(view);
    }

    public static CharSequence E(View view) {
        return (CharSequence) z0().e(view);
    }

    public static String F(View view) {
        return h.e(view);
    }

    public static float G(View view) {
        return h.f(view);
    }

    public static int H(View view) {
        return view.getWindowSystemUiVisibility();
    }

    public static float I(View view) {
        return h.g(view);
    }

    public static boolean J(View view) {
        return l(view) != null;
    }

    public static boolean K(View view) {
        return view.hasTransientState();
    }

    public static boolean L(View view) {
        Boolean bool = (Boolean) b().e(view);
        return bool != null && bool.booleanValue();
    }

    public static boolean M(View view) {
        return view.isAttachedToWindow();
    }

    public static boolean N(View view) {
        return view.isLaidOut();
    }

    public static boolean O(View view) {
        return h.h(view);
    }

    public static boolean P(View view) {
        Boolean bool = (Boolean) f0().e(view);
        return bool != null && bool.booleanValue();
    }

    public static void Q(View view, int i2) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) view.getContext().getSystemService("accessibility");
        if (accessibilityManager.isEnabled()) {
            boolean z = n(view) != null && view.isShown() && view.getWindowVisibility() == 0;
            if (view.getAccessibilityLiveRegion() != 0 || z) {
                AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                accessibilityEventObtain.setEventType(z ? 32 : 2048);
                accessibilityEventObtain.setContentChangeTypes(i2);
                if (z) {
                    accessibilityEventObtain.getText().add(n(view));
                    n0(view);
                }
                view.sendAccessibilityEventUnchecked(accessibilityEventObtain);
                return;
            }
            if (i2 != 32) {
                if (view.getParent() != null) {
                    try {
                        view.getParent().notifySubtreeAccessibilityStateChanged(view, view, i2);
                        return;
                    } catch (AbstractMethodError e2) {
                        Log.e("ViewCompat", view.getParent().getClass().getSimpleName().concat(" does not fully implement ViewParent"), e2);
                        return;
                    }
                }
                return;
            }
            AccessibilityEvent accessibilityEventObtain2 = AccessibilityEvent.obtain();
            view.onInitializeAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.setEventType(32);
            accessibilityEventObtain2.setContentChangeTypes(i2);
            accessibilityEventObtain2.setSource(view);
            view.onPopulateAccessibilityEvent(accessibilityEventObtain2);
            accessibilityEventObtain2.getText().add(n(view));
            accessibilityManager.sendAccessibilityEvent(accessibilityEventObtain2);
        }
    }

    public static void R(View view, int i2) {
        view.offsetLeftAndRight(i2);
    }

    public static void S(View view, int i2) {
        view.offsetTopAndBottom(i2);
    }

    public static w95 T(View view, w95 w95Var) {
        WindowInsets windowInsetsV = w95Var.v();
        if (windowInsetsV != null) {
            WindowInsets windowInsetsB = g.b(view, windowInsetsV);
            if (!windowInsetsB.equals(windowInsetsV)) {
                return w95.x(windowInsetsB, view);
            }
        }
        return w95Var;
    }

    public static void U(View view, g2 g2Var) {
        view.onInitializeAccessibilityNodeInfo(g2Var.O0());
    }

    public static f V() {
        return new b(rl3.K, CharSequence.class, 8, 28);
    }

    public static q20 W(View view, q20 q20Var) {
        if (Log.isLoggable("ViewCompat", 3)) {
            Log.d("ViewCompat", "performReceiveContent: " + q20Var + ", view=" + view.getClass().getSimpleName() + "[" + view.getId() + "]");
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return o.b(view, q20Var);
        }
        m63 m63Var = (m63) view.getTag(rl3.N);
        if (m63Var == null) {
            return t(view).a(q20Var);
        }
        q20 q20VarA = m63Var.a(view, q20Var);
        if (q20VarA == null) {
            return null;
        }
        return t(view).a(q20VarA);
    }

    public static void X(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void Y(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void Z(View view, Runnable runnable, long j2) {
        view.postOnAnimationDelayed(runnable, j2);
    }

    public static /* synthetic */ q20 a(q20 q20Var) {
        return q20Var;
    }

    public static void a0(View view, int i2) {
        b0(i2, view);
        Q(view, 0);
    }

    public static f b() {
        return new d(rl3.J, Boolean.class, 28);
    }

    public static void b0(int i2, View view) {
        List listO = o(view);
        for (int i3 = 0; i3 < listO.size(); i3++) {
            if (((g2.a) listO.get(i3)).b() == i2) {
                listO.remove(i3);
                return;
            }
        }
    }

    public static int c(View view, CharSequence charSequence, j2 j2Var) {
        int iP = p(view, charSequence);
        if (iP != -1) {
            d(view, new g2.a(iP, charSequence, j2Var));
        }
        return iP;
    }

    public static void c0(View view, g2.a aVar, CharSequence charSequence, j2 j2Var) {
        if (j2Var == null && charSequence == null) {
            a0(view, aVar.b());
        } else {
            d(view, aVar.a(charSequence, j2Var));
        }
    }

    public static void d(View view, g2.a aVar) {
        j(view);
        b0(aVar.b(), view);
        o(view).add(aVar);
        Q(view, 0);
    }

    public static void d0(View view) {
        g.c(view);
    }

    public static s45 e(View view) {
        if (a == null) {
            a = new WeakHashMap();
        }
        s45 s45Var = (s45) a.get(view);
        if (s45Var != null) {
            return s45Var;
        }
        s45 s45Var2 = new s45(view);
        a.put(view, s45Var2);
        return s45Var2;
    }

    public static void e0(View view, Context context, int[] iArr, AttributeSet attributeSet, TypedArray typedArray, int i2, int i3) {
        if (Build.VERSION.SDK_INT >= 29) {
            m.b(view, context, iArr, attributeSet, typedArray, i2, i3);
        }
    }

    public static w95 f(View view, w95 w95Var, Rect rect) {
        return h.b(view, w95Var, rect);
    }

    public static f f0() {
        return new a(rl3.P, Boolean.class, 28);
    }

    public static w95 g(View view, w95 w95Var) {
        WindowInsets windowInsetsV = w95Var.v();
        if (windowInsetsV != null) {
            WindowInsets windowInsetsA = Build.VERSION.SDK_INT >= 30 ? n.a(view, windowInsetsV) : g.a(view, windowInsetsV);
            if (!windowInsetsA.equals(windowInsetsV)) {
                return w95.x(windowInsetsA, view);
            }
        }
        return w95Var;
    }

    public static void g0(View view, r1 r1Var) {
        if (r1Var == null && (l(view) instanceof r1.a)) {
            r1Var = new r1();
        }
        n0(view);
        view.setAccessibilityDelegate(r1Var == null ? null : r1Var.d());
    }

    public static boolean h(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return p.a(view).b(view, keyEvent);
    }

    public static void h0(View view, boolean z) {
        b().f(view, Boolean.valueOf(z));
    }

    public static boolean i(View view, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 28) {
            return false;
        }
        return p.a(view).f(keyEvent);
    }

    public static void i0(View view, CharSequence charSequence) {
        V().f(view, charSequence);
        if (charSequence != null) {
            f.a(view);
        } else {
            f.d(view);
        }
    }

    public static void j(View view) {
        r1 r1VarK = k(view);
        if (r1VarK == null) {
            r1VarK = new r1();
        }
        g0(view, r1VarK);
    }

    public static void j0(View view, ColorStateList colorStateList) {
        h.i(view, colorStateList);
    }

    public static r1 k(View view) {
        View.AccessibilityDelegate accessibilityDelegateL = l(view);
        if (accessibilityDelegateL == null) {
            return null;
        }
        return accessibilityDelegateL instanceof r1.a ? ((r1.a) accessibilityDelegateL).a : new r1(accessibilityDelegateL);
    }

    public static void k0(View view, PorterDuff.Mode mode) {
        h.j(view, mode);
    }

    public static View.AccessibilityDelegate l(View view) {
        return Build.VERSION.SDK_INT >= 29 ? m.a(view) : m(view);
    }

    public static void l0(View view, float f2) {
        h.k(view, f2);
    }

    public static View.AccessibilityDelegate m(View view) {
        if (c) {
            return null;
        }
        if (b == null) {
            try {
                Field declaredField = View.class.getDeclaredField("mAccessibilityDelegate");
                b = declaredField;
                declaredField.setAccessible(true);
            } catch (Throwable unused) {
                c = true;
                return null;
            }
        }
        try {
            Object obj = b.get(view);
            if (obj instanceof View.AccessibilityDelegate) {
                return (View.AccessibilityDelegate) obj;
            }
            return null;
        } catch (Throwable unused2) {
            c = true;
            return null;
        }
    }

    public static void m0(View view, int i2) {
        view.setImportantForAccessibility(i2);
    }

    public static CharSequence n(View view) {
        return (CharSequence) V().e(view);
    }

    public static void n0(View view) {
        if (view.getImportantForAccessibility() == 0) {
            view.setImportantForAccessibility(1);
        }
    }

    public static List o(View view) {
        ArrayList arrayList = (ArrayList) view.getTag(rl3.H);
        if (arrayList != null) {
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        view.setTag(rl3.H, arrayList2);
        return arrayList2;
    }

    public static void o0(View view, int i2) {
        if (Build.VERSION.SDK_INT >= 26) {
            k.b(view, i2);
        }
    }

    public static int p(View view, CharSequence charSequence) {
        List listO = o(view);
        for (int i2 = 0; i2 < listO.size(); i2++) {
            if (TextUtils.equals(charSequence, ((g2.a) listO.get(i2)).c())) {
                return ((g2.a) listO.get(i2)).b();
            }
        }
        int i3 = -1;
        int i4 = 0;
        while (true) {
            int[] iArr = d;
            if (i4 >= iArr.length || i3 != -1) {
                break;
            }
            int i5 = iArr[i4];
            boolean z = true;
            for (int i6 = 0; i6 < listO.size(); i6++) {
                z &= ((g2.a) listO.get(i6)).b() != i5;
            }
            if (z) {
                i3 = i5;
            }
            i4++;
        }
        return i3;
    }

    public static void p0(View view, d63 d63Var) {
        h.l(view, d63Var);
    }

    public static ColorStateList q(View view) {
        return h.c(view);
    }

    public static void q0(View view, gf3 gf3Var) {
        j.a(view, (PointerIcon) (gf3Var != null ? gf3Var.a() : null));
    }

    public static PorterDuff.Mode r(View view) {
        return h.d(view);
    }

    public static void r0(View view, boolean z) {
        f0().f(view, Boolean.valueOf(z));
    }

    public static Display s(View view) {
        return view.getDisplay();
    }

    public static void s0(View view, int i2, int i3) {
        i.b(view, i2, i3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static n63 t(View view) {
        return view instanceof n63 ? (n63) view : e;
    }

    public static void t0(View view, CharSequence charSequence) {
        z0().f(view, charSequence);
    }

    public static boolean u(View view) {
        return view.getFitsSystemWindows();
    }

    public static void u0(View view, List list) {
        if (Build.VERSION.SDK_INT >= 29) {
            m.c(view, list);
        }
    }

    public static int v(View view) {
        return view.getImportantForAccessibility();
    }

    public static void v0(View view, String str) {
        h.m(view, str);
    }

    public static int w(View view) {
        if (Build.VERSION.SDK_INT >= 26) {
            return k.a(view);
        }
        return 0;
    }

    public static void w0(View view, float f2) {
        h.n(view, f2);
    }

    public static int x(View view) {
        return view.getLayoutDirection();
    }

    public static void x0(View view, r95.b bVar) {
        r95.e(view, bVar);
    }

    public static int y(View view) {
        return view.getMinimumHeight();
    }

    public static void y0(View view, float f2) {
        h.o(view, f2);
    }

    public static int z(View view) {
        return view.getMinimumWidth();
    }

    public static f z0() {
        return new c(rl3.Q, CharSequence.class, 64, 30);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class f {
        public final int a;
        public final Class b;
        public final int c;
        public final int d;

        public f(int i, Class cls, int i2, int i3) {
            this.a = i;
            this.b = cls;
            this.d = i2;
            this.c = i3;
        }

        public boolean a(Boolean bool, Boolean bool2) {
            return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
        }

        public final boolean b() {
            return Build.VERSION.SDK_INT >= this.c;
        }

        public abstract Object c(View view);

        public abstract void d(View view, Object obj);

        public Object e(View view) {
            if (b()) {
                return c(view);
            }
            Object tag = view.getTag(this.a);
            if (this.b.isInstance(tag)) {
                return tag;
            }
            return null;
        }

        public void f(View view, Object obj) {
            if (b()) {
                d(view, obj);
            } else if (g(e(view), obj)) {
                l35.j(view);
                view.setTag(this.a, obj);
                l35.Q(view, this.d);
            }
        }

        public abstract boolean g(Object obj, Object obj2);

        public f(int i, Class cls, int i2) {
            this(i, cls, 0, i2);
        }
    }
}
