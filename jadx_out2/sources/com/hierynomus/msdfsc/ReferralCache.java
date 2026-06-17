package com.hierynomus.msdfsc;

import com.hierynomus.msdfsc.messages.DFSReferral;
import com.hierynomus.msdfsc.messages.SMB2GetDFSReferralResponse;
import defpackage.e04;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ReferralCache {
    private ReferralCacheNode cacheRoot = new ReferralCacheNode("<root>");

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class ReferralCacheEntry {
        private final String dfsPathPrefix;
        private final long expires;
        private final boolean interlink;
        private final DFSReferral.ServerType rootOrLink;
        private final boolean targetFailback;
        private int targetHint = 0;
        private final List<TargetSetEntry> targetList;
        private final int ttl;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public ReferralCacheEntry(SMB2GetDFSReferralResponse sMB2GetDFSReferralResponse, DomainCache domainCache) {
            List<DFSReferral> referralEntries = sMB2GetDFSReferralResponse.getReferralEntries();
            Iterator<DFSReferral> it = referralEntries.iterator();
            while (it.hasNext()) {
                if (it.next().getPath() == null) {
                    e04.a("Path cannot be null for a ReferralCacheEntry?");
                    throw null;
                }
            }
            DFSReferral dFSReferral = referralEntries.get(0);
            this.dfsPathPrefix = dFSReferral.getDfsPath();
            this.rootOrLink = dFSReferral.getServerType();
            boolean z = sMB2GetDFSReferralResponse.getReferralHeaderFlags().contains(SMB2GetDFSReferralResponse.ReferralHeaderFlags.ReferralServers) && !sMB2GetDFSReferralResponse.getReferralHeaderFlags().contains(SMB2GetDFSReferralResponse.ReferralHeaderFlags.StorageServers);
            if (!z && referralEntries.size() == 1) {
                z = domainCache.lookup(new DFSPath(dFSReferral.getPath()).getPathComponents().get(0)) != null;
            }
            this.interlink = z;
            int ttl = dFSReferral.getTtl();
            this.ttl = ttl;
            this.expires = System.currentTimeMillis() + (((long) ttl) * 1000);
            this.targetFailback = sMB2GetDFSReferralResponse.getReferralHeaderFlags().contains(SMB2GetDFSReferralResponse.ReferralHeaderFlags.TargetFailback);
            ArrayList arrayList = new ArrayList(referralEntries.size());
            Iterator<DFSReferral> it2 = referralEntries.iterator();
            while (it2.hasNext()) {
                arrayList.add(new TargetSetEntry(it2.next().getPath(), false));
            }
            this.targetList = Collections.unmodifiableList(arrayList);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String getDfsPathPrefix() {
            return this.dfsPathPrefix;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public TargetSetEntry getTargetHint() {
            return this.targetList.get(this.targetHint);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public List<TargetSetEntry> getTargetList() {
            return this.targetList;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean isExpired() {
            return System.currentTimeMillis() > this.expires;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean isInterlink() {
            return isLink() && this.interlink;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean isLink() {
            return this.rootOrLink == DFSReferral.ServerType.LINK;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean isRoot() {
            return this.rootOrLink == DFSReferral.ServerType.ROOT;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public synchronized TargetSetEntry nextTargetHint() {
            if (this.targetHint >= this.targetList.size() - 1) {
                return null;
            }
            this.targetHint++;
            return getTargetHint();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String toString() {
            return this.dfsPathPrefix + "->" + getTargetHint().targetPath + "(" + this.rootOrLink + "), " + this.targetList;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class ReferralCacheNode {
        static final AtomicReferenceFieldUpdater<ReferralCacheNode, ReferralCacheEntry> ENTRY_UPDATER = AtomicReferenceFieldUpdater.newUpdater(ReferralCacheNode.class, ReferralCacheEntry.class, "entry");
        private final Map<String, ReferralCacheNode> childNodes = new ConcurrentHashMap();
        private volatile ReferralCacheEntry entry;
        private final String pathComponent;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public ReferralCacheNode(String str) {
            this.pathComponent = str;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void addReferralEntry(Iterator<String> it, ReferralCacheEntry referralCacheEntry) {
            if (!it.hasNext()) {
                ENTRY_UPDATER.set(this, referralCacheEntry);
                return;
            }
            String lowerCase = it.next().toLowerCase();
            ReferralCacheNode referralCacheNode = this.childNodes.get(lowerCase);
            if (referralCacheNode == null) {
                Map<String, ReferralCacheNode> map = this.childNodes;
                referralCacheNode = new ReferralCacheNode(lowerCase);
                map.put(lowerCase, referralCacheNode);
            }
            referralCacheNode.addReferralEntry(it, referralCacheEntry);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void clear() {
            this.childNodes.clear();
            ENTRY_UPDATER.set(this, null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void deleteExpiredReferralEntry(List<String> list) {
            if (this.entry != null && this.entry.isExpired() && !this.entry.isRoot()) {
                clear();
                return;
            }
            if (list == null || list.isEmpty()) {
                return;
            }
            ReferralCacheNode referralCacheNode = this.childNodes.get(list.get(0).toLowerCase());
            if (referralCacheNode != null) {
                referralCacheNode.deleteExpiredReferralEntry(list.subList(1, list.size()));
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Map<String, ReferralCacheNode> getChildNodes() {
            return this.childNodes;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String getPathComponent() {
            return this.pathComponent;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public ReferralCacheEntry getReferralEntry(Iterator<String> it) {
            if (it.hasNext()) {
                ReferralCacheNode referralCacheNode = this.childNodes.get(it.next().toLowerCase());
                if (referralCacheNode != null) {
                    return referralCacheNode.getReferralEntry(it);
                }
            }
            return ENTRY_UPDATER.get(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class TargetSetEntry {
        final DFSPath targetPath;
        final boolean targetSetBoundary;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public TargetSetEntry(String str, boolean z) {
            this.targetPath = new DFSPath(str);
            this.targetSetBoundary = z;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public DFSPath getTargetPath() {
            return this.targetPath;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String toString() {
            return "TargetSetEntry[" + this.targetPath + ",targetSetBoundary=" + this.targetSetBoundary + "]";
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void clear(DFSPath dFSPath) {
        this.cacheRoot.deleteExpiredReferralEntry(dFSPath.getPathComponents());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ReferralCacheEntry lookup(DFSPath dFSPath) {
        return this.cacheRoot.getReferralEntry(dFSPath.getPathComponents().iterator());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void put(ReferralCacheEntry referralCacheEntry) {
        this.cacheRoot.addReferralEntry(new DFSPath(referralCacheEntry.dfsPathPrefix).getPathComponents().iterator(), referralCacheEntry);
    }

    public void clear() {
        this.cacheRoot.clear();
    }
}
