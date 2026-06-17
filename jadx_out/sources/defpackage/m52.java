package defpackage;

import defpackage.m52;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class m52 implements l52 {
    public final Matcher a;
    public final CharSequence b;
    public final k52 c;
    public List d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends i0 {
        public a() {
        }

        public /* bridge */ boolean c(String str) {
            return super.contains(str);
        }

        @Override // defpackage.u, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof String) {
                return c((String) obj);
            }
            return false;
        }

        @Override // defpackage.i0, java.util.List
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public String get(int i) {
            String strGroup = m52.this.e().group(i);
            return strGroup == null ? "" : strGroup;
        }

        public /* bridge */ int e(String str) {
            return super.indexOf(str);
        }

        public /* bridge */ int f(String str) {
            return super.lastIndexOf(str);
        }

        @Override // defpackage.u
        public int getSize() {
            return m52.this.e().groupCount() + 1;
        }

        @Override // defpackage.i0, java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof String) {
                return e((String) obj);
            }
            return -1;
        }

        @Override // defpackage.i0, java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof String) {
                return f((String) obj);
            }
            return -1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b extends u implements k52 {
        public b() {
        }

        public static j52 c(b bVar, int i) {
            return bVar.get(i);
        }

        @Override // defpackage.u, java.util.Collection, java.util.List
        public final /* bridge */ boolean contains(Object obj) {
            if (obj == null ? true : obj instanceof j52) {
                return d((j52) obj);
            }
            return false;
        }

        public /* bridge */ boolean d(j52 j52Var) {
            return super.contains(j52Var);
        }

        @Override // defpackage.k52
        public j52 get(int i) {
            sk1 sk1VarD = tp3.d(m52.this.e(), i);
            if (sk1VarD.j().intValue() < 0) {
                return null;
            }
            String strGroup = m52.this.e().group(i);
            strGroup.getClass();
            return new j52(strGroup, sk1VarD);
        }

        @Override // defpackage.u
        public int getSize() {
            return m52.this.e().groupCount() + 1;
        }

        @Override // defpackage.u, java.util.Collection
        public boolean isEmpty() {
            return false;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return p14.m(ww.D(ow.k(this)), new Function1() { // from class: n52
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return m52.b.c(this.f, ((Integer) obj).intValue());
                }
            }).iterator();
        }
    }

    public m52(Matcher matcher, CharSequence charSequence) {
        matcher.getClass();
        charSequence.getClass();
        this.a = matcher;
        this.b = charSequence;
        this.c = new b();
    }

    @Override // defpackage.l52
    public List a() {
        if (this.d == null) {
            this.d = new a();
        }
        List list = this.d;
        list.getClass();
        return list;
    }

    @Override // defpackage.l52
    public k52 b() {
        return this.c;
    }

    @Override // defpackage.l52
    public sk1 c() {
        return tp3.c(e());
    }

    public final MatchResult e() {
        return this.a;
    }
}
