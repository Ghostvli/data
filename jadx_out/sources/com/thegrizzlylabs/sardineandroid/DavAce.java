package com.thegrizzlylabs.sardineandroid;

import com.thegrizzlylabs.sardineandroid.DavPrincipal;
import com.thegrizzlylabs.sardineandroid.model.Ace;
import com.thegrizzlylabs.sardineandroid.model.All;
import com.thegrizzlylabs.sardineandroid.model.Authenticated;
import com.thegrizzlylabs.sardineandroid.model.Bind;
import com.thegrizzlylabs.sardineandroid.model.Deny;
import com.thegrizzlylabs.sardineandroid.model.Grant;
import com.thegrizzlylabs.sardineandroid.model.Principal;
import com.thegrizzlylabs.sardineandroid.model.Privilege;
import com.thegrizzlylabs.sardineandroid.model.Property;
import com.thegrizzlylabs.sardineandroid.model.Read;
import com.thegrizzlylabs.sardineandroid.model.ReadAcl;
import com.thegrizzlylabs.sardineandroid.model.ReadCurrentUserPrivilegeSet;
import com.thegrizzlylabs.sardineandroid.model.Self;
import com.thegrizzlylabs.sardineandroid.model.SimplePrivilege;
import com.thegrizzlylabs.sardineandroid.model.UnBind;
import com.thegrizzlylabs.sardineandroid.model.Unauthenticated;
import com.thegrizzlylabs.sardineandroid.model.Unlock;
import com.thegrizzlylabs.sardineandroid.model.Write;
import com.thegrizzlylabs.sardineandroid.model.WriteContent;
import com.thegrizzlylabs.sardineandroid.model.WriteProperties;
import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.simpleframework.xml.Root;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DavAce {
    private final List<String> denied;
    private final List<String> granted;
    private final String inherited;
    private final boolean isprotected;
    private final DavPrincipal principal;

    /* JADX INFO: renamed from: com.thegrizzlylabs.sardineandroid.DavAce$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$thegrizzlylabs$sardineandroid$DavPrincipal$PrincipalType;

        static {
            int[] iArr = new int[DavPrincipal.PrincipalType.values().length];
            $SwitchMap$com$thegrizzlylabs$sardineandroid$DavPrincipal$PrincipalType = iArr;
            try {
                iArr[DavPrincipal.PrincipalType.HREF.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$thegrizzlylabs$sardineandroid$DavPrincipal$PrincipalType[DavPrincipal.PrincipalType.PROPERTY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$thegrizzlylabs$sardineandroid$DavPrincipal$PrincipalType[DavPrincipal.PrincipalType.KEY.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public DavAce(Ace ace) {
        this.principal = new DavPrincipal(ace.getPrincipal());
        this.granted = new ArrayList();
        this.denied = new ArrayList();
        if (ace.getGrant() != null) {
            Iterator<Privilege> it = ace.getGrant().getPrivilege().iterator();
            while (it.hasNext()) {
                Iterator<SimplePrivilege> it2 = it.next().getContent().iterator();
                while (it2.hasNext()) {
                    this.granted.add(((Root) it2.next().getClass().getAnnotation(Root.class)).name());
                }
            }
        }
        if (ace.getDeny() != null) {
            Iterator<Privilege> it3 = ace.getDeny().getPrivilege().iterator();
            while (it3.hasNext()) {
                Iterator<SimplePrivilege> it4 = it3.next().getContent().iterator();
                while (it4.hasNext()) {
                    this.denied.add(((Root) it4.next().getClass().getAnnotation(Root.class)).name());
                }
            }
        }
        if (ace.getInherited() != null) {
            this.inherited = ace.getInherited().getHref();
        } else {
            this.inherited = null;
        }
        this.isprotected = ace.getProtected() != null;
    }

    private List<Privilege> toPrivilege(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            Privilege privilege = new Privilege();
            if (DavPrincipal.KEY_ALL.equals(str)) {
                privilege.getContent().add(new All());
            } else if ("bind".equals(str)) {
                privilege.getContent().add(new Bind());
            } else if ("read".equals(str)) {
                privilege.getContent().add(new Read());
            } else if ("read-acl".equals(str)) {
                privilege.getContent().add(new ReadAcl());
            } else if ("read-current-user-privilege-set".equals(str)) {
                privilege.getContent().add(new ReadCurrentUserPrivilegeSet());
            } else if ("unbind".equals(str)) {
                privilege.getContent().add(new UnBind());
            } else if ("unlock".equals(str)) {
                privilege.getContent().add(new Unlock());
            } else if ("write".equals(str)) {
                privilege.getContent().add(new Write());
            } else if ("write-content".equals(str)) {
                privilege.getContent().add(new WriteContent());
            } else if ("write-properties".equals(str)) {
                privilege.getContent().add(new WriteProperties());
            }
            arrayList.add(privilege);
        }
        return arrayList;
    }

    public List<String> getDenied() {
        return this.denied;
    }

    public List<String> getGranted() {
        return this.granted;
    }

    public String getInherited() {
        return this.inherited;
    }

    public DavPrincipal getPrincipal() {
        return this.principal;
    }

    public boolean isProtected() {
        return this.isprotected;
    }

    public Ace toModel() {
        Ace ace = new Ace();
        Principal principal = new Principal();
        int i = AnonymousClass1.$SwitchMap$com$thegrizzlylabs$sardineandroid$DavPrincipal$PrincipalType[this.principal.getPrincipalType().ordinal()];
        if (i == 1) {
            principal.setHref(this.principal.getValue());
        } else if (i == 2) {
            principal.setProperty(new Property());
            principal.getProperty().setProperty(SardineUtil.createElement(this.principal.getProperty()));
        } else if (i == 3) {
            if (DavPrincipal.KEY_ALL.equals(this.principal.getValue())) {
                principal.setAll(new All());
            } else if (DavPrincipal.KEY_AUTHENTICATED.equals(this.principal.getValue())) {
                principal.setAuthenticated(new Authenticated());
            } else if (DavPrincipal.KEY_UNAUTHENTICATED.equals(this.principal.getValue())) {
                principal.setUnauthenticated(new Unauthenticated());
            } else if (DavPrincipal.KEY_SELF.equals(this.principal.getValue())) {
                principal.setSelf(new Self());
            }
        }
        ace.setPrincipal(principal);
        List<String> list = this.granted;
        if (list != null && list.size() > 0) {
            ace.setGrant(new Grant());
            ace.getGrant().setPrivilege(toPrivilege(this.granted));
        }
        List<String> list2 = this.denied;
        if (list2 != null && list2.size() > 0) {
            ace.setDeny(new Deny());
            ace.getDeny().setPrivilege(toPrivilege(this.denied));
        }
        return ace;
    }

    public DavAce(DavPrincipal davPrincipal) {
        this.principal = davPrincipal;
        this.granted = new ArrayList();
        this.denied = new ArrayList();
        this.inherited = null;
        this.isprotected = false;
    }
}
