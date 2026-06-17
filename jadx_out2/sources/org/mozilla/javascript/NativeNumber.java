package org.mozilla.javascript;

import defpackage.jl;
import org.mozilla.javascript.dtoa.DecimalFormatter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
final class NativeNumber extends IdScriptableObject {
    private static final int ConstructorId_isFinite = -1;
    private static final int ConstructorId_isInteger = -3;
    private static final int ConstructorId_isNaN = -2;
    private static final int ConstructorId_isSafeInteger = -4;
    private static final double EPSILON = 2.220446049250313E-16d;
    private static final int Id_constructor = 1;
    private static final int Id_toExponential = 7;
    private static final int Id_toFixed = 6;
    private static final int Id_toLocaleString = 3;
    private static final int Id_toPrecision = 8;
    private static final int Id_toSource = 4;
    private static final int Id_toString = 2;
    private static final int Id_valueOf = 5;
    private static final int MAX_PRECISION = 100;
    private static final int MAX_PROTOTYPE_ID = 8;
    public static final double MAX_SAFE_INTEGER = 9.007199254740991E15d;
    private static final double MIN_SAFE_INTEGER = -9.007199254740991E15d;
    private static final Object NUMBER_TAG = "Number";
    private static final long serialVersionUID = 3504516769741512101L;
    private double doubleValue;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NativeNumber(double d) {
        this.doubleValue = d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void checkPrecision(double d, double d2, Object obj) {
        if (d < d2 || d > 100.0d) {
            throw ScriptRuntime.rangeError(ScriptRuntime.getMessageById("msg.bad.precision", ScriptRuntime.toString(obj)));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Object execConstructorCall(int i, Object[] objArr) {
        if (i == ConstructorId_isSafeInteger) {
            if (objArr.length != 0) {
                Object obj = Undefined.instance;
                Object obj2 = objArr[0];
                if (obj != obj2) {
                    return obj2 instanceof Number ? Boolean.valueOf(isSafeInteger((Number) obj2)) : Boolean.FALSE;
                }
            }
            return Boolean.FALSE;
        }
        if (i == ConstructorId_isInteger) {
            if (objArr.length == 0 || Undefined.isUndefined(objArr[0])) {
                return Boolean.FALSE;
            }
            Object obj3 = objArr[0];
            return obj3 instanceof Number ? Boolean.valueOf(isInteger((Number) obj3)) : Boolean.FALSE;
        }
        if (i == ConstructorId_isNaN) {
            if (objArr.length == 0 || Undefined.isUndefined(objArr[0])) {
                return Boolean.FALSE;
            }
            Object obj4 = objArr[0];
            return obj4 instanceof Number ? isNaN((Number) obj4) : Boolean.FALSE;
        }
        if (i != -1) {
            jl.a(String.valueOf(i));
            return null;
        }
        if (objArr.length == 0 || Undefined.isUndefined(objArr[0])) {
            return Boolean.FALSE;
        }
        Object obj5 = objArr[0];
        return obj5 instanceof Number ? isFinite(obj5) : Boolean.FALSE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void init(Scriptable scriptable, boolean z) {
        new NativeNumber(0.0d).exportAsJSClass(8, scriptable, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean isDoubleInteger(Double d) {
        return (d.isInfinite() || d.isNaN() || Math.floor(d.doubleValue()) != d.doubleValue()) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean isDoubleSafeInteger(Double d) {
        return isDoubleInteger(d) && d.doubleValue() <= 9.007199254740991E15d && d.doubleValue() >= MIN_SAFE_INTEGER;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object isFinite(Object obj) {
        Double dValueOf = Double.valueOf(ScriptRuntime.toNumber(obj));
        return ScriptRuntime.wrapBoolean((dValueOf.isInfinite() || dValueOf.isNaN()) ? false : true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean isInteger(Number number) {
        return number instanceof Double ? isDoubleInteger((Double) number) : isDoubleInteger(number.doubleValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Boolean isNaN(Number number) {
        return number instanceof Double ? Boolean.valueOf(((Double) number).isNaN()) : Boolean.valueOf(Double.isNaN(number.doubleValue()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static boolean isSafeInteger(Number number) {
        return number instanceof Double ? isDoubleSafeInteger((Double) number) : isDoubleSafeInteger(number.doubleValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Object js_toExponential(double d, Object[] objArr) {
        boolean z;
        double integer;
        if (objArr.length <= 0 || Undefined.isUndefined(objArr[0])) {
            z = true;
            integer = 0.0d;
        } else {
            integer = ScriptRuntime.toInteger(objArr[0]);
            z = false;
        }
        if (!Double.isFinite(d)) {
            return ScriptRuntime.toString(d);
        }
        checkPrecision(integer, 0.0d, objArr.length > 0 ? objArr[0] : Undefined.instance);
        return DecimalFormatter.toExponential(d, z ? -1 : ScriptRuntime.toInt32(integer));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Object js_toFixed(Context context, double d, Object[] objArr) {
        int int32 = 0;
        if (objArr.length > 0 && !Undefined.isUndefined(objArr[0])) {
            double integer = ScriptRuntime.toInteger(objArr[0]);
            checkPrecision(integer, context.version < 200 ? -20 : 0, objArr[0]);
            int32 = ScriptRuntime.toInt32(integer);
        }
        return !Double.isFinite(d) ? ScriptRuntime.toString(d) : DecimalFormatter.toFixed(d, int32);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Object js_toPrecision(double d, Object[] objArr) {
        if (objArr.length == 0 || Undefined.isUndefined(objArr[0])) {
            return ScriptRuntime.toString(d);
        }
        double integer = ScriptRuntime.toInteger(objArr[0]);
        if (!Double.isFinite(d)) {
            return ScriptRuntime.toString(d);
        }
        checkPrecision(integer, 1.0d, objArr[0]);
        return DecimalFormatter.toPrecision(d, ScriptRuntime.toInt32(integer));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(NUMBER_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        if (iMethodId == 1) {
            double dDoubleValue = objArr.length >= 1 ? ScriptRuntime.toNumeric(objArr[0]).doubleValue() : 0.0d;
            return scriptable2 == null ? new NativeNumber(dDoubleValue) : ScriptRuntime.wrapNumber(dDoubleValue);
        }
        if (iMethodId < 1) {
            return execConstructorCall(iMethodId, objArr);
        }
        double d = ((NativeNumber) IdScriptableObject.ensureType(scriptable2, NativeNumber.class, idFunctionObject)).doubleValue;
        switch (iMethodId) {
            case 2:
            case 3:
                return ScriptRuntime.numberToString(d, (objArr.length == 0 || Undefined.isUndefined(objArr[0])) ? 10 : ScriptRuntime.toInt32(objArr[0]));
            case 4:
                return "(new Number(" + ScriptRuntime.toString(d) + "))";
            case 5:
                return ScriptRuntime.wrapNumber(d);
            case 6:
                return js_toFixed(context, d, objArr);
            case 7:
                return js_toExponential(d, objArr);
            case 8:
                return js_toPrecision(d, objArr);
            default:
                jl.a(String.valueOf(iMethodId));
                return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject
    public void fillConstructorProperties(IdFunctionObject idFunctionObject) {
        idFunctionObject.defineProperty("NaN", ScriptRuntime.NaNobj, 7);
        idFunctionObject.defineProperty("POSITIVE_INFINITY", ScriptRuntime.wrapNumber(Double.POSITIVE_INFINITY), 7);
        idFunctionObject.defineProperty("NEGATIVE_INFINITY", ScriptRuntime.wrapNumber(Double.NEGATIVE_INFINITY), 7);
        idFunctionObject.defineProperty("MAX_VALUE", ScriptRuntime.wrapNumber(Double.MAX_VALUE), 7);
        idFunctionObject.defineProperty("MIN_VALUE", ScriptRuntime.wrapNumber(Double.MIN_VALUE), 7);
        idFunctionObject.defineProperty("MAX_SAFE_INTEGER", ScriptRuntime.wrapNumber(9.007199254740991E15d), 7);
        idFunctionObject.defineProperty("MIN_SAFE_INTEGER", ScriptRuntime.wrapNumber(MIN_SAFE_INTEGER), 7);
        idFunctionObject.defineProperty("EPSILON", ScriptRuntime.wrapNumber(EPSILON), 7);
        Object obj = NUMBER_TAG;
        addIdFunctionProperty(idFunctionObject, obj, -1, "isFinite", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_isNaN, "isNaN", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_isInteger, "isInteger", 1);
        addIdFunctionProperty(idFunctionObject, obj, ConstructorId_isSafeInteger, "isSafeInteger", 1);
        Object topLevelProp = ScriptRuntime.getTopLevelProp(idFunctionObject, "parseFloat");
        if (topLevelProp instanceof IdFunctionObject) {
            ((IdFunctionObject) topLevelProp).addAsProperty(idFunctionObject);
        }
        Object topLevelProp2 = ScriptRuntime.getTopLevelProp(idFunctionObject, "parseInt");
        if (topLevelProp2 instanceof IdFunctionObject) {
            ((IdFunctionObject) topLevelProp2).addAsProperty(idFunctionObject);
        }
        super.fillConstructorProperties(idFunctionObject);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        str.getClass();
        switch (str) {
            case "toLocaleString":
                return 3;
            case "toPrecision":
                return 8;
            case "toSource":
                return 4;
            case "toString":
                return 2;
            case "constructor":
                return 1;
            case "toFixed":
                return 6;
            case "valueOf":
                return 5;
            case "toExponential":
                return 7;
            default:
                return 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Number";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        String str2;
        int i2 = 1;
        switch (i) {
            case 1:
                str = "constructor";
                initPrototypeMethod(NUMBER_TAG, i, str, i2);
                break;
            case 2:
                str = "toString";
                initPrototypeMethod(NUMBER_TAG, i, str, i2);
                break;
            case 3:
                str = "toLocaleString";
                initPrototypeMethod(NUMBER_TAG, i, str, i2);
                break;
            case 4:
                str2 = "toSource";
                String str3 = str2;
                i2 = 0;
                str = str3;
                initPrototypeMethod(NUMBER_TAG, i, str, i2);
                break;
            case 5:
                str2 = "valueOf";
                String str32 = str2;
                i2 = 0;
                str = str32;
                initPrototypeMethod(NUMBER_TAG, i, str, i2);
                break;
            case 6:
                str = "toFixed";
                initPrototypeMethod(NUMBER_TAG, i, str, i2);
                break;
            case 7:
                str = "toExponential";
                initPrototypeMethod(NUMBER_TAG, i, str, i2);
                break;
            case 8:
                str = "toPrecision";
                initPrototypeMethod(NUMBER_TAG, i, str, i2);
                break;
            default:
                jl.a(String.valueOf(i));
                break;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return ScriptRuntime.numberToString(this.doubleValue, 10);
    }

    private static boolean isDoubleInteger(double d) {
        return Double.isFinite(d) && Math.floor(d) == d;
    }

    private static boolean isDoubleSafeInteger(double d) {
        return isDoubleInteger(d) && d <= 9.007199254740991E15d && d >= MIN_SAFE_INTEGER;
    }
}
