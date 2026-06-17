package defpackage;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import java.io.IOException;
import java.util.Map;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class fi1 {
    public static final Object d = new Object();
    public final Context a;
    public final String b;
    public final Map c;

    public fi1(Drawable.Callback callback, String str, ei1 ei1Var, Map map) {
        if (TextUtils.isEmpty(str) || str.charAt(str.length() - 1) == '/') {
            this.b = str;
        } else {
            this.b = str.concat(ServiceReference.DELIMITER);
        }
        this.c = map;
        d(ei1Var);
        if (callback instanceof View) {
            this.a = ((View) callback).getContext().getApplicationContext();
        } else {
            this.a = null;
        }
    }

    public Bitmap a(String str) {
        l22 l22Var = (l22) this.c.get(str);
        if (l22Var == null) {
            return null;
        }
        Bitmap bitmapB = l22Var.b();
        if (bitmapB != null) {
            return bitmapB;
        }
        Context context = this.a;
        if (context == null) {
            return null;
        }
        String strC = l22Var.c();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strC.startsWith("data:") && strC.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strC.substring(strC.indexOf(44) + 1), 0);
                try {
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options);
                    if (bitmapDecodeByteArray != null) {
                        return c(str, uy4.m(bitmapDecodeByteArray, l22Var.f(), l22Var.d()));
                    }
                    k02.c("Decoded image `" + str + "` is null.");
                    return null;
                } catch (IllegalArgumentException e) {
                    k02.d("Unable to decode image `" + str + "`.", e);
                    return null;
                }
            } catch (IllegalArgumentException e2) {
                k02.d("data URL did not have correct base64 format.", e2);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.b)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            try {
                Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(context.getAssets().open(this.b + strC), null, options);
                if (bitmapDecodeStream != null) {
                    return c(str, uy4.m(bitmapDecodeStream, l22Var.f(), l22Var.d()));
                }
                k02.c("Decoded image `" + str + "` is null.");
                return null;
            } catch (IllegalArgumentException e3) {
                k02.d("Unable to decode image `" + str + "`.", e3);
                return null;
            }
        } catch (IOException e4) {
            k02.d("Unable to open asset.", e4);
            return null;
        }
    }

    public boolean b(Context context) {
        Context context2 = this.a;
        if (context == null) {
            return context2 == null;
        }
        if (context2 instanceof Application) {
            context = context.getApplicationContext();
        }
        return context == this.a;
    }

    public final Bitmap c(String str, Bitmap bitmap) {
        synchronized (d) {
            ((l22) this.c.get(str)).g(bitmap);
        }
        return bitmap;
    }

    public void d(ei1 ei1Var) {
    }
}
