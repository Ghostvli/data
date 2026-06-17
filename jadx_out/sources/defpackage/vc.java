package defpackage;

import android.media.AudioDeviceInfo;
import defpackage.wc;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface vc {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void a(long j);

        void b();

        void c();

        void d();

        void e();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends Exception {
        public final int f;
        public final boolean g;

        public b(int i, boolean z) {
            super("AudioOutput write failed: " + i);
            this.g = z;
            this.f = i;
        }
    }

    void c(int i, int i2);

    void d(ie3 ie3Var);

    long e();

    void f(float f);

    boolean g();

    int getAudioSessionId();

    dc3 getPlaybackParameters();

    void h(a aVar);

    boolean i();

    int j();

    long k();

    void l(int i);

    default boolean m(wc.g gVar, wc.c cVar, wc.g gVar2) {
        return gVar2.equals(gVar);
    }

    void n();

    boolean o(ByteBuffer byteBuffer, int i, long j);

    void pause();

    void play();

    void release();

    void setPlaybackParameters(dc3 dc3Var);

    void setPreferredDevice(AudioDeviceInfo audioDeviceInfo);

    void setVolume(float f);

    void stop();
}
