package defpackage;

import android.content.DialogInterface;
import android.view.View;
import androidx.appcompat.app.a;
import com.fongmi.android.tv.App;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class t85 {
    public final a a;

    /* JADX WARN: Multi-variable type inference failed */
    public t85(View view) {
        a aVarCreate = new o52(App.a()).setView(view).create();
        this.a = aVarCreate;
        aVarCreate.setOnDismissListener((DialogInterface.OnDismissListener) view);
    }

    public void a() {
        this.a.setOnDismissListener(null);
        this.a.dismiss();
    }

    public final void b() {
        this.a.getWindow().setDimAmount(0.0f);
        this.a.show();
    }

    public t85 c() {
        b();
        return this;
    }
}
