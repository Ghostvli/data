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

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public C0121a(f30 f30Var) {
                super(f30Var);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.hh
            public final Object invokeSuspend(Object obj) {
                this.f = obj;
                this.h |= Integer.MIN_VALUE;
                return a.this.emit(null, this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(mp3 mp3Var, a31 a31Var) {
            this.g = mp3Var;
            this.h = a31Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // defpackage.a31
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object emit(Object obj, f30 f30Var) throws Throwable {
            C0121a c0121a;
            if (f30Var instanceof C0121a) {
                c0121a = (C0121a) f30Var;
                int i = c0121a.h;
                if ((i & Integer.MIN_VALUE) != 0) {
                    c0121a.h = i - Integer.MIN_VALUE;
                } else {
                    c0121a = new C0121a(f30Var);
                }
            }
            Object obj2 = c0121a.f;
            Object objE = kl1.e();
            int i2 = c0121a.h;
            if (i2 == 0) {
                lt3.b(obj2);
                Object objInvoke = tm0.this.g.invoke(obj);
                Object obj3 = this.g.f;
                if (obj3 != m43.a && ((Boolean) tm0.this.h.invoke(obj3, objInvoke)).booleanValue()) {
                    return fw4.a;
                }
                this.g.f = objInvoke;
                a31 a31Var = this.h;
                c0121a.h = 1;
                if (a31Var.emit(obj, c0121a) == objE) {
                    return objE;
                }
            } else {
                if (i2 != 1) {
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                lt3.b(obj2);
            }
            return fw4.a;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public tm0(z21 z21Var, Function1 function1, Function2 function2) {
        this.f = z21Var;
        this.g = function1;
        this.h = function2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.z21
    public Object collect(a31 a31Var, f30 f30Var) {
        mp3 mp3Var = new mp3();
        mp3Var.f = m43.a;
        Object objCollect = this.f.collect(new a(mp3Var, a31Var), f30Var);
        return objCollect == kl1.e() ? objCollect : fw4.a;
    }
}
