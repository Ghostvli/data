package org.jupnp.model.message.header;

import defpackage.tn3;
import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class LocationHeader extends UpnpHeader<URL> {
    public LocationHeader(URL url) {
        setValue(url);
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        return getValue().toString();
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        try {
            setValue(new URL(str));
        } catch (MalformedURLException e) {
            tn3.a("Invalid URI: ", e.getMessage(), e);
        }
    }

    public LocationHeader() {
    }

    public LocationHeader(String str) {
        setString(str);
    }
}
