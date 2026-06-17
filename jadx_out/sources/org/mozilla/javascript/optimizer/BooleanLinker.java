package org.mozilla.javascript.optimizer;

import java.util.Objects;
import jdk.dynalink.linker.TypeBasedGuardingDynamicLinker;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class BooleanLinker implements TypeBasedGuardingDynamicLinker {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private static boolean eq(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    private static boolean testEq(Object obj, Object obj2) {
        return (obj instanceof Boolean) && (obj2 instanceof Boolean);
    }

    private static boolean toBoolean(Object obj) {
        return ((Boolean) obj).booleanValue();
    }

    public boolean canLinkType(Class<?> cls) {
        return Boolean.class.equals(cls);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0066  */
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
            org.mozilla.javascript.optimizer.ParsedOperation r4 = new org.mozilla.javascript.optimizer.ParsedOperation
            jdk.dynalink.CallSiteDescriptor r0 = r5.getCallSiteDescriptor()
            jdk.dynalink.Operation r0 = r0.getOperation()
            r4.<init>(r0)
            org.mozilla.javascript.optimizer.RhinoNamespace r0 = org.mozilla.javascript.optimizer.RhinoNamespace.MATH
            boolean r0 = r4.isNamespace(r0)
            if (r0 == 0) goto L66
            java.lang.invoke.MethodHandles$Lookup r0 = java.lang.invoke.MethodHandles.lookup()
            jdk.dynalink.CallSiteDescriptor r1 = r5.getCallSiteDescriptor()
            java.lang.invoke.MethodType r1 = r1.getMethodType()
            org.mozilla.javascript.optimizer.RhinoOperation r2 = org.mozilla.javascript.optimizer.RhinoOperation.EQ
            org.mozilla.javascript.optimizer.RhinoOperation r3 = org.mozilla.javascript.optimizer.RhinoOperation.SHALLOWEQ
            boolean r2 = r4.isOperation(r2, r3)
            if (r2 == 0) goto L4f
            java.lang.Object[] r5 = r5.getArguments()
            r2 = 1
            r5 = r5[r2]
            boolean r5 = r5 instanceof java.lang.Boolean
            if (r5 == 0) goto L4f
            java.lang.Class<org.mozilla.javascript.optimizer.BooleanLinker> r5 = org.mozilla.javascript.optimizer.BooleanLinker.class
            java.lang.String r2 = "eq"
            java.lang.invoke.MethodHandle r5 = r0.findStatic(r5, r2, r1)
            java.lang.Class<org.mozilla.javascript.optimizer.BooleanLinker> r2 = org.mozilla.javascript.optimizer.BooleanLinker.class
            java.lang.String r3 = "testEq"
            java.lang.invoke.MethodHandle r0 = r0.findStatic(r2, r3, r1)
            goto L68
        L4f:
            org.mozilla.javascript.optimizer.RhinoOperation r5 = org.mozilla.javascript.optimizer.RhinoOperation.TOBOOLEAN
            boolean r5 = r4.isOperation(r5)
            if (r5 == 0) goto L66
            java.lang.Class<org.mozilla.javascript.optimizer.BooleanLinker> r5 = org.mozilla.javascript.optimizer.BooleanLinker.class
            java.lang.String r2 = "toBoolean"
            java.lang.invoke.MethodHandle r5 = r0.findStatic(r5, r2, r1)
            java.lang.Class<java.lang.Boolean> r0 = java.lang.Boolean.class
            java.lang.invoke.MethodHandle r0 = jdk.dynalink.linker.support.Guards.getInstanceOfGuard(r0)
            goto L68
        L66:
            r5 = r6
            r0 = r5
        L68:
            if (r5 == 0) goto L83
            boolean r6 = org.mozilla.javascript.optimizer.DefaultLinker.DEBUG
            if (r6 == 0) goto L7d
            java.io.PrintStream r6 = java.lang.System.out
            java.lang.String r4 = java.lang.String.valueOf(r4)
            java.lang.String r1 = " boolean operation"
            java.lang.String r4 = r4.concat(r1)
            r6.println(r4)
        L7d:
            jdk.dynalink.linker.GuardedInvocation r4 = new jdk.dynalink.linker.GuardedInvocation
            r4.<init>(r5, r0)
            return r4
        L83:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.optimizer.BooleanLinker.getGuardedInvocation(jdk.dynalink.linker.LinkRequest, jdk.dynalink.linker.LinkerServices):jdk.dynalink.linker.GuardedInvocation");
    }
}
