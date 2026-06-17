package defpackage;

import android.text.TextUtils;
import com.fongmi.android.tv.bean.Channel;
import com.fongmi.android.tv.bean.Group;
import com.fongmi.android.tv.bean.Live;
import com.fongmi.android.tv.bean.Result;
import defpackage.ww1;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.stream.IntStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ww1 {
    public static final Map a = new ConcurrentHashMap();
    public static final Map b = new ConcurrentHashMap();
    public static final Map c = new ConcurrentHashMap();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends to3 {
        public final Channel a;
        public final String b;
        public final int c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(Channel channel, String str, int i) {
            this.a = channel;
            this.b = str;
            this.c = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private /* synthetic */ boolean a(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.c == aVar.c && Objects.equals(this.a, aVar.a) && Objects.equals(this.b, aVar.b);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private /* synthetic */ Object[] b() {
            return new Object[]{this.a, this.b, Integer.valueOf(this.c)};
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Channel e() {
            return this.a;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean equals(Object obj) {
            return a(obj);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String f() {
            return this.b;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int hashCode() {
            return vw1.a(this.c, this.a, this.b);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final String toString() {
            return yq.a(b(), a.class, "a;b;c");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean a(String str, String str2, Map.Entry entry) {
        return ((a) entry.getValue()).f().equals(str) && ((a) entry.getValue()).e().getName().equals(str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void g() {
        c.clear();
        a.clear();
        b.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String h() {
        String keep = l().getKeep();
        if (TextUtils.isEmpty(keep)) {
            return null;
        }
        String[] strArrSplit = keep.split("@@@");
        if (strArrSplit.length < 2) {
            return null;
        }
        final String str = strArrSplit[0];
        final String str2 = strArrSplit[1];
        i("LG:" + str);
        Integer num = (Integer) b.get(str);
        if (num == null || num.intValue() == 0) {
            return null;
        }
        return (String) c.entrySet().stream().filter(new Predicate() { // from class: tw1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ww1.a(str, str2, (Map.Entry) obj);
            }
        }).map(new Function() { // from class: uw1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (String) ((Map.Entry) obj).getKey();
            }
        }).findFirst().orElse(null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xi1 i(String str) {
        final String strSubstring = str.substring(3);
        Group groupOrElse = l().getGroups().stream().filter(new Predicate() { // from class: pw1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Group) obj).getName().equals(strSubstring);
            }
        }).findFirst().orElse(null);
        if (groupOrElse == null) {
            b.put(strSubstring, 0);
            return xi1.u();
        }
        a.keySet().removeIf(new Predicate() { // from class: qw1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((String) obj).startsWith(strSubstring + '|');
            }
        });
        c.values().removeIf(new Predicate() { // from class: rw1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((ww1.a) obj).b.equals(strSubstring);
            }
        });
        final List<Channel> channel = groupOrElse.getChannel();
        b.put(strSubstring, Integer.valueOf(channel.size()));
        return (xi1) IntStream.range(0, channel.size()).mapToObj(new IntFunction() { // from class: sw1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.IntFunction
            public final Object apply(int i) {
                return ww1.k(strSubstring, (Channel) channel.get(i), i);
            }
        }).collect(xi1.H());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xi1 j() {
        return (xi1) l().getGroups().stream().map(new Function() { // from class: ow1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Group group = (Group) obj;
                return il.g("LG:" + group.getName(), group.getName());
            }
        }).collect(xi1.H());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fg2 k(String str, Channel channel, int i) {
        String strM = m(str, i);
        String str2 = "LC:" + strM;
        a.put(strM, str2);
        c.put(str2, new a(channel, str, i));
        return il.m(str2, channel.getNumber() + " " + channel.getShow(), null, channel.getLogo());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Live l() {
        lx1.J().f();
        return lx1.J().M();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String m(String str, int i) {
        return str + '|' + i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fg2 n(String str, int i) {
        if (str.startsWith("LC:")) {
            return o(str, i);
        }
        String strH = h();
        if (strH != null) {
            return o(strH, i);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fg2 o(String str, int i) {
        Integer num;
        Map map = c;
        a aVar = (a) map.get(str);
        if (aVar == null || (num = (Integer) b.get(aVar.b)) == null || num.intValue() == 0) {
            return null;
        }
        String str2 = (String) a.get(m(aVar.b, il.t(aVar.c, i, num.intValue())));
        if (str2 == null) {
            return null;
        }
        a aVar2 = (a) map.get(str2);
        return q(aVar2 != null ? aVar2.e() : null, str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fg2 p(String str) {
        a aVar = (a) c.get(str);
        return q(aVar != null ? aVar.e() : null, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fg2 q(Channel channel, String str) {
        if (channel == null || TextUtils.isEmpty(channel.getCurrent())) {
            return null;
        }
        Result resultF = nw1.f(channel);
        if (TextUtils.isEmpty(resultF.getRealUrl())) {
            return null;
        }
        il.n(str, resultF);
        return il.s(str, resultF.getRealUrl(), channel.getShow(), null, channel.getLogo());
    }
}
