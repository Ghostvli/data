package defpackage;

import defpackage.g40;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class nn4 implements g40.c {
    public final ThreadLocal f;

    public nn4(ThreadLocal threadLocal) {
        this.f = threadLocal;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof nn4) && il1.a(this.f, ((nn4) obj).f);
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.f + ')';
    }
}
