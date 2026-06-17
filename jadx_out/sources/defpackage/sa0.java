package defpackage;

import java.lang.reflect.Field;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class sa0 {
    public static final ra0 a(hh hhVar) {
        return (ra0) hhVar.getClass().getAnnotation(ra0.class);
    }

    public static final int b(hh hhVar) {
        try {
            Field declaredField = hhVar.getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(hhVar);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    public static final StackTraceElement c(hh hhVar) {
        String strC;
        hhVar.getClass();
        ra0 ra0VarA = a(hhVar);
        if (ra0VarA == null || ra0VarA.v() < 1) {
            return null;
        }
        int iB = b(hhVar);
        int i = iB < 0 ? -1 : ra0VarA.l()[iB];
        String strB = bu2.a.b(hhVar);
        if (strB == null) {
            strC = ra0VarA.c();
        } else {
            strC = strB + '/' + ra0VarA.c();
        }
        return new StackTraceElement(strC, ra0VarA.m(), ra0VarA.f(), i);
    }
}
