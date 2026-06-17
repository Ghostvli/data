package defpackage;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class eu4 implements yh4 {
    public final zt4 f;
    public final long[] g;
    public final Map h;
    public final Map i;
    public final Map j;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public eu4(zt4 zt4Var, Map map, Map map2, Map map3) {
        this.f = zt4Var;
        this.i = map2;
        this.j = map3;
        this.h = map != null ? Collections.unmodifiableMap(map) : Collections.EMPTY_MAP;
        this.g = zt4Var.j();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yh4
    public int a(long j) {
        int iG = fy4.g(this.g, j, false, false);
        if (iG < this.g.length) {
            return iG;
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yh4
    public long b(int i) {
        return this.g[i];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yh4
    public List e(long j) {
        return this.f.h(j, this.h, this.i, this.j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yh4
    public int f() {
        return this.g.length;
    }
}
