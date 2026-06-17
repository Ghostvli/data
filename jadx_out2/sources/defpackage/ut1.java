package defpackage;

import android.content.DialogInterface;
import android.text.InputFilter;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.a;
import com.fongmi.android.tv.ui.activity.VideoActivity;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ut1 {
    public q3 a;
    public final cl0 b;
    public final p51 c;
    public a d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ut1(p51 p51Var) {
        this.c = p51Var;
        this.b = cl0.c(LayoutInflater.from(p51Var.U()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ut1 e(p51 p51Var) {
        return new ut1(p51Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void f() {
        a aVarCreate = new o52(this.b.getRoot().getContext()).m(sm3.S).setView(this.b.getRoot()).setPositiveButton(sm3.v, new DialogInterface.OnClickListener() { // from class: qt1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f.m(dialogInterface, i);
            }
        }).setNegativeButton(sm3.u, new DialogInterface.OnClickListener() { // from class: rt1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                this.f.l(dialogInterface, i);
            }
        }).create();
        this.d = aVarCreate;
        aVarCreate.getWindow().setDimAmount(0.0f);
        this.d.show();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g() {
        this.b.b.setEndIconOnClickListener(new View.OnClickListener() { // from class: st1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f.k(view);
            }
        });
        this.b.c.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: tt1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return this.a.i(textView, i, keyEvent);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h() {
        CharSequence charSequenceG = jy4.g();
        this.b.c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Integer.MAX_VALUE)});
        if (TextUtils.isEmpty(charSequenceG)) {
            return;
        }
        this.b.c.setText(u94.d(charSequenceG.toString()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ boolean i(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return true;
        }
        this.d.h(-1).performClick();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ut1 j(q3 q3Var) {
        this.a = q3Var;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k(View view) {
        g01.b(this.a).s();
        this.d.dismiss();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m(DialogInterface dialogInterface, int i) {
        String strTrim = this.b.c.getText().toString().trim();
        if (!strTrim.isEmpty()) {
            VideoActivity.l8(this.c.X1(), strTrim);
        }
        dialogInterface.dismiss();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void n() {
        f();
        h();
        g();
    }
}
