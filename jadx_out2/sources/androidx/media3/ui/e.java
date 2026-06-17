package androidx.media3.ui;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.util.Base64;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.FrameLayout;
import androidx.media3.ui.SubtitleView;
import androidx.media3.ui.c;
import defpackage.cq;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.p50;
import defpackage.qi4;
import defpackage.xf1;
import fi.iki.elonen.NanoHTTPD;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.webkit.WebView, android.view.View
        public boolean onTouchEvent(MotionEvent motionEvent) {
            super.onTouchEvent(motionEvent);
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.View
        public boolean performClick() {
            super.performClick();
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int b(int i) {
        if (i != 1) {
            return i != 2 ? 0 : -100;
        }
        return -50;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String c(Layout.Alignment alignment) {
        if (alignment == null) {
            return "center";
        }
        int i = b.a[alignment.ordinal()];
        return i != 1 ? i != 2 ? "center" : "end" : "start";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String d(cq cqVar) {
        int i = cqVar.d;
        return i != 1 ? i != 2 ? i != 3 ? i != 4 ? "unset" : fy4.M("-0.05em -0.05em 0.15em %s", xf1.b(cqVar.e)) : fy4.M("0.06em 0.08em 0.15em %s", xf1.b(cqVar.e)) : fy4.M("0.1em 0.12em 0.15em %s", xf1.b(cqVar.e)) : fy4.M("1px 1px 0 %1$s, 1px -1px 0 %1$s, -1px 1px 0 %1$s, -1px -1px 0 %1$s", xf1.b(cqVar.e));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String f(int i) {
        return i != 1 ? i != 2 ? "horizontal-tb" : "vertical-lr" : "vertical-rl";
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static String h(p50 p50Var) {
        float f = p50Var.q;
        if (f == 0.0f) {
            return "";
        }
        int i = p50Var.p;
        return fy4.M("%s(%.2fdeg)", (i == 2 || i == 1) ? "skewY" : "skewX", Float.valueOf(f));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final String e(int i, float f) {
        float f2 = qi4.f(i, f, getHeight(), (getHeight() - getPaddingTop()) - getPaddingBottom());
        return f2 == -3.4028235E38f ? "unset" : fy4.M("%.2fpx", Float.valueOf(f2 / getContext().getResources().getDisplayMetrics().density));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g() {
        this.g.destroy();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
    */
    public final void i() {
        float f;
        String strM;
        int iB;
        boolean z;
        String str;
        int i;
        String str2;
        Object obj;
        String str3;
        Layout.Alignment alignment;
        StringBuilder sb = new StringBuilder();
        float f2 = 1.2f;
        sb.append(fy4.M("<body><div style='-webkit-user-select:none;position:fixed;top:0;bottom:0;left:0;right:0;color:%s;font-size:%s;line-height:%.2f;text-shadow:%s;'>", xf1.b(this.i.a), e(this.k, this.j), Float.valueOf(1.2f), d(this.i)));
        HashMap map = new HashMap();
        map.put(xf1.a("default_bg"), fy4.M("background-color:%s;", xf1.b(this.i.b)));
        int i2 = 0;
        while (i2 < this.h.size()) {
            p50 p50Var = (p50) this.h.get(i2);
            float f3 = p50Var.h;
            float f4 = f3 != -3.4028235E38f ? f3 * 100.0f : 50.0f;
            int iB2 = b(p50Var.i);
            float f5 = p50Var.e;
            float f6 = f2;
            if (f5 == -3.4028235E38f) {
                f = -3.4028235E38f;
                strM = fy4.M("%.2f%%", Float.valueOf((1.0f - this.l) * 100.0f));
                iB = -100;
                z = false;
            } else if (p50Var.f != 1) {
                String strM2 = fy4.M("%.2f%%", Float.valueOf(f5 * 100.0f));
                int i3 = p50Var.p;
                int i4 = p50Var.g;
                iB = i3 == 1 ? -b(i4) : b(i4);
                f = -3.4028235E38f;
                str = strM2;
                z = false;
                float f7 = p50Var.j;
                String strM3 = f7 == f ? fy4.M("%.2f%%", Float.valueOf(f7 * 100.0f)) : "fit-content";
                String strC = c(p50Var.b);
                String strF = f(p50Var.p);
                String strE = e(p50Var.n, p50Var.o);
                String strB = xf1.b(!p50Var.l ? p50Var.m : this.i.c);
                i = p50Var.p;
                String str4 = "right";
                if (i != 1) {
                    if (z) {
                    }
                    str2 = str4;
                    obj = "top";
                } else if (i != 2) {
                    obj = "left";
                    str2 = z ? "bottom" : "top";
                } else {
                    if (!z) {
                        str4 = "left";
                    }
                    str2 = str4;
                    obj = "top";
                }
                if (i != 2 || i == 1) {
                    str3 = "height";
                    int i5 = iB;
                    iB = iB2;
                    iB2 = i5;
                } else {
                    str3 = "width";
                }
                String str5 = str3;
                c.b bVarA = c.a(p50Var.a, getContext().getResources().getDisplayMetrics().density);
                for (String str6 : map.keySet()) {
                    String str7 = (String) map.put(str6, (String) map.get(str6));
                    gg3.v(str7 == null || str7.equals(map.get(str6)));
                }
                sb.append(fy4.M("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", Integer.valueOf(i2), obj, Float.valueOf(f4), str2, str, str5, strM3, strC, strF, strE, strB, Integer.valueOf(iB2), Integer.valueOf(iB), h(p50Var)));
                sb.append(fy4.M("<span class='%s'>", "default_bg"));
                alignment = p50Var.c;
                if (alignment == null) {
                    sb.append(fy4.M("<span style='display:inline-block; text-align:%s;'>", c(alignment)));
                    sb.append(bVarA.a);
                    sb.append("</span>");
                } else {
                    sb.append(bVarA.a);
                }
                sb.append("</span></div>");
                i2++;
                f2 = f6;
            } else {
                f = -3.4028235E38f;
                if (f5 >= 0.0f) {
                    strM = fy4.M("%.2fem", Float.valueOf(f5 * f6));
                    z = false;
                    iB = 0;
                } else {
                    strM = fy4.M("%.2fem", Float.valueOf(((-f5) - 1.0f) * f6));
                    iB = 0;
                    z = true;
                }
            }
            str = strM;
            float f72 = p50Var.j;
            String strM32 = f72 == f ? fy4.M("%.2f%%", Float.valueOf(f72 * 100.0f)) : "fit-content";
            String strC2 = c(p50Var.b);
            String strF2 = f(p50Var.p);
            String strE2 = e(p50Var.n, p50Var.o);
            String strB2 = xf1.b(!p50Var.l ? p50Var.m : this.i.c);
            i = p50Var.p;
            String str42 = "right";
            if (i != 1) {
            }
            if (i != 2) {
                str3 = "height";
                int i52 = iB;
                iB = iB2;
                iB2 = i52;
            }
            String str52 = str3;
            c.b bVarA2 = c.a(p50Var.a, getContext().getResources().getDisplayMetrics().density);
            while (r10.hasNext()) {
            }
            sb.append(fy4.M("<div style='position:absolute;z-index:%s;%s:%.2f%%;%s:%s;%s:%s;text-align:%s;writing-mode:%s;font-size:%s;background-color:%s;transform:translate(%s%%,%s%%)%s;'>", Integer.valueOf(i2), obj, Float.valueOf(f4), str2, str, str52, strM32, strC2, strF2, strE2, strB2, Integer.valueOf(iB2), Integer.valueOf(iB), h(p50Var)));
            sb.append(fy4.M("<span class='%s'>", "default_bg"));
            alignment = p50Var.c;
            if (alignment == null) {
            }
            sb.append("</span></div>");
            i2++;
            f2 = f6;
        }
        sb.append("</div></body></html>");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<html><head><style>");
        for (String str8 : map.keySet()) {
            sb2.append(str8);
            sb2.append("{");
            sb2.append((String) map.get(str8));
            sb2.append("}");
        }
        sb2.append("</style></head>");
        sb.insert(0, (CharSequence) sb2);
        this.g.loadData(Base64.encodeToString(sb.toString().getBytes(StandardCharsets.UTF_8), 1), NanoHTTPD.MIME_HTML, "base64");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
