package defpackage;

import android.graphics.Bitmap;
import defpackage.q91;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class p91 implements q91.a {
    public final kk a;
    public final ma b;

    public p91(kk kkVar, ma maVar) {
        this.a = kkVar;
        this.b = maVar;
    }

    @Override // q91.a
    public Bitmap a(int i, int i2, Bitmap.Config config) {
        return this.a.e(i, i2, config);
    }

    @Override // q91.a
    public int[] b(int i) {
        ma maVar = this.b;
        return maVar == null ? new int[i] : (int[]) maVar.d(i, int[].class);
    }

    @Override // q91.a
    public void c(Bitmap bitmap) {
        this.a.c(bitmap);
    }

    @Override // q91.a
    public void d(byte[] bArr) {
        ma maVar = this.b;
        if (maVar == null) {
            return;
        }
        maVar.put(bArr);
    }

    @Override // q91.a
    public byte[] e(int i) {
        ma maVar = this.b;
        return maVar == null ? new byte[i] : (byte[]) maVar.d(i, byte[].class);
    }

    @Override // q91.a
    public void f(int[] iArr) {
        ma maVar = this.b;
        if (maVar == null) {
            return;
        }
        maVar.put(iArr);
    }
}
