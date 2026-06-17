package org.jupnp.model.message.header;

import defpackage.tf1;
import org.jupnp.model.Constants;
import org.jupnp.model.types.HostPort;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class HostHeader extends UpnpHeader<HostPort> {
    int port = Constants.UPNP_MULTICAST_PORT;
    String group = Constants.IPV4_UPNP_MULTICAST_GROUP;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public HostHeader() {
        setValue(new HostPort(Constants.IPV4_UPNP_MULTICAST_GROUP, Constants.UPNP_MULTICAST_PORT));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        return getValue().toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        if (!str.contains(":")) {
            this.group = str;
            setValue(new HostPort(str, this.port));
            return;
        }
        try {
            this.port = Integer.parseInt(str.substring(str.indexOf(":") + 1));
            String strSubstring = str.substring(0, str.indexOf(":"));
            this.group = strSubstring;
            setValue(new HostPort(strSubstring, this.port));
        } catch (NumberFormatException e) {
            tf1.a("Invalid HOST header value, can't parse port: ", str, " - ", e.getMessage(), e);
        }
    }

    public HostHeader(int i) {
        setValue(new HostPort(Constants.IPV4_UPNP_MULTICAST_GROUP, i));
    }

    public HostHeader(String str, int i) {
        setValue(new HostPort(str, i));
    }
}
