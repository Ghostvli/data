package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.media3.ui.SubtitleView;
import com.google.android.material.bottomsheet.b;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class di4 extends nh {
    public SubtitleView A0;
    public boolean B0;
    public jl0 z0;

    public static di4 V2() {
        return new di4();
    }

    @Override // defpackage.nh
    public i35 M2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        jl0 jl0VarC = jl0.c(layoutInflater, viewGroup, false);
        this.z0 = jl0VarC;
        return jl0VarC;
    }

    @Override // defpackage.nh
    public void N2() {
        this.z0.d.setOnClickListener(new View.OnClickListener() { // from class: ci4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.X2(view);
            }
        });
    }

    @Override // defpackage.nh
    public void O2() {
        int childCount = this.z0.getRoot().getChildCount();
        if (this.B0) {
            for (int i = 0; i < childCount; i++) {
                ((ImageView) this.z0.getRoot().getChildAt(i)).getDrawable().setTint(-1);
            }
        }
    }

    @Override // defpackage.nh
    public boolean T2() {
        return this.B0;
    }

    public di4 W2(boolean z) {
        this.B0 = z;
        return this;
    }

    public final void X2(View view) {
        q24.t0(0.0f);
        q24.s0(0.0f);
        this.A0.e();
    }

    public void Y2(u51 u51Var) {
        Iterator it = u51Var.n1().w0().iterator();
        while (it.hasNext()) {
            if (((p51) it.next()) instanceof b) {
                return;
            }
        }
        G2(u51Var.n1(), null);
    }

    public di4 Z2(SubtitleView subtitleView) {
        this.A0 = subtitleView;
        return this;
    }

    @Override // defpackage.p51
    public void q1() {
        super.q1();
        if (this.B0) {
            R2(0.5f);
        }
        z2().getWindow().setLayout(vr3.a(this.B0 ? 232 : 216), -1);
    }
}
