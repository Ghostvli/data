package defpackage;

import okhttp3.internal.ws.RealWebSocket;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class v94 {
    public final r73 a = new r73(8);
    public int b;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final long a(jz0 jz0Var) {
        int i = 0;
        jz0Var.s(this.a.f(), 0, 1);
        int i2 = this.a.f()[0] & 255;
        if (i2 == 0) {
            return Long.MIN_VALUE;
        }
        int i3 = 128;
        int i4 = 0;
        while ((i2 & i3) == 0) {
            i3 >>= 1;
            i4++;
        }
        int i5 = i2 & (~i3);
        jz0Var.s(this.a.f(), 1, i4);
        while (i < i4) {
            i++;
            i5 = (this.a.f()[i] & 255) + (i5 << 8);
        }
        this.b += i4 + 1;
        return i5;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean b(jz0 jz0Var) {
        long length = jz0Var.getLength();
        long j = RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE;
        if (length != -1 && length <= RealWebSocket.DEFAULT_MINIMUM_DEFLATE_SIZE) {
            j = length;
        }
        int i = (int) j;
        jz0Var.s(this.a.f(), 0, 4);
        long jS = this.a.S();
        this.b = 4;
        while (jS != 440786851) {
            int i2 = this.b + 1;
            this.b = i2;
            if (i2 == i) {
                return false;
            }
            jz0Var.s(this.a.f(), 0, 1);
            jS = ((jS << 8) & (-256)) | ((long) (this.a.f()[0] & 255));
        }
        long jA = a(jz0Var);
        long j2 = this.b;
        if (jA != Long.MIN_VALUE && (length == -1 || j2 + jA < length)) {
            while (true) {
                int i3 = this.b;
                long j3 = j2 + jA;
                if (i3 < j3) {
                    if (a(jz0Var) == Long.MIN_VALUE) {
                        return false;
                    }
                    long jA2 = a(jz0Var);
                    if (jA2 < 0 || jA2 > 2147483647L) {
                        break;
                    }
                    if (jA2 != 0) {
                        int i4 = (int) jA2;
                        jz0Var.m(i4);
                        this.b += i4;
                    }
                } else if (i3 == j3) {
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
