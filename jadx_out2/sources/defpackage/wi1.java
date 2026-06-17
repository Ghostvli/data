package defpackage;

import java.io.Serializable;
import java.util.Arrays;
import okhttp3.internal.url._UrlKt;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class wi1 implements Serializable {
    public static final wi1 i = new wi1(new int[0]);
    public final int[] f;
    public final transient int g;
    public final int h;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public wi1(int[] iArr, int i2, int i3) {
        this.f = iArr;
        this.g = i2;
        this.h = i3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static wi1 b(int[] iArr) {
        return iArr.length == 0 ? i : new wi1(Arrays.copyOf(iArr, iArr.length));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static wi1 g() {
        return i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static wi1 h(int i2) {
        return new wi1(new int[]{i2});
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static wi1 i(int i2, int i3) {
        return new wi1(new int[]{i2, i3});
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static wi1 j(int i2, int i3, int i4) {
        return new wi1(new int[]{i2, i3, i4});
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean a(int i2) {
        return d(i2) >= 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int c(int i2) {
        gg3.o(i2, f());
        return this.f[this.g + i2];
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int d(int i2) {
        for (int i3 = this.g; i3 < this.h; i3++) {
            if (this.f[i3] == i2) {
                return i3 - this.g;
            }
        }
        return -1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean e() {
        return this.h == this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof wi1)) {
            return false;
        }
        wi1 wi1Var = (wi1) obj;
        if (f() != wi1Var.f()) {
            return false;
        }
        for (int i2 = 0; i2 < f(); i2++) {
            if (c(i2) != wi1Var.c(i2)) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int f() {
        return this.h - this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        int iHashCode = 1;
        for (int i2 = this.g; i2 < this.h; i2++) {
            iHashCode = (iHashCode * 31) + Integer.hashCode(this.f[i2]);
        }
        return iHashCode;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int[] k() {
        return Arrays.copyOfRange(this.f, this.g, this.h);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        if (e()) {
            return _UrlKt.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(f() * 5);
        sb.append('[');
        sb.append(this.f[this.g]);
        int i2 = this.g;
        while (true) {
            i2++;
            if (i2 >= this.h) {
                sb.append(']');
                return sb.toString();
            }
            sb.append(", ");
            sb.append(this.f[i2]);
        }
    }

    public wi1(int[] iArr) {
        this(iArr, 0, iArr.length);
    }
}
