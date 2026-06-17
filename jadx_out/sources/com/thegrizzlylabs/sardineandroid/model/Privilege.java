package com.thegrizzlylabs.sardineandroid.model;

import com.thegrizzlylabs.sardineandroid.DavPrincipal;
import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.ElementListUnion;
import org.simpleframework.xml.Namespace;
import org.simpleframework.xml.Root;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
@Namespace(prefix = SardineUtil.DEFAULT_NAMESPACE_PREFIX, reference = SardineUtil.DEFAULT_NAMESPACE_URI)
@Root(strict = false)
public class Privilege {

    @ElementListUnion({@ElementList(entry = "read", inline = true, type = Read.class), @ElementList(entry = "write", inline = true, type = Write.class), @ElementList(entry = "write-properties", inline = true, type = WriteProperties.class), @ElementList(entry = "write-content", inline = true, type = WriteContent.class), @ElementList(entry = "unlock", inline = true, type = Unlock.class), @ElementList(entry = "read-acl", inline = true, type = ReadAcl.class), @ElementList(entry = "write-acl", inline = true, type = WriteAcl.class), @ElementList(entry = "bind", inline = true, type = Bind.class), @ElementList(entry = "unbind", inline = true, type = UnBind.class), @ElementList(entry = "read-current-user-privilege-set", inline = true, type = ReadCurrentUserPrivilegeSet.class), @ElementList(entry = DavPrincipal.KEY_ALL, inline = true, type = All.class), @ElementList(entry = "write_acl", inline = true, type = WriteAcl.class), @ElementList(entry = "read_acl", inline = true, type = ReadAcl.class)})
    private List<SimplePrivilege> content;

    public List<SimplePrivilege> getContent() {
        if (this.content == null) {
            this.content = new ArrayList();
        }
        return this.content;
    }

    public void setContent(List<SimplePrivilege> list) {
        this.content = list;
    }
}
