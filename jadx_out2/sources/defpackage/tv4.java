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
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.x60, android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            tv4.this.f(charSequence.toString());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: p51 */
    /* JADX WARN: Multi-variable type inference failed */
    public tv4(p51 p51Var) {
        this.b = (pv4) p51Var;
        this.a = ml0.c(LayoutInflater.from(p51Var.U()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static tv4 e(p51 p51Var) {
        return new tv4(p51Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g() {
        androidx.appcompat.app.a aVarCreate = new o52(this.a.getRoot().getContext()).m(sm3.l0).setView(this.a.getRoot()).setPositiveButton(sm3.v, new DialogInterface.OnClickListener() { // from class: rv4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f.l(dialogInterface, i);
            }
        }).setNegativeButton(sm3.u, new DialogInterface.OnClickListener() { // from class: sv4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f.k(dialogInterface, i);
            }
        }).create();
        this.c = aVarCreate;
        aVarCreate.getWindow().setDimAmount(0.0f);
        this.c.show();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h() {
        this.a.c.addTextChangedListener(new a());
        this.a.c.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: qv4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return this.a.j(textView, i, keyEvent);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i() {
        String strS = q24.s();
        this.a.c.setText(strS);
        this.a.c.setSelection(TextUtils.isEmpty(strS) ? 0 : strS.length());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ boolean j(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return true;
        }
        this.c.h(-1).performClick();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l(DialogInterface dialogInterface, int i) {
        this.b.n(this.a.c.getText().toString().trim());
        dialogInterface.dismiss();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m() {
        g();
        i();
        h();
    }
}
