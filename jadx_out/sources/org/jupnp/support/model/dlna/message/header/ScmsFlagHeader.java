package org.jupnp.support.model.dlna.message.header;

import defpackage.j32;
import java.util.regex.Pattern;
import org.jupnp.support.model.dlna.types.ScmsFlagType;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ScmsFlagHeader extends DLNAHeader<ScmsFlagType> {
    private static final Pattern pattern = Pattern.compile("^[01]{2}$", 2);

    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        ScmsFlagType value = getValue();
        return (value.isCopyright() ? "0" : "1").concat(value.isOriginal() ? "0" : "1");
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        if (pattern.matcher(str).matches()) {
            setValue(new ScmsFlagType(str.charAt(0) == '0', str.charAt(1) == '0'));
        } else {
            j32.a("Invalid ScmsFlag header value: ", str);
        }
    }
}
