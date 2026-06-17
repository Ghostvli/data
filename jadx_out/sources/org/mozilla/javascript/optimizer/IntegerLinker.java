package org.mozilla.javascript.optimizer;

import defpackage.vk1;
import java.util.Objects;
import jdk.dynalink.linker.TypeBasedGuardingDynamicLinker;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.ScriptRuntime;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class IntegerLinker implements TypeBasedGuardingDynamicLinker {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    private static Object add(Object obj, Object obj2, Context context) {
        return ScriptRuntime.add((Integer) obj, (Integer) obj2);
    }

    private static Object addDouble(Object obj, Object obj2, Context context) {
        return Double.valueOf(((Integer) obj).doubleValue() + ((Double) obj2).doubleValue());
    }

    private static boolean compareGE(Object obj, Object obj2) {
        return ((Integer) obj).intValue() >= ((Integer) obj2).intValue();
    }

    private static boolean compareGEDouble(Object obj, Object obj2) {
        return ((Integer) obj).doubleValue() >= ((Double) obj2).doubleValue();
    }

    private static boolean compareGT(Object obj, Object obj2) {
        return ((Integer) obj).intValue() > ((Integer) obj2).intValue();
    }

    private static boolean compareGTDouble(Object obj, Object obj2) {
        return ((Integer) obj).doubleValue() > ((Double) obj2).doubleValue();
    }

    private static boolean compareLE(Object obj, Object obj2) {
        return ((Integer) obj).intValue() <= ((Integer) obj2).intValue();
    }

    private static boolean compareLEDouble(Object obj, Object obj2) {
        return ((Integer) obj).doubleValue() <= ((Double) obj2).doubleValue();
    }

    private static boolean compareLT(Object obj, Object obj2) {
        return ((Integer) obj).intValue() < ((Integer) obj2).intValue();
    }

    private static boolean compareLTDouble(Object obj, Object obj2) {
        return ((Integer) obj).doubleValue() < ((Double) obj2).doubleValue();
    }

    private static boolean eq(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    private static boolean eqDouble(Object obj, Object obj2) {
        return ((Integer) obj).doubleValue() == ((Double) obj2).doubleValue();
    }

    private static boolean testAdd(Object obj, Object obj2, Context context) {
        return (obj instanceof Integer) && (obj2 instanceof Integer);
    }

    private static boolean testAddDouble(Object obj, Object obj2, Context context) {
        return (obj instanceof Integer) && (obj2 instanceof Double);
    }

    private static boolean testTwo(Object obj, Object obj2) {
        return (obj instanceof Integer) && (obj2 instanceof Integer);
    }

    private static boolean testTwoDouble(Object obj, Object obj2) {
        return (obj instanceof Integer) && (obj2 instanceof Double);
    }

    private static boolean toBoolean(Object obj) {
        return ((Integer) obj).intValue() != 0;
    }

    private static int toInt32(Object obj) {
        return ((Integer) obj).intValue();
    }

    private static double toNumber(Object obj) {
        return ((Integer) obj).doubleValue();
    }

    private static Number toNumeric(Object obj) {
        return (Number) obj;
    }

    private static long toUint32(Object obj) {
        return vk1.a(((Integer) obj).intValue());
    }

    public boolean canLinkType(Class<?> cls) {
        return Integer.class.equals(cls);
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
        throw new UnsupportedOperationException("Method not decompiled: org.mozilla.javascript.optimizer.IntegerLinker.getGuardedInvocation(jdk.dynalink.linker.LinkRequest, jdk.dynalink.linker.LinkerServices):jdk.dynalink.linker.GuardedInvocation");
    }
}
