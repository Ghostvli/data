package defpackage;

import java.util.Collections;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class vy1 {
    public static final uy1 c = new uy1(Object.class, Object.class, Object.class, Collections.singletonList(new cb0(Object.class, Object.class, Object.class, Collections.EMPTY_LIST, new jw4(), null)), null);
    public final la a = new la();
    public final AtomicReference b = new AtomicReference();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public uy1 a(Class cls, Class cls2, Class cls3) {
        uy1 uy1Var;
        yv2 yv2VarB = b(cls, cls2, cls3);
        synchronized (this.a) {
            uy1Var = (uy1) this.a.get(yv2VarB);
        }
        this.b.set(yv2VarB);
        return uy1Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final yv2 b(Class cls, Class cls2, Class cls3) {
        yv2 yv2Var = (yv2) this.b.getAndSet(null);
        if (yv2Var == null) {
            yv2Var = new yv2();
        }
        yv2Var.a(cls, cls2, cls3);
        return yv2Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean c(uy1 uy1Var) {
        return c.equals(uy1Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d(Class cls, Class cls2, Class cls3, uy1 uy1Var) {
        synchronized (this.a) {
            la laVar = this.a;
            yv2 yv2Var = new yv2(cls, cls2, cls3);
            if (uy1Var == null) {
                uy1Var = c;
            }
            laVar.put(yv2Var, uy1Var);
        }
    }
}
