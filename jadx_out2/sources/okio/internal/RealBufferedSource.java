package okio.internal;

import defpackage.a;
import defpackage.e04;
import defpackage.eb3;
import defpackage.kl;
import defpackage.ll;
import defpackage.ml;
import defpackage.zs;
import java.io.EOFException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Timeout;

/* JADX INFO: renamed from: okio.internal.-RealBufferedSource, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class RealBufferedSource {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void commonClose(okio.RealBufferedSource realBufferedSource) throws EOFException {
        realBufferedSource.getClass();
        if (realBufferedSource.closed) {
            return;
        }
        realBufferedSource.closed = true;
        realBufferedSource.source.close();
        realBufferedSource.bufferField.clear();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final boolean commonExhausted(okio.RealBufferedSource realBufferedSource) {
        realBufferedSource.getClass();
        if (!realBufferedSource.closed) {
            return realBufferedSource.bufferField.exhausted() && realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1;
        }
        e04.a("closed");
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final long commonIndexOf(okio.RealBufferedSource realBufferedSource, ByteString byteString, int i, int i2, long j, long j2) {
        realBufferedSource.getClass();
        byteString.getClass();
        int i3 = i;
        int i4 = i2;
        long j3 = i4;
        SegmentedByteString.checkOffsetAndCount(byteString.size(), i3, j3);
        if (realBufferedSource.closed) {
            e04.a("closed");
            return 0L;
        }
        long jMax = j;
        while (true) {
            long j4 = jMax;
            long jCommonIndexOf = Buffer.commonIndexOf(realBufferedSource.bufferField, byteString, j4, j2, i3, i4);
            if (jCommonIndexOf != -1) {
                return jCommonIndexOf;
            }
            long size = (realBufferedSource.bufferField.size() - j3) + 1;
            if (size >= j2 || !isMatchPossibleByExpandingBuffer(realBufferedSource.bufferField, byteString, i, i2, j4, j2) || realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                return -1L;
            }
            jMax = Math.max(j4, size);
            i3 = i;
            i4 = i2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ long commonIndexOf$default(okio.RealBufferedSource realBufferedSource, ByteString byteString, int i, int i2, long j, long j2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = byteString.size();
        }
        return commonIndexOf(realBufferedSource, byteString, i4, i2, j, (i3 & 16) != 0 ? Long.MAX_VALUE : j2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final long commonIndexOfElement(okio.RealBufferedSource realBufferedSource, ByteString byteString, long j) {
        realBufferedSource.getClass();
        byteString.getClass();
        if (realBufferedSource.closed) {
            e04.a("closed");
            return 0L;
        }
        while (true) {
            long jIndexOfElement = realBufferedSource.bufferField.indexOfElement(byteString, j);
            if (jIndexOfElement != -1) {
                return jIndexOfElement;
            }
            long size = realBufferedSource.bufferField.size();
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                return -1L;
            }
            j = Math.max(j, size);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final BufferedSource commonPeek(okio.RealBufferedSource realBufferedSource) {
        realBufferedSource.getClass();
        return Okio.buffer(new PeekSource(realBufferedSource));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final boolean commonRangeEquals(okio.RealBufferedSource realBufferedSource, long j, ByteString byteString, int i, int i2) {
        realBufferedSource.getClass();
        byteString.getClass();
        if (!realBufferedSource.closed) {
            return i2 >= 0 && j >= 0 && i >= 0 && i + i2 <= byteString.size() && (i2 == 0 || commonIndexOf(realBufferedSource, byteString, i, i2, j, j + 1) != -1);
        }
        e04.a("closed");
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final long commonRead(okio.RealBufferedSource realBufferedSource, Buffer buffer, long j) {
        realBufferedSource.getClass();
        buffer.getClass();
        if (j < 0) {
            eb3.a("byteCount < 0: ", j);
            return 0L;
        }
        if (realBufferedSource.closed) {
            e04.a("closed");
            return 0L;
        }
        if (realBufferedSource.bufferField.size() == 0) {
            if (j == 0) {
                return 0L;
            }
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                return -1L;
            }
        }
        return realBufferedSource.bufferField.read(buffer, Math.min(j, realBufferedSource.bufferField.size()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final long commonReadAll(okio.RealBufferedSource realBufferedSource, Sink sink) {
        Buffer buffer;
        realBufferedSource.getClass();
        sink.getClass();
        long j = 0;
        while (true) {
            long j2 = realBufferedSource.source.read(realBufferedSource.bufferField, 8192L);
            buffer = realBufferedSource.bufferField;
            if (j2 == -1) {
                break;
            }
            long jCompleteSegmentByteCount = buffer.completeSegmentByteCount();
            if (jCompleteSegmentByteCount > 0) {
                j += jCompleteSegmentByteCount;
                sink.write(realBufferedSource.bufferField, jCompleteSegmentByteCount);
            }
        }
        if (buffer.size() <= 0) {
            return j;
        }
        long size = j + realBufferedSource.bufferField.size();
        Buffer buffer2 = realBufferedSource.bufferField;
        sink.write(buffer2, buffer2.size());
        return size;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final byte commonReadByte(okio.RealBufferedSource realBufferedSource) throws EOFException {
        realBufferedSource.getClass();
        realBufferedSource.require(1L);
        return realBufferedSource.bufferField.readByte();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final byte[] commonReadByteArray(okio.RealBufferedSource realBufferedSource) {
        realBufferedSource.getClass();
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteArray();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final ByteString commonReadByteString(okio.RealBufferedSource realBufferedSource) {
        realBufferedSource.getClass();
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final long commonReadDecimalLong(okio.RealBufferedSource realBufferedSource) throws EOFException {
        byte b;
        realBufferedSource.getClass();
        realBufferedSource.require(1L);
        long j = 0;
        while (true) {
            long j2 = j + 1;
            if (!realBufferedSource.request(j2)) {
                break;
            }
            b = realBufferedSource.bufferField.getByte(j);
            if ((b < 48 || b > 57) && !(j == 0 && b == 45)) {
                break;
            }
            j = j2;
        }
        if (j == 0) {
            String string = Integer.toString(b, zs.a(16));
            string.getClass();
            kl.a("Expected a digit or '-' but was 0x", string);
            return 0L;
        }
        return realBufferedSource.bufferField.readDecimalLong();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void commonReadFully(okio.RealBufferedSource realBufferedSource, byte[] bArr) throws EOFException {
        realBufferedSource.getClass();
        bArr.getClass();
        try {
            realBufferedSource.require(bArr.length);
            realBufferedSource.bufferField.readFully(bArr);
        } catch (EOFException e) {
            int i = 0;
            while (realBufferedSource.bufferField.size() > 0) {
                Buffer buffer = realBufferedSource.bufferField;
                int i2 = buffer.read(bArr, i, (int) buffer.size());
                if (i2 == -1) {
                    throw new AssertionError();
                }
                i += i2;
            }
            throw e;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final long commonReadHexadecimalUnsignedLong(okio.RealBufferedSource realBufferedSource) throws EOFException {
        byte b;
        realBufferedSource.getClass();
        realBufferedSource.require(1L);
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (!realBufferedSource.request(i2)) {
                break;
            }
            b = realBufferedSource.bufferField.getByte(i);
            if ((b < 48 || b > 57) && ((b < 97 || b > 102) && (b < 65 || b > 70))) {
                break;
            }
            i = i2;
        }
        if (i == 0) {
            String string = Integer.toString(b, zs.a(16));
            string.getClass();
            kl.a("Expected leading [0-9a-fA-F] character but was 0x", string);
            return 0L;
        }
        return realBufferedSource.bufferField.readHexadecimalUnsignedLong();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final int commonReadInt(okio.RealBufferedSource realBufferedSource) throws EOFException {
        realBufferedSource.getClass();
        realBufferedSource.require(4L);
        return realBufferedSource.bufferField.readInt();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final int commonReadIntLe(okio.RealBufferedSource realBufferedSource) throws EOFException {
        realBufferedSource.getClass();
        realBufferedSource.require(4L);
        return realBufferedSource.bufferField.readIntLe();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final long commonReadLong(okio.RealBufferedSource realBufferedSource) throws EOFException {
        realBufferedSource.getClass();
        realBufferedSource.require(8L);
        return realBufferedSource.bufferField.readLong();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final long commonReadLongLe(okio.RealBufferedSource realBufferedSource) throws EOFException {
        realBufferedSource.getClass();
        realBufferedSource.require(8L);
        return realBufferedSource.bufferField.readLongLe();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final short commonReadShort(okio.RealBufferedSource realBufferedSource) throws EOFException {
        realBufferedSource.getClass();
        realBufferedSource.require(2L);
        return realBufferedSource.bufferField.readShort();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final short commonReadShortLe(okio.RealBufferedSource realBufferedSource) throws EOFException {
        realBufferedSource.getClass();
        realBufferedSource.require(2L);
        return realBufferedSource.bufferField.readShortLe();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final String commonReadUtf8(okio.RealBufferedSource realBufferedSource) {
        realBufferedSource.getClass();
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readUtf8();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final int commonReadUtf8CodePoint(okio.RealBufferedSource realBufferedSource) throws EOFException {
        realBufferedSource.getClass();
        realBufferedSource.require(1L);
        byte b = realBufferedSource.bufferField.getByte(0L);
        if ((b & 224) == 192) {
            realBufferedSource.require(2L);
        } else if ((b & 240) == 224) {
            realBufferedSource.require(3L);
        } else if ((b & 248) == 240) {
            realBufferedSource.require(4L);
        }
        return realBufferedSource.bufferField.readUtf8CodePoint();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final String commonReadUtf8Line(okio.RealBufferedSource realBufferedSource) {
        realBufferedSource.getClass();
        long jIndexOf = realBufferedSource.indexOf((byte) 10);
        Buffer buffer = realBufferedSource.bufferField;
        if (jIndexOf != -1) {
            return Buffer.readUtf8Line(buffer, jIndexOf);
        }
        if (buffer.size() != 0) {
            return realBufferedSource.readUtf8(realBufferedSource.bufferField.size());
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final String commonReadUtf8LineStrict(okio.RealBufferedSource realBufferedSource, long j) throws EOFException {
        realBufferedSource.getClass();
        if (j < 0) {
            eb3.a("limit < 0: ", j);
            return null;
        }
        long j2 = j == Long.MAX_VALUE ? Long.MAX_VALUE : j + 1;
        long jIndexOf = realBufferedSource.indexOf((byte) 10, 0L, j2);
        if (jIndexOf != -1) {
            return Buffer.readUtf8Line(realBufferedSource.bufferField, jIndexOf);
        }
        if (j2 < Long.MAX_VALUE && realBufferedSource.request(j2) && realBufferedSource.bufferField.getByte(j2 - 1) == 13 && realBufferedSource.request(j2 + 1) && realBufferedSource.bufferField.getByte(j2) == 10) {
            return Buffer.readUtf8Line(realBufferedSource.bufferField, j2);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = realBufferedSource.bufferField;
        buffer2.copyTo(buffer, 0L, Math.min(32L, buffer2.size()));
        ml.a(Math.min(realBufferedSource.bufferField.size(), j), buffer.readByteString().hex());
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final boolean commonRequest(okio.RealBufferedSource realBufferedSource, long j) {
        realBufferedSource.getClass();
        if (j < 0) {
            eb3.a("byteCount < 0: ", j);
            return false;
        }
        if (realBufferedSource.closed) {
            e04.a("closed");
            return false;
        }
        while (realBufferedSource.bufferField.size() < j) {
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void commonRequire(okio.RealBufferedSource realBufferedSource, long j) throws EOFException {
        realBufferedSource.getClass();
        if (realBufferedSource.request(j)) {
            return;
        }
        ll.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final int commonSelect(okio.RealBufferedSource realBufferedSource, Options options) throws EOFException {
        realBufferedSource.getClass();
        options.getClass();
        if (realBufferedSource.closed) {
            e04.a("closed");
            return 0;
        }
        do {
            int iSelectPrefix = Buffer.selectPrefix(realBufferedSource.bufferField, options, true);
            if (iSelectPrefix != -2) {
                if (iSelectPrefix == -1) {
                    return -1;
                }
                realBufferedSource.bufferField.skip(options.getByteStrings$okio()[iSelectPrefix].size());
                return iSelectPrefix;
            }
        } while (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) != -1);
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void commonSkip(okio.RealBufferedSource realBufferedSource, long j) throws EOFException {
        realBufferedSource.getClass();
        if (realBufferedSource.closed) {
            e04.a("closed");
            return;
        }
        while (j > 0) {
            if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                ll.a();
                return;
            } else {
                long jMin = Math.min(j, realBufferedSource.bufferField.size());
                realBufferedSource.bufferField.skip(jMin);
                j -= jMin;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final Timeout commonTimeout(okio.RealBufferedSource realBufferedSource) {
        realBufferedSource.getClass();
        return realBufferedSource.source.timeout();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final String commonToString(okio.RealBufferedSource realBufferedSource) {
        realBufferedSource.getClass();
        return "buffer(" + realBufferedSource.source + ')';
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private static final boolean isMatchPossibleByExpandingBuffer(Buffer buffer, ByteString byteString, int i, int i2, long j, long j2) {
        if (buffer.size() < j2) {
            return true;
        }
        int iMax = (int) Math.max(1L, (buffer.size() - j2) + 1);
        int iMin = ((int) Math.min(i2, (buffer.size() - j) + 1)) - 1;
        if (iMax > iMin) {
            return false;
        }
        int i3 = iMin;
        while (true) {
            Buffer buffer2 = buffer;
            ByteString byteString2 = byteString;
            int i4 = i;
            if (buffer2.rangeEquals(buffer.size() - ((long) i3), byteString2, i4, i3)) {
                return true;
            }
            if (i3 == iMax) {
                return false;
            }
            i3--;
            buffer = buffer2;
            byteString = byteString2;
            i = i4;
        }
    }

    public static final byte[] commonReadByteArray(okio.RealBufferedSource realBufferedSource, long j) throws EOFException {
        realBufferedSource.getClass();
        realBufferedSource.require(j);
        return realBufferedSource.bufferField.readByteArray(j);
    }

    public static final ByteString commonReadByteString(okio.RealBufferedSource realBufferedSource, long j) throws EOFException {
        realBufferedSource.getClass();
        realBufferedSource.require(j);
        return realBufferedSource.bufferField.readByteString(j);
    }

    public static final String commonReadUtf8(okio.RealBufferedSource realBufferedSource, long j) throws EOFException {
        realBufferedSource.getClass();
        realBufferedSource.require(j);
        return realBufferedSource.bufferField.readUtf8(j);
    }

    public static final void commonReadFully(okio.RealBufferedSource realBufferedSource, Buffer buffer, long j) throws EOFException {
        realBufferedSource.getClass();
        buffer.getClass();
        try {
            realBufferedSource.require(j);
            realBufferedSource.bufferField.readFully(buffer, j);
        } catch (EOFException e) {
            buffer.writeAll(realBufferedSource.bufferField);
            throw e;
        }
    }

    public static final int commonRead(okio.RealBufferedSource realBufferedSource, byte[] bArr, int i, int i2) {
        realBufferedSource.getClass();
        bArr.getClass();
        long j = i2;
        SegmentedByteString.checkOffsetAndCount(bArr.length, i, j);
        if (realBufferedSource.bufferField.size() == 0) {
            if (i2 == 0) {
                return 0;
            }
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                return -1;
            }
        }
        return realBufferedSource.bufferField.read(bArr, i, (int) Math.min(j, realBufferedSource.bufferField.size()));
    }

    public static final long commonIndexOf(okio.RealBufferedSource realBufferedSource, byte b, long j, long j2) {
        realBufferedSource.getClass();
        if (realBufferedSource.closed) {
            e04.a("closed");
            return 0L;
        }
        if (0 > j || j > j2) {
            a.a("fromIndex=", j, " toIndex=", j2);
            return 0L;
        }
        long jMax = j;
        while (jMax < j2) {
            byte b2 = b;
            long j3 = j2;
            long jIndexOf = realBufferedSource.bufferField.indexOf(b2, jMax, j3);
            if (jIndexOf != -1) {
                return jIndexOf;
            }
            long size = realBufferedSource.bufferField.size();
            if (size >= j3 || realBufferedSource.source.read(realBufferedSource.bufferField, 8192L) == -1) {
                break;
            }
            jMax = Math.max(jMax, size);
            b = b2;
            j2 = j3;
        }
        return -1L;
    }
}
