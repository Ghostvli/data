package defpackage;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class wt1 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean a(String str) {
        return h(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public vt1 b(String str, String str2) {
        Objects.requireNonNull(str, "ID cannot be null");
        String strG = g(str, str2);
        return new vt1(strG, strG, str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public vt1 c(String str) {
        if (yy4.n(str)) {
            jl.a("The url is null or empty");
            return null;
        }
        String strG = yy4.g(str);
        return d(strG, yy4.h(strG));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public vt1 d(String str, String str2) throws s83 {
        Objects.requireNonNull(str, "URL cannot be null");
        if (!a(str)) {
            throw new s83("URL not accepted: ".concat(str));
        }
        String strE = e(str);
        return new vt1(str, g(strE, str2), strE);
    }

    public abstract String e(String str);

    public abstract String f(String str);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String g(String str, String str2) {
        return f(str);
    }

    public abstract boolean h(String str);
}
