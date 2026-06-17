package defpackage;

import android.graphics.Bitmap;
import android.util.Log;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.q91;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class sd4 implements q91 {
    public static final String u = "sd4";
    public int[] a;
    public final int[] b;
    public final q91.a c;
    public ByteBuffer d;
    public byte[] e;
    public short[] f;
    public byte[] g;
    public byte[] h;
    public byte[] i;
    public int[] j;
    public int k;
    public aa1 l;
    public Bitmap m;
    public boolean n;
    public int o;
    public int p;
    public int q;
    public int r;
    public Boolean s;
    public Bitmap.Config t;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public sd4(q91.a aVar) {
        this.b = new int[Buffer.DEFAULT_SIZE];
        this.t = Bitmap.Config.ARGB_8888;
        this.c = aVar;
        this.l = new aa1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q91
    public synchronized Bitmap a() {
        try {
            if (this.l.c <= 0 || this.k < 0) {
                String str = u;
                if (Log.isLoggable(str, 3)) {
                    Log.d(str, "Unable to decode frame, frameCount=" + this.l.c + ", framePointer=" + this.k);
                }
                this.o = 1;
            }
            int i = this.o;
            if (i != 1 && i != 2) {
                this.o = 0;
                if (this.e == null) {
                    this.e = this.c.e(255);
                }
                x91 x91Var = (x91) this.l.e.get(this.k);
                int i2 = this.k - 1;
                x91 x91Var2 = i2 >= 0 ? (x91) this.l.e.get(i2) : null;
                int[] iArr = x91Var.k;
                if (iArr == null) {
                    iArr = this.l.a;
                }
                this.a = iArr;
                if (iArr == null) {
                    String str2 = u;
                    if (Log.isLoggable(str2, 3)) {
                        Log.d(str2, "No valid color table found for frame #" + this.k);
                    }
                    this.o = 1;
                    return null;
                }
                if (x91Var.f) {
                    System.arraycopy(iArr, 0, this.b, 0, iArr.length);
                    int[] iArr2 = this.b;
                    this.a = iArr2;
                    iArr2[x91Var.h] = 0;
                    if (x91Var.g == 2 && this.k == 0) {
                        this.s = Boolean.TRUE;
                    }
                }
                return r(x91Var, x91Var2);
            }
            String str3 = u;
            if (Log.isLoggable(str3, 3)) {
                Log.d(str3, "Unable to decode frame, status=" + this.o);
            }
            return null;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q91
    public void b() {
        this.k = (this.k + 1) % this.l.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q91
    public int c() {
        return this.l.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q91
    public void clear() {
        this.l = null;
        byte[] bArr = this.i;
        if (bArr != null) {
            this.c.d(bArr);
        }
        int[] iArr = this.j;
        if (iArr != null) {
            this.c.f(iArr);
        }
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            this.c.c(bitmap);
        }
        this.m = null;
        this.d = null;
        this.s = null;
        byte[] bArr2 = this.e;
        if (bArr2 != null) {
            this.c.d(bArr2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q91
    public int d() {
        int i;
        if (this.l.c <= 0 || (i = this.k) < 0) {
            return 0;
        }
        return m(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q91
    public void e(Bitmap.Config config) {
        Bitmap.Config config2;
        Bitmap.Config config3 = Bitmap.Config.ARGB_8888;
        if (config == config3 || config == (config2 = Bitmap.Config.RGB_565)) {
            this.t = config;
            return;
        }
        throw new IllegalArgumentException("Unsupported format: " + config + ", must be one of " + config3 + " or " + config2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q91
    public void f() {
        this.k = -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q91
    public int g() {
        return this.k;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q91
    public ByteBuffer getData() {
        return this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q91
    public int h() {
        return this.d.limit() + this.i.length + (this.j.length * 4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int i(int i, int i2, int i3) {
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        for (int i9 = i; i9 < this.p + i; i9++) {
            byte[] bArr = this.i;
            if (i9 >= bArr.length || i9 >= i2) {
                break;
            }
            int i10 = this.a[bArr[i9] & 255];
            if (i10 != 0) {
                i4 += (i10 >> 24) & 255;
                i5 += (i10 >> 16) & 255;
                i6 += (i10 >> 8) & 255;
                i7 += i10 & 255;
                i8++;
            }
        }
        int i11 = i + i3;
        for (int i12 = i11; i12 < this.p + i11; i12++) {
            byte[] bArr2 = this.i;
            if (i12 >= bArr2.length || i12 >= i2) {
                break;
            }
            int i13 = this.a[bArr2[i12] & 255];
            if (i13 != 0) {
                i4 += (i13 >> 24) & 255;
                i5 += (i13 >> 16) & 255;
                i6 += (i13 >> 8) & 255;
                i7 += i13 & 255;
                i8++;
            }
        }
        if (i8 == 0) {
            return 0;
        }
        return ((i4 / i8) << 24) | ((i5 / i8) << 16) | ((i6 / i8) << 8) | (i7 / i8);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j(x91 x91Var) {
        int i;
        int i2;
        int i3;
        int i4;
        int[] iArr = this.j;
        int i5 = x91Var.d;
        int i6 = this.p;
        int i7 = i5 / i6;
        int i8 = x91Var.b / i6;
        int i9 = x91Var.c / i6;
        int i10 = x91Var.a / i6;
        boolean z = this.k == 0;
        int i11 = this.r;
        int i12 = this.q;
        byte[] bArr = this.i;
        int[] iArr2 = this.a;
        Boolean bool = this.s;
        int i13 = 8;
        int i14 = 0;
        int i15 = 0;
        int i16 = 1;
        while (i15 < i7) {
            int[] iArr3 = iArr;
            if (x91Var.e) {
                if (i14 >= i7) {
                    int i17 = i16 + 1;
                    i = i7;
                    if (i17 == 2) {
                        i16 = i17;
                        i14 = 4;
                    } else if (i17 == 3) {
                        i16 = i17;
                        i13 = 4;
                        i14 = 2;
                    } else if (i17 != 4) {
                        i16 = i17;
                    } else {
                        i16 = i17;
                        i14 = 1;
                        i13 = 2;
                    }
                } else {
                    i = i7;
                }
                i2 = i14 + i13;
            } else {
                i = i7;
                i2 = i14;
                i14 = i15;
            }
            int i18 = i14 + i8;
            boolean z2 = i6 == 1;
            if (i18 < i12) {
                int i19 = i18 * i11;
                int i20 = i19 + i10;
                int i21 = i20 + i9;
                int i22 = i19 + i11;
                if (i22 < i21) {
                    i21 = i22;
                }
                i3 = i2;
                int i23 = i15 * i6 * x91Var.c;
                if (z2) {
                    int i24 = i20;
                    while (i24 < i21) {
                        int i25 = i24;
                        int i26 = iArr2[bArr[i23] & 255];
                        if (i26 != 0) {
                            iArr3[i25] = i26;
                        } else if (z && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i23 += i6;
                        i24 = i25 + 1;
                    }
                } else {
                    int i27 = ((i21 - i20) * i6) + i23;
                    i4 = i6;
                    int i28 = i20;
                    while (i28 < i21) {
                        int i29 = i21;
                        int i30 = i(i23, i27, x91Var.c);
                        if (i30 != 0) {
                            iArr3[i28] = i30;
                        } else if (z && bool == null) {
                            bool = Boolean.TRUE;
                        }
                        i23 += i4;
                        i28++;
                        i21 = i29;
                    }
                    i15++;
                    i6 = i4;
                    iArr = iArr3;
                    i7 = i;
                    i14 = i3;
                }
            } else {
                i3 = i2;
            }
            i4 = i6;
            i15++;
            i6 = i4;
            iArr = iArr3;
            i7 = i;
            i14 = i3;
        }
        if (this.s == null) {
            this.s = Boolean.valueOf(bool == null ? false : bool.booleanValue());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k(x91 x91Var) {
        x91 x91Var2 = x91Var;
        int[] iArr = this.j;
        int i = x91Var2.d;
        int i2 = x91Var2.b;
        int i3 = x91Var2.c;
        int i4 = x91Var2.a;
        boolean z = this.k == 0;
        int i5 = this.r;
        byte[] bArr = this.i;
        int[] iArr2 = this.a;
        int i6 = 0;
        byte b = -1;
        while (i6 < i) {
            int i7 = (i6 + i2) * i5;
            int i8 = i7 + i4;
            int i9 = i8 + i3;
            int i10 = i7 + i5;
            if (i10 < i9) {
                i9 = i10;
            }
            int i11 = x91Var2.c * i6;
            int i12 = i8;
            while (i12 < i9) {
                byte b2 = bArr[i11];
                int[] iArr3 = iArr;
                int i13 = b2 & 255;
                if (i13 != b) {
                    int i14 = iArr2[i13];
                    if (i14 != 0) {
                        iArr3[i12] = i14;
                    } else {
                        b = b2;
                    }
                }
                i11++;
                i12++;
                iArr = iArr3;
            }
            i6++;
            x91Var2 = x91Var;
        }
        Boolean bool = this.s;
        this.s = Boolean.valueOf((bool != null && bool.booleanValue()) || (this.s == null && z && b != -1));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:81:? */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v10 */
    /* JADX WARN: Type inference failed for: r3v15, types: [short] */
    /* JADX WARN: Type inference failed for: r3v17 */
    /* JADX WARN: Type inference failed for: r3v8 */
    /* JADX WARN: Type inference failed for: r3v9 */
    public final void l(x91 x91Var) {
        int i;
        int i2;
        byte[] bArr;
        short s;
        sd4 sd4Var = this;
        if (x91Var != null) {
            sd4Var.d.position(x91Var.j);
        }
        if (x91Var == null) {
            aa1 aa1Var = sd4Var.l;
            i = aa1Var.f;
            i2 = aa1Var.g;
        } else {
            i = x91Var.c;
            i2 = x91Var.d;
        }
        int i3 = i * i2;
        byte[] bArr2 = sd4Var.i;
        if (bArr2 == null || bArr2.length < i3) {
            sd4Var.i = sd4Var.c.e(i3);
        }
        byte[] bArr3 = sd4Var.i;
        if (sd4Var.f == null) {
            sd4Var.f = new short[okio.internal.Buffer.SEGMENTING_THRESHOLD];
        }
        short[] sArr = sd4Var.f;
        if (sd4Var.g == null) {
            sd4Var.g = new byte[okio.internal.Buffer.SEGMENTING_THRESHOLD];
        }
        byte[] bArr4 = sd4Var.g;
        if (sd4Var.h == null) {
            sd4Var.h = new byte[4097];
        }
        byte[] bArr5 = sd4Var.h;
        int iP = sd4Var.p();
        int i4 = 1 << iP;
        int i5 = i4 + 1;
        int i6 = i4 + 2;
        int i7 = iP + 1;
        int i8 = (1 << i7) - 1;
        byte b = 0;
        for (int i9 = 0; i9 < i4; i9++) {
            sArr[i9] = 0;
            bArr4[i9] = (byte) i9;
        }
        byte[] bArr6 = sd4Var.e;
        int i10 = i7;
        int i11 = i6;
        int i12 = i8;
        int i13 = 0;
        int iO = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        int i18 = 0;
        int i19 = 0;
        int i20 = -1;
        while (true) {
            if (i13 >= i3) {
                break;
            }
            if (iO == 0) {
                iO = sd4Var.o();
                if (iO <= 0) {
                    sd4Var.o = 3;
                    break;
                }
                i14 = b;
            }
            i16 += (bArr6[i14] & 255) << i15;
            i14++;
            iO--;
            int i21 = i15 + 8;
            int i22 = i11;
            int i23 = i10;
            int i24 = i20;
            short[] sArr2 = sArr;
            int i25 = i18;
            while (true) {
                bArr = bArr4;
                if (i21 < i23) {
                    i11 = i22;
                    i18 = i25;
                    break;
                }
                int i26 = i16 & i12;
                i16 >>= i23;
                i21 -= i23;
                if (i26 == i4) {
                    i23 = i7;
                    i22 = i6;
                    i12 = i8;
                    bArr4 = bArr;
                    i24 = -1;
                } else {
                    if (i26 == i5) {
                        i18 = i25;
                        i11 = i22;
                        break;
                    }
                    byte[] bArr7 = bArr5;
                    if (i24 == -1) {
                        bArr3[i17] = bArr[i26];
                        i17++;
                        i13++;
                        i24 = i26;
                        i25 = i24;
                        bArr4 = bArr;
                        bArr5 = bArr7;
                    } else {
                        if (i26 >= i22) {
                            bArr7[i19] = (byte) i25;
                            i19++;
                            s = i24;
                        } else {
                            s = i26;
                        }
                        while (s >= i4) {
                            bArr7[i19] = bArr[s];
                            i19++;
                            s = sArr2[s];
                        }
                        int i27 = bArr[s] & 255;
                        byte b2 = (byte) i27;
                        bArr3[i17] = b2;
                        while (true) {
                            i17++;
                            i13++;
                            if (i19 <= 0) {
                                break;
                            }
                            i19--;
                            bArr3[i17] = bArr7[i19];
                        }
                        if (i22 < 4096) {
                            sArr2[i22] = (short) i24;
                            bArr[i22] = b2;
                            i22++;
                            if ((i22 & i12) == 0 && i22 < 4096) {
                                i23++;
                                i12 += i22;
                            }
                        }
                        i24 = i26;
                        bArr4 = bArr;
                        bArr5 = bArr7;
                        i25 = i27;
                    }
                }
            }
            i15 = i21;
            sArr = sArr2;
            bArr4 = bArr;
            b = 0;
            i20 = i24;
            i10 = i23;
            sd4Var = this;
        }
        Arrays.fill(bArr3, i17, i3, b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int m(int i) {
        if (i < 0) {
            return -1;
        }
        aa1 aa1Var = this.l;
        if (i < aa1Var.c) {
            return ((x91) aa1Var.e.get(i)).i;
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Bitmap n() {
        Boolean bool = this.s;
        Bitmap bitmapA = this.c.a(this.r, this.q, (bool == null || bool.booleanValue()) ? Bitmap.Config.ARGB_8888 : this.t);
        bitmapA.setHasAlpha(true);
        return bitmapA;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int o() {
        int iP = p();
        if (iP <= 0) {
            return iP;
        }
        ByteBuffer byteBuffer = this.d;
        byteBuffer.get(this.e, 0, Math.min(iP, byteBuffer.remaining()));
        return iP;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int p() {
        return this.d.get() & 255;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void q(aa1 aa1Var, ByteBuffer byteBuffer, int i) {
        try {
            if (i <= 0) {
                throw new IllegalArgumentException("Sample size must be >=0, not: " + i);
            }
            int iHighestOneBit = Integer.highestOneBit(i);
            this.o = 0;
            this.l = aa1Var;
            this.k = -1;
            ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            this.d = byteBufferAsReadOnlyBuffer;
            byteBufferAsReadOnlyBuffer.position(0);
            this.d.order(ByteOrder.LITTLE_ENDIAN);
            this.n = false;
            Iterator it = aa1Var.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((x91) it.next()).g == 3) {
                    this.n = true;
                    break;
                }
            }
            this.p = iHighestOneBit;
            int i2 = aa1Var.f;
            this.r = i2 / iHighestOneBit;
            int i3 = aa1Var.g;
            this.q = i3 / iHighestOneBit;
            this.i = this.c.e(i2 * i3);
            this.j = this.c.b(this.r * this.q);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Bitmap r(x91 x91Var, x91 x91Var2) {
        int i;
        int i2;
        Bitmap bitmap;
        int[] iArr = this.j;
        int i3 = 0;
        if (x91Var2 == null) {
            Bitmap bitmap2 = this.m;
            if (bitmap2 != null) {
                this.c.c(bitmap2);
            }
            this.m = null;
            Arrays.fill(iArr, 0);
        }
        if (x91Var2 != null && x91Var2.g == 3 && this.m == null) {
            Arrays.fill(iArr, 0);
        }
        if (x91Var2 != null && (i2 = x91Var2.g) > 0) {
            if (i2 == 2) {
                if (!x91Var.f) {
                    aa1 aa1Var = this.l;
                    int i4 = aa1Var.l;
                    if (x91Var.k == null || aa1Var.j != x91Var.h) {
                        i3 = i4;
                    }
                }
                int i5 = x91Var2.d;
                int i6 = this.p;
                int i7 = i5 / i6;
                int i8 = x91Var2.b / i6;
                int i9 = x91Var2.c / i6;
                int i10 = x91Var2.a / i6;
                int i11 = this.r;
                int i12 = (i8 * i11) + i10;
                int i13 = (i7 * i11) + i12;
                while (i12 < i13) {
                    int i14 = i12 + i9;
                    for (int i15 = i12; i15 < i14; i15++) {
                        iArr[i15] = i3;
                    }
                    i12 += this.r;
                }
            } else if (i2 == 3 && (bitmap = this.m) != null) {
                int i16 = this.r;
                bitmap.getPixels(iArr, 0, i16, 0, 0, i16, this.q);
            }
        }
        l(x91Var);
        if (x91Var.e || this.p != 1) {
            j(x91Var);
        } else {
            k(x91Var);
        }
        if (this.n && ((i = x91Var.g) == 0 || i == 1)) {
            if (this.m == null) {
                this.m = n();
            }
            Bitmap bitmap3 = this.m;
            int i17 = this.r;
            bitmap3.setPixels(iArr, 0, i17, 0, 0, i17, this.q);
        }
        Bitmap bitmapN = n();
        int i18 = this.r;
        bitmapN.setPixels(iArr, 0, i18, 0, 0, i18, this.q);
        return bitmapN;
    }

    public sd4(q91.a aVar, aa1 aa1Var, ByteBuffer byteBuffer, int i) {
        this(aVar);
        q(aa1Var, byteBuffer, i);
    }
}
