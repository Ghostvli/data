package com.hierynomus.smbj.common;

import com.hierynomus.protocol.commons.Objects;
import com.hierynomus.utils.Strings;
import defpackage.jl;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SmbPath {
    private final String hostname;
    private final String path;
    private final String shareName;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SmbPath(SmbPath smbPath, String str) {
        this.hostname = smbPath.hostname;
        if (!Strings.isNotBlank(smbPath.shareName)) {
            jl.a("Can only make child SmbPath of fully specified SmbPath");
            throw null;
        }
        this.shareName = smbPath.shareName;
        if (!Strings.isNotBlank(smbPath.path)) {
            this.path = rewritePath(str);
            return;
        }
        this.path = smbPath.path + "\\" + rewritePath(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static SmbPath parse(String str) {
        String[] strArrSplit = rewritePath(str).split("\\\\", 3);
        return strArrSplit.length == 1 ? new SmbPath(strArrSplit[0]) : strArrSplit.length == 2 ? new SmbPath(strArrSplit[0], strArrSplit[1]) : new SmbPath(strArrSplit[0], strArrSplit[1], strArrSplit[2]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String rewritePath(String str) {
        if (!Strings.isNotBlank(str)) {
            return str;
        }
        String strReplace = str.replace('/', '\\');
        return strReplace.charAt(0) == '\\' ? (strReplace.length() <= 1 || strReplace.charAt(1) != '\\') ? strReplace.substring(1) : strReplace.substring(2) : strReplace;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            SmbPath smbPath = (SmbPath) obj;
            if (Objects.equals(this.hostname, smbPath.hostname) && Objects.equals(this.shareName, smbPath.shareName) && Objects.equals(this.path, smbPath.path)) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getHostname() {
        return this.hostname;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SmbPath getParent() {
        String str = this.path;
        if (str == null || str.isEmpty()) {
            return this;
        }
        int iLastIndexOf = this.path.lastIndexOf(92);
        String str2 = this.hostname;
        return iLastIndexOf > 0 ? new SmbPath(str2, this.shareName, this.path.substring(0, iLastIndexOf)) : new SmbPath(str2, this.shareName);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getPath() {
        return this.path;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getShareName() {
        return this.shareName;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return Objects.hash(this.hostname, this.shareName, this.path);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isOnSameHost(SmbPath smbPath) {
        return smbPath != null && Objects.equals(this.hostname, smbPath.hostname);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isOnSameShare(SmbPath smbPath) {
        return isOnSameHost(smbPath) && Objects.equals(this.shareName, smbPath.shareName);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return toUncPath();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toUncPath() {
        StringBuilder sb = new StringBuilder("\\\\");
        sb.append(this.hostname);
        String str = this.shareName;
        if (str != null && !str.isEmpty()) {
            if (this.shareName.charAt(0) != '\\') {
                sb.append("\\");
            }
            sb.append(this.shareName);
            if (Strings.isNotBlank(this.path)) {
                sb.append("\\");
                sb.append(this.path);
            }
        }
        return sb.toString();
    }

    public SmbPath(String str, String str2) {
        this(str, str2, null);
    }

    public SmbPath(String str, String str2, String str3) {
        this.shareName = str2;
        this.hostname = str;
        this.path = rewritePath(str3);
    }

    public SmbPath(String str) {
        this(str, null, null);
    }
}
