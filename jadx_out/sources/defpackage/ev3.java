package defpackage;

import defpackage.ev3;
import java.util.Comparator;
import java.util.TreeSet;
import okhttp3.internal.http2.Settings;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ev3 {
    public final TreeSet a = new TreeSet(new Comparator() { // from class: dv3
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return ev3.c(((ev3.a) obj).a.g, ((ev3.a) obj2).a.g);
        }
    });
    public int b;
    public int c;
    public boolean d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final cv3 a;
        public final long b;

        public a(cv3 cv3Var, long j) {
            this.a = cv3Var;
            this.b = j;
        }
    }

    public ev3() {
        f();
    }

    public static int c(int i, int i2) {
        int iMin;
        int i3 = i - i2;
        return (Math.abs(i3) <= 1000 || (iMin = (Math.min(i, i2) - Math.max(i, i2)) + Settings.DEFAULT_INITIAL_WINDOW_SIZE) >= 1000) ? i3 : i < i2 ? iMin : -iMin;
    }

    public final synchronized void b(a aVar) {
        this.b = aVar.a.g;
        this.a.add(aVar);
    }

    public synchronized boolean d(cv3 cv3Var, long j) {
        if (this.a.size() >= 5000) {
            throw new IllegalStateException("Queue size limit of 5000 reached.");
        }
        int i = cv3Var.g;
        if (!this.d) {
            f();
            this.c = cv3.c(i);
            this.d = true;
            b(new a(cv3Var, j));
            return true;
        }
        if (Math.abs(c(i, cv3.b(this.b))) < 1000) {
            if (c(i, this.c) <= 0) {
                return false;
            }
            b(new a(cv3Var, j));
            return true;
        }
        this.c = cv3.c(i);
        this.a.clear();
        b(new a(cv3Var, j));
        return true;
    }

    public synchronized cv3 e(long j) {
        if (this.a.isEmpty()) {
            return null;
        }
        a aVar = (a) this.a.first();
        int i = aVar.a.g;
        if (i != cv3.b(this.c) && j < aVar.b) {
            return null;
        }
        this.a.pollFirst();
        this.c = i;
        return aVar.a;
    }

    public synchronized void f() {
        this.a.clear();
        this.d = false;
        this.c = -1;
        this.b = -1;
    }
}
