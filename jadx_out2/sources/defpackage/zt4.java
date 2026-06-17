package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import defpackage.p50;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class zt4 {
    public final String a;
    public final String b;
    public final boolean c;
    public final long d;
    public final long e;
    public final du4 f;
    public final String[] g;
    public final String h;
    public final String i;
    public final zt4 j;
    public final HashMap k;
    public final HashMap l;
    public List m;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public zt4(String str, String str2, long j, long j2, du4 du4Var, String[] strArr, String str3, String str4, zt4 zt4Var) {
        this.a = str;
        this.b = str2;
        this.i = str4;
        this.f = du4Var;
        this.g = strArr;
        this.c = str2 != null;
        this.d = j;
        this.e = j2;
        this.h = (String) gg3.q(str3);
        this.j = zt4Var;
        this.k = new HashMap();
        this.l = new HashMap();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static zt4 c(String str, long j, long j2, du4 du4Var, String[] strArr, String str2, String str3, zt4 zt4Var) {
        return new zt4(str, null, j, j2, du4Var, strArr, str2, str3, zt4Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static zt4 d(String str) {
        return new zt4(null, cu4.b(str), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void e(SpannableStringBuilder spannableStringBuilder) {
        for (kj0 kj0Var : (kj0[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), kj0.class)) {
            spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(kj0Var), spannableStringBuilder.getSpanEnd(kj0Var), "");
        }
        for (int i = 0; i < spannableStringBuilder.length(); i++) {
            if (spannableStringBuilder.charAt(i) == ' ') {
                int i2 = i + 1;
                int i3 = i2;
                while (i3 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i3) == ' ') {
                    i3++;
                }
                int i4 = i3 - i2;
                if (i4 > 0) {
                    spannableStringBuilder.delete(i, i4 + i);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
            spannableStringBuilder.delete(0, 1);
        }
        for (int i5 = 0; i5 < spannableStringBuilder.length() - 1; i5++) {
            if (spannableStringBuilder.charAt(i5) == '\n') {
                int i6 = i5 + 1;
                if (spannableStringBuilder.charAt(i6) == ' ') {
                    spannableStringBuilder.delete(i6, i5 + 2);
                }
            }
        }
        if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
            spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
        }
        for (int i7 = 0; i7 < spannableStringBuilder.length() - 1; i7++) {
            if (spannableStringBuilder.charAt(i7) == ' ') {
                int i8 = i7 + 1;
                if (spannableStringBuilder.charAt(i8) == '\n') {
                    spannableStringBuilder.delete(i7, i8);
                }
            }
        }
        if (spannableStringBuilder.length() <= 0 || spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) != '\n') {
            return;
        }
        spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static SpannableStringBuilder k(String str, Map map) {
        if (!map.containsKey(str)) {
            p50.b bVar = new p50.b();
            bVar.o(new SpannableStringBuilder());
            map.put(str, bVar);
        }
        return (SpannableStringBuilder) gg3.q(((p50.b) map.get(str)).e());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a(zt4 zt4Var) {
        if (this.m == null) {
            this.m = new ArrayList();
        }
        this.m.add(zt4Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void b(Map map, p50.b bVar, int i, int i2, int i3) {
        du4 du4VarF = cu4.f(this.f, this.g, map);
        SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) bVar.e();
        if (spannableStringBuilder == null) {
            spannableStringBuilder = new SpannableStringBuilder();
            bVar.o(spannableStringBuilder);
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        if (du4VarF != null) {
            cu4.a(spannableStringBuilder2, i, i2, du4VarF, this.j, map, i3);
            if ("p".equals(this.a)) {
                if (du4VarF.m() != Float.MAX_VALUE) {
                    bVar.m((du4VarF.m() * (-90.0f)) / 100.0f);
                }
                if (du4VarF.o() != null) {
                    bVar.p(du4VarF.o());
                }
                if (du4VarF.i() != null) {
                    bVar.j(du4VarF.i());
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public zt4 f(int i) {
        List list = this.m;
        if (list != null) {
            return (zt4) list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int g() {
        List list = this.m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List h(long j, Map map, Map map2, Map map3) {
        List<Pair> arrayList = new ArrayList();
        n(j, this.h, arrayList);
        TreeMap treeMap = new TreeMap();
        p(j, false, this.h, treeMap);
        o(j, map, map2, this.h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair : arrayList) {
            String str = (String) map3.get(pair.second);
            if (str != null) {
                byte[] bArrDecode = Base64.decode(str, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                bu4 bu4Var = (bu4) gg3.q((bu4) map2.get(pair.first));
                arrayList2.add(new p50.b().f(bitmapDecodeByteArray).k(bu4Var.b).l(0).h(bu4Var.c, 0).i(bu4Var.e).n(bu4Var.f).g(bu4Var.g).r(bu4Var.j).a());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            bu4 bu4Var2 = (bu4) gg3.q((bu4) map2.get(entry.getKey()));
            p50.b bVar = (p50.b) entry.getValue();
            e((SpannableStringBuilder) gg3.q(bVar.e()));
            bVar.h(bu4Var2.c, bu4Var2.d);
            bVar.i(bu4Var2.e);
            bVar.k(bu4Var2.b);
            bVar.n(bu4Var2.f);
            bVar.q(bu4Var2.i, bu4Var2.h);
            bVar.r(bu4Var2.j);
            arrayList2.add(bVar.a());
        }
        return arrayList2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i(TreeSet treeSet, boolean z) {
        boolean zEquals = "p".equals(this.a);
        boolean zEquals2 = "div".equals(this.a);
        if (z || zEquals || (zEquals2 && this.i != null)) {
            long j = this.d;
            if (j != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.e;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.m == null) {
            return;
        }
        for (int i = 0; i < this.m.size(); i++) {
            ((zt4) this.m.get(i)).i(treeSet, z || zEquals);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public long[] j() {
        TreeSet treeSet = new TreeSet();
        int i = 0;
        i(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = ((Long) it.next()).longValue();
            i++;
        }
        return jArr;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String[] l() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean m(long j) {
        long j2 = this.d;
        if (j2 == -9223372036854775807L && this.e == -9223372036854775807L) {
            return true;
        }
        if (j2 <= j && this.e == -9223372036854775807L) {
            return true;
        }
        if (j2 != -9223372036854775807L || j >= this.e) {
            return j2 <= j && j < this.e;
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n(long j, String str, List list) {
        if (!"".equals(this.h)) {
            str = this.h;
        }
        if (m(j) && "div".equals(this.a) && this.i != null) {
            list.add(new Pair(str, this.i));
            return;
        }
        for (int i = 0; i < g(); i++) {
            f(i).n(j, str, list);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void o(long j, Map map, Map map2, String str, Map map3) {
        if (m(j)) {
            String str2 = "".equals(this.h) ? str : this.h;
            Iterator it = this.l.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry entry = (Map.Entry) it.next();
                String str3 = (String) entry.getKey();
                int iIntValue = this.k.containsKey(str3) ? ((Integer) this.k.get(str3)).intValue() : 0;
                int iIntValue2 = ((Integer) entry.getValue()).intValue();
                if (iIntValue != iIntValue2) {
                    b(map, (p50.b) gg3.q((p50.b) map3.get(str3)), iIntValue, iIntValue2, ((bu4) gg3.q((bu4) map2.get(str2))).j);
                }
            }
            for (int i = 0; i < g(); i++) {
                f(i).o(j, map, map2, str2, map3);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void p(long j, boolean z, String str, Map map) {
        boolean z2;
        Map map2;
        long j2;
        this.k.clear();
        this.l.clear();
        if ("metadata".equals(this.a)) {
            return;
        }
        if (!"".equals(this.h)) {
            str = this.h;
        }
        String str2 = str;
        if (this.c && z) {
            k(str2, map).append((CharSequence) gg3.q(this.b));
            return;
        }
        if ("br".equals(this.a) && z) {
            k(str2, map).append('\n');
            return;
        }
        if (m(j)) {
            for (Map.Entry entry : map.entrySet()) {
                this.k.put((String) entry.getKey(), Integer.valueOf(((CharSequence) gg3.q(((p50.b) entry.getValue()).e())).length()));
            }
            boolean zEquals = "p".equals(this.a);
            int i = 0;
            while (i < g()) {
                zt4 zt4VarF = f(i);
                if (z || zEquals) {
                    z2 = true;
                    map2 = map;
                    j2 = j;
                } else {
                    z2 = false;
                    j2 = j;
                    map2 = map;
                }
                zt4VarF.p(j2, z2, str2, map2);
                i++;
                j = j2;
                map = map2;
            }
            Map map3 = map;
            if (zEquals) {
                cu4.c(k(str2, map3));
            }
            for (Map.Entry entry2 : map3.entrySet()) {
                this.l.put((String) entry2.getKey(), Integer.valueOf(((CharSequence) gg3.q(((p50.b) entry2.getValue()).e())).length()));
            }
        }
    }
}
