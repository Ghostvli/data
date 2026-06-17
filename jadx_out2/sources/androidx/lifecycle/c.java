package androidx.lifecycle;

import androidx.lifecycle.g;
import defpackage.bt1;
import defpackage.hg0;
import defpackage.j33;
import defpackage.jl;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements i {
    public final hg0 f;
    public final i g;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            int[] iArr = new int[g.a.values().length];
            try {
                iArr[g.a.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[g.a.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[g.a.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[g.a.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[g.a.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[g.a.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[g.a.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            a = iArr;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public c(hg0 hg0Var, i iVar) {
        hg0Var.getClass();
        this.f = hg0Var;
        this.g = iVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.lifecycle.i
    public void c(bt1 bt1Var, g.a aVar) {
        bt1Var.getClass();
        aVar.getClass();
        switch (a.a[aVar.ordinal()]) {
            case 1:
                this.f.l(bt1Var);
                break;
            case 2:
                this.f.onStart(bt1Var);
                break;
            case 3:
                this.f.i(bt1Var);
                break;
            case 4:
                this.f.h(bt1Var);
                break;
            case 5:
                this.f.onStop(bt1Var);
                break;
            case 6:
                this.f.onDestroy(bt1Var);
                break;
            case 7:
                jl.a("ON_ANY must not been send by anybody");
                return;
            default:
                throw new j33();
        }
        i iVar = this.g;
        if (iVar != null) {
            iVar.c(bt1Var, aVar);
        }
    }
}
