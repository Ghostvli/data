package okhttp3.internal.http2;

import defpackage.il1;
import defpackage.sb1;
import defpackage.we0;
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

        public ContinuationSource(BufferedSource bufferedSource) {
            bufferedSource.getClass();
            this.source = bufferedSource;
        }

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

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
        }

        public final int getFlags() {
            return this.flags;
        }

        public final int getLeft() {
            return this.left;
        }

        public final int getLength() {
            return this.length;
        }

        public final int getPadding() {
            return this.padding;
        }

        public final int getStreamId() {
            return this.streamId;
        }

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

        public final void setFlags(int i) {
            this.flags = i;
        }

        public final void setLeft(int i) {
            this.left = i;
        }

        public final void setLength(int i) {
            this.length = i;
        }

        public final void setPadding(int i) {
            this.padding = i;
        }

        public final void setStreamId(int i) {
            this.streamId = i;
        }

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

    static {
        Logger logger2 = Logger.getLogger(Http2.class.getName());
        logger2.getClass();
        logger = logger2;
    }

    public Http2Reader(BufferedSource bufferedSource, boolean z) {
        bufferedSource.getClass();
        this.source = bufferedSource;
        this.client = z;
        ContinuationSource continuationSource = new ContinuationSource(bufferedSource);
        this.continuation = continuationSource;
        this.hpackReader = new Hpack.Reader(continuationSource, okio.internal.Buffer.SEGMENTING_THRESHOLD, 0, 4, null);
    }

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

    private final void readPushPromise(Handler handler, int i, int i2, int i3) throws IOException {
        if (i3 == 0) {
            sb1.a("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        } else {
            int iAnd = (i2 & 8) != 0 ? _UtilCommonKt.and(this.source.readByte(), 255) : 0;
            handler.pushPromise(i3, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(Companion.lengthWithoutPadding(i - 4, i2, iAnd), iAnd, i2, i3));
        }
    }

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

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0060, code lost:
    
        defpackage.ye5.a("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0065, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void readSettings(okhttp3.internal.http2.Http2Reader.Handler r7, int r8, int r9, int r10) throws java.io.IOException {
        /*
            r6 = this;
            if (r10 != 0) goto L8b
            r10 = 1
            r9 = r9 & r10
            if (r9 == 0) goto L12
            if (r8 != 0) goto Lc
            r7.ackSettings()
            return
        Lc:
            java.lang.String r6 = "FRAME_SIZE_ERROR ack frame should be empty!"
            defpackage.sb1.a(r6)
            return
        L12:
            int r9 = r8 % 6
            if (r9 != 0) goto L85
            okhttp3.internal.http2.Settings r9 = new okhttp3.internal.http2.Settings
            r9.<init>()
            r0 = 0
            sk1 r8 = defpackage.xn3.j(r0, r8)
            r1 = 6
            qk1 r8 = defpackage.xn3.i(r8, r1)
            int r1 = r8.b()
            int r2 = r8.c()
            int r8 = r8.d()
            if (r8 <= 0) goto L35
            if (r1 <= r2) goto L39
        L35:
            if (r8 >= 0) goto L81
            if (r2 > r1) goto L81
        L39:
            okio.BufferedSource r3 = r6.source
            short r3 = r3.readShort()
            r4 = 65535(0xffff, float:9.1834E-41)
            int r3 = okhttp3.internal._UtilCommonKt.and(r3, r4)
            okio.BufferedSource r4 = r6.source
            int r4 = r4.readInt()
            r5 = 2
            if (r3 == r5) goto L6f
            r5 = 4
            if (r3 == r5) goto L66
            r5 = 5
            if (r3 == r5) goto L56
            goto L7a
        L56:
            r5 = 16384(0x4000, float:2.2959E-41)
            if (r4 < r5) goto L60
            r5 = 16777215(0xffffff, float:2.3509886E-38)
            if (r4 > r5) goto L60
            goto L7a
        L60:
            java.lang.String r6 = "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "
            defpackage.ye5.a(r6, r4)
            return
        L66:
            if (r4 < 0) goto L69
            goto L7a
        L69:
            java.lang.String r6 = "PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1"
            defpackage.sb1.a(r6)
            return
        L6f:
            if (r4 == 0) goto L7a
            if (r4 != r10) goto L74
            goto L7a
        L74:
            java.lang.String r6 = "PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1"
            defpackage.sb1.a(r6)
            return
        L7a:
            r9.set(r3, r4)
            if (r1 == r2) goto L81
            int r1 = r1 + r8
            goto L39
        L81:
            r7.settings(r0, r9)
            return
        L85:
            java.lang.String r6 = "TYPE_SETTINGS length % 6 != 0: "
            defpackage.ye5.a(r6, r8)
            return
        L8b:
            java.lang.String r6 = "TYPE_SETTINGS streamId != 0"
            defpackage.sb1.a(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Reader.readSettings(okhttp3.internal.http2.Http2Reader$Handler, int, int, int):void");
    }

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

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.source.close();
    }

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
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        public final Logger getLogger() {
            return Http2Reader.logger;
        }

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
