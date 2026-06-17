package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class t02 {
    public int a;
    public int b;
    public int c;
    public long[] d;
    public int e;

    public t02(int i) {
        gg3.d(i >= 0 && i <= 1073741824);
        i = i == 0 ? 1 : i;
        i = Integer.bitCount(i) != 1 ? Integer.highestOneBit(i - 1) << 1 : i;
        this.a = 0;
        this.b = -1;
        this.c = 0;
        long[] jArr = new long[i];
        this.d = jArr;
        this.e = jArr.length - 1;
    }

    public void a(long j) {
        if (this.c == this.d.length) {
            c();
        }
        int i = (this.b + 1) & this.e;
        this.b = i;
        this.d[i] = j;
        this.c++;
    }

    public void b() {
        this.a = 0;
        this.b = -1;
        this.c = 0;
    }

    public final void c() {
        long[] jArr = this.d;
        int length = jArr.length << 1;
        if (length < 0) {
            z20.a();
            return;
        }
        long[] jArr2 = new long[length];
        int length2 = jArr.length;
        int i = this.a;
        int i2 = length2 - i;
        System.arraycopy(jArr, i, jArr2, 0, i2);
        System.arraycopy(this.d, 0, jArr2, i2, i);
        this.a = 0;
        this.b = this.c - 1;
        this.d = jArr2;
        this.e = jArr2.length - 1;
    }

    public long d() {
        if (this.c != 0) {
            return this.d[this.a];
        }
        bo.a();
        return 0L;
    }

    public boolean e() {
        return this.c == 0;
    }

    public long f() {
        int i = this.c;
        if (i == 0) {
            bo.a();
            return 0L;
        }
        long[] jArr = this.d;
        int i2 = this.a;
        long j = jArr[i2];
        this.a = this.e & (i2 + 1);
        this.c = i - 1;
        return j;
    }

    public t02() {
        this(16);
    }
}
