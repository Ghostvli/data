package com.hierynomus.ntlm.messages;

import com.hierynomus.ntlm.av.AvId;
import com.hierynomus.ntlm.av.AvPair;
import com.hierynomus.ntlm.av.AvPairEnd;
import com.hierynomus.ntlm.av.AvPairFactory;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.j02;
import defpackage.n02;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class TargetInfo {
    private static final j02 logger = n02.k(TargetInfo.class);
    private List<AvPair<?>> targetInfo = new ArrayList();

    public TargetInfo copy() {
        TargetInfo targetInfo = new TargetInfo();
        targetInfo.targetInfo = new ArrayList(this.targetInfo);
        return targetInfo;
    }

    public <T extends AvPair<?>> T getAvPair(AvId avId) {
        Iterator<AvPair<?>> it = this.targetInfo.iterator();
        while (it.hasNext()) {
            T t = (T) it.next();
            if (t.getAvId() == avId) {
                return t;
            }
        }
        return null;
    }

    public boolean hasAvPair(AvId avId) {
        Iterator<AvPair<?>> it = this.targetInfo.iterator();
        while (it.hasNext()) {
            if (it.next().getAvId() == avId) {
                return true;
            }
        }
        return false;
    }

    public void putAvPair(AvPair<?> avPair) {
        Iterator<AvPair<?>> it = this.targetInfo.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AvPair<?> next = it.next();
            if (next.getAvId() == avPair.getAvId()) {
                this.targetInfo.remove(next);
                break;
            }
        }
        this.targetInfo.add(avPair);
    }

    public TargetInfo readFrom(Buffer.PlainBuffer plainBuffer) {
        while (true) {
            AvPair<?> avPair = AvPairFactory.read(plainBuffer);
            if (avPair.getAvId() == AvId.MsvAvEOL) {
                return this;
            }
            logger.i("Read TargetInfo {} --> {}", avPair.getAvId(), avPair.getValue());
            this.targetInfo.add(avPair);
        }
    }

    public String toString() {
        return "TargetInfo{targetInfo=" + this.targetInfo + '}';
    }

    public void writeTo(Buffer.PlainBuffer plainBuffer) {
        for (AvPair<?> avPair : this.targetInfo) {
            logger.i("Writing TargetInfo {} --> {}", avPair.getAvId(), avPair.getValue());
            avPair.write(plainBuffer);
        }
        new AvPairEnd().write(plainBuffer);
    }
}
