package org.jupnp.transport.impl;

import com.sun.net.httpserver.HttpExchange;
import defpackage.j02;
import defpackage.n02;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Locale;
import java.util.Map;
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
public abstract class HttpExchangeUpnpStream extends UpnpStream {
    private HttpExchange httpExchange;
    private final j02 logger;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public HttpExchangeUpnpStream(ProtocolFactory protocolFactory, HttpExchange httpExchange) {
        super(protocolFactory);
        this.logger = n02.l(HttpExchangeUpnpStream.class.getName());
        this.httpExchange = httpExchange;
    }

    public abstract Connection createConnection();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public HttpExchange getHttpExchange() {
        return this.httpExchange;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // java.lang.Runnable
    public void run() {
        try {
            this.logger.i("Processing HTTP request: {} {}", getHttpExchange().getRequestMethod(), getHttpExchange().getRequestURI());
            StreamRequestMessage streamRequestMessage = new StreamRequestMessage(UpnpRequest.Method.getByHttpName(getHttpExchange().getRequestMethod()), getHttpExchange().getRequestURI());
            if (((UpnpRequest) streamRequestMessage.getOperation()).getMethod().equals(UpnpRequest.Method.UNKNOWN)) {
                this.logger.h("Method not supported by UPnP stack: {}", getHttpExchange().getRequestMethod());
                throw new RuntimeException("Method not supported: " + getHttpExchange().getRequestMethod());
            }
            ((UpnpRequest) streamRequestMessage.getOperation()).setHttpMinorVersion(getHttpExchange().getProtocol().toUpperCase(Locale.ROOT).equals("HTTP/1.1") ? 1 : 0);
            this.logger.h("Created new request message: {}", streamRequestMessage);
            streamRequestMessage.setConnection(createConnection());
            streamRequestMessage.setHeaders(new UpnpHeaders((Map<String, List<String>>) getHttpExchange().getRequestHeaders()));
            InputStream requestBody = getHttpExchange().getRequestBody();
            try {
                byte[] allBytes = IO.readAllBytes(requestBody);
                if (requestBody != null) {
                    requestBody.close();
                }
                this.logger.h("Reading request body bytes: {}", Integer.valueOf(allBytes.length));
                if (allBytes.length <= 0 || !streamRequestMessage.isContentTypeMissingOrText()) {
                    int length = allBytes.length;
                    j02 j02Var = this.logger;
                    if (length > 0) {
                        j02Var.y("Request contains binary entity body, setting bytes on message");
                        streamRequestMessage.setBody(UpnpMessage.BodyType.BYTES, allBytes);
                    } else {
                        j02Var.y("Request did not contain entity body");
                    }
                } else {
                    this.logger.y("Request contains textual entity body, converting then setting string on message");
                    streamRequestMessage.setBodyCharacters(allBytes);
                }
                StreamResponseMessage streamResponseMessageProcess = process(streamRequestMessage);
                j02 j02Var2 = this.logger;
                if (streamResponseMessageProcess != null) {
                    j02Var2.h("Preparing HTTP response message: {}", streamResponseMessageProcess);
                    getHttpExchange().getResponseHeaders().putAll(streamResponseMessageProcess.getHeaders());
                    byte[] bodyBytes = streamResponseMessageProcess.hasBody() ? streamResponseMessageProcess.getBodyBytes() : null;
                    int length2 = bodyBytes != null ? bodyBytes.length : -1;
                    this.logger.i("Sending HTTP response message: {} with content length: {}", streamResponseMessageProcess, Integer.valueOf(length2));
                    getHttpExchange().sendResponseHeaders(streamResponseMessageProcess.getOperation().getStatusCode(), length2);
                    if (length2 > 0) {
                        this.logger.y("Response message has body, writing bytes to stream...");
                        OutputStream responseBody = getHttpExchange().getResponseBody();
                        try {
                            responseBody.write(bodyBytes);
                            responseBody.flush();
                            responseBody.close();
                        } finally {
                        }
                    }
                } else {
                    j02Var2.h("Sending HTTP response status: {}", 404);
                    getHttpExchange().sendResponseHeaders(404, -1L);
                }
                responseSent(streamResponseMessageProcess);
            } finally {
            }
        } catch (Exception e) {
            this.logger.v("Exception occurred during UPnP stream processing", e);
            try {
                this.httpExchange.sendResponseHeaders(500, -1L);
            } catch (IOException e2) {
                this.logger.m("Couldn't send error response: {}", e2.getMessage(), e2);
            }
            responseException(e);
        }
    }
}
