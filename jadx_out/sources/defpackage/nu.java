package defpackage;

import org.mozilla.classfile.ClassFileWriter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class nu {
    public String a;
    public String b;
    public short c;
    public short d;
    public short e;
    public byte[] f;

    public nu(String str, short s, String str2, short s2, short s3) {
        this.a = str;
        this.c = s;
        this.b = str2;
        this.d = s2;
        this.e = s3;
    }

    public short a() {
        return this.e;
    }

    public String b() {
        return this.a;
    }

    public String c() {
        return this.b;
    }

    public int d() {
        return this.f.length + 8;
    }

    public void e(byte[] bArr) {
        this.f = bArr;
    }

    public int f(byte[] bArr, int i) {
        int iY0 = ClassFileWriter.y0(1, bArr, ClassFileWriter.y0(this.d, bArr, ClassFileWriter.y0(this.c, bArr, ClassFileWriter.y0(this.e, bArr, i))));
        byte[] bArr2 = this.f;
        System.arraycopy(bArr2, 0, bArr, iY0, bArr2.length);
        return iY0 + this.f.length;
    }
}
