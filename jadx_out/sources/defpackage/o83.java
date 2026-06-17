package defpackage;

import java.io.StringReader;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class o83 implements Cloneable {
    public final it4 f;
    public y73 g;
    public g83 h;
    public boolean i;
    public ql4 j;
    public final ReentrantLock k;
    public int l;

    public o83(o83 o83Var) {
        this.i = false;
        this.k = new ReentrantLock();
        this.f = o83Var.f.m();
        this.g = new y73(o83Var.g);
        this.h = new g83(o83Var.h);
        this.i = o83Var.i;
        this.l = o83Var.l;
        this.j = new ql4(o83Var.k());
    }

    public static o83 f() {
        return new o83(new vf1());
    }

    public static wm0 i(String str, String str2) {
        vf1 vf1Var = new vf1();
        return vf1Var.q(new StringReader(str), str2, new o83(vf1Var));
    }

    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public o83 clone() {
        return new o83(this);
    }

    public String b() {
        return e().f();
    }

    public y73 c() {
        return this.g;
    }

    public int d() {
        return this.l;
    }

    public it4 e() {
        return this.f;
    }

    public boolean g() {
        return this.g.c() > 0;
    }

    public boolean h() {
        return this.i;
    }

    public g83 j() {
        return this.h;
    }

    public ql4 k() {
        if (this.j == null) {
            this.j = this.f.h();
        }
        return this.j;
    }

    public o83(it4 it4Var) {
        this.i = false;
        this.k = new ReentrantLock();
        this.f = it4Var;
        this.h = it4Var.g();
        this.g = y73.d();
        this.l = it4Var.e();
    }
}
