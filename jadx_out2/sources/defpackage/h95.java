package defpackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class h95 implements yh4 {
    public final List f;
    public final long[] g;
    public final long[] h;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public h95(List list) {
        this.f = Collections.unmodifiableList(new ArrayList(list));
        this.g = new long[list.size() * 2];
        for (int i = 0; i < list.size(); i++) {
            a95 a95Var = (a95) list.get(i);
            int i2 = i * 2;
            long[] jArr = this.g;
            jArr[i2] = a95Var.b;
            jArr[i2 + 1] = a95Var.c;
        }
        long[] jArr2 = this.g;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.h = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yh4
    public int a(long j) {
        int iG = fy4.g(this.h, j, false, false);
        if (iG < this.h.length) {
            return iG;
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yh4
    public long b(int i) {
        gg3.d(i >= 0);
        gg3.d(i < this.h.length);
        return this.h[i];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yh4
    public List e(long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < this.f.size(); i++) {
            long[] jArr = this.g;
            int i2 = i * 2;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                a95 a95Var = (a95) this.f.get(i);
                p50 p50Var = a95Var.a;
                if (p50Var.e == -3.4028235E38f) {
                    arrayList2.add(a95Var);
                } else {
                    arrayList.add(p50Var);
                }
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: g95
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Long.compare(((a95) obj).b, ((a95) obj2).b);
            }
        });
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            arrayList.add(((a95) arrayList2.get(i3)).a.a().h((-1) - i3, 1).a());
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yh4
    public int f() {
        return this.h.length;
    }
}
