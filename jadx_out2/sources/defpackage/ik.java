package defpackage;

import android.graphics.Bitmap;
import android.widget.ImageView;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ik extends qi1 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ik(ImageView imageView) {
        super(imageView);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: q(Ljava/lang/Object;)V */
    @Override // defpackage.qi1
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public void q(Bitmap bitmap) {
        ((ImageView) this.f).setImageBitmap(bitmap);
    }
}
