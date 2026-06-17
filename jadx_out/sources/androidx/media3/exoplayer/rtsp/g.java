package androidx.media3.exoplayer.rtsp;

import android.os.Handler;
import android.os.HandlerThread;
import androidx.media3.exoplayer.rtsp.g;
import defpackage.e04;
import defpackage.gg3;
import defpackage.jl;
import defpackage.ll1;
import defpackage.r83;
import defpackage.xi1;
import defpackage.xy1;
import defpackage.z20;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Closeable {
    public static final Charset l = StandardCharsets.UTF_8;
    public final d f;
    public final xy1 g = new xy1("ExoPlayer:RtspMessageChannel:ReceiverLoader");
    public final Map h = Collections.synchronizedMap(new HashMap());
    public C0024g i;
    public Socket j;
    public volatile boolean k;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void h(byte[] bArr);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class c implements xy1.b {
        public c() {
        }

        @Override // xy1.b
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void j(f fVar, long j, long j2, boolean z) {
        }

        @Override // xy1.b
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public void l(f fVar, long j, long j2) {
        }

        @Override // xy1.b
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public xy1.c v(f fVar, long j, long j2, IOException iOException, int i) {
            if (!g.this.k) {
                g.this.f.a(iOException);
            }
            return xy1.f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
        default void a(Exception exc) {
        }

        default void b(List list, Exception exc) {
        }

        void c(List list);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e {
        public final List a = new ArrayList();
        public int b = 1;
        public long c;

        public static byte[] d(byte b, DataInputStream dataInputStream) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = {b, dataInputStream.readByte()};
            byteArrayOutputStream.write(bArr);
            while (true) {
                if (bArr[0] == 13 && bArr[1] == 10) {
                    return byteArrayOutputStream.toByteArray();
                }
                bArr[0] = bArr[1];
                byte b2 = dataInputStream.readByte();
                bArr[1] = b2;
                byteArrayOutputStream.write(b2);
            }
        }

        public final xi1 a(byte[] bArr) {
            gg3.v(this.b == 3);
            if (bArr.length <= 0 || bArr[bArr.length - 1] != 10) {
                jl.a("Message body is empty or does not end with a LF.");
                return null;
            }
            this.a.add((bArr.length <= 1 || bArr[bArr.length + (-2)] != 13) ? new String(bArr, 0, bArr.length - 1, g.l) : new String(bArr, 0, bArr.length - 2, g.l));
            xi1 xi1VarP = xi1.p(this.a);
            e();
            return xi1VarP;
        }

        public final xi1 b(byte[] bArr) throws r83 {
            gg3.d(bArr.length >= 2 && bArr[bArr.length - 2] == 13 && bArr[bArr.length - 1] == 10);
            String str = new String(bArr, 0, bArr.length - 2, g.l);
            this.a.add(str);
            int i = this.b;
            if (i != 1) {
                if (i != 2) {
                    z20.a();
                    return null;
                }
                long jG = h.g(str);
                if (jG != -1) {
                    this.c = jG;
                }
                if (str.isEmpty()) {
                    if (this.c <= 0) {
                        xi1 xi1VarP = xi1.p(this.a);
                        e();
                        return xi1VarP;
                    }
                    this.b = 3;
                }
            } else if (h.f(str)) {
                this.b = 2;
            }
            return null;
        }

        public xi1 c(byte b, DataInputStream dataInputStream) throws IOException {
            xi1 xi1VarB = b(d(b, dataInputStream));
            while (xi1VarB == null) {
                if (this.b == 3) {
                    long j = this.c;
                    if (j <= 0) {
                        e04.a("Expects a greater than zero Content-Length.");
                        return null;
                    }
                    int iE = ll1.e(j);
                    gg3.v(iE != -1);
                    byte[] bArr = new byte[iE];
                    dataInputStream.readFully(bArr, 0, iE);
                    xi1VarB = a(bArr);
                } else {
                    xi1VarB = b(d(dataInputStream.readByte(), dataInputStream));
                }
            }
            return xi1VarB;
        }

        public final void e() {
            this.a.clear();
            this.b = 1;
            this.c = 0L;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class f implements xy1.e {
        public final DataInputStream a;
        public final e b = new e();
        public volatile boolean c;

        public f(InputStream inputStream) {
            this.a = new DataInputStream(inputStream);
        }

        public final void a() throws IOException {
            int unsignedByte = this.a.readUnsignedByte();
            int unsignedShort = this.a.readUnsignedShort();
            byte[] bArr = new byte[unsignedShort];
            this.a.readFully(bArr, 0, unsignedShort);
            b bVar = (b) g.this.h.get(Integer.valueOf(unsignedByte));
            if (bVar == null || g.this.k) {
                return;
            }
            bVar.h(bArr);
        }

        @Override // xy1.e
        public void b() throws IOException {
            while (!this.c) {
                byte b = this.a.readByte();
                if (b == 36) {
                    a();
                } else {
                    d(b);
                }
            }
        }

        @Override // xy1.e
        public void c() {
            this.c = true;
        }

        public final void d(byte b) {
            if (g.this.k) {
                return;
            }
            g.this.f.c(this.b.c(b, this.a));
        }
    }

    /* JADX INFO: renamed from: androidx.media3.exoplayer.rtsp.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class C0024g implements Closeable {
        public final OutputStream f;
        public final HandlerThread g;
        public final Handler h;

        public C0024g(OutputStream outputStream) {
            this.f = outputStream;
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:RtspMessageChannel:Sender");
            this.g = handlerThread;
            handlerThread.start();
            this.h = new Handler(handlerThread.getLooper());
        }

        public static /* synthetic */ void a(C0024g c0024g, byte[] bArr, List list) {
            c0024g.getClass();
            try {
                c0024g.f.write(bArr);
            } catch (Exception e) {
                if (g.this.k) {
                    return;
                }
                g.this.f.b(list, e);
            }
        }

        public void c(final List list) {
            final byte[] bArrB = h.b(list);
            this.h.post(new Runnable() { // from class: tv3
                @Override // java.lang.Runnable
                public final void run() {
                    g.C0024g.a(this.f, bArrB, list);
                }
            });
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            Handler handler = this.h;
            final HandlerThread handlerThread = this.g;
            Objects.requireNonNull(handlerThread);
            handler.post(new Runnable() { // from class: sv3
                @Override // java.lang.Runnable
                public final void run() {
                    handlerThread.quit();
                }
            });
            try {
                this.g.join();
            } catch (InterruptedException unused) {
                this.g.interrupt();
            }
        }
    }

    public g(d dVar) {
        this.f = dVar;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.k) {
            return;
        }
        try {
            C0024g c0024g = this.i;
            if (c0024g != null) {
                c0024g.close();
            }
            this.g.l();
            Socket socket = this.j;
            if (socket != null) {
                socket.close();
            }
            this.k = true;
        } catch (Throwable th) {
            this.k = true;
            throw th;
        }
    }

    public void i(Socket socket) {
        this.j = socket;
        this.i = new C0024g(socket.getOutputStream());
        this.g.n(new f(socket.getInputStream()), new c(), 0);
    }

    public void l(int i, b bVar) {
        this.h.put(Integer.valueOf(i), bVar);
    }

    public void t(List list) {
        gg3.q(this.i);
        this.i.c(list);
    }
}
