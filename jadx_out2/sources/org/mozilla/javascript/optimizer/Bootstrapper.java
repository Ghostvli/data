package org.mozilla.javascript.optimizer;

import com.chaquo.python.internal.Common;
import defpackage.cl;
import java.lang.invoke.CallSite;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.Arrays;
import java.util.regex.Pattern;
import jdk.dynalink.CallSiteDescriptor;
import jdk.dynalink.DynamicLinker;
import jdk.dynalink.DynamicLinkerFactory;
import jdk.dynalink.Operation;
import jdk.dynalink.StandardNamespace;
import jdk.dynalink.StandardOperation;
import jdk.dynalink.linker.GuardingDynamicLinker;
import jdk.dynalink.linker.support.CompositeTypeBasedGuardingDynamicLinker;
import jdk.dynalink.support.ChainedCallSite;
import org.mozilla.classfile.ClassFileWriter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Bootstrapper {
    private static final DynamicLinker linker;
    private static final Pattern SEPARATOR = Pattern.compile(":");
    public static final ClassFileWriter.c BOOTSTRAP_HANDLE = new ClassFileWriter.c((byte) 6, "org.mozilla.javascript.optimizer.Bootstrapper", Common.ASSET_BOOTSTRAP, "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        DynamicLinkerFactory dynamicLinkerFactory = new DynamicLinkerFactory();
        dynamicLinkerFactory.setPrioritizedLinkers(new GuardingDynamicLinker[]{new CompositeTypeBasedGuardingDynamicLinker(Arrays.asList(new ConstAwareLinker(), new BooleanLinker(), new IntegerLinker(), new DoubleLinker(), new StringLinker(), new ConsStringLinker(), new NativeArrayLinker(), new BaseFunctionLinker())), new DefaultLinker()});
        linker = dynamicLinkerFactory.createLinker();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static CallSite bootstrap(MethodHandles.Lookup lookup, String str, MethodType methodType) throws NoSuchMethodException {
        return cl.a(linker.link(new ChainedCallSite(new CallSiteDescriptor(lookup, parseOperation(str), methodType))));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static String getNameSegment(String[] strArr, String str, int i) {
        return i >= strArr.length ? "" : strArr[i].intern();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:6:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0198  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static Operation parseOperation(String str) throws NoSuchMethodException {
        String[] strArrSplit = SEPARATOR.split(str, -1);
        String nameSegment = getNameSegment(strArrSplit, str, 0);
        String nameSegment2 = getNameSegment(strArrSplit, str, 1);
        if ("PROP".equals(nameSegment)) {
            nameSegment2.getClass();
            switch (nameSegment2) {
                case "SETINDEX":
                    return RhinoOperation.SETINDEX.withNamespace(StandardNamespace.PROPERTY);
                case "SETSUPER":
                    return RhinoOperation.SETSUPER.withNamespace(StandardNamespace.PROPERTY).named(getNameSegment(strArrSplit, str, 2));
                case "GETELEMENT":
                    return RhinoOperation.GETELEMENT.withNamespace(StandardNamespace.PROPERTY);
                case "GETINDEX":
                    return RhinoOperation.GETINDEX.withNamespace(StandardNamespace.PROPERTY);
                case "GETSUPER":
                    return RhinoOperation.GETSUPER.withNamespace(StandardNamespace.PROPERTY).named(getNameSegment(strArrSplit, str, 2));
                case "SETELEMENTSUPER":
                    return RhinoOperation.SETELEMENTSUPER.withNamespace(StandardNamespace.PROPERTY);
                case "GETWITHTHIS":
                    return RhinoOperation.GETWITHTHIS.withNamespace(StandardNamespace.PROPERTY).named(getNameSegment(strArrSplit, str, 2));
                case "GET":
                    return StandardOperation.GET.withNamespace(StandardNamespace.PROPERTY).named(getNameSegment(strArrSplit, str, 2));
                case "SET":
                    return StandardOperation.SET.withNamespace(StandardNamespace.PROPERTY).named(getNameSegment(strArrSplit, str, 2));
                case "GETNOWARN":
                    return RhinoOperation.GETNOWARN.withNamespace(StandardNamespace.PROPERTY).named(getNameSegment(strArrSplit, str, 2));
                case "SETELEMENT":
                    return RhinoOperation.SETELEMENT.withNamespace(StandardNamespace.PROPERTY);
                case "GETWITHTHISOPTIONAL":
                    return RhinoOperation.GETWITHTHISOPTIONAL.withNamespace(StandardNamespace.PROPERTY).named(getNameSegment(strArrSplit, str, 2));
                case "GETELEMENTSUPER":
                    return RhinoOperation.GETELEMENTSUPER.withNamespace(StandardNamespace.PROPERTY);
            }
        }
        if ("NAME".equals(nameSegment)) {
            nameSegment2.getClass();
            switch (nameSegment2) {
                case "SETCONST":
                    return RhinoOperation.SETCONST.withNamespace(RhinoNamespace.NAME).named(getNameSegment(strArrSplit, str, 2));
                case "GETWITHTHIS":
                    return RhinoOperation.GETWITHTHIS.withNamespace(RhinoNamespace.NAME).named(getNameSegment(strArrSplit, str, 2));
                case "SETSTRICT":
                    return RhinoOperation.SETSTRICT.withNamespace(RhinoNamespace.NAME).named(getNameSegment(strArrSplit, str, 2));
                case "GET":
                    return StandardOperation.GET.withNamespace(RhinoNamespace.NAME).named(getNameSegment(strArrSplit, str, 2));
                case "SET":
                    return StandardOperation.SET.withNamespace(RhinoNamespace.NAME).named(getNameSegment(strArrSplit, str, 2));
                case "BIND":
                    return RhinoOperation.BIND.withNamespace(RhinoNamespace.NAME).named(getNameSegment(strArrSplit, str, 2));
                case "GETWITHTHISOPTIONAL":
                    return RhinoOperation.GETWITHTHISOPTIONAL.withNamespace(RhinoNamespace.NAME).named(getNameSegment(strArrSplit, str, 2));
            }
        }
        if ("MATH".equals(nameSegment)) {
            nameSegment2.getClass();
            switch (nameSegment2) {
                case "TOBOOLEAN":
                    return RhinoOperation.TOBOOLEAN.withNamespace(RhinoNamespace.MATH);
                case "TOINT32":
                    return RhinoOperation.TOINT32.withNamespace(RhinoNamespace.MATH);
                case "TONUMBER":
                    return RhinoOperation.TONUMBER.withNamespace(RhinoNamespace.MATH);
                case "TOUINT32":
                    return RhinoOperation.TOUINT32.withNamespace(RhinoNamespace.MATH);
                case "EQ":
                    return RhinoOperation.EQ.withNamespace(RhinoNamespace.MATH);
                case "ADD":
                    return RhinoOperation.ADD.withNamespace(RhinoNamespace.MATH);
                case "SHALLOWEQ":
                    return RhinoOperation.SHALLOWEQ.withNamespace(RhinoNamespace.MATH);
                case "COMPAREGE":
                    return RhinoOperation.COMPARE_GE.withNamespace(RhinoNamespace.MATH);
                case "COMPAREGT":
                    return RhinoOperation.COMPARE_GT.withNamespace(RhinoNamespace.MATH);
                case "COMPARELE":
                    return RhinoOperation.COMPARE_LE.withNamespace(RhinoNamespace.MATH);
                case "COMPARELT":
                    return RhinoOperation.COMPARE_LT.withNamespace(RhinoNamespace.MATH);
                case "TONUMERIC":
                    return RhinoOperation.TONUMERIC.withNamespace(RhinoNamespace.MATH);
            }
        }
        throw new NoSuchMethodException(str);
    }
}
