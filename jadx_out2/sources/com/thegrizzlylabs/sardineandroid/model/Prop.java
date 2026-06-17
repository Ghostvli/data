package com.thegrizzlylabs.sardineandroid.model;

import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
@Namespace(prefix = SardineUtil.DEFAULT_NAMESPACE_PREFIX, reference = SardineUtil.DEFAULT_NAMESPACE_URI)
@Root(strict = false)
public class Prop implements EntityWithAnyElement {

    @Element(required = false)
    protected Acl acl;
    protected List<org.w3c.dom.Element> any;

    @Element(required = false)
    protected String creationdate;

    @Element(name = "current-user-privilege-set")
    private CurrentUserPrivilegeSet currentUserPrivilegeSet;

    @Element(required = false)
    protected String displayname;

    @Element(required = false)
    protected String getcontentlanguage;

    @Element(required = false)
    protected String getcontentlength;

    @Element(required = false)
    protected String getcontenttype;

    @Element(required = false)
    protected String getetag;

    @Element(required = false)
    protected String getlastmodified;

    @Element(required = false)
    protected Group group;

    @Element(required = false)
    protected Lockdiscovery lockdiscovery;

    @Element(required = false)
    protected Owner owner;

    @Element(name = "principal-collection-set", required = false)
    private PrincipalCollectionSet principalCollectionSet;

    @Element(name = "current-user-principal", required = false)
    private PrincipalURL principalURL;

    @Element(name = "quota-available-bytes", required = false)
    protected QuotaAvailableBytes quotaAvailableBytes;

    @Element(name = "quota-used-bytes", required = false)
    protected QuotaUsedBytes quotaUsedBytes;

    @Element(required = false)
    protected Resourcetype resourcetype;

    @Element(required = false)
    protected Supportedlock supportedlock;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Acl getAcl() {
        return this.acl;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.thegrizzlylabs.sardineandroid.model.EntityWithAnyElement
    public List<org.w3c.dom.Element> getAny() {
        if (this.any == null) {
            this.any = new ArrayList();
        }
        return this.any;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getCreationdate() {
        return this.creationdate;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public CurrentUserPrivilegeSet getCurrentUserPrivilegeSet() {
        return this.currentUserPrivilegeSet;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getDisplayname() {
        return this.displayname;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getGetcontentlanguage() {
        return this.getcontentlanguage;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getGetcontentlength() {
        return this.getcontentlength;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getGetcontenttype() {
        return this.getcontenttype;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getGetetag() {
        return this.getetag;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String getGetlastmodified() {
        return this.getlastmodified;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Group getGroup() {
        return this.group;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Lockdiscovery getLockdiscovery() {
        return this.lockdiscovery;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Owner getOwner() {
        return this.owner;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PrincipalCollectionSet getPrincipalCollectionSet() {
        return this.principalCollectionSet;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PrincipalURL getPrincipalURL() {
        return this.principalURL;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public QuotaAvailableBytes getQuotaAvailableBytes() {
        return this.quotaAvailableBytes;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public QuotaUsedBytes getQuotaUsedBytes() {
        return this.quotaUsedBytes;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Resourcetype getResourcetype() {
        return this.resourcetype;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Supportedlock getSupportedlock() {
        return this.supportedlock;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setAcl(Acl acl) {
        this.acl = acl;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCreationdate(String str) {
        this.creationdate = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setCurrentUserPrivilegeSet(CurrentUserPrivilegeSet currentUserPrivilegeSet) {
        this.currentUserPrivilegeSet = currentUserPrivilegeSet;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setDisplayname(String str) {
        this.displayname = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setGetcontentlanguage(String str) {
        this.getcontentlanguage = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setGetcontentlength(String str) {
        this.getcontentlength = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setGetcontenttype(String str) {
        this.getcontenttype = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setGetetag(String str) {
        this.getetag = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setGetlastmodified(String str) {
        this.getlastmodified = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setGroup(Group group) {
        this.group = group;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setLockdiscovery(Lockdiscovery lockdiscovery) {
        this.lockdiscovery = lockdiscovery;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setPrincipalCollectionSet(PrincipalCollectionSet principalCollectionSet) {
        this.principalCollectionSet = principalCollectionSet;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setPrincipalURL(PrincipalURL principalURL) {
        this.principalURL = principalURL;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setQuotaAvailableBytes(QuotaAvailableBytes quotaAvailableBytes) {
        this.quotaAvailableBytes = quotaAvailableBytes;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setQuotaUsedBytes(QuotaUsedBytes quotaUsedBytes) {
        this.quotaUsedBytes = quotaUsedBytes;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setResourcetype(Resourcetype resourcetype) {
        this.resourcetype = resourcetype;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setSupportedlock(Supportedlock supportedlock) {
        this.supportedlock = supportedlock;
    }
}
