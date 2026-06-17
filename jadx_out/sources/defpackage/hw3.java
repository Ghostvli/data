package defpackage;

import com.hierynomus.protocol.commons.buffer.Buffer;

/* JADX INFO: loaded from: classes3.dex */
public class hw3 extends u02 {
    public hw3(k50 k50Var) {
        super(k50Var);
        n50.a(r());
        reset();
    }

    @Override // defpackage.rr2
    public rr2 a() {
        return new hw3(this);
    }

    @Override // defpackage.sl0
    public String b() {
        return "SHA-512";
    }

    @Override // defpackage.rr2
    public void c(rr2 rr2Var) {
        m((hw3) rr2Var);
    }

    @Override // defpackage.sl0
    public int doFinal(byte[] bArr, int i) {
        n();
        b73.h(this.f, bArr, i);
        b73.h(this.g, bArr, i + 8);
        b73.h(this.h, bArr, i + 16);
        b73.h(this.i, bArr, i + 24);
        b73.h(this.j, bArr, i + 32);
        b73.h(this.k, bArr, i + 40);
        b73.h(this.l, bArr, i + 48);
        b73.h(this.m, bArr, i + 56);
        reset();
        return 64;
    }

    @Override // defpackage.sl0
    public int e() {
        return 64;
    }

    public j50 r() {
        return wy4.a(this, Buffer.DEFAULT_SIZE, this.a);
    }

    @Override // defpackage.u02, defpackage.sl0
    public void reset() {
        super.reset();
        this.f = 7640891576956012808L;
        this.g = -4942790177534073029L;
        this.h = 4354685564936845355L;
        this.i = -6534734903238641935L;
        this.j = 5840696475078001361L;
        this.k = -7276294671716946913L;
        this.l = 2270897969802886507L;
        this.m = 6620516959819538809L;
    }

    public hw3() {
        this(k50.ANY);
    }

    public hw3(hw3 hw3Var) {
        super(hw3Var);
        n50.a(r());
    }
}
