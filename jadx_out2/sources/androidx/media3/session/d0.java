package androidx.media3.session;

import android.os.Bundle;
import android.os.Parcelable;
import defpackage.dj1;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.pw4;
import defpackage.u43;
import defpackage.xz1;
import defpackage.y14;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class d0 {
    public static final d0 b = new b().e();
    public static final String c = fy4.N0(0);
    public final dj1 a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b {
        public final Set a = new HashSet();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b a(y14 y14Var) {
            this.a.add((y14) gg3.q(y14Var));
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b b() {
            d(y14.e);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b c() {
            d(y14.d);
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void d(List list) {
            for (int i = 0; i < list.size(); i++) {
                a(new y14(((Integer) list.get(i)).intValue()));
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d0 e() {
            return new d0(this.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b f(int i) {
            gg3.d(i != 0);
            Iterator it = this.a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                y14 y14Var = (y14) it.next();
                if (y14Var.a == i) {
                    this.a.remove(y14Var);
                    break;
                }
            }
            return this;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public d0(Collection collection) {
        this.a = dj1.p(collection);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean c(Collection collection, int i) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (((y14) it.next()).a == i) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static d0 d(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(c);
        if (parcelableArrayList == null) {
            xz1.i("SessionCommands", "Missing commands. Creating an empty SessionCommands");
            return b;
        }
        b bVar = new b();
        for (int i = 0; i < parcelableArrayList.size(); i++) {
            bVar.a(y14.a((Bundle) parcelableArrayList.get(i)));
        }
        return bVar.e();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean a(int i) {
        gg3.e(i != 0, "Use contains(Command) for custom command");
        return c(this.a, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean b(y14 y14Var) {
        return this.a.contains(gg3.q(y14Var));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Bundle e() {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>();
        pw4 it = this.a.iterator();
        while (it.hasNext()) {
            arrayList.add(((y14) it.next()).b());
        }
        bundle.putParcelableArrayList(c, arrayList);
        return bundle;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof d0) {
            return this.a.equals(((d0) obj).a);
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return u43.b(this.a);
    }
}
