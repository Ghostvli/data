package defpackage;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.textview.MaterialTextView;
import java.text.DecimalFormat;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class u44 extends uh implements pv4, pl, xb4 {
    public t61 k0;
    public DecimalFormat l0;
    public String[] m0;
    public String[] n0;
    public String[] o0;
    public String[] p0;
    public String[] q0;
    public String[] r0;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String T2(boolean z) {
        return y0(z ? sm3.v0 : sm3.u0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static u44 W2() {
        return new u44();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pl
    public void C(int i) {
        this.k0.k.setText(String.valueOf(i));
        q24.T(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void U2(DialogInterface dialogInterface, int i) {
        this.k0.i.setText(this.m0[i]);
        q24.R(i);
        dialogInterface.dismiss();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void V2(DialogInterface dialogInterface, int i) {
        this.k0.y.setText(this.p0[i]);
        q24.o0(i);
        dialogInterface.dismiss();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void X2(View view) {
        new o52(X1()).m(sm3.h0).setNegativeButton(sm3.u, null).E(this.m0, q24.a(), new DialogInterface.OnClickListener() { // from class: j44
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f.U2(dialogInterface, i);
            }
        }).n();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Y2(View view) {
        sl.c(this).h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean Z2(View view) {
        if (q24.C()) {
            o2(new Intent("android.settings.CAPTIONING_SETTINGS"));
        }
        return q24.C();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a3(View view) {
        new o52(X1()).m(sm3.j0).setNegativeButton(sm3.u, null).E(this.p0, q24.n(), new DialogInterface.OnClickListener() { // from class: k44
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f.V2(dialogInterface, i);
            }
        }).n();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void b3(View view) {
        ac4.c(this).h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c3(View view) {
        tv4.e(this).m();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void d3(View view) {
        q24.k0(!q24.K());
        this.k0.c.setText(T2(q24.K()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e3(View view) {
        q24.P(!q24.x());
        this.k0.e.setText(T2(q24.x()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.p51
    public void f1(boolean z) {
        if (z) {
            return;
        }
        x2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f3(View view) {
        q24.Q(!q24.y());
        this.k0.g.setText(T2(q24.y()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g3(View view) {
        q24.U(!q24.C());
        this.k0.m.setText(this.n0[q24.C() ? 1 : 0]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h3(View view) {
        q24.W(!q24.E());
        this.k0.o.setText(T2(q24.E()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i3(View view) {
        q24.b0(!q24.H());
        this.k0.q.setText(T2(q24.H()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j3(View view) {
        int i = q24.j() == 2 ? 1 : 2;
        this.k0.s.setText(this.r0[i != 2 ? (char) 0 : (char) 1]);
        q24.j0(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k3(View view) {
        if (q24.M() && q24.k() == 0) {
            m3(view);
        }
        int iK = q24.k() + 1;
        String[] strArr = this.o0;
        int length = iK % strArr.length;
        this.k0.u.setText(strArr[length]);
        q24.l0(length);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l3(View view) {
        int iM = q24.m() + 1;
        String[] strArr = this.q0;
        int length = iM % strArr.length;
        this.k0.w.setText(strArr[length]);
        q24.n0(length);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m3(View view) {
        q24.v0(!q24.M());
        this.k0.C.setText(T2(q24.M()));
        if (q24.M() && q24.k() == 1) {
            k3(view);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.pv4
    public void n(String str) {
        this.k0.E.setText(str);
        q24.w0(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v2, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r2v4, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public final void n3(View view) {
        boolean z = q24.h() != 0 ? 1 : 0;
        int i = !z;
        q24.h0(i);
        q24.a0(i);
        this.k0.G.setText(T2(z));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o3(View view) {
        q24.z0(!q24.N());
        this.k0.I.setText(T2(q24.N()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.xb4
    public void t(float f) {
        this.k0.A.setText(this.l0.format(f));
        q24.r0(f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.uh
    public i35 u2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        t61 t61VarC = t61.c(layoutInflater, viewGroup, false);
        this.k0 = t61VarC;
        return t61VarC;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.uh
    public void v2() {
        this.k0.D.setOnClickListener(new View.OnClickListener() { // from class: a44
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.c3(view);
            }
        });
        this.k0.b.setOnClickListener(new View.OnClickListener() { // from class: t44
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.d3(view);
            }
        });
        this.k0.x.setOnClickListener(new View.OnClickListener() { // from class: b44
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.a3(view);
            }
        });
        this.k0.z.setOnClickListener(new View.OnClickListener() { // from class: c44
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.b3(view);
            }
        });
        this.k0.j.setOnClickListener(new View.OnClickListener() { // from class: d44
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.Y2(view);
            }
        });
        this.k0.t.setOnClickListener(new View.OnClickListener() { // from class: e44
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.k3(view);
            }
        });
        this.k0.B.setOnClickListener(new View.OnClickListener() { // from class: f44
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.m3(view);
            }
        });
        this.k0.l.setOnClickListener(new View.OnClickListener() { // from class: g44
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.g3(view);
            }
        });
        this.k0.d.setOnClickListener(new View.OnClickListener() { // from class: h44
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.e3(view);
            }
        });
        this.k0.l.setOnLongClickListener(new View.OnLongClickListener() { // from class: i44
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.Z2(view);
            }
        });
        this.k0.h.setOnClickListener(new View.OnClickListener() { // from class: l44
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.X2(view);
            }
        });
        this.k0.f.setOnClickListener(new View.OnClickListener() { // from class: m44
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.f3(view);
            }
        });
        this.k0.F.setOnClickListener(new View.OnClickListener() { // from class: n44
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.n3(view);
            }
        });
        this.k0.n.setOnClickListener(new View.OnClickListener() { // from class: o44
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.h3(view);
            }
        });
        this.k0.r.setOnClickListener(new View.OnClickListener() { // from class: p44
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.j3(view);
            }
        });
        this.k0.v.setOnClickListener(new View.OnClickListener() { // from class: q44
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.l3(view);
            }
        });
        this.k0.H.setOnClickListener(new View.OnClickListener() { // from class: r44
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.o3(view);
            }
        });
        this.k0.p.setOnClickListener(new View.OnClickListener() { // from class: s44
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.i3(view);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.uh
    public void x2() {
        this.l0 = new DecimalFormat("0.#");
        this.k0.E.setText(q24.s());
        this.k0.c.setText(T2(q24.K()));
        this.k0.C.setText(T2(q24.M()));
        this.k0.e.setText(T2(q24.x()));
        this.k0.A.setText(this.l0.format(q24.p()));
        this.k0.k.setText(String.valueOf(q24.b()));
        this.k0.g.setText(T2(q24.y()));
        this.k0.G.setText(T2(q24.h() == 0));
        this.k0.o.setText(T2(q24.E()));
        this.k0.l.setVisibility(q24.v() ? 0 : 8);
        MaterialTextView materialTextView = this.k0.s;
        String[] strArrN = vr3.n(dk3.f);
        this.r0 = strArrN;
        materialTextView.setText(strArrN[q24.j() != 2 ? (char) 0 : (char) 1]);
        MaterialTextView materialTextView2 = this.k0.w;
        String[] strArrN2 = vr3.n(dk3.i);
        this.q0 = strArrN2;
        materialTextView2.setText(strArrN2[q24.m()]);
        this.k0.I.setText(T2(q24.N()));
        this.k0.q.setText(T2(q24.H()));
        MaterialTextView materialTextView3 = this.k0.y;
        String[] strArrN3 = vr3.n(dk3.j);
        this.p0 = strArrN3;
        materialTextView3.setText(strArrN3[q24.n()]);
        MaterialTextView materialTextView4 = this.k0.u;
        String[] strArrN4 = vr3.n(dk3.g);
        this.o0 = strArrN4;
        materialTextView4.setText(strArrN4[q24.k()]);
        MaterialTextView materialTextView5 = this.k0.m;
        String[] strArrN5 = vr3.n(dk3.c);
        this.n0 = strArrN5;
        materialTextView5.setText(strArrN5[q24.C() ? 1 : 0]);
        MaterialTextView materialTextView6 = this.k0.i;
        String[] strArrN6 = vr3.n(dk3.b);
        this.m0 = strArrN6;
        materialTextView6.setText(strArrN6[q24.a()]);
    }
}
