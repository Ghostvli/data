package okio;

import defpackage.i0;
import defpackage.jl;
import defpackage.we0;
import defpackage.ww;
import java.util.List;
import java.util.RandomAccess;
import kotlin.jvm.functions.Function1;
import okio.Options;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class TypedOptions<T> extends i0 implements RandomAccess {
    public static final Companion Companion = new Companion(null);
    private final List<T> list;
    private final Options options;

    public TypedOptions(List<? extends T> list, Options options) {
        list.getClass();
        options.getClass();
        this.options = options;
        List<T> listA0 = ww.a0(list);
        this.list = listA0;
        if (listA0.size() == options.size()) {
            return;
        }
        jl.a("Failed requirement.");
        throw null;
    }

    public static final <T> TypedOptions<T> of(Iterable<? extends T> iterable, Function1<? super T, ? extends ByteString> function1) {
        return Companion.of(iterable, function1);
    }

    @Override // defpackage.i0, java.util.List
    public T get(int i) {
        return this.list.get(i);
    }

    public final List<T> getList$okio() {
        return this.list;
    }

    public final Options getOptions$okio() {
        return this.options;
    }

    @Override // defpackage.u
    public int getSize() {
        return this.list.size();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        public final <T> TypedOptions<T> of(Iterable<? extends T> iterable, Function1<? super T, ? extends ByteString> function1) {
            iterable.getClass();
            function1.getClass();
            List listA0 = ww.a0(iterable);
            Options.Companion companion = Options.Companion;
            int size = listA0.size();
            ByteString[] byteStringArr = new ByteString[size];
            for (int i = 0; i < size; i++) {
                byteStringArr[i] = function1.invoke((Object) listA0.get(i));
            }
            return new TypedOptions<>(listA0, companion.of(byteStringArr));
        }

        private Companion() {
        }
    }
}
