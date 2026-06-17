package defpackage;

import defpackage.yc;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class xc {
    public final xi1 a;
    public final List b = new ArrayList();
    public ByteBuffer[] c = new ByteBuffer[0];
    public yc.a d;
    public yc.a e;
    public boolean f;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xc(xi1 xi1Var) {
        this.a = xi1Var;
        yc.a aVar = yc.a.e;
        this.d = aVar;
        this.e = aVar;
        this.f = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public yc.a a(yc.a aVar) throws yc.c {
        if (aVar.equals(yc.a.e)) {
            throw new yc.c(aVar);
        }
        for (int i = 0; i < this.a.size(); i++) {
            yc ycVar = (yc) this.a.get(i);
            yc.a aVarG = ycVar.g(aVar);
            if (ycVar.c()) {
                gg3.v(!aVarG.equals(yc.a.e));
                aVar = aVarG;
            }
        }
        this.e = aVar;
        return aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b() {
        c(yc.b.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c(yc.b bVar) {
        this.b.clear();
        this.d = this.e;
        this.f = false;
        long jI = bVar.a;
        for (int i = 0; i < this.a.size(); i++) {
            yc ycVar = (yc) this.a.get(i);
            ycVar.e(new yc.b(jI));
            if (ycVar.c()) {
                jI = ycVar.i(jI);
                gg3.v(jI >= 0);
                this.b.add(ycVar);
            }
        }
        this.c = new ByteBuffer[this.b.size()];
        for (int i2 = 0; i2 <= d(); i2++) {
            this.c[i2] = ((yc) this.b.get(i2)).d();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int d() {
        return this.c.length - 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ByteBuffer e() {
        if (!g()) {
            return yc.a;
        }
        ByteBuffer byteBuffer = this.c[d()];
        if (byteBuffer.hasRemaining()) {
            return byteBuffer;
        }
        h(yc.a);
        return this.c[d()];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof xc)) {
            return false;
        }
        xc xcVar = (xc) obj;
        if (this.a.size() != xcVar.a.size()) {
            return false;
        }
        for (int i = 0; i < this.a.size(); i++) {
            if (this.a.get(i) != xcVar.a.get(i)) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean f() {
        return this.f && ((yc) this.b.get(d())).b() && !this.c[d()].hasRemaining();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean g() {
        return !this.b.isEmpty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h(ByteBuffer byteBuffer) {
        boolean z;
        for (boolean z2 = true; z2; z2 = z) {
            z = false;
            int i = 0;
            while (i <= d()) {
                if (!this.c[i].hasRemaining()) {
                    yc ycVar = (yc) this.b.get(i);
                    if (!ycVar.b()) {
                        ByteBuffer byteBuffer2 = i > 0 ? this.c[i - 1] : byteBuffer.hasRemaining() ? byteBuffer : yc.a;
                        long jRemaining = byteBuffer2.remaining();
                        ycVar.f(byteBuffer2);
                        this.c[i] = ycVar.d();
                        z |= jRemaining - ((long) byteBuffer2.remaining()) > 0 || this.c[i].hasRemaining();
                    } else if (!this.c[i].hasRemaining() && i < d()) {
                        ((yc) this.b.get(i + 1)).h();
                    }
                }
                i++;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return this.a.hashCode();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i() {
        if (!g() || this.f) {
            return;
        }
        this.f = true;
        ((yc) this.b.get(0)).h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j(ByteBuffer byteBuffer) {
        if (!g() || this.f) {
            return;
        }
        h(byteBuffer);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k() {
        for (int i = 0; i < this.a.size(); i++) {
            yc ycVar = (yc) this.a.get(i);
            ycVar.e(yc.b.b);
            ycVar.reset();
        }
        this.b.clear();
        this.c = new ByteBuffer[0];
        yc.a aVar = yc.a.e;
        this.d = aVar;
        this.e = aVar;
        this.f = false;
    }
}
