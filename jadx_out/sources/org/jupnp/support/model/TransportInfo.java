package org.jupnp.support.model;

import java.util.Map;
import org.jupnp.model.action.ActionArgumentValue;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class TransportInfo {
    private String currentSpeed;
    private TransportState currentTransportState;
    private TransportStatus currentTransportStatus;

    public TransportInfo(Map<String, ActionArgumentValue<?>> map) {
        this(TransportState.valueOrCustomOf((String) map.get("CurrentTransportState").getValue()), TransportStatus.valueOrCustomOf((String) map.get("CurrentTransportStatus").getValue()), (String) map.get("CurrentSpeed").getValue());
    }

    public String getCurrentSpeed() {
        return this.currentSpeed;
    }

    public TransportState getCurrentTransportState() {
        return this.currentTransportState;
    }

    public TransportStatus getCurrentTransportStatus() {
        return this.currentTransportStatus;
    }

    public TransportInfo() {
        this.currentTransportState = TransportState.NO_MEDIA_PRESENT;
        this.currentTransportStatus = TransportStatus.OK;
        this.currentSpeed = "1";
    }

    public TransportInfo(TransportState transportState) {
        this.currentTransportState = TransportState.NO_MEDIA_PRESENT;
        this.currentTransportStatus = TransportStatus.OK;
        this.currentSpeed = "1";
        this.currentTransportState = transportState;
    }

    public TransportInfo(TransportState transportState, String str) {
        this.currentTransportState = TransportState.NO_MEDIA_PRESENT;
        this.currentTransportStatus = TransportStatus.OK;
        this.currentTransportState = transportState;
        this.currentSpeed = str;
    }

    public TransportInfo(TransportState transportState, TransportStatus transportStatus) {
        this.currentTransportState = TransportState.NO_MEDIA_PRESENT;
        TransportStatus transportStatus2 = TransportStatus.OK;
        this.currentSpeed = "1";
        this.currentTransportState = transportState;
        this.currentTransportStatus = transportStatus;
    }

    public TransportInfo(TransportState transportState, TransportStatus transportStatus, String str) {
        this.currentTransportState = TransportState.NO_MEDIA_PRESENT;
        TransportStatus transportStatus2 = TransportStatus.OK;
        this.currentTransportState = transportState;
        this.currentTransportStatus = transportStatus;
        this.currentSpeed = str;
    }
}
