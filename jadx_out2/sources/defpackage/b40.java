package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.History;
import com.fongmi.android.tv.bean.Parse;
import com.google.android.material.bottomsheet.b;
import com.google.android.material.slider.Slider;
import defpackage.u73;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class b40 extends nh implements u73.a {
    public v3 A0;
    public u51 B0;
    public List C0;
    public me3 D0;
    public final String[] E0 = vr3.n(dk3.j);
    public a F0;
    public History G0;
    public boolean H0;
    public tk0 z0;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void w0(Parse parse);

        void y0(int i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void A3(View view) {
        m3(this.z0.d, this.A0.e.b.d);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void B3(View view) {
        m3(this.z0.e, this.A0.e.b.e);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void C3(View view) {
        m3(this.z0.g, this.A0.e.b.h);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static b40 n3() {
        return new b40();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q3(View view) {
        o3(this.A0.e.b.m);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r3(View view) {
        o3(this.A0.e.b.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void v3(View view) {
        o3(this.A0.e.b.o);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w3(View view) {
        o3(this.A0.e.b.n);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void x3(View view) {
        o3(this.A0.e.b.i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y3(View view) {
        o3(this.A0.e.b.c);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z3(View view) {
        l3(this.z0.f, this.A0.e.b.g);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void D3() {
        xo4.X2().b3(this.B0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean E3(TextView textView, TextView textView2) {
        textView2.performLongClick();
        textView.setText(textView2.getText());
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F3(View view) {
        App.e(new Runnable() { // from class: q30
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.D3();
            }
        }, 200L);
        w2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b40 G3(v3 v3Var) {
        this.A0 = v3Var;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b40 H3(boolean z) {
        this.H0 = z;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b40 I3(me3 me3Var) {
        this.D0 = me3Var;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void J3() {
        K3(this.H0);
        this.z0.i.setHasFixedSize(true);
        this.z0.i.setItemAnimator(null);
        this.z0.i.i(new gb4(8));
        this.z0.i.setAdapter(new u73(this, 1));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void K3(boolean z) {
        this.z0.i.setVisibility(z ? 0 : 8);
        this.z0.j.setVisibility(z ? 0 : 8);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void L3() {
        this.z0.q.setValue(Math.max(this.D0.G(), 0.5f));
        this.z0.k.setText(this.A0.e.b.i.getText());
        this.z0.d.setVisibility(this.A0.e.b.d.getVisibility());
        this.z0.c.setVisibility(this.A0.e.b.c.getVisibility());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.nh
    public i35 M2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        tk0 tk0VarC = tk0.c(layoutInflater, viewGroup, false);
        this.z0 = tk0VarC;
        this.C0 = Arrays.asList(tk0VarC.l, tk0VarC.m, tk0VarC.n, tk0VarC.o, tk0VarC.p);
        return this.z0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void M3(View view) {
        Iterator it = this.C0.iterator();
        while (it.hasNext()) {
            ((TextView) it.next()).setActivated(false);
        }
        this.F0.y0(Integer.parseInt(view.getTag().toString()));
        view.setActivated(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.nh
    public void N2() {
        this.z0.s.setOnClickListener(new View.OnClickListener() { // from class: j30
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.F3(view);
            }
        });
        this.z0.q.m(new Slider.a() { // from class: y30
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // com.google.android.material.slider.Slider.a
            /* JADX INFO: renamed from: b */
            public final void a(Slider slider, float f, boolean z) {
                this.a.O3(slider, f, z);
            }
        });
        Iterator it = this.C0.iterator();
        while (it.hasNext()) {
            ((TextView) it.next()).setOnClickListener(new View.OnClickListener() { // from class: z30
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f.M3(view);
                }
            });
        }
        this.z0.r.setOnClickListener(new View.OnClickListener() { // from class: a40
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.q3(view);
            }
        });
        this.z0.b.setOnClickListener(new View.OnClickListener() { // from class: k30
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.r3(view);
            }
        });
        this.z0.v.setOnClickListener(new View.OnClickListener() { // from class: l30
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.v3(view);
            }
        });
        this.z0.t.setOnClickListener(new View.OnClickListener() { // from class: m30
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.w3(view);
            }
        });
        this.z0.k.setOnClickListener(new View.OnClickListener() { // from class: n30
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.x3(view);
            }
        });
        this.z0.c.setOnClickListener(new View.OnClickListener() { // from class: o30
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.y3(view);
            }
        });
        this.z0.f.setOnClickListener(new View.OnClickListener() { // from class: p30
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.z3(view);
            }
        });
        this.z0.d.setOnClickListener(new View.OnClickListener() { // from class: s30
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.A3(view);
            }
        });
        this.z0.e.setOnClickListener(new View.OnClickListener() { // from class: t30
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.B3(view);
            }
        });
        this.z0.g.setOnClickListener(new View.OnClickListener() { // from class: u30
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.C3(view);
            }
        });
        this.z0.k.setOnLongClickListener(new View.OnLongClickListener() { // from class: v30
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.s3(view);
            }
        });
        this.z0.e.setOnLongClickListener(new View.OnLongClickListener() { // from class: w30
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.t3(view);
            }
        });
        this.z0.g.setOnLongClickListener(new View.OnLongClickListener() { // from class: x30
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.u3(view);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void N3() {
        for (int i = 0; i < this.C0.size(); i++) {
            ((TextView) this.C0.get(i)).setText(this.E0[i]);
            ((TextView) this.C0.get(i)).setActivated(((TextView) this.C0.get(i)).getText().equals(this.A0.e.b.k.getText()));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.nh
    public void O2() {
        this.z0.d.setText(this.A0.e.b.d.getText());
        this.z0.e.setText(this.A0.e.b.e.getText());
        this.z0.g.setText(this.A0.e.b.h.getText());
        this.z0.f.setActivated(this.A0.e.b.g.isActivated());
        this.z0.s.setActivated(to4.e().g());
        Q3();
        P3();
        N3();
        L3();
        J3();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void O3(Slider slider, float f, boolean z) {
        this.A0.e.b.l.setText(this.D0.q0(f));
        History history = this.G0;
        if (history != null) {
            history.setSpeed(this.D0.G());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void P3() {
        this.z0.t.setVisibility(this.A0.e.b.n.getVisibility());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Q3() {
        this.z0.r.setVisibility(this.A0.e.b.m.getVisibility());
        this.z0.b.setVisibility(this.A0.e.b.b.getVisibility());
        this.z0.v.setVisibility(this.A0.e.b.o.getVisibility());
        tk0 tk0Var = this.z0;
        tk0Var.u.setVisibility((tk0Var.r.getVisibility() == 8 && this.z0.b.getVisibility() == 8 && this.z0.v.getVisibility() == 8) ? 8 : 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: u51 */
    /* JADX WARN: Multi-variable type inference failed */
    public b40 R3(u51 u51Var) {
        Iterator it = u51Var.n1().w0().iterator();
        while (it.hasNext()) {
            if (((p51) it.next()) instanceof b) {
                return this;
            }
        }
        G2(u51Var.n1(), null);
        this.F0 = (a) u51Var;
        this.B0 = u51Var;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l3(View view, TextView textView) {
        textView.performClick();
        view.setActivated(textView.isActivated());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m3(TextView textView, TextView textView2) {
        textView2.performClick();
        textView.setText(textView2.getText());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // u73.a
    public void o0(Parse parse) {
        this.F0.w0(parse);
        this.z0.i.getAdapter().p(0, this.z0.i.getAdapter().g());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o3(final View view) {
        Objects.requireNonNull(view);
        App.e(new Runnable() { // from class: r30
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                view.performClick();
            }
        }, 200L);
        w2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b40 p3(History history) {
        this.G0 = history;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ boolean s3(View view) {
        return E3(this.z0.k, this.A0.e.b.i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ boolean t3(View view) {
        return E3(this.z0.e, this.A0.e.b.e);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ boolean u3(View view) {
        return E3(this.z0.g, this.A0.e.b.h);
    }
}
