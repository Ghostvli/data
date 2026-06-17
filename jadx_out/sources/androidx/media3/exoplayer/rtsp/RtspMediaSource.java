package androidx.media3.exoplayer.rtsp;

import android.net.Uri;
import androidx.media3.exoplayer.rtsp.a;
import androidx.media3.exoplayer.rtsp.f;
import defpackage.fg2;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.h74;
import defpackage.hs4;
import defpackage.i51;
import defpackage.j5;
import defpackage.ji;
import defpackage.jq2;
import defpackage.kg2;
import defpackage.mi2;
import defpackage.no4;
import defpackage.sq2;
import defpackage.sy1;
import defpackage.xa;
import defpackage.yv3;
import defpackage.zo0;
import java.io.IOException;
import javax.net.SocketFactory;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class RtspMediaSource extends ji {
    public final a.InterfaceC0021a m;
    public final String n;
    public final Uri o;
    public final SocketFactory p;
    public final boolean q;
    public boolean s;
    public boolean t;
    public fg2 v;
    public long r = -9223372036854775807L;
    public boolean u = true;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Factory implements sq2 {
        public static final /* synthetic */ int h = 0;
        public long c = 8000;
        public String d = "AndroidXMedia3/1.10.0";
        public SocketFactory e = SocketFactory.getDefault();
        public boolean f;
        public boolean g;

        @Override // jq2.a
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public RtspMediaSource e(fg2 fg2Var) {
            gg3.q(fg2Var.b);
            boolean zK = k(fg2Var);
            long j = this.c;
            return new RtspMediaSource(fg2Var, zK ? new k(j) : new m(j), this.d, this.e, this.g);
        }

        @Override // jq2.a
        /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
        public Factory f(zo0 zo0Var) {
            return this;
        }

        @Override // jq2.a
        /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
        public Factory g(sy1 sy1Var) {
            return this;
        }

        public final boolean k(fg2 fg2Var) {
            if (this.f) {
                return true;
            }
            String scheme = ((fg2.h) gg3.q(fg2Var.b)).a.getScheme();
            return scheme != null && xa.a("rtspt", scheme);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements f.d {
        public a() {
        }

        @Override // androidx.media3.exoplayer.rtsp.f.d
        public void a(yv3 yv3Var) {
            RtspMediaSource.this.r = fy4.c1(yv3Var.a());
            RtspMediaSource.this.s = !yv3Var.c();
            RtspMediaSource.this.t = yv3Var.c();
            RtspMediaSource.this.u = false;
            RtspMediaSource.this.N();
        }

        @Override // androidx.media3.exoplayer.rtsp.f.d
        public void b() {
            RtspMediaSource.this.s = false;
            RtspMediaSource.this.N();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends i51 {
        public b(no4 no4Var) {
            super(no4Var);
        }

        @Override // defpackage.i51, defpackage.no4
        public no4.b m(int i, no4.b bVar, boolean z) {
            super.m(i, bVar, z);
            bVar.f = true;
            return bVar;
        }

        @Override // defpackage.i51, defpackage.no4
        public no4.d u(int i, no4.d dVar, long j) {
            super.u(i, dVar, j);
            dVar.k = true;
            return dVar;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends c {
        public d(String str) {
            super(str);
        }
    }

    static {
        kg2.a("media3.exoplayer.rtsp");
    }

    public RtspMediaSource(fg2 fg2Var, a.InterfaceC0021a interfaceC0021a, String str, SocketFactory socketFactory, boolean z) {
        this.v = fg2Var;
        this.m = interfaceC0021a;
        this.n = str;
        this.o = M(((fg2.h) gg3.q(fg2Var.b)).a);
        this.p = socketFactory;
        this.q = z;
    }

    public static Uri M(Uri uri) {
        String scheme = uri.getScheme();
        return (scheme == null || !xa.a("rtspt", scheme)) ? uri : Uri.parse("rtsp".concat(uri.toString().substring(5)));
    }

    @Override // defpackage.ji
    public void E(hs4 hs4Var) {
        N();
    }

    @Override // defpackage.ji
    public void G() {
    }

    public final void N() {
        no4 h74Var = new h74(this.r, this.s, false, this.t, null, i());
        if (this.u) {
            h74Var = new b(h74Var);
        }
        F(h74Var);
    }

    @Override // defpackage.jq2
    public boolean a(fg2 fg2Var) {
        fg2.h hVar = fg2Var.b;
        return hVar != null && M(hVar.a).equals(this.o);
    }

    @Override // defpackage.jq2
    public mi2 d(jq2.b bVar, j5 j5Var, long j) {
        return new f(j5Var, this.m, this.o, new a(), this.n, this.p, this.q);
    }

    @Override // defpackage.jq2
    public synchronized fg2 i() {
        return this.v;
    }

    @Override // defpackage.jq2
    public void m() {
    }

    @Override // defpackage.jq2
    public synchronized void q(fg2 fg2Var) {
        this.v = fg2Var;
    }

    @Override // defpackage.jq2
    public void s(mi2 mi2Var) {
        ((f) mi2Var).W();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends IOException {
        public c(String str) {
            super(str);
        }

        public c(Throwable th) {
            super(th);
        }

        public c(String str, Throwable th) {
            super(str, th);
        }
    }
}
