package defpackage;

import android.app.Activity;
import android.app.PictureInPictureParams;
import android.app.RemoteAction;
import android.graphics.Rect;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.util.Rational;
import android.view.View;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.receiver.ActionReceiver;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class bb3 {
    public PictureInPictureParams.Builder a;

    public bb3() {
        if (e()) {
            return;
        }
        this.a = ya3.a();
    }

    public static boolean e() {
        return Build.VERSION.SDK_INT < 26 || !App.b().getPackageManager().hasSystemFeature("android.software.picture_in_picture");
    }

    public final RemoteAction a(Activity activity, int i, int i2, String str) {
        ab3.a();
        return za3.a(Icon.createWithResource(activity, i), activity.getString(i2), "", ActionReceiver.a(activity, str));
    }

    public void b(Activity activity, int i, int i2, int i3) {
        try {
            if (!e() && !activity.isInPictureInPictureMode() && q24.A()) {
                if (Build.VERSION.SDK_INT >= 31) {
                    this.a.setSeamlessResizeEnabled(true);
                }
                if (i3 == 1) {
                    this.a.setAspectRatio(new Rational(16, 9));
                } else {
                    PictureInPictureParams.Builder builder = this.a;
                    if (i3 == 2) {
                        builder.setAspectRatio(new Rational(4, 3));
                    } else {
                        builder.setAspectRatio(d(i, i2));
                    }
                }
                activity.enterPictureInPictureMode(this.a.build());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final RemoteAction c(Activity activity, boolean z) {
        return z ? a(activity, el3.c, om3.g, t2.f) : a(activity, el3.d, om3.h, t2.e);
    }

    public final Rational d(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return new Rational(16, 9);
        }
        Rational rational = new Rational(239, 100);
        Rational rational2 = new Rational(100, 239);
        Rational rational3 = new Rational(i, i2);
        return rational3.isInfinite() ? new Rational(16, 9) : rational3.floatValue() > rational.floatValue() ? rational : rational3.floatValue() < rational2.floatValue() ? rational2 : rational3;
    }

    public void f(Activity activity, View view) {
        try {
            if (e()) {
                return;
            }
            Rect rect = new Rect();
            view.getGlobalVisibleRect(rect);
            this.a.setSourceRectHint(rect);
            activity.setPictureInPictureParams(this.a.build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void g(Activity activity, boolean z) {
        try {
            if (e()) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(a(activity, fl3.b, om3.e, t2.g));
            arrayList.add(c(activity, z));
            arrayList.add(a(activity, el3.b, om3.f, t2.c));
            activity.setPictureInPictureParams(this.a.setActions(arrayList).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
