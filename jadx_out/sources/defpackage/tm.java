package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class tm implements fa {
    @Override // defpackage.fa
    public String a() {
        return "ByteArrayPool";
    }

    @Override // defpackage.fa
    public int b() {
        return 1;
    }

    @Override // defpackage.fa
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int c(byte[] bArr) {
        return bArr.length;
    }

    @Override // defpackage.fa
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public byte[] newArray(int i) {
        return new byte[i];
    }
}
