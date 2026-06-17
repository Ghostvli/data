package defpackage;

import com.hierynomus.protocol.commons.buffer.Buffer;

/* JADX INFO: loaded from: classes3.dex */
public class on3 implements se4 {
    public byte[] a = null;
    public int b = 0;
    public int c = 0;
    public byte[] d = null;
    public boolean e;

    public on3() {
        n50.a(new gh0(b(), 20));
    }

    @Override // defpackage.se4
    public void a(boolean z, yt ytVar) {
        if (!(ytVar instanceof yq1)) {
            jl.a("invalid parameter passed to RC4 init - ".concat(ytVar.getClass().getName()));
            return;
        }
        byte[] bArrA = ((yq1) ytVar).a();
        this.d = bArrA;
        this.e = z;
        d(bArrA);
        n50.a(new gh0(b(), 20, ytVar, xy4.a(z)));
    }

    public String b() {
        return "RC4";
    }

    @Override // defpackage.se4
    public int c(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i + i2 > bArr.length) {
            throw new v90("input buffer too short");
        }
        if (i3 + i2 > bArr2.length) {
            throw new z63("output buffer too short");
        }
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = (this.b + 1) & 255;
            this.b = i5;
            byte[] bArr3 = this.a;
            byte b = bArr3[i5];
            int i6 = (this.c + b) & 255;
            this.c = i6;
            bArr3[i5] = bArr3[i6];
            bArr3[i6] = b;
            bArr2[i4 + i3] = (byte) (bArr3[(bArr3[i5] + b) & 255] ^ bArr[i4 + i]);
        }
        return i2;
    }

    public final void d(byte[] bArr) {
        this.d = bArr;
        this.b = 0;
        this.c = 0;
        if (this.a == null) {
            this.a = new byte[Buffer.DEFAULT_SIZE];
        }
        for (int i = 0; i < 256; i++) {
            this.a[i] = (byte) i;
        }
        int length = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 256; i3++) {
            int i4 = bArr[length] & 255;
            byte[] bArr2 = this.a;
            byte b = bArr2[i3];
            i2 = (i4 + b + i2) & 255;
            bArr2[i3] = bArr2[i2];
            bArr2[i2] = b;
            length = (length + 1) % bArr.length;
        }
    }

    @Override // defpackage.se4
    public void reset() {
        d(this.d);
    }
}
