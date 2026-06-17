package org.mozilla.classfile;

import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.a01;
import defpackage.i10;
import defpackage.jl;
import java.util.HashMap;
import okhttp3.internal.http2.Settings;
import org.mozilla.classfile.ClassFileWriter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public ClassFileWriter a;
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final HashMap d = new HashMap();
    public final HashMap e = new HashMap();
    public final HashMap f = new HashMap();
    public final HashMap g = new HashMap();
    public final HashMap j = new HashMap();
    public final HashMap k = new HashMap();
    public int i = 1;
    public byte[] l = new byte[Buffer.DEFAULT_SIZE];
    public int h = 0;

    public a(ClassFileWriter classFileWriter) {
        this.a = classFileWriter;
    }

    public short a(String str) {
        String str2;
        int iIntValue = ((Integer) this.f.getOrDefault(str, -1)).intValue();
        if (iIntValue == -1) {
            if (str.indexOf(46) > 0) {
                String strN0 = ClassFileWriter.n0(str);
                Integer num = (Integer) this.f.getOrDefault(strN0, -1);
                int iIntValue2 = num.intValue();
                if (iIntValue2 != -1) {
                    this.f.put(str, num);
                }
                str2 = strN0;
                iIntValue = iIntValue2;
            } else {
                str2 = str;
            }
            if (iIntValue == -1) {
                short sN = n(str2);
                o(3);
                byte[] bArr = this.l;
                int i = this.h;
                int i2 = i + 1;
                this.h = i2;
                bArr[i] = 7;
                this.h = ClassFileWriter.y0(sN, bArr, i2);
                iIntValue = this.i;
                this.i = iIntValue + 1;
                this.f.put(str2, Integer.valueOf(iIntValue));
                if (!str.equals(str2)) {
                    this.f.put(str, Integer.valueOf(iIntValue));
                }
            }
        }
        t(iIntValue, str);
        this.k.put(Integer.valueOf(iIntValue), (byte) 7);
        return (short) iIntValue;
    }

    public int b(double d) {
        o(9);
        byte[] bArr = this.l;
        int i = this.h;
        this.h = i + 1;
        bArr[i] = 6;
        this.h = ClassFileWriter.A0(Double.doubleToLongBits(d), this.l, this.h);
        int i2 = this.i;
        this.i = i2 + 2;
        this.k.put(Integer.valueOf(i2), (byte) 6);
        return i2;
    }

    public int c(float f) {
        o(5);
        byte[] bArr = this.l;
        int i = this.h;
        this.h = i + 1;
        bArr[i] = 4;
        this.h = ClassFileWriter.z0(Float.floatToIntBits(f), this.l, this.h);
        this.k.put(Integer.valueOf(this.i), (byte) 4);
        int i2 = this.i;
        this.i = i2 + 1;
        return i2;
    }

    public int d(int i) {
        o(5);
        byte[] bArr = this.l;
        int i2 = this.h;
        int i3 = i2 + 1;
        this.h = i3;
        bArr[i2] = 3;
        this.h = ClassFileWriter.z0(i, bArr, i3);
        this.k.put(Integer.valueOf(this.i), (byte) 3);
        int i4 = this.i;
        this.i = i4 + 1;
        return (short) i4;
    }

    public int e(long j) {
        o(9);
        byte[] bArr = this.l;
        int i = this.h;
        int i2 = i + 1;
        this.h = i2;
        bArr[i] = 5;
        this.h = ClassFileWriter.A0(j, bArr, i2);
        int i3 = this.i;
        this.i = i3 + 2;
        this.k.put(Integer.valueOf(i3), (byte) 5);
        return i3;
    }

    public int f(Object obj) {
        if ((obj instanceof Integer) || (obj instanceof Byte) || (obj instanceof Short)) {
            return d(((Number) obj).intValue());
        }
        if (obj instanceof Character) {
            return d(((Character) obj).charValue());
        }
        if (obj instanceof Boolean) {
            return d(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Float) {
            return c(((Float) obj).floatValue());
        }
        if (obj instanceof Long) {
            return e(((Long) obj).longValue());
        }
        if (obj instanceof Double) {
            return b(((Double) obj).doubleValue());
        }
        if (obj instanceof String) {
            return g((String) obj);
        }
        if (obj instanceof ClassFileWriter.c) {
            return k((ClassFileWriter.c) obj);
        }
        jl.a("value ".concat(String.valueOf(obj)));
        return 0;
    }

    public int g(String str) {
        int iN = n(str) & 65535;
        int iIntValue = ((Integer) this.b.getOrDefault(Integer.valueOf(iN), -1)).intValue();
        if (iIntValue == -1) {
            iIntValue = this.i;
            this.i = iIntValue + 1;
            o(3);
            byte[] bArr = this.l;
            int i = this.h;
            int i2 = i + 1;
            this.h = i2;
            bArr[i] = 8;
            this.h = ClassFileWriter.y0(iN, bArr, i2);
            this.b.put(Integer.valueOf(iN), Integer.valueOf(iIntValue));
        }
        this.k.put(Integer.valueOf(iIntValue), (byte) 8);
        return iIntValue;
    }

    public short h(String str, String str2, String str3) {
        a01 a01Var = new a01(str, str2, str3);
        int iIntValue = ((Integer) this.d.getOrDefault(a01Var, -1)).intValue();
        if (iIntValue == -1) {
            short sM = m(str2, str3);
            short sA = a(str);
            o(5);
            byte[] bArr = this.l;
            int i = this.h;
            int i2 = i + 1;
            this.h = i2;
            bArr[i] = 9;
            int iY0 = ClassFileWriter.y0(sA, bArr, i2);
            this.h = iY0;
            this.h = ClassFileWriter.y0(sM, this.l, iY0);
            iIntValue = this.i;
            this.i = iIntValue + 1;
            this.d.put(a01Var, Integer.valueOf(iIntValue));
        }
        t(iIntValue, a01Var);
        this.k.put(Integer.valueOf(iIntValue), (byte) 9);
        return (short) iIntValue;
    }

    public short i(String str, String str2, String str3) {
        short sM = m(str2, str3);
        short sA = a(str);
        o(5);
        byte[] bArr = this.l;
        int i = this.h;
        int i2 = i + 1;
        this.h = i2;
        bArr[i] = 11;
        int iY0 = ClassFileWriter.y0(sA, bArr, i2);
        this.h = iY0;
        this.h = ClassFileWriter.y0(sM, this.l, iY0);
        t(this.i, new a01(str, str2, str3));
        this.k.put(Integer.valueOf(this.i), (byte) 11);
        int i3 = this.i;
        this.i = i3 + 1;
        return (short) i3;
    }

    public short j(String str, String str2, int i) {
        i10 i10Var = new i10(18, i, str, str2);
        int iIntValue = ((Integer) this.g.getOrDefault(i10Var, -1)).intValue();
        if (iIntValue == -1) {
            short sM = m(str, str2);
            o(5);
            byte[] bArr = this.l;
            int i2 = this.h;
            int i3 = i2 + 1;
            this.h = i3;
            bArr[i2] = 18;
            int iY0 = ClassFileWriter.y0(i, bArr, i3);
            this.h = iY0;
            this.h = ClassFileWriter.y0(sM, this.l, iY0);
            iIntValue = this.i;
            this.i = iIntValue + 1;
            this.g.put(i10Var, Integer.valueOf(iIntValue));
            t(iIntValue, str2);
            this.k.put(Integer.valueOf(iIntValue), (byte) 18);
        }
        return (short) iIntValue;
    }

    public short k(ClassFileWriter.c cVar) {
        short sI;
        int iIntValue = ((Integer) this.g.getOrDefault(cVar, -1)).intValue();
        if (iIntValue == -1) {
            byte b = cVar.a;
            if (b <= 4) {
                sI = h(cVar.b, cVar.c, cVar.d);
            } else {
                String str = cVar.b;
                sI = b == 9 ? i(str, cVar.c, cVar.d) : l(str, cVar.c, cVar.d);
            }
            o(4);
            byte[] bArr = this.l;
            int i = this.h;
            int i2 = i + 1;
            this.h = i2;
            bArr[i] = 15;
            int i3 = i + 2;
            this.h = i3;
            bArr[i2] = cVar.a;
            this.h = ClassFileWriter.y0(sI, bArr, i3);
            iIntValue = this.i;
            this.i = iIntValue + 1;
            this.g.put(cVar, Integer.valueOf(iIntValue));
            this.k.put(Integer.valueOf(iIntValue), (byte) 15);
        }
        return (short) iIntValue;
    }

    public short l(String str, String str2, String str3) {
        a01 a01Var = new a01(str, str2, str3);
        int iIntValue = ((Integer) this.e.getOrDefault(a01Var, -1)).intValue();
        if (iIntValue == -1) {
            short sM = m(str2, str3);
            short sA = a(str);
            o(5);
            byte[] bArr = this.l;
            int i = this.h;
            int i2 = i + 1;
            this.h = i2;
            bArr[i] = 10;
            int iY0 = ClassFileWriter.y0(sA, bArr, i2);
            this.h = iY0;
            this.h = ClassFileWriter.y0(sM, this.l, iY0);
            iIntValue = this.i;
            this.i = iIntValue + 1;
            this.e.put(a01Var, Integer.valueOf(iIntValue));
        }
        t(iIntValue, a01Var);
        this.k.put(Integer.valueOf(iIntValue), (byte) 10);
        return (short) iIntValue;
    }

    public final short m(String str, String str2) {
        short sN = n(str);
        short sN2 = n(str2);
        o(5);
        byte[] bArr = this.l;
        int i = this.h;
        int i2 = i + 1;
        this.h = i2;
        bArr[i] = 12;
        int iY0 = ClassFileWriter.y0(sN, bArr, i2);
        this.h = iY0;
        this.h = ClassFileWriter.y0(sN2, this.l, iY0);
        this.k.put(Integer.valueOf(this.i), (byte) 12);
        int i3 = this.i;
        this.i = i3 + 1;
        return (short) i3;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public short n(java.lang.String r14) {
        /*
            Method dump skipped, instruction units count: 202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.classfile.a.n(java.lang.String):short");
    }

    public final void o(int i) {
        int i2 = this.h;
        int i3 = i2 + i;
        byte[] bArr = this.l;
        if (i3 > bArr.length) {
            int length = bArr.length * 2;
            if (i2 + i > length) {
                length = i2 + i;
            }
            byte[] bArr2 = new byte[length];
            System.arraycopy(bArr, 0, bArr2, 0, i2);
            this.l = bArr2;
        }
    }

    public Object p(int i) {
        return this.j.get(Integer.valueOf(i));
    }

    public byte q(int i) {
        return ((Byte) this.k.getOrDefault(Integer.valueOf(i), (byte) 0)).byteValue();
    }

    public int r(String str, int i, int i2) {
        int i3 = (i2 - i) * 3;
        int i4 = Settings.DEFAULT_INITIAL_WINDOW_SIZE;
        if (i3 > 65535) {
            while (i != i2) {
                char cCharAt = str.charAt(i);
                i4 = (cCharAt == 0 || cCharAt > 127) ? cCharAt < 2047 ? i4 - 2 : i4 - 3 : i4 - 1;
                if (i4 < 0) {
                    return i;
                }
                i++;
            }
        }
        return i2;
    }

    public int s() {
        return this.h + 2;
    }

    public void t(int i, Object obj) {
        this.j.put(Integer.valueOf(i), obj);
    }

    public int u(byte[] bArr, int i) {
        int iY0 = ClassFileWriter.y0((short) this.i, bArr, i);
        System.arraycopy(this.l, 0, bArr, iY0, this.h);
        return iY0 + this.h;
    }
}
