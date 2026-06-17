package org.jupnp.binding.xml;

import defpackage.j02;
import defpackage.n02;
import java.util.regex.Pattern;
import org.jupnp.model.meta.Service;
import org.jupnp.util.SpecificationViolationReporter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class RecoveringUDA10ServiceDescriptorBinderSAXImpl extends UDA10ServiceDescriptorBinderSAXImpl {
    private final j02 logger = n02.k(ServiceDescriptorBinder.class);

    @Override // org.jupnp.binding.xml.UDA10ServiceDescriptorBinderSAXImpl, org.jupnp.binding.xml.UDA10ServiceDescriptorBinderImpl, org.jupnp.binding.xml.ServiceDescriptorBinder
    public <S extends Service> S describe(S s, String str) throws DescriptorBindingException {
        if (str == null || str.isEmpty()) {
            throw new DescriptorBindingException("Null or empty descriptor");
        }
        try {
            this.logger.y("Reading service from XML descriptor");
            return (S) super.describe(s, fixQuotes(fixRetval(fixBOM(str))));
        } catch (DescriptorBindingException e) {
            this.logger.warn(e.getMessage());
            return null;
        }
    }

    public String fixBOM(String str) {
        if (!str.contains("<scpd xmlns=\"urn:Belkin:service-1-0\">")) {
            return str;
        }
        String strReplaceFirst = Pattern.compile("^([\\W]+)<").matcher(str.trim().replaceFirst("^([\\W]+)<", "<").trim()).replaceFirst("<");
        SpecificationViolationReporter.report("Detected UTF-8 BOM, replacing it", new Object[0]);
        return strReplaceFirst.replaceAll("\u0000", " ");
    }

    public String fixQuotes(String str) {
        if (!str.contains("<scpd xmlns=\"urn:Belkin:service-1-0\">") || !str.contains("Key\"")) {
            return str;
        }
        SpecificationViolationReporter.report("Detected invalid quotes, replacing it", new Object[0]);
        return str.replaceAll("\"smartprivateKey\"", "smartprivateKey").replaceAll("\"pluginprivateKey\"", "pluginprivateKey");
    }

    public String fixRetval(String str) {
        if (!str.contains("<scpd xmlns=\"urn:Belkin:service-1-0\">") || !str.contains("<retval")) {
            return str;
        }
        SpecificationViolationReporter.report("Detected invalid service value 'retval', replacing it", new Object[0]);
        return str.replaceAll("<retval/>", " ").replaceAll("<retval />", " ");
    }
}
