package defpackage;

import android.text.TextUtils;
import com.fongmi.android.tv.bean.Episode;
import com.fongmi.android.tv.bean.Flag;
import com.fongmi.android.tv.bean.History;
import com.fongmi.android.tv.bean.Result;
import com.fongmi.android.tv.bean.Site;
import com.fongmi.android.tv.bean.Vod;
import com.github.catvod.utils.Trans;
import defpackage.n65;
import j$.util.stream.Stream$EL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class n65 {
    public static volatile History e;
    public static final Map a = new ConcurrentHashMap();
    public static final Map b = new ConcurrentHashMap();
    public static final Map c = new ConcurrentHashMap();
    public static final Map d = new ConcurrentHashMap();
    public static volatile xi1 f = xi1.u();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends to3 {
        public final String a;
        public final String b;
        public final int c;
        public final String d;
        public final String e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(String str, String str2, int i, String str3, String str4) {
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = str3;
            this.e = str4;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private /* synthetic */ boolean a(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.c == aVar.c && Objects.equals(this.a, aVar.a) && Objects.equals(this.b, aVar.b) && Objects.equals(this.d, aVar.d) && Objects.equals(this.e, aVar.e);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private /* synthetic */ Object[] b() {
            return new Object[]{this.a, this.b, Integer.valueOf(this.c), this.d, this.e};
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean equals(Object obj) {
            return a(obj);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int hashCode() {
            return m65.a(this.c, this.a, this.b, this.d, this.e);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final String toString() {
            return yq.a(b(), a.class, "a;b;c;d;e");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xi1 A() {
        return f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void B(String str, String str2, int i, History history) {
        String strT = t(str, str2, i);
        String str3 = "VE:" + strT;
        c.put(str3, new a(str, str2, i, history.getSiteKey(), history.getVodPic()));
        b.put(strT, str3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int C(fg2 fg2Var, String str) {
        CharSequence charSequence = fg2Var.e.a;
        if (charSequence == null) {
            return 0;
        }
        String strT2s = Trans.t2s(charSequence.toString());
        if (strT2s.equals(str)) {
            return 2;
        }
        return strT2s.contains(str) ? 1 : 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fg2 D(String str, int i) {
        if (str.startsWith("VE:")) {
            return E(str, i);
        }
        String strR = r(str);
        if (strR != null) {
            return E(strR, i);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fg2 E(String str, int i) {
        a aVar = (a) c.get(str);
        if (aVar == null) {
            return null;
        }
        Integer num = (Integer) d.get(aVar.a + '|' + aVar.b);
        if (num == null || num.intValue() == 0) {
            return null;
        }
        String str2 = (String) b.get(t(aVar.a, aVar.b, il.t(aVar.c, i, num.intValue())));
        if (str2 == null) {
            return null;
        }
        if (e != null) {
            e.setPosition(0L);
        }
        return G(str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fg2 F(String str) {
        if (str.startsWith("VP:")) {
            return H(str);
        }
        if (str.startsWith("VE:")) {
            return G(str);
        }
        if (str.startsWith("VS:")) {
            return I(str);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fg2 G(String str) {
        Vod vodY;
        Flag flagW;
        a aVar = (a) c.get(str);
        if (aVar == null || (vodY = y(aVar.a)) == null || (flagW = w(vodY, aVar.b)) == null || aVar.c >= flagW.getEpisodes().size()) {
            return null;
        }
        Episode episode = flagW.getEpisodes().get(aVar.c);
        Result resultL = d84.l(aVar.d, aVar.b, episode.getUrl());
        if (TextUtils.isEmpty(resultL.getRealUrl())) {
            return null;
        }
        N(episode);
        il.n(str, resultL);
        String name = vodY.getName();
        if (TextUtils.isEmpty(name) && e != null) {
            name = e.getVodName();
        }
        return il.s(str, resultL.getRealUrl(), name, episode.getName(), aVar.e);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fg2 H(String str) {
        String strR = r(str.substring(3));
        if (strR != null) {
            return G(strR);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fg2 I(String str) {
        String strSubstring = str.substring(3);
        int iIndexOf = strSubstring.indexOf(Token.IMPORT);
        if (iIndexOf < 0) {
            return null;
        }
        String strSubstring2 = strSubstring.substring(0, iIndexOf);
        String strSubstring3 = strSubstring.substring(iIndexOf + 1);
        String str2 = strSubstring2 + "@@@" + strSubstring3;
        History historyFind = History.find(str2);
        if (historyFind != null) {
            return J(str2, historyFind);
        }
        b75.I().f();
        Vod vod = d84.h(strSubstring2, strSubstring3).getVod();
        if (!TextUtils.isEmpty(vod.getId()) && !vod.getFlags().isEmpty()) {
            a.put(str2, vod);
            History historyQ = q(str2, vod);
            Flag flagW = w(vod, historyQ.getVodFlag());
            if (flagW != null && !flagW.getEpisodes().isEmpty()) {
                int iM = m(str2, flagW, historyQ);
                e = historyQ;
                String str3 = (String) b.get(t(str2, flagW.getFlag(), iM));
                if (str3 != null) {
                    return G(str3);
                }
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fg2 J(String str, History history) {
        String strS = s(str, history);
        if (strS != null) {
            return G(strS);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean K(long j, long j2) {
        if (e == null || q24.I()) {
            return false;
        }
        final History history = e;
        history.setPosition(j);
        history.setDuration(j2);
        history.setCreateTime(System.currentTimeMillis());
        if (!history.canSave()) {
            return true;
        }
        ul4.c(new Runnable() { // from class: z55
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                history.merge().save();
            }
        });
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xi1 L(String str) {
        b75.I().f();
        final String strT2s = Trans.t2s(str);
        List listO = o(Stream$EL.toList(Stream$EL.toList(b75.I().Y().stream().filter(new j65())).stream().map(new Function() { // from class: k65
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ul4.e().submit(new Callable() { // from class: b65
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return n65.M(site, str);
                    }
                });
            }
        })));
        listO.sort(new Comparator() { // from class: l65
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return n65.g(strT2s, (fg2) obj, (fg2) obj2);
            }
        });
        f = xi1.p(listO.subList(0, Math.min(listO.size(), 50)));
        return f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List M(final Site site, String str) {
        return Stream$EL.toList(d84.m(site, str, false, "1").getList().stream().map(new Function() { // from class: c65
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                Vod vod = (Vod) obj;
                return il.m("VS:" + site.getKey() + "|" + vod.getId(), vod.getName(), vod.getRemarks(), vod.getPic());
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void N(Episode episode) {
        if (e == null) {
            return;
        }
        e.setVodRemarks(episode.getName());
        e.setEpisodeUrl(episode.getUrl());
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0008: ARITH (wrap:int:0x0000: INVOKE (r2v0 fg2), (r0v0 java.lang.String) STATIC call: n65.C(fg2, java.lang.String):int A[MD:(fg2, java.lang.String):int (m), WRAPPED] (LINE:1)) - (wrap:int:0x0004: INVOKE (r1v0 fg2), (r0v0 java.lang.String) STATIC call: n65.C(fg2, java.lang.String):int A[MD:(fg2, java.lang.String):int (m), WRAPPED] (LINE:5)) (LINE:9) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ int g(String str, fg2 fg2Var, fg2 fg2Var2) {
        return C(fg2Var2, str) - C(fg2Var, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int m(final String str, Flag flag, final History history) {
        final String str2 = str + "|";
        c.values().removeIf(new Predicate() { // from class: f65
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((n65.a) obj).a.equals(str);
            }
        });
        b.keySet().removeIf(new Predicate() { // from class: g65
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((String) obj).startsWith(str2);
            }
        });
        Map map = d;
        map.keySet().removeIf(new Predicate() { // from class: h65
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((String) obj).startsWith(str2);
            }
        });
        final String flag2 = flag.getFlag();
        List<Episode> episodes = flag.getEpisodes();
        map.put(str + '|' + flag2, Integer.valueOf(episodes.size()));
        IntStream.range(0, episodes.size()).forEach(new IntConsumer() { // from class: i65
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.IntConsumer
            public final void accept(int i) {
                n65.B(str, flag2, i, history);
            }
        });
        return v(flag, history);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void n() {
        a.clear();
        b.clear();
        c.clear();
        d.clear();
        e = null;
        f = xi1.u();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List o(List list) {
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                List list2 = (List) ((lu1) it.next()).get(5L, TimeUnit.SECONDS);
                if (list2 != null) {
                    arrayList.addAll(list2);
                }
            } catch (Exception unused) {
            }
            if (arrayList.size() >= 50) {
                break;
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long p() {
        if (e == null) {
            return -9223372036854775807L;
        }
        History history = e;
        long position = history.getPosition();
        history.setPosition(0L);
        if (position > 0) {
            return position;
        }
        return -9223372036854775807L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static History q(String str, Vod vod) {
        History history = new History();
        history.setKey(str);
        history.setCid(b75.K());
        history.setVodName(vod.getName());
        history.setVodPic(vod.getPic());
        history.findEpisode(vod.getFlags());
        return history;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String r(String str) {
        return s(str, History.find(str));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String s(String str, History history) {
        Vod vodZ;
        Flag flagW;
        if (history == null || (vodZ = z(str, history)) == null || (flagW = w(vodZ, history.getVodFlag())) == null || flagW.getEpisodes().isEmpty()) {
            return null;
        }
        int iM = m(str, flagW, history);
        e = history;
        return (String) b.get(t(str, flagW.getFlag(), iM));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String t(String str, String str2, int i) {
        return str + '|' + str2 + '|' + i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Vod u(History history) {
        b75.I().f();
        Vod vod = d84.h(history.getSiteKey(), history.getVodId()).getVod();
        if (TextUtils.isEmpty(vod.getId())) {
            return null;
        }
        return vod;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int v(Flag flag, History history) {
        final String url = history.getEpisode() != null ? history.getEpisode().getUrl() : null;
        if (TextUtils.isEmpty(url)) {
            return 0;
        }
        final List<Episode> episodes = flag.getEpisodes();
        return IntStream.range(0, episodes.size()).filter(new IntPredicate() { // from class: a65
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.IntPredicate
            public final boolean test(int i) {
                return ((Episode) episodes.get(i)).getUrl().equals(url);
            }
        }).findFirst().orElse(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Flag w(Vod vod, final String str) {
        if (vod.getFlags().isEmpty()) {
            return null;
        }
        return !TextUtils.isEmpty(str) ? vod.getFlags().stream().filter(new Predicate() { // from class: e65
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Flag) obj).getFlag().equals(str);
            }
        }).findFirst().orElse(vod.getFlags().get(0)) : vod.getFlags().get(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xi1 x() {
        return (xi1) History.get().stream().map(new Function() { // from class: d65
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                History history = (History) obj;
                return il.m("VP:" + history.getKey(), history.getVodName(), history.getVodRemarks(), history.getVodPic());
            }
        }).collect(xi1.H());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Vod y(String str) {
        Vod vod = (Vod) a.get(str);
        return vod != null ? vod : z(str, History.find(str));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Vod z(String str, History history) {
        Vod vodU;
        Map map = a;
        Vod vod = (Vod) map.get(str);
        if (vod != null) {
            return vod;
        }
        if (history == null || (vodU = u(history)) == null) {
            return null;
        }
        map.put(str, vodU);
        return vodU;
    }
}
