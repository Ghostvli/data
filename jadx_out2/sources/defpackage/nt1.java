package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.google.android.material.progressindicator.LinearProgressIndicator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class nt1 extends oi {
    public int q;
    public int r;
    public boolean s;
    public int t;
    public Integer u;
    public int v;
    public float w;
    public boolean x;
    public boolean y;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public nt1(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray typedArrayI = dn4.i(context, attributeSet, cn3.B2, mk3.v, LinearProgressIndicator.w, new int[0]);
        this.q = typedArrayI.getInt(cn3.C2, 1);
        this.r = typedArrayI.getInt(cn3.D2, 0);
        this.t = typedArrayI.getDimensionPixelSize(cn3.G2, 0);
        if (typedArrayI.hasValue(cn3.F2)) {
            this.u = Integer.valueOf(typedArrayI.getDimensionPixelSize(cn3.F2, 0));
        }
        TypedValue typedValuePeekValue = typedArrayI.peekValue(cn3.E2);
        if (typedValuePeekValue != null) {
            int i3 = typedValuePeekValue.type;
            if (i3 == 5) {
                this.v = Math.min(TypedValue.complexToDimensionPixelSize(typedValuePeekValue.data, typedArrayI.getResources().getDisplayMetrics()), this.a / 2);
                this.x = false;
                this.y = true;
            } else if (i3 == 6) {
                this.w = Math.min(typedValuePeekValue.getFraction(1.0f, 1.0f), 0.5f);
                this.x = true;
                this.y = true;
            }
        }
        typedArrayI.recycle();
        h();
        this.s = this.r == 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.oi
    public boolean g() {
        return super.g() && j() == a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.oi
    public void h() {
        super.h();
        if (this.t < 0) {
            jl.a("Stop indicator size must be >= 0.");
            return;
        }
        if (this.q == 0) {
            if ((a() > 0 || (this.y && j() > 0)) && this.i == 0) {
                jl.a("Rounded corners without gap are not supported in contiguous indeterminate animation.");
            } else {
                if (this.e.length >= 3) {
                    return;
                }
                jl.a("Contiguous indeterminate animation must be used with 3 or more indicator colors.");
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int i() {
        return Math.min(this.t, this.a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int j() {
        return !this.y ? a() : this.x ? (int) (this.a * this.w) : this.v;
    }

    public nt1(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, LinearProgressIndicator.w);
    }

    public nt1(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, mk3.v);
    }
}
