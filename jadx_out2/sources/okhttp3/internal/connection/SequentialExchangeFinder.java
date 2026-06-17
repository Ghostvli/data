package okhttp3.internal.connection;

import defpackage.mv0;
import defpackage.sb1;
import java.io.IOException;
import okhttp3.internal.connection.RoutePlanner;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class SequentialExchangeFinder implements ExchangeFinder {
    private final RoutePlanner routePlanner;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SequentialExchangeFinder(RoutePlanner routePlanner) {
        routePlanner.getClass();
        this.routePlanner = routePlanner;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.internal.connection.ExchangeFinder
    public RealConnection find() throws Throwable {
        RoutePlanner.Plan plan;
        IOException iOException = null;
        while (!getRoutePlanner().isCanceled()) {
            try {
                plan = getRoutePlanner().plan();
            } catch (IOException e) {
                if (iOException == null) {
                    iOException = e;
                } else {
                    mv0.a(iOException, e);
                }
                if (!RoutePlanner.hasNext$default(getRoutePlanner(), null, 1, null)) {
                    throw iOException;
                }
            }
            if (!plan.isReady()) {
                RoutePlanner.ConnectResult connectResultMo158connectTcp = plan.mo158connectTcp();
                if (connectResultMo158connectTcp.isSuccess()) {
                    connectResultMo158connectTcp = plan.mo159connectTlsEtc();
                }
                RoutePlanner.Plan planComponent2 = connectResultMo158connectTcp.component2();
                Throwable thComponent3 = connectResultMo158connectTcp.component3();
                if (thComponent3 != null) {
                    throw thComponent3;
                }
                if (planComponent2 != null) {
                    getRoutePlanner().getDeferredPlans().addFirst(planComponent2);
                }
            }
            return plan.mo155handleSuccess();
        }
        sb1.a("Canceled");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.internal.connection.ExchangeFinder
    public RoutePlanner getRoutePlanner() {
        return this.routePlanner;
    }
}
