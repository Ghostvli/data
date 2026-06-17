package defpackage;

import defpackage.wm0;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class q33 {
    public static wm0.a a(l33 l33Var) {
        wm0 wm0VarK = l33Var.K();
        return wm0VarK != null ? wm0VarK.f1() : new wm0("").f1();
    }

    public static o83 b(l33 l33Var) {
        wm0 wm0VarK = l33Var.K();
        return wm0VarK != null ? wm0VarK.h1() : new o83(new vf1());
    }

    public static Spliterator c(Iterator it) {
        return Spliterators.spliteratorUnknownSize(it, 273);
    }

    public static Stream d(l33 l33Var, Class cls) {
        return StreamSupport.stream(c(new n33(l33Var, cls)), false);
    }
}
