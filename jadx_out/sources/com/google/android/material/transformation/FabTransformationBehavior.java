package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import defpackage.e04;
import defpackage.ju2;
import defpackage.k7;
import defpackage.kt;
import defpackage.ku2;
import defpackage.o7;
import defpackage.ol3;
import defpackage.zf3;
import java.util.ArrayList;
import java.util.List;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {
    public final Rect h;
    public final RectF i;
    public final RectF j;
    public final int[] k;
    public float l;
    public float m;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ View b;
        public final /* synthetic */ View c;

        public a(boolean z, View view, View view2) {
            this.a = z;
            this.b = view;
            this.c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            this.b.setVisibility(4);
            this.c.setAlpha(1.0f);
            this.c.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.a) {
                this.b.setVisibility(0);
                this.c.setAlpha(0.0f);
                this.c.setVisibility(4);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public ju2 a;
        public zf3 b;
    }

    public FabTransformationBehavior() {
        this.h = new Rect();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new int[2];
    }

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    public AnimatorSet P(View view, View view2, boolean z, boolean z2) {
        b bVarF0 = f0(view2.getContext(), z);
        if (z) {
            this.l = view.getTranslationX();
            this.m = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        b0(view, view2, z, z2, bVarF0, arrayList, arrayList2);
        RectF rectF = this.i;
        e0(view, view2, z, z2, bVarF0, arrayList, arrayList2, rectF);
        float fWidth = rectF.width();
        float fHeight = rectF.height();
        a0(view, view2, z, bVarF0, arrayList);
        d0(view, view2, z, z2, bVarF0, arrayList, arrayList2);
        c0(view, view2, z, z2, bVarF0, fWidth, fHeight, arrayList, arrayList2);
        Z(view, view2, z, z2, bVarF0, arrayList, arrayList2);
        Y(view, view2, z, z2, bVarF0, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        o7.a(animatorSet, arrayList);
        animatorSet.addListener(new a(z, view2, view));
        int size = arrayList2.size();
        for (int i = 0; i < size; i++) {
            animatorSet.addListener((Animator.AnimatorListener) arrayList2.get(i));
        }
        return animatorSet;
    }

    public final ViewGroup Q(View view) {
        View viewFindViewById = view.findViewById(ol3.f);
        return viewFindViewById != null ? g0(viewFindViewById) : g0(view);
    }

    public final void R(View view, b bVar, ku2 ku2Var, ku2 ku2Var2, float f, float f2, float f3, float f4, RectF rectF) {
        float fW = W(bVar, ku2Var, f, f3);
        float fW2 = W(bVar, ku2Var2, f2, f4);
        Rect rect = this.h;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.i;
        rectF2.set(rect);
        RectF rectF3 = this.j;
        X(view, rectF3);
        rectF3.offset(fW, fW2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    public final void S(View view, RectF rectF) {
        X(view, rectF);
        rectF.offset(this.l, this.m);
    }

    public final Pair T(float f, float f2, boolean z, b bVar) {
        ku2 ku2VarE;
        ku2 ku2VarE2;
        if (f == 0.0f || f2 == 0.0f) {
            ku2VarE = bVar.a.e("translationXLinear");
            ku2VarE2 = bVar.a.e("translationYLinear");
        } else if ((!z || f2 >= 0.0f) && (z || f2 <= 0.0f)) {
            ku2VarE = bVar.a.e("translationXCurveDownwards");
            ku2VarE2 = bVar.a.e("translationYCurveDownwards");
        } else {
            ku2VarE = bVar.a.e("translationXCurveUpwards");
            ku2VarE2 = bVar.a.e("translationYCurveUpwards");
        }
        return new Pair(ku2VarE, ku2VarE2);
    }

    public final float U(View view, View view2, zf3 zf3Var) {
        float fCenterX;
        float fCenterX2;
        float f;
        RectF rectF = this.i;
        RectF rectF2 = this.j;
        S(view, rectF);
        X(view2, rectF2);
        int i = zf3Var.a & 7;
        if (i == 1) {
            fCenterX = rectF2.centerX();
            fCenterX2 = rectF.centerX();
        } else if (i == 3) {
            fCenterX = rectF2.left;
            fCenterX2 = rectF.left;
        } else {
            if (i != 5) {
                f = 0.0f;
                return f + zf3Var.b;
            }
            fCenterX = rectF2.right;
            fCenterX2 = rectF.right;
        }
        f = fCenterX - fCenterX2;
        return f + zf3Var.b;
    }

    public final float V(View view, View view2, zf3 zf3Var) {
        float fCenterY;
        float fCenterY2;
        float f;
        RectF rectF = this.i;
        RectF rectF2 = this.j;
        S(view, rectF);
        X(view2, rectF2);
        int i = zf3Var.a & Token.ASSIGN_MOD;
        if (i == 16) {
            fCenterY = rectF2.centerY();
            fCenterY2 = rectF.centerY();
        } else if (i == 48) {
            fCenterY = rectF2.top;
            fCenterY2 = rectF.top;
        } else {
            if (i != 80) {
                f = 0.0f;
                return f + zf3Var.c;
            }
            fCenterY = rectF2.bottom;
            fCenterY2 = rectF.bottom;
        }
        f = fCenterY - fCenterY2;
        return f + zf3Var.c;
    }

    public final float W(b bVar, ku2 ku2Var, float f, float f2) {
        long jC = ku2Var.c();
        long jD = ku2Var.d();
        ku2 ku2VarE = bVar.a.e("expansion");
        return k7.a(f, f2, ku2Var.e().getInterpolation((((ku2VarE.c() + ku2VarE.d()) + 17) - jC) / jD));
    }

    public final void X(View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        view.getLocationInWindow(this.k);
        rectF.offsetTo(r3[0], r3[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    public final void Y(View view, View view2, boolean z, boolean z2, b bVar, List list, List list2) {
        ViewGroup viewGroupQ;
        ObjectAnimator objectAnimatorOfFloat;
        if ((view2 instanceof ViewGroup) && (viewGroupQ = Q(view2)) != null) {
            if (z) {
                if (!z2) {
                    kt.a.set(viewGroupQ, Float.valueOf(0.0f));
                }
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupQ, (Property<ViewGroup, Float>) kt.a, 1.0f);
            } else {
                objectAnimatorOfFloat = ObjectAnimator.ofFloat(viewGroupQ, (Property<ViewGroup, Float>) kt.a, 0.0f);
            }
            bVar.a.e("contentFade").a(objectAnimatorOfFloat);
            list.add(objectAnimatorOfFloat);
        }
    }

    public final void Z(View view, View view2, boolean z, boolean z2, b bVar, List list, List list2) {
    }

    public final void a0(View view, View view2, boolean z, b bVar, List list) {
        float fU = U(view, view2, bVar.b);
        float fV = V(view, view2, bVar.b);
        Pair pairT = T(fU, fV, z, bVar);
        ku2 ku2Var = (ku2) pairT.first;
        ku2 ku2Var2 = (ku2) pairT.second;
        Property property = View.TRANSLATION_X;
        if (!z) {
            fU = this.l;
        }
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, (Property<View, Float>) property, fU);
        Property property2 = View.TRANSLATION_Y;
        if (!z) {
            fV = this.m;
        }
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view, (Property<View, Float>) property2, fV);
        ku2Var.a(objectAnimatorOfFloat);
        ku2Var2.a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    public final void b0(View view, View view2, boolean z, boolean z2, b bVar, List list, List list2) {
        ObjectAnimator objectAnimatorOfFloat;
        float elevation = view2.getElevation() - view.getElevation();
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-elevation);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, 0.0f);
        } else {
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Z, -elevation);
        }
        bVar.a.e("elevation").a(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat);
    }

    public final void c0(View view, View view2, boolean z, boolean z2, b bVar, float f, float f2, List list, List list2) {
    }

    public final void d0(View view, View view2, boolean z, boolean z2, b bVar, List list, List list2) {
    }

    public final void e0(View view, View view2, boolean z, boolean z2, b bVar, List list, List list2, RectF rectF) {
        ku2 ku2Var;
        ku2 ku2Var2;
        ObjectAnimator objectAnimatorOfFloat;
        ObjectAnimator objectAnimatorOfFloat2;
        float fU = U(view, view2, bVar.b);
        float fV = V(view, view2, bVar.b);
        Pair pairT = T(fU, fV, z, bVar);
        ku2 ku2Var3 = (ku2) pairT.first;
        ku2 ku2Var4 = (ku2) pairT.second;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-fU);
                view2.setTranslationY(-fV);
            }
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, 0.0f);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, 0.0f);
            ku2Var = ku2Var4;
            ku2Var2 = ku2Var3;
            R(view2, bVar, ku2Var2, ku2Var, -fU, -fV, 0.0f, 0.0f, rectF);
        } else {
            ku2Var = ku2Var4;
            ku2Var2 = ku2Var3;
            objectAnimatorOfFloat = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_X, -fU);
            objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(view2, (Property<View, Float>) View.TRANSLATION_Y, -fV);
        }
        ku2Var2.a(objectAnimatorOfFloat);
        ku2Var.a(objectAnimatorOfFloat2);
        list.add(objectAnimatorOfFloat);
        list.add(objectAnimatorOfFloat2);
    }

    public abstract b f0(Context context, boolean z);

    public final ViewGroup g0(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public boolean k(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (view.getVisibility() == 8) {
            e04.a("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
            return false;
        }
        if (!(view2 instanceof FloatingActionButton)) {
            return false;
        }
        int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
        return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.c
    public void m(CoordinatorLayout.f fVar) {
        if (fVar.h == 0) {
            fVar.h = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = new Rect();
        this.i = new RectF();
        this.j = new RectF();
        this.k = new int[2];
    }
}
