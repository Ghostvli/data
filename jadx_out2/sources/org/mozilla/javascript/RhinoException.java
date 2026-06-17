package org.mozilla.javascript;

import defpackage.d04;
import defpackage.jl;
import defpackage.z20;
import java.io.CharArrayWriter;
import java.io.FilenameFilter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.security.AccessControlException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class RhinoException extends RuntimeException {
    private static final Pattern JAVA_STACK_PATTERN = Pattern.compile("_c_(.*)_\\d+");
    private static final long serialVersionUID = 1883500631321581169L;
    private static StackStyle stackStyle;
    private int columnNumber;
    int[] interpreterLineData;
    Object interpreterStackInfo;
    private int lineNumber;
    private String lineSource;
    private String sourceName;

    /* JADX INFO: renamed from: org.mozilla.javascript.RhinoException$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$mozilla$javascript$StackStyle;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            int[] iArr = new int[StackStyle.values().length];
            $SwitchMap$org$mozilla$javascript$StackStyle = iArr;
            try {
                iArr[StackStyle.MOZILLA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$mozilla$javascript$StackStyle[StackStyle.MOZILLA_LF.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$mozilla$javascript$StackStyle[StackStyle.V8.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$org$mozilla$javascript$StackStyle[StackStyle.RHINO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        StackStyle stackStyle2 = StackStyle.RHINO;
        stackStyle = stackStyle2;
        try {
            String property = System.getProperty("rhino.stack.style");
            if (property != null) {
                if ("Rhino".equalsIgnoreCase(property)) {
                    stackStyle = stackStyle2;
                } else if ("Mozilla".equalsIgnoreCase(property)) {
                    stackStyle = StackStyle.MOZILLA;
                } else if ("V8".equalsIgnoreCase(property)) {
                    stackStyle = StackStyle.V8;
                }
            }
        } catch (AccessControlException unused) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RhinoException() {
        Evaluator evaluatorCreateInterpreter = Context.createInterpreter();
        if (evaluatorCreateInterpreter != null) {
            evaluatorCreateInterpreter.captureStackInfo(this);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String formatStackTrace(ScriptStackElement[] scriptStackElementArr, String str) {
        StringBuilder sb = new StringBuilder();
        String systemProperty = SecurityUtilities.getSystemProperty("line.separator");
        if (stackStyle == StackStyle.V8 && !"null".equals(str)) {
            sb.append(str);
            sb.append(systemProperty);
        }
        for (ScriptStackElement scriptStackElement : scriptStackElementArr) {
            int i = AnonymousClass1.$SwitchMap$org$mozilla$javascript$StackStyle[stackStyle.ordinal()];
            if (i == 1) {
                scriptStackElement.renderMozillaStyle(sb);
                sb.append(systemProperty);
            } else if (i == 2) {
                scriptStackElement.renderMozillaStyle(sb);
                sb.append('\n');
            } else if (i == 3) {
                scriptStackElement.renderV8Style(sb);
                sb.append(systemProperty);
            } else if (i == 4) {
                scriptStackElement.renderJavaStyle(sb);
                sb.append(systemProperty);
            }
        }
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String generateStackTrace() {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        super.printStackTrace(new PrintWriter(charArrayWriter));
        String string = charArrayWriter.toString();
        Evaluator evaluatorCreateInterpreter = Context.createInterpreter();
        if (evaluatorCreateInterpreter != null) {
            return evaluatorCreateInterpreter.getPatchedStack(this, string);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static StackStyle getStackStyle() {
        return stackStyle;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void setStackStyle(StackStyle stackStyle2) {
        stackStyle = stackStyle2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void useMozillaStackStyle(boolean z) {
        stackStyle = z ? StackStyle.MOZILLA : StackStyle.RHINO;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean usesMozillaStackStyle() {
        return stackStyle == StackStyle.MOZILLA;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int columnNumber() {
        return this.columnNumber;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String details() {
        return super.getMessage();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Throwable
    public final String getMessage() {
        String strDetails = details();
        if (this.sourceName == null || this.lineNumber <= 0) {
            return strDetails;
        }
        StringBuilder sb = new StringBuilder(strDetails);
        sb.append(" (");
        sb.append(this.sourceName);
        if (this.lineNumber > 0) {
            sb.append('#');
            sb.append(this.lineNumber);
        }
        sb.append(')');
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ScriptStackElement[] getScriptStack(int i, String str) {
        ScriptStackElement[][] scriptStackElements;
        ArrayList arrayList = new ArrayList();
        if (this.interpreterStackInfo != null) {
            Evaluator evaluatorCreateInterpreter = Context.createInterpreter();
            scriptStackElements = evaluatorCreateInterpreter instanceof Interpreter ? ((Interpreter) evaluatorCreateInterpreter).getScriptStackElements(this) : null;
        }
        StackTraceElement[] stackTrace = getStackTrace();
        boolean z = str == null;
        int i2 = 0;
        int i3 = 0;
        for (StackTraceElement stackTraceElement : stackTrace) {
            String fileName = stackTraceElement.getFileName();
            if (stackTraceElement.getMethodName().startsWith("_c_") && stackTraceElement.getLineNumber() > -1 && (fileName == null || !fileName.endsWith(".java"))) {
                String methodName = stackTraceElement.getMethodName();
                Matcher matcher = JAVA_STACK_PATTERN.matcher(methodName);
                String strGroup = ("_c_script_0".equals(methodName) || !matcher.find()) ? null : matcher.group(1);
                if (!z && str.equals(strGroup)) {
                    z = true;
                } else if (z && (i < 0 || i3 < i)) {
                    if (fileName == null) {
                        fileName = "(unknown)";
                    }
                    arrayList.add(new ScriptStackElement(fileName, strGroup, stackTraceElement.getLineNumber()));
                    i3++;
                }
            } else if ("org.mozilla.javascript.Interpreter".equals(stackTraceElement.getClassName()) && "interpretLoop".equals(stackTraceElement.getMethodName()) && scriptStackElements != null && scriptStackElements.length > i2) {
                int i4 = i2 + 1;
                for (ScriptStackElement scriptStackElement : scriptStackElements[i2]) {
                    if (!z && str.equals(scriptStackElement.functionName)) {
                        z = true;
                    } else if (z && (i < 0 || i3 < i)) {
                        arrayList.add(scriptStackElement);
                        i3++;
                    }
                }
                i2 = i4;
            }
        }
        return (ScriptStackElement[]) arrayList.toArray(new ScriptStackElement[0]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getScriptStackTrace(int i, String str) {
        return formatStackTrace(getScriptStack(i, str), details());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void initColumnNumber(int i) {
        if (i <= 0) {
            jl.a(String.valueOf(i));
        } else if (this.columnNumber <= 0) {
            this.columnNumber = i;
        } else {
            z20.a();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void initLineNumber(int i) {
        if (i <= 0) {
            jl.a(String.valueOf(i));
        } else if (this.lineNumber <= 0) {
            this.lineNumber = i;
        } else {
            z20.a();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void initLineSource(String str) {
        if (str == null) {
            d04.a();
        } else if (this.lineSource == null) {
            this.lineSource = str;
        } else {
            z20.a();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void initSourceName(String str) {
        if (str == null) {
            d04.a();
        } else if (this.sourceName == null) {
            this.sourceName = str;
        } else {
            z20.a();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int lineNumber() {
        return this.lineNumber;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String lineSource() {
        return this.lineSource;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        if (this.interpreterStackInfo == null) {
            super.printStackTrace(printWriter);
        } else {
            printWriter.print(generateStackTrace());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void recordErrorOrigin(String str, int i, String str2, int i2) {
        if (i == -1) {
            i = 0;
        }
        if (str != null) {
            initSourceName(str);
        }
        if (i != 0) {
            initLineNumber(i);
        }
        if (str2 != null) {
            initLineSource(str2);
        }
        if (i2 != 0) {
            initColumnNumber(i2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String sourceName() {
        return this.sourceName;
    }

    public RhinoException(String str) {
        super(str);
        Evaluator evaluatorCreateInterpreter = Context.createInterpreter();
        if (evaluatorCreateInterpreter != null) {
            evaluatorCreateInterpreter.captureStackInfo(this);
        }
    }

    public String getScriptStackTrace() {
        return getScriptStackTrace(-1, null);
    }

    @Deprecated
    public String getScriptStackTrace(FilenameFilter filenameFilter) {
        return getScriptStackTrace();
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        if (this.interpreterStackInfo == null) {
            super.printStackTrace(printStream);
        } else {
            printStream.print(generateStackTrace());
        }
    }

    public ScriptStackElement[] getScriptStack() {
        return getScriptStack(-1, null);
    }
}
