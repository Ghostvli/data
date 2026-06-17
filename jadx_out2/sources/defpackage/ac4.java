package defpackage;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import androidx.appcompat.app.a;
import com.google.android.material.slider.Slider;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ac4 {
    public final il0 a;
    public final xb4 b;
    public float c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: p51 */
    /* JADX WARN: Multi-variable type inference failed */
    public ac4(p51 p51Var) {
        this.b = (xb4) p51Var;
        this.a = il0.c(LayoutInflater.from(p51Var.U()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ac4 c(p51 p51Var) {
        return new ac4(p51Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void d() {
        a aVarCreate = new o52(this.a.getRoot().getContext()).m(sm3.k0).setView(this.a.getRoot()).setPositiveButton(sm3.v, new DialogInterface.OnClickListener() { // from class: yb4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f.g(dialogInterface, i);
            }
        }).setNegativeButton(sm3.u, new DialogInterface.OnClickListener() { // from class: zb4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f.f(dialogInterface, i);
            }
        }).create();
        aVarCreate.getWindow().setDimAmount(0.0f);
        aVarCreate.show();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e() {
        Slider slider = this.a.b;
        float fP = q24.p();
        this.c = fP;
        slider.setValue(fP);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f(DialogInterface dialogInterface, int i) {
        this.b.t(this.c);
        dialogInterface.dismiss();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(DialogInterface dialogInterface, int i) {
        this.b.t(this.a.b.getValue());
        dialogInterface.dismiss();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h() {
        d();
        e();
    }
}
