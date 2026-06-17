package defpackage;

import com.fongmi.android.tv.App;
import defpackage.yj;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class uj {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends yj.a {
        public final /* synthetic */ u51 a;

        public a(u51 u51Var) {
            this.a = u51Var;
        }

        @Override // yj.a
        public void a(int i, CharSequence charSequence) {
            i43.i(charSequence.toString());
        }

        @Override // yj.a
        public void c(yj.b bVar) {
            ((b) this.a).J();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void J();
    }

    public static int a() {
        return c().a(15);
    }

    public static boolean b() {
        return a() == 0;
    }

    public static xj c() {
        return xj.g(App.b());
    }

    public static yj d(u51 u51Var) {
        return new yj(u51Var, c30.h(u51Var), new a(u51Var));
    }

    public static void e(u51 u51Var) {
        d(u51Var).a(new yj.d.a().c(vr3.l(sm3.b)).b(vr3.l(sm3.u)).a());
    }
}
