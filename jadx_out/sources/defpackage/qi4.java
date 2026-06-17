package defpackage;

import android.text.Spannable;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import defpackage.p50;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class qi4 {
    public static /* synthetic */ boolean a(Object obj) {
        return (obj instanceof AbsoluteSizeSpan) || (obj instanceof RelativeSizeSpan);
    }

    public static /* synthetic */ boolean b(Object obj) {
        return !(obj instanceof wr1);
    }

    public static void c(p50.b bVar) {
        bVar.b();
        if (bVar.e() instanceof Spanned) {
            if (!(bVar.e() instanceof Spannable)) {
                bVar.o(SpannableString.valueOf(bVar.e()));
            }
            e((Spannable) gg3.q(bVar.e()), new ig3() { // from class: oi4
                @Override // defpackage.ig3
                public final boolean apply(Object obj) {
                    return qi4.b(obj);
                }
            });
        }
        d(bVar);
    }

    public static void d(p50.b bVar) {
        bVar.q(-3.4028235E38f, Integer.MIN_VALUE);
        if (bVar.e() instanceof Spanned) {
            if (!(bVar.e() instanceof Spannable)) {
                bVar.o(SpannableString.valueOf(bVar.e()));
            }
            e((Spannable) gg3.q(bVar.e()), new ig3() { // from class: pi4
                @Override // defpackage.ig3
                public final boolean apply(Object obj) {
                    return qi4.a(obj);
                }
            });
        }
    }

    public static void e(Spannable spannable, ig3 ig3Var) {
        for (Object obj : spannable.getSpans(0, spannable.length(), Object.class)) {
            if (ig3Var.apply(obj)) {
                spannable.removeSpan(obj);
            }
        }
    }

    public static float f(int i, float f, int i2, int i3) {
        float f2;
        if (f == -3.4028235E38f) {
            return -3.4028235E38f;
        }
        if (i == 0) {
            f2 = i3;
        } else {
            if (i != 1) {
                if (i != 2) {
                    return -3.4028235E38f;
                }
                return f;
            }
            f2 = i2;
        }
        return f * f2;
    }
}
