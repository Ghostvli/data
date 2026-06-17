package okio;

import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface BufferedSource extends Source, ReadableByteChannel {
    Buffer buffer();

    boolean exhausted();

    Buffer getBuffer();

    long indexOf(byte b);

    long indexOf(byte b, long j);

    long indexOf(byte b, long j, long j2);

    long indexOf(ByteString byteString);

    long indexOf(ByteString byteString, long j);

    long indexOf(ByteString byteString, long j, long j2);

    long indexOfElement(ByteString byteString);

    long indexOfElement(ByteString byteString, long j);

    InputStream inputStream();

    BufferedSource peek();

    boolean rangeEquals(long j, ByteString byteString);

    boolean rangeEquals(long j, ByteString byteString, int i, int i2);

    int read(byte[] bArr);

    int read(byte[] bArr, int i, int i2);

    long readAll(Sink sink);

    byte readByte();

    byte[] readByteArray();

    byte[] readByteArray(long j);

    ByteString readByteString();

    ByteString readByteString(long j);

    long readDecimalLong();

    void readFully(Buffer buffer, long j);

    void readFully(byte[] bArr);

    long readHexadecimalUnsignedLong();

    int readInt();

    int readIntLe();

    long readLong();

    long readLongLe();

    short readShort();

    short readShortLe();

    String readString(long j, Charset charset);

    String readString(Charset charset);

    String readUtf8();

    String readUtf8(long j);

    int readUtf8CodePoint();

    String readUtf8Line();

    String readUtf8LineStrict();

    String readUtf8LineStrict(long j);

    boolean request(long j);

    void require(long j);

    int select(Options options);

    <T> T select(TypedOptions<T> typedOptions);

    void skip(long j);
}
