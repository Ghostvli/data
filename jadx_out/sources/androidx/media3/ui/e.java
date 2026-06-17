package androidx.media3.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.media3.ui.SubtitleView;
import defpackage.cq;
import defpackage.fy4;
import defpackage.p50;
import defpackage.qi4;
import defpackage.xf1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends FrameLayout implements SubtitleView.a {
    public final androidx.media3.ui.a f;
    public final WebView g;
    public List h;
    public cq i;
    public float j;
    public int k;
    public float l;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends WebView {
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        @Override // android.webkit.WebView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            super.onTouchEvent(motionEvent);
            return false;
        }

        @Override // android.view.View
        public boolean performClick() {
            super.performClick();
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[Layout.Alignment.values().length];
            a = iArr;
            try {
                iArr[Layout.Alignment.ALIGN_NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[Layout.Alignment.ALIGN_OPPOSITE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[Layout.Alignment.ALIGN_CENTER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public e(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.h = Collections.EMPTY_LIST;
        this.i = cq.g;
        this.j = 0.0533f;
        this.k = 0;
        this.l = 0.08f;
        androidx.media3.ui.a aVar = new androidx.media3.ui.a(context, attributeSet);
        this.f = aVar;
        a aVar2 = new a(context, attributeSet);
        this.g = aVar2;
        aVar2.setBackgroundColor(0);
        aVar2.getSettings().setAllowContentAccess(false);
        addView(aVar);
        addView(aVar2);
    }

    public static int b(int i) {
        if (i != 1) {
            return i != 2 ? 0 : -100;
        }
        return -50;
    }

    public static String c(Layout.Alignment alignment) {
        if (alignment == null) {
            return "center";
        }
        int i = b.a[alignment.ordinal()];
        return i != 1 ? i != 2 ? "center" : "end" : "start";
    }

    public static String d(cq cqVar) {
        int i = cqVar.d;
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "unset" : fy4.M("-0.05em -0.05em 0.15em %s", xf1.b(cqVar.e)) : fy4.M("0.06em 0.08em 0.15em %s", xf1.b(cqVar.e)) : fy4.M("0.1em 0.12em 0.15em %s", xf1.b(cqVar.e)) : fy4.M("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", xf1.b(cqVar.e));
    }

    public static String f(int i) {
        return i != 1 ? i != 2 ? "horizontal-tb" : "vertical-lr" : "vertical-rl";
    }

    public static String h(p50 p50Var) {
        float f = p50Var.q;
        if (f == 0.0f) {
            return "";
        }
        int i = p50Var.p;
        return fy4.M("%s(%.2fdeg)", (i == 2 || i == 1) ? "skewY" : "skewX", Float.valueOf(f));
    }

    @Override // androidx.media3.ui.SubtitleView.a
    public void a(List list, cq cqVar, float f, int i, float f2) {
        this.i = cqVar;
        this.j = f;
        this.k = i;
        this.l = f2;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            p50 p50Var = (p50) list.get(i2);
            if (p50Var.d != null) {
                arrayList.add(p50Var);
            } else {
                arrayList2.add(p50Var);
            }
        }
        if (!this.h.isEmpty() || !arrayList2.isEmpty()) {
            this.h = arrayList2;
            i();
        }
        this.f.a(arrayList, cqVar, f, i, f2);
        invalidate();
    }

    public final String e(int i, float f) {
        float f2 = qi4.f(i, f, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        return f2 == -3.4028235E38f ? "unset" : fy4.M("%.2fpx", Float.valueOf(f2 / getContext().getResources().getDisplayMetrics().density));
    }

    public void g() {
        this.g.destroy();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0125  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void i() {
        /*
            Method dump skipped, instruction units count: 609
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.e.i():void");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (!z || this.h.isEmpty()) {
            return;
        }
        i();
    }

    public e(Context context) {
        this(context, null);
    }
}
