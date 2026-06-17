package org.jupnp.transport.impl;

import defpackage.ib3;
import defpackage.j02;
import defpackage.n02;
import defpackage.wo3;
import java.io.IOException;
import java.net.URI;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jupnp.model.message.Connection;
import org.jupnp.model.message.StreamRequestMessage;
import org.jupnp.model.message.StreamResponseMessage;
import org.jupnp.model.message.UpnpHeaders;
import org.jupnp.model.message.UpnpMessage;
import org.jupnp.model.message.UpnpRequest;
import org.jupnp.protocol.ProtocolFactory;
import org.jupnp.transport.spi.UpnpStream;
import org.jupnp.util.io.IO;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ServletUpnpStream extends UpnpStream {
    protected final j02 logger;
    protected StreamResponseMessage responseMessage;

    public ServletUpnpStream(ProtocolFactory protocolFactory) {
        super(protocolFactory);
        this.logger = n02.k(ServletUpnpStream.class);
    }

    public abstract void complete();

    public abstract Connection createConnection();

    public abstract HttpServletRequest getRequest();

    public abstract HttpServletResponse getResponse();

    public StreamRequestMessage readRequestMessage() throws IOException {
        String method = getRequest().getMethod();
        String requestURI = getRequest().getRequestURI();
        this.logger.i("Processing HTTP request: {} {} ", method, requestURI);
        try {
            StreamRequestMessage streamRequestMessage = new StreamRequestMessage(UpnpRequest.Method.getByHttpName(method), URI.create(requestURI));
            if (((UpnpRequest) streamRequestMessage.getOperation()).getMethod().equals(UpnpRequest.Method.UNKNOWN)) {
                ib3.a("Method not supported: ", method);
                return null;
            }
            streamRequestMessage.setConnection(createConnection());
            UpnpHeaders upnpHeaders = new UpnpHeaders();
            Enumeration headerNames = getRequest().getHeaderNames();
            while (headerNames.hasMoreElements()) {
                String str = (String) headerNames.nextElement();
                Enumeration headers = getRequest().getHeaders(str);
                while (headers.hasMoreElements()) {
                    upnpHeaders.add(str, (String) headers.nextElement());
                }
            }
            streamRequestMessage.setHeaders(upnpHeaders);
            ServletInputStream inputStream = getRequest().getInputStream();
            try {
                byte[] allBytes = UpnpRequest.Method.GET.getHttpName().equals(method) ? new byte[0] : IO.readAllBytes(inputStream);
                if (inputStream != null) {
                    inputStream.close();
                }
                this.logger.h("Reading request body bytes: {}", Integer.valueOf(allBytes.length));
                if (allBytes.length > 0 && streamRequestMessage.isContentTypeMissingOrText()) {
                    this.logger.y("Request contains textual entity body, converting then setting string on message");
                    streamRequestMessage.setBodyCharacters(allBytes);
                    return streamRequestMessage;
                }
                int length = allBytes.length;
                j02 j02Var = this.logger;
                if (length <= 0) {
                    j02Var.y("Request did not contain entity body");
                    return streamRequestMessage;
                }
                j02Var.y("Request contains binary entity body, setting bytes on message");
                streamRequestMessage.setBody(UpnpMessage.BodyType.BYTES, allBytes);
                return streamRequestMessage;
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (IllegalArgumentException e) {
            wo3.a("Invalid request URI: ", requestURI, e);
            return null;
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                StreamRequestMessage requestMessage = readRequestMessage();
                this.logger.h("Processing new request message: {}", requestMessage);
                StreamResponseMessage streamResponseMessageProcess = process(requestMessage);
                this.responseMessage = streamResponseMessageProcess;
                j02 j02Var = this.logger;
                if (streamResponseMessageProcess != null) {
                    j02Var.h("Preparing HTTP response message: {}", streamResponseMessageProcess);
                    writeResponseMessage(this.responseMessage);
                } else {
                    j02Var.h("Sending HTTP response status: {}", 404);
                    getResponse().setStatus(404);
                }
                complete();
            } catch (Exception e) {
                this.logger.t("Exception occurred during UPnP stream processing", e);
                boolean zIsCommitted = getResponse().isCommitted();
                j02 j02Var2 = this.logger;
                if (zIsCommitted) {
                    j02Var2.info("Could not return INTERNAL SERVER ERROR to client, response was already committed");
                } else {
                    j02Var2.y("Response hasn't been committed, returning INTERNAL SERVER ERROR to client");
                    getResponse().setStatus(500);
                }
                responseException(e);
                complete();
            }
        } catch (Throwable th) {
            complete();
            throw th;
        }
    }

    public void writeResponseMessage(StreamResponseMessage streamResponseMessage) {
        this.logger.h("Sending HTTP response status: {}", Integer.valueOf(streamResponseMessage.getOperation().getStatusCode()));
        getResponse().setStatus(streamResponseMessage.getOperation().getStatusCode());
        for (Map.Entry<String, List<String>> entry : streamResponseMessage.getHeaders().entrySet()) {
            Iterator<String> it = entry.getValue().iterator();
            while (it.hasNext()) {
                getResponse().addHeader(entry.getKey(), it.next());
            }
        }
        getResponse().setDateHeader("Date", System.currentTimeMillis());
        byte[] bodyBytes = streamResponseMessage.hasBody() ? streamResponseMessage.getBodyBytes() : null;
        int length = bodyBytes != null ? bodyBytes.length : -1;
        if (length > 0) {
            getResponse().setContentLength(length);
            this.logger.y("Response message has body, writing bytes to stream...");
            getResponse().getOutputStream().write(bodyBytes);
        }
    }
}
