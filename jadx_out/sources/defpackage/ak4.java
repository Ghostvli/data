package defpackage;

import android.content.Intent;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Config;
import com.fongmi.android.tv.bean.Device;
import com.fongmi.android.tv.bean.History;
import com.fongmi.android.tv.bean.Keep;
import com.fongmi.android.tv.ui.activity.ScanActivity;
import com.google.android.material.bottomsheet.b;
import defpackage.ak0;
import defpackage.jy3;
import java.io.IOException;
import java.util.Iterator;
import java.util.Locale;
import okhttp3.Call;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ak4 extends nh implements ak0.a, jy3.a {
    public vk0 C0;
    public ak0 D0;
    public String F0;
    public final q3 G0 = V1(new p3(), new l3() { // from class: tj4
        @Override // defpackage.l3
        public final void a(Object obj) {
            this.a.l3((k3) obj);
        }
    });
    public final FormBody.Builder z0 = new FormBody.Builder();
    public jy3 E0 = new jy3(this);
    public final OkHttpClient A0 = q53.k(f10.h);
    public final TypedArray B0 = vr3.p(dk3.a);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends to {
        public a() {
        }

        public final /* synthetic */ void h() {
            ak4.this.p3();
        }

        @Override // defpackage.to, okhttp3.Callback
        public void onFailure(Call call, final IOException iOException) {
            App.d(new Runnable() { // from class: yj4
                @Override // java.lang.Runnable
                public final void run() {
                    i43.i(iOException.getMessage());
                }
            });
        }

        @Override // defpackage.to, okhttp3.Callback
        public void onResponse(Call call, Response response) {
            App.d(new Runnable() { // from class: zj4
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.h();
                }
            });
        }
    }

    public static ak4 b3() {
        return new ak4();
    }

    private void e3() {
        this.D0.T(Device.getAll(), new Runnable() { // from class: sj4
            @Override // java.lang.Runnable
            public final void run() {
                this.f.h3();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void i3(View view) {
        n3();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void j3(View view) {
        o3();
    }

    private void o3() {
        this.G0.a(new Intent(X1(), (Class<?>) ScanActivity.class));
    }

    private void q() {
        this.D0.L(new Runnable() { // from class: xj4
            @Override // java.lang.Runnable
            public final void run() {
                this.f.m3();
            }
        });
    }

    private void r3() {
        this.C0.c.setHasFixedSize(false);
        RecyclerView recyclerView = this.C0.c;
        ak0 ak0Var = new ak0(this);
        this.D0 = ak0Var;
        recyclerView.setAdapter(ak0Var);
    }

    @Override // ak0.a
    public void A(Device device) {
        q53.x(this.A0, String.format(Locale.getDefault(), "%s/action?do=sync&mode=%s&type=%s", device.getIp(), this.C0.b.getTag().toString(), this.F0), this.z0.build()).enqueue(d3());
    }

    @Override // defpackage.nh
    public i35 M2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        vk0 vk0VarC = vk0.c(layoutInflater, viewGroup, false);
        this.C0 = vk0VarC;
        return vk0VarC;
    }

    @Override // defpackage.nh
    public void N2() {
        this.C0.b.setOnClickListener(new View.OnClickListener() { // from class: uj4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.i3(view);
            }
        });
        this.C0.e.setOnClickListener(new View.OnClickListener() { // from class: vj4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.j3(view);
            }
        });
        this.C0.d.setOnClickListener(new View.OnClickListener() { // from class: wj4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.k3(view);
            }
        });
    }

    @Override // defpackage.nh
    public void O2() {
        this.C0.b.setVisibility(0);
        r3();
        e3();
        q3();
    }

    @Override // jy3.a
    public void c(Device device) {
        this.D0.U(device);
    }

    @Override // defpackage.zk0, defpackage.p51
    public void c1() {
        super.c1();
        this.E0.p();
    }

    public final void c3() {
        if (this.F0.equals("keep")) {
            Keep.deleteAll();
        }
        if (this.F0.equals("history")) {
            History.delete(b75.K());
        }
    }

    public final to d3() {
        return new a();
    }

    public ak4 f3() {
        this.z0.add("device", Device.get().toString());
        this.z0.add("config", Config.vod().toString());
        this.z0.add("targets", App.c().toJson(History.get()));
        return t3("history");
    }

    public ak4 g3() {
        this.z0.add("device", Device.get().toString());
        this.z0.add("targets", App.c().toJson(Keep.getVod()));
        this.z0.add("configs", App.c().toJson(Config.findUrls()));
        return t3("keep");
    }

    public final /* synthetic */ void h3() {
        if (this.D0.g() == 0) {
            q();
        }
    }

    public final /* synthetic */ void k3(View view) {
        q();
    }

    public final /* synthetic */ void l3(k3 k3Var) {
        if (k3Var.d() != -1 || k3Var.c() == null) {
            return;
        }
        this.E0.o(k3Var.c().getStringExtra("address"));
    }

    public final /* synthetic */ void m3() {
        Device.delete();
        this.E0.n();
    }

    public final void n3() {
        int iR = q24.r();
        int i = iR == this.B0.length() + (-1) ? 0 : iR + 1;
        q24.u0(i);
        this.C0.b.setImageResource(this.B0.getResourceId(i, 0));
        this.C0.b.setTag(String.valueOf(i));
    }

    public final void p3() {
        w2();
    }

    public final void q3() {
        int iR = q24.r();
        this.C0.b.setImageResource(this.B0.getResourceId(iR, 0));
        this.C0.b.setTag(String.valueOf(iR));
    }

    public void s3(u51 u51Var) {
        Iterator it = u51Var.n1().w0().iterator();
        while (it.hasNext()) {
            if (((p51) it.next()) instanceof b) {
                return;
            }
        }
        G2(u51Var.n1(), null);
    }

    public final ak4 t3(String str) {
        this.F0 = str;
        return this;
    }

    @Override // ak0.a
    public boolean z(Device device) {
        String string = this.C0.b.getTag().toString();
        if (string.equals("0")) {
            return false;
        }
        if (string.equals("2")) {
            c3();
        }
        q53.x(this.A0, String.format(Locale.getDefault(), "%s/action?do=sync&mode=%s&type=%s%s", device.getIp(), string, this.F0, string.equals("1") ? "&force=true" : ""), this.z0.build()).enqueue(d3());
        return true;
    }
}
