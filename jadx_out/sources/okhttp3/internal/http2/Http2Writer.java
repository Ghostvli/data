package okhttp3.internal.http2;

import defpackage.fw4;
import defpackage.we0;
import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal._UtilJvmKt;
import okhttp3.internal.concurrent.Lockable;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSink;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class Http2Writer implements Closeable, Lockable {
    public static final Companion Companion = new Companion(null);
    private static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private boolean closed;
    private final Buffer hpackBuffer;
    private final Hpack.Writer hpackWriter;
    private int maxFrameSize;
    private final BufferedSink sink;

    public Http2Writer(BufferedSink bufferedSink, boolean z) {
        bufferedSink.getClass();
        this.sink = bufferedSink;
        this.client = z;
        Buffer buffer = new Buffer();
        this.hpackBuffer = buffer;
        this.maxFrameSize = Http2.INITIAL_MAX_FRAME_SIZE;
        this.hpackWriter = new Hpack.Writer(0, false, buffer, 3, null);
    }

    private final void writeContinuationFrames(int i, long j) {
        while (j > 0) {
            long jMin = Math.min(this.maxFrameSize, j);
            j -= jMin;
            frameHeader(i, (int) jMin, 9, j == 0 ? 4 : 0);
            this.sink.write(this.hpackBuffer, jMin);
        }
    }

    public final void applyAndAckSettings(Settings settings) {
        settings.getClass();
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException("closed");
                }
                this.maxFrameSize = settings.getMaxFrameSize(this.maxFrameSize);
                if (settings.getHeaderTableSize() != -1) {
                    this.hpackWriter.resizeHeaderTable(settings.getHeaderTableSize());
                }
                frameHeader(0, 0, 4, 1);
                this.sink.flush();
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        synchronized (this) {
            this.closed = true;
            this.sink.close();
            fw4 fw4Var = fw4.a;
        }
    }

    public final void connectionPreface() {
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException("closed");
                }
                if (this.client) {
                    Logger logger2 = logger;
                    if (logger2.isLoggable(Level.FINE)) {
                        logger2.fine(_UtilJvmKt.format(">> CONNECTION " + Http2.CONNECTION_PREFACE.hex(), new Object[0]));
                    }
                    this.sink.write(Http2.CONNECTION_PREFACE);
                    this.sink.flush();
                    fw4 fw4Var = fw4.a;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void data(boolean z, int i, Buffer buffer, int i2) {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            dataFrame(i, z ? 1 : 0, buffer, i2);
            fw4 fw4Var = fw4.a;
        }
    }

    public final void dataFrame(int i, int i2, Buffer buffer, int i3) {
        frameHeader(i, i3, 0, i2);
        if (i3 > 0) {
            BufferedSink bufferedSink = this.sink;
            buffer.getClass();
            bufferedSink.write(buffer, i3);
        }
    }

    public final void flush() {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            this.sink.flush();
            fw4 fw4Var = fw4.a;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void frameHeader(int r9, int r10, int r11, int r12) {
        /*
            r8 = this;
            r0 = 8
            if (r11 == r0) goto L1d
            java.util.logging.Logger r0 = okhttp3.internal.http2.Http2Writer.logger
            java.util.logging.Level r1 = java.util.logging.Level.FINE
            boolean r1 = r0.isLoggable(r1)
            if (r1 == 0) goto L1d
            okhttp3.internal.http2.Http2 r2 = okhttp3.internal.http2.Http2.INSTANCE
            r3 = 0
            r4 = r9
            r5 = r10
            r6 = r11
            r7 = r12
            java.lang.String r9 = r2.frameLog(r3, r4, r5, r6, r7)
            r0.fine(r9)
            goto L21
        L1d:
            r4 = r9
            r5 = r10
            r6 = r11
            r7 = r12
        L21:
            int r9 = r8.maxFrameSize
            if (r5 > r9) goto L4d
            r9 = -2147483648(0xffffffff80000000, float:-0.0)
            r9 = r9 & r4
            if (r9 != 0) goto L47
            okio.BufferedSink r9 = r8.sink
            okhttp3.internal._UtilCommonKt.writeMedium(r9, r5)
            okio.BufferedSink r9 = r8.sink
            r10 = r6 & 255(0xff, float:3.57E-43)
            r9.writeByte(r10)
            okio.BufferedSink r9 = r8.sink
            r10 = r7 & 255(0xff, float:3.57E-43)
            r9.writeByte(r10)
            okio.BufferedSink r8 = r8.sink
            r9 = 2147483647(0x7fffffff, float:NaN)
            r9 = r9 & r4
            r8.writeInt(r9)
            return
        L47:
            java.lang.String r8 = "reserved bit set: "
            defpackage.vx4.a(r8, r4)
            return
        L4d:
            int r8 = r8.maxFrameSize
            java.lang.String r9 = ": "
            java.lang.String r10 = "FRAME_SIZE_ERROR length > "
            defpackage.ux4.a(r10, r8, r9, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.Http2Writer.frameHeader(int, int, int, int):void");
    }

    public final Hpack.Writer getHpackWriter() {
        return this.hpackWriter;
    }

    public final void goAway(int i, ErrorCode errorCode, byte[] bArr) {
        errorCode.getClass();
        bArr.getClass();
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException("closed");
                }
                if (errorCode.getHttpCode() == -1) {
                    throw new IllegalArgumentException("errorCode.httpCode == -1");
                }
                frameHeader(0, bArr.length + 8, 7, 0);
                this.sink.writeInt(i);
                this.sink.writeInt(errorCode.getHttpCode());
                if (!(bArr.length == 0)) {
                    this.sink.write(bArr);
                }
                this.sink.flush();
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void headers(boolean z, int i, List<Header> list) {
        list.getClass();
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException("closed");
                }
                this.hpackWriter.writeHeaders(list);
                long size = this.hpackBuffer.size();
                long jMin = Math.min(this.maxFrameSize, size);
                int i2 = size == jMin ? 4 : 0;
                if (z) {
                    i2 |= 1;
                }
                frameHeader(i, (int) jMin, 1, i2);
                this.sink.write(this.hpackBuffer, jMin);
                if (size > jMin) {
                    writeContinuationFrames(i, size - jMin);
                }
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final int maxDataLength() {
        return this.maxFrameSize;
    }

    public final void ping(boolean z, int i, int i2) {
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            frameHeader(0, 8, 6, z ? 1 : 0);
            this.sink.writeInt(i);
            this.sink.writeInt(i2);
            this.sink.flush();
            fw4 fw4Var = fw4.a;
        }
    }

    public final void pushPromise(int i, int i2, List<Header> list) {
        list.getClass();
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException("closed");
                }
                this.hpackWriter.writeHeaders(list);
                long size = this.hpackBuffer.size();
                int iMin = (int) Math.min(((long) this.maxFrameSize) - 4, size);
                long j = iMin;
                frameHeader(i, iMin + 4, 5, size == j ? 4 : 0);
                this.sink.writeInt(i2 & Integer.MAX_VALUE);
                this.sink.write(this.hpackBuffer, j);
                if (size > j) {
                    writeContinuationFrames(i, size - j);
                }
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void rstStream(int i, ErrorCode errorCode) {
        errorCode.getClass();
        synchronized (this) {
            if (this.closed) {
                throw new IOException("closed");
            }
            if (errorCode.getHttpCode() == -1) {
                throw new IllegalArgumentException("Failed requirement.");
            }
            frameHeader(i, 4, 3, 0);
            this.sink.writeInt(errorCode.getHttpCode());
            this.sink.flush();
            fw4 fw4Var = fw4.a;
        }
    }

    public final void settings(Settings settings) {
        settings.getClass();
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException("closed");
                }
                frameHeader(0, settings.size() * 6, 4, 0);
                for (int i = 0; i < 10; i++) {
                    if (settings.isSet(i)) {
                        this.sink.writeShort(i);
                        this.sink.writeInt(settings.get(i));
                    }
                }
                this.sink.flush();
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void windowUpdate(int i, long j) {
        int i2;
        long j2;
        synchronized (this) {
            try {
                if (this.closed) {
                    throw new IOException("closed");
                }
                if (j == 0 || j > 2147483647L) {
                    throw new IllegalArgumentException(("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: " + j).toString());
                }
                Logger logger2 = logger;
                if (logger2.isLoggable(Level.FINE)) {
                    i2 = i;
                    j2 = j;
                    logger2.fine(Http2.INSTANCE.frameLogWindowUpdate(false, i2, 4, j2));
                } else {
                    i2 = i;
                    j2 = j;
                }
                frameHeader(i2, 4, 8, 0);
                this.sink.writeInt((int) j2);
                this.sink.flush();
                fw4 fw4Var = fw4.a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        private Companion() {
        }
    }
}
