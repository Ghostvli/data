package org.jupnp.support.model.dlna.message.header;

import defpackage.fq0;
import defpackage.tf1;
import org.jupnp.model.types.BytesRange;
import org.jupnp.model.types.InvalidValueException;
import org.jupnp.support.model.dlna.types.AvailableSeekRangeType;
import org.jupnp.support.model.dlna.types.NormalPlayTimeRange;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class AvailableSeekRangeHeader extends DLNAHeader<AvailableSeekRangeType> {
    public AvailableSeekRangeHeader(AvailableSeekRangeType availableSeekRangeType) {
        setValue(availableSeekRangeType);
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        AvailableSeekRangeType value = getValue();
        String string = Integer.toString(value.getModeFlag().ordinal());
        if (value.getNormalPlayTimeRange() != null) {
            string = string + " " + value.getNormalPlayTimeRange().getString(false);
        }
        if (value.getBytesRange() == null) {
            return string;
        }
        return string + " " + value.getBytesRange().getString(false);
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        NormalPlayTimeRange normalPlayTimeRangeValueOf;
        if (!str.isEmpty()) {
            String[] strArrSplit = str.split(" ");
            boolean z = true;
            if (strArrSplit.length > 1) {
                try {
                    try {
                        AvailableSeekRangeType.Mode modeValueOf = AvailableSeekRangeType.Mode.valueOf("MODE_" + strArrSplit[0]);
                        BytesRange bytesRangeValueOf = null;
                        try {
                            try {
                                normalPlayTimeRangeValueOf = NormalPlayTimeRange.valueOf(strArrSplit[1], true);
                            } catch (InvalidValueException unused) {
                                z = false;
                                normalPlayTimeRangeValueOf = null;
                                bytesRangeValueOf = BytesRange.valueOf(strArrSplit[1]);
                            }
                            if (!z) {
                                setValue(new AvailableSeekRangeType(modeValueOf, bytesRangeValueOf));
                                return;
                            } else if (strArrSplit.length > 2) {
                                setValue(new AvailableSeekRangeType(modeValueOf, normalPlayTimeRangeValueOf, BytesRange.valueOf(strArrSplit[2])));
                                return;
                            } else {
                                setValue(new AvailableSeekRangeType(modeValueOf, normalPlayTimeRangeValueOf));
                                return;
                            }
                        } catch (InvalidValueException unused2) {
                            throw new InvalidValueException("Invalid AvailableSeekRange Range");
                        }
                    } catch (IllegalArgumentException unused3) {
                        throw new InvalidValueException("Invalid AvailableSeekRange Mode");
                    }
                } catch (InvalidValueException e) {
                    tf1.a("Invalid AvailableSeekRange header value: ", str, "; ", e.getMessage(), e);
                    return;
                }
            }
        }
        fq0.a("Invalid AvailableSeekRange header value: ".concat(str));
    }

    public AvailableSeekRangeHeader() {
    }
}
