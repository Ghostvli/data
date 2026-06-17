package defpackage;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class v43 {
    public final long[] b;
    public final boolean[] c;
    public volatile boolean d;
    public volatile boolean f;
    public final ReentrantLock a = new ReentrantLock();
    public final ReentrantLock e = new ReentrantLock();

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public static final a f = new a("NO_OP", 0);
        public static final a g = new a("ADD", 1);
        public static final a h = new a("REMOVE", 2);
        public static final /* synthetic */ a[] i;
        public static final /* synthetic */ gt0 j;

        static {
            a[] aVarArrA = a();
            i = aVarArrA;
            j = ht0.a(aVarArrA);
        }

        public a(String str, int i2) {
        }

        public static final /* synthetic */ a[] a() {
            return new a[]{f, g, h};
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) i.clone();
        }
    }

    public v43(int i) {
        this.b = new long[i];
        this.c = new boolean[i];
    }

    public final void h() {
        ReentrantLock reentrantLock = this.a;
        reentrantLock.lock();
        try {
            this.d = true;
            fw4 fw4Var = fw4.a;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0033  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean i(int[] r13) {
        /*
            r12 = this;
            r13.getClass()
            java.util.concurrent.locks.ReentrantLock r0 = r12.a
            r0.lock()
            int r1 = r13.length     // Catch: java.lang.Throwable -> L24
            r2 = 0
            r3 = r2
            r4 = r3
        Lc:
            r5 = 1
            if (r3 >= r1) goto L29
            r6 = r13[r3]     // Catch: java.lang.Throwable -> L24
            long[] r7 = r12.b     // Catch: java.lang.Throwable -> L24
            r8 = r7[r6]     // Catch: java.lang.Throwable -> L24
            r10 = 1
            long r10 = r10 + r8
            r7[r6] = r10     // Catch: java.lang.Throwable -> L24
            r6 = 0
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 != 0) goto L26
            r12.d = r5     // Catch: java.lang.Throwable -> L24
            r4 = r5
            goto L26
        L24:
            r12 = move-exception
            goto L38
        L26:
            int r3 = r3 + 1
            goto Lc
        L29:
            if (r4 != 0) goto L33
            boolean r13 = r12.d     // Catch: java.lang.Throwable -> L24
            if (r13 != 0) goto L33
            boolean r12 = r12.f     // Catch: java.lang.Throwable -> L24
            if (r12 == 0) goto L34
        L33:
            r2 = r5
        L34:
            r0.unlock()
            return r2
        L38:
            r0.unlock()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v43.i(int[]):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0032  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean j(int[] r15) {
        /*
            r14 = this;
            r15.getClass()
            java.util.concurrent.locks.ReentrantLock r0 = r14.a
            r0.lock()
            int r1 = r15.length     // Catch: java.lang.Throwable -> L23
            r2 = 0
            r3 = r2
            r4 = r3
        Lc:
            r5 = 1
            if (r3 >= r1) goto L28
            r6 = r15[r3]     // Catch: java.lang.Throwable -> L23
            long[] r7 = r14.b     // Catch: java.lang.Throwable -> L23
            r8 = r7[r6]     // Catch: java.lang.Throwable -> L23
            r10 = 1
            long r12 = r8 - r10
            r7[r6] = r12     // Catch: java.lang.Throwable -> L23
            int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r6 != 0) goto L25
            r14.d = r5     // Catch: java.lang.Throwable -> L23
            r4 = r5
            goto L25
        L23:
            r14 = move-exception
            goto L37
        L25:
            int r3 = r3 + 1
            goto Lc
        L28:
            if (r4 != 0) goto L32
            boolean r15 = r14.d     // Catch: java.lang.Throwable -> L23
            if (r15 != 0) goto L32
            boolean r14 = r14.f     // Catch: java.lang.Throwable -> L23
            if (r14 == 0) goto L33
        L32:
            r2 = r5
        L33:
            r0.unlock()
            return r2
        L37:
            r0.unlock()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.v43.j(int[]):boolean");
    }

    public final void k() {
        ReentrantLock reentrantLock = this.a;
        reentrantLock.lock();
        try {
            ta.s(this.c, false, 0, 0, 6, null);
            this.d = true;
            fw4 fw4Var = fw4.a;
        } finally {
            reentrantLock.unlock();
        }
    }
}
