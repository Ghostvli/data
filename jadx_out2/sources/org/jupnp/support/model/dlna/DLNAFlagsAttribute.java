package org.jupnp.support.model.dlna;

import defpackage.g80;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DLNAFlagsAttribute extends DLNAAttribute<EnumSet<DLNAFlags>> {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DLNAFlagsAttribute(DLNAFlags... dLNAFlagsArr) {
        if (dLNAFlagsArr == null || dLNAFlagsArr.length <= 0) {
            return;
        }
        DLNAFlags dLNAFlags = dLNAFlagsArr[0];
        if (dLNAFlagsArr.length <= 1) {
            setValue(EnumSet.of(dLNAFlags));
        } else {
            System.arraycopy(dLNAFlagsArr, 1, dLNAFlagsArr, 0, dLNAFlagsArr.length - 1);
            setValue(EnumSet.of(dLNAFlags, dLNAFlagsArr));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.support.model.dlna.DLNAAttribute
    public String getString() {
        Iterator<DLNAFlags> it = getValue().iterator();
        int code = 0;
        while (it.hasNext()) {
            code |= it.next().getCode();
        }
        return String.format(Locale.ROOT, "%08x%024x", Integer.valueOf(code), 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.support.model.dlna.DLNAAttribute
    public void setString(String str, String str2) {
        EnumSet enumSetNoneOf = EnumSet.noneOf(DLNAFlags.class);
        try {
            int i = Integer.parseInt(str.substring(0, str.length() - 24), 16);
            for (DLNAFlags dLNAFlags : DLNAFlags.values()) {
                if (dLNAFlags.getCode() == (dLNAFlags.getCode() & i)) {
                    enumSetNoneOf.add(dLNAFlags);
                }
            }
        } catch (Exception unused) {
        }
        if (enumSetNoneOf.isEmpty()) {
            g80.a("Can't parse DLNA flags integer from: ", str);
        } else {
            setValue(enumSetNoneOf);
        }
    }

    public DLNAFlagsAttribute() {
        setValue(EnumSet.noneOf(DLNAFlags.class));
    }
}
