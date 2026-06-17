package defpackage;

import android.os.Bundle;
import defpackage.sx3;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class sx3 {
    public static final a c = new a(null);
    public final ux3 a;
    public final qx3 b;

    public sx3(ux3 ux3Var) {
        this.a = ux3Var;
        this.b = new qx3(ux3Var);
    }

    public static final sx3 a(vx3 vx3Var) {
        return c.b(vx3Var);
    }

    public final qx3 b() {
        return this.b;
    }

    public final void c() {
        this.a.f();
    }

    public final void d(Bundle bundle) {
        this.a.g(bundle);
    }

    public final void e(Bundle bundle) {
        bundle.getClass();
        this.a.h(bundle);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        public static fw4 a(vx3 vx3Var) {
            vx3Var.getLifecycle().a(new yo3(vx3Var));
            return fw4.a;
        }

        public final sx3 b(final vx3 vx3Var) {
            vx3Var.getClass();
            return new sx3(new ux3(vx3Var, new Function0() { // from class: rx3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return sx3.a.a(vx3Var);
                }
            }), null);
        }

        public a() {
        }
    }

    public /* synthetic */ sx3(ux3 ux3Var, we0 we0Var) {
        this(ux3Var);
    }
}
