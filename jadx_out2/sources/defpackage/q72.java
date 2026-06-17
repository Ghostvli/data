package defpackage;

import defpackage.di1;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q72 {
    public static final Pattern a = Pattern.compile("\\w+/\\w+");
    public static eo1 b = null;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List a(String str) {
        return yy4.n(str) ? Collections.EMPTY_LIST : av4.a(new Object[]{new di1(str, -1, -1, di1.a.UNKNOWN)});
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static eo1 b(gn0 gn0Var, pz1 pz1Var) throws fz0 {
        if (b == null) {
            try {
                b = (eo1) lo1.b().a(gn0Var.c("https://streaming.media.ccc.de/streams/v2.json", pz1Var).c());
            } catch (fo3 | IOException e) {
                throw new fz0("Could not get live stream JSON.", e);
            } catch (mo1 e2) {
                throw new fz0("Could not parse JSON.", e2);
            }
        }
        return b;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List c(ko1 ko1Var) {
        return d(ko1Var, "thumb", "poster");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List d(ko1 ko1Var, String str, String str2) {
        ArrayList arrayList = new ArrayList(2);
        String strO = ko1Var.o(str);
        if (!yy4.n(strO)) {
            arrayList.add(new di1(strO, -1, -1, di1.a.MEDIUM));
        }
        String strO2 = ko1Var.o(str2);
        if (!yy4.n(strO2)) {
            arrayList.add(new di1(strO2, -1, -1, di1.a.HIGH));
        }
        return Collections.unmodifiableList(arrayList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List e(ko1 ko1Var) {
        return d(ko1Var, "thumb_url", "poster_url");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean f(String str) {
        return a.matcher(str).find();
    }
}
