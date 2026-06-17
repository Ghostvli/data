package com.thegrizzlylabs.sardineandroid;

import com.thegrizzlylabs.sardineandroid.model.Principal;
import defpackage.jl;
import defpackage.pb1;
import javax.xml.namespace.QName;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DavPrincipal {
    public static final String KEY_ALL = "all";
    public static final String KEY_AUTHENTICATED = "authenticated";
    public static final String KEY_SELF = "self";
    public static final String KEY_UNAUTHENTICATED = "unauthenticated";
    private final String displayName;
    private final PrincipalType principalType;
    private final QName property;
    private final String value;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum PrincipalType {
        HREF,
        KEY,
        PROPERTY
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DavPrincipal(Principal principal) {
        this.displayName = null;
        if (principal.getHref() != null) {
            this.principalType = PrincipalType.HREF;
            this.value = principal.getHref();
            this.property = null;
            return;
        }
        if (principal.getProperty() != null) {
            this.principalType = PrincipalType.PROPERTY;
            this.value = null;
            this.property = new QName(principal.getProperty().getProperty().getNamespaceURI(), principal.getProperty().getProperty().getLocalName());
            return;
        }
        if (principal.getAll() == null && principal.getAuthenticated() == null && principal.getUnauthenticated() == null && principal.getSelf() == null) {
            this.principalType = null;
            this.value = null;
            this.property = null;
            return;
        }
        this.principalType = PrincipalType.KEY;
        this.property = null;
        if (principal.getAll() != null) {
            this.value = KEY_ALL;
            return;
        }
        if (principal.getAuthenticated() != null) {
            this.value = KEY_AUTHENTICATED;
        } else if (principal.getUnauthenticated() != null) {
            this.value = KEY_UNAUTHENTICATED;
        } else {
            this.value = KEY_SELF;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getDisplayName() {
        return this.displayName;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PrincipalType getPrincipalType() {
        return this.principalType;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public QName getProperty() {
        return this.property;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getValue() {
        return this.value;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "[principalType=" + this.principalType + ", value=" + this.value + ", property=" + this.property + ", displayName=" + this.displayName + "]";
    }

    public DavPrincipal(PrincipalType principalType, String str, QName qName, String str2) {
        if (str != null && principalType == PrincipalType.PROPERTY) {
            jl.a("Principal type property can't have a string value");
            throw null;
        }
        if (qName != null && principalType != PrincipalType.PROPERTY) {
            pb1.a("Principal type ", principalType.name(), " property is not allowed to have a QName property");
            throw null;
        }
        this.principalType = principalType;
        this.value = str;
        this.property = qName;
        this.displayName = str2;
    }

    public DavPrincipal(PrincipalType principalType, QName qName, String str) {
        this(principalType, null, qName, str);
    }

    public DavPrincipal(PrincipalType principalType, String str, String str2) {
        this(principalType, str, null, str2);
    }
}
