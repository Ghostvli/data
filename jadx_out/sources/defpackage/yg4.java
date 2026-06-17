package defpackage;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class yg4 extends xg4 {
    public static final String R0(String str, int i) {
        str.getClass();
        if (i >= 0) {
            return str.substring(xn3.d(i, str.length()));
        }
        i04.a("Requested character count ", i, " is less than zero.");
        return null;
    }

    public static char S0(CharSequence charSequence) {
        charSequence.getClass();
        if (charSequence.length() != 0) {
            return charSequence.charAt(wg4.U(charSequence));
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }

    public static String T0(String str, int i) {
        str.getClass();
        if (i >= 0) {
            return str.substring(0, xn3.d(i, str.length()));
        }
        i04.a("Requested character count ", i, " is less than zero.");
        return null;
    }
}
