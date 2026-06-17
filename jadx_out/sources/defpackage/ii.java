package defpackage;

import defpackage.qt;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ii implements qt.b {
    public final int[] a;
    public final ex3[] b;

    public ii(int[] iArr, ex3[] ex3VarArr) {
        this.a = iArr;
        this.b = ex3VarArr;
    }

    public int[] a() {
        int[] iArr = new int[this.b.length];
        int i = 0;
        while (true) {
            ex3[] ex3VarArr = this.b;
            if (i >= ex3VarArr.length) {
                return iArr;
            }
            iArr[i] = ex3VarArr[i].K();
            i++;
        }
    }

    public void b(long j) {
        for (ex3 ex3Var : this.b) {
            ex3Var.f0(j);
        }
    }

    @Override // qt.b
    public gr4 e(int i, int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = this.a;
            if (i3 >= iArr.length) {
                xz1.d("BaseMediaChunkOutput", "Unmatched track of type: " + i2);
                return new wl0();
            }
            if (i2 == iArr[i3]) {
                return this.b[i3];
            }
            i3++;
        }
    }
}
