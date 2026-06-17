package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import com.hierynomus.protocol.commons.buffer.Buffer;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class iu1 implements n64 {
    public static Method L;
    public static Method M;
    public AdapterView.OnItemSelectedListener A;
    public final i B;
    public final h C;
    public final g D;
    public final e E;
    public Runnable F;
    public final Handler G;
    public final Rect H;
    public Rect I;
    public boolean J;
    public PopupWindow K;
    public Context f;
    public ListAdapter g;
    public bp0 h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public int q;
    public boolean r;
    public boolean s;
    public int t;
    public View u;
    public int v;
    public DataSetObserver w;
    public View x;
    public Drawable y;
    public AdapterView.OnItemClickListener z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            View viewT = iu1.this.t();
            if (viewT == null || viewT.getWindowToken() == null) {
                return;
            }
            iu1.this.h();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements AdapterView.OnItemSelectedListener {
        public b() {
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onItemSelected(AdapterView adapterView, View view, int i, long j) {
            bp0 bp0Var;
            if (i == -1 || (bp0Var = iu1.this.h) == null) {
                return;
            }
            bp0Var.setListSelectionHidden(false);
        }

        @Override // android.widget.AdapterView.OnItemSelectedListener
        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public static int a(PopupWindow popupWindow, View view, int i, boolean z) {
            return popupWindow.getMaxAvailableHeight(view, i, z);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d {
        public static void a(PopupWindow popupWindow, Rect rect) {
            popupWindow.setEpicenterBounds(rect);
        }

        public static void b(PopupWindow popupWindow, boolean z) {
            popupWindow.setIsClippedToScreen(z);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            iu1.this.r();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class f extends DataSetObserver {
        public f() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            if (iu1.this.a()) {
                iu1.this.h();
            }
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            iu1.this.dismiss();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class g implements AbsListView.OnScrollListener {
        public g() {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        @Override // android.widget.AbsListView.OnScrollListener
        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i != 1 || iu1.this.A() || iu1.this.K.getContentView() == null) {
                return;
            }
            iu1 iu1Var = iu1.this;
            iu1Var.G.removeCallbacks(iu1Var.B);
            iu1.this.B.run();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class h implements View.OnTouchListener {
        public h() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            PopupWindow popupWindow;
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && (popupWindow = iu1.this.K) != null && popupWindow.isShowing() && x >= 0 && x < iu1.this.K.getWidth() && y >= 0 && y < iu1.this.K.getHeight()) {
                iu1 iu1Var = iu1.this;
                iu1Var.G.postDelayed(iu1Var.B, 250L);
                return false;
            }
            if (action != 1) {
                return false;
            }
            iu1 iu1Var2 = iu1.this;
            iu1Var2.G.removeCallbacks(iu1Var2.B);
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class i implements Runnable {
        public i() {
        }

        @Override // java.lang.Runnable
        public void run() {
            bp0 bp0Var = iu1.this.h;
            if (bp0Var == null || !bp0Var.isAttachedToWindow() || iu1.this.h.getCount() <= iu1.this.h.getChildCount()) {
                return;
            }
            int childCount = iu1.this.h.getChildCount();
            iu1 iu1Var = iu1.this;
            if (childCount <= iu1Var.t) {
                iu1Var.K.setInputMethodMode(2);
                iu1.this.h();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            try {
                L = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", Boolean.TYPE);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                M = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
    }

    public iu1(Context context, AttributeSet attributeSet, int i2, int i3) {
        this.i = -2;
        this.j = -2;
        this.m = 1002;
        this.q = 0;
        this.r = false;
        this.s = false;
        this.t = Integer.MAX_VALUE;
        this.v = 0;
        this.B = new i();
        this.C = new h();
        this.D = new g();
        this.E = new e();
        this.H = new Rect();
        this.f = context;
        this.G = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, mn3.g1, i2, i3);
        this.k = typedArrayObtainStyledAttributes.getDimensionPixelOffset(mn3.h1, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(mn3.i1, 0);
        this.l = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.n = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        z8 z8Var = new z8(context, attributeSet, i2, i3);
        this.K = z8Var;
        z8Var.setInputMethodMode(1);
    }

    public boolean A() {
        return this.K.getInputMethodMode() == 2;
    }

    public boolean B() {
        return this.J;
    }

    public final void C() {
        View view = this.u;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.u);
            }
        }
    }

    public void D(View view) {
        this.x = view;
    }

    public void E(int i2) {
        this.K.setAnimationStyle(i2);
    }

    public void F(int i2) {
        Drawable background = this.K.getBackground();
        if (background == null) {
            R(i2);
            return;
        }
        background.getPadding(this.H);
        Rect rect = this.H;
        this.j = rect.left + rect.right + i2;
    }

    public void G(int i2) {
        this.q = i2;
    }

    public void H(Rect rect) {
        this.I = rect != null ? new Rect(rect) : null;
    }

    public void I(int i2) {
        this.K.setInputMethodMode(i2);
    }

    public void J(boolean z) {
        this.J = z;
        this.K.setFocusable(z);
    }

    public void K(PopupWindow.OnDismissListener onDismissListener) {
        this.K.setOnDismissListener(onDismissListener);
    }

    public void L(AdapterView.OnItemClickListener onItemClickListener) {
        this.z = onItemClickListener;
    }

    public void M(AdapterView.OnItemSelectedListener onItemSelectedListener) {
        this.A = onItemSelectedListener;
    }

    public void N(boolean z) {
        this.p = true;
        this.o = z;
    }

    public final void O(boolean z) {
        if (Build.VERSION.SDK_INT > 28) {
            d.b(this.K, z);
            return;
        }
        Method method = L;
        if (method != null) {
            try {
                method.invoke(this.K, Boolean.valueOf(z));
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    public void P(int i2) {
        this.v = i2;
    }

    public void Q(int i2) {
        bp0 bp0Var = this.h;
        if (!a() || bp0Var == null) {
            return;
        }
        bp0Var.setListSelectionHidden(false);
        bp0Var.setSelection(i2);
        if (bp0Var.getChoiceMode() != 0) {
            bp0Var.setItemChecked(i2, true);
        }
    }

    public void R(int i2) {
        this.j = i2;
    }

    @Override // defpackage.n64
    public boolean a() {
        return this.K.isShowing();
    }

    public void b(Drawable drawable) {
        this.K.setBackgroundDrawable(drawable);
    }

    public int c() {
        return this.k;
    }

    @Override // defpackage.n64
    public void dismiss() {
        this.K.dismiss();
        C();
        this.K.setContentView(null);
        this.h = null;
        this.G.removeCallbacks(this.B);
    }

    public void e(int i2) {
        this.k = i2;
    }

    @Override // defpackage.n64
    public void h() {
        int iQ = q();
        boolean zA = A();
        xf3.b(this.K, this.m);
        if (this.K.isShowing()) {
            if (t().isAttachedToWindow()) {
                int width = this.j;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = t().getWidth();
                }
                int i2 = this.i;
                if (i2 == -1) {
                    if (!zA) {
                        iQ = -1;
                    }
                    PopupWindow popupWindow = this.K;
                    if (zA) {
                        popupWindow.setWidth(this.j == -1 ? -1 : 0);
                        this.K.setHeight(0);
                    } else {
                        popupWindow.setWidth(this.j == -1 ? -1 : 0);
                        this.K.setHeight(-1);
                    }
                } else if (i2 != -2) {
                    iQ = i2;
                }
                this.K.setOutsideTouchable((this.s || this.r) ? false : true);
                this.K.update(t(), this.k, this.l, width < 0 ? -1 : width, iQ < 0 ? -1 : iQ);
                return;
            }
            return;
        }
        int width2 = this.j;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = t().getWidth();
        }
        int i3 = this.i;
        if (i3 == -1) {
            iQ = -1;
        } else if (i3 != -2) {
            iQ = i3;
        }
        this.K.setWidth(width2);
        this.K.setHeight(iQ);
        O(true);
        this.K.setOutsideTouchable((this.s || this.r) ? false : true);
        this.K.setTouchInterceptor(this.C);
        if (this.p) {
            xf3.a(this.K, this.o);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = M;
            if (method != null) {
                try {
                    method.invoke(this.K, this.I);
                } catch (Exception e2) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e2);
                }
            }
        } else {
            d.a(this.K, this.I);
        }
        xf3.c(this.K, t(), this.k, this.l, this.q);
        this.h.setSelection(-1);
        if (!this.J || this.h.isInTouchMode()) {
            r();
        }
        if (this.J) {
            return;
        }
        this.G.post(this.E);
    }

    public Drawable i() {
        return this.K.getBackground();
    }

    @Override // defpackage.n64
    public ListView k() {
        return this.h;
    }

    public void l(int i2) {
        this.l = i2;
        this.n = true;
    }

    public int o() {
        if (this.n) {
            return this.l;
        }
        return 0;
    }

    public void p(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.w;
        if (dataSetObserver == null) {
            this.w = new f();
        } else {
            ListAdapter listAdapter2 = this.g;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.g = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.w);
        }
        bp0 bp0Var = this.h;
        if (bp0Var != null) {
            bp0Var.setAdapter(this.g);
        }
    }

    public final int q() {
        int measuredHeight;
        int i2;
        int iMakeMeasureSpec;
        View view;
        int i3;
        if (this.h == null) {
            Context context = this.f;
            this.F = new a();
            bp0 bp0VarS = s(context, !this.J);
            this.h = bp0VarS;
            Drawable drawable = this.y;
            if (drawable != null) {
                bp0VarS.setSelector(drawable);
            }
            this.h.setAdapter(this.g);
            this.h.setOnItemClickListener(this.z);
            this.h.setFocusable(true);
            this.h.setFocusableInTouchMode(true);
            this.h.setOnItemSelectedListener(new b());
            this.h.setOnScrollListener(this.D);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.A;
            if (onItemSelectedListener != null) {
                this.h.setOnItemSelectedListener(onItemSelectedListener);
            }
            bp0 bp0Var = this.h;
            View view2 = this.u;
            if (view2 != null) {
                LinearLayout linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, 0, 1.0f);
                int i4 = this.v;
                if (i4 == 0) {
                    linearLayout.addView(view2);
                    linearLayout.addView(bp0Var, layoutParams);
                } else if (i4 != 1) {
                    Log.e("ListPopupWindow", "Invalid hint position " + this.v);
                } else {
                    linearLayout.addView(bp0Var, layoutParams);
                    linearLayout.addView(view2);
                }
                int i5 = this.j;
                if (i5 >= 0) {
                    i3 = Integer.MIN_VALUE;
                } else {
                    i5 = 0;
                    i3 = 0;
                }
                view2.measure(View.MeasureSpec.makeMeasureSpec(i5, i3), 0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) view2.getLayoutParams();
                measuredHeight = view2.getMeasuredHeight() + layoutParams2.topMargin + layoutParams2.bottomMargin;
                view = linearLayout;
            } else {
                measuredHeight = 0;
                view = bp0Var;
            }
            this.K.setContentView(view);
        } else {
            View view3 = this.u;
            if (view3 != null) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) view3.getLayoutParams();
                measuredHeight = view3.getMeasuredHeight() + layoutParams3.topMargin + layoutParams3.bottomMargin;
            } else {
                measuredHeight = 0;
            }
        }
        Drawable background = this.K.getBackground();
        Rect rect = this.H;
        if (background != null) {
            background.getPadding(rect);
            Rect rect2 = this.H;
            int i6 = rect2.top;
            i2 = rect2.bottom + i6;
            if (!this.n) {
                this.l = -i6;
            }
        } else {
            rect.setEmpty();
            i2 = 0;
        }
        int iU = u(t(), this.l, this.K.getInputMethodMode() == 2);
        if (this.r || this.i == -1) {
            return iU + i2;
        }
        int i7 = this.j;
        if (i7 == -2) {
            int i8 = this.f.getResources().getDisplayMetrics().widthPixels;
            Rect rect3 = this.H;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i8 - (rect3.left + rect3.right), Integer.MIN_VALUE);
        } else if (i7 != -1) {
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i7, Buffer.MAX_SIZE);
        } else {
            int i9 = this.f.getResources().getDisplayMetrics().widthPixels;
            Rect rect4 = this.H;
            iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i9 - (rect4.left + rect4.right), Buffer.MAX_SIZE);
        }
        int iD = this.h.d(iMakeMeasureSpec, 0, -1, iU - measuredHeight, -1);
        if (iD > 0) {
            measuredHeight += i2 + this.h.getPaddingTop() + this.h.getPaddingBottom();
        }
        return iD + measuredHeight;
    }

    public void r() {
        bp0 bp0Var = this.h;
        if (bp0Var != null) {
            bp0Var.setListSelectionHidden(true);
            bp0Var.requestLayout();
        }
    }

    public bp0 s(Context context, boolean z) {
        return new bp0(context, z);
    }

    public View t() {
        return this.x;
    }

    public final int u(View view, int i2, boolean z) {
        return c.a(this.K, view, i2, z);
    }

    public Object v() {
        if (a()) {
            return this.h.getSelectedItem();
        }
        return null;
    }

    public long w() {
        if (a()) {
            return this.h.getSelectedItemId();
        }
        return Long.MIN_VALUE;
    }

    public int x() {
        if (a()) {
            return this.h.getSelectedItemPosition();
        }
        return -1;
    }

    public View y() {
        if (a()) {
            return this.h.getSelectedView();
        }
        return null;
    }

    public int z() {
        return this.j;
    }

    public iu1(Context context, AttributeSet attributeSet, int i2) {
        this(context, attributeSet, i2, 0);
    }

    public iu1(Context context) {
        this(context, null, nk3.D);
    }
}
