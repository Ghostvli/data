package com.google.android.material.textview;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import defpackage.cn3;
import defpackage.k62;
import defpackage.k9;
import defpackage.mk3;
import defpackage.o62;
import defpackage.p52;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class MaterialTextView extends k9 {
    public MaterialTextView(Context context, AttributeSet attributeSet, int i) {
        super(o62.d(context, attributeSet, i, 0), attributeSet, i);
        v(attributeSet, i, 0);
    }

    public static boolean t(Context context) {
        return p52.c(context, mk3.c0, true);
    }

    public static int u(Resources.Theme theme, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, cn3.e4, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(cn3.f4, -1);
        typedArrayObtainStyledAttributes.recycle();
        return resourceId;
    }

    public static int w(Context context, TypedArray typedArray, int... iArr) {
        int iD = -1;
        for (int i = 0; i < iArr.length && iD < 0; i++) {
            iD = k62.d(context, typedArray, iArr[i], -1);
        }
        return iD;
    }

    public static boolean x(Context context, Resources.Theme theme, AttributeSet attributeSet, int i, int i2) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(attributeSet, cn3.e4, i, i2);
        int iW = w(context, typedArrayObtainStyledAttributes, cn3.g4, cn3.h4);
        typedArrayObtainStyledAttributes.recycle();
        return iW != -1;
    }

    public final void s(Resources.Theme theme, int i) {
        TypedArray typedArrayObtainStyledAttributes = theme.obtainStyledAttributes(i, cn3.Y3);
        int iW = w(getContext(), typedArrayObtainStyledAttributes, cn3.b4, cn3.d4);
        typedArrayObtainStyledAttributes.recycle();
        if (iW >= 0) {
            setLineHeight(iW);
        }
    }

    @Override // defpackage.k9, android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (t(context)) {
            s(context.getTheme(), i);
        }
    }

    public final void v(AttributeSet attributeSet, int i, int i2) {
        int iU;
        Context context = getContext();
        if (t(context)) {
            Resources.Theme theme = context.getTheme();
            if (x(context, theme, attributeSet, i, i2) || (iU = u(theme, attributeSet, i, i2)) == -1) {
                return;
            }
            s(theme, iU);
        }
    }

    public MaterialTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    public MaterialTextView(Context context) {
        this(context, null);
    }

    public MaterialTextView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(o62.d(context, attributeSet, i, i2), attributeSet, i);
        v(attributeSet, i, i2);
    }
}
