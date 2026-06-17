package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import com.google.android.material.progressindicator.CircularProgressIndicator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ju extends oi {
    public int q;
    public int r;
    public int s;
    public int t;
    public boolean u;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ju(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(zk3.h0);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(zk3.g0);
        TypedArray typedArrayI = dn4.i(context, attributeSet, cn3.N1, i, i2, new int[0]);
        this.q = typedArrayI.getInt(cn3.O1, 0);
        this.r = Math.max(k62.d(context, typedArrayI, cn3.S1, dimensionPixelSize), this.a * 2);
        this.s = k62.d(context, typedArrayI, cn3.R1, dimensionPixelSize2);
        this.t = typedArrayI.getInt(cn3.Q1, 0);
        this.u = typedArrayI.getBoolean(cn3.P1, true);
        typedArrayI.recycle();
        h();
    }

    public ju(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, CircularProgressIndicator.w);
    }

    public ju(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, mk3.h);
    }
}
