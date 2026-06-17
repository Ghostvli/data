package defpackage;

import defpackage.ss1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class bn1 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String a(String str, String str2) throws s83 {
        int iIndexOf = str.indexOf(str2);
        if (iIndexOf < 0) {
            ny4.a("Start not found");
            return null;
        }
        String strSubstring = str.substring(iIndexOf + str2.length());
        ss1 ss1Var = new ss1(strSubstring);
        boolean z = false;
        while (true) {
            ss1.h hVarB = ss1Var.b();
            ip4 ip4Var = hVarB.a;
            if (ip4Var == ip4.LC) {
                z = true;
            } else {
                if (z && ss1Var.g()) {
                    return strSubstring.substring(0, hVarB.c);
                }
                if (ip4Var == ip4.EOF) {
                    ny4.a("Could not find matching braces");
                    return null;
                }
            }
        }
    }
}
