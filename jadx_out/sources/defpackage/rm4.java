package defpackage;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Typeface;
import defpackage.xm0;
import java.text.Bidi;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.HTTP;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class rm4 extends bi {
    public final StringBuilder E;
    public final StringBuilder F;
    public final StringBuilder G;
    public final StringBuilder H;
    public final RectF I;
    public final Matrix J;
    public final Paint K;
    public final Paint L;
    public final Map M;
    public final w02 N;
    public final List O;
    public final List P;
    public final qm4 Q;
    public final g22 R;
    public final f12 S;
    public um4 T;
    public zh U;
    public zh V;
    public zh W;
    public zh X;
    public zh Y;
    public zh Z;
    public zh a0;
    public zh b0;
    public zh c0;
    public zh d0;
    public zh e0;
    public zh f0;
    public zh g0;
    public zh h0;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends Paint {
        public a(int i) {
            super(i);
            setStyle(Paint.Style.FILL);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends Paint {
        public b(int i) {
            super(i);
            setStyle(Paint.Style.STROKE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[xm0.a.values().length];
            a = iArr;
            try {
                iArr[xm0.a.LEFT_ALIGN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[xm0.a.RIGHT_ALIGN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[xm0.a.CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public rm4(g22 g22Var, yr1 yr1Var) {
        v6 v6Var;
        v6 v6Var2;
        l6 l6Var;
        v6 v6Var3;
        l6 l6Var2;
        v6 v6Var4;
        l6 l6Var3;
        w6 w6Var;
        l6 l6Var4;
        w6 w6Var2;
        j6 j6Var;
        w6 w6Var3;
        j6 j6Var2;
        w6 w6Var4;
        i6 i6Var;
        w6 w6Var5;
        i6 i6Var2;
        super(g22Var, yr1Var);
        this.E = new StringBuilder(2);
        this.F = new StringBuilder(0);
        this.G = new StringBuilder(0);
        this.H = new StringBuilder(0);
        this.I = new RectF();
        this.J = new Matrix();
        this.K = new a(1);
        this.L = new b(1);
        this.M = new HashMap();
        this.N = new w02();
        this.O = new ArrayList();
        this.P = new ArrayList();
        this.T = um4.INDEX;
        this.R = g22Var;
        this.S = yr1Var.c();
        qm4 qm4VarA = yr1Var.t().a();
        this.Q = qm4VarA;
        qm4VarA.a(this);
        j(qm4VarA);
        t6 t6VarU = yr1Var.u();
        if (t6VarU != null && (w6Var5 = t6VarU.a) != null && (i6Var2 = w6Var5.a) != null) {
            zh zhVarA = i6Var2.a();
            this.U = zhVarA;
            zhVarA.a(this);
            j(this.U);
        }
        if (t6VarU != null && (w6Var4 = t6VarU.a) != null && (i6Var = w6Var4.b) != null) {
            zh zhVarA2 = i6Var.a();
            this.W = zhVarA2;
            zhVarA2.a(this);
            j(this.W);
        }
        if (t6VarU != null && (w6Var3 = t6VarU.a) != null && (j6Var2 = w6Var3.c) != null) {
            t21 t21VarA = j6Var2.a();
            this.Y = t21VarA;
            t21VarA.a(this);
            j(this.Y);
        }
        if (t6VarU != null && (w6Var2 = t6VarU.a) != null && (j6Var = w6Var2.d) != null) {
            t21 t21VarA2 = j6Var.a();
            this.a0 = t21VarA2;
            t21VarA2.a(this);
            j(this.a0);
        }
        if (t6VarU != null && (w6Var = t6VarU.a) != null && (l6Var4 = w6Var.e) != null) {
            zh zhVarA3 = l6Var4.a();
            this.c0 = zhVarA3;
            zhVarA3.a(this);
            j(this.c0);
        }
        if (t6VarU != null && (v6Var4 = t6VarU.b) != null && (l6Var3 = v6Var4.a) != null) {
            zh zhVarA4 = l6Var3.a();
            this.f0 = zhVarA4;
            zhVarA4.a(this);
            j(this.f0);
        }
        if (t6VarU != null && (v6Var3 = t6VarU.b) != null && (l6Var2 = v6Var3.b) != null) {
            zh zhVarA5 = l6Var2.a();
            this.g0 = zhVarA5;
            zhVarA5.a(this);
            j(this.g0);
        }
        if (t6VarU != null && (v6Var2 = t6VarU.b) != null && (l6Var = v6Var2.c) != null) {
            zh zhVarA6 = l6Var.a();
            this.h0 = zhVarA6;
            zhVarA6.a(this);
            j(this.h0);
        }
        if (t6VarU == null || (v6Var = t6VarU.b) == null) {
            return;
        }
        this.T = v6Var.d;
    }

    public final String P(String str, int i) {
        int iCodePointAt = str.codePointAt(i);
        int iCharCount = Character.charCount(iCodePointAt) + i;
        while (iCharCount < str.length()) {
            int iCodePointAt2 = str.codePointAt(iCharCount);
            if (!f0(iCodePointAt2)) {
                break;
            }
            iCharCount += Character.charCount(iCodePointAt2);
            iCodePointAt = (iCodePointAt * 31) + iCodePointAt2;
        }
        long j = iCodePointAt;
        if (this.N.c(j)) {
            return (String) this.N.d(j);
        }
        this.E.setLength(0);
        while (i < iCharCount) {
            int iCodePointAt3 = str.codePointAt(i);
            this.E.appendCodePoint(iCodePointAt3);
            i += Character.charCount(iCodePointAt3);
        }
        String string = this.E.toString();
        this.N.h(j, string);
        return string;
    }

    public final void Q(xm0 xm0Var, int i, int i2) {
        zh zhVar = this.V;
        if (zhVar != null) {
            this.K.setColor(((Integer) zhVar.h()).intValue());
        } else if (this.U == null || !d0(i2)) {
            this.K.setColor(xm0Var.h);
        } else {
            this.K.setColor(((Integer) this.U.h()).intValue());
        }
        zh zhVar2 = this.X;
        if (zhVar2 != null) {
            this.L.setColor(((Integer) zhVar2.h()).intValue());
        } else if (this.W == null || !d0(i2)) {
            this.L.setColor(xm0Var.i);
        } else {
            this.L.setColor(((Integer) this.W.h()).intValue());
        }
        int iIntValue = 100;
        int iIntValue2 = this.x.k() == null ? 100 : ((Integer) this.x.k().h()).intValue();
        if (this.c0 != null && d0(i2)) {
            iIntValue = ((Integer) this.c0.h()).intValue();
        }
        int iRound = Math.round(((((iIntValue2 * 255.0f) / 100.0f) * (iIntValue / 100.0f)) * i) / 255.0f);
        this.K.setAlpha(iRound);
        this.L.setAlpha(iRound);
        zh zhVar3 = this.Z;
        if (zhVar3 != null) {
            this.L.setStrokeWidth(((Float) zhVar3.h()).floatValue());
        } else if (this.Y == null || !d0(i2)) {
            this.L.setStrokeWidth(xm0Var.j * uy4.e());
        } else {
            this.L.setStrokeWidth(((Float) this.Y.h()).floatValue());
        }
    }

    public final void R(String str, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawText(str, 0, str.length(), 0.0f, 0.0f, paint);
    }

    public final void S(b41 b41Var, float f, xm0 xm0Var, Canvas canvas, int i, int i2) {
        Q(xm0Var, i2, i);
        List listA0 = a0(b41Var);
        for (int i3 = 0; i3 < listA0.size(); i3++) {
            Path path = ((o20) listA0.get(i3)).getPath();
            path.computeBounds(this.I, false);
            this.J.reset();
            this.J.preTranslate(0.0f, (-xm0Var.g) * uy4.e());
            this.J.preScale(f, f);
            path.transform(this.J);
            if (xm0Var.k) {
                V(path, this.K, canvas);
                V(path, this.L, canvas);
            } else {
                V(path, this.L, canvas);
                V(path, this.K, canvas);
            }
        }
    }

    public final void T(String str, xm0 xm0Var, Canvas canvas, int i, int i2) {
        Q(xm0Var, i2, i);
        if (xm0Var.k) {
            R(str, this.K, canvas);
            R(str, this.L, canvas);
        } else {
            R(str, this.L, canvas);
            R(str, this.K, canvas);
        }
    }

    public final void U(String str, xm0 xm0Var, Canvas canvas, float f, int i, int i2) {
        this.O.clear();
        int length = 0;
        while (length < str.length()) {
            String strP = P(str, length);
            this.O.add(strP);
            length += strP.length();
        }
        int i3 = 0;
        while (i3 < this.O.size()) {
            this.F.setLength(0);
            this.F.append((String) this.O.get(i3));
            int i4 = i3 + 1;
            while (i4 < this.O.size()) {
                String str2 = (String) this.O.get(i4);
                if (this.e0(str2)) {
                    this.F.insert(0, str2);
                    i4++;
                }
            }
            String string = this.F.toString();
            rm4 rm4Var = this;
            rm4Var.T(string, xm0Var, canvas, i + i3, i2);
            canvas.translate(rm4Var.K.measureText(string) + f, 0.0f);
            i3 = i4;
            this = rm4Var;
        }
    }

    public final void V(Path path, Paint paint, Canvas canvas) {
        if (paint.getColor() == 0) {
            return;
        }
        if (paint.getStyle() == Paint.Style.STROKE && paint.getStrokeWidth() == 0.0f) {
            return;
        }
        canvas.drawPath(path, paint);
    }

    public final void W(String str, xm0 xm0Var, y31 y31Var, Canvas canvas, float f, float f2, float f3, int i) {
        rm4 rm4Var;
        xm0 xm0Var2;
        Canvas canvas2;
        float f4;
        int i2;
        int i3 = 0;
        while (i3 < str.length()) {
            b41 b41Var = (b41) this.S.c().d(b41.c(str.charAt(i3), y31Var.a(), y31Var.c()));
            if (b41Var == null) {
                rm4Var = this;
                xm0Var2 = xm0Var;
                canvas2 = canvas;
                f4 = f2;
                i2 = i;
            } else {
                rm4Var = this;
                xm0Var2 = xm0Var;
                canvas2 = canvas;
                f4 = f2;
                i2 = i;
                rm4Var.S(b41Var, f4, xm0Var2, canvas2, i3, i2);
                canvas2.translate((((float) b41Var.b()) * f4 * uy4.e()) + f3, 0.0f);
            }
            i3++;
            this = rm4Var;
            f2 = f4;
            xm0Var = xm0Var2;
            canvas = canvas2;
            i = i2;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0088  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void X(defpackage.xm0 r18, defpackage.y31 r19, android.graphics.Canvas r20, int r21) {
        /*
            Method dump skipped, instruction units count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rm4.X(xm0, y31, android.graphics.Canvas, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void Y(defpackage.xm0 r17, android.graphics.Matrix r18, defpackage.y31 r19, android.graphics.Canvas r20, int r21) {
        /*
            r16 = this;
            r0 = r16
            r7 = r17
            zh r1 = r0.d0
            if (r1 == 0) goto L13
            java.lang.Object r1 = r1.h()
            java.lang.Float r1 = (java.lang.Float) r1
            float r1 = r1.floatValue()
            goto L15
        L13:
            float r1 = r7.c
        L15:
            r2 = 1120403456(0x42c80000, float:100.0)
            float r4 = r1 / r2
            float r8 = defpackage.uy4.g(r18)
            java.lang.String r1 = r7.a
            java.util.List r9 = r0.b0(r1)
            int r10 = r9.size()
            int r1 = r7.e
            float r1 = (float) r1
            r2 = 1092616192(0x41200000, float:10.0)
            float r1 = r1 / r2
            zh r2 = r0.b0
            if (r2 == 0) goto L3e
            java.lang.Object r2 = r2.h()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
        L3b:
            float r1 = r1 + r2
        L3c:
            r5 = r1
            goto L4d
        L3e:
            zh r2 = r0.a0
            if (r2 == 0) goto L3c
            java.lang.Object r2 = r2.h()
            java.lang.Float r2 = (java.lang.Float) r2
            float r2 = r2.floatValue()
            goto L3b
        L4d:
            r11 = 0
            r1 = -1
            r12 = r1
            r13 = r11
        L51:
            if (r13 >= r10) goto Lb0
            java.lang.Object r1 = r9.get(r13)
            java.lang.String r1 = (java.lang.String) r1
            android.graphics.PointF r2 = r7.m
            if (r2 != 0) goto L5f
            r2 = 0
            goto L61
        L5f:
            float r2 = r2.x
        L61:
            r6 = 1
            r3 = r19
            java.util.List r14 = r0.i0(r1, r2, r3, r4, r5, r6)
            r15 = r11
        L69:
            int r1 = r14.size()
            if (r15 >= r1) goto La6
            java.lang.Object r1 = r14.get(r15)
            rm4$d r1 = (rm4.d) r1
            int r12 = r12 + 1
            r20.save()
            float r2 = rm4.d.a(r1)
            r3 = r20
            boolean r2 = r0.g0(r3, r7, r12, r2)
            if (r2 == 0) goto L98
            java.lang.String r1 = rm4.d.b(r1)
            r6 = r4
            r2 = r7
            r4 = r3
            r7 = r5
            r5 = r8
            r3 = r19
            r8 = r21
            r0.W(r1, r2, r3, r4, r5, r6, r7, r8)
            r4 = r6
            goto L9a
        L98:
            r7 = r5
            r5 = r8
        L9a:
            r20.restore()
            int r15 = r15 + 1
            r0 = r16
            r8 = r5
            r5 = r7
            r7 = r17
            goto L69
        La6:
            r7 = r5
            r5 = r8
            int r13 = r13 + 1
            r0 = r16
            r5 = r7
            r7 = r17
            goto L51
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rm4.Y(xm0, android.graphics.Matrix, y31, android.graphics.Canvas, int):void");
    }

    public final d Z(int i) {
        int size = this.P.size();
        while (true) {
            List list = this.P;
            if (size >= i) {
                return (d) list.get(i - 1);
            }
            list.add(new d(null));
            size++;
        }
    }

    public final List a0(b41 b41Var) {
        if (this.M.containsKey(b41Var)) {
            return (List) this.M.get(b41Var);
        }
        List listA = b41Var.a();
        int size = listA.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(new o20(this.R, this, (f54) listA.get(i), this.S));
        }
        this.M.put(b41Var, arrayList);
        return arrayList;
    }

    public final List b0(String str) {
        return Arrays.asList(str.replaceAll(HTTP.CRLF, "\r").replaceAll("\u0003", "\r").replaceAll("\n", "\r").split("\r"));
    }

    public final Typeface c0(y31 y31Var) {
        Typeface typeface;
        zh zhVar = this.e0;
        if (zhVar != null && (typeface = (Typeface) zhVar.h()) != null) {
            return typeface;
        }
        Typeface typefaceZ = this.R.Z(y31Var);
        return typefaceZ != null ? typefaceZ : y31Var.d();
    }

    @Override // defpackage.bi, defpackage.mo0
    public void d(RectF rectF, Matrix matrix, boolean z) {
        super.d(rectF, matrix, z);
        rectF.set(0.0f, 0.0f, this.S.b().width(), this.S.b().height());
    }

    public final boolean d0(int i) {
        int length = ((xm0) this.Q.h()).a.length();
        zh zhVar = this.f0;
        if (zhVar == null || this.g0 == null) {
            return true;
        }
        int iMin = Math.min(((Integer) zhVar.h()).intValue(), ((Integer) this.g0.h()).intValue());
        int iMax = Math.max(((Integer) this.f0.h()).intValue(), ((Integer) this.g0.h()).intValue());
        zh zhVar2 = this.h0;
        if (zhVar2 != null) {
            int iIntValue = ((Integer) zhVar2.h()).intValue();
            iMin += iIntValue;
            iMax += iIntValue;
        }
        if (this.T == um4.INDEX) {
            return i >= iMin && i < iMax;
        }
        float f = (i / length) * 100.0f;
        return f >= ((float) iMin) && f < ((float) iMax);
    }

    public final boolean e0(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.getDirectionality(str.codePointAt(i)) == 2) {
                return true;
            }
        }
        return false;
    }

    public final boolean f0(int i) {
        return Character.getType(i) == 16 || Character.getType(i) == 27 || Character.getType(i) == 6 || Character.getType(i) == 28 || Character.getType(i) == 8 || Character.getType(i) == 19;
    }

    @Override // defpackage.bi, defpackage.ar1
    public void g(Object obj, y22 y22Var) {
        super.g(obj, y22Var);
        if (obj == q22.a) {
            zh zhVar = this.V;
            if (zhVar != null) {
                H(zhVar);
            }
            if (y22Var == null) {
                this.V = null;
                return;
            }
            bz4 bz4Var = new bz4(y22Var);
            this.V = bz4Var;
            bz4Var.a(this);
            j(this.V);
            return;
        }
        if (obj == q22.b) {
            zh zhVar2 = this.X;
            if (zhVar2 != null) {
                H(zhVar2);
            }
            if (y22Var == null) {
                this.X = null;
                return;
            }
            bz4 bz4Var2 = new bz4(y22Var);
            this.X = bz4Var2;
            bz4Var2.a(this);
            j(this.X);
            return;
        }
        if (obj == q22.v) {
            zh zhVar3 = this.Z;
            if (zhVar3 != null) {
                H(zhVar3);
            }
            if (y22Var == null) {
                this.Z = null;
                return;
            }
            bz4 bz4Var3 = new bz4(y22Var);
            this.Z = bz4Var3;
            bz4Var3.a(this);
            j(this.Z);
            return;
        }
        if (obj == q22.w) {
            zh zhVar4 = this.b0;
            if (zhVar4 != null) {
                H(zhVar4);
            }
            if (y22Var == null) {
                this.b0 = null;
                return;
            }
            bz4 bz4Var4 = new bz4(y22Var);
            this.b0 = bz4Var4;
            bz4Var4.a(this);
            j(this.b0);
            return;
        }
        if (obj == q22.I) {
            zh zhVar5 = this.d0;
            if (zhVar5 != null) {
                H(zhVar5);
            }
            if (y22Var == null) {
                this.d0 = null;
                return;
            }
            bz4 bz4Var5 = new bz4(y22Var);
            this.d0 = bz4Var5;
            bz4Var5.a(this);
            j(this.d0);
            return;
        }
        if (obj != q22.P) {
            if (obj == q22.R) {
                this.Q.s(y22Var);
                return;
            }
            return;
        }
        zh zhVar6 = this.e0;
        if (zhVar6 != null) {
            H(zhVar6);
        }
        if (y22Var == null) {
            this.e0 = null;
            return;
        }
        bz4 bz4Var6 = new bz4(y22Var);
        this.e0 = bz4Var6;
        bz4Var6.a(this);
        j(this.e0);
    }

    public final boolean g0(Canvas canvas, xm0 xm0Var, int i, float f) {
        PointF pointF = xm0Var.l;
        PointF pointF2 = xm0Var.m;
        float fE = uy4.e();
        float f2 = (i * xm0Var.f * fE) + (pointF == null ? 0.0f : (xm0Var.f * fE) + pointF.y);
        if (this.R.F() && pointF2 != null && pointF != null && f2 >= pointF.y + pointF2.y + xm0Var.c) {
            return false;
        }
        float f3 = pointF == null ? 0.0f : pointF.x;
        float f4 = pointF2 != null ? pointF2.x : 0.0f;
        int i2 = c.a[xm0Var.d.ordinal()];
        if (i2 == 1) {
            canvas.translate(f3, f2);
        } else if (i2 == 2) {
            canvas.translate((f3 + f4) - f, f2);
        } else if (i2 == 3) {
            canvas.translate((f3 + (f4 / 2.0f)) - (f / 2.0f), f2);
        }
        return true;
    }

    public final String h0(String str) {
        Bidi bidi = new Bidi(str, -2);
        int runCount = bidi.getRunCount();
        byte[] bArr = new byte[runCount];
        Integer[] numArr = new Integer[runCount];
        for (int i = 0; i < runCount; i++) {
            bArr[i] = (byte) bidi.getRunLevel(i);
            numArr[i] = Integer.valueOf(i);
        }
        Bidi.reorderVisually(bArr, 0, numArr, 0, runCount);
        this.G.setLength(0);
        for (int i2 = 0; i2 < runCount; i2++) {
            int iIntValue = numArr[i2].intValue();
            int runStart = bidi.getRunStart(iIntValue);
            int runLimit = bidi.getRunLimit(iIntValue);
            int runLevel = bidi.getRunLevel(iIntValue);
            String strSubstring = str.substring(runStart, runLimit);
            if ((runLevel & 1) == 0) {
                this.G.append(strSubstring);
            } else {
                this.H.setLength(0);
                int length = 0;
                while (length < strSubstring.length()) {
                    String strP = P(strSubstring, length);
                    this.H.insert(0, strP);
                    length += strP.length();
                }
                this.G.append((CharSequence) this.H);
            }
        }
        return this.G.toString();
    }

    public final List i0(String str, float f, y31 y31Var, float f2, float f3, boolean z) {
        float fMeasureText;
        int i = 0;
        int i2 = 0;
        boolean z2 = false;
        int i3 = 0;
        float f4 = 0.0f;
        float f5 = 0.0f;
        float f6 = 0.0f;
        for (int i4 = 0; i4 < str.length(); i4++) {
            char cCharAt = str.charAt(i4);
            if (z) {
                b41 b41Var = (b41) this.S.c().d(b41.c(cCharAt, y31Var.a(), y31Var.c()));
                if (b41Var != null) {
                    fMeasureText = ((float) b41Var.b()) * f2 * uy4.e();
                }
            } else {
                fMeasureText = this.K.measureText(str.substring(i4, i4 + 1));
            }
            float f7 = fMeasureText + f3;
            if (cCharAt == ' ') {
                z2 = true;
                f6 = f7;
            } else if (z2) {
                z2 = false;
                i3 = i4;
                f5 = f7;
            } else {
                f5 += f7;
            }
            f4 += f7;
            if (f > 0.0f && f4 >= f && cCharAt != ' ') {
                i++;
                d dVarZ = Z(i);
                if (i3 == i2) {
                    dVarZ.c(str.substring(i2, i4).trim(), (f4 - f7) - ((r9.length() - r7.length()) * f6));
                    i2 = i4;
                    i3 = i2;
                    f4 = f7;
                    f5 = f4;
                } else {
                    dVarZ.c(str.substring(i2, i3 - 1).trim(), ((f4 - f5) - ((r7.length() - r13.length()) * f6)) - f6);
                    f4 = f5;
                    i2 = i3;
                }
            }
        }
        if (f4 > 0.0f) {
            i++;
            Z(i).c(str.substring(i2), f4);
        }
        return this.P.subList(0, i);
    }

    @Override // defpackage.bi
    public void u(Canvas canvas, Matrix matrix, int i, dp0 dp0Var) {
        Canvas canvas2;
        xm0 xm0Var = (xm0) this.Q.h();
        y31 y31Var = (y31) this.S.g().get(xm0Var.b);
        if (y31Var == null) {
            return;
        }
        canvas.save();
        canvas.concat(matrix);
        Q(xm0Var, i, 0);
        if (this.R.V0()) {
            canvas2 = canvas;
            Y(xm0Var, matrix, y31Var, canvas2, i);
        } else {
            canvas2 = canvas;
            X(xm0Var, y31Var, canvas2, i);
        }
        canvas2.restore();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d {
        public String a;
        public float b;

        public d() {
            this.a = "";
            this.b = 0.0f;
        }

        public void c(String str, float f) {
            this.a = str;
            this.b = f;
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }
}
