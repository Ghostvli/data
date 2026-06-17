package defpackage;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class rc1 extends a1 {
    public transient int l;

    public rc1(int i, int i2) {
        super(nb3.c(i));
        this.l = 2;
        gg3.d(i2 >= 0);
        this.l = i2;
    }

    public static rc1 H() {
        return new rc1();
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: E */
    public /* bridge */ /* synthetic */ Set a() {
        return super.a();
    }

    @Override // defpackage.a1
    /* JADX INFO: renamed from: F */
    public /* bridge */ /* synthetic */ Set get(Object obj) {
        return super.get(obj);
    }

    @Override // defpackage.a1
    public /* bridge */ /* synthetic */ Set G(Object obj) {
        return super.G(obj);
    }

    @Override // defpackage.m0
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public Set s() {
        return nb3.d(this.l);
    }

    @Override // defpackage.a1, defpackage.q0, defpackage.dw2
    public /* bridge */ /* synthetic */ Map b() {
        return super.b();
    }

    @Override // defpackage.q0, defpackage.dw2
    public /* bridge */ /* synthetic */ boolean c(Object obj, Object obj2) {
        return super.c(obj, obj2);
    }

    @Override // defpackage.m0, defpackage.dw2
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // defpackage.q0
    public /* bridge */ /* synthetic */ boolean d(Object obj) {
        return super.d(obj);
    }

    @Override // defpackage.a1, defpackage.q0
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // defpackage.q0
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // defpackage.q0, defpackage.dw2
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // defpackage.a1, defpackage.m0, defpackage.dw2
    public /* bridge */ /* synthetic */ boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // defpackage.q0, defpackage.dw2
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // defpackage.m0, defpackage.dw2
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // defpackage.q0
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // defpackage.m0, defpackage.q0, defpackage.dw2
    public /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public rc1() {
        this(12, 2);
    }
}
