package okio;

import defpackage.dk1;
import defpackage.mv0;
import java.io.Closeable;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class Okio__OkioKt {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final BufferedSource buffer(Source source) {
        source.getClass();
        return new RealBufferedSource(source);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    public static final <T extends Closeable, R> R use(T t, Function1<? super T, ? extends R> function1) throws IllegalAccessException, InvocationTargetException {
        ?? r4;
        function1.getClass();
        R th = null;
        try {
            R rInvoke = function1.invoke(t);
            dk1.b(1);
            if (t != null) {
                try {
                    t.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            dk1.a(1);
            R r = th;
            th = rInvoke;
            r4 = r;
        } catch (Throwable th3) {
            dk1.b(1);
            if (t != null) {
                try {
                    t.close();
                } catch (Throwable th4) {
                    mv0.a(th3, th4);
                }
            }
            dk1.a(1);
            r4 = th3;
        }
        if (r4 == 0) {
            return th;
        }
        throw r4;
    }

    public static final BufferedSink buffer(Sink sink) {
        sink.getClass();
        return new RealBufferedSink(sink);
    }
}
