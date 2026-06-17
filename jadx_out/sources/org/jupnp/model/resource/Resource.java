package org.jupnp.model.resource;

import defpackage.jl;
import defpackage.wg1;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import org.jupnp.model.ExpirationDetails;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Resource<M> {
    private M model;
    private URI pathQuery;

    public Resource(URI uri, M m) {
        try {
            this.pathQuery = new URI(null, null, uri.getPath(), uri.getQuery(), null);
            this.model = m;
            if (m != null) {
                return;
            }
            jl.a("Model instance must not be null");
            throw null;
        } catch (URISyntaxException e) {
            wg1.a(e);
            throw null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && getPathQuery().equals(((Resource) obj).getPathQuery());
    }

    public M getModel() {
        return this.model;
    }

    public URI getPathQuery() {
        return this.pathQuery;
    }

    public int hashCode() {
        return getPathQuery().hashCode();
    }

    public void maintain(List<Runnable> list, ExpirationDetails expirationDetails) {
    }

    public boolean matches(URI uri) {
        return uri.equals(getPathQuery());
    }

    public void shutdown() {
    }

    public String toString() {
        return "(" + getClass().getSimpleName() + ") URI: " + String.valueOf(getPathQuery());
    }
}
