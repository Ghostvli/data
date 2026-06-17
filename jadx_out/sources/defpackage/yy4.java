package defpackage;

import defpackage.p83;
import j$.net.URLDecoder;
import j$.net.URLEncoder;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class yy4 {
    public static final Pattern a = Pattern.compile("(https?)?://m\\.");
    public static final Pattern b = Pattern.compile("(https?)?://www\\.");

    public static /* synthetic */ Pattern[] a(int i) {
        return new Pattern[i];
    }

    public static /* synthetic */ boolean b(String str) {
        return (n(str) || str.equals("null")) ? false : true;
    }

    public static void c(String str, String str2) throws s83 {
        d(Pattern.compile(str), str2);
    }

    public static void d(Pattern pattern, String str) throws s83 {
        if (n(str)) {
            jl.a("Url can't be null or empty");
        } else {
            if (p83.h(pattern, str.toLowerCase())) {
                return;
            }
            ny4.a("Url doesn't match the pattern");
        }
    }

    public static String e(String str) {
        return URLDecoder.decode(str, StandardCharsets.UTF_8);
    }

    public static String f(String str) {
        return URLEncoder.encode(str, StandardCharsets.UTF_8);
    }

    public static String g(String str) {
        try {
            URL urlV = v(str);
            return (urlV.getHost().contains("google") && urlV.getPath().equals("/url")) ? e(p83.k("&url=([^&]+)(?:&|$)", str)) : str;
        } catch (Exception unused) {
            return str;
        }
    }

    public static String h(String str) throws s83 {
        try {
            URL urlV = v(str);
            return urlV.getProtocol() + "://" + urlV.getAuthority();
        } catch (MalformedURLException e) {
            String message = e.getMessage();
            if (message.startsWith("unknown protocol: ")) {
                return message.substring(18);
            }
            throw new s83("Malformed url: " + str, e);
        }
    }

    public static String i(URL url, String str) {
        String query = url.getQuery();
        if (query == null) {
            return null;
        }
        for (String str2 : query.split("&")) {
            String[] strArrSplit = str2.split("=", 2);
            if (e(strArrSplit[0]).equals(str)) {
                return e(strArrSplit[1]);
            }
        }
        return null;
    }

    public static String j(String str, String[] strArr, int i) {
        return k(str, (Pattern[]) Arrays.stream(strArr).filter(new v53()).map(new Function() { // from class: py4
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Pattern.compile((String) obj);
            }
        }).toArray(new IntFunction() { // from class: ry4
            @Override // java.util.function.IntFunction
            public final Object apply(int i2) {
                return yy4.a(i2);
            }
        }), i);
    }

    public static String k(String str, Pattern[] patternArr, int i) throws p83.a {
        String strJ;
        for (Pattern pattern : patternArr) {
            try {
                strJ = p83.j(pattern, str, i);
            } catch (p83.a unused) {
            }
            if (strJ != null) {
                return strJ;
            }
        }
        throw new p83.a("No regex matched the input on group " + i);
    }

    public static boolean l(String str) {
        return str == null || q23.a(str);
    }

    public static boolean m(URL url) {
        String protocol = url.getProtocol();
        if (protocol.equals("http") || protocol.equals("https")) {
            return url.getPort() == -1 || (url.getPort() == url.getDefaultPort());
        }
        return false;
    }

    public static boolean n(String str) {
        return str == null || str.isEmpty();
    }

    public static boolean o(Collection collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean p(Map map) {
        return map == null || map.isEmpty();
    }

    public static long q(String str) {
        String strI;
        double d;
        double d2;
        try {
            strI = p83.i("[\\d]+([\\.,][\\d]+)?([KMBkmb])+", str, 2);
        } catch (s83 unused) {
            strI = "";
        }
        d = Double.parseDouble(p83.k("([\\d]+([\\.,][\\d]+)?)", str).replace(",", "."));
        String upperCase = strI.toUpperCase();
        upperCase.getClass();
        switch (upperCase) {
            case "B":
                d2 = 1.0E9d;
                break;
            case "K":
                d2 = 1000.0d;
                break;
            case "M":
                d2 = 1000000.0d;
                break;
            default:
                return (long) d;
        }
        return (long) (d * d2);
    }

    public static String r(CharSequence charSequence, String... strArr) {
        return (String) Arrays.stream(strArr).filter(new Predicate() { // from class: ty4
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return yy4.b((String) obj);
            }
        }).collect(Collectors.joining(charSequence));
    }

    public static String s(String str) {
        return a.matcher(str).find() ? str.replace("m.", "") : b.matcher(str).find() ? str.replace("www.", "") : str;
    }

    public static String t(String str) {
        return str.replaceAll("\\D+", "");
    }

    public static String u(String str) {
        if (str == null) {
            return null;
        }
        return str.startsWith("http://") ? "https://".concat(str.substring(7)) : str;
    }

    public static URL v(String str) throws MalformedURLException {
        try {
            return new URL(str);
        } catch (MalformedURLException e) {
            if (!e.getMessage().equals("no protocol: " + str)) {
                throw e;
            }
            return new URL("https://" + str);
        }
    }
}
