package defpackage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class c61 extends x51 {
    public final Activity f;
    public final Context g;
    public final Handler h;
    public final int i;
    public final k61 j;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public c61(Activity activity, Context context, Handler handler, int i) {
        this.j = new l61();
        this.f = activity;
        this.g = (Context) hg3.h(context, "context == null");
        this.h = (Handler) hg3.h(handler, "handler == null");
        this.i = i;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Activity e() {
        return this.f;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Context f() {
        return this.g;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Handler g() {
        return this.h;
    }

    public abstract void h(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract Object i();

    public abstract LayoutInflater j();

    public abstract boolean k(String str);

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l(p51 p51Var, Intent intent, int i, Bundle bundle) {
        if (i == -1) {
            c30.k(this.g, intent, bundle);
        } else {
            e04.a("Starting activity with a requestCode requires a FragmentActivity host");
        }
    }

    public abstract void m();

    public c61(u51 u51Var) {
        this(u51Var, u51Var, new Handler(), 0);
    }
}
