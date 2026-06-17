package defpackage;

import defpackage.yc;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class zg implements yc {
    public yc.a b;
    public yc.a c;
    public yc.a d;
    public yc.a e;
    public ByteBuffer f;
    public ByteBuffer g;
    public boolean h;

    public zg() {
        ByteBuffer byteBuffer = yc.a;
        this.f = byteBuffer;
        this.g = byteBuffer;
        yc.a aVar = yc.a.e;
        this.d = aVar;
        this.e = aVar;
        this.b = aVar;
        this.c = aVar;
    }

    public final boolean a() {
        return this.g.hasRemaining();
    }

    @Override // defpackage.yc
    public boolean b() {
        return this.h && this.g == yc.a;
    }

    @Override // defpackage.yc
    public boolean c() {
        return this.e != yc.a.e;
    }

    @Override // defpackage.yc
    public ByteBuffer d() {
        ByteBuffer byteBuffer = this.g;
        this.g = yc.a;
        return byteBuffer;
    }

    @Override // defpackage.yc
    public final void e(yc.b bVar) {
        this.g = yc.a;
        this.h = false;
        this.b = this.d;
        this.c = this.e;
        l(bVar);
    }

    @Override // defpackage.yc
    public final yc.a g(yc.a aVar) {
        this.d = aVar;
        this.e = j(aVar);
        return c() ? this.e : yc.a.e;
    }

    @Override // defpackage.yc
    public final void h() {
        this.h = true;
        m();
    }

    public abstract yc.a j(yc.a aVar);

    public void k() {
    }

    public void l(yc.b bVar) {
        k();
    }

    public void m() {
    }

    public void n() {
    }

    public final ByteBuffer o(int i) {
        if (this.f.capacity() < i) {
            this.f = ByteBuffer.allocateDirect(i).order(ByteOrder.nativeOrder());
        } else {
            this.f.clear();
        }
        ByteBuffer byteBuffer = this.f;
        this.g = byteBuffer;
        return byteBuffer;
    }

    @Override // defpackage.yc
    public final void reset() {
        ByteBuffer byteBuffer = yc.a;
        this.g = byteBuffer;
        this.h = false;
        this.f = byteBuffer;
        yc.a aVar = yc.a.e;
        this.d = aVar;
        this.e = aVar;
        this.b = aVar;
        this.c = aVar;
        n();
    }
}
