package org.jupnp.model.meta;

import java.util.ArrayList;
import java.util.List;
import org.jupnp.model.Validatable;
import org.jupnp.model.ValidationError;
import org.jupnp.model.types.UDN;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DeviceIdentity implements Validatable {
    private final Integer maxAgeSeconds;
    private final UDN udn;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DeviceIdentity(UDN udn) {
        this.udn = udn;
        this.maxAgeSeconds = 1800;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.udn.equals(((DeviceIdentity) obj).udn);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Integer getMaxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public UDN getUdn() {
        return this.udn;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return this.udn.hashCode();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "(" + getClass().getSimpleName() + ") UDN: " + String.valueOf(getUdn());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.Validatable
    public List<ValidationError> validate() {
        ArrayList arrayList = new ArrayList();
        if (getUdn() == null) {
            arrayList.add(new ValidationError(getClass(), "major", "Device has no UDN"));
        }
        return arrayList;
    }

    public DeviceIdentity(UDN udn, DeviceIdentity deviceIdentity) {
        this.udn = udn;
        this.maxAgeSeconds = deviceIdentity.getMaxAgeSeconds();
    }

    public DeviceIdentity(UDN udn, Integer num) {
        this.udn = udn;
        this.maxAgeSeconds = num;
    }
}
