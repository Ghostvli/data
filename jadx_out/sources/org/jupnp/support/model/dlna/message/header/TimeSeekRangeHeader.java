package org.jupnp.support.model.dlna.message.header;

import defpackage.fq0;
import defpackage.tf1;
import org.jupnp.model.types.BytesRange;
import org.jupnp.model.types.InvalidValueException;
import org.jupnp.support.model.dlna.types.NormalPlayTimeRange;
import org.jupnp.support.model.dlna.types.TimeSeekRangeType;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class TimeSeekRangeHeader extends DLNAHeader<TimeSeekRangeType> {
    public TimeSeekRangeHeader(TimeSeekRangeType timeSeekRangeType) {
        setValue(timeSeekRangeType);
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        TimeSeekRangeType value = getValue();
        String string = value.getNormalPlayTimeRange().getString();
        if (value.getBytesRange() == null) {
            return string;
        }
        return string + " " + value.getBytesRange().getString(true);
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        if (!str.isEmpty()) {
            String[] strArrSplit = str.split(" ");
            if (strArrSplit.length > 0) {
                try {
                    TimeSeekRangeType timeSeekRangeType = new TimeSeekRangeType(NormalPlayTimeRange.valueOf(strArrSplit[0]));
                    if (strArrSplit.length > 1) {
                        timeSeekRangeType.setBytesRange(BytesRange.valueOf(strArrSplit[1]));
                    }
                    setValue(timeSeekRangeType);
                    return;
                } catch (InvalidValueException e) {
                    tf1.a("Invalid TimeSeekRange header value: ", str, "; ", e.getMessage(), e);
                    return;
                }
            }
        }
        fq0.a("Invalid TimeSeekRange header value: ".concat(str));
    }

    public TimeSeekRangeHeader() {
    }
}
