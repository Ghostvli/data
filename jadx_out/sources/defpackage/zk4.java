package defpackage;

import com.hierynomus.protocol.commons.buffer.Buffer;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: classes3.dex */
public class zk4 implements a91 {
    public byte[] a;
    public long[][] b;

    @Override // defpackage.a91
    public void a(byte[] bArr) {
        long[] jArr = this.b[bArr[15] & 255];
        long j = jArr[0];
        long j2 = jArr[1];
        for (int i = 14; i >= 0; i--) {
            long[] jArr2 = this.b[bArr[i] & 255];
            long j3 = j2 << 56;
            j2 = ((j2 >>> 8) | (j << 56)) ^ jArr2[1];
            j = (((((j >>> 8) ^ jArr2[0]) ^ j3) ^ (j3 >>> 1)) ^ (j3 >>> 2)) ^ (j3 >>> 7);
        }
        b73.h(j, bArr, 0);
        b73.h(j2, bArr, 8);
    }

    @Override // defpackage.a91
    public void init(byte[] bArr) {
        if (this.b == null) {
            this.b = (long[][]) Array.newInstance((Class<?>) Long.TYPE, Buffer.DEFAULT_SIZE, 2);
        } else if (b91.a(this.a, bArr) != 0) {
            return;
        }
        byte[] bArr2 = new byte[16];
        this.a = bArr2;
        b91.e(bArr, bArr2);
        b91.c(this.a, this.b[1]);
        long[] jArr = this.b[1];
        b91.k(jArr, jArr);
        for (int i = 2; i < 256; i += 2) {
            long[][] jArr2 = this.b;
            b91.g(jArr2[i >> 1], jArr2[i]);
            long[][] jArr3 = this.b;
            b91.s(jArr3[i], jArr3[1], jArr3[i + 1]);
        }
    }
}
