package com.hierynomus.smbj.common;

import defpackage.e04;
import defpackage.jl;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Check {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void ensure(boolean z, String str) {
        if (z) {
            return;
        }
        e04.a(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void ensureEquals(byte[] bArr, byte[] bArr2, String str) {
        if (Arrays.equals(bArr, bArr2)) {
            return;
        }
        jl.a(str);
    }
}
