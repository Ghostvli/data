package androidx.media3.ui;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.media3.ui.DefaultTimeBar;
import androidx.media3.ui.d;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.gn3;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class DefaultTimeBar extends View implements d {
    public final Formatter A;
    public final Runnable B;
    public final CopyOnWriteArraySet C;
    public final Point D;
    public final float E;
    public int F;
    public long G;
    public int H;
    public Rect I;
    public ValueAnimator J;
    public float K;
    public boolean L;
    public boolean M;
    public long N;
    public long O;
    public long P;
    public long Q;
    public int R;
    public long[] S;
    public boolean[] T;
    public final Rect f;
    public final Rect g;
    public final Rect h;
    public final Rect i;
    public final Paint j;
    public final Paint k;
    public final Paint l;
    public final Paint m;
    public final Paint n;
    public final Paint o;
    public final Drawable p;
    public final int q;
    public final int r;
    public final int s;
    public final int t;
    public final int u;
    public final int v;
    public final int w;
    public final int x;
    public final int y;
    public final StringBuilder z;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DefaultTimeBar(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2, int i2) {
        super(context, attributeSet, i);
        this.f = new Rect();
        this.g = new Rect();
        this.h = new Rect();
        this.i = new Rect();
        Paint paint = new Paint();
        this.j = paint;
        Paint paint2 = new Paint();
        this.k = paint2;
        Paint paint3 = new Paint();
        this.l = paint3;
        Paint paint4 = new Paint();
        this.m = paint4;
        Paint paint5 = new Paint();
        this.n = paint5;
        Paint paint6 = new Paint();
        this.o = paint6;
        paint6.setAntiAlias(true);
        this.C = new CopyOnWriteArraySet();
        this.D = new Point();
        float f = context.getResources().getDisplayMetrics().density;
        this.E = f;
        this.y = e(f, -50);
        int iE = e(f, 4);
        int iE2 = e(f, 26);
        int iE3 = e(f, 4);
        int iE4 = e(f, 12);
        int iE5 = e(f, 0);
        int iE6 = e(f, 16);
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, gn3.c, i, i2);
            try {
                Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(gn3.n);
                this.p = drawable;
                if (drawable != null) {
                    drawable.setLayoutDirection(getLayoutDirection());
                    iE2 = Math.max(drawable.getMinimumHeight(), iE2);
                }
                this.q = typedArrayObtainStyledAttributes.getDimensionPixelSize(gn3.g, iE);
                this.r = typedArrayObtainStyledAttributes.getDimensionPixelSize(gn3.p, iE2);
                this.s = typedArrayObtainStyledAttributes.getInt(gn3.f, 0);
                this.t = typedArrayObtainStyledAttributes.getDimensionPixelSize(gn3.e, iE3);
                this.u = typedArrayObtainStyledAttributes.getDimensionPixelSize(gn3.o, iE4);
                this.v = typedArrayObtainStyledAttributes.getDimensionPixelSize(gn3.l, iE5);
                this.w = typedArrayObtainStyledAttributes.getDimensionPixelSize(gn3.m, iE6);
                int i3 = typedArrayObtainStyledAttributes.getInt(gn3.j, -1);
                int i4 = typedArrayObtainStyledAttributes.getInt(gn3.k, -1);
                int i5 = typedArrayObtainStyledAttributes.getInt(gn3.h, -855638017);
                int i6 = typedArrayObtainStyledAttributes.getInt(gn3.q, 872415231);
                int i7 = typedArrayObtainStyledAttributes.getInt(gn3.d, -1291845888);
                int i8 = typedArrayObtainStyledAttributes.getInt(gn3.i, 872414976);
                paint.setColor(i3);
                paint6.setColor(i4);
                paint2.setColor(i5);
                paint3.setColor(i6);
                paint4.setColor(i7);
                paint5.setColor(i8);
                typedArrayObtainStyledAttributes.recycle();
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            this.q = iE;
            this.r = iE2;
            this.s = 0;
            this.t = iE3;
            this.u = iE4;
            this.v = iE5;
            this.w = iE6;
            paint.setColor(-1);
            paint6.setColor(-1);
            paint2.setColor(-855638017);
            paint3.setColor(872415231);
            paint4.setColor(-1291845888);
            paint5.setColor(872414976);
            this.p = null;
        }
        StringBuilder sb = new StringBuilder();
        this.z = sb;
        this.A = new Formatter(sb, Locale.getDefault());
        this.B = new Runnable() { // from class: di0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.s(false);
            }
        };
        Drawable drawable2 = this.p;
        if (drawable2 != null) {
            this.x = (drawable2.getMinimumWidth() + 1) / 2;
        } else {
            this.x = (Math.max(this.v, Math.max(this.u, this.w)) + 1) / 2;
        }
        this.K = 1.0f;
        ValueAnimator valueAnimator = new ValueAnimator();
        this.J = valueAnimator;
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: ei0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                DefaultTimeBar.c(this.a, valueAnimator2);
            }
        });
        this.O = -9223372036854775807L;
        this.G = -9223372036854775807L;
        this.F = 20;
        setFocusable(true);
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void c(DefaultTimeBar defaultTimeBar, ValueAnimator valueAnimator) {
        defaultTimeBar.getClass();
        defaultTimeBar.K = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        defaultTimeBar.invalidate(defaultTimeBar.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int e(float f, int i) {
        return (int) ((i * f) + 0.5f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private long getPositionIncrement() {
        long j = this.G;
        if (j != -9223372036854775807L) {
            return j;
        }
        long j2 = this.O;
        if (j2 == -9223372036854775807L) {
            return 0L;
        }
        return j2 / ((long) this.F);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String getProgressText() {
        return fy4.y0(this.z, this.A, this.P);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private long getScrubberPosition() {
        if (this.g.width() <= 0 || this.O == -9223372036854775807L) {
            return 0L;
        }
        return (((long) this.i.width()) * this.O) / ((long) this.g.width());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int l(float f, int i) {
        return (int) (i / f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.ui.d
    public void a(d.a aVar) {
        gg3.q(aVar);
        this.C.add(aVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.ui.d
    public void b(long[] jArr, boolean[] zArr, int i) {
        gg3.d(i == 0 || !(jArr == null || zArr == null));
        this.R = i;
        this.S = jArr;
        this.T = zArr;
        t();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void drawableStateChanged() {
        super.drawableStateChanged();
        u();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f(Canvas canvas) {
        if (this.O <= 0) {
            return;
        }
        Rect rect = this.i;
        int iS = fy4.s(rect.right, rect.left, this.g.right);
        int iCenterY = this.i.centerY();
        if (this.p == null) {
            canvas.drawCircle(iS, iCenterY, (int) ((((this.M || isFocused()) ? this.w : isEnabled() ? this.u : this.v) * this.K) / 2.0f), this.o);
            return;
        }
        int intrinsicWidth = ((int) (r2.getIntrinsicWidth() * this.K)) / 2;
        int intrinsicHeight = ((int) (this.p.getIntrinsicHeight() * this.K)) / 2;
        this.p.setBounds(iS - intrinsicWidth, iCenterY - intrinsicHeight, iS + intrinsicWidth, iCenterY + intrinsicHeight);
        this.p.draw(canvas);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(Canvas canvas) {
        int iHeight = this.g.height();
        int iCenterY = this.g.centerY() - (iHeight / 2);
        int i = iHeight + iCenterY;
        if (this.O <= 0) {
            Rect rect = this.g;
            canvas.drawRect(rect.left, iCenterY, rect.right, i, this.l);
            return;
        }
        Rect rect2 = this.h;
        int i2 = rect2.left;
        int i3 = rect2.right;
        int iMax = Math.max(Math.max(this.g.left, i3), this.i.right);
        int i4 = this.g.right;
        if (iMax < i4) {
            canvas.drawRect(iMax, iCenterY, i4, i, this.l);
        }
        int iMax2 = Math.max(i2, this.i.right);
        if (i3 > iMax2) {
            canvas.drawRect(iMax2, iCenterY, i3, i, this.k);
        }
        if (this.i.width() > 0) {
            Rect rect3 = this.i;
            canvas.drawRect(rect3.left, iCenterY, rect3.right, i, this.j);
        }
        if (this.R == 0) {
            return;
        }
        long[] jArr = (long[]) gg3.q(this.S);
        boolean[] zArr = (boolean[]) gg3.q(this.T);
        int i5 = this.t / 2;
        for (int i6 = 0; i6 < this.R; i6++) {
            int iWidth = ((int) ((((long) this.g.width()) * fy4.t(jArr[i6], 0L, this.O)) / this.O)) - i5;
            Rect rect4 = this.g;
            canvas.drawRect(rect4.left + Math.min(rect4.width() - this.t, Math.max(0, iWidth)), iCenterY, r10 + this.t, i, zArr[i6] ? this.n : this.m);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.ui.d
    public long getPreferredUpdateDelay() {
        int iL = l(this.E, this.g.width());
        if (iL == 0) {
            return Long.MAX_VALUE;
        }
        long j = this.O;
        if (j == 0 || j == -9223372036854775807L) {
            return Long.MAX_VALUE;
        }
        return j / ((long) iL);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h(long j) {
        if (this.J.isStarted()) {
            this.J.cancel();
        }
        this.J.setFloatValues(this.K, 0.0f);
        this.J.setDuration(j);
        this.J.start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i(boolean z) {
        if (this.J.isStarted()) {
            this.J.cancel();
        }
        this.L = z;
        this.K = 0.0f;
        invalidate(this.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean j(float f, float f2) {
        return this.f.contains((int) f, (int) f2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.p;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k(float f) {
        Rect rect = this.i;
        Rect rect2 = this.g;
        rect.right = fy4.s((int) f, rect2.left, rect2.right);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Point m(MotionEvent motionEvent) {
        this.D.set((int) motionEvent.getX(), (int) motionEvent.getY());
        return this.D;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean n(long j) {
        long j2 = this.O;
        if (j2 <= 0) {
            return false;
        }
        long j3 = this.M ? this.N : this.P;
        long jT = fy4.t(j3 + j, 0L, j2);
        if (jT == j3) {
            return false;
        }
        if (this.M) {
            v(jT);
        } else {
            r(jT);
        }
        t();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o(int i, int i2) {
        Rect rect = this.I;
        if (rect != null && rect.width() == i && this.I.height() == i2) {
            return;
        }
        Rect rect2 = new Rect(0, 0, i, i2);
        this.I = rect2;
        setSystemGestureExclusionRects(Collections.singletonList(rect2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        canvas.save();
        g(canvas);
        f(canvas);
        canvas.restore();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (!this.M || z) {
            return;
        }
        s(false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (accessibilityEvent.getEventType() == 4) {
            accessibilityEvent.getText().add(getProgressText());
        }
        accessibilityEvent.setClassName("android.widget.SeekBar");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName("android.widget.SeekBar");
        accessibilityNodeInfo.setContentDescription(getProgressText());
        if (this.O <= 0) {
            return;
        }
        accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_FORWARD);
        accessibilityNodeInfo.addAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_BACKWARD);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0027  */
    @Override // android.view.View, android.view.KeyEvent.Callback
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (isEnabled()) {
            long positionIncrement = getPositionIncrement();
            if (i != 66) {
                switch (i) {
                    case 21:
                        positionIncrement = -positionIncrement;
                        if (n(positionIncrement)) {
                            removeCallbacks(this.B);
                            postDelayed(this.B, 1000L);
                        }
                        break;
                    case 22:
                        if (n(positionIncrement)) {
                        }
                        break;
                    case 23:
                        if (this.M) {
                            s(false);
                        }
                        break;
                }
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingBottom;
        int iMax;
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingRight = i5 - getPaddingRight();
        int i7 = this.L ? 0 : this.x;
        if (this.s == 1) {
            paddingBottom = (i6 - getPaddingBottom()) - this.r;
            int paddingBottom2 = i6 - getPaddingBottom();
            int i8 = this.q;
            iMax = (paddingBottom2 - i8) - Math.max(i7 - (i8 / 2), 0);
        } else {
            paddingBottom = (i6 - this.r) / 2;
            iMax = (i6 - this.q) / 2;
        }
        this.f.set(paddingLeft, paddingBottom, paddingRight, this.r + paddingBottom);
        Rect rect = this.g;
        Rect rect2 = this.f;
        rect.set(rect2.left + i7, iMax, rect2.right - i7, this.q + iMax);
        if (Build.VERSION.SDK_INT >= 29) {
            o(i5, i6);
        }
        t();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        if (mode == 0) {
            size = this.r;
        } else if (mode != 1073741824) {
            size = Math.min(this.r, size);
        }
        setMeasuredDimension(View.MeasureSpec.getSize(i), size);
        u();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public void onRtlPropertiesChanged(int i) {
        Drawable drawable = this.p;
        if (drawable == null || !drawable.setLayoutDirection(i)) {
            return;
        }
        invalidate();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004e  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (isEnabled() && this.O > 0) {
            Point pointM = m(motionEvent);
            int i = pointM.x;
            int i2 = pointM.y;
            int action = motionEvent.getAction();
            if (action == 0) {
                float f = i;
                if (j(f, i2)) {
                    k(f);
                    r(getScrubberPosition());
                    t();
                    invalidate();
                    return true;
                }
            } else if (action == 1) {
                if (this.M) {
                    s(motionEvent.getAction() == 3);
                    return true;
                }
            } else if (action != 2) {
                if (action == 3) {
                }
            } else if (this.M) {
                if (i2 < this.y) {
                    int i3 = this.H;
                    k(i3 + ((i - i3) / 3));
                } else {
                    this.H = i;
                    k(i);
                }
                v(getScrubberPosition());
                t();
                invalidate();
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void p() {
        if (this.J.isStarted()) {
            this.J.cancel();
        }
        this.L = false;
        this.K = 1.0f;
        invalidate(this.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (this.O <= 0) {
            return false;
        }
        if (i == 8192) {
            if (n(-getPositionIncrement())) {
                s(false);
            }
        } else {
            if (i != 4096) {
                return false;
            }
            if (n(getPositionIncrement())) {
                s(false);
            }
        }
        sendAccessibilityEvent(4);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void q(long j) {
        if (this.J.isStarted()) {
            this.J.cancel();
        }
        this.L = false;
        this.J.setFloatValues(this.K, 1.0f);
        this.J.setDuration(j);
        this.J.start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void r(long j) {
        this.N = j;
        this.M = true;
        setPressed(true);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        Iterator it = this.C.iterator();
        while (it.hasNext()) {
            ((d.a) it.next()).a(this, j);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void s(boolean z) {
        removeCallbacks(this.B);
        this.M = false;
        setPressed(false);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        invalidate();
        Iterator it = this.C.iterator();
        while (it.hasNext()) {
            ((d.a) it.next()).v(this, this.N, z);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setAdMarkerColor(int i) {
        this.m.setColor(i);
        invalidate(this.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setBufferedColor(int i) {
        this.k.setColor(i);
        invalidate(this.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.ui.d
    public void setBufferedPosition(long j) {
        if (this.Q == j) {
            return;
        }
        this.Q = j;
        t();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.ui.d
    public void setDuration(long j) {
        if (this.O == j) {
            return;
        }
        this.O = j;
        if (this.M && j == -9223372036854775807L) {
            s(true);
        }
        t();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View, androidx.media3.ui.d
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        if (!this.M || z) {
            return;
        }
        s(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setKeyCountIncrement(int i) {
        gg3.d(i > 0);
        this.F = i;
        this.G = -9223372036854775807L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setKeyTimeIncrement(long j) {
        gg3.d(j > 0);
        this.F = -1;
        this.G = j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setPlayedAdMarkerColor(int i) {
        this.n.setColor(i);
        invalidate(this.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setPlayedColor(int i) {
        this.j.setColor(i);
        invalidate(this.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.ui.d
    public void setPosition(long j) {
        if (this.P == j) {
            return;
        }
        this.P = j;
        setContentDescription(getProgressText());
        t();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setScrubberColor(int i) {
        this.o.setColor(i);
        invalidate(this.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setUnplayedColor(int i) {
        this.l.setColor(i);
        invalidate(this.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void t() {
        this.h.set(this.g);
        this.i.set(this.g);
        long j = this.M ? this.N : this.P;
        if (this.O > 0) {
            int iWidth = (int) ((((long) this.g.width()) * this.Q) / this.O);
            Rect rect = this.h;
            Rect rect2 = this.g;
            rect.right = Math.min(rect2.left + iWidth, rect2.right);
            int iWidth2 = (int) ((((long) this.g.width()) * j) / this.O);
            Rect rect3 = this.i;
            Rect rect4 = this.g;
            rect3.right = Math.min(rect4.left + iWidth2, rect4.right);
        } else {
            Rect rect5 = this.h;
            int i = this.g.left;
            rect5.right = i;
            this.i.right = i;
        }
        invalidate(this.f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u() {
        Drawable drawable = this.p;
        if (drawable != null && drawable.isStateful() && this.p.setState(getDrawableState())) {
            invalidate();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void v(long j) {
        if (this.N == j) {
            return;
        }
        this.N = j;
        Iterator it = this.C.iterator();
        while (it.hasNext()) {
            ((d.a) it.next()).s(this, j);
        }
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, attributeSet);
    }

    public DefaultTimeBar(Context context, AttributeSet attributeSet, int i, AttributeSet attributeSet2) {
        this(context, attributeSet, i, attributeSet2, 0);
    }

    public DefaultTimeBar(Context context) {
        this(context, null);
    }
}
