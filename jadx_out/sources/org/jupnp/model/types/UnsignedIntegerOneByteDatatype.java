package org.jupnp.model.types;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class UnsignedIntegerOneByteDatatype extends AbstractDatatype<UnsignedIntegerOneByte> {
    @Override // org.jupnp.model.types.AbstractDatatype, org.jupnp.model.types.Datatype
    public UnsignedIntegerOneByte valueOf(String str) {
        if (str.isEmpty()) {
            return null;
        }
        try {
            return new UnsignedIntegerOneByte(str);
        } catch (NumberFormatException e) {
            throw new InvalidValueException("Can't convert string to number or not in range: ".concat(str), e);
        }
    }
}
