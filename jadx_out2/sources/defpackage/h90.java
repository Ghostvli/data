package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.util.Xml;
import defpackage.g04;
import defpackage.oo0;
import defpackage.t41;
import defpackage.t83;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.http2.Http2;
import org.jupnp.support.model.dlna.DLNAProfiles;
import org.mozilla.javascript.ES6Iterator;
import org.simpleframework.xml.strategy.Name;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class h90 extends DefaultHandler implements t83.a {
    public static final Pattern b = Pattern.compile("(\\d+)(?:/(\\d+))?");
    public static final Pattern c = Pattern.compile("CC([1-4])=.*");
    public static final Pattern d = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");
    public static final int[] e = {2, 1, 2, 2, 2, 2, 1, 2, 2, 1, 1, 1, 1, 2, 1, 1, 2, 2, 2};
    public static final int[] f = {-1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14};
    public final XmlPullParserFactory a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final t41 a;
        public final xi1 b;
        public final g04 c;
        public final String d;
        public final ArrayList e;
        public final ArrayList f;
        public final long g;
        public final List h;
        public final List i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(t41 t41Var, List list, g04 g04Var, String str, ArrayList arrayList, ArrayList arrayList2, List list2, List list3, long j) {
            this.a = t41Var;
            this.b = xi1.p(list);
            this.c = g04Var;
            this.d = str;
            this.e = arrayList;
            this.f = arrayList2;
            this.h = list2;
            this.i = list3;
            this.g = j;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public h90() {
        try {
            this.a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            cx4.a("Couldn't create XmlPullParserFactory instance", e2);
            throw null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int D(List list) {
        String str;
        for (int i = 0; i < list.size(); i++) {
            rj0 rj0Var = (rj0) list.get(i);
            if ("urn:scte:dash:cc:cea-608:2015".equals(rj0Var.a) && (str = rj0Var.b) != null) {
                Matcher matcher = c.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                xz1.i("MpdParser", "Unable to parse CEA-608 channel number from: " + rj0Var.b);
            }
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int E(List list) {
        String str;
        for (int i = 0; i < list.size(); i++) {
            rj0 rj0Var = (rj0) list.get(i);
            if ("urn:scte:dash:cc:cea-708:2015".equals(rj0Var.a) && (str = rj0Var.b) != null) {
                Matcher matcher = d.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                xz1.i("MpdParser", "Unable to parse CEA-708 service block number from: " + rj0Var.b);
            }
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long H(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : fy4.l1(attributeValue);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static rj0 I(XmlPullParser xmlPullParser, String str) {
        String strU0 = u0(xmlPullParser, "schemeIdUri", "");
        String strU02 = u0(xmlPullParser, ES6Iterator.VALUE_PROPERTY, null);
        String strU03 = u0(xmlPullParser, Name.MARK, null);
        do {
            xmlPullParser.next();
        } while (!oa5.d(xmlPullParser, str));
        return new rj0(strU0, strU02, strU03);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int J(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, ES6Iterator.VALUE_PROPERTY);
        if (attributeValue == null || attributeValue.length() != 6) {
            return -1;
        }
        int i = Integer.parseInt(attributeValue, 16);
        return (8388608 & i) != 0 ? L(str) : K(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int K(int i) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = e;
            if (i2 >= iArr.length) {
                break;
            }
            i3 += ((i >> i2) & 1) * iArr[i2];
            i2++;
        }
        if (i3 == 0) {
            return -1;
        }
        return i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int L(String str) {
        String[] strArrI1 = fy4.I1(str);
        if (strArrI1.length == 0) {
            return -1;
        }
        List listI = cd4.f('.').i(xa.f(strArrI1[0].trim()));
        if (listI.size() != 4 || !((String) listI.get(0)).equals("ac-4")) {
            return -1;
        }
        String str2 = (String) listI.get(3);
        str2.getClass();
        if (str2.equals("03")) {
            return 18;
        }
        return !str2.equals("04") ? -1 : 21;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int M(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, ES6Iterator.VALUE_PROPERTY);
        if (attributeValue == null) {
            return -1;
        }
        String strF = xa.f(attributeValue);
        strF.getClass();
        switch (strF) {
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int N(XmlPullParser xmlPullParser) {
        int iX = X(xmlPullParser, ES6Iterator.VALUE_PROPERTY, -1);
        if (iX <= 0 || iX >= 33) {
            return -1;
        }
        return iX;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int O(XmlPullParser xmlPullParser) {
        int iBitCount;
        String attributeValue = xmlPullParser.getAttributeValue(null, ES6Iterator.VALUE_PROPERTY);
        if (attributeValue == null || (iBitCount = Integer.bitCount(Integer.parseInt(attributeValue, 16))) == 0) {
            return -1;
        }
        return iBitCount;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long P(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : fy4.m1(attributeValue);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String Q(List list) {
        for (int i = 0; i < list.size(); i++) {
            rj0 rj0Var = (rj0) list.get(i);
            String str = rj0Var.a;
            if ("tag:dolby.com,2018:dash:EC3_ExtensionType:2018".equals(str) && "JOC".equals(rj0Var.b)) {
                return "audio/eac3-joc";
            }
            if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(str) && "ec+3".equals(rj0Var.b)) {
                return "audio/eac3-joc";
            }
        }
        return "audio/eac3";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static float U(XmlPullParser xmlPullParser, String str, float f2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? f2 : Float.parseFloat(attributeValue);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static float V(XmlPullParser xmlPullParser, float f2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue != null) {
            Matcher matcher = b.matcher(attributeValue);
            if (matcher.matches()) {
                int i = Integer.parseInt(matcher.group(1));
                return !TextUtils.isEmpty(matcher.group(2)) ? i / Integer.parseInt(r2) : i;
            }
        }
        return f2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int X(XmlPullParser xmlPullParser, String str, int i) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? i : Integer.parseInt(attributeValue);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long Z(List list) {
        for (int i = 0; i < list.size(); i++) {
            rj0 rj0Var = (rj0) list.get(i);
            if (xa.a("http://dashif.org/guidelines/last-segment-number", rj0Var.a)) {
                return Long.parseLong(rj0Var.b);
            }
        }
        return -1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long a0(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : Long.parseLong(attributeValue);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int c0(XmlPullParser xmlPullParser) {
        int iX = X(xmlPullParser, ES6Iterator.VALUE_PROPERTY, -1);
        if (iX >= 0) {
            int[] iArr = f;
            if (iX < iArr.length) {
                return iArr[iX];
            }
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int p(int i, int i2) {
        if (i == -1) {
            return i2;
        }
        if (i2 == -1) {
            return i;
        }
        gg3.v(i == i2);
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String q(String str, String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        gg3.v(str.equals(str2));
        return str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void r(ArrayList arrayList) {
        String str;
        int i = 0;
        while (true) {
            if (i >= arrayList.size()) {
                str = null;
                break;
            }
            oo0.b bVar = (oo0.b) arrayList.get(i);
            if (kn.d.equals(bVar.g) && (str = bVar.h) != null) {
                arrayList.remove(i);
                break;
            }
            i++;
        }
        if (str == null) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            oo0.b bVar2 = (oo0.b) arrayList.get(i2);
            if (kn.c.equals(bVar2.g) && bVar2.h == null) {
                arrayList.set(i2, new oo0.b(kn.d, str, bVar2.i, bVar2.j));
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void s(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            oo0.b bVar = (oo0.b) arrayList.get(size);
            if (!bVar.s()) {
                int i = 0;
                while (true) {
                    if (i >= arrayList.size()) {
                        break;
                    }
                    if (((oo0.b) arrayList.get(i)).c(bVar)) {
                        arrayList.remove(size);
                        break;
                    }
                    i++;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long t(long j, long j2) {
        if (j2 != -9223372036854775807L) {
            j = j2;
        }
        if (j == Long.MAX_VALUE) {
            return -9223372036854775807L;
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String u(String str, String str2) {
        if (nt2.o(str)) {
            return nt2.c(str2);
        }
        if (nt2.t(str)) {
            return nt2.n(str2);
        }
        if (nt2.s(str) || nt2.q(str)) {
            return str;
        }
        if (!"application/mp4".equals(str)) {
            return null;
        }
        String strG = nt2.g(str2);
        return "text/vtt".equals(strG) ? "application/x-mp4-vtt" : strG;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String u0(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String v0(XmlPullParser xmlPullParser, String str) {
        String text = "";
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                text = xmlPullParser.getText();
            } else {
                w(xmlPullParser);
            }
        } while (!oa5.d(xmlPullParser, str));
        return text;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void w(XmlPullParser xmlPullParser) {
        if (oa5.e(xmlPullParser)) {
            int i = 1;
            while (i != 0) {
                xmlPullParser.next();
                if (oa5.e(xmlPullParser)) {
                    i++;
                } else if (oa5.c(xmlPullParser)) {
                    i--;
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int A(XmlPullParser xmlPullParser, String str) {
        int iN;
        String strU0 = u0(xmlPullParser, "schemeIdUri", null);
        strU0.getClass();
        iN = -1;
        switch (strU0) {
            case "urn:dts:dash:audio_channel_configuration:2012":
            case "tag:dts.com,2014:dash:audio_channel_configuration:2012":
                iN = N(xmlPullParser);
                break;
            case "tag:dolby.com,2015:dash:audio_channel_configuration:2015":
                iN = J(xmlPullParser, str);
                break;
            case "urn:mpeg:dash:23003:3:audio_channel_configuration:2011":
                iN = X(xmlPullParser, ES6Iterator.VALUE_PROPERTY, -1);
                break;
            case "tag:dolby.com,2014:dash:audio_channel_configuration:2011":
            case "urn:dolby:dash:audio_channel_configuration:2011":
                iN = M(xmlPullParser);
                break;
            case "urn:mpeg:mpegB:cicp:ChannelConfiguration":
                iN = c0(xmlPullParser);
                break;
            case "tag:dts.com,2018:uhd:audio_channel_configuration":
                iN = O(xmlPullParser);
                break;
        }
        do {
            xmlPullParser.next();
        } while (!oa5.d(xmlPullParser, "AudioChannelConfiguration"));
        return iN;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long B(XmlPullParser xmlPullParser, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "availabilityTimeOffset");
        if (attributeValue == null) {
            return j;
        }
        if ("INF".equals(attributeValue)) {
            return Long.MAX_VALUE;
        }
        return (long) (Float.parseFloat(attributeValue) * 1000000.0f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List C(XmlPullParser xmlPullParser, List list, boolean z) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "dvb:priority");
        int i = attributeValue != null ? Integer.parseInt(attributeValue) : z ? 1 : Integer.MIN_VALUE;
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "dvb:weight");
        int i2 = attributeValue2 != null ? Integer.parseInt(attributeValue2) : 1;
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "serviceLocation");
        String strV0 = v0(xmlPullParser, "BaseURL");
        if (kx4.c(strV0)) {
            if (attributeValue3 == null) {
                attributeValue3 = strV0;
            }
            return ru1.h(new dj(strV0, attributeValue3, i, i2));
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            dj djVar = (dj) list.get(i3);
            String strF = kx4.f(djVar.a, strV0);
            String str = attributeValue3 == null ? strF : attributeValue3;
            if (z) {
                i = djVar.c;
                i2 = djVar.d;
                str = djVar.b;
            }
            arrayList.add(new dj(strF, str, i, i2));
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:78:? */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0119  */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v4, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v4, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v9 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Pair F(XmlPullParser xmlPullParser) {
        String attributeValue;
        UUID uuid;
        UUID uuid2;
        ?? text;
        ?? B;
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "schemeIdUri");
        if (attributeValue2 != null) {
            String strF = xa.f(attributeValue2);
            strF.getClass();
            switch (strF) {
                case "urn:uuid:e2719d58-a985-b3c9-781a-b030af78d30e":
                    uuid = kn.d;
                    attributeValue = null;
                    uuid2 = null;
                    text = uuid2;
                    B = uuid2;
                    break;
                case "urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95":
                    uuid = kn.f;
                    attributeValue = null;
                    uuid2 = null;
                    text = uuid2;
                    B = uuid2;
                    break;
                case "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed":
                    uuid = kn.e;
                    attributeValue = null;
                    uuid2 = null;
                    text = uuid2;
                    B = uuid2;
                    break;
                case "urn:mpeg:dash:mp4protection:2011":
                    attributeValue = xmlPullParser.getAttributeValue(null, ES6Iterator.VALUE_PROPERTY);
                    String strB = oa5.b(xmlPullParser, "default_KID");
                    if (!TextUtils.isEmpty(strB) && !"00000000-0000-0000-0000-000000000000".equals(strB)) {
                        String[] strArrSplit = strB.split("\\s+");
                        UUID[] uuidArr = new UUID[strArrSplit.length];
                        for (int i = 0; i < strArrSplit.length; i++) {
                            uuidArr[i] = UUID.fromString(strArrSplit[i]);
                        }
                        uuid = kn.c;
                        text = 0;
                        B = xi3.b(uuid, uuidArr, null);
                        break;
                    } else {
                        xz1.i("MpdParser", "Ignoring <ContentProtection> with schemeIdUri=\"urn:mpeg:dash:mp4protection:2011\" (ClearKey) due to missing required default_KID attribute.");
                        uuid = null;
                        uuid2 = uuid;
                        text = uuid2;
                        B = uuid2;
                        break;
                    }
                    break;
                default:
                    attributeValue = null;
                    uuid = null;
                    uuid2 = uuid;
                    text = uuid2;
                    B = uuid2;
                    break;
            }
        }
        do {
            xmlPullParser.next();
            if ((oa5.f(xmlPullParser, "clearkey:Laurl") || oa5.f(xmlPullParser, "dashif:Laurl")) && xmlPullParser.next() == 4) {
                B = B;
                text = xmlPullParser.getText();
            } else if (oa5.f(xmlPullParser, "ms:laurl")) {
                B = B;
                text = xmlPullParser.getAttributeValue(null, "licenseUrl");
            } else if (B == 0 && oa5.g(xmlPullParser, "pssh") && xmlPullParser.next() == 4) {
                byte[] bArrDecode = Base64.decode(xmlPullParser.getText(), 0);
                UUID uuidF = xi3.f(bArrDecode);
                if (uuidF == null) {
                    xz1.i("MpdParser", "Skipping malformed cenc:pssh data");
                    uuid = uuidF;
                    B = 0;
                    text = text;
                } else {
                    B = bArrDecode;
                    uuid = uuidF;
                    text = text;
                }
            } else if (B == 0) {
                UUID uuid3 = kn.f;
                if (uuid3.equals(uuid) && oa5.f(xmlPullParser, "mspr:pro") && xmlPullParser.next() == 4) {
                    B = xi3.a(uuid3, Base64.decode(xmlPullParser.getText(), 0));
                    text = text;
                } else {
                    w(xmlPullParser);
                    B = B;
                    text = text;
                }
            }
        } while (!oa5.d(xmlPullParser, "ContentProtection"));
        return Pair.create(attributeValue, uuid != null ? new oo0.b(uuid, text, DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_MPEG_4, B) : null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int G(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        if ("text".equals(attributeValue)) {
            return 3;
        }
        return "image".equals(attributeValue) ? 4 : -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Pair R(XmlPullParser xmlPullParser, String str, String str2, long j, long j2, ByteArrayOutputStream byteArrayOutputStream) {
        long jA0 = a0(xmlPullParser, Name.MARK, 0L);
        long jA02 = a0(xmlPullParser, "duration", -9223372036854775807L);
        long jA03 = a0(xmlPullParser, "presentationTime", 0L);
        long jU1 = fy4.u1(jA02, 1000L, j);
        long jU12 = fy4.u1(jA03 - j2, 1000000L, j);
        String strU0 = u0(xmlPullParser, "messageData", null);
        byte[] bArrS = S(xmlPullParser, byteArrayOutputStream);
        Long lValueOf = Long.valueOf(jU12);
        if (strU0 != null) {
            bArrS = fy4.F0(strU0);
        }
        return Pair.create(lValueOf, d(str, str2, jA0, jU1, bArrS));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] S(XmlPullParser xmlPullParser, ByteArrayOutputStream byteArrayOutputStream) {
        byteArrayOutputStream.reset();
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        xmlSerializerNewSerializer.setOutput(byteArrayOutputStream, StandardCharsets.UTF_8.name());
        xmlPullParser.nextToken();
        while (!oa5.d(xmlPullParser, "Event")) {
            switch (xmlPullParser.getEventType()) {
                case 0:
                    xmlSerializerNewSerializer.startDocument(null, Boolean.FALSE);
                    break;
                case 1:
                    xmlSerializerNewSerializer.endDocument();
                    break;
                case 2:
                    xmlSerializerNewSerializer.startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                        xmlSerializerNewSerializer.attribute(xmlPullParser.getAttributeNamespace(i), xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
                    }
                    break;
                case 3:
                    xmlSerializerNewSerializer.endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    break;
                case 4:
                    xmlSerializerNewSerializer.text(xmlPullParser.getText());
                    break;
                case 5:
                    xmlSerializerNewSerializer.cdsect(xmlPullParser.getText());
                    break;
                case 6:
                    xmlSerializerNewSerializer.entityRef(xmlPullParser.getText());
                    break;
                case 7:
                    xmlSerializerNewSerializer.ignorableWhitespace(xmlPullParser.getText());
                    break;
                case 8:
                    xmlSerializerNewSerializer.processingInstruction(xmlPullParser.getText());
                    break;
                case 9:
                    xmlSerializerNewSerializer.comment(xmlPullParser.getText());
                    break;
                case 10:
                    xmlSerializerNewSerializer.docdecl(xmlPullParser.getText());
                    break;
            }
            xmlPullParser.nextToken();
        }
        xmlSerializerNewSerializer.flush();
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public iv0 T(XmlPullParser xmlPullParser) {
        h90 h90Var;
        long j;
        String str;
        String str2;
        XmlPullParser xmlPullParser2;
        String strU0 = u0(xmlPullParser, "schemeIdUri", "");
        String strU02 = u0(xmlPullParser, ES6Iterator.VALUE_PROPERTY, "");
        long jA0 = a0(xmlPullParser, "timescale", 1L);
        long jA02 = a0(xmlPullParser, "presentationTimeOffset", 0L);
        ArrayList arrayList = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        while (true) {
            xmlPullParser.next();
            if (oa5.f(xmlPullParser, "Event")) {
                h90Var = this;
                j = jA0;
                str = strU02;
                str2 = strU0;
                xmlPullParser2 = xmlPullParser;
                arrayList.add(h90Var.R(xmlPullParser2, str2, str, j, jA02, byteArrayOutputStream));
            } else {
                h90Var = this;
                j = jA0;
                str = strU02;
                str2 = strU0;
                xmlPullParser2 = xmlPullParser;
                w(xmlPullParser2);
            }
            if (oa5.d(xmlPullParser2, "EventStream")) {
                break;
            }
            this = h90Var;
            xmlPullParser = xmlPullParser2;
            strU0 = str2;
            strU02 = str;
            jA0 = j;
        }
        long[] jArr = new long[arrayList.size()];
        dv0[] dv0VarArr = new dv0[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            Pair pair = (Pair) arrayList.get(i);
            jArr[i] = ((Long) pair.first).longValue();
            dv0VarArr[i] = (dv0) pair.second;
        }
        return h90Var.e(str2, str, j, jArr, dv0VarArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public vn3 W(XmlPullParser xmlPullParser) {
        return g0(xmlPullParser, "sourceURL", "range");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public rr1 Y(XmlPullParser xmlPullParser) {
        return new rr1(xmlPullParser.getAttributeValue(null, "lang"), v0(xmlPullParser, "Label"));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long b(List list, long j, long j2, int i, long j3) {
        int iO = i >= 0 ? i + 1 : (int) fy4.o(j3 - j, j2);
        for (int i2 = 0; i2 < iO; i2++) {
            list.add(m(j, j2));
            j += j2;
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:81:0x01dd A[LOOP:0: B:24:0x00a5->B:81:0x01dd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0199 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public g90 b0(XmlPullParser xmlPullParser, Uri uri) throws r83 {
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        long j;
        ArrayList arrayList4;
        long j2;
        ArrayList arrayList5;
        long j3;
        long j4;
        long j5;
        Throwable th;
        long j6;
        h90 h90Var = this;
        boolean zV = h90Var.v(h90Var.e0(xmlPullParser, "profiles", new String[0]));
        long jH = H(xmlPullParser, "availabilityStartTime", -9223372036854775807L);
        long jP = P(xmlPullParser, "mediaPresentationDuration", -9223372036854775807L);
        long jP2 = P(xmlPullParser, "minBufferTime", -9223372036854775807L);
        boolean zEquals = "dynamic".equals(xmlPullParser.getAttributeValue(null, "type"));
        long jP3 = zEquals ? P(xmlPullParser, "minimumUpdatePeriod", -9223372036854775807L) : -9223372036854775807L;
        long jP4 = zEquals ? P(xmlPullParser, "timeShiftBufferDepth", -9223372036854775807L) : -9223372036854775807L;
        long jP5 = zEquals ? P(xmlPullParser, "suggestedPresentationDelay", -9223372036854775807L) : -9223372036854775807L;
        long jH2 = H(xmlPullParser, "publishTime", -9223372036854775807L);
        long j7 = zEquals ? 0L : -9223372036854775807L;
        ArrayList arrayListH = ru1.h(new dj(uri.toString(), uri.toString(), zV ? 1 : Integer.MIN_VALUE, 1));
        ArrayList arrayList6 = new ArrayList();
        ArrayList arrayList7 = new ArrayList();
        long j8 = zEquals ? -9223372036854775807L : 0L;
        ArrayList arrayList8 = arrayListH;
        long jB = j7;
        boolean z = false;
        boolean z2 = false;
        ph3 ph3VarF0 = null;
        tx4 tx4VarZ0 = null;
        Uri uriG = null;
        v14 v14VarT0 = null;
        while (true) {
            xmlPullParser.next();
            if (oa5.f(xmlPullParser, "BaseURL")) {
                if (!z2) {
                    jB = h90Var.B(xmlPullParser, jB);
                    z2 = true;
                }
                arrayList = arrayList8;
                arrayList2 = arrayList6;
                arrayList7.addAll(h90Var.C(xmlPullParser, arrayList, zV));
            } else {
                arrayList = arrayList8;
                arrayList2 = arrayList6;
                if (oa5.f(xmlPullParser, "ProgramInformation")) {
                    ph3VarF0 = f0(xmlPullParser);
                } else if (oa5.f(xmlPullParser, "UTCTiming")) {
                    tx4VarZ0 = z0(xmlPullParser);
                } else if (oa5.f(xmlPullParser, "Location")) {
                    uriG = kx4.g(uri.toString(), xmlPullParser.nextText());
                } else if (oa5.f(xmlPullParser, "ServiceDescription")) {
                    v14VarT0 = t0(xmlPullParser);
                } else {
                    if (!oa5.f(xmlPullParser, "Period") || z) {
                        arrayList3 = arrayList7;
                        j = jP;
                        arrayList8 = arrayList;
                        long j9 = j8;
                        long j10 = jB;
                        arrayList4 = arrayList2;
                        w(xmlPullParser);
                        j8 = j9;
                        j2 = j10;
                    } else {
                        if (arrayList7.isEmpty()) {
                            arrayList3 = arrayList7;
                            arrayList5 = arrayList;
                            j3 = j8;
                            j4 = jB;
                            arrayList4 = arrayList2;
                            arrayList8 = arrayList5;
                        } else {
                            arrayList5 = arrayList7;
                            arrayList3 = arrayList5;
                            arrayList8 = arrayList;
                            j3 = j8;
                            j4 = jB;
                            arrayList4 = arrayList2;
                        }
                        Pair pairD0 = d0(xmlPullParser, arrayList5, j3, j4, jH, jP4, zV);
                        na3 na3Var = (na3) pairD0.first;
                        j = jP;
                        if (na3Var.b != -9223372036854775807L) {
                            long jLongValue = ((Long) pairD0.second).longValue();
                            j5 = jLongValue == -9223372036854775807L ? -9223372036854775807L : na3Var.b + jLongValue;
                            arrayList4.add(na3Var);
                        } else {
                            if (!zEquals) {
                                throw r83.c("Unable to determine start of period " + arrayList4.size(), null);
                            }
                            j5 = j3;
                            z = true;
                        }
                        j2 = j4;
                        j8 = j5;
                    }
                    if (!oa5.d(xmlPullParser, "MPD")) {
                        if (j != -9223372036854775807L) {
                            th = null;
                            j6 = j;
                        } else if (j8 != -9223372036854775807L) {
                            j6 = j8;
                            th = null;
                        } else {
                            if (!zEquals) {
                                throw r83.c("Unable to determine duration of static manifest.", null);
                            }
                            th = null;
                            j6 = j;
                        }
                        if (arrayList4.isEmpty()) {
                            throw r83.c("No periods found.", th);
                        }
                        return g(jH, j6, jP2, zEquals, jP3, jP4, jP5, jH2, ph3VarF0, tx4VarZ0, v14VarT0, uriG, arrayList4);
                    }
                    long j11 = jP4;
                    long j12 = jP2;
                    ArrayList arrayList9 = arrayList4;
                    h90Var = this;
                    zEquals = zEquals;
                    jP3 = jP3;
                    jB = j2;
                    arrayList6 = arrayList9;
                    arrayList7 = arrayList3;
                    jP2 = j12;
                    jP4 = j11;
                    jP = j;
                }
            }
            arrayList3 = arrayList7;
            j2 = jB;
            j = jP;
            arrayList4 = arrayList2;
            arrayList8 = arrayList;
            if (!oa5.d(xmlPullParser, "MPD")) {
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public y3 c(long j, int i, List list, List list2, List list3, List list4) {
        return new y3(j, i, list, list2, list3, list4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public dv0 d(String str, String str2, long j, long j2, byte[] bArr) {
        return new dv0(str, str2, j2, j, bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Pair d0(XmlPullParser xmlPullParser, List list, long j, long j2, long j3, long j4, boolean z) {
        long jB;
        g04 g04Var;
        ArrayList arrayList;
        ArrayList arrayList2;
        long j5;
        Object obj;
        long j6;
        XmlPullParser xmlPullParser2;
        long j7;
        long j8;
        g04 g04VarO0;
        long j9;
        rj0 rj0Var;
        long j10;
        g04 g04Var2;
        ArrayList arrayList3;
        boolean z2;
        long j11;
        ArrayList arrayList4;
        ArrayList arrayList5;
        ArrayList arrayList6;
        List list2;
        ArrayList arrayList7;
        h90 h90Var = this;
        XmlPullParser xmlPullParser3 = xmlPullParser;
        String attributeValue = xmlPullParser3.getAttributeValue(null, Name.MARK);
        long jP = P(xmlPullParser3, "start", j);
        long j12 = j3 != -9223372036854775807L ? j3 + jP : -9223372036854775807L;
        long jP2 = P(xmlPullParser3, "duration", -9223372036854775807L);
        ArrayList arrayList8 = new ArrayList();
        long j13 = -9223372036854775807L;
        ArrayList arrayList9 = new ArrayList();
        boolean z3 = false;
        rj0 rj0VarI = null;
        long jB2 = j2;
        ArrayList arrayList10 = arrayList8;
        g04 g04Var3 = null;
        long j14 = -9223372036854775807L;
        ArrayList arrayList11 = new ArrayList();
        while (true) {
            xmlPullParser3.next();
            if (oa5.f(xmlPullParser3, "BaseURL")) {
                if (!z3) {
                    jB2 = h90Var.B(xmlPullParser3, jB2);
                    z3 = true;
                }
                arrayList11.addAll(h90Var.C(xmlPullParser3, list, z));
                arrayList2 = arrayList10;
                j9 = jB2;
                arrayList = arrayList9;
                z2 = z3;
                j5 = j13;
                obj = null;
                j6 = jP2;
                arrayList7 = arrayList11;
                rj0Var = rj0VarI;
                xmlPullParser2 = xmlPullParser3;
                g04Var2 = g04Var3;
                j11 = j14;
                j8 = j12;
            } else {
                ArrayList arrayList12 = arrayList10;
                if (oa5.f(xmlPullParser3, "AdaptationSet")) {
                    if (arrayList11.isEmpty()) {
                        arrayList6 = arrayList11;
                        list2 = list;
                    } else {
                        ArrayList arrayList13 = arrayList11;
                        arrayList6 = arrayList13;
                        list2 = arrayList13;
                    }
                    ArrayList arrayList14 = arrayList9;
                    long j15 = jB2;
                    long j16 = j12;
                    long j17 = jP2;
                    y3 y3VarY = h90Var.y(xmlPullParser3, list2, g04Var3, j17, j15, j14, j16, j4, z);
                    j12 = j16;
                    jB = j14;
                    arrayList12.add(y3VarY);
                    g04Var = g04Var3;
                    j6 = j17;
                    arrayList = arrayList14;
                    obj = null;
                    xmlPullParser2 = xmlPullParser3;
                    j7 = j15;
                    arrayList2 = arrayList12;
                    j5 = -9223372036854775807L;
                    arrayList5 = arrayList6;
                } else {
                    ArrayList arrayList15 = arrayList11;
                    ArrayList arrayList16 = arrayList9;
                    long j18 = jB2;
                    jB = j14;
                    if (oa5.f(xmlPullParser3, "EventStream")) {
                        arrayList16.add(T(xmlPullParser));
                        g04Var = g04Var3;
                        j6 = jP2;
                        arrayList = arrayList16;
                        arrayList2 = arrayList12;
                        j5 = -9223372036854775807L;
                        obj = null;
                        xmlPullParser2 = xmlPullParser3;
                        j7 = j18;
                        arrayList5 = arrayList15;
                    } else {
                        if (oa5.f(xmlPullParser3, "SegmentBase")) {
                            g04VarO0 = h90Var.m0(xmlPullParser3, null);
                            j9 = j18;
                            obj = null;
                            arrayList = arrayList16;
                            arrayList2 = arrayList12;
                            j5 = -9223372036854775807L;
                            j8 = j12;
                            j6 = jP2;
                            rj0Var = rj0VarI;
                            xmlPullParser2 = xmlPullParser3;
                        } else if (oa5.f(xmlPullParser3, "SegmentList")) {
                            long j19 = j12;
                            long j20 = jP2;
                            long jB3 = h90Var.B(xmlPullParser3, -9223372036854775807L);
                            arrayList = arrayList16;
                            arrayList2 = arrayList12;
                            j5 = -9223372036854775807L;
                            g04.b bVarN0 = h90Var.n0(xmlPullParser3, null, j19, j20, j18, jB3, j4);
                            j9 = j18;
                            obj = null;
                            j8 = j19;
                            j6 = j20;
                            rj0Var = rj0VarI;
                            xmlPullParser2 = xmlPullParser3;
                            j10 = jB3;
                            g04Var2 = bVarN0;
                            arrayList3 = arrayList15;
                            z2 = z3;
                            j11 = j10;
                            arrayList7 = arrayList3;
                        } else {
                            g04Var = g04Var3;
                            arrayList = arrayList16;
                            arrayList2 = arrayList12;
                            j5 = -9223372036854775807L;
                            if (oa5.f(xmlPullParser3, "SegmentTemplate")) {
                                jB = h90Var.B(xmlPullParser3, -9223372036854775807L);
                                obj = null;
                                g04VarO0 = h90Var.o0(xmlPullParser3, null, xi1.u(), j12, jP2, j18, jB, j4);
                                j6 = jP2;
                                xmlPullParser2 = xmlPullParser3;
                                j8 = j12;
                                j9 = j18;
                                rj0Var = rj0VarI;
                            } else {
                                obj = null;
                                j6 = jP2;
                                xmlPullParser2 = xmlPullParser3;
                                j7 = j18;
                                j8 = j12;
                                if (oa5.f(xmlPullParser2, "AssetIdentifier")) {
                                    rj0VarI = I(xmlPullParser2, "AssetIdentifier");
                                    arrayList4 = arrayList15;
                                } else {
                                    w(xmlPullParser2);
                                    arrayList4 = arrayList15;
                                }
                                j9 = j7;
                                rj0Var = rj0VarI;
                                j10 = jB;
                                g04Var2 = g04Var;
                                arrayList3 = arrayList4;
                                z2 = z3;
                                j11 = j10;
                                arrayList7 = arrayList3;
                            }
                        }
                        j10 = jB;
                        g04Var2 = g04VarO0;
                        arrayList3 = arrayList15;
                        z2 = z3;
                        j11 = j10;
                        arrayList7 = arrayList3;
                    }
                }
                j8 = j12;
                arrayList4 = arrayList5;
                j9 = j7;
                rj0Var = rj0VarI;
                j10 = jB;
                g04Var2 = g04Var;
                arrayList3 = arrayList4;
                z2 = z3;
                j11 = j10;
                arrayList7 = arrayList3;
            }
            if (oa5.d(xmlPullParser2, "Period")) {
                return Pair.create(h(attributeValue, jP, arrayList2, arrayList, rj0Var), Long.valueOf(j6));
            }
            h90Var = this;
            xmlPullParser3 = xmlPullParser2;
            j12 = j8;
            g04Var3 = g04Var2;
            j14 = j11;
            arrayList11 = arrayList7;
            arrayList10 = arrayList2;
            rj0VarI = rj0Var;
            z3 = z2;
            jP2 = j6;
            j13 = j5;
            jB2 = j9;
            arrayList9 = arrayList;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public iv0 e(String str, String str2, long j, long[] jArr, dv0[] dv0VarArr) {
        return new iv0(str, str2, j, jArr, dv0VarArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String[] e0(XmlPullParser xmlPullParser, String str, String[] strArr) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? strArr : attributeValue.split(",");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public t41 f(String str, String str2, int i, int i2, float f2, int i3, int i4, int i5, String str3, List list, List list2, String str4, String str5, String str6, List list3, List list4) {
        bx bxVar;
        String str7 = str5;
        String str8 = str4;
        String strU = u(str2, str8);
        if ("audio/eac3".equals(strU)) {
            strU = Q(list4);
            if ("audio/eac3-joc".equals(strU)) {
                str8 = "ec+3";
            }
        }
        if (nt2.p(str8, str7)) {
            bx bxVarB0 = fy4.b0(str8, str7, str6);
            if (str7 == null) {
                str7 = str8;
            }
            str8 = str7;
            bxVar = bxVarB0;
            strU = "video/dolby-vision";
        } else {
            bxVar = null;
        }
        int iS0 = s0(list);
        int iL0 = l0(list) | i0(list2) | k0(list3) | k0(list4);
        Pair pairW0 = w0(list3);
        t41.b bVarO0 = new t41.b().k0(str).X(str2).A0(strU).V(str8).u0(i5).C0(iS0).y0(iL0).W(bxVar).o0(str3);
        int iE = -1;
        t41.b bVarG0 = bVarO0.F0(pairW0 != null ? ((Integer) pairW0.first).intValue() : -1).G0(pairW0 != null ? ((Integer) pairW0.second).intValue() : -1);
        if (nt2.t(strU)) {
            bVarG0.H0(i).i0(i2).g0(f2);
        } else if (nt2.o(strU)) {
            bVarG0.U(i3).B0(i4);
        } else if (nt2.s(strU)) {
            if ("application/cea-608".equals(strU)) {
                iE = D(list2);
            } else if ("application/cea-708".equals(strU)) {
                iE = E(list2);
            }
            bVarG0.R(iE);
        } else if (nt2.q(strU)) {
            bVarG0.H0(i).i0(i2);
        }
        return bVarG0.Q();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ph3 f0(XmlPullParser xmlPullParser) {
        String strNextText = null;
        String strU0 = u0(xmlPullParser, "moreInformationURL", null);
        String strU02 = u0(xmlPullParser, "lang", null);
        String strNextText2 = null;
        String strNextText3 = null;
        while (true) {
            xmlPullParser.next();
            if (oa5.f(xmlPullParser, "Title")) {
                strNextText = xmlPullParser.nextText();
            } else if (oa5.f(xmlPullParser, "Source")) {
                strNextText2 = xmlPullParser.nextText();
            } else if (oa5.f(xmlPullParser, "Copyright")) {
                strNextText3 = xmlPullParser.nextText();
            } else {
                w(xmlPullParser);
            }
            String str = strNextText2;
            String str2 = strNextText;
            String str3 = strNextText3;
            if (oa5.d(xmlPullParser, "ProgramInformation")) {
                return new ph3(str2, str, str3, strU0, strU02);
            }
            strNextText = str2;
            strNextText2 = str;
            strNextText3 = str3;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g90 g(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, ph3 ph3Var, tx4 tx4Var, v14 v14Var, Uri uri, List list) {
        return new g90(j, j2, j3, z, j4, j5, j6, j7, ph3Var, tx4Var, v14Var, uri, list);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public vn3 g0(XmlPullParser xmlPullParser, String str, String str2) {
        long j;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        long j2 = -1;
        if (attributeValue2 != null) {
            String[] strArrSplit = attributeValue2.split("-");
            j = Long.parseLong(strArrSplit[0]);
            if (strArrSplit.length == 2) {
                j2 = (Long.parseLong(strArrSplit[1]) - j) + 1;
            }
        } else {
            j = 0;
        }
        return i(attributeValue, j, j2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public na3 h(String str, long j, List list, List list2, rj0 rj0Var) {
        return new na3(str, j, list, list2, rj0Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:56:0x025f A[LOOP:0: B:3:0x007a->B:56:0x025f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0204 A[EDGE_INSN: B:57:0x0204->B:46:0x0204 BREAK  A[LOOP:0: B:3:0x007a->B:56:0x025f], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public a h0(XmlPullParser xmlPullParser, List list, String str, String str2, String str3, String str4, int i, int i2, float f2, int i3, int i4, String str5, List list2, List list3, List list4, List list5, g04 g04Var, long j, long j2, long j3, long j4, long j5, boolean z) {
        String str6;
        ArrayList arrayList;
        int i5;
        ArrayList arrayList2;
        XmlPullParser xmlPullParser2;
        String str7;
        ArrayList arrayList3;
        ArrayList arrayList4;
        long j6;
        String str8;
        boolean z2;
        long j7;
        int i6;
        g04 eVar;
        ArrayList arrayList5;
        ArrayList arrayList6;
        ArrayList arrayList7;
        h90 h90Var = this;
        XmlPullParser xmlPullParser3 = xmlPullParser;
        String attributeValue = xmlPullParser3.getAttributeValue(null, Name.MARK);
        int iX = X(xmlPullParser3, "bandwidth", -1);
        String strU0 = u0(xmlPullParser3, "mimeType", str);
        String strU02 = u0(xmlPullParser3, "codecs", str2);
        String strU03 = u0(xmlPullParser3, "scte214:supplementalCodecs", str3);
        String strU04 = u0(xmlPullParser3, "scte214:supplementalProfiles", str4);
        int iX2 = X(xmlPullParser3, "width", i);
        int iX3 = X(xmlPullParser3, "height", i2);
        float fV = V(xmlPullParser3, f2);
        int iX4 = X(xmlPullParser3, "audioSamplingRate", i4);
        ArrayList arrayList8 = new ArrayList();
        ArrayList arrayList9 = new ArrayList();
        ArrayList arrayList10 = new ArrayList(list4);
        ArrayList arrayList11 = new ArrayList(list5);
        int i7 = i3;
        long j8 = j4;
        String str9 = null;
        boolean z3 = false;
        g04 g04Var2 = g04Var;
        long jB = j3;
        ArrayList arrayList12 = new ArrayList();
        while (true) {
            xmlPullParser3.next();
            ArrayList arrayList13 = arrayList8;
            if (oa5.f(xmlPullParser3, "BaseURL")) {
                if (!z3) {
                    jB = h90Var.B(xmlPullParser3, jB);
                    z3 = true;
                }
                g04 g04Var3 = g04Var2;
                str6 = attributeValue;
                arrayList12.addAll(h90Var.C(xmlPullParser3, list, z));
                arrayList = arrayList13;
                xmlPullParser2 = xmlPullParser3;
                arrayList3 = arrayList10;
                arrayList4 = arrayList11;
                arrayList7 = arrayList12;
                j6 = j8;
                str7 = strU02;
                i5 = iX;
                i6 = i7;
                str8 = str9;
                z2 = z3;
                eVar = g04Var3;
            } else {
                g04 g04Var4 = g04Var2;
                str6 = attributeValue;
                if (oa5.f(xmlPullParser3, "AudioChannelConfiguration")) {
                    int iA = h90Var.A(xmlPullParser3, strU02);
                    eVar = g04Var4;
                    arrayList = arrayList13;
                    xmlPullParser2 = xmlPullParser3;
                    i6 = iA;
                    arrayList3 = arrayList10;
                    arrayList4 = arrayList11;
                    arrayList7 = arrayList12;
                    j6 = j8;
                    str7 = strU02;
                    i5 = iX;
                    str8 = str9;
                    z2 = z3;
                } else if (oa5.f(xmlPullParser3, "SegmentBase")) {
                    g04.e eVarM0 = h90Var.m0(xmlPullParser3, (g04.e) g04Var4);
                    arrayList = arrayList13;
                    xmlPullParser2 = xmlPullParser3;
                    arrayList3 = arrayList10;
                    arrayList6 = arrayList12;
                    j6 = j8;
                    str7 = strU02;
                    i5 = iX;
                    i6 = i7;
                    str8 = str9;
                    z2 = z3;
                    eVar = eVarM0;
                    arrayList2 = arrayList9;
                    arrayList4 = arrayList11;
                    j7 = jB;
                    arrayList5 = arrayList6;
                    if (oa5.d(xmlPullParser2, "Representation")) {
                        break;
                    }
                    int i8 = iX2;
                    ArrayList arrayList14 = arrayList2;
                    String str10 = strU04;
                    iX2 = i8;
                    arrayList9 = arrayList14;
                    arrayList10 = arrayList3;
                    arrayList11 = arrayList4;
                    arrayList8 = arrayList;
                    g04Var2 = eVar;
                    jB = j7;
                    j8 = j6;
                    arrayList12 = arrayList5;
                    strU02 = str7;
                    z3 = z2;
                    str9 = str8;
                    i7 = i6;
                    strU03 = strU03;
                    strU04 = str10;
                    attributeValue = str6;
                    iX = i5;
                    xmlPullParser3 = xmlPullParser2;
                    h90Var = this;
                } else {
                    if (oa5.f(xmlPullParser3, "SegmentList")) {
                        long j9 = jB;
                        long jB2 = h90Var.B(xmlPullParser3, j8);
                        arrayList = arrayList13;
                        arrayList5 = arrayList12;
                        i5 = iX;
                        arrayList2 = arrayList9;
                        g04.b bVarN0 = h90Var.n0(xmlPullParser3, (g04.b) g04Var4, j, j2, j9, jB2, j5);
                        xmlPullParser2 = xmlPullParser3;
                        str7 = strU02;
                        str8 = str9;
                        z2 = z3;
                        arrayList4 = arrayList11;
                        j7 = j9;
                        i6 = i7;
                        eVar = bVarN0;
                        arrayList3 = arrayList10;
                        j6 = jB2;
                    } else {
                        arrayList = arrayList13;
                        ArrayList arrayList15 = arrayList10;
                        ArrayList arrayList16 = arrayList11;
                        ArrayList arrayList17 = arrayList12;
                        long j10 = jB;
                        i5 = iX;
                        arrayList2 = arrayList9;
                        if (oa5.f(xmlPullParser3, "SegmentTemplate")) {
                            long jB3 = h90Var.B(xmlPullParser3, j8);
                            str7 = strU02;
                            g04.c cVarO0 = h90Var.o0(xmlPullParser3, (g04.c) g04Var4, list5, j, j2, j10, jB3, j5);
                            xmlPullParser2 = xmlPullParser3;
                            str8 = str9;
                            z2 = z3;
                            arrayList4 = arrayList16;
                            j7 = j10;
                            i6 = i7;
                            eVar = cVarO0;
                            arrayList3 = arrayList15;
                            j6 = jB3;
                            arrayList5 = arrayList17;
                        } else {
                            xmlPullParser2 = xmlPullParser3;
                            str7 = strU02;
                            if (oa5.f(xmlPullParser2, "ContentProtection")) {
                                Pair pairF = F(xmlPullParser);
                                Object obj = pairF.first;
                                if (obj != null) {
                                    str9 = (String) obj;
                                }
                                Object obj2 = pairF.second;
                                if (obj2 != null) {
                                    arrayList.add((oo0.b) obj2);
                                }
                                str8 = str9;
                                z2 = z3;
                                arrayList3 = arrayList15;
                                arrayList4 = arrayList16;
                                j7 = j10;
                                j6 = j8;
                            } else {
                                if (oa5.f(xmlPullParser2, "InbandEventStream")) {
                                    arrayList2.add(I(xmlPullParser2, "InbandEventStream"));
                                    arrayList3 = arrayList15;
                                } else if (oa5.f(xmlPullParser2, "EssentialProperty")) {
                                    arrayList3 = arrayList15;
                                    arrayList3.add(I(xmlPullParser2, "EssentialProperty"));
                                } else {
                                    arrayList3 = arrayList15;
                                    if (oa5.f(xmlPullParser2, "SupplementalProperty")) {
                                        arrayList4 = arrayList16;
                                        arrayList4.add(I(xmlPullParser2, "SupplementalProperty"));
                                    } else {
                                        arrayList4 = arrayList16;
                                        w(xmlPullParser2);
                                    }
                                    j6 = j8;
                                    str8 = str9;
                                    z2 = z3;
                                    j7 = j10;
                                }
                                arrayList4 = arrayList16;
                                j6 = j8;
                                str8 = str9;
                                z2 = z3;
                                j7 = j10;
                            }
                            i6 = i7;
                            eVar = g04Var4;
                            arrayList5 = arrayList17;
                        }
                    }
                    if (oa5.d(xmlPullParser2, "Representation")) {
                    }
                }
            }
            arrayList2 = arrayList9;
            arrayList6 = arrayList7;
            j7 = jB;
            arrayList5 = arrayList6;
            if (oa5.d(xmlPullParser2, "Representation")) {
            }
        }
        ArrayList arrayList18 = arrayList2;
        String str11 = strU04;
        ArrayList arrayList19 = arrayList;
        String str12 = strU03;
        ArrayList arrayList20 = arrayList4;
        ArrayList arrayList21 = arrayList3;
        t41 t41VarF = f(str6, strU0, iX2, iX3, fV, i6, iX4, i5, str5, list2, list3, str7, str12, str11, arrayList21, arrayList20);
        if (eVar == null) {
            eVar = new g04.e();
        }
        boolean zIsEmpty = arrayList5.isEmpty();
        List list6 = arrayList5;
        if (zIsEmpty) {
            list6 = list;
        }
        return new a(t41VarF, list6, eVar, str8, arrayList19, arrayList18, arrayList21, arrayList20, -1L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public vn3 i(String str, long j, long j2) {
        return new vn3(str, j, j2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int i0(List list) {
        int iX0;
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            rj0 rj0Var = (rj0) list.get(i2);
            if (xa.a("urn:mpeg:dash:role:2011", rj0Var.a)) {
                iX0 = j0(rj0Var.b);
            } else if (xa.a("urn:tva:metadata:cs:AudioPurposeCS:2007", rj0Var.a)) {
                iX0 = x0(rj0Var.b);
            }
            i |= iX0;
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public tq3 j(a aVar, String str, List list, String str2, ArrayList arrayList, ArrayList arrayList2) {
        t41.b bVarB = aVar.a.b();
        if (str == null || !list.isEmpty()) {
            bVarB.n0(list);
        } else {
            bVarB.m0(str);
        }
        String str3 = aVar.d;
        if (str3 != null) {
            str2 = str3;
        }
        ArrayList arrayList3 = aVar.e;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            r(arrayList3);
            s(arrayList3);
            bVarB.d0(new oo0(str2, arrayList3));
        }
        ArrayList arrayList4 = aVar.f;
        arrayList4.addAll(arrayList2);
        return tq3.o(aVar.g, bVarB.Q(), aVar.b, aVar.c, arrayList4, aVar.h, aVar.i, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int j0(String str) {
        if (str == null) {
            return 0;
        }
        switch (str) {
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g04.b k(vn3 vn3Var, long j, long j2, long j3, long j4, List list, long j5, List list2, long j6, long j7) {
        return new g04.b(vn3Var, j, j2, j3, j4, list, j5, list2, fy4.c1(j6), fy4.c1(j7));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int k0(List list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (xa.a("http://dashif.org/guidelines/trickmode", ((rj0) list.get(i2)).a)) {
                i = Http2.INITIAL_MAX_FRAME_SIZE;
            }
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g04.c l(vn3 vn3Var, long j, long j2, long j3, long j4, long j5, List list, long j6, ox4 ox4Var, ox4 ox4Var2, long j7, long j8) {
        return new g04.c(vn3Var, j, j2, j3, j4, j5, list, j6, ox4Var, ox4Var2, fy4.c1(j7), fy4.c1(j8));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int l0(List list) {
        int iJ0 = 0;
        for (int i = 0; i < list.size(); i++) {
            rj0 rj0Var = (rj0) list.get(i);
            if (xa.a("urn:mpeg:dash:role:2011", rj0Var.a)) {
                iJ0 |= j0(rj0Var.b);
            }
        }
        return iJ0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g04.d m(long j, long j2) {
        return new g04.d(j, j2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g04.e m0(XmlPullParser xmlPullParser, g04.e eVar) {
        long jA0 = a0(xmlPullParser, "timescale", eVar != null ? eVar.b : 1L);
        long jA02 = a0(xmlPullParser, "presentationTimeOffset", eVar != null ? eVar.c : 0L);
        long j = eVar != null ? eVar.d : 0L;
        long j2 = eVar != null ? eVar.e : 0L;
        String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] strArrSplit = attributeValue.split("-");
            j = Long.parseLong(strArrSplit[0]);
            j2 = (Long.parseLong(strArrSplit[1]) - j) + 1;
        }
        long j3 = j2;
        vn3 vn3VarW = eVar != null ? eVar.a : null;
        while (true) {
            xmlPullParser.next();
            if (oa5.f(xmlPullParser, "Initialization")) {
                vn3VarW = W(xmlPullParser);
            } else {
                w(xmlPullParser);
            }
            vn3 vn3Var = vn3VarW;
            if (oa5.d(xmlPullParser, "SegmentBase")) {
                return n(vn3Var, jA0, jA02, j, j3);
            }
            vn3VarW = vn3Var;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g04.e n(vn3 vn3Var, long j, long j2, long j3, long j4) {
        return new g04.e(vn3Var, j, j2, j3, j4);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g04.b n0(XmlPullParser xmlPullParser, g04.b bVar, long j, long j2, long j3, long j4, long j5) {
        long j6;
        long jA0 = a0(xmlPullParser, "timescale", bVar != null ? bVar.b : 1L);
        long jA02 = a0(xmlPullParser, "presentationTimeOffset", bVar != null ? bVar.c : 0L);
        long jA03 = a0(xmlPullParser, "duration", bVar != null ? bVar.e : -9223372036854775807L);
        long jA04 = a0(xmlPullParser, "startNumber", bVar != null ? bVar.d : 1L);
        long jT = t(j3, j4);
        List arrayList = null;
        vn3 vn3VarW = null;
        List listP0 = null;
        while (true) {
            xmlPullParser.next();
            if (oa5.f(xmlPullParser, "Initialization")) {
                vn3VarW = W(xmlPullParser);
                j6 = jA0;
            } else if (oa5.f(xmlPullParser, "SegmentTimeline")) {
                j6 = jA0;
                listP0 = p0(xmlPullParser, j6, j2);
            } else {
                j6 = jA0;
                if (oa5.f(xmlPullParser, "SegmentURL")) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(q0(xmlPullParser));
                } else {
                    w(xmlPullParser);
                }
            }
            if (oa5.d(xmlPullParser, "SegmentList")) {
                break;
            }
            jA0 = j6;
        }
        if (bVar != null) {
            if (vn3VarW == null) {
                vn3VarW = bVar.a;
            }
            if (listP0 == null) {
                listP0 = bVar.f;
            }
            if (arrayList == null) {
                arrayList = bVar.j;
            }
        }
        return k(vn3VarW, j6, jA02, jA04, jA03, listP0, jT, arrayList, j5, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public tx4 o(String str, String str2) {
        return new tx4(str, str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public g04.c o0(XmlPullParser xmlPullParser, g04.c cVar, List list, long j, long j2, long j3, long j4, long j5) {
        long j6;
        h90 h90Var = this;
        long jA0 = a0(xmlPullParser, "timescale", cVar != null ? cVar.b : 1L);
        long jA02 = a0(xmlPullParser, "presentationTimeOffset", cVar != null ? cVar.c : 0L);
        long jA03 = a0(xmlPullParser, "duration", cVar != null ? cVar.e : -9223372036854775807L);
        long jA04 = a0(xmlPullParser, "startNumber", cVar != null ? cVar.d : 1L);
        long jZ = Z(list);
        long jT = t(j3, j4);
        ox4 ox4VarY0 = h90Var.y0(xmlPullParser, "media", cVar != null ? cVar.k : null);
        ox4 ox4VarY02 = h90Var.y0(xmlPullParser, "initialization", cVar != null ? cVar.j : null);
        vn3 vn3VarW = null;
        List listP0 = null;
        while (true) {
            xmlPullParser.next();
            if (oa5.f(xmlPullParser, "Initialization")) {
                vn3VarW = W(xmlPullParser);
                j6 = jA0;
            } else if (oa5.f(xmlPullParser, "SegmentTimeline")) {
                j6 = jA0;
                listP0 = h90Var.p0(xmlPullParser, j6, j2);
            } else {
                j6 = jA0;
                w(xmlPullParser);
            }
            if (oa5.d(xmlPullParser, "SegmentTemplate")) {
                break;
            }
            h90Var = this;
            jT = jT;
            jZ = jZ;
            jA04 = jA04;
            jA02 = jA02;
            jA0 = j6;
        }
        if (cVar != null) {
            if (vn3VarW == null) {
                vn3VarW = cVar.a;
            }
            if (listP0 == null) {
                listP0 = cVar.f;
            }
        }
        return l(vn3VarW, j6, jA02, jA04, jZ, jA03, listP0, jT, ox4VarY02, ox4VarY0, j5, j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List p0(XmlPullParser xmlPullParser, long j, long j2) {
        ArrayList arrayList = new ArrayList();
        long jB = 0;
        long jA0 = -9223372036854775807L;
        boolean z = false;
        int iX = 0;
        do {
            xmlPullParser.next();
            if (oa5.f(xmlPullParser, "S")) {
                long jA02 = a0(xmlPullParser, "t", -9223372036854775807L);
                if (z) {
                    ArrayList arrayList2 = arrayList;
                    jB = b(arrayList2, jB, jA0, iX, jA02);
                    arrayList = arrayList2;
                }
                if (jA02 != -9223372036854775807L) {
                    jB = jA02;
                }
                jA0 = a0(xmlPullParser, "d", -9223372036854775807L);
                iX = X(xmlPullParser, "r", 0);
                z = true;
            } else {
                w(xmlPullParser);
            }
        } while (!oa5.d(xmlPullParser, "SegmentTimeline"));
        if (z) {
            b(arrayList, jB, jA0, iX, fy4.u1(j2, j, 1000L));
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public vn3 q0(XmlPullParser xmlPullParser) {
        return g0(xmlPullParser, "media", "mediaRange");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int r0(String str) {
        if (str == null) {
            return 0;
        }
        return (str.equals("forced_subtitle") || str.equals("forced-subtitle")) ? 2 : 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int s0(List list) {
        int iR0 = 0;
        for (int i = 0; i < list.size(); i++) {
            rj0 rj0Var = (rj0) list.get(i);
            if (xa.a("urn:mpeg:dash:role:2011", rj0Var.a)) {
                iR0 |= r0(rj0Var.b);
            }
        }
        return iR0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public v14 t0(XmlPullParser xmlPullParser) {
        long jA0 = -9223372036854775807L;
        long jA02 = -9223372036854775807L;
        long jA03 = -9223372036854775807L;
        float fU = -3.4028235E38f;
        float fU2 = -3.4028235E38f;
        while (true) {
            xmlPullParser.next();
            if (oa5.f(xmlPullParser, "Latency")) {
                jA0 = a0(xmlPullParser, "target", -9223372036854775807L);
                jA02 = a0(xmlPullParser, "min", -9223372036854775807L);
                jA03 = a0(xmlPullParser, "max", -9223372036854775807L);
            } else if (oa5.f(xmlPullParser, "PlaybackRate")) {
                fU = U(xmlPullParser, "min", -3.4028235E38f);
                fU2 = U(xmlPullParser, "max", -3.4028235E38f);
            }
            long j = jA0;
            long j2 = jA02;
            long j3 = jA03;
            float f2 = fU;
            float f3 = fU2;
            if (oa5.d(xmlPullParser, "ServiceDescription")) {
                return new v14(j, j2, j3, f2, f3);
            }
            jA0 = j;
            jA02 = j2;
            jA03 = j3;
            fU = f2;
            fU2 = f3;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean v(String[] strArr) {
        for (String str : strArr) {
            if (str.startsWith("urn:dvb:dash:profile:dvb-dash:")) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Pair w0(List list) {
        String str;
        char c2 = 0;
        for (int i = 0; i < list.size(); i++) {
            rj0 rj0Var = (rj0) list.get(i);
            if ((xa.a("http://dashif.org/thumbnail_tile", rj0Var.a) || xa.a("http://dashif.org/guidelines/thumbnail_tile", rj0Var.a)) && (str = rj0Var.b) != null) {
                String[] strArrG1 = fy4.G1(str, "x");
                if (strArrG1.length != 2) {
                    continue;
                } else {
                    try {
                        return Pair.create(Integer.valueOf(Integer.parseInt(strArrG1[c2])), Integer.valueOf(Integer.parseInt(strArrG1[1])));
                    } catch (NumberFormatException unused) {
                        continue;
                    }
                }
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a(Landroid/net/Uri;Ljava/io/InputStream;)Ljava/lang/Object; */
    @Override // t83.a
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public g90 a(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser xmlPullParserNewPullParser = this.a.newPullParser();
            xmlPullParserNewPullParser.setInput(inputStream, null);
            if (xmlPullParserNewPullParser.next() == 2 && "MPD".equals(xmlPullParserNewPullParser.getName())) {
                return b0(xmlPullParserNewPullParser, uri);
            }
            throw r83.c("inputStream does not contain a valid media presentation description", null);
        } catch (XmlPullParserException e2) {
            if (e2.getDetail() instanceof IOException) {
                throw ((IOException) e2.getDetail());
            }
            throw r83.c(null, e2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int x0(String str) {
        if (str == null) {
            return 0;
        }
        switch (str) {
        }
        return 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:75:0x03cb A[LOOP:0: B:3:0x00a2->B:75:0x03cb, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x037b A[EDGE_INSN: B:76:0x037b->B:69:0x037b BREAK  A[LOOP:0: B:3:0x00a2->B:75:0x03cb], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public y3 y(XmlPullParser xmlPullParser, List list, g04 g04Var, long j, long j2, long j3, long j4, long j5, boolean z) {
        String str;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        String str2;
        int i;
        int i2;
        int iP;
        long j6;
        ArrayList arrayList5;
        g04 g04VarO0;
        ArrayList arrayList6;
        String str3;
        long j7;
        int i3;
        ArrayList arrayList7;
        ArrayList arrayList8;
        ArrayList arrayList9;
        ArrayList arrayList10;
        ArrayList arrayList11;
        List list2;
        ArrayList arrayList12;
        g04 g04Var2;
        ArrayList arrayList13;
        XmlPullParser xmlPullParser2;
        h90 h90Var;
        int i4;
        int i5;
        long j8;
        ArrayList arrayList14;
        ArrayList arrayList15;
        String str4;
        int i6;
        String str5;
        float f2;
        long j9;
        String str6;
        long j10;
        boolean z2;
        String str7;
        long j11;
        ArrayList arrayList16;
        ArrayList arrayList17;
        ArrayList arrayList18;
        ArrayList arrayList19;
        ArrayList arrayList20;
        h90 h90Var2 = this;
        XmlPullParser xmlPullParser3 = xmlPullParser;
        long jA0 = a0(xmlPullParser3, Name.MARK, -1L);
        int iG = G(xmlPullParser);
        String attributeValue = xmlPullParser3.getAttributeValue(null, "mimeType");
        String attributeValue2 = xmlPullParser3.getAttributeValue(null, "codecs");
        String attributeValue3 = xmlPullParser3.getAttributeValue(null, "scte214:supplementalCodecs");
        String attributeValue4 = xmlPullParser3.getAttributeValue(null, "scte214:supplementalProfiles");
        int iX = X(xmlPullParser3, "width", -1);
        int iX2 = X(xmlPullParser3, "height", -1);
        float fV = V(xmlPullParser3, -1.0f);
        int iX3 = X(xmlPullParser3, "audioSamplingRate", -1);
        String str8 = "lang";
        String attributeValue5 = xmlPullParser3.getAttributeValue(null, "lang");
        String attributeValue6 = xmlPullParser3.getAttributeValue(null, "label");
        ArrayList arrayList21 = new ArrayList();
        ArrayList arrayList22 = new ArrayList();
        ArrayList arrayList23 = new ArrayList();
        ArrayList arrayList24 = arrayList21;
        ArrayList arrayList25 = new ArrayList();
        ArrayList arrayList26 = new ArrayList();
        ArrayList arrayList27 = new ArrayList();
        ArrayList arrayList28 = arrayList23;
        ArrayList arrayList29 = new ArrayList();
        String str9 = attributeValue;
        ArrayList arrayList30 = new ArrayList();
        long j12 = j3;
        String str10 = attributeValue4;
        int i7 = iX;
        int i8 = iX2;
        float f3 = fV;
        int iP2 = iG;
        String str11 = attributeValue5;
        boolean z3 = false;
        int iA = -1;
        String str12 = null;
        g04 g04Var3 = g04Var;
        String str13 = attributeValue3;
        long jB = j2;
        ArrayList arrayList31 = new ArrayList();
        while (true) {
            xmlPullParser3.next();
            int i9 = iA;
            if (oa5.f(xmlPullParser3, "BaseURL")) {
                if (!z3) {
                    jB = h90Var2.B(xmlPullParser3, jB);
                    z3 = true;
                }
                arrayList31.addAll(h90Var2.C(xmlPullParser3, list, z));
                ArrayList arrayList32 = arrayList24;
                arrayList4 = arrayList27;
                arrayList10 = arrayList32;
                iA = i9;
                jB = jB;
                arrayList19 = arrayList31;
                arrayList5 = arrayList22;
                str = str8;
                arrayList = arrayList25;
                g04VarO0 = g04Var3;
                arrayList7 = arrayList30;
                arrayList8 = arrayList29;
                i = iX3;
                arrayList6 = arrayList26;
                arrayList9 = arrayList28;
            } else {
                long j13 = jB;
                if (oa5.f(xmlPullParser3, "ContentProtection")) {
                    Pair pairF = F(xmlPullParser);
                    arrayList18 = arrayList31;
                    Object obj = pairF.first;
                    if (obj != null) {
                        str12 = (String) obj;
                    }
                    Object obj2 = pairF.second;
                    if (obj2 != null) {
                        arrayList22.add((oo0.b) obj2);
                    }
                    ArrayList arrayList33 = arrayList24;
                    arrayList4 = arrayList27;
                    arrayList10 = arrayList33;
                    iA = i9;
                    arrayList8 = arrayList29;
                    str = str8;
                    arrayList = arrayList25;
                    arrayList9 = arrayList28;
                    arrayList7 = arrayList30;
                    jB = j13;
                    arrayList5 = arrayList22;
                    i = iX3;
                    g04VarO0 = g04Var3;
                } else {
                    ArrayList arrayList34 = arrayList31;
                    if (oa5.f(xmlPullParser3, "ContentComponent")) {
                        String strQ = q(str11, xmlPullParser3.getAttributeValue(null, str8));
                        iP2 = p(iP2, G(xmlPullParser));
                        ArrayList arrayList35 = arrayList24;
                        arrayList4 = arrayList27;
                        arrayList10 = arrayList35;
                        iA = i9;
                        str11 = strQ;
                    } else {
                        if (oa5.f(xmlPullParser3, "Role")) {
                            arrayList26.add(I(xmlPullParser3, "Role"));
                        } else if (oa5.f(xmlPullParser3, "AudioChannelConfiguration")) {
                            ArrayList arrayList36 = arrayList24;
                            arrayList4 = arrayList27;
                            arrayList10 = arrayList36;
                            iA = h90Var2.A(xmlPullParser3, attributeValue2);
                        } else if (oa5.f(xmlPullParser3, "Accessibility")) {
                            arrayList25.add(I(xmlPullParser3, "Accessibility"));
                        } else if (oa5.f(xmlPullParser3, "EssentialProperty")) {
                            arrayList27.add(I(xmlPullParser3, "EssentialProperty"));
                        } else if (oa5.f(xmlPullParser3, "SupplementalProperty")) {
                            arrayList29.add(I(xmlPullParser3, "SupplementalProperty"));
                        } else {
                            if (oa5.f(xmlPullParser3, "Representation")) {
                                if (arrayList34.isEmpty()) {
                                    list2 = list;
                                    arrayList2 = arrayList24;
                                    arrayList12 = arrayList30;
                                    g04Var2 = g04Var3;
                                    arrayList13 = arrayList29;
                                    xmlPullParser2 = xmlPullParser3;
                                    h90Var = h90Var2;
                                    i4 = iP2;
                                    i5 = i7;
                                    j8 = j13;
                                    arrayList14 = arrayList34;
                                    arrayList15 = arrayList27;
                                    str = str8;
                                    str4 = str10;
                                    arrayList3 = arrayList28;
                                    i6 = i8;
                                    iA = i9;
                                    str5 = str11;
                                    f2 = f3;
                                    j9 = j5;
                                    arrayList5 = arrayList22;
                                    str6 = str9;
                                    j10 = j;
                                    z2 = z;
                                    str7 = str13;
                                    j11 = j4;
                                } else {
                                    arrayList2 = arrayList24;
                                    arrayList12 = arrayList30;
                                    ArrayList arrayList37 = arrayList34;
                                    g04Var2 = g04Var3;
                                    arrayList13 = arrayList29;
                                    xmlPullParser2 = xmlPullParser3;
                                    h90Var = h90Var2;
                                    i4 = iP2;
                                    i5 = i7;
                                    j8 = j13;
                                    arrayList14 = arrayList37;
                                    iA = i9;
                                    arrayList15 = arrayList27;
                                    str = str8;
                                    str4 = str10;
                                    arrayList3 = arrayList28;
                                    i6 = i8;
                                    z2 = z;
                                    str5 = str11;
                                    str7 = str13;
                                    f2 = f3;
                                    j11 = j4;
                                    j9 = j5;
                                    arrayList5 = arrayList22;
                                    str6 = str9;
                                    j10 = j;
                                    list2 = arrayList37;
                                }
                                a aVarH0 = h90Var.h0(xmlPullParser2, list2, str6, attributeValue2, str7, str4, i5, i6, f2, iA, iX3, str5, arrayList26, arrayList25, arrayList15, arrayList13, g04Var2, j11, j10, j8, j12, j9, z2);
                                str9 = str6;
                                str13 = str7;
                                str10 = str4;
                                i8 = i6;
                                f3 = f2;
                                String str14 = str5;
                                ArrayList arrayList38 = arrayList13;
                                g04VarO0 = g04Var2;
                                arrayList6 = arrayList26;
                                arrayList4 = arrayList15;
                                str3 = attributeValue2;
                                arrayList = arrayList25;
                                i = iX3;
                                i7 = i5;
                                iP = p(i4, nt2.k(aVarH0.a.p));
                                ArrayList arrayList39 = arrayList12;
                                arrayList39.add(aVarH0);
                                xmlPullParser3 = xmlPullParser2;
                                jB = j8;
                                arrayList7 = arrayList39;
                                arrayList8 = arrayList38;
                                str11 = str14;
                                arrayList11 = arrayList14;
                            } else {
                                str = str8;
                                arrayList = arrayList25;
                                arrayList2 = arrayList24;
                                arrayList3 = arrayList28;
                                ArrayList arrayList40 = arrayList29;
                                arrayList4 = arrayList27;
                                str2 = str11;
                                i = iX3;
                                ArrayList arrayList41 = arrayList30;
                                i2 = i9;
                                XmlPullParser xmlPullParser4 = xmlPullParser3;
                                h90 h90Var3 = h90Var2;
                                iP = iP2;
                                j6 = j13;
                                arrayList5 = arrayList22;
                                g04VarO0 = g04Var3;
                                ArrayList arrayList42 = arrayList34;
                                arrayList6 = arrayList26;
                                str3 = attributeValue2;
                                j7 = j12;
                                if (oa5.f(xmlPullParser4, "SegmentBase")) {
                                    g04.e eVarM0 = h90Var3.m0(xmlPullParser4, (g04.e) g04VarO0);
                                    xmlPullParser3 = xmlPullParser4;
                                    g04VarO0 = eVarM0;
                                    j12 = j7;
                                    jB = j6;
                                    arrayList7 = arrayList41;
                                    arrayList8 = arrayList40;
                                    str11 = str2;
                                    iA = i2;
                                    arrayList11 = arrayList42;
                                } else if (oa5.f(xmlPullParser4, "SegmentList")) {
                                    long jB2 = h90Var3.B(xmlPullParser4, j7);
                                    arrayList7 = arrayList41;
                                    xmlPullParser3 = xmlPullParser;
                                    g04VarO0 = h90Var3.n0(xmlPullParser3, (g04.b) g04VarO0, j4, j, j6, jB2, j5);
                                    jB = j6;
                                    arrayList8 = arrayList40;
                                    iA = i2;
                                    iP2 = iP;
                                    arrayList9 = arrayList3;
                                    j12 = jB2;
                                    str11 = str2;
                                    arrayList10 = arrayList2;
                                    arrayList20 = arrayList42;
                                    if (!oa5.d(xmlPullParser3, "AdaptationSet")) {
                                        break;
                                    }
                                    ArrayList arrayList43 = arrayList4;
                                    arrayList24 = arrayList10;
                                    arrayList27 = arrayList43;
                                    h90Var2 = this;
                                    arrayList30 = arrayList7;
                                    arrayList28 = arrayList9;
                                    arrayList29 = arrayList8;
                                    attributeValue2 = str3;
                                    iX3 = i;
                                    arrayList25 = arrayList;
                                    arrayList26 = arrayList6;
                                    arrayList31 = arrayList20;
                                    str8 = str;
                                    g04Var3 = g04VarO0;
                                    arrayList22 = arrayList5;
                                } else {
                                    i3 = iP;
                                    xmlPullParser3 = xmlPullParser4;
                                    arrayList7 = arrayList41;
                                    if (oa5.f(xmlPullParser3, "SegmentTemplate")) {
                                        long jB3 = h90Var3.B(xmlPullParser3, j7);
                                        arrayList8 = arrayList40;
                                        g04VarO0 = h90Var3.o0(xmlPullParser3, (g04.c) g04VarO0, arrayList8, j4, j, j6, jB3, j5);
                                        jB = j6;
                                        iP2 = i3;
                                        arrayList10 = arrayList2;
                                        arrayList9 = arrayList3;
                                        j12 = jB3;
                                        arrayList16 = arrayList42;
                                        str11 = str2;
                                        iA = i2;
                                        arrayList20 = arrayList16;
                                        if (!oa5.d(xmlPullParser3, "AdaptationSet")) {
                                        }
                                    } else {
                                        arrayList8 = arrayList40;
                                        if (oa5.f(xmlPullParser3, "InbandEventStream")) {
                                            arrayList9 = arrayList3;
                                            arrayList9.add(I(xmlPullParser3, "InbandEventStream"));
                                            arrayList10 = arrayList2;
                                            arrayList17 = arrayList42;
                                        } else {
                                            arrayList9 = arrayList3;
                                            if (oa5.f(xmlPullParser3, "Label")) {
                                                arrayList10 = arrayList2;
                                                arrayList10.add(Y(xmlPullParser));
                                                arrayList17 = arrayList42;
                                            } else {
                                                arrayList10 = arrayList2;
                                                arrayList17 = arrayList42;
                                                if (oa5.e(xmlPullParser3)) {
                                                    z(xmlPullParser);
                                                    arrayList17 = arrayList42;
                                                }
                                            }
                                        }
                                        iP2 = i3;
                                        j12 = j7;
                                        jB = j6;
                                        arrayList16 = arrayList17;
                                        str11 = str2;
                                        iA = i2;
                                        arrayList20 = arrayList16;
                                        if (!oa5.d(xmlPullParser3, "AdaptationSet")) {
                                        }
                                    }
                                }
                            }
                            arrayList10 = arrayList2;
                            arrayList9 = arrayList3;
                            iP2 = iP;
                            arrayList20 = arrayList11;
                            if (!oa5.d(xmlPullParser3, "AdaptationSet")) {
                            }
                        }
                        arrayList5 = arrayList22;
                        g04VarO0 = g04Var3;
                        arrayList6 = arrayList26;
                        str3 = attributeValue2;
                        j7 = j12;
                        i3 = iP2;
                        j6 = j13;
                        ArrayList arrayList44 = arrayList24;
                        arrayList4 = arrayList27;
                        arrayList10 = arrayList44;
                        str = str8;
                        arrayList = arrayList25;
                        arrayList7 = arrayList30;
                        arrayList17 = arrayList34;
                        i2 = i9;
                        arrayList8 = arrayList29;
                        i = iX3;
                        arrayList9 = arrayList28;
                        str2 = str11;
                        iP2 = i3;
                        j12 = j7;
                        jB = j6;
                        arrayList16 = arrayList17;
                        str11 = str2;
                        iA = i2;
                        arrayList20 = arrayList16;
                        if (!oa5.d(xmlPullParser3, "AdaptationSet")) {
                        }
                    }
                    str = str8;
                    arrayList = arrayList25;
                    arrayList7 = arrayList30;
                    jB = j13;
                    arrayList8 = arrayList29;
                    arrayList5 = arrayList22;
                    i = iX3;
                    g04VarO0 = g04Var3;
                    arrayList9 = arrayList28;
                    arrayList18 = arrayList34;
                }
                arrayList19 = arrayList18;
                arrayList6 = arrayList26;
            }
            str3 = attributeValue2;
            arrayList20 = arrayList19;
            if (!oa5.d(xmlPullParser3, "AdaptationSet")) {
            }
        }
        ArrayList arrayList45 = new ArrayList(arrayList7.size());
        int i10 = 0;
        while (i10 < arrayList7.size()) {
            ArrayList arrayList46 = arrayList9;
            ArrayList arrayList47 = arrayList10;
            String str15 = attributeValue6;
            arrayList45.add(j((a) arrayList7.get(i10), str15, arrayList47, str12, arrayList5, arrayList46));
            i10++;
            attributeValue6 = str15;
            arrayList9 = arrayList46;
            arrayList10 = arrayList47;
        }
        return c(jA0, iP2, arrayList45, arrayList, arrayList4, arrayList8);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ox4 y0(XmlPullParser xmlPullParser, String str, ox4 ox4Var) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue != null ? ox4.b(attributeValue) : ox4Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void z(XmlPullParser xmlPullParser) {
        w(xmlPullParser);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public tx4 z0(XmlPullParser xmlPullParser) {
        return o(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, ES6Iterator.VALUE_PROPERTY));
    }
}
