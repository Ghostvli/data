package defpackage;

import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.textfield.a;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class c93 extends ss0 {
    public int e;
    public EditText f;
    public final View.OnClickListener g;

    public c93(a aVar, int i) {
        super(aVar);
        this.e = gl3.a;
        this.g = new View.OnClickListener() { // from class: b93
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c93.v(this.f, view);
            }
        };
        if (i != 0) {
            this.e = i;
        }
    }

    public static /* synthetic */ void v(c93 c93Var, View view) {
        EditText editText = c93Var.f;
        if (editText == null) {
            return;
        }
        int selectionEnd = editText.getSelectionEnd();
        boolean zW = c93Var.w();
        EditText editText2 = c93Var.f;
        if (zW) {
            editText2.setTransformationMethod(null);
        } else {
            editText2.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
        if (selectionEnd >= 0) {
            c93Var.f.setSelection(selectionEnd);
        }
        c93Var.r();
    }

    public static boolean x(EditText editText) {
        if (editText != null) {
            return editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224;
        }
        return false;
    }

    @Override // defpackage.ss0
    public void b(CharSequence charSequence, int i, int i2, int i3) {
        r();
    }

    @Override // defpackage.ss0
    public int c() {
        return tm3.v;
    }

    @Override // defpackage.ss0
    public int d() {
        return this.e;
    }

    @Override // defpackage.ss0
    public View.OnClickListener f() {
        return this.g;
    }

    @Override // defpackage.ss0
    public boolean l() {
        return true;
    }

    @Override // defpackage.ss0
    public boolean m() {
        return !w();
    }

    @Override // defpackage.ss0
    public void n(EditText editText) {
        this.f = editText;
        r();
    }

    @Override // defpackage.ss0
    public void s() {
        if (x(this.f)) {
            this.f.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    @Override // defpackage.ss0
    public void u() {
        EditText editText = this.f;
        if (editText != null) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }

    public final boolean w() {
        EditText editText = this.f;
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }
}
