package defpackage;

import android.content.res.AssetManager;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class pe4 extends ab {
    public pe4(AssetManager assetManager, String str) {
        super(assetManager, str);
    }

    @Override // defpackage.t90
    public Class a() {
        return InputStream.class;
    }

    @Override // defpackage.ab
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public void d(InputStream inputStream) throws IOException {
        inputStream.close();
    }

    @Override // defpackage.ab
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public InputStream f(AssetManager assetManager, String str) {
        return assetManager.open(str);
    }
}
