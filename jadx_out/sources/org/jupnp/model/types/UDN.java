package org.jupnp.model.types;

import defpackage.wg1;
import defpackage.zt2;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.UUID;
import org.jupnp.model.ModelUtil;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class UDN {
    public static final String PREFIX = "uuid:";
    private String identifierString;

    public UDN(UUID uuid) {
        this.identifierString = uuid.toString();
    }

    public static UDN uniqueSystemIdentifier(String str) {
        if (ModelUtil.ANDROID_RUNTIME) {
            zt2.a("This method does not create a unique identifier on Android, see the Javadoc and use new UDN(UUID) instead!");
            return null;
        }
        byte[] firstNetworkInterfaceHardwareAddress = ModelUtil.getFirstNetworkInterfaceHardwareAddress();
        Charset charset = StandardCharsets.UTF_8;
        try {
            return new UDN(new UUID(new BigInteger(-1, MessageDigest.getInstance("MD5").digest(new String(firstNetworkInterfaceHardwareAddress, charset).getBytes(charset))).longValue(), str.hashCode()));
        } catch (Exception e) {
            wg1.a(e);
            return null;
        }
    }

    public static UDN valueOf(String str) {
        if (str.startsWith("uuid:")) {
            str = str.substring(5);
        }
        return new UDN(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof UDN)) {
            return false;
        }
        return this.identifierString.equals(((UDN) obj).identifierString);
    }

    public String getIdentifierString() {
        return this.identifierString;
    }

    public int hashCode() {
        return this.identifierString.hashCode();
    }

    public boolean isUDA11Compliant() {
        try {
            UUID.fromString(this.identifierString);
            return true;
        } catch (IllegalArgumentException unused) {
            return false;
        }
    }

    public String toString() {
        return "uuid:" + getIdentifierString();
    }

    public UDN(String str) {
        this.identifierString = str;
    }
}
