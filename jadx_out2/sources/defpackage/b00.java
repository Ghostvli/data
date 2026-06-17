package defpackage;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.fongmi.android.tv.bean.Config;
import com.google.android.material.textfield.TextInputEditText;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class b00 {
    public q3 a;
    public final sk0 b;
    public final gz c;
    public androidx.appcompat.app.a d;
    public boolean e = true;
    public boolean f;
    public String g;
    public int h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends x60 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.x60, android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            b00.this.g(charSequence.toString());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: p51 */
    /* JADX WARN: Multi-variable type inference failed */
    public b00(p51 p51Var) {
        this.c = (gz) p51Var;
        this.b = sk0.c(LayoutInflater.from(p51Var.U()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static b00 f(p51 p51Var) {
        return new b00(p51Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(String str) {
        if (this.e && "h".equalsIgnoreCase(str)) {
            this.e = false;
            this.b.e.append("ttp://");
            return;
        }
        if (this.e && "f".equalsIgnoreCase(str)) {
            this.e = false;
            this.b.e.append("ile://");
            return;
        }
        if (this.e && "a".equalsIgnoreCase(str)) {
            this.e = false;
            this.b.e.append("ssets://");
        } else if (str.length() > 1) {
            this.e = false;
        } else if (str.isEmpty()) {
            this.e = true;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b00 h() {
        this.f = true;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Config i() {
        int i = this.h;
        if (i == 0) {
            return b75.I().i();
        }
        if (i == 1) {
            return lx1.J().i();
        }
        if (i != 2) {
            return null;
        }
        return m85.x().i();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j() {
        o52 o52Var = new o52(this.b.getRoot().getContext());
        int i = this.h;
        androidx.appcompat.app.a aVarCreate = o52Var.m(i == 0 ? sm3.y0 : i == 1 ? sm3.t0 : sm3.z0).setView(this.b.getRoot()).setPositiveButton(this.f ? sm3.t : sm3.v, new DialogInterface.OnClickListener() { // from class: zz
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f.q(dialogInterface, i2);
            }
        }).setNegativeButton(sm3.u, new DialogInterface.OnClickListener() { // from class: a00
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                this.f.p(dialogInterface, i2);
            }
        }).create();
        this.d = aVarCreate;
        aVarCreate.getWindow().setDimAmount(0.0f);
        this.d.show();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k() {
        this.b.b.setEndIconOnClickListener(new View.OnClickListener() { // from class: xz
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.o(view);
            }
        });
        this.b.e.addTextChangedListener(new a());
        this.b.e.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: yz
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return this.a.m(textView, i, keyEvent);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l() {
        this.b.d.setText(i().getName());
        TextInputEditText textInputEditText = this.b.e;
        String url = i().getUrl();
        this.g = url;
        textInputEditText.setText(url);
        this.b.c.setVisibility(this.f ? 0 : 8);
        this.b.e.setSelection(TextUtils.isEmpty(this.g) ? 0 : this.g.length());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ boolean m(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return true;
        }
        this.d.h(-1).performClick();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b00 n(q3 q3Var) {
        this.a = q3Var;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o(View view) {
        g01.b(this.a).s();
        this.d.dismiss();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void p(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q(DialogInterface dialogInterface, int i) {
        String strTrim = this.b.e.getText().toString().trim();
        String strTrim2 = this.b.d.getText().toString().trim();
        if (this.f) {
            Config.find(this.g, this.h).url(strTrim).name(strTrim2).update();
        }
        if (strTrim.isEmpty()) {
            Config.delete(this.g, this.h);
        }
        this.c.b0(Config.find(strTrim, this.h));
        dialogInterface.dismiss();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void r() {
        j();
        l();
        k();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b00 s(int i) {
        this.h = i;
        return this;
    }
}
