package defpackage;

import defpackage.t90;
import defpackage.u90;
import defpackage.vt2;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class p90 implements u90, t90.a {
    public final List f;
    public final ab0 g;
    public final u90.a h;
    public int i;
    public wq1 j;
    public List k;
    public int l;
    public volatile vt2.a m;
    public File n;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public p90(List list, ab0 ab0Var, u90.a aVar) {
        this.i = -1;
        this.f = list;
        this.g = ab0Var;
        this.h = aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean a() {
        return this.l < this.k.size();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001b, code lost:
    
        if (a() == false) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x001d, code lost:
    
        r0 = r7.k;
        r3 = r7.l;
        r7.l = r3 + 1;
        r7.m = ((defpackage.vt2) r0.get(r3)).b(r7.n, r7.g.t(), r7.g.f(), r7.g.k());
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0047, code lost:
    
        if (r7.m == null) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
    
        if (r7.g.u(r7.m.c.a()) == false) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        r7.m.c.c(r7.g.l(), r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0066, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006b, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
    
        r7.m = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0015, code lost:
    
        if (r2 != false) goto L39;
     */
    @Override // defpackage.u90
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean b() {
        qa1.a("DataCacheGenerator.startNext");
        while (true) {
            try {
                boolean z = false;
                if (this.k != null && a()) {
                    break;
                }
                int i = this.i + 1;
                this.i = i;
                if (i >= this.f.size()) {
                    return false;
                }
                wq1 wq1Var = (wq1) this.f.get(this.i);
                File fileA = this.g.d().a(new q90(wq1Var, this.g.p()));
                this.n = fileA;
                if (fileA != null) {
                    this.j = wq1Var;
                    this.k = this.g.j(fileA);
                    this.l = 0;
                }
            } finally {
                qa1.e();
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.u90
    public void cancel() {
        vt2.a aVar = this.m;
        if (aVar != null) {
            aVar.c.cancel();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // t90.a
    public void d(Exception exc) {
        this.h.a(this.j, exc, this.m.c, ba0.DATA_DISK_CACHE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // t90.a
    public void f(Object obj) {
        this.h.f(this.j, obj, this.m.c, ba0.DATA_DISK_CACHE, this.j);
    }

    public p90(ab0 ab0Var, u90.a aVar) {
        this(ab0Var.c(), ab0Var, aVar);
    }
}
