package defpackage;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.widget.ListAdapter;
import androidx.appcompat.app.a;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class o52 extends a.C0002a {
    public static final int e = nk3.k;
    public static final int f = ym3.c;
    public static final int g = mk3.w;
    public Drawable c;
    public final Rect d;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public o52(Context context, int i) {
        super(o(context), q(context, i));
        Context context2 = getContext();
        Resources.Theme theme = context2.getTheme();
        int i2 = e;
        int i3 = f;
        this.d = i62.a(context2, i2, i3);
        int iC = h62.c(context2, mk3.l, getClass().getCanonicalName());
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(null, cn3.H2, i2, i3);
        int color = typedArrayObtainStyledAttributes.getColor(cn3.M2, iC);
        typedArrayObtainStyledAttributes.recycle();
        l62 l62Var = new l62(context2, null, i2, i3);
        l62Var.S(context2);
        l62Var.e0(ColorStateList.valueOf(color));
        if (Build.VERSION.SDK_INT >= 28) {
            TypedValue typedValue = new TypedValue();
            theme.resolveAttribute(R.attr.dialogCornerRadius, typedValue, true);
            float dimension = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            if (typedValue.type == 5 && dimension >= 0.0f) {
                l62Var.b0(dimension);
            }
        }
        this.c = l62Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Context o(Context context) {
        int iP = p(context);
        Context contextD = o62.d(context, null, e, f);
        return iP == 0 ? contextD : new e30(contextD, iP);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int p(Context context) {
        TypedValue typedValueA = p52.a(context, g);
        if (typedValueA == null) {
            return 0;
        }
        return typedValueA.data;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int q(Context context, int i) {
        return i == 0 ? p(context) : i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: i(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroidx/appcompat/app/a$a; */
    @Override // androidx.appcompat.app.a.C0002a
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public o52 i(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (o52) super.i(charSequence, onClickListener);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: j(Landroid/content/DialogInterface$OnKeyListener;)Landroidx/appcompat/app/a$a; */
    @Override // androidx.appcompat.app.a.C0002a
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public o52 j(DialogInterface.OnKeyListener onKeyListener) {
        return (o52) super.j(onKeyListener);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroidx/appcompat/app/a$a; */
    @Override // androidx.appcompat.app.a.C0002a
    /* JADX INFO: renamed from: C, reason: merged with bridge method [inline-methods] */
    public o52 setPositiveButton(int i, DialogInterface.OnClickListener onClickListener) {
        return (o52) super.setPositiveButton(i, onClickListener);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: k(Landroid/widget/ListAdapter;ILandroid/content/DialogInterface$OnClickListener;)Landroidx/appcompat/app/a$a; */
    @Override // androidx.appcompat.app.a.C0002a
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public o52 k(ListAdapter listAdapter, int i, DialogInterface.OnClickListener onClickListener) {
        return (o52) super.k(listAdapter, i, onClickListener);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public o52 E(CharSequence[] charSequenceArr, int i, DialogInterface.OnClickListener onClickListener) {
        return (o52) super.l(charSequenceArr, i, onClickListener);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: m(I)Landroidx/appcompat/app/a$a; */
    @Override // androidx.appcompat.app.a.C0002a
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public o52 m(int i) {
        return (o52) super.m(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: setTitle(Ljava/lang/CharSequence;)Landroidx/appcompat/app/a$a; */
    @Override // androidx.appcompat.app.a.C0002a
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public o52 setTitle(CharSequence charSequence) {
        return (o52) super.setTitle(charSequence);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: setView(Landroid/view/View;)Landroidx/appcompat/app/a$a; */
    @Override // androidx.appcompat.app.a.C0002a
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public o52 setView(View view) {
        return (o52) super.setView(view);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.app.a.C0002a
    public a create() {
        a aVarCreate = super.create();
        Window window = aVarCreate.getWindow();
        View decorView = window.getDecorView();
        Drawable drawable = this.c;
        if (drawable instanceof l62) {
            ((l62) drawable).d0(decorView.getElevation());
        }
        window.setBackgroundDrawable(i62.b(this.c, this.d));
        decorView.setOnTouchListener(new kk1(aVarCreate, this.d));
        return aVarCreate;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a(Landroid/widget/ListAdapter;Landroid/content/DialogInterface$OnClickListener;)Landroidx/appcompat/app/a$a; */
    @Override // androidx.appcompat.app.a.C0002a
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public o52 a(ListAdapter listAdapter, DialogInterface.OnClickListener onClickListener) {
        return (o52) super.a(listAdapter, onClickListener);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: b(Z)Landroidx/appcompat/app/a$a; */
    @Override // androidx.appcompat.app.a.C0002a
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public o52 b(boolean z) {
        return (o52) super.b(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: c(Landroid/view/View;)Landroidx/appcompat/app/a$a; */
    @Override // androidx.appcompat.app.a.C0002a
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public o52 c(View view) {
        return (o52) super.c(view);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: d(Landroid/graphics/drawable/Drawable;)Landroidx/appcompat/app/a$a; */
    @Override // androidx.appcompat.app.a.C0002a
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public o52 d(Drawable drawable) {
        return (o52) super.d(drawable);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: e(I)Landroidx/appcompat/app/a$a; */
    @Override // androidx.appcompat.app.a.C0002a
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public o52 e(int i) {
        return (o52) super.e(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: f(Ljava/lang/CharSequence;)Landroidx/appcompat/app/a$a; */
    @Override // androidx.appcompat.app.a.C0002a
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public o52 f(CharSequence charSequence) {
        return (o52) super.f(charSequence);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroidx/appcompat/app/a$a; */
    @Override // androidx.appcompat.app.a.C0002a
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public o52 setNegativeButton(int i, DialogInterface.OnClickListener onClickListener) {
        return (o52) super.setNegativeButton(i, onClickListener);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: g(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroidx/appcompat/app/a$a; */
    @Override // androidx.appcompat.app.a.C0002a
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public o52 g(CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        return (o52) super.g(charSequence, onClickListener);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: h(ILandroid/content/DialogInterface$OnClickListener;)Landroidx/appcompat/app/a$a; */
    @Override // androidx.appcompat.app.a.C0002a
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public o52 h(int i, DialogInterface.OnClickListener onClickListener) {
        return (o52) super.h(i, onClickListener);
    }

    public o52(Context context) {
        this(context, 0);
    }
}
