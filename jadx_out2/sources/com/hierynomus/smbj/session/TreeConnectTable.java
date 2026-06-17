package com.hierynomus.smbj.session;

import com.hierynomus.smbj.share.Share;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
class TreeConnectTable {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Map<Long, Share> lookupById = new HashMap();
    private Map<String, Share> lookupByShareName = new HashMap();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void closed(long j) {
        this.lock.writeLock().lock();
        try {
            Share shareRemove = this.lookupById.remove(Long.valueOf(j));
            if (shareRemove != null) {
                this.lookupByShareName.remove(shareRemove.getTreeConnect().getShareName());
            }
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Collection<Share> getOpenTreeConnects() {
        this.lock.readLock().lock();
        try {
            return new ArrayList(this.lookupById.values());
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Share getTreeConnect(long j) {
        this.lock.readLock().lock();
        try {
            return this.lookupById.get(Long.valueOf(j));
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void register(Share share) {
        this.lock.writeLock().lock();
        try {
            this.lookupById.put(Long.valueOf(share.getTreeConnect().getTreeId()), share);
            this.lookupByShareName.put(share.getTreeConnect().getShareName(), share);
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    public Share getTreeConnect(String str) {
        this.lock.readLock().lock();
        try {
            return this.lookupByShareName.get(str);
        } finally {
            this.lock.readLock().unlock();
        }
    }
}
