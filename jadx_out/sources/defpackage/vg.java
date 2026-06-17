package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class vg {
    public static final a f = new a(null);
    public static final byte[] g = {13, 10};
    public static final vg h;
    public static final vg i;
    public static final vg j;
    public final boolean a;
    public final boolean b;
    public final int c;
    public final b d;
    public final int e;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public static final b f = new b("PRESENT", 0);
        public static final b g = new b("ABSENT", 1);
        public static final b h = new b("PRESENT_OPTIONAL", 2);
        public static final b i = new b("ABSENT_OPTIONAL", 3);
        public static final /* synthetic */ b[] j;
        public static final /* synthetic */ gt0 k;

        static {
            b[] bVarArrA = a();
            j = bVarArrA;
            k = ht0.a(bVarArrA);
        }

        public b(String str, int i2) {
        }

        public static final /* synthetic */ b[] a() {
            return new b[]{f, g, h, i};
        }

        public static b valueOf(String str) {
            return (b) Enum.valueOf(b.class, str);
        }

        public static b[] values() {
            return (b[]) j.clone();
        }
    }

    static {
        b bVar = b.f;
        h = new vg(true, false, -1, bVar);
        i = new vg(false, true, 76, bVar);
        j = new vg(false, true, 64, bVar);
    }

    public vg(boolean z, boolean z2, int i2, b bVar) {
        this.a = z;
        this.b = z2;
        this.c = i2;
        this.d = bVar;
        if (z && z2) {
            jl.a("Failed requirement.");
            throw null;
        }
        this.e = i2 / 4;
    }

    public static /* synthetic */ String d(vg vgVar, byte[] bArr, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            fn.a("Super calls with default arguments not supported in this target, function: encode");
            return null;
        }
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = bArr.length;
        }
        return vgVar.c(bArr, i2, i3);
    }

    public final void a(int i2, int i3, int i4) {
        if (i3 < 0 || i3 > i2) {
            ug.a("destination offset: ", i3, ", destination size: ", i2);
            return;
        }
        int i5 = i3 + i4;
        if (i5 < 0 || i5 > i2) {
            tg.a("The destination array does not have enough capacity, destination offset: ", i3, ", destination size: ", i2, ", capacity needed: ", i4);
        }
    }

    public final void b(int i2, int i3, int i4) {
        i0.Companion.a(i3, i4, i2);
    }

    public final String c(byte[] bArr, int i2, int i3) {
        bArr.getClass();
        return new String(g(bArr, i2, i3), bt.g);
    }

    public final int e(byte[] bArr, byte[] bArr2, int i2, int i3, int i4) {
        int i5 = i3;
        bArr.getClass();
        bArr2.getClass();
        b(bArr.length, i5, i4);
        a(bArr2.length, i2, f(i4 - i5));
        byte[] bArr3 = this.a ? wg.c : wg.a;
        int i6 = this.b ? this.e : Integer.MAX_VALUE;
        int i7 = i2;
        while (i5 + 2 < i4) {
            int iMin = Math.min((i4 - i5) / 3, i6);
            for (int i8 = 0; i8 < iMin; i8++) {
                int i9 = bArr[i5] & 255;
                int i10 = i5 + 2;
                int i11 = bArr[i5 + 1] & 255;
                i5 += 3;
                int i12 = (i11 << 8) | (i9 << 16) | (bArr[i10] & 255);
                bArr2[i7] = bArr3[i12 >>> 18];
                bArr2[i7 + 1] = bArr3[(i12 >>> 12) & 63];
                int i13 = i7 + 3;
                bArr2[i7 + 2] = bArr3[(i12 >>> 6) & 63];
                i7 += 4;
                bArr2[i13] = bArr3[i12 & 63];
            }
            if (iMin == i6 && i5 != i4) {
                int i14 = i7 + 1;
                byte[] bArr4 = g;
                bArr2[i7] = bArr4[0];
                i7 += 2;
                bArr2[i14] = bArr4[1];
            }
        }
        int i15 = i4 - i5;
        if (i15 == 1) {
            int i16 = i5 + 1;
            int i17 = (bArr[i5] & 255) << 4;
            bArr2[i7] = bArr3[i17 >>> 6];
            int i18 = i7 + 2;
            bArr2[i7 + 1] = bArr3[i17 & 63];
            if (h()) {
                int i19 = i7 + 3;
                bArr2[i18] = 61;
                i7 += 4;
                bArr2[i19] = 61;
                i5 = i16;
            } else {
                i5 = i16;
                i7 = i18;
            }
        } else if (i15 == 2) {
            int i20 = i5 + 1;
            int i21 = bArr[i5] & 255;
            i5 += 2;
            int i22 = ((bArr[i20] & 255) << 2) | (i21 << 10);
            bArr2[i7] = bArr3[i22 >>> 12];
            bArr2[i7 + 1] = bArr3[(i22 >>> 6) & 63];
            int i23 = i7 + 3;
            bArr2[i7 + 2] = bArr3[i22 & 63];
            if (h()) {
                i7 += 4;
                bArr2[i23] = 61;
            } else {
                i7 = i23;
            }
        }
        if (i5 == i4) {
            return i7 - i2;
        }
        e04.a("Check failed.");
        return 0;
    }

    public final int f(int i2) {
        int i3 = i2 / 3;
        int i4 = i2 % 3;
        int i5 = i3 * 4;
        if (i4 != 0) {
            i5 += h() ? 4 : i4 + 1;
        }
        if (i5 < 0) {
            jl.a("Input is too big");
            return 0;
        }
        if (this.b) {
            i5 += ((i5 - 1) / this.c) * 2;
        }
        if (i5 >= 0) {
            return i5;
        }
        jl.a("Input is too big");
        return 0;
    }

    public final byte[] g(byte[] bArr, int i2, int i3) {
        bArr.getClass();
        b(bArr.length, i2, i3);
        byte[] bArr2 = new byte[f(i3 - i2)];
        e(bArr, bArr2, 0, i2, i3);
        return bArr2;
    }

    public final boolean h() {
        b bVar = this.d;
        return bVar == b.f || bVar == b.h;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends vg {
        public a() {
            super(false, false, -1, b.f, null);
        }

        public /* synthetic */ a(we0 we0Var) {
            this();
        }
    }

    public /* synthetic */ vg(boolean z, boolean z2, int i2, b bVar, we0 we0Var) {
        this(z, z2, i2, bVar);
    }
}
