package org.jupnp.support.model.dlna.message.header;

import defpackage.j32;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class EventTypeHeader extends DLNAHeader<String> {
    private static final Pattern pattern = Pattern.compile("^[0-9]{4}$", 2);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public EventTypeHeader() {
        setValue("0000");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        return getValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        if (pattern.matcher(str).matches()) {
            setValue(str);
        } else {
            j32.a("Invalid EventType header value: ", str);
        }
    }
}
