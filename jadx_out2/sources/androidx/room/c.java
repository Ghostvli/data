package androidx.room;

import android.content.Context;
import android.content.Intent;
import androidx.room.c;
import defpackage.bu3;
import defpackage.cw3;
import defpackage.e04;
import defpackage.f30;
import defpackage.fw4;
import defpackage.i73;
import defpackage.kl1;
import defpackage.lt3;
import defpackage.lw3;
import defpackage.mt4;
import defpackage.oj4;
import defpackage.pe;
import defpackage.ql1;
import defpackage.t81;
import defpackage.u40;
import defpackage.we0;
import defpackage.ww;
import defpackage.y42;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class c {
    public static final a o = new a(null);
    public final bu3 a;
    public final Map b;
    public final Map c;
    public final String[] d;
    public final mt4 e;
    public final Map f;
    public final ReentrantLock g;
    public pe h;
    public final Function0 i;
    public final Function0 j;
    public final ql1 k;
    public Intent l;
    public androidx.room.d m;
    public final Object n;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class b {
        public final String[] a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(String[] strArr) {
            strArr.getClass();
            this.a = strArr;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final String[] a() {
            return this.a;
        }

        public abstract boolean b();

        public abstract void c(Set set);
    }

    /* JADX INFO: renamed from: androidx.room.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final /* synthetic */ class C0046c extends t81 implements Function1 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public C0046c(Object obj) {
            super(1, obj, c.class, "notifyInvalidatedObservers", "notifyInvalidatedObservers(Ljava/util/Set;)V", 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void e(Set set) {
            set.getClass();
            ((c) this.receiver).n(set);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            e((Set) obj);
            return fw4.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends oj4 implements Function2 {
        public int f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(f30 f30Var) {
            super(2, f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            return c.this.new d(f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((d) create(u40Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objE = kl1.e();
            int i = this.f;
            if (i == 0) {
                lt3.b(obj);
                mt4 mt4Var = c.this.e;
                this.f = 1;
                if (mt4Var.s(this) == objE) {
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
    public static final /* synthetic */ class e extends t81 implements Function0 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(Object obj) {
            super(0, obj, c.class, "onAutoCloseCallback", "onAutoCloseCallback()V", 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void e() {
            ((c) this.receiver).p();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            e();
            return fw4.a;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public c(bu3 bu3Var, Map map, Map map2, String... strArr) {
        bu3Var.getClass();
        map.getClass();
        map2.getClass();
        strArr.getClass();
        this.a = bu3Var;
        this.b = map;
        this.c = map2;
        this.d = strArr;
        mt4 mt4Var = new mt4(bu3Var, map, map2, strArr, bu3Var.y(), new C0046c(this));
        this.e = mt4Var;
        this.f = new LinkedHashMap();
        this.g = new ReentrantLock();
        this.i = new Function0() { // from class: rl1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return c.c(this.f);
            }
        };
        this.j = new Function0() { // from class: sl1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return c.a(this.f);
            }
        };
        this.k = new ql1(bu3Var);
        this.n = new Object();
        mt4Var.p(new Function0() { // from class: tl1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return Boolean.valueOf(c.b(this.f));
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fw4 a(c cVar) {
        pe peVar = cVar.h;
        if (peVar != null) {
            peVar.f();
        }
        return fw4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean b(c cVar) {
        return !cVar.a.z() || cVar.a.E();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fw4 c(c cVar) {
        pe peVar = cVar.h;
        if (peVar != null) {
            peVar.i();
        }
        return fw4.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean g(b bVar) {
        i73 i73VarT = this.e.t(bVar.a());
        String[] strArr = (String[]) i73VarT.a();
        int[] iArr = (int[]) i73VarT.b();
        androidx.room.e eVar = new androidx.room.e(bVar, iArr, strArr);
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            boolean zContainsKey = this.f.containsKey(bVar);
            Map map = this.f;
            androidx.room.e eVar2 = zContainsKey ? (androidx.room.e) y42.i(map, bVar) : (androidx.room.e) map.put(bVar, eVar);
            reentrantLock.unlock();
            return eVar2 == null && this.e.k(iArr);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h(b bVar) {
        bVar.getClass();
        if (bVar.b()) {
            g(bVar);
        } else {
            e04.a("isRemote was false of observer argument");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final List i() {
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            return ww.a0(this.f.keySet());
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final bu3 j() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String[] k() {
        return this.d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l(Context context, String str, Intent intent) {
        context.getClass();
        str.getClass();
        intent.getClass();
        this.l = intent;
        this.m = new androidx.room.d(context, str, this);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m(lw3 lw3Var) {
        lw3Var.getClass();
        this.e.i(lw3Var);
        synchronized (this.n) {
            try {
                androidx.room.d dVar = this.m;
                if (dVar != null) {
                    Intent intent = this.l;
                    if (intent == null) {
                        throw new IllegalStateException("Required value was null.");
                    }
                    dVar.j(intent);
                    fw4 fw4Var = fw4.a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n(Set set) {
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            List listA0 = ww.a0(this.f.values());
            reentrantLock.unlock();
            Iterator it = listA0.iterator();
            while (it.hasNext()) {
                ((androidx.room.e) it.next()).c(set);
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o(Set set) {
        set.getClass();
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            List<androidx.room.e> listA0 = ww.a0(this.f.values());
            reentrantLock.unlock();
            for (androidx.room.e eVar : listA0) {
                if (!eVar.a().b()) {
                    eVar.d(set);
                }
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void p() {
        synchronized (this.n) {
            try {
                androidx.room.d dVar = this.m;
                if (dVar != null) {
                    List listI = i();
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : listI) {
                        if (!((b) obj).b()) {
                            arrayList.add(obj);
                        }
                    }
                    if (arrayList.isEmpty()) {
                        dVar.k();
                    }
                }
                this.e.n();
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q() {
        this.e.m(this.i, this.j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void r(b bVar) {
        bVar.getClass();
        if (s(bVar)) {
            cw3.a(new d(null));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean s(b bVar) {
        ReentrantLock reentrantLock = this.g;
        reentrantLock.lock();
        try {
            androidx.room.e eVar = (androidx.room.e) this.f.remove(bVar);
            return eVar != null && this.e.l(eVar.b());
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void t(pe peVar) {
        peVar.getClass();
        this.h = peVar;
        peVar.m(new e(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u() {
        androidx.room.d dVar = this.m;
        if (dVar != null) {
            dVar.k();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Object v(f30 f30Var) throws Throwable {
        Object objS = this.e.s(f30Var);
        return objS == kl1.e() ? objS : fw4.a;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: androidx.room.c.a.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        public a() {
        }
    }
}
