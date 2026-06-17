package org.jupnp.support.renderingcontrol.lastchange;

import org.jupnp.support.model.Channel;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ChannelLoudness {
    protected Channel channel;
    protected Boolean loudness;

    public ChannelLoudness(Channel channel, Boolean bool) {
        this.channel = channel;
        this.loudness = bool;
    }

    public Channel getChannel() {
        return this.channel;
    }

    public Boolean getLoudness() {
        return this.loudness;
    }

    public String toString() {
        return "Loudness: " + getLoudness() + " (" + String.valueOf(getChannel()) + ")";
    }
}
