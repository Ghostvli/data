package defpackage;

import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import okhttp3.internal.http2.Http2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class we4 implements ds3 {
    public final List a;
    public final ds3 b;
    public final ma c;

    public we4(List list, ds3 ds3Var, ma maVar) {
        this.a = list;
        this.b = ds3Var;
        this.c = maVar;
    }

    public static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Http2.INITIAL_MAX_FRAME_SIZE);
        try {
            byte[] bArr = new byte[Http2.INITIAL_MAX_FRAME_SIZE];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (IOException e) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e);
            return null;
        }
    }

    @Override // defpackage.ds3
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public yr3 b(InputStream inputStream, int i, int i2, u63 u63Var) {
        byte[] bArrE = e(inputStream);
        if (bArrE == null) {
            return null;
        }
        return this.b.b(ByteBuffer.wrap(bArrE), i, i2, u63Var);
    }

    @Override // defpackage.ds3
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(InputStream inputStream, u63 u63Var) {
        return !((Boolean) u63Var.c(ca1.b)).booleanValue() && a.f(this.a, inputStream, this.c) == ImageHeaderParser.ImageType.GIF;
    }
}
