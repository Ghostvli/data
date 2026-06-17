package com.hierynomus.smbj.transport.tcp.direct;

import com.hierynomus.protocol.PacketData;
import com.hierynomus.protocol.commons.buffer.Buffer;
import com.hierynomus.protocol.commons.buffer.Endian;
import com.hierynomus.protocol.transport.PacketFactory;
import com.hierynomus.protocol.transport.PacketReceiver;
import com.hierynomus.protocol.transport.TransportException;
import com.hierynomus.smbj.transport.PacketReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class DirectTcpPacketReader<D extends PacketData<?>> extends PacketReader<D> {
    private final PacketFactory<D> packetFactory;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public DirectTcpPacketReader(String str, InputStream inputStream, PacketFactory<D> packetFactory, PacketReceiver<D> packetReceiver) {
        super(str, inputStream, packetReceiver);
        this.packetFactory = packetFactory;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private void readFully(byte[] bArr) throws IOException {
        int length = bArr.length;
        int i = 0;
        while (length > 0) {
            int i2 = this.in.read(bArr, i, length);
            if (i2 == -1) {
                throw new TransportException(new EOFException("EOF while reading packet"));
            }
            length -= i2;
            i += i2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private D readPacket(int i) throws IOException {
        byte[] bArr = new byte[i];
        readFully(bArr);
        return (D) this.packetFactory.read(bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private int readTcpHeader() throws Buffer.BufferException, IOException {
        byte[] bArr = new byte[4];
        readFully(bArr);
        Buffer.PlainBuffer plainBuffer = new Buffer.PlainBuffer(bArr, Endian.BE);
        plainBuffer.readByte();
        return plainBuffer.readUInt24();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // com.hierynomus.smbj.transport.PacketReader
    public D doRead() throws TransportException {
        try {
            return (D) readPacket(readTcpHeader());
        } catch (Buffer.BufferException | IOException e) {
            throw new TransportException(e);
        } catch (TransportException e2) {
            throw e2;
        }
    }
}
