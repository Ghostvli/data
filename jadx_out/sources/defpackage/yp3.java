package defpackage;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class yp3 extends xi1 {
    public static final xi1 j = new yp3(new Object[0], 0);
    public final transient Object[] h;
    public final transient int i;

    public yp3(Object[] objArr, int i) {
        this.h = objArr;
        this.i = i;
    }

    @Override // defpackage.xi1, defpackage.vi1
    public int c(Object[] objArr, int i) {
        System.arraycopy(this.h, 0, objArr, i, this.i);
        return i + this.i;
    }

    @Override // defpackage.vi1
    public Object[] d() {
        return this.h;
    }

    @Override // defpackage.vi1
    public int e() {
        return this.i;
    }

    @Override // defpackage.vi1
    public int f() {
        return 0;
    }

    @Override // defpackage.vi1
    public boolean g() {
        return false;
    }

    @Override // java.util.List
    public Object get(int i) {
        gg3.o(i, this.i);
        Object obj = this.h[i];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.i;
    }
}
