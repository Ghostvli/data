package defpackage;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class k6 extends yg {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public k6(List list) {
        super(e(list));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static dr1 d(dr1 dr1Var) {
        wa1 wa1Var = (wa1) dr1Var.b;
        wa1 wa1Var2 = (wa1) dr1Var.c;
        if (wa1Var == null || wa1Var2 == null || wa1Var.e().length == wa1Var2.e().length) {
            return dr1Var;
        }
        float[] fArrF = f(wa1Var.e(), wa1Var2.e());
        return dr1Var.b(wa1Var.b(fArrF), wa1Var2.b(fArrF));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List e(List list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, d((dr1) list.get(i)));
        }
        return list;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static float[] f(float[] fArr, float[] fArr2) {
        int length = fArr.length + fArr2.length;
        float[] fArr3 = new float[length];
        System.arraycopy(fArr, 0, fArr3, 0, fArr.length);
        System.arraycopy(fArr2, 0, fArr3, fArr.length, fArr2.length);
        Arrays.sort(fArr3);
        float f = Float.NaN;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            float f2 = fArr3[i2];
            if (f2 != f) {
                fArr3[i] = f2;
                i++;
                f = fArr3[i2];
            }
        }
        return Arrays.copyOfRange(fArr3, 0, i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.z6
    public zh a() {
        return new ya1(this.a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yg, defpackage.z6
    public /* bridge */ /* synthetic */ List b() {
        return super.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yg, defpackage.z6
    public /* bridge */ /* synthetic */ boolean c() {
        return super.c();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.yg
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }
}
