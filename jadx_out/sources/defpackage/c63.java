package defpackage;

import com.github.catvod.utils.Util;
import j$.util.stream.Stream$EL;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.SocketAddress;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.Consumer;
import java.util.stream.Stream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class c63 extends ProxySelector {
    public final List a = new CopyOnWriteArrayList();
    public final ProxySelector b = ProxySelector.getDefault();

    public synchronized void a(List list) {
        list.forEach(new Consumer() { // from class: b63
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                ((qi3) obj).k();
            }
        });
        List list2 = Stream$EL.toList(Stream.concat(this.a.stream(), list.stream()).sorted());
        this.a.clear();
        this.a.addAll(list2);
    }

    public void b() {
        this.a.clear();
    }

    public final List c(URI uri) {
        ProxySelector proxySelector = this.b;
        return proxySelector != null ? proxySelector.select(uri) : av4.a(new Object[]{Proxy.NO_PROXY});
    }

    @Override // java.net.ProxySelector
    public void connectFailed(URI uri, SocketAddress socketAddress, IOException iOException) {
        ProxySelector proxySelector = this.b;
        if (proxySelector != null) {
            proxySelector.connectFailed(uri, socketAddress, iOException);
        }
    }

    @Override // java.net.ProxySelector
    public List select(URI uri) {
        if (this.a.isEmpty() || uri.getHost() == null || "127.0.0.1".equals(uri.getHost())) {
            return c(uri);
        }
        for (qi3 qi3Var : this.a) {
            Iterator it = qi3Var.h().iterator();
            while (it.hasNext()) {
                if (Util.containOrMatch(uri.getHost(), (String) it.next())) {
                    return !qi3Var.i().isEmpty() ? qi3Var.i() : c(uri);
                }
            }
        }
        return c(uri);
    }
}
