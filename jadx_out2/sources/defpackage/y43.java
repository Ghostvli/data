package defpackage;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class y43 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final boolean a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(e eVar, d dVar) throws c {
            int i = dVar.a;
            gg3.d(i == 6 || i == 3);
            byte[] bArr = new byte[Math.min(4, dVar.b.remaining())];
            dVar.b.asReadOnlyBuffer().get(bArr);
            q73 q73Var = new q73(bArr);
            y43.f(eVar.a);
            if (q73Var.g()) {
                this.a = false;
                return;
            }
            int iH = q73Var.h(2);
            boolean zG = q73Var.g();
            y43.f(eVar.b);
            if (!zG) {
                this.a = true;
                return;
            }
            boolean zG2 = (iH == 3 || iH == 0) ? true : q73Var.g();
            q73Var.q();
            y43.f(!eVar.d);
            if (q73Var.g()) {
                y43.f(!eVar.e);
                q73Var.q();
            }
            y43.f(eVar.c);
            if (iH != 3) {
                q73Var.q();
            }
            q73Var.r(eVar.f);
            if (iH != 2 && iH != 0 && !zG2) {
                q73Var.r(3);
            }
            this.a = ((iH == 3 || iH == 0) ? 255 : q73Var.h(8)) != 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static b b(e eVar, d dVar) {
            try {
                return new b(eVar, dVar);
            } catch (c unused) {
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean a() {
            return this.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends Exception {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d {
        public final int a;
        public final ByteBuffer b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(int i, ByteBuffer byteBuffer) {
            this.a = i;
            this.b = byteBuffer;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class e {
        public final boolean a;
        public final boolean b;
        public final boolean c;
        public final boolean d;
        public final boolean e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final boolean j;
        public final int k;
        public final boolean l;
        public final boolean m;
        public final boolean n;
        public final boolean o;
        public final boolean p;
        public final int q;
        public final byte r;
        public final byte s;
        public final byte t;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r8v4, types: [int] */
        /* JADX WARN: Type inference failed for: r8v5 */
        /* JADX WARN: Type inference failed for: r8v6 */
        public e(d dVar) {
            int iH;
            int iH2;
            boolean zG;
            ?? r8;
            gg3.d(dVar.a == 1);
            byte[] bArr = new byte[dVar.b.remaining()];
            dVar.b.asReadOnlyBuffer().get(bArr);
            q73 q73Var = new q73(bArr);
            this.g = q73Var.h(3);
            q73Var.q();
            boolean zG2 = q73Var.g();
            this.a = zG2;
            if (zG2) {
                iH2 = q73Var.h(5);
                this.b = false;
                this.j = false;
                r8 = 0;
                iH = 0;
            } else {
                if (q73Var.g()) {
                    b(q73Var);
                    boolean zG3 = q73Var.g();
                    this.b = zG3;
                    if (zG3) {
                        q73Var.r(47);
                    }
                } else {
                    this.b = false;
                }
                this.j = q73Var.g();
                int iH3 = q73Var.h(5);
                int iH4 = 0;
                int i = 0;
                boolean z = false;
                iH = 0;
                while (i <= iH3) {
                    q73Var.r(12);
                    if (i == 0) {
                        iH4 = q73Var.h(5);
                        zG = z;
                        if (iH4 > 7) {
                            zG = q73Var.g();
                        }
                    } else {
                        zG = z;
                        if (q73Var.h(5) > 7) {
                            q73Var.q();
                            zG = z;
                        }
                    }
                    if (this.b) {
                        q73Var.q();
                    }
                    if (this.j && q73Var.g()) {
                        if (i == 0) {
                            iH = q73Var.h(4);
                        } else {
                            q73Var.r(4);
                        }
                    }
                    i++;
                    z = zG;
                }
                iH2 = iH4;
                r8 = z;
            }
            int iH5 = q73Var.h(4);
            int iH6 = q73Var.h(4);
            q73Var.r(iH5 + 1);
            q73Var.r(iH6 + 1);
            if (this.a) {
                this.c = false;
            } else {
                this.c = q73Var.g();
            }
            if (this.c) {
                q73Var.r(4);
                q73Var.r(3);
            }
            q73Var.r(3);
            if (this.a) {
                this.e = true;
                this.d = true;
                this.f = 0;
            } else {
                q73Var.r(4);
                boolean zG4 = q73Var.g();
                if (zG4) {
                    q73Var.r(2);
                }
                if (q73Var.g()) {
                    this.d = true;
                } else {
                    this.d = q73Var.g();
                }
                if (!this.d || q73Var.g()) {
                    this.e = true;
                } else {
                    this.e = q73Var.g();
                }
                if (zG4) {
                    this.f = q73Var.h(3) + 1;
                } else {
                    this.f = 0;
                }
            }
            this.h = iH2;
            this.i = r8;
            this.k = iH;
            q73Var.r(3);
            boolean zG5 = q73Var.g();
            this.l = zG5;
            if (this.g == 2 && zG5) {
                this.m = q73Var.g();
            } else {
                this.m = false;
            }
            if (this.g != 1) {
                this.n = q73Var.g();
            } else {
                this.n = false;
            }
            if (q73Var.g()) {
                this.r = (byte) q73Var.h(8);
                this.s = (byte) q73Var.h(8);
                this.t = (byte) q73Var.h(8);
            } else {
                this.r = (byte) 0;
                this.s = (byte) 0;
                this.t = (byte) 0;
            }
            if (this.n) {
                q73Var.q();
                this.o = false;
                this.p = false;
                this.q = 0;
            } else if (this.r == 1 && this.s == 13 && this.t == 0) {
                this.o = false;
                this.p = false;
                this.q = 0;
            } else {
                q73Var.q();
                int i2 = this.g;
                if (i2 == 0) {
                    this.o = true;
                    this.p = true;
                } else if (i2 == 1) {
                    this.o = false;
                    this.p = false;
                } else if (this.m) {
                    boolean zG6 = q73Var.g();
                    this.o = zG6;
                    if (zG6) {
                        this.p = q73Var.g();
                    } else {
                        this.p = false;
                    }
                } else {
                    this.o = true;
                    this.p = false;
                }
                if (this.o && this.p) {
                    this.q = q73Var.h(2);
                } else {
                    this.q = 0;
                }
            }
            q73Var.q();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static e a(d dVar) {
            try {
                return new e(dVar);
            } catch (c unused) {
                return null;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void b(q73 q73Var) {
            q73Var.r(64);
            if (q73Var.g()) {
                y43.d(q73Var);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int c(ByteBuffer byteBuffer) {
        int i = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            byte b2 = byteBuffer.get();
            i |= (b2 & 127) << (i2 * 7);
            if ((b2 & 128) == 0) {
                return i;
            }
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void d(q73 q73Var) {
        int i = 0;
        while (!q73Var.g()) {
            i++;
        }
        if (i < 32) {
            q73Var.r(i);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List e(ByteBuffer byteBuffer) {
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        ArrayList arrayList = new ArrayList();
        while (byteBufferAsReadOnlyBuffer.hasRemaining()) {
            try {
                byte b2 = byteBufferAsReadOnlyBuffer.get();
                int i = (b2 >> 3) & 15;
                if (((b2 >> 2) & 1) != 0) {
                    byteBufferAsReadOnlyBuffer.get();
                }
                int iC = ((b2 >> 1) & 1) != 0 ? c(byteBufferAsReadOnlyBuffer) : byteBufferAsReadOnlyBuffer.remaining();
                if (byteBufferAsReadOnlyBuffer.position() + iC > byteBufferAsReadOnlyBuffer.limit()) {
                    break;
                }
                ByteBuffer byteBufferDuplicate = byteBufferAsReadOnlyBuffer.duplicate();
                byteBufferDuplicate.limit(byteBufferAsReadOnlyBuffer.position() + iC);
                arrayList.add(new d(i, byteBufferDuplicate));
                byteBufferAsReadOnlyBuffer.position(byteBufferAsReadOnlyBuffer.position() + iC);
            } catch (BufferUnderflowException unused) {
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void f(boolean z) throws c {
        if (z) {
            throw new c();
        }
    }
}
