package defpackage;

import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class xs0 implements wq1 {
    public final Object b;
    public final int c;
    public final int d;
    public final Class e;
    public final Class f;
    public final wq1 g;
    public final Map h;
    public final u63 i;
    public int j;

    public xs0(Object obj, wq1 wq1Var, int i, int i2, Map map, Class cls, Class cls2, u63 u63Var) {
        this.b = fg3.e(obj);
        this.g = (wq1) fg3.f(wq1Var, "Signature must not be null");
        this.c = i;
        this.d = i2;
        this.h = (Map) fg3.e(map);
        this.e = (Class) fg3.f(cls, "Resource class must not be null");
        this.f = (Class) fg3.f(cls2, "Transcode class must not be null");
        this.i = (u63) fg3.e(u63Var);
    }

    @Override // defpackage.wq1
    public void b(MessageDigest messageDigest) {
        throw new UnsupportedOperationException();
    }

    @Override // defpackage.wq1
    public boolean equals(Object obj) {
        if (obj instanceof xs0) {
            xs0 xs0Var = (xs0) obj;
            if (this.b.equals(xs0Var.b) && this.g.equals(xs0Var.g) && this.d == xs0Var.d && this.c == xs0Var.c && this.h.equals(xs0Var.h) && this.e.equals(xs0Var.e) && this.f.equals(xs0Var.f) && this.i.equals(xs0Var.i)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.wq1
    public int hashCode() {
        if (this.j == 0) {
            int iHashCode = this.b.hashCode();
            this.j = iHashCode;
            int iHashCode2 = (((((iHashCode * 31) + this.g.hashCode()) * 31) + this.c) * 31) + this.d;
            this.j = iHashCode2;
            int iHashCode3 = (iHashCode2 * 31) + this.h.hashCode();
            this.j = iHashCode3;
            int iHashCode4 = (iHashCode3 * 31) + this.e.hashCode();
            this.j = iHashCode4;
            int iHashCode5 = (iHashCode4 * 31) + this.f.hashCode();
            this.j = iHashCode5;
            this.j = (iHashCode5 * 31) + this.i.hashCode();
        }
        return this.j;
    }

    public String toString() {
        return "EngineKey{model=" + this.b + ", width=" + this.c + ", height=" + this.d + ", resourceClass=" + this.e + ", transcodeClass=" + this.f + ", signature=" + this.g + ", hashCode=" + this.j + ", transformations=" + this.h + ", options=" + this.i + '}';
    }
}
