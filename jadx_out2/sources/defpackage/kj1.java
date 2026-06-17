package defpackage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import defpackage.no0;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class kj1 extends ho0 {
    public no0 w;
    public jj1 x;
    public Drawable y;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public kj1(Context context, oi oiVar, no0 no0Var, jj1 jj1Var) {
        super(context, oiVar);
        B(no0Var);
        A(jj1Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static kj1 v(Context context, ju juVar, eu euVar) {
        kj1 kj1Var = new kj1(context, juVar, euVar, juVar.q == 1 ? new gu(context, juVar) : new fu(juVar));
        kj1Var.C(gz4.b(context.getResources(), gl3.b, null));
        return kj1Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static kj1 w(Context context, nt1 nt1Var, jt1 jt1Var) {
        return new kj1(context, nt1Var, jt1Var, nt1Var.q == 0 ? new kt1(nt1Var) : new lt1(context, nt1Var));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void A(jj1 jj1Var) {
        this.x = jj1Var;
        jj1Var.e(this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void B(no0 no0Var) {
        this.w = no0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void C(Drawable drawable) {
        this.y = drawable;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0106  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void draw(Canvas canvas) {
        int i;
        Drawable drawable;
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(this.u)) {
            if (z() && (drawable = this.y) != null) {
                drawable.setBounds(getBounds());
                this.y.setTint(this.g.e[0]);
                this.y.draw(canvas);
                return;
            }
            canvas.save();
            this.w.h(canvas, getBounds(), h(), m(), l());
            int i2 = this.g.i;
            int alpha = getAlpha();
            oi oiVar = this.g;
            boolean z = (oiVar instanceof nt1) || ((oiVar instanceof ju) && ((ju) oiVar).u);
            boolean z2 = z && i2 == 0 && !oiVar.b(false);
            if (!z2) {
                if (z) {
                    no0.a aVar = (no0.a) this.x.b.get(0);
                    List list = this.x.b;
                    no0.a aVar2 = (no0.a) list.get(list.size() - 1);
                    no0 no0Var = this.w;
                    if (no0Var instanceof jt1) {
                        i = i2;
                        no0Var.d(canvas, this.s, 0.0f, aVar.a, this.g.f, alpha, i);
                        this.w.d(canvas, this.s, aVar2.b, 1.0f, this.g.f, alpha, i);
                    } else {
                        i = i2;
                        canvas.save();
                        canvas.rotate(aVar2.g);
                        this.w.d(canvas, this.s, aVar2.b, aVar.a + 1.0f, this.g.f, alpha, i);
                        canvas.restore();
                    }
                }
                for (int i3 = 0; i3 < this.x.b.size(); i3++) {
                    no0.a aVar3 = (no0.a) this.x.b.get(i3);
                    aVar3.f = i();
                    this.w.c(canvas, this.s, aVar3, getAlpha());
                    if (i3 > 0 && !z2 && z) {
                        this.w.d(canvas, this.s, ((no0.a) this.x.b.get(i3 - 1)).b, aVar3.a, this.g.f, alpha, i);
                    }
                }
                canvas.restore();
            }
            this.w.d(canvas, this.s, 0.0f, 1.0f, this.g.f, alpha, 0);
            i = i2;
            while (i3 < this.x.b.size()) {
            }
            canvas.restore();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.w.e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.w.f();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0
    public /* bridge */ /* synthetic */ boolean l() {
        return super.l();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0
    public /* bridge */ /* synthetic */ boolean m() {
        return super.m();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0
    public /* bridge */ /* synthetic */ void o(h6 h6Var) {
        super.o(h6Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0
    public /* bridge */ /* synthetic */ boolean s(boolean z, boolean z2, boolean z3) {
        return super.s(z, z2, z3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0
    public boolean t(boolean z, boolean z2, boolean z3) {
        Drawable drawable;
        boolean zT = super.t(z, z2, z3);
        if (z() && (drawable = this.y) != null) {
            return drawable.setVisible(z, z2);
        }
        if (!isRunning()) {
            this.x.a();
        }
        if (z && z3) {
            this.x.g();
        }
        return zT;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ho0
    public /* bridge */ /* synthetic */ boolean u(h6 h6Var) {
        return super.u(h6Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public jj1 x() {
        return this.x;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public no0 y() {
        return this.w;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean z() {
        m7 m7Var = this.h;
        return m7Var != null && m7Var.a(this.f.getContentResolver()) == 0.0f;
    }
}
