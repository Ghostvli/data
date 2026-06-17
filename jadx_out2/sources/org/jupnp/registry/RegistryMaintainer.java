package org.jupnp.registry;

import defpackage.j02;
import defpackage.n02;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class RegistryMaintainer implements Runnable {
    private final RegistryImpl registry;
    private final int sleepIntervalMillis;
    private final j02 logger = n02.k(RegistryMaintainer.class);
    private volatile boolean stopped = false;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public RegistryMaintainer(RegistryImpl registryImpl, int i) {
        this.registry = registryImpl;
        this.sleepIntervalMillis = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Runnable
    public void run() {
        this.stopped = false;
        this.logger.h("Running registry maintenance loop every milliseconds: {}", Integer.valueOf(this.sleepIntervalMillis));
        while (!this.stopped) {
            try {
                this.registry.maintain();
                Thread.sleep(this.sleepIntervalMillis);
            } catch (InterruptedException unused) {
                this.stopped = true;
            }
        }
        this.logger.y("Stopped status on thread received, ending maintenance loop");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void stop() {
        this.logger.y("Setting stopped status on thread");
        this.stopped = true;
    }
}
