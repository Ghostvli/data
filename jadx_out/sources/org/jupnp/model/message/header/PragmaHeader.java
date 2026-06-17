package org.jupnp.model.message.header;

import defpackage.tn3;
import org.jupnp.model.types.InvalidValueException;
import org.jupnp.model.types.PragmaType;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class PragmaHeader extends UpnpHeader<PragmaType> {
    public PragmaHeader(PragmaType pragmaType) {
        setValue(pragmaType);
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        return getValue().getString();
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        try {
            setValue(PragmaType.valueOf(str));
        } catch (InvalidValueException e) {
            tn3.a("Invalid Range Header: ", e.getMessage(), e);
        }
    }

    public PragmaHeader() {
    }

    public PragmaHeader(String str) {
        setString(str);
    }
}
