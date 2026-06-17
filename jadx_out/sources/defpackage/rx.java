package defpackage;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class rx {
    public static final rx a = new a();
    public static final rx b = new b(-1);
    public static final rx c = new b(1);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends rx {
        public a() {
            super(null);
        }

        @Override // defpackage.rx
        public rx d(int i, int i2) {
            return l(Integer.compare(i, i2));
        }

        @Override // defpackage.rx
        public rx e(long j, long j2) {
            return l(Long.compare(j, j2));
        }

        @Override // defpackage.rx
        public rx f(Comparable comparable, Comparable comparable2) {
            return l(comparable.compareTo(comparable2));
        }

        @Override // defpackage.rx
        public rx g(Object obj, Object obj2, Comparator comparator) {
            return l(comparator.compare(obj, obj2));
        }

        @Override // defpackage.rx
        public rx h(boolean z, boolean z2) {
            return l(Boolean.compare(z, z2));
        }

        @Override // defpackage.rx
        public rx i(boolean z, boolean z2) {
            return l(Boolean.compare(z2, z));
        }

        @Override // defpackage.rx
        public int j() {
            return 0;
        }

        public rx l(int i) {
            return i < 0 ? rx.b : i > 0 ? rx.c : rx.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends rx {
        public final int d;

        public b(int i) {
            super(null);
            this.d = i;
        }

        @Override // defpackage.rx
        public rx d(int i, int i2) {
            return this;
        }

        @Override // defpackage.rx
        public rx e(long j, long j2) {
            return this;
        }

        @Override // defpackage.rx
        public rx f(Comparable comparable, Comparable comparable2) {
            return this;
        }

        @Override // defpackage.rx
        public rx g(Object obj, Object obj2, Comparator comparator) {
            return this;
        }

        @Override // defpackage.rx
        public rx h(boolean z, boolean z2) {
            return this;
        }

        @Override // defpackage.rx
        public rx i(boolean z, boolean z2) {
            return this;
        }

        @Override // defpackage.rx
        public int j() {
            return this.d;
        }
    }

    public /* synthetic */ rx(a aVar) {
        this();
    }

    public static rx k() {
        return a;
    }

    public abstract rx d(int i, int i2);

    public abstract rx e(long j, long j2);

    public abstract rx f(Comparable comparable, Comparable comparable2);

    public abstract rx g(Object obj, Object obj2, Comparator comparator);

    public abstract rx h(boolean z, boolean z2);

    public abstract rx i(boolean z, boolean z2);

    public abstract int j();

    public rx() {
    }
}
