package org.jupnp.model.types;

import defpackage.qn;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class IntegerDatatype extends AbstractDatatype<Integer> {
    private int byteSize;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public IntegerDatatype(int i) {
        this.byteSize = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getByteSize() {
        return this.byteSize;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getMaxValue() {
        int byteSize = getByteSize();
        if (byteSize == 1) {
            return 127;
        }
        if (byteSize == 2) {
            return 32767;
        }
        if (byteSize == 4) {
            return Integer.MAX_VALUE;
        }
        qn.a("Invalid integer byte size: ", getByteSize());
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getMinValue() {
        int byteSize = getByteSize();
        if (byteSize == 1) {
            return -128;
        }
        if (byteSize == 2) {
            return -32768;
        }
        if (byteSize == 4) {
            return Integer.MIN_VALUE;
        }
        qn.a("Invalid integer byte size: ", getByteSize());
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.model.types.AbstractDatatype, org.jupnp.model.types.Datatype
    public boolean isHandlingJavaType(Class cls) {
        return cls == Integer.TYPE || Integer.class.isAssignableFrom(cls);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: isValid(Ljava/lang/Object;)Z */
    @Override // org.jupnp.model.types.AbstractDatatype, org.jupnp.model.types.Datatype
    public boolean isValid(Integer num) {
        if (num != null) {
            return num.intValue() >= getMinValue() && num.intValue() <= getMaxValue();
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: valueOf(Ljava/lang/String;)Ljava/lang/Object; */
    @Override // org.jupnp.model.types.AbstractDatatype, org.jupnp.model.types.Datatype
    public Integer valueOf(String str) {
        if (str.isEmpty()) {
            return null;
        }
        try {
            Integer numValueOf = Integer.valueOf(Integer.parseInt(str.trim()));
            if (isValid(numValueOf)) {
                return numValueOf;
            }
            throw new InvalidValueException("Not a " + getByteSize() + " byte(s) integer: " + str);
        } catch (NumberFormatException e) {
            if (str.equals("NOT_IMPLEMENTED")) {
                return Integer.valueOf(getMaxValue());
            }
            throw new InvalidValueException("Can't convert string to number: ".concat(str), e);
        }
    }
}
