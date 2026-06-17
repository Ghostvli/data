package com.hierynomus.smbj.connection;

import com.hierynomus.smbj.common.SMBRuntimeException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class OutstandingRequests {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Map<Long, Request> lookup = new HashMap();
    private Map<UUID, Request> cancelLookup = new HashMap();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Request getRequestByCancelId(UUID uuid) {
        this.lock.readLock().lock();
        try {
            return this.cancelLookup.get(uuid);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Request getRequestByMessageId(Long l) {
        this.lock.readLock().lock();
        try {
            return this.lookup.get(l);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void handleError(Throwable th) {
        this.lock.writeLock().lock();
        try {
            Iterator it = new HashSet(this.lookup.keySet()).iterator();
            while (it.hasNext()) {
                Request requestRemove = this.lookup.remove((Long) it.next());
                this.cancelLookup.remove(requestRemove.getCancelId());
                requestRemove.getPromise().deliverError(th);
            }
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isOutstanding(Long l) {
        this.lock.readLock().lock();
        try {
            return this.lookup.containsKey(l);
        } finally {
            this.lock.readLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Request receivedResponseFor(Long l) {
        this.lock.writeLock().lock();
        try {
            Request requestRemove = this.lookup.remove(l);
            if (requestRemove != null) {
                this.cancelLookup.remove(requestRemove.getCancelId());
                return requestRemove;
            }
            throw new SMBRuntimeException("Unable to find outstanding request for messageId " + l);
        } finally {
            this.lock.writeLock().unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void registerOutstanding(Request request) {
        this.lock.writeLock().lock();
        try {
            this.lookup.put(Long.valueOf(request.getMessageId()), request);
            this.cancelLookup.put(request.getCancelId(), request);
        } finally {
            this.lock.writeLock().unlock();
        }
    }
}
