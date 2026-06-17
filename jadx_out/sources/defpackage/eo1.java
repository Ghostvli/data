package defpackage;

import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Stream;

/* JADX INFO: loaded from: classes.dex */
public class eo1 extends ArrayList {
    public int b(int i) {
        return c(i, 0);
    }

    public int c(int i, int i2) {
        Object obj = get(i);
        return obj instanceof Number ? ((Number) obj).intValue() : i2;
    }

    public ko1 d(int i) {
        return e(i, new ko1());
    }

    public ko1 e(int i, ko1 ko1Var) {
        Object obj = get(i);
        return obj instanceof ko1 ? (ko1) obj : ko1Var;
    }

    public Stream f(final Class cls) {
        Stream<E> stream = stream();
        cls.getClass();
        return stream.filter(new co1(cls)).map(new Function() { // from class: do1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return cls.cast(obj);
            }
        });
    }

    public Stream g() {
        return f(ko1.class);
    }

    @Override // java.util.ArrayList, java.util.AbstractList, java.util.List
    public Object get(int i) {
        if (i < size()) {
            return super.get(i);
        }
        return null;
    }
}
