package defpackage;

import defpackage.o94;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class c04 {
    public static final cd4 d = cd4.f(':');
    public static final cd4 e = cd4.f('*');
    public final List a = new ArrayList();
    public int b = 0;
    public int c;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public final int a;
        public final long b;
        public final int c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(int i, long j, int i2) {
            this.a = i;
            this.b = j;
            this.c = i2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int b(String str) throws r83 {
        str.getClass();
        switch (str) {
            case "SlowMotion_Data":
                return 2192;
            case "Super_SlowMotion_Edit_Data":
                return 2819;
            case "Super_SlowMotion_Data":
                return 2816;
            case "Super_SlowMotion_Deflickering_On":
                return 2820;
            case "Super_SlowMotion_BGM":
                return 2817;
            default:
                throw r83.a("Invalid SEF name", null);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static o94 f(r73 r73Var, int i) throws r83 {
        ArrayList arrayList = new ArrayList();
        List listI = e.i(r73Var.N(i));
        for (int i2 = 0; i2 < listI.size(); i2++) {
            List listI2 = d.i((CharSequence) listI.get(i2));
            if (listI2.size() != 3) {
                throw r83.a(null, null);
            }
            try {
                arrayList.add(new o94.a(Long.parseLong((String) listI2.get(0)), Long.parseLong((String) listI2.get(1)), 1 << (Integer.parseInt((String) listI2.get(2)) - 1)));
            } catch (NumberFormatException e2) {
                throw r83.a(null, e2);
            }
        }
        return new o94(arrayList);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void a(jz0 jz0Var, yf3 yf3Var) {
        r73 r73Var = new r73(8);
        jz0Var.readFully(r73Var.f(), 0, 8);
        this.c = r73Var.D() + 8;
        if (r73Var.z() != 1397048916) {
            yf3Var.a = 0L;
        } else {
            yf3Var.a = jz0Var.getPosition() - ((long) (this.c - 12));
            this.b = 2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int c(jz0 jz0Var, yf3 yf3Var, List list) throws r83 {
        int i = this.b;
        long j = 0;
        if (i == 0) {
            long length = jz0Var.getLength();
            if (length != -1 && length >= 8) {
                j = length - 8;
            }
            yf3Var.a = j;
            this.b = 1;
        } else if (i == 1) {
            a(jz0Var, yf3Var);
        } else if (i == 2) {
            d(jz0Var, yf3Var);
        } else {
            if (i != 3) {
                z20.a();
                return 0;
            }
            e(jz0Var, list);
            yf3Var.a = 0L;
        }
        return 1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void d(jz0 jz0Var, yf3 yf3Var) {
        long length = jz0Var.getLength();
        int i = this.c - 20;
        r73 r73Var = new r73(i);
        jz0Var.readFully(r73Var.f(), 0, i);
        for (int i2 = 0; i2 < i / 12; i2++) {
            r73Var.g0(2);
            short sF = r73Var.F();
            if (sF == 2192 || sF == 2816 || sF == 2817 || sF == 2819 || sF == 2820) {
                this.a.add(new a(sF, (length - ((long) this.c)) - ((long) r73Var.D()), r73Var.D()));
            } else {
                r73Var.g0(8);
            }
        }
        if (this.a.isEmpty()) {
            yf3Var.a = 0L;
        } else {
            this.b = 3;
            yf3Var.a = ((a) this.a.get(0)).b;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e(jz0 jz0Var, List list) throws r83 {
        long position = jz0Var.getPosition();
        int length = (int) ((jz0Var.getLength() - jz0Var.getPosition()) - ((long) this.c));
        r73 r73Var = new r73(length);
        jz0Var.readFully(r73Var.f(), 0, length);
        for (int i = 0; i < this.a.size(); i++) {
            a aVar = (a) this.a.get(i);
            r73Var.f0((int) (aVar.b - position));
            r73Var.g0(4);
            int iD = r73Var.D();
            int iB = b(r73Var.N(iD));
            int i2 = aVar.c - (iD + 8);
            if (iB == 2192) {
                list.add(f(r73Var, i2));
            } else if (iB != 2816 && iB != 2817 && iB != 2819 && iB != 2820) {
                z20.a();
                return;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g() {
        this.a.clear();
        this.b = 0;
    }
}
