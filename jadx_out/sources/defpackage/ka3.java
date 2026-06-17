package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ka3 {
    public ja3 a;
    public ja3 b;

    public synchronized void a(ja3 ja3Var) {
        try {
            if (ja3Var == null) {
                throw new NullPointerException("null cannot be enqueued");
            }
            ja3 ja3Var2 = this.b;
            if (ja3Var2 != null) {
                ja3Var2.c = ja3Var;
                this.b = ja3Var;
            } else {
                if (this.a != null) {
                    throw new IllegalStateException("Head present, but no tail");
                }
                this.b = ja3Var;
                this.a = ja3Var;
            }
            notifyAll();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized ja3 b() {
        ja3 ja3Var;
        ja3Var = this.a;
        if (ja3Var != null) {
            ja3 ja3Var2 = ja3Var.c;
            this.a = ja3Var2;
            if (ja3Var2 == null) {
                this.b = null;
            }
        }
        return ja3Var;
    }

    public synchronized ja3 c(int i) {
        try {
            if (this.a == null) {
                wait(i);
            }
        } catch (Throwable th) {
            throw th;
        }
        return b();
    }
}
