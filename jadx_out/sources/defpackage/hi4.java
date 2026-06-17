package defpackage;

import androidx.media3.decoder.a;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class hi4 extends a implements yh4 {
    public yh4 f;
    public long g;

    @Override // defpackage.yh4
    public int a(long j) {
        return ((yh4) gg3.q(this.f)).a(j - this.g);
    }

    @Override // defpackage.yh4
    public long b(int i) {
        return ((yh4) gg3.q(this.f)).b(i) + this.g;
    }

    @Override // androidx.media3.decoder.a, defpackage.ol
    public void clear() {
        super.clear();
        this.f = null;
    }

    @Override // defpackage.yh4
    public List e(long j) {
        return ((yh4) gg3.q(this.f)).e(j - this.g);
    }

    @Override // defpackage.yh4
    public int f() {
        return ((yh4) gg3.q(this.f)).f();
    }

    public void g(long j, yh4 yh4Var, long j2) {
        this.timeUs = j;
        this.f = yh4Var;
        if (j2 != Long.MAX_VALUE) {
            j = j2;
        }
        this.g = j;
    }
}
