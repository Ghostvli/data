package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ax {
    public static final List a;
    public static final List b;

    static {
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add(-1092784);
        arrayList.add(-1294214);
        arrayList.add(-5552196);
        arrayList.add(-8497214);
        arrayList.add(-10720320);
        arrayList.add(-12409355);
        arrayList.add(-14043402);
        arrayList.add(-14235942);
        arrayList.add(-14244198);
        arrayList.add(-10044566);
        arrayList.add(-6501275);
        arrayList.add(-2825897);
        arrayList.add(-4520);
        arrayList.add(-13784);
        arrayList.add(-22746);
        arrayList.add(-36797);
        arrayList.add(-7508381);
        arrayList.add(-4342339);
        arrayList.add(-8875876);
        ArrayList arrayList2 = new ArrayList();
        b = arrayList2;
        arrayList2.add(-2937041);
        arrayList2.add(-4056997);
        arrayList2.add(-8708190);
        arrayList2.add(-11457112);
        arrayList2.add(-13615201);
        arrayList2.add(-15108398);
        arrayList2.add(-16611119);
        arrayList2.add(-16738393);
        arrayList2.add(-16746133);
        arrayList2.add(-13070788);
        arrayList2.add(-9920712);
        arrayList2.add(-5262293);
        arrayList2.add(-278483);
        arrayList2.add(-24576);
        arrayList2.add(-689152);
        arrayList2.add(-1684967);
        arrayList2.add(-10665929);
        arrayList2.add(-10395295);
        arrayList2.add(-12232092);
    }

    public static int a(String str) {
        List list = a;
        return ((Integer) list.get((str.hashCode() & Integer.MAX_VALUE) % list.size())).intValue();
    }
}
