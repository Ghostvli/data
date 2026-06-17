package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.bottomsheet.b;
import defpackage.to4;
import java.util.Formatter;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class xo4 extends nh implements to4.b {
    public StringBuilder A0 = new StringBuilder();
    public Formatter B0 = new Formatter(this.A0, Locale.getDefault());
    public kl0 z0;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xo4 X2() {
        return new xo4();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public void Z2(View view) {
        to4.e().j();
        w2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.nh
    public i35 M2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        kl0 kl0VarC = kl0.c(layoutInflater, viewGroup, false);
        this.z0 = kl0VarC;
        return kl0VarC;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.nh
    public void N2() {
        to4.e().m(this);
        this.z0.b.setOnClickListener(new View.OnClickListener() { // from class: uo4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.Y2(view);
            }
        });
        this.z0.d.setOnClickListener(new View.OnClickListener() { // from class: vo4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.Z2(view);
            }
        });
        this.z0.f.setOnClickListener(new View.OnClickListener() { // from class: wo4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.a3(view);
            }
        });
        this.z0.g.setOnClickListener(new View.OnClickListener() { // from class: wo4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.a3(view);
            }
        });
        this.z0.h.setOnClickListener(new View.OnClickListener() { // from class: wo4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.a3(view);
            }
        });
        this.z0.i.setOnClickListener(new View.OnClickListener() { // from class: wo4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.a3(view);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.nh
    public void O2() {
        v(to4.e().f());
        this.z0.c.setVisibility(to4.e().g() ? 8 : 0);
        this.z0.j.setVisibility(to4.e().g() ? 0 : 8);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Y2(View view) {
        to4.e().d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a3(View view) {
        to4.e().l(TimeUnit.MINUTES.toMillis(Integer.parseInt(view.getTag().toString())));
        w2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b3(u51 u51Var) {
        Iterator it = u51Var.n1().w0().iterator();
        while (it.hasNext()) {
            if (((p51) it.next()) instanceof b) {
                return;
            }
        }
        G2(u51Var.n1(), null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // to4.b
    public void d() {
        w2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // to4.b
    public void v(long j) {
        this.z0.e.setText(jy4.d(this.A0, this.B0, j));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.google.android.material.bottomsheet.b, defpackage.zk0
    public void w2() {
        to4.e().m(null);
        super.w2();
    }
}
