package defpackage;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class cs {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final or a(int i, tl tlVar, Function1 function1) {
        if (i == -2) {
            return tlVar == tl.f ? new yl(or.a.a(), function1) : new d00(1, tlVar, function1);
        }
        if (i != -1) {
            return i != 0 ? i != Integer.MAX_VALUE ? tlVar == tl.f ? new yl(i, function1) : new d00(i, tlVar, function1) : new yl(Integer.MAX_VALUE, function1) : tlVar == tl.f ? new yl(0, function1) : new d00(1, tlVar, function1);
        }
        if (tlVar == tl.f) {
            return new d00(1, tl.g, function1);
        }
        jl.a("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ or b(int i, tl tlVar, Function1 function1, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            tlVar = tl.f;
        }
        if ((i2 & 4) != 0) {
            function1 = null;
        }
        return a(i, tlVar, function1);
    }
}
