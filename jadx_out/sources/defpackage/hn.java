package defpackage;

import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class hn implements Iterable, Serializable {
    public static final hn g = new j(bl1.c);
    public static final f h;
    public static final Comparator i;
    public int f = 0;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends c {
        public int f = 0;
        public final int g;

        public a() {
            this.g = hn.this.size();
        }

        @Override // hn.g
        public byte a() {
            int i = this.f;
            if (i < this.g) {
                this.f = i + 1;
                return hn.this.l(i);
            }
            bo.a();
            return (byte) 0;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f < this.g;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements Comparator {
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(hn hnVar, hn hnVar2) {
            g gVarN = hnVar.n();
            g gVarN2 = hnVar2.n();
            while (gVarN.hasNext() && gVarN2.hasNext()) {
                int iCompare = Integer.compare(hn.x(gVarN.a()), hn.x(gVarN2.a()));
                if (iCompare != 0) {
                    return iCompare;
                }
            }
            return Integer.compare(hnVar.size(), hnVar2.size());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class c implements g {
        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Byte next() {
            return Byte.valueOf(a());
        }

        @Override // java.util.Iterator
        public final void remove() {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e extends i {
        public final byte[] j;
        public final int k;
        public final int l;

        public e(byte[] bArr, int i, int i2) {
            super(null);
            hn.d(i, i + i2, bArr.length);
            this.j = bArr;
            this.k = i;
            this.l = i2;
        }

        @Override // defpackage.hn
        public void F(cn cnVar) {
            cnVar.a(this.j, this.k, this.l);
        }

        public boolean I(hn hnVar, int i, int i2) {
            if (i2 > hnVar.size()) {
                throw new IllegalArgumentException("Length too large: " + i2 + size());
            }
            int i3 = i + i2;
            if (i3 <= hnVar.size()) {
                if (hnVar instanceof j) {
                    return hn.s(this.j, this.k, ((j) hnVar).j, i, i2);
                }
                if (hnVar instanceof e) {
                    e eVar = (e) hnVar;
                    return hn.s(this.j, this.k, eVar.j, eVar.k + i, i2);
                }
                hn hnVarU = hnVar.u(i, i3);
                int i4 = this.k;
                return hnVarU.equals(u(i4, i2 + i4));
            }
            throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + hnVar.size());
        }

        @Override // defpackage.hn
        public void j(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.j, this.k + i, bArr, i2, i3);
        }

        @Override // defpackage.hn
        public boolean k(hn hnVar) {
            return ((hnVar instanceof j) || (hnVar instanceof e)) ? I(hnVar, 0, size()) : hnVar.k(this);
        }

        @Override // defpackage.hn
        public byte l(int i) {
            return this.j[this.k + i];
        }

        @Override // defpackage.hn
        public boolean m() {
            byte[] bArr = this.j;
            int i = this.k;
            return wx4.f(bArr, i, this.l + i);
        }

        @Override // defpackage.hn
        public hv p() {
            return hv.n(this.j, this.k, this.l, true);
        }

        @Override // defpackage.hn
        public int q(int i, int i2, int i3) {
            return bl1.h(i, this.j, this.k + i2, i3);
        }

        @Override // defpackage.hn
        public int size() {
            return this.l;
        }

        @Override // defpackage.hn
        public hn u(int i, int i2) {
            int iD = hn.d(i, i2, this.l);
            return iD == 0 ? hn.g : new e(this.j, this.k + i, iD);
        }

        @Override // defpackage.hn
        public String z(Charset charset) {
            return new String(this.j, this.k, this.l, charset);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface f {
        byte[] a(byte[] bArr, int i, int i2);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface g extends Iterator {
        byte a();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class j extends i {
        public final byte[] j;

        public j(byte[] bArr) {
            super(null);
            bArr.getClass();
            this.j = bArr;
        }

        @Override // defpackage.hn
        public void F(cn cnVar) {
            cnVar.a(this.j, 0, size());
        }

        public boolean H(hn hnVar, int i, int i2) {
            if (i2 > hnVar.size()) {
                throw new IllegalArgumentException("Length too large: " + i2 + size());
            }
            int i3 = i + i2;
            if (i3 <= hnVar.size()) {
                if (hnVar instanceof j) {
                    return hn.s(this.j, 0, ((j) hnVar).j, i, i2);
                }
                if (!(hnVar instanceof e)) {
                    return hnVar.u(i, i3).equals(u(0, i2));
                }
                e eVar = (e) hnVar;
                return hn.s(this.j, 0, eVar.j, eVar.k + i, i2);
            }
            throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + hnVar.size());
        }

        @Override // defpackage.hn
        public void j(byte[] bArr, int i, int i2, int i3) {
            System.arraycopy(this.j, i, bArr, i2, i3);
        }

        @Override // defpackage.hn
        public final boolean k(hn hnVar) {
            return hnVar instanceof j ? Arrays.equals(this.j, ((j) hnVar).j) : hnVar instanceof e ? H(hnVar, 0, size()) : hnVar.k(this);
        }

        @Override // defpackage.hn
        public byte l(int i) {
            return this.j[i];
        }

        @Override // defpackage.hn
        public boolean m() {
            return wx4.e(this.j);
        }

        @Override // defpackage.hn
        public hv p() {
            return hv.n(this.j, 0, size(), true);
        }

        @Override // defpackage.hn
        public int q(int i, int i2, int i3) {
            return bl1.h(i, this.j, i2, i3);
        }

        @Override // defpackage.hn
        public int size() {
            return this.j.length;
        }

        @Override // defpackage.hn
        public hn u(int i, int i2) {
            int iD = hn.d(i, i2, size());
            return iD == 0 ? hn.g : new e(this.j, i, iD);
        }

        @Override // defpackage.hn
        public String z(Charset charset) {
            return new String(this.j, charset);
        }
    }

    static {
        a aVar = null;
        h = s5.c() ? new k(aVar) : new d(aVar);
        i = new b();
    }

    public static hn C(byte[] bArr) {
        try {
            return E(bArr, false);
        } catch (ol1 e2) {
            throw new AssertionError("Expected no InvalidProtocolBufferException as data UTF8 validity is not checked.", e2);
        }
    }

    public static hn D(byte[] bArr, int i2, int i3, boolean z) throws ol1 {
        if (!z || wx4.f(bArr, i2, i2 + i3)) {
            return new e(bArr, i2, i3);
        }
        throw ol1.d();
    }

    public static hn E(byte[] bArr, boolean z) throws ol1 {
        if (bArr.length == 0) {
            return g;
        }
        if (!z || wx4.e(bArr)) {
            return new j(bArr);
        }
        throw ol1.d();
    }

    public static int d(int i2, int i3, int i4) {
        int i5 = i3 - i2;
        if ((i2 | i3 | i5 | (i4 - i3)) >= 0) {
            return i5;
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("Beginning index: " + i2 + " < 0");
        }
        if (i3 < i2) {
            ug.a("Beginning index larger than ending index: ", i2, ", ", i3);
            return 0;
        }
        ug.a("End index: ", i3, " >= ", i4);
        return 0;
    }

    public static hn e(byte[] bArr, int i2, int i3) {
        try {
            return f(bArr, i2, i3, false);
        } catch (ol1 e2) {
            throw new AssertionError("Expected no InvalidProtocolBufferException as data UTF8 validity is not checked.", e2);
        }
    }

    public static hn f(byte[] bArr, int i2, int i3, boolean z) throws ol1 {
        if (i3 == 0) {
            return g;
        }
        int i4 = i2 + i3;
        d(i2, i4, bArr.length);
        if (!z || wx4.f(bArr, i2, i4)) {
            return new j(h.a(bArr, i2, i3));
        }
        throw ol1.d();
    }

    public static hn g(String str) {
        return str.isEmpty() ? g : new j(str.getBytes(bl1.a));
    }

    public static h o(int i2) {
        return new h(i2, null);
    }

    public static boolean s(byte[] bArr, int i2, byte[] bArr2, int i3, int i4) {
        int i5 = i2 + i4;
        d(i2, i5, bArr.length);
        d(i3, i4 + i3, bArr2.length);
        while (i2 < i5) {
            if (bArr[i2] != bArr2[i3]) {
                return false;
            }
            i2++;
            i3++;
        }
        return true;
    }

    public static int x(byte b2) {
        return b2 & 255;
    }

    public final String A() {
        return y(bl1.a);
    }

    public final String B() {
        if (size() <= 50) {
            return lm4.a(this);
        }
        return lm4.a(u(0, 47)) + "...";
    }

    public abstract void F(cn cnVar);

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof hn)) {
            return false;
        }
        hn hnVar = (hn) obj;
        int size = size();
        if (size != hnVar.size()) {
            return false;
        }
        if (size == 0) {
            return true;
        }
        int iR = r();
        int iR2 = hnVar.r();
        if (iR == 0 || iR2 == 0 || iR == iR2) {
            return k(hnVar);
        }
        return false;
    }

    public final int hashCode() {
        int iQ = this.f;
        if (iQ == 0) {
            int size = size();
            iQ = q(size, 0, size);
            if (iQ == 0) {
                iQ = 1;
            }
            this.f = iQ;
        }
        return iQ;
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public abstract void j(byte[] bArr, int i2, int i3, int i4);

    public abstract boolean k(hn hnVar);

    public abstract byte l(int i2);

    public abstract boolean m();

    public g n() {
        return new a();
    }

    public abstract hv p();

    public abstract int q(int i2, int i3, int i4);

    public final int r() {
        return this.f;
    }

    public abstract int size();

    public final String toString() {
        return String.format(Locale.ROOT, "<ByteString@%s size=%d contents=\"%s\">", Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(size()), B());
    }

    public abstract hn u(int i2, int i3);

    public final byte[] w() {
        int size = size();
        if (size == 0) {
            return bl1.c;
        }
        byte[] bArr = new byte[size];
        j(bArr, 0, 0, size);
        return bArr;
    }

    public final String y(Charset charset) {
        return isEmpty() ? "" : z(charset);
    }

    public abstract String z(Charset charset);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d implements f {
        public d() {
        }

        @Override // hn.f
        public byte[] a(byte[] bArr, int i, int i2) {
            return Arrays.copyOfRange(bArr, i, i2 + i);
        }

        public /* synthetic */ d(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class i extends hn {
        public /* synthetic */ i(a aVar) {
            this();
        }

        @Override // java.lang.Iterable
        public /* bridge */ /* synthetic */ Iterator iterator() {
            return super.n();
        }

        public i() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class k implements f {
        public k() {
        }

        @Override // hn.f
        public byte[] a(byte[] bArr, int i, int i2) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            return bArr2;
        }

        public /* synthetic */ k(a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class h {
        public final jv a;
        public final byte[] b;

        public h(int i) {
            byte[] bArr = new byte[i];
            this.b = bArr;
            this.a = jv.S(bArr);
        }

        public hn a() {
            this.a.c();
            return new j(this.b);
        }

        public jv b() {
            return this.a;
        }

        public /* synthetic */ h(int i, a aVar) {
            this(i);
        }
    }
}
