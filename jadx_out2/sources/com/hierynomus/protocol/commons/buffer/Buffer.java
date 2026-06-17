package com.hierynomus.protocol.commons.buffer;

import com.hierynomus.protocol.commons.ByteArrayUtils;
import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.j02;
import defpackage.n02;
import defpackage.ug4;
import j$.io.DesugarInputStream;
import j$.io.InputStreamRetargetInterface;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class Buffer<T extends Buffer<T>> {
    public static final int DEFAULT_SIZE = 256;
    public static final int MAX_SIZE = 1073741824;
    private static final j02 logger = n02.k(Buffer.class);
    private byte[] data;
    private Endian endianness;
    protected int rpos;
    protected int wpos;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class BufferException extends Exception {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public BufferException(String str) {
            super(str);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Buffer(Buffer<?> buffer) {
        int i = buffer.wpos;
        int i2 = buffer.rpos;
        int i3 = i - i2;
        this.wpos = i3;
        byte[] bArr = new byte[i3];
        this.data = bArr;
        this.endianness = buffer.endianness;
        System.arraycopy(buffer.data, i2, bArr, 0, i3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int getNextPowerOf2(int i) {
        int i2 = 1;
        while (i2 < i) {
            i2 <<= 1;
            if (i2 <= 0) {
                ug4.a("Cannot get next power of 2; ", i, " is too large");
                return 0;
            }
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Buffer<T> putNullTerminatedString(String str, Charset charset, Endian endian) {
        String strName = charset.name();
        strName.getClass();
        switch (strName) {
            case "UTF-16":
                endian.writeNullTerminatedUtf16String(this, str);
                return this;
            case "UTF-8":
                putRawBytes(str.getBytes(charset));
                putByte((byte) 0);
                return this;
            case "UTF-16BE":
                Endian.BE.writeNullTerminatedUtf16String(this, str);
                return this;
            case "UTF-16LE":
                Endian.LE.writeNullTerminatedUtf16String(this, str);
                return this;
            default:
                throw new UnsupportedCharsetException(charset.name());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private Buffer<T> putString(String str, Charset charset, Endian endian) {
        String strName = charset.name();
        strName.getClass();
        switch (strName) {
            case "UTF-16":
                endian.writeUtf16String(this, str);
                return this;
            case "UTF-8":
                putRawBytes(str.getBytes(charset));
                return this;
            case "UTF-16BE":
                Endian.BE.writeUtf16String(this, str);
                return this;
            case "UTF-16LE":
                Endian.LE.writeUtf16String(this, str);
                return this;
            default:
                throw new UnsupportedCharsetException(charset.name());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String readNullTerminatedString(Charset charset, Endian endian) throws BufferException {
        String strName = charset.name();
        strName.getClass();
        switch (strName) {
            case "UTF-16":
                return endian.readNullTerminatedUtf16String(this);
            case "UTF-8":
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte b = readByte();
                while (b != 0) {
                    byteArrayOutputStream.write(b);
                    b = readByte();
                }
                return new String(byteArrayOutputStream.toByteArray(), charset);
            case "UTF-16BE":
                return Endian.BE.readNullTerminatedUtf16String(this);
            case "UTF-16LE":
                return Endian.LE.readNullTerminatedUtf16String(this);
            default:
                throw new UnsupportedCharsetException(charset.name());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private String readString(Charset charset, int i, Endian endian) {
        String strName = charset.name();
        strName.getClass();
        switch (strName) {
            case "UTF-16":
                return endian.readUtf16String(this, i);
            case "UTF-8":
                return new String(readRawBytes(i), charset);
            case "UTF-16BE":
                return Endian.BE.readUtf16String(this, i);
            case "UTF-16LE":
                return Endian.LE.readUtf16String(this, i);
            default:
                throw new UnsupportedCharsetException(charset.name());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] array() {
        return this.data;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public InputStream asInputStream() {
        return new AnonymousClass1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int available() {
        return this.wpos - this.rpos;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void clear() {
        this.rpos = 0;
        this.wpos = 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void compact() {
        logger.b("Compacting...");
        if (available() > 0) {
            byte[] bArr = this.data;
            int i = this.rpos;
            System.arraycopy(bArr, i, bArr, 0, this.wpos - i);
        }
        this.wpos -= this.rpos;
        this.rpos = 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void ensureAvailable(int i) throws BufferException {
        if (available() < i) {
            throw new BufferException("Underflow");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void ensureCapacity(int i) {
        int length = this.data.length;
        int i2 = this.wpos;
        if (length - i2 < i) {
            byte[] bArr = new byte[getNextPowerOf2(i2 + i)];
            byte[] bArr2 = this.data;
            System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
            this.data = bArr;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte[] getCompactData() {
        int iAvailable = available();
        if (iAvailable <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[iAvailable];
        System.arraycopy(this.data, this.rpos, bArr, 0, iAvailable);
        return bArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String printHex() {
        return ByteArrayUtils.printHex(array(), rpos(), available());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Buffer<T> putBoolean(boolean z) {
        return putByte(z ? (byte) 1 : (byte) 0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Buffer<T> putBuffer(Buffer<? extends Buffer<?>> buffer) {
        if (buffer != null) {
            int iAvailable = buffer.available();
            ensureCapacity(iAvailable);
            System.arraycopy(buffer.data, buffer.rpos, this.data, this.wpos, iAvailable);
            this.wpos += iAvailable;
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Buffer<T> putByte(byte b) {
        ensureCapacity(1);
        byte[] bArr = this.data;
        int i = this.wpos;
        this.wpos = i + 1;
        bArr[i] = b;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Buffer<T> putLong(long j) {
        return putLong(j, this.endianness);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Buffer<T> putRawBytes(byte[] bArr, int i, int i2) {
        ensureCapacity(i2);
        System.arraycopy(bArr, i, this.data, this.wpos, i2);
        this.wpos += i2;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Buffer<T> putUInt16(int i) {
        return putUInt16(i, this.endianness);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Buffer<T> putUInt24(int i) {
        return putUInt24(i, this.endianness);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Buffer<T> putUInt32(long j) {
        return putUInt32(j, this.endianness);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Buffer<T> putUInt64(long j) {
        return putUInt64(j, this.endianness);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean readBoolean() {
        return readByte() != 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public byte readByte() throws BufferException {
        ensureAvailable(1);
        byte[] bArr = this.data;
        int i = this.rpos;
        this.rpos = i + 1;
        return bArr[i];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long readLong() {
        return readLong(this.endianness);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void readRawBytes(byte[] bArr, int i, int i2) throws BufferException {
        ensureAvailable(i2);
        System.arraycopy(this.data, this.rpos, bArr, i, i2);
        this.rpos += i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int readUInt16() {
        return readUInt16(this.endianness);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int readUInt24() {
        return readUInt24(this.endianness);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long readUInt32() {
        return readUInt32(this.endianness);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int readUInt32AsInt() {
        return (int) readUInt32();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long readUInt64() {
        return readUInt64(this.endianness);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int rpos() {
        return this.rpos;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Buffer<T> skip(int i) throws BufferException {
        ensureAvailable(i);
        this.rpos += i;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return "Buffer [rpos=" + this.rpos + ", wpos=" + this.wpos + ", size=" + this.data.length + "]";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void wpos(int i) {
        ensureCapacity(i - this.wpos);
        this.wpos = i;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class PlainBuffer extends Buffer<PlainBuffer> {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public PlainBuffer(Endian endian) {
            super(endian);
        }

        public PlainBuffer(Buffer<?> buffer) {
            super(buffer);
        }

        public PlainBuffer(byte[] bArr, Endian endian) {
            super(bArr, endian);
        }

        public PlainBuffer(int i, Endian endian) {
            super(i, endian);
        }
    }

    public void rpos(int i) {
        this.rpos = i;
    }

    public Buffer<T> putLong(long j, Endian endian) {
        endian.writeLong(this, j);
        return this;
    }

    public Buffer<T> putUInt16(int i, Endian endian) {
        endian.writeUInt16(this, i);
        return this;
    }

    public Buffer<T> putUInt24(int i, Endian endian) {
        endian.writeUInt24(this, i);
        return this;
    }

    public Buffer<T> putUInt32(long j, Endian endian) {
        endian.writeUInt32(this, j);
        return this;
    }

    public Buffer<T> putUInt64(long j, Endian endian) {
        endian.writeUInt64(this, j);
        return this;
    }

    public long readLong(Endian endian) {
        return endian.readLong(this);
    }

    public int readUInt16(Endian endian) {
        return endian.readUInt16(this);
    }

    public int readUInt24(Endian endian) {
        return endian.readUInt24(this);
    }

    public long readUInt32(Endian endian) {
        return endian.readUInt32(this);
    }

    public long readUInt64(Endian endian) {
        return endian.readUInt64(this);
    }

    public int wpos() {
        return this.wpos;
    }

    /* JADX INFO: renamed from: com.hierynomus.protocol.commons.buffer.Buffer$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class AnonymousClass1 extends InputStream implements InputStreamRetargetInterface {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public AnonymousClass1() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.InputStream
        public int available() {
            return Buffer.this.available();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.InputStream
        public int read() throws IOException {
            try {
                return Buffer.this.readByte() & 255;
            } catch (BufferException e) {
                throw new IOException(e);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.InputStream
        public long skip(long j) {
            Buffer.this.rpos((int) j);
            return j;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.io.InputStream, j$.io.InputStreamRetargetInterface
        public /* synthetic */ long transferTo(OutputStream outputStream) {
            return DesugarInputStream.transferTo(this, outputStream);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) throws IOException {
            try {
                Buffer.this.readRawBytes(bArr);
                return bArr.length;
            } catch (BufferException e) {
                throw new IOException(e);
            }
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) {
            return super.read(bArr, i, i2);
        }
    }

    public Buffer<T> putRawBytes(byte[] bArr) {
        return putRawBytes(bArr, 0, bArr.length);
    }

    public void readRawBytes(byte[] bArr) throws BufferException {
        readRawBytes(bArr, 0, bArr.length);
    }

    public byte[] readRawBytes(int i) throws BufferException {
        byte[] bArr = new byte[i];
        readRawBytes(bArr);
        return bArr;
    }

    public Buffer(Endian endian) {
        this(DEFAULT_SIZE, endian);
    }

    public Buffer(byte[] bArr, Endian endian) {
        this(bArr, true, endian);
    }

    public Buffer(int i, Endian endian) {
        this(new byte[getNextPowerOf2(i)], false, endian);
    }

    private Buffer(byte[] bArr, boolean z, Endian endian) {
        this.data = bArr;
        this.endianness = endian;
        this.rpos = 0;
        this.wpos = z ? bArr.length : 0;
    }

    public Buffer<T> putString(String str, Charset charset) {
        return putString(str, charset, this.endianness);
    }

    public Buffer<T> putNullTerminatedString(String str, Charset charset) {
        return putNullTerminatedString(str, charset, this.endianness);
    }

    public String readString(Charset charset, int i) {
        return readString(charset, i, this.endianness);
    }

    public String readString(String str, int i) {
        return readString(Charset.forName(str), i, this.endianness);
    }

    public String readNullTerminatedString(Charset charset) {
        return readNullTerminatedString(charset, this.endianness);
    }
}
