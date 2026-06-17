package org.jupnp.support.renderingcontrol.lastchange;

import java.util.Map;
import org.jupnp.model.types.BooleanDatatype;
import org.jupnp.model.types.Datatype;
import org.jupnp.support.lastchange.EventedValue;
import org.jupnp.support.model.Channel;
import org.jupnp.support.shared.AbstractMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class EventedValueChannelLoudness extends EventedValue<ChannelLoudness> {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public EventedValueChannelLoudness(ChannelLoudness channelLoudness) {
        super(channelLoudness);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.support.lastchange.EventedValue
    public Map.Entry<String, String>[] getAttributes() {
        return new Map.Entry[]{new AbstractMap.SimpleEntry("val", new BooleanDatatype().getString(getValue().getLoudness())), new AbstractMap.SimpleEntry("channel", getValue().getChannel().name())};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.support.lastchange.EventedValue
    public Datatype<?> getDatatype() {
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.support.lastchange.EventedValue
    public String toString() {
        return getValue().toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // org.jupnp.support.lastchange.EventedValue
    /* JADX INFO: renamed from: valueOf, reason: avoid collision after fix types in other method */
    public ChannelLoudness valueOf2(Map.Entry<String, String>[] entryArr) {
        Channel channelValueOf = null;
        Boolean boolValueOf = null;
        for (Map.Entry<String, String> entry : entryArr) {
            if (entry.getKey().equals("channel")) {
                channelValueOf = Channel.valueOf(entry.getValue());
            }
            if (entry.getKey().equals("val")) {
                boolValueOf = new BooleanDatatype().valueOf(entry.getValue());
            }
        }
        if (channelValueOf == null || boolValueOf == null) {
            return null;
        }
        return new ChannelLoudness(channelValueOf, boolValueOf);
    }

    public EventedValueChannelLoudness(Map.Entry<String, String>[] entryArr) {
        super(entryArr);
    }

    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    @Override // org.jupnp.support.lastchange.EventedValue
    public /* bridge */ /* synthetic */ ChannelLoudness valueOf(Map.Entry[] entryArr) {
        return valueOf2((Map.Entry<String, String>[]) entryArr);
    }
}
