package defpackage;

import java.util.Hashtable;

/* JADX INFO: loaded from: classes3.dex */
public class xb1 implements y32 {
    public static Hashtable h;
    public sl0 a;
    public int b;
    public int c;
    public rr2 d;
    public rr2 e;
    public byte[] f;
    public byte[] g;

    static {
        Hashtable hashtable = new Hashtable();
        h = hashtable;
        hashtable.put("GOST3411", xk1.a(32));
        h.put("MD2", xk1.a(16));
        h.put("MD4", xk1.a(64));
        h.put("MD5", xk1.a(64));
        h.put("RIPEMD128", xk1.a(64));
        h.put("RIPEMD160", xk1.a(64));
        h.put("SHA-1", xk1.a(64));
        h.put("SHA-224", xk1.a(64));
        h.put("SHA-256", xk1.a(64));
        h.put("SHA-384", xk1.a(128));
        h.put("SHA-512", xk1.a(128));
        h.put("Tiger", xk1.a(64));
        h.put("Whirlpool", xk1.a(64));
    }

    public xb1(sl0 sl0Var, int i) {
        this.a = sl0Var;
        int iE = sl0Var.e();
        this.b = iE;
        this.c = i;
        this.f = new byte[i];
        this.g = new byte[i + iE];
    }

    public static int c(sl0 sl0Var) {
        if (sl0Var instanceof uy0) {
            return ((uy0) sl0Var).d();
        }
        Integer num = (Integer) h.get(sl0Var.b());
        if (num != null) {
            return num.intValue();
        }
        nl.a("unknown digest passed: ", sl0Var.b());
        return 0;
    }

    public static void d(byte[] bArr, int i, byte b) {
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (bArr[i2] ^ b);
        }
    }

    @Override // defpackage.y32
    public int a() {
        return this.b;
    }

    @Override // defpackage.y32
    public void b(yt ytVar) {
        byte[] bArr;
        this.a.reset();
        byte[] bArrA = ((yq1) ytVar).a();
        int length = bArrA.length;
        if (length > this.c) {
            this.a.update(bArrA, 0, length);
            this.a.doFinal(this.f, 0);
            length = this.b;
        } else {
            System.arraycopy(bArrA, 0, this.f, 0, length);
        }
        while (true) {
            bArr = this.f;
            if (length >= bArr.length) {
                break;
            }
            bArr[length] = 0;
            length++;
        }
        System.arraycopy(bArr, 0, this.g, 0, this.c);
        d(this.f, this.c, (byte) 54);
        d(this.g, this.c, (byte) 92);
        sl0 sl0Var = this.a;
        if (sl0Var instanceof rr2) {
            rr2 rr2VarA = ((rr2) sl0Var).a();
            this.e = rr2VarA;
            ((sl0) rr2VarA).update(this.g, 0, this.c);
        }
        sl0 sl0Var2 = this.a;
        byte[] bArr2 = this.f;
        sl0Var2.update(bArr2, 0, bArr2.length);
        sl0 sl0Var3 = this.a;
        if (sl0Var3 instanceof rr2) {
            this.d = ((rr2) sl0Var3).a();
        }
    }

    @Override // defpackage.y32
    public int doFinal(byte[] bArr, int i) {
        this.a.doFinal(this.g, this.c);
        rr2 rr2Var = this.e;
        sl0 sl0Var = this.a;
        if (rr2Var != null) {
            ((rr2) sl0Var).c(rr2Var);
            sl0 sl0Var2 = this.a;
            sl0Var2.update(this.g, this.c, sl0Var2.e());
        } else {
            byte[] bArr2 = this.g;
            sl0Var.update(bArr2, 0, bArr2.length);
        }
        int iDoFinal = this.a.doFinal(bArr, i);
        int i2 = this.c;
        while (true) {
            byte[] bArr3 = this.g;
            if (i2 >= bArr3.length) {
                break;
            }
            bArr3[i2] = 0;
            i2++;
        }
        rr2 rr2Var2 = this.d;
        sl0 sl0Var3 = this.a;
        if (rr2Var2 != null) {
            ((rr2) sl0Var3).c(rr2Var2);
            return iDoFinal;
        }
        byte[] bArr4 = this.f;
        sl0Var3.update(bArr4, 0, bArr4.length);
        return iDoFinal;
    }

    @Override // defpackage.y32
    public void reset() {
        rr2 rr2Var = this.d;
        sl0 sl0Var = this.a;
        if (rr2Var != null) {
            ((rr2) sl0Var).c(rr2Var);
            return;
        }
        sl0Var.reset();
        sl0 sl0Var2 = this.a;
        byte[] bArr = this.f;
        sl0Var2.update(bArr, 0, bArr.length);
    }

    @Override // defpackage.y32
    public void update(byte b) {
        this.a.update(b);
    }

    @Override // defpackage.y32
    public void update(byte[] bArr, int i, int i2) {
        this.a.update(bArr, i, i2);
    }

    public xb1(sl0 sl0Var) {
        this(sl0Var, c(sl0Var));
    }
}
