package org.jupnp.support.model.dlna;

import defpackage.g80;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DLNAOperationsAttribute extends DLNAAttribute<EnumSet<DLNAOperations>> {
    public DLNAOperationsAttribute(DLNAOperations... dLNAOperationsArr) {
        if (dLNAOperationsArr == null || dLNAOperationsArr.length <= 0) {
            return;
        }
        DLNAOperations dLNAOperations = dLNAOperationsArr[0];
        if (dLNAOperationsArr.length <= 1) {
            setValue(EnumSet.of(dLNAOperations));
        } else {
            System.arraycopy(dLNAOperationsArr, 1, dLNAOperationsArr, 0, dLNAOperationsArr.length - 1);
            setValue(EnumSet.of(dLNAOperations, dLNAOperationsArr));
        }
    }

    @Override // org.jupnp.support.model.dlna.DLNAAttribute
    public String getString() {
        int code = DLNAOperations.NONE.getCode();
        Iterator<DLNAOperations> it = getValue().iterator();
        while (it.hasNext()) {
            code |= it.next().getCode();
        }
        return String.format(Locale.ROOT, "%02x", Integer.valueOf(code));
    }

    @Override // org.jupnp.support.model.dlna.DLNAAttribute
    public void setString(String str, String str2) {
        EnumSet enumSetNoneOf = EnumSet.noneOf(DLNAOperations.class);
        try {
            int i = Integer.parseInt(str, 16);
            for (DLNAOperations dLNAOperations : DLNAOperations.values()) {
                int code = dLNAOperations.getCode() & i;
                if (dLNAOperations != DLNAOperations.NONE && dLNAOperations.getCode() == code) {
                    enumSetNoneOf.add(dLNAOperations);
                }
            }
        } catch (NumberFormatException unused) {
        }
        if (enumSetNoneOf.isEmpty()) {
            g80.a("Can't parse DLNA operations integer from: ", str);
        } else {
            setValue(enumSetNoneOf);
        }
    }

    public DLNAOperationsAttribute() {
        setValue(EnumSet.of(DLNAOperations.NONE));
    }
}
