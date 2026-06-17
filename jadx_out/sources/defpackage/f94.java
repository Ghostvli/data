package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class f94 implements jk {
    public final jk a;
    public final wi1 b;

    public f94(jk jkVar, wi1 wi1Var) {
        this.a = jkVar;
        this.b = wi1Var;
    }

    @Override // defpackage.jk
    public lu1 a(Uri uri) {
        return x81.g(this.a.a(uri), new e94(this), du2.b());
    }

    @Override // defpackage.jk
    public lu1 b(ph2 ph2Var) {
        lu1 lu1VarB = this.a.b(ph2Var);
        if (lu1VarB == null) {
            return null;
        }
        return x81.g(lu1VarB, new e94(this), du2.b());
    }

    @Override // defpackage.jk
    public lu1 c(byte[] bArr) {
        return x81.g(this.a.c(bArr), new e94(this), du2.b());
    }

    public final Bitmap e(Bitmap bitmap) {
        int height = bitmap.getHeight();
        int width = bitmap.getWidth();
        if (!this.b.a(Math.max(height, width))) {
            return bitmap;
        }
        if (this.b.a(height)) {
            height--;
        }
        if (this.b.a(width)) {
            width--;
        }
        return ok.b(Bitmap.createScaledBitmap(bitmap, width, height, true));
    }
}
