package okhttp3.internal.ws;

import defpackage.jl;
import defpackage.sb1;
import java.io.Closeable;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Random;
import okhttp3.internal._UtilCommonKt;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class WebSocketWriter implements Closeable {
    private final boolean isClient;
    private final Buffer.UnsafeCursor maskCursor;
    private final byte[] maskKey;
    private final Buffer messageBuffer;
    private MessageDeflater messageDeflater;
    private final long minimumDeflateSize;
    private final boolean noContextTakeover;
    private final boolean perMessageDeflate;
    private final Random random;
    private final BufferedSink sink;
    private final Buffer sinkBuffer;
    private boolean writerClosed;

    public WebSocketWriter(boolean z, BufferedSink bufferedSink, Random random, boolean z2, boolean z3, long j) {
        bufferedSink.getClass();
        random.getClass();
        this.isClient = z;
        this.sink = bufferedSink;
        this.random = random;
        this.perMessageDeflate = z2;
        this.noContextTakeover = z3;
        this.minimumDeflateSize = j;
        this.messageBuffer = new Buffer();
        this.sinkBuffer = bufferedSink.getBuffer();
        this.maskKey = z ? new byte[4] : null;
        this.maskCursor = z ? new Buffer.UnsafeCursor() : null;
    }

    private final void writeControlFrame(int i, ByteString byteString) throws IOException {
        if (this.writerClosed) {
            sb1.a("closed");
            return;
        }
        int size = byteString.size();
        if (size > 125) {
            jl.a("Payload size must be less than or equal to 125");
            return;
        }
        this.sinkBuffer.writeByte(i | 128);
        boolean z = this.isClient;
        Buffer buffer = this.sinkBuffer;
        if (z) {
            buffer.writeByte(size | 128);
            Random random = this.random;
            byte[] bArr = this.maskKey;
            bArr.getClass();
            random.nextBytes(bArr);
            this.sinkBuffer.write(this.maskKey);
            if (size > 0) {
                long size2 = this.sinkBuffer.size();
                this.sinkBuffer.write(byteString);
                Buffer buffer2 = this.sinkBuffer;
                Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                unsafeCursor.getClass();
                buffer2.readAndWriteUnsafe(unsafeCursor);
                this.maskCursor.seek(size2);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        } else {
            buffer.writeByte(size);
            this.sinkBuffer.write(byteString);
        }
        this.sink.flush();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        MessageDeflater messageDeflater = this.messageDeflater;
        if (messageDeflater != null) {
            _UtilCommonKt.closeQuietly(messageDeflater);
        }
        _UtilCommonKt.closeQuietly(this.sink);
    }

    public final Random getRandom() {
        return this.random;
    }

    public final BufferedSink getSink() {
        return this.sink;
    }

    public final void writeClose(int i, ByteString byteString) {
        ByteString byteString2 = ByteString.EMPTY;
        if (i != 0 || byteString != null) {
            if (i != 0) {
                WebSocketProtocol.INSTANCE.validateCloseCode(i);
            }
            Buffer buffer = new Buffer();
            buffer.writeShort(i);
            if (byteString != null) {
                buffer.write(byteString);
            }
            byteString2 = buffer.readByteString();
        }
        try {
            writeControlFrame(8, byteString2);
        } finally {
            this.writerClosed = true;
        }
    }

    public final void writeMessageFrame(int i, ByteString byteString) throws IllegalAccessException, IOException, InvocationTargetException {
        byteString.getClass();
        if (this.writerClosed) {
            sb1.a("closed");
            return;
        }
        this.messageBuffer.write(byteString);
        int i2 = i | 128;
        if (this.perMessageDeflate && byteString.size() >= this.minimumDeflateSize) {
            MessageDeflater messageDeflater = this.messageDeflater;
            if (messageDeflater == null) {
                messageDeflater = new MessageDeflater(this.noContextTakeover);
                this.messageDeflater = messageDeflater;
            }
            messageDeflater.deflate(this.messageBuffer);
            i2 = i | 192;
        }
        long size = this.messageBuffer.size();
        this.sinkBuffer.writeByte(i2);
        int i3 = this.isClient ? 128 : 0;
        if (size <= 125) {
            this.sinkBuffer.writeByte(i3 | ((int) size));
        } else {
            Buffer buffer = this.sinkBuffer;
            if (size <= WebSocketProtocol.PAYLOAD_SHORT_MAX) {
                buffer.writeByte(i3 | 126);
                this.sinkBuffer.writeShort((int) size);
            } else {
                buffer.writeByte(i3 | 127);
                this.sinkBuffer.writeLong(size);
            }
        }
        if (this.isClient) {
            Random random = this.random;
            byte[] bArr = this.maskKey;
            bArr.getClass();
            random.nextBytes(bArr);
            this.sinkBuffer.write(this.maskKey);
            if (size > 0) {
                Buffer buffer2 = this.messageBuffer;
                Buffer.UnsafeCursor unsafeCursor = this.maskCursor;
                unsafeCursor.getClass();
                buffer2.readAndWriteUnsafe(unsafeCursor);
                this.maskCursor.seek(0L);
                WebSocketProtocol.INSTANCE.toggleMask(this.maskCursor, this.maskKey);
                this.maskCursor.close();
            }
        }
        this.sinkBuffer.write(this.messageBuffer, size);
        this.sink.flush();
    }

    public final void writePing(ByteString byteString) throws IOException {
        byteString.getClass();
        writeControlFrame(9, byteString);
    }

    public final void writePong(ByteString byteString) throws IOException {
        byteString.getClass();
        writeControlFrame(10, byteString);
    }
}
