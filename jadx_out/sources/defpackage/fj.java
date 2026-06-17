package defpackage;

import android.os.SystemClock;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class fj {
    public final Map a;
    public final Map b;
    public final Map c;
    public final Random d;

    public fj(Random random) {
        this.c = new HashMap();
        this.d = random;
        this.a = new HashMap();
        this.b = new HashMap();
    }

    public static void b(Object obj, long j, Map map) {
        if (map.containsKey(obj)) {
            j = Math.max(j, ((Long) fy4.l((Long) map.get(obj))).longValue());
        }
        map.put(obj, Long.valueOf(j));
    }

    public static int d(dj djVar, dj djVar2) {
        int iCompare = Integer.compare(djVar.c, djVar2.c);
        return iCompare != 0 ? iCompare : djVar.b.compareTo(djVar2.b);
    }

    public static int f(List list) {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            hashSet.add(Integer.valueOf(((dj) list.get(i)).c));
        }
        return hashSet.size();
    }

    public static void h(long j, Map map) {
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : map.entrySet()) {
            if (((Long) entry.getValue()).longValue() <= j) {
                arrayList.add(entry.getKey());
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            map.remove(arrayList.get(i));
        }
    }

    public final List c(List list) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        h(jElapsedRealtime, this.a);
        h(jElapsedRealtime, this.b);
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            dj djVar = (dj) list.get(i);
            if (!this.a.containsKey(djVar.b) && !this.b.containsKey(Integer.valueOf(djVar.c))) {
                arrayList.add(djVar);
            }
        }
        return arrayList;
    }

    public void e(dj djVar, long j) {
        long jElapsedRealtime = SystemClock.elapsedRealtime() + j;
        b(djVar.b, jElapsedRealtime, this.a);
        int i = djVar.c;
        if (i != Integer.MIN_VALUE) {
            b(Integer.valueOf(i), jElapsedRealtime, this.b);
        }
    }

    public int g(List list) {
        HashSet hashSet = new HashSet();
        List listC = c(list);
        for (int i = 0; i < listC.size(); i++) {
            hashSet.add(Integer.valueOf(((dj) listC.get(i)).c));
        }
        return hashSet.size();
    }

    public void i() {
        this.a.clear();
        this.b.clear();
        this.c.clear();
    }

    public dj j(List list) {
        List listC = c(list);
        if (listC.size() < 2) {
            return (dj) km1.c(listC, null);
        }
        Collections.sort(listC, new Comparator() { // from class: ej
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return fj.d((dj) obj, (dj) obj2);
            }
        });
        ArrayList arrayList = new ArrayList();
        int i = ((dj) listC.get(0)).c;
        int i2 = 0;
        while (true) {
            if (i2 >= listC.size()) {
                break;
            }
            dj djVar = (dj) listC.get(i2);
            if (i == djVar.c) {
                arrayList.add(new Pair(djVar.b, Integer.valueOf(djVar.d)));
                i2++;
            } else if (arrayList.size() == 1) {
                return (dj) listC.get(0);
            }
        }
        dj djVar2 = (dj) this.c.get(arrayList);
        if (djVar2 != null) {
            return djVar2;
        }
        dj djVarK = k(listC.subList(0, arrayList.size()));
        this.c.put(arrayList, djVarK);
        return djVarK;
    }

    public final dj k(List list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            i += ((dj) list.get(i2)).d;
        }
        int iNextInt = this.d.nextInt(i);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            dj djVar = (dj) list.get(i4);
            i3 += djVar.d;
            if (iNextInt < i3) {
                return djVar;
            }
        }
        return (dj) km1.d(list);
    }

    public fj() {
        this(new Random());
    }
}
