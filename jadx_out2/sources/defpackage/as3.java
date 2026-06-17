package defpackage;

import defpackage.t90;
import defpackage.u90;
import defpackage.vt2;
import java.io.File;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class as3 implements u90, t90.a {
    public final u90.a f;
    public final ab0 g;
    public int h;
    public int i = -1;
    public wq1 j;
    public List k;
    public int l;
    public volatile vt2.a m;
    public File n;
    public bs3 o;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public as3(ab0 ab0Var, u90.a aVar) {
        this.g = ab0Var;
        this.f = aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean a() {
        return this.l < this.k.size();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.u90
    public boolean b() {
        qa1.a("ResourceCacheGenerator.startNext");
        try {
            List listC = this.g.c();
            boolean z = false;
            if (listC.isEmpty()) {
                return false;
            }
            List listM = this.g.m();
            if (listM.isEmpty()) {
                if (File.class.equals(this.g.r())) {
                    return false;
                }
                throw new IllegalStateException("Failed to find any load path from " + this.g.i() + " to " + this.g.r());
            }
            while (true) {
                if (this.k != null && a()) {
                    this.m = null;
                    while (!z && a()) {
                        List list = this.k;
                        int i = this.l;
                        this.l = i + 1;
                        this.m = ((vt2) list.get(i)).b(this.n, this.g.t(), this.g.f(), this.g.k());
                        if (this.m != null && this.g.u(this.m.c.a())) {
                            this.m.c.c(this.g.l(), this);
                            z = true;
                        }
                    }
                    return z;
                }
                int i2 = this.i + 1;
                this.i = i2;
                if (i2 >= listM.size()) {
                    int i3 = this.h + 1;
                    this.h = i3;
                    if (i3 >= listC.size()) {
                        return false;
                    }
                    this.i = 0;
                }
                wq1 wq1Var = (wq1) listC.get(this.h);
                Class cls = (Class) listM.get(this.i);
                this.o = new bs3(this.g.b(), wq1Var, this.g.p(), this.g.t(), this.g.f(), this.g.s(cls), cls, this.g.k());
                File fileA = this.g.d().a(this.o);
                this.n = fileA;
                if (fileA != null) {
                    this.j = wq1Var;
                    this.k = this.g.j(fileA);
                    this.l = 0;
                }
            }
        } finally {
            qa1.e();
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
        this.f.a(this.o, exc, this.m.c, ba0.RESOURCE_DISK_CACHE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // t90.a
    public void f(Object obj) {
        this.f.f(this.j, obj, this.m.c, ba0.RESOURCE_DISK_CACHE, this.o);
    }
}
