package com.thegrizzlylabs.sardineandroid.model;

import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
@Namespace(prefix = SardineUtil.DEFAULT_NAMESPACE_PREFIX, reference = SardineUtil.DEFAULT_NAMESPACE_URI)
@Root
public class Principal {

    @Element(required = false)
    private All all;

    @Element(required = false)
    private Authenticated authenticated;

    @Element(required = false)
    private String href;

    @Element(required = false)
    private Property property;

    @Element(required = false)
    private Self self;

    @Element(required = false)
    private Unauthenticated unauthenticated;

    public All getAll() {
        return this.all;
    }

    public Authenticated getAuthenticated() {
        return this.authenticated;
    }

    public String getHref() {
        return this.href;
    }

    public Property getProperty() {
        return this.property;
    }

    public Self getSelf() {
        return this.self;
    }

    public Unauthenticated getUnauthenticated() {
        return this.unauthenticated;
    }

    public void setAll(All all) {
        this.all = all;
    }

    public void setAuthenticated(Authenticated authenticated) {
        this.authenticated = authenticated;
    }

    public void setHref(String str) {
        this.href = str;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public void setSelf(Self self) {
        this.self = self;
    }

    public void setUnauthenticated(Unauthenticated unauthenticated) {
        this.unauthenticated = unauthenticated;
    }
}
