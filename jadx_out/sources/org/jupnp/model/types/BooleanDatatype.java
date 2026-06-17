package org.jupnp.model.types;

import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class BooleanDatatype extends AbstractDatatype<Boolean> {
    @Override // org.jupnp.model.types.AbstractDatatype, org.jupnp.model.types.Datatype
    public String getString(Boolean bool) {
        return bool == null ? "" : bool.booleanValue() ? "1" : "0";
    }

    @Override // org.jupnp.model.types.AbstractDatatype, org.jupnp.model.types.Datatype
    public boolean isHandlingJavaType(Class cls) {
        return cls == Boolean.TYPE || Boolean.class.isAssignableFrom(cls);
    }

    @Override // org.jupnp.model.types.AbstractDatatype, org.jupnp.model.types.Datatype
    public Boolean valueOf(String str) {
        if (str.isEmpty()) {
            return null;
        }
        if (!str.equals("1")) {
            Locale locale = Locale.ENGLISH;
            if (!str.toUpperCase(locale).equals("YES") && !str.toUpperCase(locale).equals("TRUE")) {
                if (str.equals("0") || str.toUpperCase(locale).equals("NO") || str.toUpperCase(locale).equals("FALSE")) {
                    return Boolean.FALSE;
                }
                throw new InvalidValueException("Invalid boolean value string: ".concat(str));
            }
        }
        return Boolean.TRUE;
    }
}
