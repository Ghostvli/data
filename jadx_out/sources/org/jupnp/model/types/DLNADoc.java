package org.jupnp.model.types;

import defpackage.f80;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DLNADoc {
    public static final Pattern PATTERN = Pattern.compile("(.+?)[ -]([0-9].[0-9]{2})");
    private final String devClass;
    private final String version;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum Version {
        V1_0("1.00"),
        V1_5("1.50");

        final String s;

        Version(String str) {
            this.s = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.s;
        }
    }

    public DLNADoc(String str, Version version) {
        this.devClass = str;
        this.version = version.s;
    }

    public static DLNADoc valueOf(String str) {
        Matcher matcher = PATTERN.matcher(str);
        if (matcher.matches()) {
            return new DLNADoc(matcher.group(1), matcher.group(2));
        }
        f80.a("Can't parse DLNADoc: ", str);
        return null;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DLNADoc dLNADoc = (DLNADoc) obj;
        return this.devClass.equals(dLNADoc.devClass) && this.version.equals(dLNADoc.version);
    }

    public String getDevClass() {
        return this.devClass;
    }

    public String getVersion() {
        return this.version;
    }

    public int hashCode() {
        return (this.devClass.hashCode() * 31) + this.version.hashCode();
    }

    public String toString() {
        return getDevClass() + "-" + getVersion();
    }

    public DLNADoc(String str, String str2) {
        this.devClass = str;
        this.version = str2;
    }
}
