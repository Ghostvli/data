package org.mozilla.javascript.commonjs.module.provider;

import java.io.Reader;
import java.io.Serializable;
import java.net.URI;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ModuleSource implements Serializable {
    private static final long serialVersionUID = 1;
    private final URI base;
    private final Reader reader;
    private final Object securityDomain;
    private final URI uri;
    private final Object validator;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ModuleSource(Reader reader, Object obj, URI uri, URI uri2, Object obj2) {
        this.reader = reader;
        this.securityDomain = obj;
        this.uri = uri;
        this.base = uri2;
        this.validator = obj2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public URI getBase() {
        return this.base;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Reader getReader() {
        return this.reader;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object getSecurityDomain() {
        return this.securityDomain;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public URI getUri() {
        return this.uri;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object getValidator() {
        return this.validator;
    }
}
