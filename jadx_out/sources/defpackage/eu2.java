package defpackage;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class eu2 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final String a;
        public final a b;
        public a c;
        public boolean d;
        public boolean e;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public static class a {
            public String a;
            public Object b;
            public a c;
        }

        public b(String str) {
            a aVar = new a();
            this.b = aVar;
            this.c = aVar;
            this.d = false;
            this.e = false;
            this.a = (String) gg3.q(str);
        }

        public static boolean d(Object obj) {
            return obj instanceof CharSequence ? ((CharSequence) obj).length() == 0 : obj instanceof Collection ? ((Collection) obj).isEmpty() : obj instanceof Map ? ((Map) obj).isEmpty() : obj instanceof t63 ? !((t63) obj).b() : obj.getClass().isArray() && Array.getLength(obj) == 0;
        }

        public final a a() {
            a aVar = new a();
            this.c.c = aVar;
            this.c = aVar;
            return aVar;
        }

        public final b b(Object obj) {
            a().b = obj;
            return this;
        }

        public b c(Object obj) {
            return b(obj);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x002c  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.String toString() {
            /*
                r6 = this;
                boolean r0 = r6.d
                boolean r1 = r6.e
                java.lang.StringBuilder r2 = new java.lang.StringBuilder
                r3 = 32
                r2.<init>(r3)
                java.lang.String r3 = r6.a
                r2.append(r3)
                r3 = 123(0x7b, float:1.72E-43)
                r2.append(r3)
                eu2$b$a r6 = r6.b
                eu2$b$a r6 = r6.c
                java.lang.String r3 = ""
            L1b:
                if (r6 == 0) goto L61
                java.lang.Object r4 = r6.b
                if (r4 != 0) goto L24
                if (r0 != 0) goto L5e
                goto L2c
            L24:
                if (r1 == 0) goto L2c
                boolean r5 = d(r4)
                if (r5 != 0) goto L5e
            L2c:
                r2.append(r3)
                java.lang.String r3 = r6.a
                if (r3 == 0) goto L3b
                r2.append(r3)
                r3 = 61
                r2.append(r3)
            L3b:
                if (r4 == 0) goto L59
                java.lang.Class r3 = r4.getClass()
                boolean r3 = r3.isArray()
                if (r3 == 0) goto L59
                java.lang.Object[] r3 = new java.lang.Object[]{r4}
                java.lang.String r3 = java.util.Arrays.deepToString(r3)
                int r4 = r3.length()
                r5 = 1
                int r4 = r4 - r5
                r2.append(r3, r5, r4)
                goto L5c
            L59:
                r2.append(r4)
            L5c:
                java.lang.String r3 = ", "
            L5e:
                eu2$b$a r6 = r6.c
                goto L1b
            L61:
                r6 = 125(0x7d, float:1.75E-43)
                r2.append(r6)
                java.lang.String r6 = r2.toString()
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: eu2.b.toString():java.lang.String");
        }
    }

    public static Object a(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        if (obj2 != null) {
            return obj2;
        }
        om1.a("Both parameters are null");
        return null;
    }

    public static b b(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }
}
