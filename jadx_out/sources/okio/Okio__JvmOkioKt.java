package okio;

import j$.nio.file.Files;
import j$.nio.file.OpenOption;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import okio.internal.DefaultSocket;
import okio.internal.PipeSocket;
import okio.internal.ResourceFileSystem;
import okio.internal.SocketAsyncTimeout;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class Okio__JvmOkioKt {
    public static final Sink appendingSink(File file) {
        file.getClass();
        return Okio.sink(new FileOutputStream(file, true));
    }

    public static final FileSystem asResourceFileSystem(ClassLoader classLoader) {
        classLoader.getClass();
        return new ResourceFileSystem(classLoader, true, null, 4, null);
    }

    public static final CipherSink cipherSink(Sink sink, Cipher cipher) {
        sink.getClass();
        cipher.getClass();
        return new CipherSink(Okio.buffer(sink), cipher);
    }

    public static final CipherSource cipherSource(Source source, Cipher cipher) {
        source.getClass();
        cipher.getClass();
        return new CipherSource(Okio.buffer(source), cipher);
    }

    public static final HashingSink hashingSink(Sink sink, Mac mac) {
        sink.getClass();
        mac.getClass();
        return new HashingSink(sink, mac);
    }

    public static final HashingSource hashingSource(Source source, Mac mac) {
        source.getClass();
        mac.getClass();
        return new HashingSource(source, mac);
    }

    public static final Socket[] inMemorySocketPair(long j) {
        Pipe pipe = new Pipe(j);
        Pipe pipe2 = new Pipe(j);
        return new Socket[]{new PipeSocket(pipe, pipe2), new PipeSocket(pipe2, pipe)};
    }

    public static final Sink sink(java.net.Socket socket) throws IOException {
        socket.getClass();
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.getClass();
        return socketAsyncTimeout.sink(new OutputStreamSink(outputStream, socketAsyncTimeout));
    }

    public static /* synthetic */ Sink sink$default(File file, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return Okio.sink(file, z);
    }

    public static final Socket socket(java.net.Socket socket) {
        socket.getClass();
        return new DefaultSocket(socket);
    }

    public static final Source source(java.net.Socket socket) throws IOException {
        socket.getClass();
        SocketAsyncTimeout socketAsyncTimeout = new SocketAsyncTimeout(socket);
        InputStream inputStream = socket.getInputStream();
        inputStream.getClass();
        return socketAsyncTimeout.source(new InputStreamSource(inputStream, socketAsyncTimeout));
    }

    public static final HashingSink hashingSink(Sink sink, MessageDigest messageDigest) {
        sink.getClass();
        messageDigest.getClass();
        return new HashingSink(sink, messageDigest);
    }

    public static final HashingSource hashingSource(Source source, MessageDigest messageDigest) {
        source.getClass();
        messageDigest.getClass();
        return new HashingSource(source, messageDigest);
    }

    public static final Sink sink(OutputStream outputStream) {
        outputStream.getClass();
        return new OutputStreamSink(outputStream, new Timeout());
    }

    public static final Source source(InputStream inputStream) {
        inputStream.getClass();
        return new InputStreamSource(inputStream, new Timeout());
    }

    public static final Sink sink(File file) {
        file.getClass();
        return sink$default(file, false, 1, null);
    }

    public static final Source source(File file) {
        file.getClass();
        return new InputStreamSource(new FileInputStream(file), Timeout.NONE);
    }

    public static final Sink sink(File file, boolean z) {
        file.getClass();
        return Okio.sink(new FileOutputStream(file, z));
    }

    public static final Source source(j$.nio.file.Path path, OpenOption... openOptionArr) {
        path.getClass();
        openOptionArr.getClass();
        InputStream inputStreamNewInputStream = Files.newInputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        inputStreamNewInputStream.getClass();
        return Okio.source(inputStreamNewInputStream);
    }

    public static final Sink sink(j$.nio.file.Path path, OpenOption... openOptionArr) {
        path.getClass();
        openOptionArr.getClass();
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(path, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        outputStreamNewOutputStream.getClass();
        return Okio.sink(outputStreamNewOutputStream);
    }
}
