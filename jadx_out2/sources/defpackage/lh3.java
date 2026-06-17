package defpackage;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class lh3 {
    public static final byte[] a = {112, 114, 111, 0};
    public static final byte[] b = {112, 114, 109, 0};

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void A(byte[] bArr, int i, int i2, pk0 pk0Var) {
        int iM = m(i, i2, pk0Var.g);
        int i3 = iM / 8;
        bArr[i3] = (byte) ((1 << (iM % 8)) | bArr[i3]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void B(InputStream inputStream) {
        ps0.h(inputStream);
        int iJ = ps0.j(inputStream);
        if (iJ == 6 || iJ == 7) {
            return;
        }
        while (iJ > 0) {
            ps0.j(inputStream);
            for (int iJ2 = ps0.j(inputStream); iJ2 > 0; iJ2--) {
                ps0.h(inputStream);
            }
            iJ--;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean C(OutputStream outputStream, byte[] bArr, pk0[] pk0VarArr) throws IOException {
        if (Arrays.equals(bArr, mh3.a)) {
            P(outputStream, pk0VarArr);
            return true;
        }
        if (Arrays.equals(bArr, mh3.b)) {
            O(outputStream, pk0VarArr);
            return true;
        }
        if (Arrays.equals(bArr, mh3.d)) {
            M(outputStream, pk0VarArr);
            return true;
        }
        if (Arrays.equals(bArr, mh3.c)) {
            N(outputStream, pk0VarArr);
            return true;
        }
        if (!Arrays.equals(bArr, mh3.e)) {
            return false;
        }
        L(outputStream, pk0VarArr);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void D(OutputStream outputStream, pk0 pk0Var) throws IOException {
        int[] iArr = pk0Var.h;
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = iArr[i];
            ps0.p(outputStream, i3 - i2);
            i++;
            i2 = i3;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ga5 E(pk0[] pk0VarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            ps0.p(byteArrayOutputStream, pk0VarArr.length);
            int i = 2;
            for (pk0 pk0Var : pk0VarArr) {
                ps0.q(byteArrayOutputStream, pk0Var.c);
                ps0.q(byteArrayOutputStream, pk0Var.d);
                ps0.q(byteArrayOutputStream, pk0Var.g);
                String strJ = j(pk0Var.a, pk0Var.b, mh3.a);
                int iK = ps0.k(strJ);
                ps0.p(byteArrayOutputStream, iK);
                i = i + 14 + iK;
                ps0.n(byteArrayOutputStream, strJ);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i == byteArray.length) {
                ga5 ga5Var = new ga5(q01.DEX_FILES, i, byteArray, false);
                byteArrayOutputStream.close();
                return ga5Var;
            }
            throw ps0.c("Expected size " + i + ", does not match actual size " + byteArray.length);
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void F(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(a);
        outputStream.write(bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void G(OutputStream outputStream, pk0 pk0Var) throws IOException {
        K(outputStream, pk0Var);
        D(outputStream, pk0Var);
        I(outputStream, pk0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void H(OutputStream outputStream, pk0 pk0Var, String str) throws IOException {
        ps0.p(outputStream, ps0.k(str));
        ps0.p(outputStream, pk0Var.e);
        ps0.q(outputStream, pk0Var.f);
        ps0.q(outputStream, pk0Var.c);
        ps0.q(outputStream, pk0Var.g);
        ps0.n(outputStream, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void I(OutputStream outputStream, pk0 pk0Var) throws IOException {
        byte[] bArr = new byte[k(pk0Var.g)];
        for (Map.Entry entry : pk0Var.i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            if ((iIntValue2 & 2) != 0) {
                A(bArr, 2, iIntValue, pk0Var);
            }
            if ((iIntValue2 & 4) != 0) {
                A(bArr, 4, iIntValue, pk0Var);
            }
        }
        outputStream.write(bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void J(OutputStream outputStream, int i, pk0 pk0Var) throws IOException {
        byte[] bArr = new byte[l(i, pk0Var.g)];
        for (Map.Entry entry : pk0Var.i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            int i2 = 0;
            for (int i3 = 1; i3 <= 4; i3 <<= 1) {
                if (i3 != 1 && (i3 & i) != 0) {
                    if ((i3 & iIntValue2) == i3) {
                        int i4 = (pk0Var.g * i2) + iIntValue;
                        int i5 = i4 / 8;
                        bArr[i5] = (byte) ((1 << (i4 % 8)) | bArr[i5]);
                    }
                    i2++;
                }
            }
        }
        outputStream.write(bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void K(OutputStream outputStream, pk0 pk0Var) throws IOException {
        int i = 0;
        for (Map.Entry entry : pk0Var.i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                ps0.p(outputStream, iIntValue - i);
                ps0.p(outputStream, 0);
                i = iIntValue;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void L(OutputStream outputStream, pk0[] pk0VarArr) throws IOException {
        ps0.p(outputStream, pk0VarArr.length);
        for (pk0 pk0Var : pk0VarArr) {
            String strJ = j(pk0Var.a, pk0Var.b, mh3.e);
            ps0.p(outputStream, ps0.k(strJ));
            ps0.p(outputStream, pk0Var.i.size());
            ps0.p(outputStream, pk0Var.h.length);
            ps0.q(outputStream, pk0Var.c);
            ps0.n(outputStream, strJ);
            Iterator it = pk0Var.i.keySet().iterator();
            while (it.hasNext()) {
                ps0.p(outputStream, ((Integer) it.next()).intValue());
            }
            for (int i : pk0Var.h) {
                ps0.p(outputStream, i);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void M(OutputStream outputStream, pk0[] pk0VarArr) throws IOException {
        ps0.r(outputStream, pk0VarArr.length);
        for (pk0 pk0Var : pk0VarArr) {
            int size = pk0Var.i.size() * 4;
            String strJ = j(pk0Var.a, pk0Var.b, mh3.d);
            ps0.p(outputStream, ps0.k(strJ));
            ps0.p(outputStream, pk0Var.h.length);
            ps0.q(outputStream, size);
            ps0.q(outputStream, pk0Var.c);
            ps0.n(outputStream, strJ);
            Iterator it = pk0Var.i.keySet().iterator();
            while (it.hasNext()) {
                ps0.p(outputStream, ((Integer) it.next()).intValue());
                ps0.p(outputStream, 0);
            }
            for (int i : pk0Var.h) {
                ps0.p(outputStream, i);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void N(OutputStream outputStream, pk0[] pk0VarArr) throws IOException {
        byte[] bArrB = b(pk0VarArr, mh3.c);
        ps0.r(outputStream, pk0VarArr.length);
        ps0.m(outputStream, bArrB);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void O(OutputStream outputStream, pk0[] pk0VarArr) throws IOException {
        byte[] bArrB = b(pk0VarArr, mh3.b);
        ps0.r(outputStream, pk0VarArr.length);
        ps0.m(outputStream, bArrB);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void P(OutputStream outputStream, pk0[] pk0VarArr) throws IOException {
        Q(outputStream, pk0VarArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void Q(OutputStream outputStream, pk0[] pk0VarArr) throws IOException {
        int length;
        ArrayList arrayList = new ArrayList(3);
        ArrayList arrayList2 = new ArrayList(3);
        arrayList.add(E(pk0VarArr));
        arrayList.add(c(pk0VarArr));
        arrayList.add(d(pk0VarArr));
        long length2 = ((long) mh3.a.length) + ((long) a.length) + 4 + ((long) (arrayList.size() * 16));
        ps0.q(outputStream, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            ga5 ga5Var = (ga5) arrayList.get(i);
            ps0.q(outputStream, ga5Var.a.b());
            ps0.q(outputStream, length2);
            boolean z = ga5Var.d;
            byte[] bArr = ga5Var.c;
            if (z) {
                long length3 = bArr.length;
                byte[] bArrB = ps0.b(bArr);
                arrayList2.add(bArrB);
                ps0.q(outputStream, bArrB.length);
                ps0.q(outputStream, length3);
                length = bArrB.length;
            } else {
                arrayList2.add(bArr);
                ps0.q(outputStream, ga5Var.c.length);
                ps0.q(outputStream, 0L);
                length = ga5Var.c.length;
            }
            length2 += (long) length;
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            outputStream.write((byte[]) arrayList2.get(i2));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int a(pk0 pk0Var) {
        Iterator it = pk0Var.i.entrySet().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue |= ((Integer) ((Map.Entry) it.next()).getValue()).intValue();
        }
        return iIntValue;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] b(pk0[] pk0VarArr, byte[] bArr) throws IOException {
        int i = 0;
        int iK = 0;
        for (pk0 pk0Var : pk0VarArr) {
            iK += ps0.k(j(pk0Var.a, pk0Var.b, bArr)) + 16 + (pk0Var.e * 2) + pk0Var.f + k(pk0Var.g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(iK);
        if (Arrays.equals(bArr, mh3.c)) {
            int length = pk0VarArr.length;
            while (i < length) {
                pk0 pk0Var2 = pk0VarArr[i];
                H(byteArrayOutputStream, pk0Var2, j(pk0Var2.a, pk0Var2.b, bArr));
                G(byteArrayOutputStream, pk0Var2);
                i++;
            }
        } else {
            for (pk0 pk0Var3 : pk0VarArr) {
                H(byteArrayOutputStream, pk0Var3, j(pk0Var3.a, pk0Var3.b, bArr));
            }
            int length2 = pk0VarArr.length;
            while (i < length2) {
                G(byteArrayOutputStream, pk0VarArr[i]);
                i++;
            }
        }
        if (byteArrayOutputStream.size() == iK) {
            return byteArrayOutputStream.toByteArray();
        }
        throw ps0.c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + iK);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ga5 c(pk0[] pk0VarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        for (int i2 = 0; i2 < pk0VarArr.length; i2++) {
            try {
                pk0 pk0Var = pk0VarArr[i2];
                ps0.p(byteArrayOutputStream, i2);
                ps0.p(byteArrayOutputStream, pk0Var.e);
                i = i + 4 + (pk0Var.e * 2);
                D(byteArrayOutputStream, pk0Var);
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i == byteArray.length) {
            ga5 ga5Var = new ga5(q01.CLASSES, i, byteArray, true);
            byteArrayOutputStream.close();
            return ga5Var;
        }
        throw ps0.c("Expected size " + i + ", does not match actual size " + byteArray.length);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ga5 d(pk0[] pk0VarArr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        for (int i2 = 0; i2 < pk0VarArr.length; i2++) {
            try {
                pk0 pk0Var = pk0VarArr[i2];
                int iA = a(pk0Var);
                byte[] bArrE = e(iA, pk0Var);
                byte[] bArrF = f(pk0Var);
                ps0.p(byteArrayOutputStream, i2);
                int length = bArrE.length + 2 + bArrF.length;
                ps0.q(byteArrayOutputStream, length);
                ps0.p(byteArrayOutputStream, iA);
                byteArrayOutputStream.write(bArrE);
                byteArrayOutputStream.write(bArrF);
                i = i + 6 + length;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i == byteArray.length) {
            ga5 ga5Var = new ga5(q01.METHODS, i, byteArray, true);
            byteArrayOutputStream.close();
            return ga5Var;
        }
        throw ps0.c("Expected size " + i + ", does not match actual size " + byteArray.length);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] e(int i, pk0 pk0Var) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            J(byteArrayOutputStream, i, pk0Var);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] f(pk0 pk0Var) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            K(byteArrayOutputStream, pk0Var);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String g(String str, String str2) {
        return "!".equals(str2) ? str.replace(":", "!") : ":".equals(str2) ? str.replace("!", ":") : str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String h(String str) {
        int iIndexOf = str.indexOf("!");
        if (iIndexOf < 0) {
            iIndexOf = str.indexOf(":");
        }
        return iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static pk0 i(pk0[] pk0VarArr, String str) {
        if (pk0VarArr.length <= 0) {
            return null;
        }
        String strH = h(str);
        for (int i = 0; i < pk0VarArr.length; i++) {
            if (pk0VarArr[i].b.equals(strH)) {
                return pk0VarArr[i];
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String j(String str, String str2, byte[] bArr) {
        String strA = mh3.a(bArr);
        if (str.length() <= 0) {
            return g(str2, strA);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            return g(str2, strA);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + mh3.a(bArr) + str2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int k(int i) {
        return z(i * 2) / 8;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int l(int i, int i2) {
        return z(Integer.bitCount(i & (-2)) * i2) / 8;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int m(int i, int i2, int i3) {
        if (i == 1) {
            throw ps0.c("HOT methods are not stored in the bitmap");
        }
        if (i == 2) {
            return i2;
        }
        if (i == 4) {
            return i2 + i3;
        }
        throw ps0.c("Unexpected flag: " + i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int[] n(InputStream inputStream, int i) {
        int[] iArr = new int[i];
        int iH = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iH += ps0.h(inputStream);
            iArr[i2] = iH;
        }
        return iArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int o(BitSet bitSet, int i, int i2) {
        int i3 = bitSet.get(m(2, i, i2)) ? 2 : 0;
        return bitSet.get(m(4, i, i2)) ? i3 | 4 : i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] p(InputStream inputStream, byte[] bArr) {
        if (Arrays.equals(bArr, ps0.d(inputStream, bArr.length))) {
            return ps0.d(inputStream, mh3.b.length);
        }
        throw ps0.c("Invalid magic");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void q(InputStream inputStream, pk0 pk0Var) {
        int iAvailable = inputStream.available() - pk0Var.f;
        int iH = 0;
        while (inputStream.available() > iAvailable) {
            iH += ps0.h(inputStream);
            pk0Var.i.put(Integer.valueOf(iH), 1);
            for (int iH2 = ps0.h(inputStream); iH2 > 0; iH2--) {
                B(inputStream);
            }
        }
        if (inputStream.available() != iAvailable) {
            throw ps0.c("Read too much data during profile line parse");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static pk0[] r(InputStream inputStream, byte[] bArr, byte[] bArr2, pk0[] pk0VarArr) {
        if (Arrays.equals(bArr, mh3.f)) {
            if (Arrays.equals(mh3.a, bArr2)) {
                throw ps0.c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            }
            return s(inputStream, bArr, pk0VarArr);
        }
        if (Arrays.equals(bArr, mh3.g)) {
            return u(inputStream, bArr2, pk0VarArr);
        }
        throw ps0.c("Unsupported meta version");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static pk0[] s(InputStream inputStream, byte[] bArr, pk0[] pk0VarArr) throws IOException {
        if (!Arrays.equals(bArr, mh3.f)) {
            throw ps0.c("Unsupported meta version");
        }
        int iJ = ps0.j(inputStream);
        byte[] bArrE = ps0.e(inputStream, (int) ps0.i(inputStream), (int) ps0.i(inputStream));
        if (inputStream.read() > 0) {
            throw ps0.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            pk0[] pk0VarArrT = t(byteArrayInputStream, iJ, pk0VarArr);
            byteArrayInputStream.close();
            return pk0VarArrT;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static pk0[] t(InputStream inputStream, int i, pk0[] pk0VarArr) {
        if (inputStream.available() == 0) {
            return new pk0[0];
        }
        if (i != pk0VarArr.length) {
            throw ps0.c("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i];
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            int iH = ps0.h(inputStream);
            iArr[i2] = ps0.h(inputStream);
            strArr[i2] = ps0.f(inputStream, iH);
        }
        for (int i3 = 0; i3 < i; i3++) {
            pk0 pk0Var = pk0VarArr[i3];
            if (!pk0Var.b.equals(strArr[i3])) {
                throw ps0.c("Order of dexfiles in metadata did not match baseline");
            }
            int i4 = iArr[i3];
            pk0Var.e = i4;
            pk0Var.h = n(inputStream, i4);
        }
        return pk0VarArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static pk0[] u(InputStream inputStream, byte[] bArr, pk0[] pk0VarArr) throws IOException {
        int iH = ps0.h(inputStream);
        byte[] bArrE = ps0.e(inputStream, (int) ps0.i(inputStream), (int) ps0.i(inputStream));
        if (inputStream.read() > 0) {
            throw ps0.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            pk0[] pk0VarArrV = v(byteArrayInputStream, bArr, iH, pk0VarArr);
            byteArrayInputStream.close();
            return pk0VarArrV;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static pk0[] v(InputStream inputStream, byte[] bArr, int i, pk0[] pk0VarArr) {
        if (inputStream.available() == 0) {
            return new pk0[0];
        }
        if (i != pk0VarArr.length) {
            throw ps0.c("Mismatched number of dex files found in metadata");
        }
        for (int i2 = 0; i2 < i; i2++) {
            ps0.h(inputStream);
            String strF = ps0.f(inputStream, ps0.h(inputStream));
            long jI = ps0.i(inputStream);
            int iH = ps0.h(inputStream);
            pk0 pk0VarI = i(pk0VarArr, strF);
            if (pk0VarI == null) {
                throw ps0.c("Missing profile key: " + strF);
            }
            pk0VarI.d = jI;
            int[] iArrN = n(inputStream, iH);
            if (Arrays.equals(bArr, mh3.e)) {
                pk0VarI.e = iH;
                pk0VarI.h = iArrN;
            }
        }
        return pk0VarArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void w(InputStream inputStream, pk0 pk0Var) {
        BitSet bitSetValueOf = BitSet.valueOf(ps0.d(inputStream, ps0.a(pk0Var.g * 2)));
        int i = 0;
        while (true) {
            int i2 = pk0Var.g;
            if (i >= i2) {
                return;
            }
            int iO = o(bitSetValueOf, i, i2);
            if (iO != 0) {
                Integer num = (Integer) pk0Var.i.get(Integer.valueOf(i));
                if (num == null) {
                    num = 0;
                }
                pk0Var.i.put(Integer.valueOf(i), Integer.valueOf(iO | num.intValue()));
            }
            i++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static pk0[] x(InputStream inputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, mh3.b)) {
            throw ps0.c("Unsupported version");
        }
        int iJ = ps0.j(inputStream);
        byte[] bArrE = ps0.e(inputStream, (int) ps0.i(inputStream), (int) ps0.i(inputStream));
        if (inputStream.read() > 0) {
            throw ps0.c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrE);
        try {
            pk0[] pk0VarArrY = y(byteArrayInputStream, str, iJ);
            byteArrayInputStream.close();
            return pk0VarArrY;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static pk0[] y(InputStream inputStream, String str, int i) {
        if (inputStream.available() == 0) {
            return new pk0[0];
        }
        pk0[] pk0VarArr = new pk0[i];
        for (int i2 = 0; i2 < i; i2++) {
            int iH = ps0.h(inputStream);
            int iH2 = ps0.h(inputStream);
            pk0VarArr[i2] = new pk0(str, ps0.f(inputStream, iH), ps0.i(inputStream), 0L, iH2, (int) ps0.i(inputStream), (int) ps0.i(inputStream), new int[iH2], new TreeMap());
        }
        for (int i3 = 0; i3 < i; i3++) {
            pk0 pk0Var = pk0VarArr[i3];
            q(inputStream, pk0Var);
            pk0Var.h = n(inputStream, pk0Var.e);
            w(inputStream, pk0Var);
        }
        return pk0VarArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int z(int i) {
        return (i + 7) & (-8);
    }
}
