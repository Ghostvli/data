package defpackage;

import android.net.Uri;
import androidx.media3.exoplayer.rtsp.h;
import com.thegrizzlylabs.sardineandroid.util.SardineUtil;
import defpackage.yf2;
import defpackage.z14;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.jupnp.support.messagebox.parser.MessageElement;
import org.mozilla.javascript.Token;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a24 {
    public static final Pattern a = Pattern.compile("([a-z])=\\s?((?:.|\f)++)");
    public static final Pattern b = Pattern.compile("^([a-z])=$");
    public static final Pattern c = Pattern.compile("([\\x21\\x23-\\x27\\x2a\\x2b\\x2d\\x2e\\x30-\\x39\\x41-\\x5a\\x5e-\\x7e]+)(?::((?:.|\f)*+))?");
    public static final Pattern d = Pattern.compile("(\\S+)\\s(\\S+)\\s(\\S+)\\s(\\S+)");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void a(z14.b bVar, yf2.b bVar2) throws r83 {
        try {
            bVar.n(bVar2.j());
        } catch (IllegalArgumentException | IllegalStateException e) {
            throw r83.c(null, e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x01b8, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static z14 b(String str) throws r83 {
        String str2;
        z14.b bVar = new z14.b();
        yf2.b bVarC = null;
        boolean z = false;
        for (String str3 : h.s(str)) {
            String strTrim = str3.trim();
            if (!strTrim.isEmpty()) {
                Matcher matcher = a.matcher(strTrim);
                if (matcher.matches()) {
                    String str4 = (String) gg3.q(matcher.group(1));
                    String str5 = (String) gg3.q(matcher.group(2));
                    switch (str4.hashCode()) {
                        case Token.RP /* 97 */:
                            if (!str4.equals("a")) {
                                continue;
                            } else if (!z) {
                                Matcher matcher2 = c.matcher(str5);
                                if (!matcher2.matches()) {
                                    throw r83.c("Malformed Attribute line: ".concat(strTrim), null);
                                }
                                String str6 = (String) gg3.q(matcher2.group(1));
                                String strD = gg4.d(matcher2.group(2));
                                if (bVarC == null) {
                                    bVar.m(str6, strD);
                                } else {
                                    bVarC.i(str6, strD);
                                }
                            } else {
                                continue;
                            }
                            break;
                        case Token.COMMA /* 98 */:
                            if (!str4.equals("b")) {
                                continue;
                            } else if (!z) {
                                String[] strArrG1 = fy4.G1(str5, ":\\s?");
                                gg3.d(strArrG1.length == 2);
                                int i = Integer.parseInt(strArrG1[1]);
                                if (bVarC == null) {
                                    bVar.p(i * 1000);
                                } else {
                                    bVarC.m(i * 1000);
                                }
                            }
                            break;
                        case 99:
                            if (!str4.equals("c")) {
                                continue;
                            } else if (!z) {
                                if (bVarC == null) {
                                    bVar.q(str5);
                                } else {
                                    bVarC.n(str5);
                                }
                            }
                            break;
                        case 101:
                            if (str4.equals("e")) {
                                bVar.r(str5);
                            } else {
                                continue;
                            }
                            break;
                        case Token.ASSIGN_LSH /* 105 */:
                            if (!str4.equals("i")) {
                                continue;
                            } else if (!z) {
                                if (bVarC == null) {
                                    bVar.v(str5);
                                } else {
                                    bVarC.p(str5);
                                }
                            }
                            break;
                        case Token.ASSIGN_URSH /* 107 */:
                            if (!str4.equals("k")) {
                                continue;
                            } else if (!z) {
                                if (bVarC == null) {
                                    bVar.s(str5);
                                } else {
                                    bVarC.o(str5);
                                }
                            }
                            break;
                        case Token.ASSIGN_SUB /* 109 */:
                            if (str4.equals(MessageElement.XPATH_PREFIX)) {
                                if (bVarC != null) {
                                    a(bVar, bVarC);
                                }
                                bVarC = c(str5);
                                z = bVarC == null;
                            } else {
                                continue;
                            }
                            break;
                        case Token.ASSIGN_DIV /* 111 */:
                            if (str4.equals("o")) {
                                bVar.t(str5);
                            } else {
                                continue;
                            }
                            break;
                        case Token.ASSIGN_MOD /* 112 */:
                            if (str4.equals("p")) {
                                bVar.u(str5);
                            } else {
                                continue;
                            }
                            break;
                        case 114:
                            str2 = "r";
                            break;
                        case Token.HOOK /* 115 */:
                            if (str4.equals(SardineUtil.CUSTOM_NAMESPACE_PREFIX)) {
                                bVar.w(str5);
                            } else {
                                continue;
                            }
                            break;
                        case Token.COLON /* 116 */:
                            if (str4.equals("t")) {
                                bVar.x(str5);
                            } else {
                                continue;
                            }
                            break;
                        case Token.OR /* 117 */:
                            if (str4.equals("u")) {
                                bVar.y(Uri.parse(str5));
                            } else {
                                continue;
                            }
                            break;
                        case Token.AND /* 118 */:
                            if (str4.equals("v")) {
                                if (!"0".equals(str5)) {
                                    throw r83.c(String.format("SDP version %s is not supported.", str5), null);
                                }
                            } else {
                                continue;
                            }
                            break;
                        case Token.FUNCTION /* 122 */:
                            str2 = "z";
                            break;
                    }
                    str4.equals(str2);
                } else {
                    Matcher matcher3 = b.matcher(strTrim);
                    if (!matcher3.matches() || !Objects.equals(matcher3.group(1), "i")) {
                        throw r83.c("Malformed SDP line: ".concat(strTrim), null);
                    }
                }
            }
        }
        if (bVarC != null) {
            a(bVar, bVarC);
        }
        try {
            return bVar.o();
        } catch (IllegalArgumentException | IllegalStateException e) {
            throw r83.c(null, e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
