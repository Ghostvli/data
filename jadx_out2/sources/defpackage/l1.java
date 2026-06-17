package defpackage;

import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.t41;
import java.nio.ByteBuffer;
import okio.Utf8;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class l1 {
    public static final int[] a = {1, 2, 3, 6};
    public static final int[] b = {48000, 44100, 32000};
    public static final int[] c = {24000, 22050, 16000};
    public static final int[] d = {2, 1, 2, 3, 3, 4, 4, 5};
    public static final int[] e = {32, 40, 48, 56, 64, 80, 96, Token.ASSIGN_MOD, 128, 160, 192, 224, Buffer.DEFAULT_SIZE, 320, 384, 448, 512, 576, 640};
    public static final int[] f = {69, 87, Token.ASSIGN_LOGICAL_AND, Token.DOT, Token.VOID, Token.DEBUGGER, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final String a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(String str, int i, int i2, int i3, int i4, int i5, int i6) {
            this.a = str;
            this.b = i;
            this.d = i2;
            this.c = i3;
            this.e = i4;
            this.f = i5;
            this.g = i6;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int a(int i, int i2, int i3) {
        return (i * i2) / (i3 * 32);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int b(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int iLimit = byteBuffer.limit() - 10;
        for (int i = iPosition; i <= iLimit; i++) {
            if ((fy4.V(byteBuffer, i + 4) & (-2)) == -126718022) {
                return i - iPosition;
            }
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int c(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0) {
            return -1;
        }
        int[] iArr = b;
        if (i >= iArr.length || i2 < 0) {
            return -1;
        }
        int[] iArr2 = f;
        if (i3 >= iArr2.length) {
            return -1;
        }
        int i4 = iArr[i];
        if (i4 == 44100) {
            return (iArr2[i3] + (i2 % 2)) * 2;
        }
        int i5 = e[i3];
        return i4 == 32000 ? i5 * 6 : i5 * 4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static t41 d(r73 r73Var, String str, String str2, oo0 oo0Var) {
        q73 q73Var = new q73();
        q73Var.m(r73Var);
        int i = b[q73Var.h(2)];
        q73Var.r(8);
        int i2 = d[q73Var.h(3)];
        if (q73Var.h(1) != 0) {
            i2++;
        }
        int i3 = e[q73Var.h(5)] * 1000;
        q73Var.c();
        r73Var.f0(q73Var.d());
        return new t41.b().k0(str).A0("audio/ac3").U(i2).B0(i).d0(oo0Var).o0(str2).T(i3).u0(i3).Q();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int e(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return a[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * Buffer.DEFAULT_SIZE;
        }
        return 1536;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static b f(q73 q73Var) {
        int iC;
        int i;
        int i2;
        int i3;
        String str;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int iE = q73Var.e();
        q73Var.r(40);
        boolean z = q73Var.h(5) > 10;
        q73Var.p(iE);
        int i10 = -1;
        if (z) {
            q73Var.r(16);
            int iH = q73Var.h(2);
            if (iH == 0) {
                i10 = 0;
            } else if (iH == 1) {
                i10 = 1;
            } else if (iH == 2) {
                i10 = 2;
            }
            q73Var.r(3);
            iC = (q73Var.h(11) + 1) * 2;
            int iH2 = q73Var.h(2);
            if (iH2 == 3) {
                i = c[q73Var.h(2)];
                i5 = 3;
                i6 = 6;
            } else {
                int iH3 = q73Var.h(2);
                int i11 = a[iH3];
                i5 = iH3;
                i = b[iH2];
                i6 = i11;
            }
            i3 = i6 * Buffer.DEFAULT_SIZE;
            int iA = a(iC, i, i6);
            int iH4 = q73Var.h(3);
            boolean zG = q73Var.g();
            i2 = d[iH4] + (zG ? 1 : 0);
            q73Var.r(10);
            if (q73Var.g()) {
                q73Var.r(8);
            }
            if (iH4 == 0) {
                q73Var.r(5);
                if (q73Var.g()) {
                    q73Var.r(8);
                }
            }
            if (i10 == 1 && q73Var.g()) {
                q73Var.r(16);
            }
            if (q73Var.g()) {
                if (iH4 > 2) {
                    q73Var.r(2);
                }
                if ((iH4 & 1) == 0 || iH4 <= 2) {
                    i8 = 6;
                } else {
                    i8 = 6;
                    q73Var.r(6);
                }
                if ((iH4 & 4) != 0) {
                    q73Var.r(i8);
                }
                if (zG && q73Var.g()) {
                    q73Var.r(5);
                }
                if (i10 == 0) {
                    if (q73Var.g()) {
                        i9 = 6;
                        q73Var.r(6);
                    } else {
                        i9 = 6;
                    }
                    if (iH4 == 0 && q73Var.g()) {
                        q73Var.r(i9);
                    }
                    if (q73Var.g()) {
                        q73Var.r(i9);
                    }
                    int iH5 = q73Var.h(2);
                    if (iH5 == 1) {
                        q73Var.r(5);
                    } else if (iH5 == 2) {
                        q73Var.r(12);
                    } else if (iH5 == 3) {
                        int iH6 = q73Var.h(5);
                        if (q73Var.g()) {
                            q73Var.r(5);
                            if (q73Var.g()) {
                                q73Var.r(4);
                            }
                            if (q73Var.g()) {
                                q73Var.r(4);
                            }
                            if (q73Var.g()) {
                                q73Var.r(4);
                            }
                            if (q73Var.g()) {
                                q73Var.r(4);
                            }
                            if (q73Var.g()) {
                                q73Var.r(4);
                            }
                            if (q73Var.g()) {
                                q73Var.r(4);
                            }
                            if (q73Var.g()) {
                                q73Var.r(4);
                            }
                            if (q73Var.g()) {
                                if (q73Var.g()) {
                                    q73Var.r(4);
                                }
                                if (q73Var.g()) {
                                    q73Var.r(4);
                                }
                            }
                        }
                        if (q73Var.g()) {
                            q73Var.r(5);
                            if (q73Var.g()) {
                                q73Var.r(7);
                                if (q73Var.g()) {
                                    q73Var.r(8);
                                }
                            }
                        }
                        q73Var.r((iH6 + 2) * 8);
                        q73Var.c();
                    }
                    if (iH4 < 2) {
                        if (q73Var.g()) {
                            q73Var.r(14);
                        }
                        if (iH4 == 0 && q73Var.g()) {
                            q73Var.r(14);
                        }
                    }
                    if (q73Var.g()) {
                        if (i5 == 0) {
                            q73Var.r(5);
                        } else {
                            for (int i12 = 0; i12 < i6; i12++) {
                                if (q73Var.g()) {
                                    q73Var.r(5);
                                }
                            }
                        }
                    }
                }
            }
            if (q73Var.g()) {
                q73Var.r(5);
                if (iH4 == 2) {
                    q73Var.r(4);
                }
                if (iH4 >= 6) {
                    q73Var.r(2);
                }
                if (q73Var.g()) {
                    q73Var.r(8);
                }
                if (iH4 == 0 && q73Var.g()) {
                    q73Var.r(8);
                }
                if (iH2 < 3) {
                    q73Var.q();
                }
            }
            if (i10 == 0 && i5 != 3) {
                q73Var.q();
            }
            if (i10 == 2 && (i5 == 3 || q73Var.g())) {
                i7 = 6;
                q73Var.r(6);
            } else {
                i7 = 6;
            }
            str = (q73Var.g() && q73Var.h(i7) == 1 && q73Var.h(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i4 = iA;
        } else {
            q73Var.r(32);
            int iH7 = q73Var.h(2);
            String str2 = iH7 == 3 ? null : "audio/ac3";
            int iH8 = q73Var.h(6);
            int i13 = e[iH8 / 2] * 1000;
            iC = c(iH7, iH8);
            q73Var.r(8);
            int iH9 = q73Var.h(3);
            if ((iH9 & 1) != 0 && iH9 != 1) {
                q73Var.r(2);
            }
            if ((iH9 & 4) != 0) {
                q73Var.r(2);
            }
            if (iH9 == 2) {
                q73Var.r(2);
            }
            int[] iArr = b;
            i = iH7 < iArr.length ? iArr[iH7] : -1;
            i2 = d[iH9] + (q73Var.g() ? 1 : 0);
            i3 = 1536;
            str = str2;
            i4 = i13;
        }
        return new b(str, i10, i2, i, iC, i3, i4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int g(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        byte b2 = bArr[4];
        return c((b2 & 192) >> 6, b2 & Utf8.REPLACEMENT_BYTE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static t41 h(r73 r73Var, String str, String str2, oo0 oo0Var) {
        String str3;
        q73 q73Var = new q73();
        q73Var.m(r73Var);
        int iH = q73Var.h(13) * 1000;
        q73Var.r(3);
        int i = b[q73Var.h(2)];
        q73Var.r(10);
        int i2 = d[q73Var.h(3)];
        if (q73Var.h(1) != 0) {
            i2++;
        }
        q73Var.r(3);
        int iH2 = q73Var.h(4);
        q73Var.r(1);
        if (iH2 > 0) {
            q73Var.r(6);
            if (q73Var.h(1) != 0) {
                i2 += 2;
            }
            q73Var.r(1);
        }
        if (q73Var.b() > 7) {
            q73Var.r(7);
            str3 = q73Var.h(1) != 0 ? "audio/eac3-joc" : "audio/eac3";
        }
        q73Var.c();
        r73Var.f0(q73Var.d());
        return new t41.b().k0(str).A0(str3).U(i2).B0(i).d0(oo0Var).o0(str2).u0(iH).Q();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int i(ByteBuffer byteBuffer, int i) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i) + ((byteBuffer.get((byteBuffer.position() + i) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int j(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b2 = bArr[7];
            if ((b2 & 254) == 186) {
                return 40 << ((bArr[(b2 & 255) == 187 ? '\t' : '\b'] >> 4) & 7);
            }
        }
        return 0;
    }
}
