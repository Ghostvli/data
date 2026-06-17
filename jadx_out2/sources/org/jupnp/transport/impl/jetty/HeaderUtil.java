package org.jupnp.transport.impl.jetty;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.client.api.ContentProvider;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.api.Response;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpFields;
import org.jupnp.http.Headers;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class HeaderUtil {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private HeaderUtil() {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void add(Request request, Headers headers) {
        HttpFields headers2 = request.getHeaders();
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                headers2.add(entry.getKey(), it.next());
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Headers get(Response response) {
        Headers headers = new Headers();
        for (HttpField httpField : response.getHeaders()) {
            headers.add(httpField.getName(), httpField.getValue());
        }
        return headers;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] getBytes(Request request) {
        ContentProvider<ByteBuffer> content = request.getContent();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        for (ByteBuffer byteBuffer : content) {
            int iCapacity = byteBuffer.capacity();
            byte[] bArr = new byte[iCapacity];
            byteBuffer.get(bArr);
            byteArrayOutputStream.write(bArr, 0, iCapacity);
        }
        return byteArrayOutputStream.toByteArray();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String getContent(Request request) {
        ContentProvider<ByteBuffer> content = request.getContent();
        StringBuilder sb = new StringBuilder();
        for (ByteBuffer byteBuffer : content) {
            byte[] bArr = new byte[byteBuffer.capacity()];
            byteBuffer.get(bArr);
            sb.append(new String(bArr, StandardCharsets.UTF_8));
        }
        return sb.toString();
    }

    public static Headers get(org.eclipse.jetty.server.Request request) {
        Headers headers = new Headers();
        for (HttpField httpField : request.getHttpFields()) {
            headers.add(httpField.getName(), httpField.getValue());
        }
        return headers;
    }

    public static byte[] getBytes(org.eclipse.jetty.server.Request request) throws IOException {
        ServletInputStream inputStream = request.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[1024];
        while (true) {
            int i = inputStream.read(bArr);
            if (i > 0) {
                byteArrayOutputStream.write(bArr, 0, i);
            } else {
                return byteArrayOutputStream.toByteArray();
            }
        }
    }

    public static void add(HttpServletResponse httpServletResponse, Headers headers) {
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                httpServletResponse.addHeader(entry.getKey(), it.next());
            }
        }
    }
}
