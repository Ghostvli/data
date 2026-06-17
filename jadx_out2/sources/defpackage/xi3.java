package defpackage;

import java.nio.ByteBuffer;
import java.util.UUID;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class xi3 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final UUID a;
        public final int b;
        public final byte[] c;
        public final UUID[] d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(UUID uuid, int i, byte[] bArr, UUID[] uuidArr) {
            this.a = uuid;
            this.b = i;
            this.c = bArr;
            this.d = uuidArr;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] a(UUID uuid, byte[] bArr) {
        return b(uuid, null, bArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] b(UUID uuid, UUID[] uuidArr, byte[] bArr) {
        int length = (bArr != null ? bArr.length : 0) + 32;
        if (uuidArr != null) {
            length += (uuidArr.length * 16) + 4;
        }
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(length);
        byteBufferAllocate.putInt(length);
        byteBufferAllocate.putInt(1886614376);
        byteBufferAllocate.putInt(uuidArr != null ? Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE : 0);
        byteBufferAllocate.putLong(uuid.getMostSignificantBits());
        byteBufferAllocate.putLong(uuid.getLeastSignificantBits());
        if (uuidArr != null) {
            byteBufferAllocate.putInt(uuidArr.length);
            for (UUID uuid2 : uuidArr) {
                byteBufferAllocate.putLong(uuid2.getMostSignificantBits());
                byteBufferAllocate.putLong(uuid2.getLeastSignificantBits());
            }
        }
        if (bArr == null || bArr.length == 0) {
            byteBufferAllocate.putInt(0);
        } else {
            byteBufferAllocate.putInt(bArr.length);
            byteBufferAllocate.put(bArr);
        }
        return byteBufferAllocate.array();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean c(byte[] bArr) {
        return d(bArr) != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static a d(byte[] bArr) {
        UUID[] uuidArr;
        r73 r73Var = new r73(bArr);
        if (r73Var.j() < 32) {
            return null;
        }
        r73Var.f0(0);
        int iA = r73Var.a();
        int iZ = r73Var.z();
        if (iZ != iA) {
            xz1.i("PsshAtomUtil", "Advertised atom size (" + iZ + ") does not match buffer size: " + iA);
            return null;
        }
        int iZ2 = r73Var.z();
        if (iZ2 != 1886614376) {
            xz1.i("PsshAtomUtil", "Atom type is not pssh: " + iZ2);
            return null;
        }
        int iQ = gl.q(r73Var.z());
        if (iQ > 1) {
            xz1.i("PsshAtomUtil", "Unsupported pssh version: " + iQ);
            return null;
        }
        UUID uuid = new UUID(r73Var.J(), r73Var.J());
        if (iQ == 1) {
            int iU = r73Var.U();
            uuidArr = new UUID[iU];
            for (int i = 0; i < iU; i++) {
                uuidArr[i] = new UUID(r73Var.J(), r73Var.J());
            }
        } else {
            uuidArr = null;
        }
        int iU2 = r73Var.U();
        int iA2 = r73Var.a();
        if (iU2 == iA2) {
            byte[] bArr2 = new byte[iU2];
            r73Var.u(bArr2, 0, iU2);
            return new a(uuid, iQ, bArr2, uuidArr);
        }
        xz1.i("PsshAtomUtil", "Atom data size (" + iU2 + ") does not match the bytes left: " + iA2);
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static byte[] e(byte[] bArr, UUID uuid) {
        a aVarD = d(bArr);
        if (aVarD == null) {
            return null;
        }
        if (uuid.equals(aVarD.a)) {
            return aVarD.c;
        }
        xz1.i("PsshAtomUtil", "UUID mismatch. Expected: " + uuid + ", got: " + aVarD.a + ".");
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static UUID f(byte[] bArr) {
        a aVarD = d(bArr);
        if (aVarD == null) {
            return null;
        }
        return aVarD.a;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int g(byte[] bArr) {
        a aVarD = d(bArr);
        if (aVarD == null) {
            return -1;
        }
        return aVarD.b;
    }
}
