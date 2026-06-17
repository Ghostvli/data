package defpackage;

/* JADX INFO: loaded from: classes3.dex */
public class yq1 implements yt {
    public byte[] a;

    public yq1(byte[] bArr, int i, int i2) {
        this(i2);
        System.arraycopy(bArr, i, this.a, 0, i2);
    }

    public byte[] a() {
        return this.a;
    }

    public int b() {
        return this.a.length;
    }

    public yq1(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public yq1(int i) {
        this.a = new byte[i];
    }
}
