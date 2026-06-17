package defpackage;

import defpackage.m94;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class m94 {
    public static final Comparator h = new Comparator() { // from class: k94
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return m94.b((m94.b) obj, (m94.b) obj2);
        }
    };
    public static final Comparator i = new Comparator() { // from class: l94
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            return Float.compare(((m94.b) obj).c, ((m94.b) obj2).c);
        }
    };
    public final int a;
    public int e;
    public int f;
    public int g;
    public final b[] c = new b[5];
    public final ArrayList b = new ArrayList();
    public int d = -1;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public int a;
        public int b;
        public float c;

        public b() {
        }
    }

    public m94(int i2) {
        this.a = i2;
    }

    public static /* synthetic */ int b(b bVar, b bVar2) {
        return bVar.a - bVar2.a;
    }

    public void c(int i2, float f) {
        b bVar;
        d();
        int i3 = this.g;
        if (i3 > 0) {
            b[] bVarArr = this.c;
            int i4 = i3 - 1;
            this.g = i4;
            bVar = bVarArr[i4];
        } else {
            bVar = new b();
        }
        int i5 = this.e;
        this.e = i5 + 1;
        bVar.a = i5;
        bVar.b = i2;
        bVar.c = f;
        this.b.add(bVar);
        this.f += i2;
        while (true) {
            int i6 = this.f;
            int i7 = this.a;
            if (i6 <= i7) {
                return;
            }
            int i8 = i6 - i7;
            b bVar2 = (b) this.b.get(0);
            int i9 = bVar2.b;
            if (i9 <= i8) {
                this.f -= i9;
                this.b.remove(0);
                int i10 = this.g;
                if (i10 < 5) {
                    b[] bVarArr2 = this.c;
                    this.g = i10 + 1;
                    bVarArr2[i10] = bVar2;
                }
            } else {
                bVar2.b = i9 - i8;
                this.f -= i8;
            }
        }
    }

    public final void d() {
        if (this.d != 1) {
            Collections.sort(this.b, h);
            this.d = 1;
        }
    }

    public final void e() {
        if (this.d != 0) {
            Collections.sort(this.b, i);
            this.d = 0;
        }
    }

    public float f(float f) {
        e();
        float f2 = f * this.f;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = this.b.size();
            ArrayList arrayList = this.b;
            if (i2 >= size) {
                if (arrayList.isEmpty()) {
                    return Float.NaN;
                }
                return ((b) this.b.get(r4.size() - 1)).c;
            }
            b bVar = (b) arrayList.get(i2);
            i3 += bVar.b;
            if (i3 >= f2) {
                return bVar.c;
            }
            i2++;
        }
    }

    public void g() {
        this.b.clear();
        this.d = -1;
        this.e = 0;
        this.f = 0;
    }
}
