package org.jupnp.support.avtransport.lastchange;

import java.util.Set;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import org.jupnp.model.ModelUtil;
import org.jupnp.support.lastchange.EventedValue;
import org.jupnp.support.lastchange.LastChangeParser;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AVTransportLastChangeParser extends LastChangeParser {
    public static final String NAMESPACE_URI = "urn:schemas-upnp-org:metadata-1-0/AVT/";
    public static final String SCHEMA_RESOURCE = "org/jupnp/support/avtransport/metadata-1.01-avt.xsd";

    @Override // org.jupnp.support.lastchange.LastChangeParser
    public Set<Class<? extends EventedValue<?>>> getEventedVariables() {
        return AVTransportVariable.ALL;
    }

    @Override // org.jupnp.support.lastchange.LastChangeParser
    public String getNamespace() {
        return NAMESPACE_URI;
    }

    @Override // org.jupnp.xml.SAXParser
    public Source[] getSchemaSources() {
        if (ModelUtil.ANDROID_RUNTIME) {
            return null;
        }
        return new Source[]{new StreamSource(Thread.currentThread().getContextClassLoader().getResourceAsStream(SCHEMA_RESOURCE))};
    }
}
