package defpackage;

import android.net.Uri;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class fd4 implements j11 {
    public final int a;
    public final int b;
    public final int c;
    public final boolean d;
    public final a e;
    public final b[] f;
    public final long g;
    public final long h;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public final UUID a;
        public final byte[] b;
        public final yq4[] c;

        public a(UUID uuid, byte[] bArr, yq4[] yq4VarArr) {
            this.a = uuid;
            this.b = bArr;
            this.c = yq4VarArr;
        }
    }

    public fd4(int i, int i2, long j, long j2, long j3, int i3, boolean z, a aVar, b[] bVarArr) {
        this(i, i2, j2 == 0 ? -9223372036854775807L : fy4.u1(j2, 1000000L, j), j3 != 0 ? fy4.u1(j3, 1000000L, j) : -9223372036854775807L, i3, z, aVar, bVarArr);
    }

    @Override // defpackage.j11
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final fd4 a(List list) {
        ArrayList arrayList = new ArrayList(list);
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        b bVar = null;
        int i = 0;
        while (i < arrayList.size()) {
            bf4 bf4Var = (bf4) arrayList.get(i);
            b bVar2 = this.f[bf4Var.g];
            if (bVar2 != bVar && bVar != null) {
                arrayList2.add(bVar.b((t41[]) arrayList3.toArray(new t41[0])));
                arrayList3.clear();
            }
            arrayList3.add(bVar2.j[bf4Var.h]);
            i++;
            bVar = bVar2;
        }
        if (bVar != null) {
            arrayList2.add(bVar.b((t41[]) arrayList3.toArray(new t41[0])));
        }
        return new fd4(this.a, this.b, this.g, this.h, this.c, this.d, this.e, (b[]) arrayList2.toArray(new b[0]));
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public final int a;
        public final String b;
        public final long c;
        public final String d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final String i;
        public final t41[] j;
        public final int k;
        public final String l;
        public final String m;
        public final List n;
        public final long[] o;
        public final long p;

        public b(String str, String str2, int i, String str3, long j, String str4, int i2, int i3, int i4, int i5, String str5, t41[] t41VarArr, List list, long j2) {
            this(str, str2, i, str3, j, str4, i2, i3, i4, i5, str5, t41VarArr, list, fy4.v1(list, 1000000L, j), fy4.u1(j2, 1000000L, j));
        }

        public Uri a(int i, int i2) {
            gg3.v(this.j != null);
            gg3.v(this.n != null);
            gg3.v(i2 < this.n.size());
            String string = Integer.toString(this.j[i].j);
            String string2 = ((Long) this.n.get(i2)).toString();
            return kx4.g(this.l, this.m.replace("{bitrate}", string).replace("{Bitrate}", string).replace("{start time}", string2).replace("{start_time}", string2));
        }

        public b b(t41[] t41VarArr) {
            return new b(this.l, this.m, this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.h, this.i, t41VarArr, this.n, this.o, this.p);
        }

        public long c(int i) {
            if (i == this.k - 1) {
                return this.p;
            }
            long[] jArr = this.o;
            return jArr[i + 1] - jArr[i];
        }

        public int d(long j) {
            return fy4.k(this.o, j, true, true);
        }

        public long e(int i) {
            return this.o[i];
        }

        public b(String str, String str2, int i, String str3, long j, String str4, int i2, int i3, int i4, int i5, String str5, t41[] t41VarArr, List list, long[] jArr, long j2) {
            this.l = str;
            this.m = str2;
            this.a = i;
            this.b = str3;
            this.c = j;
            this.d = str4;
            this.e = i2;
            this.f = i3;
            this.g = i4;
            this.h = i5;
            this.i = str5;
            this.j = t41VarArr;
            this.n = list;
            this.o = jArr;
            this.p = j2;
            this.k = list.size();
        }
    }

    public fd4(int i, int i2, long j, long j2, int i3, boolean z, a aVar, b[] bVarArr) {
        this.a = i;
        this.b = i2;
        this.g = j;
        this.h = j2;
        this.c = i3;
        this.d = z;
        this.e = aVar;
        this.f = bVarArr;
    }
}
