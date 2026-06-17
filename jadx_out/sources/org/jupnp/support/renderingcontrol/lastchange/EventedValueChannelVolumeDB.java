package org.jupnp.support.renderingcontrol.lastchange;

import java.util.Map;
import org.jupnp.model.types.Datatype;
import org.jupnp.model.types.UnsignedIntegerTwoBytes;
import org.jupnp.model.types.UnsignedIntegerTwoBytesDatatype;
import org.jupnp.support.lastchange.EventedValue;
import org.jupnp.support.model.Channel;
import org.jupnp.support.shared.AbstractMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class EventedValueChannelVolumeDB extends EventedValue<ChannelVolumeDB> {
    public EventedValueChannelVolumeDB(ChannelVolumeDB channelVolumeDB) {
        super(channelVolumeDB);
    }

    @Override // org.jupnp.support.lastchange.EventedValue
    public Map.Entry<String, String>[] getAttributes() {
        return new Map.Entry[]{new AbstractMap.SimpleEntry("val", new UnsignedIntegerTwoBytesDatatype().getString(new UnsignedIntegerTwoBytes(getValue().getVolumeDB().intValue()))), new AbstractMap.SimpleEntry("channel", getValue().getChannel().name())};
    }

    @Override // org.jupnp.support.lastchange.EventedValue
    public Datatype<?> getDatatype() {
        return null;
    }

    @Override // org.jupnp.support.lastchange.EventedValue
    public String toString() {
        return getValue().toString();
    }

    @Override // org.jupnp.support.lastchange.EventedValue
    /* JADX INFO: renamed from: valueOf, reason: avoid collision after fix types in other method */
    public ChannelVolumeDB valueOf2(Map.Entry<String, String>[] entryArr) {
        Channel channelValueOf = null;
        Integer numValueOf = null;
        for (Map.Entry<String, String> entry : entryArr) {
            if (entry.getKey().equals("channel")) {
                channelValueOf = Channel.valueOf(entry.getValue());
            }
            if (entry.getKey().equals("val")) {
                numValueOf = Integer.valueOf(new UnsignedIntegerTwoBytesDatatype().valueOf(entry.getValue()).getValue().intValue());
            }
        }
        if (channelValueOf == null || numValueOf == null) {
            return null;
        }
        return new ChannelVolumeDB(channelValueOf, numValueOf);
    }

    public EventedValueChannelVolumeDB(Map.Entry<String, String>[] entryArr) {
        super(entryArr);
    }

    @Override // org.jupnp.support.lastchange.EventedValue
    public /* bridge */ /* synthetic */ ChannelVolumeDB valueOf(Map.Entry[] entryArr) {
        return valueOf2((Map.Entry<String, String>[]) entryArr);
    }
}
