package defpackage;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class m extends ViewGroup {
    public final a f;
    public final Context g;
    public ActionMenuView h;
    public androidx.appcompat.widget.a i;
    public int j;
    public s45 k;
    public boolean l;
    public boolean m;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements u45 {
        public boolean a = false;
        public int b;

        public a() {
        }

        @Override // defpackage.u45
        public void a(View view) {
            this.a = true;
        }

        @Override // defpackage.u45
        public void b(View view) {
            if (this.a) {
                return;
            }
            m mVar = m.this;
            mVar.k = null;
            m.super.setVisibility(this.b);
        }

        @Override // defpackage.u45
        public void c(View view) {
            m.super.setVisibility(0);
            this.a = false;
        }

        public a d(s45 s45Var, int i) {
            m.this.k = s45Var;
            this.b = i;
            return this;
        }
    }

    public m(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = new a();
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(nk3.a, typedValue, true) || typedValue.resourceId == 0) {
            this.g = context;
        } else {
            this.g = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    public static int d(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    public int c(View view, int i, int i2, int i3) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    public int e(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = i2 + ((i3 - measuredHeight) / 2);
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }

    public s45 f(int i, long j) {
        s45 s45Var = this.k;
        if (s45Var != null) {
            s45Var.c();
        }
        if (i != 0) {
            s45 s45VarB = l35.e(this).b(0.0f);
            s45VarB.e(j);
            s45VarB.g(this.f.d(s45VarB, i));
            return s45VarB;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        s45 s45VarB2 = l35.e(this).b(1.0f);
        s45VarB2.e(j);
        s45VarB2.g(this.f.d(s45VarB2, i));
        return s45VarB2;
    }

    public int getAnimatedVisibility() {
        return this.k != null ? this.f.b : getVisibility();
    }

    public int getContentHeight() {
        return this.j;
    }

    @Override // android.view.View
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, mn3.a, nk3.c, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(mn3.j, 0));
        typedArrayObtainStyledAttributes.recycle();
        androidx.appcompat.widget.a aVar = this.i;
        if (aVar != null) {
            aVar.H(configuration);
        }
    }

    @Override // android.view.View
    public boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.m = false;
        }
        if (!this.m) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.m = true;
            }
        }
        if (actionMasked == 10 || actionMasked == 3) {
            this.m = false;
        }
        return true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.l = false;
        }
        if (!this.l) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.l = true;
            }
        }
        if (actionMasked == 1 || actionMasked == 3) {
            this.l = false;
        }
        return true;
    }

    public abstract void setContentHeight(int i);

    @Override // android.view.View
    public void setVisibility(int i) {
        if (i != getVisibility()) {
            s45 s45Var = this.k;
            if (s45Var != null) {
                s45Var.c();
            }
            super.setVisibility(i);
        }
    }
}
