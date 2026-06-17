package defpackage;

import android.util.Log;
import com.fongmi.android.tv.bean.Channel;
import com.fongmi.android.tv.bean.Epg;
import com.fongmi.android.tv.bean.EpgData;
import com.fongmi.android.tv.bean.Group;
import com.fongmi.android.tv.bean.Live;
import com.fongmi.android.tv.bean.Tv;
import com.github.catvod.utils.Path;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.LocalDateTime;
import j$.time.OffsetDateTime;
import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.ZonedDateTime;
import j$.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.simpleframework.xml.core.Persister;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class yt0 {
    public static final String a = "yt0";

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public Map a;
        public Map b;

        public a(Map map, Map map2) {
            this.a = map;
            this.b = map2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public Tv a;
        public Map b;

        public b(Tv tv2, Map map) {
            this.a = tv2;
            this.b = map;
        }
    }

    public static /* synthetic */ boolean c(String str) {
        return !str.isEmpty();
    }

    public static /* synthetic */ Map f(String str) {
        return new HashMap();
    }

    public static /* synthetic */ void h(Map map, Channel channel) {
        if (!channel.getTvgId().isEmpty()) {
            map.putIfAbsent(channel.getTvgId(), channel);
        }
        if (!channel.getTvgName().isEmpty()) {
            map.putIfAbsent(channel.getTvgName(), channel);
        }
        if (channel.getName().isEmpty()) {
            return;
        }
        map.putIfAbsent(channel.getName(), channel);
    }

    public static /* synthetic */ void i(a aVar, int[] iArr, Channel channel) {
        String str;
        String tvgId = channel.getTvgId();
        Map map = (Map) aVar.a.get(tvgId);
        if (map != null) {
            channel.setDataList(new ArrayList(map.values()));
            iArr[0] = iArr[0] + 1;
        } else {
            iArr[1] = iArr[1] + 1;
        }
        if (!channel.getLogo().isEmpty() || (str = (String) aVar.b.get(tvgId)) == null) {
            return;
        }
        channel.setLogo(str);
    }

    public static void j(Live live, final a aVar) {
        final int[] iArr = {0, 0};
        live.getGroups().stream().flatMap(new Function() { // from class: pt0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Group) obj).getChannel().stream();
            }
        }).forEach(new Consumer() { // from class: qt0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                yt0.i(aVar, iArr, (Channel) obj);
            }
        });
        Log.i(a, "bindResultsToLive with-epg=" + iArr[0] + " without-epg=" + iArr[1]);
    }

    public static Channel k(String str, final Map map, Map map2) {
        Channel channel = (Channel) map.get(str);
        if (channel != null) {
            return channel;
        }
        List list = (List) map2.get(str);
        if (list == null) {
            return null;
        }
        return (Channel) list.stream().flatMap(new Function() { // from class: wt0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Tv.Channel) obj).getDisplayName().stream();
            }
        }).map(new Function() { // from class: xt0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Tv.DisplayName) obj).getText();
            }
        }).filter(new Predicate() { // from class: mt0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return yt0.c((String) obj);
            }
        }).filter(new Predicate() { // from class: nt0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return map.containsKey((String) obj);
            }
        }).findFirst().map(new Function() { // from class: ot0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return (Channel) map.get((String) obj);
            }
        }).orElse(null);
    }

    public static Epg l(String str, String str2, final ZoneId zoneId) {
        try {
            Tv tv2 = (Tv) new Persister().read(Tv.class, str, false);
            String date = tv2.getDate();
            final Epg epgCreate = Epg.create(str2, date.isEmpty() ? LocalDate.now(zoneId).format(w41.a) : q(date, zoneId).atZoneSameInstant(zoneId).format(w41.a));
            tv2.getProgramme().forEach(new Consumer() { // from class: lt0
                @Override // java.util.function.Consumer
                public final void accept(Object obj) {
                    epgCreate.getList().add(yt0.m((Tv.Programme) obj, zoneId));
                }
            });
            return epgCreate;
        } catch (Exception e) {
            Log.w(a, "getEpg parse failed key=" + str2 + ": " + e.getMessage());
            return new Epg();
        }
    }

    public static EpgData m(Tv.Programme programme, ZoneId zoneId) {
        return n(q(programme.getStart(), zoneId), q(programme.getStop(), zoneId), zoneId, programme);
    }

    public static EpgData n(OffsetDateTime offsetDateTime, OffsetDateTime offsetDateTime2, ZoneId zoneId, Tv.Programme programme) {
        try {
            EpgData epgData = new EpgData();
            epgData.setTitle(programme.getTitle());
            ZonedDateTime zonedDateTimeAtZoneSameInstant = offsetDateTime.atZoneSameInstant(zoneId);
            DateTimeFormatter dateTimeFormatter = w41.b;
            epgData.setStart(zonedDateTimeAtZoneSameInstant.format(dateTimeFormatter));
            epgData.setEnd(offsetDateTime2.atZoneSameInstant(zoneId).format(dateTimeFormatter));
            epgData.setStartTime(offsetDateTime.toInstant().toEpochMilli());
            epgData.setEndTime(offsetDateTime2.toInstant().toEpochMilli());
            epgData.trans();
            return epgData;
        } catch (Exception unused) {
            return new EpgData();
        }
    }

    public static boolean o(File file) {
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                boolean z = (fileInputStream.read() | (fileInputStream.read() << 8)) == 35615;
                fileInputStream.close();
                return z;
            } finally {
            }
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean p(long j) {
        return LocalDate.ofInstant(Instant.ofEpochMilli(j), ZoneId.systemDefault()).equals(LocalDate.now());
    }

    public static OffsetDateTime q(String str, ZoneId zoneId) {
        String strTrim = str.trim();
        int length = strTrim.length();
        try {
            if (length >= 20) {
                return OffsetDateTime.parse(strTrim, strTrim.charAt(length + (-3)) == ':' ? w41.j : w41.h);
            }
            return LocalDateTime.parse(length > 14 ? strTrim.substring(0, 14) : strTrim, w41.i).M(zoneId).toOffsetDateTime();
        } catch (Exception e) {
            Log.w(a, "parseFull failed: " + strTrim + " -> " + e.getMessage());
            return OffsetDateTime.ofInstant(Instant.EPOCH, ZoneOffset.UTC);
        }
    }

    public static b r(File file) {
        Tv tv2 = (Tv) new Persister().read(Tv.class, file, false);
        return new b(tv2, (Map) tv2.getChannel().stream().collect(Collectors.groupingBy(new Function() { // from class: rt0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Tv.Channel) obj).getId();
            }
        })));
    }

    public static Map s(Live live) {
        final HashMap map = new HashMap();
        live.getGroups().stream().flatMap(new Function() { // from class: ut0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((Group) obj).getChannel().stream();
            }
        }).forEach(new Consumer() { // from class: vt0
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                yt0.h(map, (Channel) obj);
            }
        });
        return map;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0060 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static yt0.a t(yt0.b r17, java.util.Map r18, j$.time.ZoneId r19) {
        /*
            Method dump skipped, instruction units count: 247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.yt0.t(yt0$b, java.util.Map, j$.time.ZoneId):yt0$a");
    }

    public static void u(Live live, File file, boolean z) {
        File fileEpg = Path.epg(file.getName() + ".xml");
        if (!Path.exists(fileEpg) || z) {
            w01.n(file, fileEpg);
        }
        v(live, fileEpg);
    }

    public static void v(Live live, File file) {
        ZoneId zoneIdY = y(live.getTimeZone());
        j(live, t(r(file), s(live), zoneIdY));
    }

    public static String w(File file) {
        if (!Path.exists(file)) {
            return "file-missing";
        }
        if (!p(file.lastModified())) {
            return "not-today";
        }
        if (System.currentTimeMillis() - file.lastModified() > 21600000) {
            return "older-than-6h";
        }
        return null;
    }

    public static void x(Live live, String str) {
        String str2;
        long jCurrentTimeMillis = System.currentTimeMillis();
        File fileEpg = Path.epg(qx4.g(str));
        String strW = w(fileEpg);
        boolean z = strW != null;
        String str3 = a;
        StringBuilder sb = new StringBuilder("start url=");
        sb.append(str);
        sb.append(" file=");
        sb.append(fileEpg.getName());
        sb.append(" refresh=");
        sb.append(z);
        if (z) {
            str2 = " reason=" + strW;
        } else {
            str2 = "";
        }
        sb.append(str2);
        Log.i(str3, sb.toString());
        if (z) {
            fn0.a(str, fileEpg).d();
        }
        if (o(fileEpg)) {
            u(live, fileEpg, z);
        } else {
            v(live, fileEpg);
        }
        Log.i(str3, "start done elapsed=" + (System.currentTimeMillis() - jCurrentTimeMillis) + "ms");
    }

    public static ZoneId y(String str) {
        if (str.isEmpty()) {
            return ZoneId.systemDefault();
        }
        try {
            return ZoneId.of(str);
        } catch (Exception unused) {
            return ZoneId.systemDefault();
        }
    }
}
