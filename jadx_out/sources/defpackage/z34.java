package defpackage;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.FileProvider;
import com.fongmi.android.tv.bean.Config;
import com.fongmi.android.tv.bean.Live;
import com.fongmi.android.tv.bean.Site;
import com.fongmi.android.tv.db.AppDatabase;
import com.fongmi.android.tv.ui.activity.HomeActivity;
import com.github.catvod.utils.Path;
import com.google.android.material.textview.MaterialTextView;
import defpackage.c00;
import fi.iki.elonen.NanoHTTPD;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class z34 extends uh implements gz, e84, yw1 {
    public s61 k0;
    public String[] l0;
    public String[] m0;
    public int n0;
    public final q3 o0 = V1(new p3(), new l3() { // from class: h34
        @Override // defpackage.l3
        public final void a(Object obj) {
            this.a.r3((k3) obj);
        }
    });

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends to {
        public a() {
        }

        @Override // defpackage.to
        public void e(String str) {
            z34.this.k0.d.setText(str);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends to {
        public b() {
        }

        @Override // defpackage.to
        public void b(String str) {
            i43.c();
            i43.i(str);
        }

        @Override // defpackage.to
        public void c() {
            i43.g(z34.this.X1());
        }

        @Override // defpackage.to
        public void d() {
            i43.c();
            z34.this.T3();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends to {
        public c() {
        }

        @Override // defpackage.to
        public void d() {
            z34.this.T3();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d extends to {
        public d() {
        }

        @Override // defpackage.to
        public void a() {
            i43.h(sm3.c);
        }

        @Override // defpackage.to
        public void d() {
            i43.h(sm3.d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e extends to {
        public e() {
        }

        @Override // defpackage.to
        public void a() {
            i43.h(sm3.o0);
        }

        @Override // defpackage.to
        public void d() {
            i43.h(sm3.p0);
            z34.this.X3();
            z34.this.q3();
        }
    }

    public static z34 B3() {
        return new z34();
    }

    private to l3() {
        return new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q3() {
        b75.I().c0().n(l3());
        lx1.J().U().a0();
        m85.x().z().C();
    }

    public final void A3(Config config) {
        int type = config.getType();
        if (type == 0) {
            b75.j0(config, l3());
            return;
        }
        if (type == 1) {
            lx1.b0(config, l3());
        } else {
            if (type != 2) {
                return;
            }
            q24.x0(0);
            m85.D(config, l3());
        }
    }

    @Override // defpackage.yw1
    public void B(Live live) {
        lx1.J().i0(live);
    }

    public final void C3(View view) {
        ta3.a(this, new Consumer() { // from class: m34
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.s3((Boolean) obj);
            }
        });
    }

    public final void D3(View view) {
        w01.e(new c());
    }

    public final void E3(View view) {
        b00 b00VarN = b00.f(this).n(this.o0);
        this.n0 = 1;
        b00VarN.s(1).r();
    }

    public final boolean F3(View view) {
        b00 b00VarN = b00.f(this).n(this.o0);
        this.n0 = 1;
        b00VarN.s(1).h().r();
        return true;
    }

    public final void G3(View view) {
        me1 me1VarC = me1.c(this);
        this.n0 = 1;
        me1VarC.j(1).i();
    }

    public final void H3(View view) {
        yx1.h(this).g().n();
    }

    public final void I3(View view) {
        new Thread(new Runnable() { // from class: p34
            @Override // java.lang.Runnable
            public final void run() {
                this.f.u3();
            }
        }).start();
    }

    public final void J3(View view) {
        o3().b2(2);
    }

    public final void K3(View view) {
        ta3.a(this, new Consumer() { // from class: o34
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                this.a.v3((Boolean) obj);
            }
        });
    }

    public final void L3(View view) {
        i43.i("基于fongmi影视二次开发，适用于山东IPTV点播\n 5.4.1");
    }

    public final void M3(View view) {
        b00 b00VarN = b00.f(this).n(this.o0);
        this.n0 = 0;
        b00VarN.s(0).r();
    }

    public final boolean N3(View view) {
        b00 b00VarN = b00.f(this).n(this.o0);
        this.n0 = 0;
        b00VarN.s(0).h().r();
        return true;
    }

    public final void O3(View view) {
        me1 me1VarC = me1.c(this);
        this.n0 = 0;
        me1VarC.j(0).i();
    }

    public final void P3(View view) {
        p84.i(this).g().o();
    }

    public final void Q3(View view) {
        b00 b00VarN = b00.f(this).n(this.o0);
        this.n0 = 2;
        b00VarN.s(2).r();
    }

    public final boolean R3(View view) {
        b00 b00VarN = b00.f(this).n(this.o0);
        this.n0 = 2;
        b00VarN.s(2).h().r();
        return true;
    }

    public final boolean S3(View view) {
        me1 me1VarC = me1.c(this);
        this.n0 = 2;
        me1VarC.j(2).i();
        return true;
    }

    public final void T3() {
        w01.g(new a());
    }

    public final void U3(an0 an0Var) {
        q53.m().i(an0Var);
        q24.Z(an0Var.toString());
        this.k0.f.setText(an0Var.e());
    }

    public final void V3(View view) {
        new o52(X1()).m(sm3.s0).setNegativeButton(sm3.u, null).E(n3(), m3(), new DialogInterface.OnClickListener() { // from class: k34
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f.x3(dialogInterface, i);
            }
        }).n();
    }

    public final void W3(View view) {
        q24.d0(!q24.I());
        this.k0.h.setText(p3(q24.I()));
    }

    public final void X3() {
        this.k0.f.setText(n3()[m3()]);
        this.k0.h.setText(p3(q24.I()));
        MaterialTextView materialTextView = this.k0.u;
        String[] strArrN = vr3.n(dk3.k);
        this.l0 = strArrN;
        materialTextView.setText(strArrN[q24.o()]);
        this.k0.s.setText(p3(q24.L()));
        MaterialTextView materialTextView2 = this.k0.o;
        String[] strArrN2 = vr3.n(dk3.e);
        this.m0 = strArrN2;
        materialTextView2.setText(strArrN2[q24.i()]);
    }

    public final void Y3(View view) {
        new o52(X1()).m(sm3.w0).setNegativeButton(sm3.u, null).E(this.m0, q24.i(), new DialogInterface.OnClickListener() { // from class: l34
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f.y3(dialogInterface, i);
            }
        }).n();
    }

    public final void Z3(View view) {
        q24.p0(!q24.L());
        this.k0.s.setText(p3(q24.L()));
    }

    public final void a4(View view) {
        new o52(X1()).m(sm3.x0).setNegativeButton(sm3.u, null).E(this.l0, q24.o(), new DialogInterface.OnClickListener() { // from class: j34
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f.z3(dialogInterface, i);
            }
        }).n();
    }

    @Override // defpackage.gz
    public void b0(final Config config) {
        if (config.getUrl().startsWith("file")) {
            ta3.a(this, new Consumer() { // from class: i34
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    this.a.w3(config, (Boolean) obj);
                }
            });
        } else {
            A3(config);
        }
    }

    public final void b4(View view) {
        q24.x0(q24.t() != 4 ? 1 + q24.t() : 1);
        q24.y0(0);
        c00.j();
    }

    @Override // defpackage.uh, defpackage.p51
    public void c1() {
        super.c1();
        uu0.d().r(this);
    }

    public final void c4(View view) {
        q24.x0(0);
        m85.x().n(l3());
    }

    @Override // defpackage.p51
    public void f1(boolean z) {
        if (z) {
            return;
        }
        T3();
    }

    public final int m3() {
        return Math.max(0, b75.I().M().indexOf(an0.h(q24.c())));
    }

    public final String[] n3() {
        ArrayList arrayList = new ArrayList();
        Iterator it = b75.I().M().iterator();
        while (it.hasNext()) {
            arrayList.add(((an0) it.next()).e());
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @Override // defpackage.e84
    public void o(Site site) {
        b75.I().q0(site);
    }

    public final HomeActivity o3() {
        return (HomeActivity) X1();
    }

    @lh4(threadMode = ThreadMode.MAIN)
    public void onConfigEvent(c00 c00Var) {
        if (c00Var.h() != c00.a.COMMON) {
            return;
        }
        this.k0.A.setText(b75.L());
        this.k0.l.setText(lx1.L());
        this.k0.E.setText(m85.y());
    }

    public final String p3(boolean z) {
        return y0(z ? sm3.v0 : sm3.u0);
    }

    public final /* synthetic */ void r3(k3 k3Var) {
        if (k3Var.d() != -1 || k3Var.c() == null || k3Var.c().getData() == null) {
            return;
        }
        b0(Config.find("file:/" + g01.m(k3Var.c().getData()).replace(Path.rootPath(), ""), this.n0));
    }

    public final /* synthetic */ void s3(Boolean bool) {
        AppDatabase.N(new d());
    }

    public final /* synthetic */ void t3(Intent intent) {
        o2(intent);
    }

    @Override // defpackage.uh
    public i35 u2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        s61 s61VarC = s61.c(layoutInflater, viewGroup, false);
        this.k0 = s61VarC;
        return s61VarC;
    }

    public final /* synthetic */ void u3() {
        File fileE = zz1.e(X1());
        if (fileE == null) {
            X1().runOnUiThread(new Runnable() { // from class: q34
                @Override // java.lang.Runnable
                public final void run() {
                    i43.i("日志导出失败");
                }
            });
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType(NanoHTTPD.MIME_PLAINTEXT);
        intent.putExtra("android.intent.extra.STREAM", FileProvider.h(X1(), X1().getPackageName() + ".provider", fileE));
        intent.addFlags(1);
        final Intent intentCreateChooser = Intent.createChooser(intent, "分享日志");
        X1().runOnUiThread(new Runnable() { // from class: r34
            @Override // java.lang.Runnable
            public final void run() {
                this.f.t3(intentCreateChooser);
            }
        });
    }

    @Override // defpackage.uh
    public void v2() {
        this.k0.x.setOnClickListener(new View.OnClickListener() { // from class: r24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.M3(view);
            }
        });
        this.k0.e.setOnClickListener(new View.OnClickListener() { // from class: t24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.V3(view);
            }
        });
        this.k0.i.setOnClickListener(new View.OnClickListener() { // from class: y24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.E3(view);
            }
        });
        this.k0.B.setOnClickListener(new View.OnClickListener() { // from class: z24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.Q3(view);
            }
        });
        this.k0.t.setOnClickListener(new View.OnClickListener() { // from class: a34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.a4(view);
            }
        });
        this.k0.c.setOnClickListener(new View.OnClickListener() { // from class: b34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.D3(view);
            }
        });
        this.k0.b.setOnClickListener(new View.OnClickListener() { // from class: d34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.C3(view);
            }
        });
        this.k0.p.setOnClickListener(new View.OnClickListener() { // from class: e34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.J3(view);
            }
        });
        this.k0.q.setOnClickListener(new View.OnClickListener() { // from class: f34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.K3(view);
            }
        });
        this.k0.v.setOnClickListener(new View.OnClickListener() { // from class: g34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.L3(view);
            }
        });
        this.k0.m.setOnClickListener(new View.OnClickListener() { // from class: c34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.I3(view);
            }
        });
        this.k0.x.setOnLongClickListener(new View.OnLongClickListener() { // from class: n34
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.N3(view);
            }
        });
        this.k0.z.setOnClickListener(new View.OnClickListener() { // from class: s34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.P3(view);
            }
        });
        this.k0.i.setOnLongClickListener(new View.OnLongClickListener() { // from class: t34
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.F3(view);
            }
        });
        this.k0.k.setOnClickListener(new View.OnClickListener() { // from class: u34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.H3(view);
            }
        });
        this.k0.B.setOnLongClickListener(new View.OnLongClickListener() { // from class: v34
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.R3(view);
            }
        });
        this.k0.g.setOnClickListener(new View.OnClickListener() { // from class: w34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.W3(view);
            }
        });
        this.k0.r.setOnClickListener(new View.OnClickListener() { // from class: x34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.Z3(view);
            }
        });
        this.k0.n.setOnClickListener(new View.OnClickListener() { // from class: y34
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.Y3(view);
            }
        });
        this.k0.y.setOnClickListener(new View.OnClickListener() { // from class: s24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.O3(view);
            }
        });
        this.k0.j.setOnClickListener(new View.OnClickListener() { // from class: u24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.G3(view);
            }
        });
        this.k0.C.setOnClickListener(new View.OnClickListener() { // from class: v24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.b4(view);
            }
        });
        this.k0.D.setOnClickListener(new View.OnClickListener() { // from class: w24
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.c4(view);
            }
        });
        this.k0.D.setOnLongClickListener(new View.OnLongClickListener() { // from class: x24
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.S3(view);
            }
        });
    }

    public final /* synthetic */ void v3(Boolean bool) {
        et3.U2().V2(X1(), new e());
    }

    public final /* synthetic */ void w3(Config config, Boolean bool) {
        A3(config);
    }

    @Override // defpackage.uh
    public void x2() {
        uu0.d().p(this);
        this.k0.A.setText(b75.L());
        this.k0.l.setText(lx1.L());
        this.k0.E.setText(m85.y());
        this.k0.w.setText(" 時光轨車5.4.1");
        X3();
        T3();
    }

    public final /* synthetic */ void x3(DialogInterface dialogInterface, int i) {
        U3((an0) b75.I().M().get(i));
        dialogInterface.dismiss();
    }

    public final /* synthetic */ void y3(DialogInterface dialogInterface, int i) {
        this.k0.o.setText(this.m0[i]);
        q24.i0(i);
        dialogInterface.dismiss();
    }

    public final /* synthetic */ void z3(DialogInterface dialogInterface, int i) {
        this.k0.u.setText(this.l0[i]);
        q24.q0(i);
        qp3.l();
        dialogInterface.dismiss();
    }
}
