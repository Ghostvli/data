package defpackage;

import android.net.Uri;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import j$.util.stream.Stream$EL;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class qi3 implements Comparable<qi3> {

    @SerializedName("name")
    private String f;

    @SerializedName("hosts")
    private List<String> g;

    @SerializedName("urls")
    private List<String> h;
    public List i;
    public boolean j;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends TypeToken<List<qi3>> {
    }

    public static List e(JsonElement jsonElement) {
        try {
            List list = (List) new Gson().fromJson(jsonElement, new a().getType());
            return list == null ? Collections.EMPTY_LIST : list;
        } catch (Exception unused) {
            return Collections.EMPTY_LIST;
        }
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public int compareTo(qi3 qi3Var) {
        return Boolean.compare(this.j, qi3Var.j);
    }

    public final Proxy g(String str) {
        Uri uri = Uri.parse(str);
        if (uri.getScheme() != null && uri.getHost() != null && uri.getPort() > 0) {
            if (uri.getScheme().startsWith("http")) {
                return new Proxy(Proxy.Type.HTTP, InetSocketAddress.createUnresolved(uri.getHost(), uri.getPort()));
            }
            if (uri.getScheme().startsWith("socks")) {
                return new Proxy(Proxy.Type.SOCKS, InetSocketAddress.createUnresolved(uri.getHost(), uri.getPort()));
            }
        }
        return null;
    }

    public List h() {
        List<String> list = this.g;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public List i() {
        List list = this.i;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public List j() {
        List<String> list = this.h;
        return list == null ? Collections.EMPTY_LIST : list;
    }

    public void k() {
        this.j = h().stream().anyMatch(new Predicate() { // from class: ni3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((String) obj).contains("*");
            }
        });
        this.i = Stream$EL.toList(j().stream().map(new Function() { // from class: oi3
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return this.a.g((String) obj);
            }
        }).filter(new Predicate() { // from class: pi3
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return Objects.nonNull((Proxy) obj);
            }
        }));
    }
}
