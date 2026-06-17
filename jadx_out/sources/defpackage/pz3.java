package defpackage;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.lifecycle.g;
import androidx.recyclerview.widget.RecyclerView;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Word;
import com.google.android.flexbox.FlexboxLayoutManager;
import defpackage.da5;
import defpackage.vo3;
import j$.net.URLEncoder;
import java.lang.reflect.InvocationTargetException;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import okhttp3.Call;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class pz3 extends uh implements ds2, da5.a, vo3.b {
    public r61 k0;
    public vo3 l0;
    public da5 m0;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends x60 {
        public a() {
        }

        @Override // defpackage.x60, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            pz3.this.X1().invalidateOptionsMenu();
            pz3.this.N2(editable.toString());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends to {
        public final /* synthetic */ boolean f;

        public b(boolean z) {
            this.f = z;
        }

        public final /* synthetic */ void g(String str, boolean z) {
            pz3.this.Z2(str, z);
        }

        @Override // defpackage.to, okhttp3.Callback
        public void onResponse(Call call, Response response) throws IllegalAccessException, InvocationTargetException {
            final String strString = response.body().string();
            if (TextUtils.isEmpty(strString)) {
                return;
            }
            final boolean z = this.f;
            App.d(new Runnable() { // from class: qz3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.g(strString, z);
                }
            });
        }
    }

    private String L2() {
        return S().getString("keyword");
    }

    public static pz3 T2(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("keyword", str);
        pz3 pz3Var = new pz3();
        pz3Var.e2(bundle);
        return pz3Var;
    }

    private void U2() {
        this.k0.b.setText("");
        X1().invalidateOptionsMenu();
    }

    private void W2() {
        if (I2()) {
            return;
        }
        final String strTrim = this.k0.b.getText().toString().trim();
        App.e(new Runnable() { // from class: kz3
            @Override // java.lang.Runnable
            public final void run() {
                this.f.S2(strTrim);
            }
        }, 250L);
        jy4.l(this.k0.b);
        H2(strTrim);
    }

    private void Y2() {
        this.k0.g.setHasFixedSize(false);
        RecyclerView recyclerView = this.k0.g;
        da5 da5Var = new da5(this);
        this.m0 = da5Var;
        recyclerView.setAdapter(da5Var);
        this.k0.g.setLayoutManager(new FlexboxLayoutManager(U(), 0));
        this.k0.d.setHasFixedSize(false);
        RecyclerView recyclerView2 = this.k0.d;
        vo3 vo3Var = new vo3(this);
        this.l0 = vo3Var;
        recyclerView2.setAdapter(vo3Var);
        this.k0.d.setLayoutManager(new FlexboxLayoutManager(U(), 0));
    }

    public final void G2() {
        boolean z = X1().n1().j0(iw.class.getSimpleName()) != null;
        if (TextUtils.isEmpty(L2()) && !z) {
            jy4.p(this.k0.b);
        }
        X2(L2());
        N2(L2());
    }

    public final void H2(String str) {
        k61 k61VarN1 = X1().n1();
        String simpleName = iw.class.getSimpleName();
        if (k61VarN1.j0(simpleName) != null) {
            return;
        }
        String simpleName2 = pz3.class.getSimpleName();
        final d71 d71VarV = k61VarN1.o().v(4097);
        d71VarV.c(nl3.J, iw.K2(str), simpleName);
        Optional.ofNullable(k61VarN1.j0(simpleName2)).ifPresent(new Consumer() { // from class: nz3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                d71VarV.n((p51) obj);
            }
        });
        d71VarV.u(true).g(null).h();
    }

    public final boolean I2() {
        return this.k0.b.getText().toString().trim().isEmpty();
    }

    public final to J2(boolean z) {
        return new b(z);
    }

    public final void K2() {
        this.k0.f.setText(sm3.q0);
        this.m0.R(Word.objectFrom(q24.e()).getData());
        q53.s("https://api.web.360kan.com/v1/rank?cat=1", m41.a(new Map.Entry[]{new AbstractMap.SimpleEntry("Referer", "https://www.360kan.com/rank/general")})).enqueue(J2(true));
    }

    public final void M2(String str) {
        this.k0.f.setText(sm3.r0);
        q53.q("https://suggest.video.iqiyi.com/?if=mobile&key=" + URLEncoder.encode(str)).enqueue(J2(false));
    }

    public final void N2(String str) {
        if (str.isEmpty()) {
            K2();
        } else {
            M2(str);
        }
    }

    public final /* synthetic */ boolean O2(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 3) {
            return true;
        }
        W2();
        return true;
    }

    public final /* synthetic */ void P2(String str, Bundle bundle) {
        if (bundle.getBoolean("edit", false)) {
            jy4.p(this.k0.b);
        }
    }

    public final /* synthetic */ void Q2() {
        this.k0.d.requestLayout();
    }

    public final /* synthetic */ void R2() {
        p84.i(this).l().o();
    }

    public final /* synthetic */ void S2(String str) {
        this.l0.J(str);
    }

    public final void V2() {
        jy4.l(this.k0.b);
        this.k0.b.post(new Runnable() { // from class: oz3
            @Override // java.lang.Runnable
            public final void run() {
                this.f.R2();
            }
        });
    }

    public final void X2(String str) {
        this.k0.b.setText(str);
        this.k0.b.setSelection(str.length());
    }

    public final void Z2(String str, boolean z) {
        if (z || !this.k0.b.getText().toString().trim().isEmpty()) {
            this.m0.R(Word.objectFrom(str).getData());
            if (z) {
                q24.c0(str);
            }
        }
    }

    @Override // da5.a, vo3.b
    public void b(String str) {
        X2(str);
        W2();
    }

    @Override // defpackage.uh, defpackage.p51
    public void c1() {
        super.c1();
        X1().s0(this);
    }

    @Override // defpackage.ds2
    public boolean f(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            X1().y().k();
        }
        if (menuItem.getItemId() == nl3.e) {
            U2();
        }
        if (menuItem.getItemId() != nl3.f) {
            return true;
        }
        V2();
        return true;
    }

    @Override // defpackage.p51
    public void f1(boolean z) {
        if (z) {
            X1().s0(this);
        } else {
            w2();
        }
    }

    @Override // vo3.b
    public void l(int i) {
        this.k0.c.setVisibility(i == 0 ? 8 : 0);
        this.k0.d.setVisibility(i == 0 ? 8 : 0);
        this.k0.d.postDelayed(new Runnable() { // from class: jz3
            @Override // java.lang.Runnable
            public final void run() {
                this.f.Q2();
            }
        }, 250L);
    }

    @Override // defpackage.uh
    public i35 u2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        r61 r61VarC = r61.c(f0());
        this.k0 = r61VarC;
        return r61VarC;
    }

    @Override // defpackage.uh
    public void v2() {
        this.k0.b.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: lz3
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return this.a.O2(textView, i, keyEvent);
            }
        });
        this.k0.b.addTextChangedListener(new a());
        k0().p1("result", C0(), new p61() { // from class: mz3
            @Override // defpackage.p61
            public final void a(String str, Bundle bundle) {
                this.a.P2(str, bundle);
            }
        });
    }

    @Override // defpackage.ds2
    public void w(Menu menu, MenuInflater menuInflater) {
        menuInflater.inflate(im3.c, menu);
    }

    @Override // defpackage.uh
    public void w2() {
        if (I0()) {
            return;
        }
        x7 x7Var = (x7) X1();
        x7Var.D1(this.k0.e);
        x7Var.u1().r(true);
        x7Var.a1(this, C0(), g.b.j);
        x7Var.setTitle("");
    }

    @Override // defpackage.ds2
    public void x(Menu menu) {
        menu.findItem(nl3.e).setVisible(!I2());
    }

    @Override // defpackage.uh
    public void x2() {
        Y2();
        G2();
        W2();
    }
}
