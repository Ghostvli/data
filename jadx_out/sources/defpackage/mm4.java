package defpackage;

import defpackage.ph2;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class mm4 extends yh1 {
    public final String b;
    public final String c;
    public final xi1 d;

    public mm4(String str, String str2, List list) {
        super(str);
        gg3.d(!list.isEmpty());
        this.b = str2;
        xi1 xi1VarP = xi1.p(list);
        this.d = xi1VarP;
        this.c = (String) xi1VarP.get(0);
    }

    public static List d(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(8, 10))));
                return arrayList;
            }
            if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                return arrayList;
            }
            if (str.length() >= 4) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
            }
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // xs2.a
    public void b(ph2.b bVar) {
        String str = this.a;
        str.getClass();
        byte b = -1;
        switch (str.hashCode()) {
            case 82815:
                if (str.equals("TAL")) {
                    b = 0;
                }
                break;
            case 82878:
                if (str.equals("TCM")) {
                    b = 1;
                }
                break;
            case 82897:
                if (str.equals("TDA")) {
                    b = 2;
                }
                break;
            case 83253:
                if (str.equals("TP1")) {
                    b = 3;
                }
                break;
            case 83254:
                if (str.equals("TP2")) {
                    b = 4;
                }
                break;
            case 83255:
                if (str.equals("TP3")) {
                    b = 5;
                }
                break;
            case 83341:
                if (str.equals("TRK")) {
                    b = 6;
                }
                break;
            case 83378:
                if (str.equals("TT2")) {
                    b = 7;
                }
                break;
            case 83536:
                if (str.equals("TXT")) {
                    b = 8;
                }
                break;
            case 83552:
                if (str.equals("TYE")) {
                    b = 9;
                }
                break;
            case 2567331:
                if (str.equals("TALB")) {
                    b = 10;
                }
                break;
            case 2569357:
                if (str.equals("TCOM")) {
                    b = 11;
                }
                break;
            case 2569358:
                if (str.equals("TCON")) {
                    b = 12;
                }
                break;
            case 2569891:
                if (str.equals("TDAT")) {
                    b = 13;
                }
                break;
            case 2570401:
                if (str.equals("TDRC")) {
                    b = 14;
                }
                break;
            case 2570410:
                if (str.equals("TDRL")) {
                    b = 15;
                }
                break;
            case 2571565:
                if (str.equals("TEXT")) {
                    b = 16;
                }
                break;
            case 2575251:
                if (str.equals("TIT2")) {
                    b = 17;
                }
                break;
            case 2581512:
                if (str.equals("TPE1")) {
                    b = 18;
                }
                break;
            case 2581513:
                if (str.equals("TPE2")) {
                    b = 19;
                }
                break;
            case 2581514:
                if (str.equals("TPE3")) {
                    b = 20;
                }
                break;
            case 2583398:
                if (str.equals("TRCK")) {
                    b = 21;
                }
                break;
            case 2590194:
                if (str.equals("TYER")) {
                    b = 22;
                }
                break;
        }
        try {
            switch (b) {
                case 0:
                case 10:
                    bVar.R((CharSequence) this.d.get(0));
                    break;
                case 1:
                case 11:
                    bVar.W((CharSequence) this.d.get(0));
                    break;
                case 2:
                case 13:
                    String str2 = (String) this.d.get(0);
                    bVar.k0(Integer.valueOf(Integer.parseInt(str2.substring(2, 4)))).j0(Integer.valueOf(Integer.parseInt(str2.substring(0, 2))));
                    break;
                case 3:
                case 18:
                    bVar.S((CharSequence) this.d.get(0));
                    break;
                case 4:
                case 19:
                    bVar.Q((CharSequence) this.d.get(0));
                    break;
                case 5:
                case 20:
                    bVar.X((CharSequence) this.d.get(0));
                    break;
                case 6:
                case 21:
                    String[] strArrG1 = fy4.G1((String) this.d.get(0), ServiceReference.DELIMITER);
                    bVar.v0(Integer.valueOf(Integer.parseInt(strArrG1[0]))).u0(strArrG1.length > 1 ? Integer.valueOf(Integer.parseInt(strArrG1[1])) : null);
                    break;
                case 7:
                case 17:
                    bVar.s0((CharSequence) this.d.get(0));
                    break;
                case 8:
                case 16:
                    bVar.x0((CharSequence) this.d.get(0));
                    break;
                case 9:
                case 22:
                    bVar.l0(Integer.valueOf(Integer.parseInt((String) this.d.get(0))));
                    break;
                case 12:
                    Integer numP = ll1.p((String) this.d.get(0));
                    if (numP != null) {
                        String strA = bi1.a(numP.intValue());
                        if (strA != null) {
                            bVar.e0(strA);
                        }
                    } else {
                        bVar.e0((CharSequence) this.d.get(0));
                    }
                    break;
                case 14:
                    List listD = d((String) this.d.get(0));
                    int size = listD.size();
                    if (size != 1) {
                        if (size != 2) {
                            if (size == 3) {
                                bVar.j0((Integer) listD.get(2));
                            }
                        }
                        bVar.k0((Integer) listD.get(1));
                    }
                    bVar.l0((Integer) listD.get(0));
                    break;
                case 15:
                    List listD2 = d((String) this.d.get(0));
                    int size2 = listD2.size();
                    if (size2 != 1) {
                        if (size2 != 2) {
                            if (size2 == 3) {
                                bVar.m0((Integer) listD2.get(2));
                            }
                        }
                        bVar.n0((Integer) listD2.get(1));
                    }
                    bVar.o0((Integer) listD2.get(0));
                    break;
            }
        } catch (NumberFormatException | StringIndexOutOfBoundsException unused) {
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && mm4.class == obj.getClass()) {
            mm4 mm4Var = (mm4) obj;
            if (Objects.equals(this.a, mm4Var.a) && Objects.equals(this.b, mm4Var.b) && this.d.equals(mm4Var.d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (527 + this.a.hashCode()) * 31;
        String str = this.b;
        return ((iHashCode + (str != null ? str.hashCode() : 0)) * 31) + this.d.hashCode();
    }

    @Override // defpackage.yh1
    public String toString() {
        return this.a + ": description=" + this.b + ": values=" + this.d;
    }
}
