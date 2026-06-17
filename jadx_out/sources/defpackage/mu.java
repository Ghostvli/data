package defpackage;

import org.mozilla.classfile.ClassFileWriter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class mu {
    public short a;
    public short b;
    public short c;
    public boolean d = false;
    public short e;
    public short f;
    public short g;
    public int h;

    public mu(short s, short s2, short s3) {
        this.a = s;
        this.b = s2;
        this.c = s3;
    }

    public int a() {
        return !this.d ? 8 : 16;
    }

    public int b(byte[] bArr, int i) {
        int iY0 = ClassFileWriter.y0(this.b, bArr, ClassFileWriter.y0(this.a, bArr, ClassFileWriter.y0(this.c, bArr, i)));
        if (!this.d) {
            return ClassFileWriter.y0(0, bArr, iY0);
        }
        return ClassFileWriter.y0(this.h, bArr, ClassFileWriter.y0(this.g, bArr, ClassFileWriter.y0(this.f, bArr, ClassFileWriter.y0(this.e, bArr, ClassFileWriter.y0(1, bArr, iY0)))));
    }
}
