package defpackage;

import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class fe5 implements Function {
    public final /* synthetic */ je5 a;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Marked for inline */
    /* JADX DEBUG: Method not inlined, still used in: [je5.I():java.util.Optional, je5.d():java.lang.String, je5.e():long] */
    public /* synthetic */ fe5(je5 je5Var) {
        this.a = je5Var;
    }

    /* JADX DEBUG: Class process forced to load method for inline: je5.B(je5, ko1):java.lang.String */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return this.a.J((ko1) obj);
    }
}
