package org.jupnp.binding.xml;

import defpackage.j02;
import defpackage.n02;
import org.jupnp.model.meta.Service;
import org.jupnp.util.SpecificationViolationReporter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class RecoveringUDA10ServiceDescriptorBinderImpl extends UDA10ServiceDescriptorBinderImpl {
    private final j02 logger = n02.k(ServiceDescriptorBinder.class);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.binding.xml.UDA10ServiceDescriptorBinderImpl, org.jupnp.binding.xml.ServiceDescriptorBinder
    public <S extends Service> S describe(S s, String str) {
        try {
            return (S) super.describe(s, fixWrongNamespaces(str));
        } catch (DescriptorBindingException e) {
            this.logger.warn(e.getMessage());
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String fixWrongNamespaces(String str) {
        if (!str.contains("<scpd xmlns=\"urn:Belkin:service-1-0\">")) {
            return str;
        }
        SpecificationViolationReporter.report("Detected invalid scpd namespace 'urn:Belkin', replacing it with 'urn:schemas-upnp-org'", new Object[0]);
        return str.replaceAll("<scpd xmlns=\"urn:Belkin:service-1-0\">", "<scpd xmlns=\"urn:schemas-upnp-org:service-1-0\">");
    }
}
