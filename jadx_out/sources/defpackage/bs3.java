package defpackage;

import java.nio.ByteBuffer;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class bs3 implements wq1 {
    public static final e32 j = new e32(50);
    public final ma b;
    public final wq1 c;
    public final wq1 d;
    public final int e;
    public final int f;
    public final Class g;
    public final u63 h;
    public final ns4 i;

    public bs3(ma maVar, wq1 wq1Var, wq1 wq1Var2, int i, int i2, ns4 ns4Var, Class cls, u63 u63Var) {
        this.b = maVar;
        this.c = wq1Var;
        this.d = wq1Var2;
        this.e = i;
        this.f = i2;
        this.i = ns4Var;
        this.g = cls;
        this.h = u63Var;
    }

    @Override // defpackage.wq1
    public void b(MessageDigest messageDigest) {
        byte[] bArr = (byte[]) this.b.c(8, byte[].class);
        ByteBuffer.wrap(bArr).putInt(this.e).putInt(this.f).array();
        this.d.b(messageDigest);
        this.c.b(messageDigest);
        messageDigest.update(bArr);
        ns4 ns4Var = this.i;
        if (ns4Var != null) {
            ns4Var.b(messageDigest);
        }
        this.h.b(messageDigest);
        messageDigest.update(c());
        this.b.put(bArr);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$ArrayArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final byte[] c() {
        e32 e32Var = j;
        byte[] bArr = (byte[]) e32Var.g(this.g);
        if (bArr != null) {
            return bArr;
        }
        byte[] bytes = this.g.getName().getBytes(wq1.a);
        e32Var.k(this.g, bytes);
        return bytes;
    }

    @Override // defpackage.wq1
    public boolean equals(Object obj) {
        if (obj instanceof bs3) {
            bs3 bs3Var = (bs3) obj;
            if (this.f == bs3Var.f && this.e == bs3Var.e && iy4.e(this.i, bs3Var.i) && this.g.equals(bs3Var.g) && this.c.equals(bs3Var.c) && this.d.equals(bs3Var.d) && this.h.equals(bs3Var.h)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.wq1
    public int hashCode() {
        int iHashCode = (((((this.c.hashCode() * 31) + this.d.hashCode()) * 31) + this.e) * 31) + this.f;
        ns4 ns4Var = this.i;
        if (ns4Var != null) {
            iHashCode = (iHashCode * 31) + ns4Var.hashCode();
        }
        return (((iHashCode * 31) + this.g.hashCode()) * 31) + this.h.hashCode();
    }

    public String toString() {
        return "ResourceCacheKey{sourceKey=" + this.c + ", signature=" + this.d + ", width=" + this.e + ", height=" + this.f + ", decodedResourceClass=" + this.g + ", transformation='" + this.i + "', options=" + this.h + '}';
    }
}
