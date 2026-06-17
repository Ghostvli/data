package okhttp3.internal.http2;

import defpackage.il1;
import defpackage.qk1;
import defpackage.sb1;
import defpackage.we0;
import defpackage.xn3;
import defpackage.ye5;
import defpackage.ze5;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal._UtilCommonKt;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class Http2Reader implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger;
    private final boolean client;
    private final ContinuationSource continuation;
    private final Hpack.Reader hpackReader;
    private final BufferedSource source;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class ContinuationSource implements Source {
        private int flags;
        private int left;
        private int length;
        private int padding;
        private final BufferedSource source;
        private int streamId;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public ContinuationSource(BufferedSource bufferedSource) {
            bufferedSource.getClass();
            this.source = bufferedSource;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        private final void readContinuationHeader() throws IOException {
            int i = this.streamId;
            int medium = _UtilCommonKt.readMedium(this.source);
            this.left = medium;
            this.length = medium;
            int iAnd = _UtilCommonKt.and(this.source.readByte(), 255);
            this.flags = _UtilCommonKt.and(this.source.readByte(), 255);
            Companion companion = Http2Reader.Companion;
            if (companion.getLogger().isLoggable(Level.FINE)) {
                companion.getLogger().fine(Http2.INSTANCE.frameLog(true, this.streamId, this.length, iAnd, this.flags));
            }
            int i2 = this.source.readInt() & Integer.MAX_VALUE;
            this.streamId = i2;
            if (iAnd == 9) {
                if (i2 == i) {
                    return;
                }
                sb1.a("TYPE_CONTINUATION streamId changed");
            } else {
                throw new IOException(iAnd + " != TYPE_CONTINUATION");
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int getFlags() {
            return this.flags;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int getLeft() {
            return this.left;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int getLength() {
            return this.length;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int getPadding() {
            return this.padding;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int getStreamId() {
            return this.streamId;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okio.Source
        public long read(Buffer buffer, long j) throws IOException {
            buffer.getClass();
            while (true) {
                int i = this.left;
                BufferedSource bufferedSource = this.source;
                if (i != 0) {
                    long j2 = bufferedSource.read(buffer, Math.min(j, i));
                    if (j2 == -1) {
                        return -1L;
                    }
                    this.left -= (int) j2;
                    return j2;
                }
                bufferedSource.skip(this.padding);
                this.padding = 0;
                if ((this.flags & 4) != 0) {
                    return -1L;
                }
                readContinuationHeader();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void setFlags(int i) {
            this.flags = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void setLeft(int i) {
            this.left = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void setLength(int i) {
            this.length = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void setPadding(int i) {
            this.padding = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void setStreamId(int i) {
            this.streamId = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // okio.Source
        public Timeout timeout() {
            return this.source.timeout();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface Handler {
        void ackSettings();

        void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j);

        void data(boolean z, int i, BufferedSource bufferedSource, int i2);

        void goAway(int i, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z, int i, int i2, List<Header> list);

        void ping(boolean z, int i, int i2);

        void priority(int i, int i2, int i3, boolean z);

        void pushPromise(int i, int i2, List<Header> list);

        void rstStream(int i, ErrorCode errorCode);

        void settings(boolean z, Settings settings);

        void windowUpdate(int i, long j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        Logger logger2 = Logger.getLogger(Http2.class.getName());
        logger2.getClass();
        logger = logger2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Http2Reader(BufferedSource bufferedSource, boolean z) {
        bufferedSource.getClass();
        this.source = bufferedSource;
        this.client = z;
        ContinuationSource continuationSource = new ContinuationSource(bufferedSource);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(continuationSource, okio.internal.Buffer.SEGMENTING_THRESHOLD, 0, 4, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final void readData(Handler handler, int i, int i2, int i3) throws IOException {
        if (i3 == 0) {
            sb1.a("PROTOCOL_ERROR: TYPE_DATA streamId == 0");
            return;
        }
        boolean z = (i2 & 1) != 0;
        if ((i2 & 32) != 0) {
            sb1.a("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA");
            return;
        }
        int iAnd = (i2 & 8) != 0 ? _UtilCommonKt.and(this.source.readByte(), 255) : 0;
        handler.data(z, i3, this.source, Companion.lengthWithoutPadding(i, i2, iAnd));
        this.source.skip(iAnd);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final void readGoAway(Handler handler, int i, int i2, int i3) throws IOException {
        if (i < 8) {
            ye5.a("TYPE_GOAWAY length < 8: ", i);
            return;
        }
        if (i3 != 0) {
            sb1.a("TYPE_GOAWAY streamId != 0");
            return;
        }
        int i4 = this.source.readInt();
        int i5 = this.source.readInt();
        int i6 = i - 8;
        ErrorCode errorCodeFromHttp2 = ErrorCode.Companion.fromHttp2(i5);
        if (errorCodeFromHttp2 == null) {
            ye5.a("TYPE_GOAWAY unexpected error code: ", i5);
            return;
        }
        ByteString byteString = ByteString.EMPTY;
        if (i6 > 0) {
            byteString = this.source.readByteString(i6);
        }
        handler.goAway(i4, errorCodeFromHttp2, byteString);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final List<Header> readHeaderBlock(int i, int i2, int i3, int i4) throws IOException {
        this.continuation.setLeft(i);
        ContinuationSource continuationSource = this.continuation;
        continuationSource.setLength(continuationSource.getLeft());
        this.continuation.setPadding(i2);
        this.continuation.setFlags(i3);
        this.continuation.setStreamId(i4);
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final void readHeaders(Handler handler, int i, int i2, int i3) throws IOException {
        if (i3 == 0) {
            sb1.a("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
            return;
        }
        boolean z = (i2 & 1) != 0;
        int iAnd = (i2 & 8) != 0 ? _UtilCommonKt.and(this.source.readByte(), 255) : 0;
        if ((i2 & 32) != 0) {
            readPriority(handler, i3);
            i -= 5;
        }
        handler.headers(z, i3, -1, readHeaderBlock(Companion.lengthWithoutPadding(i, i2, iAnd), iAnd, i2, i3));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final void readPing(Handler handler, int i, int i2, int i3) throws IOException {
        if (i != 8) {
            ye5.a("TYPE_PING length != 8: ", i);
        } else {
            if (i3 != 0) {
                sb1.a("TYPE_PING streamId != 0");
                return;
            }
            handler.ping((i2 & 1) != 0, this.source.readInt(), this.source.readInt());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final void readPriority(Handler handler, int i, int i2, int i3) throws IOException {
        if (i != 5) {
            throw new IOException("TYPE_PRIORITY length: " + i + " != 5");
        }
        if (i3 != 0) {
            readPriority(handler, i3);
        } else {
            sb1.a("TYPE_PRIORITY streamId == 0");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final void readPushPromise(Handler handler, int i, int i2, int i3) throws IOException {
        if (i3 == 0) {
            sb1.a("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        } else {
            int iAnd = (i2 & 8) != 0 ? _UtilCommonKt.and(this.source.readByte(), 255) : 0;
            handler.pushPromise(i3, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(Companion.lengthWithoutPadding(i - 4, i2, iAnd), iAnd, i2, i3));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final void readRstStream(Handler handler, int i, int i2, int i3) throws IOException {
        if (i != 4) {
            throw new IOException("TYPE_RST_STREAM length: " + i + " != 4");
        }
        if (i3 == 0) {
            sb1.a("TYPE_RST_STREAM streamId == 0");
            return;
        }
        int i4 = this.source.readInt();
        ErrorCode errorCodeFromHttp2 = ErrorCode.Companion.fromHttp2(i4);
        if (errorCodeFromHttp2 != null) {
            handler.rstStream(i3, errorCodeFromHttp2);
        } else {
            ye5.a("TYPE_RST_STREAM unexpected error code: ", i4);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0060, code lost:
    
        defpackage.ye5.a("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0065, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void readSettings(Handler handler, int i, int i2, int i3) throws IOException {
        if (i3 != 0) {
            sb1.a("TYPE_SETTINGS streamId != 0");
            return;
        }
        if ((i2 & 1) != 0) {
            if (i == 0) {
                handler.ackSettings();
                return;
            } else {
                sb1.a("FRAME_SIZE_ERROR ack frame should be empty!");
                return;
            }
        }
        if (i % 6 != 0) {
            ye5.a("TYPE_SETTINGS length % 6 != 0: ", i);
            return;
        }
        Settings settings = new Settings();
        qk1 qk1VarI = xn3.i(xn3.j(0, i), 6);
        int iB = qk1VarI.b();
        int iC = qk1VarI.c();
        int iD = qk1VarI.d();
        if ((iD > 0 && iB <= iC) || (iD < 0 && iC <= iB)) {
            while (true) {
                int iAnd = _UtilCommonKt.and(this.source.readShort(), Settings.DEFAULT_INITIAL_WINDOW_SIZE);
                int i4 = this.source.readInt();
                if (iAnd != 2) {
                    if (iAnd != 4) {
                        if (iAnd == 5 && (i4 < 16384 || i4 > 16777215)) {
                            break;
                        }
                    } else if (i4 < 0) {
                        sb1.a("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1");
                        return;
                    }
                } else if (i4 != 0 && i4 != 1) {
                    sb1.a("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1");
                    return;
                }
                settings.set(iAnd, i4);
                if (iB == iC) {
                    break;
                } else {
                    iB += iD;
                }
            }
        }
        handler.settings(false, settings);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final void readWindowUpdate(Handler handler, int i, int i2, int i3) throws Exception {
        int i4;
        try {
            if (i != 4) {
                throw new IOException("TYPE_WINDOW_UPDATE length !=4: " + i);
            }
            try {
                long jAnd = _UtilCommonKt.and(this.source.readInt(), 2147483647L);
                if (jAnd == 0) {
                    throw new IOException("windowSizeIncrement was 0");
                }
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    i4 = i3;
                    logger2.fine(Http2.INSTANCE.frameLogWindowUpdate(true, i3, i, jAnd));
                } else {
                    i4 = i3;
                }
                handler.windowUpdate(i4, jAnd);
            } catch (Exception e) {
                e = e;
                Exception exc = e;
                logger.fine(Http2.INSTANCE.frameLog(true, i3, i, 8, i2));
                throw exc;
            }
        } catch (Exception e2) {
            e = e2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.source.close();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean nextFrame(boolean z, Handler handler) throws Exception {
        handler.getClass();
        try {
            this.source.require(9L);
            int medium = _UtilCommonKt.readMedium(this.source);
            if (medium > 16384) {
                ye5.a("FRAME_SIZE_ERROR: ", medium);
                return false;
            }
            int iAnd = _UtilCommonKt.and(this.source.readByte(), 255);
            int iAnd2 = _UtilCommonKt.and(this.source.readByte(), 255);
            int i = this.source.readInt() & Integer.MAX_VALUE;
            if (iAnd != 8) {
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    logger2.fine(Http2.INSTANCE.frameLog(true, i, medium, iAnd, iAnd2));
                }
            }
            if (z && iAnd != 4) {
                ze5.a("Expected a SETTINGS frame but was ", Http2.INSTANCE.formattedType$okhttp(iAnd));
                return false;
            }
            switch (iAnd) {
                case 0:
                    readData(handler, medium, iAnd2, i);
                    return true;
                case 1:
                    readHeaders(handler, medium, iAnd2, i);
                    return true;
                case 2:
                    readPriority(handler, medium, iAnd2, i);
                    return true;
                case 3:
                    readRstStream(handler, medium, iAnd2, i);
                    return true;
                case 4:
                    readSettings(handler, medium, iAnd2, i);
                    return true;
                case 5:
                    readPushPromise(handler, medium, iAnd2, i);
                    return true;
                case 6:
                    readPing(handler, medium, iAnd2, i);
                    return true;
                case 7:
                    readGoAway(handler, medium, iAnd2, i);
                    return true;
                case 8:
                    readWindowUpdate(handler, medium, iAnd2, i);
                    return true;
                default:
                    this.source.skip(medium);
                    return true;
            }
        } catch (EOFException unused) {
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void readConnectionPreface(Handler handler) throws IOException {
        handler.getClass();
        if (this.client) {
            if (nextFrame(true, handler)) {
                return;
            }
            sb1.a("Required SETTINGS preface not received");
            return;
        }
        BufferedSource bufferedSource = this.source;
        ByteString byteString = Http2.CONNECTION_PREFACE;
        ByteString byteString2 = bufferedSource.readByteString(byteString.size());
        Logger logger2 = logger;
        if (logger2.isLoggable(Level.FINE)) {
            logger2.fine(_UtilJvmKt.format("<< CONNECTION " + byteString2.hex(), new Object[0]));
        }
        if (il1.a(byteString, byteString2)) {
            return;
        }
        ze5.a("Expected a connection header but was ", byteString2.utf8());
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: okhttp3.internal.http2.Http2Reader.Companion.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final Logger getLogger() {
            return Http2Reader.logger;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final int lengthWithoutPadding(int i, int i2, int i3) throws IOException {
            if ((i2 & 8) != 0) {
                i--;
            }
            if (i3 <= i) {
                return i - i3;
            }
            throw new IOException("PROTOCOL_ERROR padding " + i3 + " > remaining length " + i);
        }

        private Companion() {
        }
    }

    private final void readPriority(Handler handler, int i) {
        int i2 = this.source.readInt();
        handler.priority(i, i2 & Integer.MAX_VALUE, _UtilCommonKt.and(this.source.readByte(), 255) + 1, (Integer.MIN_VALUE & i2) != 0);
    }
}
