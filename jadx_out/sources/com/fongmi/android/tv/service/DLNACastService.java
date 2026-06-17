package com.fongmi.android.tv.service;

import defpackage.i80;
import org.jupnp.UpnpServiceConfiguration;
import org.jupnp.android.AndroidUpnpServiceImpl;
import org.jupnp.model.types.ServiceType;
import org.jupnp.model.types.UDAServiceType;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class DLNACastService extends AndroidUpnpServiceImpl {
    @Override // org.jupnp.android.AndroidUpnpServiceImpl
    public UpnpServiceConfiguration createConfiguration() {
        return new i80() { // from class: com.fongmi.android.tv.service.DLNACastService.1
            @Override // org.jupnp.DefaultUpnpServiceConfiguration, org.jupnp.UpnpServiceConfiguration
            public ServiceType[] getExclusiveServiceTypes() {
                return new ServiceType[]{new UDAServiceType("AVTransport", 1)};
            }
        };
    }

    @Override // org.jupnp.android.AndroidUpnpServiceImpl, android.app.Service
    public void onCreate() {
        super.onCreate();
        this.upnpService.startup();
    }
}
