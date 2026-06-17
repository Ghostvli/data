package com.hierynomus.smbj.connection;

import com.hierynomus.mssmb2.SMB2Dialect;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NegotiatedProtocol {
    private SMB2Dialect dialect;
    private int maxReadSize;
    private int maxTransactSize;
    private int maxWriteSize;

    public NegotiatedProtocol(SMB2Dialect sMB2Dialect, int i, int i2, int i3, boolean z) {
        this.dialect = sMB2Dialect;
        this.maxTransactSize = z ? i : Math.max(i, 65536);
        this.maxReadSize = z ? i2 : Math.max(i2, 65536);
        this.maxWriteSize = z ? i3 : Math.max(i3, 65536);
    }

    public SMB2Dialect getDialect() {
        return this.dialect;
    }

    public int getMaxReadSize() {
        return this.maxReadSize;
    }

    public int getMaxTransactSize() {
        return this.maxTransactSize;
    }

    public int getMaxWriteSize() {
        return this.maxWriteSize;
    }

    public String toString() {
        return "NegotiatedProtocol{dialect=" + this.dialect + ", maxTransactSize=" + this.maxTransactSize + ", maxReadSize=" + this.maxReadSize + ", maxWriteSize=" + this.maxWriteSize + '}';
    }
}
