package org.jupnp.util.statemachine;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class TransitionException extends RuntimeException {
    private static final long serialVersionUID = -8079683510134407318L;

    public TransitionException(String str) {
        super(str);
    }

    public TransitionException(String str, Throwable th) {
        super(str, th);
    }
}
