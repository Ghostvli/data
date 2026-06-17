package defpackage;

import defpackage.yf2;
import defpackage.z14;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a24 {
    public static final Pattern a = Pattern.compile("([a-z])=\\s?((?:.|\f)++)");
    public static final Pattern b = Pattern.compile("^([a-z])=$");
    public static final Pattern c = Pattern.compile("([\\x21\\x23-\\x27\\x2a\\x2b\\x2d\\x2e\\x30-\\x39\\x41-\\x5a\\x5e-\\x7e]+)(?::((?:.|\f)*+))?");
    public static final Pattern d = Pattern.compile("(\\S+)\\s(\\S+)\\s(\\S+)\\s(\\S+)");

    public static void a(z14.b bVar, yf2.b bVar2) throws r83 {
        try {
            bVar.n(bVar2.j());
        } catch (IllegalArgumentException | IllegalStateException e) {
            throw r83.c(null, e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:151:0x01b8, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static defpackage.z14 b(java.lang.String r14) throws defpackage.r83 {
        /*
            Method dump skipped, instruction units count: 518
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.a24.b(java.lang.String):z14");
    }

    public static yf2.b c(String str) throws r83 {
        Matcher matcher = d.matcher(str);
        if (!matcher.matches()) {
            throw r83.c("Malformed SDP media description line: " + str, null);
        }
        try {
            return new yf2.b((String) gg3.q(matcher.group(1)), Integer.parseInt((String) gg3.q(matcher.group(2))), (String) gg3.q(matcher.group(3)), Integer.parseInt((String) gg3.q(matcher.group(4))));
        } catch (NumberFormatException e) {
            xz1.j("SDPParser", "Malformed SDP media description line: " + str, e);
            return null;
        }
    }
}
