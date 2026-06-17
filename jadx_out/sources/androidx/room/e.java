package androidx.room;

import androidx.room.c;
import defpackage.e04;
import defpackage.n24;
import defpackage.o24;
import defpackage.sg4;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class e {
    public final c.b a;
    public final int[] b;
    public final String[] c;
    public final Set d;

    public e(c.b bVar, int[] iArr, String[] strArr) {
        bVar.getClass();
        iArr.getClass();
        strArr.getClass();
        this.a = bVar;
        this.b = iArr;
        this.c = strArr;
        if (iArr.length == strArr.length) {
            this.d = !(strArr.length == 0) ? n24.c(strArr[0]) : o24.d();
        } else {
            e04.a("Check failed.");
            throw null;
        }
    }

    public final c.b a() {
        return this.a;
    }

    public final int[] b() {
        return this.b;
    }

    public final void c(Set set) {
        Set setD;
        set.getClass();
        int[] iArr = this.b;
        int length = iArr.length;
        if (length != 0) {
            int i = 0;
            if (length != 1) {
                Set setB = n24.b();
                int[] iArr2 = this.b;
                int length2 = iArr2.length;
                int i2 = 0;
                while (i < length2) {
                    int i3 = i2 + 1;
                    if (set.contains(Integer.valueOf(iArr2[i]))) {
                        setB.add(this.c[i2]);
                    }
                    i++;
                    i2 = i3;
                }
                setD = n24.a(setB);
            } else {
                setD = set.contains(Integer.valueOf(iArr[0])) ? this.d : o24.d();
            }
        } else {
            setD = o24.d();
        }
        if (setD.isEmpty()) {
            return;
        }
        this.a.c(setD);
    }

    public final void d(Set set) {
        Set setD;
        set.getClass();
        int length = this.c.length;
        if (length == 0) {
            setD = o24.d();
        } else if (length != 1) {
            Set setB = n24.b();
            Iterator it = set.iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                String[] strArr = this.c;
                int length2 = strArr.length;
                int i = 0;
                while (true) {
                    if (i < length2) {
                        String str2 = strArr[i];
                        if (sg4.y(str2, str, true)) {
                            setB.add(str2);
                            break;
                        }
                        i++;
                    }
                }
            }
            setD = n24.a(setB);
        } else if (set == null || !set.isEmpty()) {
            Iterator it2 = set.iterator();
            while (it2.hasNext()) {
                if (sg4.y((String) it2.next(), this.c[0], true)) {
                    setD = this.d;
                    break;
                }
            }
            setD = o24.d();
        } else {
            setD = o24.d();
        }
        if (setD.isEmpty()) {
            return;
        }
        this.a.c(setD);
    }
}
