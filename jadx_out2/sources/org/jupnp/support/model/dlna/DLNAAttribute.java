package org.jupnp.support.model.dlna;

import defpackage.j02;
import defpackage.n02;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class DLNAAttribute<T> {
    private static final j02 LOGGER = n02.k(DLNAAttribute.class);
    private T value;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum Type {
        DLNA_ORG_PN("DLNA.ORG_PN", DLNAProfileAttribute.class),
        DLNA_ORG_OP("DLNA.ORG_OP", DLNAOperationsAttribute.class),
        DLNA_ORG_PS("DLNA.ORG_PS", DLNAPlaySpeedAttribute.class),
        DLNA_ORG_CI("DLNA.ORG_CI", DLNAConversionIndicatorAttribute.class),
        DLNA_ORG_FLAGS("DLNA.ORG_FLAGS", DLNAFlagsAttribute.class);

        private static final Map<String, Type> byName = new HashMap<String, Type>() { // from class: org.jupnp.support.model.dlna.DLNAAttribute.Type.1
            private static final long serialVersionUID = -4611773458029624524L;

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            {
                for (Type type : Type.values()) {
                    put(type.getAttributeName().toUpperCase(Locale.ROOT), type);
                }
            }
        };
        private final String attributeName;
        private final Class<? extends DLNAAttribute<?>>[] attributeTypes;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @SafeVarargs
        Type(String str, Class... clsArr) {
            this.attributeName = str;
            this.attributeTypes = clsArr;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static Type valueOfAttributeName(String str) {
            if (str == null) {
                return null;
            }
            return byName.get(str.toUpperCase(Locale.ROOT));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String getAttributeName() {
            return this.attributeName;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Class<? extends DLNAAttribute<?>>[] getAttributeTypes() {
            return this.attributeTypes;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static DLNAAttribute<?> newInstance(Type type, String str, String str2) {
        DLNAAttribute<?> dLNAAttributeNewInstance;
        Exception e;
        DLNAAttribute<?> dLNAAttribute = null;
        for (int i = 0; i < type.getAttributeTypes().length && dLNAAttribute == null; i++) {
            Class<? extends DLNAAttribute<?>> cls = type.getAttributeTypes()[i];
            try {
                try {
                    LOGGER.i("Trying to parse DLNA '{}' with class: {}", type, cls.getSimpleName());
                    dLNAAttributeNewInstance = cls.getDeclaredConstructor(null).newInstance(null);
                    if (str != null) {
                        try {
                            dLNAAttributeNewInstance.setString(str, str2);
                        } catch (Exception e2) {
                            e = e2;
                            LOGGER.p("Error instantiating DLNA attribute of type '{}' with value: {}", type, str, e);
                        }
                    }
                } catch (InvalidDLNAProtocolAttributeException e3) {
                    LOGGER.i("Invalid DLNA attribute value for tested type: {} - {}", cls.getSimpleName(), e3.getMessage());
                    dLNAAttribute = null;
                }
            } catch (Exception e4) {
                dLNAAttributeNewInstance = dLNAAttribute;
                e = e4;
            }
            dLNAAttribute = dLNAAttributeNewInstance;
        }
        return dLNAAttribute;
    }

    public abstract String getString();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public T getValue() {
        return this.value;
    }

    public abstract void setString(String str, String str2);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setValue(T t) {
        this.value = t;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "(" + getClass().getSimpleName() + ") '" + String.valueOf(getValue()) + "'";
    }
}
