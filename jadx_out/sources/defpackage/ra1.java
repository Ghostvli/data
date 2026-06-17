package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ra1 implements wq1 {
    public final cd1 b;
    public final URL c;
    public final String d;
    public String e;
    public URL f;
    public volatile byte[] g;
    public int h;

    public ra1(URL url, cd1 cd1Var) {
        this.c = (URL) fg3.e(url);
        this.d = null;
        this.b = (cd1) fg3.e(cd1Var);
    }

    @Override // defpackage.wq1
    public void b(MessageDigest messageDigest) {
        messageDigest.update(d());
    }

    public String c() {
        String str = this.d;
        return str != null ? str : ((URL) fg3.e(this.c)).toString();
    }

    public final byte[] d() {
        if (this.g == null) {
            this.g = c().getBytes(wq1.a);
        }
        return this.g;
    }

    public Map e() {
        return this.b.getHeaders();
    }

    @Override // defpackage.wq1
    public boolean equals(Object obj) {
        if (obj instanceof ra1) {
            ra1 ra1Var = (ra1) obj;
            if (c().equals(ra1Var.c()) && this.b.equals(ra1Var.b)) {
                return true;
            }
        }
        return false;
    }

    public final String f() {
        if (TextUtils.isEmpty(this.e)) {
            String string = this.d;
            if (TextUtils.isEmpty(string)) {
                string = ((URL) fg3.e(this.c)).toString();
            }
            this.e = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$[]");
        }
        return this.e;
    }

    public final URL g() {
        if (this.f == null) {
            this.f = new URL(f());
        }
        return this.f;
    }

    public String h() {
        return f();
    }

    @Override // defpackage.wq1
    public int hashCode() {
        if (this.h == 0) {
            int iHashCode = c().hashCode();
            this.h = iHashCode;
            this.h = (iHashCode * 31) + this.b.hashCode();
        }
        return this.h;
    }

    public URL i() {
        return g();
    }

    public String toString() {
        return c();
    }

    public ra1(String str) {
        this(str, cd1.b);
    }

    public ra1(URL url) {
        this(url, cd1.b);
    }

    public ra1(String str, cd1 cd1Var) {
        this.c = null;
        this.d = fg3.c(str);
        this.b = (cd1) fg3.e(cd1Var);
    }
}
