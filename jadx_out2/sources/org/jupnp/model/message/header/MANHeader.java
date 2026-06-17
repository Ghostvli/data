package org.jupnp.model.message.header;

import defpackage.j32;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MANHeader extends UpnpHeader<String> {
    public String namespace;
    public static final Pattern PATTERN = Pattern.compile("\"(.+?)\"(;.+?)??");
    public static final Pattern NAMESPACE_PATTERN = Pattern.compile(";\\s?ns\\s?=\\s?([0-9]{2})");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public MANHeader(String str) {
        setValue(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getNamespace() {
        return this.namespace;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        if (getValue() == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder("\"");
        sb.append(getValue());
        sb.append("\"");
        if (getNamespace() != null) {
            sb.append("; ns=");
            sb.append(getNamespace());
        }
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setNamespace(String str) {
        this.namespace = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        Matcher matcher = PATTERN.matcher(str);
        if (!matcher.matches()) {
            j32.a("Invalid MAN header value: ", str);
            return;
        }
        setValue(matcher.group(1));
        if (matcher.group(2) != null) {
            Matcher matcher2 = NAMESPACE_PATTERN.matcher(matcher.group(2));
            if (matcher2.matches()) {
                setNamespace(matcher2.group(1));
            } else {
                j32.a("Invalid namespace in MAN header value: ", str);
            }
        }
    }

    public MANHeader() {
    }

    public MANHeader(String str, String str2) {
        this(str);
        this.namespace = str2;
    }
}
