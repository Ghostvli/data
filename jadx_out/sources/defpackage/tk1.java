package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class tk1 implements fa {
    @Override // defpackage.fa
    public String a() {
        return "IntegerArrayPool";
    }

    @Override // defpackage.fa
    public int b() {
        return 4;
    }

    @Override // defpackage.fa
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public int c(int[] iArr) {
        return iArr.length;
    }

    @Override // defpackage.fa
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public int[] newArray(int i) {
        return new int[i];
    }
}
