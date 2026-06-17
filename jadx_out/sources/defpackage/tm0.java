package defpackage;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class tm0 implements z21 {
    public final z21 f;
    public final Function1 g;
    public final Function2 h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements a31 {
        public final /* synthetic */ mp3 g;
        public final /* synthetic */ a31 h;

        /* JADX INFO: renamed from: tm0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class C0121a extends g30 {
            public /* synthetic */ Object f;
            public int h;

            public C0121a(f30 f30Var) {
                super(f30Var);
            }

            @Override // defpackage.hh
            public final Object invokeSuspend(Object obj) {
                this.f = obj;
                this.h |= Integer.MIN_VALUE;
                return a.this.emit(null, this);
            }
        }

        public a(mp3 mp3Var, a31 a31Var) {
            this.g = mp3Var;
            this.h = a31Var;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // defpackage.a31
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(java.lang.Object r6, defpackage.f30 r7) throws java.lang.Throwable {
            /*
                r5 = this;
                boolean r0 = r7 instanceof tm0.a.C0121a
                if (r0 == 0) goto L13
                r0 = r7
                tm0$a$a r0 = (tm0.a.C0121a) r0
                int r1 = r0.h
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.h = r1
                goto L18
            L13:
                tm0$a$a r0 = new tm0$a$a
                r0.<init>(r7)
            L18:
                java.lang.Object r7 = r0.f
                java.lang.Object r1 = defpackage.kl1.e()
                int r2 = r0.h
                r3 = 1
                if (r2 == 0) goto L30
                if (r2 != r3) goto L29
                defpackage.lt3.b(r7)
                goto L66
            L29:
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                defpackage.e04.a(r5)
                r5 = 0
                return r5
            L30:
                defpackage.lt3.b(r7)
                tm0 r7 = defpackage.tm0.this
                kotlin.jvm.functions.Function1 r7 = r7.g
                java.lang.Object r7 = r7.invoke(r6)
                mp3 r2 = r5.g
                java.lang.Object r2 = r2.f
                qj4 r4 = defpackage.m43.a
                if (r2 == r4) goto L57
                tm0 r4 = defpackage.tm0.this
                kotlin.jvm.functions.Function2 r4 = r4.h
                java.lang.Object r2 = r4.invoke(r2, r7)
                java.lang.Boolean r2 = (java.lang.Boolean) r2
                boolean r2 = r2.booleanValue()
                if (r2 != 0) goto L54
                goto L57
            L54:
                fw4 r5 = defpackage.fw4.a
                return r5
            L57:
                mp3 r2 = r5.g
                r2.f = r7
                a31 r5 = r5.h
                r0.h = r3
                java.lang.Object r5 = r5.emit(r6, r0)
                if (r5 != r1) goto L66
                return r1
            L66:
                fw4 r5 = defpackage.fw4.a
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: tm0.a.emit(java.lang.Object, f30):java.lang.Object");
        }
    }

    public tm0(z21 z21Var, Function1 function1, Function2 function2) {
        this.f = z21Var;
        this.g = function1;
        this.h = function2;
    }

    @Override // defpackage.z21
    public Object collect(a31 a31Var, f30 f30Var) {
        mp3 mp3Var = new mp3();
        mp3Var.f = m43.a;
        Object objCollect = this.f.collect(new a(mp3Var, a31Var), f30Var);
        return objCollect == kl1.e() ? objCollect : fw4.a;
    }
}
