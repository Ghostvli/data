package defpackage;

import android.os.Handler;
import android.os.Message;
import defpackage.hd3;
import defpackage.no4;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ih4 {
    public final hd3 a;
    public final hd3.d b;
    public final b c;
    public final zu d;
    public final no4.b e = new no4.b();
    public final mc1 f;
    public final c g;
    public final d h;
    public final e i;
    public final f j;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements hd3.d {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public void onEvents(hd3 hd3Var, hd3.c cVar) {
            ih4.this.i();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void D(jh4 jh4Var);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class c {
        public final int a;
        public Object b;
        public int c;
        public int d;
        public long e;
        public long f;
        public boolean g;
        public long h;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a() {
            if (ih4.this.a.getPlaybackState() != 2 || !ih4.this.a.getPlayWhenReady() || ih4.this.a.getPlaybackSuppressionReason() != 0) {
                if (this.g) {
                    ih4.this.f.k(1);
                }
                this.g = false;
                return;
            }
            no4 currentTimeline = ih4.this.a.getCurrentTimeline();
            Object objS = currentTimeline.w() ? null : currentTimeline.s(ih4.this.a.getCurrentPeriodIndex());
            int currentAdGroupIndex = ih4.this.a.getCurrentAdGroupIndex();
            int currentAdIndexInAdGroup = ih4.this.a.getCurrentAdIndexInAdGroup();
            long bufferedPosition = ih4.this.a.getBufferedPosition();
            long jMax = Math.max(0L, ih4.this.a.getTotalBufferedDuration() - Math.max(0L, bufferedPosition - ih4.this.a.getCurrentPosition()));
            if (objS != null && currentAdGroupIndex == -1) {
                bufferedPosition -= currentTimeline.n(objS, ih4.this.e).o();
            }
            long jE = ih4.this.d.e();
            if (this.g && Objects.equals(objS, this.b) && currentAdGroupIndex == this.c && currentAdIndexInAdGroup == this.d && bufferedPosition == this.e && jMax == this.f) {
                if (jE - this.h >= this.a) {
                    ih4.this.c.D(new jh4(1, this.a));
                    return;
                }
                return;
            }
            this.g = true;
            this.h = jE;
            this.b = objS;
            this.c = currentAdGroupIndex;
            this.d = currentAdIndexInAdGroup;
            this.e = bufferedPosition;
            this.f = jMax;
            ih4.this.f.k(1);
            ih4.this.f.c(1, this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class d {
        public final int a;
        public Object b;
        public int c;
        public int d;
        public long e;
        public boolean f;
        public long g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a() {
            if (!ih4.this.a.isPlaying()) {
                if (this.f) {
                    ih4.this.f.k(2);
                }
                this.f = false;
                return;
            }
            no4 currentTimeline = ih4.this.a.getCurrentTimeline();
            Object objS = currentTimeline.w() ? null : currentTimeline.s(ih4.this.a.getCurrentPeriodIndex());
            int currentAdGroupIndex = ih4.this.a.getCurrentAdGroupIndex();
            int currentAdIndexInAdGroup = ih4.this.a.getCurrentAdIndexInAdGroup();
            long currentPosition = ih4.this.a.getCurrentPosition();
            if (objS != null && currentAdGroupIndex == -1) {
                currentPosition -= currentTimeline.n(objS, ih4.this.e).o();
            }
            long jE = ih4.this.d.e();
            if (this.f && Objects.equals(objS, this.b) && currentAdGroupIndex == this.c && currentAdIndexInAdGroup == this.d && currentPosition == this.e) {
                if (jE - this.g >= this.a) {
                    ih4.this.c.D(new jh4(2, this.a));
                    return;
                }
                return;
            }
            this.f = true;
            this.g = jE;
            this.b = objS;
            this.c = currentAdGroupIndex;
            this.d = currentAdIndexInAdGroup;
            this.e = currentPosition;
            ih4.this.f.k(2);
            ih4.this.f.c(2, this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class e {
        public final int a;
        public Object b;
        public int c;
        public int d;
        public boolean e;
        public long f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a() {
            long duration;
            no4 currentTimeline = ih4.this.a.getCurrentTimeline();
            Object objS = currentTimeline.w() ? null : currentTimeline.s(ih4.this.a.getCurrentPeriodIndex());
            int currentAdGroupIndex = ih4.this.a.getCurrentAdGroupIndex();
            int currentAdIndexInAdGroup = ih4.this.a.getCurrentAdIndexInAdGroup();
            long currentPosition = ih4.this.a.getCurrentPosition();
            if (objS == null || currentAdGroupIndex != -1) {
                duration = currentAdGroupIndex != -1 ? ih4.this.a.getDuration() : -9223372036854775807L;
            } else {
                currentTimeline.n(objS, ih4.this.e);
                currentPosition -= ih4.this.e.o();
                duration = ih4.this.e.k();
            }
            boolean zIsPlaying = ih4.this.a.isPlaying();
            if (!zIsPlaying || duration == -9223372036854775807L || currentPosition < duration) {
                ih4.this.f.k(3);
                if (zIsPlaying && duration != -9223372036854775807L) {
                    ih4.this.f.c(3, (int) Math.ceil((duration - currentPosition) / ih4.this.a.getPlaybackParameters().a));
                }
                this.e = false;
                return;
            }
            long jE = ih4.this.d.e();
            if (this.e && Objects.equals(objS, this.b) && currentAdGroupIndex == this.c && currentAdIndexInAdGroup == this.d) {
                if (jE - this.f >= this.a) {
                    ih4.this.c.D(new jh4(3, this.a));
                    return;
                }
                return;
            }
            this.e = true;
            this.f = jE;
            this.b = objS;
            this.c = currentAdGroupIndex;
            this.d = currentAdIndexInAdGroup;
            ih4.this.f.k(3);
            ih4.this.f.c(3, this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class f {
        public final int a;
        public int b;
        public boolean c;
        public long d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a() {
            int playbackSuppressionReason = ih4.this.a.getPlaybackSuppressionReason();
            if (!ih4.this.a.getPlayWhenReady() || ih4.this.a.getPlaybackState() == 1 || ih4.this.a.getPlaybackState() == 4 || playbackSuppressionReason == 0 || playbackSuppressionReason == 1) {
                if (this.c) {
                    ih4.this.f.k(4);
                }
                this.c = false;
                return;
            }
            long jE = ih4.this.d.e();
            if (this.c && this.b == playbackSuppressionReason) {
                if (jE - this.d >= this.a) {
                    ih4.this.c.D(new jh4(4, this.a));
                }
            } else {
                this.c = true;
                this.d = jE;
                this.b = playbackSuppressionReason;
                ih4.this.f.k(4);
                ih4.this.f.c(4, this.a);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ih4(hd3 hd3Var, b bVar, zu zuVar, int i, int i2, int i3, int i4) {
        this.a = hd3Var;
        this.c = bVar;
        this.d = zuVar;
        this.f = zuVar.c(hd3Var.getApplicationLooper(), new Handler.Callback() { // from class: hh4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                return this.f.h(message);
            }
        });
        this.g = new c(i);
        this.h = new d(i2);
        this.i = new e(i3);
        this.j = new f(i4);
        a aVar = new a();
        this.b = aVar;
        hd3Var.addListener(aVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean h(Message message) {
        int i = message.what;
        if (i == 1) {
            this.g.a();
            return true;
        }
        if (i == 2) {
            this.h.a();
            return true;
        }
        if (i == 3) {
            this.i.a();
            return true;
        }
        if (i != 4) {
            return false;
        }
        this.j.a();
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i() {
        this.g.a();
        this.h.a();
        this.i.a();
        this.j.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j() {
        this.f.m(null);
        this.a.removeListener(this.b);
    }
}
