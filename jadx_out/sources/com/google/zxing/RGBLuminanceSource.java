package com.google.zxing;

import defpackage.jl;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class RGBLuminanceSource extends GrayscaleLuminanceSource {
    public RGBLuminanceSource(int i, int i2, int[] iArr) {
        super(i, i2, toGrayscale(i, i2, iArr));
    }

    private static byte[] toGrayscale(int i, int i2, int[] iArr) {
        int i3 = i * i2;
        if (iArr == null || iArr.length < i3) {
            jl.a("Pixel array length is less than width * height");
            return null;
        }
        byte[] bArr = new byte[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = iArr[i4];
            bArr[i4] = (byte) (((((i5 >> 16) & 255) + ((i5 >> 7) & 510)) + (i5 & 255)) / 4);
        }
        return bArr;
    }
}
