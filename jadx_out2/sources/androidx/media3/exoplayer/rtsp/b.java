package androidx.media3.exoplayer.rtsp;

import android.os.Handler;
import androidx.media3.exoplayer.rtsp.a;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.ia0;
import defpackage.jz0;
import defpackage.mz0;
import defpackage.rv3;
import defpackage.sf0;
import defpackage.vu3;
import defpackage.x90;
import defpackage.xy1;
import defpackage.yf3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements xy1.e {
    public final int a;
    public final rv3 b;
    public final a c;
    public final mz0 d;
    public final a.InterfaceC0021a f;
    public androidx.media3.exoplayer.rtsp.a g;
    public vu3 h;
    public sf0 i;
    public volatile boolean j;
    public volatile long l;
    public final Handler e = fy4.E();
    public volatile long k = -9223372036854775807L;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void a(String str, androidx.media3.exoplayer.rtsp.a aVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b(int i, rv3 rv3Var, a aVar, mz0 mz0Var, a.InterfaceC0021a interfaceC0021a) {
        this.a = i;
        this.b = rv3Var;
        this.c = aVar;
        this.d = mz0Var;
        this.f = interfaceC0021a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // xy1.e
    public void b() {
        if (this.j) {
            this.j = false;
        }
        try {
            if (this.g == null) {
                androidx.media3.exoplayer.rtsp.a aVarA = this.f.a(this.a);
                this.g = aVarA;
                final String strC = aVarA.c();
                final androidx.media3.exoplayer.rtsp.a aVar = this.g;
                this.e.post(new Runnable() { // from class: uu3
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f.c.a(strC, aVar);
                    }
                });
                this.i = new sf0((x90) gg3.q(this.g), 0L, -1L);
                vu3 vu3Var = new vu3(this.b.a, this.a);
                this.h = vu3Var;
                vu3Var.b(this.d);
            }
            while (!this.j) {
                if (this.k != -9223372036854775807L) {
                    ((vu3) gg3.q(this.h)).a(this.l, this.k);
                    this.k = -9223372036854775807L;
                }
                if (((vu3) gg3.q(this.h)).d((jz0) gg3.q(this.i), new yf3()) == -1) {
                    break;
                }
            }
            this.j = false;
            if (((androidx.media3.exoplayer.rtsp.a) gg3.q(this.g)).g()) {
                ia0.a(this.g);
                this.g = null;
            }
        } catch (Throwable th) {
            if (((androidx.media3.exoplayer.rtsp.a) gg3.q(this.g)).g()) {
                ia0.a(this.g);
                this.g = null;
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // xy1.e
    public void c() {
        this.j = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d() {
        ((vu3) gg3.q(this.h)).i();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e(long j, long j2) {
        this.k = j;
        this.l = j2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f(int i) {
        if (((vu3) gg3.q(this.h)).h()) {
            return;
        }
        this.h.j(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g(long j) {
        if (j == -9223372036854775807L || ((vu3) gg3.q(this.h)).h()) {
            return;
        }
        this.h.k(j);
    }
}
