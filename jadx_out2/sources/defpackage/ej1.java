package defpackage;

import java.util.Comparator;
import java.util.NavigableSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ej1 extends dj1 implements NavigableSet, ma4 {
    public final transient Comparator h;
    public transient ej1 i;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ej1(Comparator comparator) {
        this.h = comparator;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static cq3 F(Comparator comparator) {
        return x63.d().equals(comparator) ? cq3.k : new cq3(xi1.u(), comparator);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int Q(Comparator comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    public abstract ej1 D();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: descendingSet()Ljava/util/NavigableSet; */
    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public ej1 descendingSet() {
        ej1 ej1Var = this.i;
        if (ej1Var != null) {
            return ej1Var;
        }
        ej1 ej1VarD = D();
        this.i = ej1VarD;
        ej1VarD.i = this;
        return ej1VarD;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: headSet(Ljava/lang/Object;)Ljava/util/SortedSet; */
    @Override // java.util.NavigableSet, java.util.SortedSet
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public ej1 headSet(Object obj) {
        return headSet(obj, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: headSet(Ljava/lang/Object;Z)Ljava/util/NavigableSet; */
    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public ej1 headSet(Object obj, boolean z) {
        return I(gg3.q(obj), z);
    }

    public abstract ej1 I(Object obj, boolean z);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: subSet(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/SortedSet; */
    @Override // java.util.NavigableSet, java.util.SortedSet
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public ej1 subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: subSet(Ljava/lang/Object;ZLjava/lang/Object;Z)Ljava/util/NavigableSet; */
    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
    public ej1 subSet(Object obj, boolean z, Object obj2, boolean z2) {
        gg3.q(obj);
        gg3.q(obj2);
        gg3.d(this.h.compare(obj, obj2) <= 0);
        return L(obj, z, obj2, z2);
    }

    public abstract ej1 L(Object obj, boolean z, Object obj2, boolean z2);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: tailSet(Ljava/lang/Object;)Ljava/util/SortedSet; */
    @Override // java.util.NavigableSet, java.util.SortedSet
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public ej1 tailSet(Object obj) {
        return tailSet(obj, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: tailSet(Ljava/lang/Object;Z)Ljava/util/NavigableSet; */
    @Override // java.util.NavigableSet
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public ej1 tailSet(Object obj, boolean z) {
        return O(gg3.q(obj), z);
    }

    public abstract ej1 O(Object obj, boolean z);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int P(Object obj, Object obj2) {
        return Q(this.h, obj, obj2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.SortedSet, defpackage.ma4
    public Comparator comparator() {
        return this.h;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.NavigableSet
    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.util.NavigableSet
    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }
}
