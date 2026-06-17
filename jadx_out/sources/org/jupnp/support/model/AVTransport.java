package org.jupnp.support.model;

import org.jupnp.model.types.UnsignedIntegerFourBytes;
import org.jupnp.support.lastchange.LastChange;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AVTransport {
    protected DeviceCapabilities deviceCapabilities;
    protected final UnsignedIntegerFourBytes instanceID;
    protected final LastChange lastChange;
    protected MediaInfo mediaInfo;
    protected PositionInfo positionInfo;
    protected TransportInfo transportInfo;
    protected TransportSettings transportSettings;

    public AVTransport(UnsignedIntegerFourBytes unsignedIntegerFourBytes, LastChange lastChange, StorageMedium[] storageMediumArr) {
        this.instanceID = unsignedIntegerFourBytes;
        this.lastChange = lastChange;
        setDeviceCapabilities(new DeviceCapabilities(storageMediumArr));
        setMediaInfo(new MediaInfo());
        setTransportInfo(new TransportInfo());
        setPositionInfo(new PositionInfo());
        setTransportSettings(new TransportSettings());
    }

    public DeviceCapabilities getDeviceCapabilities() {
        return this.deviceCapabilities;
    }

    public UnsignedIntegerFourBytes getInstanceId() {
        return this.instanceID;
    }

    public LastChange getLastChange() {
        return this.lastChange;
    }

    public MediaInfo getMediaInfo() {
        return this.mediaInfo;
    }

    public PositionInfo getPositionInfo() {
        return this.positionInfo;
    }

    public TransportInfo getTransportInfo() {
        return this.transportInfo;
    }

    public TransportSettings getTransportSettings() {
        return this.transportSettings;
    }

    public void setDeviceCapabilities(DeviceCapabilities deviceCapabilities) {
        this.deviceCapabilities = deviceCapabilities;
    }

    public void setMediaInfo(MediaInfo mediaInfo) {
        this.mediaInfo = mediaInfo;
    }

    public void setPositionInfo(PositionInfo positionInfo) {
        this.positionInfo = positionInfo;
    }

    public void setTransportInfo(TransportInfo transportInfo) {
        this.transportInfo = transportInfo;
    }

    public void setTransportSettings(TransportSettings transportSettings) {
        this.transportSettings = transportSettings;
    }

    public AVTransport(UnsignedIntegerFourBytes unsignedIntegerFourBytes, LastChange lastChange, StorageMedium storageMedium) {
        this(unsignedIntegerFourBytes, lastChange, new StorageMedium[]{storageMedium});
    }
}
