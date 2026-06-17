package defpackage;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import defpackage.lf1;
import defpackage.oo0;
import defpackage.t41;
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okio.internal.Buffer;
import org.jupnp.model.ServiceReference;
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(Queue queue, BufferedReader bufferedReader) {
            this.b = queue;
            this.a = bufferedReader;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d() {
            super(16, 0.75f, true);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: V */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.LinkedHashMap
        public boolean removeEldestEntry(Map.Entry entry) {
            return size() > 32;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public bf1(ze1 ze1Var, we1 we1Var) {
        this.a = ze1Var;
        this.b = we1Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String B(String str, Pattern pattern, Map map, d dVar) throws r83 {
        String strX = x(str, pattern, map, dVar);
        if (strX != null) {
            return strX;
        }
        throw r83.c("Couldn't match " + pattern.pattern() + " in " + str, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long C(String str, Pattern pattern, d dVar) {
        return new BigDecimal(B(str, pattern, Collections.EMPTY_MAP, dVar)).multiply(new BigDecimal(1000000L)).longValue();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int E(BufferedReader bufferedReader, boolean z2, int i2) throws IOException {
        while (i2 != -1 && Character.isWhitespace(i2) && (z2 || !fy4.T0(i2))) {
            i2 = bufferedReader.read();
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void F(String str, Map map) throws r83 {
        if (map.containsKey(str)) {
            throw r83.c("duplicate variable name \"" + str + "\"", null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Pattern c(String str) {
        return Pattern.compile(str + "=(NO|YES)");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static oo0 d(String str, oo0.b[] bVarArr) {
        oo0.b[] bVarArr2 = new oo0.b[bVarArr.length];
        for (int i2 = 0; i2 < bVarArr.length; i2++) {
            bVarArr2[i2] = bVarArr[i2].d(null);
        }
        return new oo0(str, bVarArr2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String e(long j2, String str, String str2) {
        if (str == null) {
            return null;
        }
        return str2 != null ? str2 : Long.toHexString(j2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ze1.b f(ArrayList arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ze1.b bVar = (ze1.b) arrayList.get(i2);
            if (str.equals(bVar.d)) {
                return bVar;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ze1.b g(ArrayList arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ze1.b bVar = (ze1.b) arrayList.get(i2);
            if (str.equals(bVar.e)) {
                return bVar;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ze1.b h(ArrayList arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ze1.b bVar = (ze1.b) arrayList.get(i2);
            if (str.equals(bVar.c)) {
                return bVar;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static double l(String str, Pattern pattern, d dVar) {
        return Double.parseDouble(B(str, pattern, Collections.EMPTY_MAP, dVar));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String n(String str) {
        return ("SAMPLE-AES-CENC".equals(str) || "SAMPLE-AES-CTR".equals(str)) ? "cenc" : "cbcs";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int o(String str, Pattern pattern, d dVar) {
        return Integer.parseInt(B(str, pattern, Collections.EMPTY_MAP, dVar));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long p(String str, Pattern pattern, d dVar) {
        return Long.parseLong(B(str, pattern, Collections.EMPTY_MAP, dVar));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
    */
    public static we1 q(ze1 ze1Var, we1 we1Var, c cVar, Uri uri, d dVar) throws r83, b {
        long j2;
        ArrayList arrayList;
        String str;
        String str2;
        ArrayList arrayList2;
        ArrayList arrayList3;
        String str3;
        TreeMap treeMap;
        String str4;
        long j3;
        LinkedHashMap linkedHashMap;
        long j4;
        long j5;
        boolean z2;
        String str5;
        we1.f fVar;
        TreeMap treeMap2;
        ArrayList arrayList4;
        TreeMap treeMap3;
        String str6;
        oo0 oo0Var;
        oo0 oo0VarD;
        String str7;
        HashMap map;
        ArrayList arrayList5;
        ArrayList arrayList6;
        String str8;
        String str9;
        long j6;
        we1.f fVar2;
        long j7;
        String str10;
        boolean z3;
        oo0 oo0Var2;
        oo0 oo0VarD2;
        we1.f fVar3;
        String str11;
        int i2;
        long j8;
        long j9;
        boolean z4;
        long j10;
        String str12;
        ArrayList arrayList7;
        String str13;
        long jC1;
        long jC12;
        String strGroup;
        Matcher matcher;
        ArrayList arrayList8;
        String strTrim;
        int i3;
        long j11;
        oo0 oo0VarD3;
        ze1 ze1Var2 = ze1Var;
        we1 we1Var2 = we1Var;
        String string = uri.toString();
        boolean z5 = ze1Var2.c;
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList9 = new ArrayList();
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        we1.h hVar = new we1.h(-9223372036854775807L, false, -9223372036854775807L, -9223372036854775807L, false);
        TreeMap treeMap4 = new TreeMap();
        boolean z6 = z5;
        LinkedHashMap linkedHashMap3 = linkedHashMap2;
        we1.h hVarA = hVar;
        long jP = 0;
        long j12 = 0;
        long jC13 = 0;
        long j13 = 0;
        long j14 = 0;
        long jC = 0;
        long j15 = 0;
        long j16 = -9223372036854775807L;
        long jO = -9223372036854775807L;
        String str14 = "";
        String strW = str14;
        we1.d dVar2 = null;
        String strN = null;
        oo0 oo0Var3 = null;
        we1.f fVar4 = null;
        oo0 oo0Var4 = null;
        int i4 = 0;
        String strB = null;
        String str15 = null;
        int iO = 1;
        boolean z7 = false;
        boolean z8 = false;
        int i5 = 0;
        long j17 = -1;
        long j18 = -1;
        boolean z9 = false;
        boolean z10 = false;
        long j19 = 0;
        long jL = -9223372036854775807L;
        boolean zS = false;
        int i6 = 0;
        while (true) {
            LinkedHashMap linkedHashMap4 = linkedHashMap3;
            if (!cVar.a()) {
                we1.d dVar3 = dVar2;
                ArrayList arrayList13 = arrayList9;
                ArrayList arrayList14 = arrayList11;
                ArrayList arrayList15 = arrayList12;
                HashMap map4 = new HashMap();
                int i7 = 0;
                while (i7 < arrayList14.size()) {
                    ArrayList arrayList16 = arrayList14;
                    we1.e eVar = (we1.e) arrayList16.get(i7);
                    long size = eVar.b;
                    if (size == -1) {
                        size = (j19 + ((long) arrayList13.size())) - (arrayList10.isEmpty() ? 1L : 0L);
                    }
                    int size2 = eVar.c;
                    if (size2 == -1 && jL != -9223372036854775807L) {
                        size2 = (arrayList10.isEmpty() ? ((we1.f) km1.d(arrayList13)).r : arrayList10).size() - 1;
                    }
                    Uri uri2 = eVar.a;
                    map4.put(uri2, new we1.e(uri2, size, size2));
                    i7++;
                    arrayList14 = arrayList16;
                }
                if (dVar3 != null) {
                    arrayList10.add(dVar3);
                }
                ArrayList arrayList17 = new ArrayList();
                Iterator it = linkedHashMap4.values().iterator();
                while (it.hasNext()) {
                    we1.c cVarA = ((we1.c.a) it.next()).a();
                    if (cVarA != null) {
                        arrayList17.add(cVarA);
                    }
                }
                if (jC13 == 0 && we1Var != null && we1Var.p) {
                    jC13 = we1Var.h;
                }
                return new we1(i6, uri.toString(), arrayList15, j16, zS, jC13, z8, i5, j19, iO, jO, jL, z6, z7, jC13 != 0, oo0Var4, arrayList13, arrayList10, hVarA, map4, arrayList17);
            }
            String strB2 = cVar.b();
            we1.d dVar4 = dVar2;
            if (strB2.startsWith("#EXT")) {
                arrayList12.add(strB2);
            }
            if (strB2.startsWith("#EXT-X-PLAYLIST-TYPE")) {
                String strB3 = B(strB2, w, map2, dVar);
                if ("VOD".equals(strB3)) {
                    i6 = 1;
                } else if ("EVENT".equals(strB3)) {
                    i6 = 2;
                }
                linkedHashMap3 = linkedHashMap4;
                dVar2 = dVar4;
            } else if (strB2.equals("#EXT-X-I-FRAMES-ONLY")) {
                linkedHashMap3 = linkedHashMap4;
                dVar2 = dVar4;
                z9 = true;
            } else {
                if (strB2.startsWith("#EXT-X-START")) {
                    double dL = l(strB2, I, dVar);
                    j2 = jP;
                    arrayList = arrayList12;
                    zS = s(strB2, f0, false, dVar);
                    j16 = (long) (dL * 1000000.0d);
                } else {
                    arrayList = arrayList12;
                    j2 = jP;
                    if (strB2.startsWith("#EXT-X-SERVER-CONTROL")) {
                        hVarA = A(strB2, dVar);
                    } else if (strB2.startsWith("#EXT-X-PART-INF")) {
                        jL = (long) (l(strB2, u, dVar) * 1000000.0d);
                    } else if (strB2.startsWith("#EXT-X-MAP")) {
                        String strB4 = B(strB2, Q, map2, dVar);
                        String strX = x(strB2, K, map2, dVar);
                        if (strX != null) {
                            String[] strArrG1 = fy4.G1(strX, "@");
                            j17 = Long.parseLong(strArrG1[0]);
                            if (strArrG1.length > 1) {
                                j13 = Long.parseLong(strArrG1[1]);
                            }
                        }
                        long j20 = j17;
                        if (j20 == j18) {
                            j13 = 0;
                        }
                        if (strB != null && str15 == null) {
                            throw r83.c("The encryption IV attribute must be present when an initialization segment is encrypted with METHOD=AES-128.", null);
                        }
                        String str16 = strB;
                        long j21 = j13;
                        we1.f fVar5 = new we1.f(strB4, j21, j20, str16, str15);
                        String str17 = str15;
                        j13 = j20 != j18 ? j21 + j20 : j21;
                        strB = str16;
                        str15 = str17;
                        fVar4 = fVar5;
                        linkedHashMap3 = linkedHashMap4;
                        jP = j2;
                        j17 = j18;
                        dVar2 = dVar4;
                        arrayList12 = arrayList;
                    } else {
                        String str18 = strB;
                        String str19 = str15;
                        if (strB2.startsWith("#EXT-X-TARGETDURATION")) {
                            str = strN;
                            jO = ((long) o(strB2, r, dVar)) * 1000000;
                        } else {
                            str = strN;
                            if (strB2.startsWith("#EXT-X-MEDIA-SEQUENCE")) {
                                strB = str18;
                                str15 = str19;
                                jP = p(strB2, D, dVar);
                                j19 = jP;
                                linkedHashMap3 = linkedHashMap4;
                                dVar2 = dVar4;
                                arrayList12 = arrayList;
                                strN = str;
                            } else if (strB2.startsWith("#EXT-X-VERSION")) {
                                iO = o(strB2, v, dVar);
                            } else {
                                if (strB2.startsWith("#EXT-X-DEFINE")) {
                                    String strX2 = x(strB2, V, map2, dVar);
                                    String strX3 = x(strB2, W, map2, dVar);
                                    if (strX2 != null) {
                                        F(strX2, map2);
                                        map2.put(strX2, B(strB2, g0, map2, dVar));
                                    } else if (strX3 != null) {
                                        F(strX3, map2);
                                        String queryParameter = uri.getQueryParameter(strX3);
                                        if (queryParameter == null) {
                                            throw r83.c("QUERYPARAM \"" + strX3 + "\" not found in playlist URI", null);
                                        }
                                        map2.put(strX3, queryParameter);
                                    } else {
                                        String strB5 = B(strB2, h0, map2, dVar);
                                        F(strB5, map2);
                                        String str20 = (String) ze1Var2.l.get(strB5);
                                        if (str20 != null) {
                                            map2.put(strB5, str20);
                                        }
                                        str2 = string;
                                        arrayList2 = arrayList9;
                                        arrayList3 = arrayList11;
                                        str3 = str19;
                                        treeMap = treeMap4;
                                        str4 = str14;
                                        j3 = j17;
                                        linkedHashMap = linkedHashMap4;
                                        j4 = j2;
                                        j5 = j14;
                                        z2 = z10;
                                        str5 = str;
                                    }
                                    str2 = string;
                                    arrayList2 = arrayList9;
                                    arrayList3 = arrayList11;
                                    str3 = str19;
                                    treeMap = treeMap4;
                                    str4 = str14;
                                    j3 = j17;
                                    linkedHashMap = linkedHashMap4;
                                    j4 = j2;
                                    j5 = j14;
                                    z2 = z10;
                                    str5 = str;
                                } else if (strB2.startsWith("#EXTINF")) {
                                    jC = C(strB2, E, dVar);
                                    strW = w(strB2, F, str14, map2, dVar);
                                } else {
                                    String str21 = str14;
                                    if (strB2.startsWith("#EXT-X-SKIP")) {
                                        int iO2 = o(strB2, z, dVar);
                                        gg3.v(we1Var2 != null && arrayList9.isEmpty());
                                        int i8 = (int) (j19 - ((we1) fy4.l(we1Var2)).k);
                                        int i9 = iO2 + i8;
                                        if (i8 >= 0 && i9 <= we1Var2.r.size()) {
                                            String str22 = str18;
                                            str15 = str19;
                                            long j22 = j2;
                                            long j23 = j14;
                                            while (i8 < i9) {
                                                we1.f fVarB = (we1.f) we1Var2.r.get(i8);
                                                ArrayList arrayList18 = arrayList10;
                                                ArrayList arrayList19 = arrayList11;
                                                if (j19 != we1Var2.k) {
                                                    fVarB = fVarB.b(j23, (we1Var2.j - i5) + fVarB.i);
                                                }
                                                arrayList9.add(fVarB);
                                                j23 += fVarB.h;
                                                long j24 = fVarB.o;
                                                if (j24 != j18) {
                                                    j13 = fVarB.n + j24;
                                                }
                                                int i10 = fVarB.i;
                                                we1.f fVar6 = fVarB.g;
                                                oo0 oo0Var5 = fVarB.k;
                                                int i11 = i9;
                                                String str23 = fVarB.l;
                                                String str24 = fVarB.m;
                                                if (str24 == null || !str24.equals(Long.toHexString(j22))) {
                                                    str15 = fVarB.m;
                                                }
                                                j22++;
                                                i8++;
                                                i4 = i10;
                                                fVar4 = fVar6;
                                                j12 = j23;
                                                str22 = str23;
                                                i9 = i11;
                                                arrayList11 = arrayList19;
                                                arrayList10 = arrayList18;
                                                oo0Var3 = oo0Var5;
                                            }
                                            ze1Var2 = ze1Var;
                                            j14 = j23;
                                            strB = str22;
                                            jP = j22;
                                            linkedHashMap3 = linkedHashMap4;
                                            dVar2 = dVar4;
                                            arrayList12 = arrayList;
                                            strN = str;
                                            str14 = str21;
                                        }
                                    } else {
                                        ArrayList arrayList20 = arrayList10;
                                        ArrayList arrayList21 = arrayList11;
                                        str4 = str21;
                                        if (strB2.startsWith("#EXT-X-KEY")) {
                                            String strB6 = B(strB2, N, map2, dVar);
                                            String strW2 = w(strB2, O, "identity", map2, dVar);
                                            if ("NONE".equals(strB6)) {
                                                treeMap4.clear();
                                                strN = str;
                                                oo0Var3 = null;
                                                strB = null;
                                                str15 = null;
                                            } else {
                                                String strX4 = x(strB2, R, map2, dVar);
                                                if (!"identity".equals(strW2)) {
                                                    strN = str == null ? n(strB6) : str;
                                                    oo0.b bVarM = m(strB2, strW2, map2, dVar);
                                                    if (bVarM != null) {
                                                        treeMap4.put(strW2, bVarM);
                                                        str15 = strX4;
                                                        oo0Var3 = null;
                                                    } else {
                                                        str15 = strX4;
                                                    }
                                                } else if ("AES-128".equals(strB6)) {
                                                    strB = B(strB2, Q, map2, dVar);
                                                    str15 = strX4;
                                                    strN = str;
                                                } else {
                                                    str15 = strX4;
                                                    strN = str;
                                                }
                                                strB = null;
                                            }
                                            ze1Var2 = ze1Var;
                                            linkedHashMap3 = linkedHashMap4;
                                            jP = j2;
                                            dVar2 = dVar4;
                                            arrayList12 = arrayList;
                                        } else {
                                            if (strB2.startsWith("#EXT-X-BYTERANGE")) {
                                                String[] strArrG12 = fy4.G1(B(strB2, J, map2, dVar), "@");
                                                j17 = Long.parseLong(strArrG12[0]);
                                                if (strArrG12.length > 1) {
                                                    j13 = Long.parseLong(strArrG12[1]);
                                                }
                                            } else if (strB2.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE")) {
                                                i5 = Integer.parseInt(strB2.substring(strB2.indexOf(58) + 1));
                                                ze1Var2 = ze1Var;
                                                strB = str18;
                                                str15 = str19;
                                                linkedHashMap3 = linkedHashMap4;
                                                jP = j2;
                                                dVar2 = dVar4;
                                                arrayList12 = arrayList;
                                                strN = str;
                                                str14 = str4;
                                                arrayList11 = arrayList21;
                                                arrayList10 = arrayList20;
                                                z8 = true;
                                            } else if (strB2.equals("#EXT-X-DISCONTINUITY")) {
                                                i4++;
                                            } else if (strB2.startsWith("#EXT-X-PROGRAM-DATE-TIME")) {
                                                if (jC13 == 0) {
                                                    jC13 = fy4.c1(fy4.l1(strB2.substring(strB2.indexOf(58) + 1))) - j14;
                                                } else {
                                                    arrayList2 = arrayList9;
                                                    str3 = str19;
                                                    treeMap = treeMap4;
                                                    j3 = j17;
                                                    linkedHashMap = linkedHashMap4;
                                                    j4 = j2;
                                                    j5 = j14;
                                                    z2 = z10;
                                                    str5 = str;
                                                    arrayList3 = arrayList21;
                                                    arrayList10 = arrayList20;
                                                    str2 = string;
                                                    fVar = fVar4;
                                                    str15 = str3;
                                                    arrayList9 = arrayList2;
                                                    strB = str18;
                                                    linkedHashMap3 = linkedHashMap;
                                                    jP = j4;
                                                    j14 = j5;
                                                    j17 = j3;
                                                    z10 = z2;
                                                    dVar2 = dVar4;
                                                    fVar4 = fVar;
                                                    str14 = str4;
                                                    string = str2;
                                                    treeMap4 = treeMap;
                                                    arrayList11 = arrayList3;
                                                    j18 = -1;
                                                    ze1Var2 = ze1Var;
                                                    we1Var2 = we1Var;
                                                    strN = str5;
                                                    arrayList12 = arrayList;
                                                }
                                            } else if (strB2.equals("#EXT-X-GAP")) {
                                                ze1Var2 = ze1Var;
                                                strB = str18;
                                                str15 = str19;
                                                linkedHashMap3 = linkedHashMap4;
                                                jP = j2;
                                                dVar2 = dVar4;
                                                arrayList12 = arrayList;
                                                strN = str;
                                                str14 = str4;
                                                arrayList11 = arrayList21;
                                                arrayList10 = arrayList20;
                                                z10 = true;
                                            } else if (strB2.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                                                ze1Var2 = ze1Var;
                                                strB = str18;
                                                str15 = str19;
                                                linkedHashMap3 = linkedHashMap4;
                                                jP = j2;
                                                dVar2 = dVar4;
                                                arrayList12 = arrayList;
                                                strN = str;
                                                str14 = str4;
                                                arrayList11 = arrayList21;
                                                arrayList10 = arrayList20;
                                                z6 = true;
                                            } else if (strB2.equals("#EXT-X-ENDLIST")) {
                                                ze1Var2 = ze1Var;
                                                strB = str18;
                                                str15 = str19;
                                                linkedHashMap3 = linkedHashMap4;
                                                jP = j2;
                                                dVar2 = dVar4;
                                                arrayList12 = arrayList;
                                                strN = str;
                                                str14 = str4;
                                                arrayList11 = arrayList21;
                                                arrayList10 = arrayList20;
                                                z7 = true;
                                            } else {
                                                if (strB2.startsWith("#EXT-X-RENDITION-REPORT")) {
                                                    treeMap2 = treeMap4;
                                                    arrayList4 = arrayList21;
                                                    arrayList4.add(new we1.e(Uri.parse(kx4.f(string, B(strB2, Q, map2, dVar))), v(strB2, G, j18, dVar), u(strB2, H, -1, dVar)));
                                                } else {
                                                    treeMap2 = treeMap4;
                                                    arrayList4 = arrayList21;
                                                    if (!strB2.startsWith("#EXT-X-PRELOAD-HINT")) {
                                                        str2 = string;
                                                        treeMap = treeMap2;
                                                        if (strB2.startsWith("#EXT-X-PART")) {
                                                            String strE = e(j2, str18, str19);
                                                            String strB7 = B(strB2, Q, map2, dVar);
                                                            long jL2 = (long) (l(strB2, s, dVar) * 1000000.0d);
                                                            boolean zS2 = s(strB2, d0, false, dVar) | (z6 && arrayList20.isEmpty());
                                                            boolean zS3 = s(strB2, e0, false, dVar);
                                                            String strX5 = x(strB2, K, map2, dVar);
                                                            if (strX5 != null) {
                                                                String[] strArrG13 = fy4.G1(strX5, "@");
                                                                long j25 = Long.parseLong(strArrG13[0]);
                                                                if (strArrG13.length > 1) {
                                                                    j15 = Long.parseLong(strArrG13[1]);
                                                                }
                                                                j11 = j25;
                                                            } else {
                                                                j11 = -1;
                                                            }
                                                            long j26 = j11 == -1 ? 0L : j15;
                                                            if (oo0Var3 != null || treeMap.isEmpty()) {
                                                                oo0VarD3 = oo0Var4;
                                                                we1.f fVar7 = fVar4;
                                                                oo0 oo0Var6 = oo0Var3;
                                                                long j27 = j12;
                                                                arrayList20.add(new we1.d(strB7, fVar7, jL2, i4, j27, oo0Var6, str18, strE, j26, j11, zS3, zS2, false));
                                                                j12 = j27 + jL2;
                                                                if (j11 != -1) {
                                                                    j26 += j11;
                                                                }
                                                                j15 = j26;
                                                                oo0Var4 = oo0VarD3;
                                                                fVar4 = fVar7;
                                                                arrayList10 = arrayList20;
                                                                strB = str18;
                                                                str15 = str19;
                                                                jP = j2;
                                                                oo0Var3 = oo0Var6;
                                                                linkedHashMap3 = linkedHashMap4;
                                                                dVar2 = dVar4;
                                                                arrayList12 = arrayList;
                                                                str14 = str4;
                                                                treeMap4 = treeMap;
                                                                j18 = -1;
                                                                arrayList11 = arrayList4;
                                                                strN = str;
                                                                string = str2;
                                                            } else {
                                                                oo0.b[] bVarArr = (oo0.b[]) treeMap.values().toArray(new oo0.b[0]);
                                                                oo0 oo0Var7 = new oo0(str, bVarArr);
                                                                if (oo0Var4 == null) {
                                                                    oo0VarD3 = d(str, bVarArr);
                                                                    oo0Var3 = oo0Var7;
                                                                    we1.f fVar72 = fVar4;
                                                                    oo0 oo0Var62 = oo0Var3;
                                                                    long j272 = j12;
                                                                    arrayList20.add(new we1.d(strB7, fVar72, jL2, i4, j272, oo0Var62, str18, strE, j26, j11, zS3, zS2, false));
                                                                    j12 = j272 + jL2;
                                                                    if (j11 != -1) {
                                                                    }
                                                                    j15 = j26;
                                                                    oo0Var4 = oo0VarD3;
                                                                    fVar4 = fVar72;
                                                                    arrayList10 = arrayList20;
                                                                    strB = str18;
                                                                    str15 = str19;
                                                                    jP = j2;
                                                                    oo0Var3 = oo0Var62;
                                                                    linkedHashMap3 = linkedHashMap4;
                                                                    dVar2 = dVar4;
                                                                    arrayList12 = arrayList;
                                                                    str14 = str4;
                                                                    treeMap4 = treeMap;
                                                                    j18 = -1;
                                                                    arrayList11 = arrayList4;
                                                                    strN = str;
                                                                    string = str2;
                                                                } else {
                                                                    oo0Var3 = oo0Var7;
                                                                    oo0VarD3 = oo0Var4;
                                                                    we1.f fVar722 = fVar4;
                                                                    oo0 oo0Var622 = oo0Var3;
                                                                    long j2722 = j12;
                                                                    arrayList20.add(new we1.d(strB7, fVar722, jL2, i4, j2722, oo0Var622, str18, strE, j26, j11, zS3, zS2, false));
                                                                    j12 = j2722 + jL2;
                                                                    if (j11 != -1) {
                                                                    }
                                                                    j15 = j26;
                                                                    oo0Var4 = oo0VarD3;
                                                                    fVar4 = fVar722;
                                                                    arrayList10 = arrayList20;
                                                                    strB = str18;
                                                                    str15 = str19;
                                                                    jP = j2;
                                                                    oo0Var3 = oo0Var622;
                                                                    linkedHashMap3 = linkedHashMap4;
                                                                    dVar2 = dVar4;
                                                                    arrayList12 = arrayList;
                                                                    str14 = str4;
                                                                    treeMap4 = treeMap;
                                                                    j18 = -1;
                                                                    arrayList11 = arrayList4;
                                                                    strN = str;
                                                                    string = str2;
                                                                }
                                                            }
                                                        } else {
                                                            we1.f fVar8 = fVar4;
                                                            if (strB2.startsWith("#EXT-X-DATERANGE") && w(strB2, j0, str4, map2, dVar).equals("com.apple.hls.interstitial")) {
                                                                String strB8 = B(strB2, i0, map2, dVar);
                                                                String strX6 = x(strB2, p0, map2, dVar);
                                                                Uri uri3 = strX6 != null ? Uri.parse(strX6) : null;
                                                                fVar = fVar8;
                                                                String strX7 = x(strB2, q0, map2, dVar);
                                                                Uri uri4 = strX7 != null ? Uri.parse(strX7) : null;
                                                                arrayList6 = arrayList20;
                                                                String strX8 = x(strB2, k0, map2, dVar);
                                                                if (strX8 != null) {
                                                                    arrayList3 = arrayList4;
                                                                    jC1 = fy4.c1(fy4.l1(strX8));
                                                                } else {
                                                                    arrayList3 = arrayList4;
                                                                    jC1 = -9223372036854775807L;
                                                                }
                                                                String strX9 = x(strB2, m0, map2, dVar);
                                                                if (strX9 != null) {
                                                                    map = map3;
                                                                    arrayList5 = arrayList9;
                                                                    jC12 = fy4.c1(fy4.l1(strX9));
                                                                } else {
                                                                    map = map3;
                                                                    arrayList5 = arrayList9;
                                                                    jC12 = -9223372036854775807L;
                                                                }
                                                                ArrayList arrayList22 = new ArrayList();
                                                                str7 = str;
                                                                String strX10 = x(strB2, l0, map2, dVar);
                                                                str8 = str18;
                                                                if (strX10 != null) {
                                                                    String[] strArrG14 = fy4.G1(strX10, ",");
                                                                    str9 = str19;
                                                                    int length = strArrG14.length;
                                                                    int i12 = 0;
                                                                    while (i12 < length) {
                                                                        int i13 = i12;
                                                                        strTrim = strArrG14[i12].trim();
                                                                        strTrim.getClass();
                                                                        switch (strTrim) {
                                                                            case "PRE":
                                                                            case "ONCE":
                                                                            case "POST":
                                                                                arrayList22.add(strTrim);
                                                                                break;
                                                                        }
                                                                        i12 = i13 + 1;
                                                                        length = i3;
                                                                    }
                                                                } else {
                                                                    str9 = str19;
                                                                }
                                                                j6 = j2;
                                                                double dT = t(strB2, t, -1.0d, dVar);
                                                                long j28 = dT >= 0.0d ? (long) (dT * 1000000.0d) : -9223372036854775807L;
                                                                double dT2 = t(strB2, n0, -1.0d, dVar);
                                                                long j29 = dT2 >= 0.0d ? (long) (dT2 * 1000000.0d) : -9223372036854775807L;
                                                                boolean zS4 = s(strB2, o0, false, dVar);
                                                                long j30 = j29;
                                                                double dT3 = t(strB2, r0, Double.MIN_VALUE, dVar);
                                                                long j31 = dT3 != Double.MIN_VALUE ? (long) (dT3 * 1000000.0d) : -9223372036854775807L;
                                                                double dT4 = t(strB2, s0, -1.0d, dVar);
                                                                long j32 = dT4 >= 0.0d ? (long) (dT4 * 1000000.0d) : -9223372036854775807L;
                                                                ArrayList arrayList23 = new ArrayList();
                                                                long j33 = j32;
                                                                String strX11 = x(strB2, t0, map2, dVar);
                                                                if (strX11 != null) {
                                                                    String[] strArrG15 = fy4.G1(strX11, ",");
                                                                    int length2 = strArrG15.length;
                                                                    int i14 = 0;
                                                                    while (i14 < length2) {
                                                                        int i15 = i14;
                                                                        String strTrim2 = strArrG15[i14].trim();
                                                                        strTrim2.getClass();
                                                                        int i16 = length2;
                                                                        if (strTrim2.equals("IN") || strTrim2.equals("OUT")) {
                                                                            arrayList23.add(strTrim2);
                                                                        }
                                                                        i14 = i15 + 1;
                                                                        length2 = i16;
                                                                    }
                                                                }
                                                                ArrayList arrayList24 = new ArrayList();
                                                                String strX12 = x(strB2, u0, map2, dVar);
                                                                if (strX12 != null) {
                                                                    String[] strArrG16 = fy4.G1(strX12, ",");
                                                                    int length3 = strArrG16.length;
                                                                    int i17 = 0;
                                                                    while (i17 < length3) {
                                                                        int i18 = i17;
                                                                        String strTrim3 = strArrG16[i17].trim();
                                                                        strTrim3.getClass();
                                                                        int i19 = length3;
                                                                        if (strTrim3.equals("JUMP") || strTrim3.equals("SKIP")) {
                                                                            arrayList24.add(strTrim3);
                                                                        }
                                                                        i17 = i18 + 1;
                                                                        length3 = i19;
                                                                    }
                                                                }
                                                                Boolean boolValueOf = x(strB2, v0, map2, dVar) != null ? Boolean.valueOf(!r11.equals("NO")) : null;
                                                                String strX13 = x(strB2, w0, map2, dVar);
                                                                Boolean bool = boolValueOf;
                                                                if (strX13 != null) {
                                                                    String str25 = "RANGE";
                                                                    if (!strX13.equals("RANGE")) {
                                                                        str25 = "POINT";
                                                                        if (!strX13.equals("POINT")) {
                                                                            str25 = null;
                                                                        }
                                                                    }
                                                                    String strX14 = x(strB2, x0, map2, dVar);
                                                                    String str26 = str25;
                                                                    if (strX14 != null) {
                                                                        String str27 = "PRIMARY";
                                                                        if (!strX14.equals("PRIMARY")) {
                                                                            str27 = "HIGHLIGHT";
                                                                            if (!strX14.equals("HIGHLIGHT")) {
                                                                                str27 = null;
                                                                            }
                                                                        }
                                                                        String str28 = str27;
                                                                        double dT5 = t(strB2, y0, -1.0d, dVar);
                                                                        long j34 = dT5 >= 0.0d ? (long) (dT5 * 1000000.0d) : -9223372036854775807L;
                                                                        double dT6 = t(strB2, z0, -1.0d, dVar);
                                                                        long j35 = dT6 >= 0.0d ? (long) (dT6 * 1000000.0d) : -9223372036854775807L;
                                                                        String strX15 = x(strB2, A0, map2, dVar);
                                                                        ArrayList arrayList25 = new ArrayList();
                                                                        long j36 = j35;
                                                                        String strSubstring = strB2.substring(17);
                                                                        Matcher matcherB = dVar.b(C0, strSubstring);
                                                                        while (matcherB.find()) {
                                                                            strGroup = matcherB.group();
                                                                            strGroup.getClass();
                                                                            switch (strGroup) {
                                                                                case "X-SNAP=":
                                                                                case "X-CONTENT-MAY-VARY=":
                                                                                case "X-PLAYOUT-LIMIT=":
                                                                                case "X-TIMELINE-STYLE=":
                                                                                case "X-ASSET-LIST=":
                                                                                case "X-TIMELINE-OCCUPIES=":
                                                                                case "X-SKIP-CONTROL-DURATION=":
                                                                                case "X-SKIP-CONTROL-OFFSET=":
                                                                                case "X-RESTRICT=":
                                                                                case "X-RESUME-OFFSET=":
                                                                                case "X-ASSET-URI=":
                                                                                case "X-SKIP-CONTROL-LABEL-ID=":
                                                                                    arrayList8 = arrayList23;
                                                                                    break;
                                                                                default:
                                                                                    arrayList8 = arrayList23;
                                                                                    arrayList25.add(k(strSubstring, strGroup.substring(0, strGroup.length() - 1), map2, dVar));
                                                                                    break;
                                                                            }
                                                                            matcherB = matcher;
                                                                            arrayList23 = arrayList8;
                                                                        }
                                                                        linkedHashMap = linkedHashMap4;
                                                                        linkedHashMap.put(strB8, (linkedHashMap.containsKey(strB8) ? (we1.c.a) linkedHashMap.get(strB8) : new we1.c.a(strB8)).c(uri3).b(uri4).r(jC1).h(jC12).g(j28).j(j30).f(arrayList22).i(zS4).m(j31).k(j33).q(arrayList23).l(arrayList24).d(arrayList25).e(bool).s(str26).t(str28).p(j34).n(j36).o(strX15));
                                                                    }
                                                                }
                                                            } else {
                                                                arrayList3 = arrayList4;
                                                                str7 = str;
                                                                map = map3;
                                                                arrayList5 = arrayList9;
                                                                fVar = fVar8;
                                                                arrayList6 = arrayList20;
                                                                str8 = str18;
                                                                str9 = str19;
                                                                j6 = j2;
                                                                linkedHashMap = linkedHashMap4;
                                                                if (!strB2.startsWith("#")) {
                                                                    String strE2 = e(j6, str8, str9);
                                                                    long j37 = j6 + 1;
                                                                    String strD = D(strB2, map2, dVar);
                                                                    map3 = map;
                                                                    we1.f fVar9 = (we1.f) map3.get(strD);
                                                                    if (j17 == -1) {
                                                                        fVar2 = fVar9;
                                                                        j7 = 0;
                                                                    } else {
                                                                        if (z9 && fVar == null && fVar9 == null) {
                                                                            fVar9 = new we1.f(strD, 0L, j13, null, null);
                                                                            map3.put(strD, fVar9);
                                                                        }
                                                                        fVar2 = fVar9;
                                                                        j7 = j13;
                                                                    }
                                                                    if (oo0Var3 != null || treeMap.isEmpty()) {
                                                                        str10 = str7;
                                                                        z3 = false;
                                                                        oo0Var2 = oo0Var3;
                                                                    } else {
                                                                        z3 = false;
                                                                        oo0.b[] bVarArr2 = (oo0.b[]) treeMap.values().toArray(new oo0.b[0]);
                                                                        str10 = str7;
                                                                        oo0 oo0Var8 = new oo0(str10, bVarArr2);
                                                                        if (oo0Var4 == null) {
                                                                            oo0VarD2 = d(str10, bVarArr2);
                                                                            oo0Var2 = oo0Var8;
                                                                            if (fVar == null) {
                                                                                fVar3 = fVar;
                                                                                str13 = strD;
                                                                                str11 = str8;
                                                                                i2 = i4;
                                                                                j8 = j17;
                                                                                j9 = j14;
                                                                                z4 = z10;
                                                                                j10 = jC;
                                                                                str12 = strW;
                                                                                arrayList7 = arrayList6;
                                                                            } else {
                                                                                fVar3 = fVar2;
                                                                                str11 = str8;
                                                                                i2 = i4;
                                                                                j8 = j17;
                                                                                j9 = j14;
                                                                                z4 = z10;
                                                                                j10 = jC;
                                                                                str12 = strW;
                                                                                arrayList7 = arrayList6;
                                                                                str13 = strD;
                                                                            }
                                                                            i4 = i2;
                                                                            String str29 = str11;
                                                                            arrayList5.add(new we1.f(str13, fVar3, str12, j10, i2, j9, oo0Var2, str11, strE2, j7, j8, z4, arrayList7));
                                                                            j12 = j9 + j10;
                                                                            ArrayList arrayList26 = new ArrayList();
                                                                            if (j17 != -1) {
                                                                                j7 += j8;
                                                                            }
                                                                            j13 = j7;
                                                                            str15 = str9;
                                                                            oo0Var4 = oo0VarD2;
                                                                            arrayList10 = arrayList26;
                                                                            strN = str10;
                                                                            z10 = z3;
                                                                            j14 = j12;
                                                                            oo0Var3 = oo0Var2;
                                                                            jC = 0;
                                                                            arrayList12 = arrayList;
                                                                            fVar4 = fVar;
                                                                            str14 = str4;
                                                                            strW = str14;
                                                                            treeMap4 = treeMap;
                                                                            arrayList11 = arrayList3;
                                                                            j17 = -1;
                                                                            j18 = -1;
                                                                            ze1Var2 = ze1Var;
                                                                            arrayList9 = arrayList5;
                                                                            strB = str29;
                                                                            linkedHashMap3 = linkedHashMap;
                                                                            we1Var2 = we1Var;
                                                                            jP = j37;
                                                                            dVar2 = dVar4;
                                                                            string = str2;
                                                                        } else {
                                                                            oo0Var2 = oo0Var8;
                                                                        }
                                                                    }
                                                                    oo0VarD2 = oo0Var4;
                                                                    if (fVar == null) {
                                                                    }
                                                                    i4 = i2;
                                                                    String str292 = str11;
                                                                    arrayList5.add(new we1.f(str13, fVar3, str12, j10, i2, j9, oo0Var2, str11, strE2, j7, j8, z4, arrayList7));
                                                                    j12 = j9 + j10;
                                                                    ArrayList arrayList262 = new ArrayList();
                                                                    if (j17 != -1) {
                                                                    }
                                                                    j13 = j7;
                                                                    str15 = str9;
                                                                    oo0Var4 = oo0VarD2;
                                                                    arrayList10 = arrayList262;
                                                                    strN = str10;
                                                                    z10 = z3;
                                                                    j14 = j12;
                                                                    oo0Var3 = oo0Var2;
                                                                    jC = 0;
                                                                    arrayList12 = arrayList;
                                                                    fVar4 = fVar;
                                                                    str14 = str4;
                                                                    strW = str14;
                                                                    treeMap4 = treeMap;
                                                                    arrayList11 = arrayList3;
                                                                    j17 = -1;
                                                                    j18 = -1;
                                                                    ze1Var2 = ze1Var;
                                                                    arrayList9 = arrayList5;
                                                                    strB = str292;
                                                                    linkedHashMap3 = linkedHashMap;
                                                                    we1Var2 = we1Var;
                                                                    jP = j37;
                                                                    dVar2 = dVar4;
                                                                    string = str2;
                                                                }
                                                            }
                                                            map3 = map;
                                                            str18 = str8;
                                                            j3 = j17;
                                                            j4 = j6;
                                                            j5 = j14;
                                                            z2 = z10;
                                                            arrayList10 = arrayList6;
                                                            arrayList2 = arrayList5;
                                                            str5 = str7;
                                                            str3 = str9;
                                                            str15 = str3;
                                                            arrayList9 = arrayList2;
                                                            strB = str18;
                                                            linkedHashMap3 = linkedHashMap;
                                                            jP = j4;
                                                            j14 = j5;
                                                            j17 = j3;
                                                            z10 = z2;
                                                            dVar2 = dVar4;
                                                            fVar4 = fVar;
                                                            str14 = str4;
                                                            string = str2;
                                                            treeMap4 = treeMap;
                                                            arrayList11 = arrayList3;
                                                            j18 = -1;
                                                            ze1Var2 = ze1Var;
                                                            we1Var2 = we1Var;
                                                            strN = str5;
                                                            arrayList12 = arrayList;
                                                        }
                                                    } else if (dVar4 == null && "PART".equals(B(strB2, T, map2, dVar))) {
                                                        String strB9 = B(strB2, Q, map2, dVar);
                                                        long jV = v(strB2, L, -1L, dVar);
                                                        String str30 = string;
                                                        long jV2 = v(strB2, M, -1L, dVar);
                                                        String strE3 = e(j2, str18, str19);
                                                        if (oo0Var3 != null || treeMap2.isEmpty()) {
                                                            treeMap3 = treeMap2;
                                                            str6 = str;
                                                            oo0Var = oo0Var3;
                                                        } else {
                                                            treeMap3 = treeMap2;
                                                            oo0.b[] bVarArr3 = (oo0.b[]) treeMap2.values().toArray(new oo0.b[0]);
                                                            str6 = str;
                                                            oo0 oo0Var9 = new oo0(str6, bVarArr3);
                                                            if (oo0Var4 == null) {
                                                                oo0VarD = d(str6, bVarArr3);
                                                                oo0Var = oo0Var9;
                                                                if (jV == -1 && jV2 == -1) {
                                                                    dVar2 = dVar4;
                                                                } else {
                                                                    long j38 = j12;
                                                                    we1.f fVar10 = fVar4;
                                                                    fVar4 = fVar10;
                                                                    j12 = j38;
                                                                    dVar2 = new we1.d(strB9, fVar10, 0L, i4, j38, oo0Var, str18, strE3, jV == -1 ? jV : 0L, jV2, false, false, true);
                                                                }
                                                                arrayList11 = arrayList4;
                                                                oo0Var4 = oo0VarD;
                                                                strB = str18;
                                                                str15 = str19;
                                                                jP = j2;
                                                                strN = str6;
                                                                oo0Var3 = oo0Var;
                                                                linkedHashMap3 = linkedHashMap4;
                                                                arrayList12 = arrayList;
                                                                str14 = str4;
                                                                string = str30;
                                                                arrayList10 = arrayList20;
                                                                treeMap4 = treeMap3;
                                                                j18 = -1;
                                                            } else {
                                                                oo0Var = oo0Var9;
                                                            }
                                                        }
                                                        oo0VarD = oo0Var4;
                                                        if (jV == -1) {
                                                            long j382 = j12;
                                                            we1.f fVar102 = fVar4;
                                                            fVar4 = fVar102;
                                                            j12 = j382;
                                                            dVar2 = new we1.d(strB9, fVar102, 0L, i4, j382, oo0Var, str18, strE3, jV == -1 ? jV : 0L, jV2, false, false, true);
                                                            arrayList11 = arrayList4;
                                                            oo0Var4 = oo0VarD;
                                                            strB = str18;
                                                            str15 = str19;
                                                            jP = j2;
                                                            strN = str6;
                                                            oo0Var3 = oo0Var;
                                                            linkedHashMap3 = linkedHashMap4;
                                                            arrayList12 = arrayList;
                                                            str14 = str4;
                                                            string = str30;
                                                            arrayList10 = arrayList20;
                                                            treeMap4 = treeMap3;
                                                            j18 = -1;
                                                        }
                                                    }
                                                    ze1Var2 = ze1Var;
                                                }
                                                arrayList3 = arrayList4;
                                                str2 = string;
                                                treeMap = treeMap2;
                                                arrayList2 = arrayList9;
                                                str3 = str19;
                                                j3 = j17;
                                                linkedHashMap = linkedHashMap4;
                                                j4 = j2;
                                                j5 = j14;
                                                z2 = z10;
                                                str5 = str;
                                                arrayList10 = arrayList20;
                                            }
                                            ze1Var2 = ze1Var;
                                            strB = str18;
                                            str15 = str19;
                                            linkedHashMap3 = linkedHashMap4;
                                            jP = j2;
                                            dVar2 = dVar4;
                                            arrayList12 = arrayList;
                                            strN = str;
                                        }
                                        str14 = str4;
                                        arrayList11 = arrayList21;
                                        arrayList10 = arrayList20;
                                    }
                                }
                                fVar = fVar4;
                                str15 = str3;
                                arrayList9 = arrayList2;
                                strB = str18;
                                linkedHashMap3 = linkedHashMap;
                                jP = j4;
                                j14 = j5;
                                j17 = j3;
                                z10 = z2;
                                dVar2 = dVar4;
                                fVar4 = fVar;
                                str14 = str4;
                                string = str2;
                                treeMap4 = treeMap;
                                arrayList11 = arrayList3;
                                j18 = -1;
                                ze1Var2 = ze1Var;
                                we1Var2 = we1Var;
                                strN = str5;
                                arrayList12 = arrayList;
                            }
                        }
                        strB = str18;
                        str15 = str19;
                        linkedHashMap3 = linkedHashMap4;
                        jP = j2;
                        dVar2 = dVar4;
                        arrayList12 = arrayList;
                        strN = str;
                    }
                }
                linkedHashMap3 = linkedHashMap4;
                jP = j2;
                dVar2 = dVar4;
                arrayList12 = arrayList;
            }
        }
        throw new b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:120:0x03f7. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:103:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01dd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ze1 r(c cVar, Uri uri, d dVar) throws r83 {
        String str;
        String strB;
        String strB2;
        String strX;
        ArrayList arrayList;
        t41.b bVarO0;
        Uri uriG;
        xs2 xs2Var;
        ArrayList arrayList2;
        ArrayList arrayList3;
        String strG;
        ArrayList arrayList4;
        int i2;
        String str2;
        ArrayList arrayList5;
        String strG2;
        boolean z2;
        int i3;
        ArrayList arrayList6;
        ArrayList arrayList7;
        ArrayList arrayList8;
        ArrayList arrayList9;
        HashMap map;
        ArrayList arrayList10;
        int i4;
        String str3;
        String str4;
        String strZ;
        bx bxVarB0;
        String strX2;
        Uri uriG2;
        String string = uri.toString();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        ArrayList arrayList16 = new ArrayList();
        ArrayList arrayList17 = new ArrayList();
        ArrayList arrayList18 = new ArrayList();
        boolean z3 = false;
        boolean z4 = false;
        while (true) {
            ArrayList arrayList19 = arrayList15;
            boolean z5 = z3;
            if (!cVar.a()) {
                ArrayList arrayList20 = arrayList16;
                ArrayList arrayList21 = arrayList18;
                ArrayList arrayList22 = arrayList12;
                ArrayList arrayList23 = arrayList13;
                ArrayList arrayList24 = arrayList14;
                boolean z6 = z4;
                ArrayList arrayList25 = arrayList17;
                ArrayList arrayList26 = new ArrayList();
                HashSet hashSet = new HashSet();
                for (int i5 = 0; i5 < arrayList11.size(); i5++) {
                    ze1.b bVar = (ze1.b) arrayList11.get(i5);
                    if (hashSet.add(bVar.a)) {
                        gg3.v(bVar.b.l == null);
                        arrayList26.add(bVar.a(bVar.b.b().s0(new xs2(new lf1(null, null, (List) gg3.q((ArrayList) map2.get(bVar.a))))).Q()));
                    }
                }
                ArrayList arrayList27 = null;
                t41 t41VarQ = null;
                int i6 = 0;
                while (i6 < arrayList20.size()) {
                    ArrayList arrayList28 = arrayList20;
                    str = (String) arrayList28.get(i6);
                    strB = B(str, X, map3, dVar);
                    strB2 = B(str, V, map3, dVar);
                    strX = x(str, q, map3, dVar);
                    t41.b bVar2 = new t41.b();
                    StringBuilder sb = new StringBuilder();
                    sb.append(strB);
                    arrayList = arrayList27;
                    sb.append(":");
                    sb.append(strB2);
                    bVarO0 = bVar2.k0(sb.toString()).m0(strB2).X("application/x-mpegURL").C0(z(str, dVar)).y0(y(str, map3, dVar)).o0(x(str, U, map3, dVar));
                    String strX3 = x(str, Q, map3, dVar);
                    uriG = strX3 == null ? null : kx4.g(string, strX3);
                    String str5 = string;
                    ArrayList arrayList29 = arrayList26;
                    xs2Var = new xs2(new lf1(strB, strB2, Collections.EMPTY_LIST));
                    String strB3 = B(str, S, map3, dVar);
                    strB3.getClass();
                    switch (strB3) {
                        case "SUBTITLES":
                            arrayList2 = arrayList23;
                            arrayList3 = arrayList22;
                            ze1.b bVarG = g(arrayList11, strB);
                            if (bVarG != null) {
                                String strZ2 = fy4.Z(bVarG.b.k, 3);
                                bVarO0.V(strZ2);
                                strG = nt2.g(strZ2);
                            } else {
                                strG = null;
                            }
                            if (strG == null) {
                                strG = "text/vtt";
                            }
                            bVarO0.A0(strG).s0(xs2Var);
                            if (uriG != null) {
                                ze1.a aVar = new ze1.a(uriG, bVarO0.Q(), strB, strB2, strX);
                                arrayList4 = arrayList24;
                                arrayList4.add(aVar);
                            } else {
                                arrayList4 = arrayList24;
                                xz1.i("HlsPlaylistParser", "EXT-X-MEDIA tag with missing mandatory URI attribute: skipping");
                            }
                            arrayList5 = arrayList;
                            break;
                        case "CLOSED-CAPTIONS":
                            arrayList2 = arrayList23;
                            arrayList3 = arrayList22;
                            String strB4 = B(str, Z, map3, dVar);
                            if (strB4.startsWith("CC")) {
                                i2 = Integer.parseInt(strB4.substring(2));
                                str2 = "application/cea-608";
                            } else {
                                i2 = Integer.parseInt(strB4.substring(7));
                                str2 = "application/cea-708";
                            }
                            arrayList5 = arrayList == null ? new ArrayList() : arrayList;
                            bVarO0.A0(str2).R(i2);
                            arrayList5.add(bVarO0.Q());
                            arrayList4 = arrayList24;
                            break;
                        case "AUDIO":
                            arrayList3 = arrayList22;
                            ze1.b bVarF = f(arrayList11, strB);
                            if (bVarF != null) {
                                String strZ3 = fy4.Z(bVarF.b.k, 1);
                                bVarO0.V(strZ3);
                                strG2 = nt2.g(strZ3);
                            } else {
                                strG2 = null;
                            }
                            String strX4 = x(str, i, map3, dVar);
                            if (strX4 != null) {
                                bVarO0.U(Integer.parseInt(fy4.H1(strX4, ServiceReference.DELIMITER)[0]));
                                if ("audio/eac3".equals(strG2) && strX4.endsWith("/JOC")) {
                                    bVarO0.V("ec+3");
                                    strG2 = "audio/eac3-joc";
                                }
                            }
                            bVarO0.A0(strG2);
                            if (uriG == null) {
                                arrayList2 = arrayList23;
                                if (bVarF != null) {
                                    arrayList5 = arrayList;
                                    t41VarQ = bVarO0.Q();
                                    arrayList4 = arrayList24;
                                }
                                break;
                            } else {
                                bVarO0.s0(xs2Var);
                                arrayList2 = arrayList23;
                                arrayList2.add(new ze1.a(uriG, bVarO0.Q(), strB, strB2, strX));
                            }
                            arrayList4 = arrayList24;
                            arrayList5 = arrayList;
                            break;
                        case "VIDEO":
                            ze1.b bVarH = h(arrayList11, strB);
                            if (bVarH != null) {
                                t41 t41Var = bVarH.b;
                                String strZ4 = fy4.Z(t41Var.k, 2);
                                bVarO0.V(strZ4).A0(nt2.g(strZ4)).H0(t41Var.w).i0(t41Var.x).g0(t41Var.A);
                            }
                            if (uriG != null) {
                                bVarO0.s0(xs2Var);
                                arrayList3 = arrayList22;
                                arrayList3.add(new ze1.a(uriG, bVarO0.Q(), strB, strB2, strX));
                                arrayList4 = arrayList24;
                                arrayList2 = arrayList23;
                            }
                            arrayList5 = arrayList;
                        default:
                            arrayList4 = arrayList24;
                            arrayList2 = arrayList23;
                            arrayList3 = arrayList22;
                            arrayList5 = arrayList;
                            break;
                    }
                    i6++;
                    arrayList22 = arrayList3;
                    arrayList24 = arrayList4;
                    arrayList23 = arrayList2;
                    arrayList20 = arrayList28;
                    arrayList27 = arrayList5;
                    string = str5;
                    arrayList26 = arrayList29;
                }
                return new ze1(uri.toString(), arrayList21, arrayList26, arrayList22, arrayList23, arrayList24, arrayList19, t41VarQ, z5 ? Collections.EMPTY_LIST : arrayList27, z6, map3, arrayList25);
            }
            String strB5 = cVar.b();
            if (strB5.startsWith("#EXT")) {
                arrayList18.add(strB5);
            }
            boolean zStartsWith = strB5.startsWith("#EXT-X-I-FRAME-STREAM-INF");
            ArrayList arrayList30 = arrayList18;
            if (strB5.startsWith("#EXT-X-DEFINE")) {
                String strX5 = x(strB5, V, map3, dVar);
                if (strX5 != null) {
                    F(strX5, map3);
                    map3.put(strX5, B(strB5, g0, map3, dVar));
                } else {
                    String strB6 = B(strB5, W, map3, dVar);
                    F(strB6, map3);
                    String queryParameter = uri.getQueryParameter(strB6);
                    if (queryParameter == null) {
                        throw r83.c("QUERYPARAM \"" + strB6 + "\" not found in playlist URI", null);
                    }
                    map3.put(strB6, queryParameter);
                }
            } else {
                if (strB5.equals("#EXT-X-INDEPENDENT-SEGMENTS")) {
                    arrayList10 = arrayList16;
                    arrayList9 = arrayList12;
                    arrayList8 = arrayList13;
                    arrayList7 = arrayList14;
                    arrayList6 = arrayList17;
                    z3 = z5;
                    z4 = true;
                } else if (strB5.startsWith("#EXT-X-MEDIA")) {
                    arrayList16.add(strB5);
                } else if (strB5.startsWith("#EXT-X-SESSION-KEY")) {
                    oo0.b bVarM = m(strB5, w(strB5, O, "identity", map3, dVar), map3, dVar);
                    if (bVarM != null) {
                        arrayList17.add(new oo0(n(B(strB5, N, map3, dVar)), bVarM));
                    }
                } else if (strB5.startsWith("#EXT-X-STREAM-INF") || zStartsWith) {
                    boolean zContains = z5 | strB5.contains("CLOSED-CAPTIONS=NONE");
                    if (zStartsWith) {
                        z2 = zContains;
                        i3 = 16384;
                    } else {
                        z2 = zContains;
                        i3 = 0;
                    }
                    int iO = o(strB5, h, dVar);
                    boolean z7 = z4;
                    arrayList6 = arrayList17;
                    int iU = u(strB5, c, -1, dVar);
                    String strX6 = x(strB5, j, map3, dVar);
                    arrayList7 = arrayList14;
                    String strX7 = x(strB5, k, map3, dVar);
                    arrayList8 = arrayList13;
                    String strX8 = x(strB5, l, map3, dVar);
                    arrayList9 = arrayList12;
                    if (strX8 != null) {
                        String[] strArrG1 = fy4.G1(fy4.H1(strX8, ",")[0], ServiceReference.DELIMITER);
                        String str6 = strArrG1[0];
                        if (strArrG1.length > 1) {
                            str4 = strArrG1[1];
                            map = map2;
                            arrayList10 = arrayList16;
                            str3 = str6;
                            i4 = 2;
                            strZ = fy4.Z(strX7, i4);
                            if (i(strX6, strZ, str3, str4)) {
                                bxVarB0 = null;
                            } else {
                                bxVarB0 = fy4.b0(strX7, str3, str4);
                                if (str3 == null) {
                                    str3 = strZ;
                                }
                                String strA0 = fy4.a0(strX7, i4);
                                strX7 = strA0 != null ? str3 + "," + strA0 : str3;
                            }
                            strX2 = x(strB5, m, map3, dVar);
                            if (strX2 == null) {
                                String[] strArrG12 = fy4.G1(strX2, "x");
                                int i7 = Integer.parseInt(strArrG12[0]);
                                int i8 = Integer.parseInt(strArrG12[1]);
                                if (i7 <= 0 || i8 <= 0) {
                                    i8 = -1;
                                    i7 = -1;
                                }
                                String strX9 = x(strB5, n, map3, dVar);
                                float f2 = strX9 != null ? Float.parseFloat(strX9) : -1.0f;
                                String strX10 = x(strB5, o, map3, dVar);
                                String strX11 = x(strB5, d, map3, dVar);
                                String strX12 = x(strB5, e, map3, dVar);
                                String strX13 = x(strB5, f, map3, dVar);
                                String strX14 = x(strB5, g, map3, dVar);
                                String strX15 = x(strB5, p, map3, dVar);
                                if (zStartsWith) {
                                    uriG2 = kx4.g(string, B(strB5, Q, map3, dVar));
                                } else {
                                    if (!cVar.a()) {
                                        throw r83.c("#EXT-X-STREAM-INF must be followed by another line", null);
                                    }
                                    uriG2 = kx4.g(string, D(cVar.b(), map3, dVar));
                                }
                                Uri uri2 = uriG2;
                                arrayList11.add(new ze1.b(uri2, new t41.b().j0(arrayList11.size()).X("application/x-mpegURL").V(strX7).T(iU).u0(iO).H0(i7).i0(i8).g0(f2).y0(i3).W(bxVarB0).Q(), strX11, strX12, strX13, strX14, strX10, strX15));
                                map2 = map;
                                ArrayList arrayList31 = (ArrayList) map2.get(uri2);
                                if (arrayList31 == null) {
                                    arrayList31 = new ArrayList();
                                    map2.put(uri2, arrayList31);
                                }
                                arrayList31.add(new lf1.a(iU, iO, strX11, strX12, strX13, strX14));
                                z3 = z2;
                                z4 = z7;
                            }
                        } else {
                            map = map2;
                            arrayList10 = arrayList16;
                            str3 = str6;
                            i4 = 2;
                        }
                    } else {
                        map = map2;
                        arrayList10 = arrayList16;
                        i4 = 2;
                        str3 = null;
                    }
                    str4 = null;
                    strZ = fy4.Z(strX7, i4);
                    if (i(strX6, strZ, str3, str4)) {
                    }
                    strX2 = x(strB5, m, map3, dVar);
                    if (strX2 == null) {
                    }
                }
                arrayList15 = arrayList19;
                arrayList18 = arrayList30;
                arrayList17 = arrayList6;
                arrayList14 = arrayList7;
                arrayList13 = arrayList8;
                arrayList12 = arrayList9;
                arrayList16 = arrayList10;
            }
            arrayList10 = arrayList16;
            arrayList9 = arrayList12;
            arrayList8 = arrayList13;
            arrayList7 = arrayList14;
            arrayList6 = arrayList17;
            z3 = z5;
            arrayList15 = arrayList19;
            arrayList18 = arrayList30;
            arrayList17 = arrayList6;
            arrayList14 = arrayList7;
            arrayList13 = arrayList8;
            arrayList12 = arrayList9;
            arrayList16 = arrayList10;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean s(String str, Pattern pattern, boolean z2, d dVar) {
        Matcher matcherB = dVar.b(pattern, str);
        return matcherB.find() ? "YES".equals(matcherB.group(1)) : z2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static double t(String str, Pattern pattern, double d2, d dVar) {
        Matcher matcherB = dVar.b(pattern, str);
        return matcherB.find() ? Double.parseDouble((String) gg3.q(matcherB.group(1))) : d2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int u(String str, Pattern pattern, int i2, d dVar) {
        Matcher matcherB = dVar.b(pattern, str);
        return matcherB.find() ? Integer.parseInt((String) gg3.q(matcherB.group(1))) : i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long v(String str, Pattern pattern, long j2, d dVar) {
        Matcher matcherB = dVar.b(pattern, str);
        return matcherB.find() ? Long.parseLong((String) gg3.q(matcherB.group(1))) : j2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String w(String str, Pattern pattern, String str2, Map map, d dVar) {
        Matcher matcherB = dVar.b(pattern, str);
        if (matcherB.find()) {
            str2 = (String) gg3.q(matcherB.group(1));
        }
        return (map.isEmpty() || str2 == null) ? str2 : D(str2, map, dVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String x(String str, Pattern pattern, Map map, d dVar) {
        return w(str, pattern, null, map, dVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a(Landroid/net/Uri;Ljava/io/InputStream;)Ljava/lang/Object; */
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
