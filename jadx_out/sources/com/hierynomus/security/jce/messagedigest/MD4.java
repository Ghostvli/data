package com.hierynomus.security.jce.messagedigest;

import java.security.DigestException;
import java.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MD4 extends MessageDigest {
    private static final int A = 1732584193;
    private static final int B = -271733879;
    public static final int BYTE_BLOCK_LENGTH = 64;
    public static final int BYTE_DIGEST_LENGTH = 16;
    private static final int C = -1732584194;
    private static final int D = 271733878;
    private int a;
    private int b;
    private final byte[] buffer;
    private int c;
    private int d;
    private long msgLength;

    public MD4() {
        super("MD4");
        this.a = A;
        this.b = B;
        this.c = C;
        this.d = D;
        this.buffer = new byte[64];
    }

    private byte[] pad() {
        long j = this.msgLength;
        int i = (int) (j % 64);
        int i2 = i < 56 ? 64 - i : 128 - i;
        byte[] bArr = new byte[i2];
        int i3 = 0;
        bArr[0] = -128;
        long j2 = j << 3;
        int i4 = i2 - 8;
        while (i3 < 8) {
            bArr[i4] = (byte) (j2 >>> (i3 << 3));
            i3++;
            i4++;
        }
        return bArr;
    }

    private void process(byte[] bArr, int i) {
        int i2 = this.a;
        int i3 = this.b;
        int i4 = this.c;
        int i5 = this.d;
        int[] iArr = new int[16];
        int i6 = i;
        for (int i7 = 0; i7 < 16; i7++) {
            int i8 = i6 + 3;
            int i9 = ((bArr[i6 + 1] & 255) << 8) | (bArr[i6] & 255) | ((bArr[i6 + 2] & 255) << 16);
            i6 += 4;
            iArr[i7] = ((bArr[i8] & 255) << 24) | i9;
        }
        int i10 = this.a;
        int i11 = this.b;
        int i12 = this.c;
        int i13 = ~i11;
        int i14 = this.d;
        int i15 = iArr[0];
        int i16 = i10 + ((i11 & i12) | (i13 & i14)) + i15;
        int i17 = (i16 >>> 29) | (i16 << 3);
        int i18 = (i17 & i11) | ((~i17) & i12);
        int i19 = iArr[1];
        int i20 = i14 + i18 + i19;
        int i21 = (i20 << 7) | (i20 >>> 25);
        int i22 = (i21 & i17) | ((~i21) & i11);
        int i23 = iArr[2];
        int i24 = i12 + i22 + i23;
        int i25 = (i24 >>> 21) | (i24 << 11);
        int i26 = ((~i25) & i17) | (i25 & i21);
        int i27 = iArr[3];
        int i28 = i11 + i26 + i27;
        int i29 = (i28 >>> 13) | (i28 << 19);
        int i30 = (i29 & i25) | ((~i29) & i21);
        int i31 = iArr[4];
        int i32 = i17 + i30 + i31;
        int i33 = (i32 >>> 29) | (i32 << 3);
        int i34 = ((~i33) & i25) | (i33 & i29);
        int i35 = iArr[5];
        int i36 = i21 + i34 + i35;
        int i37 = (i36 << 7) | (i36 >>> 25);
        int i38 = ((~i37) & i29) | (i37 & i33);
        int i39 = iArr[6];
        int i40 = i25 + i38 + i39;
        int i41 = (i40 << 11) | (i40 >>> 21);
        int i42 = ((~i41) & i33) | (i41 & i37);
        int i43 = iArr[7];
        int i44 = i29 + i42 + i43;
        int i45 = (i44 << 19) | (i44 >>> 13);
        int i46 = ((~i45) & i37) | (i45 & i41);
        int i47 = iArr[8];
        int i48 = i33 + i46 + i47;
        int i49 = (i48 << 3) | (i48 >>> 29);
        int i50 = ((~i49) & i41) | (i49 & i45);
        int i51 = iArr[9];
        int i52 = i37 + i50 + i51;
        int i53 = (i52 << 7) | (i52 >>> 25);
        int i54 = (i53 & i49) | ((~i53) & i45);
        int i55 = iArr[10];
        int i56 = i41 + i54 + i55;
        int i57 = (i56 << 11) | (i56 >>> 21);
        int i58 = (i57 & i53) | ((~i57) & i49);
        int i59 = iArr[11];
        int i60 = i45 + i58 + i59;
        int i61 = (i60 << 19) | (i60 >>> 13);
        int i62 = (i61 & i57) | ((~i61) & i53);
        int i63 = iArr[12];
        int i64 = i49 + i62 + i63;
        int i65 = (i64 << 3) | (i64 >>> 29);
        int i66 = (i65 & i61) | ((~i65) & i57);
        int i67 = iArr[13];
        int i68 = i53 + i66 + i67;
        int i69 = (i68 << 7) | (i68 >>> 25);
        int i70 = (i69 & i65) | ((~i69) & i61);
        int i71 = iArr[14];
        int i72 = i57 + i70 + i71;
        int i73 = (i72 << 11) | (i72 >>> 21);
        int i74 = (i73 & i69) | ((~i73) & i65);
        int i75 = iArr[15];
        int i76 = i61 + i74 + i75;
        int i77 = (i76 << 19) | (i76 >>> 13);
        int i78 = i65 + ((i77 & (i73 | i69)) | (i73 & i69)) + i15 + 1518500249;
        int i79 = (i78 << 3) | (i78 >>> 29);
        int i80 = i69 + ((i79 & (i77 | i73)) | (i77 & i73)) + i31 + 1518500249;
        int i81 = (i80 << 5) | (i80 >>> 27);
        int i82 = i73 + ((i81 & (i79 | i77)) | (i79 & i77)) + i47 + 1518500249;
        int i83 = (i82 << 9) | (i82 >>> 23);
        int i84 = i77 + ((i83 & (i81 | i79)) | (i81 & i79)) + i63 + 1518500249;
        int i85 = (i84 << 13) | (i84 >>> 19);
        int i86 = i79 + ((i85 & (i83 | i81)) | (i83 & i81)) + i19 + 1518500249;
        int i87 = (i86 << 3) | (i86 >>> 29);
        int i88 = i81 + ((i87 & (i85 | i83)) | (i85 & i83)) + i35 + 1518500249;
        int i89 = (i88 << 5) | (i88 >>> 27);
        int i90 = i83 + ((i89 & (i87 | i85)) | (i87 & i85)) + i51 + 1518500249;
        int i91 = (i90 << 9) | (i90 >>> 23);
        int i92 = i85 + ((i91 & (i89 | i87)) | (i89 & i87)) + i67 + 1518500249;
        int i93 = (i92 << 13) | (i92 >>> 19);
        int i94 = i87 + ((i93 & (i91 | i89)) | (i91 & i89)) + i23 + 1518500249;
        int i95 = (i94 << 3) | (i94 >>> 29);
        int i96 = i89 + ((i95 & (i93 | i91)) | (i93 & i91)) + i39 + 1518500249;
        int i97 = (i96 << 5) | (i96 >>> 27);
        int i98 = i91 + ((i97 & (i95 | i93)) | (i95 & i93)) + i55 + 1518500249;
        int i99 = (i98 << 9) | (i98 >>> 23);
        int i100 = i93 + ((i99 & (i97 | i95)) | (i97 & i95)) + i71 + 1518500249;
        int i101 = (i100 << 13) | (i100 >>> 19);
        int i102 = i95 + ((i101 & (i99 | i97)) | (i99 & i97)) + i27 + 1518500249;
        int i103 = (i102 << 3) | (i102 >>> 29);
        int i104 = i97 + ((i103 & (i101 | i99)) | (i101 & i99)) + i43 + 1518500249;
        int i105 = (i104 << 5) | (i104 >>> 27);
        int i106 = i99 + ((i105 & (i103 | i101)) | (i103 & i101)) + i59 + 1518500249;
        int i107 = (i106 << 9) | (i106 >>> 23);
        int i108 = i101 + ((i107 & (i105 | i103)) | (i105 & i103)) + i75 + 1518500249;
        int i109 = (i108 << 13) | (i108 >>> 19);
        int i110 = i103 + ((i109 ^ i107) ^ i105) + i15 + 1859775393;
        int i111 = (i110 << 3) | (i110 >>> 29);
        int i112 = i105 + ((i111 ^ i109) ^ i107) + i47 + 1859775393;
        int i113 = (i112 << 9) | (i112 >>> 23);
        int i114 = i107 + ((i113 ^ i111) ^ i109) + i31 + 1859775393;
        int i115 = (i114 >>> 21) | (i114 << 11);
        int i116 = i109 + ((i115 ^ i113) ^ i111) + i63 + 1859775393;
        int i117 = (i116 >>> 17) | (i116 << 15);
        int i118 = i111 + ((i117 ^ i115) ^ i113) + i23 + 1859775393;
        int i119 = (i118 << 3) | (i118 >>> 29);
        int i120 = i113 + ((i119 ^ i117) ^ i115) + i55 + 1859775393;
        int i121 = (i120 >>> 23) | (i120 << 9);
        int i122 = i115 + ((i121 ^ i119) ^ i117) + i39 + 1859775393;
        int i123 = (i122 >>> 21) | (i122 << 11);
        int i124 = i117 + ((i123 ^ i121) ^ i119) + i71 + 1859775393;
        int i125 = (i124 >>> 17) | (i124 << 15);
        int i126 = i119 + ((i125 ^ i123) ^ i121) + i19 + 1859775393;
        int i127 = (i126 >>> 29) | (i126 << 3);
        int i128 = i121 + ((i127 ^ i125) ^ i123) + i51 + 1859775393;
        int i129 = (i128 << 9) | (i128 >>> 23);
        int i130 = i123 + ((i129 ^ i127) ^ i125) + i35 + 1859775393;
        int i131 = (i130 >>> 21) | (i130 << 11);
        int i132 = i125 + ((i131 ^ i129) ^ i127) + i67 + 1859775393;
        int i133 = (i132 >>> 17) | (i132 << 15);
        int i134 = i127 + ((i133 ^ i131) ^ i129) + i27 + 1859775393;
        int i135 = (i134 << 3) | (i134 >>> 29);
        int i136 = i129 + ((i135 ^ i133) ^ i131) + i59 + 1859775393;
        int i137 = (i136 >>> 23) | (i136 << 9);
        int i138 = i131 + ((i137 ^ i135) ^ i133) + i43 + 1859775393;
        int i139 = (i138 >>> 21) | (i138 << 11);
        int i140 = i133 + ((i139 ^ i137) ^ i135) + i75 + 1859775393;
        this.a = i135 + i2;
        this.b = ((i140 >>> 17) | (i140 << 15)) + i3;
        this.c = i139 + i4;
        this.d = i137 + i5;
    }

    @Override // java.security.MessageDigestSpi
    public byte[] engineDigest() {
        byte[] bArrPad = pad();
        engineUpdate(bArrPad, 0, bArrPad.length);
        int i = this.a;
        int i2 = this.b;
        int i3 = this.c;
        int i4 = this.d;
        byte[] bArr = {(byte) i, (byte) (i >>> 8), (byte) (i >>> 16), (byte) (i >>> 24), (byte) i2, (byte) (i2 >>> 8), (byte) (i2 >>> 16), (byte) (i2 >>> 24), (byte) i3, (byte) (i3 >>> 8), (byte) (i3 >>> 16), (byte) (i3 >>> 24), (byte) i4, (byte) (i4 >>> 8), (byte) (i4 >>> 16), (byte) (i4 >>> 24)};
        engineReset();
        return bArr;
    }

    @Override // java.security.MessageDigestSpi
    public int engineGetDigestLength() {
        return 16;
    }

    @Override // java.security.MessageDigestSpi
    public void engineReset() {
        this.a = A;
        this.b = B;
        this.c = C;
        this.d = D;
        this.msgLength = 0L;
    }

    @Override // java.security.MessageDigestSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        long j = this.msgLength;
        int i3 = (int) (j % 64);
        int i4 = 64 - i3;
        this.msgLength = j + ((long) i2);
        int i5 = 0;
        if (i2 >= i4) {
            System.arraycopy(bArr, i, this.buffer, i3, i4);
            process(this.buffer, 0);
            while (true) {
                int i6 = i4 + 64;
                if (i4 + 63 >= i2) {
                    break;
                }
                process(bArr, i4 + i);
                i4 = i6;
            }
            i3 = 0;
            i5 = i4;
        }
        if (i5 < i2) {
            System.arraycopy(bArr, i + i5, this.buffer, i3, i2 - i5);
        }
    }

    @Override // java.security.MessageDigestSpi
    public void engineUpdate(byte b) {
        long j = this.msgLength;
        int i = (int) (j % 64);
        byte[] bArr = this.buffer;
        bArr[i] = b;
        this.msgLength = j + 1;
        if (i == 63) {
            process(bArr, 0);
        }
    }

    @Override // java.security.MessageDigestSpi
    public int engineDigest(byte[] bArr, int i, int i2) throws DigestException {
        if (i >= 0 && i + i2 < bArr.length) {
            int iMin = Math.min(i2, 16);
            System.arraycopy(engineDigest(), 0, bArr, i, iMin);
            return iMin;
        }
        throw new DigestException("Wrong offset or not enough space to store the digest");
    }
}
