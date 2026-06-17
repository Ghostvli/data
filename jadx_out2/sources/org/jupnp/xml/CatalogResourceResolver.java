package org.jupnp.xml;

import defpackage.j02;
import defpackage.n02;
import defpackage.wg1;
import java.io.InputStream;
import java.io.Reader;
import java.net.URI;
import java.net.URL;
import java.util.Map;
import org.w3c.dom.ls.LSInput;
import org.w3c.dom.ls.LSResourceResolver;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class CatalogResourceResolver implements LSResourceResolver {
    private final Map<URI, URL> catalog;
    private final j02 logger = n02.k(CatalogResourceResolver.class);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Input implements LSInput {
        InputStream in;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Input(InputStream inputStream) {
            this.in = inputStream;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.w3c.dom.ls.LSInput
        public String getBaseURI() {
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.w3c.dom.ls.LSInput
        public InputStream getByteStream() {
            return this.in;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.w3c.dom.ls.LSInput
        public boolean getCertifiedText() {
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.w3c.dom.ls.LSInput
        public Reader getCharacterStream() {
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.w3c.dom.ls.LSInput
        public String getEncoding() {
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.w3c.dom.ls.LSInput
        public String getPublicId() {
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.w3c.dom.ls.LSInput
        public String getStringData() {
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.w3c.dom.ls.LSInput
        public String getSystemId() {
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.w3c.dom.ls.LSInput
        public void setBaseURI(String str) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.w3c.dom.ls.LSInput
        public void setByteStream(InputStream inputStream) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.w3c.dom.ls.LSInput
        public void setCertifiedText(boolean z) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.w3c.dom.ls.LSInput
        public void setCharacterStream(Reader reader) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.w3c.dom.ls.LSInput
        public void setEncoding(String str) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.w3c.dom.ls.LSInput
        public void setPublicId(String str) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.w3c.dom.ls.LSInput
        public void setStringData(String str) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // org.w3c.dom.ls.LSInput
        public void setSystemId(String str) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CatalogResourceResolver(Map<URI, URL> map) {
        this.catalog = map;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.w3c.dom.ls.LSResourceResolver
    public LSInput resolveResource(String str, String str2, String str3, String str4, String str5) {
        this.logger.h("Trying to resolve system identifier URI in catalog: {}", str4);
        URL url = this.catalog.get(URI.create(str4));
        j02 j02Var = this.logger;
        if (url == null) {
            j02Var.c("System identifier not found in catalog, continuing with default resolution (this most likely means remote HTTP request!): {}", str4);
            return null;
        }
        j02Var.h("Loading catalog resource: {}", url);
        try {
            Input input = new Input(url.openStream());
            input.setBaseURI(str5);
            input.setSystemId(str4);
            input.setPublicId(str3);
            return input;
        } catch (Exception e) {
            wg1.a(e);
            return null;
        }
    }
}
