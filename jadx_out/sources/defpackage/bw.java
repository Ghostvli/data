package defpackage;

import defpackage.cj1;
import defpackage.dj1;
import defpackage.xi1;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class bw {
    public static final Collector a = Collector.of(new Supplier() { // from class: pv
        @Override // java.util.function.Supplier
        public final Object get() {
            return xi1.m();
        }
    }, new BiConsumer() { // from class: uv
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            ((xi1.a) obj).h(obj2);
        }
    }, new BinaryOperator() { // from class: vv
        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            return ((xi1.a) obj).m((xi1.a) obj2);
        }
    }, new Function() { // from class: wv
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return ((xi1.a) obj).k();
        }
    }, new Collector.Characteristics[0]);
    public static final Collector b = Collector.of(new Supplier() { // from class: xv
        @Override // java.util.function.Supplier
        public final Object get() {
            return dj1.m();
        }
    }, new BiConsumer() { // from class: yv
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            ((dj1.a) obj).h(obj2);
        }
    }, new BinaryOperator() { // from class: zv
        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            return ((dj1.a) obj).l((dj1.a) obj2);
        }
    }, new Function() { // from class: aw
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return ((dj1.a) obj).k();
        }
    }, new Collector.Characteristics[0]);
    public static final Collector c = Collector.of(new Supplier() { // from class: qv
        @Override // java.util.function.Supplier
        public final Object get() {
            return cj1.d();
        }
    }, new BiConsumer() { // from class: rv
        @Override // java.util.function.BiConsumer
        public final void accept(Object obj, Object obj2) {
            ((cj1.a) obj).a((rn3) obj2);
        }
    }, new BinaryOperator() { // from class: sv
        @Override // java.util.function.BiFunction
        public final Object apply(Object obj, Object obj2) {
            return ((cj1.a) obj).d((cj1.a) obj2);
        }
    }, new Function() { // from class: tv
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return ((cj1.a) obj).c();
        }
    }, new Collector.Characteristics[0]);

    public static Collector a() {
        return a;
    }
}
