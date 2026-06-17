package com.hierynomus.protocol.commons.buffer;

import com.hierynomus.protocol.commons.Charsets;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.b;
import defpackage.ts0;
import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class Endian {
    public static final Endian BE;
    public static final Endian LE;
    private static final byte[] NULL_TERMINATOR = {0, 0};

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Big extends Endian {
        private Big() {
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> long readLong(Buffer<T> buffer) throws Buffer.BufferException {
            byte[] rawBytes = buffer.readRawBytes(8);
            long j = 0;
            for (int i = 0; i < 8; i++) {
                j = (j << 8) | ((long) (rawBytes[i] & 255));
            }
            return j;
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> String readNullTerminatedUtf16String(Buffer<T> buffer) {
            return readNullTerminatedUtf16String(buffer, Charsets.UTF_16BE);
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> int readUInt16(Buffer<T> buffer) throws Buffer.BufferException {
            byte[] rawBytes = buffer.readRawBytes(2);
            return (rawBytes[1] & 255) | ((rawBytes[0] << 8) & 65280);
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> int readUInt24(Buffer<T> buffer) throws Buffer.BufferException {
            byte[] rawBytes = buffer.readRawBytes(3);
            return (rawBytes[2] & 255) | ((rawBytes[0] << 16) & 16711680) | ((rawBytes[1] << 8) & 65280);
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> long readUInt32(Buffer<T> buffer) throws Buffer.BufferException {
            byte[] rawBytes = buffer.readRawBytes(4);
            return (((long) rawBytes[3]) & 255) | (((long) (rawBytes[0] << 24)) & 4278190080L) | (((long) (rawBytes[1] << 16)) & 16711680) | (((long) (rawBytes[2] << 8)) & 65280);
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> long readUInt64(Buffer<T> buffer) throws Buffer.BufferException {
            long uInt32 = (readUInt32(buffer) << 32) + (readUInt32(buffer) & 4294967295L);
            if (uInt32 >= 0) {
                return uInt32;
            }
            throw new Buffer.BufferException("Cannot handle values > 9223372036854775807");
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> String readUtf16String(Buffer<T> buffer, int i) {
            return readUtf16String(buffer, i, Charsets.UTF_16BE);
        }

        public String toString() {
            return "big endian";
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> void writeLong(Buffer<T> buffer, long j) {
            buffer.putRawBytes(new byte[]{(byte) (j >> 56), (byte) (j >> 48), (byte) (j >> 40), (byte) (j >> 32), (byte) (j >> 24), (byte) (j >> 16), (byte) (j >> 8), (byte) j});
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> void writeUInt16(Buffer<T> buffer, int i) {
            if (i < 0 || i > 65535) {
                b.a("Invalid uint16 value: ", i);
            } else {
                buffer.putRawBytes(new byte[]{(byte) (i >> 8), (byte) i});
            }
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> void writeUInt24(Buffer<T> buffer, int i) {
            if (i < 0 || i > 16777215) {
                b.a("Invalid uint24 value: ", i);
            } else {
                buffer.putRawBytes(new byte[]{(byte) (i >> 16), (byte) (i >> 8), (byte) i});
            }
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> void writeUInt32(Buffer<T> buffer, long j) {
            if (j < 0 || j > 4294967295L) {
                ts0.a("Invalid uint32 value: ", j);
            } else {
                buffer.putRawBytes(new byte[]{(byte) (j >> 24), (byte) (j >> 16), (byte) (j >> 8), (byte) j});
            }
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> void writeUInt64(Buffer<T> buffer, long j) {
            if (j >= 0) {
                writeLong(buffer, j);
            } else {
                ts0.a("Invalid uint64 value: ", j);
            }
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> void writeUtf16String(Buffer<T> buffer, String str) {
            buffer.putRawBytes(str.getBytes(Charsets.UTF_16BE));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class Little extends Endian {
        private Little() {
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> long readLong(Buffer<T> buffer) throws Buffer.BufferException {
            byte[] rawBytes = buffer.readRawBytes(8);
            long j = 0;
            for (int i = 7; i >= 0; i--) {
                j = (j << 8) | ((long) (rawBytes[i] & 255));
            }
            return j;
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> String readNullTerminatedUtf16String(Buffer<T> buffer) {
            return readNullTerminatedUtf16String(buffer, Charsets.UTF_16LE);
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> int readUInt16(Buffer<T> buffer) throws Buffer.BufferException {
            byte[] rawBytes = buffer.readRawBytes(2);
            return ((rawBytes[1] << 8) & 65280) | (rawBytes[0] & 255);
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> int readUInt24(Buffer<T> buffer) throws Buffer.BufferException {
            byte[] rawBytes = buffer.readRawBytes(3);
            return ((rawBytes[2] << 16) & 16711680) | (rawBytes[0] & 255) | ((rawBytes[1] << 8) & 65280);
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> long readUInt32(Buffer<T> buffer) throws Buffer.BufferException {
            byte[] rawBytes = buffer.readRawBytes(4);
            return (((long) (rawBytes[3] << 24)) & 4278190080L) | (((long) rawBytes[0]) & 255) | (((long) (rawBytes[1] << 8)) & 65280) | (((long) (rawBytes[2] << 16)) & 16711680);
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> long readUInt64(Buffer<T> buffer) throws Buffer.BufferException {
            long uInt32 = (readUInt32(buffer) & 4294967295L) + (readUInt32(buffer) << 32);
            if (uInt32 >= 0) {
                return uInt32;
            }
            throw new Buffer.BufferException("Cannot handle values > 9223372036854775807");
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> String readUtf16String(Buffer<T> buffer, int i) {
            return readUtf16String(buffer, i, Charsets.UTF_16LE);
        }

        public String toString() {
            return "little endian";
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> void writeLong(Buffer<T> buffer, long j) {
            buffer.putRawBytes(new byte[]{(byte) j, (byte) (j >> 8), (byte) (j >> 16), (byte) (j >> 24), (byte) (j >> 32), (byte) (j >> 40), (byte) (j >> 48), (byte) (j >> 56)});
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> void writeUInt16(Buffer<T> buffer, int i) {
            if (i < 0 || i > 65535) {
                b.a("Invalid uint16 value: ", i);
            } else {
                buffer.putRawBytes(new byte[]{(byte) i, (byte) (i >> 8)});
            }
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> void writeUInt24(Buffer<T> buffer, int i) {
            if (i < 0 || i > 16777215) {
                b.a("Invalid uint24 value: ", i);
            } else {
                buffer.putRawBytes(new byte[]{(byte) i, (byte) (i >> 8), (byte) (i >> 16)});
            }
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> void writeUInt32(Buffer<T> buffer, long j) {
            if (j < 0 || j > 4294967295L) {
                ts0.a("Invalid uint32 value: ", j);
            } else {
                buffer.putRawBytes(new byte[]{(byte) j, (byte) (j >> 8), (byte) (j >> 16), (byte) (j >> 24)});
            }
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> void writeUInt64(Buffer<T> buffer, long j) {
            if (j >= 0) {
                writeLong(buffer, j);
            } else {
                ts0.a("Invalid uint64 value: ", j);
            }
        }

        @Override // com.hierynomus.protocol.commons.buffer.Endian
        public <T extends Buffer<T>> void writeUtf16String(Buffer<T> buffer, String str) {
            buffer.putRawBytes(str.getBytes(Charsets.UTF_16LE));
        }
    }

    static {
        LE = new Little();
        BE = new Big();
    }

    public abstract <T extends Buffer<T>> long readLong(Buffer<T> buffer);

    public abstract <T extends Buffer<T>> String readNullTerminatedUtf16String(Buffer<T> buffer);

    public <T extends Buffer<T>> String readNullTerminatedUtf16String(Buffer<T> buffer, Charset charset) throws Buffer.BufferException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = new byte[2];
        buffer.readRawBytes(bArr);
        while (true) {
            if (bArr[0] == 0 && bArr[1] == 0) {
                return new String(byteArrayOutputStream.toByteArray(), charset);
            }
            byteArrayOutputStream.write(bArr, 0, 2);
            buffer.readRawBytes(bArr);
        }
    }

    public abstract <T extends Buffer<T>> int readUInt16(Buffer<T> buffer);

    public abstract <T extends Buffer<T>> int readUInt24(Buffer<T> buffer);

    public abstract <T extends Buffer<T>> long readUInt32(Buffer<T> buffer);

    public abstract <T extends Buffer<T>> long readUInt64(Buffer<T> buffer);

    public abstract <T extends Buffer<T>> String readUtf16String(Buffer<T> buffer, int i);

    public <T extends Buffer<T>> String readUtf16String(Buffer<T> buffer, int i, Charset charset) throws Buffer.BufferException {
        byte[] bArr = new byte[i * 2];
        buffer.readRawBytes(bArr);
        return new String(bArr, charset);
    }

    public abstract <T extends Buffer<T>> void writeLong(Buffer<T> buffer, long j);

    public <T extends Buffer<T>> void writeNullTerminatedUtf16String(Buffer<T> buffer, String str) {
        writeUtf16String(buffer, str);
        buffer.putRawBytes(NULL_TERMINATOR);
    }

    public abstract <T extends Buffer<T>> void writeUInt16(Buffer<T> buffer, int i);

    public abstract <T extends Buffer<T>> void writeUInt24(Buffer<T> buffer, int i);

    public abstract <T extends Buffer<T>> void writeUInt32(Buffer<T> buffer, long j);

    public abstract <T extends Buffer<T>> void writeUInt64(Buffer<T> buffer, long j);

    public abstract <T extends Buffer<T>> void writeUtf16String(Buffer<T> buffer, String str);
}
