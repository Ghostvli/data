package org.jupnp.model.types;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NamedServiceType {
    private ServiceType serviceType;
    private UDN udn;

    public NamedServiceType(UDN udn, ServiceType serviceType) {
        this.udn = udn;
        this.serviceType = serviceType;
    }

    public static NamedServiceType valueOf(String str) {
        String[] strArrSplit = str.split("::");
        if (strArrSplit.length != 2) {
            throw new InvalidValueException("Can't parse UDN::ServiceType from: ".concat(str));
        }
        try {
            return new NamedServiceType(UDN.valueOf(strArrSplit[0]), ServiceType.valueOf(strArrSplit[1]));
        } catch (Exception unused) {
            throw new InvalidValueException("Can't parse UDN: " + strArrSplit[0]);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof NamedServiceType)) {
            return false;
        }
        NamedServiceType namedServiceType = (NamedServiceType) obj;
        return this.serviceType.equals(namedServiceType.serviceType) && this.udn.equals(namedServiceType.udn);
    }

    public ServiceType getServiceType() {
        return this.serviceType;
    }

    public UDN getUdn() {
        return this.udn;
    }

    public int hashCode() {
        return (this.udn.hashCode() * 31) + this.serviceType.hashCode();
    }

    public String toString() {
        return getUdn().toString() + "::" + getServiceType().toString();
    }
}
