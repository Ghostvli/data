package defpackage;

import com.fongmi.android.tv.bean.Channel;
import com.fongmi.android.tv.bean.Epg;
import com.fongmi.android.tv.bean.EpgData;
import com.fongmi.android.tv.bean.Group;
import com.fongmi.android.tv.bean.Live;
import com.fongmi.android.tv.bean.Result;
import j$.time.LocalDate;
import j$.time.ZoneId;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class nw1 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void d(Channel channel, ZoneId zoneId, int i) {
        final String str = LocalDate.now(zoneId).plusDays(i).format(w41.a);
        String strReplace = channel.getEpg().replace("{date}", str);
        if (strReplace.startsWith("http") && channel.getDataList().stream().noneMatch(new Predicate() { // from class: mw1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Epg) obj).equal(str);
            }
        })) {
            channel.setData(Epg.objectFrom(q53.E(strReplace), channel.getTvgId(), zoneId));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Epg e(Channel channel, ZoneId zoneId) {
        final String str = LocalDate.now(zoneId).format(w41.a);
        int[] iArr = {-1, 0, 1};
        for (int i = 0; i < 3; i++) {
            d(channel, zoneId, iArr[i]);
        }
        return channel.getDataList().stream().filter(new Predicate() { // from class: kw1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Epg) obj).equal(str);
            }
        }).findFirst().orElseGet(new Supplier() { // from class: lw1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Supplier
            public final Object get() {
                return new Epg();
            }
        }).selected();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Result f(Channel channel) {
        db4.f().j();
        Result result = channel.result();
        result.setUrl(db4.f().e(result));
        return result;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Result g(Channel channel, EpgData epgData) {
        Result resultF = f(channel);
        resultF.setUrl(channel.getCatchup().format(resultF.getRealUrl(), epgData));
        if (channel.isRtsp()) {
            resultF.getHeader().put("rtsp_range", epgData.getRange());
        }
        return resultF;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void h(Live live) {
        zx1.g(live.recent());
        live.getGroups().removeIf(new Predicate() { // from class: hw1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((Group) obj).isEmpty();
            }
        });
        if (live.getGroups().isEmpty() || live.getGroups().get(0).isKeep()) {
            return;
        }
        live.getGroups().add(0, Group.create(sm3.J));
        lx1.J().E(live.getGroups());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean i(final Live live) {
        return ((Boolean) live.getEpgXml().stream().map(new Function() { // from class: iw1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Boolean.valueOf(nw1.j(live, (String) obj));
            }
        }).reduce(Boolean.FALSE, new BinaryOperator() { // from class: jw1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.BiFunction
            public final Object apply(Object obj, Object obj2) {
                return Boolean.valueOf(Boolean.logicalOr(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue()));
            }
        })).booleanValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean j(Live live, String str) {
        try {
            yt0.x(live, str);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
