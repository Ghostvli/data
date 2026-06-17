package defpackage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class xm4 {
    public static final void a(Reader reader, Function1 function1) throws IllegalAccessException, IOException, InvocationTargetException {
        reader.getClass();
        function1.getClass();
        BufferedReader bufferedReader = reader instanceof BufferedReader ? (BufferedReader) reader : new BufferedReader(reader, 8192);
        try {
            Iterator it = b(bufferedReader).iterator();
            while (it.hasNext()) {
                function1.invoke(it.next());
            }
            fw4 fw4Var = fw4.a;
            bv.a(bufferedReader, null);
        } finally {
        }
    }

    public static final f14 b(BufferedReader bufferedReader) {
        bufferedReader.getClass();
        return n14.e(new pt1(bufferedReader));
    }
}
