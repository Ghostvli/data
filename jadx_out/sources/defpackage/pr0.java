package defpackage;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class pr0 {
    public final b a;
    public int b = Integer.MAX_VALUE;
    public int c = 0;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a extends b {
        public final EditText a;
        public final xr0 b;

        public a(EditText editText, boolean z) {
            this.a = editText;
            xr0 xr0Var = new xr0(editText, z);
            this.b = xr0Var;
            editText.addTextChangedListener(xr0Var);
            editText.setEditableFactory(qr0.getInstance());
        }

        @Override // pr0.b
        public KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof ur0) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            return keyListener instanceof NumberKeyListener ? keyListener : new ur0(keyListener);
        }

        @Override // pr0.b
        public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection instanceof sr0 ? inputConnection : new sr0(this.a, inputConnection, editorInfo);
        }

        @Override // pr0.b
        public void c(boolean z) {
            this.b.c(z);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public abstract KeyListener a(KeyListener keyListener);

        public abstract InputConnection b(InputConnection inputConnection, EditorInfo editorInfo);

        public abstract void c(boolean z);
    }

    public pr0(EditText editText, boolean z) {
        hg3.h(editText, "editText cannot be null");
        this.a = new a(editText, z);
    }

    public KeyListener a(KeyListener keyListener) {
        return this.a.a(keyListener);
    }

    public InputConnection b(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.a.b(inputConnection, editorInfo);
    }

    public void c(boolean z) {
        this.a.c(z);
    }
}
