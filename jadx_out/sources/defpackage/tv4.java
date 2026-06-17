package defpackage;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.github.catvod.utils.Util;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class tv4 {
    public final ml0 a;
    public final pv4 b;
    public androidx.appcompat.app.a c;
    public boolean d = true;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends x60 {
        public a() {
        }

        @Override // defpackage.x60, android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            tv4.this.f(charSequence.toString());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public tv4(p51 p51Var) {
        this.b = (pv4) p51Var;
        this.a = ml0.c(LayoutInflater.from(p51Var.U()));
    }

    public static tv4 e(p51 p51Var) {
        return new tv4(p51Var);
    }

    public final void f(String str) {
        if (this.d && "c".equalsIgnoreCase(str)) {
            this.d = false;
            this.a.c.setText(Util.CHROME);
            return;
        }
        if (this.d && "o".equalsIgnoreCase(str)) {
            this.d = false;
            this.a.c.setText(Util.OKHTTP);
        } else if (str.length() > 1) {
            this.d = false;
        } else if (str.isEmpty()) {
            this.d = true;
        }
    }

    public final void g() {
        androidx.appcompat.app.a aVarCreate = new o52(this.a.getRoot().getContext()).m(sm3.l0).setView(this.a.getRoot()).setPositiveButton(sm3.v, new DialogInterface.OnClickListener() { // from class: rv4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f.l(dialogInterface, i);
            }
        }).setNegativeButton(sm3.u, new DialogInterface.OnClickListener() { // from class: sv4
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f.k(dialogInterface, i);
            }
        }).create();
        this.c = aVarCreate;
        aVarCreate.getWindow().setDimAmount(0.0f);
        this.c.show();
    }

    public final void h() {
        this.a.c.addTextChangedListener(new a());
        this.a.c.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: qv4
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return this.a.j(textView, i, keyEvent);
            }
        });
    }

    public final void i() {
        String strS = q24.s();
        this.a.c.setText(strS);
        this.a.c.setSelection(TextUtils.isEmpty(strS) ? 0 : strS.length());
    }

    public final /* synthetic */ boolean j(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return true;
        }
        this.c.h(-1).performClick();
        return true;
    }

    public final void k(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    public final void l(DialogInterface dialogInterface, int i) {
        this.b.n(this.a.c.getText().toString().trim());
        dialogInterface.dismiss();
    }

    public void m() {
        g();
        i();
        h();
    }
}
