package defpackage;

import android.net.Uri;
import android.os.Bundle;
import android.view.accessibility.CaptioningManager;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.d;
import androidx.media3.exoplayer.i;
import androidx.media3.ui.PlayerView;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Drm;
import com.fongmi.android.tv.bean.Sub;
import defpackage.fg2;
import defpackage.hd3;
import defpackage.jq2;
import defpackage.ri0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class ny0 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ String a(String str) {
        return str;
    }

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: ?: TERNARY null = ((wrap:java.lang.String:0x0000: INVOKE (r0v0 android.os.Bundle), (r1v0 java.lang.String) VIRTUAL call: android.os.BaseBundle.getString(java.lang.String):java.lang.String A[MD:(java.lang.String):java.lang.String (c), WRAPPED] (LINE:1)) != (null java.lang.String)) ? true : false */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ boolean b(Bundle bundle, String str) {
        return bundle.getString(str) != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fg2.f c(Drm drm) {
        if (drm == null) {
            return null;
        }
        return new fg2.f.a(drm.getUUID()).p(!kn.d.equals(drm.getUUID())).j(drm.isForceKey()).m(drm.getHeader()).o(drm.getKey()).i();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static i d() {
        return new d.a().b(q24.b() * 50000, q24.b() * 50000, 1000, 2000).a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static jq2.a e() {
        return new tq2();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static ExoPlayer f(int i, hd3.d dVar) {
        ExoPlayer exoPlayerI = new ExoPlayer.b(App.b()).j(d()).m(k()).l(g(p(i))).k(e()).i();
        exoPlayerI.setAudioAttributes(yb.i, true);
        exoPlayerI.a(true);
        exoPlayerI.setPlayWhenReady(true);
        exoPlayerI.addListener(dVar);
        return exoPlayerI;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static lq3 g(int i) {
        return new ch0(App.b()).o(true).p(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fg2.i h(vb3 vb3Var) {
        return new fg2.i.a().f(vb3Var.l()).e(ge3.g(vb3Var.h())).d();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fg2.k i(Sub sub) {
        return new fg2.k.a(Uri.parse(qx4.a(sub.getUrl()))).l(sub.getName()).n(sub.getFormat()).p(sub.getFlag()).m(sub.getLang()).i();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List j(List list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(i((Sub) it.next()));
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static or4 k() {
        ri0 ri0Var = new ri0(App.b());
        ri0.e.a aVarI = ri0Var.I();
        if (q24.K()) {
            aVarI.D0("audio/mp4a-latm");
        }
        aVarI.X(Locale.getDefault().getISO3Language());
        aVarI.J0(q24.M());
        aVarI.A0(true);
        ri0Var.m(aVarI.K());
        return ri0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Map l(fg2 fg2Var) {
        final Bundle bundle = fg2Var.h.c;
        return bundle == null ? new HashMap() : (Map) bundle.keySet().stream().filter(new Predicate() { // from class: ky0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                return ny0.b(bundle, (String) obj);
            }
        }).collect(Collectors.toMap(new Function() { // from class: ly0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return ny0.a((String) obj);
            }
        }, new Function() { // from class: my0
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return bundle.getString((String) obj);
            }
        }));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static cq m() {
        return q24.C() ? cq.a(((CaptioningManager) App.b().getSystemService("captioning")).getUserStyle()) : new cq(-1, 0, 0, 1, -16777216, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static fg2 n(vb3 vb3Var, int i) {
        fg2.c cVarK = new fg2.c().k(vb3Var.l());
        cVarK.i(j(vb3Var.k()));
        cVarK.b(c(vb3Var.f()));
        cVarK.h(h(vb3Var));
        cVarK.f(vb3Var.j());
        cVarK.g(vb3Var.g());
        cVarK.c(15000L);
        cVarK.e(vb3Var.i());
        return cVarK.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String o(int i) {
        if (i == 3003 || i == 3001 || i == 2000) {
            return "application/x-mpegURL";
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int p(int i) {
        return i == 1 ? 1 : 2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void q(PlayerView playerView) {
        playerView.getSubtitleView().setStyle(m());
        playerView.getSubtitleView().setApplyEmbeddedStyles(true);
        playerView.getSubtitleView().setApplyEmbeddedFontSizes(false);
        if (q24.q() != 0.0f) {
            playerView.getSubtitleView().setFractionalTextSize(q24.q());
        }
    }
}
