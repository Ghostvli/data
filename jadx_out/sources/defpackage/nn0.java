package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.ColorSpace;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.DisplayMetrics;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import defpackage.hn0;
import defpackage.mi1;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class nn0 {
    public static final s63 f = s63.f("com.bumptech.glide.load.resource.bitmap.Downsampler.DecodeFormat", za0.h);
    public static final s63 g = s63.e("com.bumptech.glide.load.resource.bitmap.Downsampler.PreferredColorSpace");
    public static final s63 h = hn0.h;
    public static final s63 i;
    public static final s63 j;
    public static final Set k;
    public static final b l;
    public static final Set m;
    public static final Queue n;
    public final kk a;
    public final DisplayMetrics b;
    public final ma c;
    public final List d;
    public final qc1 e = qc1.b();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements b {
        @Override // nn0.b
        public void a() {
        }

        @Override // nn0.b
        public void b(kk kkVar, Bitmap bitmap) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void a();

        void b(kk kkVar, Bitmap bitmap);
    }

    static {
        Boolean bool = Boolean.FALSE;
        i = s63.f("com.bumptech.glide.load.resource.bitmap.Downsampler.FixBitmapSize", bool);
        j = s63.f("com.bumptech.glide.load.resource.bitmap.Downsampler.AllowHardwareDecode", bool);
        k = Collections.unmodifiableSet(new HashSet(Arrays.asList("image/vnd.wap.wbmp", "image/x-ico")));
        l = new a();
        m = Collections.unmodifiableSet(EnumSet.of(ImageHeaderParser.ImageType.JPEG, ImageHeaderParser.ImageType.PNG_A, ImageHeaderParser.ImageType.PNG));
        n = iy4.g(0);
    }

    public nn0(List list, DisplayMetrics displayMetrics, kk kkVar, ma maVar) {
        this.d = list;
        this.b = (DisplayMetrics) fg3.e(displayMetrics);
        this.a = (kk) fg3.e(kkVar);
        this.c = (ma) fg3.e(maVar);
    }

    public static int a(double d) {
        int iL = l(d);
        int iX = x(((double) iL) * d);
        return x((d / ((double) (iX / iL))) * ((double) iX));
    }

    public static void c(ImageHeaderParser.ImageType imageType, mi1 mi1Var, b bVar, kk kkVar, hn0 hn0Var, int i2, int i3, int i4, int i5, int i6, BitmapFactory.Options options) {
        int i7;
        int i8;
        int i9;
        int iFloor;
        int iFloor2;
        if (i3 <= 0 || i4 <= 0) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Unable to determine dimensions for: " + imageType + " with target [" + i5 + "x" + i6 + "]");
                return;
            }
            return;
        }
        if (r(i2)) {
            i8 = i3;
            i7 = i4;
        } else {
            i7 = i3;
            i8 = i4;
        }
        float fB = hn0Var.b(i7, i8, i5, i6);
        if (fB <= 0.0f) {
            throw new IllegalArgumentException("Cannot scale with factor: " + fB + " from: " + hn0Var + ", source: [" + i3 + "x" + i4 + "], target: [" + i5 + "x" + i6 + "]");
        }
        hn0.g gVarA = hn0Var.a(i7, i8, i5, i6);
        if (gVarA == null) {
            jl.a("Cannot round with null rounding");
            return;
        }
        float f2 = i7;
        float f3 = i8;
        int i10 = i7;
        int i11 = i8;
        int iX = i10 / x(fB * f2);
        int iX2 = i11 / x(fB * f3);
        hn0.g gVar = hn0.g.MEMORY;
        int iMax = Math.max(1, Integer.highestOneBit(gVarA == gVar ? Math.max(iX, iX2) : Math.min(iX, iX2)));
        if (gVarA == gVar && iMax < 1.0f / fB) {
            iMax <<= 1;
        }
        options.inSampleSize = iMax;
        if (imageType == ImageHeaderParser.ImageType.JPEG) {
            float fMin = Math.min(iMax, 8);
            i9 = 0;
            iFloor = (int) Math.ceil(f2 / fMin);
            iFloor2 = (int) Math.ceil(f3 / fMin);
            int i12 = iMax / 8;
            if (i12 > 0) {
                iFloor /= i12;
                iFloor2 /= i12;
            }
        } else {
            i9 = 0;
            if (imageType == ImageHeaderParser.ImageType.PNG || imageType == ImageHeaderParser.ImageType.PNG_A) {
                float f4 = iMax;
                iFloor = (int) Math.floor(f2 / f4);
                iFloor2 = (int) Math.floor(f3 / f4);
            } else if (imageType.isWebp()) {
                float f5 = iMax;
                iFloor = Math.round(f2 / f5);
                iFloor2 = Math.round(f3 / f5);
            } else if (i10 % iMax == 0 && i11 % iMax == 0) {
                iFloor = i10 / iMax;
                iFloor2 = i11 / iMax;
            } else {
                int[] iArrM = m(mi1Var, options, bVar, kkVar);
                iFloor = iArrM[0];
                iFloor2 = iArrM[1];
            }
        }
        double dB = hn0Var.b(iFloor, iFloor2, i5, i6);
        options.inTargetDensity = a(dB);
        options.inDensity = l(dB);
        if (s(options)) {
            options.inScaled = true;
        } else {
            int i13 = i9;
            options.inTargetDensity = i13;
            options.inDensity = i13;
        }
        if (Log.isLoggable("Downsampler", 2)) {
            Log.v("Downsampler", "Calculate scaling, source: [" + i3 + "x" + i4 + "], degreesToRotate: " + i2 + ", target: [" + i5 + "x" + i6 + "], power of two scaled: [" + iFloor + "x" + iFloor2 + "], exact scale factor: " + fB + ", power of 2 sample size: " + iMax + ", adjusted scale factor: " + dB + ", target density: " + options.inTargetDensity + ", density: " + options.inDensity);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:?, code lost:
    
        throw r1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static android.graphics.Bitmap i(defpackage.mi1 r5, android.graphics.BitmapFactory.Options r6, nn0.b r7, defpackage.kk r8) {
        /*
            java.lang.String r0 = "Downsampler"
            boolean r1 = r6.inJustDecodeBounds
            if (r1 != 0) goto Lc
            r7.a()
            r5.d()
        Lc:
            int r1 = r6.outWidth
            int r2 = r6.outHeight
            java.lang.String r3 = r6.outMimeType
            java.util.concurrent.locks.Lock r4 = defpackage.os4.i()
            r4.lock()
            android.graphics.Bitmap r5 = r5.b(r6)     // Catch: java.lang.IllegalArgumentException -> L25 java.lang.Throwable -> L47
        L1d:
            java.util.concurrent.locks.Lock r6 = defpackage.os4.i()
            r6.unlock()
            return r5
        L25:
            r4 = move-exception
            java.io.IOException r1 = u(r4, r1, r2, r3, r6)     // Catch: java.lang.Throwable -> L47
            r2 = 3
            boolean r2 = android.util.Log.isLoggable(r0, r2)     // Catch: java.lang.Throwable -> L47
            if (r2 == 0) goto L36
            java.lang.String r2 = "Failed to decode with inBitmap, trying again without Bitmap re-use"
            android.util.Log.d(r0, r2, r1)     // Catch: java.lang.Throwable -> L47
        L36:
            android.graphics.Bitmap r0 = r6.inBitmap     // Catch: java.lang.Throwable -> L47
            if (r0 == 0) goto L46
            r8.c(r0)     // Catch: java.io.IOException -> L45 java.lang.Throwable -> L47
            r0 = 0
            r6.inBitmap = r0     // Catch: java.io.IOException -> L45 java.lang.Throwable -> L47
            android.graphics.Bitmap r5 = i(r5, r6, r7, r8)     // Catch: java.io.IOException -> L45 java.lang.Throwable -> L47
            goto L1d
        L45:
            throw r1     // Catch: java.lang.Throwable -> L47
        L46:
            throw r1     // Catch: java.lang.Throwable -> L47
        L47:
            r5 = move-exception
            java.util.concurrent.locks.Lock r6 = defpackage.os4.i()
            r6.unlock()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.nn0.i(mi1, android.graphics.BitmapFactory$Options, nn0$b, kk):android.graphics.Bitmap");
    }

    public static String j(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return "[" + bitmap.getWidth() + "x" + bitmap.getHeight() + "] " + bitmap.getConfig() + (" (" + bitmap.getAllocationByteCount() + ")");
    }

    public static synchronized BitmapFactory.Options k() {
        BitmapFactory.Options options;
        Queue queue = n;
        synchronized (queue) {
            options = (BitmapFactory.Options) queue.poll();
        }
        if (options == null) {
            options = new BitmapFactory.Options();
            w(options);
        }
        return options;
    }

    public static int l(double d) {
        if (d > 1.0d) {
            d = 1.0d / d;
        }
        return (int) Math.round(d * 2.147483647E9d);
    }

    public static int[] m(mi1 mi1Var, BitmapFactory.Options options, b bVar, kk kkVar) {
        options.inJustDecodeBounds = true;
        i(mi1Var, options, bVar, kkVar);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    public static String n(BitmapFactory.Options options) {
        return j(options.inBitmap);
    }

    public static boolean r(int i2) {
        return i2 == 90 || i2 == 270;
    }

    public static boolean s(BitmapFactory.Options options) {
        int i2;
        int i3 = options.inTargetDensity;
        return i3 > 0 && (i2 = options.inDensity) > 0 && i3 != i2;
    }

    public static void t(int i2, int i3, String str, BitmapFactory.Options options, Bitmap bitmap, int i4, int i5, long j2) {
        Log.v("Downsampler", "Decoded " + j(bitmap) + " from [" + i2 + "x" + i3 + "] " + str + " with inBitmap " + n(options) + " for [" + i4 + "x" + i5 + "], sample size: " + options.inSampleSize + ", density: " + options.inDensity + ", target density: " + options.inTargetDensity + ", thread: " + Thread.currentThread().getName() + ", duration: " + b02.a(j2));
    }

    public static IOException u(IllegalArgumentException illegalArgumentException, int i2, int i3, String str, BitmapFactory.Options options) {
        return new IOException("Exception decoding bitmap, outWidth: " + i2 + ", outHeight: " + i3 + ", outMimeType: " + str + ", inBitmap: " + n(options), illegalArgumentException);
    }

    public static void v(BitmapFactory.Options options) {
        w(options);
        Queue queue = n;
        synchronized (queue) {
            queue.offer(options);
        }
    }

    public static void w(BitmapFactory.Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.inDensity = 0;
        options.inTargetDensity = 0;
        if (Build.VERSION.SDK_INT >= 26) {
            options.inPreferredColorSpace = null;
            options.outColorSpace = null;
            options.outConfig = null;
        }
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        options.inBitmap = null;
        options.inMutable = true;
    }

    public static int x(double d) {
        return (int) (d + 0.5d);
    }

    public static void y(BitmapFactory.Options options, kk kkVar, int i2, int i3) {
        Bitmap.Config config;
        if (Build.VERSION.SDK_INT < 26) {
            config = null;
        } else if (options.inPreferredConfig == Bitmap.Config.HARDWARE) {
            return;
        } else {
            config = options.outConfig;
        }
        if (config == null) {
            config = options.inPreferredConfig;
        }
        options.inBitmap = kkVar.e(i2, i3, config);
    }

    public final void b(mi1 mi1Var, za0 za0Var, boolean z, boolean z2, BitmapFactory.Options options, int i2, int i3) {
        boolean zHasAlpha;
        if (this.e.g(i2, i3, options, z, z2)) {
            return;
        }
        if (za0Var == za0.PREFER_ARGB_8888) {
            options.inPreferredConfig = Bitmap.Config.ARGB_8888;
            return;
        }
        try {
            zHasAlpha = mi1Var.e().hasAlpha();
        } catch (IOException e) {
            if (Log.isLoggable("Downsampler", 3)) {
                Log.d("Downsampler", "Cannot determine whether the image has alpha or not from header, format " + za0Var, e);
            }
            zHasAlpha = false;
        }
        Bitmap.Config config = zHasAlpha ? Bitmap.Config.ARGB_8888 : Bitmap.Config.RGB_565;
        options.inPreferredConfig = config;
        if (config == Bitmap.Config.RGB_565) {
            options.inDither = true;
        }
    }

    public final yr3 d(mi1 mi1Var, int i2, int i3, u63 u63Var, b bVar) {
        byte[] bArr = (byte[]) this.c.d(65536, byte[].class);
        BitmapFactory.Options optionsK = k();
        optionsK.inTempStorage = bArr;
        za0 za0Var = (za0) u63Var.c(f);
        mg3 mg3Var = (mg3) u63Var.c(g);
        hn0 hn0Var = (hn0) u63Var.c(hn0.h);
        boolean zBooleanValue = ((Boolean) u63Var.c(i)).booleanValue();
        s63 s63Var = j;
        try {
            return mk.f(h(mi1Var, optionsK, hn0Var, za0Var, mg3Var, u63Var.c(s63Var) != null && ((Boolean) u63Var.c(s63Var)).booleanValue(), i2, i3, zBooleanValue, bVar), this.a);
        } finally {
            v(optionsK);
            this.c.put(bArr);
        }
    }

    public yr3 e(ParcelFileDescriptor parcelFileDescriptor, int i2, int i3, u63 u63Var) {
        return d(new mi1.c(parcelFileDescriptor, this.d, this.c), i2, i3, u63Var, l);
    }

    public yr3 f(InputStream inputStream, int i2, int i3, u63 u63Var, b bVar) {
        return d(new mi1.b(inputStream, this.d, this.c), i2, i3, u63Var, bVar);
    }

    public yr3 g(ByteBuffer byteBuffer, int i2, int i3, u63 u63Var) {
        return d(new mi1.a(byteBuffer, this.d, this.c), i2, i3, u63Var, l);
    }

    public final Bitmap h(mi1 mi1Var, BitmapFactory.Options options, hn0 hn0Var, za0 za0Var, mg3 mg3Var, boolean z, int i2, int i3, boolean z2, b bVar) {
        int i4;
        String str;
        ColorSpace colorSpace;
        int iRound;
        int i5;
        long jB = b02.b();
        int[] iArrM = m(mi1Var, options, bVar, this.a);
        int i6 = iArrM[0];
        int i7 = iArrM[1];
        String str2 = options.outMimeType;
        boolean z3 = (i6 == -1 || i7 == -1) ? false : z;
        int iA = mi1Var.a();
        int iJ = os4.j(iA);
        boolean zM = os4.m(iA);
        int i8 = i2;
        if (i8 != Integer.MIN_VALUE) {
            i4 = i3;
        } else if (r(iJ)) {
            i4 = i3;
            i8 = i7;
        } else {
            i4 = i3;
            i8 = i6;
        }
        if (i4 == Integer.MIN_VALUE) {
            i4 = r(iJ) ? i6 : i7;
        }
        ImageHeaderParser.ImageType imageTypeE = mi1Var.e();
        c(imageTypeE, mi1Var, bVar, this.a, hn0Var, iJ, i6, i7, i8, i4, options);
        int i9 = i8;
        int i10 = i4;
        b(mi1Var, za0Var, z3, zM, options, i9, i10);
        if (z(imageTypeE)) {
            if (i6 < 0 || i7 < 0 || !z2) {
                float f2 = s(options) ? options.inTargetDensity / options.inDensity : 1.0f;
                int i11 = options.inSampleSize;
                float f3 = i6;
                float f4 = i11;
                int iCeil = (int) Math.ceil(f3 / f4);
                int iCeil2 = (int) Math.ceil(i7 / f4);
                int iRound2 = Math.round(iCeil * f2);
                iRound = Math.round(iCeil2 * f2);
                str = "Downsampler";
                if (Log.isLoggable(str, 2)) {
                    StringBuilder sb = new StringBuilder("Calculated target [");
                    sb.append(iRound2);
                    sb.append("x");
                    sb.append(iRound);
                    i5 = iRound2;
                    sb.append("] for source [");
                    sb.append(i6);
                    sb.append("x");
                    sb.append(i7);
                    sb.append("], sampleSize: ");
                    sb.append(i11);
                    sb.append(", targetDensity: ");
                    sb.append(options.inTargetDensity);
                    sb.append(", density: ");
                    sb.append(options.inDensity);
                    sb.append(", density multiplier: ");
                    sb.append(f2);
                    Log.v(str, sb.toString());
                } else {
                    i5 = iRound2;
                }
                i9 = i5;
            } else {
                str = "Downsampler";
                iRound = i10;
            }
            if (i9 > 0 && iRound > 0) {
                y(options, this.a, i9, iRound);
            }
        } else {
            str = "Downsampler";
        }
        if (mg3Var != null) {
            int i12 = Build.VERSION.SDK_INT;
            if (i12 >= 28) {
                options.inPreferredColorSpace = ColorSpace.get((mg3Var == mg3.DISPLAY_P3 && (colorSpace = options.outColorSpace) != null && colorSpace.isWideGamut()) ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB);
            } else if (i12 >= 26) {
                options.inPreferredColorSpace = ColorSpace.get(ColorSpace.Named.SRGB);
            }
        }
        Bitmap bitmapI = i(mi1Var, options, bVar, this.a);
        bVar.b(this.a, bitmapI);
        if (Log.isLoggable(str, 2)) {
            t(i6, i7, str2, options, bitmapI, i2, i3, jB);
        }
        if (bitmapI == null) {
            return null;
        }
        bitmapI.setDensity(this.b.densityDpi);
        Bitmap bitmapN = os4.n(this.a, bitmapI, iA);
        if (!bitmapI.equals(bitmapN)) {
            this.a.c(bitmapI);
        }
        return bitmapN;
    }

    public boolean o(ParcelFileDescriptor parcelFileDescriptor) {
        return ParcelFileDescriptorRewinder.c();
    }

    public boolean p(InputStream inputStream) {
        return true;
    }

    public boolean q(ByteBuffer byteBuffer) {
        return true;
    }

    public final boolean z(ImageHeaderParser.ImageType imageType) {
        return true;
    }
}
