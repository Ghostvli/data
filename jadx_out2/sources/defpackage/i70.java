package defpackage;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import defpackage.l62;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i70 extends l62 {
    public b O;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends i70 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(b bVar) {
            super(bVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.l62
        public void x(Canvas canvas) {
            if (this.O.w.isEmpty()) {
                super.x(canvas);
                return;
            }
            canvas.save();
            int i = Build.VERSION.SDK_INT;
            b bVar = this.O;
            if (i >= 26) {
                canvas.clipOutRect(bVar.w);
            } else {
                canvas.clipRect(bVar.w, Region.Op.DIFFERENCE);
            }
            super.x(canvas);
            canvas.restore();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public i70(b bVar) {
        super(bVar);
        this.O = bVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static i70 A0(y44 y44Var) {
        if (y44Var == null) {
            y44Var = new y44();
        }
        return z0(new b(y44Var, new RectF()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static i70 z0(b bVar) {
        return new c(bVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean B0() {
        return !this.O.w.isEmpty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void C0() {
        D0(0.0f, 0.0f, 0.0f, 0.0f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void D0(float f, float f2, float f3, float f4) {
        if (f == this.O.w.left && f2 == this.O.w.top && f3 == this.O.w.right && f4 == this.O.w.bottom) {
            return;
        }
        this.O.w.set(f, f2, f3, f4);
        invalidateSelf();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void E0(RectF rectF) {
        D0(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.l62, android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.O = new b(this.O);
        return this;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends l62.c {
        public final RectF w;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(b bVar) {
            super(bVar);
            this.w = bVar.w;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // l62.c, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            i70 i70VarZ0 = i70.z0(this);
            i70VarZ0.invalidateSelf();
            return i70VarZ0;
        }

        public b(y44 y44Var, RectF rectF) {
            super(y44Var, null);
            this.w = rectF;
        }
    }
}
