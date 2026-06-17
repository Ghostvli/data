package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.media3.exoplayer.a;
import androidx.media3.exoplayer.p;
import defpackage.jq2;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ft2 extends a implements Handler.Callback {
    public final at2 A;
    public final boolean B;
    public ys2 C;
    public boolean D;
    public boolean E;
    public long F;
    public xs2 G;
    public long H;
    public final zs2 x;
    public final et2 y;
    public final Handler z;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ft2(et2 et2Var, Looper looper, zs2 zs2Var, boolean z) {
        super(5);
        this.y = (et2) gg3.q(et2Var);
        this.z = looper == null ? null : fy4.D(looper, this);
        this.x = (zs2) gg3.q(zs2Var);
        this.B = z;
        this.A = new at2();
        this.H = -9223372036854775807L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.p
    public int a(t41 t41Var) {
        if (this.x.a(t41Var)) {
            return p.C(t41Var.Q == 0 ? 4 : 2);
        }
        return p.C(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public boolean b() {
        return this.E;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public void c(long j, long j2) {
        boolean zU0 = true;
        while (zU0) {
            v0();
            zU0 = u0(j);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.a
    public void c0() {
        this.G = null;
        this.C = null;
        this.H = -9223372036854775807L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.a
    public void f0(long j, boolean z, boolean z2) {
        this.G = null;
        this.D = false;
        this.E = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o, androidx.media3.exoplayer.p
    public String getName() {
        return "MetadataRenderer";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            t0((xs2) message.obj);
            return true;
        }
        z20.a();
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.o
    public boolean isReady() {
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.media3.exoplayer.a
    public void l0(t41[] t41VarArr, long j, long j2, jq2.b bVar) {
        this.C = this.x.b(t41VarArr[0]);
        xs2 xs2Var = this.G;
        if (xs2Var != null) {
            this.G = xs2Var.c((xs2Var.b + this.H) - j2);
        }
        this.H = j2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q0(xs2 xs2Var, List list) {
        for (int i = 0; i < xs2Var.j(); i++) {
            t41 t41VarA = xs2Var.e(i).a();
            if (t41VarA == null || !this.x.a(t41VarA)) {
                list.add(xs2Var.e(i));
            } else {
                ys2 ys2VarB = this.x.b(t41VarA);
                byte[] bArr = (byte[]) gg3.q(xs2Var.e(i).c());
                this.A.clear();
                this.A.ensureSpaceForWrite(bArr.length);
                ((ByteBuffer) fy4.l(this.A.data)).put(bArr);
                this.A.flip();
                xs2 xs2VarA = ys2VarB.a(this.A);
                if (xs2VarA != null) {
                    q0(xs2VarA, list);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long r0(long j) {
        gg3.v(j != -9223372036854775807L);
        gg3.v(this.H != -9223372036854775807L);
        return j - this.H;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void s0(xs2 xs2Var) {
        Handler handler = this.z;
        if (handler != null) {
            handler.obtainMessage(1, xs2Var).sendToTarget();
        } else {
            t0(xs2Var);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void t0(xs2 xs2Var) {
        this.y.onMetadata(xs2Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean u0(long j) {
        boolean z;
        xs2 xs2Var = this.G;
        if (xs2Var == null || (!this.B && xs2Var.b > r0(j))) {
            z = false;
        } else {
            s0(this.G);
            this.G = null;
            z = true;
        }
        if (this.D && this.G == null) {
            this.E = true;
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void v0() {
        if (this.D || this.G != null) {
            return;
        }
        this.A.clear();
        u41 u41VarT = T();
        int iN0 = n0(u41VarT, this.A, 0);
        if (iN0 != -4) {
            if (iN0 == -5) {
                this.F = ((t41) gg3.q(u41VarT.b)).u;
                return;
            }
            return;
        }
        if (this.A.isEndOfStream()) {
            this.D = true;
            return;
        }
        if (this.A.timeUs >= V()) {
            at2 at2Var = this.A;
            at2Var.f = this.F;
            at2Var.flip();
            xs2 xs2VarA = ((ys2) fy4.l(this.C)).a(this.A);
            if (xs2VarA != null) {
                ArrayList arrayList = new ArrayList(xs2VarA.j());
                q0(xs2VarA, arrayList);
                if (arrayList.isEmpty()) {
                    return;
                }
                this.G = new xs2(r0(this.A.timeUs), arrayList);
            }
        }
    }

    public ft2(et2 et2Var, Looper looper, zs2 zs2Var) {
        this(et2Var, looper, zs2Var, false);
    }

    public ft2(et2 et2Var, Looper looper) {
        this(et2Var, looper, zs2.a);
    }
}
