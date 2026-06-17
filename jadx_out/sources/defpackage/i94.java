package defpackage;

import android.graphics.Bitmap;
import android.net.Uri;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class i94 implements jk {
    public final jk a;
    public final int b;
    public final boolean c;

    public i94(jk jkVar, int i, boolean z) {
        this.a = jkVar;
        this.b = i;
        this.c = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Bitmap e(Bitmap bitmap) {
        if (bitmap.getWidth() > this.b || bitmap.getHeight() > this.b) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i = this.b;
            float f = width;
            float f2 = height;
            float fMin = Math.min(i / f, i / f2);
            bitmap = Bitmap.createScaledBitmap(bitmap, (int) (f * fMin), (int) (f2 * fMin), true);
        }
        return this.c ? ok.b(bitmap) : bitmap;
    }

    @Override // defpackage.jk
    public lu1 a(Uri uri) {
        return x81.g(this.a.a(uri), new h94(this), du2.b());
    }

    @Override // defpackage.jk
    public lu1 b(ph2 ph2Var) {
        lu1 lu1VarB = this.a.b(ph2Var);
        if (lu1VarB == null) {
            return null;
        }
        return x81.g(lu1VarB, new h94(this), du2.b());
    }

    @Override // defpackage.jk
    public lu1 c(byte[] bArr) {
        return x81.g(this.a.c(bArr), new h94(this), du2.b());
    }
}
