package defpackage;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class al4 implements Cloneable {
    public static int j = 1;
    public static int k = 2;
    public static int l = 4;
    public static int m = 8;
    public static int n = 16;
    public static int o = 32;
    public static int p = 64;
    public static int q = 128;
    public static int r = 256;
    public static int s = 512;
    public String f;
    public String g;
    public String h;
    public int i;

    public al4(String str, String str2, String str3) {
        this.i = 0;
        this.g = str;
        this.h = str2;
        this.f = str3;
    }

    public static al4 o(String str, String str2, g83 g83Var) {
        return ql4.o().w(str, null, str2, g83Var.f());
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public al4 clone() {
        try {
            return (al4) super.clone();
        } catch (CloneNotSupportedException e) {
            wg1.a(e);
            return null;
        }
    }

    public String b() {
        return this.g;
    }

    public boolean c(int i) {
        return (this.i & i) != 0;
    }

    public boolean d() {
        return (this.i & l) != 0;
    }

    public boolean e() {
        return (this.i & k) != 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof al4)) {
            return false;
        }
        al4 al4Var = (al4) obj;
        return Objects.equals(this.g, al4Var.g) && Objects.equals(this.f, al4Var.f) && Objects.equals(this.h, al4Var.h) && this.i == al4Var.i;
    }

    public boolean f() {
        return (this.i & l) == 0;
    }

    public boolean g() {
        return (this.i & j) != 0;
    }

    public boolean h() {
        int i = this.i;
        return ((n & i) == 0 && (i & k) == 0) ? false : true;
    }

    public int hashCode() {
        return Objects.hash(this.g, this.f);
    }

    public String i() {
        return this.f;
    }

    public String j() {
        return this.h;
    }

    public boolean k() {
        return (this.i & p) != 0;
    }

    public al4 l(int i) {
        this.i = i | this.i | j;
        return this;
    }

    public void m() {
        this.i |= o;
    }

    public op4 n() {
        if (c(q)) {
            return op4.h;
        }
        if (c(r)) {
            return op4.j;
        }
        return null;
    }

    public String toString() {
        return this.g;
    }

    public al4(String str, String str2) {
        this(str, g83.a(str), str2);
    }
}
