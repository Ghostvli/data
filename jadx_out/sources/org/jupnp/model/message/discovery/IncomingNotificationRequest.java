package org.jupnp.model.message.discovery;

import java.net.URL;
import org.jupnp.model.message.IncomingDatagramMessage;
import org.jupnp.model.message.UpnpHeaders;
import org.jupnp.model.message.UpnpRequest;
import org.jupnp.model.message.header.DeviceUSNHeader;
import org.jupnp.model.message.header.InterfaceMacHeader;
import org.jupnp.model.message.header.LocationHeader;
import org.jupnp.model.message.header.MaxAgeHeader;
import org.jupnp.model.message.header.NTSHeader;
import org.jupnp.model.message.header.ServiceUSNHeader;
import org.jupnp.model.message.header.UDNHeader;
import org.jupnp.model.message.header.USNRootDeviceHeader;
import org.jupnp.model.message.header.UpnpHeader;
import org.jupnp.model.types.NamedDeviceType;
import org.jupnp.model.types.NamedServiceType;
import org.jupnp.model.types.NotificationSubtype;
import org.jupnp.model.types.UDN;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class IncomingNotificationRequest extends IncomingDatagramMessage<UpnpRequest> {
    public IncomingNotificationRequest(IncomingDatagramMessage<UpnpRequest> incomingDatagramMessage) {
        super(incomingDatagramMessage);
    }

    public byte[] getInterfaceMacHeader() {
        InterfaceMacHeader interfaceMacHeader = (InterfaceMacHeader) getHeaders().getFirstHeader(UpnpHeader.Type.EXT_IFACE_MAC, InterfaceMacHeader.class);
        if (interfaceMacHeader != null) {
            return interfaceMacHeader.getValue();
        }
        return null;
    }

    public URL getLocationURL() {
        LocationHeader locationHeader = (LocationHeader) getHeaders().getFirstHeader(UpnpHeader.Type.LOCATION, LocationHeader.class);
        if (locationHeader != null) {
            return locationHeader.getValue();
        }
        return null;
    }

    public Integer getMaxAge() {
        MaxAgeHeader maxAgeHeader = (MaxAgeHeader) getHeaders().getFirstHeader(UpnpHeader.Type.MAX_AGE, MaxAgeHeader.class);
        if (maxAgeHeader != null) {
            return maxAgeHeader.getValue();
        }
        return null;
    }

    public UDN getUDN() {
        UpnpHeaders headers = getHeaders();
        UpnpHeader.Type type = UpnpHeader.Type.USN;
        UpnpHeader firstHeader = headers.getFirstHeader(type, USNRootDeviceHeader.class);
        if (firstHeader != null) {
            return (UDN) firstHeader.getValue();
        }
        UpnpHeader firstHeader2 = getHeaders().getFirstHeader(type, UDNHeader.class);
        if (firstHeader2 != null) {
            return (UDN) firstHeader2.getValue();
        }
        UpnpHeader firstHeader3 = getHeaders().getFirstHeader(type, DeviceUSNHeader.class);
        if (firstHeader3 != null) {
            return ((NamedDeviceType) firstHeader3.getValue()).getUdn();
        }
        UpnpHeader firstHeader4 = getHeaders().getFirstHeader(type, ServiceUSNHeader.class);
        if (firstHeader4 != null) {
            return ((NamedServiceType) firstHeader4.getValue()).getUdn();
        }
        return null;
    }

    public boolean isAliveMessage() {
        NTSHeader nTSHeader = (NTSHeader) getHeaders().getFirstHeader(UpnpHeader.Type.NTS, NTSHeader.class);
        return nTSHeader != null && nTSHeader.getValue().equals(NotificationSubtype.ALIVE);
    }

    public boolean isByeByeMessage() {
        NTSHeader nTSHeader = (NTSHeader) getHeaders().getFirstHeader(UpnpHeader.Type.NTS, NTSHeader.class);
        return nTSHeader != null && nTSHeader.getValue().equals(NotificationSubtype.BYEBYE);
    }
}
