package defpackage;

import defpackage.su0;
import defpackage.wm0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.simpleframework.xml.strategy.Name;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class br0 extends l33 implements Iterable {
    public static final List l = Collections.EMPTY_LIST;
    public static final a m = new a(0);
    public static final Pattern n = Pattern.compile("\\s+");
    public static final String o = xb.y("baseUri");
    public al4 i;
    public a j;
    public xb k;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends ArrayList {
        public boolean f;

        public a(int i) {
            super(i);
            this.f = true;
        }

        public void b() {
            ((ArrayList) this).modCount++;
        }

        public int c() {
            return ((ArrayList) this).modCount;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b implements r33 {
        public final StringBuilder a;

        public b(StringBuilder sb) {
            this.a = sb;
        }

        @Override // defpackage.r33
        public void a(l33 l33Var, int i) {
            if (l33Var instanceof sm4) {
                br0.g0(this.a, (sm4) l33Var);
            } else if (l33Var instanceof br0) {
                br0 br0Var = (br0) l33Var;
                if (this.a.length() > 0) {
                    if ((br0Var.H0() || br0Var.z("br")) && !sm4.h0(this.a)) {
                        this.a.append(' ');
                    }
                }
            }
        }

        @Override // defpackage.r33
        public void b(l33 l33Var, int i) {
            if (l33Var instanceof br0) {
                br0 br0Var = (br0) l33Var;
                l33 l33VarB = l33Var.B();
                if (br0Var.i.f()) {
                    return;
                }
                if (((l33VarB instanceof sm4) || ((l33VarB instanceof br0) && ((br0) l33VarB).i.f())) && !sm4.h0(this.a)) {
                    this.a.append(' ');
                }
            }
        }
    }

    public br0(al4 al4Var, String str, xb xbVar) {
        zy4.j(al4Var);
        this.j = m;
        this.k = xbVar;
        this.i = al4Var;
        if (fg4.j(str)) {
            return;
        }
        V(str);
    }

    public static int F0(br0 br0Var, List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (list.get(i) == br0Var) {
                return i;
            }
        }
        return 0;
    }

    public static boolean N0(l33 l33Var) {
        if (l33Var instanceof br0) {
            br0 br0VarL = (br0) l33Var;
            int i = 0;
            while (!br0VarL.i.k()) {
                br0VarL = br0VarL.L();
                i++;
                if (i >= 6 || br0VarL == null) {
                }
            }
            return true;
        }
        return false;
    }

    public static String Q0(br0 br0Var, String str) {
        while (br0Var != null) {
            xb xbVar = br0Var.k;
            if (xbVar != null && xbVar.p(str)) {
                return br0Var.k.m(str);
            }
            br0Var = br0Var.L();
        }
        return null;
    }

    public static /* synthetic */ String a0(l33 l33Var) {
        return l33Var instanceof sm4 ? ((sm4) l33Var).f0() : l33Var.z("br") ? "\n" : "";
    }

    public static /* synthetic */ void b0(StringBuilder sb, l33 l33Var, int i) {
        if (l33Var instanceof w90) {
            sb.append(((w90) l33Var).f0());
        } else if (l33Var instanceof lx) {
            sb.append(((lx) l33Var).f0());
        } else if (l33Var instanceof pn) {
            sb.append(((pn) l33Var).f0());
        }
    }

    public static String b1(Stream stream) {
        return (String) stream.map(new Function() { // from class: wq0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return br0.a0((l33) obj);
            }
        }).collect(fg4.s(""));
    }

    public static void g0(StringBuilder sb, sm4 sm4Var) {
        String strF0 = sm4Var.f0();
        if (N0(sm4Var.f) || (sm4Var instanceof pn)) {
            sb.append(strF0);
        } else {
            fg4.d(sb, strF0, sm4.h0(sb));
        }
    }

    public boolean A0(String str) {
        String str2;
        xb xbVar = this.k;
        if (xbVar == null) {
            return false;
        }
        String strN = xbVar.n(Name.LABEL);
        int length = strN.length();
        int length2 = str.length();
        if (length != 0 && length >= length2) {
            if (length == length2) {
                return str.equalsIgnoreCase(strN);
            }
            int i = 0;
            boolean z = false;
            int i2 = 0;
            while (i < length) {
                if (!Character.isWhitespace(strN.charAt(i))) {
                    str2 = str;
                    if (!z) {
                        i2 = i;
                        z = true;
                    }
                } else if (z) {
                    if (i - i2 == length2) {
                        str2 = str;
                        if (strN.regionMatches(true, i2, str2, 0, length2)) {
                            return true;
                        }
                    } else {
                        str2 = str;
                    }
                    z = false;
                } else {
                    str2 = str;
                }
                i++;
                str = str2;
            }
            String str3 = str;
            if (z && length - i2 == length2) {
                return strN.regionMatches(true, i2, str3, 0, length2);
            }
        }
        return false;
    }

    public boolean B0() {
        return this.j.f;
    }

    @Override // defpackage.l33
    public String C() {
        return this.i.b();
    }

    public Appendable C0(Appendable appendable) {
        l33 l33VarS = s();
        if (l33VarS != null) {
            sg3 sg3VarI = sg3.i(l33VarS, uj3.d(appendable));
            while (l33VarS != null) {
                sg3VarI.c(l33VarS);
                l33VarS = l33VarS.B();
            }
        }
        return appendable;
    }

    public String D0() {
        StringBuilder sbE = fg4.e();
        C0(sbE);
        String strV = fg4.v(sbE);
        return q33.a(this).i() ? strV.trim() : strV;
    }

    public String E0() {
        xb xbVar = this.k;
        return xbVar != null ? xbVar.n(Name.MARK) : "";
    }

    @Override // defpackage.l33
    public String F() {
        return Z0();
    }

    @Override // defpackage.l33
    public String G() {
        return this.i.j();
    }

    public void G0() {
        this.j.f = false;
    }

    public boolean H0() {
        return this.i.d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public br0 I0() {
        for (int size = this.j.size() - 1; size >= 0; size--) {
            l33 l33Var = (l33) this.j.get(size);
            if (l33Var instanceof br0) {
                return (br0) l33Var;
            }
        }
        return null;
    }

    @Override // defpackage.l33
    public void J(uj3 uj3Var, wm0.a aVar) {
        String strP0 = P0(aVar.j());
        uj3Var.a('<').b(strP0);
        xb xbVar = this.k;
        if (xbVar != null) {
            xbVar.u(uj3Var, aVar);
        }
        if (!this.j.isEmpty()) {
            uj3Var.a('>');
            return;
        }
        boolean z = aVar.j() == wm0.a.EnumC0128a.xml || !this.i.i().equals("http://www.w3.org/1999/xhtml");
        if (z && (this.i.c(al4.o) || (this.i.g() && (this.i.e() || this.i.h())))) {
            uj3Var.b(" />");
        } else if (z || !this.i.e()) {
            uj3Var.b("></").b(strP0).a('>');
        } else {
            uj3Var.a('>');
        }
    }

    public void J0(uj3 uj3Var, wm0.a aVar) {
        if (this.j.isEmpty()) {
            return;
        }
        uj3Var.b("</").b(P0(aVar.j())).a('>');
    }

    public String K0() {
        StringBuilder sbE = fg4.e();
        L0(sbE);
        return fg4.v(sbE).trim();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void L0(StringBuilder sb) {
        for (int i = 0; i < l(); i++) {
            l33 l33Var = (l33) this.j.get(i);
            if (l33Var instanceof sm4) {
                g0(sb, (sm4) l33Var);
            } else if (l33Var.z("br") && !sm4.h0(sb)) {
                sb.append(" ");
            }
        }
    }

    @Override // defpackage.l33
    /* JADX INFO: renamed from: M0, reason: merged with bridge method [inline-methods] */
    public final br0 L() {
        return this.f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void O0() {
        int size = this.j.size();
        int i = 0;
        while (true) {
            a aVar = this.j;
            if (i >= size) {
                aVar.f = true;
                return;
            } else {
                ((l33) aVar.get(i)).X(i);
                i++;
            }
        }
    }

    public final String P0(wm0.a.EnumC0128a enumC0128a) {
        wm0.a.EnumC0128a enumC0128a2 = wm0.a.EnumC0128a.xml;
        String strV0 = V0();
        return enumC0128a == enumC0128a2 ? z33.c(strV0) : strV0;
    }

    public er0 R0(String str) {
        return m04.c(str, this);
    }

    public er0 S0() {
        if (this.f == null) {
            return new er0(0);
        }
        List<br0> listK0 = L().k0();
        er0 er0Var = new er0(listK0.size() - 1);
        for (br0 br0Var : listK0) {
            if (br0Var != this) {
                er0Var.add(br0Var);
            }
        }
        return er0Var;
    }

    public final void T0(List list) {
        Map mapJ = f().J();
        mapJ.put("jsoup.childEls", new WeakReference(list));
        mapJ.put("jsoup.childElsMod", Integer.valueOf(this.j.c()));
    }

    public al4 U0() {
        return this.i;
    }

    public String V0() {
        return this.i.b();
    }

    public String W0() {
        StringBuilder sbE = fg4.e();
        new b(sbE).c(this);
        return fg4.v(sbE).trim();
    }

    public List X0() {
        return t0(sm4.class);
    }

    public br0 Y0(r33 r33Var) {
        return (br0) super.Z(r33Var);
    }

    public String Z0() {
        return b1(this.j.stream());
    }

    public String a1() {
        return b1(D());
    }

    public br0 d0(l33 l33Var) {
        zy4.j(l33Var);
        S(l33Var);
        r();
        this.j.add(l33Var);
        l33Var.X(this.j.size() - 1);
        return this;
    }

    public br0 e0(String str) {
        return f0(str, this.i.i());
    }

    @Override // defpackage.l33
    public xb f() {
        if (this.k == null) {
            this.k = new xb();
        }
        return this.k;
    }

    public br0 f0(String str, String str2) {
        o83 o83VarB = q33.b(this);
        br0 br0Var = new br0(o83VarB.k().v(str, str2, o83VarB.j()), g());
        d0(br0Var);
        return br0Var;
    }

    @Override // java.lang.Iterable
    public void forEach(Consumer consumer) {
        stream().forEach(consumer);
    }

    @Override // defpackage.l33
    public String g() {
        String strQ0 = Q0(this, o);
        return strQ0 != null ? strQ0 : "";
    }

    public br0 h0(String str, String str2) {
        super.d(str, str2);
        return this;
    }

    public br0 i0(l33 l33Var) {
        return (br0) super.j(l33Var);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new n33(this, br0.class);
    }

    public List j0() {
        List list;
        Integer num;
        xb xbVar = this.k;
        if (xbVar != null && xbVar.r()) {
            Map mapJ = this.k.J();
            WeakReference weakReference = (WeakReference) mapJ.get("jsoup.childEls");
            if (weakReference != null && (list = (List) weakReference.get()) != null && (num = (Integer) mapJ.get("jsoup.childElsMod")) != null && num.intValue() == this.j.c()) {
                return list;
            }
        }
        return null;
    }

    public List k0() {
        List listJ0;
        if (l() == 0) {
            return l;
        }
        synchronized (this.j) {
            try {
                listJ0 = j0();
                if (listJ0 == null) {
                    listJ0 = t0(br0.class);
                    T0(listJ0);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return listJ0;
    }

    @Override // defpackage.l33
    public int l() {
        return this.j.size();
    }

    public int l0() {
        if (l() == 0) {
            return 0;
        }
        return k0().size();
    }

    @Override // defpackage.l33
    /* JADX INFO: renamed from: m0, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public br0 clone() {
        return (br0) super.clone();
    }

    public String n0() {
        final StringBuilder sbE = fg4.e();
        Y0(new r33() { // from class: ar0
            @Override // defpackage.r33
            public final void a(l33 l33Var, int i) {
                br0.b0(sbE, l33Var, i);
            }
        });
        return fg4.v(sbE);
    }

    @Override // defpackage.l33
    /* JADX INFO: renamed from: o0, reason: merged with bridge method [inline-methods] */
    public br0 o(l33 l33Var) {
        br0 br0Var = (br0) super.o(l33Var);
        a aVar = new a(this.j.size());
        br0Var.j = aVar;
        aVar.addAll(this.j);
        xb xbVar = this.k;
        if (xbVar != null) {
            xb xbVarClone = xbVar.clone();
            br0Var.k = xbVarClone;
            xbVarClone.H("jsoup.childEls", null);
        }
        return br0Var;
    }

    @Override // defpackage.l33
    public void p(String str) {
        f().C(o, str);
    }

    public boolean p0(String str, String str2) {
        return this.i.j().equals(str) && this.i.i().equals(str2);
    }

    public int q0() {
        if (L() == null) {
            return 0;
        }
        return F0(this, L().k0());
    }

    @Override // defpackage.l33
    public List r() {
        if (this.j == m) {
            this.j = new a(4);
        }
        return this.j;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.l33
    /* JADX INFO: renamed from: r0, reason: merged with bridge method [inline-methods] */
    public br0 q() {
        int size = this.j.size();
        int i = 0;
        while (true) {
            a aVar = this.j;
            if (i >= size) {
                aVar.clear();
                return this;
            }
            ((l33) aVar.get(i)).f = null;
            i++;
        }
    }

    public sn3 s0() {
        return sn3.b(this, false);
    }

    public Stream stream() {
        return q33.d(this, br0.class);
    }

    public final List t0(final Class cls) {
        Stream<E> stream = this.j.stream();
        Objects.requireNonNull(cls);
        return (List) stream.filter(new Predicate() { // from class: xq0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return cls.isInstance((l33) obj);
            }
        }).map(new Function() { // from class: yq0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return cls.cast((l33) obj);
            }
        }).collect(Collectors.collectingAndThen(Collectors.toList(), new Function() { // from class: zq0
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return Collections.unmodifiableList((List) obj);
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public br0 u0() {
        int size = this.j.size();
        for (int i = 0; i < size; i++) {
            l33 l33Var = (l33) this.j.get(i);
            if (l33Var instanceof br0) {
                return (br0) l33Var;
            }
        }
        return null;
    }

    public br0 v0() {
        return L() != null ? L().u0() : this;
    }

    public er0 w0(String str) {
        zy4.h(str);
        return zw.a(new su0.b(str.trim()), this);
    }

    @Override // defpackage.l33
    public boolean x() {
        return this.k != null;
    }

    public er0 x0(String str, String str2) {
        return zw.a(new su0.e(str, str2), this);
    }

    public er0 y0(String str) {
        zy4.h(str);
        return zw.a(new su0.k(str), this);
    }

    public er0 z0(String str) {
        zy4.h(str);
        return zw.a(new su0.n0(z33.b(str)), this);
    }

    public br0(al4 al4Var, String str) {
        this(al4Var, str, null);
    }
}
