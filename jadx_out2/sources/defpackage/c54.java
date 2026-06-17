package defpackage;

import android.graphics.PointF;
import defpackage.no1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class c54 implements cz4 {
    public static final c54 a = new c54();
    public static final no1.a b = no1.a.a("c", "v", "i", "o");

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a(Lno1;F)Ljava/lang/Object; */
    @Override // defpackage.cz4
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public b54 a(no1 no1Var, float f) {
        if (no1Var.K() == no1.b.BEGIN_ARRAY) {
            no1Var.c();
        }
        no1Var.h();
        List listF = null;
        List listF2 = null;
        List listF3 = null;
        boolean zU = false;
        while (no1Var.t()) {
            int iM = no1Var.M(b);
            if (iM == 0) {
                zU = no1Var.u();
            } else if (iM == 1) {
                listF = wo1.f(no1Var, f);
            } else if (iM == 2) {
                listF2 = wo1.f(no1Var, f);
            } else if (iM != 3) {
                no1Var.N();
                no1Var.O();
            } else {
                listF3 = wo1.f(no1Var, f);
            }
        }
        no1Var.l();
        if (no1Var.K() == no1.b.END_ARRAY) {
            no1Var.i();
        }
        if (listF == null || listF2 == null || listF3 == null) {
            jl.a("Shape data was missing information.");
            return null;
        }
        if (listF.isEmpty()) {
            return new b54(new PointF(), false, Collections.EMPTY_LIST);
        }
        int size = listF.size();
        PointF pointF = (PointF) listF.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i = 1; i < size; i++) {
            PointF pointF2 = (PointF) listF.get(i);
            int i2 = i - 1;
            arrayList.add(new o50(ot2.a((PointF) listF.get(i2), (PointF) listF3.get(i2)), ot2.a(pointF2, (PointF) listF2.get(i)), pointF2));
        }
        if (zU) {
            PointF pointF3 = (PointF) listF.get(0);
            int i3 = size - 1;
            arrayList.add(new o50(ot2.a((PointF) listF.get(i3), (PointF) listF3.get(i3)), ot2.a(pointF3, (PointF) listF2.get(0)), pointF3));
        }
        return new b54(pointF, zU, arrayList);
    }
}
