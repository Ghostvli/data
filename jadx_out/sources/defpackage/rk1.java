package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class rk1 extends ok1 {
    public final int f;
    public final int g;
    public boolean h;
    public int i;

    public rk1(int i, int i2, int i3) {
        this.f = i3;
        this.g = i2;
        boolean z = false;
        if (i3 <= 0 ? i >= i2 : i <= i2) {
            z = true;
        }
        this.h = z;
        this.i = z ? i : i2;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.h;
    }

    @Override // defpackage.ok1
    public int nextInt() {
        int i = this.i;
        if (i != this.g) {
            this.i = this.f + i;
            return i;
        }
        if (this.h) {
            this.h = false;
            return i;
        }
        bo.a();
        return 0;
    }
}
