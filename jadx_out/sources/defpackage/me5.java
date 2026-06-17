package defpackage;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class me5 extends wt1 {
    public static final Pattern a = Pattern.compile("^([a-zA-Z0-9_-]{11})");
    public static final me5 b = new me5();
    public static final List c = av4.a(new Object[]{"embed/", "live/", "shorts/", "watch/", "v/", "w/"});

    public static String i(String str) throws s83 {
        String strJ = j(str);
        if (strJ != null) {
            return strJ;
        }
        ny4.a("The given string is not a YouTube video ID");
        return null;
    }

    public static String j(String str) {
        if (str != null) {
            Matcher matcher = a.matcher(str);
            if (matcher.find()) {
                return matcher.group(1);
            }
        }
        return null;
    }

    public static me5 l() {
        return b;
    }

    @Override // defpackage.wt1
    public String e(String str) throws s83 {
        String strI;
        try {
            URI uri = new URI(str);
            String scheme = uri.getScheme();
            if (scheme != null && (scheme.equals("vnd.youtube") || scheme.equals("vnd.youtube.launch"))) {
                String schemeSpecificPart = uri.getSchemeSpecificPart();
                if (!schemeSpecificPart.startsWith("//")) {
                    return i(schemeSpecificPart);
                }
                String strJ = j(schemeSpecificPart.substring(2));
                if (strJ != null) {
                    return strJ;
                }
                str = "https:".concat(schemeSpecificPart);
            }
        } catch (URISyntaxException unused) {
        }
        try {
            URL urlV = yy4.v(str);
            String host = urlV.getHost();
            String path = urlV.getPath();
            if (!path.isEmpty()) {
                path = path.substring(1);
            }
            if (!yy4.m(urlV) || (!cc5.f0(urlV) && !cc5.e0(urlV) && !cc5.W(urlV) && !cc5.X(urlV) && !cc5.Z(urlV))) {
                if (!host.equalsIgnoreCase("googleads.g.doubleclick.net")) {
                    ny4.a("The URL is not a YouTube URL");
                    return null;
                }
                throw new l51("Error: found ad: " + str);
            }
            if (gc5.n().a(str)) {
                to1.a("Error: no suitable URL: ", str);
                return null;
            }
            String upperCase = host.toUpperCase();
            upperCase.getClass();
            switch (upperCase) {
                case "INVIDIOUS.ZEE.LI":
                case "TUBUS.EDUVID.ORG":
                case "YT.CYBERHOST.UK":
                case "VID.MINT.LGBT":
                case "YTB.TROM.TF":
                case "VID.PUFFYAN.US":
                case "PIPED.KAVIN.ROCKS":
                case "INVIDIOUS.NAMAZSO.EU":
                case "DEV.INVIDIO.US":
                case "INV.RIVERSIDE.ROCKS":
                case "INVIDIOU.SITE":
                case "YEWTU.BE":
                case "INVIDIOUS.KAVIN.ROCKS":
                case "INVIDIOUS-US.KAVIN.ROCKS":
                case "HOOKTUBE.COM":
                case "INVIDIOUS.MOOMOO.ME":
                case "Y.COM.CM":
                case "INVIDIOUS.EXONIP.DE":
                case "TUBE.CONNECT.CAFE":
                case "INVIDIO.US":
                case "INVIDIOUS.FDN.FR":
                case "INVIDIOUS.SNOPYTA.ORG":
                case "REDIRECT.INVIDIOUS.IO":
                case "YTPRIVATE.COM":
                case "INVIDIOUS.048596.XYZ":
                case "INVIDIOUS.BLAMEFRAN.NET":
                case "INVIDIOUS.SILKKY.CLOUD":
                case "WWW.INVIDIO.US":
                case "INVIDIOUS.SITE":
                    if (path.equals("watch") && (strI = yy4.i(urlV, "v")) != null) {
                        return i(strI);
                    }
                    String strK = k(path);
                    if (strK != null) {
                        return strK;
                    }
                    String strI2 = yy4.i(urlV, "v");
                    return strI2 != null ? i(strI2) : i(path);
                case "Y2U.BE":
                case "YOUTU.BE":
                    String strI3 = yy4.i(urlV, "v");
                    return strI3 != null ? i(strI3) : i(path);
                case "M.YOUTUBE.COM":
                case "MUSIC.YOUTUBE.COM":
                case "WWW.YOUTUBE.COM":
                case "YOUTUBE.COM":
                    if (!path.equals("attribution_link")) {
                        String strK2 = k(path);
                        return strK2 != null ? strK2 : i(yy4.i(urlV, "v"));
                    }
                    try {
                        return i(yy4.i(yy4.v("https://www.youtube.com" + yy4.i(urlV, "u")), "v"));
                    } catch (MalformedURLException unused2) {
                        to1.a("Error: no suitable URL: ", str);
                        return null;
                    }
                case "WWW.YOUTUBE-NOCOOKIE.COM":
                    if (path.startsWith("embed/")) {
                        return i(path.substring(6));
                    }
                    break;
            }
            to1.a("Error: no suitable URL: ", str);
            return null;
        } catch (MalformedURLException e) {
            uo1.a("The given URL is not valid", e);
            return null;
        }
    }

    @Override // defpackage.wt1
    public String f(String str) {
        return "https://www.youtube.com/watch?v=" + str;
    }

    @Override // defpackage.wt1
    public boolean h(String str) throws l51 {
        try {
            e(str);
            return true;
        } catch (l51 e) {
            throw e;
        } catch (s83 unused) {
            return false;
        }
    }

    public final String k(String str) {
        for (String str2 : c) {
            if (str.startsWith(str2)) {
                return i(str.substring(str2.length()));
            }
        }
        return null;
    }
}
