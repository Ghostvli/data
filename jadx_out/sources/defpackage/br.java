package defpackage;

import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import defpackage.br;
import defpackage.p50;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import okio.Utf8;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class br extends dr {
    public final r73 h = new r73();
    public final q73 i = new q73();
    public int j = -1;
    public final boolean k;
    public final int l;
    public final b[] m;
    public b n;
    public List o;
    public List p;
    public c q;
    public int r;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public static final Comparator c = new Comparator() { // from class: ar
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Integer.compare(((br.a) obj2).b, ((br.a) obj).b);
            }
        };
        public final p50 a;
        public final int b;

        public a(CharSequence charSequence, Layout.Alignment alignment, float f, int i, int i2, float f2, int i3, float f3, boolean z, int i4, int i5) {
            p50.b bVarN = new p50.b().o(charSequence).p(alignment).h(f, i).i(i2).k(f2).l(i3).n(f3);
            if (z) {
                bVarN.s(i4);
            }
            this.a = bVarN.a();
            this.b = i5;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public static final int[] A;
        public static final boolean[] B;
        public static final int[] C;
        public static final int[] D;
        public static final int[] E;
        public static final int[] F;
        public static final int v = h(2, 2, 2, 0);
        public static final int w;
        public static final int x;
        public static final int[] y;
        public static final int[] z;
        public final List a = new ArrayList();
        public final SpannableStringBuilder b = new SpannableStringBuilder();
        public boolean c;
        public boolean d;
        public int e;
        public boolean f;
        public int g;
        public int h;
        public int i;
        public int j;
        public int k;
        public int l;
        public int m;
        public int n;
        public int o;
        public int p;
        public int q;
        public int r;
        public int s;
        public int t;
        public int u;

        static {
            int iH = h(0, 0, 0, 0);
            w = iH;
            int iH2 = h(0, 0, 0, 3);
            x = iH2;
            y = new int[]{0, 0, 0, 0, 0, 2, 0};
            z = new int[]{0, 0, 0, 0, 0, 0, 2};
            A = new int[]{3, 3, 3, 3, 3, 3, 1};
            B = new boolean[]{false, false, false, true, true, true, false};
            C = new int[]{iH, iH2, iH, iH, iH2, iH, iH};
            D = new int[]{0, 1, 2, 3, 4, 3, 4};
            E = new int[]{0, 0, 0, 0, 0, 3, 3};
            F = new int[]{iH, iH, iH, iH, iH, iH2, iH2};
        }

        public b() {
            l();
        }

        public static int g(int i, int i2, int i3) {
            return h(i, i2, i3, 0);
        }

        /* JADX WARN: Removed duplicated region for block: B:9:0x001b  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static int h(int r4, int r5, int r6, int r7) {
            /*
                r0 = 4
                defpackage.gg3.o(r4, r0)
                defpackage.gg3.o(r5, r0)
                defpackage.gg3.o(r6, r0)
                defpackage.gg3.o(r7, r0)
                r0 = 0
                r1 = 1
                r2 = 255(0xff, float:3.57E-43)
                if (r7 == 0) goto L1b
                if (r7 == r1) goto L1b
                r3 = 2
                if (r7 == r3) goto L1f
                r3 = 3
                if (r7 == r3) goto L1d
            L1b:
                r7 = r2
                goto L21
            L1d:
                r7 = r0
                goto L21
            L1f:
                r7 = 127(0x7f, float:1.78E-43)
            L21:
                if (r4 <= r1) goto L25
                r4 = r2
                goto L26
            L25:
                r4 = r0
            L26:
                if (r5 <= r1) goto L2a
                r5 = r2
                goto L2b
            L2a:
                r5 = r0
            L2b:
                if (r6 <= r1) goto L2e
                r0 = r2
            L2e:
                int r4 = android.graphics.Color.argb(r7, r4, r5, r0)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: br.b.h(int, int, int, int):int");
        }

        public void a(char c) {
            if (c != '\n') {
                this.b.append(c);
                return;
            }
            this.a.add(d());
            this.b.clear();
            if (this.o != -1) {
                this.o = 0;
            }
            if (this.p != -1) {
                this.p = 0;
            }
            if (this.q != -1) {
                this.q = 0;
            }
            if (this.s != -1) {
                this.s = 0;
            }
            while (true) {
                if (this.a.size() < this.j && this.a.size() < 15) {
                    this.u = this.a.size();
                    return;
                }
                this.a.remove(0);
            }
        }

        public void b() {
            int length = this.b.length();
            if (length > 0) {
                this.b.delete(length - 1, length);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r7v10 */
        /* JADX WARN: Type inference failed for: r7v7 */
        /* JADX WARN: Type inference failed for: r7v8 */
        /* JADX WARN: Type inference failed for: r7v9, types: [int] */
        public a c() {
            Layout.Alignment alignment;
            float f;
            float f2;
            boolean z2;
            if (j()) {
                return null;
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            for (int i = 0; i < this.a.size(); i++) {
                spannableStringBuilder.append((CharSequence) this.a.get(i));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append((CharSequence) d());
            int i2 = this.k;
            int i3 = 1;
            if (i2 == 0) {
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else if (i2 == 1) {
                alignment = Layout.Alignment.ALIGN_OPPOSITE;
            } else if (i2 != 2) {
                if (i2 != 3) {
                    qn.a("Unexpected justification value: ", this.k);
                    return null;
                }
                alignment = Layout.Alignment.ALIGN_NORMAL;
            } else {
                alignment = Layout.Alignment.ALIGN_CENTER;
            }
            boolean z3 = this.f;
            int i4 = this.h;
            if (z3) {
                f = i4 / 99.0f;
                f2 = this.g / 99.0f;
            } else {
                f = i4 / 209.0f;
                f2 = this.g / 74.0f;
            }
            float f3 = (f * 0.9f) + 0.05f;
            float f4 = (f2 * 0.9f) + 0.05f;
            int i5 = this.i;
            if (i5 / 3 == 0) {
                z2 = true;
                i3 = 0;
            } else if (i5 / 3 == 1) {
                z2 = true;
            } else {
                z2 = true;
                i3 = 2;
            }
            ?? r7 = i5 % 3 == 0 ? 0 : i5 % 3 == z2 ? z2 : 2;
            if (this.n == w) {
                z2 = false;
            }
            return new a(spannableStringBuilder, alignment, f4, 0, i3, f3, r7, -3.4028235E38f, z2, this.n, this.e);
        }

        public SpannableString d() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.b);
            int length = spannableStringBuilder.length();
            if (length > 0) {
                if (this.o != -1) {
                    spannableStringBuilder.setSpan(new StyleSpan(2), this.o, length, 33);
                }
                if (this.p != -1) {
                    spannableStringBuilder.setSpan(new UnderlineSpan(), this.p, length, 33);
                }
                if (this.q != -1) {
                    spannableStringBuilder.setSpan(new ForegroundColorSpan(this.r), this.q, length, 33);
                }
                if (this.s != -1) {
                    spannableStringBuilder.setSpan(new BackgroundColorSpan(this.t), this.s, length, 33);
                }
            }
            return new SpannableString(spannableStringBuilder);
        }

        public void e() {
            this.a.clear();
            this.b.clear();
            this.o = -1;
            this.p = -1;
            this.q = -1;
            this.s = -1;
            this.u = 0;
        }

        public void f(boolean z2, int i, boolean z3, int i2, int i3, int i4, int i5, int i6, int i7) {
            this.c = true;
            this.d = z2;
            this.e = i;
            this.f = z3;
            this.g = i2;
            this.h = i3;
            this.i = i5;
            int i8 = i4 + 1;
            if (this.j != i8) {
                this.j = i8;
                while (true) {
                    if (this.a.size() < this.j && this.a.size() < 15) {
                        break;
                    } else {
                        this.a.remove(0);
                    }
                }
            }
            if (i6 != 0 && this.l != i6) {
                this.l = i6;
                int i9 = i6 - 1;
                q(C[i9], x, B[i9], 0, z[i9], A[i9], y[i9]);
            }
            if (i7 == 0 || this.m == i7) {
                return;
            }
            this.m = i7;
            int i10 = i7 - 1;
            m(0, 1, 1, false, false, E[i10], D[i10]);
            n(v, F[i10], w);
        }

        public boolean i() {
            return this.c;
        }

        public boolean j() {
            if (i()) {
                return this.a.isEmpty() && this.b.length() == 0;
            }
            return true;
        }

        public boolean k() {
            return this.d;
        }

        public void l() {
            e();
            this.c = false;
            this.d = false;
            this.e = 4;
            this.f = false;
            this.g = 0;
            this.h = 0;
            this.i = 0;
            this.j = 15;
            this.k = 0;
            this.l = 0;
            this.m = 0;
            int i = w;
            this.n = i;
            this.r = v;
            this.t = i;
        }

        public void m(int i, int i2, int i3, boolean z2, boolean z3, int i4, int i5) {
            if (this.o != -1) {
                if (!z2) {
                    this.b.setSpan(new StyleSpan(2), this.o, this.b.length(), 33);
                    this.o = -1;
                }
            } else if (z2) {
                this.o = this.b.length();
            }
            if (this.p == -1) {
                if (z3) {
                    this.p = this.b.length();
                }
            } else {
                if (z3) {
                    return;
                }
                this.b.setSpan(new UnderlineSpan(), this.p, this.b.length(), 33);
                this.p = -1;
            }
        }

        public void n(int i, int i2, int i3) {
            if (this.q != -1 && this.r != i) {
                this.b.setSpan(new ForegroundColorSpan(this.r), this.q, this.b.length(), 33);
            }
            if (i != v) {
                this.q = this.b.length();
                this.r = i;
            }
            if (this.s != -1 && this.t != i2) {
                this.b.setSpan(new BackgroundColorSpan(this.t), this.s, this.b.length(), 33);
            }
            if (i2 != w) {
                this.s = this.b.length();
                this.t = i2;
            }
        }

        public void o(int i, int i2) {
            if (this.u != i) {
                a('\n');
            }
            this.u = i;
        }

        public void p(boolean z2) {
            this.d = z2;
        }

        public void q(int i, int i2, boolean z2, int i3, int i4, int i5, int i6) {
            this.n = i;
            this.k = i6;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public final int a;
        public final int b;
        public final byte[] c;
        public int d = 0;

        public c(int i, int i2) {
            this.a = i;
            this.b = i2;
            this.c = new byte[(i2 * 2) - 1];
        }
    }

    public br(int i, List list) {
        this.l = i == -1 ? 1 : i;
        this.k = list != null && gv.G(list);
        this.m = new b[8];
        int i2 = 0;
        while (true) {
            b[] bVarArr = this.m;
            if (i2 >= 8) {
                this.n = bVarArr[0];
                return;
            } else {
                bVarArr[i2] = new b();
                i2++;
            }
        }
    }

    private void G() {
        for (int i = 0; i < 8; i++) {
            this.m[i].l();
        }
    }

    private List r() {
        a aVarC;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < 8; i++) {
            if (!this.m[i].j() && this.m[i].k() && (aVarC = this.m[i].c()) != null) {
                arrayList.add(aVarC);
            }
        }
        Collections.sort(arrayList, a.c);
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.add(((a) arrayList.get(i2)).a);
        }
        return Collections.unmodifiableList(arrayList2);
    }

    public final void A(int i) {
        if (i == 160) {
            this.n.a((char) 13252);
            return;
        }
        xz1.i("Cea708Decoder", "Invalid G3 character: " + i);
        this.n.a('_');
    }

    public final void B() {
        this.n.m(this.i.h(4), this.i.h(2), this.i.h(2), this.i.g(), this.i.g(), this.i.h(3), this.i.h(3));
    }

    public final void C() {
        int iH = b.h(this.i.h(2), this.i.h(2), this.i.h(2), this.i.h(2));
        int iH2 = b.h(this.i.h(2), this.i.h(2), this.i.h(2), this.i.h(2));
        this.i.r(2);
        this.n.n(iH, iH2, b.g(this.i.h(2), this.i.h(2), this.i.h(2)));
    }

    public final void D() {
        this.i.r(4);
        int iH = this.i.h(4);
        this.i.r(2);
        this.n.o(iH, this.i.h(6));
    }

    public final void E() {
        int iH = b.h(this.i.h(2), this.i.h(2), this.i.h(2), this.i.h(2));
        int iH2 = this.i.h(2);
        int iG = b.g(this.i.h(2), this.i.h(2), this.i.h(2));
        if (this.i.g()) {
            iH2 |= 4;
        }
        boolean zG = this.i.g();
        int iH3 = this.i.h(2);
        int iH4 = this.i.h(2);
        int iH5 = this.i.h(2);
        this.i.r(8);
        this.n.q(iH, iG, zG, iH2, iH3, iH4, iH5);
    }

    public final void F() {
        c cVar = this.q;
        if (cVar.d != (cVar.b * 2) - 1) {
            xz1.b("Cea708Decoder", "DtvCcPacket ended prematurely; size is " + ((this.q.b * 2) - 1) + ", but current index is " + this.q.d + " (sequence number " + this.q.a + ");");
        }
        q73 q73Var = this.i;
        c cVar2 = this.q;
        q73Var.o(cVar2.c, cVar2.d);
        boolean z = false;
        while (true) {
            if (this.i.b() <= 0) {
                break;
            }
            int iH = this.i.h(3);
            int iH2 = this.i.h(5);
            if (iH == 7) {
                this.i.r(2);
                iH = this.i.h(6);
                if (iH < 7) {
                    xz1.i("Cea708Decoder", "Invalid extended service number: " + iH);
                }
            }
            if (iH2 != 0) {
                int i = this.l;
                q73 q73Var2 = this.i;
                if (iH != i) {
                    q73Var2.s(iH2);
                } else {
                    int iE = q73Var2.e() + (iH2 * 8);
                    while (this.i.e() < iE) {
                        int iH3 = this.i.h(8);
                        if (iH3 == 16) {
                            int iH4 = this.i.h(8);
                            if (iH4 <= 31) {
                                u(iH4);
                            } else {
                                if (iH4 <= 127) {
                                    z(iH4);
                                } else if (iH4 <= 159) {
                                    v(iH4);
                                } else if (iH4 <= 255) {
                                    A(iH4);
                                } else {
                                    xz1.i("Cea708Decoder", "Invalid extended command: " + iH4);
                                }
                                z = true;
                            }
                        } else if (iH3 <= 31) {
                            s(iH3);
                        } else {
                            if (iH3 <= 127) {
                                x(iH3);
                            } else if (iH3 <= 159) {
                                t(iH3);
                            } else if (iH3 <= 255) {
                                y(iH3);
                            } else {
                                xz1.i("Cea708Decoder", "Invalid base command: " + iH3);
                            }
                            z = true;
                        }
                    }
                }
            } else if (iH != 0) {
                xz1.i("Cea708Decoder", "serviceNumber is non-zero (" + iH + ") when blockSize is 0");
            }
        }
        if (z) {
            this.o = r();
        }
    }

    @Override // defpackage.dr, defpackage.zh4
    public /* bridge */ /* synthetic */ void c(long j) {
        super.c(j);
    }

    @Override // defpackage.dr, defpackage.fb0
    public void flush() {
        super.flush();
        this.o = null;
        this.p = null;
        this.r = 0;
        this.n = this.m[0];
        G();
        this.q = null;
    }

    @Override // defpackage.dr
    public yh4 g() {
        List list = this.o;
        this.p = list;
        return new er((List) gg3.q(list));
    }

    @Override // defpackage.dr
    public void h(gi4 gi4Var) {
        ByteBuffer byteBuffer = (ByteBuffer) gg3.q(gi4Var.data);
        this.h.d0(byteBuffer.array(), byteBuffer.limit());
        while (this.h.a() >= 3) {
            int iQ = this.h.Q();
            int i = iQ & 3;
            boolean z = (iQ & 4) == 4;
            byte bQ = (byte) this.h.Q();
            byte bQ2 = (byte) this.h.Q();
            if (i == 2 || i == 3) {
                if (z) {
                    if (i == 3) {
                        q();
                        int i2 = (bQ & 192) >> 6;
                        int i3 = this.j;
                        if (i3 != -1 && i2 != (i3 + 1) % 4) {
                            G();
                            xz1.i("Cea708Decoder", "Sequence number discontinuity. previous=" + this.j + " current=" + i2);
                        }
                        this.j = i2;
                        int i4 = bQ & Utf8.REPLACEMENT_BYTE;
                        if (i4 == 0) {
                            i4 = 64;
                        }
                        c cVar = new c(i2, i4);
                        this.q = cVar;
                        byte[] bArr = cVar.c;
                        int i5 = cVar.d;
                        cVar.d = i5 + 1;
                        bArr[i5] = bQ2;
                    } else {
                        gg3.d(i == 2);
                        c cVar2 = this.q;
                        if (cVar2 == null) {
                            xz1.d("Cea708Decoder", "Encountered DTVCC_PACKET_DATA before DTVCC_PACKET_START");
                        } else {
                            byte[] bArr2 = cVar2.c;
                            int i6 = cVar2.d;
                            int i7 = i6 + 1;
                            cVar2.d = i7;
                            bArr2[i6] = bQ;
                            cVar2.d = i6 + 2;
                            bArr2[i7] = bQ2;
                        }
                    }
                    c cVar3 = this.q;
                    if (cVar3.d == (cVar3.b * 2) - 1) {
                        q();
                    }
                }
            }
        }
    }

    @Override // defpackage.dr
    /* JADX INFO: renamed from: i */
    public /* bridge */ /* synthetic */ gi4 d() {
        return super.d();
    }

    @Override // defpackage.dr
    /* JADX INFO: renamed from: j */
    public /* bridge */ /* synthetic */ hi4 a() {
        return super.a();
    }

    @Override // defpackage.dr
    public boolean m() {
        return this.o != this.p;
    }

    @Override // defpackage.dr
    /* JADX INFO: renamed from: n */
    public /* bridge */ /* synthetic */ void f(gi4 gi4Var) {
        super.f(gi4Var);
    }

    public final void q() {
        if (this.q == null) {
            return;
        }
        F();
        this.q = null;
    }

    @Override // defpackage.dr, defpackage.fb0
    public /* bridge */ /* synthetic */ void release() {
        super.release();
    }

    public final void s(int i) {
        if (i != 0) {
            if (i == 3) {
                this.o = r();
                return;
            }
            if (i == 8) {
                this.n.b();
                return;
            }
            switch (i) {
                case 12:
                    G();
                    break;
                case 13:
                    this.n.a('\n');
                    break;
                case 14:
                    break;
                default:
                    if (i >= 17 && i <= 23) {
                        xz1.i("Cea708Decoder", "Currently unsupported COMMAND_EXT1 Command: " + i);
                        this.i.r(8);
                    } else if (i >= 24 && i <= 31) {
                        xz1.i("Cea708Decoder", "Currently unsupported COMMAND_P16 Command: " + i);
                        this.i.r(16);
                    } else {
                        xz1.i("Cea708Decoder", "Invalid C0 command: " + i);
                    }
                    break;
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public final void t(int i) {
        int i2 = 1;
        switch (i) {
            case 128:
            case Token.DEFAULT /* 129 */:
            case 130:
            case Token.DO /* 131 */:
            case Token.FOR /* 132 */:
            case Token.BREAK /* 133 */:
            case Token.CONTINUE /* 134 */:
            case Token.VAR /* 135 */:
                int i3 = i - 128;
                if (this.r != i3) {
                    this.r = i3;
                    this.n = this.m[i3];
                }
                break;
            case Token.WITH /* 136 */:
                while (i2 <= 8) {
                    if (this.i.g()) {
                        this.m[8 - i2].e();
                    }
                    i2++;
                }
                break;
            case Token.CATCH /* 137 */:
                for (int i4 = 1; i4 <= 8; i4++) {
                    if (this.i.g()) {
                        this.m[8 - i4].p(true);
                    }
                }
                break;
            case Token.FINALLY /* 138 */:
                while (i2 <= 8) {
                    if (this.i.g()) {
                        this.m[8 - i2].p(false);
                    }
                    i2++;
                }
                break;
            case Token.VOID /* 139 */:
                for (int i5 = 1; i5 <= 8; i5++) {
                    if (this.i.g()) {
                        this.m[8 - i5].p(!r0.k());
                    }
                }
                break;
            case 140:
                while (i2 <= 8) {
                    if (this.i.g()) {
                        this.m[8 - i2].l();
                    }
                    i2++;
                }
                break;
            case Token.EMPTY /* 141 */:
                this.i.r(8);
                break;
            case Token.COMPUTED_PROPERTY /* 142 */:
                break;
            case Token.BLOCK /* 143 */:
                G();
                break;
            case Token.LABEL /* 144 */:
                if (this.n.i()) {
                    B();
                } else {
                    this.i.r(16);
                }
                break;
            case Token.TARGET /* 145 */:
                if (this.n.i()) {
                    C();
                } else {
                    this.i.r(24);
                }
                break;
            case Token.LOOP /* 146 */:
                if (this.n.i()) {
                    D();
                } else {
                    this.i.r(16);
                }
                break;
            case Token.EXPR_VOID /* 147 */:
            case Token.EXPR_RESULT /* 148 */:
            case Token.JSR /* 149 */:
            case 150:
            default:
                xz1.i("Cea708Decoder", "Invalid C1 command: " + i);
                break;
            case Token.TYPEOFNAME /* 151 */:
                if (this.n.i()) {
                    E();
                } else {
                    this.i.r(32);
                }
                break;
            case Token.USE_STACK /* 152 */:
            case Token.SETPROP_OP /* 153 */:
            case Token.SETELEM_OP /* 154 */:
            case Token.LOCAL_BLOCK /* 155 */:
            case Token.SET_REF_OP /* 156 */:
            case Token.DOTDOT /* 157 */:
            case Token.COLONCOLON /* 158 */:
            case Token.XML /* 159 */:
                int i6 = i - 152;
                w(i6);
                if (this.r != i6) {
                    this.r = i6;
                    this.n = this.m[i6];
                }
                break;
        }
    }

    public final void u(int i) {
        if (i <= 7) {
            return;
        }
        if (i <= 15) {
            this.i.r(8);
        } else if (i <= 23) {
            this.i.r(16);
        } else if (i <= 31) {
            this.i.r(24);
        }
    }

    public final void v(int i) {
        if (i <= 135) {
            this.i.r(32);
            return;
        }
        if (i <= 143) {
            this.i.r(40);
        } else if (i <= 159) {
            this.i.r(2);
            this.i.r(this.i.h(6) * 8);
        }
    }

    public final void w(int i) {
        b bVar = this.m[i];
        this.i.r(2);
        boolean zG = this.i.g();
        this.i.r(2);
        int iH = this.i.h(3);
        boolean zG2 = this.i.g();
        int iH2 = this.i.h(7);
        int iH3 = this.i.h(8);
        int iH4 = this.i.h(4);
        int iH5 = this.i.h(4);
        this.i.r(2);
        this.i.r(6);
        this.i.r(2);
        bVar.f(zG, iH, zG2, iH2, iH3, iH5, iH4, this.i.h(3), this.i.h(3));
    }

    public final void x(int i) {
        b bVar = this.n;
        if (i == 127) {
            bVar.a((char) 9835);
        } else {
            bVar.a((char) (i & 255));
        }
    }

    public final void y(int i) {
        this.n.a((char) (i & 255));
    }

    public final void z(int i) {
        if (i == 32) {
            this.n.a(' ');
            return;
        }
        if (i == 33) {
            this.n.a((char) 160);
            return;
        }
        if (i == 37) {
            this.n.a((char) 8230);
            return;
        }
        if (i == 42) {
            this.n.a((char) 352);
            return;
        }
        if (i == 44) {
            this.n.a((char) 338);
            return;
        }
        if (i == 63) {
            this.n.a((char) 376);
            return;
        }
        if (i == 57) {
            this.n.a((char) 8482);
            return;
        }
        if (i == 58) {
            this.n.a((char) 353);
            return;
        }
        if (i == 60) {
            this.n.a((char) 339);
            return;
        }
        if (i == 61) {
            this.n.a((char) 8480);
            return;
        }
        switch (i) {
            case 48:
                this.n.a((char) 9608);
                break;
            case Token.FALSE /* 49 */:
                this.n.a((char) 8216);
                break;
            case 50:
                this.n.a((char) 8217);
                break;
            case Token.SHEQ /* 51 */:
                this.n.a((char) 8220);
                break;
            case Token.SHNE /* 52 */:
                this.n.a((char) 8221);
                break;
            case Token.REGEXP /* 53 */:
                this.n.a((char) 8226);
                break;
            default:
                switch (i) {
                    case Token.AND /* 118 */:
                        this.n.a((char) 8539);
                        break;
                    case Token.INC /* 119 */:
                        this.n.a((char) 8540);
                        break;
                    case 120:
                        this.n.a((char) 8541);
                        break;
                    case Token.DOT /* 121 */:
                        this.n.a((char) 8542);
                        break;
                    case Token.FUNCTION /* 122 */:
                        this.n.a((char) 9474);
                        break;
                    case Token.EXPORT /* 123 */:
                        this.n.a((char) 9488);
                        break;
                    case Token.IMPORT /* 124 */:
                        this.n.a((char) 9492);
                        break;
                    case Token.IF /* 125 */:
                        this.n.a((char) 9472);
                        break;
                    case 126:
                        this.n.a((char) 9496);
                        break;
                    case 127:
                        this.n.a((char) 9484);
                        break;
                    default:
                        xz1.i("Cea708Decoder", "Invalid G2 character: " + i);
                        break;
                }
                break;
        }
    }
}
