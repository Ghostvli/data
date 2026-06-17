package defpackage;

import defpackage.vj1;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ye4 extends vj1 {
    public final gf4 k;
    public String l;
    public String m;
    public String n;
    public qa0 o;
    public long p;
    public long q;
    public String r;
    public List s;
    public boolean t;
    public boolean u;
    public l20 v;

    public ye4(int i, String str, String str2, gf4 gf4Var) {
        super(vj1.a.STREAM, i, str, str2);
        this.p = -1L;
        this.q = -1L;
        this.r = null;
        this.s = Collections.EMPTY_LIST;
        this.t = false;
        this.u = false;
        this.v = l20.AVAILABLE;
        this.k = gf4Var;
    }

    public long g() {
        return this.q;
    }

    public boolean h() {
        return this.t;
    }

    public void i(l20 l20Var) {
        this.v = l20Var;
    }

    public void j(long j) {
        this.q = j;
    }

    public void k(String str) {
        this.m = str;
    }

    public void l(boolean z) {
        this.u = z;
    }

    public void m(String str) {
        this.n = str;
    }

    public void n(qa0 qa0Var) {
        this.o = qa0Var;
    }

    public void o(List list) {
        this.s = list;
    }

    public void p(String str) {
        this.l = str;
    }

    public void q(String str) {
        this.r = str;
    }

    public void r(boolean z) {
        this.t = z;
    }

    public void s(long j) {
        this.p = j;
    }

    @Override // defpackage.vj1
    public String toString() {
        return "StreamInfoItem{streamType=" + this.k + ", uploaderName='" + this.l + "', textualUploadDate='" + this.n + "', viewCount=" + this.p + ", duration=" + this.q + ", uploaderUrl='" + this.r + "', infoType=" + a() + ", serviceId=" + c() + ", url='" + e() + "', name='" + b() + "', thumbnails='" + d() + "', uploaderVerified='" + h() + "'}";
    }
}
