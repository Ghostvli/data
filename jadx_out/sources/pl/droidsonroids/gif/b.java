package pl.droidsonroids.gif;

import android.os.SystemClock;
import defpackage.bx3;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class b extends bx3 {
    public b(a aVar) {
        super(aVar);
    }

    @Override // defpackage.bx3
    public void a() {
        a aVar = this.f;
        long jM = aVar.l.m(aVar.k);
        a aVar2 = this.f;
        if (jM >= 0) {
            aVar2.h = SystemClock.uptimeMillis() + jM;
            if (this.f.isVisible() && this.f.g) {
                a aVar3 = this.f;
                if (!aVar3.q) {
                    aVar3.f.remove(this);
                    a aVar4 = this.f;
                    aVar4.u = aVar4.f.schedule(this, jM, TimeUnit.MILLISECONDS);
                }
            }
            if (!this.f.m.isEmpty() && this.f.b() == this.f.l.h() - 1) {
                a aVar5 = this.f;
                aVar5.r.sendEmptyMessageAtTime(aVar5.c(), this.f.h);
            }
        } else {
            aVar2.h = Long.MIN_VALUE;
            aVar2.g = false;
        }
        if (!this.f.isVisible() || this.f.r.hasMessages(-1)) {
            return;
        }
        this.f.r.sendEmptyMessageAtTime(-1, 0L);
    }
}
