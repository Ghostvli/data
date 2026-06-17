package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ea {
    public final int a;
    public float b;
    public int c;
    public int d;
    public float e;
    public float f;
    public final int g;
    public final float h;

    public ea(int i, float f, float f2, float f3, int i2, float f4, int i3, float f5, int i4, float f6) {
        this.a = i;
        this.b = r62.a(f, f2, f3);
        this.c = i2;
        this.e = f4;
        this.d = i3;
        this.f = f5;
        this.g = i4;
        d(f6, f2, f3, f5);
        this.h = b(f5);
    }

    public static ea c(float f, float f2, float f3, float f4, int[] iArr, float f5, int[] iArr2, float f6, int[] iArr3) {
        ea eaVar = null;
        int i = 1;
        for (int i2 : iArr3) {
            int length = iArr2.length;
            int i3 = 0;
            while (i3 < length) {
                int i4 = iArr2[i3];
                int length2 = iArr.length;
                int i5 = 0;
                while (i5 < length2) {
                    int i6 = length;
                    int i7 = i3;
                    int i8 = i;
                    int i9 = length2;
                    int i10 = i5;
                    ea eaVar2 = new ea(i8, f2, f3, f4, iArr[i5], f5, i4, f6, i2, f);
                    if (eaVar == null || eaVar2.h < eaVar.h) {
                        if (eaVar2.h == 0.0f) {
                            return eaVar2;
                        }
                        eaVar = eaVar2;
                    }
                    int i11 = i8 + 1;
                    i5 = i10 + 1;
                    i3 = i7;
                    i = i11;
                    length = i6;
                    length2 = i9;
                }
                i3++;
                i = i;
                length = length;
            }
        }
        return eaVar;
    }

    public final float a(float f, int i, float f2, int i2, int i3) {
        if (i <= 0) {
            f2 = 0.0f;
        }
        float f3 = i;
        float f4 = i2 / 2.0f;
        return (f - ((f3 + f4) * f2)) / (i3 + f4);
    }

    public final float b(float f) {
        if (g()) {
            return Math.abs(f - this.f) * this.a;
        }
        return Float.MAX_VALUE;
    }

    public final void d(float f, float f2, float f3, float f4) {
        float f5 = f - f();
        int i = this.c;
        if (i > 0 && f5 > 0.0f) {
            float f6 = this.b;
            this.b = f6 + Math.min(f5 / i, f3 - f6);
        } else if (i > 0 && f5 < 0.0f) {
            float f7 = this.b;
            this.b = f7 + Math.max(f5 / i, f2 - f7);
        }
        int i2 = this.c;
        float f8 = i2 > 0 ? this.b : 0.0f;
        this.b = f8;
        float fA = a(f, i2, f8, this.d, this.g);
        this.f = fA;
        float f9 = (this.b + fA) / 2.0f;
        this.e = f9;
        int i3 = this.d;
        if (i3 <= 0 || fA == f4) {
            return;
        }
        float f10 = (f4 - fA) * this.g;
        float fMin = Math.min(Math.abs(f10), f9 * 0.1f * i3);
        float f11 = this.e;
        if (f10 > 0.0f) {
            this.e = f11 - (fMin / this.d);
            this.f += fMin / this.g;
        } else {
            this.e = f11 + (fMin / this.d);
            this.f -= fMin / this.g;
        }
    }

    public int e() {
        return this.c + this.d + this.g;
    }

    public final float f() {
        return (this.f * this.g) + (this.e * this.d) + (this.b * this.c);
    }

    public final boolean g() {
        int i = this.g;
        if (i <= 0 || this.c <= 0 || this.d <= 0) {
            return i <= 0 || this.c <= 0 || this.f > this.b;
        }
        float f = this.f;
        float f2 = this.e;
        return f > f2 && f2 > this.b;
    }

    public String toString() {
        return "Arrangement [priority=" + this.a + ", smallCount=" + this.c + ", smallSize=" + this.b + ", mediumCount=" + this.d + ", mediumSize=" + this.e + ", largeCount=" + this.g + ", largeSize=" + this.f + ", cost=" + this.h + "]";
    }
}
