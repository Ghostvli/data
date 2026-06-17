package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import defpackage.no0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class kt1 extends jj1 {
    public static final Property i = new b(Float.class, "animationFraction");
    public ObjectAnimator c;
    public yz0 d;
    public final oi e;
    public int f;
    public boolean g;
    public float h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            kt1 kt1Var = kt1.this;
            kt1Var.f = (kt1Var.f + 1) % kt1.this.e.e.length;
            kt1.this.g = true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends Property {
        public b(Class cls, String str) {
            super(cls, str);
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Float get(kt1 kt1Var) {
            return Float.valueOf(kt1Var.n());
        }

        @Override // android.util.Property
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void set(kt1 kt1Var, Float f) {
            kt1Var.r(f.floatValue());
        }
    }

    public kt1(nt1 nt1Var) {
        super(3);
        this.f = 1;
        this.e = nt1Var;
        this.d = new yz0();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float n() {
        return this.h;
    }

    private void o() {
        if (this.c == null) {
            ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this, (Property<kt1, Float>) i, 0.0f, 1.0f);
            this.c = objectAnimatorOfFloat;
            objectAnimatorOfFloat.setDuration((long) (this.e.n * 333.0f));
            this.c.setInterpolator(null);
            this.c.setRepeatCount(-1);
            this.c.addListener(new a());
        }
    }

    private void s() {
        o();
        this.c.setDuration((long) (this.e.n * 333.0f));
    }

    private void t(int i2) {
        ((no0.a) this.b.get(0)).a = 0.0f;
        float fB = b(i2, 0, 667);
        no0.a aVar = (no0.a) this.b.get(0);
        no0.a aVar2 = (no0.a) this.b.get(1);
        float interpolation = this.d.getInterpolation(fB);
        aVar2.a = interpolation;
        aVar.b = interpolation;
        no0.a aVar3 = (no0.a) this.b.get(1);
        no0.a aVar4 = (no0.a) this.b.get(2);
        float interpolation2 = this.d.getInterpolation(fB + 0.49925038f);
        aVar4.a = interpolation2;
        aVar3.b = interpolation2;
        ((no0.a) this.b.get(2)).b = 1.0f;
    }

    @Override // defpackage.jj1
    public void a() {
        ObjectAnimator objectAnimator = this.c;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // defpackage.jj1
    public void c() {
        s();
        q();
    }

    @Override // defpackage.jj1
    public void d(h6 h6Var) {
    }

    @Override // defpackage.jj1
    public void f() {
    }

    @Override // defpackage.jj1
    public void g() {
        o();
        q();
        this.c.start();
    }

    @Override // defpackage.jj1
    public void h() {
    }

    public final void p() {
        if (!this.g || ((no0.a) this.b.get(1)).b >= 1.0f) {
            return;
        }
        ((no0.a) this.b.get(2)).c = ((no0.a) this.b.get(1)).c;
        ((no0.a) this.b.get(1)).c = ((no0.a) this.b.get(0)).c;
        ((no0.a) this.b.get(0)).c = this.e.e[this.f];
        this.g = false;
    }

    public void q() {
        this.g = true;
        this.f = 1;
        for (no0.a aVar : this.b) {
            oi oiVar = this.e;
            aVar.c = oiVar.e[0];
            aVar.d = oiVar.i / 2;
        }
    }

    public void r(float f) {
        this.h = f;
        t((int) (f * 333.0f));
        p();
        this.a.invalidateSelf();
    }
}
