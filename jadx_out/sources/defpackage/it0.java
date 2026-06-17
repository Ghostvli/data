package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class it0 extends i0 implements gt0, Serializable {
    public final Enum[] f;

    public it0(Enum[] enumArr) {
        enumArr.getClass();
        this.f = enumArr;
    }

    public boolean c(Enum r2) {
        r2.getClass();
        return ((Enum) ua.B(this.f, r2.ordinal())) == r2;
    }

    @Override // defpackage.u, java.util.Collection, java.util.List
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Enum) {
            return c((Enum) obj);
        }
        return false;
    }

    @Override // defpackage.i0, java.util.List
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Enum get(int i) {
        i0.Companion.b(i, this.f.length);
        return this.f[i];
    }

    public int e(Enum r2) {
        r2.getClass();
        int iOrdinal = r2.ordinal();
        if (((Enum) ua.B(this.f, iOrdinal)) == r2) {
            return iOrdinal;
        }
        return -1;
    }

    public int f(Enum r1) {
        r1.getClass();
        return e(r1);
    }

    @Override // defpackage.u
    public int getSize() {
        return this.f.length;
    }

    @Override // defpackage.i0, java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Enum) {
            return e((Enum) obj);
        }
        return -1;
    }

    @Override // defpackage.i0, java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Enum) {
            return f((Enum) obj);
        }
        return -1;
    }
}
