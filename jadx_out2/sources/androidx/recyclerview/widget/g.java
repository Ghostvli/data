package androidx.recyclerview.widget;

import defpackage.ju1;
import defpackage.lj;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class g {
    public static final Comparator a = new a();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Comparator {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: compare(Ljava/lang/Object;Ljava/lang/Object;)I */
        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            return dVar.a - dVar2.a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class b {
        public abstract boolean a(int i, int i2);

        public abstract boolean b(int i, int i2);

        public abstract Object c(int i, int i2);

        public abstract int d();

        public abstract int e();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c {
        public final int[] a;
        public final int b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(int i) {
            int[] iArr = new int[i];
            this.a = iArr;
            this.b = iArr.length / 2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int[] a() {
            return this.a;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int b(int i) {
            return this.a[i + this.b];
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c(int i, int i2) {
            this.a[i + this.b] = i2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d {
        public final int a;
        public final int b;
        public final int c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d(int i, int i2, int i3) {
            this.a = i;
            this.b = i2;
            this.c = i3;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int a() {
            return this.a + this.c;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int b() {
            return this.b + this.c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e {
        public final List a;
        public final int[] b;
        public final int[] c;
        public final b d;
        public final int e;
        public final int f;
        public final boolean g;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(b bVar, List list, int[] iArr, int[] iArr2, boolean z) {
            this.a = list;
            this.b = iArr;
            this.c = iArr2;
            Arrays.fill(iArr, 0);
            Arrays.fill(iArr2, 0);
            this.d = bVar;
            this.e = bVar.e();
            this.f = bVar.d();
            this.g = z;
            a();
            d();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static C0042g f(Collection collection, int i, boolean z) {
            C0042g c0042g;
            Iterator it = collection.iterator();
            while (true) {
                if (!it.hasNext()) {
                    c0042g = null;
                    break;
                }
                c0042g = (C0042g) it.next();
                if (c0042g.a == i && c0042g.c == z) {
                    it.remove();
                    break;
                }
            }
            while (it.hasNext()) {
                C0042g c0042g2 = (C0042g) it.next();
                if (z) {
                    c0042g2.b--;
                } else {
                    c0042g2.b++;
                }
            }
            return c0042g;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void a() {
            d dVar = this.a.isEmpty() ? null : (d) this.a.get(0);
            if (dVar == null || dVar.a != 0 || dVar.b != 0) {
                this.a.add(0, new d(0, 0, 0));
            }
            this.a.add(new d(this.e, this.f, 0));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b(ju1 ju1Var) {
            int i;
            lj ljVar = ju1Var instanceof lj ? (lj) ju1Var : new lj(ju1Var);
            int i2 = this.e;
            ArrayDeque arrayDeque = new ArrayDeque();
            int i3 = this.e;
            int i4 = this.f;
            for (int size = this.a.size() - 1; size >= 0; size--) {
                d dVar = (d) this.a.get(size);
                int iA = dVar.a();
                int iB = dVar.b();
                while (true) {
                    if (i3 <= iA) {
                        break;
                    }
                    i3--;
                    int i5 = this.b[i3];
                    if ((i5 & 12) != 0) {
                        int i6 = i5 >> 4;
                        C0042g c0042gF = f(arrayDeque, i6, false);
                        if (c0042gF != null) {
                            int i7 = (i2 - c0042gF.b) - 1;
                            ljVar.a(i3, i7);
                            if ((i5 & 4) != 0) {
                                ljVar.d(i7, 1, this.d.c(i3, i6));
                            }
                        } else {
                            arrayDeque.add(new C0042g(i3, (i2 - i3) - 1, true));
                        }
                    } else {
                        ljVar.c(i3, 1);
                        i2--;
                    }
                }
                while (i4 > iB) {
                    i4--;
                    int i8 = this.c[i4];
                    if ((i8 & 12) != 0) {
                        int i9 = i8 >> 4;
                        C0042g c0042gF2 = f(arrayDeque, i9, true);
                        if (c0042gF2 == null) {
                            arrayDeque.add(new C0042g(i4, i2 - i3, false));
                        } else {
                            ljVar.a((i2 - c0042gF2.b) - 1, i3);
                            if ((i8 & 4) != 0) {
                                ljVar.d(i3, 1, this.d.c(i9, i4));
                            }
                        }
                    } else {
                        ljVar.b(i3, 1);
                        i2++;
                    }
                }
                int i10 = dVar.a;
                int i11 = dVar.b;
                for (i = 0; i < dVar.c; i++) {
                    if ((this.b[i10] & 15) == 2) {
                        ljVar.d(i10, 1, this.d.c(i10, i11));
                    }
                    i10++;
                    i11++;
                }
                i3 = dVar.a;
                i4 = dVar.b;
            }
            ljVar.e();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void c(int i) {
            int size = this.a.size();
            int iB = 0;
            for (int i2 = 0; i2 < size; i2++) {
                d dVar = (d) this.a.get(i2);
                while (iB < dVar.b) {
                    if (this.c[iB] == 0 && this.d.b(i, iB)) {
                        int i3 = this.d.a(i, iB) ? 8 : 4;
                        this.b[i] = (iB << 4) | i3;
                        this.c[iB] = (i << 4) | i3;
                        return;
                    }
                    iB++;
                }
                iB = dVar.b();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void d() {
            for (d dVar : this.a) {
                for (int i = 0; i < dVar.c; i++) {
                    int i2 = dVar.a + i;
                    int i3 = dVar.b + i;
                    int i4 = this.d.a(i2, i3) ? 1 : 2;
                    this.b[i2] = (i3 << 4) | i4;
                    this.c[i3] = (i2 << 4) | i4;
                }
            }
            if (this.g) {
                e();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void e() {
            int iA = 0;
            for (d dVar : this.a) {
                while (iA < dVar.a) {
                    if (this.b[iA] == 0) {
                        c(iA);
                    }
                    iA++;
                }
                iA = dVar.a();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class f {
        public abstract boolean a(Object obj, Object obj2);

        public abstract boolean b(Object obj, Object obj2);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public Object c(Object obj, Object obj2) {
            return null;
        }
    }

    /* JADX INFO: renamed from: androidx.recyclerview.widget.g$g, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class C0042g {
        public int a;
        public int b;
        public boolean c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public C0042g(int i, int i2, boolean z) {
            this.a = i;
            this.b = i2;
            this.c = z;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class i {
        public int a;
        public int b;
        public int c;
        public int d;
        public boolean e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int a() {
            return Math.min(this.c - this.a, this.d - this.b);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean b() {
            return this.d - this.b != this.c - this.a;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean c() {
            return this.d - this.b > this.c - this.a;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d d() {
            if (!b()) {
                int i = this.a;
                return new d(i, this.b, this.c - i);
            }
            if (this.e) {
                return new d(this.a, this.b, a());
            }
            boolean zC = c();
            int i2 = this.a;
            return zC ? new d(i2, this.b + 1, a()) : new d(i2 + 1, this.b, a());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static i a(h hVar, b bVar, c cVar, c cVar2, int i2) {
        int iB;
        int i3;
        int i4;
        boolean z = (hVar.b() - hVar.a()) % 2 == 0;
        int iB2 = hVar.b() - hVar.a();
        int i5 = -i2;
        for (int i6 = i5; i6 <= i2; i6 += 2) {
            if (i6 == i5 || (i6 != i2 && cVar2.b(i6 + 1) < cVar2.b(i6 - 1))) {
                iB = cVar2.b(i6 + 1);
                i3 = iB;
            } else {
                iB = cVar2.b(i6 - 1);
                i3 = iB - 1;
            }
            int i7 = hVar.d - ((hVar.b - i3) - i6);
            int i8 = (i2 == 0 || i3 != iB) ? i7 : i7 + 1;
            while (i3 > hVar.a && i7 > hVar.c && bVar.b(i3 - 1, i7 - 1)) {
                i3--;
                i7--;
            }
            cVar2.c(i6, i3);
            if (z && (i4 = iB2 - i6) >= i5 && i4 <= i2 && cVar.b(i4) >= i3) {
                i iVar = new i();
                iVar.a = i3;
                iVar.b = i7;
                iVar.c = iB;
                iVar.d = i8;
                iVar.e = true;
                return iVar;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static e b(b bVar) {
        return c(bVar, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static e c(b bVar, boolean z) {
        int iE = bVar.e();
        int iD = bVar.d();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(new h(0, iE, 0, iD));
        int i2 = ((((iE + iD) + 1) / 2) * 2) + 1;
        c cVar = new c(i2);
        c cVar2 = new c(i2);
        ArrayList arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            h hVar = (h) arrayList2.remove(arrayList2.size() - 1);
            i iVarE = e(hVar, bVar, cVar, cVar2);
            if (iVarE != null) {
                if (iVarE.a() > 0) {
                    arrayList.add(iVarE.d());
                }
                h hVar2 = arrayList3.isEmpty() ? new h() : (h) arrayList3.remove(arrayList3.size() - 1);
                hVar2.a = hVar.a;
                hVar2.c = hVar.c;
                hVar2.b = iVarE.a;
                hVar2.d = iVarE.b;
                arrayList2.add(hVar2);
                hVar.b = hVar.b;
                hVar.d = hVar.d;
                hVar.a = iVarE.c;
                hVar.c = iVarE.d;
                arrayList2.add(hVar);
            } else {
                arrayList3.add(hVar);
            }
        }
        Collections.sort(arrayList, a);
        return new e(bVar, arrayList, cVar.a(), cVar2.a(), z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static i d(h hVar, b bVar, c cVar, c cVar2, int i2) {
        int iB;
        int i3;
        int i4;
        boolean z = Math.abs(hVar.b() - hVar.a()) % 2 == 1;
        int iB2 = hVar.b() - hVar.a();
        int i5 = -i2;
        for (int i6 = i5; i6 <= i2; i6 += 2) {
            if (i6 == i5 || (i6 != i2 && cVar.b(i6 + 1) > cVar.b(i6 - 1))) {
                iB = cVar.b(i6 + 1);
                i3 = iB;
            } else {
                iB = cVar.b(i6 - 1);
                i3 = iB + 1;
            }
            int i7 = (hVar.c + (i3 - hVar.a)) - i6;
            int i8 = (i2 == 0 || i3 != iB) ? i7 : i7 - 1;
            while (i3 < hVar.b && i7 < hVar.d && bVar.b(i3, i7)) {
                i3++;
                i7++;
            }
            cVar.c(i6, i3);
            if (z && (i4 = iB2 - i6) >= i5 + 1 && i4 <= i2 - 1 && cVar2.b(i4) <= i3) {
                i iVar = new i();
                iVar.a = iB;
                iVar.b = i8;
                iVar.c = i3;
                iVar.d = i7;
                iVar.e = false;
                return iVar;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static i e(h hVar, b bVar, c cVar, c cVar2) {
        if (hVar.b() >= 1 && hVar.a() >= 1) {
            int iB = ((hVar.b() + hVar.a()) + 1) / 2;
            cVar.c(1, hVar.a);
            cVar2.c(1, hVar.b);
            for (int i2 = 0; i2 < iB; i2++) {
                i iVarD = d(hVar, bVar, cVar, cVar2, i2);
                if (iVarD != null) {
                    return iVarD;
                }
                i iVarA = a(hVar, bVar, cVar, cVar2, i2);
                if (iVarA != null) {
                    return iVarA;
                }
            }
        }
        return null;
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class h {
        public int a;
        public int b;
        public int c;
        public int d;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public h(int i, int i2, int i3, int i4) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int a() {
            return this.d - this.c;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public int b() {
            return this.b - this.a;
        }

        public h() {
        }
    }
}
