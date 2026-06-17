package defpackage;

import android.net.Uri;
import android.text.TextUtils;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.http2.Http2;
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

    public h90() {
        try {
            this.a = XmlPullParserFactory.newInstance();
        } catch (XmlPullParserException e2) {
            cx4.a("Couldn't create XmlPullParserFactory instance", e2);
            throw null;
        }
    }

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

    public static long H(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : fy4.l1(attributeValue);
    }

    public static rj0 I(XmlPullParser xmlPullParser, String str) {
        String strU0 = u0(xmlPullParser, "schemeIdUri", "");
        String strU02 = u0(xmlPullParser, ES6Iterator.VALUE_PROPERTY, null);
        String strU03 = u0(xmlPullParser, Name.MARK, null);
        do {
            xmlPullParser.next();
        } while (!oa5.d(xmlPullParser, str));
        return new rj0(strU0, strU02, strU03);
    }

    public static int J(XmlPullParser xmlPullParser, String str) {
        String attributeValue = xmlPullParser.getAttributeValue(null, ES6Iterator.VALUE_PROPERTY);
        if (attributeValue == null || attributeValue.length() != 6) {
            return -1;
        }
        int i = Integer.parseInt(attributeValue, 16);
        return (8388608 & i) != 0 ? L(str) : K(i);
    }

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

    public static int N(XmlPullParser xmlPullParser) {
        int iX = X(xmlPullParser, ES6Iterator.VALUE_PROPERTY, -1);
        if (iX <= 0 || iX >= 33) {
            return -1;
        }
        return iX;
    }

    public static int O(XmlPullParser xmlPullParser) {
        int iBitCount;
        String attributeValue = xmlPullParser.getAttributeValue(null, ES6Iterator.VALUE_PROPERTY);
        if (attributeValue == null || (iBitCount = Integer.bitCount(Integer.parseInt(attributeValue, 16))) == 0) {
            return -1;
        }
        return iBitCount;
    }

    public static long P(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : fy4.m1(attributeValue);
    }

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

    public static float U(XmlPullParser xmlPullParser, String str, float f2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? f2 : Float.parseFloat(attributeValue);
    }

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

    public static int X(XmlPullParser xmlPullParser, String str, int i) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? i : Integer.parseInt(attributeValue);
    }

    public static long Z(List list) {
        for (int i = 0; i < list.size(); i++) {
            rj0 rj0Var = (rj0) list.get(i);
            if (xa.a("http://dashif.org/guidelines/last-segment-number", rj0Var.a)) {
                return Long.parseLong(rj0Var.b);
            }
        }
        return -1L;
    }

    public static long a0(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : Long.parseLong(attributeValue);
    }

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

    public static long t(long j, long j2) {
        if (j2 != -9223372036854775807L) {
            j = j2;
        }
        if (j == Long.MAX_VALUE) {
            return -9223372036854775807L;
        }
        return j;
    }

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

    public static String u0(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

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
        To view partially-correct add '--show-bad-code' argument
    */
    public android.util.Pair F(org.xmlpull.v1.XmlPullParser r11) {
        /*
            Method dump skipped, instruction units count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h90.F(org.xmlpull.v1.XmlPullParser):android.util.Pair");
    }

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

    public vn3 W(XmlPullParser xmlPullParser) {
        return g0(xmlPullParser, "sourceURL", "range");
    }

    public rr1 Y(XmlPullParser xmlPullParser) {
        return new rr1(xmlPullParser.getAttributeValue(null, "lang"), v0(xmlPullParser, "Label"));
    }

    public final long b(List list, long j, long j2, int i, long j3) {
        int iO = i >= 0 ? i + 1 : (int) fy4.o(j3 - j, j2);
        for (int i2 = 0; i2 < iO; i2++) {
            list.add(m(j, j2));
            j += j2;
        }
        return j;
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x01dd A[LOOP:0: B:24:0x00a5->B:81:0x01dd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0199 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.g90 b0(org.xmlpull.v1.XmlPullParser r41, android.net.Uri r42) throws defpackage.r83 {
        /*
            Method dump skipped, instruction units count: 513
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h90.b0(org.xmlpull.v1.XmlPullParser, android.net.Uri):g90");
    }

    public y3 c(long j, int i, List list, List list2, List list3, List list4) {
        return new y3(j, i, list, list2, list3, list4);
    }

    public dv0 d(String str, String str2, long j, long j2, byte[] bArr) {
        return new dv0(str, str2, j2, j, bArr);
    }

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

    public iv0 e(String str, String str2, long j, long[] jArr, dv0[] dv0VarArr) {
        return new iv0(str, str2, j, jArr, dv0VarArr);
    }

    public String[] e0(XmlPullParser xmlPullParser, String str, String[] strArr) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? strArr : attributeValue.split(",");
    }

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

    public g90 g(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, ph3 ph3Var, tx4 tx4Var, v14 v14Var, Uri uri, List list) {
        return new g90(j, j2, j3, z, j4, j5, j6, j7, ph3Var, tx4Var, v14Var, uri, list);
    }

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

    public na3 h(String str, long j, List list, List list2, rj0 rj0Var) {
        return new na3(str, j, list, list2, rj0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:56:0x025f A[LOOP:0: B:3:0x007a->B:56:0x025f, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0204 A[EDGE_INSN: B:57:0x0204->B:46:0x0204 BREAK  A[LOOP:0: B:3:0x007a->B:56:0x025f], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public h90.a h0(org.xmlpull.v1.XmlPullParser r35, java.util.List r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, int r41, int r42, float r43, int r44, int r45, java.lang.String r46, java.util.List r47, java.util.List r48, java.util.List r49, java.util.List r50, defpackage.g04 r51, long r52, long r54, long r56, long r58, long r60, boolean r62) {
        /*
            Method dump skipped, instruction units count: 662
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h90.h0(org.xmlpull.v1.XmlPullParser, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, float, int, int, java.lang.String, java.util.List, java.util.List, java.util.List, java.util.List, g04, long, long, long, long, long, boolean):h90$a");
    }

    public vn3 i(String str, long j, long j2) {
        return new vn3(str, j, j2);
    }

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

    public int j0(String str) {
        if (str == null) {
            return 0;
        }
        switch (str) {
        }
        return 0;
    }

    public g04.b k(vn3 vn3Var, long j, long j2, long j3, long j4, List list, long j5, List list2, long j6, long j7) {
        return new g04.b(vn3Var, j, j2, j3, j4, list, j5, list2, fy4.c1(j6), fy4.c1(j7));
    }

    public int k0(List list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (xa.a("http://dashif.org/guidelines/trickmode", ((rj0) list.get(i2)).a)) {
                i = Http2.INITIAL_MAX_FRAME_SIZE;
            }
        }
        return i;
    }

    public g04.c l(vn3 vn3Var, long j, long j2, long j3, long j4, long j5, List list, long j6, ox4 ox4Var, ox4 ox4Var2, long j7, long j8) {
        return new g04.c(vn3Var, j, j2, j3, j4, j5, list, j6, ox4Var, ox4Var2, fy4.c1(j7), fy4.c1(j8));
    }

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

    public g04.d m(long j, long j2) {
        return new g04.d(j, j2);
    }

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

    public g04.e n(vn3 vn3Var, long j, long j2, long j3, long j4) {
        return new g04.e(vn3Var, j, j2, j3, j4);
    }

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

    public tx4 o(String str, String str2) {
        return new tx4(str, str2);
    }

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

    public vn3 q0(XmlPullParser xmlPullParser) {
        return g0(xmlPullParser, "media", "mediaRange");
    }

    public int r0(String str) {
        if (str == null) {
            return 0;
        }
        return (str.equals("forced_subtitle") || str.equals("forced-subtitle")) ? 2 : 0;
    }

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

    public final boolean v(String[] strArr) {
        for (String str : strArr) {
            if (str.startsWith("urn:dvb:dash:profile:dvb-dash:")) {
                return true;
            }
        }
        return false;
    }

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

    public int x0(String str) {
        if (str == null) {
            return 0;
        }
        switch (str) {
        }
        return 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:75:0x03cb A[LOOP:0: B:3:0x00a2->B:75:0x03cb, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x037b A[EDGE_INSN: B:76:0x037b->B:69:0x037b BREAK  A[LOOP:0: B:3:0x00a2->B:75:0x03cb], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public defpackage.y3 y(org.xmlpull.v1.XmlPullParser r46, java.util.List r47, defpackage.g04 r48, long r49, long r51, long r53, long r55, long r57, boolean r59) {
        /*
            Method dump skipped, instruction units count: 999
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h90.y(org.xmlpull.v1.XmlPullParser, java.util.List, g04, long, long, long, long, long, boolean):y3");
    }

    public ox4 y0(XmlPullParser xmlPullParser, String str, ox4 ox4Var) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue != null ? ox4.b(attributeValue) : ox4Var;
    }

    public void z(XmlPullParser xmlPullParser) {
        w(xmlPullParser);
    }

    public tx4 z0(XmlPullParser xmlPullParser) {
        return o(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, ES6Iterator.VALUE_PROPERTY));
    }
}
