package defpackage;

import com.hierynomus.protocol.commons.buffer.Buffer;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class sh {
    public static final sh a = new c("base64()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/", '=');
    public static final sh b = new c("base64Url()", "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_", '=');
    public static final sh c = new e("base32()", "ABCDEFGHIJKLMNOPQRSTUVWXYZ234567", '=');
    public static final sh d = new e("base32Hex()", "0123456789ABCDEFGHIJKLMNOPQRSTUV", '=');
    public static final sh e = new b("base16()", "0123456789ABCDEF");

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends IOException {
        public d(String str) {
            super(str);
        }
    }

    public static sh a() {
        return e;
    }

    public static byte[] h(byte[] bArr, int i) {
        if (i == bArr.length) {
            return bArr;
        }
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, 0, bArr2, 0, i);
        return bArr2;
    }

    public final byte[] b(CharSequence charSequence) {
        try {
            return c(charSequence);
        } catch (d e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    public final byte[] c(CharSequence charSequence) {
        CharSequence charSequenceM = m(charSequence);
        byte[] bArr = new byte[k(charSequenceM.length())];
        return h(bArr, d(bArr, charSequenceM));
    }

    public abstract int d(byte[] bArr, CharSequence charSequence);

    public String e(byte[] bArr) {
        return f(bArr, 0, bArr.length);
    }

    public final String f(byte[] bArr, int i, int i2) {
        gg3.u(i, i + i2, bArr.length);
        StringBuilder sb = new StringBuilder(l(i2));
        try {
            g(sb, bArr, i, i2);
            return sb.toString();
        } catch (IOException e2) {
            throw new AssertionError(e2);
        }
    }

    public abstract void g(Appendable appendable, byte[] bArr, int i, int i2);

    public abstract sh i();

    public abstract sh j();

    public abstract int k(int i);

    public abstract int l(int i);

    public abstract CharSequence m(CharSequence charSequence);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends e {
        public c(a aVar, Character ch) {
            super(aVar, ch);
            gg3.d(aVar.b.length == 64);
        }

        @Override // sh.e, defpackage.sh
        public int d(byte[] bArr, CharSequence charSequence) throws d {
            gg3.q(bArr);
            CharSequence charSequenceM = m(charSequence);
            if (!this.f.h(charSequenceM.length())) {
                throw new d("Invalid input length " + charSequenceM.length());
            }
            int i = 0;
            int i2 = 0;
            while (i < charSequenceM.length()) {
                int i3 = i + 2;
                int iC = (this.f.c(charSequenceM.charAt(i)) << 18) | (this.f.c(charSequenceM.charAt(i + 1)) << 12);
                int i4 = i2 + 1;
                bArr[i2] = (byte) (iC >>> 16);
                if (i3 < charSequenceM.length()) {
                    int i5 = i + 3;
                    int iC2 = iC | (this.f.c(charSequenceM.charAt(i3)) << 6);
                    int i6 = i2 + 2;
                    bArr[i4] = (byte) ((iC2 >>> 8) & 255);
                    if (i5 < charSequenceM.length()) {
                        i += 4;
                        i2 += 3;
                        bArr[i6] = (byte) ((iC2 | this.f.c(charSequenceM.charAt(i5))) & 255);
                    } else {
                        i2 = i6;
                        i = i5;
                    }
                } else {
                    i2 = i4;
                    i = i3;
                }
            }
            return i2;
        }

        @Override // sh.e, defpackage.sh
        public void g(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            gg3.q(appendable);
            int i3 = i + i2;
            gg3.u(i, i3, bArr.length);
            while (i2 >= 3) {
                int i4 = i + 2;
                int i5 = ((bArr[i + 1] & 255) << 8) | ((bArr[i] & 255) << 16);
                i += 3;
                int i6 = i5 | (bArr[i4] & 255);
                appendable.append(this.f.d(i6 >>> 18));
                appendable.append(this.f.d((i6 >>> 12) & 63));
                appendable.append(this.f.d((i6 >>> 6) & 63));
                appendable.append(this.f.d(i6 & 63));
                i2 -= 3;
            }
            if (i < i3) {
                n(appendable, bArr, i, i3 - i);
            }
        }

        @Override // sh.e
        public sh o(a aVar, Character ch) {
            return new c(aVar, ch);
        }

        public c(String str, String str2, Character ch) {
            this(new a(str, str2.toCharArray()), ch);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e extends sh {
        public final a f;
        public final Character g;
        public volatile sh h;
        public volatile sh i;

        public e(a aVar, Character ch) {
            this.f = (a) gg3.q(aVar);
            gg3.k(ch == null || !aVar.j(ch.charValue()), "Padding character %s was already in alphabet", ch);
            this.g = ch;
        }

        @Override // defpackage.sh
        public int d(byte[] bArr, CharSequence charSequence) throws d {
            a aVar;
            gg3.q(bArr);
            CharSequence charSequenceM = m(charSequence);
            if (!this.f.h(charSequenceM.length())) {
                throw new d("Invalid input length " + charSequenceM.length());
            }
            int i = 0;
            int i2 = 0;
            while (i < charSequenceM.length()) {
                long jC = 0;
                int i3 = 0;
                int i4 = 0;
                while (true) {
                    aVar = this.f;
                    if (i3 >= aVar.e) {
                        break;
                    }
                    jC <<= aVar.d;
                    if (i + i3 < charSequenceM.length()) {
                        jC |= (long) this.f.c(charSequenceM.charAt(i4 + i));
                        i4++;
                    }
                    i3++;
                }
                int i5 = aVar.f;
                int i6 = (i5 * 8) - (i4 * aVar.d);
                int i7 = (i5 - 1) * 8;
                while (i7 >= i6) {
                    bArr[i2] = (byte) ((jC >>> i7) & 255);
                    i7 -= 8;
                    i2++;
                }
                i += this.f.e;
            }
            return i2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof e) {
                e eVar = (e) obj;
                if (this.f.equals(eVar.f) && Objects.equals(this.g, eVar.g)) {
                    return true;
                }
            }
            return false;
        }

        @Override // defpackage.sh
        public void g(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            gg3.q(appendable);
            gg3.u(i, i + i2, bArr.length);
            int i3 = 0;
            while (i3 < i2) {
                n(appendable, bArr, i + i3, Math.min(this.f.f, i2 - i3));
                i3 += this.f.f;
            }
        }

        public int hashCode() {
            return Objects.hashCode(this.g) ^ this.f.hashCode();
        }

        @Override // defpackage.sh
        public sh i() {
            sh shVarO = this.i;
            if (shVarO == null) {
                a aVarG = this.f.g();
                shVarO = aVarG == this.f ? this : o(aVarG, this.g);
                this.i = shVarO;
            }
            return shVarO;
        }

        @Override // defpackage.sh
        public sh j() {
            sh shVarO = this.h;
            if (shVarO == null) {
                a aVarI = this.f.i();
                shVarO = aVarI == this.f ? this : o(aVarI, this.g);
                this.h = shVarO;
            }
            return shVarO;
        }

        @Override // defpackage.sh
        public int k(int i) {
            return (int) (((((long) this.f.d) * ((long) i)) + 7) / 8);
        }

        @Override // defpackage.sh
        public int l(int i) {
            a aVar = this.f;
            return aVar.e * pk1.b(i, aVar.f, RoundingMode.CEILING);
        }

        @Override // defpackage.sh
        public CharSequence m(CharSequence charSequence) {
            gg3.q(charSequence);
            Character ch = this.g;
            if (ch == null) {
                return charSequence;
            }
            char cCharValue = ch.charValue();
            int length = charSequence.length() - 1;
            while (length >= 0 && charSequence.charAt(length) == cCharValue) {
                length--;
            }
            return charSequence.subSequence(0, length + 1);
        }

        public void n(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            gg3.q(appendable);
            gg3.u(i, i + i2, bArr.length);
            int i3 = 0;
            gg3.d(i2 <= this.f.f);
            long j = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                j = (j | ((long) (bArr[i + i4] & 255))) << 8;
            }
            int i5 = ((i2 + 1) * 8) - this.f.d;
            while (i3 < i2 * 8) {
                a aVar = this.f;
                appendable.append(aVar.d(((int) (j >>> (i5 - i3))) & aVar.c));
                i3 += this.f.d;
            }
            if (this.g != null) {
                while (i3 < this.f.f * 8) {
                    appendable.append(this.g.charValue());
                    i3 += this.f.d;
                }
            }
        }

        public sh o(a aVar, Character ch) {
            return new e(aVar, ch);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder("BaseEncoding.");
            sb.append(this.f);
            if (8 % this.f.d != 0) {
                if (this.g == null) {
                    sb.append(".omitPadding()");
                } else {
                    sb.append(".withPadChar('");
                    sb.append(this.g);
                    sb.append("')");
                }
            }
            return sb.toString();
        }

        public e(String str, String str2, Character ch) {
            this(new a(str, str2.toCharArray()), ch);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends e {
        public final char[] j;

        public b(a aVar) {
            super(aVar, null);
            this.j = new char[512];
            gg3.d(aVar.b.length == 16);
            for (int i = 0; i < 256; i++) {
                this.j[i] = aVar.d(i >>> 4);
                this.j[i | Buffer.DEFAULT_SIZE] = aVar.d(i & 15);
            }
        }

        @Override // sh.e, defpackage.sh
        public int d(byte[] bArr, CharSequence charSequence) throws d {
            gg3.q(bArr);
            if (charSequence.length() % 2 == 1) {
                throw new d("Invalid input length " + charSequence.length());
            }
            int i = 0;
            int i2 = 0;
            while (i < charSequence.length()) {
                bArr[i2] = (byte) ((this.f.c(charSequence.charAt(i)) << 4) | this.f.c(charSequence.charAt(i + 1)));
                i += 2;
                i2++;
            }
            return i2;
        }

        @Override // sh.e, defpackage.sh
        public void g(Appendable appendable, byte[] bArr, int i, int i2) throws IOException {
            gg3.q(appendable);
            gg3.u(i, i + i2, bArr.length);
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = bArr[i + i3] & 255;
                appendable.append(this.j[i4]);
                appendable.append(this.j[i4 | Buffer.DEFAULT_SIZE]);
            }
        }

        @Override // sh.e
        public sh o(a aVar, Character ch) {
            return new b(aVar);
        }

        public b(String str, String str2) {
            this(new a(str, str2.toCharArray()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final String a;
        public final char[] b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final byte[] g;
        public final boolean[] h;
        public final boolean i;

        public a(String str, char[] cArr, byte[] bArr, boolean z) {
            this.a = (String) gg3.q(str);
            this.b = (char[]) gg3.q(cArr);
            try {
                int iE = pk1.e(cArr.length, RoundingMode.UNNECESSARY);
                this.d = iE;
                int iNumberOfTrailingZeros = Integer.numberOfTrailingZeros(iE);
                int i = 1 << (3 - iNumberOfTrailingZeros);
                this.e = i;
                this.f = iE >> iNumberOfTrailingZeros;
                this.c = cArr.length - 1;
                this.g = bArr;
                boolean[] zArr = new boolean[i];
                for (int i2 = 0; i2 < this.f; i2++) {
                    zArr[pk1.b(i2 * 8, this.d, RoundingMode.CEILING)] = true;
                }
                this.h = zArr;
                this.i = z;
            } catch (ArithmeticException e) {
                throw new IllegalArgumentException("Illegal alphabet length " + cArr.length, e);
            }
        }

        public static byte[] b(char[] cArr) {
            byte[] bArr = new byte[128];
            Arrays.fill(bArr, (byte) -1);
            for (int i = 0; i < cArr.length; i++) {
                char c = cArr[i];
                boolean z = true;
                gg3.f(c < 128, "Non-ASCII character: %s", c);
                if (bArr[c] != -1) {
                    z = false;
                }
                gg3.f(z, "Duplicate character: %s", c);
                bArr[c] = (byte) i;
            }
            return bArr;
        }

        public int c(char c) throws d {
            if (c > 127) {
                throw new d("Unrecognized character: 0x" + Integer.toHexString(c));
            }
            byte b = this.g[c];
            if (b != -1) {
                return b;
            }
            if (c > ' ' && c != 127) {
                throw new d("Unrecognized character: " + c);
            }
            throw new d("Unrecognized character: 0x" + Integer.toHexString(c));
        }

        public char d(int i) {
            return this.b[i];
        }

        public final boolean e() {
            for (char c : this.b) {
                if (xa.c(c)) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof a) {
                a aVar = (a) obj;
                if (this.i == aVar.i && Arrays.equals(this.b, aVar.b)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean f() {
            for (char c : this.b) {
                if (xa.d(c)) {
                    return true;
                }
            }
            return false;
        }

        public a g() {
            if (this.i) {
                return this;
            }
            byte[] bArr = this.g;
            byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
            int i = 65;
            while (true) {
                if (i > 90) {
                    return new a(this.a + ".ignoreCase()", this.b, bArrCopyOf, true);
                }
                int i2 = i | 32;
                byte[] bArr2 = this.g;
                byte b = bArr2[i];
                byte b2 = bArr2[i2];
                if (b == -1) {
                    bArrCopyOf[i] = b2;
                } else {
                    gg3.x(b2 == -1, "Can't ignoreCase() since '%s' and '%s' encode different values", (char) i, (char) i2);
                    bArrCopyOf[i2] = b;
                }
                i++;
            }
        }

        public boolean h(int i) {
            return this.h[i % this.e];
        }

        public int hashCode() {
            return Arrays.hashCode(this.b) + (this.i ? 1231 : 1237);
        }

        public a i() {
            if (!f()) {
                return this;
            }
            gg3.w(!e(), "Cannot call lowerCase() on a mixed-case alphabet");
            char[] cArr = new char[this.b.length];
            int i = 0;
            while (true) {
                char[] cArr2 = this.b;
                if (i >= cArr2.length) {
                    break;
                }
                cArr[i] = xa.e(cArr2[i]);
                i++;
            }
            a aVar = new a(this.a + ".lowerCase()", cArr);
            return this.i ? aVar.g() : aVar;
        }

        public boolean j(char c) {
            byte[] bArr = this.g;
            return c < bArr.length && bArr[c] != -1;
        }

        public String toString() {
            return this.a;
        }

        public a(String str, char[] cArr) {
            this(str, cArr, b(cArr), false);
        }
    }
}
