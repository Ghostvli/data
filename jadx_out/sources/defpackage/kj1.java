package defpackage;

import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class kj1 extends ho0 {
    public no0 w;
    public jj1 x;
    public Drawable y;

    public kj1(Context context, oi oiVar, no0 no0Var, jj1 jj1Var) {
        super(context, oiVar);
        B(no0Var);
        A(jj1Var);
    }

    public static kj1 v(Context context, ju juVar, eu euVar) {
        kj1 kj1Var = new kj1(context, juVar, euVar, juVar.q == 1 ? new gu(context, juVar) : new fu(juVar));
        kj1Var.C(gz4.b(context.getResources(), gl3.b, null));
        return kj1Var;
    }

    public static kj1 w(Context context, nt1 nt1Var, jt1 jt1Var) {
        return new kj1(context, nt1Var, jt1Var, nt1Var.q == 0 ? new kt1(nt1Var) : new lt1(context, nt1Var));
    }

    public void A(jj1 jj1Var) {
        this.x = jj1Var;
        jj1Var.e(this);
    }

    public void B(no0 no0Var) {
        this.w = no0Var;
    }

    public void C(Drawable drawable) {
        this.y = drawable;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0106  */
    @Override // android.graphics.drawable.Drawable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void draw(android.graphics.Canvas r14) {
        /*
            Method dump skipped, instruction units count: 335
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kj1.draw(android.graphics.Canvas):void");
    }

    @Override // defpackage.ho0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.w.e();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.w.f();
    }

    @Override // defpackage.ho0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    @Override // defpackage.ho0, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // defpackage.ho0
    public /* bridge */ /* synthetic */ boolean j() {
        return super.j();
    }

    @Override // defpackage.ho0
    public /* bridge */ /* synthetic */ boolean l() {
        return super.l();
    }

    @Override // defpackage.ho0
    public /* bridge */ /* synthetic */ boolean m() {
        return super.m();
    }

    @Override // defpackage.ho0
    public /* bridge */ /* synthetic */ void o(h6 h6Var) {
        super.o(h6Var);
    }

    @Override // defpackage.ho0
    public /* bridge */ /* synthetic */ boolean s(boolean z, boolean z2, boolean z3) {
        return super.s(z, z2, z3);
    }

    @Override // defpackage.ho0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // defpackage.ho0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    @Override // defpackage.ho0, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2);
    }

    @Override // defpackage.ho0, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // defpackage.ho0, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

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

    @Override // defpackage.ho0
    public /* bridge */ /* synthetic */ boolean u(h6 h6Var) {
        return super.u(h6Var);
    }

    public jj1 x() {
        return this.x;
    }

    public no0 y() {
        return this.w;
    }

    public final boolean z() {
        m7 m7Var = this.h;
        return m7Var != null && m7Var.a(this.f.getContentResolver()) == 0.0f;
    }
}
