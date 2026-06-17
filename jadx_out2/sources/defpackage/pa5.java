package defpackage;

import defpackage.gu2;
import defpackage.xi1;
import java.io.StringReader;
import org.jupnp.support.model.dlna.DLNAProfiles;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class pa5 {
    public static final String[] a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    public static final String[] b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    public static final String[] c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean a(String str) {
        if (str == null) {
            return false;
        }
        for (String str2 : a) {
            if (str.contains(str2 + "=\"1\"")) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static gu2 b(String str) {
        try {
            return c(str);
        } catch (NumberFormatException | XmlPullParserException | r83 unused) {
            xz1.i("MotionPhotoXmpParser", "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static gu2 c(String str) throws XmlPullParserException, r83 {
        XmlPullParser xmlPullParserNewPullParser = XmlPullParserFactory.newInstance().newPullParser();
        xmlPullParserNewPullParser.setInput(new StringReader(str));
        xmlPullParserNewPullParser.next();
        if (!oa5.f(xmlPullParserNewPullParser, "x:xmpmeta")) {
            throw r83.a("Couldn't find xmp metadata", null);
        }
        xi1 xi1VarU = xi1.u();
        long jF = -9223372036854775807L;
        do {
            xmlPullParserNewPullParser.next();
            if (oa5.f(xmlPullParserNewPullParser, "rdf:Description")) {
                if (!e(xmlPullParserNewPullParser)) {
                    return null;
                }
                jF = f(xmlPullParserNewPullParser);
                xi1VarU = d(xmlPullParserNewPullParser);
            } else if (oa5.f(xmlPullParserNewPullParser, "Container:Directory")) {
                xi1VarU = g(xmlPullParserNewPullParser, "Container", "Item");
            } else if (oa5.f(xmlPullParserNewPullParser, "GContainer:Directory")) {
                xi1VarU = g(xmlPullParserNewPullParser, "GContainer", "GContainerItem");
            }
        } while (!oa5.d(xmlPullParserNewPullParser, "x:xmpmeta"));
        if (xi1VarU.isEmpty()) {
            return null;
        }
        return new gu2(jF, xi1VarU);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xi1 d(XmlPullParser xmlPullParser) {
        for (String str : c) {
            String strA = oa5.a(xmlPullParser, str);
            if (strA != null) {
                return xi1.x(new gu2.a(DLNAProfiles.DLNAMimeTypes.MIME_IMAGE_JPEG, "Primary", 0L, 0L), new gu2.a(DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_MPEG_4, "MotionPhoto", Long.parseLong(strA), 0L));
            }
        }
        return xi1.u();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean e(XmlPullParser xmlPullParser) {
        for (String str : a) {
            String strA = oa5.a(xmlPullParser, str);
            if (strA != null) {
                return Integer.parseInt(strA) == 1;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long f(XmlPullParser xmlPullParser) {
        for (String str : b) {
            String strA = oa5.a(xmlPullParser, str);
            if (strA != null) {
                long j = Long.parseLong(strA);
                if (j == -1) {
                    return -9223372036854775807L;
                }
                return j;
            }
        }
        return -9223372036854775807L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static xi1 g(XmlPullParser xmlPullParser, String str, String str2) {
        xi1.a aVarM = xi1.m();
        String str3 = str + ":Item";
        String str4 = str + ":Directory";
        do {
            xmlPullParser.next();
            if (oa5.f(xmlPullParser, str3)) {
                String strA = oa5.a(xmlPullParser, str2 + ":Mime");
                String strA2 = oa5.a(xmlPullParser, str2 + ":Semantic");
                String strA3 = oa5.a(xmlPullParser, str2 + ":Length");
                String strA4 = oa5.a(xmlPullParser, str2 + ":Padding");
                if (strA == null || strA2 == null) {
                    return xi1.u();
                }
                aVarM.a(new gu2.a(strA, strA2, strA3 != null ? Long.parseLong(strA3) : 0L, strA4 != null ? Long.parseLong(strA4) : 0L));
            }
        } while (!oa5.d(xmlPullParser, str4));
        return aVarM.k();
    }
}
