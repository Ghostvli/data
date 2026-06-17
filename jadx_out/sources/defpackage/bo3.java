package defpackage;

import android.graphics.Rect;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class bo3 {
    public byte[] a;
    public int b;
    public int c;

    public bo3(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.b = i;
        this.c = i2;
    }

    public static byte[] e(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr2 = new byte[i3];
        int i4 = i3 - 1;
        for (int i5 = 0; i5 < i3; i5++) {
            bArr2[i4] = bArr[i5];
            i4--;
        }
        return bArr2;
    }

    public static byte[] f(byte[] bArr, int i, int i2) {
        int i3 = i * i2;
        byte[] bArr2 = new byte[i3];
        int i4 = i3 - 1;
        for (int i5 = 0; i5 < i; i5++) {
            for (int i6 = i2 - 1; i6 >= 0; i6--) {
                bArr2[i4] = bArr[(i6 * i) + i5];
                i4--;
            }
        }
        return bArr2;
    }

    public static byte[] g(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i * i2];
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4++) {
            for (int i5 = i2 - 1; i5 >= 0; i5--) {
                bArr2[i3] = bArr[(i5 * i) + i4];
                i3++;
            }
        }
        return bArr2;
    }

    public bo3 a(Rect rect, int i) {
        int iWidth = rect.width() / i;
        int iHeight = rect.height() / i;
        int i2 = rect.top;
        byte[] bArr = new byte[iWidth * iHeight];
        int i3 = this.b;
        if (i == 1) {
            int i4 = (i2 * i3) + rect.left;
            for (int i5 = 0; i5 < iHeight; i5++) {
                System.arraycopy(this.a, i4, bArr, i5 * iWidth, iWidth);
                i4 += this.b;
            }
        } else {
            int i6 = (i2 * i3) + rect.left;
            for (int i7 = 0; i7 < iHeight; i7++) {
                int i8 = i7 * iWidth;
                int i9 = i6;
                for (int i10 = 0; i10 < iWidth; i10++) {
                    bArr[i8] = this.a[i9];
                    i9 += i;
                    i8++;
                }
                i6 += this.b * i;
            }
        }
        return new bo3(bArr, iWidth, iHeight);
    }

    public byte[] b() {
        return this.a;
    }

    public int c() {
        return this.c;
    }

    public int d() {
        return this.b;
    }

    public bo3 h(int i) {
        return i != 90 ? i != 180 ? i != 270 ? this : new bo3(f(this.a, this.b, this.c), this.c, this.b) : new bo3(e(this.a, this.b, this.c), this.b, this.c) : new bo3(g(this.a, this.b, this.c), this.c, this.b);
    }
}
