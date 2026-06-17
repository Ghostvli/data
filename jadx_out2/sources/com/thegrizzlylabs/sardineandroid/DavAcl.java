package com.thegrizzlylabs.sardineandroid;

import com.thegrizzlylabs.sardineandroid.model.Ace;
import com.thegrizzlylabs.sardineandroid.model.Acl;
import com.thegrizzlylabs.sardineandroid.model.Group;
import com.thegrizzlylabs.sardineandroid.model.Owner;
import com.thegrizzlylabs.sardineandroid.model.Propstat;
import com.thegrizzlylabs.sardineandroid.model.Response;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DavAcl {
    private List<DavAce> aces;
    private final String group;
    private final String owner;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DavAcl(Response response) {
        this.owner = getOwner(response);
        this.group = getGroup(response);
        this.aces = getAces(response);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private List<DavAce> getAces(Response response) {
        ArrayList arrayList = new ArrayList();
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return null;
        }
        Iterator<Propstat> it = propstat.iterator();
        while (it.hasNext()) {
            Acl acl = it.next().getProp().getAcl();
            if (acl != null && acl.getAce() != null) {
                Iterator<Ace> it2 = acl.getAce().iterator();
                while (it2.hasNext()) {
                    arrayList.add(new DavAce(it2.next()));
                }
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String getGroup(Response response) {
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return null;
        }
        Iterator<Propstat> it = propstat.iterator();
        while (it.hasNext()) {
            Group group = it.next().getProp().getGroup();
            if (group != null && group.getHref() != null) {
                return group.getHref();
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String getOwner(Response response) {
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return null;
        }
        Iterator<Propstat> it = propstat.iterator();
        while (it.hasNext()) {
            Owner owner = it.next().getProp().getOwner();
            if (owner != null) {
                if (owner.getUnauthenticated() != null) {
                    return DavPrincipal.KEY_UNAUTHENTICATED;
                }
                if (owner.getHref() != null) {
                    return owner.getHref();
                }
            }
        }
        return null;
    }

    public String getGroup() {
        return this.group;
    }

    public String getOwner() {
        return this.owner;
    }

    public List<DavAce> getAces() {
        return this.aces;
    }
}
