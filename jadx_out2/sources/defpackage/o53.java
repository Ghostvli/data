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

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: ?: TERNARY null = ((wrap:int:0x0000: ARRAY_LENGTH (r1v0 java.lang.String[]) A[WRAPPED] (LINE:1)) == (2 int)) ? true : false */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean b(String[] strArr) {
        return strArr.length == 2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ String c(String str, String str2) {
        return str2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f(List list) {
        this.a.putAll((Map) list.stream().filter(new v53()).map(new Function() { // from class: j53
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((String) obj).split("=", 2);
            }
        }).filter(new Predicate() { // from class: k53
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return o53.b((String[]) obj);
            }
        }).collect(Collectors.toMap(new Function() { // from class: l53
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((String[]) obj)[0].trim();
            }
        }, new Function() { // from class: m53
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((String[]) obj)[1].trim();
            }
        }, new BinaryOperator() { // from class: n53
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return o53.c((String) obj, (String) obj2);
            }
        })));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g() {
        this.a.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i(an0 an0Var) {
        if (an0Var.f().isEmpty()) {
            return;
        }
        this.b = new DnsOverHttps.Builder().client(new OkHttpClient()).url(HttpUrl.get(an0Var.f())).bootstrapDnsHosts(an0Var.c()).build();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.Dns
    public List lookup(String str) {
        Dns dns = this.b;
        if (dns == null) {
            dns = Dns.SYSTEM;
        }
        return dns.lookup(h(str));
    }
}
