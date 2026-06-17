package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.fongmi.android.tv.bean.History;
import com.fongmi.android.tv.ui.activity.VideoActivity;
import com.google.android.material.bottomsheet.b;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class qo3 extends nh {
    public wq A0;
    public fl0 z0;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends to {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.to
        public void b(String str) {
            i43.i(str);
            qo3.this.a3();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.to
        public void d() {
            qo3.this.c3();
            qo3.this.a3();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static qo3 X2() {
        return new qo3();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private to Z2() {
        return new a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public void a3() {
        this.z0.b.setEnabled(true);
        this.z0.f.setVisibility(0);
        this.z0.g.getRoot().setVisibility(8);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void b3(View view) {
        c3();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void f3() {
        this.z0.b.setEnabled(false);
        this.z0.f.setVisibility(8);
        this.z0.g.getRoot().setVisibility(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.nh
    public i35 M2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        fl0 fl0VarC = fl0.c(layoutInflater, viewGroup, false);
        this.z0 = fl0VarC;
        return fl0VarC;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.nh
    public void N2() {
        this.z0.b.setOnClickListener(new View.OnClickListener() { // from class: po3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.b3(view);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.nh
    public void O2() {
        History historyE = this.A0.e();
        this.z0.e.setText(historyE.getVodName());
        this.z0.c.setText(this.A0.d().getName());
        si1.h(historyE.getVodName(), historyE.getVodPic(), this.z0.d);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public qo3 Y2(wq wqVar) {
        this.A0 = wqVar;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c3() {
        if (b75.I().i().equals(this.A0.c())) {
            VideoActivity.u4(X1(), this.A0.e().save(b75.K()));
            w2();
        } else {
            f3();
            b75.j0(this.A0.c(), Z2());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d3(p51 p51Var) {
        Iterator it = p51Var.T().w0().iterator();
        while (it.hasNext()) {
            if (((p51) it.next()) instanceof b) {
                return;
            }
        }
        G2(p51Var.T(), null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e3(u51 u51Var) {
        Iterator it = u51Var.n1().w0().iterator();
        while (it.hasNext()) {
            if (((p51) it.next()) instanceof b) {
                return;
            }
        }
        G2(u51Var.n1(), null);
    }
}
