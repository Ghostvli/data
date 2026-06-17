package org.mozilla.javascript;

import com.thegrizzlylabs.sardineandroid.DavPrincipal;
import defpackage.zt2;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.security.CodeSource;
import java.security.ProtectionDomain;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.mozilla.classfile.ClassFileWriter;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.JavaAdapter;
import org.mozilla.javascript.optimizer.Signatures;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class JavaAdapter implements IdFunctionCall {
    private static final Object FTAG = "JavaAdapter";
    private static final int Id_JavaAdapter = 1;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class JavaAdapterSignature {
        Class<?>[] interfaces;
        Map<String, Integer> names;
        Class<?> superClass;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public JavaAdapterSignature(Class<?> cls, Class<?>[] clsArr, Map<String, Integer> map) {
            this.superClass = cls;
            this.interfaces = clsArr;
            this.names = map;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean equals(Object obj) {
            if (!(obj instanceof JavaAdapterSignature)) {
                return false;
            }
            JavaAdapterSignature javaAdapterSignature = (JavaAdapterSignature) obj;
            if (this.superClass != javaAdapterSignature.superClass) {
                return false;
            }
            Class<?>[] clsArr = this.interfaces;
            Class<?>[] clsArr2 = javaAdapterSignature.interfaces;
            if (clsArr != clsArr2) {
                if (clsArr.length != clsArr2.length) {
                    return false;
                }
                int i = 0;
                while (true) {
                    Class<?>[] clsArr3 = this.interfaces;
                    if (i >= clsArr3.length) {
                        break;
                    }
                    if (clsArr3[i] != javaAdapterSignature.interfaces[i]) {
                        return false;
                    }
                    i++;
                }
            }
            if (this.names.size() != javaAdapterSignature.names.size()) {
                return false;
            }
            for (Map.Entry<String, Integer> entry : this.names.entrySet()) {
                String key = entry.getKey();
                int iIntValue = entry.getValue().intValue();
                if (iIntValue != javaAdapterSignature.names.getOrDefault(key, Integer.valueOf(iIntValue + 1)).intValue()) {
                    return false;
                }
            }
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int hashCode() {
            return this.names.size() ^ (this.superClass.hashCode() + Arrays.hashCode(this.interfaces));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ ScriptableObject a(Script script, Context context) {
        ScriptableObject global = ScriptRuntime.getGlobal(context);
        script.exec(context, global);
        return global;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int appendMethodSignature(Class<?>[] clsArr, Class<?> cls, StringBuilder sb) {
        sb.append('(');
        int length = clsArr.length + 1;
        for (Class<?> cls2 : clsArr) {
            appendTypeString(sb, cls2);
            if (cls2 == Long.TYPE || cls2 == Double.TYPE) {
                length++;
            }
        }
        sb.append(')');
        appendTypeString(sb, cls);
        return length;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void appendOverridableMethods(Class<?> cls, List<Method> list, Set<String> set) {
        for (Method method : cls.isInterface() ? cls.getMethods() : cls.getDeclaredMethods()) {
            String str = method.getName() + getMethodSignature(method, method.getParameterTypes());
            if (!set.contains(str)) {
                int modifiers = method.getModifiers();
                if (!Modifier.isStatic(modifiers)) {
                    if (Modifier.isFinal(modifiers)) {
                        set.add(str);
                    } else if (Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers)) {
                        list.add(method);
                        set.add(str);
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static StringBuilder appendTypeString(StringBuilder sb, Class<?> cls) {
        while (cls.isArray()) {
            sb.append('[');
            cls = cls.getComponentType();
        }
        if (cls.isPrimitive()) {
            sb.append(cls == Boolean.TYPE ? 'Z' : cls == Long.TYPE ? 'J' : Character.toUpperCase(cls.getName().charAt(0)));
            return sb;
        }
        sb.append('L');
        sb.append(cls.getName().replace('.', '/'));
        sb.append(';');
        return sb;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object callMethod(ContextFactory contextFactory, final Scriptable scriptable, final Function function, final Object[] objArr, final long j) {
        if (function == null) {
            return null;
        }
        if (contextFactory == null) {
            contextFactory = ContextFactory.getGlobal();
        }
        final Scriptable parentScope = function.getParentScope();
        if (j == 0) {
            return Context.call(contextFactory, function, parentScope, scriptable, objArr);
        }
        Context currentContext = Context.getCurrentContext();
        return currentContext != null ? doCall(currentContext, parentScope, scriptable, function, objArr, j) : contextFactory.call(new ContextAction() { // from class: ym1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.ContextAction
            public final Object run(Context context) {
                return JavaAdapter.doCall(context, parentScope, scriptable, function, objArr, j);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object convertResult(Object obj, Class<?> cls) {
        if (obj != Undefined.instance || cls == ScriptRuntime.ObjectClass || cls == ScriptRuntime.StringClass) {
            return Context.jsToJava(obj, cls);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0140  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static byte[] createAdapterCode(Map<String, Integer> map, String str, Class<?> cls, Class<?>[] clsArr, String str2) {
        String str3;
        int i;
        ClassFileWriter classFileWriter;
        int i2;
        String str4;
        Map<String, Integer> map2 = map;
        Class<?>[] clsArr2 = clsArr;
        int i3 = 0;
        ClassFileWriter classFileWriter2 = new ClassFileWriter(str, cls.getName(), "<adapter>");
        classFileWriter2.B("factory", "Lorg/mozilla/javascript/ContextFactory;", (short) 17);
        classFileWriter2.B("delegee", "Lorg/mozilla/javascript/Scriptable;", (short) 17);
        classFileWriter2.B(DavPrincipal.KEY_SELF, "Lorg/mozilla/javascript/Scriptable;", (short) 17);
        int length = clsArr2 == null ? 0 : clsArr2.length;
        for (int i4 = 0; i4 < length; i4++) {
            Class<?> cls2 = clsArr2[i4];
            if (cls2 != null) {
                classFileWriter2.E(cls2.getName());
            }
        }
        String strReplace = cls.getName().replace('.', '/');
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            int modifiers = constructor.getModifiers();
            if (Modifier.isPublic(modifiers) || Modifier.isProtected(modifiers)) {
                generateCtor(classFileWriter2, str, strReplace, constructor);
            }
        }
        generateSerialCtor(classFileWriter2, str, strReplace);
        if (str2 != null) {
            generateEmptyCtor(classFileWriter2, str, strReplace, str2);
        }
        HashMap map3 = new HashMap();
        HashMap map4 = new HashMap();
        int i5 = 0;
        while (i5 < length) {
            Method[] methods = clsArr2[i5].getMethods();
            int length2 = methods.length;
            int i6 = i3;
            while (i6 < length2) {
                Method method = methods[i6];
                int modifiers2 = method.getModifiers();
                if (Modifier.isStatic(modifiers2) || Modifier.isFinal(modifiers2) || method.isDefault()) {
                    i = length2;
                    classFileWriter = classFileWriter2;
                    i2 = i6;
                } else {
                    int i7 = length2;
                    classFileWriter = classFileWriter2;
                    String name = method.getName();
                    int i8 = i6;
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (!map2.containsKey(name)) {
                        try {
                            cls.getMethod(name, parameterTypes);
                        } catch (NoSuchMethodException unused) {
                            str4 = name + getMethodSignature(method, parameterTypes);
                            if (map3.containsKey(str4)) {
                            }
                        }
                        i2 = i8;
                        i = i7;
                    }
                    str4 = name + getMethodSignature(method, parameterTypes);
                    if (map3.containsKey(str4)) {
                        i2 = i8;
                        classFileWriter = classFileWriter;
                        i = i7;
                        generateMethod(classFileWriter, str, name, parameterTypes, method.getReturnType(), true);
                        map3.put(str4, 0);
                        map4.put(name, 0);
                    } else {
                        classFileWriter = classFileWriter;
                        i2 = i8;
                        i = i7;
                    }
                }
                i6 = i2 + 1;
                classFileWriter2 = classFileWriter;
                length2 = i;
            }
            i5++;
            clsArr2 = clsArr;
            i3 = 0;
        }
        ClassFileWriter classFileWriter3 = classFileWriter2;
        Method[] overridableMethods = getOverridableMethods(cls);
        int length3 = overridableMethods.length;
        int i9 = 0;
        while (i9 < length3) {
            Method method2 = overridableMethods[i9];
            boolean zIsAbstract = Modifier.isAbstract(method2.getModifiers());
            String name2 = method2.getName();
            if (zIsAbstract || map2.containsKey(name2)) {
                Class<?>[] parameterTypes2 = method2.getParameterTypes();
                String methodSignature = getMethodSignature(method2, parameterTypes2);
                String str5 = name2 + methodSignature;
                if (!map3.containsKey(str5)) {
                    generateMethod(classFileWriter3, str, name2, parameterTypes2, method2.getReturnType(), true);
                    map3.put(str5, 0);
                    map4.put(name2, 0);
                    if (zIsAbstract) {
                        str3 = strReplace;
                    } else {
                        str3 = strReplace;
                        generateSuper(classFileWriter3, str, str3, name2, methodSignature, parameterTypes2, method2.getReturnType());
                    }
                }
            }
            i9++;
            map2 = map;
            strReplace = str3;
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            if (!map4.containsKey(key)) {
                int iIntValue = entry.getValue().intValue();
                Class[] clsArr3 = new Class[iIntValue];
                for (int i10 = 0; i10 < iIntValue; i10++) {
                    clsArr3[i10] = ScriptRuntime.ObjectClass;
                }
                ClassFileWriter classFileWriter4 = classFileWriter3;
                generateMethod(classFileWriter4, str, key, clsArr3, ScriptRuntime.ObjectClass, false);
                classFileWriter3 = classFileWriter4;
            }
        }
        return classFileWriter3.I0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Scriptable createAdapterWrapper(Scriptable scriptable, Object obj) {
        NativeJavaObject nativeJavaObject = new NativeJavaObject(ScriptableObject.getTopLevelScope(scriptable), obj, null, true);
        nativeJavaObject.setPrototype(scriptable);
        return nativeJavaObject;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public static Object doCall(Context context, Scriptable scriptable, Scriptable scriptable2, Function function, Object[] objArr, long j) {
        for (int i = 0; i != objArr.length; i++) {
            if (0 != (((long) (1 << i)) & j)) {
                Object obj = objArr[i];
                if (!(obj instanceof Scriptable)) {
                    objArr[i] = context.getWrapFactory().wrap(context, scriptable, obj, null);
                }
            }
        }
        return function.call(context, scriptable, scriptable2, objArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void generateCtor(ClassFileWriter classFileWriter, String str, String str2, Constructor<?> constructor) {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int iGeneratePushParam = 3;
        if (parameterTypes.length == 0) {
            classFileWriter.G0("<init>", "(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/ContextFactory;)V", (short) 1);
            classFileWriter.r(42);
            classFileWriter.F(Token.TAGGED_TEMPLATE_LITERAL, str2, "<init>", "()V");
        } else {
            StringBuilder sb = new StringBuilder("(Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/ContextFactory;");
            int length = sb.length();
            for (Class<?> cls : parameterTypes) {
                appendTypeString(sb, cls);
            }
            sb.append(")V");
            classFileWriter.G0("<init>", sb.toString(), (short) 1);
            classFileWriter.r(42);
            for (Class<?> cls2 : parameterTypes) {
                iGeneratePushParam += generatePushParam(classFileWriter, iGeneratePushParam, cls2);
            }
            sb.delete(1, length);
            classFileWriter.F(Token.TAGGED_TEMPLATE_LITERAL, str2, "<init>", sb.toString());
        }
        classFileWriter.r(42);
        classFileWriter.r(43);
        classFileWriter.u(Token.TEMPLATE_CHARS, str, "delegee", "Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.r(42);
        classFileWriter.r(44);
        classFileWriter.u(Token.TEMPLATE_CHARS, str, "factory", "Lorg/mozilla/javascript/ContextFactory;");
        classFileWriter.r(42);
        classFileWriter.r(43);
        classFileWriter.r(42);
        classFileWriter.F(Token.DOTDOTDOT, "org/mozilla/javascript/JavaAdapter", "createAdapterWrapper", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.u(Token.TEMPLATE_CHARS, str, DavPrincipal.KEY_SELF, "Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.r(Token.METHOD);
        classFileWriter.H0(iGeneratePushParam);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void generateEmptyCtor(ClassFileWriter classFileWriter, String str, String str2, String str3) {
        classFileWriter.G0("<init>", "()V", (short) 1);
        classFileWriter.r(42);
        classFileWriter.F(Token.TAGGED_TEMPLATE_LITERAL, str2, "<init>", "()V");
        classFileWriter.r(42);
        classFileWriter.r(1);
        classFileWriter.u(Token.TEMPLATE_CHARS, str, "factory", "Lorg/mozilla/javascript/ContextFactory;");
        classFileWriter.t(Token.LAST_TOKEN, str3);
        classFileWriter.r(89);
        classFileWriter.F(Token.TAGGED_TEMPLATE_LITERAL, str3, "<init>", "()V");
        classFileWriter.F(Token.DOTDOTDOT, "org/mozilla/javascript/JavaAdapter", "runScript", "(Lorg/mozilla/javascript/Script;)Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.r(76);
        classFileWriter.r(42);
        classFileWriter.r(43);
        classFileWriter.u(Token.TEMPLATE_CHARS, str, "delegee", "Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.r(42);
        classFileWriter.r(43);
        classFileWriter.r(42);
        classFileWriter.F(Token.DOTDOTDOT, "org/mozilla/javascript/JavaAdapter", "createAdapterWrapper", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/Object;)Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.u(Token.TEMPLATE_CHARS, str, DavPrincipal.KEY_SELF, "Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.r(Token.METHOD);
        classFileWriter.H0(2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void generateMethod(ClassFileWriter classFileWriter, String str, String str2, Class<?>[] clsArr, Class<?> cls, boolean z) {
        StringBuilder sb = new StringBuilder();
        int iAppendMethodSignature = appendMethodSignature(clsArr, cls, sb);
        classFileWriter.G0(str2, sb.toString(), (short) 1);
        classFileWriter.r(42);
        classFileWriter.u(180, str, "factory", "Lorg/mozilla/javascript/ContextFactory;");
        classFileWriter.r(42);
        classFileWriter.u(180, str, DavPrincipal.KEY_SELF, "Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.r(42);
        classFileWriter.u(180, str, "delegee", "Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.S(str2);
        classFileWriter.F(Token.DOTDOTDOT, "org/mozilla/javascript/JavaAdapter", "getFunction", "(Lorg/mozilla/javascript/Scriptable;Ljava/lang/String;)Lorg/mozilla/javascript/Function;");
        generatePushWrappedArgs(classFileWriter, clsArr, clsArr.length);
        if (clsArr.length > 64) {
            throw Context.reportRuntimeErrorById("JavaAdapter can not subclass methods with more then 64 arguments.", new Object[0]);
        }
        long j = 0;
        for (int i = 0; i != clsArr.length; i++) {
            if (!clsArr[i].isPrimitive()) {
                j |= (long) (1 << i);
            }
        }
        classFileWriter.R(j);
        classFileWriter.F(Token.DOTDOTDOT, "org/mozilla/javascript/JavaAdapter", "callMethod", "(Lorg/mozilla/javascript/ContextFactory;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Function;[Ljava/lang/Object;J)Ljava/lang/Object;");
        generateReturnResult(classFileWriter, cls, z);
        classFileWriter.H0((short) iAppendMethodSignature);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void generatePopResult(ClassFileWriter classFileWriter, Class<?> cls) {
        if (!cls.isPrimitive()) {
            classFileWriter.r(Token.GENEXPR);
            return;
        }
        char cCharAt = cls.getName().charAt(0);
        if (cCharAt == 'f') {
            classFileWriter.r(Token.DEBUGGER);
            return;
        }
        if (cCharAt != 'i') {
            if (cCharAt == 'l') {
                classFileWriter.r(Token.WITHEXPR);
                return;
            } else if (cCharAt != 's' && cCharAt != 'z') {
                switch (cCharAt) {
                    case 'd':
                        classFileWriter.r(Token.COMMENT);
                        break;
                }
                return;
            }
        }
        classFileWriter.r(Token.LETEXPR);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static int generatePushParam(ClassFileWriter classFileWriter, int i, Class<?> cls) {
        if (!cls.isPrimitive()) {
            classFileWriter.v(i);
            return 1;
        }
        char cCharAt = cls.getName().charAt(0);
        if (cCharAt == 'f') {
            classFileWriter.A(i);
            return 1;
        }
        if (cCharAt != 'i') {
            if (cCharAt == 'l') {
                classFileWriter.H(i);
                return 2;
            }
            if (cCharAt != 's' && cCharAt != 'z') {
                switch (cCharAt) {
                    case Token.COMMA /* 98 */:
                    case 'c':
                        break;
                    case 'd':
                        classFileWriter.x(i);
                        return 2;
                    default:
                        throw Kit.codeBug();
                }
            }
        }
        classFileWriter.C(i);
        return 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void generatePushWrappedArgs(ClassFileWriter classFileWriter, Class<?>[] clsArr, int i) {
        classFileWriter.Q(i);
        classFileWriter.t(189, "java/lang/Object");
        int iGenerateWrapArg = 1;
        for (int i2 = 0; i2 != clsArr.length; i2++) {
            classFileWriter.r(89);
            classFileWriter.Q(i2);
            iGenerateWrapArg += generateWrapArg(classFileWriter, iGenerateWrapArg, clsArr[i2]);
            classFileWriter.r(83);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void generateReturnResult(ClassFileWriter classFileWriter, Class<?> cls, boolean z) {
        if (cls == Void.TYPE) {
            classFileWriter.r(87);
            classFileWriter.r(Token.METHOD);
            return;
        }
        if (cls == Boolean.TYPE) {
            classFileWriter.F(Token.DOTDOTDOT, "org/mozilla/javascript/Context", "toBoolean", Signatures.MATH_TO_BOOLEAN);
            classFileWriter.r(Token.LETEXPR);
            return;
        }
        if (cls == Character.TYPE) {
            classFileWriter.F(Token.DOTDOTDOT, "org/mozilla/javascript/Context", "toString", "(Ljava/lang/Object;)Ljava/lang/String;");
            classFileWriter.r(3);
            classFileWriter.F(Token.TEMPLATE_LITERAL_SUBST, "java/lang/String", "charAt", "(I)C");
            classFileWriter.r(Token.LETEXPR);
            return;
        }
        if (!cls.isPrimitive()) {
            String name = cls.getName();
            if (z) {
                classFileWriter.N(name);
                classFileWriter.F(Token.DOTDOTDOT, "java/lang/Class", "forName", "(Ljava/lang/String;)Ljava/lang/Class;");
                classFileWriter.F(Token.DOTDOTDOT, "org/mozilla/javascript/JavaAdapter", "convertResult", "(Ljava/lang/Object;Ljava/lang/Class;)Ljava/lang/Object;");
            }
            classFileWriter.t(192, name);
            classFileWriter.r(Token.GENEXPR);
            return;
        }
        classFileWriter.F(Token.DOTDOTDOT, "org/mozilla/javascript/Context", "toNumber", Signatures.MATH_TO_NUMBER);
        char cCharAt = cls.getName().charAt(0);
        if (cCharAt != 'b') {
            if (cCharAt == 'd') {
                classFileWriter.r(Token.COMMENT);
                return;
            }
            if (cCharAt == 'f') {
                classFileWriter.r(Token.LABEL);
                classFileWriter.r(Token.DEBUGGER);
                return;
            } else if (cCharAt != 'i') {
                if (cCharAt == 'l') {
                    classFileWriter.r(Token.BLOCK);
                    classFileWriter.r(Token.WITHEXPR);
                    return;
                } else if (cCharAt != 's') {
                    zt2.a("Unexpected return type ".concat(String.valueOf(cls)));
                    return;
                }
            }
        }
        classFileWriter.r(Token.COMPUTED_PROPERTY);
        classFileWriter.r(Token.LETEXPR);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void generateSerialCtor(ClassFileWriter classFileWriter, String str, String str2) {
        classFileWriter.G0("<init>", "(Lorg/mozilla/javascript/ContextFactory;Lorg/mozilla/javascript/Scriptable;Lorg/mozilla/javascript/Scriptable;)V", (short) 1);
        classFileWriter.r(42);
        classFileWriter.F(Token.TAGGED_TEMPLATE_LITERAL, str2, "<init>", "()V");
        classFileWriter.r(42);
        classFileWriter.r(43);
        classFileWriter.u(Token.TEMPLATE_CHARS, str, "factory", "Lorg/mozilla/javascript/ContextFactory;");
        classFileWriter.r(42);
        classFileWriter.r(44);
        classFileWriter.u(Token.TEMPLATE_CHARS, str, "delegee", "Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.r(42);
        classFileWriter.r(45);
        classFileWriter.u(Token.TEMPLATE_CHARS, str, DavPrincipal.KEY_SELF, "Lorg/mozilla/javascript/Scriptable;");
        classFileWriter.r(Token.METHOD);
        classFileWriter.H0(4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static void generateSuper(ClassFileWriter classFileWriter, String str, String str2, String str3, String str4, Class<?>[] clsArr, Class<?> cls) {
        classFileWriter.G0("super$" + str3, str4, (short) 1);
        classFileWriter.s(25, 0);
        int iGeneratePushParam = 1;
        for (Class<?> cls2 : clsArr) {
            iGeneratePushParam += generatePushParam(classFileWriter, iGeneratePushParam, cls2);
        }
        classFileWriter.F(Token.TAGGED_TEMPLATE_LITERAL, str2, str3, str4);
        if (cls.equals(Void.TYPE)) {
            classFileWriter.r(Token.METHOD);
        } else {
            generatePopResult(classFileWriter, cls);
        }
        classFileWriter.H0((short) (iGeneratePushParam + 1));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int generateWrapArg(ClassFileWriter classFileWriter, int i, Class<?> cls) {
        int i2 = 1;
        if (!cls.isPrimitive()) {
            classFileWriter.s(25, i);
            return 1;
        }
        if (cls == Boolean.TYPE) {
            classFileWriter.t(Token.LAST_TOKEN, "java/lang/Boolean");
            classFileWriter.r(89);
            classFileWriter.s(21, i);
            classFileWriter.F(Token.TAGGED_TEMPLATE_LITERAL, "java/lang/Boolean", "<init>", "(Z)V");
            return 1;
        }
        if (cls == Character.TYPE) {
            classFileWriter.s(21, i);
            classFileWriter.F(Token.DOTDOTDOT, "java/lang/String", "valueOf", "(C)Ljava/lang/String;");
            return 1;
        }
        classFileWriter.t(Token.LAST_TOKEN, "java/lang/Double");
        classFileWriter.r(89);
        char cCharAt = cls.getName().charAt(0);
        if (cCharAt == 'b') {
            classFileWriter.s(21, i);
            classFileWriter.r(Token.VAR);
        } else {
            if (cCharAt == 'd') {
                classFileWriter.s(24, i);
            } else if (cCharAt == 'f') {
                classFileWriter.s(23, i);
                classFileWriter.r(Token.EMPTY);
            } else if (cCharAt != 'i') {
                if (cCharAt == 'l') {
                    classFileWriter.s(22, i);
                    classFileWriter.r(Token.FINALLY);
                } else if (cCharAt == 's') {
                }
            }
            i2 = 2;
        }
        classFileWriter.F(Token.TAGGED_TEMPLATE_LITERAL, "java/lang/Double", "<init>", "(D)V");
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Class<?> getAdapterClass(Scriptable scriptable, Class<?> cls, Class<?>[] clsArr, Scriptable scriptable2) {
        ClassCache classCache = ClassCache.get(scriptable);
        Map<JavaAdapterSignature, Class<?>> interfaceAdapterCacheMap = classCache.getInterfaceAdapterCacheMap();
        Map<String, Integer> objectFunctionNames = getObjectFunctionNames(scriptable2);
        JavaAdapterSignature javaAdapterSignature = new JavaAdapterSignature(cls, clsArr, objectFunctionNames);
        Class<?> cls2 = interfaceAdapterCacheMap.get(javaAdapterSignature);
        if (cls2 != null) {
            return cls2;
        }
        String str = "adapter" + classCache.newClassSerialNumber();
        Class<?> clsLoadAdapterClass = loadAdapterClass(str, createAdapterCode(objectFunctionNames, str, cls, clsArr, null));
        if (classCache.isCachingEnabled()) {
            interfaceAdapterCacheMap.put(javaAdapterSignature, clsLoadAdapterClass);
        }
        return clsLoadAdapterClass;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object getAdapterSelf(Class<?> cls, Object obj) {
        return cls.getDeclaredField(DavPrincipal.KEY_SELF).get(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int[] getArgsToConvert(Class<?>[] clsArr) {
        int i = 0;
        for (int i2 = 0; i2 != clsArr.length; i2++) {
            if (!clsArr[i2].isPrimitive()) {
                i++;
            }
        }
        if (i == 0) {
            return null;
        }
        int[] iArr = new int[i];
        int i3 = 0;
        for (int i4 = 0; i4 != clsArr.length; i4++) {
            if (!clsArr[i4].isPrimitive()) {
                iArr[i3] = i4;
                i3++;
            }
        }
        return iArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Function getFunction(Scriptable scriptable, String str) {
        Object property = ScriptableObject.getProperty(scriptable, str);
        if (property == Scriptable.NOT_FOUND) {
            return null;
        }
        if (property instanceof Function) {
            return (Function) property;
        }
        throw ScriptRuntime.notFunctionError(property, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String getMethodSignature(Method method, Class<?>[] clsArr) {
        StringBuilder sb = new StringBuilder();
        appendMethodSignature(clsArr, method.getReturnType(), sb);
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static Map<String, Integer> getObjectFunctionNames(Scriptable scriptable) {
        Object[] propertyIds = ScriptableObject.getPropertyIds(scriptable);
        HashMap map = new HashMap();
        for (int i = 0; i != propertyIds.length; i++) {
            Object obj = propertyIds[i];
            if (obj instanceof String) {
                String str = (String) obj;
                Object property = ScriptableObject.getProperty(scriptable, str);
                if (property instanceof Function) {
                    int int32 = ScriptRuntime.toInt32(ScriptableObject.getProperty((Function) property, Name.LENGTH));
                    if (int32 < 0) {
                        int32 = 0;
                    }
                    map.put(str, Integer.valueOf(int32));
                }
            }
        }
        return map;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Method[] getOverridableMethods(Class<?> cls) {
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            appendOverridableMethods(superclass, arrayList, hashSet);
        }
        while (true) {
            if (cls == null) {
                return (Method[]) arrayList.toArray(new Method[0]);
            }
            for (Class<?> cls2 : cls.getInterfaces()) {
                appendOverridableMethods(cls2, arrayList, hashSet);
            }
            cls = cls.getSuperclass();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void init(Context context, Scriptable scriptable, boolean z) {
        IdFunctionObject idFunctionObject = new IdFunctionObject(new JavaAdapter(), FTAG, 1, "JavaAdapter", 1, scriptable);
        idFunctionObject.markAsConstructor(null);
        if (z) {
            idFunctionObject.sealObject();
        }
        idFunctionObject.exportAsScopeProperty();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object js_createAdapter(Context context, Scriptable scriptable, Object[] objArr) {
        Object objNewInstance;
        int length = objArr.length;
        if (length == 0) {
            throw ScriptRuntime.typeErrorById("msg.adapter.zero.args", new Object[0]);
        }
        int i = 0;
        while (i < length - 1) {
            Object obj = objArr[i];
            if (obj instanceof NativeObject) {
                break;
            }
            if (!(obj instanceof NativeJavaClass)) {
                throw ScriptRuntime.typeErrorById("msg.not.java.class.arg", String.valueOf(i), ScriptRuntime.toString(obj));
            }
            i++;
        }
        Class[] clsArr = new Class[i];
        Class<?> cls = null;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            Class<?> classObject = ((NativeJavaClass) objArr[i3]).getClassObject();
            if (classObject.isInterface()) {
                clsArr[i2] = classObject;
                i2++;
            } else {
                if (cls != null) {
                    throw ScriptRuntime.typeErrorById("msg.only.one.super", cls.getName(), classObject.getName());
                }
                cls = classObject;
            }
        }
        if (cls == null) {
            cls = ScriptRuntime.ObjectClass;
        }
        Class[] clsArr2 = new Class[i2];
        System.arraycopy(clsArr, 0, clsArr2, 0, i2);
        Scriptable scriptableEnsureScriptable = ScriptableObject.ensureScriptable(objArr[i]);
        Class<?> adapterClass = getAdapterClass(scriptable, cls, clsArr2, scriptableEnsureScriptable);
        int i4 = length - i;
        int i5 = i4 - 1;
        try {
            if (i5 > 0) {
                Object[] objArr2 = new Object[i4 + 1];
                objArr2[0] = scriptableEnsureScriptable;
                objArr2[1] = context.getFactory();
                System.arraycopy(objArr, i + 1, objArr2, 2, i5);
                NativeJavaMethod nativeJavaMethod = new NativeJavaClass(scriptable, adapterClass, true).members.ctors;
                int iFindCachedFunction = nativeJavaMethod.findCachedFunction(context, objArr2);
                if (iFindCachedFunction < 0) {
                    throw Context.reportRuntimeErrorById("msg.no.java.ctor", adapterClass.getName(), NativeJavaMethod.scriptSignature(objArr));
                }
                objNewInstance = NativeJavaClass.constructInternal(objArr2, nativeJavaMethod.methods[iFindCachedFunction]);
            } else {
                objNewInstance = adapterClass.getConstructor(ScriptRuntime.ScriptableClass, ScriptRuntime.ContextFactoryClass).newInstance(scriptableEnsureScriptable, context.getFactory());
            }
            Object adapterSelf = getAdapterSelf(adapterClass, objNewInstance);
            if (adapterSelf instanceof Wrapper) {
                Object objUnwrap = ((Wrapper) adapterSelf).unwrap();
                if (objUnwrap instanceof Scriptable) {
                    if (objUnwrap instanceof ScriptableObject) {
                        ScriptRuntime.setObjectProtoAndParent((ScriptableObject) objUnwrap, scriptable);
                    }
                    return objUnwrap;
                }
            }
            return adapterSelf;
        } catch (Exception e) {
            throw Context.throwAsScriptRuntimeEx(e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:11:0x001c */
    /* JADX DEBUG: Multi-variable search result rejected for r3v1, resolved type: java.security.ProtectionDomain */
    /* JADX DEBUG: Multi-variable search result rejected for r3v2, resolved type: java.security.ProtectionDomain */
    /* JADX DEBUG: Multi-variable search result rejected for r3v5, resolved type: java.lang.Object */
    /* JADX DEBUG: Multi-variable search result rejected for r3v6, resolved type: java.security.ProtectionDomain */
    /* JADX DEBUG: Multi-variable search result rejected for r3v7, resolved type: java.security.ProtectionDomain */
    /* JADX DEBUG: Multi-variable search result rejected for r3v8, resolved type: java.security.ProtectionDomain */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x000e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Class<?> loadAdapterClass(String str, byte[] bArr) {
        ProtectionDomain codeSource;
        Class<?> staticSecurityDomainClass = SecurityController.getStaticSecurityDomainClass();
        if (staticSecurityDomainClass == CodeSource.class || staticSecurityDomainClass == ProtectionDomain.class) {
            ProtectionDomain scriptProtectionDomain = SecurityUtilities.getScriptProtectionDomain();
            codeSource = scriptProtectionDomain;
            if (scriptProtectionDomain == null) {
                codeSource = JavaAdapter.class.getProtectionDomain();
            }
            if (staticSecurityDomainClass == CodeSource.class) {
                codeSource = codeSource == 0 ? 0 : codeSource.getCodeSource();
            }
        }
        GeneratedClassLoader generatedClassLoaderCreateLoader = SecurityController.createLoader(null, codeSource);
        Class<?> clsDefineClass = generatedClassLoaderCreateLoader.defineClass(str, bArr);
        generatedClassLoaderCreateLoader.linkClass(clsDefineClass);
        return clsDefineClass;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object readAdapterObject(Scriptable scriptable, ObjectInputStream objectInputStream) throws ClassNotFoundException {
        Context currentContext = Context.getCurrentContext();
        ContextFactory factory = currentContext != null ? currentContext.getFactory() : null;
        Class<?> cls = Class.forName((String) objectInputStream.readObject());
        String[] strArr = (String[]) objectInputStream.readObject();
        Class[] clsArr = new Class[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            clsArr[i] = Class.forName(strArr[i]);
        }
        Scriptable scriptable2 = (Scriptable) objectInputStream.readObject();
        Class<?> adapterClass = getAdapterClass(scriptable, cls, clsArr, scriptable2);
        Class<?> cls2 = ScriptRuntime.ContextFactoryClass;
        Class<Scriptable> cls3 = ScriptRuntime.ScriptableClass;
        try {
            return adapterClass.getConstructor(cls2, cls3, cls3).newInstance(factory, scriptable2, scriptable);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
            throw new ClassNotFoundException("adapter");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Scriptable runScript(final Script script) {
        return (Scriptable) ContextFactory.getGlobal().call(new ContextAction() { // from class: zm1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.mozilla.javascript.ContextAction
            public final Object run(Context context) {
                return JavaAdapter.a(script, context);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void writeAdapterObject(Object obj, ObjectOutputStream objectOutputStream) throws IOException {
        Class<?> cls = obj.getClass();
        objectOutputStream.writeObject(cls.getSuperclass().getName());
        Class<?>[] interfaces = cls.getInterfaces();
        String[] strArr = new String[interfaces.length];
        for (int i = 0; i < interfaces.length; i++) {
            strArr[i] = interfaces[i].getName();
        }
        objectOutputStream.writeObject(strArr);
        try {
            objectOutputStream.writeObject(cls.getField("delegee").get(obj));
        } catch (IllegalAccessException | NoSuchFieldException unused) {
            throw new IOException();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.mozilla.javascript.IdFunctionCall
    public Object execIdCall(IdFunctionObject idFunctionObject, Context context, Scriptable scriptable, Scriptable scriptable2, Object[] objArr) {
        if (idFunctionObject.hasTag(FTAG) && idFunctionObject.methodId() == 1) {
            return js_createAdapter(context, scriptable, objArr);
        }
        throw idFunctionObject.unknown();
    }
}
