package com.thegrizzlylabs.sardineandroid.report;

import com.thegrizzlylabs.sardineandroid.model.Multistatus;
import com.thegrizzlylabs.sardineandroid.util.SardineUtil;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class SardineReport<T> {
    public abstract T fromMultistatus(Multistatus multistatus);

    public abstract Object toJaxb();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toXml() {
        return SardineUtil.toXml(toJaxb());
    }
}
