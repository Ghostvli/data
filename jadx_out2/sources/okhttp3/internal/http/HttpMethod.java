package okhttp3.internal.http;

import defpackage.il1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class HttpMethod {
    public static final HttpMethod INSTANCE = new HttpMethod();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private HttpMethod() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final boolean invalidatesCache(String str) {
        str.getClass();
        return il1.a(str, "POST") || il1.a(str, "PATCH") || il1.a(str, "PUT") || il1.a(str, "DELETE") || il1.a(str, "MOVE");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final boolean permitsRequestBody(String str) {
        str.getClass();
        return (il1.a(str, "GET") || il1.a(str, "HEAD")) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final boolean requiresRequestBody(String str) {
        str.getClass();
        return il1.a(str, "POST") || il1.a(str, "PUT") || il1.a(str, "PATCH") || il1.a(str, "PROPPATCH") || il1.a(str, "QUERY") || il1.a(str, "REPORT");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean isCacheable(String str) {
        str.getClass();
        return il1.a(str, "GET") || il1.a(str, "QUERY");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean redirectsToGet(String str) {
        str.getClass();
        return !il1.a(str, "PROPFIND");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean redirectsWithBody(String str) {
        str.getClass();
        return il1.a(str, "PROPFIND");
    }
}
