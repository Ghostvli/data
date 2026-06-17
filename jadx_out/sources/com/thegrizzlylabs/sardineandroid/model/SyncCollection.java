package com.thegrizzlylabs.sardineandroid.model;

import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
@Namespace(prefix = SardineUtil.DEFAULT_NAMESPACE_PREFIX, reference = SardineUtil.DEFAULT_NAMESPACE_URI)
@Root
public class SyncCollection {
    protected Limit limit;
    protected Prop prop;
    protected String syncLevel;
    protected String syncToken;

    public Limit getLimit() {
        return this.limit;
    }

    public Prop getProp() {
        return this.prop;
    }

    public String getSyncLevel() {
        return this.syncLevel;
    }

    public String getSyncToken() {
        return this.syncToken;
    }

    public void setLimit(Limit limit) {
        this.limit = limit;
    }

    public void setProp(Prop prop) {
        this.prop = prop;
    }

    public void setSyncLevel(String str) {
        this.syncLevel = str;
    }

    public void setSyncToken(String str) {
        this.syncToken = str;
    }
}
