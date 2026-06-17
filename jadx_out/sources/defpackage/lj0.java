package defpackage;

import java.util.Iterator;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class lj0 implements f14 {
    public final CharSequence a;
    public final int b;
    public final int c;
    public final Function2 d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements Iterator, op1 {
        public int f = -1;
        public int g;
        public int h;
        public sk1 i;
        public int j;

        public a() {
            int iF = xn3.f(lj0.this.b, 0, lj0.this.a.length());
            this.g = iF;
            this.h = iF;
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        private final void b() {
            /*
                r6 = this;
                int r0 = r6.h
                r1 = 0
                if (r0 >= 0) goto Lb
                r6.f = r1
                r0 = 0
                r6.i = r0
                return
            Lb:
                lj0 r0 = defpackage.lj0.this
                int r0 = defpackage.lj0.d(r0)
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L22
                int r0 = r6.j
                int r0 = r0 + r3
                r6.j = r0
                lj0 r4 = defpackage.lj0.this
                int r4 = defpackage.lj0.d(r4)
                if (r0 >= r4) goto L30
            L22:
                int r0 = r6.h
                lj0 r4 = defpackage.lj0.this
                java.lang.CharSequence r4 = defpackage.lj0.c(r4)
                int r4 = r4.length()
                if (r0 <= r4) goto L46
            L30:
                sk1 r0 = new sk1
                int r1 = r6.g
                lj0 r4 = defpackage.lj0.this
                java.lang.CharSequence r4 = defpackage.lj0.c(r4)
                int r4 = defpackage.wg4.U(r4)
                r0.<init>(r1, r4)
                r6.i = r0
                r6.h = r2
                goto L9b
            L46:
                lj0 r0 = defpackage.lj0.this
                kotlin.jvm.functions.Function2 r0 = defpackage.lj0.b(r0)
                lj0 r4 = defpackage.lj0.this
                java.lang.CharSequence r4 = defpackage.lj0.c(r4)
                int r5 = r6.h
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                i73 r0 = (defpackage.i73) r0
                if (r0 != 0) goto L76
                sk1 r0 = new sk1
                int r1 = r6.g
                lj0 r4 = defpackage.lj0.this
                java.lang.CharSequence r4 = defpackage.lj0.c(r4)
                int r4 = defpackage.wg4.U(r4)
                r0.<init>(r1, r4)
                r6.i = r0
                r6.h = r2
                goto L9b
            L76:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.g
                sk1 r4 = defpackage.xn3.j(r4, r2)
                r6.i = r4
                int r2 = r2 + r0
                r6.g = r2
                if (r0 != 0) goto L98
                r1 = r3
            L98:
                int r2 = r2 + r1
                r6.h = r2
            L9b:
                r6.f = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: lj0.a.b():void");
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public sk1 next() {
            if (this.f == -1) {
                b();
            }
            if (this.f == 0) {
                bo.a();
                return null;
            }
            sk1 sk1Var = this.i;
            sk1Var.getClass();
            this.i = null;
            this.f = -1;
            return sk1Var;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f == -1) {
                b();
            }
            return this.f == 1;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public lj0(CharSequence charSequence, int i, int i2, Function2 function2) {
        charSequence.getClass();
        function2.getClass();
        this.a = charSequence;
        this.b = i;
        this.c = i2;
        this.d = function2;
    }

    @Override // defpackage.f14
    public Iterator iterator() {
        return new a();
    }
}
