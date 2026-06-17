package defpackage;

import com.hierynomus.protocol.commons.buffer.Buffer;
import defpackage.dh1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class z80 {
    public final Exception a = new Exception("not suuport this filter tag");
    public final Map b = Collections.synchronizedSortedMap(new TreeMap());
    public final Map c = Collections.synchronizedSortedMap(new TreeMap());
    public e[] d = new e[0];
    public e[] e = new e[0];

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class a implements e {
        @Override // z80.e
        public void clear() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b extends a {
        public final dh1 a = new e90(4);
        public final LinkedHashMap b = new LinkedHashMap();
        public final dh1 c = new e90(4);

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a extends dh1.c {
            public long a = lk4.b();
            public final /* synthetic */ long b;

            public a(long j) {
                this.b = j;
            }

            @Override // dh1.b
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public int a(ih ihVar) {
                try {
                    if (lk4.b() - this.a > this.b) {
                        return 1;
                    }
                    if (ihVar.w()) {
                        return 2;
                    }
                } catch (Exception unused) {
                }
                return 1;
            }
        }

        @Override // z80.e
        public boolean a(ih ihVar, int i, int i2, b90 b90Var, boolean z, t80 t80Var) {
            boolean zC = c(ihVar, i, i2, b90Var, z);
            if (zC) {
                ihVar.F |= 128;
            }
            return zC;
        }

        public synchronized boolean c(ih ihVar, int i, int i2, b90 b90Var, boolean z) {
            d(this.a, 2L);
            d(this.c, 2L);
            e(this.b, 3);
            if (this.a.b(ihVar) && !ihVar.s()) {
                return true;
            }
            if (this.c.b(ihVar)) {
                return false;
            }
            boolean zContainsKey = this.b.containsKey(ihVar.c);
            LinkedHashMap linkedHashMap = this.b;
            if (!zContainsKey) {
                linkedHashMap.put(String.valueOf(ihVar.c), ihVar);
                this.c.c(ihVar);
                return false;
            }
            linkedHashMap.put(String.valueOf(ihVar.c), ihVar);
            this.a.f(ihVar);
            this.a.c(ihVar);
            return true;
        }

        @Override // z80.a, z80.e
        public void clear() {
            f();
        }

        public final void d(dh1 dh1Var, long j) {
            dh1Var.g(new a(j));
        }

        public final void e(LinkedHashMap linkedHashMap, int i) {
            Iterator it = linkedHashMap.entrySet().iterator();
            long jB = lk4.b();
            while (it.hasNext()) {
                try {
                    if (!((ih) ((Map.Entry) it.next()).getValue()).w()) {
                        return;
                    }
                    it.remove();
                    if (lk4.b() - jB > i) {
                        return;
                    }
                } catch (Exception unused) {
                    return;
                }
            }
        }

        public synchronized void f() {
            this.c.clear();
            this.a.clear();
            this.b.clear();
        }

        @Override // z80.e
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public void b(Void r1) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c extends a {
        public long a = 20;

        private synchronized boolean c(ih ihVar, int i, int i2, b90 b90Var, boolean z) {
            if (b90Var != null) {
                if (ihVar.s()) {
                    return lk4.b() - b90Var.a >= this.a;
                }
            }
            return false;
        }

        @Override // z80.e
        public boolean a(ih ihVar, int i, int i2, b90 b90Var, boolean z, t80 t80Var) {
            boolean zC = c(ihVar, i, i2, b90Var, z);
            if (zC) {
                ihVar.F |= 4;
            }
            return zC;
        }

        @Override // z80.e
        public void b(Object obj) {
            d();
        }

        @Override // z80.a, z80.e
        public void clear() {
            d();
        }

        public synchronized void d() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d extends a {
        public Boolean a = Boolean.FALSE;

        @Override // z80.e
        public boolean a(ih ihVar, int i, int i2, b90 b90Var, boolean z, t80 t80Var) {
            boolean z2 = this.a.booleanValue() && ihVar.C;
            if (z2) {
                ihVar.F |= 64;
            }
            return z2;
        }

        @Override // z80.e
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(Boolean bool) {
            this.a = bool;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface e {
        boolean a(ih ihVar, int i, int i2, b90 b90Var, boolean z, t80 t80Var);

        void b(Object obj);

        void clear();
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class f extends a {
        public Map a;

        @Override // z80.e
        public boolean a(ih ihVar, int i, int i2, b90 b90Var, boolean z, t80 t80Var) {
            Map map = this.a;
            boolean z2 = false;
            if (map != null) {
                Integer num = (Integer) map.get(Integer.valueOf(ihVar.m()));
                if (num != null && i >= num.intValue()) {
                    z2 = true;
                }
                if (z2) {
                    ihVar.F |= Buffer.DEFAULT_SIZE;
                }
            }
            return z2;
        }

        @Override // z80.e
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(Map map) {
            this.a = map;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class g extends a {
        public Map a;

        @Override // z80.e
        public boolean a(ih ihVar, int i, int i2, b90 b90Var, boolean z, t80 t80Var) {
            Map map = this.a;
            boolean z2 = false;
            if (map != null) {
                Boolean bool = (Boolean) map.get(Integer.valueOf(ihVar.m()));
                if (bool != null && bool.booleanValue() && z) {
                    z2 = true;
                }
                if (z2) {
                    ihVar.F |= 512;
                }
            }
            return z2;
        }

        @Override // z80.e
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void b(Map map) {
            this.a = map;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class h extends a {
        public int a = -1;
        public ih b = null;
        public float c = 1.0f;

        @Override // z80.e
        public synchronized boolean a(ih ihVar, int i, int i2, b90 b90Var, boolean z, t80 t80Var) {
            boolean zC;
            zC = c(ihVar, i, i2, b90Var, z, t80Var);
            if (zC) {
                ihVar.F |= 2;
            }
            return zC;
        }

        public final boolean c(ih ihVar, int i, int i2, b90 b90Var, boolean z, t80 t80Var) {
            if (this.a > 0 && ihVar.m() == 1) {
                ih ihVar2 = this.b;
                if (ihVar2 != null && !ihVar2.w()) {
                    long jB = ihVar.b() - this.b.b();
                    up0 up0Var = t80Var.E.g;
                    if ((jB >= 0 && up0Var != null && jB < up0Var.h * this.c) || i > this.a) {
                        return true;
                    }
                    this.b = ihVar;
                    return false;
                }
                this.b = ihVar;
            }
            return false;
        }

        @Override // z80.a, z80.e
        public void clear() {
            d();
        }

        public synchronized void d() {
            this.b = null;
        }

        @Override // z80.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(Integer num) {
            d();
            if (num == null || num.intValue() == this.a) {
                return;
            }
            int iIntValue = num.intValue() + (num.intValue() / 5);
            this.a = iIntValue;
            this.c = 1.0f / iIntValue;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class i extends a {
        public List a = new ArrayList();

        @Override // z80.e
        public boolean a(ih ihVar, int i, int i2, b90 b90Var, boolean z, t80 t80Var) {
            boolean z2 = (ihVar == null || this.a.contains(Integer.valueOf(ihVar.f))) ? false : true;
            if (z2) {
                ihVar.F |= 8;
            }
            return z2;
        }

        public final void c(Integer num) {
            if (this.a.contains(num)) {
                return;
            }
            this.a.add(num);
        }

        public void d() {
            this.a.clear();
        }

        @Override // z80.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(List list) {
            d();
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    c((Integer) it.next());
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class j extends a {
        public final List a = Collections.synchronizedList(new ArrayList());

        @Override // z80.e
        public boolean a(ih ihVar, int i, int i2, b90 b90Var, boolean z, t80 t80Var) {
            boolean z2 = ihVar != null && this.a.contains(Integer.valueOf(ihVar.m()));
            if (z2) {
                ihVar.F = 1 | ihVar.F;
            }
            return z2;
        }

        public void c(Integer num) {
            if (this.a.contains(num)) {
                return;
            }
            this.a.add(num);
        }

        public void d() {
            this.a.clear();
        }

        @Override // z80.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(List list) {
            d();
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    c((Integer) it.next());
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static abstract class k extends a {
        public List a = new ArrayList();

        public final void c(Object obj) {
            if (this.a.contains(obj)) {
                return;
            }
            this.a.add(obj);
        }

        public void d() {
            this.a.clear();
        }

        @Override // z80.e
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public void b(List list) {
            d();
            if (list != null) {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    c(it.next());
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class l extends k {
        @Override // z80.e
        public boolean a(ih ihVar, int i, int i2, b90 b90Var, boolean z, t80 t80Var) {
            boolean z2 = ihVar != null && this.a.contains(ihVar.B);
            if (z2) {
                ihVar.F |= 32;
            }
            return z2;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class m extends k {
        @Override // z80.e
        public boolean a(ih ihVar, int i, int i2, b90 b90Var, boolean z, t80 t80Var) {
            boolean z2 = ihVar != null && this.a.contains(Integer.valueOf(ihVar.A));
            if (z2) {
                ihVar.F |= 16;
            }
            return z2;
        }
    }

    public void a() {
        for (e eVar : this.d) {
            if (eVar != null) {
                eVar.clear();
            }
        }
        for (e eVar2 : this.e) {
            if (eVar2 != null) {
                eVar2.clear();
            }
        }
    }

    public void b(ih ihVar, int i2, int i3, b90 b90Var, boolean z, t80 t80Var) {
        e[] eVarArr = this.d;
        int length = eVarArr.length;
        int i4 = 0;
        while (i4 < length) {
            e eVar = eVarArr[i4];
            ih ihVar2 = ihVar;
            int i5 = i2;
            int i6 = i3;
            b90 b90Var2 = b90Var;
            boolean z2 = z;
            t80 t80Var2 = t80Var;
            if (eVar != null) {
                boolean zA = eVar.a(ihVar2, i5, i6, b90Var2, z2, t80Var2);
                ihVar2.G = t80Var2.C.c;
                if (zA) {
                    return;
                }
            }
            i4++;
            ihVar = ihVar2;
            i2 = i5;
            i3 = i6;
            b90Var = b90Var2;
            z = z2;
            t80Var = t80Var2;
        }
    }

    public boolean c(ih ihVar, int i2, int i3, b90 b90Var, boolean z, t80 t80Var) {
        for (e eVar : this.e) {
            if (eVar != null) {
                boolean zA = eVar.a(ihVar, i2, i3, b90Var, z, t80Var);
                ihVar.G = t80Var.C.c;
                if (zA) {
                    return true;
                }
            }
        }
        return false;
    }

    public e d(String str, boolean z) {
        e eVar = (e) (z ? this.b : this.c).get(str);
        return eVar == null ? f(str, z) : eVar;
    }

    public e e(String str) {
        return f(str, true);
    }

    public e f(String str, boolean z) {
        if (str == null) {
            g();
            return null;
        }
        e gVar = (e) this.b.get(str);
        if (gVar == null) {
            if ("1010_Filter".equals(str)) {
                gVar = new j();
            } else if ("1011_Filter".equals(str)) {
                gVar = new h();
            } else if ("1012_Filter".equals(str)) {
                gVar = new c();
            } else if ("1013_Filter".equals(str)) {
                gVar = new i();
            } else if ("1014_Filter".equals(str)) {
                gVar = new m();
            } else if ("1015_Filter".equals(str)) {
                gVar = new l();
            } else if ("1016_Filter".equals(str)) {
                gVar = new d();
            } else if ("1017_Filter".equals(str)) {
                gVar = new b();
            } else if ("1018_Filter".equals(str)) {
                gVar = new f();
            } else if ("1019_Filter".equals(str)) {
                gVar = new g();
            }
        }
        if (gVar == null) {
            g();
            return null;
        }
        gVar.b(null);
        if (z) {
            this.b.put(str, gVar);
            this.d = (e[]) this.b.values().toArray(this.d);
            return gVar;
        }
        this.c.put(str, gVar);
        this.e = (e[]) this.c.values().toArray(this.e);
        return gVar;
    }

    public final void g() {
        try {
            throw this.a;
        } catch (Exception unused) {
        }
    }

    public void h(String str) {
        i(str, true);
    }

    public void i(String str, boolean z) {
        e eVar = (e) (z ? this.b : this.c).remove(str);
        if (eVar != null) {
            eVar.clear();
            if (z) {
                this.d = (e[]) this.b.values().toArray(this.d);
            } else {
                this.e = (e[]) this.c.values().toArray(this.e);
            }
        }
    }
}
