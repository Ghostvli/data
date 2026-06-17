package defpackage;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class uj1 {
    public final bl0 a;
    public final a b;
    public androidx.appcompat.app.a c;
    public CharSequence d;
    public String e;
    public String f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void P0(CharSequence charSequence);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public uj1(Activity activity) {
        this.a = bl0.c(LayoutInflater.from(activity));
        this.b = (a) activity;
    }

    public static uj1 d(Activity activity) {
        return new uj1(activity);
    }

    public final String e(String str) {
        return TextUtils.isEmpty(str) ? "" : str.startsWith("data") ? str.substring(0, Math.min(str.length(), 128)).concat("...") : str;
    }

    public uj1 f(Map map) {
        StringBuilder sb = new StringBuilder();
        for (String str : map.keySet()) {
            sb.append(str);
            sb.append(" : ");
            sb.append((String) map.get(str));
            sb.append("\n");
        }
        this.e = jy4.s(sb.toString());
        return this;
    }

    public final void g() {
        androidx.appcompat.app.a aVarCreate = new o52(this.a.getRoot().getContext()).setView(this.a.getRoot()).create();
        this.c = aVarCreate;
        aVarCreate.getWindow().setDimAmount(0.0f);
        this.c.show();
    }

    public final void h() {
        this.a.d.setOnClickListener(new View.OnClickListener() { // from class: rj1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.m(view);
            }
        });
        this.a.d.setOnLongClickListener(new View.OnLongClickListener() { // from class: sj1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.j(view);
            }
        });
        this.a.b.setOnLongClickListener(new View.OnLongClickListener() { // from class: tj1
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                return this.f.k(view);
            }
        });
    }

    public final void i() {
        this.a.d.setText(this.f);
        this.a.c.setText(this.d);
        this.a.b.setText(this.e);
        this.a.c.setSingleLine(this.d.toString().contains(this.f));
        this.a.d.setVisibility(TextUtils.isEmpty(this.f) ? 8 : 0);
        this.a.b.setVisibility(TextUtils.isEmpty(this.e) ? 8 : 0);
    }

    public final /* synthetic */ boolean j(View view) {
        return l(this.f);
    }

    public final /* synthetic */ boolean k(View view) {
        return l(this.e);
    }

    public final boolean l(String str) {
        jy4.c(str);
        return true;
    }

    public final void m(View view) {
        this.b.P0(this.d);
        this.c.dismiss();
    }

    public void n() {
        g();
        i();
        h();
    }

    public uj1 o(CharSequence charSequence) {
        this.d = charSequence;
        return this;
    }

    public uj1 p(String str) {
        this.f = e(str);
        return this;
    }
}
