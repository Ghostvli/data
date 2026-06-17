package com.thegrizzlylabs.sardineandroid.model;

import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
@Namespace(prefix = SardineUtil.DEFAULT_NAMESPACE_PREFIX, reference = SardineUtil.DEFAULT_NAMESPACE_URI)
@Root(strict = false)
public class Activelock {

    @Element
    private String depth;

    @Element
    private Lockscope lockscope;

    @Element(required = false)
    private Locktoken locktoken;

    @Element
    private Locktype locktype;

    @Element(required = false)
    private Owner owner;

    @Element(required = false)
    private String timeout;

    public String getDepth() {
        return this.depth;
    }

    public Lockscope getLockscope() {
        return this.lockscope;
    }

    public Locktoken getLocktoken() {
        return this.locktoken;
    }

    public Locktype getLocktype() {
        return this.locktype;
    }

    public Owner getOwner() {
        return this.owner;
    }

    public String getTimeout() {
        return this.timeout;
    }

    public void setDepth(String str) {
        this.depth = str;
    }

    public void setLockscope(Lockscope lockscope) {
        this.lockscope = lockscope;
    }

    public void setLocktoken(Locktoken locktoken) {
        this.locktoken = locktoken;
    }

    public void setLocktype(Locktype locktype) {
        this.locktype = locktype;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public void setTimeout(String str) {
        this.timeout = str;
    }
}
