package defpackage;

import com.github.catvod.utils.Path;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import fi.iki.elonen.NanoHTTPD;
import j$.time.Instant;
import j$.time.ZoneId;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.zip.CRC32;
import org.jupnp.model.ServiceReference;
import org.jupnp.model.message.header.ContentRangeHeader;
import org.jupnp.model.types.BytesRange;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class fz1 implements zg3 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends to3 {
        public final long a;
        public final long b;
        public final long c;
        public final boolean d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(long j, long j2, long j3, boolean z) {
            this.a = j;
            this.b = j2;
            this.c = j3;
            this.d = z;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private /* synthetic */ boolean a(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.d == aVar.d && this.a == aVar.a && this.b == aVar.b && this.c == aVar.c;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private /* synthetic */ Object[] b() {
            return new Object[]{Long.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.c), Boolean.valueOf(this.d)};
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static a f(long j, Map map, String str) {
            long j2;
            long j3 = j - 1;
            String str2 = (String) map.get("range");
            String str3 = (String) map.get("if-range");
            if (str3 != null && !str3.equals(str)) {
                str2 = null;
            }
            if (str2 == null || !str2.startsWith(BytesRange.PREFIX)) {
                j2 = j3;
            } else {
                try {
                    String[] strArrSplit = str2.substring(6).split("-", 2);
                    j = strArrSplit[0].isEmpty() ? 0L : Long.parseLong(strArrSplit[0]);
                    j2 = (strArrSplit.length <= 1 || strArrSplit[1].isEmpty()) ? j3 : Long.parseLong(strArrSplit[1]);
                    if (j >= j || j > j2) {
                        return g();
                    }
                } catch (NumberFormatException unused) {
                    return g();
                }
            }
            long j4 = j2 >= j ? j3 : j2;
            return new a(j, j4, (j4 - j) + 1, true);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static a g() {
            return new a(0L, 0L, 0L, false);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean equals(Object obj) {
            return a(obj);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean h(long j) {
            return this.c < j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int hashCode() {
            return ez1.a(this.d, this.a, this.b, this.c);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean i() {
            return this.d;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final String toString() {
            return yq.a(b(), a.class, "a;b;c;d");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String j(File file, File file2, String str) {
        if (file.equals(file2)) {
            return ".";
        }
        File parentFile = file.getParentFile();
        return (parentFile == null || parentFile.equals(file2)) ? "" : k(parentFile, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String k(File file, String str) {
        String absolutePath = file.getAbsolutePath();
        return absolutePath.startsWith(str) ? absolutePath.substring(str.length()) : absolutePath;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zg3
    public boolean a(NanoHTTPD.IHTTPSession iHTTPSession, String str) {
        return str.startsWith("/file") || str.startsWith("/upload") || str.startsWith("/newFolder") || str.startsWith("/delFolder") || str.startsWith("/delFile");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.zg3
    public NanoHTTPD.Response b(NanoHTTPD.IHTTPSession iHTTPSession, String str, Map map) {
        if (str.startsWith("/file")) {
            return g(iHTTPSession.getHeaders(), str);
        }
        if (str.startsWith("/upload")) {
            return m(iHTTPSession.getParms(), map);
        }
        if (str.startsWith("/newFolder")) {
            return i(iHTTPSession.getParms());
        }
        if (str.startsWith("/delFolder") || str.startsWith("/delFile")) {
            return d(iHTTPSession.getParms());
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final NanoHTTPD.Response c(long j) {
        NanoHTTPD.Response responseNewFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.RANGE_NOT_SATISFIABLE, NanoHTTPD.MIME_PLAINTEXT, "");
        responseNewFixedLengthResponse.addHeader("Content-Range", "bytes */" + j);
        return responseNewFixedLengthResponse;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final NanoHTTPD.Response d(Map map) {
        Path.clear(Path.root((String) map.get("path")));
        return gx2.e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String e(File file, long j) {
        CRC32 crc32 = new CRC32();
        crc32.update((file.getAbsolutePath() + file.lastModified() + j).getBytes());
        return Long.toHexString(crc32.getValue());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final NanoHTTPD.Response f(Map map, File file, String str) throws IOException {
        NanoHTTPD.Response responseNewFixedLengthResponse;
        long length = file.length();
        String strE = e(file, length);
        String str2 = (String) map.get("if-none-match");
        if (str2 != null && (str2.equals("*") || str2.equals(strE))) {
            return NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.NOT_MODIFIED, str, "");
        }
        a aVarF = a.f(length, map, strE);
        if (!aVarF.i()) {
            return c(length);
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        l(fileInputStream, aVarF.a);
        if (aVarF.h(length)) {
            responseNewFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.PARTIAL_CONTENT, str, fileInputStream, aVarF.c);
            responseNewFixedLengthResponse.addHeader("Content-Range", ContentRangeHeader.PREFIX + aVarF.a + "-" + aVarF.b + ServiceReference.DELIMITER + length);
        } else {
            responseNewFixedLengthResponse = NanoHTTPD.newFixedLengthResponse(NanoHTTPD.Response.Status.OK, str, fileInputStream, aVarF.c);
        }
        responseNewFixedLengthResponse.addHeader("Content-Length", String.valueOf(aVarF.c));
        responseNewFixedLengthResponse.addHeader("Accept-Ranges", "bytes");
        responseNewFixedLengthResponse.addHeader("ETag", strE);
        return responseNewFixedLengthResponse;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final NanoHTTPD.Response g(Map map, String str) {
        try {
            File fileLocal = Path.local(str.substring(5));
            if (fileLocal.isDirectory()) {
                return h(fileLocal);
            }
            if (fileLocal.isFile()) {
                return f(map, fileLocal, NanoHTTPD.getMimeTypeForFile(str));
            }
            throw new FileNotFoundException();
        } catch (Exception e) {
            return gx2.c(e.getMessage());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final NanoHTTPD.Response h(File file) {
        File fileRoot = Path.root();
        String absolutePath = fileRoot.getAbsolutePath();
        JsonArray jsonArray = new JsonArray();
        for (File file2 : Path.list(file)) {
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty("name", file2.getName());
            jsonObject.addProperty("path", k(file2, absolutePath));
            jsonObject.addProperty("time", w41.d.format(Instant.ofEpochMilli(file2.lastModified()).atZone(ZoneId.systemDefault())));
            jsonObject.addProperty("dir", Integer.valueOf(file2.isDirectory() ? 1 : 0));
            jsonArray.add(jsonObject);
        }
        JsonObject jsonObject2 = new JsonObject();
        jsonObject2.addProperty("parent", j(file, fileRoot, absolutePath));
        jsonObject2.add("files", jsonArray);
        return gx2.f(jsonObject2.toString());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final NanoHTTPD.Response i(Map map) {
        Path.root((String) map.get("path"), (String) map.get("name")).mkdirs();
        return gx2.e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void l(InputStream inputStream, long j) throws IOException {
        if (j <= 0) {
            return;
        }
        while (j > 0) {
            long jSkip = inputStream.skip(j);
            if (jSkip <= 0) {
                sb1.a("Failed to skip desired number of bytes");
                return;
            }
            j -= jSkip;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final NanoHTTPD.Response m(Map map, Map map2) {
        String str = (String) map.get("path");
        for (String str2 : map2.keySet()) {
            String str3 = (String) map.get(str2);
            File file = new File((String) map2.get(str2));
            if (str3.toLowerCase().endsWith(".zip")) {
                w01.p(file, Path.root(str));
            } else {
                Path.copy(file, Path.root(str, str3));
            }
        }
        return gx2.e();
    }
}
