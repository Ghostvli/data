package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class o02 implements tg3 {
    public final ThreadLocal a = new ThreadLocal();
    public final List b = new ArrayList();

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.tg3
    public void a(String str, Object... objArr) {
        l(3, null, str, objArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.tg3
    public tg3 b(String str) {
        if (str != null) {
            this.a.set(str);
        }
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.tg3
    public void c(String str, Object... objArr) {
        i(null, str, objArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.tg3
    public void d(String str, Object... objArr) {
        l(5, null, str, objArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.tg3
    public void e(String str, Object... objArr) {
        l(4, null, str, objArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.tg3
    public void f(yz1 yz1Var) {
        this.b.add(vy4.a(yz1Var));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.tg3
    public void g(Object obj) {
        l(3, null, vy4.e(obj), new Object[0]);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String h(String str, Object... objArr) {
        return (objArr == null || objArr.length == 0) ? str : String.format(str, objArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void i(Throwable th, String str, Object... objArr) {
        l(6, th, str, objArr);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String j() {
        String str = (String) this.a.get();
        if (str == null) {
            return null;
        }
        this.a.remove();
        return str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public synchronized void k(int i, String str, String str2, Throwable th) {
        if (th != null && str2 != null) {
            try {
                str2 = str2 + " : " + vy4.c(th);
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (th != null && str2 == null) {
            str2 = vy4.c(th);
        }
        if (vy4.d(str2)) {
            str2 = "Empty/NULL log message";
        }
        for (yz1 yz1Var : this.b) {
            if (yz1Var.b(i, str)) {
                yz1Var.a(i, str, str2);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final synchronized void l(int i, Throwable th, String str, Object... objArr) {
        vy4.a(str);
        k(i, j(), h(str, objArr), th);
    }
}
