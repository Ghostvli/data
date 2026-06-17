package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TwoStatePreference extends Preference {
    public boolean I;
    public CharSequence J;
    public CharSequence K;
    public boolean L;
    public boolean M;

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    @Override // androidx.preference.Preference
    public boolean H() {
        boolean z = this.M;
        boolean z2 = this.I;
        if (!z) {
            z2 = !z2;
        }
        return z2 || super.H();
    }

    public boolean J() {
        return this.I;
    }

    public void K(boolean z) {
        boolean z2 = this.I != z;
        if (z2 || !this.L) {
            this.I = z;
            this.L = true;
            D(z);
            if (z2) {
                w(H());
                v();
            }
        }
    }

    public void L(boolean z) {
        this.M = z;
    }

    public void M(CharSequence charSequence) {
        this.K = charSequence;
        if (J()) {
            return;
        }
        v();
    }

    public void N(CharSequence charSequence) {
        this.J = charSequence;
        if (J()) {
            v();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void O(android.view.View r4) {
        /*
            r3 = this;
            boolean r0 = r4 instanceof android.widget.TextView
            if (r0 != 0) goto L5
            goto L4c
        L5:
            android.widget.TextView r4 = (android.widget.TextView) r4
            boolean r0 = r3.I
            r1 = 0
            if (r0 == 0) goto L1b
            java.lang.CharSequence r0 = r3.J
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L1b
            java.lang.CharSequence r0 = r3.J
            r4.setText(r0)
        L19:
            r0 = r1
            goto L2e
        L1b:
            boolean r0 = r3.I
            if (r0 != 0) goto L2d
            java.lang.CharSequence r0 = r3.K
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L2d
            java.lang.CharSequence r0 = r3.K
            r4.setText(r0)
            goto L19
        L2d:
            r0 = 1
        L2e:
            if (r0 == 0) goto L3e
            java.lang.CharSequence r3 = r3.n()
            boolean r2 = android.text.TextUtils.isEmpty(r3)
            if (r2 != 0) goto L3e
            r4.setText(r3)
            r0 = r1
        L3e:
            if (r0 != 0) goto L41
            goto L43
        L41:
            r1 = 8
        L43:
            int r3 = r4.getVisibility()
            if (r1 == r3) goto L4c
            r4.setVisibility(r1)
        L4c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.preference.TwoStatePreference.O(android.view.View):void");
    }

    @Override // androidx.preference.Preference
    public void x() {
        super.x();
        boolean z = !J();
        if (a(Boolean.valueOf(z))) {
            K(z);
        }
    }

    @Override // androidx.preference.Preference
    public Object z(TypedArray typedArray, int i) {
        return Boolean.valueOf(typedArray.getBoolean(i, false));
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public TwoStatePreference(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
