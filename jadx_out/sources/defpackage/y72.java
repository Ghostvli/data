package defpackage;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface y72 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final c82 a;
        public final MediaFormat b;
        public final t41 c;
        public final Surface d;
        public final MediaCrypto e;
        public final z22 f;

        public a(c82 c82Var, MediaFormat mediaFormat, t41 t41Var, Surface surface, MediaCrypto mediaCrypto, z22 z22Var) {
            this.a = c82Var;
            this.b = mediaFormat;
            this.c = t41Var;
            this.d = surface;
            this.e = mediaCrypto;
            this.f = z22Var;
        }

        public static a a(c82 c82Var, MediaFormat mediaFormat, t41 t41Var, MediaCrypto mediaCrypto, z22 z22Var) {
            return new a(c82Var, mediaFormat, t41Var, null, mediaCrypto, z22Var);
        }

        public static a b(c82 c82Var, MediaFormat mediaFormat, t41 t41Var, Surface surface, MediaCrypto mediaCrypto) {
            return new a(c82Var, mediaFormat, t41Var, surface, mediaCrypto, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        public static final b a = new lg0();

        static b b(Context context) {
            return new lg0(context);
        }

        y72 a(a aVar);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface c {
        void a();

        void b();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
        void a(y72 y72Var, long j, long j2);
    }

    void a(int i, int i2, h50 h50Var, long j, int i3);

    void b(Bundle bundle);

    void c(int i, int i2, int i3, long j, int i4);

    boolean d();

    void e(List list);

    default void f(Runnable runnable) {
        runnable.run();
    }

    void flush();

    MediaFormat g();

    void h();

    void i(List list);

    void j(int i, long j);

    int k();

    int l(MediaCodec.BufferInfo bufferInfo);

    void m(int i, boolean z);

    void n(int i);

    ByteBuffer o(int i);

    void p(Surface surface);

    ByteBuffer q(int i);

    default boolean r(c cVar) {
        return false;
    }

    void release();

    void s(d dVar, Handler handler);
}
