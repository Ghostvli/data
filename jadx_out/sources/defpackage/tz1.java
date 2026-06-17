package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class tz1 {
    public static final /* synthetic */ AtomicReferenceFieldUpdater a = AtomicReferenceFieldUpdater.newUpdater(tz1.class, Object.class, "_cur$volatile");
    private volatile /* synthetic */ Object _cur$volatile;

    public tz1(boolean z) {
        this._cur$volatile = new uz1(8, z);
    }

    public final boolean a(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        while (true) {
            uz1 uz1Var = (uz1) atomicReferenceFieldUpdater.get(this);
            int iA = uz1Var.a(obj);
            if (iA == 0) {
                return true;
            }
            if (iA == 1) {
                z0.a(a, this, uz1Var, uz1Var.l());
            } else if (iA == 2) {
                return false;
            }
        }
    }

    public final void b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        while (true) {
            uz1 uz1Var = (uz1) atomicReferenceFieldUpdater.get(this);
            if (uz1Var.d()) {
                return;
            } else {
                z0.a(a, this, uz1Var, uz1Var.l());
            }
        }
    }

    public final int c() {
        return ((uz1) a.get(this)).g();
    }

    public final Object e() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = a;
        while (true) {
            uz1 uz1Var = (uz1) atomicReferenceFieldUpdater.get(this);
            Object objM = uz1Var.m();
            if (objM != uz1.h) {
                return objM;
            }
            z0.a(a, this, uz1Var, uz1Var.l());
        }
    }
}
