package okhttp3.internal.connection;

import defpackage.fn;
import defpackage.ia;
import defpackage.il1;
import defpackage.we0;
import okhttp3.Address;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface RoutePlanner {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class DefaultImpls {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface Plan {
        /* JADX INFO: renamed from: cancel */
        void mo154cancel();

        /* JADX INFO: renamed from: connectTcp */
        ConnectResult mo158connectTcp();

        /* JADX INFO: renamed from: connectTlsEtc */
        ConnectResult mo159connectTlsEtc();

        /* JADX INFO: renamed from: handleSuccess */
        RealConnection mo155handleSuccess();

        boolean isReady();

        /* JADX INFO: renamed from: retry */
        Plan mo156retry();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static /* synthetic */ boolean hasNext$default(RoutePlanner routePlanner, RealConnection realConnection, int i, Object obj) {
        if (obj != null) {
            fn.a("Super calls with default arguments not supported in this target, function: hasNext");
            return false;
        }
        if ((i & 1) != 0) {
            realConnection = null;
        }
        return routePlanner.hasNext(realConnection);
    }

    Address getAddress();

    ia getDeferredPlans();

    boolean hasNext(RealConnection realConnection);

    boolean isCanceled();

    Plan plan();

    boolean sameHostAndPort(HttpUrl httpUrl);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class ConnectResult {
        private final Plan nextPlan;
        private final Plan plan;
        private final Throwable throwable;

        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x000b: CONSTRUCTOR 
          (r2v0 okhttp3.internal.connection.RoutePlanner$Plan)
          (wrap:okhttp3.internal.connection.RoutePlanner$Plan:?: TERNARY null = ((wrap:int:0x0000: ARITH (r5v0 int) & (2 int) A[WRAPPED] (LINE:1)) != (0 int)) ? (null okhttp3.internal.connection.RoutePlanner$Plan) : (r3v0 okhttp3.internal.connection.RoutePlanner$Plan))
          (wrap:java.lang.Throwable:?: TERNARY null = ((wrap:int:0x0006: ARITH (r5v0 int) & (4 int) A[WRAPPED] (LINE:7)) != (0 int)) ? (null java.lang.Throwable) : (r4v0 java.lang.Throwable))
         A[MD:(okhttp3.internal.connection.RoutePlanner$Plan, okhttp3.internal.connection.RoutePlanner$Plan, java.lang.Throwable):void (m)] (LINE:12) call: okhttp3.internal.connection.RoutePlanner.ConnectResult.<init>(okhttp3.internal.connection.RoutePlanner$Plan, okhttp3.internal.connection.RoutePlanner$Plan, java.lang.Throwable):void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ ConnectResult(Plan plan, Plan plan2, Throwable th, int i, we0 we0Var) {
            this(plan, (i & 2) != 0 ? null : plan2, (i & 4) != 0 ? null : th);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ ConnectResult copy$default(ConnectResult connectResult, Plan plan, Plan plan2, Throwable th, int i, Object obj) {
            if ((i & 1) != 0) {
                plan = connectResult.plan;
            }
            if ((i & 2) != 0) {
                plan2 = connectResult.nextPlan;
            }
            if ((i & 4) != 0) {
                th = connectResult.throwable;
            }
            return connectResult.copy(plan, plan2, th);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Plan component1() {
            return this.plan;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Plan component2() {
            return this.nextPlan;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Throwable component3() {
            return this.throwable;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final ConnectResult copy(Plan plan, Plan plan2, Throwable th) {
            plan.getClass();
            return new ConnectResult(plan, plan2, th);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ConnectResult)) {
                return false;
            }
            ConnectResult connectResult = (ConnectResult) obj;
            return il1.a(this.plan, connectResult.plan) && il1.a(this.nextPlan, connectResult.nextPlan) && il1.a(this.throwable, connectResult.throwable);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Plan getNextPlan() {
            return this.nextPlan;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Plan getPlan() {
            return this.plan;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Throwable getThrowable() {
            return this.throwable;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int hashCode() {
            int iHashCode = this.plan.hashCode() * 31;
            Plan plan = this.nextPlan;
            int iHashCode2 = (iHashCode + (plan == null ? 0 : plan.hashCode())) * 31;
            Throwable th = this.throwable;
            return iHashCode2 + (th != null ? th.hashCode() : 0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean isSuccess() {
            return this.nextPlan == null && this.throwable == null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String toString() {
            return "ConnectResult(plan=" + this.plan + ", nextPlan=" + this.nextPlan + ", throwable=" + this.throwable + ')';
        }

        public ConnectResult(Plan plan, Plan plan2, Throwable th) {
            plan.getClass();
            this.plan = plan;
            this.nextPlan = plan2;
            this.throwable = th;
        }
    }
}
