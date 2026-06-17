package defpackage;

import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SharedMemory;
import android.system.OsConstants;
import defpackage.xi1;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class lm {
    public static final String e = fy4.N0(0);
    public static final String f = fy4.N0(1);
    public static final String g = fy4.N0(2);
    public final byte[] a;
    public final b b = new b();
    public c c;
    public d d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class b extends Binder {
        public b() {
        }

        public final byte[] b() {
            return lm.this.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c {
        public final SharedMemory a;

        public c(SharedMemory sharedMemory) {
            this.a = sharedMemory;
        }

        public static c d(byte[] bArr) {
            SharedMemory sharedMemoryCreate;
            try {
                sharedMemoryCreate = SharedMemory.create("BundleableByteArray", bArr.length);
            } catch (Exception e) {
                e = e;
                sharedMemoryCreate = null;
            }
            try {
                ByteBuffer byteBufferMapReadWrite = sharedMemoryCreate.mapReadWrite();
                byteBufferMapReadWrite.put(bArr);
                SharedMemory.unmap(byteBufferMapReadWrite);
                sharedMemoryCreate.setProtect(OsConstants.PROT_READ);
                return new c(sharedMemoryCreate);
            } catch (Exception e2) {
                e = e2;
                xz1.j("BundleableByteArray", "Failed to allocate shared memory for byte array, size=" + bArr.length, e);
                if (sharedMemoryCreate != null) {
                    sharedMemoryCreate.close();
                }
                return null;
            }
        }

        public static byte[] e(Bundle bundle) throws Throwable {
            ByteBuffer byteBufferMapReadOnly;
            SharedMemory sharedMemoryA = mm.a(bundle.getParcelable(lm.f));
            try {
                if (sharedMemoryA == null) {
                    return null;
                }
                try {
                    byteBufferMapReadOnly = sharedMemoryA.mapReadOnly();
                    try {
                        byte[] bArr = new byte[sharedMemoryA.getSize()];
                        byteBufferMapReadOnly.get(bArr);
                        SharedMemory.unmap(byteBufferMapReadOnly);
                        sharedMemoryA.close();
                        return bArr;
                    } catch (Exception e) {
                        e = e;
                        xz1.j("BundleableByteArray", "Failed to read byte array from shared memory", e);
                        if (byteBufferMapReadOnly != null) {
                            SharedMemory.unmap(byteBufferMapReadOnly);
                        }
                        sharedMemoryA.close();
                        return null;
                    }
                } catch (Exception e2) {
                    e = e2;
                    byteBufferMapReadOnly = null;
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        SharedMemory.unmap(null);
                    }
                    sharedMemoryA.close();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        public final void f(Bundle bundle) {
            bundle.putParcelable(lm.f, this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d {
        public static final int b = kn.a;
        public final km a;

        public d(byte[] bArr) {
            xi1.a aVarM = xi1.m();
            int iN = fy4.n(bArr.length, b);
            for (int i = 0; i < iN; i++) {
                Bundle bundle = new Bundle();
                int i2 = b;
                int i3 = i * i2;
                bundle.putByteArray("bytes", Arrays.copyOfRange(bArr, i3, Math.min(i2 + i3, bArr.length)));
                aVarM.a(bundle);
            }
            this.a = new km(aVarM.k());
        }

        public static byte[] c(Bundle bundle) {
            IBinder binder = bundle.getBinder(lm.g);
            if (binder == null) {
                return null;
            }
            try {
                xi1 xi1VarA = km.a(binder);
                if (xi1VarA.isEmpty()) {
                    return fy4.f;
                }
                byte[] byteArray = ((Bundle) km1.d(xi1VarA)).getByteArray("bytes");
                if (byteArray == null) {
                    return null;
                }
                int size = xi1VarA.size() - 1;
                int i = b;
                byte[] bArr = new byte[(size * i) + byteArray.length];
                System.arraycopy(byteArray, 0, bArr, i * size, byteArray.length);
                for (int i2 = 0; i2 < size; i2++) {
                    byte[] byteArray2 = ((Bundle) xi1VarA.get(i2)).getByteArray("bytes");
                    if (byteArray2 != null) {
                        int length = byteArray2.length;
                        int i3 = b;
                        if (length == i3) {
                            System.arraycopy(byteArray2, 0, bArr, i2 * i3, i3);
                        }
                    }
                    return null;
                }
                return bArr;
            } catch (RuntimeException e) {
                xz1.j("BundleableByteArray", "Failed to read byte array from bundle list retriever", e);
                return null;
            }
        }

        public final void d(Bundle bundle) {
            bundle.putBinder(lm.g, this.a);
        }
    }

    public lm(byte[] bArr) {
        this.a = bArr;
    }

    public static byte[] d(Bundle bundle) {
        byte[] bArrE;
        IBinder binder = bundle.getBinder(e);
        if (binder == null) {
            return null;
        }
        return binder instanceof b ? ((b) binder).b() : (Build.VERSION.SDK_INT < 27 || (bArrE = c.e(bundle)) == null) ? d.c(bundle) : bArrE;
    }

    public Bundle e() {
        Bundle bundle = new Bundle();
        bundle.putBinder(e, this.b);
        if (Build.VERSION.SDK_INT >= 27) {
            byte[] bArr = this.a;
            if (bArr.length > 0) {
                if (this.c == null) {
                    this.c = c.d(bArr);
                }
                c cVar = this.c;
                if (cVar != null) {
                    cVar.f(bundle);
                    return bundle;
                }
            }
        }
        if (this.d == null) {
            this.d = new d(this.a);
        }
        this.d.d(bundle);
        return bundle;
    }
}
