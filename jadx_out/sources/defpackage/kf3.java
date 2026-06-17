package defpackage;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class kf3 {
    public final int a;
    public final Function0 b;
    public final int c;
    public final ReentrantLock d;
    public int e;
    public boolean f;
    public final c10[] g;
    public final n04 h;
    public final ia i;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends g30 {
        public /* synthetic */ Object f;
        public int h;

        public a(f30 f30Var) {
            super(f30Var);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.f = obj;
            this.h |= Integer.MIN_VALUE;
            return kf3.this.a(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends g30 {
        public long f;
        public Object g;
        public Object h;
        public /* synthetic */ Object i;
        public int k;

        public b(f30 f30Var) {
            super(f30Var);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.i = obj;
            this.k |= Integer.MIN_VALUE;
            return kf3.this.b(0L, null, this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c extends oj4 implements Function2 {
        public Object f;
        public int g;
        public final /* synthetic */ mp3 h;
        public final /* synthetic */ kf3 i;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(mp3 mp3Var, kf3 kf3Var, f30 f30Var) {
            super(2, f30Var);
            this.h = mp3Var;
            this.i = kf3Var;
        }

        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            return new c(this.h, this.i, f30Var);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(u40 u40Var, f30 f30Var) {
            return ((c) create(u40Var, f30Var)).invokeSuspend(fw4.a);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) throws Throwable {
            mp3 mp3Var;
            Object objE = kl1.e();
            int i = this.g;
            if (i == 0) {
                lt3.b(obj);
                mp3 mp3Var2 = this.h;
                kf3 kf3Var = this.i;
                this.f = mp3Var2;
                this.g = 1;
                Object objA = kf3Var.a(this);
                if (objA == objE) {
                    return objE;
                }
                obj = objA;
                mp3Var = mp3Var2;
            } else {
                if (i != 1) {
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                mp3Var = (mp3) this.f;
                lt3.b(obj);
            }
            mp3Var.f = obj;
            return fw4.a;
        }
    }

    public kf3(int i, Function0 function0, int i2) {
        function0.getClass();
        this.a = i;
        this.b = function0;
        this.c = i2;
        this.d = new ReentrantLock();
        this.g = new c10[i];
        this.h = r04.b(i, 0, 2, null);
        this.i = new ia(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(defpackage.f30 r5) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r5 instanceof kf3.a
            if (r0 == 0) goto L13
            r0 = r5
            kf3$a r0 = (kf3.a) r0
            int r1 = r0.h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.h = r1
            goto L18
        L13:
            kf3$a r0 = new kf3$a
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f
            java.lang.Object r1 = defpackage.kl1.e()
            int r2 = r0.h
            r3 = 1
            if (r2 == 0) goto L30
            if (r2 != r3) goto L29
            defpackage.lt3.b(r5)
            goto L3e
        L29:
            java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.e04.a(r4)
            r4 = 0
            return r4
        L30:
            defpackage.lt3.b(r5)
            n04 r5 = r4.h
            r0.h = r3
            java.lang.Object r5 = r5.b(r0)
            if (r5 != r1) goto L3e
            return r1
        L3e:
            java.util.concurrent.locks.ReentrantLock r5 = r4.d     // Catch: java.lang.Throwable -> L61
            r5.lock()     // Catch: java.lang.Throwable -> L61
            boolean r0 = r4.f     // Catch: java.lang.Throwable -> L53
            if (r0 != 0) goto L63
            ia r0 = r4.i     // Catch: java.lang.Throwable -> L53
            boolean r0 = r0.isEmpty()     // Catch: java.lang.Throwable -> L53
            if (r0 == 0) goto L55
            r4.f()     // Catch: java.lang.Throwable -> L53
            goto L55
        L53:
            r0 = move-exception
            goto L70
        L55:
            ia r0 = r4.i     // Catch: java.lang.Throwable -> L53
            java.lang.Object r0 = r0.removeLast()     // Catch: java.lang.Throwable -> L53
            c10 r0 = (defpackage.c10) r0     // Catch: java.lang.Throwable -> L53
            r5.unlock()     // Catch: java.lang.Throwable -> L61
            return r0
        L61:
            r5 = move-exception
            goto L74
        L63:
            java.lang.String r0 = "Connection pool is closed"
            r1 = 21
            defpackage.kw3.b(r1, r0)     // Catch: java.lang.Throwable -> L53
            kr1 r0 = new kr1     // Catch: java.lang.Throwable -> L53
            r0.<init>()     // Catch: java.lang.Throwable -> L53
            throw r0     // Catch: java.lang.Throwable -> L53
        L70:
            r5.unlock()     // Catch: java.lang.Throwable -> L61
            throw r0     // Catch: java.lang.Throwable -> L61
        L74:
            n04 r4 = r4.h
            r4.release()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kf3.a(f30):java.lang.Object");
    }

    /* JADX WARN: Can't wrap try/catch for region: R(12:11|45|12|24|43|28|(1:(1:38)(2:34|(1:36)))(1:30)|37|19|47|20|(1:22)(10:23|24|43|28|(0)(0)|37|19|47|20|(0)(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005f, code lost:
    
        r2 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0064, code lost:
    
        r11 = r11;
        r10 = r10;
        r2 = r0;
        r0 = r2;
     */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0057 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x006d A[Catch: all -> 0x0071, TryCatch #0 {all -> 0x0071, blocks: (B:28:0x0069, B:30:0x006d, B:34:0x0075, B:38:0x007c), top: B:43:0x0069 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0058 -> B:24:0x005a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object b(long r8, kotlin.jvm.functions.Function0 r10, defpackage.f30 r11) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r11 instanceof kf3.b
            if (r0 == 0) goto L13
            r0 = r11
            kf3$b r0 = (kf3.b) r0
            int r1 = r0.k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.k = r1
            goto L18
        L13:
            kf3$b r0 = new kf3$b
            r0.<init>(r11)
        L18:
            java.lang.Object r11 = r0.i
            java.lang.Object r1 = defpackage.kl1.e()
            int r2 = r0.k
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3c
            if (r2 != r3) goto L36
            long r8 = r0.f
            java.lang.Object r10 = r0.h
            mp3 r10 = (defpackage.mp3) r10
            java.lang.Object r2 = r0.g
            kotlin.jvm.functions.Function0 r2 = (kotlin.jvm.functions.Function0) r2
            defpackage.lt3.b(r11)     // Catch: java.lang.Throwable -> L34
            goto L5a
        L34:
            r11 = move-exception
            goto L64
        L36:
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.e04.a(r7)
            return r4
        L3c:
            defpackage.lt3.b(r11)
        L3f:
            mp3 r11 = new mp3
            r11.<init>()
            kf3$c r2 = new kf3$c     // Catch: java.lang.Throwable -> L5f
            r2.<init>(r11, r7, r4)     // Catch: java.lang.Throwable -> L5f
            r0.g = r10     // Catch: java.lang.Throwable -> L5f
            r0.h = r11     // Catch: java.lang.Throwable -> L5f
            r0.f = r8     // Catch: java.lang.Throwable -> L5f
            r0.k = r3     // Catch: java.lang.Throwable -> L5f
            java.lang.Object r2 = defpackage.so4.d(r8, r2, r0)     // Catch: java.lang.Throwable -> L5f
            if (r2 != r1) goto L58
            return r1
        L58:
            r2 = r10
            r10 = r11
        L5a:
            r11 = r10
            r10 = r2
            r2 = r0
            r0 = r4
            goto L69
        L5f:
            r2 = move-exception
            r6 = r2
            r2 = r10
            r10 = r11
            r11 = r6
        L64:
            r6 = r11
            r11 = r10
            r10 = r2
            r2 = r0
            r0 = r6
        L69:
            boolean r5 = r0 instanceof defpackage.po4     // Catch: java.lang.Throwable -> L71
            if (r5 == 0) goto L73
            r10.invoke()     // Catch: java.lang.Throwable -> L71
            goto L7a
        L71:
            r8 = move-exception
            goto L7d
        L73:
            if (r0 != 0) goto L7c
            java.lang.Object r11 = r11.f     // Catch: java.lang.Throwable -> L71
            if (r11 == 0) goto L7a
            return r11
        L7a:
            r0 = r2
            goto L3f
        L7c:
            throw r0     // Catch: java.lang.Throwable -> L71
        L7d:
            java.lang.Object r9 = r11.f
            c10 r9 = (defpackage.c10) r9
            if (r9 == 0) goto L86
            r7.e(r9)
        L86:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.kf3.b(long, kotlin.jvm.functions.Function0, f30):java.lang.Object");
    }

    public final void c() {
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            this.f = true;
            for (c10 c10Var : this.g) {
                if (c10Var != null) {
                    c10Var.close();
                }
            }
            fw4 fw4Var = fw4.a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void d(StringBuilder sb) {
        sb.getClass();
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            List listC = nw.c();
            int size = this.i.size();
            for (int i = 0; i < size; i++) {
                listC.add(this.i.get(i));
            }
            List listA = nw.a(listC);
            sb.append('\t' + super.toString() + " (");
            sb.append("capacity=" + this.a + ", ");
            sb.append("permits=" + this.h.a() + ", ");
            sb.append("queue=(size=" + listA.size() + ")[" + ww.P(listA, null, null, null, 0, null, null, 63, null) + ']');
            sb.append(")");
            sb.append('\n');
            c10[] c10VarArr = this.g;
            int length = c10VarArr.length;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                c10 c10Var = c10VarArr[i3];
                i2++;
                StringBuilder sb2 = new StringBuilder();
                sb2.append("\t\t[");
                sb2.append(i2);
                sb2.append("] - ");
                sb2.append(c10Var != null ? c10Var.toString() : null);
                sb.append(sb2.toString());
                sb.append('\n');
                if (c10Var != null) {
                    c10Var.i(sb);
                }
            }
            fw4 fw4Var = fw4.a;
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void e(c10 c10Var) {
        c10Var.getClass();
        ReentrantLock reentrantLock = this.d;
        reentrantLock.lock();
        try {
            this.i.addLast(c10Var);
            fw4 fw4Var = fw4.a;
            reentrantLock.unlock();
            this.h.release();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void f() {
        if (this.e >= this.a) {
            return;
        }
        c10 c10Var = new c10((lw3) this.b.invoke(), null, this.c, 2, null);
        c10[] c10VarArr = this.g;
        int i = this.e;
        this.e = i + 1;
        c10VarArr[i] = c10Var;
        this.i.addLast(c10Var);
    }
}
