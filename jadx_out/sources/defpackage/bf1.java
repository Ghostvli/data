package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import defpackage.oo0;
import defpackage.t83;
import defpackage.we1;
import defpackage.ze1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okio.internal.Buffer;
import org.jupnp.support.model.dlna.DLNAProfiles;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class bf1 implements t83.a {
    public final ze1 a;
    public final we1 b;
    public static final Pattern c = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    public static final Pattern d = Pattern.compile("VIDEO=\"((?:.|\f)+?)\"");
    public static final Pattern e = Pattern.compile("AUDIO=\"((?:.|\f)+?)\"");
    public static final Pattern f = Pattern.compile("SUBTITLES=\"((?:.|\f)+?)\"");
    public static final Pattern g = Pattern.compile("CLOSED-CAPTIONS=\"((?:.|\f)+?)\"");
    public static final Pattern h = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    public static final Pattern i = Pattern.compile("CHANNELS=\"((?:.|\f)+?)\"");
    public static final Pattern j = Pattern.compile("VIDEO-RANGE=(SDR|PQ|HLG)");
    public static final Pattern k = Pattern.compile("CODECS=\"((?:.|\f)+?)\"");
    public static final Pattern l = Pattern.compile("SUPPLEMENTAL-CODECS=\"((?:.|\f)+?)\"");
    public static final Pattern m = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    public static final Pattern n = Pattern.compile("FRAME-RATE=([\\d\\.]+)\\b");
    public static final Pattern o = Pattern.compile("PATHWAY-ID=\"((?:.|\f)+?)\"");
    public static final Pattern p = Pattern.compile("STABLE-VARIANT-ID=\"((?:.|\f)+?)\"");
    public static final Pattern q = Pattern.compile("STABLE-RENDITION-ID=\"((?:.|\f)+?)\"");
    public static final Pattern r = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    public static final Pattern s = Pattern.compile("DURATION=([\\d\\.]+)\\b");
    public static final Pattern t = Pattern.compile("[:,]DURATION=([\\d\\.]+)\\b");
    public static final Pattern u = Pattern.compile("PART-TARGET=([\\d\\.]+)\\b");
    public static final Pattern v = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    public static final Pattern w = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    public static final Pattern x = Pattern.compile("CAN-SKIP-UNTIL=([\\d\\.]+)\\b");
    public static final Pattern y = c("CAN-SKIP-DATERANGES");
    public static final Pattern z = Pattern.compile("SKIPPED-SEGMENTS=(\\d+)\\b");
    public static final Pattern A = Pattern.compile("[:|,]HOLD-BACK=([\\d\\.]+)\\b");
    public static final Pattern B = Pattern.compile("PART-HOLD-BACK=([\\d\\.]+)\\b");
    public static final Pattern C = c("CAN-BLOCK-RELOAD");
    public static final Pattern D = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    public static final Pattern E = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    public static final Pattern F = Pattern.compile("#EXTINF:[\\d\\.]+\\b,(.+)");
    public static final Pattern G = Pattern.compile("LAST-MSN=(\\d+)\\b");
    public static final Pattern H = Pattern.compile("LAST-PART=(\\d+)\\b");
    public static final Pattern I = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    public static final Pattern J = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    public static final Pattern K = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    public static final Pattern L = Pattern.compile("BYTERANGE-START=(\\d+)\\b");
    public static final Pattern M = Pattern.compile("BYTERANGE-LENGTH=(\\d+)\\b");
    public static final Pattern N = Pattern.compile("METHOD=(NONE|AES-128|SAMPLE-AES|SAMPLE-AES-CENC|SAMPLE-AES-CTR)\\s*(?:,|$)");
    public static final Pattern O = Pattern.compile("KEYFORMAT=\"((?:.|\f)+?)\"");
    public static final Pattern P = Pattern.compile("KEYFORMATVERSIONS=\"((?:.|\f)+?)\"");
    public static final Pattern Q = Pattern.compile("URI=\"((?:.|\f)+?)\"");
    public static final Pattern R = Pattern.compile("IV=([^,.*]+)");
    public static final Pattern S = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    public static final Pattern T = Pattern.compile("TYPE=(PART|MAP)");
    public static final Pattern U = Pattern.compile("LANGUAGE=\"((?:.|\f)+?)\"");
    public static final Pattern V = Pattern.compile("NAME=\"((?:.|\f)+?)\"");
    public static final Pattern W = Pattern.compile("QUERYPARAM=\"((?:.|\f)+?)\"");
    public static final Pattern X = Pattern.compile("GROUP-ID=\"((?:.|\f)+?)\"");
    public static final Pattern Y = Pattern.compile("CHARACTERISTICS=\"((?:.|\f)+?)\"");
    public static final Pattern Z = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    public static final Pattern a0 = c("AUTOSELECT");
    public static final Pattern b0 = c("DEFAULT");
    public static final Pattern c0 = c("FORCED");
    public static final Pattern d0 = c("INDEPENDENT");
    public static final Pattern e0 = c("GAP");
    public static final Pattern f0 = c("PRECISE");
    public static final Pattern g0 = Pattern.compile("VALUE=\"((?:.|\f)+?)\"");
    public static final Pattern h0 = Pattern.compile("IMPORT=\"((?:.|\f)+?)\"");
    public static final Pattern i0 = Pattern.compile("[:,]ID=\"((?:.|\f)+?)\"");
    public static final Pattern j0 = Pattern.compile("CLASS=\"((?:.|\f)+?)\"");
    public static final Pattern k0 = Pattern.compile("START-DATE=\"((?:.|\f)+?)\"");
    public static final Pattern l0 = Pattern.compile("CUE=\"((?:.|\f)+?)\"");
    public static final Pattern m0 = Pattern.compile("END-DATE=\"((?:.|\f)+?)\"");
    public static final Pattern n0 = Pattern.compile("PLANNED-DURATION=([\\d\\.]+)\\b");
    public static final Pattern o0 = c("END-ON-NEXT");
    public static final Pattern p0 = Pattern.compile("X-ASSET-URI=\"((?:.|\f)+?)\"");
    public static final Pattern q0 = Pattern.compile("X-ASSET-LIST=\"((?:.|\f)+?)\"");
    public static final Pattern r0 = Pattern.compile("X-RESUME-OFFSET=(-?[\\d\\.]+)\\b");
    public static final Pattern s0 = Pattern.compile("X-PLAYOUT-LIMIT=([\\d\\.]+)\\b");
    public static final Pattern t0 = Pattern.compile("X-SNAP=\"((?:.|\f)+?)\"");
    public static final Pattern u0 = Pattern.compile("X-RESTRICT=\"((?:.|\f)+?)\"");
    public static final Pattern v0 = Pattern.compile("X-CONTENT-MAY-VARY=\"((?:.|\f)+?)\"");
    public static final Pattern w0 = Pattern.compile("X-TIMELINE-OCCUPIES=\"((?:.|\f)+?)\"");
    public static final Pattern x0 = Pattern.compile("X-TIMELINE-STYLE=\"((?:.|\f)+?)\"");
    public static final Pattern y0 = Pattern.compile("X-SKIP-CONTROL-OFFSET=([\\d\\.]+)\\b");
    public static final Pattern z0 = Pattern.compile("X-SKIP-CONTROL-DURATION=([\\d\\.]+)\\b");
    public static final Pattern A0 = Pattern.compile("X-SKIP-CONTROL-LABEL-ID=\"((?:.|\f)+?)\"");
    public static final Pattern B0 = Pattern.compile("\\{\\$([a-zA-Z0-9\\-_]+)\\}");
    public static final Pattern C0 = Pattern.compile("\\b(X-[A-Z0-9-]+)=");

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends IOException {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public final BufferedReader a;
        public final Queue b;
        public String c;

        public c(Queue queue, BufferedReader bufferedReader) {
            this.b = queue;
            this.a = bufferedReader;
        }

        public boolean a() throws IOException {
            String strTrim;
            if (this.c != null) {
                return true;
            }
            if (!this.b.isEmpty()) {
                this.c = (String) gg3.q((String) this.b.poll());
                return true;
            }
            do {
                String line = this.a.readLine();
                this.c = line;
                if (line == null) {
                    return false;
                }
                strTrim = line.trim();
                this.c = strTrim;
            } while (strTrim.isEmpty());
            return true;
        }

        public String b() {
            if (!a()) {
                bo.a();
                return null;
            }
            String str = this.c;
            this.c = null;
            return str;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d extends LinkedHashMap {
        public d() {
            super(16, 0.75f, true);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Matcher b(Pattern pattern, CharSequence charSequence) {
            Matcher matcher = (Matcher) get(pattern);
            if (matcher != null) {
                matcher.reset(charSequence);
                return matcher;
            }
            Matcher matcher2 = pattern.matcher(charSequence);
            put(pattern, matcher2);
            return matcher2;
        }

        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry entry) {
            return size() > 32;
        }
    }

    public bf1(ze1 ze1Var, we1 we1Var) {
        this.a = ze1Var;
        this.b = we1Var;
    }

    public static we1.h A(String str, d dVar) {
        double d2;
        long j2;
        double dT = t(str, x, -9.223372036854776E18d, dVar);
        long j3 = dT == -9.223372036854776E18d ? -9223372036854775807L : (long) (dT * 1000000.0d);
        boolean zS = s(str, y, false, dVar);
        double dT2 = t(str, A, -9.223372036854776E18d, dVar);
        if (dT2 == -9.223372036854776E18d) {
            d2 = 1000000.0d;
            j2 = -9223372036854775807L;
        } else {
            d2 = 1000000.0d;
            j2 = (long) (dT2 * 1000000.0d);
        }
        double dT3 = t(str, B, -9.223372036854776E18d, dVar);
        return new we1.h(j3, zS, j2, dT3 != -9.223372036854776E18d ? (long) (dT3 * d2) : -9223372036854775807L, s(str, C, false, dVar));
    }

    public static String B(String str, Pattern pattern, Map map, d dVar) throws r83 {
        String strX = x(str, pattern, map, dVar);
        if (strX != null) {
            return strX;
        }
        throw r83.c("Couldn't match " + pattern.pattern() + " in " + str, null);
    }

    public static long C(String str, Pattern pattern, d dVar) {
        return new BigDecimal(B(str, pattern, Collections.EMPTY_MAP, dVar)).multiply(new BigDecimal(1000000L)).longValue();
    }

    public static String D(String str, Map map, d dVar) {
        Matcher matcherB = dVar.b(B0, str);
        StringBuffer stringBuffer = new StringBuffer();
        while (matcherB.find()) {
            String strGroup = matcherB.group(1);
            if (map.containsKey(strGroup)) {
                matcherB.appendReplacement(stringBuffer, Matcher.quoteReplacement((String) map.get(strGroup)));
            }
        }
        matcherB.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    public static int E(BufferedReader bufferedReader, boolean z2, int i2) throws IOException {
        while (i2 != -1 && Character.isWhitespace(i2) && (z2 || !fy4.T0(i2))) {
            i2 = bufferedReader.read();
        }
        return i2;
    }

    public static void F(String str, Map map) throws r83 {
        if (map.containsKey(str)) {
            throw r83.c("duplicate variable name \"" + str + "\"", null);
        }
    }

    public static boolean b(BufferedReader bufferedReader) throws IOException {
        int i2 = bufferedReader.read();
        if (i2 == 239) {
            if (bufferedReader.read() != 187 || bufferedReader.read() != 191) {
                return false;
            }
            i2 = bufferedReader.read();
        }
        int iE = E(bufferedReader, true, i2);
        for (int i3 = 0; i3 < 7; i3++) {
            if (iE != "#EXTM3U".charAt(i3)) {
                return false;
            }
            iE = bufferedReader.read();
        }
        return fy4.T0(E(bufferedReader, false, iE));
    }

    public static Pattern c(String str) {
        return Pattern.compile(str + "=(NO|YES)");
    }

    public static oo0 d(String str, oo0.b[] bVarArr) {
        oo0.b[] bVarArr2 = new oo0.b[bVarArr.length];
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            bVarArr2[i2] = bVarArr[i2].d(null);
        }
        return new oo0(str, bVarArr2);
    }

    public static String e(long j2, String str, String str2) {
        if (str == null) {
            return null;
        }
        return str2 != null ? str2 : Long.toHexString(j2);
    }

    public static ze1.b f(ArrayList arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ze1.b bVar = (ze1.b) arrayList.get(i2);
            if (str.equals(bVar.d)) {
                return bVar;
            }
        }
        return null;
    }

    public static ze1.b g(ArrayList arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ze1.b bVar = (ze1.b) arrayList.get(i2);
            if (str.equals(bVar.e)) {
                return bVar;
            }
        }
        return null;
    }

    public static ze1.b h(ArrayList arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ze1.b bVar = (ze1.b) arrayList.get(i2);
            if (str.equals(bVar.c)) {
                return bVar;
            }
        }
        return null;
    }

    public static boolean i(String str, String str2, String str3, String str4) {
        if (!nt2.p(str2, str3)) {
            return false;
        }
        if (str3 == null) {
            return true;
        }
        if (str == null || str4 == null) {
            return false;
        }
        return (!str.equals("PQ") || str4.equals("db1p")) && (!str.equals("SDR") || str4.equals("db2g")) && (!str.equals("HLG") || str4.startsWith("db4"));
    }

    public static we1.b k(String str, String str2, Map map, d dVar) {
        String str3 = str2 + "=";
        int iIndexOf = str.indexOf(str3) + str3.length();
        String strSubstring = str.substring(iIndexOf, (str.length() == iIndexOf + 1 ? 1 : 2) + iIndexOf);
        if (strSubstring.startsWith("\"")) {
            return new we1.b(str2, B(str, Pattern.compile(str2 + "=\"((?:.|\f)+?)\""), map, dVar), 0);
        }
        if (strSubstring.equals("0x") || strSubstring.equals("0X")) {
            return new we1.b(str2, B(str, Pattern.compile(str2 + "=(0[xX][A-F0-9]+)"), map, dVar), 1);
        }
        return new we1.b(str2, l(str, Pattern.compile(str2 + "=([\\d\\.]+)\\b"), dVar));
    }

    public static double l(String str, Pattern pattern, d dVar) {
        return Double.parseDouble(B(str, pattern, Collections.EMPTY_MAP, dVar));
    }

    public static oo0.b m(String str, String str2, Map map, d dVar) throws r83 {
        String strW = w(str, P, "1", map, dVar);
        if ("urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed".equals(str2)) {
            String strB = B(str, Q, map, dVar);
            return new oo0.b(kn.e, DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_MPEG_4, Base64.decode(strB.substring(strB.indexOf(44)), 0));
        }
        if ("com.widevine".equals(str2)) {
            return new oo0.b(kn.e, "hls", fy4.F0(str));
        }
        if (!"com.microsoft.playready".equals(str2) || !"1".equals(strW)) {
            return null;
        }
        String strB2 = B(str, Q, map, dVar);
        byte[] bArrDecode = Base64.decode(strB2.substring(strB2.indexOf(44)), 0);
        UUID uuid = kn.f;
        return new oo0.b(uuid, DLNAProfiles.DLNAMimeTypes.MIME_VIDEO_MPEG_4, xi3.a(uuid, bArrDecode));
    }

    public static String n(String str) {
        return ("SAMPLE-AES-CENC".equals(str) || "SAMPLE-AES-CTR".equals(str)) ? "cenc" : "cbcs";
    }

    public static int o(String str, Pattern pattern, d dVar) {
        return Integer.parseInt(B(str, pattern, Collections.EMPTY_MAP, dVar));
    }

    public static long p(String str, Pattern pattern, d dVar) {
        return Long.parseLong(B(str, pattern, Collections.EMPTY_MAP, dVar));
    }

    /* JADX WARN: Code restructure failed: missing block: B:256:0x0783, code lost:
    
        r35 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0787, code lost:
    
        r35 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:262:0x0795, code lost:
    
        r35 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x07a2, code lost:
    
        r35 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:348:0x093c, code lost:
    
        r40 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:350:0x0941, code lost:
    
        r40 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x0951, code lost:
    
        r40 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:358:0x0961, code lost:
    
        r40 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:362:0x0971, code lost:
    
        r40 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:366:0x0981, code lost:
    
        r40 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:370:0x0990, code lost:
    
        r40 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:374:0x099d, code lost:
    
        r40 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:378:0x09aa, code lost:
    
        r40 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:382:0x09b7, code lost:
    
        r40 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:386:0x09c4, code lost:
    
        r40 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:390:0x09d2, code lost:
    
        r40 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:394:0x09df, code lost:
    
        r40 = r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:189:0x05b2  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x05b6  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x05b9  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x06b4  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0785 A[PHI: r35
      0x0785: PHI (r35v31 int) = (r35v27 int), (r35v28 int), (r35v29 int), (r35v32 int) binds: [B:267:0x07aa, B:263:0x079d, B:259:0x078f, B:256:0x0783] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:325:0x08c5  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x08e2  */
    /* JADX WARN: Removed duplicated region for block: B:349:0x093e A[PHI: r40
      0x093e: PHI (r40v33 java.util.regex.Matcher) = 
      (r40v20 java.util.regex.Matcher)
      (r40v21 java.util.regex.Matcher)
      (r40v22 java.util.regex.Matcher)
      (r40v23 java.util.regex.Matcher)
      (r40v24 java.util.regex.Matcher)
      (r40v25 java.util.regex.Matcher)
      (r40v26 java.util.regex.Matcher)
      (r40v27 java.util.regex.Matcher)
      (r40v28 java.util.regex.Matcher)
      (r40v29 java.util.regex.Matcher)
      (r40v30 java.util.regex.Matcher)
      (r40v31 java.util.regex.Matcher)
      (r40v34 java.util.regex.Matcher)
     binds: [B:395:0x09e7, B:391:0x09da, B:387:0x09cc, B:383:0x09bf, B:379:0x09b2, B:375:0x09a5, B:371:0x0998, B:367:0x0989, B:363:0x0979, B:359:0x0969, B:355:0x0959, B:351:0x0949, B:348:0x093c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:429:0x0b31  */
    /* JADX WARN: Removed duplicated region for block: B:430:0x0b46  */
    /* JADX WARN: Removed duplicated region for block: B:433:0x0b73  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.we1 q(defpackage.ze1 r101, defpackage.we1 r102, bf1.c r103, android.net.Uri r104, bf1.d r105) throws defpackage.r83, bf1.b {
        /*
            Method dump skipped, instruction units count: 3328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bf1.q(ze1, we1, bf1$c, android.net.Uri, bf1$d):we1");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:120:0x03f7. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:103:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.ze1 r(bf1.c r45, android.net.Uri r46, bf1.d r47) throws defpackage.r83 {
        /*
            Method dump skipped, instruction units count: 1460
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bf1.r(bf1$c, android.net.Uri, bf1$d):ze1");
    }

    public static boolean s(String str, Pattern pattern, boolean z2, d dVar) {
        Matcher matcherB = dVar.b(pattern, str);
        return matcherB.find() ? "YES".equals(matcherB.group(1)) : z2;
    }

    public static double t(String str, Pattern pattern, double d2, d dVar) {
        Matcher matcherB = dVar.b(pattern, str);
        return matcherB.find() ? Double.parseDouble((String) gg3.q(matcherB.group(1))) : d2;
    }

    public static int u(String str, Pattern pattern, int i2, d dVar) {
        Matcher matcherB = dVar.b(pattern, str);
        return matcherB.find() ? Integer.parseInt((String) gg3.q(matcherB.group(1))) : i2;
    }

    public static long v(String str, Pattern pattern, long j2, d dVar) {
        Matcher matcherB = dVar.b(pattern, str);
        return matcherB.find() ? Long.parseLong((String) gg3.q(matcherB.group(1))) : j2;
    }

    public static String w(String str, Pattern pattern, String str2, Map map, d dVar) {
        Matcher matcherB = dVar.b(pattern, str);
        if (matcherB.find()) {
            str2 = (String) gg3.q(matcherB.group(1));
        }
        return (map.isEmpty() || str2 == null) ? str2 : D(str2, map, dVar);
    }

    public static String x(String str, Pattern pattern, Map map, d dVar) {
        return w(str, pattern, null, map, dVar);
    }

    public static int y(String str, Map map, d dVar) {
        String strX = x(str, Y, map, dVar);
        if (TextUtils.isEmpty(strX)) {
            return 0;
        }
        String[] strArrG1 = fy4.G1(strX, ",");
        int i2 = fy4.v(strArrG1, "public.accessibility.describes-video") ? 512 : 0;
        if (fy4.v(strArrG1, "public.accessibility.transcribes-spoken-dialog")) {
            i2 |= Buffer.SEGMENTING_THRESHOLD;
        }
        if (fy4.v(strArrG1, "public.accessibility.describes-music-and-sound")) {
            i2 |= 1024;
        }
        return fy4.v(strArrG1, "public.easy-to-read") ? i2 | 8192 : i2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v2, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    public static int z(String str, d dVar) {
        boolean zS = s(str, b0, false, dVar);
        ?? r02 = zS;
        if (s(str, c0, false, dVar)) {
            r02 = (zS ? 1 : 0) | 2;
        }
        return s(str, a0, false, dVar) ? r02 | 4 : r02;
    }

    @Override // t83.a
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public af1 a(Uri uri, InputStream inputStream) throws r83 {
        String strTrim;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        ArrayDeque arrayDeque = new ArrayDeque();
        d dVar = new d();
        try {
            if (!b(bufferedReader)) {
                throw r83.c("Input does not start with the #EXTM3U header.", null);
            }
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    fy4.p(bufferedReader);
                    throw r83.c("Failed to parse the playlist, could not identify any tags.", null);
                }
                strTrim = line.trim();
                if (!strTrim.isEmpty()) {
                    if (!strTrim.startsWith("#EXT-X-STREAM-INF")) {
                        if (strTrim.startsWith("#EXT-X-TARGETDURATION") || strTrim.startsWith("#EXT-X-MEDIA-SEQUENCE") || strTrim.startsWith("#EXTINF") || strTrim.startsWith("#EXT-X-KEY") || strTrim.startsWith("#EXT-X-BYTERANGE") || strTrim.equals("#EXT-X-DISCONTINUITY") || strTrim.equals("#EXT-X-DISCONTINUITY-SEQUENCE") || strTrim.equals("#EXT-X-ENDLIST")) {
                            break;
                        }
                        arrayDeque.add(strTrim);
                    } else {
                        arrayDeque.add(strTrim);
                        return r(new c(arrayDeque, bufferedReader), uri, dVar);
                    }
                }
            }
            arrayDeque.add(strTrim);
            return q(this.a, this.b, new c(arrayDeque, bufferedReader), uri, dVar);
        } finally {
            fy4.p(bufferedReader);
        }
    }

    public bf1() {
        this(ze1.n, null);
    }
}
