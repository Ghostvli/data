package com.hierynomus.msdfsc;

import com.hierynomus.msdfsc.messages.DFSReferral;
import com.hierynomus.msdfsc.messages.SMB2GetDFSReferralResponse;
import com.hierynomus.protocol.commons.EnumWithValue;
import defpackage.jr1;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DomainCache {
    private Map<String, DomainCacheEntry> cache = new ConcurrentHashMap();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class DomainCacheEntry {
        String DCHint;
        List<String> DCList;
        String domainName;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public DomainCacheEntry(SMB2GetDFSReferralResponse sMB2GetDFSReferralResponse) {
            if (sMB2GetDFSReferralResponse.getReferralEntries().size() != 1) {
                jr1.a("Expecting exactly 1 referral for a domain referral, found: ", sMB2GetDFSReferralResponse.getReferralEntries().size());
                throw null;
            }
            DFSReferral dFSReferral = sMB2GetDFSReferralResponse.getReferralEntries().get(0);
            if (EnumWithValue.EnumUtils.isSet(dFSReferral.getReferralEntryFlags(), DFSReferral.ReferralEntryFlags.NameListReferral)) {
                this.domainName = dFSReferral.getSpecialName();
                this.DCHint = dFSReferral.getExpandedNames().get(0);
                this.DCList = dFSReferral.getExpandedNames();
            } else {
                throw new IllegalStateException("Referral Entry for '" + dFSReferral.getSpecialName() + "' does not have NameListReferral bit set.");
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String getDCHint() {
            return this.DCHint;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public List<String> getDCList() {
            return this.DCList;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String getDomainName() {
            return this.domainName;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String toString() {
            return this.domainName + "->" + this.DCHint + ", " + this.DCList;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DomainCacheEntry lookup(String str) {
        return this.cache.get(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void put(DomainCacheEntry domainCacheEntry) {
        this.cache.put(domainCacheEntry.domainName, domainCacheEntry);
    }
}
