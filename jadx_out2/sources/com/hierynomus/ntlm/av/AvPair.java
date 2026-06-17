package com.hierynomus.ntlm.av;

import com.hierynomus.protocol.commons.buffer.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AvPair<T> {
    protected AvId avId;
    protected T value;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AvPair(AvId avId, T t) {
        this.avId = avId;
        this.value = t;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public AvId getAvId() {
        return this.avId;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public T getValue() {
        return this.value;
    }

    public abstract AvPair<T> read(Buffer<?> buffer);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "AvPair{avId=" + this.avId.name() + ", value=" + this.value + '}';
    }

    public abstract void write(Buffer<?> buffer);

    public AvPair(AvId avId) {
        this.avId = avId;
    }
}
