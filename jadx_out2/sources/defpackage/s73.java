package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class s73 {
    public byte[] a;
    public int b;
    public int c;
    public int d;
    public int e;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public s73(byte[] bArr, int i, int i2) {
        j(bArr, i, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a() {
        int i;
        int i2 = this.d;
        gg3.v(i2 >= 0 && (i2 < (i = this.b) || (i2 == i && this.e == 0)));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b() {
        int i = this.e;
        if (i > 0) {
            m(8 - i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean c(int i) {
        int i2 = this.d;
        int i3 = i / 8;
        int i4 = i2 + i3;
        int i5 = (this.e + i) - (i3 * 8);
        if (i5 > 7) {
            i4++;
            i5 -= 8;
        }
        while (true) {
            i2++;
            if (i2 > i4 || i4 > this.b) {
                break;
            }
            if (k(i2)) {
                i4++;
                i2 += 2;
            }
        }
        int i6 = this.b;
        return i4 < i6 || (i4 == i6 && i5 == 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean d() {
        int i = this.d;
        int i2 = this.e;
        int i3 = 0;
        while (this.d < this.b && !e()) {
            i3++;
        }
        boolean z = this.d == this.b;
        this.d = i;
        this.e = i2;
        return !z && c((i3 * 2) + 1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean e() {
        boolean z = (this.a[this.d] & (128 >> this.e)) != 0;
        l();
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int f(int i) {
        int i2;
        this.e += i;
        int i3 = 0;
        while (true) {
            i2 = this.e;
            if (i2 <= 8) {
                break;
            }
            int i4 = i2 - 8;
            this.e = i4;
            byte[] bArr = this.a;
            int i5 = this.d;
            i3 |= (bArr[i5] & 255) << i4;
            if (!k(i5 + 1)) {
                i = 1;
            }
            this.d = i5 + i;
        }
        byte[] bArr2 = this.a;
        int i6 = this.d;
        int i7 = ((-1) >>> (32 - i)) & (i3 | ((bArr2[i6] & 255) >> (8 - i2)));
        if (i2 == 8) {
            this.e = 0;
            this.d = i6 + (k(i6 + 1) ? 2 : 1);
        }
        a();
        return i7;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int g() {
        int i = 0;
        while (!e()) {
            i++;
        }
        return ((1 << i) - 1) + (i > 0 ? f(i) : 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int h() {
        int iG = g();
        return (iG % 2 == 0 ? -1 : 1) * ((iG + 1) / 2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int i() {
        return g();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j(byte[] bArr, int i, int i2) {
        this.a = bArr;
        this.c = i;
        this.d = i;
        this.b = i2;
        this.e = 0;
        a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean k(int i) {
        int i2 = i - 2;
        if (this.c > i2 || i >= this.b) {
            return false;
        }
        byte[] bArr = this.a;
        return bArr[i] == 3 && bArr[i2] == 0 && bArr[i - 1] == 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l() {
        int i = this.e + 1;
        this.e = i;
        if (i == 8) {
            this.e = 0;
            int i2 = this.d;
            this.d = i2 + (k(i2 + 1) ? 2 : 1);
        }
        a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m(int i) {
        int i2 = this.d;
        int i3 = i / 8;
        int i4 = i2 + i3;
        this.d = i4;
        int i5 = this.e + (i - (i3 * 8));
        this.e = i5;
        if (i5 > 7) {
            this.d = i4 + 1;
            this.e = i5 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.d) {
                a();
                return;
            } else if (k(i2)) {
                this.d++;
                i2 += 2;
            }
        }
    }
}
