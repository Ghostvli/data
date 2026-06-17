package defpackage;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class a41 {
    public final AssetManager d;
    public final ow2 a = new ow2();
    public final Map b = new HashMap();
    public final Map c = new HashMap();
    public String e = ".ttf";

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public a41(Drawable.Callback callback, z31 z31Var) {
        if (callback instanceof View) {
            this.d = ((View) callback).getContext().getAssets();
        } else {
            k02.c("LottieDrawable must be inside of a view for images to work.");
            this.d = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Typeface a(y31 y31Var) {
        String strA = y31Var.a();
        Typeface typeface = (Typeface) this.c.get(strA);
        if (typeface != null) {
            return typeface;
        }
        y31Var.c();
        y31Var.b();
        if (y31Var.d() != null) {
            return y31Var.d();
        }
        Typeface typefaceCreateFromAsset = Typeface.createFromAsset(this.d, "fonts/" + strA + this.e);
        this.c.put(strA, typefaceCreateFromAsset);
        return typefaceCreateFromAsset;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Typeface b(y31 y31Var) {
        this.a.b(y31Var.a(), y31Var.c());
        Typeface typeface = (Typeface) this.b.get(this.a);
        if (typeface != null) {
            return typeface;
        }
        Typeface typefaceE = e(a(y31Var), y31Var.c());
        this.b.put(this.a, typefaceE);
        return typefaceE;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void c(String str) {
        this.e = str;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d(z31 z31Var) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Typeface e(Typeface typeface, String str) {
        boolean zContains = str.contains("Italic");
        boolean zContains2 = str.contains("Bold");
        int i = (zContains && zContains2) ? 3 : zContains ? 2 : zContains2 ? 1 : 0;
        return typeface.getStyle() == i ? typeface : Typeface.create(typeface, i);
    }
}
