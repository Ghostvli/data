package com.fongmi.android.tv.ui.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.bn3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class CustomRecyclerView extends RecyclerView {
    public int T0;
    public int U0;
    public int V0;
    public int W0;
    public int X0;
    public float Y0;
    public float Z0;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CustomRecyclerView(Context context) {
        super(context);
        P1(context, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: Q1(I)V */
    /* JADX INFO: renamed from: N1, reason: merged with bridge method [inline-methods] */
    public final void Q1(int i) {
        RecyclerView.g0 g0VarE0 = e0(i);
        if (g0VarE0 != null) {
            g0VarE0.f.requestFocus();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int O1(int i, int i2, int i3) {
        if (i3 > 0) {
            i = Math.min(i, i3);
        }
        return i2 > 0 ? Math.max(i, i2) : i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void P1(Context context, AttributeSet attributeSet) {
        this.X0 = ViewConfiguration.get(context).getScaledTouchSlop();
        if (attributeSet != null) {
            R1(context, attributeSet);
        }
        setOverScrollMode(2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void R1(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, bn3.a);
        this.T0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(bn3.b, 0);
        this.U0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(bn3.c, 0);
        this.V0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(bn3.e, 0);
        this.W0 = typedArrayObtainStyledAttributes.getDimensionPixelSize(bn3.d, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getPointerCount() != 1) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.Y0 = motionEvent.getX();
            this.Z0 = motionEvent.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (action == 1) {
            this.Z0 = 0.0f;
            this.Y0 = 0.0f;
        } else if (action == 2) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            float fAbs = Math.abs(x - this.Y0);
            if (fAbs > Math.abs(y - this.Z0) && fAbs > this.X0) {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(O1(getMeasuredWidth(), this.T0, this.V0), O1(getMeasuredHeight(), this.U0, this.W0));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setMaxHeight(int i) {
        this.W0 = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setMaxWidth(int i) {
        this.V0 = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setMinHeight(int i) {
        this.U0 = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setMinWidth(int i) {
        this.T0 = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.recyclerview.widget.RecyclerView
    public void t1(final int i) {
        super.t1(i);
        postDelayed(new Runnable() { // from class: r60
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.Q1(i);
            }
        }, 50L);
    }

    public CustomRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        P1(context, attributeSet);
    }

    public CustomRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        P1(context, attributeSet);
    }
}
