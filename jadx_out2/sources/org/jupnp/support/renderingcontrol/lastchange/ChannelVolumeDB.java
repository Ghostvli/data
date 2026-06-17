package org.jupnp.support.renderingcontrol.lastchange;

import org.jupnp.support.model.Channel;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class ChannelVolumeDB {
    protected Channel channel;
    protected Integer volumeDB;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ChannelVolumeDB(Channel channel, Integer num) {
        this.channel = channel;
        this.volumeDB = num;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Channel getChannel() {
        return this.channel;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Integer getVolumeDB() {
        return this.volumeDB;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "VolumeDB: " + getVolumeDB() + " (" + String.valueOf(getChannel()) + ")";
    }
}
