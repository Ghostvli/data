package defpackage;

import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface ee3 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum a {
        RECOVERED,
        DECODE,
        FATAL
    }

    boolean a();

    boolean b();

    float c();

    String d(ac3 ac3Var);

    void e();

    void f(int i);

    a g(ac3 ac3Var);

    xr4 getCurrentTracks();

    long getDuration();

    int getPlaybackState();

    long getPosition();

    int getType();

    boolean h();

    void i(List list);

    boolean isPlaying();

    String j();

    void k();

    void l(vb3 vb3Var);

    void m(ph2 ph2Var);

    boolean n(int i);

    void pause();

    void play();

    void seekTo(long j);

    void setPlaybackSpeed(float f);
}
