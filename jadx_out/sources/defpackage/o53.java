package defpackage;

import com.github.catvod.utils.Util;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import okhttp3.Dns;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.dnsoverhttps.DnsOverHttps;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class o53 implements Dns {
    public final ConcurrentHashMap a = new ConcurrentHashMap();
    public DnsOverHttps b;

    public static /* synthetic */ boolean b(String[] strArr) {
        return strArr.length == 2;
    }

    public static /* synthetic */ String c(String str, String str2) {
        return str2;
    }

    public void f(List list) {
        this.a.putAll((Map) list.stream().filter(new v53()).map(new Function() { // from class: j53
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((String) obj).split("=", 2);
            }
        }).filter(new Predicate() { // from class: k53
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return o53.b((String[]) obj);
            }
        }).collect(Collectors.toMap(new Function() { // from class: l53
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((String[]) obj)[0].trim();
            }
        }, new Function() { // from class: m53
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((String[]) obj)[1].trim();
            }
        }, new BinaryOperator() { // from class: n53
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return o53.c((String) obj, (String) obj2);
            }
        })));
    }

    public void g() {
        this.a.clear();
    }

    public final String h(String str) {
        String str2 = (String) this.a.get(str);
        if (str2 != null) {
            return str2;
        }
        for (Map.Entry entry : this.a.entrySet()) {
            if (Util.containOrMatch(str, (String) entry.getKey())) {
                return (String) entry.getValue();
            }
        }
        return str;
    }

    public void i(an0 an0Var) {
        if (an0Var.f().isEmpty()) {
            return;
        }
        this.b = new DnsOverHttps.Builder().client(new OkHttpClient()).url(HttpUrl.get(an0Var.f())).bootstrapDnsHosts(an0Var.c()).build();
    }

    @Override // okhttp3.Dns
    public List lookup(String str) {
        Dns dns = this.b;
        if (dns == null) {
            dns = Dns.SYSTEM;
        }
        return dns.lookup(h(str));
    }
}
