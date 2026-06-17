package defpackage;

import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import defpackage.a53;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class dp0 {
    public float a;
    public float b;
    public float c;
    public int d;
    public float[] e = null;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public dp0(dp0 dp0Var) {
        this.a = 0.0f;
        this.b = 0.0f;
        this.c = 0.0f;
        this.d = 0;
        this.a = dp0Var.a;
        this.b = dp0Var.b;
        this.c = dp0Var.c;
        this.d = dp0Var.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a(a53.b bVar) {
        if (Color.alpha(this.d) > 0) {
            bVar.d = this;
        } else {
            bVar.d = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b(Paint paint) {
        if (Color.alpha(this.d) > 0) {
            paint.setShadowLayer(Math.max(this.a, Float.MIN_VALUE), this.b, this.c, this.d);
        } else {
            paint.clearShadowLayer();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c(int i, a53.b bVar) {
        dp0 dp0Var = new dp0(this);
        bVar.d = dp0Var;
        dp0Var.i(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d(int i, Paint paint) {
        int iL = uy4.l(Color.alpha(this.d), ot2.c(i, 0, 255));
        if (iL <= 0) {
            paint.clearShadowLayer();
        } else {
            paint.setShadowLayer(Math.max(this.a, Float.MIN_VALUE), this.b, this.c, Color.argb(iL, Color.red(this.d), Color.green(this.d), Color.blue(this.d)));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int e() {
        return this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float f() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float g() {
        return this.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public float h() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i(int i) {
        this.d = Color.argb(Math.round((Color.alpha(this.d) * ot2.c(i, 0, 255)) / 255.0f), Color.red(this.d), Color.green(this.d), Color.blue(this.d));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean j(dp0 dp0Var) {
        return this.a == dp0Var.a && this.b == dp0Var.b && this.c == dp0Var.c && this.d == dp0Var.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k(Matrix matrix) {
        if (this.e == null) {
            this.e = new float[2];
        }
        float[] fArr = this.e;
        fArr[0] = this.b;
        fArr[1] = this.c;
        matrix.mapVectors(fArr);
        float[] fArr2 = this.e;
        this.b = fArr2[0];
        this.c = fArr2[1];
        this.a = matrix.mapRadius(this.a);
    }

    public dp0(float f, float f2, float f3, int i) {
        this.a = f;
        this.b = f2;
        this.c = f3;
        this.d = i;
    }
}
