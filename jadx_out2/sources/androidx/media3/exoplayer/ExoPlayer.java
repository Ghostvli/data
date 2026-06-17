package androidx.media3.exoplayer;

import android.content.Context;
import android.os.Looper;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.c;
import androidx.media3.exoplayer.d;
import androidx.media3.exoplayer.image.ImageOutput;
import com.hierynomus.msdtyp.FileTime;
import defpackage.ay1;
import defpackage.cc3;
import defpackage.ch0;
import defpackage.fy4;
import defpackage.fz3;
import defpackage.gg3;
import defpackage.hd3;
import defpackage.jq2;
import defpackage.lq3;
import defpackage.or4;
import defpackage.p81;
import defpackage.ri0;
import defpackage.ug0;
import defpackage.vf0;
import defpackage.wc;
import defpackage.xi4;
import defpackage.yb;
import defpackage.zu;
import defpackage.zz3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface ExoPlayer extends hd3 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void C(boolean z);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        default void z(boolean z) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public static final c b = new c(-9223372036854775807L);
        public final long a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(long j) {
            this.a = j;
        }
    }

    void a(boolean z);

    boolean isScrubbingModeEnabled();

    @Override // defpackage.hd3
    void release();

    void setImageOutput(ImageOutput imageOutput);

    void setScrubbingModeEnabled(boolean z);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public static final int R;
        public static boolean S;
        public long A;
        public ay1 B;
        public long C;
        public long D;
        public int E;
        public int F;
        public int G;
        public int H;
        public boolean I;
        public boolean J;
        public cc3 K;
        public boolean L;
        public boolean M;
        public String N;
        public boolean O;
        public r P;
        public boolean Q;
        public final Context a;
        public zu b;
        public long c;
        public xi4 d;
        public xi4 e;
        public xi4 f;
        public xi4 g;
        public xi4 h;
        public p81 i;
        public wc j;
        public Looper k;
        public int l;
        public yb m;
        public boolean n;
        public int o;
        public boolean p;
        public boolean q;
        public boolean r;
        public boolean s;
        public int t;
        public int u;
        public boolean v;
        public zz3 w;
        public fz3 x;
        public long y;
        public long z;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        static {
            R = fy4.V0() ? 30000 : FileTime.NANO100_TO_MILLI;
            S = true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(Context context, xi4 xi4Var, xi4 xi4Var2, xi4 xi4Var3, xi4 xi4Var4, xi4 xi4Var5, p81 p81Var) {
            this.a = (Context) gg3.q(context);
            this.d = xi4Var;
            this.e = xi4Var2;
            this.f = xi4Var3;
            this.g = xi4Var4;
            this.h = xi4Var5;
            this.i = p81Var;
            this.k = fy4.f0();
            this.m = yb.i;
            this.o = 0;
            this.t = 1;
            this.u = 0;
            this.v = true;
            this.w = zz3.g;
            this.y = 5000L;
            this.z = 15000L;
            this.A = 3000L;
            this.x = fz3.j;
            this.B = new c.b().a();
            this.b = zu.a;
            this.C = 500L;
            this.D = 2000L;
            this.E = 600000;
            boolean z = S;
            this.F = z ? R : Integer.MAX_VALUE;
            this.G = z ? 60000 : Integer.MAX_VALUE;
            this.H = 600000;
            this.J = true;
            this.N = "";
            this.l = -1000;
            this.P = new f();
            this.Q = true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ lq3 a(lq3 lq3Var) {
            return lq3Var;
        }

        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0002: CONSTRUCTOR (r1v0 android.content.Context) A[MD:(android.content.Context):void (m)] (LINE:3) call: ch0.<init>(android.content.Context):void type: CONSTRUCTOR */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ lq3 b(Context context) {
            return new ch0(context);
        }

        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0007: CONSTRUCTOR 
          (r2v0 android.content.Context)
          (wrap:vf0:0x0004: CONSTRUCTOR  A[MD:():void (m), WRAPPED] (LINE:5) call: vf0.<init>():void type: CONSTRUCTOR)
         A[MD:(android.content.Context, pz0):void (m)] (LINE:8) call: ug0.<init>(android.content.Context, pz0):void type: CONSTRUCTOR */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ jq2.a c(Context context) {
            return new ug0(context, new vf0());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ i d(i iVar) {
            return iVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ jq2.a e(jq2.a aVar) {
            return aVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ or4 g(or4 or4Var) {
            return or4Var;
        }

        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0002: CONSTRUCTOR (r1v0 android.content.Context) A[MD:(android.content.Context):void (m)] (LINE:3) call: ri0.<init>(android.content.Context):void type: CONSTRUCTOR */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ or4 h(Context context) {
            return new ri0(context);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public ExoPlayer i() {
            gg3.v(!this.L);
            this.L = true;
            return new g(this, null);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b j(final i iVar) {
            gg3.v(!this.L);
            gg3.q(iVar);
            this.g = new xi4() { // from class: cw0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.xi4
                public final Object get() {
                    return ExoPlayer.b.d(iVar);
                }
            };
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b k(final jq2.a aVar) {
            gg3.v(!this.L);
            gg3.q(aVar);
            this.e = new xi4() { // from class: iw0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.xi4
                public final Object get() {
                    return ExoPlayer.b.e(aVar);
                }
            };
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b l(final lq3 lq3Var) {
            gg3.v(!this.L);
            gg3.q(lq3Var);
            this.d = new xi4() { // from class: jw0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.xi4
                public final Object get() {
                    return ExoPlayer.b.a(lq3Var);
                }
            };
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b m(final or4 or4Var) {
            gg3.v(!this.L);
            gg3.q(or4Var);
            this.f = new xi4() { // from class: hw0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.xi4
                public final Object get() {
                    return ExoPlayer.b.g(or4Var);
                }
            };
            return this;
        }

        public b(final Context context, xi4 xi4Var, xi4 xi4Var2) {
            this(context, xi4Var, xi4Var2, new xi4() { // from class: dw0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.xi4
                public final Object get() {
                    return ExoPlayer.b.h(context);
                }
            }, new xi4() { // from class: ew0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.xi4
                public final Object get() {
                    return new d();
                }
            }, new xi4() { // from class: fw0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.xi4
                public final Object get() {
                    return se0.n(context);
                }
            }, new p81() { // from class: gw0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.p81
                public final Object apply(Object obj) {
                    return new ke0((zu) obj);
                }
            });
        }

        public b(final Context context) {
            this(context, new xi4() { // from class: aw0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.xi4
                public final Object get() {
                    return ExoPlayer.b.b(context);
                }
            }, new xi4() { // from class: bw0
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // defpackage.xi4
                public final Object get() {
                    return ExoPlayer.b.c(context);
                }
            });
        }
    }
}
