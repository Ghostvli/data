package defpackage;

import android.content.res.AssetManager;
import android.util.Log;
import defpackage.t90;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ab implements t90 {
    public final String f;
    public final AssetManager g;
    public Object h;

    public ab(AssetManager assetManager, String str) {
        this.g = assetManager;
        this.f = str;
    }

    @Override // defpackage.t90
    public void b() {
        Object obj = this.h;
        if (obj == null) {
            return;
        }
        try {
            d(obj);
        } catch (IOException unused) {
        }
    }

    @Override // defpackage.t90
    public void c(ug3 ug3Var, t90.a aVar) {
        try {
            Object objF = f(this.g, this.f);
            this.h = objF;
            aVar.f(objF);
        } catch (IOException e) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e);
            }
            aVar.d(e);
        }
    }

    @Override // defpackage.t90
    public void cancel() {
    }

    public abstract void d(Object obj);

    @Override // defpackage.t90
    public ba0 e() {
        return ba0.LOCAL;
    }

    public abstract Object f(AssetManager assetManager, String str);
}
