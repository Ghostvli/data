package defpackage;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import androidx.appcompat.app.a;
import com.google.android.material.slider.Slider;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class sl {
    public final rk0 a;
    public final pl b;
    public int c;

    /* JADX WARN: Multi-variable type inference failed */
    public sl(p51 p51Var) {
        this.b = (pl) p51Var;
        this.a = rk0.c(LayoutInflater.from(p51Var.U()));
    }

    public static sl c(p51 p51Var) {
        return new sl(p51Var);
    }

    public final void d() {
        a aVarCreate = new o52(this.a.getRoot().getContext()).m(sm3.i0).setView(this.a.getRoot()).setPositiveButton(sm3.v, new DialogInterface.OnClickListener() { // from class: ql
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f.g(dialogInterface, i);
            }
        }).setNegativeButton(sm3.u, new DialogInterface.OnClickListener() { // from class: rl
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f.f(dialogInterface, i);
            }
        }).create();
        aVarCreate.getWindow().setDimAmount(0.0f);
        aVarCreate.show();
    }

    public final void e() {
        Slider slider = this.a.b;
        int iB = q24.b();
        this.c = iB;
        slider.setValue(iB);
    }

    public final void f(DialogInterface dialogInterface, int i) {
        this.b.C(this.c);
        dialogInterface.dismiss();
    }

    public final void g(DialogInterface dialogInterface, int i) {
        this.b.C((int) this.a.b.getValue());
        dialogInterface.dismiss();
    }

    public void h() {
        d();
        e();
    }
}
