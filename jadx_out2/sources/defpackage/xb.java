package defpackage;

import defpackage.sn3;
import defpackage.wm0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class xb implements Iterable, Cloneable {
    public int f = 0;
    public String[] g = new String[3];
    public Object[] h = new Object[3];

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Iterator {
        public int f;
        public int g = 0;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
            this.f = xb.this.f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void b() {
            if (xb.this.f != this.f) {
                throw new ConcurrentModificationException("Use Iterator#remove() instead to remove attributes while iterating.");
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: next()Ljava/lang/Object; */
        @Override // java.util.Iterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public wb next() {
            b();
            int i = this.g;
            xb xbVar = xb.this;
            if (i >= xbVar.f) {
                bo.a();
                return null;
            }
            String str = xbVar.g[i];
            xb xbVar2 = xb.this;
            wb wbVar = new wb(str, (String) xbVar2.h[this.g], xbVar2);
            this.g++;
            return wbVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Iterator
        public boolean hasNext() {
            b();
            while (true) {
                int i = this.g;
                xb xbVar = xb.this;
                if (i >= xbVar.f || !xb.z(xbVar.g[i])) {
                    break;
                }
                this.g++;
            }
            return this.g < xb.this.f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.util.Iterator
        public void remove() {
            xb xbVar = xb.this;
            int i = this.g - 1;
            this.g = i;
            xbVar.E(i);
            this.f--;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String j(Object obj) {
        return obj == null ? "" : (String) obj;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String y(String str) {
        return ServiceReference.DELIMITER + str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean z(String str) {
        return str.length() > 1 && str.charAt(0) == '/';
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void A() {
        for (int i = 0; i < this.f; i++) {
            String str = this.g[i];
            if (!z(str)) {
                this.g[i] = z33.a(str);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xb B(wb wbVar) {
        zy4.j(wbVar);
        C(wbVar.getKey(), wbVar.getValue());
        wbVar.h = this;
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xb C(String str, String str2) {
        zy4.j(str);
        int iW = w(str);
        if (iW != -1) {
            this.h[iW] = str2;
            return this;
        }
        e(str, str2);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void D(String str, String str2) {
        int iX = x(str);
        if (iX == -1) {
            e(str, str2);
            return;
        }
        this.h[iX] = str2;
        if (this.g[iX].equals(str)) {
            return;
        }
        this.g[iX] = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void E(int i) {
        zy4.b(i >= this.f);
        int i2 = (this.f - i) - 1;
        if (i2 > 0) {
            String[] strArr = this.g;
            int i3 = i + 1;
            System.arraycopy(strArr, i3, strArr, i, i2);
            Object[] objArr = this.h;
            System.arraycopy(objArr, i3, objArr, i, i2);
        }
        int i4 = this.f - 1;
        this.f = i4;
        this.g[i4] = null;
        this.h[i4] = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xb F(String str, sn3.a aVar) {
        zy4.j(str);
        zy4.j(aVar);
        Map mapO = o();
        if (mapO == null) {
            mapO = new HashMap();
            H("jsoup.attrs", mapO);
        }
        mapO.put(str, aVar);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public sn3.a G(String str) {
        if (!p(str)) {
            return sn3.a.c;
        }
        Map mapO = o();
        if (mapO == null) {
            return sn3.a.c;
        }
        sn3.a aVar = (sn3.a) mapO.get(str);
        return aVar != null ? aVar : sn3.a.c;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xb H(String str, Object obj) {
        zy4.j(str);
        if (obj == null && !p("/jsoup.userdata")) {
            return this;
        }
        Map mapJ = J();
        if (obj == null) {
            mapJ.remove(str);
            return this;
        }
        mapJ.put(str, obj);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Object I(String str) {
        zy4.j(str);
        if (r()) {
            return J().get(str);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Map J() {
        int iW = w("/jsoup.userdata");
        if (iW != -1) {
            return (Map) this.h[iW];
        }
        HashMap map = new HashMap();
        e("/jsoup.userdata", map);
        return map;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public xb c(String str, String str2) {
        e(str, str2);
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d(xb xbVar) {
        int size = xbVar.size();
        if (size == 0) {
            return;
        }
        g(this.f + size);
        boolean z = this.f != 0;
        Iterator it = xbVar.iterator();
        while (it.hasNext()) {
            wb wbVar = (wb) it.next();
            if (z) {
                B(wbVar);
            } else {
                e(wbVar.getKey(), wbVar.getValue());
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e(String str, Object obj) {
        g(this.f + 1);
        String[] strArr = this.g;
        int i = this.f;
        strArr[i] = str;
        this.h[i] = obj;
        this.f = i + 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        xb xbVar = (xb) obj;
        if (this.f != xbVar.f) {
            return false;
        }
        for (int i = 0; i < this.f; i++) {
            int iW = xbVar.w(this.g[i]);
            if (iW == -1 || !Objects.equals(this.h[i], xbVar.h[iW])) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public List f() {
        ArrayList arrayList = new ArrayList(this.f);
        for (int i = 0; i < this.f; i++) {
            String str = this.g[i];
            if (!z(str)) {
                arrayList.add(new wb(str, (String) this.h[i], this));
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g(int i) {
        zy4.d(i >= this.f);
        String[] strArr = this.g;
        int length = strArr.length;
        if (length >= i) {
            return;
        }
        int i2 = length >= 3 ? this.f * 2 : 3;
        if (i <= i2) {
            i = i2;
        }
        this.g = (String[]) Arrays.copyOf(strArr, i);
        this.h = Arrays.copyOf(this.h, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return (((this.f * 31) + Arrays.hashCode(this.g)) * 31) + Arrays.hashCode(this.h);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean isEmpty() {
        return size() == 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.lang.Iterable
    public Iterator iterator() {
        return new a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: clone()Ljava/lang/Object; */
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public xb clone() {
        try {
            xb xbVar = (xb) super.clone();
            xbVar.f = this.f;
            xbVar.g = (String[]) Arrays.copyOf(this.g, this.f);
            xbVar.h = Arrays.copyOf(this.h, this.f);
            int iW = w("/jsoup.userdata");
            if (iW != -1) {
                this.h[iW] = new HashMap((Map) this.h[iW]);
            }
            return xbVar;
        } catch (CloneNotSupportedException e) {
            wg1.a(e);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int l(g83 g83Var) {
        int i = 0;
        if (this.f == 0) {
            return 0;
        }
        boolean zE = g83Var.e();
        int i2 = 0;
        while (i < this.f) {
            String str = this.g[i];
            i++;
            int i3 = i;
            while (i3 < this.f) {
                if ((zE && str.equals(this.g[i3])) || (!zE && str.equalsIgnoreCase(this.g[i3]))) {
                    i2++;
                    E(i3);
                    i3--;
                }
                i3++;
            }
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String m(String str) {
        int iW = w(str);
        return iW == -1 ? "" : j(this.h[iW]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String n(String str) {
        int iX = x(str);
        return iX == -1 ? "" : j(this.h[iX]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Map o() {
        return (Map) I("jsoup.attrs");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean p(String str) {
        return w(str) != -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean q(String str) {
        return x(str) != -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean r() {
        return p("/jsoup.userdata");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String s() {
        StringBuilder sbE = fg4.e();
        u(uj3.d(sbE), new wm0.a());
        return fg4.v(sbE);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int size() {
        if (this.f == 0) {
            return 0;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.f; i2++) {
            if (!z(this.g[i2])) {
                i++;
            }
        }
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        return s();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u(uj3 uj3Var, wm0.a aVar) {
        String strC;
        int i = this.f;
        for (int i2 = 0; i2 < i; i2++) {
            String str = this.g[i2];
            if (!z(str) && (strC = wb.c(str, aVar.j())) != null) {
                wb.h(strC, (String) this.h[i2], uj3Var.a(' '), aVar);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int w(String str) {
        zy4.j(str);
        for (int i = 0; i < this.f; i++) {
            if (str.equals(this.g[i])) {
                return i;
            }
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int x(String str) {
        zy4.j(str);
        for (int i = 0; i < this.f; i++) {
            if (str.equalsIgnoreCase(this.g[i])) {
                return i;
            }
        }
        return -1;
    }
}
