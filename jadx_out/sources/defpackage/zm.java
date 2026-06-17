package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import defpackage.q91;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class zm implements ds3 {
    public static final a f = new a();
    public static final b g = new b();
    public final Context a;
    public final List b;
    public final b c;
    public final a d;
    public final p91 e;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public q91 a(q91.a aVar, aa1 aa1Var, ByteBuffer byteBuffer, int i) {
            return new sd4(aVar, aa1Var, byteBuffer, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public final Queue a = iy4.g(0);

        public synchronized ba1 a(ByteBuffer byteBuffer) {
            ba1 ba1Var;
            try {
                ba1Var = (ba1) this.a.poll();
                if (ba1Var == null) {
                    ba1Var = new ba1();
                }
            } catch (Throwable th) {
                throw th;
            }
            return ba1Var.p(byteBuffer);
        }

        public synchronized void b(ba1 ba1Var) {
            ba1Var.a();
            this.a.offer(ba1Var);
        }
    }

    public zm(Context context, List list, kk kkVar, ma maVar, b bVar, a aVar) {
        this.a = context.getApplicationContext();
        this.b = list;
        this.d = aVar;
        this.e = new p91(kkVar, maVar);
        this.c = bVar;
    }

    public static int e(aa1 aa1Var, int i, int i2) {
        int iMin = Math.min(aa1Var.a() / i2, aa1Var.d() / i);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable("BufferGifDecoder", 2) && iMax > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i + "x" + i2 + "], actual dimens: [" + aa1Var.d() + "x" + aa1Var.a() + "]");
        }
        return iMax;
    }

    public final u91 c(ByteBuffer byteBuffer, int i, int i2, ba1 ba1Var, u63 u63Var) {
        StringBuilder sb;
        long jB = b02.b();
        try {
            aa1 aa1VarC = ba1Var.c();
            if (aa1VarC.b() > 0 && aa1VarC.c() == 0) {
                Bitmap.Config config = u63Var.c(ca1.a) == za0.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                q91 q91VarA = this.d.a(this.e, aa1VarC, byteBuffer, e(aa1VarC, i, i2));
                q91VarA.e(config);
                q91VarA.b();
                Bitmap bitmapA = q91VarA.a();
                if (bitmapA == null) {
                    if (Log.isLoggable("BufferGifDecoder", 2)) {
                        sb = new StringBuilder("Decoded GIF from stream in ");
                    }
                    return null;
                }
                u91 u91Var = new u91(new r91(this.a, q91VarA, kw4.c(), i, i2, bitmapA));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + b02.a(jB));
                }
                return u91Var;
            }
            if (!Log.isLoggable("BufferGifDecoder", 2)) {
                return null;
            }
            sb = new StringBuilder("Decoded GIF from stream in ");
            sb.append(b02.a(jB));
            Log.v("BufferGifDecoder", sb.toString());
            return null;
        } catch (Throwable th) {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + b02.a(jB));
            }
            throw th;
        }
    }

    @Override // defpackage.ds3
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public u91 b(ByteBuffer byteBuffer, int i, int i2, u63 u63Var) {
        ba1 ba1VarA = this.c.a(byteBuffer);
        try {
            return c(byteBuffer, i, i2, ba1VarA, u63Var);
        } finally {
            this.c.b(ba1VarA);
        }
    }

    @Override // defpackage.ds3
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean a(ByteBuffer byteBuffer, u63 u63Var) {
        return !((Boolean) u63Var.c(ca1.b)).booleanValue() && com.bumptech.glide.load.a.g(this.b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    public zm(Context context, List list, kk kkVar, ma maVar) {
        this(context, list, kkVar, maVar, g, f);
    }
}
