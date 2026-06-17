package defpackage;

import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Device;
import com.hierynomus.protocol.commons.buffer.Buffer;
import j$.util.stream.Stream$EL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.stream.IntStream;
import okhttp3.OkHttpClient;
import okhttp3.Response;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class jy3 {
    public a c;
    public final OkHttpClient b = q53.k(1000);
    public final CopyOnWriteArrayList a = new CopyOnWriteArrayList();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void c(Device device);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public jy3(a aVar) {
        this.c = aVar;
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: STR_CONCAT (r1v0 java.lang.String), (r2v0 int), (":9978") A[MD:():java.lang.String (c), SYNTHETIC] (LINE:17) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ String f(String str, int i) {
        return str + i + ":9978";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: j(Ljava/lang/String;)V */
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final void j(String str) {
        if (str.equals(t14.b().c())) {
            return;
        }
        try {
            Response responseExecute = q53.w(this.b, str.concat("/device"), "scan").execute();
            try {
                final Device deviceObjectFrom = Device.objectFrom(responseExecute.body().string());
                if (deviceObjectFrom != null) {
                    App.d(new Runnable() { // from class: iy3
                        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                        @Override // java.lang.Runnable
                        public final void run() {
                            this.f.i(deviceObjectFrom);
                        }
                    });
                }
                responseExecute.close();
            } finally {
            }
        } catch (Exception unused) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final List h() {
        String strC = t14.b().c();
        final String strSubstring = strC.substring(0, strC.lastIndexOf(".") + 1);
        return Stream$EL.toList(IntStream.range(1, Buffer.DEFAULT_SIZE).mapToObj(new IntFunction() { // from class: hy3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.IntFunction
            public final Object apply(int i) {
                return jy3.f(strSubstring, i);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void i(Device device) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.c(device.save());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void k() {
        m(h());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final /* synthetic */ void l(String str) {
        m(av4.a(new Object[]{str}));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void m(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final String str = (String) it.next();
            this.a.add(ul4.i(new Runnable() { // from class: gy3
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.j(str);
                }
            }));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void n() {
        ul4.c(new Runnable() { // from class: fy3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.k();
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void o(final String str) {
        ul4.c(new Runnable() { // from class: ey3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.l(str);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void p() {
        this.c = null;
        q53.f(this.b, "scan");
        this.a.forEach(new Consumer() { // from class: dy3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Future) obj).cancel(true);
            }
        });
        this.a.clear();
    }
}
