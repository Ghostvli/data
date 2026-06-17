package org.jupnp.support.model.dlna.message.header;

import defpackage.fq0;
import org.jupnp.support.model.dlna.types.NormalPlayTime;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class RealTimeInfoHeader extends DLNAHeader<NormalPlayTime> {
    public static final String PREFIX = "DLNA.ORG_TLAG=";

    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        NormalPlayTime value = getValue();
        if (value == null) {
            return "DLNA.ORG_TLAG=*";
        }
        return PREFIX + value.getString();
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        if (!str.isEmpty() && str.startsWith(PREFIX)) {
            try {
                str = str.substring(14);
                setValue(str.equals("*") ? null : NormalPlayTime.valueOf(str));
                return;
            } catch (Exception unused) {
            }
        }
        fq0.a("Invalid RealTimeInfo header value: ".concat(str));
    }
}
