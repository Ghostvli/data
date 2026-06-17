package defpackage;

import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.http2.Http2;
import okio.internal.Buffer;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class gv {
    public static final byte[] a = {0, 0, 0, 1};
    public static final String[] b = {"", "A", "B", "C"};
    public static final Pattern c = Pattern.compile("^\\D?(\\d+)$");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Pair A(String str, String[] strArr) {
        if (strArr.length < 3) {
            xz1.i("CodecSpecificDataUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
        try {
            int i = Integer.parseInt(strArr[1]);
            int i2 = Integer.parseInt(strArr[2]);
            int iJ = J(i);
            if (iJ == -1) {
                xz1.i("CodecSpecificDataUtil", "Unknown VP9 profile: " + i);
                return null;
            }
            int I = I(i2);
            if (I != -1) {
                return new Pair(Integer.valueOf(iJ), Integer.valueOf(I));
            }
            xz1.i("CodecSpecificDataUtil", "Unknown VP9 level: " + i2);
            return null;
        } catch (NumberFormatException unused) {
            xz1.i("CodecSpecificDataUtil", "Ignoring malformed VP9 codec string: " + str);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Pair B(String str, String[] strArr, bx bxVar) {
        if (strArr.length < 3) {
            xz1.i("CodecSpecificDataUtil", "Ignoring malformed VVC codec string: " + str);
            return null;
        }
        int i = 1;
        try {
            int i2 = Integer.parseInt(strArr[1]);
            if (i2 == 1) {
                if (bxVar != null && bxVar.c == 6) {
                    i = Buffer.SEGMENTING_THRESHOLD;
                } else if (bxVar == null || bxVar.e != 8) {
                    i = 2;
                }
            } else {
                if (i2 != 65) {
                    xz1.i("CodecSpecificDataUtil", "Unknown VVC profile IDC: " + strArr[1]);
                    return null;
                }
                i = 4;
            }
            String str2 = strArr[2];
            Integer numK = K(str2);
            if (numK != null) {
                return new Pair(Integer.valueOf(i), numK);
            }
            xz1.i("CodecSpecificDataUtil", "Unknown VVC level string: " + str2);
            return null;
        } catch (NumberFormatException unused) {
            xz1.i("CodecSpecificDataUtil", "Ignoring malformed VVC codec string: " + str);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Integer C(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean D(byte[] bArr, int i) {
        if (bArr.length - i <= a.length) {
            return false;
        }
        int i2 = 0;
        while (true) {
            byte[] bArr2 = a;
            if (i2 >= bArr2.length) {
                return true;
            }
            if (bArr[i + i2] != bArr2[i2]) {
                return false;
            }
            i2++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int E(int i) {
        int i2 = 17;
        if (i != 17) {
            i2 = 20;
            if (i != 20) {
                i2 = 23;
                if (i != 23) {
                    i2 = 29;
                    if (i != 29) {
                        i2 = 39;
                        if (i != 39) {
                            i2 = 42;
                            if (i != 42) {
                                switch (i) {
                                    case 1:
                                        return 1;
                                    case 2:
                                        return 2;
                                    case 3:
                                        return 3;
                                    case 4:
                                        return 4;
                                    case 5:
                                        return 5;
                                    case 6:
                                        return 6;
                                    default:
                                        return -1;
                                }
                            }
                        }
                    }
                }
            }
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int[] F(byte[] bArr) {
        r73 r73Var = new r73(bArr);
        r73Var.f0(5);
        int iQ = r73Var.Q();
        r73Var.f0(9);
        int iQ2 = r73Var.Q();
        r73Var.f0(20);
        return new int[]{r73Var.U(), iQ2, iQ};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean G(List list) {
        return list.size() == 1 && ((byte[]) list.get(0)).length == 1 && ((byte[]) list.get(0))[0] == 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[][] H(byte[] bArr) {
        if (!D(bArr, 0)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int iO = 0;
        do {
            arrayList.add(Integer.valueOf(iO));
            iO = o(bArr, iO + a.length);
        } while (iO != -1);
        byte[][] bArr2 = new byte[arrayList.size()][];
        int i = 0;
        while (i < arrayList.size()) {
            int iIntValue = ((Integer) arrayList.get(i)).intValue();
            int iIntValue2 = (i < arrayList.size() + (-1) ? ((Integer) arrayList.get(i + 1)).intValue() : bArr.length) - iIntValue;
            byte[] bArr3 = new byte[iIntValue2];
            System.arraycopy(bArr, iIntValue, bArr3, 0, iIntValue2);
            bArr2[i] = bArr3;
            i++;
        }
        return bArr2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int I(int i) {
        if (i == 10) {
            return 1;
        }
        if (i == 11) {
            return 2;
        }
        if (i == 20) {
            return 4;
        }
        if (i == 21) {
            return 8;
        }
        if (i == 30) {
            return 16;
        }
        if (i == 31) {
            return 32;
        }
        if (i == 40) {
            return 64;
        }
        if (i == 41) {
            return 128;
        }
        if (i == 50) {
            return com.hierynomus.protocol.commons.buffer.Buffer.DEFAULT_SIZE;
        }
        if (i == 51) {
            return 512;
        }
        switch (i) {
            case 60:
                return 2048;
            case Token.SETVAR /* 61 */:
                return Buffer.SEGMENTING_THRESHOLD;
            case Token.CATCH_SCOPE /* 62 */:
                return 8192;
            default:
                return -1;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int J(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i != 2) {
            return i != 3 ? -1 : 8;
        }
        return 4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Integer K(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int a(int i, int i2) {
        if (i == 0) {
            return i2 == 0 ? 257 : -1;
        }
        if (i == 1) {
            if (i2 == 0) {
                return 513;
            }
            return i2 == 1 ? 514 : -1;
        }
        if (i != 2) {
            return -1;
        }
        if (i2 == 1) {
            return 1026;
        }
        return i2 == 2 ? 1028 : -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int b(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 4;
        }
        if (i != 3) {
            return i != 4 ? -1 : 16;
        }
        return 8;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int c(int i) {
        switch (i) {
            case 0:
                return 1;
            case 1:
                return 2;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 16;
            case 5:
                return 32;
            case 6:
                return 64;
            case 7:
                return 128;
            case 8:
                return com.hierynomus.protocol.commons.buffer.Buffer.DEFAULT_SIZE;
            case 9:
                return 512;
            case 10:
                return 1024;
            case 11:
                return 2048;
            case 12:
                return Buffer.SEGMENTING_THRESHOLD;
            case 13:
                return 8192;
            case 14:
                return Http2.INITIAL_MAX_FRAME_SIZE;
            case 15:
                return 32768;
            case 16:
                return 65536;
            case 17:
                return 131072;
            case 18:
                return 262144;
            case 19:
                return 524288;
            case 20:
                return 1048576;
            case 21:
                return 2097152;
            case 22:
                return 4194304;
            case 23:
                return 8388608;
            default:
                return -1;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int d(int i) {
        switch (i) {
            case 10:
                return 1;
            case 11:
                return 4;
            case 12:
                return 8;
            case 13:
                return 16;
            default:
                switch (i) {
                    case 20:
                        return 32;
                    case 21:
                        return 64;
                    case 22:
                        return 128;
                    default:
                        switch (i) {
                            case 30:
                                return com.hierynomus.protocol.commons.buffer.Buffer.DEFAULT_SIZE;
                            case 31:
                                return 512;
                            case 32:
                                return 1024;
                            default:
                                switch (i) {
                                    case 40:
                                        return 2048;
                                    case Token.SETELEM /* 41 */:
                                        return Buffer.SEGMENTING_THRESHOLD;
                                    case Token.SETELEM_SUPER /* 42 */:
                                        return 8192;
                                    default:
                                        switch (i) {
                                            case 50:
                                                return Http2.INITIAL_MAX_FRAME_SIZE;
                                            case Token.SHEQ /* 51 */:
                                                return 32768;
                                            case Token.SHNE /* 52 */:
                                                return 65536;
                                            default:
                                                return -1;
                                        }
                                }
                        }
                }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int e(int i) {
        if (i == 66) {
            return 1;
        }
        if (i == 77) {
            return 2;
        }
        if (i == 88) {
            return 4;
        }
        if (i == 100) {
            return 8;
        }
        if (i == 110) {
            return 16;
        }
        if (i != 122) {
            return i != 244 ? -1 : 64;
        }
        return 32;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String f(byte[] bArr) {
        gg3.g(bArr.length >= 17, "Invalid APV CSD length: %s", bArr.length);
        byte b2 = bArr[0];
        gg3.g(b2 == 1, "Invalid APV CSD version: %s", b2);
        return fy4.M("apv1.apvf%d.apvl%d.apvb%d", Integer.valueOf(bArr[5]), Integer.valueOf(bArr[6]), Integer.valueOf(bArr[7]));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String g(int i, int i2, int i3) {
        return String.format("avc1.%02X%02X%02X", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List h(boolean z) {
        return Collections.singletonList(z ? new byte[]{1} : new byte[]{0});
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String i(int i, boolean z, int i2, int i3, int[] iArr, int i4) {
        StringBuilder sb = new StringBuilder(fy4.M("hvc1.%s%d.%X.%c%d", b[i], Integer.valueOf(i2), Integer.valueOf(i3), Character.valueOf(z ? 'H' : 'L'), Integer.valueOf(i4)));
        int length = iArr.length;
        while (length > 0 && iArr[length - 1] == 0) {
            length--;
        }
        for (int i5 = 0; i5 < length; i5++) {
            sb.append(String.format(".%02X", Integer.valueOf(iArr[i5])));
        }
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String j(byte[] bArr) {
        r73 r73Var = new r73(bArr);
        String strM = null;
        String strN = null;
        while (r73Var.a() > 0 && (strM == null || strN == null)) {
            int iQ = r73Var.Q();
            int i = iQ >> 3;
            boolean z = (iQ & 2) != 0;
            boolean z2 = (iQ & 1) != 0;
            int iV = r73Var.V();
            if (i > 4 && i < 24 && z) {
                r73Var.h0();
                r73Var.h0();
            }
            if (z2) {
                r73Var.g0(r73Var.V());
            }
            int iG = r73Var.g() + iV;
            if (i == 31) {
                r73Var.g0(4);
                strM = fy4.M("iamf.%03X.%03X", Integer.valueOf(r73Var.Q()), Integer.valueOf(r73Var.Q()));
            } else if (i == 0) {
                r73Var.h0();
                strN = r73Var.N(4);
                if (strN.equals("mp4a")) {
                    r73Var.h0();
                    r73Var.g0(2);
                    q73 q73Var = new q73();
                    q73Var.m(r73Var);
                    int iH = q73Var.h(5);
                    if (iH == 31) {
                        iH = q73Var.h(6) + 32;
                    }
                    strN = strN + ".40." + iH;
                }
            }
            r73Var.f0(iG);
        }
        if (strM == null || strN == null) {
            return null;
        }
        return strM + "." + strN;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] k(byte[] bArr, int i, int i2) {
        byte[] bArr2 = a;
        byte[] bArr3 = new byte[bArr2.length + i2];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, bArr2.length, i2);
        return bArr3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xi1 l(byte b2, byte b3, byte b4, byte b5) {
        return xi1.w(new byte[]{1, 1, b2, 2, 1, b3, 3, 1, b4, 4, 1, b5});
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Integer m(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Integer n(String str) {
        if (str == null) {
            return null;
        }
        switch (str) {
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int o(byte[] bArr, int i) {
        int length = bArr.length - a.length;
        while (i <= length) {
            if (D(bArr, i)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Pair p(String str, String[] strArr) {
        int iE;
        if (strArr.length != 3) {
            xz1.i("CodecSpecificDataUtil", "Ignoring malformed MP4A codec string: " + str);
            return null;
        }
        try {
            if ("audio/mp4a-latm".equals(nt2.h(Integer.parseInt(strArr[1], 16))) && (iE = E(Integer.parseInt(strArr[2]))) != -1) {
                return new Pair(Integer.valueOf(iE), 0);
            }
        } catch (NumberFormatException unused) {
            xz1.i("CodecSpecificDataUtil", "Ignoring malformed MP4A codec string: " + str);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Pair q(String str, String[] strArr) {
        if (strArr.length != 4) {
            xz1.i("CodecSpecificDataUtil", "Ignoring malformed AC-4 codec string: " + str);
            return null;
        }
        try {
            int i = Integer.parseInt(strArr[1]);
            int i2 = Integer.parseInt(strArr[2]);
            int i3 = Integer.parseInt(strArr[3]);
            int iA = a(i, i2);
            if (iA == -1) {
                xz1.i("CodecSpecificDataUtil", "Unknown AC-4 profile: " + i + "." + i2);
                return null;
            }
            int iB = b(i3);
            if (iB != -1) {
                return new Pair(Integer.valueOf(iA), Integer.valueOf(iB));
            }
            xz1.i("CodecSpecificDataUtil", "Unknown AC-4 level: " + i3);
            return null;
        } catch (NumberFormatException unused) {
            xz1.i("CodecSpecificDataUtil", "Ignoring malformed AC-4 codec string: " + str);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Pair r(String str, String[] strArr) {
        int i;
        if (strArr.length < 4) {
            xz1.i("CodecSpecificDataUtil", "Ignoring malformed APV codec string: " + str);
            return null;
        }
        try {
            int i2 = Integer.parseInt(strArr[1].substring(4));
            int i3 = Integer.parseInt(strArr[2].substring(4));
            int i4 = Integer.parseInt(strArr[3].substring(4));
            if (i2 == 33) {
                i = 1;
            } else {
                if (i2 != 44) {
                    xz1.i("CodecSpecificDataUtil", "Ignoring invalid APV profile: " + i2);
                    return null;
                }
                i = 8192;
            }
            int i5 = (i3 / 30) * 2;
            if (i3 % 30 == 0) {
                i5--;
            }
            return new Pair(Integer.valueOf(i), Integer.valueOf((1 << i4) | (com.hierynomus.protocol.commons.buffer.Buffer.DEFAULT_SIZE << (i5 - 1))));
        } catch (NumberFormatException e) {
            xz1.j("CodecSpecificDataUtil", "Ignoring malformed APV codec string: " + str, e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Pair s(String str, String[] strArr, bx bxVar) {
        int i;
        if (strArr.length < 4) {
            xz1.i("CodecSpecificDataUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
        try {
            int i2 = Integer.parseInt(strArr[1]);
            int i3 = Integer.parseInt(strArr[2].substring(0, 2));
            int i4 = Integer.parseInt(strArr[3]);
            if (i2 != 0) {
                xz1.i("CodecSpecificDataUtil", "Unknown AV1 profile: " + i2);
                return null;
            }
            if (i4 != 8 && i4 != 10) {
                xz1.i("CodecSpecificDataUtil", "Unknown AV1 bit depth: " + i4);
                return null;
            }
            int i5 = i4 != 8 ? (bxVar == null || !(bxVar.d != null || (i = bxVar.c) == 7 || i == 6)) ? 2 : Buffer.SEGMENTING_THRESHOLD : 1;
            int iC = c(i3);
            if (iC != -1) {
                return new Pair(Integer.valueOf(i5), Integer.valueOf(iC));
            }
            xz1.i("CodecSpecificDataUtil", "Unknown AV1 level: " + i3);
            return null;
        } catch (NumberFormatException unused) {
            xz1.i("CodecSpecificDataUtil", "Ignoring malformed AV1 codec string: " + str);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Pair t(String str, String[] strArr) {
        int i;
        int i2;
        if (strArr.length < 2) {
            xz1.i("CodecSpecificDataUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                i2 = Integer.parseInt(strArr[1].substring(0, 2), 16);
                i = Integer.parseInt(strArr[1].substring(4), 16);
            } else {
                if (strArr.length < 3) {
                    xz1.i("CodecSpecificDataUtil", "Ignoring malformed AVC codec string: " + str);
                    return null;
                }
                int i3 = Integer.parseInt(strArr[1]);
                i = Integer.parseInt(strArr[2]);
                i2 = i3;
            }
            int iE = e(i2);
            if (iE == -1) {
                xz1.i("CodecSpecificDataUtil", "Unknown AVC profile: " + i2);
                return null;
            }
            int iD = d(i);
            if (iD != -1) {
                return new Pair(Integer.valueOf(iE), Integer.valueOf(iD));
            }
            xz1.i("CodecSpecificDataUtil", "Unknown AVC level: " + i);
            return null;
        } catch (NumberFormatException unused) {
            xz1.i("CodecSpecificDataUtil", "Ignoring malformed AVC codec string: " + str);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Pair u(t41 t41Var) {
        String str = t41Var.k;
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("\\.");
        if ("video/dolby-vision".equals(t41Var.p)) {
            return v(t41Var.k, strArrSplit);
        }
        String str2 = strArrSplit[0];
        str2.getClass();
        switch (str2) {
            case "ac-4":
                return q(t41Var.k, strArrSplit);
            case "apv1":
                return r(t41Var.k, strArrSplit);
            case "av01":
                return s(t41Var.k, strArrSplit, t41Var.F);
            case "avc1":
            case "avc2":
                return t(t41Var.k, strArrSplit);
            case "hev1":
            case "hvc1":
                return x(t41Var.k, strArrSplit, t41Var.F);
            case "iamf":
                return y(t41Var.k, strArrSplit);
            case "mp4a":
                return p(t41Var.k, strArrSplit);
            case "s263":
                return w(t41Var.k, strArrSplit);
            case "vp09":
                return A(t41Var.k, strArrSplit);
            case "vvc1":
            case "vvi1":
                return B(t41Var.k, strArrSplit, t41Var.F);
            default:
                return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Pair v(String str, String[] strArr) {
        if (strArr.length < 3) {
            xz1.i("CodecSpecificDataUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        Matcher matcher = c.matcher(strArr[1]);
        if (!matcher.matches()) {
            xz1.i("CodecSpecificDataUtil", "Ignoring malformed Dolby Vision codec string: " + str);
            return null;
        }
        String strGroup = matcher.group(1);
        Integer numN = n(strGroup);
        if (numN == null) {
            xz1.i("CodecSpecificDataUtil", "Unknown Dolby Vision profile string: " + strGroup);
            return null;
        }
        String str2 = strArr[2];
        Integer numM = m(str2);
        if (numM != null) {
            return new Pair(numN, numM);
        }
        xz1.i("CodecSpecificDataUtil", "Unknown Dolby Vision level string: " + str2);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Pair w(String str, String[] strArr) {
        Pair pair = new Pair(1, 1);
        if (strArr.length < 3) {
            xz1.i("CodecSpecificDataUtil", "Ignoring malformed H263 codec string: " + str);
            return pair;
        }
        try {
            return new Pair(Integer.valueOf(Integer.parseInt(strArr[1])), Integer.valueOf(Integer.parseInt(strArr[2])));
        } catch (NumberFormatException unused) {
            xz1.i("CodecSpecificDataUtil", "Ignoring malformed H263 codec string: " + str);
            return pair;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Pair x(String str, String[] strArr, bx bxVar) {
        if (strArr.length < 4) {
            xz1.i("CodecSpecificDataUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        int i = 1;
        Matcher matcher = c.matcher(strArr[1]);
        if (!matcher.matches()) {
            xz1.i("CodecSpecificDataUtil", "Ignoring malformed HEVC codec string: " + str);
            return null;
        }
        String strGroup = matcher.group(1);
        if (!"1".equals(strGroup)) {
            i = 6;
            if ("2".equals(strGroup)) {
                i = (bxVar == null || bxVar.c != 6) ? 2 : Buffer.SEGMENTING_THRESHOLD;
            } else if (!"6".equals(strGroup)) {
                xz1.i("CodecSpecificDataUtil", "Unknown HEVC profile string: " + strGroup);
                return null;
            }
        }
        String str2 = strArr[3];
        Integer numC = C(str2);
        if (numC != null) {
            return new Pair(Integer.valueOf(i), numC);
        }
        xz1.i("CodecSpecificDataUtil", "Unknown HEVC level string: " + str2);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Pair y(String str, String[] strArr) {
        int i = 4;
        if (strArr.length < 4) {
            xz1.i("CodecSpecificDataUtil", "Ignoring malformed IAMF codec string: " + str);
            return null;
        }
        try {
            int i2 = 1 << (Integer.parseInt(strArr[1]) + 16);
            String str2 = strArr[3];
            str2.getClass();
            switch (str2) {
                case "Opus":
                    i = 1;
                    break;
                case "fLaC":
                    break;
                case "ipcm":
                    i = 8;
                    break;
                case "mp4a":
                    i = 2;
                    break;
                default:
                    xz1.i("CodecSpecificDataUtil", "Ignoring unknown codec identifier for IAMF auxiliary profile: " + strArr[3]);
                    return null;
            }
            return new Pair(Integer.valueOf(16777216 | i2 | i), 0);
        } catch (NumberFormatException e) {
            xz1.j("CodecSpecificDataUtil", "Ignoring malformed primary profile in IAMF codec string: " + strArr[1], e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Pair z(byte[] bArr) {
        boolean z;
        r73 r73Var = new r73(bArr);
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i2 + 3;
            if (i3 >= bArr.length) {
                z = false;
                break;
            }
            if (r73Var.T() == 1 && (bArr[i3] & 240) == 32) {
                z = true;
                break;
            }
            r73Var.f0(r73Var.g() - 2);
            i2++;
        }
        gg3.e(z, "Invalid input: VOL not found.");
        q73 q73Var = new q73(bArr);
        q73Var.r((i2 + 4) * 8);
        q73Var.r(1);
        q73Var.r(8);
        if (q73Var.g()) {
            q73Var.r(4);
            q73Var.r(3);
        }
        if (q73Var.h(4) == 15) {
            q73Var.r(8);
            q73Var.r(8);
        }
        if (q73Var.g()) {
            q73Var.r(2);
            q73Var.r(1);
            if (q73Var.g()) {
                q73Var.r(79);
            }
        }
        gg3.e(q73Var.h(2) == 0, "Only supports rectangular video object layer shape.");
        gg3.d(q73Var.g());
        int iH = q73Var.h(16);
        gg3.d(q73Var.g());
        if (q73Var.g()) {
            gg3.d(iH > 0);
            for (int i4 = iH - 1; i4 > 0; i4 >>= 1) {
                i++;
            }
            q73Var.r(i);
        }
        gg3.d(q73Var.g());
        int iH2 = q73Var.h(13);
        gg3.d(q73Var.g());
        int iH3 = q73Var.h(13);
        gg3.d(q73Var.g());
        q73Var.r(1);
        return Pair.create(Integer.valueOf(iH2), Integer.valueOf(iH3));
    }
}
