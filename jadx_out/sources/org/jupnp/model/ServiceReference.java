package org.jupnp.model;

import org.jupnp.model.types.ServiceId;
import org.jupnp.model.types.UDN;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ServiceReference {
    public static final String DELIMITER = "/";
    private final ServiceId serviceId;
    private final UDN udn;

    public ServiceReference(String str) {
        String[] strArrSplit = str.split(DELIMITER);
        if (strArrSplit.length == 2) {
            this.udn = UDN.valueOf(strArrSplit[0]);
            this.serviceId = ServiceId.valueOf(strArrSplit[1]);
        } else {
            this.udn = null;
            this.serviceId = null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ServiceReference serviceReference = (ServiceReference) obj;
        return this.serviceId.equals(serviceReference.serviceId) && this.udn.equals(serviceReference.udn);
    }

    public ServiceId getServiceId() {
        return this.serviceId;
    }

    public UDN getUdn() {
        return this.udn;
    }

    public int hashCode() {
        return (this.udn.hashCode() * 31) + this.serviceId.hashCode();
    }

    public String toString() {
        UDN udn = this.udn;
        if (udn == null || this.serviceId == null) {
            return "";
        }
        return String.valueOf(udn) + DELIMITER + String.valueOf(this.serviceId);
    }

    public ServiceReference(UDN udn, ServiceId serviceId) {
        this.udn = udn;
        this.serviceId = serviceId;
    }
}
