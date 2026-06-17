package defpackage;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class g90 implements j11 {
    public final long a;
    public final long b;
    public final long c;
    public final boolean d;
    public final long e;
    public final long f;
    public final long g;
    public final long h;
    public final tx4 i;
    public final v14 j;
    public final Uri k;
    public final ph3 l;
    public final List m;

    public g90(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, ph3 ph3Var, tx4 tx4Var, v14 v14Var, Uri uri, List list) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = z;
        this.e = j4;
        this.f = j5;
        this.g = j6;
        this.h = j7;
        this.l = ph3Var;
        this.i = tx4Var;
        this.k = uri;
        this.j = v14Var;
        this.m = list == null ? Collections.EMPTY_LIST : list;
    }

    public static ArrayList c(List list, LinkedList linkedList) {
        bf4 bf4Var = (bf4) linkedList.poll();
        int i = bf4Var.f;
        ArrayList arrayList = new ArrayList();
        do {
            int i2 = bf4Var.g;
            y3 y3Var = (y3) list.get(i2);
            List list2 = y3Var.c;
            ArrayList arrayList2 = new ArrayList();
            do {
                arrayList2.add((tq3) list2.get(bf4Var.h));
                bf4Var = (bf4) linkedList.poll();
                if (bf4Var.f != i) {
                    break;
                }
            } while (bf4Var.g == i2);
            arrayList.add(new y3(y3Var.a, y3Var.b, arrayList2, y3Var.d, y3Var.e, y3Var.f));
        } while (bf4Var.f == i);
        linkedList.addFirst(bf4Var);
        return arrayList;
    }

    @Override // defpackage.j11
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final g90 a(List list) {
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new bf4(-1, -1, -1));
        ArrayList arrayList = new ArrayList();
        long j = 0;
        int i = 0;
        while (true) {
            if (i >= e()) {
                break;
            }
            if (((bf4) linkedList.peek()).f != i) {
                long jF = f(i);
                if (jF != -9223372036854775807L) {
                    j += jF;
                }
            } else {
                na3 na3VarD = d(i);
                arrayList.add(new na3(na3VarD.a, na3VarD.b - j, c(na3VarD.c, linkedList), na3VarD.d));
            }
            i++;
        }
        long j2 = this.b;
        return new g90(this.a, j2 != -9223372036854775807L ? j2 - j : -9223372036854775807L, this.c, this.d, this.e, this.f, this.g, this.h, this.l, this.i, this.j, this.k, arrayList);
    }

    public final na3 d(int i) {
        return (na3) this.m.get(i);
    }

    public final int e() {
        return this.m.size();
    }

    public final long f(int i) {
        long j;
        long j2;
        if (i == this.m.size() - 1) {
            j = this.b;
            if (j == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            j2 = ((na3) this.m.get(i)).b;
        } else {
            j = ((na3) this.m.get(i + 1)).b;
            j2 = ((na3) this.m.get(i)).b;
        }
        return j - j2;
    }

    public final long g(int i) {
        return fy4.c1(f(i));
    }
}
