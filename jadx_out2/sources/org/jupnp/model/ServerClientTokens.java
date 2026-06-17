package org.jupnp.model;

import com.hierynomus.protocol.commons.buffer.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ServerClientTokens {
    private static String DEFAULT_OS_NAME = System.getProperty("os.name").replaceAll("[^a-zA-Z0-9\\.\\-_]", "");
    private static String DEFAULT_OS_VERSION = System.getProperty("os.version").replaceAll("[^a-zA-Z0-9\\.\\-_]", "");
    public static final String UNKNOWN_PLACEHOLDER = "UNKNOWN";
    private int majorVersion;
    private int minorVersion;
    private String osName;
    private String osVersion;
    private String productName;
    private String productVersion;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ServerClientTokens() {
        this.majorVersion = 1;
        this.minorVersion = 0;
        this.osName = DEFAULT_OS_NAME;
        this.osVersion = DEFAULT_OS_VERSION;
        this.productName = UserConstants.PRODUCT_TOKEN_NAME;
        this.productVersion = UserConstants.PRODUCT_TOKEN_VERSION;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ServerClientTokens serverClientTokens = (ServerClientTokens) obj;
        return this.majorVersion == serverClientTokens.majorVersion && this.minorVersion == serverClientTokens.minorVersion && this.osName.equals(serverClientTokens.osName) && this.osVersion.equals(serverClientTokens.osVersion) && this.productName.equals(serverClientTokens.productName) && this.productVersion.equals(serverClientTokens.productVersion);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getHttpToken() {
        StringBuilder sb = new StringBuilder(Buffer.DEFAULT_SIZE);
        int iIndexOf = this.osName.indexOf(32);
        String strReplace = this.osName;
        if (iIndexOf != -1) {
            strReplace = strReplace.replace(' ', '_');
        }
        sb.append(strReplace);
        sb.append('/');
        int iIndexOf2 = this.osVersion.indexOf(32);
        String strReplace2 = this.osVersion;
        if (iIndexOf2 != -1) {
            strReplace2 = strReplace2.replace(' ', '_');
        }
        sb.append(strReplace2);
        sb.append(" UPnP/");
        sb.append(this.majorVersion);
        sb.append('.');
        sb.append(this.minorVersion);
        sb.append(' ');
        int iIndexOf3 = this.productName.indexOf(32);
        String strReplace3 = this.productName;
        if (iIndexOf3 != -1) {
            strReplace3 = strReplace3.replace(' ', '_');
        }
        sb.append(strReplace3);
        sb.append('/');
        int iIndexOf4 = this.productVersion.indexOf(32);
        String strReplace4 = this.productVersion;
        if (iIndexOf4 != -1) {
            strReplace4 = strReplace4.replace(' ', '_');
        }
        sb.append(strReplace4);
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getMajorVersion() {
        return this.majorVersion;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getMinorVersion() {
        return this.minorVersion;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getOsName() {
        return this.osName;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getOsToken() {
        return getOsName().replaceAll(" ", "_") + ServiceReference.DELIMITER + getOsVersion().replaceAll(" ", "_");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getOsVersion() {
        return this.osVersion;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getProductName() {
        return this.productName;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getProductToken() {
        return getProductName().replaceAll(" ", "_") + ServiceReference.DELIMITER + getProductVersion().replaceAll(" ", "_");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getProductVersion() {
        return this.productVersion;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return (((((((((this.majorVersion * 31) + this.minorVersion) * 31) + this.osName.hashCode()) * 31) + this.osVersion.hashCode()) * 31) + this.productName.hashCode()) * 31) + this.productVersion.hashCode();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setMajorVersion(int i) {
        this.majorVersion = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setMinorVersion(int i) {
        this.minorVersion = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setOsName(String str) {
        this.osName = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setOsVersion(String str) {
        this.osVersion = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setProductName(String str) {
        this.productName = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setProductVersion(String str) {
        this.productVersion = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return getOsName() + ServiceReference.DELIMITER + getOsVersion() + " UPnP/" + getMajorVersion() + "." + getMinorVersion() + " " + getProductName() + ServiceReference.DELIMITER + getProductVersion();
    }

    public ServerClientTokens(int i, int i2) {
        this.osName = DEFAULT_OS_NAME;
        this.osVersion = DEFAULT_OS_VERSION;
        this.productName = UserConstants.PRODUCT_TOKEN_NAME;
        this.productVersion = UserConstants.PRODUCT_TOKEN_VERSION;
        this.majorVersion = i;
        this.minorVersion = i2;
    }

    public ServerClientTokens(String str, String str2) {
        this.majorVersion = 1;
        this.minorVersion = 0;
        this.osName = DEFAULT_OS_NAME;
        this.osVersion = DEFAULT_OS_VERSION;
        this.productName = str;
        this.productVersion = str2;
    }

    public ServerClientTokens(int i, int i2, String str, String str2, String str3, String str4) {
        this.majorVersion = i;
        this.minorVersion = i2;
        this.osName = str;
        this.osVersion = str2;
        this.productName = str3;
        this.productVersion = str4;
    }
}
