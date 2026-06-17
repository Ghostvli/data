package androidx.recyclerview.widget;

import androidx.recyclerview.widget.a;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class l {
    public final a a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        void a(a.b bVar);

        a.b b(int i, int i2, int i3, Object obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public l(a aVar) {
        this.a = aVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int a(List list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (((a.b) list.get(size)).a != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b(List list) {
        while (true) {
            int iA = a(list);
            if (iA == -1) {
                return;
            } else {
                d(list, iA, iA + 1);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c(List list, int i, a.b bVar, int i2, a.b bVar2) {
        int i3 = bVar.d;
        int i4 = bVar2.b;
        int i5 = i3 < i4 ? -1 : 0;
        int i6 = bVar.b;
        if (i6 < i4) {
            i5++;
        }
        if (i4 <= i6) {
            bVar.b = i6 + bVar2.d;
        }
        int i7 = bVar2.b;
        if (i7 <= i3) {
            bVar.d = i3 + bVar2.d;
        }
        bVar2.b = i7 + i5;
        list.set(i, bVar2);
        list.set(i2, bVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void d(List list, int i, int i2) {
        a.b bVar = (a.b) list.get(i);
        a.b bVar2 = (a.b) list.get(i2);
        int i3 = bVar2.a;
        if (i3 == 1) {
            c(list, i, bVar, i2, bVar2);
        } else if (i3 == 2) {
            e(list, i, bVar, i2, bVar2);
        } else {
            if (i3 != 4) {
                return;
            }
            f(list, i, bVar, i2, bVar2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e(List list, int i, a.b bVar, int i2, a.b bVar2) {
        boolean z;
        int i3 = bVar.b;
        int i4 = bVar.d;
        boolean z2 = false;
        if (i3 < i4) {
            if (bVar2.b == i3 && bVar2.d == i4 - i3) {
                z = false;
                z2 = true;
            } else {
                z = false;
            }
        } else if (bVar2.b == i4 + 1 && bVar2.d == i3 - i4) {
            z = true;
            z2 = true;
        } else {
            z = true;
        }
        int i5 = bVar2.b;
        if (i4 < i5) {
            bVar2.b = i5 - 1;
        } else {
            int i6 = bVar2.d;
            if (i4 < i5 + i6) {
                bVar2.d = i6 - 1;
                bVar.a = 2;
                bVar.d = 1;
                if (bVar2.d == 0) {
                    list.remove(i2);
                    this.a.a(bVar2);
                    return;
                }
                return;
            }
        }
        int i7 = bVar.b;
        int i8 = bVar2.b;
        a.b bVarB = null;
        if (i7 <= i8) {
            bVar2.b = i8 + 1;
        } else {
            int i9 = bVar2.d;
            if (i7 < i8 + i9) {
                bVarB = this.a.b(2, i7 + 1, (i8 + i9) - i7, null);
                bVar2.d = bVar.b - bVar2.b;
            }
        }
        if (z2) {
            list.set(i, bVar2);
            list.remove(i2);
            this.a.a(bVar);
            return;
        }
        if (z) {
            if (bVarB != null) {
                int i10 = bVar.b;
                if (i10 > bVarB.b) {
                    bVar.b = i10 - bVarB.d;
                }
                int i11 = bVar.d;
                if (i11 > bVarB.b) {
                    bVar.d = i11 - bVarB.d;
                }
            }
            int i12 = bVar.b;
            if (i12 > bVar2.b) {
                bVar.b = i12 - bVar2.d;
            }
            int i13 = bVar.d;
            if (i13 > bVar2.b) {
                bVar.d = i13 - bVar2.d;
            }
        } else {
            if (bVarB != null) {
                int i14 = bVar.b;
                if (i14 >= bVarB.b) {
                    bVar.b = i14 - bVarB.d;
                }
                int i15 = bVar.d;
                if (i15 >= bVarB.b) {
                    bVar.d = i15 - bVarB.d;
                }
            }
            int i16 = bVar.b;
            if (i16 >= bVar2.b) {
                bVar.b = i16 - bVar2.d;
            }
            int i17 = bVar.d;
            if (i17 >= bVar2.b) {
                bVar.d = i17 - bVar2.d;
            }
        }
        list.set(i, bVar2);
        if (bVar.b != bVar.d) {
            list.set(i2, bVar);
        } else {
            list.remove(i2);
        }
        if (bVarB != null) {
            list.add(i, bVarB);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x004c  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x005b  */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void f(List list, int i, a.b bVar, int i2, a.b bVar2) {
        a.b bVarB;
        int i3;
        int i4;
        int i5 = bVar.d;
        int i6 = bVar2.b;
        a.b bVarB2 = null;
        if (i5 >= i6) {
            int i7 = bVar2.d;
            if (i5 < i6 + i7) {
                bVar2.d = i7 - 1;
                bVarB = this.a.b(4, bVar.b, 1, bVar2.c);
            }
            i3 = bVar.b;
            i4 = bVar2.b;
            if (i3 > i4) {
                bVar2.b = i4 + 1;
            } else {
                int i8 = bVar2.d;
                if (i3 < i4 + i8) {
                    int i9 = (i4 + i8) - i3;
                    bVarB2 = this.a.b(4, i3 + 1, i9, bVar2.c);
                    bVar2.d -= i9;
                }
            }
            list.set(i2, bVar);
            if (bVar2.d <= 0) {
                list.set(i, bVar2);
            } else {
                list.remove(i);
                this.a.a(bVar2);
            }
            if (bVarB != null) {
                list.add(i, bVarB);
            }
            if (bVarB2 == null) {
                list.add(i, bVarB2);
                return;
            }
            return;
        }
        bVar2.b = i6 - 1;
        bVarB = null;
        i3 = bVar.b;
        i4 = bVar2.b;
        if (i3 > i4) {
        }
        list.set(i2, bVar);
        if (bVar2.d <= 0) {
        }
        if (bVarB != null) {
        }
        if (bVarB2 == null) {
        }
    }
}
