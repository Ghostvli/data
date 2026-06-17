package defpackage;

import defpackage.wn1;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import javax.xml.XMLConstants;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class qr2 {
    public final String a;
    public final String b;
    public final yi1 c;
    public String d;
    public int e;
    public t63 f;
    public static final yi1 g = yi1.x("charset", xa.f(StandardCharsets.UTF_8.name()));
    public static final ls h = ls.f().b(ls.l().p()).b(ls.k(' ')).b(ls.r("()<>@,;:\\\"/[]?="));
    public static final ls i = ls.f().b(ls.r("\"\\\r"));
    public static final ls j = ls.d(" \t\r\n");
    public static final Map k = new HashMap();
    public static final qr2 l = d("*", "*");
    public static final qr2 m = d("text", "*");
    public static final qr2 n = d("image", "*");
    public static final qr2 o = d("audio", "*");
    public static final qr2 p = d("video", "*");
    public static final qr2 q = d("application", "*");
    public static final qr2 r = d("font", "*");
    public static final qr2 s = e("text", "cache-manifest");
    public static final qr2 t = e("text", "css");
    public static final qr2 u = e("text", "csv");
    public static final qr2 v = e("text", "html");
    public static final qr2 w = e("text", "calendar");
    public static final qr2 x = e("text", "markdown");
    public static final qr2 y = e("text", "plain");
    public static final qr2 z = e("text", "javascript");
    public static final qr2 A = e("text", "tab-separated-values");
    public static final qr2 B = e("text", "vcard");
    public static final qr2 C = e("text", "vnd.wap.wml");
    public static final qr2 D = e("text", XMLConstants.XML_NS_PREFIX);
    public static final qr2 E = e("text", "vtt");
    public static final qr2 F = d("image", "bmp");
    public static final qr2 G = d("image", "x-canon-crw");
    public static final qr2 H = d("image", "gif");
    public static final qr2 I = d("image", "vnd.microsoft.icon");
    public static final qr2 J = d("image", "jpeg");
    public static final qr2 K = d("image", "png");
    public static final qr2 L = d("image", "vnd.adobe.photoshop");
    public static final qr2 M = e("image", "svg+xml");
    public static final qr2 N = d("image", "tiff");
    public static final qr2 O = d("image", "avif");
    public static final qr2 P = d("image", "webp");
    public static final qr2 Q = d("image", "heif");
    public static final qr2 R = d("image", "jp2");
    public static final qr2 S = d("audio", "mp4");
    public static final qr2 T = d("audio", "mpeg");
    public static final qr2 U = d("audio", "ogg");
    public static final qr2 V = d("audio", "webm");
    public static final qr2 W = d("audio", "l16");
    public static final qr2 X = d("audio", "l24");
    public static final qr2 Y = d("audio", "basic");
    public static final qr2 Z = d("audio", "aac");
    public static final qr2 a0 = d("audio", "vorbis");
    public static final qr2 b0 = d("audio", "x-ms-wma");
    public static final qr2 c0 = d("audio", "x-ms-wax");
    public static final qr2 d0 = d("audio", "vnd.rn-realaudio");
    public static final qr2 e0 = d("audio", "vnd.wave");
    public static final qr2 f0 = d("video", "mp4");
    public static final qr2 g0 = d("video", "mpeg");
    public static final qr2 h0 = d("video", "ogg");
    public static final qr2 i0 = d("video", "quicktime");
    public static final qr2 j0 = d("video", "webm");
    public static final qr2 k0 = d("video", "x-ms-wmv");
    public static final qr2 l0 = d("video", "x-flv");
    public static final qr2 m0 = d("video", "3gpp");
    public static final qr2 n0 = d("video", "3gpp2");
    public static final qr2 o0 = e("application", XMLConstants.XML_NS_PREFIX);
    public static final qr2 p0 = e("application", "atom+xml");
    public static final qr2 q0 = d("application", "x-bzip2");
    public static final qr2 r0 = e("application", "dart");
    public static final qr2 s0 = d("application", "vnd.apple.pkpass");
    public static final qr2 t0 = d("application", "vnd.ms-fontobject");
    public static final qr2 u0 = d("application", "epub+zip");
    public static final qr2 v0 = d("application", "x-www-form-urlencoded");
    public static final qr2 w0 = d("application", "pkcs12");
    public static final qr2 x0 = d("application", "binary");
    public static final qr2 y0 = d("application", "cbor");
    public static final qr2 z0 = d("application", "geo+json");
    public static final qr2 A0 = d("application", "x-gzip");
    public static final qr2 B0 = d("application", "hal+json");
    public static final qr2 C0 = e("application", "javascript");
    public static final qr2 D0 = d("application", "jose");
    public static final qr2 E0 = d("application", "jose+json");
    public static final qr2 F0 = e("application", "json");
    public static final qr2 G0 = d("application", "jwt");
    public static final qr2 H0 = e("application", "manifest+json");
    public static final qr2 I0 = d("application", "vnd.google-earth.kml+xml");
    public static final qr2 J0 = d("application", "vnd.google-earth.kmz");
    public static final qr2 K0 = d("application", "mbox");
    public static final qr2 L0 = d("application", "x-apple-aspen-config");
    public static final qr2 M0 = d("application", "vnd.ms-excel");
    public static final qr2 N0 = d("application", "vnd.ms-outlook");
    public static final qr2 O0 = d("application", "vnd.ms-powerpoint");
    public static final qr2 P0 = d("application", "msword");
    public static final qr2 Q0 = d("application", "dash+xml");
    public static final qr2 R0 = d("application", "wasm");
    public static final qr2 S0 = d("application", "x-nacl");
    public static final qr2 T0 = d("application", "x-pnacl");
    public static final qr2 U0 = d("application", "octet-stream");
    public static final qr2 V0 = d("application", "ogg");
    public static final qr2 W0 = d("application", "vnd.openxmlformats-officedocument.wordprocessingml.document");
    public static final qr2 X0 = d("application", "vnd.openxmlformats-officedocument.presentationml.presentation");
    public static final qr2 Y0 = d("application", "vnd.openxmlformats-officedocument.spreadsheetml.sheet");
    public static final qr2 Z0 = d("application", "vnd.oasis.opendocument.graphics");
    public static final qr2 a1 = d("application", "vnd.oasis.opendocument.presentation");
    public static final qr2 b1 = d("application", "vnd.oasis.opendocument.spreadsheet");
    public static final qr2 c1 = d("application", "vnd.oasis.opendocument.text");
    public static final qr2 d1 = e("application", "opensearchdescription+xml");
    public static final qr2 e1 = d("application", "pdf");
    public static final qr2 f1 = d("application", "postscript");
    public static final qr2 g1 = d("application", "protobuf");
    public static final qr2 h1 = e("application", "rdf+xml");
    public static final qr2 i1 = e("application", "rtf");
    public static final qr2 j1 = d("application", "font-sfnt");
    public static final qr2 k1 = d("application", "x-shockwave-flash");
    public static final qr2 l1 = d("application", "vnd.sketchup.skp");
    public static final qr2 m1 = e("application", "soap+xml");
    public static final qr2 n1 = d("application", "x-tar");
    public static final qr2 o1 = d("application", "font-woff");
    public static final qr2 p1 = d("application", "font-woff2");
    public static final qr2 q1 = e("application", "xhtml+xml");
    public static final qr2 r1 = e("application", "xrd+xml");
    public static final qr2 s1 = d("application", "zip");
    public static final qr2 t1 = d("font", "collection");
    public static final qr2 u1 = d("font", "otf");
    public static final qr2 v1 = d("font", "sfnt");
    public static final qr2 w1 = d("font", "ttf");
    public static final qr2 x1 = d("font", "woff");
    public static final qr2 y1 = d("font", "woff2");
    public static final wn1.a z1 = wn1.h("; ").j("=");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public qr2(String str, String str2, yi1 yi1Var) {
        this.a = str;
        this.b = str2;
        this.c = yi1Var;
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: ?: TERNARY null = ((!((wrap:boolean:0x0002: INVOKE (wrap:ls:0x0000: SGET  A[WRAPPED] (LINE:1) qr2.h ls), (r1v0 java.lang.String) VIRTUAL call: ls.n(java.lang.CharSequence):boolean A[MD:(java.lang.CharSequence):boolean (m), WRAPPED] (LINE:3)) == true) || (wrap:boolean:0x0008: INVOKE (r1v0 java.lang.String) VIRTUAL call: java.lang.String.isEmpty():boolean A[MD:():boolean (c), WRAPPED] (LINE:9)) == true)) ? (wrap:java.lang.String:0x000f: INVOKE (r1v0 java.lang.String) STATIC call: qr2.f(java.lang.String):java.lang.String A[MD:(java.lang.String):java.lang.String (m), WRAPPED] (LINE:16)) : (r1v0 java.lang.String) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ String a(String str) {
        return (!h.n(str) || str.isEmpty()) ? f(str) : str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static qr2 b(qr2 qr2Var) {
        k.put(qr2Var, qr2Var);
        return qr2Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static qr2 d(String str, String str2) {
        qr2 qr2VarB = b(new qr2(str, str2, yi1.w()));
        qr2VarB.f = t63.a();
        return qr2VarB;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static qr2 e(String str, String str2) {
        qr2 qr2VarB = b(new qr2(str, str2, g));
        qr2VarB.f = t63.c(StandardCharsets.UTF_8);
        return qr2VarB;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String f(String str) {
        StringBuilder sb = new StringBuilder(str.length() + 16);
        sb.append('\"');
        for (int i2 = 0; i2 < str.length(); i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '\r' || cCharAt == '\\' || cCharAt == '\"') {
                sb.append('\\');
            }
            sb.append(cCharAt);
        }
        sb.append('\"');
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String c() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append('/');
        sb.append(this.b);
        if (!this.c.j()) {
            sb.append("; ");
            z1.b(sb, gw2.e(this.c, new p81() { // from class: or2
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.p81
                public final Object apply(Object obj) {
                    return qr2.a((String) obj);
                }
            }).a());
        }
        return sb.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof qr2) {
            qr2 qr2Var = (qr2) obj;
            if (this.a.equals(qr2Var.a) && this.b.equals(qr2Var.b) && g().equals(qr2Var.g())) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Map g() {
        return v42.q(this.c.b(), new p81() { // from class: pr2
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return bj1.k((Collection) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        int i2 = this.e;
        if (i2 != 0) {
            return i2;
        }
        int iHash = Objects.hash(this.a, this.b, g());
        this.e = iHash;
        return iHash;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        String str = this.d;
        if (str != null) {
            return str;
        }
        String strC = c();
        this.d = strC;
        return strC;
    }
}
