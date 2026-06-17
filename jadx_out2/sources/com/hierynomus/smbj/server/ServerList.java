package com.hierynomus.smbj.server;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ServerList {
    private ReentrantLock lock = new ReentrantLock();
    private Map<String, Server> lookup = new HashMap();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Server lookup(String str) {
        this.lock.lock();
        try {
            return this.lookup.get(str);
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void registerServer(Server server) {
        this.lock.lock();
        try {
            this.lookup.put(server.getServerName(), server);
        } finally {
            this.lock.unlock();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void unregister(String str) {
        this.lock.lock();
        try {
            this.lookup.remove(str);
        } finally {
            this.lock.unlock();
        }
    }
}
