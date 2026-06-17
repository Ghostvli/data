package defpackage;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract /* synthetic */ class du3 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0077, code lost:
    
        defpackage.jl.a("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x007c, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void a(bu3 bu3Var, ma0 ma0Var) {
        bu3Var.getClass();
        ma0Var.getClass();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Set setR = bu3Var.r();
        int size = ma0Var.r.size();
        boolean[] zArr = new boolean[size];
        Iterator it = setR.iterator();
        while (true) {
            int i = -1;
            if (!it.hasNext()) {
                int size2 = ma0Var.r.size() - 1;
                if (size2 >= 0) {
                    while (true) {
                        int i2 = size2 - 1;
                        if (size2 >= size || !zArr[size2]) {
                            break;
                        } else if (i2 < 0) {
                            break;
                        } else {
                            size2 = i2;
                        }
                    }
                }
                for (it2 it2Var : bu3Var.h(linkedHashMap)) {
                    if (!ma0Var.d.c(it2Var.a, it2Var.b)) {
                        ma0Var.d.a(it2Var);
                    }
                }
                return;
            }
            hp1 hp1Var = (hp1) it.next();
            int size3 = ma0Var.r.size() - 1;
            if (size3 >= 0) {
                while (true) {
                    int i3 = size3 - 1;
                    if (hp1Var.d(ma0Var.r.get(size3))) {
                        zArr[size3] = true;
                        i = size3;
                        break;
                    } else if (i3 < 0) {
                        break;
                    } else {
                        size3 = i3;
                    }
                }
            }
            if (i < 0) {
                vq3.a("A required auto migration spec (", hp1Var.a(), ") is missing in the database configuration.");
                return;
            }
            linkedHashMap.put(hp1Var, ma0Var.r.get(i));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
