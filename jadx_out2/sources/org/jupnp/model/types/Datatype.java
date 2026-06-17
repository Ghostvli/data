package org.jupnp.model.types;

import java.net.URI;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface Datatype<V> {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum Builtin {
        UI1("ui1", new UnsignedIntegerOneByteDatatype()),
        UI2("ui2", new UnsignedIntegerTwoBytesDatatype()),
        UI4("ui4", new UnsignedIntegerFourBytesDatatype()),
        I1("i1", new IntegerDatatype(1)),
        I2("i2", new IntegerDatatype(2)),
        I2_SHORT("i2", new ShortDatatype()),
        I4("i4", new IntegerDatatype(4)),
        INT("int", new IntegerDatatype(4)),
        R4("r4", new FloatDatatype()),
        R8("r8", new DoubleDatatype()),
        NUMBER("number", new DoubleDatatype()),
        FIXED144("fixed.14.4", new DoubleDatatype()),
        FLOAT("float", new DoubleDatatype()),
        CHAR("char", new CharacterDatatype()),
        STRING("string", new StringDatatype()),
        DATE("date", new DateTimeDatatype(new String[]{"yyyy-MM-dd"}, "yyyy-MM-dd")),
        DATETIME("dateTime", new DateTimeDatatype(new String[]{"yyyy-MM-dd", "yyyy-MM-dd'T'HH:mm:ss"}, "yyyy-MM-dd'T'HH:mm:ss")),
        DATETIME_TZ("dateTime.tz", new DateTimeDatatype(new String[]{"yyyy-MM-dd", "yyyy-MM-dd'T'HH:mm:ss", "yyyy-MM-dd'T'HH:mm:ssZ"}, "yyyy-MM-dd'T'HH:mm:ssZ")),
        TIME("time", new DateTimeDatatype(new String[]{"HH:mm:ss"}, "HH:mm:ss")),
        TIME_TZ("time.tz", new DateTimeDatatype(new String[]{"HH:mm:ssZ", "HH:mm:ss"}, "HH:mm:ssZ")),
        BOOLEAN("boolean", new BooleanDatatype()),
        BIN_BASE64("bin.base64", new Base64Datatype()),
        BIN_HEX("bin.hex", new BinHexDatatype()),
        URI("uri", new URIDatatype()),
        UUID("uuid", new StringDatatype());

        private static final Map<String, Builtin> byName = new HashMap<String, Builtin>() { // from class: org.jupnp.model.types.Datatype.Builtin.1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            {
                for (Builtin builtin : Builtin.values()) {
                    String descriptorName = builtin.getDescriptorName();
                    Locale locale = Locale.ENGLISH;
                    if (!containsKey(descriptorName.toLowerCase(locale))) {
                        put(builtin.getDescriptorName().toLowerCase(locale), builtin);
                    }
                }
            }
        };
        private final Datatype datatype;
        private final String descriptorName;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        Builtin(String str, AbstractDatatype abstractDatatype) {
            abstractDatatype.setBuiltin(this);
            this.descriptorName = str;
            this.datatype = abstractDatatype;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static Builtin getByDescriptorName(String str) {
            if (str == null) {
                return null;
            }
            return byName.get(str.toLowerCase(Locale.ENGLISH));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static boolean isNumeric(Builtin builtin) {
            if (builtin != null) {
                return builtin.equals(UI1) || builtin.equals(UI2) || builtin.equals(UI4) || builtin.equals(I1) || builtin.equals(I2) || builtin.equals(I4) || builtin.equals(INT);
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Datatype getDatatype() {
            return this.datatype;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String getDescriptorName() {
            return this.descriptorName;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'BOOLEAN' uses external variables
    	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByField(EnumVisitor.java:372)
    	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByWrappedInsn(EnumVisitor.java:337)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:322)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInvoke(EnumVisitor.java:293)
    	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:266)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Default {
        private static final /* synthetic */ Default[] $VALUES;
        public static final Default BOOLEAN;
        public static final Default BOOLEAN_PRIMITIVE;
        public static final Default BYTES;
        public static final Default CALENDAR;
        public static final Default CHAR;
        public static final Default CHAR_PRIMITIVE;
        public static final Default DOUBLE;
        public static final Default DOUBLE_PRIMTIIVE;
        public static final Default FLOAT;
        public static final Default FLOAT_PRIMITIVE;
        public static final Default INTEGER;
        public static final Default INTEGER_PRIMITIVE;
        public static final Default SHORT;
        public static final Default SHORT_PRIMITIVE;
        public static final Default STRING;
        public static final Default UNSIGNED_INTEGER_FOUR_BYTES;
        public static final Default UNSIGNED_INTEGER_ONE_BYTE;
        public static final Default UNSIGNED_INTEGER_TWO_BYTES;
        public static final Default URI;
        private final Builtin builtinType;
        private final Class javaType;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private static /* synthetic */ Default[] $values() {
            return new Default[]{BOOLEAN, BOOLEAN_PRIMITIVE, SHORT, SHORT_PRIMITIVE, INTEGER, INTEGER_PRIMITIVE, UNSIGNED_INTEGER_ONE_BYTE, UNSIGNED_INTEGER_TWO_BYTES, UNSIGNED_INTEGER_FOUR_BYTES, FLOAT, FLOAT_PRIMITIVE, DOUBLE, DOUBLE_PRIMTIIVE, CHAR, CHAR_PRIMITIVE, STRING, CALENDAR, BYTES, URI};
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            Builtin builtin = Builtin.BOOLEAN;
            BOOLEAN = new Default("BOOLEAN", 0, Boolean.class, builtin);
            BOOLEAN_PRIMITIVE = new Default("BOOLEAN_PRIMITIVE", 1, Boolean.TYPE, builtin);
            Builtin builtin2 = Builtin.I2_SHORT;
            SHORT = new Default("SHORT", 2, Short.class, builtin2);
            SHORT_PRIMITIVE = new Default("SHORT_PRIMITIVE", 3, Short.TYPE, builtin2);
            Builtin builtin3 = Builtin.I4;
            INTEGER = new Default("INTEGER", 4, Integer.class, builtin3);
            INTEGER_PRIMITIVE = new Default("INTEGER_PRIMITIVE", 5, Integer.TYPE, builtin3);
            UNSIGNED_INTEGER_ONE_BYTE = new Default("UNSIGNED_INTEGER_ONE_BYTE", 6, UnsignedIntegerOneByte.class, Builtin.UI1);
            UNSIGNED_INTEGER_TWO_BYTES = new Default("UNSIGNED_INTEGER_TWO_BYTES", 7, UnsignedIntegerTwoBytes.class, Builtin.UI2);
            UNSIGNED_INTEGER_FOUR_BYTES = new Default("UNSIGNED_INTEGER_FOUR_BYTES", 8, UnsignedIntegerFourBytes.class, Builtin.UI4);
            Builtin builtin4 = Builtin.R4;
            FLOAT = new Default("FLOAT", 9, Float.class, builtin4);
            FLOAT_PRIMITIVE = new Default("FLOAT_PRIMITIVE", 10, Float.TYPE, builtin4);
            Builtin builtin5 = Builtin.FLOAT;
            DOUBLE = new Default("DOUBLE", 11, Double.class, builtin5);
            DOUBLE_PRIMTIIVE = new Default("DOUBLE_PRIMTIIVE", 12, Double.TYPE, builtin5);
            Builtin builtin6 = Builtin.CHAR;
            CHAR = new Default("CHAR", 13, Character.class, builtin6);
            CHAR_PRIMITIVE = new Default("CHAR_PRIMITIVE", 14, Character.TYPE, builtin6);
            STRING = new Default("STRING", 15, String.class, Builtin.STRING);
            CALENDAR = new Default("CALENDAR", 16, Calendar.class, Builtin.DATETIME);
            BYTES = new Default("BYTES", 17, byte[].class, Builtin.BIN_BASE64);
            URI = new Default("URI", 18, URI.class, Builtin.URI);
            $VALUES = $values();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private Default(String str, int i, Class cls, Builtin builtin) {
            this.javaType = cls;
            this.builtinType = builtin;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static Default getByJavaType(Class cls) {
            for (Default r3 : values()) {
                if (r3.getJavaType().equals(cls)) {
                    return r3;
                }
            }
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static Default valueOf(String str) {
            return (Default) Enum.valueOf(Default.class, str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static Default[] values() {
            return (Default[]) $VALUES.clone();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Builtin getBuiltinType() {
            return this.builtinType;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Class getJavaType() {
            return this.javaType;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Enum
        public String toString() {
            return String.valueOf(getJavaType()) + " => " + String.valueOf(getBuiltinType());
        }
    }

    Builtin getBuiltin();

    String getDisplayString();

    String getString(V v);

    boolean isHandlingJavaType(Class cls);

    boolean isValid(V v);

    V valueOf(String str);
}
