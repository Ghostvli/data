package defpackage;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.CastVideo;
import com.fongmi.android.tv.bean.Config;
import com.fongmi.android.tv.bean.Device;
import com.fongmi.android.tv.bean.History;
import com.fongmi.android.tv.ui.activity.ScanActivity;
import com.github.catvod.utils.Path;
import com.github.catvod.utils.Util;
import com.google.android.material.bottomsheet.b;
import defpackage.ak0;
import defpackage.e80;
import defpackage.jy3;
import java.io.IOException;
import java.util.Iterator;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class uq extends nh implements ak0.a, jy3.a, e80.a, Callback {
    public final OkHttpClient A0;
    public vk0 B0;
    public ak0 C0;
    public a E0;
    public CastVideo F0;
    public boolean G0;
    public final FormBody.Builder z0;
    public final q3 H0 = V1(new p3(), new l3() { // from class: sq
        @Override // defpackage.l3
        public final void a(Object obj) {
            this.a.j3((k3) obj);
        }
    });
    public jy3 D0 = new jy3(this);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void Q0();
    }

    public uq() {
        FormBody.Builder builder = new FormBody.Builder();
        this.z0 = builder;
        builder.add("device", Device.get().toString());
        builder.add("config", Config.vod().toString());
        this.A0 = q53.k(f10.h);
    }

    public static uq c3() {
        return new uq();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l3() {
        this.E0.Q0();
        w2();
    }

    private void q() {
        this.C0.L(new Runnable() { // from class: tq
            @Override // java.lang.Runnable
            public final void run() {
                this.f.k3();
            }
        });
    }

    @Override // ak0.a
    public void A(Device device) {
        if (device.isDLNA()) {
            new x70(this.F0, new mq(this)).i(device);
        } else {
            q53.x(this.A0, device.getIp().concat("/action?do=cast"), this.z0.build()).enqueue(this);
        }
    }

    @Override // defpackage.nh
    public i35 M2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        vk0 vk0VarC = vk0.c(layoutInflater, viewGroup, false);
        this.B0 = vk0VarC;
        return vk0VarC;
    }

    @Override // defpackage.nh
    public void N2() {
        this.B0.e.setOnClickListener(new View.OnClickListener() { // from class: oq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.h3(view);
            }
        });
        this.B0.d.setOnClickListener(new View.OnClickListener() { // from class: pq
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.i3(view);
            }
        });
    }

    @Override // defpackage.nh
    public void O2() {
        this.B0.e.setVisibility(this.G0 ? 0 : 8);
        e80.h().k(X1());
        e80.h().r(this);
        n3();
        e3();
    }

    @Override // jy3.a
    public void c(Device device) {
        this.C0.U(device);
    }

    @Override // defpackage.zk0, defpackage.p51
    public void c1() {
        super.c1();
        e80.h().r(null);
        e80.h().p(X1());
        this.D0.p();
    }

    public uq d3(boolean z) {
        this.G0 = z;
        return this;
    }

    public final void e3() {
        this.C0.T(Device.getAll(), new Runnable() { // from class: rq
            @Override // java.lang.Runnable
            public final void run() {
                this.f.g3();
            }
        });
    }

    public uq f3(History history) {
        String vodId = history.getVodId();
        String vodId2 = history.getVodId();
        if (vodId2.startsWith(ServiceReference.DELIMITER)) {
            vodId2 = t14.b().c() + "/file" + vodId2.replace(Path.rootPath(), "");
        }
        if (vodId2.startsWith("file")) {
            vodId2 = t14.b().c() + ServiceReference.DELIMITER + vodId2.replace(Path.rootPath(), "").replace("://", "");
        }
        if (vodId2.contains("127.0.0.1")) {
            vodId2 = vodId2.replace("127.0.0.1", Util.getIp());
        }
        this.z0.add("history", history.toString().replace(vodId, vodId2));
        return this;
    }

    @Override // e80.a
    public void g(Device device) {
        this.C0.P(device);
    }

    public final /* synthetic */ void g3() {
        this.C0.W(e80.h().j());
        if (this.C0.g() == 0) {
            q();
        } else {
            e80.h().q();
        }
    }

    public final /* synthetic */ void h3(View view) {
        m3();
    }

    public final /* synthetic */ void i3(View view) {
        q();
    }

    public final /* synthetic */ void j3(k3 k3Var) {
        if (k3Var.d() != -1 || k3Var.c() == null) {
            return;
        }
        this.D0.o(k3Var.c().getStringExtra("address"));
    }

    public final /* synthetic */ void k3() {
        Device.delete();
        if (this.G0) {
            this.D0.n();
        }
        this.C0.W(e80.h().j());
        e80.h().q();
    }

    public final void m3() {
        this.H0.a(new Intent(X1(), (Class<?>) ScanActivity.class));
    }

    public final void n3() {
        this.B0.c.setHasFixedSize(false);
        RecyclerView recyclerView = this.B0.c;
        ak0 ak0Var = new ak0(this);
        this.C0 = ak0Var;
        recyclerView.setAdapter(ak0Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void o3(u51 u51Var) {
        Iterator it = u51Var.n1().w0().iterator();
        while (it.hasNext()) {
            if (((p51) it.next()) instanceof b) {
                return;
            }
        }
        G2(u51Var.n1(), null);
        this.E0 = (a) u51Var;
    }

    @Override // okhttp3.Callback
    public void onFailure(Call call, final IOException iOException) {
        App.d(new Runnable() { // from class: qq
            @Override // java.lang.Runnable
            public final void run() {
                i43.i(iOException.getMessage());
            }
        });
    }

    @Override // okhttp3.Callback
    public void onResponse(Call call, Response response) {
        try {
            if (response.body().string().equals("OK")) {
                App.d(new mq(this));
            } else {
                App.d(new Runnable() { // from class: nq
                    @Override // java.lang.Runnable
                    public final void run() {
                        i43.h(sm3.p);
                    }
                });
            }
            response.close();
        } catch (Throwable th) {
            if (response != null) {
                try {
                    response.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // e80.a
    public void p(Device device) {
        this.C0.U(device);
    }

    public uq p3(CastVideo castVideo) {
        this.F0 = castVideo;
        return this;
    }

    @Override // ak0.a
    public boolean z(Device device) {
        return false;
    }
}
