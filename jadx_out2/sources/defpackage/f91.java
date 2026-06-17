package defpackage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class f91 {
    public static final Pattern c = Pattern.compile("^ [0-9a-fA-F]{8} ([0-9a-fA-F]{8}) ([0-9a-fA-F]{8})");
    public int a = -1;
    public int b = -1;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean b(dl1 dl1Var) {
        return dl1Var.b.equals("com.apple.iTunes") && dl1Var.c.equals("iTunSMPB");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean c() {
        return (this.a == -1 || this.b == -1) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean d(String str) {
        Matcher matcher = c.matcher(str);
        if (!matcher.find()) {
            return false;
        }
        try {
            int i = Integer.parseInt((String) fy4.l(matcher.group(1)), 16);
            int i2 = Integer.parseInt((String) fy4.l(matcher.group(2)), 16);
            if (i <= 0 && i2 <= 0) {
                return false;
            }
            this.a = i;
            this.b = i2;
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean e(xs2 xs2Var) {
        pw4 it = xs2Var.i(mx.class, new ig3() { // from class: d91
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.ig3
            public final boolean apply(Object obj) {
                return ((mx) obj).c.equals("iTunSMPB");
            }
        }).iterator();
        while (it.hasNext()) {
            if (d(((mx) it.next()).d)) {
                return true;
            }
        }
        pw4 it2 = xs2Var.i(dl1.class, new ig3() { // from class: e91
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.ig3
            public final boolean apply(Object obj) {
                return f91.b((dl1) obj);
            }
        }).iterator();
        while (it2.hasNext()) {
            if (d(((dl1) it2.next()).d)) {
                return true;
            }
        }
        return false;
    }
}
