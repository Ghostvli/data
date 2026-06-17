package org.jupnp.model.types;

import defpackage.f80;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jupnp.util.SpecificationViolationReporter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class UDAServiceId extends ServiceId {
    public static final String BROKEN_DEFAULT_NAMESPACE = "schemas-upnp-org";
    public static final String DEFAULT_NAMESPACE = "upnp-org";
    public static final Pattern PATTERN = Pattern.compile("urn:upnp-org:serviceId:([a-zA-Z_0-9\\-:\\.]{1,64})");
    public static final Pattern BROKEN_PATTERN = Pattern.compile("urn:schemas-upnp-org:service:([a-zA-Z_0-9\\-:\\.]{1,64})");

    public UDAServiceId(String str) {
        super(DEFAULT_NAMESPACE, str);
    }

    public static UDAServiceId valueOf(String str) {
        Matcher matcher = PATTERN.matcher(str);
        if (matcher.matches() && matcher.groupCount() >= 1) {
            return new UDAServiceId(matcher.group(1));
        }
        Matcher matcher2 = BROKEN_PATTERN.matcher(str);
        if (matcher2.matches() && matcher2.groupCount() >= 1) {
            return new UDAServiceId(matcher2.group(1));
        }
        Matcher matcher3 = Pattern.compile("urn:upnp-orgerviceId:urnchemas-upnp-orgervice:([a-zA-Z_0-9\\-:\\.]{1,64})").matcher(str);
        if (matcher3.matches()) {
            SpecificationViolationReporter.report("Recovering from Eyecon garbage: {}", str);
            return new UDAServiceId(matcher3.group(1));
        }
        if ("ContentDirectory".equals(str) || "ConnectionManager".equals(str) || "RenderingControl".equals(str) || "AVTransport".equals(str)) {
            SpecificationViolationReporter.report("Fixing broken Service ID: {}", str);
            return new UDAServiceId(str);
        }
        f80.a("Can't parse UDA service ID string (upnp-org/id): ", str);
        return null;
    }
}
