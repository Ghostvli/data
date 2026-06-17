package defpackage;

import java.util.ArrayList;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class tr implements u81 {
    public final g40 f;
    public final int g;
    public final tl h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends oj4 implements Function2 {
        public int f;
        public /* synthetic */ Object g;
        public final /* synthetic */ a31 h;
        public final /* synthetic */ tr i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(a31 a31Var, tr trVar, f30 f30Var) {
            super(2, f30Var);
            this.h = a31Var;
            this.i = trVar;
        }

        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            a aVar = new a(this.h, this.i, f30Var);
            aVar.g = obj;
            return aVar;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((a) create(u40Var, f30Var)).invokeSuspend(fw4.a);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kl1.e();
            int i = this.f;
            if (i == 0) {
                lt3.b(obj);
                u40 u40Var = (u40) this.g;
                a31 a31Var = this.h;
                oo3 oo3VarM = this.i.m(u40Var);
                this.f = 1;
                if (c31.f(a31Var, oo3VarM, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                lt3.b(obj);
            }
            return fw4.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends oj4 implements Function2 {
        public int f;
        public /* synthetic */ Object g;

        public b(f30 f30Var) {
            super(2, f30Var);
        }

        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            b bVar = tr.this.new b(f30Var);
            bVar.g = obj;
            return bVar;
        }

        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
        public final Object invoke(eh3 eh3Var, f30 f30Var) {
            return ((b) create(eh3Var, f30Var)).invokeSuspend(fw4.a);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kl1.e();
            int i = this.f;
            if (i == 0) {
                lt3.b(obj);
                eh3 eh3Var = (eh3) this.g;
                tr trVar = tr.this;
                this.f = 1;
                if (trVar.h(eh3Var, this) == objE) {
                    return objE;
                }
            } else {
                if (i != 1) {
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                lt3.b(obj);
            }
            return fw4.a;
        }
    }

    public tr(g40 g40Var, int i, tl tlVar) {
        this.f = g40Var;
        this.g = i;
        this.h = tlVar;
    }

    public static /* synthetic */ Object f(tr trVar, a31 a31Var, f30 f30Var) {
        Object objD = v40.d(new a(a31Var, trVar, null), f30Var);
        return objD == kl1.e() ? objD : fw4.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0013  */
    @Override // defpackage.u81
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.z21 b(defpackage.g40 r2, int r3, defpackage.tl r4) {
        /*
            r1 = this;
            g40 r0 = r1.f
            g40 r2 = r2.N(r0)
            tl r0 = defpackage.tl.f
            if (r4 == r0) goto Lb
            goto L25
        Lb:
            int r4 = r1.g
            r0 = -3
            if (r4 != r0) goto L11
            goto L23
        L11:
            if (r3 != r0) goto L15
        L13:
            r3 = r4
            goto L23
        L15:
            r0 = -2
            if (r4 != r0) goto L19
            goto L23
        L19:
            if (r3 != r0) goto L1c
            goto L13
        L1c:
            int r3 = r3 + r4
            if (r3 < 0) goto L20
            goto L23
        L20:
            r3 = 2147483647(0x7fffffff, float:NaN)
        L23:
            tl r4 = r1.h
        L25:
            g40 r0 = r1.f
            boolean r0 = defpackage.il1.a(r2, r0)
            if (r0 == 0) goto L36
            int r0 = r1.g
            if (r3 != r0) goto L36
            tl r0 = r1.h
            if (r4 != r0) goto L36
            return r1
        L36:
            tr r1 = r1.i(r2, r3, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.tr.b(g40, int, tl):z21");
    }

    @Override // defpackage.z21
    public Object collect(a31 a31Var, f30 f30Var) {
        return f(this, a31Var, f30Var);
    }

    public String e() {
        return null;
    }

    public abstract Object h(eh3 eh3Var, f30 f30Var);

    public abstract tr i(g40 g40Var, int i, tl tlVar);

    public z21 j() {
        return null;
    }

    public final Function2 k() {
        return new b(null);
    }

    public final int l() {
        int i = this.g;
        if (i == -3) {
            return -2;
        }
        return i;
    }

    public oo3 m(u40 u40Var) {
        return ch3.b(u40Var, this.f, l(), this.h, y40.h, null, k(), 16, null);
    }

    public String toString() {
        ArrayList arrayList = new ArrayList(4);
        String strE = e();
        if (strE != null) {
            arrayList.add(strE);
        }
        if (this.f != bs0.f) {
            arrayList.add("context=" + this.f);
        }
        if (this.g != -3) {
            arrayList.add("capacity=" + this.g);
        }
        if (this.h != tl.f) {
            arrayList.add("onBufferOverflow=" + this.h);
        }
        return ua0.a(this) + '[' + ww.P(arrayList, ", ", null, null, 0, null, null, 62, null) + ']';
    }
}
