package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class cz {
    public final zu a;
    public boolean b;

    public cz() {
        this(zu.a);
    }

    public synchronized void a() {
        while (!this.b) {
            this.a.d();
            wait();
        }
    }

    public synchronized void b() {
        boolean z = false;
        while (!this.b) {
            try {
                this.a.d();
                wait();
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized boolean c(long j) {
        if (j <= 0) {
            return this.b;
        }
        long jE = this.a.e();
        long j2 = j + jE;
        if (j2 < jE) {
            b();
        } else {
            boolean z = false;
            while (!this.b && jE < j2) {
                try {
                    this.a.d();
                    wait(j2 - jE);
                } catch (InterruptedException unused) {
                    z = true;
                }
                jE = this.a.e();
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
        }
        return this.b;
    }

    public synchronized boolean d() {
        boolean z;
        z = this.b;
        this.b = false;
        return z;
    }

    public synchronized boolean e() {
        return this.b;
    }

    public synchronized boolean f() {
        if (this.b) {
            return false;
        }
        this.b = true;
        notifyAll();
        return true;
    }

    public cz(zu zuVar) {
        this.a = zuVar;
    }
}
