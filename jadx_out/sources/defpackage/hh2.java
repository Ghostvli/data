package defpackage;

import androidx.media3.session.r;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class hh2 implements Executor {
    public final /* synthetic */ r f;

    public /* synthetic */ hh2(r rVar) {
        this.f = rVar;
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        this.f.Y0(runnable);
    }
}
