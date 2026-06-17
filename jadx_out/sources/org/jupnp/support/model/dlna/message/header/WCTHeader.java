package org.jupnp.support.model.dlna.message.header;

import defpackage.j32;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class WCTHeader extends DLNAHeader<Boolean> {
    private static final Pattern pattern = Pattern.compile("^[01]{1}$", 2);

    public WCTHeader() {
        setValue(Boolean.FALSE);
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        return getValue().booleanValue() ? "1" : "0";
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        if (pattern.matcher(str).matches()) {
            setValue(Boolean.valueOf(str.equals("1")));
        } else {
            j32.a("Invalid SCID header value: ", str);
        }
    }
}
