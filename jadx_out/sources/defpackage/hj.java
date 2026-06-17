package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class hj implements z81 {
    public long[] a;

    @Override // defpackage.z81
    public void a(long j, byte[] bArr) {
        long[] jArrL = b91.l();
        if (j > 0) {
            long[] jArr = new long[2];
            b91.f(this.a, jArr);
            do {
                if ((1 & j) != 0) {
                    b91.j(jArrL, jArr);
                }
                b91.m(jArr, jArr);
                j >>>= 1;
            } while (j > 0);
        }
        b91.b(jArrL, bArr);
    }

    @Override // defpackage.z81
    public void init(byte[] bArr) {
        this.a = b91.d(bArr);
    }
}
