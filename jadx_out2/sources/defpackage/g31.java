package defpackage;

import defpackage.u81;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract /* synthetic */ class g31 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final z21 a(z21 z21Var, int i, tl tlVar) {
        if (i < 0 && i != -2 && i != -1) {
            vx4.a("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was ", i);
            return null;
        }
        if (i == -1 && tlVar != tl.f) {
            jl.a("CONFLATED capacity cannot be used with non-default onBufferOverflow");
            return null;
        }
        if (i == -1) {
            tlVar = tl.g;
            i = 0;
        }
        int i2 = i;
        tl tlVar2 = tlVar;
        if (z21Var instanceof u81) {
            return u81.a.a((u81) z21Var, null, i2, tlVar2, 1, null);
        }
        return new wr(z21Var, null, i2, tlVar2, 2, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ z21 b(z21 z21Var, int i, tl tlVar, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = -2;
        }
        if ((i2 & 2) != 0) {
            tlVar = tl.f;
        }
        return c31.a(z21Var, i, tlVar);
    }
}
