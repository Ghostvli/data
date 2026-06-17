package defpackage;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ma3 {
    public boolean a = false;
    public final Set b = new na();
    public final Map c = new HashMap();
    public final Comparator d = new a();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Comparator {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: compare(Ljava/lang/Object;Ljava/lang/Object;)I */
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(k73 k73Var, k73 k73Var2) {
            float fFloatValue = ((Float) k73Var.b).floatValue();
            float fFloatValue2 = ((Float) k73Var2.b).floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a(String str, float f) {
        if (this.a) {
            x62 x62Var = (x62) this.c.get(str);
            if (x62Var == null) {
                x62Var = new x62();
                this.c.put(str, x62Var);
            }
            x62Var.a(f);
            if (str.equals("__container")) {
                Iterator it = this.b.iterator();
                if (it.hasNext()) {
                    w82.a(it.next());
                    throw null;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b(boolean z) {
        this.a = z;
    }
}
