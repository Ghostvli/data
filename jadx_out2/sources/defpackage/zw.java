package defpackage;

import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class zw {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static er0 a(su0 su0Var, br0 br0Var) {
        er0 er0Var = (er0) (su0Var.j() ? c(su0Var, br0Var, br0.class) : b(su0Var, br0Var)).collect(Collectors.toCollection(new Supplier() { // from class: xw
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Supplier
            public final Object get() {
                return new er0();
            }
        }));
        su0Var.i();
        return er0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Stream b(su0 su0Var, br0 br0Var) {
        su0Var.i();
        return br0Var.stream().filter(su0Var.d(br0Var));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Stream c(su0 su0Var, br0 br0Var, Class cls) {
        su0Var.i();
        return br0Var.E(cls).filter(su0Var.c(br0Var));
    }
}
