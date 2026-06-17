package defpackage;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Array;
import java.util.BitSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public abstract class ap1 {
    public static final char[] m = {'n', 'u', 'l', 'l'};
    public static final char[] n = {'t', 'r', 'u', 'e'};
    public static final char[] o = {'f', 'a', 'l', 's', 'e'};
    public static final char[] p = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static final char[] q = {'\\', 'u', '0', '0'};
    public static final char[] r = {'\\', 'u'};
    public final Appendable a;
    public boolean j;
    public String k;
    public int f = 0;
    public BitSet g = new BitSet();
    public int h = 0;
    public boolean i = true;
    public int l = 0;
    public final OutputStream b = null;
    public final boolean c = false;
    public final StringBuilder d = new StringBuilder(10240);
    public final byte[] e = null;

    public ap1(Appendable appendable, String str) {
        this.a = appendable;
        this.k = str;
    }

    public ap1 A(String str) {
        if (str == null) {
            return l();
        }
        s();
        i(str);
        return g();
    }

    public ap1 B(String str, int i) {
        t(str);
        v(Integer.toString(i));
        return g();
    }

    public ap1 C(String str, Number number) {
        if (number == null) {
            return m(str);
        }
        t(str);
        v(number.toString());
        return g();
    }

    public ap1 D(String str, Object obj) {
        if (obj == null) {
            return m(str);
        }
        if (obj instanceof String) {
            return E(str, (String) obj);
        }
        if (obj instanceof Number) {
            return C(str, (Number) obj);
        }
        if (obj instanceof Boolean) {
            return F(str, ((Boolean) obj).booleanValue());
        }
        if (obj instanceof Collection) {
            return e(str, (Collection) obj);
        }
        if (obj instanceof Map) {
            return p(str, (Map) obj);
        }
        if (!obj.getClass().isArray()) {
            throw new bp1("Unable to handle type: " + obj.getClass());
        }
        int length = Array.getLength(obj);
        d(str);
        for (int i = 0; i < length; i++) {
            z(Array.get(obj, i));
        }
        return j();
    }

    public ap1 E(String str, String str2) {
        if (str2 == null) {
            return m(str);
        }
        t(str);
        i(str2);
        return g();
    }

    public ap1 F(String str, boolean z) {
        t(str);
        w(z ? n : o);
        return g();
    }

    public ap1 G(boolean z) {
        s();
        w(z ? n : o);
        return g();
    }

    public final void a() {
        for (int i = 0; i < this.l; i++) {
            v(this.k);
        }
    }

    public final void b() {
        u('\n');
    }

    public ap1 c() {
        s();
        BitSet bitSet = this.g;
        int i = this.h;
        this.h = i + 1;
        bitSet.set(i, this.j);
        this.j = false;
        this.i = true;
        u('[');
        return g();
    }

    public ap1 d(String str) {
        t(str);
        BitSet bitSet = this.g;
        int i = this.h;
        this.h = i + 1;
        bitSet.set(i, this.j);
        this.j = false;
        this.i = true;
        u('[');
        return g();
    }

    public ap1 e(String str, Collection collection) {
        if (str == null) {
            c();
        } else {
            d(str);
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            z(it.next());
        }
        return j();
    }

    public ap1 f(Collection collection) {
        return e(null, collection);
    }

    public final ap1 g() {
        return this;
    }

    public void h() {
        if (this.h > 0) {
            throw new bp1("Unclosed JSON objects and/or arrays when closing writer");
        }
        if (this.i) {
            throw new bp1("Nothing was written to the JSON writer");
        }
        k();
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0173  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i(java.lang.String r11) {
        /*
            Method dump skipped, instruction units count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ap1.i(java.lang.String):void");
    }

    public ap1 j() {
        char c;
        if (this.h == 0) {
            throw new bp1("Invalid call to end()");
        }
        if (this.j) {
            if (this.k != null) {
                this.l--;
                b();
                a();
            }
            c = '}';
        } else {
            c = ']';
        }
        u(c);
        this.i = false;
        BitSet bitSet = this.g;
        int i = this.h - 1;
        this.h = i;
        this.j = bitSet.get(i);
        return g();
    }

    public final void k() {
        try {
            if (this.c) {
                this.b.write(this.e, 0, this.f);
                this.f = 0;
            } else {
                this.a.append(this.d.toString());
                this.d.setLength(0);
            }
        } catch (IOException e) {
            throw new bp1(e);
        }
    }

    public ap1 l() {
        s();
        w(m);
        return g();
    }

    public ap1 m(String str) {
        t(str);
        w(m);
        return g();
    }

    public ap1 n() {
        s();
        BitSet bitSet = this.g;
        int i = this.h;
        this.h = i + 1;
        bitSet.set(i, this.j);
        this.j = true;
        this.i = true;
        u('{');
        if (this.k != null) {
            this.l++;
            b();
        }
        return g();
    }

    public ap1 o(String str) {
        t(str);
        BitSet bitSet = this.g;
        int i = this.h;
        this.h = i + 1;
        bitSet.set(i, this.j);
        this.j = true;
        this.i = true;
        u('{');
        if (this.k != null) {
            this.l++;
            b();
        }
        return g();
    }

    public ap1 p(String str, Map map) {
        if (str == null) {
            n();
        } else {
            o(str);
        }
        for (Map.Entry entry : map.entrySet()) {
            Object value = entry.getValue();
            if (!(entry.getKey() instanceof String)) {
                StringBuilder sb = new StringBuilder("Invalid key type for map: ");
                sb.append(entry.getKey() == null ? "null" : entry.getKey().getClass());
                throw new bp1(sb.toString());
            }
            D((String) entry.getKey(), value);
        }
        return j();
    }

    public ap1 q(Map map) {
        return p(null, map);
    }

    public final void r() {
        if (this.i) {
            this.i = false;
            return;
        }
        if (this.h == 0) {
            throw new bp1("Invalid call to emit a value in a finished JSON writer");
        }
        u(',');
        if (this.k == null || !this.j) {
            return;
        }
        b();
    }

    public final void s() {
        if (this.j) {
            throw new bp1("Invalid call to emit a keyless value while writing an object");
        }
        r();
    }

    public final void t(String str) {
        if (!this.j) {
            throw new bp1("Invalid call to emit a key value while not writing an object");
        }
        r();
        if (this.k != null) {
            a();
        }
        i(str);
        u(':');
    }

    public final void u(char c) {
        if (!this.c) {
            this.d.append(c);
            if (this.d.length() > 10240) {
                k();
                return;
            }
            return;
        }
        if (this.f + 1 > 10240) {
            k();
        }
        byte[] bArr = this.e;
        int i = this.f;
        this.f = i + 1;
        bArr[i] = (byte) c;
    }

    public final void v(String str) {
        if (!this.c) {
            this.d.append(str);
            if (this.d.length() > 10240) {
                k();
                return;
            }
            return;
        }
        int length = str.length();
        if (this.f + length > 10240) {
            k();
        }
        for (int i = 0; i < length; i++) {
            byte[] bArr = this.e;
            int i2 = this.f;
            this.f = i2 + 1;
            bArr[i2] = (byte) str.charAt(i);
        }
    }

    public final void w(char[] cArr) {
        if (!this.c) {
            this.d.append(cArr);
            if (this.d.length() > 10240) {
                k();
                return;
            }
            return;
        }
        if (this.f + cArr.length > 10240) {
            k();
        }
        for (char c : cArr) {
            byte[] bArr = this.e;
            int i = this.f;
            this.f = i + 1;
            bArr[i] = (byte) c;
        }
    }

    public final boolean x(char c) {
        if (c < ' ') {
            return true;
        }
        if (c < 128 || c >= 160) {
            return c >= 8192 && c < 8448;
        }
        return true;
    }

    public ap1 y(Number number) {
        s();
        if (number == null) {
            w(m);
        } else {
            v(number.toString());
        }
        return g();
    }

    public ap1 z(Object obj) {
        if (obj == null) {
            return l();
        }
        if (obj instanceof String) {
            return A((String) obj);
        }
        if (obj instanceof Number) {
            return y((Number) obj);
        }
        if (obj instanceof Boolean) {
            return G(((Boolean) obj).booleanValue());
        }
        if (obj instanceof Collection) {
            return f((Collection) obj);
        }
        if (obj instanceof Map) {
            return q((Map) obj);
        }
        if (!obj.getClass().isArray()) {
            throw new bp1("Unable to handle type: " + obj.getClass());
        }
        int length = Array.getLength(obj);
        c();
        for (int i = 0; i < length; i++) {
            z(Array.get(obj, i));
        }
        return j();
    }
}
