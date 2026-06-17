package com.hierynomus.smbj.utils;

import com.hierynomus.security.MessageDigest;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DigestUtil {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] digest(MessageDigest messageDigest, byte[] bArr, byte[] bArr2) {
        messageDigest.reset();
        messageDigest.update(bArr);
        messageDigest.update(bArr2);
        return messageDigest.digest();
    }
}
