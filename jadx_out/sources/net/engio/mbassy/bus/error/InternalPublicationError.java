package net.engio.mbassy.bus.error;

import net.engio.mbassy.bus.IMessagePublication;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class InternalPublicationError extends PublicationError {
    public InternalPublicationError(Throwable th, String str, IMessagePublication iMessagePublication) {
        super(th, str, iMessagePublication);
    }

    public InternalPublicationError(Throwable th, String str) {
        super(th, str);
    }
}
