package defpackage;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.c;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class br3 extends pi implements Cloneable {
    public static final qr3 T = (qr3) ((qr3) ((qr3) new qr3().g(zl0.c)).W(ug3.LOW)).e0(true);
    public final Context F;
    public final lr3 G;
    public final Class H;
    public final com.bumptech.glide.a I;
    public final c J;
    public ct4 K;
    public Object L;
    public List M;
    public br3 N;
    public br3 O;
    public Float P;
    public boolean Q = true;
    public boolean R;
    public boolean S;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[ug3.values().length];
            b = iArr;
            try {
                iArr[ug3.LOW.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[ug3.NORMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[ug3.HIGH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                b[ug3.IMMEDIATE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            int[] iArr2 = new int[ImageView.ScaleType.values().length];
            a = iArr2;
            try {
                iArr2[ImageView.ScaleType.CENTER_CROP.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ImageView.ScaleType.CENTER_INSIDE.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ImageView.ScaleType.FIT_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ImageView.ScaleType.FIT_START.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ImageView.ScaleType.FIT_END.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ImageView.ScaleType.FIT_XY.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ImageView.ScaleType.CENTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[ImageView.ScaleType.MATRIX.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public br3(com.bumptech.glide.a aVar, lr3 lr3Var, Class cls, Context context) {
        this.I = aVar;
        this.G = lr3Var;
        this.H = cls;
        this.F = context;
        this.K = lr3Var.s(cls);
        this.J = aVar.i();
        r0(lr3Var.q());
        a(lr3Var.r());
    }

    public br3 A0(String str) {
        return B0(str);
    }

    public final br3 B0(Object obj) {
        if (E()) {
            return clone().B0(obj);
        }
        this.L = obj;
        this.R = true;
        return (br3) a0();
    }

    public final yq3 C0(Object obj, rl4 rl4Var, jr3 jr3Var, pi piVar, er3 er3Var, ct4 ct4Var, ug3 ug3Var, int i, int i2, Executor executor) {
        Context context = this.F;
        c cVar = this.J;
        return i74.y(context, cVar, obj, this.L, this.H, piVar, i, i2, ug3Var, rl4Var, jr3Var, this.M, er3Var, cVar.f(), ct4Var.b(), executor);
    }

    public w81 D0() {
        return E0(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public w81 E0(int i, int i2) {
        gr3 gr3Var = new gr3(i, i2);
        return (w81) u0(gr3Var, gr3Var, sv0.a());
    }

    @Override // defpackage.pi
    public boolean equals(Object obj) {
        if (obj instanceof br3) {
            br3 br3Var = (br3) obj;
            if (super.equals(br3Var) && Objects.equals(this.H, br3Var.H) && this.K.equals(br3Var.K) && Objects.equals(this.L, br3Var.L) && Objects.equals(this.M, br3Var.M) && Objects.equals(this.N, br3Var.N) && Objects.equals(this.O, br3Var.O) && Objects.equals(this.P, br3Var.P) && this.Q == br3Var.Q && this.R == br3Var.R) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.pi
    public int hashCode() {
        return iy4.q(this.R, iy4.q(this.Q, iy4.p(this.P, iy4.p(this.O, iy4.p(this.N, iy4.p(this.M, iy4.p(this.L, iy4.p(this.K, iy4.p(this.H, super.hashCode())))))))));
    }

    public br3 k0(jr3 jr3Var) {
        if (E()) {
            return clone().k0(jr3Var);
        }
        if (jr3Var != null) {
            if (this.M == null) {
                this.M = new ArrayList();
            }
            this.M.add(jr3Var);
        }
        return (br3) a0();
    }

    @Override // defpackage.pi
    /* JADX INFO: renamed from: l0, reason: merged with bridge method [inline-methods] */
    public br3 a(pi piVar) {
        fg3.e(piVar);
        return (br3) super.a(piVar);
    }

    public final yq3 m0(rl4 rl4Var, jr3 jr3Var, pi piVar, Executor executor) {
        return n0(new Object(), rl4Var, jr3Var, null, this.K, piVar.w(), piVar.t(), piVar.s(), piVar, executor);
    }

    public final yq3 n0(Object obj, rl4 rl4Var, jr3 jr3Var, er3 er3Var, ct4 ct4Var, ug3 ug3Var, int i, int i2, pi piVar, Executor executor) {
        nu0 nu0Var;
        if (this.O != null) {
            nu0Var = new nu0(obj, er3Var);
            er3Var = nu0Var;
        } else {
            nu0Var = null;
        }
        yq3 yq3VarO0 = o0(obj, rl4Var, jr3Var, er3Var, ct4Var, ug3Var, i, i2, piVar, executor);
        if (nu0Var == null) {
            return yq3VarO0;
        }
        int iT = this.O.t();
        int iS = this.O.s();
        if (iy4.u(i, i2) && !this.O.O()) {
            iT = piVar.t();
            iS = piVar.s();
        }
        int i3 = iS;
        br3 br3Var = this.O;
        nu0 nu0Var2 = nu0Var;
        nu0Var2.o(yq3VarO0, br3Var.n0(obj, rl4Var, jr3Var, nu0Var2, br3Var.K, br3Var.w(), iT, i3, this.O, executor));
        return nu0Var2;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final yq3 o0(Object obj, rl4 rl4Var, jr3 jr3Var, er3 er3Var, ct4 ct4Var, ug3 ug3Var, int i, int i2, pi piVar, Executor executor) {
        br3 br3Var = this.N;
        if (br3Var == null) {
            if (this.P == null) {
                return C0(obj, rl4Var, jr3Var, piVar, er3Var, ct4Var, ug3Var, i, i2, executor);
            }
            yn4 yn4Var = new yn4(obj, er3Var);
            yn4Var.n(C0(obj, rl4Var, jr3Var, piVar, yn4Var, ct4Var, ug3Var, i, i2, executor), C0(obj, rl4Var, jr3Var, piVar.clone().d0(this.P.floatValue()), yn4Var, ct4Var, q0(ug3Var), i, i2, executor));
            return yn4Var;
        }
        if (this.S) {
            e04.a("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            return null;
        }
        ct4 ct4Var2 = br3Var.Q ? ct4Var : br3Var.K;
        ug3 ug3VarW = br3Var.H() ? this.N.w() : q0(ug3Var);
        int iT = this.N.t();
        int iS = this.N.s();
        if (iy4.u(i, i2) && !this.N.O()) {
            iT = piVar.t();
            iS = piVar.s();
        }
        yn4 yn4Var2 = new yn4(obj, er3Var);
        yq3 yq3VarC0 = C0(obj, rl4Var, jr3Var, piVar, yn4Var2, ct4Var, ug3Var, i, i2, executor);
        this.S = true;
        br3 br3Var2 = this.N;
        yq3 yq3VarN0 = br3Var2.n0(obj, rl4Var, jr3Var, yn4Var2, ct4Var2, ug3VarW, iT, iS, br3Var2, executor);
        this.S = false;
        yn4Var2.n(yq3VarC0, yq3VarN0);
        return yn4Var2;
    }

    @Override // defpackage.pi
    /* JADX INFO: renamed from: p0, reason: merged with bridge method [inline-methods] */
    public br3 clone() {
        br3 br3Var = (br3) super.clone();
        br3Var.K = br3Var.K.clone();
        if (br3Var.M != null) {
            br3Var.M = new ArrayList(br3Var.M);
        }
        br3 br3Var2 = br3Var.N;
        if (br3Var2 != null) {
            br3Var.N = br3Var2.clone();
        }
        br3 br3Var3 = br3Var.O;
        if (br3Var3 != null) {
            br3Var.O = br3Var3.clone();
        }
        return br3Var;
    }

    public final ug3 q0(ug3 ug3Var) {
        int i = a.b[ug3Var.ordinal()];
        if (i == 1) {
            return ug3.NORMAL;
        }
        if (i == 2) {
            return ug3.HIGH;
        }
        if (i == 3 || i == 4) {
            return ug3.IMMEDIATE;
        }
        nl.a("unknown priority: ", w());
        return null;
    }

    public final void r0(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            k0((jr3) it.next());
        }
    }

    public rl4 s0(rl4 rl4Var) {
        return u0(rl4Var, null, sv0.b());
    }

    public final rl4 t0(rl4 rl4Var, jr3 jr3Var, pi piVar, Executor executor) {
        fg3.e(rl4Var);
        if (!this.R) {
            jl.a("You must call #load() before calling #into()");
            return null;
        }
        yq3 yq3VarM0 = m0(rl4Var, jr3Var, piVar, executor);
        yq3 yq3VarL = rl4Var.l();
        if (yq3VarM0.d(yq3VarL) && !w0(piVar, yq3VarL)) {
            if (!((yq3) fg3.e(yq3VarL)).isRunning()) {
                yq3VarL.i();
            }
            return rl4Var;
        }
        this.G.n(rl4Var);
        rl4Var.f(yq3VarM0);
        this.G.A(rl4Var, yq3VarM0);
        return rl4Var;
    }

    public rl4 u0(rl4 rl4Var, jr3 jr3Var, Executor executor) {
        return t0(rl4Var, jr3Var, this, executor);
    }

    public y45 v0(ImageView imageView) {
        pi piVarQ;
        iy4.b();
        fg3.e(imageView);
        if (!N() && L() && imageView.getScaleType() != null) {
            switch (a.a[imageView.getScaleType().ordinal()]) {
                case 1:
                    piVarQ = clone().Q();
                    break;
                case 2:
                    piVarQ = clone().R();
                    break;
                case 3:
                case 4:
                case 5:
                    piVarQ = clone().S();
                    break;
                case 6:
                    piVarQ = clone().R();
                    break;
                default:
                    piVarQ = this;
                    break;
            }
        } else {
            piVarQ = this;
        }
        return (y45) t0(this.J.a(imageView, this.H), null, piVarQ, sv0.b());
    }

    public final boolean w0(pi piVar, yq3 yq3Var) {
        return !piVar.G() && yq3Var.j();
    }

    public br3 x0(jr3 jr3Var) {
        if (E()) {
            return clone().x0(jr3Var);
        }
        this.M = null;
        return k0(jr3Var);
    }

    public br3 y0(File file) {
        return B0(file);
    }

    public br3 z0(Object obj) {
        return B0(obj);
    }
}
