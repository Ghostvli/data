package defpackage;

import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class y73 extends ArrayList {
    public final int f;
    public final int g;

    public y73(int i, int i2) {
        super(i);
        this.f = i;
        this.g = i2;
    }

    public static y73 d() {
        return new y73(0, 0);
    }

    public boolean b() {
        return size() < this.g;
    }

    public int c() {
        return this.g;
    }

    @Override // java.util.ArrayList
    public Object clone() {
        return super.clone();
    }

    public y73(y73 y73Var) {
        this(y73Var.f, y73Var.g);
    }
}
