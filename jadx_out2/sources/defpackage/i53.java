package defpackage;

import android.net.Uri;
import com.github.catvod.utils.Auth;
import com.github.catvod.utils.Util;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class i53 implements Authenticator {
    public final List a = new CopyOnWriteArrayList();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a(List list) {
        this.a.addAll(list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.Authenticator
    public Request authenticate(Route route, Response response) {
        String userInfo;
        if (route != null && response.request().header("Proxy-Authorization") == null) {
            SocketAddress socketAddressAddress = route.proxy().address();
            if (socketAddressAddress instanceof InetSocketAddress) {
                String strHost = response.request().url().host();
                String hostName = ((InetSocketAddress) socketAddressAddress).getHostName();
                for (qi3 qi3Var : this.a) {
                    Iterator it = qi3Var.h().iterator();
                    while (it.hasNext()) {
                        if (Util.containOrMatch(strHost, (String) it.next())) {
                            for (String str : qi3Var.j()) {
                                if (str.contains(hostName) && (userInfo = Uri.parse(str).getUserInfo()) != null) {
                                    return response.request().newBuilder().header("Proxy-Authorization", Auth.basic(userInfo)).build();
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b() {
        this.a.clear();
    }
}
