package org.jupnp.model;

import org.jupnp.model.types.Datatype;
import org.jupnp.model.types.InvalidValueException;
import org.jupnp.util.SpecificationViolationReporter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class VariableValue {
    private final Datatype datatype;
    private final Object value;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public VariableValue(Datatype datatype, Object obj) {
        this.datatype = datatype;
        this.value = obj instanceof String ? datatype.valueOf((String) obj) : obj;
        if (ModelUtil.ANDROID_RUNTIME) {
            return;
        }
        if (getDatatype().isValid(getValue())) {
            logInvalidXML(toString());
            return;
        }
        throw new InvalidValueException("Invalid value for " + String.valueOf(getDatatype()) + ": " + String.valueOf(getValue()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Datatype getDatatype() {
        return this.datatype;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object getValue() {
        return this.value;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void logInvalidXML(String str) {
        int iCharCount = 0;
        while (iCharCount < str.length()) {
            int iCodePointAt = str.codePointAt(iCharCount);
            if (iCodePointAt != 9 && iCodePointAt != 10 && iCodePointAt != 13 && ((iCodePointAt < 32 || iCodePointAt > 55295) && ((iCodePointAt < 57344 || iCodePointAt > 65533) && (iCodePointAt < 65536 || iCodePointAt > 1114111)))) {
                SpecificationViolationReporter.report("Found invalid XML char code: {}", Integer.valueOf(iCodePointAt));
            }
            iCharCount += Character.charCount(iCodePointAt);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return getDatatype().getString(getValue());
    }
}
