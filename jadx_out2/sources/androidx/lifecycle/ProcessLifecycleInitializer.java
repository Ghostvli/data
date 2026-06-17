package androidx.lifecycle;

import android.content.Context;
import androidx.lifecycle.n;
import defpackage.bk1;
import defpackage.bt1;
import defpackage.e04;
import defpackage.ow;
import defpackage.v9;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ProcessLifecycleInitializer implements bk1 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: create(Landroid/content/Context;)Ljava/lang/Object; */
    @Override // defpackage.bk1
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public bt1 create(Context context) {
        context.getClass();
        v9 v9VarE = v9.e(context);
        v9VarE.getClass();
        if (!v9VarE.g(ProcessLifecycleInitializer.class)) {
            e04.a("ProcessLifecycleInitializer cannot be initialized lazily.\n               Please ensure that you have:\n               <meta-data\n                   android:name='androidx.lifecycle.ProcessLifecycleInitializer'\n                   android:value='androidx.startup' />\n               under InitializationProvider in your AndroidManifest.xml");
            return null;
        }
        h.a(context);
        n.b bVar = n.n;
        bVar.b(context);
        return bVar.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.bk1
    public List dependencies() {
        return ow.j();
    }
}
