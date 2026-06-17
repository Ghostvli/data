package defpackage;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class cp4 extends ts3 {
    public final WeakReference b;

    public cp4(Context context, Resources resources) {
        super(resources);
        this.b = new WeakReference(context);
    }

    @Override // android.content.res.Resources
    public Drawable getDrawable(int i) {
        Drawable drawableA = a(i);
        Context context = (Context) this.b.get();
        if (drawableA != null && context != null) {
            ls3.g().w(context, i, drawableA);
        }
        return drawableA;
    }
}
