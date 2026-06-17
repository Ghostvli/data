package com.hierynomus.ntlm.messages;

import com.hierynomus.ntlm.functions.NtlmFunctions;
import com.hierynomus.protocol.commons.buffer.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class Utils {
    public static byte[] EMPTY = new byte[0];

    private Utils() {
    }

    public static byte[] ensureNotNull(String str) {
        return str != null ? NtlmFunctions.unicode(str) : EMPTY;
    }

    public static int writeOffsettedByteArrayFields(Buffer.PlainBuffer plainBuffer, byte[] bArr, int i) {
        if (bArr == null) {
            bArr = EMPTY;
        }
        plainBuffer.putUInt16(bArr.length);
        plainBuffer.putUInt16(bArr.length);
        plainBuffer.putUInt32(i);
        return i + bArr.length;
    }

    public static byte[] ensureNotNull(byte[] bArr) {
        return bArr != null ? bArr : EMPTY;
    }
}
