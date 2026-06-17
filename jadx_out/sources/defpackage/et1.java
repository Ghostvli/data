package defpackage;

import android.content.Context;
import androidx.lifecycle.g;
import defpackage.mr3;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class et1 {
    public final Map a = new HashMap();
    public final mr3.b b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements zs1 {
        public final /* synthetic */ g f;

        public a(g gVar) {
            this.f = gVar;
        }

        @Override // defpackage.zs1
        public void b() {
        }

        @Override // defpackage.zs1
        public void h() {
            et1.this.a.remove(this.f);
        }

        @Override // defpackage.zs1
        public void onStop() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class b implements nr3 {
        public final k61 a;

        public b(k61 k61Var) {
            this.a = k61Var;
        }

        @Override // defpackage.nr3
        public Set a() {
            HashSet hashSet = new HashSet();
            b(this.a, hashSet);
            return hashSet;
        }

        public final void b(k61 k61Var, Set set) {
            List listW0 = k61Var.w0();
            int size = listW0.size();
            for (int i = 0; i < size; i++) {
                p51 p51Var = (p51) listW0.get(i);
                b(p51Var.T(), set);
                lr3 lr3VarA = et1.this.a(p51Var.getLifecycle());
                if (lr3VarA != null) {
                    set.add(lr3VarA);
                }
            }
        }
    }

    public et1(mr3.b bVar) {
        this.b = bVar;
    }

    public lr3 a(g gVar) {
        iy4.b();
        return (lr3) this.a.get(gVar);
    }

    public lr3 b(Context context, com.bumptech.glide.a aVar, g gVar, k61 k61Var, boolean z) {
        iy4.b();
        lr3 lr3VarA = a(gVar);
        if (lr3VarA != null) {
            return lr3VarA;
        }
        ys1 ys1Var = new ys1(gVar);
        lr3 lr3VarA2 = this.b.a(aVar, ys1Var, new b(k61Var), context);
        this.a.put(gVar, lr3VarA2);
        ys1Var.b(new a(gVar));
        if (z) {
            lr3VarA2.b();
        }
        return lr3VarA2;
    }
}
