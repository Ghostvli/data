package com.hierynomus.mssmb2;

import defpackage.bo1;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public enum SMB2Dialect {
    UNKNOWN(0),
    SMB_2_0_2(514),
    SMB_2_1(528),
    SMB_2XX(767),
    SMB_3_0(768),
    SMB_3_0_2(770),
    SMB_3_1_1(785);

    private int value;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    SMB2Dialect(int i) {
        this.value = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static SMB2Dialect lookup(int i) {
        for (SMB2Dialect sMB2Dialect : values()) {
            if (sMB2Dialect.getValue() == i) {
                return sMB2Dialect;
            }
        }
        bo1.a("Unknown SMB2 Dialect: ", i);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean supportsSmb3x(Set<SMB2Dialect> set) {
        Iterator<SMB2Dialect> it = set.iterator();
        while (it.hasNext()) {
            if (it.next().isSmb3x()) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getValue() {
        return this.value;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isSmb3x() {
        return this == SMB_3_0 || this == SMB_3_0_2 || this == SMB_3_1_1;
    }
}
