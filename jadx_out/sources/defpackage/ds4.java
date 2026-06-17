package defpackage;

import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface ds4 extends pf3 {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public static final a f = new a("DEFERRED", 0);
        public static final a g = new a("IMMEDIATE", 1);
        public static final a h = new a("EXCLUSIVE", 2);
        public static final /* synthetic */ a[] i;
        public static final /* synthetic */ gt0 j;

        static {
            a[] aVarArrA = a();
            i = aVarArrA;
            j = ht0.a(aVarArrA);
        }

        public a(String str, int i2) {
        }

        public static final /* synthetic */ a[] a() {
            return new a[]{f, g, h};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) i.clone();
        }
    }

    Object b(a aVar, Function2 function2, f30 f30Var);

    Object c(f30 f30Var);
}
