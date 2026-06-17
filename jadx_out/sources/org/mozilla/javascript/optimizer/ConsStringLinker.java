package org.mozilla.javascript.optimizer;

import jdk.dynalink.linker.TypeBasedGuardingDynamicLinker;
import org.mozilla.javascript.ConsString;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class ConsStringLinker implements TypeBasedGuardingDynamicLinker {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private static Object add(Object obj, Object obj2, Context context) {
        return new ConsString((ConsString) obj, ((CharSequence) obj2).toString());
    }

    private static Object getLength(Object obj, Context context, Scriptable scriptable) {
        return Integer.valueOf(((ConsString) obj).length());
    }

    private static boolean testAdd(Object obj, Object obj2, Context context) {
        return (obj instanceof ConsString) && (obj2 instanceof CharSequence);
    }

    public boolean canLinkType(Class<?> cls) {
        return ConsString.class.equals(cls);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0089  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public jdk.dynalink.linker.GuardedInvocation getGuardedInvocation(jdk.dynalink.linker.LinkRequest r5, jdk.dynalink.linker.LinkerServices r6) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException {
        /*
            r4 = this;
            boolean r4 = r5.isCallSiteUnstable()
            r6 = 0
            if (r4 == 0) goto L8
            return r6
        L8:
            java.lang.Object[] r4 = r5.getArguments()
            int r4 = r4.length
            r0 = 1
            if (r4 <= r0) goto L17
            java.lang.Object[] r4 = r5.getArguments()
            r4 = r4[r0]
            goto L18
        L17:
            r4 = r6
        L18:
            java.lang.invoke.MethodHandles$Lookup r0 = java.lang.invoke.MethodHandles.lookup()
            org.mozilla.javascript.optimizer.ParsedOperation r1 = new org.mozilla.javascript.optimizer.ParsedOperation
            jdk.dynalink.CallSiteDescriptor r2 = r5.getCallSiteDescriptor()
            jdk.dynalink.Operation r2 = r2.getOperation()
            r1.<init>(r2)
            jdk.dynalink.CallSiteDescriptor r5 = r5.getCallSiteDescriptor()
            java.lang.invoke.MethodType r5 = r5.getMethodType()
            org.mozilla.javascript.optimizer.RhinoNamespace r2 = org.mozilla.javascript.optimizer.RhinoNamespace.MATH
            boolean r2 = r1.isNamespace(r2)
            if (r2 == 0) goto L5c
            org.mozilla.javascript.optimizer.RhinoOperation r2 = org.mozilla.javascript.optimizer.RhinoOperation.ADD
            boolean r2 = r1.isOperation(r2)
            if (r2 == 0) goto L89
            java.lang.Class r2 = java.lang.Boolean.TYPE
            java.lang.invoke.MethodType r2 = r5.changeReturnType(r2)
            boolean r4 = r4 instanceof java.lang.CharSequence
            if (r4 == 0) goto L89
            java.lang.Class<org.mozilla.javascript.optimizer.ConsStringLinker> r4 = org.mozilla.javascript.optimizer.ConsStringLinker.class
            java.lang.String r3 = "add"
            java.lang.invoke.MethodHandle r4 = r0.findStatic(r4, r3, r5)
            java.lang.Class<org.mozilla.javascript.optimizer.ConsStringLinker> r5 = org.mozilla.javascript.optimizer.ConsStringLinker.class
            java.lang.String r3 = "testAdd"
            java.lang.invoke.MethodHandle r5 = r0.findStatic(r5, r3, r2)
            goto L8b
        L5c:
            jdk.dynalink.StandardNamespace r4 = jdk.dynalink.StandardNamespace.PROPERTY
            boolean r4 = r1.isNamespace(r4)
            if (r4 == 0) goto L89
            jdk.dynalink.StandardOperation r4 = jdk.dynalink.StandardOperation.GET
            org.mozilla.javascript.optimizer.RhinoOperation r2 = org.mozilla.javascript.optimizer.RhinoOperation.GETNOWARN
            boolean r4 = r1.isOperation(r4, r2)
            if (r4 == 0) goto L89
            java.lang.String r4 = "length"
            java.lang.String r2 = r1.getName()
            boolean r4 = r4.equals(r2)
            if (r4 == 0) goto L89
            java.lang.Class<org.mozilla.javascript.optimizer.ConsStringLinker> r4 = org.mozilla.javascript.optimizer.ConsStringLinker.class
            java.lang.String r2 = "getLength"
            java.lang.invoke.MethodHandle r4 = r0.findStatic(r4, r2, r5)
            java.lang.Class<org.mozilla.javascript.ConsString> r5 = org.mozilla.javascript.ConsString.class
            java.lang.invoke.MethodHandle r5 = jdk.dynalink.linker.support.Guards.getInstanceOfGuard(r5)
            goto L8b
        L89:
            r4 = r6
            r5 = r4
        L8b:
            if (r4 == 0) goto La5
            boolean r6 = org.mozilla.javascript.optimizer.DefaultLinker.DEBUG
            if (r6 == 0) goto La0
            java.io.PrintStream r6 = java.lang.System.out
            java.lang.String r0 = java.lang.String.valueOf(r1)
            java.lang.String r1 = " ConsString operation"
            java.lang.String r0 = r0.concat(r1)
            r6.println(r0)
        La0:
            jdk.dynalink.linker.GuardedInvocation r6 = new jdk.dynalink.linker.GuardedInvocation
            r6.<init>(r4, r5)
        La5:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.optimizer.ConsStringLinker.getGuardedInvocation(jdk.dynalink.linker.LinkRequest, jdk.dynalink.linker.LinkerServices):jdk.dynalink.linker.GuardedInvocation");
    }
}
