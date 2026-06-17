package org.jupnp.protocol;

import defpackage.j02;
import defpackage.n02;
import defpackage.u04;
import org.jupnp.UpnpService;
import org.jupnp.model.message.UpnpMessage;
import org.jupnp.model.message.header.UpnpHeader;
import org.jupnp.util.Exceptions;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ReceivingAsync<M extends UpnpMessage> implements Runnable {
    private M inputMessage;
    private final j02 logger = n02.k(UpnpService.class);
    private final UpnpService upnpService;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ReceivingAsync(UpnpService upnpService, M m) {
        this.upnpService = upnpService;
        this.inputMessage = m;
    }

    public abstract void execute();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public <H extends UpnpHeader> H getFirstHeader(UpnpHeader.Type type, Class<H> cls) {
        return (H) getInputMessage().getHeaders().getFirstHeader(type, cls);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public M getInputMessage() {
        return this.inputMessage;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public UpnpService getUpnpService() {
        return this.upnpService;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Runnable
    public void run() {
        boolean zWaitBeforeExecution;
        try {
            zWaitBeforeExecution = waitBeforeExecution();
        } catch (InterruptedException unused) {
            this.logger.c("Protocol wait before execution interrupted (on shutdown?): {}", getClass().getSimpleName());
            zWaitBeforeExecution = false;
        }
        if (zWaitBeforeExecution) {
            try {
                execute();
            } catch (Exception e) {
                if (Exceptions.unwrap(e) instanceof InterruptedException) {
                    this.logger.A("Interrupted protocol '{}'", getClass().getSimpleName(), e);
                } else {
                    u04.a("Fatal error while executing protocol '", getClass().getSimpleName(), "'", e);
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "(" + getClass().getSimpleName() + ")";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean waitBeforeExecution() {
        return true;
    }
}
