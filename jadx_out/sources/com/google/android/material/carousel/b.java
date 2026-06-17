package com.google.android.material.carousel;

import android.content.Context;
import com.google.android.material.carousel.c;
import defpackage.ea;
import defpackage.zk3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b {
    public static float a(float f, float f2, int i) {
        return f + (Math.max(0, i - 1) * f2);
    }

    public static float b(float f, float f2, int i) {
        return i > 0 ? f + (f2 / 2.0f) : f;
    }

    public static c c(Context context, float f, int i, ea eaVar) {
        float f2;
        float f3;
        float fMin = Math.min(f(context) + f, eaVar.f);
        float f4 = fMin / 2.0f;
        float f5 = 0.0f - f4;
        float fB = b(0.0f, eaVar.b, eaVar.c);
        float fJ = j(0.0f, a(fB, eaVar.b, (int) Math.floor(eaVar.c / 2.0f)), eaVar.b, eaVar.c);
        float fB2 = b(fJ, eaVar.e, eaVar.d);
        float fJ2 = j(fJ, a(fB2, eaVar.e, (int) Math.floor(eaVar.d / 2.0f)), eaVar.e, eaVar.d);
        float fB3 = b(fJ2, eaVar.f, eaVar.g);
        float fJ3 = j(fJ2, a(fB3, eaVar.f, eaVar.g), eaVar.f, eaVar.g);
        float fB4 = b(fJ3, eaVar.e, eaVar.d);
        float fB5 = b(j(fJ3, a(fB4, eaVar.e, (int) Math.ceil(eaVar.d / 2.0f)), eaVar.e, eaVar.d), eaVar.b, eaVar.c);
        float f6 = i + f4;
        float fB6 = a.b(fMin, eaVar.f, f);
        float fB7 = a.b(eaVar.b, eaVar.f, f);
        float fB8 = a.b(eaVar.e, eaVar.f, f);
        c.b bVarA = new c.b(eaVar.f, i).a(f5, fB6, fMin);
        if (eaVar.c > 0) {
            f2 = 2.0f;
            f3 = fB6;
            bVarA.g(fB, fB7, eaVar.b, (int) Math.floor(r7 / 2.0f));
        } else {
            f2 = 2.0f;
            f3 = fB6;
        }
        if (eaVar.d > 0) {
            bVarA.g(fB2, fB8, eaVar.e, (int) Math.floor(r4 / f2));
        }
        bVarA.h(fB3, 0.0f, eaVar.f, eaVar.g, true);
        if (eaVar.d > 0) {
            bVarA.g(fB4, fB8, eaVar.e, (int) Math.ceil(r4 / f2));
        }
        if (eaVar.c > 0) {
            bVarA.g(fB5, fB7, eaVar.b, (int) Math.ceil(r0 / f2));
        }
        bVarA.a(f6, f3, fMin);
        return bVarA.i();
    }

    public static c d(Context context, float f, int i, ea eaVar, int i2) {
        return i2 == 1 ? c(context, f, i, eaVar) : e(context, f, i, eaVar);
    }

    public static c e(Context context, float f, int i, ea eaVar) {
        float fMin = Math.min(f(context) + f, eaVar.f);
        float f2 = fMin / 2.0f;
        float f3 = 0.0f - f2;
        float fB = b(0.0f, eaVar.f, eaVar.g);
        float fJ = j(0.0f, a(fB, eaVar.f, eaVar.g), eaVar.f, eaVar.g);
        float fB2 = b(fJ, eaVar.e, eaVar.d);
        float fB3 = b(j(fJ, fB2, eaVar.e, eaVar.d), eaVar.b, eaVar.c);
        float f4 = i + f2;
        float fB4 = a.b(fMin, eaVar.f, f);
        float fB5 = a.b(eaVar.b, eaVar.f, f);
        float fB6 = a.b(eaVar.e, eaVar.f, f);
        c.b bVarH = new c.b(eaVar.f, i).a(f3, fB4, fMin).h(fB, 0.0f, eaVar.f, eaVar.g, true);
        if (eaVar.d > 0) {
            bVarH.b(fB2, fB6, eaVar.e);
        }
        int i2 = eaVar.c;
        if (i2 > 0) {
            bVarH.g(fB3, fB5, eaVar.b, i2);
        }
        bVarH.a(f4, fB4, fMin);
        return bVarH.i();
    }

    public static float f(Context context) {
        return context.getResources().getDimension(zk3.x);
    }

    public static float g(Context context) {
        return context.getResources().getDimension(zk3.y);
    }

    public static float h(Context context) {
        return context.getResources().getDimension(zk3.z);
    }

    public static int i(int[] iArr) {
        int i = Integer.MIN_VALUE;
        for (int i2 : iArr) {
            if (i2 > i) {
                i = i2;
            }
        }
        return i;
    }

    public static float j(float f, float f2, float f3, int i) {
        return i > 0 ? f2 + (f3 / 2.0f) : f;
    }
}
