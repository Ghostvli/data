package org.jupnp.util;

import defpackage.j02;
import defpackage.n02;
import org.jupnp.model.meta.Device;
import org.jupnp.model.meta.DeviceIdentity;
import org.jupnp.model.meta.Service;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SpecificationViolationReporter {
    private static final SpecificationViolationReporter INSTANCE = new SpecificationViolationReporter();
    private volatile boolean enabled = true;
    private final j02 logger = n02.k(SpecificationViolationReporter.class);

    private void _disableReporting() {
        this.enabled = false;
    }

    private void _enableReporting() {
        this.enabled = true;
    }

    private void _report(Device<DeviceIdentity, Device, Service> device, String str, Object... objArr) {
        if (this.enabled) {
            if (device == null) {
                this.logger.m("{}: " + str, "UPnP specification violation", objArr);
                return;
            }
            this.logger.k("{} of device '{}': " + str, "UPnP specification violation", device, objArr);
        }
    }

    public static void disableReporting() {
        INSTANCE._disableReporting();
    }

    public static void enableReporting() {
        INSTANCE._enableReporting();
    }

    public static void report(String str, Object... objArr) {
        INSTANCE._report(str, objArr);
    }

    public static void report(Device<DeviceIdentity, Device, Service> device, String str, Object... objArr) {
        INSTANCE._report(device, str, objArr);
    }

    private void _report(String str, Object... objArr) {
        if (this.enabled) {
            this.logger.m("{}: " + str, "UPnP specification violation", objArr);
        }
    }
}
