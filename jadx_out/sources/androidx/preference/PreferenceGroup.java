package androidx.preference;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.Log;
import defpackage.hn3;
import defpackage.wu4;
import defpackage.x64;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class PreferenceGroup extends Preference {
    public final x64 I;
    public final Handler J;
    public final List K;
    public boolean L;
    public int M;
    public boolean N;
    public int O;
    public final Runnable P;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            synchronized (this) {
                PreferenceGroup.this.I.clear();
            }
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.I = new x64();
        this.J = new Handler(Looper.getMainLooper());
        this.L = true;
        this.M = 0;
        this.N = false;
        this.O = Integer.MAX_VALUE;
        this.P = new a();
        this.K = new ArrayList();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, hn3.s0, i, i2);
        int i3 = hn3.u0;
        this.L = wu4.b(typedArrayObtainStyledAttributes, i3, i3, true);
        if (typedArrayObtainStyledAttributes.hasValue(hn3.t0)) {
            int i4 = hn3.t0;
            L(wu4.d(typedArrayObtainStyledAttributes, i4, i4, Integer.MAX_VALUE));
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public Preference J(int i) {
        return (Preference) this.K.get(i);
    }

    public int K() {
        return this.K.size();
    }

    public void L(int i) {
        if (i != Integer.MAX_VALUE && !q()) {
            Log.e("PreferenceGroup", getClass().getSimpleName().concat(" should have a key defined if it contains an expandable preference"));
        }
        this.O = i;
    }

    @Override // androidx.preference.Preference
    public void w(boolean z) {
        super.w(z);
        int iK = K();
        for (int i = 0; i < iK; i++) {
            J(i).A(this, z);
        }
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public PreferenceGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }
}
