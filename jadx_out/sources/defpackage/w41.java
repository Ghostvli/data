package defpackage;

import j$.time.ZoneId;
import j$.time.ZoneOffset;
import j$.time.format.DateTimeFormatter;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class w41 {
    public static final DateTimeFormatter a;
    public static final DateTimeFormatter b;
    public static final DateTimeFormatter c;
    public static final DateTimeFormatter d;
    public static final DateTimeFormatter e;
    public static final DateTimeFormatter f;
    public static final DateTimeFormatter g;
    public static final DateTimeFormatter h;
    public static final DateTimeFormatter i;
    public static final DateTimeFormatter j;

    static {
        Locale locale = Locale.ROOT;
        a = DateTimeFormatter.ofPattern("yyyy-MM-dd", locale);
        b = DateTimeFormatter.ofPattern("HH:mm", locale);
        c = DateTimeFormatter.ofPattern("HH:mm:ss", locale).withZone(ZoneId.systemDefault());
        d = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss", locale);
        e = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm", locale);
        f = DateTimeFormatter.ofPattern("yyyy-MM-ddHH:mm:ss", locale);
        g = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss'Z'", locale).withZone(ZoneOffset.UTC);
        h = DateTimeFormatter.ofPattern("yyyyMMddHHmmss Z", locale);
        i = DateTimeFormatter.ofPattern("yyyyMMddHHmmss", locale);
        j = DateTimeFormatter.ofPattern("yyyyMMddHHmmss ZZZ", locale);
    }
}
