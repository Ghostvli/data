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

    public jy3(a aVar) {
        this.c = aVar;
    }

    public static /* synthetic */ String f(String str, int i) {
        return str + i + ":9978";
    }

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

    public final List h() {
        String strC = t14.b().c();
        final String strSubstring = strC.substring(0, strC.lastIndexOf(".") + 1);
        return Stream$EL.toList(IntStream.range(1, Buffer.DEFAULT_SIZE).mapToObj(new IntFunction() { // from class: hy3
            @Override // java.util.function.IntFunction
            public final Object apply(int i) {
                return jy3.f(strSubstring, i);
            }
        }));
    }

    public final /* synthetic */ void i(Device device) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.c(device.save());
        }
    }

    public final /* synthetic */ void k() {
        m(h());
    }

    public final /* synthetic */ void l(String str) {
        m(av4.a(new Object[]{str}));
    }

    public final void m(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            final String str = (String) it.next();
            this.a.add(ul4.i(new Runnable() { // from class: gy3
                @Override // java.lang.Runnable
                public final void run() {
                    this.f.j(str);
                }
            }));
        }
    }

    public void n() {
        ul4.c(new Runnable() { // from class: fy3
            @Override // java.lang.Runnable
            public final void run() {
                this.f.k();
            }
        });
    }

    public void o(final String str) {
        ul4.c(new Runnable() { // from class: ey3
            @Override // java.lang.Runnable
            public final void run() {
                this.f.l(str);
            }
        });
    }

    public void p() {
        this.c = null;
        q53.f(this.b, "scan");
        this.a.forEach(new Consumer() { // from class: dy3
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((Future) obj).cancel(true);
            }
        });
        this.a.clear();
    }
}
