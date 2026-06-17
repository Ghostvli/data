package org.jupnp.model.message;

import defpackage.j02;
import defpackage.n02;
import defpackage.wg1;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.charset.UnsupportedCharsetException;
import org.jupnp.model.message.UpnpOperation;
import org.jupnp.model.message.header.ContentTypeHeader;
import org.jupnp.model.message.header.UpnpHeader;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class UpnpMessage<O extends UpnpOperation> {
    private static final j02 LOGGER = n02.k(UpnpMessage.class);
    private Object body;
    private BodyType bodyType;
    private UpnpHeaders headers;
    private O operation;
    private int udaMajorVersion;
    private int udaMinorVersion;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum BodyType {
        STRING,
        BYTES
    }

    public UpnpMessage(UpnpMessage<O> upnpMessage) {
        this.udaMajorVersion = 1;
        this.udaMinorVersion = 0;
        this.headers = new UpnpHeaders();
        this.bodyType = BodyType.STRING;
        this.operation = (O) upnpMessage.getOperation();
        this.headers = upnpMessage.getHeaders();
        this.body = upnpMessage.getBody();
        this.bodyType = upnpMessage.getBodyType();
        this.udaMajorVersion = upnpMessage.getUdaMajorVersion();
        this.udaMinorVersion = upnpMessage.getUdaMinorVersion();
    }

    public Object getBody() {
        return this.body;
    }

    public byte[] getBodyBytes() {
        try {
            if (hasBody()) {
                return getBodyType().equals(BodyType.STRING) ? getBodyString().getBytes(getContentTypeCharset()) : (byte[]) getBody();
            }
            return null;
        } catch (Exception e) {
            wg1.a(e);
            return null;
        }
    }

    public String getBodyString() {
        try {
            if (!hasBody()) {
                return null;
            }
            if (!getBodyType().equals(BodyType.STRING)) {
                return new String((byte[]) getBody(), getContentTypeCharset());
            }
            String str = (String) getBody();
            return str.charAt(0) == 65279 ? str.substring(1) : str;
        } catch (Exception e) {
            wg1.a(e);
            return null;
        }
    }

    public BodyType getBodyType() {
        return this.bodyType;
    }

    public Charset getContentTypeCharset() {
        ContentTypeHeader contentTypeHeader = getContentTypeHeader();
        if (contentTypeHeader == null) {
            return StandardCharsets.UTF_8;
        }
        String str = contentTypeHeader.getValue().getParameters().get("charset");
        if (str == null) {
            return StandardCharsets.UTF_8;
        }
        try {
            return Charset.forName(str);
        } catch (UnsupportedCharsetException e) {
            LOGGER.m("UpnpMessage has unsupported charset '{}' using UTF-8 instead", str, e);
            return StandardCharsets.UTF_8;
        }
    }

    public ContentTypeHeader getContentTypeHeader() {
        return (ContentTypeHeader) getHeaders().getFirstHeader(UpnpHeader.Type.CONTENT_TYPE, ContentTypeHeader.class);
    }

    public UpnpHeaders getHeaders() {
        return this.headers;
    }

    public O getOperation() {
        return this.operation;
    }

    public int getUdaMajorVersion() {
        return this.udaMajorVersion;
    }

    public int getUdaMinorVersion() {
        return this.udaMinorVersion;
    }

    public boolean hasBody() {
        return getBody() != null;
    }

    public boolean hasHostHeader() {
        return getHeaders().getFirstHeader(UpnpHeader.Type.HOST) != null;
    }

    public boolean isBodyNonEmptyString() {
        return hasBody() && getBodyType().equals(BodyType.STRING) && !getBodyString().isEmpty();
    }

    public boolean isContentTypeMissingOrText() {
        ContentTypeHeader contentTypeHeader = getContentTypeHeader();
        return contentTypeHeader == null || contentTypeHeader.isText();
    }

    public boolean isContentTypeText() {
        ContentTypeHeader contentTypeHeader = getContentTypeHeader();
        return contentTypeHeader != null && contentTypeHeader.isText();
    }

    public boolean isContentTypeTextUDA() {
        ContentTypeHeader contentTypeHeader = getContentTypeHeader();
        return contentTypeHeader != null && contentTypeHeader.isUDACompliantXML();
    }

    public void setBody(String str) {
        this.bodyType = BodyType.STRING;
        this.body = str;
    }

    public void setBodyCharacters(byte[] bArr) {
        setBody(BodyType.STRING, new String(bArr, getContentTypeCharset()));
    }

    public void setBodyType(BodyType bodyType) {
        this.bodyType = bodyType;
    }

    public void setHeaders(UpnpHeaders upnpHeaders) {
        this.headers = upnpHeaders;
    }

    public void setUdaMajorVersion(int i) {
        this.udaMajorVersion = i;
    }

    public void setUdaMinorVersion(int i) {
        this.udaMinorVersion = i;
    }

    public String toString() {
        return "(" + getClass().getSimpleName() + ") " + getOperation().toString();
    }

    public void setBody(BodyType bodyType, Object obj) {
        this.bodyType = bodyType;
        this.body = obj;
    }

    public UpnpMessage(O o) {
        this.udaMajorVersion = 1;
        this.udaMinorVersion = 0;
        this.headers = new UpnpHeaders();
        this.bodyType = BodyType.STRING;
        this.operation = o;
    }

    public UpnpMessage(O o, BodyType bodyType, Object obj) {
        this.udaMajorVersion = 1;
        this.udaMinorVersion = 0;
        this.headers = new UpnpHeaders();
        BodyType bodyType2 = BodyType.STRING;
        this.operation = o;
        this.bodyType = bodyType;
        this.body = obj;
    }
}
