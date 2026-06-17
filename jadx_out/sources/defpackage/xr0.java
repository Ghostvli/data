package defpackage;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.c;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class xr0 implements TextWatcher {
    public final EditText f;
    public final boolean g;
    public c.f h;
    public int i = Integer.MAX_VALUE;
    public int j = 0;
    public boolean k = true;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends c.f {
        public final Reference a;

        public a(EditText editText) {
            this.a = new WeakReference(editText);
        }

        @Override // androidx.emoji2.text.c.f
        public void b() {
            super.b();
            xr0.b((EditText) this.a.get(), 1);
        }
    }

    public xr0(EditText editText, boolean z) {
        this.f = editText;
        this.g = z;
    }

    public static void b(EditText editText, int i) {
        if (i == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            c.c().p(editableText);
            tr0.b(editableText, selectionStart, selectionEnd);
        }
    }

    public final c.f a() {
        if (this.h == null) {
            this.h = new a(this.f);
        }
        return this.h;
    }

    @Override // android.text.TextWatcher
    public void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void c(boolean z) {
        if (this.k != z) {
            if (this.h != null) {
                c.c().u(this.h);
            }
            this.k = z;
            if (z) {
                b(this.f, c.c().e());
            }
        }
    }

    public final boolean d() {
        if (this.k) {
            return (this.g || c.i()) ? false : true;
        }
        return true;
    }

    @Override // android.text.TextWatcher
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (this.f.isInEditMode() || d() || i2 > i3 || !(charSequence instanceof Spannable)) {
            return;
        }
        int iE = c.c().e();
        if (iE != 0) {
            if (iE == 1) {
                c.c().s((Spannable) charSequence, i, i + i3, this.i, this.j);
                return;
            } else if (iE != 3) {
                return;
            }
        }
        c.c().t(a());
    }
}
