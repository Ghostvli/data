package androidx.preference;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import defpackage.hn3;
import defpackage.jk3;
import defpackage.wu4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class DialogPreference extends Preference {
    public CharSequence I;
    public CharSequence J;
    public Drawable K;
    public CharSequence L;
    public CharSequence M;
    public int N;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DialogPreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, hn3.h, i, i2);
        String strM = wu4.m(typedArrayObtainStyledAttributes, hn3.r, hn3.i);
        this.I = strM;
        if (strM == null) {
            this.I = p();
        }
        this.J = wu4.m(typedArrayObtainStyledAttributes, hn3.q, hn3.j);
        this.K = wu4.c(typedArrayObtainStyledAttributes, hn3.o, hn3.k);
        this.L = wu4.m(typedArrayObtainStyledAttributes, hn3.t, hn3.l);
        this.M = wu4.m(typedArrayObtainStyledAttributes, hn3.s, hn3.m);
        this.N = wu4.l(typedArrayObtainStyledAttributes, hn3.p, hn3.n, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.preference.Preference
    public void x() {
        m();
        throw null;
    }

    public DialogPreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public DialogPreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, wu4.a(context, jk3.b, R.attr.dialogPreferenceStyle));
    }
}
