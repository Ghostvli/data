package defpackage;

import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Arrays;
import okhttp3.internal.http2.Http2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class br4 {
    public static final String f = fy4.N0(0);
    public static final String g = fy4.N0(1);
    public final int a;
    public final String b;
    public final int c;
    public final t41[] d;
    public int e;

    public br4(String str, t41... t41VarArr) {
        gg3.d(t41VarArr.length > 0);
        this.b = str;
        this.d = t41VarArr;
        this.a = t41VarArr.length;
        String str2 = t41VarArr[0].p;
        this.c = TextUtils.isEmpty(str2) ? nt2.k(t41VarArr[0].o) : nt2.k(str2);
        i();
    }

    public static br4 b(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(f);
        return new br4(bundle.getString(g, ""), (t41[]) (parcelableArrayList == null ? xi1.u() : fm.d(new p81() { // from class: ar4
            @Override // defpackage.p81
            public final Object apply(Object obj) {
                return t41.e((Bundle) obj);
            }
        }, parcelableArrayList)).toArray(new t41[0]));
    }

    public static void e(String str, String str2, String str3, int i) {
        xz1.e("TrackGroup", "", new IllegalStateException("Different " + str + " combined in one TrackGroup: '" + str2 + "' (track 0) and '" + str3 + "' (track " + i + ")"));
    }

    public static String f(String str) {
        return (str == null || str.equals("und")) ? "" : str;
    }

    public static int g(int i) {
        return i | Http2.INITIAL_MAX_FRAME_SIZE;
    }

    public br4 a(String str) {
        return new br4(str, this.d);
    }

    public t41 c(int i) {
        return this.d[i];
    }

    public int d(t41 t41Var) {
        int i = 0;
        while (true) {
            t41[] t41VarArr = this.d;
            if (i >= t41VarArr.length) {
                return -1;
            }
            if (t41Var == t41VarArr[i]) {
                return i;
            }
            i++;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && br4.class == obj.getClass()) {
            br4 br4Var = (br4) obj;
            if (this.b.equals(br4Var.b) && Arrays.equals(this.d, br4Var.d)) {
                return true;
            }
        }
        return false;
    }

    public Bundle h() {
        Bundle bundle = new Bundle();
        ArrayList<? extends Parcelable> arrayList = new ArrayList<>(this.d.length);
        for (t41 t41Var : this.d) {
            arrayList.add(t41Var.k());
        }
        bundle.putParcelableArrayList(f, arrayList);
        bundle.putString(g, this.b);
        return bundle;
    }

    public int hashCode() {
        if (this.e == 0) {
            this.e = ((527 + this.b.hashCode()) * 31) + Arrays.hashCode(this.d);
        }
        return this.e;
    }

    public final void i() {
        String strF = f(this.d[0].d);
        int iG = g(this.d[0].f);
        int i = 1;
        while (true) {
            t41[] t41VarArr = this.d;
            if (i >= t41VarArr.length) {
                return;
            }
            boolean zEquals = strF.equals(f(t41VarArr[i].d));
            t41[] t41VarArr2 = this.d;
            if (!zEquals) {
                e("languages", t41VarArr2[0].d, t41VarArr2[i].d, i);
                return;
            } else {
                if (iG != g(t41VarArr2[i].f)) {
                    e("role flags", Integer.toBinaryString(this.d[0].f), Integer.toBinaryString(this.d[i].f), i);
                    return;
                }
                i++;
            }
        }
    }

    public String toString() {
        return this.b + ": " + Arrays.toString(this.d);
    }

    public br4(t41... t41VarArr) {
        this("", t41VarArr);
    }
}
