package defpackage;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import defpackage.ys4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class qi1 extends y45 implements ys4.a {
    public Animatable m;

    public qi1(ImageView imageView) {
        super(imageView);
    }

    @Override // defpackage.zs1
    public void b() {
        Animatable animatable = this.m;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // defpackage.rl4
    public void d(Object obj, ys4 ys4Var) {
        if (ys4Var == null || !ys4Var.a(obj, this)) {
            r(obj);
        } else {
            o(obj);
        }
    }

    @Override // defpackage.yi, defpackage.rl4
    public void j(Drawable drawable) {
        super.j(drawable);
        r(null);
        p(drawable);
    }

    @Override // defpackage.y45, defpackage.yi, defpackage.rl4
    public void k(Drawable drawable) {
        super.k(drawable);
        r(null);
        p(drawable);
    }

    @Override // defpackage.y45, defpackage.yi, defpackage.rl4
    public void m(Drawable drawable) {
        super.m(drawable);
        Animatable animatable = this.m;
        if (animatable != null) {
            animatable.stop();
        }
        r(null);
        p(drawable);
    }

    public final void o(Object obj) {
        if (!(obj instanceof Animatable)) {
            this.m = null;
            return;
        }
        Animatable animatable = (Animatable) obj;
        this.m = animatable;
        animatable.start();
    }

    @Override // defpackage.zs1
    public void onStop() {
        Animatable animatable = this.m;
        if (animatable != null) {
            animatable.stop();
        }
    }

    public void p(Drawable drawable) {
        ((ImageView) this.f).setImageDrawable(drawable);
    }

    public abstract void q(Object obj);

    public final void r(Object obj) {
        q(obj);
        o(obj);
    }
}
