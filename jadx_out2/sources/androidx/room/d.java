package androidx.room;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.a;
import androidx.room.b;
import androidx.room.c;
import defpackage.dm;
import defpackage.e04;
import defpackage.f30;
import defpackage.fw4;
import defpackage.kl1;
import defpackage.lt3;
import defpackage.o24;
import defpackage.oj4;
import defpackage.pw2;
import defpackage.tl;
import defpackage.u40;
import defpackage.w54;
import java.util.Arrays;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class d {
    public final String a;
    public final androidx.room.c b;
    public final Context c;
    public final u40 d;
    public final AtomicBoolean e;
    public int f;
    public androidx.room.b g;
    public final pw2 h;
    public final b i;
    public final androidx.room.a j;
    public final ServiceConnection k;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends a.AbstractBinderC0043a {

        /* JADX INFO: renamed from: androidx.room.d$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static final class C0047a extends oj4 implements Function2 {
            public Object f;
            public int g;
            public final /* synthetic */ String[] h;
            public final /* synthetic */ d i;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C0047a(String[] strArr, d dVar, f30 f30Var) {
                super(2, f30Var);
                this.h = strArr;
                this.i = dVar;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.hh
            public final f30 create(Object obj, f30 f30Var) {
                return new C0047a(this.h, this.i, f30Var);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(u40 u40Var, f30 f30Var) {
                return ((C0047a) create(u40Var, f30Var)).invokeSuspend(fw4.a);
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.hh
            public final Object invokeSuspend(Object obj) throws Throwable {
                Set set;
                Object objE = kl1.e();
                int i = this.g;
                if (i == 0) {
                    lt3.b(obj);
                    String[] strArr = this.h;
                    Set setF = o24.f(Arrays.copyOf(strArr, strArr.length));
                    pw2 pw2Var = this.i.h;
                    this.f = setF;
                    this.g = 1;
                    if (pw2Var.emit(setF, this) == objE) {
                        return objE;
                    }
                    set = setF;
                } else {
                    if (i != 1) {
                        e04.a("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    set = (Set) this.f;
                    lt3.b(obj);
                }
                this.i.h().o(set);
                return fw4.a;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.room.a
        public void w(String[] strArr) {
            strArr.getClass();
            dm.b(d.this.d, null, null, new C0047a(strArr, d.this, null), 3, null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends c.b {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(String[] strArr) {
            super(strArr);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.room.c.b
        public boolean b() {
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.room.c.b
        public void c(Set set) {
            set.getClass();
            if (d.this.e.get()) {
                return;
            }
            try {
                androidx.room.b bVar = d.this.g;
                if (bVar != null) {
                    bVar.J0(d.this.f, (String[]) set.toArray(new String[0]));
                }
            } catch (RemoteException e) {
                Log.w("ROOM", "Cannot broadcast invalidation", e);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c implements ServiceConnection {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            componentName.getClass();
            iBinder.getClass();
            d.this.g = b.a.Z0(iBinder);
            d.this.i();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            componentName.getClass();
            d.this.g = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d(Context context, String str, androidx.room.c cVar) {
        context.getClass();
        str.getClass();
        cVar.getClass();
        this.a = str;
        this.b = cVar;
        this.c = context.getApplicationContext();
        this.d = cVar.j().o();
        this.e = new AtomicBoolean(true);
        this.h = w54.a(0, 0, tl.f);
        this.i = new b(cVar.k());
        this.j = new a();
        this.k = new c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final androidx.room.c h() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i() {
        try {
            androidx.room.b bVar = this.g;
            if (bVar != null) {
                this.f = bVar.D(this.j, this.a);
            }
        } catch (RemoteException e) {
            Log.w("ROOM", "Cannot register multi-instance invalidation callback", e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j(Intent intent) {
        intent.getClass();
        if (this.e.compareAndSet(true, false)) {
            this.c.bindService(intent, this.k, 1);
            this.b.h(this.i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k() {
        if (this.e.compareAndSet(false, true)) {
            this.b.r(this.i);
            try {
                androidx.room.b bVar = this.g;
                if (bVar != null) {
                    bVar.S0(this.j, this.f);
                }
            } catch (RemoteException e) {
                Log.w("ROOM", "Cannot unregister multi-instance invalidation callback", e);
            }
            this.c.unbindService(this.k);
        }
    }
}
