package org.jupnp.model.types;

import defpackage.jl;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jupnp.model.Constants;
import org.jupnp.util.SpecificationViolationReporter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ServiceId {
    public static final String UNKNOWN = "UNKNOWN";
    private String id;
    private String namespace;
    public static final Pattern PATTERN = Pattern.compile("urn:([a-zA-Z0-9\\-\\.]+):serviceId:([a-zA-Z_0-9\\-:\\.]{1,64})");
    public static final Pattern BROKEN_PATTERN = Pattern.compile("urn:([a-zA-Z0-9\\-\\.]+):service:([a-zA-Z_0-9\\-:\\.]{1,64})");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ServiceId(String str, String str2) {
        if (str != null && !str.matches(Constants.REGEX_NAMESPACE)) {
            jl.a("Service ID namespace contains illegal characters");
            throw null;
        }
        this.namespace = str;
        if (str2 == null || str2.matches(Constants.REGEX_ID)) {
            this.id = str2;
        } else {
            jl.a("Service ID suffix too long (64) or contains illegal characters");
            throw null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ServiceId valueOf(String str) {
        UDAServiceId uDAServiceIdValueOf;
        try {
            uDAServiceIdValueOf = UDAServiceId.valueOf(str);
        } catch (Exception unused) {
            uDAServiceIdValueOf = null;
        }
        if (uDAServiceIdValueOf != null) {
            return uDAServiceIdValueOf;
        }
        Matcher matcher = PATTERN.matcher(str);
        if (matcher.matches() && matcher.groupCount() >= 2) {
            return new ServiceId(matcher.group(1), matcher.group(2));
        }
        Matcher matcher2 = BROKEN_PATTERN.matcher(str);
        if (matcher2.matches() && matcher2.groupCount() >= 2) {
            return new ServiceId(matcher2.group(1), matcher2.group(2));
        }
        Matcher matcher3 = Pattern.compile("urn:([a-zA-Z0-9\\-\\.]+):serviceId:").matcher(str);
        if (matcher3.matches() && matcher3.groupCount() >= 1) {
            SpecificationViolationReporter.report("No service ID token, defaulting to {}: {}", "UNKNOWN", str);
            return new ServiceId(matcher3.group(1), "UNKNOWN");
        }
        String[] strArrSplit = str.split("[:]");
        if (strArrSplit.length != 4) {
            throw new InvalidValueException("Can't parse service ID string (namespace/id): ".concat(str));
        }
        SpecificationViolationReporter.report("Trying a simple colon-split of: {}", str);
        return new ServiceId(strArrSplit[1], strArrSplit[3]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ServiceId)) {
            return false;
        }
        ServiceId serviceId = (ServiceId) obj;
        return this.id.equals(serviceId.id) && this.namespace.equals(serviceId.namespace);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getId() {
        return this.id;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getNamespace() {
        return this.namespace;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return (this.namespace.hashCode() * 31) + this.id.hashCode();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "urn:" + getNamespace() + ":serviceId:" + getId();
    }
}
