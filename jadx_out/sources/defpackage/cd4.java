package defpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class cd4 {
    public final ls a;
    public final boolean b;
    public final d c;
    public final int d;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends c {
        public final /* synthetic */ ls m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(cd4 cd4Var, CharSequence charSequence, ls lsVar) {
            super(cd4Var, charSequence);
            this.m = lsVar;
        }

        @Override // cd4.c
        public int f(int i) {
            return i + 1;
        }

        @Override // cd4.c
        public int g(int i) {
            return this.m.h(this.h, i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends c {
        public final /* synthetic */ String m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(cd4 cd4Var, CharSequence charSequence, String str) {
            super(cd4Var, charSequence);
            this.m = str;
        }

        @Override // cd4.c
        public int f(int i) {
            return i + this.m.length();
        }

        /* JADX WARN: Code restructure failed: missing block: B:8:0x0022, code lost:
        
            r6 = r6 + 1;
         */
        @Override // cd4.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int g(int r6) {
            /*
                r5 = this;
                java.lang.String r0 = r5.m
                int r0 = r0.length()
                java.lang.CharSequence r1 = r5.h
                int r1 = r1.length()
                int r1 = r1 - r0
            Ld:
                if (r6 > r1) goto L29
                r2 = 0
            L10:
                if (r2 >= r0) goto L28
                java.lang.CharSequence r3 = r5.h
                int r4 = r2 + r6
                char r3 = r3.charAt(r4)
                java.lang.String r4 = r5.m
                char r4 = r4.charAt(r2)
                if (r3 == r4) goto L25
                int r6 = r6 + 1
                goto Ld
            L25:
                int r2 = r2 + 1
                goto L10
            L28:
                return r6
            L29:
                r5 = -1
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: cd4.b.g(int):int");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class c extends g0 {
        public final CharSequence h;
        public final ls i;
        public final boolean j;
        public int k = 0;
        public int l;

        public c(cd4 cd4Var, CharSequence charSequence) {
            this.i = cd4Var.a;
            this.j = cd4Var.b;
            this.l = cd4Var.d;
            this.h = charSequence;
        }

        @Override // defpackage.g0
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public String b() {
            int iG;
            int i = this.k;
            while (true) {
                int i2 = this.k;
                if (i2 == -1) {
                    return (String) c();
                }
                iG = g(i2);
                if (iG == -1) {
                    iG = this.h.length();
                    this.k = -1;
                } else {
                    this.k = f(iG);
                }
                int i3 = this.k;
                if (i3 == i) {
                    int i4 = i3 + 1;
                    this.k = i4;
                    if (i4 > this.h.length()) {
                        this.k = -1;
                    }
                } else {
                    while (i < iG && this.i.m(this.h.charAt(i))) {
                        i++;
                    }
                    while (iG > i && this.i.m(this.h.charAt(iG - 1))) {
                        iG--;
                    }
                    if (!this.j || i != iG) {
                        break;
                    }
                    i = this.k;
                }
            }
            int i5 = this.l;
            if (i5 == 1) {
                iG = this.h.length();
                this.k = -1;
                while (iG > i && this.i.m(this.h.charAt(iG - 1))) {
                    iG--;
                }
            } else {
                this.l = i5 - 1;
            }
            return this.h.subSequence(i, iG).toString();
        }

        public abstract int f(int i);

        public abstract int g(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
        Iterator a(cd4 cd4Var, CharSequence charSequence);
    }

    public cd4(d dVar) {
        this(dVar, false, ls.q(), Integer.MAX_VALUE);
    }

    public static /* synthetic */ Iterator a(ls lsVar, cd4 cd4Var, CharSequence charSequence) {
        return new a(cd4Var, charSequence, lsVar);
    }

    public static /* synthetic */ Iterator b(String str, cd4 cd4Var, CharSequence charSequence) {
        return new b(cd4Var, charSequence, str);
    }

    public static cd4 f(char c2) {
        return g(ls.i(c2));
    }

    public static cd4 g(final ls lsVar) {
        gg3.q(lsVar);
        return new cd4(new d() { // from class: bd4
            @Override // cd4.d
            public final Iterator a(cd4 cd4Var, CharSequence charSequence) {
                return cd4.a(lsVar, cd4Var, charSequence);
            }
        });
    }

    public static cd4 h(final String str) {
        gg3.e(str.length() != 0, "The separator may not be the empty string.");
        return str.length() == 1 ? f(str.charAt(0)) : new cd4(new d() { // from class: ad4
            @Override // cd4.d
            public final Iterator a(cd4 cd4Var, CharSequence charSequence) {
                return cd4.b(str, cd4Var, charSequence);
            }
        });
    }

    public List i(CharSequence charSequence) {
        gg3.q(charSequence);
        Iterator itJ = j(charSequence);
        ArrayList arrayList = new ArrayList();
        while (itJ.hasNext()) {
            arrayList.add((String) itJ.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final Iterator j(CharSequence charSequence) {
        return this.c.a(this, charSequence);
    }

    public cd4(d dVar, boolean z, ls lsVar, int i) {
        this.c = dVar;
        this.b = z;
        this.a = lsVar;
        this.d = i;
    }
}
