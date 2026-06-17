package defpackage;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class nv0 {
    public static final a c = new a(null);
    public static final Map d = new LinkedHashMap();
    public final ReentrantLock a;
    public final n01 b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public nv0(String str, boolean z) {
        str.getClass();
        a aVar = c;
        this.a = aVar.d(str);
        this.b = z ? aVar.c(str) : null;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IGET]}, finally: {[IGET, INVOKE, IF] complete} */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 3, expect 1 */
    public final Object b(Function0 function0, Function1 function1) {
        function0.getClass();
        function1.getClass();
        this.a.lock();
        boolean z = false;
        try {
            n01 n01Var = this.b;
            if (n01Var != null) {
                n01Var.a();
            }
            z = true;
            try {
                Object objInvoke = function0.invoke();
                this.a.unlock();
                return objInvoke;
            } finally {
                n01 n01Var2 = this.b;
                if (n01Var2 != null) {
                    n01Var2.b();
                }
            }
        } catch (Throwable th) {
            try {
                if (z) {
                    throw th;
                }
                function1.invoke(th);
                throw new kr1();
            } catch (Throwable th2) {
                this.a.unlock();
                throw th2;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: nv0.a.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final n01 c(String str) {
            return new n01(str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final ReentrantLock d(String str) {
            ReentrantLock reentrantLock;
            synchronized (this) {
                try {
                    Map map = nv0.d;
                    Object reentrantLock2 = map.get(str);
                    if (reentrantLock2 == null) {
                        reentrantLock2 = new ReentrantLock();
                        map.put(str, reentrantLock2);
                    }
                    reentrantLock = (ReentrantLock) reentrantLock2;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return reentrantLock;
        }

        public a() {
        }
    }
}
