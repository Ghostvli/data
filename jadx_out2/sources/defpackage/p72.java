package defpackage;

import defpackage.f35;
import defpackage.p72;
import defpackage.qd;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class p72 extends ue4 {
    public ko1 h;
    public String i;
    public ko1 j;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final ko1 a;
        public final String b;
        public final ko1 c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(ko1 ko1Var, String str, ko1 ko1Var2) {
            this.a = ko1Var;
            this.b = str;
            this.c = ko1Var2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public p72(wf4 wf4Var, vt1 vt1Var) {
        super(wf4Var, vt1Var);
        this.h = null;
        this.i = "";
        this.j = null;
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0004: INSTANCE_OF 
      (wrap:java.lang.Object:0x0000: INVOKE (r0v0 java.util.Map$Entry) INTERFACE call: java.util.Map.Entry.getValue():java.lang.Object A[MD:():V (c), WRAPPED] (LINE:1))
     (LINE:5) ko1 */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean e0(Map.Entry entry) {
        return entry.getValue() instanceof ko1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ qd g0(a aVar) {
        qd.a aVarR = new qd.a().u(aVar.c.p("tech", " ")).s(aVar.c.o("url"), true).r(-1);
        return "hls".equals(aVar.b) ? aVarR.t(mj0.HLS).m() : aVarR.x(dg2.b(aVar.b)).m();
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x000e: CONSTRUCTOR 
      (r2v0 ko1)
      (wrap:java.lang.String:0x0006: CHECK_CAST (java.lang.String) (wrap:java.lang.Object:0x0002: INVOKE (r3v0 java.util.Map$Entry) INTERFACE call: java.util.Map.Entry.getKey():java.lang.Object A[MD:():K (c), WRAPPED] (LINE:3)))
      (wrap:ko1:0x000c: CHECK_CAST (ko1) (wrap:java.lang.Object:0x0008: INVOKE (r3v0 java.util.Map$Entry) INTERFACE call: java.util.Map.Entry.getValue():java.lang.Object A[MD:():V (c), WRAPPED] (LINE:9)))
     A[MD:(ko1, java.lang.String, ko1):void (m)] (LINE:15) call: p72.a.<init>(ko1, java.lang.String, ko1):void type: CONSTRUCTOR */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ a j0(ko1 ko1Var, Map.Entry entry) {
        return new a(ko1Var, (String) entry.getKey(), (ko1) entry.getValue());
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: NOT 
      (wrap:boolean:0x0004: INVOKE 
      ("dash")
      (wrap:java.lang.String:0x0002: IGET (r1v0 p72$a) A[DONT_GENERATE, REMOVE, WRAPPED] (LINE:3) p72.a.b java.lang.String)
     VIRTUAL call: java.lang.String.equals(java.lang.Object):boolean A[DONT_GENERATE, MD:(java.lang.Object):boolean (c), REMOVE, WRAPPED] (LINE:5))
     */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean l0(a aVar) {
        return !"dash".equals(aVar.b);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ f35 m0(a aVar) {
        eo1 eo1VarB = aVar.a.b("videoSize");
        f35.a aVarI = new f35.a().d(aVar.c.p("tech", " ")).b(aVar.c.o("url"), true).e(false).i(eo1VarB.b(0) + "x" + eo1VarB.b(1));
        return "hls".equals(aVar.b) ? aVarI.c(mj0.HLS).a() : aVarI.h(dg2.b(aVar.b)).a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public gf4 J() {
        return gf4.LIVE_STREAM;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List R() {
        return q72.c(this.j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String W() {
        return this.h.o("conference");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String Y() {
        return "https://streaming.media.ccc.de/" + this.h.o("slug");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List Z() {
        return Collections.EMPTY_LIST;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List a0() {
        return p0("video", new Function() { // from class: j72
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return p72.m0((p72.a) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public long b0() {
        return -1L;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gz0
    public String j() {
        return this.j.o("display");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String o0(final String str) {
        return (String) this.j.b("streams").stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).map(new Function() { // from class: g72
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ko1) obj).m("urls");
            }
        }).filter(new Predicate() { // from class: h72
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ((ko1) obj).q(str);
            }
        }).map(new Function() { // from class: i72
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ((ko1) obj).m(str).p("url", "");
            }
        }).findFirst().orElse("");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.gz0
    public void p(gn0 gn0Var) throws fz0 {
        eo1 eo1VarB = q72.b(gn0Var, g());
        for (int i = 0; i < eo1VarB.size(); i++) {
            ko1 ko1VarD = eo1VarB.d(i);
            eo1 eo1VarB2 = ko1VarD.b("groups");
            for (int i2 = 0; i2 < eo1VarB2.size(); i2++) {
                String strO = eo1VarB2.d(i2).o("group");
                eo1 eo1VarB3 = eo1VarB2.d(i2).b("rooms");
                for (int i3 = 0; i3 < eo1VarB3.size(); i3++) {
                    ko1 ko1VarD2 = eo1VarB3.d(i3);
                    if (h().equals(ko1VarD.o("slug") + ServiceReference.DELIMITER + ko1VarD2.o("slug"))) {
                        this.h = ko1VarD;
                        this.i = strO;
                        this.j = ko1VarD2;
                        return;
                    }
                }
            }
        }
        throw new fz0("Could not find room matching id: '" + h() + "'");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final List p0(final String str, Function function) {
        return (List) this.j.b("streams").stream().filter(new co1(ko1.class)).map(new e72(ko1.class)).filter(new Predicate() { // from class: l72
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return str.equals(((ko1) obj).o("type"));
            }
        }).flatMap(new Function() { // from class: m72
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                ko1 ko1Var = (ko1) obj;
                return ko1Var.m("urls").entrySet().stream().filter(new Predicate() { // from class: o72
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.util.function.Predicate
                    public final boolean test(Object obj2) {
                        return p72.e0((Map.Entry) obj2);
                    }
                }).map(new Function() { // from class: f72
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // java.util.function.Function
                    public final Object apply(Object obj2) {
                        return p72.j0(ko1Var, (Map.Entry) obj2);
                    }
                });
            }
        }).filter(new Predicate() { // from class: n72
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return p72.l0((p72.a) obj);
            }
        }).map(function).collect(Collectors.toList());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public List r() {
        return p0("audio", new Function() { // from class: k72
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return p72.g0((p72.a) obj);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String s() {
        return this.i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String u() {
        return o0("dash");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public qj0 v() {
        return new qj0(this.h.o("description") + " - " + this.i, 3);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.ue4
    public String z() {
        return o0("hls");
    }
}
