package defpackage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class z01 extends y01 {
    public static final void a(File file, Charset charset, Function1 function1) throws IllegalAccessException, IOException, InvocationTargetException {
        file.getClass();
        charset.getClass();
        function1.getClass();
        xm4.a(new BufferedReader(new InputStreamReader(new FileInputStream(file), charset)), function1);
    }

    public static /* synthetic */ void b(File file, Charset charset, Function1 function1, int i, Object obj) throws IllegalAccessException, IOException, InvocationTargetException {
        if ((i & 1) != 0) {
            charset = bt.b;
        }
        a(file, charset, function1);
    }
}
