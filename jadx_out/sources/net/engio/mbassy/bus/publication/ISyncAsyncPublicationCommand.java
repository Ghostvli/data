package net.engio.mbassy.bus.publication;

import java.util.concurrent.TimeUnit;
import net.engio.mbassy.bus.IMessagePublication;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface ISyncAsyncPublicationCommand extends IPublicationCommand {
    IMessagePublication asynchronously();

    IMessagePublication asynchronously(long j, TimeUnit timeUnit);
}
