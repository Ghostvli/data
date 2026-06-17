package defpackage;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class du3 {
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0077, code lost:
    
        defpackage.jl.a("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007c, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void a(defpackage.bu3 r9, defpackage.ma0 r10) {
        /*
            r9.getClass()
            r10.getClass()
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            java.util.Set r1 = r9.r()
            java.util.List r2 = r10.r
            int r2 = r2.size()
            boolean[] r3 = new boolean[r2]
            java.util.Iterator r1 = r1.iterator()
        L1b:
            boolean r4 = r1.hasNext()
            r5 = -1
            if (r4 == 0) goto L61
            java.lang.Object r4 = r1.next()
            hp1 r4 = (defpackage.hp1) r4
            java.util.List r6 = r10.r
            int r6 = r6.size()
            int r6 = r6 + r5
            if (r6 < 0) goto L49
        L31:
            int r7 = r6 + (-1)
            java.util.List r8 = r10.r
            java.lang.Object r8 = r8.get(r6)
            boolean r8 = r4.d(r8)
            if (r8 == 0) goto L44
            r5 = 1
            r3[r6] = r5
            r5 = r6
            goto L49
        L44:
            if (r7 >= 0) goto L47
            goto L49
        L47:
            r6 = r7
            goto L31
        L49:
            if (r5 < 0) goto L55
            java.util.List r6 = r10.r
            java.lang.Object r5 = r6.get(r5)
            r0.put(r4, r5)
            goto L1b
        L55:
            java.lang.String r9 = r4.a()
            java.lang.String r10 = ") is missing in the database configuration."
            java.lang.String r0 = "A required auto migration spec ("
            defpackage.vq3.a(r0, r9, r10)
            return
        L61:
            java.util.List r1 = r10.r
            int r1 = r1.size()
            int r1 = r1 + r5
            if (r1 < 0) goto L7d
        L6a:
            int r4 = r1 + (-1)
            if (r1 >= r2) goto L77
            boolean r1 = r3[r1]
            if (r1 == 0) goto L77
            if (r4 >= 0) goto L75
            goto L7d
        L75:
            r1 = r4
            goto L6a
        L77:
            java.lang.String r9 = "Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder."
            defpackage.jl.a(r9)
            return
        L7d:
            java.util.List r9 = r9.h(r0)
            java.util.Iterator r9 = r9.iterator()
        L85:
            boolean r0 = r9.hasNext()
            if (r0 == 0) goto La3
            java.lang.Object r0 = r9.next()
            it2 r0 = (defpackage.it2) r0
            bu3$e r1 = r10.d
            int r2 = r0.a
            int r3 = r0.b
            boolean r1 = r1.c(r2, r3)
            if (r1 != 0) goto L85
            bu3$e r1 = r10.d
            r1.a(r0)
            goto L85
        La3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.du3.a(bu3, ma0):void");
    }

    public static final void b(Set set, Set set2) {
        set.getClass();
        set2.getClass();
        if (set.isEmpty()) {
            return;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            if (set2.contains(Integer.valueOf(iIntValue))) {
                vx4.a("Inconsistency detected. A Migration was supplied to addMigration() that has a start or end version equal to a start version supplied to fallbackToDestructiveMigrationFrom(). Start version is: ", iIntValue);
                return;
            }
        }
    }

    public static final void c(bu3 bu3Var, ma0 ma0Var) {
        bu3Var.getClass();
        ma0Var.getClass();
        Map mapU = bu3Var.u();
        boolean[] zArr = new boolean[ma0Var.q.size()];
        for (Map.Entry entry : mapU.entrySet()) {
            hp1 hp1Var = (hp1) entry.getKey();
            for (hp1 hp1Var2 : (List) entry.getValue()) {
                int size = ma0Var.q.size() - 1;
                if (size >= 0) {
                    while (true) {
                        int i = size - 1;
                        if (hp1Var2.d(ma0Var.q.get(size))) {
                            zArr[size] = true;
                            break;
                        } else if (i < 0) {
                            break;
                        } else {
                            size = i;
                        }
                    }
                    size = -1;
                } else {
                    size = -1;
                }
                if (size < 0) {
                    throw new IllegalArgumentException(("A required type converter (" + hp1Var2.a() + ") for " + hp1Var.a() + " is missing in the database configuration.").toString());
                }
                bu3Var.d(hp1Var2, ma0Var.q.get(size));
            }
        }
        int size2 = ma0Var.q.size() - 1;
        if (size2 < 0) {
            return;
        }
        while (true) {
            int i2 = size2 - 1;
            if (!zArr[size2]) {
                f02.a("Unexpected type converter ", ma0Var.q.get(size2), ". Annotate TypeConverter class with @ProvidedTypeConverter annotation or remove this converter from the builder.");
                return;
            } else if (i2 < 0) {
                return;
            } else {
                size2 = i2;
            }
        }
    }
}
