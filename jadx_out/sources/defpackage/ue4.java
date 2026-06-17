package defpackage;

import defpackage.p83;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ue4 extends gz0 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public enum a {
        PUBLIC,
        UNLISTED,
        PRIVATE,
        INTERNAL,
        OTHER
    }

    public ue4(wf4 wf4Var, vt1 vt1Var) {
        super(wf4Var, vt1Var);
    }

    public String A() {
        return "";
    }

    public Locale B() {
        return null;
    }

    public long C() {
        return 0L;
    }

    public String D() {
        return "";
    }

    public long E() {
        return -1L;
    }

    public List F() {
        return Collections.EMPTY_LIST;
    }

    public a G() {
        return a.PUBLIC;
    }

    public xj1 H() {
        return null;
    }

    public List I() {
        return Collections.EMPTY_LIST;
    }

    public abstract gf4 J();

    public List K() {
        return Collections.EMPTY_LIST;
    }

    public String L() {
        return "";
    }

    public String M() {
        return "";
    }

    public List N() {
        return Collections.EMPTY_LIST;
    }

    public String O() {
        return "";
    }

    public List P() {
        return Collections.EMPTY_LIST;
    }

    public String Q() {
        return null;
    }

    public abstract List R();

    public long S() {
        return 0L;
    }

    public long T(String str) throws s83 {
        String strK;
        String strK2;
        String strK3 = "";
        try {
            String strK4 = p83.k(str, k());
            if (!strK4.isEmpty()) {
                try {
                    strK = p83.k("(\\d+)s", strK4);
                    try {
                        strK2 = p83.k("(\\d+)m", strK4);
                        try {
                            strK3 = p83.k("(\\d+)h", strK4);
                        } catch (Exception unused) {
                            try {
                                if (strK.isEmpty() && strK2.isEmpty()) {
                                    strK = p83.k("t=(\\d+)", strK4);
                                }
                            } catch (s83 e) {
                                uo1.a("Could not get timestamp.", e);
                            }
                        }
                    } catch (Exception unused2) {
                        strK2 = "";
                    }
                } catch (Exception unused3) {
                    strK = "";
                    strK2 = strK;
                }
                int i = 0;
                int i2 = strK.isEmpty() ? 0 : Integer.parseInt(strK);
                int i3 = strK2.isEmpty() ? 0 : Integer.parseInt(strK2);
                if (!strK3.isEmpty()) {
                    i = Integer.parseInt(strK3);
                }
                return ((long) i2) + (((long) i3) * 60) + (((long) i) * 3600);
            }
            return 0L;
        } catch (p83.a unused4) {
            return -2L;
        }
    }

    public qa0 U() {
        return null;
    }

    public List V() {
        return Collections.EMPTY_LIST;
    }

    public abstract String W();

    public long X() {
        return -1L;
    }

    public abstract String Y();

    public abstract List Z();

    public abstract List a0();

    public long b0() {
        return -1L;
    }

    public boolean c0() {
        return false;
    }

    public boolean d0() {
        return false;
    }

    public int q() {
        return 0;
    }

    public abstract List r();

    public String s() {
        return "";
    }

    public l20 t() {
        return l20.UNKNOWN;
    }

    public String u() {
        return "";
    }

    public abstract qj0 v();

    public long w() {
        return -1L;
    }

    public String x() {
        return null;
    }

    public List y() {
        return Collections.EMPTY_LIST;
    }

    public String z() {
        return "";
    }
}
