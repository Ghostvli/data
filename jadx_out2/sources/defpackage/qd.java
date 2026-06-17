package defpackage;

import java.util.Locale;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class qd extends oe4 {
    public final int l;
    public int m;
    public int n;
    public int o;
    public int p;
    public int q;
    public int r;
    public String s;
    public String t;
    public final String u;
    public final String v;
    public final Locale w;
    public final je x;
    public jm1 y;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public String a;
        public String b;
        public boolean c;
        public dg2 e;
        public String f;
        public String h;
        public String i;
        public Locale j;
        public je k;
        public jm1 l;
        public mj0 d = mj0.PROGRESSIVE_HTTP;
        public int g = -1;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public qd m() {
            y();
            return new qd(this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a n(Locale locale) {
            this.j = locale;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a o(String str) {
            this.h = str;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a p(String str) {
            this.i = str;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a q(je jeVar) {
            this.k = jeVar;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a r(int i) {
            this.g = i;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a s(String str, boolean z) {
            this.b = str;
            this.c = z;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a t(mj0 mj0Var) {
            this.d = mj0Var;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a u(String str) {
            this.a = str;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a v(jm1 jm1Var) {
            this.l = jm1Var;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a w(String str) {
            this.f = str;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a x(dg2 dg2Var) {
            this.e = dg2Var;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void y() {
            if (this.a == null) {
                e04.a("The identifier of the audio stream has been not set or is null. If you are not able to get an identifier, use the static constant ID_UNKNOWN of the Stream class.");
            } else if (this.b == null) {
                e04.a("The content of the audio stream has been not set or is null. Please specify a non-null one with setContent.");
            } else {
                if (this.d != null) {
                    return;
                }
                e04.a("The delivery method of the audio stream has been set as null, which is not allowed. Pass a valid one instead with setDeliveryMethod.");
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public qd(a aVar) {
        super(aVar.a, aVar.b, aVar.c, aVar.e, aVar.d, aVar.f);
        this.m = -1;
        if (aVar.l != null) {
            this.y = aVar.l;
            this.m = aVar.l.g;
            this.s = aVar.l.p();
            this.n = aVar.l.f();
            this.o = aVar.l.m();
            this.p = aVar.l.l();
            this.q = aVar.l.k();
            this.r = aVar.l.j();
            this.t = aVar.l.g();
        }
        this.l = aVar.g;
        this.u = aVar.h;
        this.v = aVar.i;
        this.w = aVar.j;
        this.x = aVar.k;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.oe4
    public boolean b(oe4 oe4Var) {
        if (!super.b(oe4Var) || !(oe4Var instanceof qd)) {
            return false;
        }
        qd qdVar = (qd) oe4Var;
        return this.l == qdVar.l && Objects.equals(this.u, qdVar.u) && this.x == qdVar.x && Objects.equals(this.w, qdVar.w);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int e() {
        return this.n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String f() {
        return this.t;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int g() {
        return this.r;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int h() {
        return this.q;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int i() {
        return this.p;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int j() {
        return this.o;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int k() {
        return this.m;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public jm1 l() {
        return this.y;
    }
}
