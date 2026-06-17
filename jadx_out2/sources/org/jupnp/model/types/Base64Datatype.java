package org.jupnp.model.types;

import j$.util.Base64;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Base64Datatype extends AbstractDatatype<byte[]> {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: getString(Ljava/lang/Object;)Ljava/lang/String; */
    @Override // org.jupnp.model.types.AbstractDatatype, org.jupnp.model.types.Datatype
    public String getString(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        try {
            return Base64.getEncoder().encodeToString(bArr);
        } catch (Exception e) {
            throw new InvalidValueException(e.getMessage(), e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.types.AbstractDatatype
    public Class<byte[]> getValueType() {
        return byte[].class;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: valueOf(Ljava/lang/String;)Ljava/lang/Object; */
    @Override // org.jupnp.model.types.AbstractDatatype, org.jupnp.model.types.Datatype
    public byte[] valueOf(String str) {
        if (str.isEmpty()) {
            return null;
        }
        try {
            return Base64.getDecoder().decode(str);
        } catch (Exception e) {
            throw new InvalidValueException(e.getMessage(), e);
        }
    }
}
