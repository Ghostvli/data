package com.hierynomus.msfscc.fsctl;

import com.hierynomus.protocol.commons.EnumWithValue;
import com.hierynomus.protocol.commons.buffer.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class FsCtlPipePeekResponse {
    public static final int STRUCTURE_SIZE = 24;
    private byte[] data;
    private long messageLength;
    private long numberOfMessages;
    private long readDataAvailable;
    private PipeState state;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum PipeState implements EnumWithValue<PipeState> {
        FILE_PIPE_CONNECTED_STATE(3),
        FILE_PIPE_CLOSING_STATE(4);

        private final int value;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        PipeState(int i) {
            this.value = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // com.hierynomus.protocol.commons.EnumWithValue
        public long getValue() {
            return this.value;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public FsCtlPipePeekResponse(PipeState pipeState, long j, long j2, long j3, byte[] bArr) {
        this.state = pipeState;
        this.readDataAvailable = j;
        this.numberOfMessages = j2;
        this.messageLength = j3;
        this.data = bArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] getData() {
        return this.data;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getMessageLength() {
        return this.messageLength;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getNumberOfMessages() {
        return this.numberOfMessages;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long getReadDataAvailable() {
        return this.readDataAvailable;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public PipeState getState() {
        return this.state;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void read(Buffer<?> buffer) {
        this.state = (PipeState) EnumWithValue.EnumUtils.valueOf(buffer.readUInt32(), PipeState.class, null);
        this.readDataAvailable = buffer.readUInt32();
        this.numberOfMessages = buffer.readUInt32();
        this.messageLength = buffer.readUInt32();
        this.data = buffer.readRawBytes(buffer.available());
    }

    public FsCtlPipePeekResponse() {
    }
}
