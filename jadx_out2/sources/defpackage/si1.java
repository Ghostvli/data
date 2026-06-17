package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.widget.ImageView;
import com.github.catvod.utils.Json;
import defpackage.hm4;
import defpackage.hs1;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class si1 {
    public static final Set a = Collections.synchronizedSet(new HashSet());

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements jr3 {
        public final /* synthetic */ ImageView f;
        public final /* synthetic */ String g;
        public final /* synthetic */ boolean h;
        public final /* synthetic */ String i;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(ImageView imageView, String str, boolean z, String str2) {
            this.f = imageView;
            this.g = str;
            this.h = z;
            this.i = str2;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: e(Ljava/lang/Object;Ljava/lang/Object;Lrl4;Lba0;Z)Z */
        @Override // defpackage.jr3
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean e(Drawable drawable, Object obj, rl4 rl4Var, ba0 ba0Var, boolean z) {
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.jr3
        public boolean c(ja1 ja1Var, Object obj, rl4 rl4Var, boolean z) {
            this.f.setImageDrawable(si1.e(this.g, this.h));
            si1.a.add(this.i);
            return true;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void c(hs1.a aVar, String str) {
        for (Map.Entry<String, String> entry : Json.toMap(Json.parse(str)).entrySet()) {
            aVar.b(qx4.b(entry.getKey()), entry.getValue());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static jr3 d(String str, String str2, ImageView imageView, boolean z) {
        return new a(imageView, str, z, str2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Drawable e(String str, boolean z) {
        hm4.a aVar = new hm4.a();
        String strSubstring = TextUtils.isEmpty(str) ? "！" : str.substring(0, 1);
        if (z) {
            aVar.c(strSubstring, ax.a(strSubstring));
        }
        return aVar.d(strSubstring, ax.a(strSubstring), vr3.a(4));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Object f(String str) {
        String str2;
        String strA = qx4.a(str);
        if (strA.startsWith("data:")) {
            return strA;
        }
        hs1.a aVar = new hs1.a();
        if (strA.contains("@Headers=")) {
            str2 = strA.split("@Headers=")[1].split("@")[0];
            c(aVar, str2);
        } else {
            str2 = null;
        }
        if (strA.contains("@Cookie=")) {
            str2 = strA.split("@Cookie=")[1].split("@")[0];
            aVar.b("Cookie", str2);
        }
        if (strA.contains("@Referer=")) {
            str2 = strA.split("@Referer=")[1].split("@")[0];
            aVar.b("Referer", str2);
        }
        if (strA.contains("@User-Agent=")) {
            str2 = strA.split("@User-Agent=")[1].split("@")[0];
            aVar.b("User-Agent", str2);
        }
        if (str2 != null) {
            strA = strA.split("@")[0];
        }
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        return new ra1(strA, aVar.c());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void g(Context context, String str, v60 v60Var) {
        try {
            ((br3) ((br3) com.bumptech.glide.a.t(context).t(f(str)).V(vr3.j(), vr3.g())).i(fl3.a)).s0(v60Var);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void h(String str, String str2, ImageView imageView) {
        i(str, str2, imageView, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void i(String str, String str2, ImageView imageView, boolean z) {
        imageView.setScaleType(z ? ImageView.ScaleType.CENTER_CROP : ImageView.ScaleType.FIT_CENTER);
        if (!z) {
            imageView.setVisibility(TextUtils.isEmpty(str2) ? 8 : 0);
        }
        if (TextUtils.isEmpty(str2) || a.contains(str2)) {
            imageView.setImageDrawable(e(str, z));
            return;
        }
        try {
            br3 br3VarX0 = com.bumptech.glide.a.u(imageView).t(f(str2)).x0(d(str, str2, imageView, z));
            if (z) {
                ((br3) br3VarX0.c()).v0(imageView);
            } else {
                ((br3) br3VarX0.j()).v0(imageView);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void j(ImageView imageView) {
        try {
            ((br3) ((br3) ((br3) com.bumptech.glide.a.u(imageView).u(qx4.a(b75.I().i().getLogo())).d()).V(Integer.MIN_VALUE, Integer.MIN_VALUE)).i(fl3.p)).v0(imageView);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
