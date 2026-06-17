package org.jupnp.model.message.header;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class MXHeader extends UpnpHeader<Integer> {
    public static final Integer DEFAULT_VALUE = 3;

    public MXHeader() {
        setValue(DEFAULT_VALUE);
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public String getString() {
        return getValue().toString();
    }

    @Override // org.jupnp.model.message.header.UpnpHeader
    public void setString(String str) {
        try {
            int i = Integer.parseInt(str);
            if (i < 0 || i > 120) {
                setValue(DEFAULT_VALUE);
            } else {
                setValue(Integer.valueOf(i));
            }
        } catch (Exception e) {
            throw new InvalidHeaderException("Can't parse MX seconds integer from: " + str, e);
        }
    }

    public MXHeader(Integer num) {
        setValue(num);
    }
}
