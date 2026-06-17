package net.engio.mbassy.bus.error;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MessageBusException extends Exception {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public MessageBusException(String str) {
        super(str);
    }

    public MessageBusException(String str, Throwable th) {
        super(str, th);
    }

    public MessageBusException(Throwable th) {
        super(th);
    }
}
