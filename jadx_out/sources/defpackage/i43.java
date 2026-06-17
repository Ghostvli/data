package defpackage;

import android.R;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.Toast;
import com.fongmi.android.tv.App;
import defpackage.d43;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class i43 {
    public androidx.appcompat.app.a a;
    public Toast b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public static volatile i43 a = new i43();
    }

    public static void b() {
        h43.d(App.b()).b(new d43.c("default", 2).b("TV").a());
    }

    public static void c() {
        try {
            if (d().a != null) {
                d().a.dismiss();
            }
        } catch (Exception unused) {
        }
    }

    public static i43 d() {
        return a.a;
    }

    public static String e(int i, Throwable th) {
        if (TextUtils.isEmpty(th.getMessage())) {
            return vr3.l(i);
        }
        return vr3.l(i) + "\n" + th.getMessage();
    }

    public static void g(Context context) {
        c();
        d().a(context);
    }

    public static void h(int i) {
        if (i != 0) {
            i(vr3.l(i));
        }
    }

    public static void i(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d().f(str);
    }

    public final void a(Context context) {
        androidx.appcompat.app.a aVarCreate = new o52(context).setView(q45.c(LayoutInflater.from(context)).getRoot()).create();
        this.a = aVarCreate;
        aVarCreate.getWindow().setBackgroundDrawableResource(R.color.transparent);
        this.a.show();
    }

    public final void f(String str) {
        Toast toast = this.b;
        if (toast != null) {
            toast.cancel();
        }
        Toast toastMakeText = Toast.makeText(App.b(), str, 1);
        this.b = toastMakeText;
        toastMakeText.show();
    }
}
