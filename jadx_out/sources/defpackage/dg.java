package defpackage;

import defpackage.di1;
import j$.time.DateTimeException;
import j$.time.ZonedDateTime;
import j$.time.format.DateTimeFormatter;
import j$.util.stream.DesugarCollectors;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.function.Function;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class dg {
    public static final List a;

    static {
        di1.a aVar = di1.a.HIGH;
        oi1 oi1Var = new oi1("10.jpg", -1, 1200, aVar);
        di1.a aVar2 = di1.a.LOW;
        oi1 oi1Var2 = new oi1("101.jpg", 90, -1, aVar2);
        di1.a aVar3 = di1.a.MEDIUM;
        a = av4.a(new oi1[]{oi1Var, oi1Var2, new oi1("170.jpg", 422, -1, aVar3), new oi1("171.jpg", 646, -1, aVar3), new oi1("20.jpg", -1, 1024, aVar), new oi1("200.jpg", 420, -1, aVar3), new oi1("201.jpg", 280, -1, aVar3), new oi1("202.jpg", 140, -1, aVar2), new oi1("204.jpg", 360, -1, aVar3), new oi1("205.jpg", 240, -1, aVar3), new oi1("206.jpg", 180, -1, aVar3), new oi1("207.jpg", 120, -1, aVar2), new oi1("43.jpg", 100, -1, aVar2), new oi1("44.jpg", 200, -1, aVar3)});
    }

    public static /* synthetic */ di1 a(String str, oi1 oi1Var) {
        return new di1(str + oi1Var.c(), oi1Var.a(), oi1Var.d(), oi1Var.b());
    }

    public static ko1 b(String str) throws s83 {
        try {
            return (ko1) lo1.d().a(a33.a().j("https://bandcamp.com/api/mobile/22/band_details", Collections.EMPTY_MAP, ((po1) ((po1) ((po1) zo1.a().n()).E("band_id", str)).j()).H().getBytes(StandardCharsets.UTF_8)).c());
        } catch (fo3 | IOException | mo1 e) {
            uo1.a("Could not download band details", e);
            return null;
        }
    }

    public static String c(long j, boolean z) {
        return "https://f4.bcbits.com/img/" + (z ? 'a' : "") + j + "_10.jpg";
    }

    public static List d(final String str) {
        return (List) a.stream().map(new Function() { // from class: cg
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return dg.a(str, (oi1) obj);
            }
        }).collect(DesugarCollectors.toUnmodifiableList());
    }

    public static List e(long j, boolean z) {
        if (j == 0) {
            return Collections.EMPTY_LIST;
        }
        return d("https://f4.bcbits.com/img/" + (z ? 'a' : "") + j + "_");
    }

    public static List f(String str) {
        return yy4.n(str) ? Collections.EMPTY_LIST : d(str.replaceFirst("_\\d+\\.\\w+", "_"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean g(String str) throws s83 {
        if (str.toLowerCase().matches("https?://.+\\.bandcamp\\.com(/.*)?")) {
            return true;
        }
        if (str.toLowerCase().matches("https?://bandcamp\\.com(/.*)?")) {
            return false;
        }
        try {
            return ((br0) ((br0) cp1.a(a33.a().b(yy4.u(str)).c()).y0("cart-wrapper").get(0)).z0("a").get(0)).e("href").equals("https://bandcamp.com/cart");
        } catch (fo3 | IOException unused) {
            ny4.a("Could not determine whether URL is custom domain (not available? network error?)");
            return false;
        } catch (IndexOutOfBoundsException | NullPointerException unused2) {
            return false;
        }
    }

    public static boolean h(String str) {
        return str.toLowerCase().matches("https?://bandcamp\\.com/\\?show=\\d+");
    }

    public static qa0 i(String str) throws s83 {
        try {
            return new qa0(ZonedDateTime.parse(str, DateTimeFormatter.ofPattern("dd MMM yyyy HH:mm:ss zzz", Locale.ENGLISH)).toInstant());
        } catch (DateTimeException e) {
            pa0.a("Could not parse date '", str, "'", e);
            return null;
        }
    }
}
