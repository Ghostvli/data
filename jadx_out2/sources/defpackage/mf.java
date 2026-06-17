package defpackage;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.a;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class mf implements ds3 {
    public final List a;
    public final jf b;
    public final ma c;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public mf(List list, jf jfVar, ma maVar) {
        this.a = list;
        this.b = (jf) fg3.e(jfVar);
        this.c = (ma) fg3.e(maVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: b(Ljava/lang/Object;IILu63;)Lyr3; */
    @Override // defpackage.ds3
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public yr3 b(InputStream inputStream, int i, int i2, u63 u63Var) {
        return this.b.b(bn.b(inputStream), i, i2, u63Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;Lu63;)Z */
    @Override // defpackage.ds3
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(InputStream inputStream, u63 u63Var) {
        ImageHeaderParser.ImageType imageTypeF = a.f(this.a, inputStream, this.c);
        return imageTypeF.equals(ImageHeaderParser.ImageType.AVIF) || imageTypeF.equals(ImageHeaderParser.ImageType.ANIMATED_AVIF);
    }
}
