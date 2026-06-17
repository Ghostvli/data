package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class jp4 {
    public String a;
    public StringBuilder b;

    public void a(char c) {
        StringBuilder sb = this.b;
        if (sb != null) {
            sb.append(c);
        } else if (this.a == null) {
            this.a = String.valueOf(c);
        } else {
            d();
            this.b.append(c);
        }
    }

    public void b(String str) {
        StringBuilder sb = this.b;
        if (sb != null) {
            sb.append(str);
        } else if (this.a == null) {
            this.a = str;
        } else {
            d();
            this.b.append(str);
        }
    }

    public void c(int i) {
        StringBuilder sb = this.b;
        if (sb != null) {
            sb.appendCodePoint(i);
        } else if (this.a == null) {
            this.a = String.valueOf(Character.toChars(i));
        } else {
            d();
            this.b.appendCodePoint(i);
        }
    }

    public final void d() {
        StringBuilder sbE = fg4.e();
        this.b = sbE;
        sbE.append(this.a);
        this.a = null;
    }

    public boolean e() {
        return (this.b == null && this.a == null) ? false : true;
    }

    public void f() {
        StringBuilder sb = this.b;
        if (sb != null) {
            fg4.w(sb);
            this.b = null;
        }
        this.a = null;
    }

    public void g(String str) {
        f();
        this.a = str;
    }

    public String h() {
        StringBuilder sb = this.b;
        if (sb == null) {
            String str = this.a;
            return str != null ? str : "";
        }
        this.a = sb.toString();
        fg4.v(this.b);
        this.b = null;
        return this.a;
    }

    public String toString() {
        StringBuilder sb = this.b;
        if (sb != null) {
            return sb.toString();
        }
        String str = this.a;
        return str != null ? str : "";
    }
}
