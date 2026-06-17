package org.jupnp.protocol.async;

import defpackage.j02;
import defpackage.jl;
import defpackage.n02;
import org.jupnp.UpnpService;
import org.jupnp.model.message.discovery.OutgoingSearchRequest;
import org.jupnp.model.message.header.MXHeader;
import org.jupnp.model.message.header.STAllHeader;
import org.jupnp.model.message.header.UpnpHeader;
import org.jupnp.protocol.SendingAsync;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SendingSearch extends SendingAsync {
    private final j02 logger;
    private final int mxSeconds;
    private final UpnpHeader searchTarget;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v3, resolved type: org.jupnp.model.message.header.UpnpHeader$Type */
    /* JADX WARN: Multi-variable type inference failed */
    public SendingSearch(UpnpService upnpService, UpnpHeader upnpHeader, int i) {
        super(upnpService);
        this.logger = n02.k(SendingSearch.class);
        if (!UpnpHeader.Type.ST.isValidHeaderType(upnpHeader.getClass())) {
            jl.a("Given search target instance is not a valid header class for type ST: ".concat(String.valueOf(upnpHeader.getClass())));
            throw null;
        }
        this.searchTarget = upnpHeader;
        this.mxSeconds = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.protocol.SendingAsync
    public void execute() {
        this.logger.i("Executing search for target: {} with MX seconds: {}", this.searchTarget.getString(), Integer.valueOf(getMxSeconds()));
        OutgoingSearchRequest outgoingSearchRequest = new OutgoingSearchRequest(this.searchTarget, getMxSeconds());
        prepareOutgoingSearchRequest(outgoingSearchRequest);
        for (int i = 0; i < getBulkRepeat(); i++) {
            try {
                getUpnpService().getRouter().send(outgoingSearchRequest);
                this.logger.h("Sleeping {} milliseconds", Integer.valueOf(getBulkIntervalMilliseconds()));
                Thread.sleep(getBulkIntervalMilliseconds());
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getBulkIntervalMilliseconds() {
        return 500;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getBulkRepeat() {
        return 3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getMxSeconds() {
        return this.mxSeconds;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public UpnpHeader getSearchTarget() {
        return this.searchTarget;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void prepareOutgoingSearchRequest(OutgoingSearchRequest outgoingSearchRequest) {
    }

    public SendingSearch(UpnpService upnpService, UpnpHeader upnpHeader) {
        this(upnpService, upnpHeader, MXHeader.DEFAULT_VALUE.intValue());
    }

    public SendingSearch(UpnpService upnpService) {
        this(upnpService, new STAllHeader());
    }
}
