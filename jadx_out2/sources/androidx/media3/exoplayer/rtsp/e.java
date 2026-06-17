package androidx.media3.exoplayer.rtsp;

import defpackage.fy4;
import defpackage.km1;
import defpackage.xa;
import defpackage.xi1;
import defpackage.yi1;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public static final e b = new b().e();
    public final yi1 a;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public e(b bVar) {
        this.a = bVar.a.e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String c(String str) {
        return xa.a(str, "Accept") ? "Accept" : xa.a(str, "Allow") ? "Allow" : xa.a(str, "Authorization") ? "Authorization" : xa.a(str, "Bandwidth") ? "Bandwidth" : xa.a(str, "Blocksize") ? "Blocksize" : xa.a(str, "Cache-Control") ? "Cache-Control" : xa.a(str, "Connection") ? "Connection" : xa.a(str, "Content-Base") ? "Content-Base" : xa.a(str, "Content-Encoding") ? "Content-Encoding" : xa.a(str, "Content-Language") ? "Content-Language" : xa.a(str, "Content-Length") ? "Content-Length" : xa.a(str, "Content-Location") ? "Content-Location" : xa.a(str, "Content-Type") ? "Content-Type" : xa.a(str, "CSeq") ? "CSeq" : xa.a(str, "Date") ? "Date" : xa.a(str, "Expires") ? "Expires" : xa.a(str, "Location") ? "Location" : xa.a(str, "Proxy-Authenticate") ? "Proxy-Authenticate" : xa.a(str, "Proxy-Require") ? "Proxy-Require" : xa.a(str, "Public") ? "Public" : xa.a(str, "Range") ? "Range" : xa.a(str, "RTP-Info") ? "RTP-Info" : xa.a(str, "RTCP-Interval") ? "RTCP-Interval" : xa.a(str, "Scale") ? "Scale" : xa.a(str, "Session") ? "Session" : xa.a(str, "Speed") ? "Speed" : xa.a(str, "Supported") ? "Supported" : xa.a(str, "Timestamp") ? "Timestamp" : xa.a(str, "Transport") ? "Transport" : xa.a(str, "User-Agent") ? "User-Agent" : xa.a(str, "Via") ? "Via" : xa.a(str, "WWW-Authenticate") ? "WWW-Authenticate" : str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public yi1 b() {
        return this.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String d(String str) {
        xi1 xi1VarE = e(str);
        if (xi1VarE.isEmpty()) {
            return null;
        }
        return (String) km1.d(xi1VarE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xi1 e(String str) {
        return this.a.get(c(str));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e) {
            return this.a.equals(((e) obj).a);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return this.a.hashCode();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final yi1.a a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(String str, String str2, int i) {
            this();
            b("User-Agent", str);
            b("CSeq", String.valueOf(i));
            if (str2 != null) {
                b("Session", str2);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b b(String str, String str2) {
            this.a.f(e.c(str.trim()), str2.trim());
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b c(List list) {
            for (int i = 0; i < list.size(); i++) {
                String[] strArrH1 = fy4.H1((String) list.get(i), ":\\s?");
                if (strArrH1.length == 2) {
                    b(strArrH1[0], strArrH1[1]);
                }
            }
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b d(Map map) {
            for (Map.Entry entry : map.entrySet()) {
                b((String) entry.getKey(), (String) entry.getValue());
            }
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e e() {
            return new e(this);
        }

        public b() {
            this.a = new yi1.a();
        }
    }
}
