package androidx.media3.exoplayer;

import android.os.Looper;
import defpackage.gg3;
import defpackage.no4;
import defpackage.zu;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class n {
    public final b a;
    public final a b;
    public final zu c;
    public final no4 d;
    public int e;
    public Object f;
    public Looper g;
    public int h;
    public long i = -9223372036854775807L;
    public boolean j = true;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void g(n nVar);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void F(int i, Object obj);
    }

    public n(a aVar, b bVar, no4 no4Var, int i, zu zuVar, Looper looper) {
        this.b = aVar;
        this.a = bVar;
        this.d = no4Var;
        this.g = looper;
        this.c = zuVar;
        this.h = i;
    }

    public boolean a() {
        return this.j;
    }

    public Looper b() {
        return this.g;
    }

    public int c() {
        return this.h;
    }

    public Object d() {
        return this.f;
    }

    public long e() {
        return this.i;
    }

    public b f() {
        return this.a;
    }

    public no4 g() {
        return this.d;
    }

    public int h() {
        return this.e;
    }

    public synchronized boolean i() {
        return this.n;
    }

    public synchronized void j(boolean z) {
        this.l = z | this.l;
        this.m = true;
        notifyAll();
    }

    public n k() {
        gg3.v(!this.k);
        if (this.i == -9223372036854775807L) {
            gg3.d(this.j);
        }
        this.k = true;
        this.b.g(this);
        return this;
    }

    public n l(Object obj) {
        gg3.v(!this.k);
        this.f = obj;
        return this;
    }

    public n m(int i) {
        gg3.v(!this.k);
        this.e = i;
        return this;
    }
}
