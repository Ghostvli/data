package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import defpackage.y91;
import java.nio.ByteBuffer;
import java.util.List;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class r91 extends Drawable implements y91.b, Animatable {
    public final a f;
    public boolean g;
    public boolean h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public boolean m;
    public Paint n;
    public Rect o;
    public List p;

    public r91(Context context, q91 q91Var, ns4 ns4Var, int i, int i2, Bitmap bitmap) {
        this(new a(new y91(com.bumptech.glide.a.c(context), q91Var, i, i2, ns4Var, bitmap)));
    }

    @Override // y91.b
    public void a() {
        if (b() == null) {
            stop();
            invalidateSelf();
            return;
        }
        invalidateSelf();
        if (g() == f() - 1) {
            this.k++;
        }
        int i = this.l;
        if (i == -1 || this.k < i) {
            return;
        }
        stop();
        j();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Drawable.Callback b() {
        Drawable.Callback callback = getCallback();
        while (callback instanceof Drawable) {
            callback = ((Drawable) callback).getCallback();
        }
        return callback;
    }

    public ByteBuffer c() {
        return this.f.a.b();
    }

    public final Rect d() {
        if (this.o == null) {
            this.o = new Rect();
        }
        return this.o;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.i) {
            return;
        }
        if (this.m) {
            Gravity.apply(Token.INC, getIntrinsicWidth(), getIntrinsicHeight(), getBounds(), d());
            this.m = false;
        }
        canvas.drawBitmap(this.f.a.c(), (Rect) null, d(), h());
    }

    public Bitmap e() {
        return this.f.a.e();
    }

    public int f() {
        return this.f.a.f();
    }

    public int g() {
        return this.f.a.d();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.f;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f.a.h();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f.a.k();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -2;
    }

    public final Paint h() {
        if (this.n == null) {
            this.n = new Paint(2);
        }
        return this.n;
    }

    public int i() {
        return this.f.a.j();
    }

    @Override // android.graphics.drawable.Animatable
    public boolean isRunning() {
        return this.g;
    }

    public final void j() {
        List list = this.p;
        if (list != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                ((h6) this.p.get(i)).b(this);
            }
        }
    }

    public void k() {
        this.i = true;
        this.f.a.a();
    }

    public final void l() {
        this.k = 0;
    }

    public void m(ns4 ns4Var, Bitmap bitmap) {
        this.f.a.o(ns4Var, bitmap);
    }

    public final void n() {
        fg3.b(!this.i, "You cannot start a recycled Drawable. Ensure thatyou clear any references to the Drawable when clearing the corresponding request.");
        if (this.f.a.f() == 1) {
            invalidateSelf();
        } else {
            if (this.g) {
                return;
            }
            this.g = true;
            this.f.a.r(this);
            invalidateSelf();
        }
    }

    public final void o() {
        this.g = false;
        this.f.a.s(this);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.m = true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        h().setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        h().setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        fg3.b(!this.i, "Cannot change the visibility of a recycled resource. Ensure that you unset the Drawable from your View before changing the View's visibility.");
        this.j = z;
        if (!z) {
            o();
        } else if (this.h) {
            n();
        }
        return super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Animatable
    public void start() {
        this.h = true;
        l();
        if (this.j) {
            n();
        }
    }

    @Override // android.graphics.drawable.Animatable
    public void stop() {
        this.h = false;
        o();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends Drawable.ConstantState {
        public final y91 a;

        public a(y91 y91Var) {
            this.a = y91Var;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new r91(this);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return newDrawable();
        }
    }

    public r91(a aVar) {
        this.j = true;
        this.l = -1;
        this.f = (a) fg3.e(aVar);
    }
}
