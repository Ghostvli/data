package androidx.media3.session;

import android.os.Handler;
import android.os.Looper;
import androidx.media3.session.l;
import androidx.media3.session.m;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class m extends defpackage.b0 implements l.b {
    public final Handler m;
    public l n;
    public boolean o;

    public m(Looper looper) {
        this.m = new Handler(looper);
    }

    public static /* synthetic */ void R(m mVar, l lVar) {
        if (mVar.isCancelled()) {
            lVar.release();
        }
    }

    public final void S() {
        N(new SecurityException("Session rejected the connection request."));
    }

    public final void T() {
        l lVar = this.n;
        if (lVar == null || !this.o) {
            return;
        }
        M(lVar);
    }

    public void U(final l lVar) {
        this.n = lVar;
        T();
        g(new Runnable() { // from class: x82
            @Override // java.lang.Runnable
            public final void run() {
                m.R(this.f, lVar);
            }
        }, new Executor() { // from class: y82
            @Override // java.util.concurrent.Executor
            public final void execute(Runnable runnable) {
                fy4.o1(this.f.m, runnable);
            }
        });
    }

    @Override // androidx.media3.session.l.b
    public void a() {
        this.o = true;
        T();
    }

    @Override // androidx.media3.session.l.b
    public void b() {
        S();
    }
}
