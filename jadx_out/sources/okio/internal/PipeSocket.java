package okio.internal;

import okio.Pipe;
import okio.Sink;
import okio.Socket;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class PipeSocket implements Socket {
    private final Pipe sinkPipe;
    private final Pipe sourcePipe;

    public PipeSocket(Pipe pipe, Pipe pipe2) {
        pipe.getClass();
        pipe2.getClass();
        this.sinkPipe = pipe;
        this.sourcePipe = pipe2;
    }

    @Override // okio.Socket
    public void cancel() {
        this.sourcePipe.cancel();
        this.sinkPipe.cancel();
    }

    @Override // okio.Socket
    public Sink getSink() {
        return this.sinkPipe.sink();
    }

    public final Pipe getSinkPipe() {
        return this.sinkPipe;
    }

    @Override // okio.Socket
    public Source getSource() {
        return this.sourcePipe.source();
    }

    public final Pipe getSourcePipe() {
        return this.sourcePipe;
    }
}
