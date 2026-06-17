package com.hierynomus.smbj.event;

import defpackage.j02;
import defpackage.n02;
import net.engio.mbassy.bus.SyncMessageBus;
import net.engio.mbassy.bus.common.PubSubSupport;
import net.engio.mbassy.bus.error.IPublicationErrorHandler;
import net.engio.mbassy.bus.error.PublicationError;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SMBEventBus {
    private static final j02 logger = n02.k(SMBEventBus.class);
    private PubSubSupport<SMBEvent> wrappedBus;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SMBEventBus() {
        this(new SyncMessageBus(new IPublicationErrorHandler() { // from class: com.hierynomus.smbj.event.SMBEventBus.1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // net.engio.mbassy.bus.error.IPublicationErrorHandler
            public void handleError(PublicationError publicationError) {
                if (publicationError.getCause() != null) {
                    SMBEventBus.logger.a(publicationError.toString(), publicationError.getCause());
                } else {
                    SMBEventBus.logger.error(publicationError.toString());
                }
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void publish(SMBEvent sMBEvent) {
        this.wrappedBus.publish(sMBEvent);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void subscribe(Object obj) {
        this.wrappedBus.subscribe(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean unsubscribe(Object obj) {
        return this.wrappedBus.unsubscribe(obj);
    }

    public SMBEventBus(PubSubSupport<SMBEvent> pubSubSupport) {
        this.wrappedBus = pubSubSupport;
    }
}
