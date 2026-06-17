package org.mozilla.classfile;

import defpackage.jl;
import defpackage.uu4;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class b {
    public int a;
    public int b;
    public int c;
    public int[] d;
    public int[] e;
    public boolean f;
    public boolean g;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public b(int i, int i2, int i3, int[] iArr) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        int[] iArr2 = new int[iArr.length];
        this.d = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        this.e = new int[0];
        this.f = false;
        this.g = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean j(int[] iArr, int[] iArr2, int i, a aVar) {
        boolean z = false;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            int iJ = uu4.j(i3, iArr2[i2], aVar);
            iArr[i2] = iJ;
            if (i3 != iJ) {
                z = true;
            }
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int a() {
        return this.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int b() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int[] c() {
        int[] iArr = this.d;
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int[] d() {
        int[] iArr = this.e;
        int[] iArr2 = new int[iArr.length];
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int e() {
        return this.b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int[] f() {
        int length = this.d.length - 1;
        while (length >= 0) {
            int[] iArr = this.d;
            if (iArr[length] != 0 || uu4.i(iArr[length - 1])) {
                break;
            }
            length--;
        }
        int i = length + 1;
        int i2 = 0;
        int i3 = i;
        for (int i4 = 0; i4 < i; i4++) {
            if (uu4.i(this.d[i4])) {
                i3--;
            }
        }
        int[] iArr2 = new int[i3];
        int i5 = 0;
        while (i2 < i3) {
            int[] iArr3 = this.d;
            iArr2[i2] = iArr3[i5];
            if (uu4.i(iArr3[i5])) {
                i5++;
            }
            i2++;
            i5++;
        }
        return iArr2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean g() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean h() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean i(int[] iArr, int i, int[] iArr2, int i2, a aVar) {
        boolean z = this.f;
        int[] iArr3 = this.d;
        if (z) {
            if (iArr3.length == i && this.e.length == i2) {
                return j(iArr3, iArr, i, aVar) || j(this.e, iArr2, i2, aVar);
            }
            jl.a("bad merge attempt");
            return false;
        }
        System.arraycopy(iArr, 0, iArr3, 0, i);
        int[] iArr4 = new int[i2];
        this.e = iArr4;
        System.arraycopy(iArr2, 0, iArr4, 0, i2);
        this.f = true;
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void k(boolean z) {
        this.g = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l(boolean z) {
        this.f = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "sb " + this.a;
    }
}
