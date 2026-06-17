package defpackage;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.google.android.material.bottomsheet.b;
import java.util.Iterator;
import org.mozilla.javascript.Context;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class w83 extends nh {
    public u83 A0;
    public el0 z0;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static w83 V2() {
        return new w83();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.nh
    public i35 M2(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        el0 el0VarC = el0.c(layoutInflater, viewGroup, false);
        this.z0 = el0VarC;
        return el0VarC;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.nh
    public void N2() {
        this.z0.b.setOnEditorActionListener(new TextView.OnEditorActionListener() { // from class: v83
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.widget.TextView.OnEditorActionListener
            public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                return this.a.W2(textView, i, keyEvent);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean W2(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6) {
            return true;
        }
        X2();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void X2() {
        String strTrim = this.z0.b.getText().toString().trim();
        if (!strTrim.isEmpty()) {
            this.A0.n0(strTrim);
        }
        w2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: u51 */
    /* JADX WARN: Multi-variable type inference failed */
    public void Y2(u51 u51Var) {
        Iterator it = u51Var.n1().w0().iterator();
        while (it.hasNext()) {
            if (((p51) it.next()) instanceof b) {
                return;
            }
        }
        G2(u51Var.n1(), null);
        this.A0 = (u83) u51Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.p51
    public void q1() {
        super.q1();
        z2().getWindow().setLayout(vr3.a(Context.VERSION_ECMASCRIPT), -1);
    }
}
