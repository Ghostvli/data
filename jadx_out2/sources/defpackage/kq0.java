package defpackage;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.view.View;
import android.view.Window;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class kq0 {
    public static final int a = Color.argb(230, 255, 255, 255);
    public static final int b = Color.argb(128, 27, 27, 27);
    public static oq0 c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void a(iy iyVar, kk4 kk4Var, kk4 kk4Var2) {
        iyVar.getClass();
        kk4Var.getClass();
        kk4Var2.getClass();
        View decorView = iyVar.getWindow().getDecorView();
        decorView.getClass();
        Function1 function1C = kk4Var.c();
        Resources resources = decorView.getResources();
        resources.getClass();
        boolean zBooleanValue = ((Boolean) function1C.invoke(resources)).booleanValue();
        Function1 function1C2 = kk4Var2.c();
        Resources resources2 = decorView.getResources();
        resources2.getClass();
        boolean zBooleanValue2 = ((Boolean) function1C2.invoke(resources2)).booleanValue();
        oq0 nq0Var = c;
        if (nq0Var == null) {
            int i = Build.VERSION.SDK_INT;
            nq0Var = i >= 29 ? new nq0() : i >= 26 ? new mq0() : new lq0();
        }
        oq0 oq0Var = nq0Var;
        Window window = iyVar.getWindow();
        window.getClass();
        oq0Var.a(kk4Var, kk4Var2, window, decorView, zBooleanValue, zBooleanValue2);
    }
}
