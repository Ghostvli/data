package org.jupnp.http;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import org.jupnp.http.HttpFetch;
import org.jupnp.http.Representation;
import org.jupnp.util.io.IO;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class HttpFetch {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface RepresentationFactory<E> {
        Representation<E> createRepresentation(URLConnection uRLConnection, InputStream inputStream);
    }

    public static /* synthetic */ Representation a(URLConnection uRLConnection, InputStream inputStream) {
        return new Representation(uRLConnection, IO.readLines(inputStream));
    }

    public static /* synthetic */ Representation b(URLConnection uRLConnection, InputStream inputStream) {
        return new Representation(uRLConnection, IO.readAllBytes(inputStream));
    }

    public static /* synthetic */ Representation c(URLConnection uRLConnection, InputStream inputStream) {
        return new Representation(uRLConnection, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static <E> org.jupnp.http.Representation<E> fetch(java.net.URL r2, java.lang.String r3, int r4, int r5, org.jupnp.http.HttpFetch.RepresentationFactory<E> r6) throws java.lang.Throwable {
        /*
            r0 = 0
            java.net.URLConnection r2 = r2.openConnection()     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L2b
            java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch: java.lang.Throwable -> L28 java.io.IOException -> L2b
            r2.setRequestMethod(r3)     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L23
            r2.setConnectTimeout(r4)     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L23
            r2.setReadTimeout(r5)     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L23
            java.io.InputStream r0 = r2.getInputStream()     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L23
            org.jupnp.http.Representation r3 = r6.createRepresentation(r2, r0)     // Catch: java.lang.Throwable -> L21 java.io.IOException -> L23
            if (r0 == 0) goto L1d
            r0.close()
        L1d:
            r2.disconnect()
            return r3
        L21:
            r3 = move-exception
            goto L62
        L23:
            r3 = move-exception
            r1 = r0
            r0 = r2
            r2 = r1
            goto L2d
        L28:
            r3 = move-exception
            r2 = r0
            goto L62
        L2b:
            r3 = move-exception
            r2 = r0
        L2d:
            if (r0 == 0) goto L61
            int r3 = r0.getResponseCode()     // Catch: java.lang.Throwable -> L45
            java.io.InputStream r4 = r0.getErrorStream()     // Catch: java.lang.Throwable -> L45
            if (r4 == 0) goto L4a
        L39:
            int r5 = r4.read()     // Catch: java.lang.Throwable -> L45
            r6 = -1
            if (r5 == r6) goto L41
            goto L39
        L41:
            r4.close()     // Catch: java.lang.Throwable -> L45
            goto L4a
        L45:
            r3 = move-exception
            r1 = r0
            r0 = r2
            r2 = r1
            goto L62
        L4a:
            java.io.IOException r4 = new java.io.IOException     // Catch: java.lang.Throwable -> L45
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L45
            r5.<init>()     // Catch: java.lang.Throwable -> L45
            java.lang.String r6 = "Fetching resource failed, returned status code: "
            r5.append(r6)     // Catch: java.lang.Throwable -> L45
            r5.append(r3)     // Catch: java.lang.Throwable -> L45
            java.lang.String r3 = r5.toString()     // Catch: java.lang.Throwable -> L45
            r4.<init>(r3)     // Catch: java.lang.Throwable -> L45
            throw r4     // Catch: java.lang.Throwable -> L45
        L61:
            throw r3     // Catch: java.lang.Throwable -> L45
        L62:
            if (r0 == 0) goto L67
            r0.close()
        L67:
            if (r2 == 0) goto L6c
            r2.disconnect()
        L6c:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jupnp.http.HttpFetch.fetch(java.net.URL, java.lang.String, int, int, org.jupnp.http.HttpFetch$RepresentationFactory):org.jupnp.http.Representation");
    }

    public static Representation<byte[]> fetchBinary(URL url, int i, int i2) {
        return fetch(url, i, i2, new RepresentationFactory() { // from class: sg1
            @Override // org.jupnp.http.HttpFetch.RepresentationFactory
            public final Representation createRepresentation(URLConnection uRLConnection, InputStream inputStream) {
                return HttpFetch.b(uRLConnection, inputStream);
            }
        });
    }

    public static Representation<String> fetchString(URL url, int i, int i2) {
        return fetch(url, i, i2, new RepresentationFactory() { // from class: tg1
            @Override // org.jupnp.http.HttpFetch.RepresentationFactory
            public final Representation createRepresentation(URLConnection uRLConnection, InputStream inputStream) {
                return HttpFetch.a(uRLConnection, inputStream);
            }
        });
    }

    public static void validate(URL url) throws Throwable {
        fetch(url, "HEAD", 500, 500, new RepresentationFactory() { // from class: rg1
            @Override // org.jupnp.http.HttpFetch.RepresentationFactory
            public final Representation createRepresentation(URLConnection uRLConnection, InputStream inputStream) {
                return HttpFetch.c(uRLConnection, inputStream);
            }
        });
    }

    public static Representation<byte[]> fetchBinary(URL url) {
        return fetchBinary(url, 500, 500);
    }

    public static <E> Representation<E> fetch(URL url, int i, int i2, RepresentationFactory<E> representationFactory) {
        return fetch(url, "GET", i, i2, representationFactory);
    }
}
