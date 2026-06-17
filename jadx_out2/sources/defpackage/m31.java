package defpackage;

import java.util.NoSuchElementException;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class m31 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements a31 {
        public final /* synthetic */ Function2 f;
        public final /* synthetic */ mp3 g;

        /* JADX INFO: renamed from: m31$a$a, reason: collision with other inner class name */
        public static final class C0096a extends g30 {
            public Object f;
            public /* synthetic */ Object g;
            public int h;
            public Object j;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public C0096a(f30 f30Var) {
                super(f30Var);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.hh
            public final Object invokeSuspend(Object obj) {
                this.g = obj;
                this.h |= Integer.MIN_VALUE;
                return a.this.emit(null, this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(Function2 function2, mp3 mp3Var) {
            this.f = function2;
            this.g = mp3Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // defpackage.a31
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public Object emit(Object obj, f30 f30Var) throws Throwable {
            C0096a c0096a;
            if (f30Var instanceof C0096a) {
                c0096a = (C0096a) f30Var;
                int i = c0096a.h;
                if ((i & Integer.MIN_VALUE) != 0) {
                    c0096a.h = i - Integer.MIN_VALUE;
                } else {
                    c0096a = new C0096a(f30Var);
                }
            }
            Object objInvoke = c0096a.g;
            Object objE = kl1.e();
            int i2 = c0096a.h;
            if (i2 == 0) {
                lt3.b(objInvoke);
                Function2 function2 = this.f;
                c0096a.f = this;
                c0096a.j = obj;
                c0096a.h = 1;
                dk1.c(6);
                objInvoke = function2.invoke(obj, c0096a);
                dk1.c(7);
                if (objInvoke == objE) {
                    return objE;
                }
            } else {
                if (i2 != 1) {
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                obj = c0096a.j;
                this = (a) c0096a.f;
                lt3.b(objInvoke);
            }
            if (!((Boolean) objInvoke).booleanValue()) {
                return fw4.a;
            }
            this.g.f = obj;
            throw new l(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends g30 {
        public Object f;
        public Object g;
        public Object h;
        public /* synthetic */ Object i;
        public int j;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(f30 f30Var) {
            super(f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.i = obj;
            this.j |= Integer.MIN_VALUE;
            return c31.h(null, null, this);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object a(z21 z21Var, Function2 function2, f30 f30Var) throws Throwable {
        b bVar;
        Function2 function22;
        mp3 mp3Var;
        l e;
        a31 a31Var;
        if (f30Var instanceof b) {
            bVar = (b) f30Var;
            int i = bVar.j;
            if ((i & Integer.MIN_VALUE) != 0) {
                bVar.j = i - Integer.MIN_VALUE;
            } else {
                bVar = new b(f30Var);
            }
        }
        Object obj = bVar.i;
        Object objE = kl1.e();
        int i2 = bVar.j;
        if (i2 == 0) {
            lt3.b(obj);
            mp3 mp3Var2 = new mp3();
            mp3Var2.f = m43.a;
            a31 aVar = new a(function2, mp3Var2);
            try {
                bVar.f = function2;
                bVar.g = mp3Var2;
                bVar.h = aVar;
                bVar.j = 1;
                if (z21Var.collect(aVar, bVar) == objE) {
                    return objE;
                }
                function22 = function2;
                mp3Var = mp3Var2;
            } catch (l e2) {
                function22 = function2;
                mp3Var = mp3Var2;
                e = e2;
                a31Var = aVar;
                b31.a(e, a31Var);
            }
        } else {
            if (i2 != 1) {
                e04.a("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            a31Var = (a) bVar.h;
            mp3Var = (mp3) bVar.g;
            function22 = (Function2) bVar.f;
            try {
                lt3.b(obj);
            } catch (l e3) {
                e = e3;
                b31.a(e, a31Var);
            }
        }
        Object obj2 = mp3Var.f;
        if (obj2 != m43.a) {
            return obj2;
        }
        throw new NoSuchElementException("Expected at least one element matching the predicate " + function22);
    }
}
