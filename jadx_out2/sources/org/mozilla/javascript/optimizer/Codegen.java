package org.mozilla.javascript.optimizer;

import defpackage.zt2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.mozilla.classfile.ClassFileWriter;
import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Evaluator;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.GeneratedClassLoader;
import org.mozilla.javascript.Kit;
import org.mozilla.javascript.NativeFunction;
import org.mozilla.javascript.RhinoException;
import org.mozilla.javascript.Script;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.SecurityController;
import org.mozilla.javascript.Token;
import org.mozilla.javascript.ast.FunctionNode;
import org.mozilla.javascript.ast.Name;
import org.mozilla.javascript.ast.ScriptNode;
import org.mozilla.javascript.ast.TemplateCharacters;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Codegen implements Evaluator {
    static final String DEFAULT_MAIN_METHOD_CLASS = "org.mozilla.javascript.optimizer.OptRuntime";
    static final String FUNCTION_CONSTRUCTOR_SIGNATURE = "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Context;I)V";
    static final String FUNCTION_INIT_SIGNATURE = "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)V";
    static final String ID_FIELD_NAME = "_id";
    static final String REGEXP_INIT_METHOD_NAME = "_reInit";
    static final String REGEXP_INIT_METHOD_SIGNATURE = "(Lorg/mozilla/javascript/Context;)V";
    private static final String SUPER_CLASS_NAME = "org.mozilla.javascript.NativeFunction";
    static final String TEMPLATE_LITERAL_INIT_METHOD_NAME = "_qInit";
    static final String TEMPLATE_LITERAL_INIT_METHOD_SIGNATURE = "()V";
    private static final Object globalLock = new Object();
    private static int globalSerialClassCounter;
    private CompilerEnvirons compilerEnv;
    private List<OptFunctionNode> directCallTargets;
    private double[] itsConstantList;
    private int itsConstantListSize;
    String mainClassName;
    String mainClassSignature;
    private String mainMethodClass = DEFAULT_MAIN_METHOD_CLASS;
    private HashMap<ScriptNode, Integer> scriptOrFnIndexes;
    ScriptNode[] scriptOrFnNodes;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void addDoubleWrap(ClassFileWriter classFileWriter) {
        classFileWriter.F(Token.DOTDOTDOT, "org/mozilla/javascript/optimizer/OptRuntime", "wrapDouble", "(D)Ljava/lang/Double;");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static RuntimeException badTree() {
        throw new RuntimeException("Bad tree in codegen");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void collectScriptNodes_r(ScriptNode scriptNode, List<ScriptNode> list) {
        list.add(scriptNode);
        int functionCount = scriptNode.getFunctionCount();
        for (int i = 0; i != functionCount; i++) {
            collectScriptNodes_r(scriptNode.getFunctionNode(i), list);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Class<?> defineClass(Object obj, Object obj2) {
        Object[] objArr = (Object[]) obj;
        String str = (String) objArr[0];
        byte[] bArr = (byte[]) objArr[1];
        GeneratedClassLoader generatedClassLoaderCreateLoader = SecurityController.createLoader(getClass().getClassLoader(), obj2);
        try {
            Class<?> clsDefineClass = generatedClassLoaderCreateLoader.defineClass(str, bArr);
            generatedClassLoaderCreateLoader.linkClass(clsDefineClass);
            return clsDefineClass;
        } catch (IllegalArgumentException | SecurityException e) {
            zt2.a("Malformed optimizer package ".concat(String.valueOf(e)));
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void emitConstantDudeInitializers(ClassFileWriter classFileWriter) {
        int i = this.itsConstantListSize;
        if (i == 0) {
            return;
        }
        classFileWriter.G0("<clinit>", TEMPLATE_LITERAL_INIT_METHOD_SIGNATURE, (short) 24);
        double[] dArr = this.itsConstantList;
        for (int i2 = 0; i2 != i; i2++) {
            double d = dArr[i2];
            String str = "_k" + i2;
            String staticConstantWrapperType = getStaticConstantWrapperType(d);
            classFileWriter.B(str, staticConstantWrapperType, (short) 10);
            int i3 = (int) d;
            if (i3 == d) {
                classFileWriter.Q(i3);
                classFileWriter.F(Token.DOTDOTDOT, "java/lang/Integer", "valueOf", "(I)Ljava/lang/Integer;");
            } else {
                classFileWriter.P(d);
                addDoubleWrap(classFileWriter);
            }
            classFileWriter.u(Token.YIELD_STAR, this.mainClassName, str, staticConstantWrapperType);
        }
        classFileWriter.r(Token.METHOD);
        classFileWriter.H0(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void emitDirectConstructor(ClassFileWriter classFileWriter, OptFunctionNode optFunctionNode) {
        classFileWriter.G0(getDirectCtorName(optFunctionNode.fnode), getBodyMethodSignature(optFunctionNode.fnode), (short) 10);
        int paramCount = optFunctionNode.fnode.getParamCount();
        int i = paramCount * 3;
        int i2 = i + 4;
        int i3 = i + 5;
        classFileWriter.v(0);
        classFileWriter.v(1);
        classFileWriter.v(2);
        classFileWriter.F(Token.TEMPLATE_LITERAL_SUBST, "org/mozilla/javascript/BaseFunction", "createObject", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.w(i3);
        classFileWriter.v(0);
        classFileWriter.v(1);
        classFileWriter.v(2);
        classFileWriter.v(i3);
        for (int i4 = 0; i4 < paramCount; i4++) {
            int i5 = i4 * 3;
            classFileWriter.v(i5 + 4);
            classFileWriter.x(i5 + 5);
        }
        classFileWriter.v(i2);
        classFileWriter.F(Token.DOTDOTDOT, this.mainClassName, getBodyMethodName(optFunctionNode.fnode), getBodyMethodSignature(optFunctionNode.fnode));
        int iQ = classFileWriter.q();
        classFileWriter.r(89);
        classFileWriter.t(193, "org/mozilla/javascript/Scriptable");
        classFileWriter.s(Token.SETPROP_OP, iQ);
        classFileWriter.t(192, "org/mozilla/javascript/Scriptable");
        classFileWriter.r(Token.GENEXPR);
        classFileWriter.r0(iQ);
        classFileWriter.v(i3);
        classFileWriter.r(Token.GENEXPR);
        classFileWriter.H0((short) (i + 6));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void emitRegExpInit(ClassFileWriter classFileWriter) {
        int i = 0;
        int i2 = 0;
        int regexpCount = 0;
        while (true) {
            ScriptNode[] scriptNodeArr = this.scriptOrFnNodes;
            if (i2 == scriptNodeArr.length) {
                break;
            }
            regexpCount += scriptNodeArr[i2].getRegexpCount();
            i2++;
        }
        if (regexpCount == 0) {
            return;
        }
        short s = 10;
        classFileWriter.G0(REGEXP_INIT_METHOD_NAME, REGEXP_INIT_METHOD_SIGNATURE, (short) 10);
        classFileWriter.B("_reInitDone", "Z", (short) 74);
        classFileWriter.u(Token.ARROW, this.mainClassName, "_reInitDone", "Z");
        int iQ = classFileWriter.q();
        classFileWriter.s(Token.SETPROP_OP, iQ);
        classFileWriter.r(Token.METHOD);
        classFileWriter.r0(iQ);
        classFileWriter.v(0);
        classFileWriter.F(Token.DOTDOTDOT, "org/mozilla/javascript/ScriptRuntime", "checkRegExpProxy", "(Lorg/mozilla/javascript/Context;)Lorg/mozilla/javascript/RegExpProxy;");
        classFileWriter.w(1);
        int i3 = 0;
        while (true) {
            ScriptNode[] scriptNodeArr2 = this.scriptOrFnNodes;
            if (i3 == scriptNodeArr2.length) {
                classFileWriter.Q(1);
                classFileWriter.u(Token.YIELD_STAR, this.mainClassName, "_reInitDone", "Z");
                classFileWriter.r(Token.METHOD);
                classFileWriter.H0(2);
                return;
            }
            ScriptNode scriptNode = scriptNodeArr2[i3];
            int regexpCount2 = scriptNode.getRegexpCount();
            int i4 = i;
            while (i4 != regexpCount2) {
                String compiledRegexpName = getCompiledRegexpName(scriptNode, i4);
                String regexpString = scriptNode.getRegexpString(i4);
                String regexpFlags = scriptNode.getRegexpFlags(i4);
                classFileWriter.B(compiledRegexpName, "Ljava/lang/Object;", s);
                classFileWriter.v(1);
                classFileWriter.v(i);
                classFileWriter.S(regexpString);
                if (regexpFlags == null) {
                    classFileWriter.r(1);
                } else {
                    classFileWriter.S(regexpFlags);
                }
                classFileWriter.F(Token.NULLISH_COALESCING, "org/mozilla/javascript/RegExpProxy", "compileRegExp", "(Lorg/mozilla/javascript/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/Object;");
                classFileWriter.u(Token.YIELD_STAR, this.mainClassName, compiledRegexpName, "Ljava/lang/Object;");
                i4++;
                i = 0;
                s = 10;
            }
            i3++;
            i = 0;
            s = 10;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void emitTemplateLiteralInit(ClassFileWriter classFileWriter) {
        int templateLiteralCount = 0;
        for (ScriptNode scriptNode : this.scriptOrFnNodes) {
            templateLiteralCount += scriptNode.getTemplateLiteralCount();
        }
        if (templateLiteralCount == 0) {
            return;
        }
        short s = 10;
        classFileWriter.G0(TEMPLATE_LITERAL_INIT_METHOD_NAME, TEMPLATE_LITERAL_INIT_METHOD_SIGNATURE, (short) 10);
        classFileWriter.B("_qInitDone", "Z", (short) 74);
        classFileWriter.u(Token.ARROW, this.mainClassName, "_qInitDone", "Z");
        int iQ = classFileWriter.q();
        classFileWriter.s(Token.SETPROP_OP, iQ);
        classFileWriter.r(Token.METHOD);
        classFileWriter.r0(iQ);
        ScriptNode[] scriptNodeArr = this.scriptOrFnNodes;
        int length = scriptNodeArr.length;
        int i = 0;
        while (i < length) {
            ScriptNode scriptNode2 = scriptNodeArr[i];
            int templateLiteralCount2 = scriptNode2.getTemplateLiteralCount();
            if (templateLiteralCount2 != 0) {
                String templateLiteralName = getTemplateLiteralName(scriptNode2);
                classFileWriter.B(templateLiteralName, "[Ljava/lang/Object;", s);
                classFileWriter.Q(templateLiteralCount2);
                int i2 = 189;
                classFileWriter.t(189, "java/lang/Object");
                int i3 = 0;
                while (i3 < templateLiteralCount2) {
                    List<TemplateCharacters> templateLiteralStrings = scriptNode2.getTemplateLiteralStrings(i3);
                    int i4 = 89;
                    classFileWriter.r(89);
                    classFileWriter.Q(i3);
                    classFileWriter.Q(templateLiteralStrings.size() * 2);
                    classFileWriter.t(i2, "java/lang/String");
                    int i5 = 0;
                    for (TemplateCharacters templateCharacters : templateLiteralStrings) {
                        classFileWriter.r(i4);
                        int i6 = i5 + 1;
                        classFileWriter.Q(i5);
                        if (templateCharacters.getValue() != null) {
                            classFileWriter.S(templateCharacters.getValue());
                        } else {
                            classFileWriter.r(1);
                        }
                        classFileWriter.r(83);
                        classFileWriter.r(89);
                        i5 += 2;
                        classFileWriter.Q(i6);
                        classFileWriter.S(templateCharacters.getRawValue());
                        classFileWriter.r(83);
                        i4 = 89;
                    }
                    classFileWriter.r(83);
                    i3++;
                    i2 = 189;
                }
                classFileWriter.u(Token.YIELD_STAR, this.mainClassName, templateLiteralName, "[Ljava/lang/Object;");
            }
            i++;
            s = 10;
        }
        classFileWriter.T(true);
        classFileWriter.u(Token.YIELD_STAR, this.mainClassName, "_qInitDone", "Z");
        classFileWriter.r(Token.METHOD);
        classFileWriter.H0(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void generateCallMethod(ClassFileWriter classFileWriter, boolean z) {
        int iW;
        int paramCount;
        classFileWriter.G0("call", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;", (short) 17);
        int iQ = classFileWriter.q();
        classFileWriter.v(1);
        classFileWriter.F(Token.DOTDOTDOT, "org/mozilla/javascript/ScriptRuntime", "hasTopCall", "(Lorg/mozilla/javascript/Context;)Z");
        classFileWriter.s(Token.SETELEM_OP, iQ);
        int i = 0;
        classFileWriter.v(0);
        classFileWriter.v(1);
        classFileWriter.v(2);
        classFileWriter.v(3);
        classFileWriter.v(4);
        classFileWriter.T(z);
        classFileWriter.F(Token.DOTDOTDOT, "org/mozilla/javascript/ScriptRuntime", "doTopCall", "(Lorg/mozilla/javascript/Callable;Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;Z)Ljava/lang/Object;");
        classFileWriter.r(Token.GENEXPR);
        classFileWriter.r0(iQ);
        classFileWriter.v(0);
        classFileWriter.v(1);
        classFileWriter.v(2);
        classFileWriter.v(3);
        classFileWriter.v(4);
        int length = this.scriptOrFnNodes.length;
        boolean z2 = 2 <= length;
        if (z2) {
            classFileWriter.O();
            classFileWriter.u(180, classFileWriter.k0(), ID_FIELD_NAME, "I");
            iW = classFileWriter.W(1, length - 1);
        } else {
            iW = 0;
        }
        int i2 = 0;
        int iO0 = 0;
        while (i2 != length) {
            ScriptNode scriptNode = this.scriptOrFnNodes[i2];
            if (z2) {
                if (i2 == 0) {
                    classFileWriter.v0(iW);
                    iO0 = classFileWriter.o0();
                } else {
                    classFileWriter.u0(iW, i2 - 1, iO0);
                }
            }
            if (scriptNode.getType() == 122) {
                OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode);
                if (optFunctionNode.isTargetOfDirectCall() && (paramCount = optFunctionNode.fnode.getParamCount()) != 0) {
                    for (int i3 = i; i3 != paramCount; i3++) {
                        classFileWriter.r(190);
                        classFileWriter.Q(i3);
                        int iQ2 = classFileWriter.q();
                        int iQ3 = classFileWriter.q();
                        classFileWriter.s(Token.TO_DOUBLE, iQ2);
                        classFileWriter.v(4);
                        classFileWriter.Q(i3);
                        classFileWriter.r(50);
                        classFileWriter.s(Token.LET, iQ3);
                        classFileWriter.r0(iQ2);
                        pushUndefined(classFileWriter);
                        classFileWriter.r0(iQ3);
                        classFileWriter.a0(-1);
                        classFileWriter.P(0.0d);
                        classFileWriter.v(4);
                    }
                }
            }
            classFileWriter.F(Token.DOTDOTDOT, this.mainClassName, getBodyMethodName(scriptNode), getBodyMethodSignature(scriptNode));
            classFileWriter.r(Token.GENEXPR);
            i2++;
            i = 0;
        }
        classFileWriter.H0(5);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private byte[] generateCode(String str) {
        boolean z = true;
        boolean z2 = this.scriptOrFnNodes[0].getType() == 150;
        ScriptNode[] scriptNodeArr = this.scriptOrFnNodes;
        if (scriptNodeArr.length <= 1 && z2) {
            z = false;
        }
        boolean zIsInStrictMode = scriptNodeArr[0].isInStrictMode();
        ClassFileWriter classFileWriter = new ClassFileWriter(this.mainClassName, SUPER_CLASS_NAME, this.scriptOrFnNodes[0].getSourceName());
        classFileWriter.B(ID_FIELD_NAME, "I", (short) 2);
        if (z) {
            generateFunctionConstructor(classFileWriter);
        }
        if (z2) {
            classFileWriter.E("org/mozilla/javascript/Script");
            generateScriptCtor(classFileWriter);
            generateMain(classFileWriter);
            generateExecute(classFileWriter);
        }
        generateCallMethod(classFileWriter, zIsInStrictMode);
        generateResumeGenerator(classFileWriter);
        generateNativeFunctionOverrides(classFileWriter, str);
        int length = this.scriptOrFnNodes.length;
        for (int i = 0; i != length; i++) {
            ScriptNode scriptNode = this.scriptOrFnNodes[i];
            BodyCodegen bodyCodegen = new BodyCodegen();
            bodyCodegen.cfw = classFileWriter;
            bodyCodegen.codegen = this;
            bodyCodegen.compilerEnv = this.compilerEnv;
            bodyCodegen.scriptOrFn = scriptNode;
            bodyCodegen.scriptOrFnIndex = i;
            bodyCodegen.generateBodyCode();
            if (scriptNode.getType() == 122) {
                OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode);
                generateFunctionInit(classFileWriter, optFunctionNode);
                if (optFunctionNode.isTargetOfDirectCall()) {
                    emitDirectConstructor(classFileWriter, optFunctionNode);
                }
            }
        }
        emitRegExpInit(classFileWriter);
        emitTemplateLiteralInit(classFileWriter);
        emitConstantDudeInitializers(classFileWriter);
        return classFileWriter.I0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void generateExecute(ClassFileWriter classFileWriter) {
        classFileWriter.G0("exec", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;)Ljava/lang/Object;", (short) 17);
        classFileWriter.O();
        classFileWriter.v(1);
        classFileWriter.v(2);
        classFileWriter.r(89);
        classFileWriter.r(1);
        classFileWriter.F(Token.TEMPLATE_LITERAL_SUBST, classFileWriter.k0(), "call", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;[Ljava/lang/Object;)Ljava/lang/Object;");
        classFileWriter.v(1);
        classFileWriter.F(Token.TEMPLATE_LITERAL_SUBST, "org.mozilla.javascript.Context", "processMicrotasks", TEMPLATE_LITERAL_INIT_METHOD_SIGNATURE);
        classFileWriter.r(Token.GENEXPR);
        classFileWriter.H0(3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void generateFunctionConstructor(ClassFileWriter classFileWriter) {
        int iW;
        classFileWriter.G0("<init>", FUNCTION_CONSTRUCTOR_SIGNATURE, (short) 1);
        int iO0 = 0;
        classFileWriter.v(0);
        classFileWriter.F(Token.TAGGED_TEMPLATE_LITERAL, SUPER_CLASS_NAME, "<init>", TEMPLATE_LITERAL_INIT_METHOD_SIGNATURE);
        classFileWriter.O();
        classFileWriter.C(3);
        classFileWriter.u(Token.TEMPLATE_CHARS, classFileWriter.k0(), ID_FIELD_NAME, "I");
        classFileWriter.O();
        classFileWriter.v(2);
        classFileWriter.v(1);
        int i = this.scriptOrFnNodes[0].getType() == 150 ? 1 : 0;
        int length = this.scriptOrFnNodes.length;
        if (i == length) {
            throw badTree();
        }
        boolean z = 2 <= length - i;
        if (z) {
            classFileWriter.C(3);
            iW = classFileWriter.W(i + 1, length - 1);
        } else {
            iW = 0;
        }
        for (int i2 = i; i2 != length; i2++) {
            if (z) {
                if (i2 == i) {
                    classFileWriter.v0(iW);
                    iO0 = classFileWriter.o0();
                } else {
                    classFileWriter.u0(iW, (i2 - 1) - i, iO0);
                }
            }
            classFileWriter.F(Token.TAGGED_TEMPLATE_LITERAL, this.mainClassName, getFunctionInitMethodName(OptFunctionNode.get(this.scriptOrFnNodes[i2])), FUNCTION_INIT_SIGNATURE);
            classFileWriter.r(Token.METHOD);
        }
        classFileWriter.H0(4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void generateFunctionInit(ClassFileWriter classFileWriter, OptFunctionNode optFunctionNode) {
        classFileWriter.G0(getFunctionInitMethodName(optFunctionNode), FUNCTION_INIT_SIGNATURE, (short) 18);
        classFileWriter.O();
        classFileWriter.v(1);
        classFileWriter.v(2);
        classFileWriter.F(Token.TEMPLATE_LITERAL_SUBST, "org/mozilla/javascript/NativeFunction", "initScriptFunction", FUNCTION_INIT_SIGNATURE);
        if (optFunctionNode.fnode.getRegexpCount() != 0) {
            classFileWriter.v(1);
            classFileWriter.F(Token.DOTDOTDOT, this.mainClassName, REGEXP_INIT_METHOD_NAME, REGEXP_INIT_METHOD_SIGNATURE);
        }
        if (optFunctionNode.fnode.getTemplateLiteralCount() != 0) {
            classFileWriter.F(Token.DOTDOTDOT, this.mainClassName, TEMPLATE_LITERAL_INIT_METHOD_NAME, TEMPLATE_LITERAL_INIT_METHOD_SIGNATURE);
        }
        classFileWriter.r(Token.METHOD);
        classFileWriter.H0(3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void generateMain(ClassFileWriter classFileWriter) {
        classFileWriter.G0("main", "([Ljava/lang/String;)V", (short) 9);
        classFileWriter.t(Token.LAST_TOKEN, classFileWriter.k0());
        classFileWriter.r(89);
        classFileWriter.F(Token.TAGGED_TEMPLATE_LITERAL, classFileWriter.k0(), "<init>", TEMPLATE_LITERAL_INIT_METHOD_SIGNATURE);
        classFileWriter.r(42);
        classFileWriter.F(Token.DOTDOTDOT, this.mainMethodClass, "main", "(Lorg/mozilla/javascript/Script;[Ljava/lang/String;)V");
        classFileWriter.r(Token.METHOD);
        classFileWriter.H0(1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void generateNativeFunctionOverrides(ClassFileWriter classFileWriter, String str) {
        short s;
        int length;
        int iW;
        int i;
        short s2;
        short s3;
        short s4;
        short s5 = 1;
        classFileWriter.G0("getLanguageVersion", "()I", (short) 1);
        classFileWriter.Q(this.compilerEnv.getLanguageVersion());
        int i2 = Token.LETEXPR;
        classFileWriter.r(Token.LETEXPR);
        classFileWriter.H0(1);
        int i3 = 0;
        while (i3 != 9) {
            if (i3 == 4 && str == null) {
                s2 = s5;
            } else {
                int i4 = 3;
                switch (i3) {
                    case 0:
                        classFileWriter.G0("getFunctionName", "()Ljava/lang/String;", s5);
                        s = s5;
                        length = this.scriptOrFnNodes.length;
                        if (length > s5) {
                            classFileWriter.O();
                            classFileWriter.u(180, classFileWriter.k0(), ID_FIELD_NAME, "I");
                            iW = classFileWriter.W(s5, length - 1);
                        } else {
                            iW = 0;
                        }
                        i = 0;
                        int iO0 = 0;
                        while (i != length) {
                            ScriptNode scriptNode = this.scriptOrFnNodes[i];
                            if (i != 0) {
                                classFileWriter.u0(iW, i - 1, iO0);
                            } else if (length > s5) {
                                classFileWriter.v0(iW);
                                iO0 = classFileWriter.o0();
                            }
                            switch (i3) {
                                case 0:
                                    s3 = s5;
                                    if (scriptNode.getType() == 150) {
                                        classFileWriter.S("");
                                    } else {
                                        classFileWriter.S(((FunctionNode) scriptNode).getName());
                                    }
                                    classFileWriter.r(Token.GENEXPR);
                                    i++;
                                    s5 = s3;
                                    i4 = 3;
                                    break;
                                case 1:
                                    if (scriptNode.hasRestParameter()) {
                                        s3 = 1;
                                        classFileWriter.Q(scriptNode.getParamCount() - 1);
                                    } else {
                                        s3 = 1;
                                        classFileWriter.Q(scriptNode.getParamCount());
                                    }
                                    classFileWriter.r(i2);
                                    i++;
                                    s5 = s3;
                                    i4 = 3;
                                    break;
                                case 2:
                                    classFileWriter.Q(scriptNode.getParamAndVarCount());
                                    i2 = Token.LETEXPR;
                                    classFileWriter.r(Token.LETEXPR);
                                    s3 = 1;
                                    i++;
                                    s5 = s3;
                                    i4 = 3;
                                    break;
                                case 3:
                                    int paramAndVarCount = scriptNode.getParamAndVarCount();
                                    if (paramAndVarCount != 0) {
                                        s4 = 1;
                                        if (paramAndVarCount != 1) {
                                            classFileWriter.C(1);
                                            int iW2 = classFileWriter.W(1, paramAndVarCount - 1);
                                            int i5 = 0;
                                            while (i5 != paramAndVarCount) {
                                                if (classFileWriter.o0() != 0) {
                                                    Kit.codeBug();
                                                }
                                                String paramOrVarName = scriptNode.getParamOrVarName(i5);
                                                if (i5 == 0) {
                                                    classFileWriter.v0(iW2);
                                                } else {
                                                    classFileWriter.u0(iW2, i5 - 1, 0);
                                                }
                                                classFileWriter.S(paramOrVarName);
                                                classFileWriter.r(Token.GENEXPR);
                                                i5++;
                                                i2 = Token.LETEXPR;
                                            }
                                            s3 = 1;
                                            i++;
                                            s5 = s3;
                                            i4 = 3;
                                        } else {
                                            classFileWriter.S(scriptNode.getParamOrVarName(0));
                                            classFileWriter.r(Token.GENEXPR);
                                        }
                                    } else {
                                        s4 = 1;
                                        classFileWriter.r(1);
                                        classFileWriter.r(Token.GENEXPR);
                                    }
                                    s3 = s4;
                                    i++;
                                    s5 = s3;
                                    i4 = 3;
                                    break;
                                case 4:
                                    classFileWriter.Q(scriptNode.getRawSourceStart());
                                    classFileWriter.Q(scriptNode.getRawSourceEnd());
                                    classFileWriter.F(Token.TEMPLATE_LITERAL_SUBST, "java/lang/String", "substring", "(II)Ljava/lang/String;");
                                    classFileWriter.r(Token.GENEXPR);
                                    s3 = 1;
                                    i++;
                                    s5 = s3;
                                    i4 = 3;
                                    break;
                                case 5:
                                    int paramAndVarCount2 = scriptNode.getParamAndVarCount();
                                    boolean[] paramAndVarConst = scriptNode.getParamAndVarConst();
                                    if (paramAndVarCount2 == 0) {
                                        classFileWriter.r(i4);
                                        classFileWriter.r(i2);
                                    } else if (paramAndVarCount2 == s5) {
                                        classFileWriter.T(paramAndVarConst[0]);
                                        classFileWriter.r(i2);
                                    } else {
                                        classFileWriter.C(s5);
                                        int iW3 = classFileWriter.W(s5, paramAndVarCount2 - 1);
                                        int i6 = 0;
                                        while (i6 != paramAndVarCount2) {
                                            if (classFileWriter.o0() != 0) {
                                                Kit.codeBug();
                                            }
                                            if (i6 == 0) {
                                                classFileWriter.v0(iW3);
                                            } else {
                                                classFileWriter.u0(iW3, i6 - 1, 0);
                                            }
                                            classFileWriter.T(paramAndVarConst[i6]);
                                            classFileWriter.r(i2);
                                            i6++;
                                            s5 = 1;
                                        }
                                    }
                                    s3 = s5;
                                    i++;
                                    s5 = s3;
                                    i4 = 3;
                                    break;
                                case 6:
                                    if (scriptNode instanceof FunctionNode) {
                                        classFileWriter.T(((FunctionNode) scriptNode).isES6Generator());
                                    } else {
                                        classFileWriter.T(false);
                                    }
                                    classFileWriter.r(i2);
                                    s3 = s5;
                                    i++;
                                    s5 = s3;
                                    i4 = 3;
                                    break;
                                case 7:
                                    classFileWriter.T(scriptNode.hasRestParameter());
                                    classFileWriter.r(i2);
                                    s3 = s5;
                                    i++;
                                    s5 = s3;
                                    i4 = 3;
                                    break;
                                case 8:
                                    if (scriptNode instanceof FunctionNode) {
                                        classFileWriter.T(scriptNode.getDefaultParams() != null ? s5 : false);
                                    } else {
                                        classFileWriter.T(false);
                                    }
                                    classFileWriter.r(i2);
                                    s3 = s5;
                                    i++;
                                    s5 = s3;
                                    i4 = 3;
                                    break;
                                default:
                                    throw Kit.codeBug();
                            }
                        }
                        s2 = s5;
                        classFileWriter.H0(s);
                        break;
                    case 1:
                        classFileWriter.G0("getParamCount", "()I", s5);
                        s = s5;
                        length = this.scriptOrFnNodes.length;
                        if (length > s5) {
                        }
                        i = 0;
                        int iO02 = 0;
                        while (i != length) {
                        }
                        s2 = s5;
                        classFileWriter.H0(s);
                        break;
                    case 2:
                        classFileWriter.G0("getParamAndVarCount", "()I", s5);
                        s = s5;
                        length = this.scriptOrFnNodes.length;
                        if (length > s5) {
                        }
                        i = 0;
                        int iO022 = 0;
                        while (i != length) {
                        }
                        s2 = s5;
                        classFileWriter.H0(s);
                        break;
                    case 3:
                        classFileWriter.G0("getParamOrVarName", "(I)Ljava/lang/String;", s5);
                        s = 2;
                        length = this.scriptOrFnNodes.length;
                        if (length > s5) {
                        }
                        i = 0;
                        int iO0222 = 0;
                        while (i != length) {
                        }
                        s2 = s5;
                        classFileWriter.H0(s);
                        break;
                    case 4:
                        classFileWriter.G0("getRawSource", "()Ljava/lang/String;", s5);
                        classFileWriter.S(str);
                        s = s5;
                        length = this.scriptOrFnNodes.length;
                        if (length > s5) {
                        }
                        i = 0;
                        int iO02222 = 0;
                        while (i != length) {
                        }
                        s2 = s5;
                        classFileWriter.H0(s);
                        break;
                    case 5:
                        classFileWriter.G0("getParamOrVarConst", "(I)Z", s5);
                        s = 3;
                        length = this.scriptOrFnNodes.length;
                        if (length > s5) {
                        }
                        i = 0;
                        int iO022222 = 0;
                        while (i != length) {
                        }
                        s2 = s5;
                        classFileWriter.H0(s);
                        break;
                    case 6:
                        classFileWriter.G0("isGeneratorFunction", "()Z", (short) 4);
                        s = s5;
                        length = this.scriptOrFnNodes.length;
                        if (length > s5) {
                        }
                        i = 0;
                        int iO0222222 = 0;
                        while (i != length) {
                        }
                        s2 = s5;
                        classFileWriter.H0(s);
                        break;
                    case 7:
                        classFileWriter.G0("hasRestParameter", "()Z", s5);
                        s = s5;
                        length = this.scriptOrFnNodes.length;
                        if (length > s5) {
                        }
                        i = 0;
                        int iO02222222 = 0;
                        while (i != length) {
                        }
                        s2 = s5;
                        classFileWriter.H0(s);
                        break;
                    case 8:
                        classFileWriter.G0("hasDefaultParameters", "()Z", s5);
                        s = s5;
                        length = this.scriptOrFnNodes.length;
                        if (length > s5) {
                        }
                        i = 0;
                        int iO022222222 = 0;
                        while (i != length) {
                        }
                        s2 = s5;
                        classFileWriter.H0(s);
                        break;
                    default:
                        throw Kit.codeBug();
                }
            }
            i3++;
            s5 = s2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void generateResumeGenerator(ClassFileWriter classFileWriter) {
        int i = 0;
        boolean z = false;
        for (ScriptNode scriptNode : this.scriptOrFnNodes) {
            if (isGenerator(scriptNode)) {
                z = true;
            }
        }
        if (!z) {
            return;
        }
        classFileWriter.G0("resumeGenerator", "(Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;ILjava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", (short) 17);
        classFileWriter.v(0);
        classFileWriter.v(1);
        classFileWriter.v(2);
        classFileWriter.v(4);
        classFileWriter.v(5);
        classFileWriter.C(3);
        classFileWriter.O();
        classFileWriter.u(180, classFileWriter.k0(), ID_FIELD_NAME, "I");
        int iW = classFileWriter.W(0, this.scriptOrFnNodes.length - 1);
        classFileWriter.v0(iW);
        int iQ = classFileWriter.q();
        while (true) {
            ScriptNode[] scriptNodeArr = this.scriptOrFnNodes;
            if (i >= scriptNodeArr.length) {
                classFileWriter.r0(iQ);
                pushUndefined(classFileWriter);
                classFileWriter.r(Token.GENEXPR);
                classFileWriter.H0(6);
                return;
            }
            ScriptNode scriptNode2 = scriptNodeArr[i];
            classFileWriter.u0(iW, i, 6);
            if (isGenerator(scriptNode2)) {
                classFileWriter.F(Token.DOTDOTDOT, this.mainClassName, getBodyMethodName(scriptNode2) + "_gen", "(" + this.mainClassSignature + "Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;Ljava/lang/Object;I)Ljava/lang/Object;");
                classFileWriter.r(Token.GENEXPR);
            } else {
                classFileWriter.s(Token.LET, iQ);
            }
            i++;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void generateScriptCtor(ClassFileWriter classFileWriter) {
        classFileWriter.G0("<init>", TEMPLATE_LITERAL_INIT_METHOD_SIGNATURE, (short) 1);
        classFileWriter.O();
        classFileWriter.F(Token.TAGGED_TEMPLATE_LITERAL, SUPER_CLASS_NAME, "<init>", TEMPLATE_LITERAL_INIT_METHOD_SIGNATURE);
        classFileWriter.O();
        classFileWriter.Q(0);
        classFileWriter.u(Token.TEMPLATE_CHARS, classFileWriter.k0(), ID_FIELD_NAME, "I");
        classFileWriter.r(Token.METHOD);
        classFileWriter.H0(1);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String getStaticConstantWrapperType(double d) {
        return ((double) ((int) d)) == d ? "Ljava/lang/Integer;" : "Ljava/lang/Double;";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void initOptFunctions_r(ScriptNode scriptNode) {
        int functionCount = scriptNode.getFunctionCount();
        for (int i = 0; i != functionCount; i++) {
            FunctionNode functionNode = scriptNode.getFunctionNode(i);
            new OptFunctionNode(functionNode);
            initOptFunctions_r(functionNode);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void initScriptNodesData(ScriptNode scriptNode) {
        ArrayList arrayList = new ArrayList();
        collectScriptNodes_r(scriptNode, arrayList);
        int size = arrayList.size();
        ScriptNode[] scriptNodeArr = new ScriptNode[size];
        this.scriptOrFnNodes = scriptNodeArr;
        arrayList.toArray(scriptNodeArr);
        this.scriptOrFnIndexes = new HashMap<>();
        for (int i = 0; i != size; i++) {
            this.scriptOrFnIndexes.put(this.scriptOrFnNodes[i], Integer.valueOf(i));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean isGenerator(ScriptNode scriptNode) {
        return scriptNode.getType() == 122 && ((FunctionNode) scriptNode).isGenerator();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void pushUndefined(ClassFileWriter classFileWriter) {
        classFileWriter.u(Token.ARROW, "org/mozilla/javascript/Undefined", "instance", "Ljava/lang/Object;");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void transform(ScriptNode scriptNode) {
        initOptFunctions_r(scriptNode);
        boolean zIsInterpretedMode = this.compilerEnv.isInterpretedMode();
        HashMap map = null;
        if (!zIsInterpretedMode && scriptNode.getType() == 150) {
            int functionCount = scriptNode.getFunctionCount();
            for (int i = 0; i != functionCount; i++) {
                OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode, i);
                if (optFunctionNode.fnode.getFunctionType() == 1) {
                    String name = optFunctionNode.fnode.getName();
                    if (name.length() != 0) {
                        if (map == null) {
                            map = new HashMap();
                        }
                        map.put(name, optFunctionNode);
                    }
                }
            }
        }
        if (map != null) {
            this.directCallTargets = new ArrayList();
        }
        new OptTransformer(map, this.directCallTargets).transform(scriptNode, this.compilerEnv);
        if (zIsInterpretedMode) {
            return;
        }
        new Optimizer().optimize(scriptNode);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Evaluator
    public void captureStackInfo(RhinoException rhinoException) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String cleanName(ScriptNode scriptNode) {
        if (!(scriptNode instanceof FunctionNode)) {
            return "script";
        }
        Name functionName = ((FunctionNode) scriptNode).getFunctionName();
        return functionName == null ? "anonymous" : functionName.getIdentifier();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Evaluator
    public Object compile(CompilerEnvirons compilerEnvirons, ScriptNode scriptNode, String str, boolean z) {
        int i;
        synchronized (globalLock) {
            i = globalSerialClassCounter + 1;
            globalSerialClassCounter = i;
        }
        String strReplaceAll = "c";
        if (scriptNode.getSourceName().length() > 0) {
            strReplaceAll = scriptNode.getSourceName().replaceAll("\\W", "_");
            if (!Character.isJavaIdentifierStart(strReplaceAll.charAt(0))) {
                strReplaceAll = "_".concat(strReplaceAll);
            }
        }
        String str2 = "org.mozilla.javascript.gen." + strReplaceAll + "_" + i;
        return new Object[]{str2, compileToClassFile(compilerEnvirons, str2, scriptNode, str, z)};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] compileToClassFile(CompilerEnvirons compilerEnvirons, String str, ScriptNode scriptNode, String str2, boolean z) {
        this.compilerEnv = compilerEnvirons;
        transform(scriptNode);
        if (z) {
            scriptNode = scriptNode.getFunctionNode(0);
        }
        initScriptNodesData(scriptNode);
        this.mainClassName = str;
        this.mainClassSignature = ClassFileWriter.e0(str);
        return generateCode(str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Evaluator
    public Function createFunctionObject(Context context, Scriptable scriptable, Object obj, Object obj2) {
        try {
            return (NativeFunction) defineClass(obj, obj2).getConstructors()[0].newInstance(scriptable, context, 0);
        } catch (Exception e) {
            throw new RuntimeException("Unable to instantiate compiled class:" + e.toString());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Evaluator
    public Script createScriptObject(Object obj, Object obj2) {
        try {
            return (Script) defineClass(obj, obj2).getDeclaredConstructor(null).newInstance(null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to instantiate compiled class:" + e.toString());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getBodyMethodName(ScriptNode scriptNode) {
        return "_c_" + cleanName(scriptNode) + "_" + getIndex(scriptNode);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getBodyMethodSignature(ScriptNode scriptNode) {
        StringBuilder sb = new StringBuilder("(");
        sb.append(this.mainClassSignature);
        sb.append("Lorg/mozilla/javascript/Context;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;");
        if (scriptNode.getType() == 122) {
            OptFunctionNode optFunctionNode = OptFunctionNode.get(scriptNode);
            if (optFunctionNode.isTargetOfDirectCall()) {
                int paramCount = optFunctionNode.fnode.getParamCount();
                for (int i = 0; i != paramCount; i++) {
                    sb.append("Ljava/lang/Object;D");
                }
            }
        }
        sb.append("[Ljava/lang/Object;)Ljava/lang/Object;");
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getCompiledRegexpName(ScriptNode scriptNode, int i) {
        return "_re" + getIndex(scriptNode) + "_" + i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getDirectCtorName(ScriptNode scriptNode) {
        return "_n" + getIndex(scriptNode);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getFunctionInitMethodName(OptFunctionNode optFunctionNode) {
        return "_i" + getIndex(optFunctionNode.fnode);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getIndex(ScriptNode scriptNode) {
        return this.scriptOrFnIndexes.get(scriptNode).intValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Evaluator
    public String getPatchedStack(RhinoException rhinoException, String str) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Evaluator
    public List<String> getScriptStack(RhinoException rhinoException) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Evaluator
    public String getSourcePositionFromStack(Context context, int[] iArr) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getTemplateLiteralName(ScriptNode scriptNode) {
        return "_q" + getIndex(scriptNode);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void pushNumberAsObject(ClassFileWriter classFileWriter, double d) {
        if (d == 0.0d) {
            if (1.0d / d > 0.0d) {
                classFileWriter.u(Token.ARROW, "org/mozilla/javascript/ScriptRuntime", "zeroObj", "Ljava/lang/Integer;");
                return;
            } else {
                classFileWriter.P(d);
                addDoubleWrap(classFileWriter);
                return;
            }
        }
        if (d == 1.0d) {
            classFileWriter.u(Token.ARROW, "org/mozilla/javascript/optimizer/OptRuntime", "oneObj", "Ljava/lang/Integer;");
            return;
        }
        if (d == -1.0d) {
            classFileWriter.u(Token.ARROW, "org/mozilla/javascript/optimizer/OptRuntime", "minusOneObj", "Ljava/lang/Integer;");
            return;
        }
        if (Double.isNaN(d)) {
            classFileWriter.u(Token.ARROW, "org/mozilla/javascript/ScriptRuntime", "NaNobj", "Ljava/lang/Double;");
            return;
        }
        int i = this.itsConstantListSize;
        if (i >= 2000) {
            classFileWriter.P(d);
            addDoubleWrap(classFileWriter);
            return;
        }
        int i2 = 0;
        if (i == 0) {
            this.itsConstantList = new double[64];
        } else {
            double[] dArr = this.itsConstantList;
            int i3 = 0;
            while (i3 != i && dArr[i3] != d) {
                i3++;
            }
            if (i == dArr.length) {
                double[] dArr2 = new double[i * 2];
                System.arraycopy(this.itsConstantList, 0, dArr2, 0, i);
                this.itsConstantList = dArr2;
            }
            i2 = i3;
        }
        if (i2 == i) {
            this.itsConstantList[i] = d;
            this.itsConstantListSize = i + 1;
        }
        classFileWriter.u(Token.ARROW, this.mainClassName, "_k" + i2, getStaticConstantWrapperType(d));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.Evaluator
    public void setEvalScriptFlag(Script script) {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setMainMethodClass(String str) {
        this.mainMethodClass = str;
    }
}
