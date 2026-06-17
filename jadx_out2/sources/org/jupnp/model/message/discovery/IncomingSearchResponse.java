package org.jupnp.model.message.discovery;

import java.net.URL;
import org.jupnp.model.message.IncomingDatagramMessage;
import org.jupnp.model.message.UpnpHeaders;
import org.jupnp.model.message.UpnpResponse;
import org.jupnp.model.message.header.DeviceUSNHeader;
import org.jupnp.model.message.header.InterfaceMacHeader;
import org.jupnp.model.message.header.LocationHeader;
import org.jupnp.model.message.header.MaxAgeHeader;
import org.jupnp.model.message.header.ServiceUSNHeader;
import org.jupnp.model.message.header.UDNHeader;
import org.jupnp.model.message.header.USNRootDeviceHeader;
import org.jupnp.model.message.header.UpnpHeader;
import org.jupnp.model.types.NamedDeviceType;
import org.jupnp.model.types.NamedServiceType;
import org.jupnp.model.types.UDN;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class IncomingSearchResponse extends IncomingDatagramMessage<UpnpResponse> {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public IncomingSearchResponse(IncomingDatagramMessage<UpnpResponse> incomingDatagramMessage) {
        super(incomingDatagramMessage);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] getInterfaceMacHeader() {
        InterfaceMacHeader interfaceMacHeader = (InterfaceMacHeader) getHeaders().getFirstHeader(UpnpHeader.Type.EXT_IFACE_MAC, InterfaceMacHeader.class);
        if (interfaceMacHeader != null) {
            return interfaceMacHeader.getValue();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public URL getLocationURL() {
        LocationHeader locationHeader = (LocationHeader) getHeaders().getFirstHeader(UpnpHeader.Type.LOCATION, LocationHeader.class);
        if (locationHeader != null) {
            return locationHeader.getValue();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Integer getMaxAge() {
        MaxAgeHeader maxAgeHeader = (MaxAgeHeader) getHeaders().getFirstHeader(UpnpHeader.Type.MAX_AGE, MaxAgeHeader.class);
        if (maxAgeHeader != null) {
            return maxAgeHeader.getValue();
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public UDN getRootDeviceUDN() {
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isSearchResponseMessage() {
        UpnpHeader firstHeader = getHeaders().getFirstHeader(UpnpHeader.Type.ST);
        UpnpHeader firstHeader2 = getHeaders().getFirstHeader(UpnpHeader.Type.USN);
        return (firstHeader == null || firstHeader.getValue() == null || firstHeader2 == null || firstHeader2.getValue() == null || getHeaders().getFirstHeader(UpnpHeader.Type.EXT) == null) ? false : true;
    }
}
