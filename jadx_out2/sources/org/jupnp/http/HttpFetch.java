package org.jupnp.http;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
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

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0006: CONSTRUCTOR 
      (r1v0 java.net.URLConnection)
      (wrap:java.lang.String:0x0002: INVOKE (r2v0 java.io.InputStream) STATIC call: org.jupnp.util.io.IO.readLines(java.io.InputStream):java.lang.String A[MD:(java.io.InputStream):java.lang.String throws java.io.IOException (m), WRAPPED] (LINE:3))
     A[MD:(java.net.URLConnection, E):void (m)] (LINE:7) call: org.jupnp.http.Representation.<init>(java.net.URLConnection, java.lang.Object):void type: CONSTRUCTOR */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Representation a(URLConnection uRLConnection, InputStream inputStream) {
        return new Representation(uRLConnection, IO.readLines(inputStream));
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0006: CONSTRUCTOR 
      (r1v0 java.net.URLConnection)
      (wrap:byte[]:0x0002: INVOKE (r2v0 java.io.InputStream) STATIC call: org.jupnp.util.io.IO.readAllBytes(java.io.InputStream):byte[] A[MD:(java.io.InputStream):byte[] throws java.io.IOException (m), WRAPPED] (LINE:3))
     A[MD:(java.net.URLConnection, E):void (m)] (LINE:7) call: org.jupnp.http.Representation.<init>(java.net.URLConnection, java.lang.Object):void type: CONSTRUCTOR */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Representation b(URLConnection uRLConnection, InputStream inputStream) {
        return new Representation(uRLConnection, IO.readAllBytes(inputStream));
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0003: CONSTRUCTOR (r1v0 java.net.URLConnection), (null java.lang.Object) A[MD:(java.net.URLConnection, E):void (m)] (LINE:4) call: org.jupnp.http.Representation.<init>(java.net.URLConnection, java.lang.Object):void type: CONSTRUCTOR */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ Representation c(URLConnection uRLConnection, InputStream inputStream) {
        return new Representation(uRLConnection, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static <E> Representation<E> fetch(URL url, String str, int i, int i2, RepresentationFactory<E> representationFactory) throws Throwable {
        HttpURLConnection httpURLConnection;
        InputStream inputStream;
        InputStream inputStream2 = null;
        inputStream2 = null;
        inputStream2 = null;
        HttpURLConnection httpURLConnection2 = null;
        try {
            httpURLConnection = (HttpURLConnection) url.openConnection();
            try {
                httpURLConnection.setRequestMethod(str);
                httpURLConnection.setConnectTimeout(i);
                httpURLConnection.setReadTimeout(i2);
                inputStream2 = httpURLConnection.getInputStream();
                Representation<E> representationCreateRepresentation = representationFactory.createRepresentation(httpURLConnection, inputStream2);
                if (inputStream2 != null) {
                    inputStream2.close();
                }
                httpURLConnection.disconnect();
                return representationCreateRepresentation;
            } catch (IOException e) {
                e = e;
                InputStream inputStream3 = inputStream2;
                httpURLConnection2 = httpURLConnection;
                inputStream = inputStream3;
                try {
                    if (httpURLConnection2 == null) {
                        throw e;
                    }
                    int responseCode = httpURLConnection2.getResponseCode();
                    InputStream errorStream = httpURLConnection2.getErrorStream();
                    if (errorStream != null) {
                        while (errorStream.read() != -1) {
                        }
                        errorStream.close();
                    }
                    throw new IOException("Fetching resource failed, returned status code: " + responseCode);
                } catch (Throwable th) {
                    th = th;
                    HttpURLConnection httpURLConnection3 = httpURLConnection2;
                    inputStream2 = inputStream;
                    httpURLConnection = httpURLConnection3;
                    if (inputStream2 != null) {
                        inputStream2.close();
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                if (inputStream2 != null) {
                }
                if (httpURLConnection != null) {
                }
                throw th;
            }
        } catch (IOException e2) {
            e = e2;
            inputStream = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Representation<byte[]> fetchBinary(URL url, int i, int i2) {
        return fetch(url, i, i2, new RepresentationFactory() { // from class: sg1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.jupnp.http.HttpFetch.RepresentationFactory
            public final Representation createRepresentation(URLConnection uRLConnection, InputStream inputStream) {
                return HttpFetch.b(uRLConnection, inputStream);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Representation<String> fetchString(URL url, int i, int i2) {
        return fetch(url, i, i2, new RepresentationFactory() { // from class: tg1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // org.jupnp.http.HttpFetch.RepresentationFactory
            public final Representation createRepresentation(URLConnection uRLConnection, InputStream inputStream) {
                return HttpFetch.a(uRLConnection, inputStream);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void validate(URL url) throws Throwable {
        fetch(url, "HEAD", 500, 500, new RepresentationFactory() { // from class: rg1
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
