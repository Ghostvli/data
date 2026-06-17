package defpackage;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class co3 implements ps2 {
    public final rs2 a;
    public final String b;
    public final Object[] c;
    public final int d;

    public co3(rs2 rs2Var, String str, Object[] objArr) {
        this.a = rs2Var;
        this.b = str;
        this.c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.d = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 < 55296) {
                this.d = i | (cCharAt2 << i2);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    @Override // defpackage.ps2
    public boolean a() {
        return (this.d & 2) == 2;
    }

    @Override // defpackage.ps2
    public rs2 b() {
        return this.a;
    }

    @Override // defpackage.ps2
    public ki3 c() {
        int i = this.d;
        return (i & 1) != 0 ? ki3.PROTO2 : (i & 4) == 4 ? ki3.EDITIONS : ki3.PROTO3;
    }

    public Object[] d() {
        return this.c;
    }

    public String e() {
        return this.b;
    }
}
