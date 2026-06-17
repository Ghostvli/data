package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bt4 {
    public static ss4 a = new ze();
    public static ThreadLocal b = new ThreadLocal();
    public static ArrayList c = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {
        public ss4 f;
        public ViewGroup g;

        /* JADX INFO: renamed from: bt4$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class C0048a extends at4 {
            public final /* synthetic */ la a;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public C0048a(la laVar) {
                this.a = laVar;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // ss4.g
            public void c(ss4 ss4Var) {
                ((ArrayList) this.a.get(a.this.g)).remove(ss4Var);
                ss4Var.T(this);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(ss4 ss4Var, ViewGroup viewGroup) {
            this.f = ss4Var;
            this.g = viewGroup;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void a() {
            this.g.getViewTreeObserver().removeOnPreDrawListener(this);
            this.g.removeOnAttachStateChangeListener(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            a();
            if (!bt4.c.remove(this.g)) {
                return true;
            }
            la laVarB = bt4.b();
            ArrayList arrayList = (ArrayList) laVarB.get(this.g);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                laVarB.put(this.g, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f);
            this.f.a(new C0048a(laVarB));
            this.f.j(this.g, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((ss4) it.next()).V(this.g);
                }
            }
            this.f.S(this.g);
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            a();
            bt4.c.remove(this.g);
            ArrayList arrayList = (ArrayList) bt4.b().get(this.g);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((ss4) it.next()).V(this.g);
                }
            }
            this.f.k(true);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void a(ViewGroup viewGroup, ss4 ss4Var) {
        if (c.contains(viewGroup) || !viewGroup.isLaidOut()) {
            return;
        }
        c.add(viewGroup);
        if (ss4Var == null) {
            ss4Var = a;
        }
        ss4 ss4VarClone = ss4Var.clone();
        d(viewGroup, ss4VarClone);
        ky3.b(viewGroup, null);
        c(viewGroup, ss4VarClone);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static la b() {
        la laVar;
        WeakReference weakReference = (WeakReference) b.get();
        if (weakReference != null && (laVar = (la) weakReference.get()) != null) {
            return laVar;
        }
        la laVar2 = new la();
        b.set(new WeakReference(laVar2));
        return laVar2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void c(ViewGroup viewGroup, ss4 ss4Var) {
        if (ss4Var == null || viewGroup == null) {
            return;
        }
        a aVar = new a(ss4Var, viewGroup);
        viewGroup.addOnAttachStateChangeListener(aVar);
        viewGroup.getViewTreeObserver().addOnPreDrawListener(aVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void d(ViewGroup viewGroup, ss4 ss4Var) {
        ArrayList arrayList = (ArrayList) b().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((ss4) it.next()).R(viewGroup);
            }
        }
        if (ss4Var != null) {
            ss4Var.j(viewGroup, true);
        }
        ky3.a(viewGroup);
    }
}
