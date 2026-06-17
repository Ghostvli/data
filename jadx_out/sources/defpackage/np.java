package defpackage;

import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface np extends a43 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements np {
        public final Function1 a;

        public a(Function1 function1) {
            this.a = function1;
        }

        @Override // defpackage.np
        public void a(Throwable th) {
            this.a.invoke(th);
        }

        public String toString() {
            return "CancelHandler.UserSupplied[" + ua0.a(this.a) + '@' + ua0.b(this) + ']';
        }
    }

    void a(Throwable th);
}
