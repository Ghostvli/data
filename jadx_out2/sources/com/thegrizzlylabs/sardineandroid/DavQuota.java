package com.thegrizzlylabs.sardineandroid;

import com.thegrizzlylabs.sardineandroid.model.Prop;
import com.thegrizzlylabs.sardineandroid.model.Propstat;
import com.thegrizzlylabs.sardineandroid.model.Response;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DavQuota {
    private final long quotaAvailableBytes;
    private final long quotaUsedBytes;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DavQuota(Response response) {
        this.quotaAvailableBytes = getAvailable(response);
        this.quotaUsedBytes = getUsed(response);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private long getAvailable(Response response) {
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return Long.MAX_VALUE;
        }
        Iterator<Propstat> it = propstat.iterator();
        while (it.hasNext()) {
            Prop prop = it.next().getProp();
            if (prop != null && prop.getQuotaAvailableBytes() != null && !prop.getQuotaAvailableBytes().getContent().isEmpty()) {
                return Long.valueOf(prop.getQuotaAvailableBytes().getContent().get(0)).longValue();
            }
        }
        return Long.MAX_VALUE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private long getUsed(Response response) {
        List<Propstat> propstat = response.getPropstat();
        if (propstat.isEmpty()) {
            return 0L;
        }
        Iterator<Propstat> it = propstat.iterator();
        while (it.hasNext()) {
            Prop prop = it.next().getProp();
            if (prop != null && prop.getQuotaUsedBytes() != null && !prop.getQuotaUsedBytes().getContent().isEmpty()) {
                return Long.valueOf(prop.getQuotaUsedBytes().getContent().get(0)).longValue();
            }
        }
        return 0L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getQuotaAvailableBytes() {
        return this.quotaAvailableBytes;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getQuotaUsedBytes() {
        return this.quotaUsedBytes;
    }
}
