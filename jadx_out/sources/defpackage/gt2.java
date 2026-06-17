package defpackage;

import defpackage.t41;
import defpackage.xs2;
import org.jupnp.model.ServiceReference;
import org.jupnp.support.model.dlna.DLNAProfiles;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class gt2 {
    public static mx a(int i, r73 r73Var) {
        int iZ = r73Var.z();
        if (r73Var.z() == 1684108385) {
            r73Var.g0(8);
            String strL = r73Var.L(iZ - 16);
            return new mx("und", strL, strL);
        }
        xz1.i("MetadataUtil", "Failed to parse comment attribute: " + su2.a(i));
        return null;
    }

    public static t7 b(r73 r73Var) {
        int iZ = r73Var.z();
        if (r73Var.z() != 1684108385) {
            xz1.i("MetadataUtil", "Failed to parse cover art attribute");
            return null;
        }
        int iP = gl.p(r73Var.z());
        String str = iP == 13 ? DLNAProfiles.DLNAMimeTypes.MIME_IMAGE_JPEG : iP == 14 ? DLNAProfiles.DLNAMimeTypes.MIME_IMAGE_PNG : null;
        if (str == null) {
            xz1.i("MetadataUtil", "Unrecognized cover art flags: " + iP);
            return null;
        }
        r73Var.g0(4);
        int i = iZ - 16;
        byte[] bArr = new byte[i];
        r73Var.u(bArr, 0, i);
        return new t7(str, null, 3, bArr);
    }

    public static xs2.a c(r73 r73Var) {
        int iG = r73Var.g() + r73Var.z();
        int iZ = r73Var.z();
        int i = (iZ >> 24) & 255;
        try {
            if (i == 169 || i == 253) {
                int i2 = 16777215 & iZ;
                if (i2 == 6516084) {
                    return a(iZ, r73Var);
                }
                if (i2 == 7233901 || i2 == 7631467) {
                    return j(iZ, "TIT2", r73Var);
                }
                if (i2 == 6516589 || i2 == 7828084) {
                    return j(iZ, "TCOM", r73Var);
                }
                if (i2 == 6578553) {
                    return j(iZ, "TDRC", r73Var);
                }
                if (i2 == 4280916) {
                    return j(iZ, "TPE1", r73Var);
                }
                if (i2 == 7630703) {
                    return j(iZ, "TSSE", r73Var);
                }
                if (i2 == 6384738) {
                    return j(iZ, "TALB", r73Var);
                }
                if (i2 == 7108978) {
                    return j(iZ, "USLT", r73Var);
                }
                if (i2 == 6776174) {
                    return j(iZ, "TCON", r73Var);
                }
                if (i2 == 6779504) {
                    return j(iZ, "TIT1", r73Var);
                }
                if (i2 == 7173742) {
                    return j(iZ, "MVNM", r73Var);
                }
                if (i2 == 7173737) {
                    return f(iZ, "MVIN", r73Var, true, false);
                }
            } else {
                if (iZ == 1735291493) {
                    return i(r73Var);
                }
                if (iZ == 1684632427) {
                    return d(iZ, "TPOS", r73Var);
                }
                if (iZ == 1953655662) {
                    return d(iZ, "TRCK", r73Var);
                }
                if (iZ == 1953329263) {
                    return f(iZ, "TBPM", r73Var, true, false);
                }
                if (iZ == 1668311404) {
                    return f(iZ, "TCMP", r73Var, true, true);
                }
                if (iZ == 1668249202) {
                    return b(r73Var);
                }
                if (iZ == 1631670868) {
                    return j(iZ, "TPE2", r73Var);
                }
                if (iZ == 1936682605) {
                    return j(iZ, "TSOT", r73Var);
                }
                if (iZ == 1936679276) {
                    return j(iZ, "TSOA", r73Var);
                }
                if (iZ == 1936679282) {
                    return j(iZ, "TSOP", r73Var);
                }
                if (iZ == 1936679265) {
                    return j(iZ, "TSO2", r73Var);
                }
                if (iZ == 1936679791) {
                    return j(iZ, "TSOC", r73Var);
                }
                if (iZ == 1920233063) {
                    return f(iZ, "ITUNESADVISORY", r73Var, false, false);
                }
                if (iZ == 1885823344) {
                    return f(iZ, "ITUNESGAPLESS", r73Var, false, true);
                }
                if (iZ == 1936683886) {
                    return j(iZ, "TVSHOWSORT", r73Var);
                }
                if (iZ == 1953919848) {
                    return j(iZ, "TVSHOW", r73Var);
                }
                if (iZ == 757935405) {
                    return g(r73Var, iG);
                }
            }
            xz1.b("MetadataUtil", "Skipped unknown metadata entry: " + su2.a(iZ));
            r73Var.f0(iG);
            return null;
        } finally {
            r73Var.f0(iG);
        }
    }

    public static mm4 d(int i, String str, r73 r73Var) {
        int iZ = r73Var.z();
        if (r73Var.z() == 1684108385 && iZ >= 22) {
            r73Var.g0(10);
            int iY = r73Var.Y();
            if (iY > 0) {
                String str2 = "" + iY;
                int iY2 = r73Var.Y();
                if (iY2 > 0) {
                    str2 = str2 + ServiceReference.DELIMITER + iY2;
                }
                return new mm4(str, null, xi1.w(str2));
            }
        }
        xz1.i("MetadataUtil", "Failed to parse index/count attribute: " + su2.a(i));
        return null;
    }

    public static int e(r73 r73Var) {
        int iZ = r73Var.z();
        if (r73Var.z() == 1684108385) {
            r73Var.g0(8);
            int i = iZ - 16;
            if (i == 1) {
                return r73Var.Q();
            }
            if (i == 2) {
                return r73Var.Y();
            }
            if (i == 3) {
                return r73Var.T();
            }
            if (i == 4 && (r73Var.q() & 128) == 0) {
                return r73Var.U();
            }
        }
        xz1.i("MetadataUtil", "Failed to parse data atom to int");
        return -1;
    }

    public static yh1 f(int i, String str, r73 r73Var, boolean z, boolean z2) {
        int iE = e(r73Var);
        if (z2) {
            iE = Math.min(1, iE);
        }
        if (iE >= 0) {
            return z ? new mm4(str, null, xi1.w(Integer.toString(iE))) : new mx("und", str, Integer.toString(iE));
        }
        xz1.i("MetadataUtil", "Failed to parse uint8 attribute: " + su2.a(i));
        return null;
    }

    public static yh1 g(r73 r73Var, int i) {
        String strL = null;
        String strL2 = null;
        int i2 = -1;
        int i3 = -1;
        while (r73Var.g() < i) {
            int iG = r73Var.g();
            int iZ = r73Var.z();
            int iZ2 = r73Var.z();
            r73Var.g0(4);
            if (iZ2 == 1835360622) {
                strL = r73Var.L(iZ - 12);
            } else if (iZ2 == 1851878757) {
                strL2 = r73Var.L(iZ - 12);
            } else {
                if (iZ2 == 1684108385) {
                    i2 = iG;
                    i3 = iZ;
                }
                r73Var.g0(iZ - 12);
            }
        }
        if (strL == null || strL2 == null || i2 == -1) {
            return null;
        }
        r73Var.f0(i2);
        r73Var.g0(16);
        return new dl1(strL, strL2, r73Var.L(i3 - 16));
    }

    public static w62 h(r73 r73Var, int i, String str) {
        while (true) {
            int iG = r73Var.g();
            if (iG >= i) {
                return null;
            }
            int iZ = r73Var.z();
            if (r73Var.z() == 1684108385) {
                int iZ2 = r73Var.z();
                int iZ3 = r73Var.z();
                int i2 = iZ - 16;
                byte[] bArr = new byte[i2];
                r73Var.u(bArr, 0, i2);
                try {
                    return new w62(str, bArr, iZ3, iZ2);
                } catch (Exception unused) {
                    xz1.i("MetadataUtil", "Failed to parse metadata entry with key: " + str);
                    return null;
                }
            }
            r73Var.f0(iG + iZ);
        }
    }

    public static mm4 i(r73 r73Var) {
        String strA = bi1.a(e(r73Var) - 1);
        if (strA != null) {
            return new mm4("TCON", null, xi1.w(strA));
        }
        xz1.i("MetadataUtil", "Failed to parse standard genre code");
        return null;
    }

    public static mm4 j(int i, String str, r73 r73Var) {
        int iZ = r73Var.z();
        if (r73Var.z() == 1684108385) {
            r73Var.g0(8);
            return new mm4(str, null, xi1.w(r73Var.L(iZ - 16)));
        }
        xz1.i("MetadataUtil", "Failed to parse text attribute: " + su2.a(i));
        return null;
    }

    public static void k(int i, f91 f91Var, t41.b bVar) {
        if (i == 1 && f91Var.c()) {
            bVar.e0(f91Var.a).f0(f91Var.b);
        }
    }

    public static void l(int i, xs2 xs2Var, t41.b bVar, xs2 xs2Var2, xs2... xs2VarArr) {
        if (xs2Var2 == null) {
            xs2Var2 = new xs2(new xs2.a[0]);
        }
        if (xs2Var != null) {
            pw4 it = xs2Var.f(w62.class).iterator();
            while (it.hasNext()) {
                w62 w62Var = (w62) it.next();
                if (!w62Var.a.equals("com.android.capture.fps") || i == 2) {
                    xs2Var2 = xs2Var2.a(w62Var);
                }
            }
        }
        for (xs2 xs2Var3 : xs2VarArr) {
            xs2Var2 = xs2Var2.b(xs2Var3);
        }
        if (xs2Var2.j() > 0) {
            bVar.s0(xs2Var2);
        }
    }
}
