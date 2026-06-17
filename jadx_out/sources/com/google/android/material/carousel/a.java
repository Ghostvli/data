package com.google.android.material.carousel;

import android.content.Context;
import android.view.View;
import defpackage.iq;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public float a;
    public float b;

    /* JADX INFO: renamed from: com.google.android.material.carousel.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum EnumC0063a {
        CONTAINED,
        UNCONTAINED
    }

    public static int[] a(int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            iArr2[i] = iArr[i] * 2;
        }
        return iArr2;
    }

    public static float b(float f, float f2, float f3) {
        return 1.0f - ((f - f3) / (f2 - f3));
    }

    public float c() {
        return this.b;
    }

    public float d() {
        return this.a;
    }

    public EnumC0063a e() {
        return EnumC0063a.CONTAINED;
    }

    public void f(Context context) {
        float fH = this.a;
        if (fH <= 0.0f) {
            fH = b.h(context);
        }
        this.a = fH;
        float fG = this.b;
        if (fG <= 0.0f) {
            fG = b.g(context);
        }
        this.b = fG;
    }

    public abstract c g(iq iqVar, View view);

    public abstract boolean h(iq iqVar, int i);
}
