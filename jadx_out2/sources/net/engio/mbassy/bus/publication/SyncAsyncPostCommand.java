package net.engio.mbassy.bus.publication;

import java.util.concurrent.TimeUnit;
import net.engio.mbassy.bus.IMessagePublication;
import net.engio.mbassy.bus.MBassador;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class SyncAsyncPostCommand<T> implements ISyncAsyncPublicationCommand {
    private MBassador<T> mBassador;
    private T message;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public SyncAsyncPostCommand(MBassador<T> mBassador, T t) {
        this.mBassador = mBassador;
        this.message = t;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // net.engio.mbassy.bus.publication.ISyncAsyncPublicationCommand
    public IMessagePublication asynchronously() {
        return this.mBassador.publishAsync(this.message);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // net.engio.mbassy.bus.publication.IPublicationCommand
    public IMessagePublication now() {
        return this.mBassador.publish(this.message);
    }

    @Override // net.engio.mbassy.bus.publication.ISyncAsyncPublicationCommand
    public IMessagePublication asynchronously(long j, TimeUnit timeUnit) {
        return this.mBassador.publishAsync(this.message, j, timeUnit);
    }
}
