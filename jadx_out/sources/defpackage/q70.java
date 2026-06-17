package defpackage;

import java.math.BigInteger;

/* JADX INFO: loaded from: classes3.dex */
public class q70 implements yt {
    public BigInteger a;
    public BigInteger b;
    public BigInteger c;
    public BigInteger d;
    public int e;
    public int f;
    public r70 g;

    public q70(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, int i, int i2, BigInteger bigInteger4, r70 r70Var) {
        if (i2 != 0) {
            if (i2 > bigInteger.bitLength()) {
                jl.a("when l value specified, it must satisfy 2^(l-1) <= p");
                throw null;
            }
            if (i2 < i) {
                jl.a("when l value specified, it may not be less than m value");
                throw null;
            }
        }
        if (i > bigInteger.bitLength() && !ci3.b("org.bouncycastle.dh.allow_unsafe_p_value")) {
            jl.a("unsafe p value so small specific l required");
            throw null;
        }
        this.a = bigInteger2;
        this.b = bigInteger;
        this.c = bigInteger3;
        this.e = i;
        this.f = i2;
        this.d = bigInteger4;
        this.g = r70Var;
    }

    public BigInteger a() {
        return this.a;
    }

    public BigInteger b() {
        return this.b;
    }

    public BigInteger c() {
        return this.c;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof q70)) {
            return false;
        }
        q70 q70Var = (q70) obj;
        if (c() != null) {
            if (!c().equals(q70Var.c())) {
                return false;
            }
        } else if (q70Var.c() != null) {
            return false;
        }
        return q70Var.b().equals(this.b) && q70Var.a().equals(this.a);
    }

    public int hashCode() {
        return (c() != null ? c().hashCode() : 0) ^ (b().hashCode() ^ a().hashCode());
    }
}
