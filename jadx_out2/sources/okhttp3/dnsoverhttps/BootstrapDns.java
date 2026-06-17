package okhttp3.dnsoverhttps;

import defpackage.il1;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;
import okhttp3.Dns;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class BootstrapDns implements Dns {
    private final String dnsHostname;
    private final List<InetAddress> dnsServers;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: java.util.List<? extends java.net.InetAddress> */
    /* JADX WARN: Multi-variable type inference failed */
    public BootstrapDns(String str, List<? extends InetAddress> list) {
        str.getClass();
        list.getClass();
        this.dnsHostname = str;
        this.dnsServers = list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.Dns
    public List<InetAddress> lookup(String str) throws UnknownHostException {
        str.getClass();
        if (il1.a(this.dnsHostname, str)) {
            return this.dnsServers;
        }
        throw new UnknownHostException("BootstrapDns called for " + str + " instead of " + this.dnsHostname);
    }
}
