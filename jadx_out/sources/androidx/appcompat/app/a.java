package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AlertController;
import defpackage.nk3;
import defpackage.q8;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class a extends q8 implements DialogInterface {
    public final AlertController k;

    public a(Context context, int i) {
        super(context, j(context, i));
        this.k = new AlertController(getContext(), this, getWindow());
    }

    public static int j(Context context, int i) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(nk3.l, typedValue, true);
        return typedValue.resourceId;
    }

    public Button h(int i) {
        return this.k.c(i);
    }

    public ListView i() {
        return this.k.e();
    }

    @Override // defpackage.q8, defpackage.my, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.k.f();
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (this.k.g(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (this.k.h(i, keyEvent)) {
            return true;
        }
        return super.onKeyUp(i, keyEvent);
    }

    @Override // defpackage.q8, android.app.Dialog
    public void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        this.k.q(charSequence);
    }

    /* JADX INFO: renamed from: androidx.appcompat.app.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class C0002a {
        public final AlertController.b a;
        public final int b;

        public C0002a(Context context, int i) {
            this.a = new AlertController.b(new ContextThemeWrapper(context, a.j(context, i)));
            this.b = i;
        }

        public C0002a a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.a;
            bVar.w = listAdapter;
            bVar.x = onClickListener;
            return this;
        }

        public C0002a b(boolean z) {
            this.a.r = z;
            return this;
        }

        public C0002a c(View view) {
            this.a.g = view;
            return this;
        }

        public a create() {
            a aVar = new a(this.a.a, this.b);
            this.a.a(aVar.k);
            aVar.setCancelable(this.a.r);
            if (this.a.r) {
                aVar.setCanceledOnTouchOutside(true);
            }
            aVar.setOnCancelListener(this.a.s);
            aVar.setOnDismissListener(this.a.t);
            DialogInterface.OnKeyListener onKeyListener = this.a.u;
            if (onKeyListener != null) {
                aVar.setOnKeyListener(onKeyListener);
            }
            return aVar;
        }

        public C0002a d(Drawable drawable) {
            this.a.d = drawable;
            return this;
        }

        public C0002a e(int i) {
            AlertController.b bVar = this.a;
            bVar.h = bVar.a.getText(i);
            return this;
        }

        public C0002a f(CharSequence charSequence) {
            this.a.h = charSequence;
            return this;
        }

        public C0002a g(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.a;
            bVar.l = charSequence;
            bVar.n = onClickListener;
            return this;
        }

        public Context getContext() {
            return this.a.a;
        }

        public C0002a h(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.a;
            bVar.o = bVar.a.getText(i);
            this.a.q = onClickListener;
            return this;
        }

        public C0002a i(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.a;
            bVar.o = charSequence;
            bVar.q = onClickListener;
            return this;
        }

        public C0002a j(DialogInterface.OnKeyListener onKeyListener) {
            this.a.u = onKeyListener;
            return this;
        }

        public C0002a k(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.a;
            bVar.w = listAdapter;
            bVar.x = onClickListener;
            bVar.I = i;
            bVar.H = true;
            return this;
        }

        public C0002a l(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.a;
            bVar.v = charSequenceArr;
            bVar.x = onClickListener;
            bVar.I = i;
            bVar.H = true;
            return this;
        }

        public C0002a m(int i) {
            AlertController.b bVar = this.a;
            bVar.f = bVar.a.getText(i);
            return this;
        }

        public a n() {
            a aVarCreate = create();
            aVarCreate.show();
            return aVarCreate;
        }

        public C0002a setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.a;
            bVar.l = bVar.a.getText(i);
            this.a.n = onClickListener;
            return this;
        }

        public C0002a setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
            AlertController.b bVar = this.a;
            bVar.i = bVar.a.getText(i);
            this.a.k = onClickListener;
            return this;
        }

        public C0002a setTitle(CharSequence charSequence) {
            this.a.f = charSequence;
            return this;
        }

        public C0002a setView(View view) {
            AlertController.b bVar = this.a;
            bVar.z = view;
            bVar.y = 0;
            bVar.E = false;
            return this;
        }

        public C0002a(Context context) {
            this(context, a.j(context, 0));
        }
    }
}
