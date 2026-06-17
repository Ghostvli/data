package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.graphics.Rect;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import defpackage.oh0;
import defpackage.ub4;
import defpackage.v51;
import defpackage.wp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class oh0 extends ub4 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends b {
        public final boolean c;
        public boolean d;
        public v51.a e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ub4.c cVar, wp wpVar, boolean z) {
            super(cVar, wpVar);
            cVar.getClass();
            wpVar.getClass();
            this.c = z;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final v51.a e(Context context) {
            context.getClass();
            if (this.d) {
                return this.e;
            }
            v51.a aVarB = v51.b(context, b().g(), b().f() == ub4.c.b.VISIBLE, this.c);
            this.e = aVarB;
            this.d = true;
            return aVarB;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public final ub4.c a;
        public final wp b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(ub4.c cVar, wp wpVar) {
            cVar.getClass();
            wpVar.getClass();
            this.a = cVar;
            this.b = wpVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void a() {
            this.a.e(this.b);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final ub4.c b() {
            return this.a;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final wp c() {
            return this.b;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean d() {
            ub4.c.b.a aVar = ub4.c.b.f;
            View view = this.a.g().N;
            view.getClass();
            ub4.c.b bVarA = aVar.a(view);
            ub4.c.b bVarF = this.a.f();
            if (bVarA == bVarF) {
                return true;
            }
            ub4.c.b bVar = ub4.c.b.VISIBLE;
            return (bVarA == bVar || bVarF == bVar) ? false : true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends b {
        public final Object c;
        public final boolean d;
        public final Object e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ub4.c cVar, wp wpVar, boolean z, boolean z2) {
            Object objT0;
            super(cVar, wpVar);
            cVar.getClass();
            wpVar.getClass();
            ub4.c.b bVarF = cVar.f();
            ub4.c.b bVar = ub4.c.b.VISIBLE;
            if (bVarF == bVar) {
                p51 p51VarG = cVar.g();
                objT0 = z ? p51VarG.r0() : p51VarG.W();
            } else {
                p51 p51VarG2 = cVar.g();
                objT0 = z ? p51VarG2.t0() : p51VarG2.Z();
            }
            this.c = objT0;
            this.d = cVar.f() == bVar ? z ? cVar.g().Q() : cVar.g().P() : true;
            this.e = z2 ? z ? cVar.g().v0() : cVar.g().u0() : null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final g71 e() {
            g71 g71VarF = f(this.c);
            g71 g71VarF2 = f(this.e);
            if (g71VarF == null || g71VarF2 == null || g71VarF == g71VarF2) {
                return g71VarF == null ? g71VarF2 : g71VarF;
            }
            StringBuilder sb = new StringBuilder("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
            sb.append(b().g());
            sb.append(" returned Transition ");
            sb.append(this.c);
            Object obj = this.e;
            sb.append(" which uses a different Transition  type than its shared element transition ");
            sb.append(obj);
            throw new IllegalArgumentException(sb.toString().toString());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final g71 f(Object obj) {
            if (obj == null) {
                return null;
            }
            g71 g71Var = e71.b;
            if (g71Var != null && g71Var.e(obj)) {
                return g71Var;
            }
            g71 g71Var2 = e71.c;
            if (g71Var2 != null && g71Var2.e(obj)) {
                return g71Var2;
            }
            StringBuilder sb = new StringBuilder("Transition ");
            sb.append(obj);
            p51 p51VarG = b().g();
            sb.append(" for fragment ");
            sb.append(p51VarG);
            sb.append(" is not a valid framework Transition or AndroidX Transition");
            throw new IllegalArgumentException(sb.toString());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Object g() {
            return this.e;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Object h() {
            return this.c;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean i() {
            return this.e != null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean j() {
            return this.d;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends tr1 implements Function1 {
        public final /* synthetic */ Collection g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Collection collection) {
            super(1);
            this.g = collection;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Map.Entry entry) {
            entry.getClass();
            return Boolean.valueOf(ww.E(this.g, l35.F((View) entry.getValue())));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e extends AnimatorListenerAdapter {
        public final /* synthetic */ View b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ ub4.c d;
        public final /* synthetic */ a e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(View view, boolean z, ub4.c cVar, a aVar) {
            this.b = view;
            this.c = z;
            this.d = cVar;
            this.e = aVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            animator.getClass();
            oh0.this.o().endViewTransition(this.b);
            if (this.c) {
                ub4.c.b bVarF = this.d.f();
                View view = this.b;
                view.getClass();
                bVarF.b(view);
            }
            this.e.a();
            if (k61.K0(2)) {
                Log.v("FragmentManager", "Animator from operation " + this.d + " has ended.");
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f implements Animation.AnimationListener {
        public final /* synthetic */ ub4.c a;
        public final /* synthetic */ oh0 b;
        public final /* synthetic */ View c;
        public final /* synthetic */ a d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f(ub4.c cVar, oh0 oh0Var, View view, a aVar) {
            this.a = cVar;
            this.b = oh0Var;
            this.c = view;
            this.d = aVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void a(oh0 oh0Var, View view, a aVar) {
            oh0Var.getClass();
            aVar.getClass();
            oh0Var.o().endViewTransition(view);
            aVar.a();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            animation.getClass();
            ViewGroup viewGroupO = this.b.o();
            final oh0 oh0Var = this.b;
            final View view = this.c;
            final a aVar = this.d;
            viewGroupO.post(new Runnable() { // from class: ph0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    oh0.f.a(oh0Var, view, aVar);
                }
            });
            if (k61.K0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.a + " has ended.");
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            animation.getClass();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            animation.getClass();
            if (k61.K0(2)) {
                Log.v("FragmentManager", "Animation from operation " + this.a + " has reached onAnimationStart.");
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public oh0(ViewGroup viewGroup) {
        super(viewGroup);
        viewGroup.getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void A(g71 g71Var, View view, Rect rect) {
        g71Var.getClass();
        rect.getClass();
        g71Var.h(view, rect);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void u(List list, ub4.c cVar, oh0 oh0Var) {
        list.getClass();
        cVar.getClass();
        oh0Var.getClass();
        if (list.contains(cVar)) {
            list.remove(cVar);
            oh0Var.B(cVar);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void v(ub4.c cVar, ub4.c cVar2, boolean z, la laVar) {
        laVar.getClass();
        e71.a(cVar.g(), cVar2.g(), z, laVar, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void w(Animator animator, ub4.c cVar) {
        cVar.getClass();
        animator.end();
        if (k61.K0(2)) {
            Log.v("FragmentManager", "Animator from operation " + cVar + " has been canceled.");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void x(View view, oh0 oh0Var, a aVar, ub4.c cVar) {
        oh0Var.getClass();
        aVar.getClass();
        cVar.getClass();
        view.clearAnimation();
        oh0Var.o().endViewTransition(view);
        aVar.a();
        if (k61.K0(2)) {
            Log.v("FragmentManager", "Animation from operation " + cVar + " has been cancelled.");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void y(ArrayList arrayList) {
        arrayList.getClass();
        e71.d(arrayList, 4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void z(c cVar, ub4.c cVar2) {
        cVar.getClass();
        cVar2.getClass();
        cVar.a();
        if (k61.K0(2)) {
            Log.v("FragmentManager", "Transition for operation " + cVar2 + " has completed");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void B(ub4.c cVar) {
        View view = cVar.g().N;
        ub4.c.b bVarF = cVar.f();
        view.getClass();
        bVarF.b(view);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void C(ArrayList arrayList, View view) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (x35.c(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C(arrayList, childAt);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void D(Map map, View view) {
        String strF = l35.F(view);
        if (strF != null) {
            map.put(strF, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = viewGroup.getChildAt(i);
                if (childAt.getVisibility() == 0) {
                    D(map, childAt);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void E(la laVar, Collection collection) {
        Set setEntrySet = laVar.entrySet();
        setEntrySet.getClass();
        tw.B(setEntrySet, new d(collection));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F(List list, List list2, boolean z, Map map) {
        Context context = o().getContext();
        ArrayList<a> arrayList = new ArrayList();
        Iterator it = list.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (aVar.d()) {
                aVar.a();
            } else {
                context.getClass();
                v51.a aVarE = aVar.e(context);
                if (aVarE == null) {
                    aVar.a();
                } else {
                    final Animator animator = aVarE.b;
                    if (animator == null) {
                        arrayList.add(aVar);
                    } else {
                        final ub4.c cVarB = aVar.b();
                        p51 p51VarG = cVarB.g();
                        if (il1.a(map.get(cVarB), Boolean.TRUE)) {
                            if (k61.K0(2)) {
                                Log.v("FragmentManager", "Ignoring Animator set on " + p51VarG + " as this Fragment was involved in a Transition.");
                            }
                            aVar.a();
                        } else {
                            boolean z3 = cVarB.f() == ub4.c.b.GONE;
                            if (z3) {
                                list2.remove(cVarB);
                            }
                            View view = p51VarG.N;
                            o().startViewTransition(view);
                            animator.addListener(new e(view, z3, cVarB, aVar));
                            animator.setTarget(view);
                            animator.start();
                            if (k61.K0(2)) {
                                Log.v("FragmentManager", "Animator from operation " + cVarB + " has started.");
                            }
                            aVar.c().c(new wp.a() { // from class: ih0
                                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                                @Override // wp.a
                                public final void onCancel() {
                                    oh0.w(animator, cVarB);
                                }
                            });
                            z2 = true;
                        }
                    }
                }
            }
        }
        for (final a aVar2 : arrayList) {
            final ub4.c cVarB2 = aVar2.b();
            p51 p51VarG2 = cVarB2.g();
            if (z) {
                if (k61.K0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + p51VarG2 + " as Animations cannot run alongside Transitions.");
                }
                aVar2.a();
            } else if (z2) {
                if (k61.K0(2)) {
                    Log.v("FragmentManager", "Ignoring Animation set on " + p51VarG2 + " as Animations cannot run alongside Animators.");
                }
                aVar2.a();
            } else {
                final View view2 = p51VarG2.N;
                context.getClass();
                v51.a aVarE2 = aVar2.e(context);
                if (aVarE2 == null) {
                    e04.a("Required value was null.");
                    return;
                }
                Animation animation = aVarE2.a;
                if (animation == null) {
                    e04.a("Required value was null.");
                    return;
                }
                if (cVarB2.f() != ub4.c.b.REMOVED) {
                    view2.startAnimation(animation);
                    aVar2.a();
                } else {
                    o().startViewTransition(view2);
                    v51.b bVar = new v51.b(animation, o(), view2);
                    bVar.setAnimationListener(new f(cVarB2, this, view2, aVar2));
                    view2.startAnimation(bVar);
                    if (k61.K0(2)) {
                        Log.v("FragmentManager", "Animation from operation " + cVarB2 + " has started.");
                    }
                }
                aVar2.c().c(new wp.a() { // from class: jh0
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // wp.a
                    public final void onCancel() {
                        oh0.x(view2, this, aVar2, cVarB2);
                    }
                });
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Map G(List list, List list2, final boolean z, final ub4.c cVar, ub4.c cVar2) {
        Object obj;
        View view;
        String str;
        String str2;
        ArrayList arrayList;
        Object obj2;
        View view2;
        LinkedHashMap linkedHashMap;
        ArrayList arrayList2;
        Object obj3;
        View view3;
        Object obj4;
        String str3;
        Object obj5;
        boolean z2;
        ub4.c cVar3;
        i73 i73VarA;
        int i;
        final View view4;
        oh0 oh0Var = this;
        final ub4.c cVar4 = cVar2;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj6 : list) {
            if (!((c) obj6).d()) {
                arrayList3.add(obj6);
            }
        }
        ArrayList<c> arrayList4 = new ArrayList();
        for (Object obj7 : arrayList3) {
            if (((c) obj7).e() != null) {
                arrayList4.add(obj7);
            }
        }
        final g71 g71Var = null;
        for (c cVar5 : arrayList4) {
            g71 g71VarE = cVar5.e();
            if (g71Var != null && g71VarE != g71Var) {
                StringBuilder sb = new StringBuilder("Mixing framework transitions and AndroidX transitions is not allowed. Fragment ");
                sb.append(cVar5.b().g());
                Object objH = cVar5.h();
                sb.append(" returned Transition ");
                sb.append(objH);
                sb.append(" which uses a different Transition type than other Fragments.");
                throw new IllegalArgumentException(sb.toString().toString());
            }
            g71Var = g71VarE;
        }
        if (g71Var == null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                c cVar6 = (c) it.next();
                linkedHashMap2.put(cVar6.b(), Boolean.FALSE);
                cVar6.a();
            }
        } else {
            View view5 = new View(oh0Var.o().getContext());
            final Rect rect = new Rect();
            ArrayList arrayList5 = new ArrayList();
            ArrayList arrayList6 = new ArrayList();
            la laVar = new la();
            Iterator it2 = list.iterator();
            Object obj8 = null;
            View view6 = null;
            boolean z3 = false;
            while (true) {
                obj = obj8;
                view = view6;
                str = "FragmentManager";
                if (!it2.hasNext()) {
                    break;
                }
                c cVar7 = (c) it2.next();
                if (!cVar7.i() || cVar == null || cVar4 == null) {
                    view5 = view5;
                    arrayList5 = arrayList5;
                    linkedHashMap2 = linkedHashMap2;
                    obj8 = obj;
                    view6 = view;
                    laVar = laVar;
                } else {
                    Object objU = g71Var.u(g71Var.f(cVar7.g()));
                    ArrayList arrayListW0 = cVar4.g().w0();
                    arrayListW0.getClass();
                    ArrayList arrayListW02 = cVar.g().w0();
                    arrayListW02.getClass();
                    ArrayList arrayListX0 = cVar.g().x0();
                    arrayListX0.getClass();
                    LinkedHashMap linkedHashMap3 = linkedHashMap2;
                    int size = arrayListX0.size();
                    View view7 = view5;
                    int i2 = 0;
                    while (i2 < size) {
                        int i3 = size;
                        int iIndexOf = arrayListW0.indexOf(arrayListX0.get(i2));
                        ArrayList arrayList7 = arrayListX0;
                        if (iIndexOf != -1) {
                            arrayListW0.set(iIndexOf, arrayListW02.get(i2));
                        }
                        i2++;
                        size = i3;
                        arrayListX0 = arrayList7;
                    }
                    ArrayList arrayListX02 = cVar4.g().x0();
                    arrayListX02.getClass();
                    if (z) {
                        cVar.g().X();
                        cVar4.g().a0();
                        i73VarA = fu4.a(null, null);
                    } else {
                        cVar.g().a0();
                        cVar4.g().X();
                        i73VarA = fu4.a(null, null);
                    }
                    w82.a(i73VarA.a());
                    w82.a(i73VarA.b());
                    int i4 = 0;
                    for (int size2 = arrayListW0.size(); i4 < size2; size2 = size2) {
                        laVar.put((String) arrayListW0.get(i4), (String) arrayListX02.get(i4));
                        i4++;
                    }
                    if (k61.K0(2)) {
                        Log.v("FragmentManager", ">>> entering view names <<<");
                        for (Iterator it3 = arrayListX02.iterator(); it3.hasNext(); it3 = it3) {
                            Log.v("FragmentManager", "Name: " + ((String) it3.next()));
                        }
                        Log.v("FragmentManager", ">>> exiting view names <<<");
                        for (Iterator it4 = arrayListW0.iterator(); it4.hasNext(); it4 = it4) {
                            Log.v("FragmentManager", "Name: " + ((String) it4.next()));
                        }
                    }
                    la laVar2 = new la();
                    View view8 = cVar.g().N;
                    view8.getClass();
                    oh0Var.D(laVar2, view8);
                    laVar2.o(arrayListW0);
                    laVar.o(laVar2.keySet());
                    final la laVar3 = new la();
                    View view9 = cVar4.g().N;
                    view9.getClass();
                    oh0Var.D(laVar3, view9);
                    laVar3.o(arrayListX02);
                    laVar3.o(laVar.values());
                    e71.c(laVar, laVar3);
                    Set setKeySet = laVar.keySet();
                    setKeySet.getClass();
                    oh0Var.E(laVar2, setKeySet);
                    Collection collectionValues = laVar.values();
                    collectionValues.getClass();
                    oh0Var.E(laVar3, collectionValues);
                    if (laVar.isEmpty()) {
                        arrayList5.clear();
                        arrayList6.clear();
                        view6 = view;
                        linkedHashMap2 = linkedHashMap3;
                        view5 = view7;
                        obj8 = null;
                    } else {
                        la laVar4 = laVar;
                        e71.a(cVar4.g(), cVar.g(), z, laVar2, true);
                        q63.a(oh0Var.o(), new Runnable() { // from class: kh0
                            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                            @Override // java.lang.Runnable
                            public final void run() {
                                oh0.v(cVar4, cVar, z, laVar3);
                            }
                        });
                        arrayList5.addAll(laVar2.values());
                        if (arrayListW0.isEmpty()) {
                            i = 0;
                        } else {
                            i = 0;
                            View view10 = (View) laVar2.get((String) arrayListW0.get(0));
                            g71Var.p(objU, view10);
                            view = view10;
                        }
                        arrayList6.addAll(laVar3.values());
                        if (!arrayListX02.isEmpty() && (view4 = (View) laVar3.get((String) arrayListX02.get(i))) != null) {
                            q63.a(oh0Var.o(), new Runnable() { // from class: lh0
                                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                                @Override // java.lang.Runnable
                                public final void run() {
                                    oh0.A(g71Var, view4, rect);
                                }
                            });
                            z3 = true;
                        }
                        g71Var.s(objU, view7, arrayList5);
                        g71Var.n(objU, null, null, null, null, objU, arrayList6);
                        Boolean bool = Boolean.TRUE;
                        linkedHashMap3.put(cVar, bool);
                        linkedHashMap3.put(cVar4, bool);
                        view5 = view7;
                        obj8 = objU;
                        linkedHashMap2 = linkedHashMap3;
                        view6 = view;
                        laVar = laVar4;
                        arrayList5 = arrayList5;
                    }
                }
            }
            LinkedHashMap linkedHashMap4 = linkedHashMap2;
            View view11 = view5;
            ArrayList arrayList8 = arrayList5;
            la laVar5 = laVar;
            boolean z4 = false;
            boolean z5 = true;
            ArrayList arrayList9 = new ArrayList();
            Iterator it5 = list.iterator();
            Object objK = null;
            Object objK2 = null;
            while (it5.hasNext()) {
                c cVar8 = (c) it5.next();
                if (cVar8.d()) {
                    linkedHashMap4.put(cVar8.b(), Boolean.FALSE);
                    cVar8.a();
                } else {
                    Object objF = g71Var.f(cVar8.h());
                    ub4.c cVarB = cVar8.b();
                    boolean z6 = (obj == null || !(cVarB == cVar || cVarB == cVar4)) ? z4 : true;
                    if (objF != null) {
                        LinkedHashMap linkedHashMap5 = linkedHashMap4;
                        final ArrayList arrayList10 = new ArrayList();
                        View view12 = cVarB.g().N;
                        view12.getClass();
                        oh0Var.C(arrayList10, view12);
                        if (z6) {
                            if (cVarB == cVar) {
                                arrayList10.removeAll(ww.e0(arrayList8));
                            } else {
                                arrayList10.removeAll(ww.e0(arrayList6));
                            }
                        }
                        if (arrayList10.isEmpty()) {
                            g71Var.a(objF, view11);
                            view2 = view11;
                            linkedHashMap = linkedHashMap5;
                            Object obj9 = obj;
                            arrayList2 = arrayList8;
                            obj3 = obj9;
                            obj5 = objK;
                            obj2 = objF;
                            obj4 = objK2;
                            str3 = str;
                            cVar3 = cVarB;
                            arrayList = arrayList6;
                            view3 = view;
                            z2 = true;
                        } else {
                            g71Var.b(objF, arrayList10);
                            arrayList = arrayList6;
                            Object obj10 = objK;
                            obj2 = objF;
                            view2 = view11;
                            linkedHashMap = linkedHashMap5;
                            Object obj11 = obj;
                            arrayList2 = arrayList8;
                            obj3 = obj11;
                            view3 = view;
                            obj4 = objK2;
                            str3 = str;
                            obj5 = obj10;
                            z2 = true;
                            g71Var.n(obj2, objF, arrayList10, null, null, null, null);
                            if (cVarB.f() == ub4.c.b.GONE) {
                                cVar3 = cVarB;
                                list2.remove(cVar3);
                                ArrayList arrayList11 = new ArrayList(arrayList10);
                                arrayList11.remove(cVar3.g().N);
                                g71Var.m(obj2, cVar3.g().N, arrayList11);
                                q63.a(o(), new Runnable() { // from class: mh0
                                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        oh0.y(arrayList10);
                                    }
                                });
                            } else {
                                cVar3 = cVarB;
                            }
                        }
                        if (cVar3.f() == ub4.c.b.VISIBLE) {
                            arrayList9.addAll(arrayList10);
                            if (z3) {
                                g71Var.o(obj2, rect);
                            }
                        } else {
                            g71Var.p(obj2, view3);
                        }
                        linkedHashMap.put(cVar3, Boolean.TRUE);
                        if (cVar8.j()) {
                            objK = g71Var.k(obj5, obj2, null);
                            ArrayList arrayList12 = arrayList2;
                            obj = obj3;
                            arrayList8 = arrayList12;
                            objK2 = obj4;
                            view = view3;
                            linkedHashMap4 = linkedHashMap;
                            z5 = z2;
                            arrayList6 = arrayList;
                            view11 = view2;
                            str = str3;
                            z4 = false;
                            oh0Var = this;
                        } else {
                            objK2 = g71Var.k(obj4, obj2, null);
                            ArrayList arrayList13 = arrayList2;
                            obj = obj3;
                            arrayList8 = arrayList13;
                            oh0Var = this;
                            view = view3;
                            linkedHashMap4 = linkedHashMap;
                            objK = obj5;
                            z5 = z2;
                            arrayList6 = arrayList;
                            view11 = view2;
                            str = str3;
                            z4 = false;
                        }
                        cVar4 = cVar2;
                    } else if (!z6) {
                        linkedHashMap4.put(cVarB, Boolean.FALSE);
                        cVar8.a();
                    }
                }
                z5 = true;
            }
            Object obj12 = obj;
            ArrayList arrayList14 = arrayList8;
            boolean z7 = z5;
            linkedHashMap2 = linkedHashMap4;
            String str4 = str;
            ArrayList arrayList15 = arrayList6;
            Object objJ = g71Var.j(objK, objK2, obj12);
            if (objJ != null) {
                ArrayList<c> arrayList16 = new ArrayList();
                for (Object obj13 : list) {
                    if (!((c) obj13).d()) {
                        arrayList16.add(obj13);
                    }
                }
                for (final c cVar9 : arrayList16) {
                    Object objH2 = cVar9.h();
                    final ub4.c cVarB2 = cVar9.b();
                    boolean z8 = (obj12 == null || !(cVarB2 == cVar || cVarB2 == cVar2)) ? false : z7;
                    if (objH2 == null && !z8) {
                        str2 = str4;
                    } else if (l35.N(o())) {
                        str2 = str4;
                        g71Var.q(cVar9.b().g(), objJ, cVar9.c(), new Runnable() { // from class: nh0
                            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                            @Override // java.lang.Runnable
                            public final void run() {
                                oh0.z(cVar9, cVarB2);
                            }
                        });
                    } else {
                        if (k61.K0(2)) {
                            str2 = str4;
                            Log.v(str2, "SpecialEffectsController: Container " + o() + " has not been laid out. Completing operation " + cVarB2);
                        } else {
                            str2 = str4;
                        }
                        cVar9.a();
                    }
                    str4 = str2;
                }
                String str5 = str4;
                if (l35.N(o())) {
                    e71.d(arrayList9, 4);
                    ArrayList arrayListL = g71Var.l(arrayList15);
                    if (k61.K0(2)) {
                        Log.v(str5, ">>>>> Beginning transition <<<<<");
                        Log.v(str5, ">>>>> SharedElementFirstOutViews <<<<<");
                        for (Object obj14 : arrayList14) {
                            obj14.getClass();
                            View view13 = (View) obj14;
                            Log.v(str5, "View: " + view13 + " Name: " + l35.F(view13));
                        }
                        Log.v(str5, ">>>>> SharedElementLastInViews <<<<<");
                        for (Object obj15 : arrayList15) {
                            obj15.getClass();
                            View view14 = (View) obj15;
                            Log.v(str5, "View: " + view14 + " Name: " + l35.F(view14));
                        }
                    }
                    g71Var.c(o(), objJ);
                    g71Var.r(o(), arrayList14, arrayList15, arrayListL, laVar5);
                    e71.d(arrayList9, 0);
                    g71Var.t(obj12, arrayList14, arrayList15);
                    return linkedHashMap2;
                }
            }
        }
        return linkedHashMap2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void H(List list) {
        p51 p51VarG = ((ub4.c) ww.R(list)).g();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ub4.c cVar = (ub4.c) it.next();
            cVar.g().Q.c = p51VarG.Q.c;
            cVar.g().Q.d = p51VarG.Q.d;
            cVar.g().Q.e = p51VarG.Q.e;
            cVar.g().Q.f = p51VarG.Q.f;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c8  */
    @Override // defpackage.ub4
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void h(List list, boolean z) {
        Object obj;
        Object next;
        list.getClass();
        Iterator it = list.iterator();
        while (true) {
            obj = null;
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            ub4.c cVar = (ub4.c) next;
            ub4.c.b.a aVar = ub4.c.b.f;
            View view = cVar.g().N;
            view.getClass();
            ub4.c.b bVarA = aVar.a(view);
            ub4.c.b bVar = ub4.c.b.VISIBLE;
            if (bVarA == bVar && cVar.f() != bVar) {
                break;
            }
        }
        ub4.c cVar2 = (ub4.c) next;
        ListIterator listIterator = list.listIterator(list.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                break;
            }
            Object objPrevious = listIterator.previous();
            ub4.c cVar3 = (ub4.c) objPrevious;
            ub4.c.b.a aVar2 = ub4.c.b.f;
            View view2 = cVar3.g().N;
            view2.getClass();
            ub4.c.b bVarA2 = aVar2.a(view2);
            ub4.c.b bVar2 = ub4.c.b.VISIBLE;
            if (bVarA2 != bVar2 && cVar3.f() == bVar2) {
                obj = objPrevious;
                break;
            }
        }
        ub4.c cVar4 = (ub4.c) obj;
        if (k61.K0(2)) {
            Log.v("FragmentManager", "Executing operations from " + cVar2 + " to " + cVar4);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        final List listC0 = ww.c0(list);
        H(list);
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            final ub4.c cVar5 = (ub4.c) it2.next();
            wp wpVar = new wp();
            cVar5.k(wpVar);
            arrayList.add(new a(cVar5, wpVar, z));
            wp wpVar2 = new wp();
            cVar5.k(wpVar2);
            boolean z2 = false;
            if (z) {
                if (cVar5 == cVar2) {
                    z2 = true;
                }
            } else if (cVar5 == cVar4) {
            }
            arrayList2.add(new c(cVar5, wpVar2, z, z2));
            cVar5.b(new Runnable() { // from class: hh0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    oh0.u(listC0, cVar5, this);
                }
            });
        }
        Map mapG = G(arrayList2, listC0, z, cVar2, cVar4);
        F(arrayList, listC0, mapG.containsValue(Boolean.TRUE), mapG);
        Iterator it3 = listC0.iterator();
        while (it3.hasNext()) {
            B((ub4.c) it3.next());
        }
        listC0.clear();
        if (k61.K0(2)) {
            Log.v("FragmentManager", "Completed executing operations from " + cVar2 + " to " + cVar4);
        }
    }
}
