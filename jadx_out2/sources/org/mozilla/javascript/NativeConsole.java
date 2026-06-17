package org.mozilla.javascript;

import defpackage.e04;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.mozilla.javascript.NativeConsole;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class NativeConsole extends IdScriptableObject {
    private static final String DEFAULT_LABEL = "default";
    private static final int Id_assert = 8;
    private static final int Id_count = 9;
    private static final int Id_countReset = 10;
    private static final int Id_debug = 3;
    private static final int Id_error = 7;
    private static final int Id_info = 5;
    private static final int Id_log = 4;
    private static final int Id_time = 11;
    private static final int Id_timeEnd = 12;
    private static final int Id_timeLog = 13;
    private static final int Id_toSource = 1;
    private static final int Id_trace = 2;
    private static final int Id_warn = 6;
    private static final int LAST_METHOD_ID = 13;
    private static final int MAX_ID = 13;
    private static final long serialVersionUID = 5694613212458273057L;
    private final ConsolePrinter printer;
    private static final Object CONSOLE_TAG = "Console";
    private static final Pattern FMT_REG = Pattern.compile("%[sfdioOc%]");
    private final Map<String, Long> timers = new ConcurrentHashMap();
    private final Map<String, AtomicInteger> counters = new ConcurrentHashMap();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface ConsolePrinter extends Serializable {
        void print(Context context, Scriptable scriptable, Level level, Object[] objArr, ScriptStackElement[] scriptStackElementArr);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum Level {
        TRACE,
        DEBUG,
        INFO,
        WARN,
        ERROR
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private NativeConsole(ConsolePrinter consolePrinter) {
        this.printer = consolePrinter;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void count(Context context, Scriptable scriptable, Object[] objArr) {
        String string = objArr.length > 0 ? ScriptRuntime.toString(objArr[0]) : DEFAULT_LABEL;
        int iIncrementAndGet = this.counters.computeIfAbsent(string, new java.util.function.Function() { // from class: nx2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return NativeConsole.j((String) obj);
            }
        }).incrementAndGet();
        print(context, scriptable, Level.INFO, string + ": " + iIncrementAndGet);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void countReset(Context context, Scriptable scriptable, Object[] objArr) {
        String string = objArr.length > 0 ? ScriptRuntime.toString(objArr[0]) : DEFAULT_LABEL;
        if (this.counters.remove(string) == null) {
            print(context, scriptable, Level.WARN, "Count for '" + string + "' does not exist.");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String format(Context context, Scriptable scriptable, Object[] objArr) {
        Object obj;
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        Object obj2 = objArr[0];
        if ((obj2 instanceof String) || (obj2 instanceof ConsString)) {
            Matcher matcher = FMT_REG.matcher(obj2.toString());
            int i2 = 1;
            while (matcher.find()) {
                String strGroup = matcher.group();
                if (strGroup.equals("%%")) {
                    strGroup = "%";
                } else {
                    if (i2 < objArr.length) {
                        obj = objArr[i2];
                        switch (strGroup) {
                            case "%O":
                            case "%o":
                                strGroup = formatObj(context, scriptable, obj);
                                break;
                            case "%d":
                            case "%i":
                                strGroup = formatInt(obj);
                                break;
                            case "%f":
                                strGroup = formatFloat(obj);
                                break;
                            case "%s":
                                strGroup = formatString(obj);
                                break;
                            default:
                                strGroup = "";
                                break;
                        }
                    }
                    i2++;
                }
                matcher.appendReplacement(stringBuffer, Matcher.quoteReplacement(strGroup));
            }
            matcher.appendTail(stringBuffer);
            i = i2;
        }
        while (i < objArr.length) {
            if (stringBuffer.length() > 0) {
                stringBuffer.append(' ');
            }
            Object obj3 = objArr[i];
            if (obj3 instanceof String) {
                stringBuffer.append(formatString(obj3));
            } else {
                stringBuffer.append(formatObj(context, scriptable, obj3));
            }
            i++;
        }
        return stringBuffer.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String formatFloat(Object obj) {
        return ((obj instanceof BigInteger) || ScriptRuntime.isSymbol(obj)) ? ScriptRuntime.NaNobj.toString() : ScriptRuntime.numberToString(ScriptRuntime.toNumber(obj), 10);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String formatInt(Object obj) {
        if (!(obj instanceof BigInteger)) {
            if (ScriptRuntime.isSymbol(obj)) {
                return ScriptRuntime.NaNobj.toString();
            }
            double number = ScriptRuntime.toNumber(obj);
            return (Double.isInfinite(number) || Double.isNaN(number)) ? ScriptRuntime.toString(number) : String.valueOf((long) number);
        }
        return ScriptRuntime.bigIntToString((BigInteger) obj, 10) + "n";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String formatObj(Context context, Scriptable scriptable, final Object obj) {
        if (obj == null) {
            return "null";
        }
        if (Undefined.isUndefined(obj)) {
            return Undefined.SCRIPTABLE_UNDEFINED.toString();
        }
        if (!(obj instanceof NativeError)) {
            try {
                return ScriptRuntime.toString(NativeJSON.stringify(context, scriptable, obj, new Callable() { // from class: org.mozilla.javascript.NativeConsole.1
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // org.mozilla.javascript.Callable
                    public Object call(Context context2, Scriptable scriptable2, Scriptable scriptable3, Object[] objArr) {
                        Object delegee = objArr[1];
                        while (delegee instanceof Delegator) {
                            delegee = ((Delegator) delegee).getDelegee();
                        }
                        if (delegee instanceof BaseFunction) {
                            return "function " + ((BaseFunction) delegee).getFunctionName() + "() {...}";
                        }
                        if (delegee instanceof Callable) {
                            return ScriptRuntime.toString(delegee);
                        }
                        Object obj2 = obj;
                        return obj2 instanceof NativeError ? ((NativeError) obj2).toString() : delegee;
                    }
                }, null));
            } catch (EcmaError e) {
                if ("TypeError".equals(e.getName())) {
                    return ScriptRuntime.toString(obj);
                }
                throw e;
            }
        }
        NativeError nativeError = (NativeError) obj;
        return (nativeError.toString() + "\n").concat(String.valueOf(nativeError.get("stack")));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String formatString(Object obj) {
        if (!(obj instanceof BigInteger)) {
            return ScriptRuntime.isSymbol(obj) ? obj.toString() : ScriptRuntime.toString(obj);
        }
        return ScriptRuntime.toString(obj) + "n";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void init(Scriptable scriptable, boolean z, ConsolePrinter consolePrinter) {
        NativeConsole nativeConsole = new NativeConsole(consolePrinter);
        nativeConsole.activatePrototypeMap(13);
        nativeConsole.setPrototype(ScriptableObject.getObjectPrototype(scriptable));
        nativeConsole.setParentScope(scriptable);
        if (z) {
            nativeConsole.sealObject();
        }
        ScriptableObject.defineProperty(scriptable, "console", nativeConsole, 2);
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0003: CONSTRUCTOR (0 int) A[MD:(int):void (c)] (LINE:4) call: java.util.concurrent.atomic.AtomicInteger.<init>(int):void type: CONSTRUCTOR */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ AtomicInteger j(String str) {
        return new AtomicInteger(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void jsAssert(Context context, Scriptable scriptable, Object[] objArr) {
        Object[] objArr2;
        if (objArr == null || objArr.length <= 0 || !ScriptRuntime.toBoolean(objArr[0])) {
            if (objArr == null || objArr.length < 2) {
                this.printer.print(context, scriptable, Level.ERROR, new String[]{"Assertion failed: console.assert"}, null);
                return;
            }
            Object obj = objArr[1];
            if (obj instanceof String) {
                objArr[1] = "Assertion failed: ".concat(String.valueOf(obj));
                int length = objArr.length - 1;
                Object[] objArr3 = new Object[length];
                System.arraycopy(objArr, 1, objArr3, 0, length);
                objArr2 = objArr3;
            } else {
                objArr[0] = "Assertion failed:";
                objArr2 = objArr;
            }
            this.printer.print(context, scriptable, Level.ERROR, objArr2, null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private double nano2Milli(Long l) {
        return l.longValue() / 1000000.0d;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void print(Context context, Scriptable scriptable, Level level, String str) {
        this.printer.print(context, scriptable, level, new String[]{str}, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void time(Context context, Scriptable scriptable, Object[] objArr) {
        String string = objArr.length > 0 ? ScriptRuntime.toString(objArr[0]) : DEFAULT_LABEL;
        if (this.timers.get(string) == null) {
            this.timers.put(string, Long.valueOf(System.nanoTime()));
            return;
        }
        print(context, scriptable, Level.WARN, "Timer '" + string + "' already exists.");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void timeEnd(Context context, Scriptable scriptable, Object[] objArr) {
        String string = objArr.length > 0 ? ScriptRuntime.toString(objArr[0]) : DEFAULT_LABEL;
        Long lRemove = this.timers.remove(string);
        if (lRemove == null) {
            print(context, scriptable, Level.WARN, "Timer '" + string + "' does not exist.");
            return;
        }
        print(context, scriptable, Level.INFO, string + ": " + nano2Milli(Long.valueOf(System.nanoTime() - lRemove.longValue())) + "ms");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void timeLog(Context context, Scriptable scriptable, Object[] objArr) {
        String string = objArr.length > 0 ? ScriptRuntime.toString(objArr[0]) : DEFAULT_LABEL;
        Long l = this.timers.get(string);
        if (l == null) {
            print(context, scriptable, Level.WARN, "Timer '" + string + "' does not exist.");
            return;
        }
        StringBuilder sb = new StringBuilder(string + ": " + nano2Milli(Long.valueOf(System.nanoTime() - l.longValue())) + "ms");
        if (objArr.length > 1) {
            for (int i = 1; i < objArr.length; i++) {
                sb.append(" ");
                sb.append(ScriptRuntime.toString(objArr[i]));
            }
        }
        print(context, scriptable, Level.INFO, sb.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject, org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (!idFunctionObject.hasTag(CONSOLE_TAG)) {
            return super.execIdCall(idFunctionObject, context, scriptable, scriptable2, objArr);
        }
        int iMethodId = idFunctionObject.methodId();
        switch (iMethodId) {
            case 1:
                return "Console";
            case 2:
                this.printer.print(context, scriptable, Level.TRACE, objArr, new EvaluatorException("[object Object]").getScriptStack());
                break;
            case 3:
                this.printer.print(context, scriptable, Level.DEBUG, objArr, null);
                break;
            case 4:
            case 5:
                this.printer.print(context, scriptable, Level.INFO, objArr, null);
                break;
            case 6:
                this.printer.print(context, scriptable, Level.WARN, objArr, null);
                break;
            case 7:
                this.printer.print(context, scriptable, Level.ERROR, objArr, null);
                break;
            case 8:
                jsAssert(context, scriptable, objArr);
                break;
            case 9:
                count(context, scriptable, objArr);
                break;
            case 10:
                countReset(context, scriptable, objArr);
                break;
            case 11:
                time(context, scriptable, objArr);
                break;
            case 12:
                timeEnd(context, scriptable, objArr);
                break;
            case 13:
                timeLog(context, scriptable, objArr);
                break;
            default:
                e04.a(String.valueOf(iMethodId));
                return null;
        }
        return Undefined.instance;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject
    public int findPrototypeId(String str) {
        str.getClass();
        switch (str) {
            case "toSource":
                return 1;
            case "assert":
                return 8;
            case "timeEnd":
                return 12;
            case "timeLog":
                return 13;
            case "countReset":
                return 10;
            case "log":
                return 4;
            case "info":
                return 5;
            case "time":
                return 11;
            case "warn":
                return 6;
            case "count":
                return 9;
            case "debug":
                return 3;
            case "error":
                return 7;
            case "trace":
                return 2;
            default:
                return 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.ScriptableObject, org.mozilla.javascript.Scriptable
    public String getClassName() {
        return "Console";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdScriptableObject
    public void initPrototypeId(int i) {
        String str;
        String str2;
        if (i > 13) {
            e04.a(String.valueOf(i));
            return;
        }
        int i2 = 2;
        switch (i) {
            case 1:
                i2 = 0;
                str = "toSource";
                initPrototypeMethod(CONSOLE_TAG, i, str, i2);
                break;
            case 2:
                str2 = "trace";
                str = str2;
                i2 = 1;
                initPrototypeMethod(CONSOLE_TAG, i, str, i2);
                break;
            case 3:
                str2 = "debug";
                str = str2;
                i2 = 1;
                initPrototypeMethod(CONSOLE_TAG, i, str, i2);
                break;
            case 4:
                str2 = "log";
                str = str2;
                i2 = 1;
                initPrototypeMethod(CONSOLE_TAG, i, str, i2);
                break;
            case 5:
                str2 = "info";
                str = str2;
                i2 = 1;
                initPrototypeMethod(CONSOLE_TAG, i, str, i2);
                break;
            case 6:
                str2 = "warn";
                str = str2;
                i2 = 1;
                initPrototypeMethod(CONSOLE_TAG, i, str, i2);
                break;
            case 7:
                str2 = "error";
                str = str2;
                i2 = 1;
                initPrototypeMethod(CONSOLE_TAG, i, str, i2);
                break;
            case 8:
                str = "assert";
                initPrototypeMethod(CONSOLE_TAG, i, str, i2);
                break;
            case 9:
                str2 = "count";
                str = str2;
                i2 = 1;
                initPrototypeMethod(CONSOLE_TAG, i, str, i2);
                break;
            case 10:
                str2 = "countReset";
                str = str2;
                i2 = 1;
                initPrototypeMethod(CONSOLE_TAG, i, str, i2);
                break;
            case 11:
                str2 = "time";
                str = str2;
                i2 = 1;
                initPrototypeMethod(CONSOLE_TAG, i, str, i2);
                break;
            case 12:
                str2 = "timeEnd";
                str = str2;
                i2 = 1;
                initPrototypeMethod(CONSOLE_TAG, i, str, i2);
                break;
            case 13:
                str = "timeLog";
                initPrototypeMethod(CONSOLE_TAG, i, str, i2);
                break;
            default:
                e04.a(String.valueOf(i));
                break;
        }
    }
}
