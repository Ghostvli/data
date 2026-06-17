package defpackage;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.a;
import androidx.lifecycle.x;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class m11 extends zk0 {
    public zj A0;
    public int B0;
    public int C0;
    public ImageView D0;
    public TextView E0;
    public final Handler y0 = new Handler(Looper.getMainLooper());
    public final Runnable z0 = new a();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            m11.this.L2();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements DialogInterface.OnClickListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i) {
            m11.this.A0.X(true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements x43 {
        public c() {
        }

        @Override // defpackage.x43
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Integer num) {
            m11 m11Var = m11.this;
            m11Var.y0.removeCallbacks(m11Var.z0);
            m11.this.N2(num.intValue());
            m11.this.O2(num.intValue());
            m11 m11Var2 = m11.this;
            m11Var2.y0.postDelayed(m11Var2.z0, 2000L);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d implements x43 {
        public d() {
        }

        @Override // defpackage.x43
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(CharSequence charSequence) {
            m11 m11Var = m11.this;
            m11Var.y0.removeCallbacks(m11Var.z0);
            m11.this.P2(charSequence);
            m11 m11Var2 = m11.this;
            m11Var2.y0.postDelayed(m11Var2.z0, 2000L);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e {
        public static void a(Drawable drawable) {
            if (drawable instanceof AnimatedVectorDrawable) {
                ((AnimatedVectorDrawable) drawable).start();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class f {
        public static int a() {
            return fk3.a;
        }
    }

    private void H2() {
        u51 u51VarO = O();
        if (u51VarO == null) {
            return;
        }
        zj zjVar = (zj) new x(u51VarO).b(zj.class);
        this.A0 = zjVar;
        zjVar.r().f(this, new c());
        this.A0.p().f(this, new d());
    }

    public static m11 K2() {
        return new m11();
    }

    @Override // defpackage.zk0
    public Dialog B2(Bundle bundle) {
        a.C0002a c0002a = new a.C0002a(Y1());
        c0002a.setTitle(this.A0.w());
        View viewInflate = LayoutInflater.from(c0002a.getContext()).inflate(bm3.a, (ViewGroup) null);
        TextView textView = (TextView) viewInflate.findViewById(ql3.d);
        if (textView != null) {
            CharSequence charSequenceV = this.A0.v();
            if (TextUtils.isEmpty(charSequenceV)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
                textView.setText(charSequenceV);
            }
        }
        TextView textView2 = (TextView) viewInflate.findViewById(ql3.a);
        if (textView2 != null) {
            CharSequence charSequenceO = this.A0.o();
            if (TextUtils.isEmpty(charSequenceO)) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
                textView2.setText(charSequenceO);
            }
        }
        this.D0 = (ImageView) viewInflate.findViewById(ql3.c);
        this.E0 = (TextView) viewInflate.findViewById(ql3.b);
        c0002a.g(me.c(this.A0.e()) ? y0(mm3.a) : this.A0.u(), new b());
        c0002a.setView(viewInflate);
        androidx.appcompat.app.a aVarCreate = c0002a.create();
        aVarCreate.setCanceledOnTouchOutside(false);
        return aVarCreate;
    }

    public final Drawable I2(int i, int i2) {
        int i3;
        Context contextU = U();
        if (contextU == null) {
            Log.w("FingerprintFragment", "Unable to get asset. Context is null.");
            return null;
        }
        if (i == 0 && i2 == 1) {
            i3 = cl3.b;
        } else if (i == 1 && i2 == 2) {
            i3 = cl3.a;
        } else if (i == 2 && i2 == 1) {
            i3 = cl3.b;
        } else {
            if (i != 1 || i2 != 3) {
                return null;
            }
            i3 = cl3.b;
        }
        return c30.e(contextU, i3);
    }

    public final int J2(int i) {
        Context contextU = U();
        u51 u51VarO = O();
        if (contextU == null || u51VarO == null) {
            Log.w("FingerprintFragment", "Unable to get themed color. Context or activity is null.");
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        contextU.getTheme().resolveAttribute(i, typedValue, true);
        TypedArray typedArrayObtainStyledAttributes = u51VarO.obtainStyledAttributes(typedValue.data, new int[]{i});
        int color = typedArrayObtainStyledAttributes.getColor(0, 0);
        typedArrayObtainStyledAttributes.recycle();
        return color;
    }

    public void L2() {
        Context contextU = U();
        if (contextU == null) {
            Log.w("FingerprintFragment", "Not resetting the dialog. Context is null.");
        } else {
            this.A0.V(1);
            this.A0.T(contextU.getString(mm3.c));
        }
    }

    public final boolean M2(int i, int i2) {
        if (i == 0 && i2 == 1) {
            return false;
        }
        if (i == 1 && i2 == 2) {
            return true;
        }
        return i == 2 && i2 == 1;
    }

    public void N2(int i) {
        int iQ;
        Drawable drawableI2;
        if (this.D0 == null || (drawableI2 = I2((iQ = this.A0.q()), i)) == null) {
            return;
        }
        this.D0.setImageDrawable(drawableI2);
        if (M2(iQ, i)) {
            e.a(drawableI2);
        }
        this.A0.U(i);
    }

    public void O2(int i) {
        TextView textView = this.E0;
        if (textView != null) {
            textView.setTextColor(i == 2 ? this.B0 : this.C0);
        }
    }

    public void P2(CharSequence charSequence) {
        TextView textView = this.E0;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    @Override // defpackage.zk0, defpackage.p51
    public void V0(Bundle bundle) {
        super.V0(bundle);
        H2();
        if (Build.VERSION.SDK_INT >= 26) {
            this.B0 = J2(f.a());
        } else {
            Context contextU = U();
            this.B0 = contextU != null ? c30.b(contextU, pk3.a) : 0;
        }
        this.C0 = J2(R.attr.textColorSecondary);
    }

    @Override // defpackage.p51
    public void l1() {
        super.l1();
        this.y0.removeCallbacksAndMessages(null);
    }

    @Override // defpackage.zk0, android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        this.A0.R(true);
    }

    @Override // defpackage.p51
    public void q1() {
        super.q1();
        this.A0.U(0);
        this.A0.V(1);
        this.A0.T(y0(mm3.c));
    }
}
