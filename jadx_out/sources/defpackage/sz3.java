package defpackage;

import com.fongmi.android.tv.bean.Result;
import com.fongmi.android.tv.bean.Site;
import com.github.catvod.utils.Trans;
import java.util.Objects;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class sz3 extends to3 implements Callable {
    public final Site a;
    public final String b;
    public final boolean c;
    public final String d;

    public sz3(Site site, String str, boolean z, String str2) {
        this.b = Trans.t2s(str);
        this.c = z;
        this.d = str2;
        this.a = site;
    }

    private /* synthetic */ boolean a(Object obj) {
        if (!(obj instanceof sz3)) {
            return false;
        }
        sz3 sz3Var = (sz3) obj;
        return this.c == sz3Var.c && Objects.equals(this.a, sz3Var.a) && Objects.equals(this.b, sz3Var.b) && Objects.equals(this.d, sz3Var.d);
    }

    private /* synthetic */ Object[] b() {
        return new Object[]{this.a, this.b, Boolean.valueOf(this.c), this.d};
    }

    public static sz3 d(Site site, String str, boolean z) {
        return new sz3(site, str, z, "1");
    }

    public static sz3 e(Site site, String str, boolean z, String str2) {
        return new sz3(site, str, z, str2);
    }

    @Override // java.util.concurrent.Callable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Result call() {
        return (!this.c || this.a.isQuickSearch()) ? d84.m(this.a, this.b, this.c, this.d) : Result.empty();
    }

    public final boolean equals(Object obj) {
        return a(obj);
    }

    public final int hashCode() {
        return rz3.a(this.c, this.a, this.b, this.d);
    }

    public final String toString() {
        return yq.a(b(), sz3.class, "a;b;c;d");
    }
}
