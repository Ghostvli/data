package defpackage;

import java.util.LinkedHashSet;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class mz1 {
    public static jz1 a(jz1 jz1Var, jz1 jz1Var2) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        int i = 0;
        while (i < jz1Var.f() + jz1Var2.f()) {
            Locale localeC = i < jz1Var.f() ? jz1Var.c(i) : jz1Var2.c(i - jz1Var.f());
            if (localeC != null) {
                linkedHashSet.add(localeC);
            }
            i++;
        }
        return jz1.a((Locale[]) linkedHashSet.toArray(new Locale[linkedHashSet.size()]));
    }

    public static jz1 b(jz1 jz1Var, jz1 jz1Var2) {
        return (jz1Var == null || jz1Var.e()) ? jz1.d() : a(jz1Var, jz1Var2);
    }
}
