package defpackage;

import android.R;
import android.animation.Animator;
import android.content.Context;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class v51 {
    public static int a(p51 p51Var, boolean z, boolean z2) {
        return z2 ? z ? p51Var.n0() : p51Var.p0() : z ? p51Var.V() : p51Var.Y();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x0071 A[Catch: RuntimeException -> 0x0077, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0077, blocks: (B:32:0x006b, B:34:0x0071), top: B:45:0x006b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static v51.a b(android.content.Context r4, defpackage.p51 r5, boolean r6, boolean r7) {
        /*
            int r0 = r5.i0()
            int r7 = a(r5, r6, r7)
            r1 = 0
            r5.d2(r1, r1, r1, r1)
            android.view.ViewGroup r1 = r5.M
            r2 = 0
            if (r1 == 0) goto L20
            int r3 = defpackage.tl3.c
            java.lang.Object r1 = r1.getTag(r3)
            if (r1 == 0) goto L20
            android.view.ViewGroup r1 = r5.M
            int r3 = defpackage.tl3.c
            r1.setTag(r3, r2)
        L20:
            android.view.ViewGroup r1 = r5.M
            if (r1 == 0) goto L2b
            android.animation.LayoutTransition r1 = r1.getLayoutTransition()
            if (r1 == 0) goto L2b
            return r2
        L2b:
            android.view.animation.Animation r1 = r5.W0(r0, r6, r7)
            if (r1 == 0) goto L37
            v51$a r4 = new v51$a
            r4.<init>(r1)
            return r4
        L37:
            android.animation.Animator r5 = r5.X0(r0, r6, r7)
            if (r5 == 0) goto L43
            v51$a r4 = new v51$a
            r4.<init>(r5)
            return r4
        L43:
            if (r7 != 0) goto L4b
            if (r0 == 0) goto L4b
            int r7 = d(r4, r0, r6)
        L4b:
            if (r7 == 0) goto L87
            android.content.res.Resources r5 = r4.getResources()
            java.lang.String r5 = r5.getResourceTypeName(r7)
            java.lang.String r6 = "anim"
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L6b
            android.view.animation.Animation r6 = android.view.animation.AnimationUtils.loadAnimation(r4, r7)     // Catch: android.content.res.Resources.NotFoundException -> L69 java.lang.RuntimeException -> L6b
            if (r6 == 0) goto L87
            v51$a r0 = new v51$a     // Catch: android.content.res.Resources.NotFoundException -> L69 java.lang.RuntimeException -> L6b
            r0.<init>(r6)     // Catch: android.content.res.Resources.NotFoundException -> L69 java.lang.RuntimeException -> L6b
            return r0
        L69:
            r4 = move-exception
            throw r4
        L6b:
            android.animation.Animator r6 = android.animation.AnimatorInflater.loadAnimator(r4, r7)     // Catch: java.lang.RuntimeException -> L77
            if (r6 == 0) goto L87
            v51$a r0 = new v51$a     // Catch: java.lang.RuntimeException -> L77
            r0.<init>(r6)     // Catch: java.lang.RuntimeException -> L77
            return r0
        L77:
            r6 = move-exception
            if (r5 != 0) goto L86
            android.view.animation.Animation r4 = android.view.animation.AnimationUtils.loadAnimation(r4, r7)
            if (r4 == 0) goto L87
            v51$a r5 = new v51$a
            r5.<init>(r4)
            return r5
        L86:
            throw r6
        L87:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v51.b(android.content.Context, p51, boolean, boolean):v51$a");
    }

    public static int c(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static int d(Context context, int i, boolean z) {
        if (i == 4097) {
            return z ? bk3.e : bk3.f;
        }
        if (i == 8194) {
            return z ? bk3.a : bk3.b;
        }
        if (i == 8197) {
            return z ? c(context, R.attr.activityCloseEnterAnimation) : c(context, R.attr.activityCloseExitAnimation);
        }
        if (i == 4099) {
            return z ? bk3.c : bk3.d;
        }
        if (i != 4100) {
            return -1;
        }
        return z ? c(context, R.attr.activityOpenEnterAnimation) : c(context, R.attr.activityOpenExitAnimation);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public final Animation a;
        public final Animator b;

        public a(Animation animation) {
            this.a = animation;
            this.b = null;
            if (animation != null) {
                return;
            }
            e04.a("Animation cannot be null");
            throw null;
        }

        public a(Animator animator) {
            this.a = null;
            this.b = animator;
            if (animator != null) {
                return;
            }
            e04.a("Animator cannot be null");
            throw null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b extends AnimationSet implements Runnable {
        public final ViewGroup f;
        public final View g;
        public boolean h;
        public boolean i;
        public boolean j;

        public b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.j = true;
            this.f = viewGroup;
            this.g = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        @Override // android.view.animation.AnimationSet, android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation) {
            this.j = true;
            if (this.h) {
                return !this.i;
            }
            if (!super.getTransformation(j, transformation)) {
                this.h = true;
                q63.a(this.f, this);
            }
            return true;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.h || !this.j) {
                this.f.endViewTransition(this.g);
                this.i = true;
            } else {
                this.j = false;
                this.f.post(this);
            }
        }

        @Override // android.view.animation.Animation
        public boolean getTransformation(long j, Transformation transformation, float f) {
            this.j = true;
            if (this.h) {
                return !this.i;
            }
            if (!super.getTransformation(j, transformation, f)) {
                this.h = true;
                q63.a(this.f, this);
            }
            return true;
        }
    }
}
