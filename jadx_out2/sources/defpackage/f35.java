package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class f35 extends oe4 {
    public final String l;
    public final boolean m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public int s;
    public int t;
    public int u;
    public int v;
    public String w;
    public String x;
    public jm1 y;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public String a;
        public String b;
        public boolean c;
        public mj0 d = mj0.PROGRESSIVE_HTTP;
        public dg2 e;
        public String f;
        public Boolean g;
        public String h;
        public jm1 i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public f35 a() {
            String str = this.a;
            if (str == null) {
                e04.a("The identifier of the video stream has been not set or is null. If you are not able to get an identifier, use the static constant ID_UNKNOWN of the Stream class.");
                return null;
            }
            String str2 = this.b;
            if (str2 == null) {
                e04.a("The content of the video stream has been not set or is null. Please specify a non-null one with setContent.");
                return null;
            }
            mj0 mj0Var = this.d;
            if (mj0Var == null) {
                e04.a("The delivery method of the video stream has been set as null, which is not allowed. Pass a valid one instead with setDeliveryMethod.");
                return null;
            }
            Boolean bool = this.g;
            if (bool == null) {
                e04.a("The video stream has been not set as a video-only stream or as a video stream with embedded audio. Please specify this information with setIsVideoOnly.");
                return null;
            }
            String str3 = this.h;
            if (str3 != null) {
                return new f35(str, str2, this.c, this.e, mj0Var, str3, bool.booleanValue(), this.f, this.i);
            }
            e04.a("The resolution of the video stream has been not set. Please specify it with setResolution (use an empty string if you are not able to get it).");
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a b(String str, boolean z) {
            this.b = str;
            this.c = z;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a c(mj0 mj0Var) {
            this.d = mj0Var;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a d(String str) {
            this.a = str;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a e(boolean z) {
            this.g = Boolean.valueOf(z);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a f(jm1 jm1Var) {
            this.i = jm1Var;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a g(String str) {
            this.f = str;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a h(dg2 dg2Var) {
            this.e = dg2Var;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a i(String str) {
            this.h = str;
            return this;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public f35(String str, String str2, boolean z, dg2 dg2Var, mj0 mj0Var, String str3, boolean z2, String str4, jm1 jm1Var) {
        super(str, str2, z, dg2Var, mj0Var, str4);
        this.n = -1;
        if (jm1Var != null) {
            this.y = jm1Var;
            this.n = jm1Var.g;
            this.o = jm1Var.f();
            this.p = jm1Var.m();
            this.q = jm1Var.l();
            this.r = jm1Var.k();
            this.s = jm1Var.j();
            this.x = jm1Var.g();
            this.u = jm1Var.i();
            this.t = jm1Var.s();
            this.w = jm1Var.p();
            this.v = jm1Var.h();
        }
        this.l = str3;
        this.m = z2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.oe4
    public boolean b(oe4 oe4Var) {
        if (!super.b(oe4Var) || !(oe4Var instanceof f35)) {
            return false;
        }
        f35 f35Var = (f35) oe4Var;
        return this.l.equals(f35Var.l) && this.m == f35Var.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int e() {
        return this.o;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String f() {
        return this.x;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int g() {
        return this.v;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int h() {
        return this.u;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int i() {
        return this.s;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int j() {
        return this.r;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int k() {
        return this.q;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int l() {
        return this.p;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int m() {
        return this.n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int n() {
        return this.t;
    }
}
