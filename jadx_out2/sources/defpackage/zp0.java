package defpackage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.SparseArray;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.ki4;
import defpackage.p50;
import java.util.ArrayList;
import java.util.List;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class zp0 implements ki4 {
    public static final byte[] h = {0, 7, 8, 15};
    public static final byte[] i = {0, 119, -120, -1};
    public static final byte[] j = {0, 17, 34, 51, 68, 85, 102, 119, -120, -103, -86, -69, -52, -35, -18, -1};
    public final Paint a;
    public final Paint b;
    public final Canvas c;
    public final b d;
    public final a e;
    public final h f;
    public Bitmap g;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final int a;
        public final int[] b;
        public final int[] c;
        public final int[] d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(int i, int[] iArr, int[] iArr2, int[] iArr3) {
            this.a = i;
            this.b = iArr;
            this.c = iArr2;
            this.d = iArr3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(int i, int i2, int i3, int i4, int i5, int i6) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public final int a;
        public final boolean b;
        public final byte[] c;
        public final byte[] d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(int i, boolean z, byte[] bArr, byte[] bArr2) {
            this.a = i;
            this.b = z;
            this.c = bArr;
            this.d = bArr2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d {
        public final int a;
        public final int b;
        public final int c;
        public final SparseArray d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(int i, int i2, int i3, SparseArray sparseArray) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = sparseArray;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e {
        public final int a;
        public final int b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f {
        public final int a;
        public final boolean b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final int j;
        public final SparseArray k;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f(int i, boolean z, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, SparseArray sparseArray) {
            this.a = i;
            this.b = z;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.f = i5;
            this.g = i6;
            this.h = i7;
            this.i = i8;
            this.j = i9;
            this.k = sparseArray;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a(f fVar) {
            SparseArray sparseArray = fVar.k;
            for (int i = 0; i < sparseArray.size(); i++) {
                this.k.put(sparseArray.keyAt(i), (g) sparseArray.valueAt(i));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g(int i, int i2, int i3, int i4, int i5, int i6) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class h {
        public final int a;
        public final int b;
        public final SparseArray c = new SparseArray();
        public final SparseArray d = new SparseArray();
        public final SparseArray e = new SparseArray();
        public final SparseArray f = new SparseArray();
        public final SparseArray g = new SparseArray();
        public b h;
        public d i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public h(int i, int i2) {
            this.a = i;
            this.b = i2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a() {
            this.c.clear();
            this.d.clear();
            this.e.clear();
            this.f.clear();
            this.g.clear();
            this.h = null;
            this.i = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public zp0(List list) {
        r73 r73Var = new r73((byte[]) list.get(0));
        int iY = r73Var.Y();
        int iY2 = r73Var.Y();
        Paint paint = new Paint();
        this.a = paint;
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC));
        paint.setPathEffect(null);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setStyle(Paint.Style.FILL);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OVER));
        paint2.setPathEffect(null);
        this.c = new Canvas();
        this.d = new b(719, 575, 0, 719, 0, 575);
        this.e = new a(0, e(), f(), g());
        this.f = new h(iY, iY2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] d(int i2, int i3, q73 q73Var) {
        byte[] bArr = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) q73Var.h(i3);
        }
        return bArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int[] e() {
        return new int[]{0, -1, -16777216, -8421505};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int[] f() {
        int[] iArr = new int[16];
        iArr[0] = 0;
        for (int i2 = 1; i2 < 16; i2++) {
            if (i2 < 8) {
                iArr[i2] = h(255, (i2 & 1) != 0 ? 255 : 0, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) != 0 ? 255 : 0);
            } else {
                iArr[i2] = h(255, (i2 & 1) != 0 ? 127 : 0, (i2 & 2) != 0 ? 127 : 0, (i2 & 4) == 0 ? 0 : 127);
            }
        }
        return iArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int[] g() {
        int[] iArr = new int[Buffer.DEFAULT_SIZE];
        iArr[0] = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            if (i2 < 8) {
                iArr[i2] = h(63, (i2 & 1) != 0 ? 255 : 0, (i2 & 2) != 0 ? 255 : 0, (i2 & 4) == 0 ? 0 : 255);
            } else {
                int i3 = i2 & Token.WITH;
                if (i3 == 0) {
                    iArr[i2] = h(255, ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0), ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0), ((i2 & 4) == 0 ? 0 : 85) + ((i2 & 64) == 0 ? 0 : 170));
                } else if (i3 == 8) {
                    iArr[i2] = h(127, ((i2 & 1) != 0 ? 85 : 0) + ((i2 & 16) != 0 ? 170 : 0), ((i2 & 2) != 0 ? 85 : 0) + ((i2 & 32) != 0 ? 170 : 0), ((i2 & 4) == 0 ? 0 : 85) + ((i2 & 64) == 0 ? 0 : 170));
                } else if (i3 == 128) {
                    iArr[i2] = h(255, ((i2 & 1) != 0 ? 43 : 0) + 127 + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + 127 + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 4) == 0 ? 0 : 43) + 127 + ((i2 & 64) == 0 ? 0 : 85));
                } else if (i3 == 136) {
                    iArr[i2] = h(255, ((i2 & 1) != 0 ? 43 : 0) + ((i2 & 16) != 0 ? 85 : 0), ((i2 & 2) != 0 ? 43 : 0) + ((i2 & 32) != 0 ? 85 : 0), ((i2 & 4) == 0 ? 0 : 43) + ((i2 & 64) == 0 ? 0 : 85));
                }
            }
        }
        return iArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int h(int i2, int i3, int i4, int i5) {
        return (i2 << 24) | (i3 << 16) | (i4 << 8) | i5;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int i(q73 q73Var, int[] iArr, byte[] bArr, int i2, int i3, Paint paint, Canvas canvas) {
        boolean z;
        int i4;
        int iH;
        int iH2;
        boolean z2 = false;
        while (true) {
            int iH3 = q73Var.h(2);
            if (iH3 != 0) {
                z = z2;
                i4 = 1;
            } else {
                if (q73Var.g()) {
                    iH = q73Var.h(3) + 3;
                    iH2 = q73Var.h(2);
                } else {
                    if (q73Var.g()) {
                        z = z2;
                        i4 = 1;
                    } else {
                        int iH4 = q73Var.h(2);
                        if (iH4 == 0) {
                            z = true;
                        } else if (iH4 == 1) {
                            z = z2;
                            i4 = 2;
                        } else if (iH4 == 2) {
                            iH = q73Var.h(4) + 12;
                            iH2 = q73Var.h(2);
                        } else if (iH4 != 3) {
                            z = z2;
                        } else {
                            iH = q73Var.h(8) + 29;
                            iH2 = q73Var.h(2);
                        }
                        iH3 = 0;
                        i4 = 0;
                    }
                    iH3 = 0;
                }
                z = z2;
                i4 = iH;
                iH3 = iH2;
            }
            if (i4 != 0 && paint != null) {
                if (bArr != null) {
                    iH3 = bArr[iH3];
                }
                paint.setColor(iArr[iH3]);
                canvas.drawRect(i2, i3, i2 + i4, 1 + i3, paint);
            }
            i2 += i4;
            if (z) {
                return i2;
            }
            z2 = z;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int j(q73 q73Var, int[] iArr, byte[] bArr, int i2, int i3, Paint paint, Canvas canvas) {
        boolean z;
        int i4;
        int iH;
        int iH2;
        boolean z2 = false;
        while (true) {
            int iH3 = q73Var.h(4);
            if (iH3 != 0) {
                z = z2;
                i4 = 1;
            } else if (q73Var.g()) {
                if (q73Var.g()) {
                    int iH4 = q73Var.h(2);
                    if (iH4 == 0) {
                        z = z2;
                        i4 = 1;
                        iH3 = 0;
                    } else if (iH4 == 1) {
                        iH3 = 0;
                        i4 = 2;
                        z = z2;
                    } else if (iH4 == 2) {
                        iH = q73Var.h(4) + 9;
                        iH2 = q73Var.h(4);
                    } else if (iH4 != 3) {
                        z = z2;
                        iH3 = 0;
                        i4 = 0;
                    } else {
                        iH = q73Var.h(8) + 25;
                        iH2 = q73Var.h(4);
                    }
                } else {
                    iH = q73Var.h(2) + 4;
                    iH2 = q73Var.h(4);
                }
                z = z2;
                i4 = iH;
                iH3 = iH2;
            } else {
                int iH5 = q73Var.h(3);
                if (iH5 != 0) {
                    z = z2;
                    i4 = iH5 + 2;
                    iH3 = 0;
                } else {
                    z = true;
                    iH3 = 0;
                    i4 = 0;
                }
            }
            if (i4 != 0 && paint != null) {
                if (bArr != null) {
                    iH3 = bArr[iH3];
                }
                paint.setColor(iArr[iH3]);
                canvas.drawRect(i2, i3, i2 + i4, 1 + i3, paint);
            }
            i2 += i4;
            if (z) {
                return i2;
            }
            z2 = z;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int k(q73 q73Var, int[] iArr, byte[] bArr, int i2, int i3, Paint paint, Canvas canvas) {
        boolean z;
        int iH;
        boolean z2 = false;
        while (true) {
            int iH2 = q73Var.h(8);
            if (iH2 != 0) {
                z = z2;
                iH = 1;
            } else if (q73Var.g()) {
                z = z2;
                iH = q73Var.h(7);
                iH2 = q73Var.h(8);
            } else {
                int iH3 = q73Var.h(7);
                if (iH3 != 0) {
                    z = z2;
                    iH = iH3;
                    iH2 = 0;
                } else {
                    z = true;
                    iH2 = 0;
                    iH = 0;
                }
            }
            if (iH != 0 && paint != null) {
                if (bArr != null) {
                    iH2 = bArr[iH2];
                }
                paint.setColor(iArr[iH2]);
                canvas.drawRect(i2, i3, i2 + iH, 1 + i3, paint);
            }
            i2 += iH;
            if (z) {
                return i2;
            }
            z2 = z;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void l(byte[] bArr, int[] iArr, int i2, int i3, int i4, Paint paint, Canvas canvas) {
        int[] iArr2;
        Paint paint2;
        Canvas canvas2;
        byte[] bArr2;
        byte[] bArr3;
        q73 q73Var = new q73(bArr);
        byte[] bArrD = null;
        byte[] bArrD2 = null;
        int i5 = i3;
        int i6 = i4;
        byte[] bArrD3 = null;
        while (q73Var.b() != 0) {
            int iH = q73Var.h(8);
            if (iH != 240) {
                switch (iH) {
                    case 16:
                        iArr2 = iArr;
                        Paint paint3 = paint;
                        canvas2 = canvas;
                        if (i2 == 3) {
                            bArr3 = bArrD3 == null ? i : bArrD3;
                        } else if (i2 != 2) {
                            bArr2 = null;
                            paint2 = paint3;
                            i5 = i(q73Var, iArr2, bArr2, i5, i6, paint2, canvas2);
                            q73Var.c();
                        } else {
                            bArr3 = bArrD2 == null ? h : bArrD2;
                        }
                        paint2 = paint3;
                        bArr2 = bArr3;
                        i5 = i(q73Var, iArr2, bArr2, i5, i6, paint2, canvas2);
                        q73Var.c();
                        break;
                    case 17:
                        iArr2 = iArr;
                        Paint paint4 = paint;
                        canvas2 = canvas;
                        paint2 = paint4;
                        i5 = j(q73Var, iArr2, i2 == 3 ? bArrD == null ? j : bArrD : null, i5, i6, paint2, canvas2);
                        q73Var.c();
                        break;
                    case 18:
                        iArr2 = iArr;
                        paint2 = paint;
                        canvas2 = canvas;
                        i5 = k(q73Var, iArr2, null, i5, i6, paint2, canvas2);
                        break;
                    default:
                        switch (iH) {
                            case 32:
                                bArrD2 = d(4, 4, q73Var);
                                break;
                            case 33:
                                bArrD3 = d(4, 8, q73Var);
                                break;
                            case Token.GETPROPNOWARN /* 34 */:
                                bArrD = d(16, 8, q73Var);
                                break;
                        }
                        iArr2 = iArr;
                        paint2 = paint;
                        canvas2 = canvas;
                        break;
                }
            } else {
                iArr2 = iArr;
                paint2 = paint;
                canvas2 = canvas;
                i6 += 2;
                i5 = i3;
            }
            iArr = iArr2;
            paint = paint2;
            canvas = canvas2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void m(c cVar, a aVar, int i2, int i3, int i4, Paint paint, Canvas canvas) {
        int[] iArr = i2 == 3 ? aVar.d : i2 == 2 ? aVar.c : aVar.b;
        l(cVar.c, iArr, i2, i3, i4, paint, canvas);
        l(cVar.d, iArr, i2, i3, i4 + 1, paint, canvas);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static a o(q73 q73Var, int i2) {
        int iH;
        int i3;
        int iH2;
        int iH3;
        int iH4;
        int i4 = 8;
        int iH5 = q73Var.h(8);
        q73Var.r(8);
        int i5 = 2;
        int i6 = i2 - 2;
        int[] iArrE = e();
        int[] iArrF = f();
        int[] iArrG = g();
        while (i6 > 0) {
            int iH6 = q73Var.h(i4);
            int iH7 = q73Var.h(i4);
            int[] iArr = (iH7 & 128) != 0 ? iArrE : (iH7 & 64) != 0 ? iArrF : iArrG;
            if ((iH7 & 1) != 0) {
                iH3 = q73Var.h(i4);
                iH4 = q73Var.h(i4);
                iH = q73Var.h(i4);
                iH2 = q73Var.h(i4);
                i3 = i6 - 6;
            } else {
                int iH8 = q73Var.h(6) << i5;
                int iH9 = q73Var.h(4) << 4;
                iH = q73Var.h(4) << 4;
                i3 = i6 - 4;
                iH2 = q73Var.h(i5) << 6;
                iH3 = iH8;
                iH4 = iH9;
            }
            if (iH3 == 0) {
                iH2 = 255;
                iH4 = 0;
                iH = 0;
            }
            double d2 = iH3;
            double d3 = iH4 - 128;
            double d4 = iH - 128;
            iArr[iH6] = h((byte) (255 - (iH2 & 255)), fy4.s((int) (d2 + (1.402d * d3)), 0, 255), fy4.s((int) ((d2 - (0.34414d * d4)) - (d3 * 0.71414d)), 0, 255), fy4.s((int) (d2 + (d4 * 1.772d)), 0, 255));
            i6 = i3;
            iH5 = iH5;
            i4 = 8;
            i5 = 2;
        }
        return new a(iH5, iArrE, iArrF, iArrG);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static b p(q73 q73Var) {
        int i2;
        int i3;
        int i4;
        int iH;
        q73Var.r(4);
        boolean zG = q73Var.g();
        q73Var.r(3);
        int iH2 = q73Var.h(16);
        int iH3 = q73Var.h(16);
        if (zG) {
            int iH4 = q73Var.h(16);
            int iH5 = q73Var.h(16);
            int iH6 = q73Var.h(16);
            iH = q73Var.h(16);
            i4 = iH5;
            i3 = iH6;
            i2 = iH4;
        } else {
            i2 = 0;
            i3 = 0;
            i4 = iH2;
            iH = iH3;
        }
        return new b(iH2, iH3, i2, i4, i3, iH);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static c q(q73 q73Var) {
        byte[] bArr;
        int iH = q73Var.h(16);
        q73Var.r(4);
        int iH2 = q73Var.h(2);
        boolean zG = q73Var.g();
        q73Var.r(1);
        byte[] bArr2 = fy4.f;
        if (iH2 != 1) {
            if (iH2 == 0) {
                int iH3 = q73Var.h(16);
                int iH4 = q73Var.h(16);
                if (iH3 > 0) {
                    bArr2 = new byte[iH3];
                    q73Var.k(bArr2, 0, iH3);
                }
                if (iH4 > 0) {
                    bArr = new byte[iH4];
                    q73Var.k(bArr, 0, iH4);
                }
            }
            return new c(iH, zG, bArr2, bArr);
        }
        q73Var.r(q73Var.h(8) * 16);
        bArr = bArr2;
        return new c(iH, zG, bArr2, bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static d r(q73 q73Var, int i2) {
        int iH = q73Var.h(8);
        int iH2 = q73Var.h(4);
        int iH3 = q73Var.h(2);
        q73Var.r(2);
        int i3 = i2 - 2;
        SparseArray sparseArray = new SparseArray();
        while (i3 > 0) {
            int iH4 = q73Var.h(8);
            q73Var.r(8);
            i3 -= 6;
            sparseArray.put(iH4, new e(q73Var.h(16), q73Var.h(16)));
        }
        return new d(iH, iH2, iH3, sparseArray);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static f s(q73 q73Var, int i2) {
        int i3;
        int iH;
        int iH2;
        char c2;
        int iH3 = q73Var.h(8);
        int i4 = 4;
        q73Var.r(4);
        boolean zG = q73Var.g();
        q73Var.r(3);
        int i5 = 16;
        int iH4 = q73Var.h(16);
        int iH5 = q73Var.h(16);
        int iH6 = q73Var.h(3);
        int iH7 = q73Var.h(3);
        int i6 = 2;
        q73Var.r(2);
        int iH8 = q73Var.h(8);
        int iH9 = q73Var.h(8);
        int iH10 = q73Var.h(4);
        int iH11 = q73Var.h(2);
        q73Var.r(2);
        int i7 = i2 - 10;
        SparseArray sparseArray = new SparseArray();
        while (i7 > 0) {
            int iH12 = q73Var.h(i5);
            int iH13 = q73Var.h(i6);
            int iH14 = q73Var.h(i6);
            int iH15 = q73Var.h(12);
            q73Var.r(i4);
            int iH16 = q73Var.h(12);
            int i8 = i7 - 6;
            if (iH13 != 1) {
                i3 = 2;
                if (iH13 != 2) {
                    iH2 = 0;
                    iH = 0;
                    i7 = i8;
                    c2 = '\b';
                }
                sparseArray.put(iH12, new g(iH13, iH14, iH15, iH16, iH2, iH));
                i5 = 16;
                i6 = i3;
                i4 = 4;
            } else {
                i3 = 2;
            }
            c2 = '\b';
            i7 -= 8;
            iH2 = q73Var.h(8);
            iH = q73Var.h(8);
            sparseArray.put(iH12, new g(iH13, iH14, iH15, iH16, iH2, iH));
            i5 = 16;
            i6 = i3;
            i4 = 4;
        }
        return new f(iH3, zG, iH4, iH5, iH6, iH7, iH8, iH9, iH10, iH11, sparseArray);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void t(q73 q73Var, h hVar) {
        f fVar;
        int iH = q73Var.h(8);
        int iH2 = q73Var.h(16);
        int iH3 = q73Var.h(16);
        int iD = q73Var.d() + iH3;
        if (iH3 * 8 > q73Var.b()) {
            xz1.i("DvbParser", "Data field length exceeds limit");
            q73Var.r(q73Var.b());
            return;
        }
        switch (iH) {
            case 16:
                if (iH2 == hVar.a) {
                    d dVar = hVar.i;
                    d dVarR = r(q73Var, iH3);
                    if (dVarR.c != 0) {
                        hVar.i = dVarR;
                        hVar.c.clear();
                        hVar.d.clear();
                        hVar.e.clear();
                    } else if (dVar != null && dVar.b != dVarR.b) {
                        hVar.i = dVarR;
                    }
                }
                break;
            case 17:
                d dVar2 = hVar.i;
                if (iH2 == hVar.a && dVar2 != null) {
                    f fVarS = s(q73Var, iH3);
                    if (dVar2.c == 0 && (fVar = (f) hVar.c.get(fVarS.a)) != null) {
                        fVarS.a(fVar);
                    }
                    hVar.c.put(fVarS.a, fVarS);
                }
                break;
            case 18:
                if (iH2 == hVar.a) {
                    a aVarO = o(q73Var, iH3);
                    hVar.d.put(aVarO.a, aVarO);
                } else if (iH2 == hVar.b) {
                    a aVarO2 = o(q73Var, iH3);
                    hVar.f.put(aVarO2.a, aVarO2);
                }
                break;
            case 19:
                if (iH2 == hVar.a) {
                    c cVarQ = q(q73Var);
                    hVar.e.put(cVarQ.a, cVarQ);
                } else if (iH2 == hVar.b) {
                    c cVarQ2 = q(q73Var);
                    hVar.g.put(cVarQ2.a, cVarQ2);
                }
                break;
            case 20:
                if (iH2 == hVar.a) {
                    hVar.h = p(q73Var);
                }
                break;
        }
        q73Var.s(iD - q73Var.d());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ki4
    public void b(byte[] bArr, int i2, int i3, ki4.b bVar, g20 g20Var) {
        q73 q73Var = new q73(bArr, i3 + i2);
        q73Var.p(i2);
        g20Var.accept(n(q73Var));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ki4
    public int c() {
        return 2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final y50 n(q73 q73Var) {
        SparseArray sparseArray;
        int i2;
        while (q73Var.b() >= 48 && q73Var.h(8) == 15) {
            t(q73Var, this.f);
        }
        h hVar = this.f;
        d dVar = hVar.i;
        if (dVar == null) {
            return new y50(xi1.u(), -9223372036854775807L, -9223372036854775807L);
        }
        b bVar = hVar.h;
        if (bVar == null) {
            bVar = this.d;
        }
        Bitmap bitmap = this.g;
        if (bitmap == null || bVar.a + 1 != bitmap.getWidth() || bVar.b + 1 != this.g.getHeight()) {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bVar.a + 1, bVar.b + 1, Bitmap.Config.ARGB_8888);
            this.g = bitmapCreateBitmap;
            this.c.setBitmap(bitmapCreateBitmap);
        }
        ArrayList arrayList = new ArrayList();
        SparseArray sparseArray2 = dVar.d;
        int i3 = 0;
        while (i3 < sparseArray2.size()) {
            this.c.save();
            e eVar = (e) sparseArray2.valueAt(i3);
            f fVar = (f) this.f.c.get(sparseArray2.keyAt(i3));
            int i4 = eVar.a + bVar.c;
            int i5 = eVar.b + bVar.e;
            this.c.clipRect(i4, i5, Math.min(fVar.c + i4, bVar.d), Math.min(fVar.d + i5, bVar.f));
            a aVar = (a) this.f.d.get(fVar.g);
            if (aVar == null && (aVar = (a) this.f.f.get(fVar.g)) == null) {
                aVar = this.e;
            }
            a aVar2 = aVar;
            SparseArray sparseArray3 = fVar.k;
            int i6 = 0;
            while (i6 < sparseArray3.size()) {
                int iKeyAt = sparseArray3.keyAt(i6);
                g gVar = (g) sparseArray3.valueAt(i6);
                c cVar = (c) this.f.e.get(iKeyAt);
                if (cVar == null) {
                    cVar = (c) this.f.g.get(iKeyAt);
                }
                if (cVar != null) {
                    sparseArray = sparseArray2;
                    i2 = i6;
                    m(cVar, aVar2, fVar.f, gVar.c + i4, gVar.d + i5, cVar.b ? null : this.a, this.c);
                } else {
                    sparseArray = sparseArray2;
                    i2 = i6;
                }
                i6 = i2 + 1;
                sparseArray2 = sparseArray;
            }
            SparseArray sparseArray4 = sparseArray2;
            if (fVar.b) {
                int i7 = fVar.f;
                this.b.setColor(i7 == 3 ? aVar2.d[fVar.h] : i7 == 2 ? aVar2.c[fVar.i] : aVar2.b[fVar.j]);
                this.c.drawRect(i4, i5, fVar.c + i4, fVar.d + i5, this.b);
            }
            arrayList.add(new p50.b().f(Bitmap.createBitmap(this.g, i4, i5, fVar.c, fVar.d)).k(i4 / bVar.a).l(0).h(i5 / bVar.b, 0).i(0).n(fVar.c / bVar.a).g(fVar.d / bVar.b).a());
            this.c.drawColor(0, PorterDuff.Mode.CLEAR);
            this.c.restore();
            i3++;
            sparseArray2 = sparseArray4;
        }
        return new y50(arrayList, -9223372036854775807L, -9223372036854775807L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ki4
    public void reset() {
        this.f.a();
    }
}
