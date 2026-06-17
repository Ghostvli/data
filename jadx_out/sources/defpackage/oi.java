package defpackage;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class oi {
    public int a;
    public int b;
    public float c;
    public boolean d;
    public int[] e = new int[0];
    public int f;
    public int g;
    public int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public int m;
    public float n;
    public float o;
    public float p;

    public oi(Context context, AttributeSet attributeSet, int i, int i2) {
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(zk3.i0);
        TypedArray typedArrayI = dn4.i(context, attributeSet, cn3.R, i, i2, new int[0]);
        this.a = k62.d(context, typedArrayI, cn3.b0, dimensionPixelSize);
        TypedValue typedValuePeekValue = typedArrayI.peekValue(cn3.a0);
        if (typedValuePeekValue != null) {
            int i3 = typedValuePeekValue.type;
            if (i3 == 5) {
                this.b = Math.min(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArrayI.getResources().getDisplayMetrics()), this.a / 2);
                this.d = false;
            } else if (i3 == 6) {
                this.c = Math.min(typedValuePeekValue.getFraction(1.0f, 1.0f), 0.5f);
                this.d = true;
            }
        }
        this.g = typedArrayI.getInt(cn3.X, 0);
        this.h = typedArrayI.getInt(cn3.S, 0);
        this.i = typedArrayI.getDimensionPixelSize(cn3.V, 0);
        int iAbs = Math.abs(typedArrayI.getDimensionPixelSize(cn3.g0, 0));
        this.j = Math.abs(typedArrayI.getDimensionPixelSize(cn3.h0, iAbs));
        this.k = Math.abs(typedArrayI.getDimensionPixelSize(cn3.i0, iAbs));
        this.l = Math.abs(typedArrayI.getDimensionPixelSize(cn3.c0, 0));
        this.m = typedArrayI.getDimensionPixelSize(cn3.f0, 0);
        this.n = typedArrayI.getFloat(cn3.T, 1.0f);
        this.o = typedArrayI.getFloat(cn3.e0, 0.1f);
        this.p = typedArrayI.getFloat(cn3.d0, 0.9f);
        e(context, typedArrayI);
        f(context, typedArrayI);
        typedArrayI.recycle();
    }

    public int a() {
        return this.d ? (int) (this.a * this.c) : this.b;
    }

    public boolean b(boolean z) {
        if (this.l <= 0) {
            return false;
        }
        if (z || this.k <= 0) {
            return z && this.j > 0;
        }
        return true;
    }

    public boolean c() {
        return this.h != 0;
    }

    public boolean d() {
        return this.g != 0;
    }

    public final void e(Context context, TypedArray typedArray) {
        if (!typedArray.hasValue(cn3.U)) {
            this.e = new int[]{h62.b(context, nk3.w, -1)};
            return;
        }
        if (typedArray.peekValue(cn3.U).type != 1) {
            this.e = new int[]{typedArray.getColor(cn3.U, -1)};
            return;
        }
        int[] intArray = context.getResources().getIntArray(typedArray.getResourceId(cn3.U, -1));
        this.e = intArray;
        if (intArray.length != 0) {
            return;
        }
        jl.a("indicatorColors cannot be empty when indicatorColor is not used.");
    }

    public final void f(Context context, TypedArray typedArray) {
        if (typedArray.hasValue(cn3.Z)) {
            this.f = typedArray.getColor(cn3.Z, -1);
            return;
        }
        this.f = this.e[0];
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(new int[]{R.attr.disabledAlpha});
        float f = typedArrayObtainStyledAttributes.getFloat(0, 0.2f);
        typedArrayObtainStyledAttributes.recycle();
        this.f = h62.a(this.f, (int) (f * 255.0f));
    }

    public boolean g() {
        return this.d && this.c == 0.5f;
    }

    public void h() {
        if (this.i >= 0) {
            return;
        }
        jl.a("indicatorTrackGapSize must be >= 0.");
    }
}
