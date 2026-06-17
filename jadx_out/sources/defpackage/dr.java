package defpackage;

import androidx.media3.decoder.a;
import defpackage.dr;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class dr implements zh4 {
    public final ArrayDeque a = new ArrayDeque();
    public final ArrayDeque b;
    public final ArrayDeque c;
    public b d;
    public long e;
    public long f;
    public long g;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends gi4 implements Comparable {
        public long g;

        public b() {
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public int compareTo(b bVar) {
            if (isEndOfStream() != bVar.isEndOfStream()) {
                return isEndOfStream() ? 1 : -1;
            }
            long j = this.timeUs - bVar.timeUs;
            if (j == 0) {
                j = this.g - bVar.g;
                if (j == 0) {
                    return 0;
                }
            }
            return j > 0 ? 1 : -1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends hi4 {
        public a.InterfaceC0015a h;

        public c(a.InterfaceC0015a interfaceC0015a) {
            this.h = interfaceC0015a;
        }

        @Override // androidx.media3.decoder.a
        public final void release() {
            this.h.a(this);
        }
    }

    public dr() {
        for (int i = 0; i < 10; i++) {
            this.a.add(new b());
        }
        this.b = new ArrayDeque();
        for (int i2 = 0; i2 < 2; i2++) {
            this.b.add(new c(new a.InterfaceC0015a() { // from class: cr
                @Override // androidx.media3.decoder.a.InterfaceC0015a
                public final void a(a aVar) {
                    this.a.p((dr.c) aVar);
                }
            }));
        }
        this.c = new ArrayDeque();
        this.g = -9223372036854775807L;
    }

    @Override // defpackage.fb0
    public final void b(long j) {
        this.g = j;
    }

    @Override // defpackage.zh4
    public void c(long j) {
        this.e = j;
    }

    @Override // defpackage.fb0
    public void flush() {
        this.f = 0L;
        this.e = 0L;
        while (!this.c.isEmpty()) {
            o((b) fy4.l((b) this.c.poll()));
        }
        b bVar = this.d;
        if (bVar != null) {
            o(bVar);
            this.d = null;
        }
    }

    public abstract yh4 g();

    public abstract void h(gi4 gi4Var);

    @Override // defpackage.fb0
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public gi4 d() {
        gg3.v(this.d == null);
        if (this.a.isEmpty()) {
            return null;
        }
        b bVar = (b) this.a.pollFirst();
        this.d = bVar;
        return bVar;
    }

    @Override // defpackage.fb0
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public hi4 a() {
        if (this.b.isEmpty()) {
            return null;
        }
        while (!this.c.isEmpty() && ((b) fy4.l((b) this.c.peek())).timeUs <= this.e) {
            b bVar = (b) fy4.l((b) this.c.poll());
            if (bVar.isEndOfStream()) {
                hi4 hi4Var = (hi4) fy4.l((hi4) this.b.pollFirst());
                hi4Var.addFlag(4);
                o(bVar);
                return hi4Var;
            }
            h(bVar);
            if (m()) {
                yh4 yh4VarG = g();
                hi4 hi4Var2 = (hi4) fy4.l((hi4) this.b.pollFirst());
                hi4Var2.g(bVar.timeUs, yh4VarG, Long.MAX_VALUE);
                o(bVar);
                return hi4Var2;
            }
            o(bVar);
        }
        return null;
    }

    public final hi4 k() {
        return (hi4) this.b.pollFirst();
    }

    public final long l() {
        return this.e;
    }

    public abstract boolean m();

    /* JADX WARN: Removed duplicated region for block: B:15:0x002d  */
    @Override // defpackage.fb0
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void f(defpackage.gi4 r7) {
        /*
            r6 = this;
            dr$b r0 = r6.d
            if (r7 != r0) goto L6
            r0 = 1
            goto L7
        L6:
            r0 = 0
        L7:
            defpackage.gg3.d(r0)
            dr$b r7 = (dr.b) r7
            boolean r0 = r7.isEndOfStream()
            if (r0 != 0) goto L2d
            long r0 = r7.timeUs
            r2 = -9223372036854775808
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 == 0) goto L2d
            long r2 = r6.g
            r4 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r4 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r4 == 0) goto L2d
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L2d
            r6.o(r7)
            goto L3c
        L2d:
            long r0 = r6.f
            r2 = 1
            long r2 = r2 + r0
            r6.f = r2
            dr.b.g(r7, r0)
            java.util.ArrayDeque r0 = r6.c
            r0.add(r7)
        L3c:
            r7 = 0
            r6.d = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.dr.f(gi4):void");
    }

    public final void o(b bVar) {
        bVar.clear();
        this.a.add(bVar);
    }

    public void p(hi4 hi4Var) {
        hi4Var.clear();
        this.b.add(hi4Var);
    }

    @Override // defpackage.fb0
    public void release() {
    }
}
