package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public abstract class u02 implements uy0, rr2 {
    public static final long[] p = {4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L};
    public final k50 a;
    public byte[] b;
    public int c;
    public long d;
    public long e;
    public long f;
    public long g;
    public long h;
    public long i;
    public long j;
    public long k;
    public long l;
    public long m;
    public long[] n;
    public int o;

    public u02(k50 k50Var) {
        this.b = new byte[8];
        this.n = new long[80];
        this.a = k50Var;
        this.c = 0;
        reset();
    }

    @Override // defpackage.uy0
    public int d() {
        return 128;
    }

    public final long f(long j, long j2, long j3) {
        return ((~j) & j3) ^ (j2 & j);
    }

    public final long g(long j, long j2, long j3) {
        return ((j & j3) ^ (j & j2)) ^ (j2 & j3);
    }

    public final long h(long j) {
        return (j >>> 7) ^ (((j << 63) | (j >>> 1)) ^ ((j << 56) | (j >>> 8)));
    }

    public final long i(long j) {
        return (j >>> 6) ^ (((j << 45) | (j >>> 19)) ^ ((j << 3) | (j >>> 61)));
    }

    public final long j(long j) {
        return ((j >>> 39) | (j << 25)) ^ (((j << 36) | (j >>> 28)) ^ ((j << 30) | (j >>> 34)));
    }

    public final long k(long j) {
        return ((j >>> 41) | (j << 23)) ^ (((j << 50) | (j >>> 14)) ^ ((j << 46) | (j >>> 18)));
    }

    public final void l() {
        long j = this.d;
        if (j > 2305843009213693951L) {
            this.e += j >>> 61;
            this.d = j & 2305843009213693951L;
        }
    }

    public void m(u02 u02Var) {
        byte[] bArr = u02Var.b;
        System.arraycopy(bArr, 0, this.b, 0, bArr.length);
        this.c = u02Var.c;
        this.d = u02Var.d;
        this.e = u02Var.e;
        this.f = u02Var.f;
        this.g = u02Var.g;
        this.h = u02Var.h;
        this.i = u02Var.i;
        this.j = u02Var.j;
        this.k = u02Var.k;
        this.l = u02Var.l;
        this.m = u02Var.m;
        long[] jArr = u02Var.n;
        System.arraycopy(jArr, 0, this.n, 0, jArr.length);
        this.o = u02Var.o;
    }

    public void n() {
        l();
        long j = this.d << 3;
        long j2 = this.e;
        byte b = -128;
        while (true) {
            update(b);
            if (this.c == 0) {
                p(j, j2);
                o();
                return;
            }
            b = 0;
        }
    }

    public void o() {
        l();
        for (int i = 16; i <= 79; i++) {
            long[] jArr = this.n;
            long jI = i(jArr[i - 2]);
            long[] jArr2 = this.n;
            jArr[i] = jI + jArr2[i - 7] + h(jArr2[i - 15]) + this.n[i - 16];
        }
        long j = this.f;
        long j2 = this.g;
        long j3 = this.h;
        long j4 = this.i;
        long j5 = this.j;
        long j6 = j4;
        long j7 = this.k;
        int i2 = 0;
        int i3 = 0;
        long j8 = j3;
        long j9 = this.l;
        long j10 = this.m;
        long j11 = j;
        long j12 = j5;
        long j13 = j2;
        while (i2 < 10) {
            long j14 = j7;
            long j15 = j12;
            long j16 = j9;
            long jK = k(j12) + f(j12, j14, j9);
            long[] jArr3 = p;
            int i4 = i3 + 1;
            long j17 = j10 + jK + jArr3[i3] + this.n[i3];
            long j18 = j6 + j17;
            long j19 = j11;
            long j20 = j13;
            long j21 = j8;
            long j22 = j17 + j(j11) + g(j19, j20, j21);
            int i5 = i3 + 2;
            long jK2 = j16 + k(j18) + f(j18, j15, j14) + jArr3[i4] + this.n[i4];
            long j23 = j21 + jK2;
            long j24 = jK2 + j(j22) + g(j22, j19, j20);
            int i6 = i3 + 3;
            long jK3 = j14 + k(j23) + f(j23, j18, j15) + jArr3[i5] + this.n[i5];
            long j25 = j20 + jK3;
            long j26 = jK3 + j(j24) + g(j24, j22, j19);
            int i7 = i3 + 4;
            long jK4 = j15 + k(j25) + f(j25, j23, j18) + jArr3[i6] + this.n[i6];
            long j27 = j19 + jK4;
            long j28 = jK4 + j(j26) + g(j26, j24, j22);
            int i8 = i3 + 5;
            long jK5 = j18 + k(j27) + f(j27, j25, j23) + jArr3[i7] + this.n[i7];
            long j29 = j22 + jK5;
            long j30 = jK5 + j(j28) + g(j28, j26, j24);
            int i9 = i3 + 6;
            long jK6 = j23 + k(j29) + f(j29, j27, j25) + jArr3[i8] + this.n[i8];
            long j31 = j24 + jK6;
            long j32 = jK6 + j(j30) + g(j30, j28, j26);
            int i10 = i3 + 7;
            long jK7 = j25 + k(j31) + f(j31, j29, j27) + jArr3[i9] + this.n[i9];
            long j33 = j26 + jK7;
            long j34 = jK7 + j(j32) + g(j32, j30, j28);
            i3 += 8;
            long jK8 = j27 + k(j33) + f(j33, j31, j29) + jArr3[i10] + this.n[i10];
            long j35 = j28 + jK8;
            j11 = jK8 + j(j34) + g(j34, j32, j30);
            i2++;
            j13 = j34;
            j12 = j35;
            j8 = j32;
            j10 = j29;
            j7 = j33;
            j9 = j31;
            j6 = j30;
        }
        this.f += j11;
        this.g += j13;
        this.h += j8;
        this.i += j6;
        this.j += j12;
        this.k += j7;
        this.l += j9;
        this.m += j10;
        this.o = 0;
        for (int i11 = 0; i11 < 16; i11++) {
            this.n[i11] = 0;
        }
    }

    public void p(long j, long j2) {
        if (this.o > 14) {
            o();
        }
        long[] jArr = this.n;
        jArr[14] = j2;
        jArr[15] = j;
    }

    public void q(byte[] bArr, int i) {
        this.n[this.o] = b73.b(bArr, i);
        int i2 = this.o + 1;
        this.o = i2;
        if (i2 == 16) {
            o();
        }
    }

    @Override // defpackage.sl0
    public void reset() {
        this.d = 0L;
        this.e = 0L;
        int i = 0;
        this.c = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.b;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = 0;
            i2++;
        }
        this.o = 0;
        while (true) {
            long[] jArr = this.n;
            if (i == jArr.length) {
                return;
            }
            jArr[i] = 0;
            i++;
        }
    }

    @Override // defpackage.sl0
    public void update(byte[] bArr, int i, int i2) {
        while (this.c != 0 && i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
        while (i2 >= this.b.length) {
            q(bArr, i);
            byte[] bArr2 = this.b;
            i += bArr2.length;
            i2 -= bArr2.length;
            this.d += (long) bArr2.length;
        }
        while (i2 > 0) {
            update(bArr[i]);
            i++;
            i2--;
        }
    }

    public u02(u02 u02Var) {
        this.b = new byte[8];
        this.n = new long[80];
        this.a = u02Var.a;
        m(u02Var);
    }

    @Override // defpackage.sl0
    public void update(byte b) {
        byte[] bArr = this.b;
        int i = this.c;
        int i2 = i + 1;
        this.c = i2;
        bArr[i] = b;
        if (i2 == bArr.length) {
            q(bArr, 0);
            this.c = 0;
        }
        this.d++;
    }
}
