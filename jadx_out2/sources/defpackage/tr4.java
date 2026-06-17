package defpackage;

import com.fongmi.android.tv.bean.Track;
import defpackage.lr4;
import defpackage.xr4;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class tr4 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends to3 {
        public final xr4.a a;
        public final int b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(xr4.a aVar, int i) {
            this.a = aVar;
            this.b = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private /* synthetic */ boolean a(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.b == aVar.b && Objects.equals(this.a, aVar.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private /* synthetic */ Object[] b() {
            return new Object[]{this.a, Integer.valueOf(this.b)};
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean equals(Object obj) {
            return a(obj);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int hashCode() {
            return zt0.a(this.b, this.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final String toString() {
            return yq.a(b(), a.class, "a;b");
        }
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: ?: TERNARY null = ((wrap:int:0x0000: INVOKE (r1v0 xr4$a) VIRTUAL call: xr4.a.e():int A[MD:():int (m), WRAPPED] (LINE:1)) == (r0v0 int)) ? true : false */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean b(int i, xr4.a aVar) {
        return aVar.e() == i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void c(Map map, lr4.c cVar, Integer num, br4 br4Var) {
        Integer num2 = (Integer) map.get(num);
        cVar.U(new jr4(br4Var, num2 != null ? av4.a(new Object[]{num2}) : Collections.EMPTY_LIST));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int d(xr4 xr4Var, final int i) {
        return xr4Var.b().stream().filter(new Predicate() { // from class: qr4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return tr4.b(i, (xr4.a) obj);
            }
        }).mapToInt(new ToIntFunction() { // from class: rr4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.ToIntFunction
            public final int applyAsInt(Object obj) {
                return ((xr4.a) obj).a;
            }
        }).sum();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static a e(hd3 hd3Var, Track track) {
        if (track.getFormat() == null) {
            return null;
        }
        pw4 it = hd3Var.getCurrentTracks().b().iterator();
        while (it.hasNext()) {
            xr4.a aVar = (xr4.a) it.next();
            if (aVar.e() == track.getType()) {
                for (int i = 0; i < aVar.a; i++) {
                    if (track.getFormat().equals(ge3.a(aVar.d(i)))) {
                        return new a(aVar, i);
                    }
                }
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void f(hd3 hd3Var) {
        hd3Var.setTrackSelectionParameters(hd3Var.getTrackSelectionParameters().M().L().K());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void g(hd3 hd3Var, List list) {
        HashMap map = new HashMap();
        final HashMap map2 = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Track track = (Track) it.next();
            a aVarE = e(hd3Var, track);
            if (aVarE != null) {
                int iE = aVarE.a.e();
                map.put(Integer.valueOf(iE), aVarE.a.c());
                if (track.isSelected()) {
                    map2.put(Integer.valueOf(iE), Integer.valueOf(aVarE.b));
                }
            }
        }
        final lr4.c cVarM = hd3Var.getTrackSelectionParameters().M();
        map.forEach(new BiConsumer() { // from class: sr4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.BiConsumer
            public final void accept(Object obj, Object obj2) {
                tr4.c(map2, cVarM, (Integer) obj, (br4) obj2);
            }
        });
        hd3Var.setTrackSelectionParameters(cVarM.K());
    }
}
