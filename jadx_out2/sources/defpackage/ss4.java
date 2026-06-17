package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.graphics.Path;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowId;
import android.widget.ListView;
import defpackage.ss4;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ss4 implements Cloneable {
    public static final Animator[] N = new Animator[0];
    public static final int[] O = {2, 1, 3, 4};
    public static final k93 P = new a();
    public static ThreadLocal Q = new ThreadLocal();
    public g[] A;
    public f K;
    public la L;
    public ArrayList y;
    public ArrayList z;
    public String f = getClass().getName();
    public long g = -1;
    public long h = -1;
    public TimeInterpolator i = null;
    public ArrayList j = new ArrayList();
    public ArrayList k = new ArrayList();
    public ArrayList l = null;
    public ArrayList m = null;
    public ArrayList n = null;
    public ArrayList o = null;
    public ArrayList p = null;
    public ArrayList q = null;
    public ArrayList r = null;
    public ArrayList s = null;
    public ArrayList t = null;
    public ht4 u = new ht4();
    public ht4 v = new ht4();
    public et4 w = null;
    public int[] x = O;
    public boolean B = false;
    public ArrayList C = new ArrayList();
    public Animator[] D = N;
    public int E = 0;
    public boolean F = false;
    public boolean G = false;
    public ss4 H = null;
    public ArrayList I = null;
    public ArrayList J = new ArrayList();
    public k93 M = P;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends k93 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.k93
        public Path a(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends AnimatorListenerAdapter {
        public final /* synthetic */ la a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(la laVar) {
            this.a = laVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.remove(animator);
            ss4.this.C.remove(animator);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            ss4.this.C.add(animator);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends AnimatorListenerAdapter {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            ss4.this.o();
            animator.removeListener(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d {
        public View a;
        public String b;
        public gt4 c;
        public WindowId d;
        public ss4 e;
        public Animator f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(View view, String str, ss4 ss4Var, WindowId windowId, gt4 gt4Var, Animator animator) {
            this.a = view;
            this.b = str;
            this.c = gt4Var;
            this.d = windowId;
            this.e = ss4Var;
            this.f = animator;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static ArrayList a(ArrayList arrayList, Object obj) {
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            if (!arrayList.contains(obj)) {
                arrayList.add(obj);
            }
            return arrayList;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static ArrayList b(ArrayList arrayList, Object obj) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(obj);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class f {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface g {
        void a(ss4 ss4Var);

        void b(ss4 ss4Var);

        void c(ss4 ss4Var);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void d(ss4 ss4Var, boolean z) {
            c(ss4Var);
        }

        void e(ss4 ss4Var);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void f(ss4 ss4Var, boolean z) {
            a(ss4Var);
        }

        void g(ss4 ss4Var);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface h {
        public static final h a = new h() { // from class: ts4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // ss4.h
            public final void c(ss4.g gVar, ss4 ss4Var, boolean z) {
                gVar.f(ss4Var, z);
            }
        };
        public static final h b = new h() { // from class: us4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // ss4.h
            public final void c(ss4.g gVar, ss4 ss4Var, boolean z) {
                gVar.d(ss4Var, z);
            }
        };
        public static final h c = new h() { // from class: vs4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // ss4.h
            public final void c(ss4.g gVar, ss4 ss4Var, boolean z) {
                gVar.g(ss4Var);
            }
        };
        public static final h d = new h() { // from class: ws4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // ss4.h
            public final void c(ss4.g gVar, ss4 ss4Var, boolean z) {
                gVar.e(ss4Var);
            }
        };
        public static final h e = new h() { // from class: xs4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // ss4.h
            public final void c(ss4.g gVar, ss4 ss4Var, boolean z) {
                gVar.b(ss4Var);
            }
        };

        void c(g gVar, ss4 ss4Var, boolean z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean J(gt4 gt4Var, gt4 gt4Var2, String str) {
        Object obj = gt4Var.a.get(str);
        Object obj2 = gt4Var2.a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return !obj.equals(obj2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void d(ht4 ht4Var, View view, gt4 gt4Var) {
        ht4Var.a.put(view, gt4Var);
        int id = view.getId();
        if (id >= 0) {
            int iIndexOfKey = ht4Var.b.indexOfKey(id);
            SparseArray sparseArray = ht4Var.b;
            if (iIndexOfKey >= 0) {
                sparseArray.put(id, null);
            } else {
                sparseArray.put(id, view);
            }
        }
        String strF = l35.F(view);
        if (strF != null) {
            boolean zContainsKey = ht4Var.d.containsKey(strF);
            la laVar = ht4Var.d;
            if (zContainsKey) {
                laVar.put(strF, null);
            } else {
                laVar.put(strF, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (ht4Var.c.e(itemIdAtPosition) < 0) {
                    view.setHasTransientState(true);
                    ht4Var.c.h(itemIdAtPosition, view);
                    return;
                }
                View view2 = (View) ht4Var.c.d(itemIdAtPosition);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                    ht4Var.c.h(itemIdAtPosition, null);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static la z() {
        la laVar = (la) Q.get();
        if (laVar != null) {
            return laVar;
        }
        la laVar2 = new la();
        Q.set(laVar2);
        return laVar2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long A() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List B() {
        return this.j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List C() {
        return this.l;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List D() {
        return this.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List E() {
        return this.k;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String[] F() {
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public gt4 G(View view, boolean z) {
        et4 et4Var = this.w;
        if (et4Var != null) {
            return et4Var.G(view, z);
        }
        return (gt4) (z ? this.u : this.v).a.get(view);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean H(gt4 gt4Var, gt4 gt4Var2) {
        if (gt4Var != null && gt4Var2 != null) {
            String[] strArrF = F();
            if (strArrF != null) {
                for (String str : strArrF) {
                    if (J(gt4Var, gt4Var2, str)) {
                        return true;
                    }
                }
            } else {
                Iterator it = gt4Var.a.keySet().iterator();
                while (it.hasNext()) {
                    if (J(gt4Var, gt4Var2, (String) it.next())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean I(View view) {
        ArrayList arrayList;
        ArrayList arrayList2;
        int id = view.getId();
        ArrayList arrayList3 = this.n;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList arrayList4 = this.o;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList arrayList5 = this.p;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i = 0; i < size; i++) {
                if (((Class) this.p.get(i)).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.q != null && l35.F(view) != null && this.q.contains(l35.F(view))) {
            return false;
        }
        if ((this.j.size() == 0 && this.k.size() == 0 && (((arrayList = this.m) == null || arrayList.isEmpty()) && ((arrayList2 = this.l) == null || arrayList2.isEmpty()))) || this.j.contains(Integer.valueOf(id)) || this.k.contains(view)) {
            return true;
        }
        ArrayList arrayList6 = this.l;
        if (arrayList6 != null && arrayList6.contains(l35.F(view))) {
            return true;
        }
        if (this.m != null) {
            for (int i2 = 0; i2 < this.m.size(); i2++) {
                if (((Class) this.m.get(i2)).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void K(la laVar, la laVar2, SparseArray sparseArray, SparseArray sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View view2 = (View) sparseArray.valueAt(i);
            if (view2 != null && I(view2) && (view = (View) sparseArray2.get(sparseArray.keyAt(i))) != null && I(view)) {
                gt4 gt4Var = (gt4) laVar.get(view2);
                gt4 gt4Var2 = (gt4) laVar2.get(view);
                if (gt4Var != null && gt4Var2 != null) {
                    this.y.add(gt4Var);
                    this.z.add(gt4Var2);
                    laVar.remove(view2);
                    laVar2.remove(view);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void L(la laVar, la laVar2) {
        gt4 gt4Var;
        for (int size = laVar.size() - 1; size >= 0; size--) {
            View view = (View) laVar.f(size);
            if (view != null && I(view) && (gt4Var = (gt4) laVar2.remove(view)) != null && I(gt4Var.b)) {
                this.y.add((gt4) laVar.h(size));
                this.z.add(gt4Var);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void M(la laVar, la laVar2, w02 w02Var, w02 w02Var2) {
        View view;
        int iK = w02Var.k();
        for (int i = 0; i < iK; i++) {
            View view2 = (View) w02Var.l(i);
            if (view2 != null && I(view2) && (view = (View) w02Var2.d(w02Var.g(i))) != null && I(view)) {
                gt4 gt4Var = (gt4) laVar.get(view2);
                gt4 gt4Var2 = (gt4) laVar2.get(view);
                if (gt4Var != null && gt4Var2 != null) {
                    this.y.add(gt4Var);
                    this.z.add(gt4Var2);
                    laVar.remove(view2);
                    laVar2.remove(view);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void N(la laVar, la laVar2, la laVar3, la laVar4) {
        View view;
        int size = laVar3.size();
        for (int i = 0; i < size; i++) {
            View view2 = (View) laVar3.j(i);
            if (view2 != null && I(view2) && (view = (View) laVar4.get(laVar3.f(i))) != null && I(view)) {
                gt4 gt4Var = (gt4) laVar.get(view2);
                gt4 gt4Var2 = (gt4) laVar2.get(view);
                if (gt4Var != null && gt4Var2 != null) {
                    this.y.add(gt4Var);
                    this.z.add(gt4Var2);
                    laVar.remove(view2);
                    laVar2.remove(view);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void O(ht4 ht4Var, ht4 ht4Var2) {
        la laVar = new la(ht4Var.a);
        la laVar2 = new la(ht4Var2.a);
        int i = 0;
        while (true) {
            int[] iArr = this.x;
            if (i >= iArr.length) {
                c(laVar, laVar2);
                return;
            }
            int i2 = iArr[i];
            if (i2 == 1) {
                L(laVar, laVar2);
            } else if (i2 == 2) {
                N(laVar, laVar2, ht4Var.d, ht4Var2.d);
            } else if (i2 == 3) {
                K(laVar, laVar2, ht4Var.b, ht4Var2.b);
            } else if (i2 == 4) {
                M(laVar, laVar2, ht4Var.c, ht4Var2.c);
            }
            i++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void P(ss4 ss4Var, h hVar, boolean z) {
        ss4 ss4Var2 = this.H;
        if (ss4Var2 != null) {
            ss4Var2.P(ss4Var, hVar, z);
        }
        ArrayList arrayList = this.I;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        int size = this.I.size();
        g[] gVarArr = this.A;
        if (gVarArr == null) {
            gVarArr = new g[size];
        }
        this.A = null;
        g[] gVarArr2 = (g[]) this.I.toArray(gVarArr);
        for (int i = 0; i < size; i++) {
            hVar.c(gVarArr2[i], ss4Var, z);
            gVarArr2[i] = null;
        }
        this.A = gVarArr2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Q(h hVar, boolean z) {
        P(this, hVar, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void R(View view) {
        if (this.G) {
            return;
        }
        int size = this.C.size();
        Animator[] animatorArr = (Animator[]) this.C.toArray(this.D);
        this.D = N;
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = animatorArr[i];
            animatorArr[i] = null;
            animator.pause();
        }
        this.D = animatorArr;
        Q(h.d, false);
        this.F = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void S(ViewGroup viewGroup) {
        d dVar;
        this.y = new ArrayList();
        this.z = new ArrayList();
        O(this.u, this.v);
        la laVarZ = z();
        int size = laVarZ.size();
        WindowId windowId = viewGroup.getWindowId();
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = (Animator) laVarZ.f(i);
            if (animator != null && (dVar = (d) laVarZ.get(animator)) != null && dVar.a != null && windowId.equals(dVar.d)) {
                gt4 gt4Var = dVar.c;
                View view = dVar.a;
                gt4 gt4VarG = G(view, true);
                gt4 gt4VarU = u(view, true);
                if (gt4VarG == null && gt4VarU == null) {
                    gt4VarU = (gt4) this.v.a.get(view);
                }
                if ((gt4VarG != null || gt4VarU != null) && dVar.e.H(gt4Var, gt4VarU)) {
                    dVar.e.y().getClass();
                    if (animator.isRunning() || animator.isStarted()) {
                        animator.cancel();
                    } else {
                        laVarZ.remove(animator);
                    }
                }
            }
        }
        n(viewGroup, this.u, this.v, this.y, this.z);
        X();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ss4 T(g gVar) {
        ss4 ss4Var;
        ArrayList arrayList = this.I;
        if (arrayList != null) {
            if (!arrayList.remove(gVar) && (ss4Var = this.H) != null) {
                ss4Var.T(gVar);
            }
            if (this.I.size() == 0) {
                this.I = null;
            }
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ss4 U(View view) {
        this.k.remove(view);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void V(View view) {
        if (this.F) {
            if (!this.G) {
                int size = this.C.size();
                Animator[] animatorArr = (Animator[]) this.C.toArray(this.D);
                this.D = N;
                for (int i = size - 1; i >= 0; i--) {
                    Animator animator = animatorArr[i];
                    animatorArr[i] = null;
                    animator.resume();
                }
                this.D = animatorArr;
                Q(h.e, false);
            }
            this.F = false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void W(Animator animator, la laVar) {
        if (animator != null) {
            animator.addListener(new b(laVar));
            e(animator);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void X() {
        e0();
        la laVarZ = z();
        for (Animator animator : this.J) {
            if (laVarZ.containsKey(animator)) {
                e0();
                W(animator, laVarZ);
            }
        }
        this.J.clear();
        o();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ss4 Y(long j) {
        this.h = j;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Z(f fVar) {
        this.K = fVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ss4 a(g gVar) {
        if (this.I == null) {
            this.I = new ArrayList();
        }
        this.I.add(gVar);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ss4 a0(TimeInterpolator timeInterpolator) {
        this.i = timeInterpolator;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ss4 b(View view) {
        this.k.add(view);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b0(k93 k93Var) {
        if (k93Var == null) {
            this.M = P;
        } else {
            this.M = k93Var;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c(la laVar, la laVar2) {
        for (int i = 0; i < laVar.size(); i++) {
            gt4 gt4Var = (gt4) laVar.j(i);
            if (I(gt4Var.b)) {
                this.y.add(gt4Var);
                this.z.add(null);
            }
        }
        for (int i2 = 0; i2 < laVar2.size(); i2++) {
            gt4 gt4Var2 = (gt4) laVar2.j(i2);
            if (I(gt4Var2.b)) {
                this.z.add(gt4Var2);
                this.y.add(null);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c0(dt4 dt4Var) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void cancel() {
        int size = this.C.size();
        Animator[] animatorArr = (Animator[]) this.C.toArray(this.D);
        this.D = N;
        for (int i = size - 1; i >= 0; i--) {
            Animator animator = animatorArr[i];
            animatorArr[i] = null;
            animator.cancel();
        }
        this.D = animatorArr;
        Q(h.c, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ss4 d0(long j) {
        this.g = j;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e(Animator animator) {
        if (animator == null) {
            o();
            return;
        }
        if (r() >= 0) {
            animator.setDuration(r());
        }
        if (A() >= 0) {
            animator.setStartDelay(A() + animator.getStartDelay());
        }
        if (t() != null) {
            animator.setInterpolator(t());
        }
        animator.addListener(new c());
        animator.start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e0() {
        if (this.E == 0) {
            Q(h.a, false);
            this.G = false;
        }
        this.E++;
    }

    public abstract void f(gt4 gt4Var);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String f0(String str) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(getClass().getSimpleName());
        sb.append("@");
        sb.append(Integer.toHexString(hashCode()));
        sb.append(": ");
        if (this.h != -1) {
            sb.append("dur(");
            sb.append(this.h);
            sb.append(") ");
        }
        if (this.g != -1) {
            sb.append("dly(");
            sb.append(this.g);
            sb.append(") ");
        }
        if (this.i != null) {
            sb.append("interp(");
            sb.append(this.i);
            sb.append(") ");
        }
        if (this.j.size() > 0 || this.k.size() > 0) {
            sb.append("tgts(");
            if (this.j.size() > 0) {
                for (int i = 0; i < this.j.size(); i++) {
                    if (i > 0) {
                        sb.append(", ");
                    }
                    sb.append(this.j.get(i));
                }
            }
            if (this.k.size() > 0) {
                for (int i2 = 0; i2 < this.k.size(); i2++) {
                    if (i2 > 0) {
                        sb.append(", ");
                    }
                    sb.append(this.k.get(i2));
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList arrayList = this.n;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList arrayList2 = this.o;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList arrayList3 = this.p;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i = 0; i < size; i++) {
                        if (((Class) this.p.get(i)).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    gt4 gt4Var = new gt4(view);
                    if (z) {
                        i(gt4Var);
                    } else {
                        f(gt4Var);
                    }
                    gt4Var.c.add(this);
                    h(gt4Var);
                    if (z) {
                        d(this.u, view, gt4Var);
                    } else {
                        d(this.v, view, gt4Var);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList arrayList4 = this.r;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList arrayList5 = this.s;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList arrayList6 = this.t;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    if (((Class) this.t.get(i2)).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                g(viewGroup.getChildAt(i3), z);
                            }
                        }
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h(gt4 gt4Var) {
    }

    public abstract void i(gt4 gt4Var);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j(ViewGroup viewGroup, boolean z) {
        ArrayList arrayList;
        ArrayList arrayList2;
        la laVar;
        k(z);
        if ((this.j.size() > 0 || this.k.size() > 0) && (((arrayList = this.l) == null || arrayList.isEmpty()) && ((arrayList2 = this.m) == null || arrayList2.isEmpty()))) {
            for (int i = 0; i < this.j.size(); i++) {
                View viewFindViewById = viewGroup.findViewById(((Integer) this.j.get(i)).intValue());
                if (viewFindViewById != null) {
                    gt4 gt4Var = new gt4(viewFindViewById);
                    if (z) {
                        i(gt4Var);
                    } else {
                        f(gt4Var);
                    }
                    gt4Var.c.add(this);
                    h(gt4Var);
                    if (z) {
                        d(this.u, viewFindViewById, gt4Var);
                    } else {
                        d(this.v, viewFindViewById, gt4Var);
                    }
                }
            }
            for (int i2 = 0; i2 < this.k.size(); i2++) {
                View view = (View) this.k.get(i2);
                gt4 gt4Var2 = new gt4(view);
                if (z) {
                    i(gt4Var2);
                } else {
                    f(gt4Var2);
                }
                gt4Var2.c.add(this);
                h(gt4Var2);
                if (z) {
                    d(this.u, view, gt4Var2);
                } else {
                    d(this.v, view, gt4Var2);
                }
            }
        } else {
            g(viewGroup, z);
        }
        if (z || (laVar = this.L) == null) {
            return;
        }
        int size = laVar.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3.add((View) this.u.d.remove((String) this.L.f(i3)));
        }
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) arrayList3.get(i4);
            if (view2 != null) {
                this.u.d.put((String) this.L.j(i4), view2);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k(boolean z) {
        if (z) {
            this.u.a.clear();
            this.u.b.clear();
            this.u.c.a();
        } else {
            this.v.a.clear();
            this.v.b.clear();
            this.v.c.a();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: clone()Ljava/lang/Object; */
    @Override // 
    /* JADX INFO: renamed from: l */
    public ss4 clone() {
        try {
            ss4 ss4Var = (ss4) super.clone();
            ss4Var.J = new ArrayList();
            ss4Var.u = new ht4();
            ss4Var.v = new ht4();
            ss4Var.y = null;
            ss4Var.z = null;
            ss4Var.H = this;
            ss4Var.I = null;
            return ss4Var;
        } catch (CloneNotSupportedException e2) {
            wg1.a(e2);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Animator m(ViewGroup viewGroup, gt4 gt4Var, gt4 gt4Var2) {
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void n(ViewGroup viewGroup, ht4 ht4Var, ht4 ht4Var2, ArrayList arrayList, ArrayList arrayList2) {
        View view;
        Animator animator;
        gt4 gt4Var;
        View view2;
        Animator animator2;
        la laVarZ = z();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        y().getClass();
        for (int i = 0; i < size; i++) {
            gt4 gt4Var2 = (gt4) arrayList.get(i);
            gt4 gt4Var3 = (gt4) arrayList2.get(i);
            if (gt4Var2 != null && !gt4Var2.c.contains(this)) {
                gt4Var2 = null;
            }
            if (gt4Var3 != null && !gt4Var3.c.contains(this)) {
                gt4Var3 = null;
            }
            if ((gt4Var2 != null || gt4Var3 != null) && (gt4Var2 == null || gt4Var3 == null || H(gt4Var2, gt4Var3))) {
                Animator animatorM = m(viewGroup, gt4Var2, gt4Var3);
                if (animatorM != null) {
                    if (gt4Var3 != null) {
                        View view3 = gt4Var3.b;
                        String[] strArrF = F();
                        if (strArrF != null && strArrF.length > 0) {
                            gt4Var = new gt4(view3);
                            gt4 gt4Var4 = (gt4) ht4Var2.a.get(view3);
                            if (gt4Var4 != null) {
                                int i2 = 0;
                                while (i2 < strArrF.length) {
                                    Map map = gt4Var.a;
                                    String[] strArr = strArrF;
                                    String str = strArr[i2];
                                    map.put(str, gt4Var4.a.get(str));
                                    i2++;
                                    strArrF = strArr;
                                }
                            }
                            int size2 = laVarZ.size();
                            int i3 = 0;
                            while (true) {
                                if (i3 >= size2) {
                                    view2 = view3;
                                    animator2 = animatorM;
                                    break;
                                }
                                d dVar = (d) laVarZ.get((Animator) laVarZ.f(i3));
                                if (dVar.c != null && dVar.a == view3) {
                                    view2 = view3;
                                    if (dVar.b.equals(v()) && dVar.c.equals(gt4Var)) {
                                        animator2 = null;
                                        break;
                                    }
                                } else {
                                    view2 = view3;
                                }
                                i3++;
                                view3 = view2;
                            }
                        } else {
                            view2 = view3;
                            animator2 = animatorM;
                            gt4Var = null;
                        }
                        animator = animator2;
                        view = view2;
                    } else {
                        view = gt4Var2.b;
                        animator = animatorM;
                        gt4Var = null;
                    }
                    if (animator != null) {
                        laVarZ.put(animator, new d(view, v(), this, viewGroup.getWindowId(), gt4Var, animator));
                        this.J.add(animator);
                    }
                }
            }
        }
        if (sparseIntArray.size() != 0) {
            for (int i4 = 0; i4 < sparseIntArray.size(); i4++) {
                d dVar2 = (d) laVarZ.get((Animator) this.J.get(sparseIntArray.keyAt(i4)));
                dVar2.f.setStartDelay((((long) sparseIntArray.valueAt(i4)) - Long.MAX_VALUE) + dVar2.f.getStartDelay());
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void o() {
        int i = this.E - 1;
        this.E = i;
        if (i == 0) {
            Q(h.b, false);
            for (int i2 = 0; i2 < this.u.c.k(); i2++) {
                View view = (View) this.u.c.l(i2);
                if (view != null) {
                    view.setHasTransientState(false);
                }
            }
            for (int i3 = 0; i3 < this.v.c.k(); i3++) {
                View view2 = (View) this.v.c.l(i3);
                if (view2 != null) {
                    view2.setHasTransientState(false);
                }
            }
            this.G = true;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ss4 p(Class cls, boolean z) {
        this.p = q(this.p, cls, z);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ArrayList q(ArrayList arrayList, Class cls, boolean z) {
        return cls != null ? z ? e.a(arrayList, cls) : e.b(arrayList, cls) : arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long r() {
        return this.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public f s() {
        return this.K;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public TimeInterpolator t() {
        return this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return f0("");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x002d, code lost:
    
        if (r3 < 0) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x002f, code lost:
    
        if (r7 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0031, code lost:
    
        r5 = r5.z;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0034, code lost:
    
        r5 = r5.y;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x003c, code lost:
    
        return (defpackage.gt4) r5.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x003d, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public gt4 u(View view, boolean z) {
        et4 et4Var = this.w;
        if (et4Var != null) {
            return et4Var.u(view, z);
        }
        ArrayList arrayList = z ? this.y : this.z;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            gt4 gt4Var = (gt4) arrayList.get(i);
            if (gt4Var == null) {
                return null;
            }
            if (gt4Var.b == view) {
                break;
            }
            i++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String v() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public k93 w() {
        return this.M;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public dt4 x() {
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ss4 y() {
        et4 et4Var = this.w;
        return et4Var != null ? et4Var.y() : this;
    }
}
