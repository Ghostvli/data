package org.jupnp.model.types;

import defpackage.f80;
import defpackage.jl;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jupnp.model.Constants;
import org.jupnp.util.SpecificationViolationReporter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DeviceType {
    public static final String UNKNOWN = "UNKNOWN";
    private String namespace;
    private String type;
    private int version;
    public static final Pattern PATTERN = Pattern.compile("urn:([a-zA-Z0-9\\-\\.]+):device:([a-zA-Z_0-9\\-]{1,64}):([0-9]+).*");
    private static final Pattern PATTERN_WHITESPACE = Pattern.compile("\\s");
    private static final Pattern PATTERN_NAMESPACE = Pattern.compile(Constants.REGEX_NAMESPACE);
    private static final Pattern PATTERN_TYPE = Pattern.compile(Constants.REGEX_TYPE);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DeviceType(String str, String str2, int i) {
        this.version = 1;
        if (str != null && !PATTERN_NAMESPACE.matcher(str).matches()) {
            jl.a("Device type namespace contains illegal characters");
            throw null;
        }
        this.namespace = str;
        if (str2 != null && !PATTERN_TYPE.matcher(str2).matches()) {
            jl.a("Device type suffix too long (64) or contains illegal characters");
            throw null;
        }
        this.type = str2;
        this.version = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static DeviceType valueOf(String str) {
        UDADeviceType uDADeviceTypeValueOf;
        String strReplaceAll = PATTERN_WHITESPACE.matcher(str).replaceAll("");
        try {
            uDADeviceTypeValueOf = UDADeviceType.valueOf(strReplaceAll);
        } catch (Exception unused) {
            uDADeviceTypeValueOf = null;
        }
        if (uDADeviceTypeValueOf != null) {
            return uDADeviceTypeValueOf;
        }
        try {
            Matcher matcher = PATTERN.matcher(strReplaceAll);
            if (matcher.matches()) {
                return new DeviceType(matcher.group(1), matcher.group(2), Integer.parseInt(matcher.group(3)));
            }
            Matcher matcher2 = Pattern.compile("urn:([a-zA-Z0-9\\-\\.]+):device::([0-9]+).*").matcher(strReplaceAll);
            if (matcher2.matches() && matcher2.groupCount() >= 2) {
                SpecificationViolationReporter.report("No device type token, defaulting to UNKNOWN: " + strReplaceAll, new Object[0]);
                return new DeviceType(matcher2.group(1), "UNKNOWN", Integer.parseInt(matcher2.group(2)));
            }
            Matcher matcher3 = Pattern.compile("urn:([a-zA-Z0-9\\-\\.]+):device:(.+?):([0-9]+).*").matcher(strReplaceAll);
            if (!matcher3.matches() || matcher3.groupCount() < 3) {
                f80.a("Can't parse device type string (namespace/type/version): ", strReplaceAll);
                return null;
            }
            String strReplaceAll2 = matcher3.group(2).replaceAll("[^a-zA-Z_0-9\\-]", "-");
            SpecificationViolationReporter.report("Replacing invalid device type token '{}' with: {}", matcher3.group(2), strReplaceAll2);
            return new DeviceType(matcher3.group(1), strReplaceAll2, Integer.parseInt(matcher3.group(3)));
        } catch (RuntimeException e) {
            throw new InvalidValueException(String.format("Can't parse device type string (namespace/type/version) '%s'", strReplaceAll), e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeviceType)) {
            return false;
        }
        DeviceType deviceType = (DeviceType) obj;
        return this.version == deviceType.version && this.namespace.equals(deviceType.namespace) && this.type.equals(deviceType.type);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getDisplayString() {
        return getType();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getNamespace() {
        return this.namespace;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getType() {
        return this.type;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getVersion() {
        return this.version;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return (((this.namespace.hashCode() * 31) + this.type.hashCode()) * 31) + this.version;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean implementsVersion(DeviceType deviceType) {
        return this.namespace.equals(deviceType.namespace) && this.type.equals(deviceType.type) && this.version >= deviceType.version;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "urn:" + getNamespace() + ":device:" + getType() + ":" + getVersion();
    }

    public DeviceType(String str, String str2) {
        this(str, str2, 1);
    }
}
