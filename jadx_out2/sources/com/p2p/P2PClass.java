package com.p2p;

import com.github.catvod.utils.Path;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class P2PClass {
    public int port;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public P2PClass() {
        System.loadLibrary("jpa");
        this.port = P2Pdoxstarthttpd("TEST3E63BAAECDAA79BEAA91853490A69F08".getBytes(), Path.jpa().getAbsolutePath().getBytes());
    }

    private native int doxpause(byte[] bArr);

    private native int doxstart(byte[] bArr);

    private native int doxstarthttpd(byte[] bArr, byte[] bArr2);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void P2Pdoxpause(byte[] bArr) {
        doxpause(bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void P2Pdoxstart(byte[] bArr) {
        doxstart(bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int P2Pdoxstarthttpd(byte[] bArr, byte[] bArr2) {
        return doxstarthttpd(bArr, bArr2);
    }
}
