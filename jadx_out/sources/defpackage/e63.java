package defpackage;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e63 {
    public boolean a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    public Function0 c;

    public e63(boolean z) {
        this.a = z;
    }

    public final void a(pp ppVar) {
        ppVar.getClass();
        this.b.add(ppVar);
    }

    public final Function0 b() {
        return this.c;
    }

    public void c() {
    }

    public abstract void d();

    public void e(nf nfVar) {
        nfVar.getClass();
    }

    public void f(nf nfVar) {
        nfVar.getClass();
    }

    public final boolean g() {
        return this.a;
    }

    public final void h() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((pp) it.next()).cancel();
        }
    }

    public final void i(pp ppVar) {
        ppVar.getClass();
        this.b.remove(ppVar);
    }

    public final void j(boolean z) {
        this.a = z;
        Function0 function0 = this.c;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void k(Function0 function0) {
        this.c = function0;
    }
}
