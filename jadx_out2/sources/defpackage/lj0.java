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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
            int iF = xn3.f(lj0.this.b, 0, lj0.this.a.length());
            this.g = iF;
            this.h = iF;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Removed duplicated region for block: B:10:0x0022  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final void b() {
            i73 i73Var;
            if (this.h < 0) {
                this.f = 0;
                this.i = null;
                return;
            }
            if (lj0.this.c > 0) {
                int i = this.j + 1;
                this.j = i;
                if (i >= lj0.this.c) {
                    this.i = new sk1(this.g, wg4.U(lj0.this.a));
                    this.h = -1;
                } else if (this.h <= lj0.this.a.length() && (i73Var = (i73) lj0.this.d.invoke(lj0.this.a, Integer.valueOf(this.h))) != null) {
                    int iIntValue = ((Number) i73Var.a()).intValue();
                    int iIntValue2 = ((Number) i73Var.b()).intValue();
                    this.i = xn3.j(this.g, iIntValue);
                    int i2 = iIntValue + iIntValue2;
                    this.g = i2;
                    this.h = i2 + (iIntValue2 == 0 ? 1 : 0);
                } else {
                    this.i = new sk1(this.g, wg4.U(lj0.this.a));
                    this.h = -1;
                }
            }
            this.f = 1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: next()Ljava/lang/Object; */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Iterator
        public boolean hasNext() {
            if (this.f == -1) {
                b();
            }
            return this.f == 1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public lj0(CharSequence charSequence, int i, int i2, Function2 function2) {
        charSequence.getClass();
        function2.getClass();
        this.a = charSequence;
        this.b = i;
        this.c = i2;
        this.d = function2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.f14
    public Iterator iterator() {
        return new a();
    }
}
