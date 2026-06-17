package defpackage;

import android.os.Build;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.lifecycle.g;
import defpackage.f63;
import java.util.Iterator;
import java.util.ListIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class f63 {
    public final Runnable a;
    public final h20 b;
    public final ia c;
    public e63 d;
    public OnBackInvokedCallback e;
    public OnBackInvokedDispatcher f;
    public boolean g;
    public boolean h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends tr1 implements Function1 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
            super(1);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void a(nf nfVar) {
            nfVar.getClass();
            f63.this.m(nfVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((nf) obj);
            return fw4.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends tr1 implements Function1 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
            super(1);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void a(nf nfVar) {
            nfVar.getClass();
            f63.this.l(nfVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((nf) obj);
            return fw4.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends tr1 implements Function0 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
            super(0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void a() {
            f63.this.k();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return fw4.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends tr1 implements Function0 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d() {
            super(0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void a() {
            f63.this.j();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return fw4.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e extends tr1 implements Function0 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e() {
            super(0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void a() {
            f63.this.k();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return fw4.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f {
        public static final f a = new f();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void a(Function0 function0) {
            function0.getClass();
            function0.invoke();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final OnBackInvokedCallback b(final Function0<fw4> function0) {
            function0.getClass();
            return new OnBackInvokedCallback() { // from class: g63
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public final void onBackInvoked() {
                    f63.f.a(function0);
                }
            };
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void c(Object obj, int i, Object obj2) {
            obj.getClass();
            obj2.getClass();
            ((OnBackInvokedDispatcher) obj).registerOnBackInvokedCallback(i, (OnBackInvokedCallback) obj2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void d(Object obj, Object obj2) {
            obj.getClass();
            obj2.getClass();
            ((OnBackInvokedDispatcher) obj).unregisterOnBackInvokedCallback((OnBackInvokedCallback) obj2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class g {
        public static final g a = new g();

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class a implements OnBackAnimationCallback {
            public final /* synthetic */ Function1 a;
            public final /* synthetic */ Function1 b;
            public final /* synthetic */ Function0 c;
            public final /* synthetic */ Function0 d;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a(Function1 function1, Function1 function12, Function0 function0, Function0 function02) {
                this.a = function1;
                this.b = function12;
                this.c = function0;
                this.d = function02;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public void onBackCancelled() {
                this.d.invoke();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public void onBackInvoked() {
                this.c.invoke();
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public void onBackProgressed(BackEvent backEvent) {
                backEvent.getClass();
                this.b.invoke(new nf(backEvent));
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public void onBackStarted(BackEvent backEvent) {
                backEvent.getClass();
                this.a.invoke(new nf(backEvent));
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final OnBackInvokedCallback a(Function1<? super nf, fw4> function1, Function1<? super nf, fw4> function12, Function0<fw4> function0, Function0<fw4> function02) {
            function1.getClass();
            function12.getClass();
            function0.getClass();
            function02.getClass();
            return new a(function1, function12, function0, function02);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class h implements androidx.lifecycle.i, pp {
        public final androidx.lifecycle.g f;
        public final e63 g;
        public pp h;
        public final /* synthetic */ f63 i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public h(f63 f63Var, androidx.lifecycle.g gVar, e63 e63Var) {
            gVar.getClass();
            e63Var.getClass();
            this.i = f63Var;
            this.f = gVar;
            this.g = e63Var;
            gVar.a(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.lifecycle.i
        public void c(bt1 bt1Var, g.a aVar) {
            bt1Var.getClass();
            aVar.getClass();
            if (aVar == g.a.ON_START) {
                this.h = this.i.i(this.g);
                return;
            }
            if (aVar != g.a.ON_STOP) {
                if (aVar == g.a.ON_DESTROY) {
                    cancel();
                }
            } else {
                pp ppVar = this.h;
                if (ppVar != null) {
                    ppVar.cancel();
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.pp
        public void cancel() {
            this.f.c(this);
            this.g.i(this);
            pp ppVar = this.h;
            if (ppVar != null) {
                ppVar.cancel();
            }
            this.h = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class i implements pp {
        public final e63 f;
        public final /* synthetic */ f63 g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public i(f63 f63Var, e63 e63Var) {
            e63Var.getClass();
            this.g = f63Var;
            this.f = e63Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.pp
        public void cancel() {
            this.g.c.remove(this.f);
            if (il1.a(this.g.d, this.f)) {
                this.f.c();
                this.g.d = null;
            }
            this.f.i(this);
            Function0 function0B = this.f.b();
            if (function0B != null) {
                function0B.invoke();
            }
            this.f.k(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class j extends t81 implements Function0 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public j(Object obj) {
            super(0, obj, f63.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void e() {
            ((f63) this.receiver).p();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            e();
            return fw4.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public /* synthetic */ class k extends t81 implements Function0 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public k(Object obj) {
            super(0, obj, f63.class, "updateEnabledCallbacks", "updateEnabledCallbacks()V", 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void e() {
            ((f63) this.receiver).p();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            e();
            return fw4.a;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public f63(Runnable runnable, h20 h20Var) {
        this.a = runnable;
        this.b = h20Var;
        this.c = new ia();
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 33) {
            this.e = i2 >= 34 ? g.a.a(new a(), new b(), new c(), new d()) : f.a.b(new e());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h(bt1 bt1Var, e63 e63Var) {
        bt1Var.getClass();
        e63Var.getClass();
        androidx.lifecycle.g lifecycle = bt1Var.getLifecycle();
        if (lifecycle.b() == g.b.f) {
            return;
        }
        e63Var.a(new h(this, lifecycle, e63Var));
        p();
        e63Var.k(new j(this));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final pp i(e63 e63Var) {
        e63Var.getClass();
        this.c.add(e63Var);
        i iVar = new i(this, e63Var);
        e63Var.a(iVar);
        p();
        e63Var.k(new k(this));
        return iVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j() {
        Object objPrevious;
        ia iaVar = this.c;
        ListIterator<E> listIterator = iaVar.listIterator(iaVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            } else {
                objPrevious = listIterator.previous();
                if (((e63) objPrevious).g()) {
                    break;
                }
            }
        }
        e63 e63Var = (e63) objPrevious;
        this.d = null;
        if (e63Var != null) {
            e63Var.c();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k() {
        Object objPrevious;
        ia iaVar = this.c;
        ListIterator<E> listIterator = iaVar.listIterator(iaVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            } else {
                objPrevious = listIterator.previous();
                if (((e63) objPrevious).g()) {
                    break;
                }
            }
        }
        e63 e63Var = (e63) objPrevious;
        this.d = null;
        if (e63Var != null) {
            e63Var.d();
            return;
        }
        Runnable runnable = this.a;
        if (runnable != null) {
            runnable.run();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l(nf nfVar) {
        Object objPrevious;
        ia iaVar = this.c;
        ListIterator<E> listIterator = iaVar.listIterator(iaVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            } else {
                objPrevious = listIterator.previous();
                if (((e63) objPrevious).g()) {
                    break;
                }
            }
        }
        e63 e63Var = (e63) objPrevious;
        if (e63Var != null) {
            e63Var.e(nfVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m(nf nfVar) {
        Object objPrevious;
        ia iaVar = this.c;
        ListIterator<E> listIterator = iaVar.listIterator(iaVar.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                objPrevious = null;
                break;
            } else {
                objPrevious = listIterator.previous();
                if (((e63) objPrevious).g()) {
                    break;
                }
            }
        }
        e63 e63Var = (e63) objPrevious;
        this.d = e63Var;
        if (e63Var != null) {
            e63Var.f(nfVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        onBackInvokedDispatcher.getClass();
        this.f = onBackInvokedDispatcher;
        o(this.h);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o(boolean z) {
        OnBackInvokedDispatcher onBackInvokedDispatcher = this.f;
        OnBackInvokedCallback onBackInvokedCallback = this.e;
        if (onBackInvokedDispatcher == null || onBackInvokedCallback == null) {
            return;
        }
        if (z && !this.g) {
            f.a.c(onBackInvokedDispatcher, 0, onBackInvokedCallback);
            this.g = true;
        } else {
            if (z || !this.g) {
                return;
            }
            f.a.d(onBackInvokedDispatcher, onBackInvokedCallback);
            this.g = false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void p() {
        boolean z = this.h;
        ia iaVar = this.c;
        boolean z2 = false;
        if (iaVar == null || !iaVar.isEmpty()) {
            Iterator<E> it = iaVar.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (((e63) it.next()).g()) {
                    z2 = true;
                    break;
                }
            }
        }
        this.h = z2;
        if (z2 != z) {
            h20 h20Var = this.b;
            if (h20Var != null) {
                h20Var.accept(Boolean.valueOf(z2));
            }
            if (Build.VERSION.SDK_INT >= 33) {
                o(z2);
            }
        }
    }

    public f63(Runnable runnable) {
        this(runnable, null);
    }
}
