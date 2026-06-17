package defpackage;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class k80 implements yt {
    public BigInteger a;
    public BigInteger b;
    public BigInteger c;
    public l80 d;

    public k80(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, l80 l80Var) {
        this.a = bigInteger3;
        this.c = bigInteger;
        this.b = bigInteger2;
        this.d = l80Var;
    }

    public BigInteger a() {
        return this.a;
    }

    public BigInteger b() {
        return this.c;
    }

    public BigInteger c() {
        return this.b;
    }

    public l80 d() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof k80)) {
            return false;
        }
        k80 k80Var = (k80) obj;
        return k80Var.b().equals(this.c) && k80Var.c().equals(this.b) && k80Var.a().equals(this.a);
    }

    public int hashCode() {
        return a().hashCode() ^ (b().hashCode() ^ c().hashCode());
    }
}
