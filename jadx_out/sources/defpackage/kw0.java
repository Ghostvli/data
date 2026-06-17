package defpackage;

import androidx.media3.exoplayer.ExoPlayer;
import defpackage.ee3;
import defpackage.hd3;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class kw0 implements ee3 {
    public final mu0 a = new mu0();
    public vb3 b;
    public hd3 c;
    public int d;

    public kw0(int i, hd3.d dVar) {
        this.c = ny0.f(i, dVar);
        this.d = i;
    }

    @Override // defpackage.ee3
    public boolean a() {
        return this.c.isCurrentMediaItemLive();
    }

    @Override // defpackage.ee3
    public boolean b() {
        return !this.c.isCurrentMediaItemLive();
    }

    @Override // defpackage.ee3
    public float c() {
        return this.c.getPlaybackParameters().a;
    }

    @Override // defpackage.ee3
    public String d(ac3 ac3Var) {
        return this.a.a(ac3Var);
    }

    @Override // defpackage.ee3
    public void e() {
        tr4.f(this.c);
    }

    @Override // defpackage.ee3
    public void f(int i) {
        this.d = i;
        q24.a0(i);
    }

    @Override // defpackage.ee3
    public ee3.a g(ac3 ac3Var) {
        int i = ac3Var.f;
        if (i == 1002) {
            return s();
        }
        if (i != 2000) {
            switch (i) {
                case 3001:
                case 3002:
                case 3003:
                case 3004:
                    break;
                default:
                    switch (i) {
                        case 4001:
                        case 4002:
                        case 4003:
                            return ee3.a.DECODE;
                        default:
                            return ee3.a.FATAL;
                    }
            }
        }
        return r(i);
    }

    @Override // defpackage.ee3
    public xr4 getCurrentTracks() {
        return this.c.getCurrentTracks();
    }

    @Override // defpackage.ee3
    public long getDuration() {
        return this.c.getDuration();
    }

    @Override // defpackage.ee3
    public int getPlaybackState() {
        return this.c.getPlaybackState();
    }

    @Override // defpackage.ee3
    public long getPosition() {
        return this.c.getCurrentPosition();
    }

    @Override // defpackage.ee3
    public int getType() {
        return this.d;
    }

    @Override // defpackage.ee3
    public boolean h() {
        return this.d == 1;
    }

    @Override // defpackage.ee3
    public void i(List list) {
        tr4.g(this.c, list);
    }

    @Override // defpackage.ee3
    public boolean isPlaying() {
        return this.c.isPlaying();
    }

    @Override // defpackage.ee3
    public String j() {
        return vr3.n(dk3.d)[this.d];
    }

    @Override // defpackage.ee3
    public void k() {
        this.c.stop();
    }

    @Override // defpackage.ee3
    public void l(vb3 vb3Var) {
        this.b = vb3Var;
        t();
    }

    @Override // defpackage.ee3
    public void m(ph2 ph2Var) {
        fg2 currentMediaItem = this.c.getCurrentMediaItem();
        if (currentMediaItem != null) {
            hd3 hd3Var = this.c;
            hd3Var.replaceMediaItem(hd3Var.getCurrentMediaItemIndex(), currentMediaItem.a().f(ph2Var).a());
        }
    }

    @Override // defpackage.ee3
    public boolean n(int i) {
        return tr4.d(getCurrentTracks(), i) > 0;
    }

    public hd3 o() {
        return this.c;
    }

    public hd3 p(hd3.d dVar) {
        this.c.release();
        ExoPlayer exoPlayerF = ny0.f(this.d, dVar);
        this.c = exoPlayerF;
        return exoPlayerF;
    }

    @Override // defpackage.ee3
    public void pause() {
        this.c.pause();
    }

    @Override // defpackage.ee3
    public void play() {
        this.c.play();
    }

    public void q() {
        this.c.release();
    }

    public final ee3.a r(int i) {
        this.b.p(ny0.o(i));
        t();
        return ee3.a.RECOVERED;
    }

    public final ee3.a s() {
        this.c.seekToDefaultPosition();
        this.c.prepare();
        return ee3.a.RECOVERED;
    }

    @Override // defpackage.ee3
    public void seekTo(long j) {
        this.c.seekTo(j);
    }

    @Override // defpackage.ee3
    public void setPlaybackSpeed(float f) {
        hd3 hd3Var = this.c;
        hd3Var.setPlaybackParameters(hd3Var.getPlaybackParameters().d(f));
    }

    public final void t() {
        this.c.setMediaItem(ny0.n(this.b, this.d));
        this.c.prepare();
        this.c.play();
    }
}
