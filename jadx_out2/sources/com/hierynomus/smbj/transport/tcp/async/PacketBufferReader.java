package com.hierynomus.smbj.transport.tcp.async;

import com.hierynomus.protocol.Packet;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class PacketBufferReader {
    private static final int HEADER_SIZE = 4;
    private static final int NO_PACKET_LENGTH = -1;
    private static final int READ_BUFFER_CAPACITY = 9000;
    private byte[] currentPacketBytes;
    private int currentPacketLength = -1;
    private int currentPacketOffset = 0;
    private final ByteBuffer readBuffer;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public <P extends Packet<?>> PacketBufferReader() {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(9000);
        this.readBuffer = byteBufferAllocate;
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean isAwaitingHeader() {
        return this.currentPacketLength == -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private boolean isHeaderAvailable() {
        return this.readBuffer.remaining() >= 4;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private byte[] readPacketBody() {
        int iRemaining = this.currentPacketLength - this.currentPacketOffset;
        if (iRemaining > this.readBuffer.remaining()) {
            iRemaining = this.readBuffer.remaining();
        }
        this.readBuffer.get(this.currentPacketBytes, this.currentPacketOffset, iRemaining);
        int i = this.currentPacketOffset + iRemaining;
        this.currentPacketOffset = i;
        if (i == this.currentPacketLength) {
            return this.currentPacketBytes;
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int readPacketHeader() {
        return this.readBuffer.getInt() & 16777215;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ByteBuffer getBuffer() {
        return this.readBuffer;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] readNext() {
        byte[] packetBody;
        this.readBuffer.flip();
        if (isAwaitingHeader() && isHeaderAvailable()) {
            int packetHeader = readPacketHeader();
            this.currentPacketLength = packetHeader;
            this.currentPacketBytes = new byte[packetHeader];
            packetBody = readPacketBody();
        } else {
            packetBody = !isAwaitingHeader() ? readPacketBody() : null;
        }
        this.readBuffer.compact();
        if (packetBody != null) {
            this.currentPacketBytes = null;
            this.currentPacketOffset = 0;
            this.currentPacketLength = -1;
        }
        return packetBody;
    }
}
