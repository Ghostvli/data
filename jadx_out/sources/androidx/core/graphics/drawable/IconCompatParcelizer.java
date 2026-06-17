package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.os.Parcelable;
import defpackage.lz4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    public static IconCompat read(lz4 lz4Var) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.a = lz4Var.p(iconCompat.a, 1);
        iconCompat.c = lz4Var.j(iconCompat.c, 2);
        iconCompat.d = lz4Var.r(iconCompat.d, 3);
        iconCompat.e = lz4Var.p(iconCompat.e, 4);
        iconCompat.f = lz4Var.p(iconCompat.f, 5);
        iconCompat.g = (ColorStateList) lz4Var.r(iconCompat.g, 6);
        iconCompat.i = lz4Var.t(iconCompat.i, 7);
        iconCompat.j = lz4Var.t(iconCompat.j, 8);
        iconCompat.m();
        return iconCompat;
    }

    public static void write(IconCompat iconCompat, lz4 lz4Var) {
        lz4Var.x(true, true);
        iconCompat.n(lz4Var.f());
        int i = iconCompat.a;
        if (-1 != i) {
            lz4Var.F(i, 1);
        }
        byte[] bArr = iconCompat.c;
        if (bArr != null) {
            lz4Var.B(bArr, 2);
        }
        Parcelable parcelable = iconCompat.d;
        if (parcelable != null) {
            lz4Var.H(parcelable, 3);
        }
        int i2 = iconCompat.e;
        if (i2 != 0) {
            lz4Var.F(i2, 4);
        }
        int i3 = iconCompat.f;
        if (i3 != 0) {
            lz4Var.F(i3, 5);
        }
        ColorStateList colorStateList = iconCompat.g;
        if (colorStateList != null) {
            lz4Var.H(colorStateList, 6);
        }
        String str = iconCompat.i;
        if (str != null) {
            lz4Var.J(str, 7);
        }
        String str2 = iconCompat.j;
        if (str2 != null) {
            lz4Var.J(str2, 8);
        }
    }
}
