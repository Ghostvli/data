package com.google.android.flexbox;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.b;
import defpackage.p21;
import defpackage.q21;
import defpackage.r21;
import defpackage.sy;
import defpackage.z42;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public final p21 a;
    public boolean[] b;
    public int[] c;
    public long[] d;
    public long[] e;

    /* JADX INFO: renamed from: com.google.android.flexbox.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class C0060a {
        public List a;
        public int b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a() {
            this.a = null;
            this.b = 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public a(p21 p21Var) {
        this.a = p21Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int A(boolean z) {
        p21 p21Var = this.a;
        return z ? p21Var.b() : p21Var.c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int B(boolean z) {
        p21 p21Var = this.a;
        return z ? p21Var.c() : p21Var.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int C(boolean z) {
        p21 p21Var = this.a;
        return z ? p21Var.w() : p21Var.u();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int D(boolean z) {
        p21 p21Var = this.a;
        return z ? p21Var.u() : p21Var.w();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int E(View view, boolean z) {
        return z ? view.getMeasuredHeight() : view.getMeasuredWidth();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int F(View view, boolean z) {
        return z ? view.getMeasuredWidth() : view.getMeasuredHeight();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean G(int i, int i2, r21 r21Var) {
        return i == i2 - 1 && r21Var.c() != 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean H(View view, int i, int i2, int i3, int i4, q21 q21Var, int i5, int i6, int i7) {
        if (this.a.j() == 0) {
            return false;
        }
        if (q21Var.q()) {
            return true;
        }
        if (i == 0) {
            return false;
        }
        int iH = this.a.h();
        if (iH != -1 && iH <= i7 + 1) {
            return false;
        }
        int iQ = this.a.q(view, i5, i6);
        if (iQ > 0) {
            i4 += iQ;
        }
        return i2 < i3 + i4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I(View view, r21 r21Var, int i, int i2, int i3, int i4) {
        q21 q21Var = (q21) view.getLayoutParams();
        int iM = this.a.m();
        if (q21Var.e() != -1) {
            iM = q21Var.e();
        }
        int i5 = r21Var.g;
        if (iM != 0) {
            if (iM == 1) {
                if (this.a.j() == 2) {
                    view.layout(i, (i2 - i5) + view.getMeasuredHeight() + q21Var.k(), i3, (i4 - i5) + view.getMeasuredHeight() + q21Var.k());
                    return;
                } else {
                    int i6 = i2 + i5;
                    view.layout(i, (i6 - view.getMeasuredHeight()) - q21Var.i(), i3, i6 - q21Var.i());
                    return;
                }
            }
            if (iM == 2) {
                int measuredHeight = (((i5 - view.getMeasuredHeight()) + q21Var.k()) - q21Var.i()) / 2;
                if (this.a.j() != 2) {
                    int i7 = i2 + measuredHeight;
                    view.layout(i, i7, i3, view.getMeasuredHeight() + i7);
                    return;
                } else {
                    int i8 = i2 - measuredHeight;
                    view.layout(i, i8, i3, view.getMeasuredHeight() + i8);
                    return;
                }
            }
            if (iM == 3) {
                int iJ = this.a.j();
                int i9 = r21Var.l;
                if (iJ != 2) {
                    int iMax = Math.max(i9 - view.getBaseline(), q21Var.k());
                    view.layout(i, i2 + iMax, i3, i4 + iMax);
                    return;
                } else {
                    int iMax2 = Math.max((i9 - view.getMeasuredHeight()) + view.getBaseline(), q21Var.i());
                    view.layout(i, i2 - iMax2, i3, i4 - iMax2);
                    return;
                }
            }
            if (iM != 4) {
                return;
            }
        }
        if (this.a.j() != 2) {
            view.layout(i, i2 + q21Var.k(), i3, i4 + q21Var.k());
        } else {
            view.layout(i, i2 - q21Var.i(), i3, i4 - q21Var.i());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void J(View view, r21 r21Var, boolean z, int i, int i2, int i3, int i4) {
        q21 q21Var = (q21) view.getLayoutParams();
        int iM = this.a.m();
        if (q21Var.e() != -1) {
            iM = q21Var.e();
        }
        int i5 = r21Var.g;
        if (iM != 0) {
            if (iM == 1) {
                if (z) {
                    view.layout((i - i5) + view.getMeasuredWidth() + q21Var.j(), i2, (i3 - i5) + view.getMeasuredWidth() + q21Var.j(), i4);
                    return;
                } else {
                    view.layout(((i + i5) - view.getMeasuredWidth()) - q21Var.o(), i2, ((i3 + i5) - view.getMeasuredWidth()) - q21Var.o(), i4);
                    return;
                }
            }
            if (iM == 2) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                int measuredWidth = (((i5 - view.getMeasuredWidth()) + z42.b(marginLayoutParams)) - z42.a(marginLayoutParams)) / 2;
                if (z) {
                    view.layout(i - measuredWidth, i2, i3 - measuredWidth, i4);
                    return;
                } else {
                    view.layout(i + measuredWidth, i2, i3 + measuredWidth, i4);
                    return;
                }
            }
            if (iM != 3 && iM != 4) {
                return;
            }
        }
        if (z) {
            view.layout(i - q21Var.o(), i2, i3 - q21Var.o(), i4);
        } else {
            view.layout(i + q21Var.j(), i2, i3 + q21Var.j(), i4);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long K(int i, int i2) {
        return (((long) i) & 4294967295L) | (((long) i2) << 32);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void L(int i, int i2, r21 r21Var, int i3, int i4, boolean z) {
        float f;
        float f2;
        int iMax;
        int iG;
        int i5 = r21Var.e;
        float f3 = r21Var.k;
        float f4 = 0.0f;
        if (f3 <= 0.0f || i3 > i5) {
            return;
        }
        float f5 = (i5 - i3) / f3;
        r21Var.e = i4 + r21Var.f;
        if (!z) {
            r21Var.g = Integer.MIN_VALUE;
        }
        int i6 = 0;
        boolean z2 = false;
        int i7 = 0;
        float f6 = 0.0f;
        while (i6 < r21Var.h) {
            int i8 = r21Var.o + i6;
            View viewK = this.a.k(i8);
            if (viewK == null || viewK.getVisibility() == 8) {
                f = f4;
                f2 = f5;
            } else {
                q21 q21Var = (q21) viewK.getLayoutParams();
                int iG2 = this.a.g();
                f = f4;
                if (iG2 == 0 || iG2 == 1) {
                    int measuredWidth = viewK.getMeasuredWidth();
                    long[] jArr = this.e;
                    if (jArr != null) {
                        measuredWidth = r(jArr[i8]);
                    }
                    int measuredHeight = viewK.getMeasuredHeight();
                    long[] jArr2 = this.e;
                    f2 = f5;
                    if (jArr2 != null) {
                        measuredHeight = q(jArr2[i8]);
                    }
                    if (!this.b[i8] && q21Var.f() > f) {
                        float f7 = measuredWidth - (f2 * q21Var.f());
                        if (i6 == r21Var.h - 1) {
                            f7 += f6;
                            f6 = f;
                        }
                        int iRound = Math.round(f7);
                        if (iRound < q21Var.g()) {
                            iG = q21Var.g();
                            this.b[i8] = true;
                            r21Var.k -= q21Var.f();
                            z2 = true;
                        } else {
                            f6 += f7 - iRound;
                            double d = f6;
                            if (d > 1.0d) {
                                iG = iRound + 1;
                                f6 -= 1.0f;
                            } else if (d < -1.0d) {
                                iG = iRound - 1;
                                f6 += 1.0f;
                            } else {
                                iG = iRound;
                            }
                        }
                        int iS = s(i2, q21Var, r21Var.m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iG, Buffer.MAX_SIZE);
                        viewK.measure(iMakeMeasureSpec, iS);
                        int measuredWidth2 = viewK.getMeasuredWidth();
                        int measuredHeight2 = viewK.getMeasuredHeight();
                        Q(i8, iMakeMeasureSpec, iS, viewK);
                        this.a.n(i8, viewK);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i7, measuredHeight + q21Var.k() + q21Var.i() + this.a.B(viewK));
                    r21Var.e += measuredWidth + q21Var.j() + q21Var.o();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewK.getMeasuredHeight();
                    long[] jArr3 = this.e;
                    if (jArr3 != null) {
                        measuredHeight3 = q(jArr3[i8]);
                    }
                    int measuredWidth3 = viewK.getMeasuredWidth();
                    long[] jArr4 = this.e;
                    if (jArr4 != null) {
                        measuredWidth3 = r(jArr4[i8]);
                    }
                    if (!this.b[i8] && q21Var.f() > f) {
                        float f8 = measuredHeight3 - (q21Var.f() * f5);
                        if (i6 == r21Var.h - 1) {
                            f8 += f6;
                            f6 = f;
                        }
                        int iRound2 = Math.round(f8);
                        if (iRound2 < q21Var.p()) {
                            iRound2 = q21Var.p();
                            this.b[i8] = true;
                            r21Var.k -= q21Var.f();
                            z2 = true;
                        } else {
                            f6 += f8 - iRound2;
                            double d2 = f6;
                            if (d2 > 1.0d) {
                                iRound2++;
                                f6 -= 1.0f;
                            } else if (d2 < -1.0d) {
                                iRound2--;
                                f6 += 1.0f;
                            }
                        }
                        int iT = t(i, q21Var, r21Var.m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, Buffer.MAX_SIZE);
                        viewK.measure(iT, iMakeMeasureSpec2);
                        int measuredWidth4 = viewK.getMeasuredWidth();
                        int measuredHeight4 = viewK.getMeasuredHeight();
                        Q(i8, iT, iMakeMeasureSpec2, viewK);
                        this.a.n(i8, viewK);
                        measuredWidth3 = measuredWidth4;
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i7, measuredWidth3 + q21Var.j() + q21Var.o() + this.a.B(viewK));
                    r21Var.e += measuredHeight3 + q21Var.k() + q21Var.i();
                    f2 = f5;
                }
                r21Var.g = Math.max(r21Var.g, iMax);
                i7 = iMax;
            }
            i6++;
            f5 = f2;
            f4 = f;
        }
        if (!z2 || i5 == r21Var.e) {
            return;
        }
        L(i, i2, r21Var, i3, i4, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void M(View view, int i, int i2) {
        q21 q21Var = (q21) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - q21Var.j()) - q21Var.o()) - this.a.B(view), q21Var.g()), q21Var.t());
        long[] jArr = this.e;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? q(jArr[i2]) : view.getMeasuredHeight(), Buffer.MAX_SIZE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, Buffer.MAX_SIZE);
        view.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
        Q(i2, iMakeMeasureSpec2, iMakeMeasureSpec, view);
        this.a.n(i2, view);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void N(View view, int i, int i2) {
        q21 q21Var = (q21) view.getLayoutParams();
        int iMin = Math.min(Math.max(((i - q21Var.k()) - q21Var.i()) - this.a.B(view), q21Var.p()), q21Var.r());
        long[] jArr = this.e;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(jArr != null ? r(jArr[i2]) : view.getMeasuredWidth(), Buffer.MAX_SIZE);
        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iMin, Buffer.MAX_SIZE);
        view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
        Q(i2, iMakeMeasureSpec, iMakeMeasureSpec2, view);
        this.a.n(i2, view);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void O() {
        P(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void P(int i) {
        View viewK;
        if (i >= this.a.e()) {
            return;
        }
        int iG = this.a.g();
        if (this.a.m() != 4) {
            for (r21 r21Var : this.a.s()) {
                for (Integer num : r21Var.n) {
                    View viewK2 = this.a.k(num.intValue());
                    if (iG == 0 || iG == 1) {
                        N(viewK2, r21Var.g, num.intValue());
                    } else {
                        if (iG != 2 && iG != 3) {
                            b.a("Invalid flex direction: ", iG);
                            return;
                        }
                        M(viewK2, r21Var.g, num.intValue());
                    }
                }
            }
            return;
        }
        int[] iArr = this.c;
        List listS = this.a.s();
        int size = listS.size();
        for (int i2 = iArr != null ? iArr[i] : 0; i2 < size; i2++) {
            r21 r21Var2 = (r21) listS.get(i2);
            int i3 = r21Var2.h;
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = r21Var2.o + i4;
                if (i4 < this.a.e() && (viewK = this.a.k(i5)) != null && viewK.getVisibility() != 8) {
                    q21 q21Var = (q21) viewK.getLayoutParams();
                    if (q21Var.e() == -1 || q21Var.e() == 4) {
                        if (iG == 0 || iG == 1) {
                            N(viewK, r21Var2.g, i5);
                        } else {
                            if (iG != 2 && iG != 3) {
                                b.a("Invalid flex direction: ", iG);
                                return;
                            }
                            M(viewK, r21Var2.g, i5);
                        }
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Q(int i, int i2, int i3, View view) {
        long[] jArr = this.d;
        if (jArr != null) {
            jArr[i] = K(i2, i3);
        }
        long[] jArr2 = this.e;
        if (jArr2 != null) {
            jArr2[i] = K(view.getMeasuredWidth(), view.getMeasuredHeight());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a(List list, r21 r21Var, int i, int i2) {
        r21Var.m = i2;
        this.a.x(r21Var);
        r21Var.p = i;
        list.add(r21Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r4v10, resolved type: boolean */
    /* JADX DEBUG: Multi-variable search result rejected for r4v2, resolved type: android.view.ViewGroup$LayoutParams */
    /* JADX DEBUG: Multi-variable search result rejected for r4v8, resolved type: boolean */
    /* JADX WARN: Multi-variable type inference failed */
    public void b(C0060a c0060a, int i, int i2, int i3, int i4, int i5, List list) {
        int i6;
        C0060a c0060a2;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int iL;
        int i12;
        int i13;
        int i14;
        r21 r21Var;
        int i15;
        int i16;
        boolean z;
        int i17;
        boolean z2;
        int i18;
        int i19 = i;
        boolean zA = this.a.A();
        int mode = View.MeasureSpec.getMode(i19);
        int size = View.MeasureSpec.getSize(i19);
        List arrayList = list == null ? new ArrayList() : list;
        c0060a.a = arrayList;
        boolean z3 = i5 == -1;
        int iD = D(zA);
        int iB = B(zA);
        int iC = C(zA);
        int iA = A(zA);
        r21 r21Var2 = new r21();
        int i20 = i4;
        r21Var2.o = i20;
        int i21 = iD + iB;
        r21Var2.e = i21;
        int iE = this.a.e();
        boolean z4 = z3;
        r21 r21Var3 = r21Var2;
        int i22 = Integer.MIN_VALUE;
        int i23 = 0;
        int iCombineMeasuredStates = 0;
        int i24 = 0;
        while (true) {
            if (i20 >= iE) {
                i6 = iCombineMeasuredStates;
                c0060a2 = c0060a;
                break;
            }
            View viewK = this.a.k(i20);
            if (viewK == null) {
                if (G(i20, iE, r21Var3)) {
                    a(arrayList, r21Var3, i20, i23);
                }
                i7 = i21;
            } else {
                i7 = i21;
                if (viewK.getVisibility() == 8) {
                    r21Var3.i++;
                    r21Var3.h++;
                    if (G(i20, iE, r21Var3)) {
                        a(arrayList, r21Var3, i20, i23);
                    }
                } else {
                    if (viewK instanceof CompoundButton) {
                        o((CompoundButton) viewK);
                    }
                    q21 q21Var = (q21) viewK.getLayoutParams();
                    int i25 = iE;
                    if (q21Var.e() == 4) {
                        r21Var3.n.add(Integer.valueOf(i20));
                    }
                    int iZ = z(q21Var, zA);
                    if (q21Var.n() != -1.0f && mode == 1073741824) {
                        iZ = Math.round(size * q21Var.n());
                    }
                    p21 p21Var = this.a;
                    if (zA) {
                        i9 = mode;
                        iL = p21Var.l(i19, i7 + x(q21Var, true) + v(q21Var, true), iZ);
                        i8 = size;
                        i10 = i23;
                        int iT = this.a.t(i2, iC + iA + w(q21Var, true) + u(q21Var, true) + i23, y(q21Var, true));
                        viewK.measure(iL, iT);
                        Q(i20, iL, iT, viewK);
                        i11 = 0;
                    } else {
                        i8 = size;
                        i9 = mode;
                        i10 = i23;
                        i11 = 0;
                        int iL2 = p21Var.l(i2, iC + iA + w(q21Var, false) + u(q21Var, false) + i10, y(q21Var, false));
                        int iT2 = this.a.t(i19, i7 + x(q21Var, false) + v(q21Var, false), iZ);
                        viewK.measure(iL2, iT2);
                        Q(i20, iL2, iT2, viewK);
                        iL = iT2;
                    }
                    this.a.n(i20, viewK);
                    g(viewK, i20);
                    iCombineMeasuredStates = View.combineMeasuredStates(iCombineMeasuredStates, viewK.getMeasuredState());
                    int i26 = i11;
                    i12 = i20;
                    int i27 = iL;
                    r21 r21Var4 = r21Var3;
                    int i28 = i24;
                    i13 = i7;
                    i14 = i10;
                    boolean z5 = zA;
                    size = i8;
                    if (H(viewK, i9, size, r21Var3.e, F(viewK, zA) + x(q21Var, zA) + v(q21Var, zA), q21Var, i12, i28, arrayList.size())) {
                        if (r21Var4.c() > 0) {
                            a(arrayList, r21Var4, i12 > 0 ? i12 - 1 : i26, i14);
                            i18 = i14 + r21Var4.g;
                        } else {
                            i18 = i14;
                        }
                        if (z5) {
                            if (q21Var.a() == -1) {
                                p21 p21Var2 = this.a;
                                viewK.measure(i27, p21Var2.t(i2, p21Var2.w() + this.a.b() + q21Var.k() + q21Var.i() + i18, q21Var.a()));
                                g(viewK, i12);
                            }
                        } else if (q21Var.b() == -1) {
                            p21 p21Var3 = this.a;
                            viewK.measure(p21Var3.l(i2, p21Var3.y() + this.a.p() + q21Var.j() + q21Var.o() + i18, q21Var.b()), i27);
                            g(viewK, i12);
                        }
                        r21 r21Var5 = new r21();
                        r21Var5.h = 1;
                        r21Var5.e = i13;
                        r21Var5.o = i12;
                        i14 = i18;
                        i15 = i26;
                        r21Var = r21Var5;
                        i16 = Integer.MIN_VALUE;
                    } else {
                        r21Var = r21Var4;
                        r21Var.h++;
                        i15 = i28 + 1;
                        i16 = i22;
                    }
                    r21Var.q = (r21Var.q ? 1 : 0) | (q21Var.m() != 0.0f ? 1 : i26);
                    r21Var.r = (r21Var.r ? 1 : 0) | (q21Var.f() != 0.0f ? 1 : i26);
                    int[] iArr = this.c;
                    if (iArr != null) {
                        iArr[i12] = arrayList.size();
                    }
                    z = z5;
                    r21Var.e += F(viewK, z) + x(q21Var, z) + v(q21Var, z);
                    r21Var.j += q21Var.m();
                    r21Var.k += q21Var.f();
                    this.a.o(viewK, i12, i15, r21Var);
                    int iMax = Math.max(i16, E(viewK, z) + w(q21Var, z) + u(q21Var, z) + this.a.B(viewK));
                    r21Var.g = Math.max(r21Var.g, iMax);
                    if (z) {
                        int iJ = this.a.j();
                        int i29 = r21Var.l;
                        if (iJ != 2) {
                            r21Var.l = Math.max(i29, viewK.getBaseline() + q21Var.k());
                        } else {
                            r21Var.l = Math.max(i29, (viewK.getMeasuredHeight() - viewK.getBaseline()) + q21Var.i());
                        }
                    }
                    i17 = i25;
                    if (G(i12, i17, r21Var)) {
                        a(arrayList, r21Var, i12, i14);
                        i14 += r21Var.g;
                    }
                    if (i5 != -1 && arrayList.size() > 0) {
                        if (((r21) arrayList.get(arrayList.size() - 1)).p >= i5 && i12 >= i5 && !z4) {
                            i14 = -r21Var.a();
                            z2 = true;
                        }
                        if (i14 <= i3 && z2) {
                            c0060a2 = c0060a;
                            i6 = iCombineMeasuredStates;
                            break;
                        }
                        i22 = iMax;
                        z4 = z2;
                        i24 = i15;
                        int i30 = i12 + 1;
                        zA = z;
                        r21Var3 = r21Var;
                        i21 = i13;
                        i23 = i14;
                        i19 = i;
                        iE = i17;
                        i20 = i30;
                        mode = i9;
                    }
                    z2 = z4;
                    if (i14 <= i3) {
                    }
                    i22 = iMax;
                    z4 = z2;
                    i24 = i15;
                    int i302 = i12 + 1;
                    zA = z;
                    r21Var3 = r21Var;
                    i21 = i13;
                    i23 = i14;
                    i19 = i;
                    iE = i17;
                    i20 = i302;
                    mode = i9;
                }
            }
            i12 = i20;
            i9 = mode;
            i17 = iE;
            i14 = i23;
            z = zA;
            i13 = i7;
            r21Var = r21Var3;
            int i3022 = i12 + 1;
            zA = z;
            r21Var3 = r21Var;
            i21 = i13;
            i23 = i14;
            i19 = i;
            iE = i17;
            i20 = i3022;
            mode = i9;
        }
        c0060a2.b = i6;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c(C0060a c0060a, int i, int i2, int i3, int i4, List list) {
        b(c0060a, i, i2, i3, i4, -1, list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d(C0060a c0060a, int i, int i2, int i3, int i4, List list) {
        b(c0060a, i, i2, i3, 0, i4, list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e(C0060a c0060a, int i, int i2, int i3, int i4, List list) {
        b(c0060a, i2, i, i3, i4, -1, list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f(C0060a c0060a, int i, int i2, int i3, int i4, List list) {
        b(c0060a, i2, i, i3, 0, i4, list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void g(View view, int i) {
        boolean z;
        q21 q21Var = (q21) view.getLayoutParams();
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        boolean z2 = true;
        if (measuredWidth < q21Var.g()) {
            measuredWidth = q21Var.g();
        } else {
            if (measuredWidth <= q21Var.t()) {
                z = false;
                if (measuredHeight >= q21Var.p()) {
                    measuredHeight = q21Var.p();
                } else if (measuredHeight > q21Var.r()) {
                    measuredHeight = q21Var.r();
                } else {
                    z2 = z;
                }
                if (z2) {
                    return;
                }
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(measuredWidth, Buffer.MAX_SIZE);
                int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(measuredHeight, Buffer.MAX_SIZE);
                view.measure(iMakeMeasureSpec, iMakeMeasureSpec2);
                Q(i, iMakeMeasureSpec, iMakeMeasureSpec2, view);
                this.a.n(i, view);
                return;
            }
            measuredWidth = q21Var.t();
        }
        z = true;
        if (measuredHeight >= q21Var.p()) {
        }
        if (z2) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h(List list, int i) {
        int i2 = this.c[i];
        if (i2 == -1) {
            i2 = 0;
        }
        if (list.size() > i2) {
            list.subList(i2, list.size()).clear();
        }
        int[] iArr = this.c;
        int length = iArr.length - 1;
        if (i > length) {
            Arrays.fill(iArr, -1);
        } else {
            Arrays.fill(iArr, i, length, -1);
        }
        long[] jArr = this.d;
        int length2 = jArr.length - 1;
        if (i > length2) {
            Arrays.fill(jArr, 0L);
        } else {
            Arrays.fill(jArr, i, length2, 0L);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i(int i, int i2) {
        j(i, i2, 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void j(int i, int i2, int i3) {
        int size;
        int iY;
        int iP;
        int i4;
        int i5;
        a aVar;
        k(this.a.e());
        if (i3 >= this.a.e()) {
            return;
        }
        int iG = this.a.g();
        int iG2 = this.a.g();
        if (iG2 == 0 || iG2 == 1) {
            int mode = View.MeasureSpec.getMode(i);
            size = View.MeasureSpec.getSize(i);
            int i6 = this.a.i();
            if (mode != 1073741824) {
                size = Math.min(i6, size);
            }
            iY = this.a.y();
            iP = this.a.p();
        } else {
            if (iG2 != 2 && iG2 != 3) {
                b.a("Invalid flex direction: ", iG);
                return;
            }
            int mode2 = View.MeasureSpec.getMode(i2);
            size = View.MeasureSpec.getSize(i2);
            if (mode2 != 1073741824) {
                size = this.a.i();
            }
            iY = this.a.w();
            iP = this.a.b();
        }
        int i7 = iY + iP;
        int i8 = size;
        int[] iArr = this.c;
        int i9 = iArr != null ? iArr[i3] : 0;
        List listS = this.a.s();
        int size2 = listS.size();
        while (i9 < size2) {
            r21 r21Var = (r21) listS.get(i9);
            int i10 = r21Var.e;
            if (i10 >= i8 || !r21Var.q) {
                i4 = i;
                i5 = i2;
                if (i10 <= i8 || !r21Var.r) {
                    aVar = this;
                } else {
                    aVar = this;
                    aVar.L(i4, i5, r21Var, i8, i7, false);
                }
            } else {
                aVar = this;
                i4 = i;
                i5 = i2;
                aVar.p(i4, i5, r21Var, i8, i7, false);
            }
            i9++;
            this = aVar;
            i = i4;
            i2 = i5;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void k(int i) {
        boolean[] zArr = this.b;
        if (zArr == null) {
            this.b = new boolean[Math.max(i, 10)];
        } else if (zArr.length < i) {
            this.b = new boolean[Math.max(zArr.length * 2, i)];
        } else {
            Arrays.fill(zArr, false);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l(int i) {
        int[] iArr = this.c;
        if (iArr == null) {
            this.c = new int[Math.max(i, 10)];
        } else if (iArr.length < i) {
            this.c = Arrays.copyOf(this.c, Math.max(iArr.length * 2, i));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m(int i) {
        long[] jArr = this.d;
        if (jArr == null) {
            this.d = new long[Math.max(i, 10)];
        } else if (jArr.length < i) {
            this.d = Arrays.copyOf(this.d, Math.max(jArr.length * 2, i));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void n(int i) {
        long[] jArr = this.e;
        if (jArr == null) {
            this.e = new long[Math.max(i, 10)];
        } else if (jArr.length < i) {
            this.e = Arrays.copyOf(this.e, Math.max(jArr.length * 2, i));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o(CompoundButton compoundButton) {
        q21 q21Var = (q21) compoundButton.getLayoutParams();
        int iG = q21Var.g();
        int iP = q21Var.p();
        Drawable drawableA = sy.a(compoundButton);
        int minimumWidth = drawableA == null ? 0 : drawableA.getMinimumWidth();
        int minimumHeight = drawableA != null ? drawableA.getMinimumHeight() : 0;
        if (iG == -1) {
            iG = minimumWidth;
        }
        q21Var.h(iG);
        if (iP == -1) {
            iP = minimumHeight;
        }
        q21Var.l(iP);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void p(int i, int i2, r21 r21Var, int i3, int i4, boolean z) {
        int i5;
        float f;
        float f2;
        int iMax;
        double d;
        double d2;
        float f3 = r21Var.j;
        float f4 = 0.0f;
        if (f3 <= 0.0f || i3 < (i5 = r21Var.e)) {
            return;
        }
        float f5 = (i3 - i5) / f3;
        r21Var.e = i4 + r21Var.f;
        if (!z) {
            r21Var.g = Integer.MIN_VALUE;
        }
        int i6 = 0;
        boolean z2 = false;
        int i7 = 0;
        float f6 = 0.0f;
        while (i6 < r21Var.h) {
            int i8 = r21Var.o + i6;
            View viewK = this.a.k(i8);
            if (viewK == null || viewK.getVisibility() == 8) {
                f = f4;
                f2 = f5;
                z2 = z2;
            } else {
                q21 q21Var = (q21) viewK.getLayoutParams();
                int iG = this.a.g();
                f = f4;
                if (iG == 0 || iG == 1) {
                    f2 = f5;
                    boolean z3 = z2;
                    int measuredWidth = viewK.getMeasuredWidth();
                    long[] jArr = this.e;
                    if (jArr != null) {
                        measuredWidth = r(jArr[i8]);
                    }
                    int measuredHeight = viewK.getMeasuredHeight();
                    long[] jArr2 = this.e;
                    if (jArr2 != null) {
                        measuredHeight = q(jArr2[i8]);
                    }
                    if (this.b[i8] || q21Var.m() <= f) {
                        z2 = z3;
                    } else {
                        float fM = measuredWidth + (q21Var.m() * f2);
                        if (i6 == r21Var.h - 1) {
                            fM += f6;
                            f6 = f;
                        }
                        int iRound = Math.round(fM);
                        if (iRound > q21Var.t()) {
                            iRound = q21Var.t();
                            this.b[i8] = true;
                            r21Var.j -= q21Var.m();
                            z2 = true;
                        } else {
                            f6 += fM - iRound;
                            double d3 = f6;
                            if (d3 > 1.0d) {
                                iRound++;
                                d = d3 - 1.0d;
                            } else {
                                if (d3 < -1.0d) {
                                    iRound--;
                                    d = d3 + 1.0d;
                                }
                                z2 = z3;
                            }
                            f6 = (float) d;
                            z2 = z3;
                        }
                        int iS = s(i2, q21Var, r21Var.m);
                        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iRound, Buffer.MAX_SIZE);
                        viewK.measure(iMakeMeasureSpec, iS);
                        int measuredWidth2 = viewK.getMeasuredWidth();
                        int measuredHeight2 = viewK.getMeasuredHeight();
                        Q(i8, iMakeMeasureSpec, iS, viewK);
                        this.a.n(i8, viewK);
                        measuredWidth = measuredWidth2;
                        measuredHeight = measuredHeight2;
                    }
                    int iMax2 = Math.max(i7, measuredHeight + q21Var.k() + q21Var.i() + this.a.B(viewK));
                    r21Var.e += measuredWidth + q21Var.j() + q21Var.o();
                    iMax = iMax2;
                } else {
                    int measuredHeight3 = viewK.getMeasuredHeight();
                    long[] jArr3 = this.e;
                    if (jArr3 != null) {
                        measuredHeight3 = q(jArr3[i8]);
                    }
                    int measuredWidth3 = viewK.getMeasuredWidth();
                    long[] jArr4 = this.e;
                    f2 = f5;
                    boolean z4 = z2;
                    if (jArr4 != null) {
                        measuredWidth3 = r(jArr4[i8]);
                    }
                    if (this.b[i8] || q21Var.m() <= f) {
                        z2 = z4;
                    } else {
                        float fM2 = measuredHeight3 + (q21Var.m() * f2);
                        if (i6 == r21Var.h - 1) {
                            fM2 += f6;
                            f6 = f;
                        }
                        int iRound2 = Math.round(fM2);
                        if (iRound2 > q21Var.r()) {
                            iRound2 = q21Var.r();
                            this.b[i8] = true;
                            r21Var.j -= q21Var.m();
                            z2 = true;
                        } else {
                            f6 += fM2 - iRound2;
                            double d4 = f6;
                            if (d4 > 1.0d) {
                                iRound2++;
                                d2 = d4 - 1.0d;
                            } else {
                                if (d4 < -1.0d) {
                                    iRound2--;
                                    d2 = d4 + 1.0d;
                                }
                                z2 = z4;
                            }
                            f6 = (float) d2;
                            z2 = z4;
                        }
                        int iT = t(i, q21Var, r21Var.m);
                        int iMakeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(iRound2, Buffer.MAX_SIZE);
                        viewK.measure(iT, iMakeMeasureSpec2);
                        int measuredWidth4 = viewK.getMeasuredWidth();
                        int measuredHeight4 = viewK.getMeasuredHeight();
                        Q(i8, iT, iMakeMeasureSpec2, viewK);
                        this.a.n(i8, viewK);
                        measuredWidth3 = measuredWidth4;
                        measuredHeight3 = measuredHeight4;
                    }
                    iMax = Math.max(i7, measuredWidth3 + q21Var.j() + q21Var.o() + this.a.B(viewK));
                    r21Var.e += measuredHeight3 + q21Var.k() + q21Var.i();
                }
                r21Var.g = Math.max(r21Var.g, iMax);
                i7 = iMax;
            }
            i6++;
            f5 = f2;
            f4 = f;
        }
        if (!z2 || i5 == r21Var.e) {
            return;
        }
        p(i, i2, r21Var, i3, i4, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int q(long j) {
        return (int) (j >> 32);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int r(long j) {
        return (int) j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int s(int i, q21 q21Var, int i2) {
        p21 p21Var = this.a;
        int iT = p21Var.t(i, p21Var.w() + this.a.b() + q21Var.k() + q21Var.i() + i2, q21Var.a());
        int size = View.MeasureSpec.getSize(iT);
        return size > q21Var.r() ? View.MeasureSpec.makeMeasureSpec(q21Var.r(), View.MeasureSpec.getMode(iT)) : size < q21Var.p() ? View.MeasureSpec.makeMeasureSpec(q21Var.p(), View.MeasureSpec.getMode(iT)) : iT;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int t(int i, q21 q21Var, int i2) {
        p21 p21Var = this.a;
        int iL = p21Var.l(i, p21Var.y() + this.a.p() + q21Var.j() + q21Var.o() + i2, q21Var.b());
        int size = View.MeasureSpec.getSize(iL);
        return size > q21Var.t() ? View.MeasureSpec.makeMeasureSpec(q21Var.t(), View.MeasureSpec.getMode(iL)) : size < q21Var.g() ? View.MeasureSpec.makeMeasureSpec(q21Var.g(), View.MeasureSpec.getMode(iL)) : iL;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int u(q21 q21Var, boolean z) {
        return z ? q21Var.i() : q21Var.o();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int v(q21 q21Var, boolean z) {
        return z ? q21Var.o() : q21Var.i();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int w(q21 q21Var, boolean z) {
        return z ? q21Var.k() : q21Var.j();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int x(q21 q21Var, boolean z) {
        return z ? q21Var.j() : q21Var.k();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int y(q21 q21Var, boolean z) {
        return z ? q21Var.a() : q21Var.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int z(q21 q21Var, boolean z) {
        return z ? q21Var.b() : q21Var.a();
    }
}
