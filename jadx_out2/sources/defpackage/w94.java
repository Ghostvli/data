package defpackage;

import android.os.SystemClock;
import defpackage.xy1;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class w94 {
    public static final Object a = new Object();
    public static final Object b = new Object();
    public static boolean c = false;
    public static long d = 0;
    public static String e = "time.android.com";
    public static int f = 1000;
    public static long g = -9223372036854775807L;
    public static long h = -9223372036854775807L;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void a(IOException iOException);

        void b();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c implements xy1.b {
        public final b f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(b bVar) {
            this.f = bVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // xy1.b
        public void j(xy1.e eVar, long j, long j2, boolean z) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // xy1.b
        public void l(xy1.e eVar, long j, long j2) {
            if (this.f != null) {
                boolean zM = w94.m();
                b bVar = this.f;
                if (zM) {
                    bVar.b();
                } else {
                    bVar.a(new IOException(new ConcurrentModificationException()));
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // xy1.b
        public xy1.c v(xy1.e eVar, long j, long j2, IOException iOException, int i) {
            b bVar = this.f;
            if (bVar != null) {
                bVar.a(iOException);
            }
            return xy1.f;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d implements xy1.e {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // xy1.e
        public void b() {
            synchronized (w94.a) {
                synchronized (w94.b) {
                    if (w94.c) {
                        return;
                    }
                    long jN = w94.n();
                    synchronized (w94.b) {
                        long unused = w94.h = SystemClock.elapsedRealtime();
                        long unused2 = w94.d = jN;
                        boolean unused3 = w94.c = true;
                    }
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // xy1.e
        public void c() {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void h(byte b2, byte b3, int i, long j) throws IOException {
        if (b2 == 3) {
            sb1.a("SNTP: Unsynchronized server");
            return;
        }
        if (b3 != 4 && b3 != 5) {
            ye5.a("SNTP: Untrusted mode: ", b3);
            return;
        }
        if (i == 0 || i > 15) {
            ye5.a("SNTP: Untrusted stratum: ", i);
        } else {
            if (j != 0) {
                return;
            }
            sb1.a("SNTP: Zero transmitTime");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long i() {
        long j;
        synchronized (b) {
            try {
                j = c ? d : -9223372036854775807L;
            } catch (Throwable th) {
                throw th;
            }
        }
        return j;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String j() {
        String str;
        synchronized (b) {
            str = e;
        }
        return str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int k() {
        int i;
        synchronized (b) {
            i = f;
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void l(xy1 xy1Var, b bVar) {
        if (m()) {
            if (bVar != null) {
                bVar.b();
            }
        } else {
            if (xy1Var == null) {
                xy1Var = new xy1("SntpClient");
            }
            xy1Var.n(new d(), new c(bVar), 1);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean m() {
        boolean z;
        synchronized (b) {
            try {
                if (h != -9223372036854775807L && g != -9223372036854775807L) {
                    c = c && SystemClock.elapsedRealtime() - h < g;
                }
                z = c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static long n() {
        DatagramSocket datagramSocket = new DatagramSocket();
        try {
            datagramSocket.setSoTimeout(k());
            InetAddress[] allByName = InetAddress.getAllByName(j());
            int length = allByName.length;
            SocketTimeoutException socketTimeoutException = null;
            int i = 0;
            int i2 = 0;
            while (i < length) {
                byte[] bArr = new byte[48];
                DatagramPacket datagramPacket = new DatagramPacket(bArr, 48, allByName[i], Token.EXPORT);
                bArr[0] = 27;
                long jCurrentTimeMillis = System.currentTimeMillis();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                q(bArr, 40, jCurrentTimeMillis);
                datagramSocket.send(datagramPacket);
                try {
                    datagramSocket.receive(new DatagramPacket(bArr, 48));
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    long j = jCurrentTimeMillis + (jElapsedRealtime2 - jElapsedRealtime);
                    byte b2 = bArr[0];
                    int i3 = bArr[1] & 255;
                    long jP = p(bArr, 24);
                    long jP2 = p(bArr, 32);
                    long jP3 = p(bArr, 40);
                    h((byte) ((b2 >> 6) & 3), (byte) (b2 & 7), i3, jP3);
                    long j2 = (j + (((jP2 - jP) + (jP3 - j)) / 2)) - jElapsedRealtime2;
                    datagramSocket.close();
                    return j2;
                } catch (SocketTimeoutException e2) {
                    if (socketTimeoutException == null) {
                        socketTimeoutException = e2;
                    } else {
                        socketTimeoutException.addSuppressed(e2);
                    }
                    int i4 = i2 + 1;
                    if (i2 >= 10) {
                        throw ((SocketTimeoutException) gg3.q(socketTimeoutException));
                    }
                    i++;
                    i2 = i4;
                }
            }
            throw ((SocketTimeoutException) gg3.q(socketTimeoutException));
        } finally {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long o(byte[] bArr, int i) {
        int i2 = bArr[i];
        int i3 = bArr[i + 1];
        int i4 = bArr[i + 2];
        int i5 = bArr[i + 3];
        if ((i2 & 128) == 128) {
            i2 = (i2 & 127) + 128;
        }
        if ((i3 & 128) == 128) {
            i3 = (i3 & 127) + 128;
        }
        if ((i4 & 128) == 128) {
            i4 = (i4 & 127) + 128;
        }
        if ((i5 & 128) == 128) {
            i5 = (i5 & 127) + 128;
        }
        return (((long) i2) << 24) + (((long) i3) << 16) + (((long) i4) << 8) + ((long) i5);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static long p(byte[] bArr, int i) {
        long jO = o(bArr, i);
        long jO2 = o(bArr, i + 4);
        if (jO == 0 && jO2 == 0) {
            return 0L;
        }
        return ((jO - 2208988800L) * 1000) + ((jO2 * 1000) / 4294967296L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void q(byte[] bArr, int i, long j) {
        if (j == 0) {
            Arrays.fill(bArr, i, i + 8, (byte) 0);
            return;
        }
        long j2 = j / 1000;
        long j3 = j - (j2 * 1000);
        bArr[i] = (byte) (r2 >> 24);
        bArr[i + 1] = (byte) (r2 >> 16);
        bArr[i + 2] = (byte) (r2 >> 8);
        bArr[i + 3] = (byte) (j2 + 2208988800L);
        long j4 = (j3 * 4294967296L) / 1000;
        bArr[i + 4] = (byte) (j4 >> 24);
        bArr[i + 5] = (byte) (j4 >> 16);
        bArr[i + 6] = (byte) (j4 >> 8);
        bArr[i + 7] = (byte) (Math.random() * 255.0d);
    }
}
