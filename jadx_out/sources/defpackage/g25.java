package defpackage;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.media.MediaDataSource;
import android.media.MediaExtractor;
import android.media.MediaMetadataRetriever;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import defpackage.s63;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class g25 implements ds3 {
    public static final s63 d = s63.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.TargetFrame", -1L, new a());
    public static final s63 e = s63.a("com.bumptech.glide.load.resource.bitmap.VideoBitmapDecode.FrameOption", 2, new b());
    public static final f f = new f();
    public static final List g = Collections.unmodifiableList(Arrays.asList("TP1A", "TD1A.220804.031"));
    public final e a;
    public final kk b;
    public final f c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements s63.b {
        public final ByteBuffer a = ByteBuffer.allocate(8);

        @Override // s63.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr, Long l, MessageDigest messageDigest) {
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putLong(l.longValue()).array());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements s63.b {
        public final ByteBuffer a = ByteBuffer.allocate(4);

        @Override // s63.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(byte[] bArr, Integer num, MessageDigest messageDigest) {
            if (num == null) {
                return;
            }
            messageDigest.update(bArr);
            synchronized (this.a) {
                this.a.position(0);
                messageDigest.update(this.a.putInt(num.intValue()).array());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d implements e {

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a extends MediaDataSource {
            public final /* synthetic */ ByteBuffer f;

            public a(ByteBuffer byteBuffer) {
                this.f = byteBuffer;
            }

            @Override // java.io.Closeable, java.lang.AutoCloseable
            public void close() {
            }

            @Override // android.media.MediaDataSource
            public long getSize() {
                return this.f.limit();
            }

            @Override // android.media.MediaDataSource
            public int readAt(long j, byte[] bArr, int i, int i2) {
                if (j >= this.f.limit()) {
                    return -1;
                }
                this.f.position((int) j);
                int iMin = Math.min(i2, this.f.remaining());
                this.f.get(bArr, i, iMin);
                return iMin;
            }
        }

        public final MediaDataSource c(ByteBuffer byteBuffer) {
            return new a(byteBuffer);
        }

        @Override // g25.e
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void a(MediaExtractor mediaExtractor, ByteBuffer byteBuffer) throws IOException {
            mediaExtractor.setDataSource(c(byteBuffer));
        }

        @Override // g25.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(MediaMetadataRetriever mediaMetadataRetriever, ByteBuffer byteBuffer) {
            mediaMetadataRetriever.setDataSource(c(byteBuffer));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface e {
        void a(MediaExtractor mediaExtractor, Object obj);

        void b(MediaMetadataRetriever mediaMetadataRetriever, Object obj);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class f {
        public MediaMetadataRetriever a() {
            return new MediaMetadataRetriever();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g implements e {
        @Override // g25.e
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(MediaExtractor mediaExtractor, ParcelFileDescriptor parcelFileDescriptor) throws IOException {
            mediaExtractor.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }

        @Override // g25.e
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(MediaMetadataRetriever mediaMetadataRetriever, ParcelFileDescriptor parcelFileDescriptor) {
            mediaMetadataRetriever.setDataSource(parcelFileDescriptor.getFileDescriptor());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class h extends RuntimeException {
        public h() {
            super("MediaMetadataRetriever failed to retrieve a frame without throwing, check the adb logs for .*MetadataRetriever.* prior to this exception for details");
        }
    }

    public g25(kk kkVar, e eVar, f fVar) {
        this.b = kkVar;
        this.a = eVar;
        this.c = fVar;
    }

    public static ds3 c(kk kkVar) {
        return new g25(kkVar, new c(null));
    }

    public static ds3 d(kk kkVar) {
        return new g25(kkVar, new d());
    }

    public static Bitmap e(MediaMetadataRetriever mediaMetadataRetriever, Bitmap bitmap) {
        if (j()) {
            try {
                if (i(mediaMetadataRetriever)) {
                    if (Math.abs(Integer.parseInt(mediaMetadataRetriever.extractMetadata(24))) != 180) {
                        return bitmap;
                    }
                    if (Log.isLoggable("VideoDecoder", 3)) {
                        Log.d("VideoDecoder", "Applying HDR 180 deg thumbnail correction");
                    }
                    Matrix matrix = new Matrix();
                    matrix.postRotate(180.0f, bitmap.getWidth() / 2.0f, bitmap.getHeight() / 2.0f);
                    return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                }
            } catch (NumberFormatException unused) {
                if (!Log.isLoggable("VideoDecoder", 3)) {
                    return bitmap;
                }
                Log.d("VideoDecoder", "Exception trying to extract HDR transfer function or rotation");
                return bitmap;
            }
        }
        return bitmap;
    }

    public static Bitmap g(MediaMetadataRetriever mediaMetadataRetriever, long j, int i) {
        return mediaMetadataRetriever.getFrameAtTime(j, i);
    }

    public static Bitmap h(MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, hn0 hn0Var) {
        try {
            int i4 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
            int i5 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
            int i6 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
            if (i6 == 90 || i6 == 270) {
                i5 = i4;
                i4 = i5;
            }
            float fB = hn0Var.b(i4, i5, i2, i3);
            return mediaMetadataRetriever.getScaledFrameAtTime(j, i, Math.round(i4 * fB), Math.round(fB * i5));
        } catch (Throwable th) {
            if (!Log.isLoggable("VideoDecoder", 3)) {
                return null;
            }
            Log.d("VideoDecoder", "Exception trying to decode a scaled frame on oreo+, falling back to a fullsize frame", th);
            return null;
        }
    }

    public static boolean i(MediaMetadataRetriever mediaMetadataRetriever) {
        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(36);
        String strExtractMetadata2 = mediaMetadataRetriever.extractMetadata(35);
        int i = Integer.parseInt(strExtractMetadata);
        return (i == 7 || i == 6) && Integer.parseInt(strExtractMetadata2) == 6;
    }

    public static boolean j() {
        if (Build.MODEL.startsWith("Pixel") && Build.VERSION.SDK_INT == 33) {
            return k();
        }
        int i = Build.VERSION.SDK_INT;
        return i >= 30 && i < 33;
    }

    public static boolean k() {
        Iterator it = g.iterator();
        while (it.hasNext()) {
            if (Build.ID.startsWith((String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public static ds3 m(kk kkVar) {
        return new g25(kkVar, new g());
    }

    @Override // defpackage.ds3
    public boolean a(Object obj, u63 u63Var) {
        return true;
    }

    @Override // defpackage.ds3
    public yr3 b(Object obj, int i, int i2, u63 u63Var) throws Exception {
        long jLongValue = ((Long) u63Var.c(d)).longValue();
        if (jLongValue < 0 && jLongValue != -1) {
            ts0.a("Requested frame must be non-negative, or DEFAULT_FRAME, given: ", jLongValue);
            return null;
        }
        Integer num = (Integer) u63Var.c(e);
        if (num == null) {
            num = 2;
        }
        hn0 hn0Var = (hn0) u63Var.c(hn0.h);
        if (hn0Var == null) {
            hn0Var = hn0.g;
        }
        hn0 hn0Var2 = hn0Var;
        MediaMetadataRetriever mediaMetadataRetrieverA = this.c.a();
        try {
            this.a.b(mediaMetadataRetrieverA, obj);
            Bitmap bitmapF = f(obj, mediaMetadataRetrieverA, jLongValue, num.intValue(), i, i2, hn0Var2);
            if (Build.VERSION.SDK_INT >= 29) {
                d45.a(mediaMetadataRetrieverA);
            } else {
                mediaMetadataRetrieverA.release();
            }
            return mk.f(bitmapF, this.b);
        } catch (Throwable th) {
            if (Build.VERSION.SDK_INT >= 29) {
                d45.a(mediaMetadataRetrieverA);
                throw th;
            }
            mediaMetadataRetrieverA.release();
            throw th;
        }
    }

    public final Bitmap f(Object obj, MediaMetadataRetriever mediaMetadataRetriever, long j, int i, int i2, int i3, hn0 hn0Var) {
        boolean zL = l(obj, mediaMetadataRetriever);
        Bitmap bitmapG = null;
        if (zL) {
            e04.a("Cannot decode VP8 video on CrOS.");
            return null;
        }
        if (Build.VERSION.SDK_INT >= 27 && i2 != Integer.MIN_VALUE && i3 != Integer.MIN_VALUE && hn0Var != hn0.f) {
            bitmapG = h(mediaMetadataRetriever, j, i, i2, i3, hn0Var);
        }
        if (bitmapG == null) {
            bitmapG = g(mediaMetadataRetriever, j, i);
        }
        Bitmap bitmapE = e(mediaMetadataRetriever, bitmapG);
        if (bitmapE != null) {
            return bitmapE;
        }
        throw new h();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0059 A[Catch: all -> 0x005f, TRY_LEAVE, TryCatch #2 {all -> 0x005f, blocks: (B:23:0x0053, B:25:0x0059), top: B:40:0x0053 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0063 A[DONT_GENERATE] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean l(java.lang.Object r5, android.media.MediaMetadataRetriever r6) {
        /*
            r4 = this;
            java.lang.String r0 = "VideoDecoder"
            java.lang.String r1 = android.os.Build.DEVICE
            r2 = 0
            if (r1 == 0) goto L6d
            java.lang.String r3 = ".+_cheets|cheets_.+"
            boolean r1 = r1.matches(r3)
            if (r1 == 0) goto L6d
            r1 = 12
            r3 = 0
            java.lang.String r6 = r6.extractMetadata(r1)     // Catch: java.lang.Throwable -> L51
            java.lang.String r1 = "video/webm"
            boolean r6 = r1.equals(r6)     // Catch: java.lang.Throwable -> L51
            if (r6 != 0) goto L1f
            return r2
        L1f:
            android.media.MediaExtractor r6 = new android.media.MediaExtractor     // Catch: java.lang.Throwable -> L51
            r6.<init>()     // Catch: java.lang.Throwable -> L51
            g25$e r4 = r4.a     // Catch: java.lang.Throwable -> L4a
            r4.a(r6, r5)     // Catch: java.lang.Throwable -> L4a
            int r4 = r6.getTrackCount()     // Catch: java.lang.Throwable -> L4a
            r5 = r2
        L2e:
            if (r5 >= r4) goto L4d
            android.media.MediaFormat r1 = r6.getTrackFormat(r5)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r3 = "mime"
            java.lang.String r1 = r1.getString(r3)     // Catch: java.lang.Throwable -> L4a
            java.lang.String r3 = "video/x-vnd.on2.vp8"
            boolean r1 = r3.equals(r1)     // Catch: java.lang.Throwable -> L4a
            if (r1 == 0) goto L47
            r6.release()
            r4 = 1
            return r4
        L47:
            int r5 = r5 + 1
            goto L2e
        L4a:
            r4 = move-exception
            r3 = r6
            goto L52
        L4d:
            r6.release()
            goto L66
        L51:
            r4 = move-exception
        L52:
            r5 = 3
            boolean r5 = android.util.Log.isLoggable(r0, r5)     // Catch: java.lang.Throwable -> L5f
            if (r5 == 0) goto L61
            java.lang.String r5 = "Exception trying to extract track info for a webm video on CrOS."
            android.util.Log.d(r0, r5, r4)     // Catch: java.lang.Throwable -> L5f
            goto L61
        L5f:
            r4 = move-exception
            goto L67
        L61:
            if (r3 == 0) goto L66
            r3.release()
        L66:
            return r2
        L67:
            if (r3 == 0) goto L6c
            r3.release()
        L6c:
            throw r4
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.g25.l(java.lang.Object, android.media.MediaMetadataRetriever):boolean");
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c implements e {
        public c() {
        }

        @Override // g25.e
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(MediaExtractor mediaExtractor, AssetFileDescriptor assetFileDescriptor) throws IOException {
            mediaExtractor.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        @Override // g25.e
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public void b(MediaMetadataRetriever mediaMetadataRetriever, AssetFileDescriptor assetFileDescriptor) {
            mediaMetadataRetriever.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public g25(kk kkVar, e eVar) {
        this(kkVar, eVar, f);
    }
}
