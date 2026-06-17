package defpackage;

import android.text.Layout;
import com.thegrizzlylabs.sardineandroid.DavPrincipal;
import defpackage.ki4;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.simpleframework.xml.strategy.Name;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class au4 implements ki4 {
    public static final Pattern b = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    public static final Pattern c = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    public static final Pattern d = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    public static final Pattern e = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");
    public static final Pattern f = Pattern.compile("^([-+]?\\d+\\.?\\d*?)% ([-+]?\\d+\\.?\\d*?)%$");
    public static final Pattern g = Pattern.compile("^([-+]?\\d+\\.?\\d*?)px ([-+]?\\d+\\.?\\d*?)px$");
    public static final Pattern h = Pattern.compile("^(\\d+) (\\d+)$");
    public static final a i = new a(30.0f, 1, 1);
    public final XmlPullParserFactory a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final float a;
        public final int b;
        public final int c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(float f, int i, int i2) {
            this.a = f;
            this.b = i;
            this.c = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final int a;
        public final int b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public au4() {
        try {
            XmlPullParserFactory xmlPullParserFactoryNewInstance = XmlPullParserFactory.newInstance();
            this.a = xmlPullParserFactoryNewInstance;
            xmlPullParserFactoryNewInstance.setNamespaceAware(true);
        } catch (XmlPullParserException e2) {
            cx4.a("Couldn't create XmlPullParserFactory instance", e2);
            throw null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static du4 d(du4 du4Var) {
        return du4Var == null ? new du4() : du4Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean e(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("image") || str.equals("data") || str.equals("information");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Layout.Alignment f(String str) {
        String strF = xa.f(str);
        strF.getClass();
        switch (strF) {
            case "center":
                return Layout.Alignment.ALIGN_CENTER;
            case "end":
            case "right":
                return Layout.Alignment.ALIGN_OPPOSITE;
            case "left":
            case "start":
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int g(XmlPullParser xmlPullParser, int i2) {
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "cellResolution");
        if (attributeValue == null) {
            return i2;
        }
        Matcher matcher = h.matcher(attributeValue);
        if (!matcher.matches()) {
            xz1.i("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue));
            return i2;
        }
        boolean z = true;
        try {
            int i3 = Integer.parseInt((String) gg3.q(matcher.group(1)));
            int i4 = Integer.parseInt((String) gg3.q(matcher.group(2)));
            if (i3 == 0 || i4 == 0) {
                z = false;
            }
            gg3.h(z, "Invalid cell resolution %s %s", i3, i4);
            return i4;
        } catch (NumberFormatException unused) {
            xz1.i("TtmlParser", "Ignoring malformed cell resolution: ".concat(attributeValue));
            return i2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void h(String str, du4 du4Var) throws ai4 {
        Matcher matcher;
        String str2;
        String[] strArrG1 = fy4.G1(str, "\\s+");
        if (strArrG1.length == 1) {
            matcher = d.matcher(str);
        } else {
            if (strArrG1.length != 2) {
                throw new ai4("Invalid number of entries for fontSize: " + strArrG1.length + ".");
            }
            matcher = d.matcher(strArrG1[1]);
            xz1.i("TtmlParser", "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new ai4("Invalid expression for fontSize: '" + str + "'.");
        }
        str2 = (String) gg3.q(matcher.group(3));
        str2.getClass();
        switch (str2) {
            case "%":
                du4Var.C(3);
                break;
            case "em":
                du4Var.C(2);
                break;
            case "px":
                du4Var.C(1);
                break;
            default:
                throw new ai4("Invalid unit for fontSize: '" + str2 + "'.");
        }
        du4Var.B(Float.parseFloat((String) gg3.q(matcher.group(1))));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static a i(XmlPullParser xmlPullParser) {
        float f2;
        String attributeValue = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
        int i2 = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
        if (attributeValue2 != null) {
            gg3.e(fy4.G1(attributeValue2, " ").length == 2, "frameRateMultiplier doesn't have 2 parts");
            f2 = Integer.parseInt(r2[0]) / Integer.parseInt(r2[1]);
        } else {
            f2 = 1.0f;
        }
        a aVar = i;
        int i3 = aVar.b;
        String attributeValue3 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
        if (attributeValue3 != null) {
            i3 = Integer.parseInt(attributeValue3);
        }
        int i4 = aVar.c;
        String attributeValue4 = xmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
        if (attributeValue4 != null) {
            i4 = Integer.parseInt(attributeValue4);
        }
        return new a(i2 * f2, i3, i4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Map j(XmlPullParser xmlPullParser, Map map, int i2, b bVar, Map map2, Map map3) {
        do {
            xmlPullParser.next();
            if (oa5.f(xmlPullParser, "style")) {
                String strA = oa5.a(xmlPullParser, "style");
                du4 du4VarO = o(xmlPullParser, new du4());
                if (strA != null) {
                    for (String str : p(strA)) {
                        du4VarO.a((du4) map.get(str));
                    }
                }
                String strH = du4VarO.h();
                if (strH != null) {
                    map.put(strH, du4VarO);
                }
            } else if (oa5.f(xmlPullParser, "region")) {
                bu4 bu4VarM = m(xmlPullParser, i2, bVar, map);
                if (bu4VarM != null) {
                    map2.put(bu4VarM.a, bu4VarM);
                }
            } else if (oa5.f(xmlPullParser, "metadata")) {
                k(xmlPullParser, map3);
            }
        } while (!oa5.d(xmlPullParser, "head"));
        return map;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void k(XmlPullParser xmlPullParser, Map map) {
        String strA;
        do {
            xmlPullParser.next();
            if (oa5.f(xmlPullParser, "image") && (strA = oa5.a(xmlPullParser, Name.MARK)) != null) {
                map.put(strA, xmlPullParser.nextText());
            }
        } while (!oa5.d(xmlPullParser, "metadata"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static zt4 l(XmlPullParser xmlPullParser, zt4 zt4Var, Map map, a aVar) throws ai4 {
        String attributeValue;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        int attributeCount = xmlPullParser2.getAttributeCount();
        String strSubstring = null;
        du4 du4VarO = o(xmlPullParser2, null);
        long jQ = -9223372036854775807L;
        long jQ2 = -9223372036854775807L;
        long jQ3 = -9223372036854775807L;
        String[] strArr = null;
        String str = "";
        int i2 = 0;
        while (i2 < attributeCount) {
            String attributeName = xmlPullParser2.getAttributeName(i2);
            int i3 = attributeCount;
            attributeValue = xmlPullParser2.getAttributeValue(i2);
            attributeName.getClass();
            switch (attributeName) {
                case "region":
                    if (map.containsKey(attributeValue)) {
                        str = attributeValue;
                        continue;
                    }
                    i2++;
                    xmlPullParser2 = xmlPullParser;
                    attributeCount = i3;
                    break;
                case "dur":
                    jQ3 = q(attributeValue, aVar);
                    break;
                case "end":
                    jQ2 = q(attributeValue, aVar);
                    break;
                case "begin":
                    jQ = q(attributeValue, aVar);
                    break;
                case "style":
                    String[] strArrP = p(attributeValue);
                    if (strArrP.length > 0) {
                        strArr = strArrP;
                        break;
                    }
                    break;
                case "backgroundImage":
                    if (attributeValue.startsWith("#")) {
                        strSubstring = attributeValue.substring(1);
                        break;
                    }
                    break;
            }
            i2++;
            xmlPullParser2 = xmlPullParser;
            attributeCount = i3;
        }
        if (zt4Var != null) {
            long j = zt4Var.d;
            if (j != -9223372036854775807L) {
                if (jQ != -9223372036854775807L) {
                    jQ += j;
                }
                if (jQ2 != -9223372036854775807L) {
                    jQ2 += j;
                }
            }
        }
        long j2 = jQ;
        if (jQ2 == -9223372036854775807L) {
            if (jQ3 != -9223372036854775807L) {
                jQ2 = j2 + jQ3;
            } else if (zt4Var != null) {
                long j3 = zt4Var.e;
                if (j3 != -9223372036854775807L) {
                    jQ2 = j3;
                }
            }
        }
        return zt4.c(xmlPullParser.getName(), j2, jQ2, du4VarO, strArr, str, strSubstring, zt4Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0204  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static bu4 m(XmlPullParser xmlPullParser, int i2, b bVar, Map map) {
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        int i3;
        int i4;
        float f7;
        int i5;
        float f8;
        float f9;
        String strA;
        du4 du4Var;
        String strA2;
        du4 du4Var2;
        String strA3 = oa5.a(xmlPullParser, Name.MARK);
        if (strA3 == null) {
            return null;
        }
        String strA4 = oa5.a(xmlPullParser, "origin");
        if (strA4 == null && (strA2 = oa5.a(xmlPullParser, "style")) != null && (du4Var2 = (du4) map.get(strA2)) != null) {
            strA4 = du4Var2.j();
        }
        int i6 = 2;
        if (strA4 != null) {
            Matcher matcher = f.matcher(strA4);
            Matcher matcher2 = g.matcher(strA4);
            if (matcher.matches()) {
                try {
                    f3 = Float.parseFloat((String) gg3.q(matcher.group(1))) / 100.0f;
                    f2 = Float.parseFloat((String) gg3.q(matcher.group(2))) / 100.0f;
                } catch (NumberFormatException unused) {
                    xz1.i("TtmlParser", "Ignoring region with malformed origin: ".concat(strA4));
                    return null;
                }
            } else {
                if (!matcher2.matches()) {
                    xz1.i("TtmlParser", "Ignoring region with unsupported origin: ".concat(strA4));
                    return null;
                }
                if (bVar == null) {
                    xz1.i("TtmlParser", "Ignoring region with missing tts:extent: ".concat(strA4));
                    return null;
                }
                try {
                    float f10 = Integer.parseInt((String) gg3.q(matcher2.group(1))) / bVar.a;
                    float f11 = Integer.parseInt((String) gg3.q(matcher2.group(2))) / bVar.b;
                    f3 = f10;
                    f2 = f11;
                } catch (NumberFormatException unused2) {
                    xz1.i("TtmlParser", "Ignoring region with malformed origin: ".concat(strA4));
                    return null;
                }
            }
        } else {
            f2 = 0.0f;
            f3 = 0.0f;
        }
        String strA5 = oa5.a(xmlPullParser, "extent");
        if (strA5 == null && (strA = oa5.a(xmlPullParser, "style")) != null && (du4Var = (du4) map.get(strA)) != null) {
            strA5 = du4Var.c();
        }
        if (strA5 != null) {
            Matcher matcher3 = f.matcher(strA5);
            Matcher matcher4 = g.matcher(strA5);
            f4 = 1.0f;
            if (matcher3.matches()) {
                try {
                    f5 = Float.parseFloat((String) gg3.q(matcher3.group(1))) / 100.0f;
                    f9 = Float.parseFloat((String) gg3.q(matcher3.group(2))) / 100.0f;
                } catch (NumberFormatException unused3) {
                    xz1.i("TtmlParser", "Ignoring region with malformed extent: " + strA4);
                    return null;
                }
            } else {
                if (!matcher4.matches()) {
                    xz1.i("TtmlParser", "Ignoring region with unsupported extent: " + strA4);
                    return null;
                }
                if (bVar == null) {
                    xz1.i("TtmlParser", "Ignoring region with missing tts:extent: " + strA4);
                    return null;
                }
                try {
                    float f12 = Integer.parseInt((String) gg3.q(matcher4.group(1))) / bVar.a;
                    f9 = Integer.parseInt((String) gg3.q(matcher4.group(2))) / bVar.b;
                    f5 = f12;
                } catch (NumberFormatException unused4) {
                    xz1.i("TtmlParser", "Ignoring region with malformed extent: " + strA4);
                    return null;
                }
            }
            f6 = f9;
        } else {
            f4 = 1.0f;
            f5 = 1.0f;
            f6 = 1.0f;
        }
        String strA6 = oa5.a(xmlPullParser, "displayAlign");
        int i7 = 0;
        if (strA6 != null) {
            String strF = xa.f(strA6);
            strF.getClass();
            if (strF.equals("center")) {
                f8 = f2 + (f6 / 2.0f);
                i3 = i2;
                i4 = 2;
                i6 = 1;
            } else {
                if (strF.equals("after")) {
                    f8 = f2 + f6;
                    i3 = i2;
                    i4 = 2;
                }
                i3 = i2;
                i4 = 2;
                f7 = f2;
                i6 = 0;
            }
            f7 = f8;
        } else {
            i3 = i2;
            i4 = 2;
            f7 = f2;
            i6 = 0;
        }
        float f13 = f4 / i3;
        String strA7 = oa5.a(xmlPullParser, "writingMode");
        if (strA7 != null) {
            String strF2 = xa.f(strA7);
            strF2.getClass();
            switch (strF2.hashCode()) {
                case 3694:
                    if (!strF2.equals("tb")) {
                        i7 = -1;
                    }
                    break;
                case 3553396:
                    i7 = !strF2.equals("tblr") ? -1 : 1;
                    break;
                case 3553576:
                    i7 = !strF2.equals("tbrl") ? -1 : i4;
                    break;
                default:
                    i7 = -1;
                    break;
            }
            switch (i7) {
                case 0:
                case 1:
                    i5 = i4;
                    break;
                case 2:
                    i5 = 1;
                    break;
                default:
                    i5 = Integer.MIN_VALUE;
                    break;
            }
        }
        return new bu4(strA3, f3, f7, 0, i6, f5, f6, 1, f13, i5);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static float n(String str) {
        Matcher matcher = e.matcher(str);
        if (!matcher.matches()) {
            xz1.i("TtmlParser", "Invalid value for shear: " + str);
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) gg3.q(matcher.group(1)))));
        } catch (NumberFormatException e2) {
            xz1.j("TtmlParser", "Failed to parse shear: " + str, e2);
            return Float.MAX_VALUE;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static du4 o(XmlPullParser xmlPullParser, du4 du4Var) {
        String attributeValue;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i2 = 0; i2 < attributeCount; i2++) {
            attributeValue = xmlPullParser.getAttributeValue(i2);
            String attributeName = xmlPullParser.getAttributeName(i2);
            attributeName.getClass();
            switch (attributeName) {
                case "fontStyle":
                    du4Var = d(du4Var).E("italic".equalsIgnoreCase(attributeValue));
                    break;
                case "extent":
                    du4Var = d(du4Var).y(attributeValue);
                    break;
                case "fontFamily":
                    du4Var = d(du4Var).A(attributeValue);
                    break;
                case "textAlign":
                    du4Var = d(du4Var).L(f(attributeValue));
                    break;
                case "origin":
                    du4Var = d(du4Var).H(attributeValue);
                    break;
                case "textDecoration":
                    String strF = xa.f(attributeValue);
                    strF.getClass();
                    switch (strF) {
                        case "nounderline":
                            du4Var = d(du4Var).O(false);
                            break;
                        case "underline":
                            du4Var = d(du4Var).O(true);
                            break;
                        case "nolinethrough":
                            du4Var = d(du4Var).F(false);
                            break;
                        case "linethrough":
                            du4Var = d(du4Var).F(true);
                            break;
                    }
                    break;
                case "fontWeight":
                    du4Var = d(du4Var).x("bold".equalsIgnoreCase(attributeValue));
                    break;
                case "id":
                    if (!"style".equals(xmlPullParser.getName())) {
                        break;
                    } else {
                        du4Var = d(du4Var).D(attributeValue);
                        break;
                    }
                    break;
                case "ruby":
                    String strF2 = xa.f(attributeValue);
                    strF2.getClass();
                    switch (strF2) {
                        case "baseContainer":
                        case "base":
                            du4Var = d(du4Var).J(2);
                            break;
                        case "container":
                            du4Var = d(du4Var).J(1);
                            break;
                        case "delimiter":
                            du4Var = d(du4Var).J(4);
                            break;
                        case "textContainer":
                        case "text":
                            du4Var = d(du4Var).J(3);
                            break;
                    }
                    break;
                case "color":
                    du4Var = d(du4Var);
                    try {
                        du4Var.z(ex.c(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused) {
                        xz1.i("TtmlParser", "Failed parsing color value: " + attributeValue);
                        break;
                    }
                    break;
                case "shear":
                    du4Var = d(du4Var).K(n(attributeValue));
                    break;
                case "textCombine":
                    String strF3 = xa.f(attributeValue);
                    strF3.getClass();
                    if (!strF3.equals(DavPrincipal.KEY_ALL)) {
                        if (strF3.equals("none")) {
                            du4Var = d(du4Var).M(false);
                        }
                        break;
                    } else {
                        du4Var = d(du4Var).M(true);
                        break;
                    }
                    break;
                case "fontSize":
                    try {
                        du4Var = d(du4Var);
                        h(attributeValue, du4Var);
                        break;
                    } catch (ai4 unused2) {
                        xz1.i("TtmlParser", "Failed parsing fontSize value: " + attributeValue);
                        break;
                    }
                    break;
                case "textEmphasis":
                    du4Var = d(du4Var).N(jm4.a(attributeValue));
                    break;
                case "rubyPosition":
                    String strF4 = xa.f(attributeValue);
                    strF4.getClass();
                    if (!strF4.equals("before")) {
                        if (strF4.equals("after")) {
                            du4Var = d(du4Var).I(2);
                        }
                        break;
                    } else {
                        du4Var = d(du4Var).I(1);
                        break;
                    }
                    break;
                case "backgroundColor":
                    du4Var = d(du4Var);
                    try {
                        du4Var.w(ex.c(attributeValue));
                        break;
                    } catch (IllegalArgumentException unused3) {
                        xz1.i("TtmlParser", "Failed parsing background value: " + attributeValue);
                        break;
                    }
                    break;
                case "multiRowAlign":
                    du4Var = d(du4Var).G(f(attributeValue));
                    break;
            }
        }
        return du4Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String[] p(String str) {
        String strTrim = str.trim();
        return strTrim.isEmpty() ? new String[0] : fy4.G1(strTrim, "\\s+");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long q(String str, a aVar) throws ai4 {
        double d2;
        double d3;
        double d4;
        Matcher matcher = b.matcher(str);
        if (matcher.matches()) {
            double d5 = (Long.parseLong((String) gg3.q(matcher.group(1))) * 3600) + (Long.parseLong((String) gg3.q(matcher.group(2))) * 60) + Long.parseLong((String) gg3.q(matcher.group(3)));
            String strGroup = matcher.group(4);
            return (long) ((d5 + (strGroup != null ? Double.parseDouble(strGroup) : 0.0d) + (matcher.group(5) != null ? Long.parseLong(r13) / aVar.a : 0.0d) + (matcher.group(6) != null ? (Long.parseLong(r13) / ((double) aVar.b)) / ((double) aVar.a) : 0.0d)) * 1000000.0d);
        }
        Matcher matcher2 = c.matcher(str);
        if (!matcher2.matches()) {
            throw new ai4("Malformed time expression: " + str);
        }
        d2 = Double.parseDouble((String) gg3.q(matcher2.group(1)));
        String str2 = (String) gg3.q(matcher2.group(2));
        str2.getClass();
        switch (str2) {
            case "f":
                d3 = aVar.a;
                d2 /= d3;
                return (long) (d2 * 1000000.0d);
            case "h":
                d4 = 3600.0d;
                break;
            case "m":
                d4 = 60.0d;
                break;
            case "t":
                d3 = aVar.c;
                d2 /= d3;
                return (long) (d2 * 1000000.0d);
            case "ms":
                d3 = 1000.0d;
                d2 /= d3;
                return (long) (d2 * 1000000.0d);
            default:
                return (long) (d2 * 1000000.0d);
        }
        d2 *= d4;
        return (long) (d2 * 1000000.0d);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static b r(XmlPullParser xmlPullParser) {
        String strA = oa5.a(xmlPullParser, "extent");
        if (strA == null) {
            return null;
        }
        Matcher matcher = g.matcher(strA);
        if (!matcher.matches()) {
            xz1.i("TtmlParser", "Ignoring non-pixel tts extent: ".concat(strA));
            return null;
        }
        try {
            return new b(Integer.parseInt((String) gg3.q(matcher.group(1))), Integer.parseInt((String) gg3.q(matcher.group(2))));
        } catch (NumberFormatException unused) {
            xz1.i("TtmlParser", "Ignoring malformed tts extent: ".concat(strA));
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ki4
    public yh4 a(byte[] bArr, int i2, int i3) {
        yh4 yh4Var;
        yh4 yh4Var2 = null;
        try {
            XmlPullParser xmlPullParserNewPullParser = this.a.newPullParser();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            map2.put("", new bu4(""));
            xmlPullParserNewPullParser.setInput(new ByteArrayInputStream(bArr, i2, i3), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            int eventType = xmlPullParserNewPullParser.getEventType();
            a aVarI = i;
            eu4 eu4Var = null;
            b bVarR = null;
            int i4 = 0;
            int iG = 15;
            while (eventType != 1) {
                zt4 zt4Var = (zt4) arrayDeque.peek();
                if (i4 == 0) {
                    yh4Var = yh4Var2;
                    try {
                        String name = xmlPullParserNewPullParser.getName();
                        if (eventType == 2) {
                            if ("tt".equals(name)) {
                                aVarI = i(xmlPullParserNewPullParser);
                                iG = g(xmlPullParserNewPullParser, 15);
                                bVarR = r(xmlPullParserNewPullParser);
                            }
                            b bVar = bVarR;
                            a aVar = aVarI;
                            int i5 = iG;
                            if (e(name)) {
                                if ("head".equals(name)) {
                                    j(xmlPullParserNewPullParser, map, i5, bVar, map2, map3);
                                } else {
                                    try {
                                        zt4 zt4VarL = l(xmlPullParserNewPullParser, zt4Var, map2, aVar);
                                        arrayDeque.push(zt4VarL);
                                        if (zt4Var != null) {
                                            zt4Var.a(zt4VarL);
                                        }
                                    } catch (ai4 e2) {
                                        xz1.j("TtmlParser", "Suppressing parser error", e2);
                                        i4++;
                                    }
                                }
                                iG = i5;
                                aVarI = aVar;
                                bVarR = bVar;
                            } else {
                                xz1.g("TtmlParser", "Ignoring unsupported tag: " + xmlPullParserNewPullParser.getName());
                            }
                            i4++;
                            iG = i5;
                            aVarI = aVar;
                            bVarR = bVar;
                        } else if (eventType == 4) {
                            ((zt4) gg3.q(zt4Var)).a(zt4.d(xmlPullParserNewPullParser.getText()));
                        } else if (eventType == 3) {
                            if (xmlPullParserNewPullParser.getName().equals("tt")) {
                                eu4Var = new eu4((zt4) gg3.q((zt4) arrayDeque.peek()), map, map2, map3);
                            }
                            arrayDeque.pop();
                        }
                    } catch (IOException e3) {
                        e = e3;
                        l02.a("Unexpected error when reading input.", e);
                        return yh4Var;
                    } catch (XmlPullParserException e4) {
                        e = e4;
                        l02.a("Unable to decode source", e);
                        return yh4Var;
                    }
                } else {
                    yh4Var = yh4Var2;
                    if (eventType == 2) {
                        i4++;
                    } else if (eventType == 3) {
                        i4--;
                    }
                }
                xmlPullParserNewPullParser.next();
                eventType = xmlPullParserNewPullParser.getEventType();
                yh4Var2 = yh4Var;
            }
            yh4Var = yh4Var2;
            return (yh4) gg3.q(eu4Var);
        } catch (IOException e5) {
            e = e5;
            yh4Var = yh4Var2;
        } catch (XmlPullParserException e6) {
            e = e6;
            yh4Var = yh4Var2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ki4
    public void b(byte[] bArr, int i2, int i3, ki4.b bVar, g20 g20Var) {
        qs1.c(a(bArr, i2, i3), bVar, g20Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ki4
    public int c() {
        return 1;
    }
}
