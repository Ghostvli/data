package defpackage;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class v51 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int a(p51 p51Var, boolean z, boolean z2) {
        return z2 ? z ? p51Var.n0() : p51Var.p0() : z ? p51Var.V() : p51Var.Y();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0071 A[Catch: RuntimeException -> 0x0077, TRY_LEAVE, TryCatch #0 {RuntimeException -> 0x0077, blocks: (B:32:0x006b, B:34:0x0071), top: B:45:0x006b }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static a b(Context context, p51 p51Var, boolean z, boolean z2) {
        Animator animatorLoadAnimator;
        int iI0 = p51Var.i0();
        int iA = a(p51Var, z, z2);
        p51Var.d2(0, 0, 0, 0);
        ViewGroup viewGroup = p51Var.M;
        if (viewGroup != null && viewGroup.getTag(tl3.c) != null) {
            p51Var.M.setTag(tl3.c, null);
        }
        ViewGroup viewGroup2 = p51Var.M;
        if (viewGroup2 != null && viewGroup2.getLayoutTransition() != null) {
            return null;
        }
        Animation animationW0 = p51Var.W0(iI0, z, iA);
        if (animationW0 != null) {
            return new a(animationW0);
        }
        Animator animatorX0 = p51Var.X0(iI0, z, iA);
        if (animatorX0 != null) {
            return new a(animatorX0);
        }
        if (iA == 0 && iI0 != 0) {
            iA = d(context, iI0, z);
        }
        if (iA != 0) {
            boolean zEquals = "anim".equals(context.getResources().getResourceTypeName(iA));
            if (zEquals) {
                try {
                    Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, iA);
                    if (animationLoadAnimation != null) {
                        return new a(animationLoadAnimation);
                    }
                } catch (Resources.NotFoundException e) {
                    throw e;
                } catch (RuntimeException unused) {
                    try {
                        animatorLoadAnimator = AnimatorInflater.loadAnimator(context, iA);
                        if (animatorLoadAnimator != null) {
                        }
                    } catch (RuntimeException e2) {
                        if (zEquals) {
                            throw e2;
                        }
                        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, iA);
                        if (animationLoadAnimation2 != null) {
                            return new a(animationLoadAnimation2);
                        }
                    }
                }
            } else {
                animatorLoadAnimator = AnimatorInflater.loadAnimator(context, iA);
                if (animatorLoadAnimator != null) {
                    return new a(animatorLoadAnimator);
                }
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int c(Context context, int i) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(R.style.Animation.Activity, new int[]{i});
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(0, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(Animation animation, ViewGroup viewGroup, View view) {
            super(false);
            this.j = true;
            this.f = viewGroup;
            this.g = view;
            addAnimation(animation);
            viewGroup.post(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
