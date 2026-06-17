package org.mozilla.javascript.optimizer;

import jdk.dynalink.linker.TypeBasedGuardingDynamicLinker;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptRuntime;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class DoubleLinker implements TypeBasedGuardingDynamicLinker {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private static Object add(Object obj, Object obj2, Context context) {
        return Double.valueOf(((Double) obj).doubleValue() + ((Double) obj2).doubleValue());
    }

    private static Object addInt(Object obj, Object obj2, Context context) {
        return Double.valueOf(((Double) obj).doubleValue() + ((double) ((Integer) obj2).intValue()));
    }

    private static boolean compareGE(Object obj, Object obj2) {
        return ((Double) obj).doubleValue() >= ((Double) obj2).doubleValue();
    }

    private static boolean compareGEInt(Object obj, Object obj2) {
        return ((Double) obj).doubleValue() >= ((Integer) obj2).doubleValue();
    }

    private static boolean compareGT(Object obj, Object obj2) {
        return ((Double) obj).doubleValue() > ((Double) obj2).doubleValue();
    }

    private static boolean compareGTInt(Object obj, Object obj2) {
        return ((Double) obj).doubleValue() > ((Integer) obj2).doubleValue();
    }

    private static boolean compareLE(Object obj, Object obj2) {
        return ((Double) obj).doubleValue() <= ((Double) obj2).doubleValue();
    }

    private static boolean compareLEInt(Object obj, Object obj2) {
        return ((Double) obj).doubleValue() <= ((Integer) obj2).doubleValue();
    }

    private static boolean compareLT(Object obj, Object obj2) {
        return ((Double) obj).doubleValue() < ((Double) obj2).doubleValue();
    }

    private static boolean compareLTInt(Object obj, Object obj2) {
        return ((Double) obj).doubleValue() < ((Integer) obj2).doubleValue();
    }

    private static boolean eq(Object obj, Object obj2) {
        return ((Double) obj).doubleValue() == ((Double) obj2).doubleValue();
    }

    private static boolean eqInt(Object obj, Object obj2) {
        return ((Double) obj).doubleValue() == ((Integer) obj2).doubleValue();
    }

    private static boolean testAdd(Object obj, Object obj2, Context context) {
        return (obj instanceof Double) && (obj2 instanceof Double);
    }

    private static boolean testAddInt(Object obj, Object obj2, Context context) {
        return (obj instanceof Double) && (obj2 instanceof Integer);
    }

    private static boolean testTwo(Object obj, Object obj2) {
        return (obj instanceof Double) && (obj2 instanceof Double);
    }

    private static boolean testTwoInt(Object obj, Object obj2) {
        return (obj instanceof Double) && (obj2 instanceof Integer);
    }

    private static boolean toBoolean(Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        return (Double.isNaN(dDoubleValue) || dDoubleValue == 0.0d) ? false : true;
    }

    private static int toInt32(Object obj) {
        return ScriptRuntime.toInt32(((Double) obj).doubleValue());
    }

    private static double toNumber(Object obj) {
        return ((Double) obj).doubleValue();
    }

    private static Number toNumeric(Object obj) {
        return (Double) obj;
    }

    private static long toUint32(Object obj) {
        return ScriptRuntime.toUint32(((Double) obj).doubleValue());
    }

    public boolean canLinkType(Class<?> cls) {
        return Double.class.equals(cls);
    }

    /* JADX WARN: Removed duplicated region for block: B:86:0x01fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public jdk.dynalink.linker.GuardedInvocation getGuardedInvocation(jdk.dynalink.linker.LinkRequest r10, jdk.dynalink.linker.LinkerServices r11) throws java.lang.IllegalAccessException, java.lang.NoSuchMethodException {
        /*
            Method dump skipped, instruction units count: 538
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.optimizer.DoubleLinker.getGuardedInvocation(jdk.dynalink.linker.LinkRequest, jdk.dynalink.linker.LinkerServices):jdk.dynalink.linker.GuardedInvocation");
    }
}
