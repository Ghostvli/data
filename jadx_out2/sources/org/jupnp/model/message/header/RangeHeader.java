package org.jupnp.model.message.header;

import defpackage.tn3;
import org.jupnp.model.types.BytesRange;
import org.jupnp.model.types.InvalidValueException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class RangeHeader extends UpnpHeader<BytesRange> {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RangeHeader(BytesRange bytesRange) {
        setValue(bytesRange);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        return getValue().getString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        try {
            setValue(BytesRange.valueOf(str));
        } catch (InvalidValueException e) {
            tn3.a("Invalid Range Header: ", e.getMessage(), e);
        }
    }

    public RangeHeader() {
    }

    public RangeHeader(String str) {
        setString(str);
    }
}
