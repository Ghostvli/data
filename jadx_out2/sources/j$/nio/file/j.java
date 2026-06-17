package j$.nio.file;

import j$.time.DateTimeException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class j {
    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0005: THROW 
      (wrap:java.lang.IllegalArgumentException:0x0002: CONSTRUCTOR (r1v0 java.lang.String) A[MD:(java.lang.String):void (c), WRAPPED] (LINE:3) call: java.lang.IllegalArgumentException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:6) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(String str) {
        throw new IllegalArgumentException(str);
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0011: THROW 
      (wrap:j$.time.DateTimeException:0x000e: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT (r2v0 java.lang.String), (r3v0 int) A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:11))
     A[MD:(java.lang.String):void (c), WRAPPED] (LINE:15) call: j$.time.DateTimeException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:18) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void b(String str, int i) {
        throw new DateTimeException(str + i);
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0014: THROW 
      (wrap:j$.time.DateTimeException:0x0011: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT (r2v0 java.lang.String), (r3v0 int), (r4v0 java.lang.Object) A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:14))
     A[MD:(java.lang.String):void (c), WRAPPED] (LINE:18) call: j$.time.DateTimeException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:21) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void c(String str, int i, Object obj) {
        throw new DateTimeException(str + i + obj);
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0011: THROW 
      (wrap:j$.time.temporal.r:0x000e: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT (r2v0 java.lang.String), (r3v0 java.lang.Object) A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:11))
     A[MD:(java.lang.String):void (c), WRAPPED] (LINE:15) call: j$.time.temporal.r.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:18) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void d(String str, Object obj) {
        throw new j$.time.temporal.r(str + obj);
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0014: THROW 
      (wrap:java.lang.UnsupportedOperationException:0x0011: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT (r2v0 java.lang.String), (r3v0 java.lang.Object), (r4v0 java.lang.Object) A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:14))
     A[MD:(java.lang.String):void (c), WRAPPED] (LINE:18) call: java.lang.UnsupportedOperationException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:21) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void e(String str, Object obj, Object obj2) {
        throw new UnsupportedOperationException(str + obj + obj2);
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0017: THROW 
      (wrap:j$.time.DateTimeException:0x0014: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT (r1v0 java.lang.String), (r2v0 java.lang.Object), (r3v0 java.lang.Object), (r4v0 java.lang.Object) A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:15))
     A[MD:(java.lang.String):void (c), WRAPPED] (LINE:21) call: j$.time.DateTimeException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:24) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void f(String str, Object obj, Object obj2, Object obj3) {
        throw new DateTimeException(str + obj + obj2 + obj3);
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0019: THROW 
      (wrap:j$.time.DateTimeException:0x0016: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT 
      (r1v0 java.lang.String)
      (r2v0 java.lang.Object)
      (wrap:java.lang.Object:?: CAST (java.lang.Object) (" of type "))
      (r3v0 java.lang.Object)
     A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:17))
      (r4v0 java.lang.Throwable)
     A[MD:(java.lang.String, java.lang.Throwable):void (c), WRAPPED] (LINE:23) call: j$.time.DateTimeException.<init>(java.lang.String, java.lang.Throwable):void type: CONSTRUCTOR)
     (LINE:26) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void g(String str, Object obj, Object obj2, Throwable th) {
        throw new DateTimeException(str + obj + ((Object) " of type ") + obj2, th);
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0005: THROW 
      (wrap:j$.time.DateTimeException:0x0002: CONSTRUCTOR (r1v0 java.lang.String) A[MD:(java.lang.String):void (c), WRAPPED] (LINE:3) call: j$.time.DateTimeException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:6) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void h(String str) {
        throw new DateTimeException(str);
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0011: THROW 
      (wrap:java.lang.IllegalArgumentException:0x000e: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT (r2v0 java.lang.String), (wrap:char:?: CAST (char) (r3v0 int)) A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:11))
     A[MD:(java.lang.String):void (c), WRAPPED] (LINE:15) call: java.lang.IllegalArgumentException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:18) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void i(String str, int i) {
        throw new IllegalArgumentException(str + ((char) i));
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0011: THROW 
      (wrap:j$.time.DateTimeException:0x000e: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT (r2v0 java.lang.String), (r3v0 java.lang.Object) A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:11))
     A[MD:(java.lang.String):void (c), WRAPPED] (LINE:15) call: j$.time.DateTimeException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:18) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void j(String str, Object obj) {
        throw new DateTimeException(str + obj);
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0019: THROW 
      (wrap:java.lang.ClassCastException:0x0016: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT 
      (r1v0 java.lang.String)
      (r2v0 java.lang.Object)
      (wrap:java.lang.Object:?: CAST (java.lang.Object) (", actual: "))
      (r3v0 java.lang.Object)
     A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:17))
     A[MD:(java.lang.String):void (c), WRAPPED] (LINE:23) call: java.lang.ClassCastException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:26) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void k(String str, Object obj, Object obj2) {
        throw new ClassCastException(str + obj + ((Object) ", actual: ") + obj2);
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0017: THROW 
      (wrap:j$.time.DateTimeException:0x0014: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT (r2v0 java.lang.String), (r3v0 java.lang.Object), (r4v0 java.lang.Object), (r5v0 java.lang.Object) A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:17))
     A[MD:(java.lang.String):void (c), WRAPPED] (LINE:21) call: j$.time.DateTimeException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:24) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void l(String str, Object obj, Object obj2, Object obj3) {
        throw new DateTimeException(str + obj + obj2 + obj3);
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0011: THROW 
      (wrap:java.lang.IllegalArgumentException:0x000e: CONSTRUCTOR 
      (wrap:java.lang.String:STR_CONCAT (r2v0 java.lang.String), (r3v0 int) A[MD:():java.lang.String (c), SYNTHETIC, WRAPPED] (LINE:11))
     A[MD:(java.lang.String):void (c), WRAPPED] (LINE:15) call: java.lang.IllegalArgumentException.<init>(java.lang.String):void type: CONSTRUCTOR)
     (LINE:18) */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void m(String str, int i) {
        throw new IllegalArgumentException(str + i);
    }
}
