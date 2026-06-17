package defpackage;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.appcompat.view.menu.e;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.ViewStubCompat;
import androidx.lifecycle.g;
import defpackage.bj4;
import defpackage.ps3;
import defpackage.v2;
import defpackage.xq1;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import okio.internal.Buffer;
import org.mozilla.javascript.Token;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class j8 extends h8 implements e.a, LayoutInflater.Factory2 {
    public static final x64 o0 = new x64();
    public static final boolean p0 = false;
    public static final int[] q0 = {R.attr.windowBackground};
    public static final boolean r0 = !"robolectric".equals(Build.FINGERPRINT);
    public ActionBarContextView A;
    public PopupWindow B;
    public Runnable C;
    public s45 D;
    public boolean E;
    public boolean F;
    public ViewGroup G;
    public TextView H;
    public View I;
    public boolean J;
    public boolean K;
    public boolean L;
    public boolean M;
    public boolean N;
    public boolean O;
    public boolean P;
    public boolean Q;
    public r[] R;
    public r S;
    public boolean T;
    public boolean U;
    public boolean V;
    public boolean W;
    public Configuration X;
    public int Y;
    public int Z;
    public int a0;
    public boolean b0;
    public o c0;
    public o d0;
    public boolean e0;
    public int f0;
    public final Runnable g0;
    public boolean h0;
    public Rect i0;
    public Rect j0;
    public n9 k0;
    public as1 l0;
    public OnBackInvokedDispatcher m0;
    public OnBackInvokedCallback n0;
    public final Object o;
    public final Context p;
    public Window q;
    public m r;
    public final b8 s;
    public q2 t;
    public MenuInflater u;
    public CharSequence v;
    public nb0 w;
    public g x;
    public s y;
    public v2 z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements Runnable {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            j8 j8Var = j8.this;
            if ((j8Var.f0 & 1) != 0) {
                j8Var.g0(0);
            }
            j8 j8Var2 = j8.this;
            if ((j8Var2.f0 & Buffer.SEGMENTING_THRESHOLD) != 0) {
                j8Var2.g0(Token.ASSIGN_ADD);
            }
            j8 j8Var3 = j8.this;
            j8Var3.e0 = false;
            j8Var3.f0 = 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements d63 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.d63
        public w95 a(View view, w95 w95Var) {
            int iL = w95Var.l();
            int iD1 = j8.this.d1(w95Var, null);
            if (iL != iD1) {
                w95Var = w95Var.p(w95Var.j(), iD1, w95Var.k(), w95Var.i());
            }
            return l35.T(view, w95Var);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements ContentFrameLayout.a {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.widget.ContentFrameLayout.a
        public void onDetachedFromWindow() {
            j8.this.e0();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d implements Runnable {

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a extends v45 {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a() {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.u45
            public void b(View view) {
                j8.this.A.setAlpha(1.0f);
                j8.this.D.g(null);
                j8.this.D = null;
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.v45, defpackage.u45
            public void c(View view) {
                j8.this.A.setVisibility(0);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public d() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // java.lang.Runnable
        public void run() {
            j8 j8Var = j8.this;
            j8Var.B.showAtLocation(j8Var.A, 55, 0, 0);
            j8.this.h0();
            boolean zS0 = j8.this.S0();
            j8 j8Var2 = j8.this;
            if (!zS0) {
                j8Var2.A.setAlpha(1.0f);
                j8.this.A.setVisibility(0);
            } else {
                j8Var2.A.setAlpha(0.0f);
                j8 j8Var3 = j8.this;
                j8Var3.D = l35.e(j8Var3.A).b(1.0f);
                j8.this.D.g(new a());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e extends v45 {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.u45
        public void b(View view) {
            j8.this.A.setAlpha(1.0f);
            j8.this.D.g(null);
            j8.this.D = null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.v45, defpackage.u45
        public void c(View view) {
            j8.this.A.setVisibility(0);
            if (j8.this.A.getParent() instanceof View) {
                l35.d0((View) j8.this.A.getParent());
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface f {
        boolean a(int i);

        View onCreatePanelView(int i);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class g implements i.a {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.view.menu.i.a
        public void b(androidx.appcompat.view.menu.e eVar, boolean z) {
            j8.this.X(eVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.view.menu.i.a
        public boolean c(androidx.appcompat.view.menu.e eVar) {
            Window.Callback callbackT0 = j8.this.t0();
            if (callbackT0 == null) {
                return true;
            }
            callbackT0.onMenuOpened(Token.ASSIGN_ADD, eVar);
            return true;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class h implements v2.a {
        public v2.a a;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a extends v45 {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a() {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // defpackage.u45
            public void b(View view) {
                j8.this.A.setVisibility(8);
                j8 j8Var = j8.this;
                PopupWindow popupWindow = j8Var.B;
                if (popupWindow != null) {
                    popupWindow.dismiss();
                } else if (j8Var.A.getParent() instanceof View) {
                    l35.d0((View) j8.this.A.getParent());
                }
                j8.this.A.k();
                j8.this.D.g(null);
                j8 j8Var2 = j8.this;
                j8Var2.D = null;
                l35.d0(j8Var2.G);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public h(v2.a aVar) {
            this.a = aVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v2.a
        public boolean a(v2 v2Var, MenuItem menuItem) {
            return this.a.a(v2Var, menuItem);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v2.a
        public void b(v2 v2Var) {
            this.a.b(v2Var);
            j8 j8Var = j8.this;
            if (j8Var.B != null) {
                j8Var.q.getDecorView().removeCallbacks(j8.this.C);
            }
            j8 j8Var2 = j8.this;
            if (j8Var2.A != null) {
                j8Var2.h0();
                j8 j8Var3 = j8.this;
                j8Var3.D = l35.e(j8Var3.A).b(0.0f);
                j8.this.D.g(new a());
            }
            j8 j8Var4 = j8.this;
            b8 b8Var = j8Var4.s;
            if (b8Var != null) {
                b8Var.G(j8Var4.z);
            }
            j8 j8Var5 = j8.this;
            j8Var5.z = null;
            l35.d0(j8Var5.G);
            j8.this.b1();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v2.a
        public boolean c(v2 v2Var, Menu menu) {
            return this.a.c(v2Var, menu);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // v2.a
        public boolean d(v2 v2Var, Menu menu) {
            l35.d0(j8.this.G);
            return this.a.d(v2Var, menu);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class i {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static String b(Locale locale) {
            return locale.toLanguageTag();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class j {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (locales.equals(locales2)) {
                return;
            }
            configuration3.setLocales(locales2);
            configuration3.locale = configuration2.locale;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static jz1 b(Configuration configuration) {
            return jz1.b(configuration.getLocales().toLanguageTags());
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void c(jz1 jz1Var) {
            LocaleList.setDefault(LocaleList.forLanguageTags(jz1Var.g()));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void d(Configuration configuration, jz1 jz1Var) {
            configuration.setLocales(LocaleList.forLanguageTags(jz1Var.g()));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class k {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            int i = configuration.colorMode & 3;
            int i2 = configuration2.colorMode;
            if (i != (i2 & 3)) {
                configuration3.colorMode |= i2 & 3;
            }
            int i3 = configuration.colorMode & 12;
            int i4 = configuration2.colorMode;
            if (i3 != (i4 & 12)) {
                configuration3.colorMode |= i4 & 12;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class l {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static OnBackInvokedDispatcher a(Activity activity) {
            return activity.getOnBackInvokedDispatcher();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static OnBackInvokedCallback b(Object obj, final j8 j8Var) {
            Objects.requireNonNull(j8Var);
            OnBackInvokedCallback onBackInvokedCallback = new OnBackInvokedCallback() { // from class: o8
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                public final void onBackInvoked() {
                    j8Var.B0();
                }
            };
            n8.a(obj).registerOnBackInvokedCallback(1000000, onBackInvokedCallback);
            return onBackInvokedCallback;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void c(Object obj, Object obj2) {
            n8.a(obj).unregisterOnBackInvokedCallback(m8.a(obj2));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class n extends o {
        public final PowerManager c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public n(Context context) {
            super();
            this.c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // j8.o
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // j8.o
        public int c() {
            return i.a(this.c) ? 2 : 1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // j8.o
        public void d() {
            j8.this.R();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public abstract class o {
        public BroadcastReceiver a;

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a extends BroadcastReceiver {
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            public a() {
            }

            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                o.this.d();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public o() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a() {
            BroadcastReceiver broadcastReceiver = this.a;
            if (broadcastReceiver != null) {
                try {
                    j8.this.p.unregisterReceiver(broadcastReceiver);
                } catch (IllegalArgumentException unused) {
                }
                this.a = null;
            }
        }

        public abstract IntentFilter b();

        public abstract int c();

        public abstract void d();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void e() {
            a();
            IntentFilter intentFilterB = b();
            if (intentFilterB == null || intentFilterB.countActions() == 0) {
                return;
            }
            if (this.a == null) {
                this.a = new a();
            }
            j8.this.p.registerReceiver(this.a, intentFilterB);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class p extends o {
        public final hu4 c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public p(hu4 hu4Var) {
            super();
            this.c = hu4Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // j8.o
        public IntentFilter b() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // j8.o
        public int c() {
            return this.c.d() ? 2 : 1;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // j8.o
        public void d() {
            j8.this.R();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class q extends ContentFrameLayout {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public q(Context context) {
            super(context);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean b(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.ViewGroup, android.view.View
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return j8.this.f0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.ViewGroup
        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !b((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            j8.this.Z(0);
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.View
        public void setBackgroundResource(int i) {
            setBackgroundDrawable(e9.b(getContext(), i));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class r {
        public int a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;
        public ViewGroup g;
        public View h;
        public View i;
        public androidx.appcompat.view.menu.e j;
        public androidx.appcompat.view.menu.c k;
        public Context l;
        public boolean m;
        public boolean n;
        public boolean o;
        public boolean p;
        public boolean q = false;
        public boolean r;
        public Bundle s;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public r(int i) {
            this.a = i;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public androidx.appcompat.view.menu.j a(i.a aVar) {
            if (this.j == null) {
                return null;
            }
            if (this.k == null) {
                androidx.appcompat.view.menu.c cVar = new androidx.appcompat.view.menu.c(this.l, hm3.j);
                this.k = cVar;
                cVar.g(aVar);
                this.j.b(this.k);
            }
            return this.k.h(this.g);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean b() {
            if (this.h == null) {
                return false;
            }
            return this.i != null || this.k.a().getCount() > 0;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c(androidx.appcompat.view.menu.e eVar) {
            androidx.appcompat.view.menu.c cVar;
            androidx.appcompat.view.menu.e eVar2 = this.j;
            if (eVar == eVar2) {
                return;
            }
            if (eVar2 != null) {
                eVar2.R(this.k);
            }
            this.j = eVar;
            if (eVar == null || (cVar = this.k) == null) {
                return;
            }
            eVar.b(cVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme themeNewTheme = context.getResources().newTheme();
            themeNewTheme.setTo(context.getTheme());
            themeNewTheme.resolveAttribute(nk3.a, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                themeNewTheme.applyStyle(i, true);
            }
            themeNewTheme.resolveAttribute(nk3.E, typedValue, true);
            int i2 = typedValue.resourceId;
            if (i2 != 0) {
                themeNewTheme.applyStyle(i2, true);
            } else {
                themeNewTheme.applyStyle(zm3.c, true);
            }
            e30 e30Var = new e30(context, 0);
            e30Var.getTheme().setTo(themeNewTheme);
            this.l = e30Var;
            TypedArray typedArrayObtainStyledAttributes = e30Var.obtainStyledAttributes(mn3.v0);
            this.b = typedArrayObtainStyledAttributes.getResourceId(mn3.y0, 0);
            this.f = typedArrayObtainStyledAttributes.getResourceId(mn3.x0, 0);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class s implements i.a {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public s() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.view.menu.i.a
        public void b(androidx.appcompat.view.menu.e eVar, boolean z) {
            androidx.appcompat.view.menu.e eVarF = eVar.F();
            boolean z2 = eVarF != eVar;
            j8 j8Var = j8.this;
            if (z2) {
                eVar = eVarF;
            }
            r rVarK0 = j8Var.k0(eVar);
            if (rVarK0 != null) {
                j8 j8Var2 = j8.this;
                if (!z2) {
                    j8Var2.a0(rVarK0, z);
                } else {
                    j8Var2.W(rVarK0.a, rVarK0, eVarF);
                    j8.this.a0(rVarK0, true);
                }
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.appcompat.view.menu.i.a
        public boolean c(androidx.appcompat.view.menu.e eVar) {
            Window.Callback callbackT0;
            if (eVar != eVar.F()) {
                return true;
            }
            j8 j8Var = j8.this;
            if (!j8Var.L || (callbackT0 = j8Var.t0()) == null || j8.this.W) {
                return true;
            }
            callbackT0.onMenuOpened(Token.ASSIGN_ADD, eVar);
            return true;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public j8(Context context, Window window, b8 b8Var, Object obj) {
        x7 x7VarY0;
        this.D = null;
        this.E = true;
        this.Y = -100;
        this.g0 = new a();
        this.p = context;
        this.s = b8Var;
        this.o = obj;
        if (this.Y == -100 && (obj instanceof Dialog) && (x7VarY0 = Y0()) != null) {
            this.Y = x7VarY0.t1().n();
        }
        if (this.Y == -100) {
            x64 x64Var = o0;
            Integer num = (Integer) x64Var.get(obj.getClass().getName());
            if (num != null) {
                this.Y = num.intValue();
                x64Var.remove(obj.getClass().getName());
            }
        }
        if (window != null) {
            T(window);
        }
        s8.h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static Configuration l0(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (configuration2 != null && configuration.diff(configuration2) != 0) {
            float f2 = configuration.fontScale;
            float f3 = configuration2.fontScale;
            if (f2 != f3) {
                configuration3.fontScale = f3;
            }
            int i2 = configuration.mcc;
            int i3 = configuration2.mcc;
            if (i2 != i3) {
                configuration3.mcc = i3;
            }
            int i4 = configuration.mnc;
            int i5 = configuration2.mnc;
            if (i4 != i5) {
                configuration3.mnc = i5;
            }
            j.a(configuration, configuration2, configuration3);
            int i6 = configuration.touchscreen;
            int i7 = configuration2.touchscreen;
            if (i6 != i7) {
                configuration3.touchscreen = i7;
            }
            int i8 = configuration.keyboard;
            int i9 = configuration2.keyboard;
            if (i8 != i9) {
                configuration3.keyboard = i9;
            }
            int i10 = configuration.keyboardHidden;
            int i11 = configuration2.keyboardHidden;
            if (i10 != i11) {
                configuration3.keyboardHidden = i11;
            }
            int i12 = configuration.navigation;
            int i13 = configuration2.navigation;
            if (i12 != i13) {
                configuration3.navigation = i13;
            }
            int i14 = configuration.navigationHidden;
            int i15 = configuration2.navigationHidden;
            if (i14 != i15) {
                configuration3.navigationHidden = i15;
            }
            int i16 = configuration.orientation;
            int i17 = configuration2.orientation;
            if (i16 != i17) {
                configuration3.orientation = i17;
            }
            int i18 = configuration.screenLayout & 15;
            int i19 = configuration2.screenLayout;
            if (i18 != (i19 & 15)) {
                configuration3.screenLayout |= i19 & 15;
            }
            int i20 = configuration.screenLayout & 192;
            int i21 = configuration2.screenLayout;
            if (i20 != (i21 & 192)) {
                configuration3.screenLayout |= i21 & 192;
            }
            int i22 = configuration.screenLayout & 48;
            int i23 = configuration2.screenLayout;
            if (i22 != (i23 & 48)) {
                configuration3.screenLayout |= i23 & 48;
            }
            int i24 = configuration.screenLayout & 768;
            int i25 = configuration2.screenLayout;
            if (i24 != (i25 & 768)) {
                configuration3.screenLayout |= i25 & 768;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                k.a(configuration, configuration2, configuration3);
            }
            int i26 = configuration.uiMode & 15;
            int i27 = configuration2.uiMode;
            if (i26 != (i27 & 15)) {
                configuration3.uiMode |= i27 & 15;
            }
            int i28 = configuration.uiMode & 48;
            int i29 = configuration2.uiMode;
            if (i28 != (i29 & 48)) {
                configuration3.uiMode |= i29 & 48;
            }
            int i30 = configuration.screenWidthDp;
            int i31 = configuration2.screenWidthDp;
            if (i30 != i31) {
                configuration3.screenWidthDp = i31;
            }
            int i32 = configuration.screenHeightDp;
            int i33 = configuration2.screenHeightDp;
            if (i32 != i33) {
                configuration3.screenHeightDp = i33;
            }
            int i34 = configuration.smallestScreenWidthDp;
            int i35 = configuration2.smallestScreenWidthDp;
            if (i34 != i35) {
                configuration3.smallestScreenWidthDp = i35;
            }
            int i36 = configuration.densityDpi;
            int i37 = configuration2.densityDpi;
            if (i36 != i37) {
                configuration3.densityDpi = i37;
            }
        }
        return configuration3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.h8
    public void A(Bundle bundle) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int A0(Context context, int i2) {
        if (i2 == -100) {
            return -1;
        }
        if (i2 != -1) {
            if (i2 == 0) {
                if (((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                    return -1;
                }
                return p0(context).c();
            }
            if (i2 != 1 && i2 != 2) {
                if (i2 == 3) {
                    return o0(context).c();
                }
                e04.a("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                return 0;
            }
        }
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.h8
    public void B() {
        Q(true, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean B0() {
        boolean z = this.T;
        this.T = false;
        r rVarR0 = r0(0, false);
        if (rVarR0 != null && rVarR0.o) {
            if (!z) {
                a0(rVarR0, true);
            }
            return true;
        }
        v2 v2Var = this.z;
        if (v2Var != null) {
            v2Var.c();
            return true;
        }
        q2 q2VarR = r();
        return q2VarR != null && q2VarR.g();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.h8
    public void C() {
        q2 q2VarR = r();
        if (q2VarR != null) {
            q2VarR.s(false);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean C0(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            this.T = (keyEvent.getFlags() & 128) != 0;
        } else if (i2 == 82) {
            D0(0, keyEvent);
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean D0(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        r rVarR0 = r0(i2, true);
        if (rVarR0.o) {
            return false;
        }
        return N0(rVarR0, keyEvent);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean E0(int i2, KeyEvent keyEvent) {
        q2 q2VarR = r();
        if (q2VarR != null && q2VarR.n(i2, keyEvent)) {
            return true;
        }
        r rVar = this.S;
        if (rVar != null && M0(rVar, keyEvent.getKeyCode(), keyEvent, 1)) {
            r rVar2 = this.S;
            if (rVar2 != null) {
                rVar2.n = true;
            }
            return true;
        }
        if (this.S == null) {
            r rVarR0 = r0(0, true);
            N0(rVarR0, keyEvent);
            boolean zM0 = M0(rVarR0, keyEvent.getKeyCode(), keyEvent, 1);
            rVarR0.m = false;
            if (zM0) {
                return true;
            }
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.h8
    public boolean F(int i2) {
        int iP0 = P0(i2);
        if (this.P && iP0 == 108) {
            return false;
        }
        if (this.L && iP0 == 1) {
            this.L = false;
        }
        if (iP0 == 1) {
            X0();
            this.P = true;
            return true;
        }
        if (iP0 == 2) {
            X0();
            this.J = true;
            return true;
        }
        if (iP0 == 5) {
            X0();
            this.K = true;
            return true;
        }
        if (iP0 == 10) {
            X0();
            this.N = true;
            return true;
        }
        if (iP0 == 108) {
            X0();
            this.L = true;
            return true;
        }
        if (iP0 != 109) {
            return this.q.requestFeature(iP0);
        }
        X0();
        this.M = true;
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean F0(int i2, KeyEvent keyEvent) {
        if (i2 != 4) {
            if (i2 == 82) {
                G0(0, keyEvent);
                return true;
            }
        } else if (B0()) {
            return true;
        }
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.h8
    public void G(int i2) {
        i0();
        ViewGroup viewGroup = (ViewGroup) this.G.findViewById(R.id.content);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.p).inflate(i2, viewGroup);
        this.r.c(this.q.getCallback());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean G0(int i2, KeyEvent keyEvent) {
        boolean zN0;
        nb0 nb0Var;
        if (this.z != null) {
            return false;
        }
        boolean zF = true;
        r rVarR0 = r0(i2, true);
        if (i2 != 0 || (nb0Var = this.w) == null || !nb0Var.d() || ViewConfiguration.get(this.p).hasPermanentMenuKey()) {
            boolean z = rVarR0.o;
            if (z || rVarR0.n) {
                a0(rVarR0, true);
                zF = z;
            } else if (rVarR0.m) {
                if (rVarR0.r) {
                    rVarR0.m = false;
                    zN0 = N0(rVarR0, keyEvent);
                } else {
                    zN0 = true;
                }
                if (zN0) {
                    K0(rVarR0, keyEvent);
                }
            } else {
                zF = false;
            }
        } else if (this.w.b()) {
            zF = this.w.f();
        } else if (!this.W && N0(rVarR0, keyEvent)) {
            zF = this.w.g();
        }
        if (zF) {
            AudioManager audioManager = (AudioManager) this.p.getApplicationContext().getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
                return zF;
            }
            Log.w("AppCompatDelegate", "Couldn't get audio manager");
        }
        return zF;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.h8
    public void H(View view) {
        i0();
        ViewGroup viewGroup = (ViewGroup) this.G.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.r.c(this.q.getCallback());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void H0(int i2) {
        q2 q2VarR;
        if (i2 != 108 || (q2VarR = r()) == null) {
            return;
        }
        q2VarR.h(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.h8
    public void I(View view, ViewGroup.LayoutParams layoutParams) {
        i0();
        ViewGroup viewGroup = (ViewGroup) this.G.findViewById(R.id.content);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.r.c(this.q.getCallback());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void I0(int i2) {
        if (i2 == 108) {
            q2 q2VarR = r();
            if (q2VarR != null) {
                q2VarR.h(false);
                return;
            }
            return;
        }
        if (i2 == 0) {
            r rVarR0 = r0(i2, true);
            if (rVarR0.o) {
                a0(rVarR0, false);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
    @Override // defpackage.h8
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void J(OnBackInvokedDispatcher onBackInvokedDispatcher) {
        OnBackInvokedCallback onBackInvokedCallback;
        super.J(onBackInvokedDispatcher);
        OnBackInvokedDispatcher onBackInvokedDispatcher2 = this.m0;
        if (onBackInvokedDispatcher2 != null && (onBackInvokedCallback = this.n0) != null) {
            l.c(onBackInvokedDispatcher2, onBackInvokedCallback);
            this.n0 = null;
        }
        if (onBackInvokedDispatcher == null) {
            Object obj = this.o;
            if (!(obj instanceof Activity) || ((Activity) obj).getWindow() == null) {
                this.m0 = onBackInvokedDispatcher;
            } else {
                this.m0 = l.a((Activity) this.o);
            }
        }
        b1();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void J0(ViewGroup viewGroup) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.h8
    public void K(Toolbar toolbar) {
        if (this.o instanceof Activity) {
            q2 q2VarR = r();
            if (q2VarR instanceof q95) {
                e04.a("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
                return;
            }
            this.u = null;
            if (q2VarR != null) {
                q2VarR.m();
            }
            this.t = null;
            if (toolbar != null) {
                sp4 sp4Var = new sp4(toolbar, s0(), this.r);
                this.t = sp4Var;
                this.r.e(sp4Var.c);
                toolbar.setBackInvokedCallbackEnabled(true);
            } else {
                this.r.e(null);
            }
            t();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void K0(r rVar, KeyEvent keyEvent) {
        int i2;
        ViewGroup.LayoutParams layoutParams;
        if (rVar.o || this.W) {
            return;
        }
        if (rVar.a == 0 && (this.p.getResources().getConfiguration().screenLayout & 15) == 4) {
            return;
        }
        Window.Callback callbackT0 = t0();
        if (callbackT0 != null && !callbackT0.onMenuOpened(rVar.a, rVar.j)) {
            a0(rVar, true);
            return;
        }
        WindowManager windowManager = (WindowManager) this.p.getSystemService("window");
        if (windowManager == null || !N0(rVar, keyEvent)) {
            return;
        }
        ViewGroup viewGroup = rVar.g;
        if (viewGroup != null && !rVar.q) {
            View view = rVar.i;
            if (view != null && (layoutParams = view.getLayoutParams()) != null && layoutParams.width == -1) {
                i2 = -1;
            }
            rVar.n = false;
            WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(i2, -2, rVar.d, rVar.e, 1002, 8519680, -3);
            layoutParams2.gravity = rVar.c;
            layoutParams2.windowAnimations = rVar.f;
            windowManager.addView(rVar.g, layoutParams2);
            rVar.o = true;
            if (rVar.a != 0) {
                b1();
                return;
            }
            return;
        }
        if (viewGroup == null) {
            if (!w0(rVar) || rVar.g == null) {
                return;
            }
        } else if (rVar.q && viewGroup.getChildCount() > 0) {
            rVar.g.removeAllViews();
        }
        if (!v0(rVar) || !rVar.b()) {
            rVar.q = true;
            return;
        }
        ViewGroup.LayoutParams layoutParams3 = rVar.h.getLayoutParams();
        if (layoutParams3 == null) {
            layoutParams3 = new ViewGroup.LayoutParams(-2, -2);
        }
        rVar.g.setBackgroundResource(rVar.b);
        ViewParent parent = rVar.h.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(rVar.h);
        }
        rVar.g.addView(rVar.h, layoutParams3);
        if (!rVar.h.hasFocus()) {
            rVar.h.requestFocus();
        }
        i2 = -2;
        rVar.n = false;
        WindowManager.LayoutParams layoutParams22 = new WindowManager.LayoutParams(i2, -2, rVar.d, rVar.e, 1002, 8519680, -3);
        layoutParams22.gravity = rVar.c;
        layoutParams22.windowAnimations = rVar.f;
        windowManager.addView(rVar.g, layoutParams22);
        rVar.o = true;
        if (rVar.a != 0) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.h8
    public void L(int i2) {
        this.Z = i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final q2 L0() {
        return this.t;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.h8
    public final void M(CharSequence charSequence) {
        this.v = charSequence;
        nb0 nb0Var = this.w;
        if (nb0Var != null) {
            nb0Var.setWindowTitle(charSequence);
            return;
        }
        if (L0() != null) {
            L0().t(charSequence);
            return;
        }
        TextView textView = this.H;
        if (textView != null) {
            textView.setText(charSequence);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean M0(r rVar, int i2, KeyEvent keyEvent, int i3) {
        androidx.appcompat.view.menu.e eVar;
        boolean zPerformShortcut = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((rVar.m || N0(rVar, keyEvent)) && (eVar = rVar.j) != null) {
            zPerformShortcut = eVar.performShortcut(i2, keyEvent, i3);
        }
        if (zPerformShortcut && (i3 & 1) == 0 && this.w == null) {
            a0(rVar, true);
        }
        return zPerformShortcut;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean N0(r rVar, KeyEvent keyEvent) {
        nb0 nb0Var;
        nb0 nb0Var2;
        nb0 nb0Var3;
        if (this.W) {
            return false;
        }
        if (rVar.m) {
            return true;
        }
        r rVar2 = this.S;
        if (rVar2 != null && rVar2 != rVar) {
            a0(rVar2, false);
        }
        Window.Callback callbackT0 = t0();
        if (callbackT0 != null) {
            rVar.i = callbackT0.onCreatePanelView(rVar.a);
        }
        int i2 = rVar.a;
        boolean z = i2 == 0 || i2 == 108;
        if (z && (nb0Var3 = this.w) != null) {
            nb0Var3.c();
        }
        if (rVar.i == null && (!z || !(L0() instanceof sp4))) {
            androidx.appcompat.view.menu.e eVar = rVar.j;
            if (eVar == null || rVar.r) {
                if (eVar == null && (!x0(rVar) || rVar.j == null)) {
                    return false;
                }
                if (z && this.w != null) {
                    if (this.x == null) {
                        this.x = new g();
                    }
                    this.w.a(rVar.j, this.x);
                }
                rVar.j.i0();
                if (!callbackT0.onCreatePanelMenu(rVar.a, rVar.j)) {
                    rVar.c(null);
                    if (z && (nb0Var = this.w) != null) {
                        nb0Var.a(null, this.x);
                    }
                    return false;
                }
                rVar.r = false;
            }
            rVar.j.i0();
            Bundle bundle = rVar.s;
            if (bundle != null) {
                rVar.j.S(bundle);
                rVar.s = null;
            }
            if (!callbackT0.onPreparePanel(0, rVar.i, rVar.j)) {
                if (z && (nb0Var2 = this.w) != null) {
                    nb0Var2.a(null, this.x);
                }
                rVar.j.h0();
                return false;
            }
            boolean z2 = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            rVar.p = z2;
            rVar.j.setQwertyMode(z2);
            rVar.j.h0();
        }
        rVar.m = true;
        rVar.n = false;
        this.S = rVar;
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void O0(boolean z) {
        nb0 nb0Var = this.w;
        if (nb0Var == null || !nb0Var.d() || (ViewConfiguration.get(this.p).hasPermanentMenuKey() && !this.w.e())) {
            r rVarR0 = r0(0, true);
            rVarR0.q = true;
            a0(rVarR0, false);
            K0(rVarR0, null);
            return;
        }
        Window.Callback callbackT0 = t0();
        if (this.w.b() && z) {
            this.w.f();
            if (this.W) {
                return;
            }
            callbackT0.onPanelClosed(Token.ASSIGN_ADD, r0(0, true).j);
            return;
        }
        if (callbackT0 == null || this.W) {
            return;
        }
        if (this.e0 && (this.f0 & 1) != 0) {
            this.q.getDecorView().removeCallbacks(this.g0);
            this.g0.run();
        }
        r rVarR02 = r0(0, true);
        androidx.appcompat.view.menu.e eVar = rVarR02.j;
        if (eVar == null || rVarR02.r || !callbackT0.onPreparePanel(0, rVarR02.i, eVar)) {
            return;
        }
        callbackT0.onMenuOpened(Token.ASSIGN_ADD, rVarR02.j);
        this.w.g();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean P(boolean z) {
        return Q(z, true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int P0(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return Token.ASSIGN_ADD;
        }
        if (i2 != 9) {
            return i2;
        }
        Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
        return Token.ASSIGN_SUB;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean Q(boolean z, boolean z2) {
        if (this.W) {
            return false;
        }
        int iV = V();
        int iA0 = A0(this.p, iV);
        jz1 jz1VarU = Build.VERSION.SDK_INT < 33 ? U(this.p) : null;
        if (!z2 && jz1VarU != null) {
            jz1VarU = q0(this.p.getResources().getConfiguration());
        }
        boolean zA1 = a1(iA0, jz1VarU, z);
        if (iV == 0) {
            p0(this.p).e();
        } else {
            o oVar = this.c0;
            if (oVar != null) {
                oVar.a();
            }
        }
        if (iV == 3) {
            o0(this.p).e();
            return zA1;
        }
        o oVar2 = this.d0;
        if (oVar2 != null) {
            oVar2.a();
        }
        return zA1;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Q0(Configuration configuration, jz1 jz1Var) {
        j.d(configuration, jz1Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean R() {
        return P(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void R0(jz1 jz1Var) {
        j.c(jz1Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void S() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.G.findViewById(R.id.content);
        View decorView = this.q.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray typedArrayObtainStyledAttributes = this.p.obtainStyledAttributes(mn3.v0);
        typedArrayObtainStyledAttributes.getValue(mn3.H0, contentFrameLayout.getMinWidthMajor());
        typedArrayObtainStyledAttributes.getValue(mn3.I0, contentFrameLayout.getMinWidthMinor());
        if (typedArrayObtainStyledAttributes.hasValue(mn3.F0)) {
            typedArrayObtainStyledAttributes.getValue(mn3.F0, contentFrameLayout.getFixedWidthMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(mn3.G0)) {
            typedArrayObtainStyledAttributes.getValue(mn3.G0, contentFrameLayout.getFixedWidthMinor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(mn3.D0)) {
            typedArrayObtainStyledAttributes.getValue(mn3.D0, contentFrameLayout.getFixedHeightMajor());
        }
        if (typedArrayObtainStyledAttributes.hasValue(mn3.E0)) {
            typedArrayObtainStyledAttributes.getValue(mn3.E0, contentFrameLayout.getFixedHeightMinor());
        }
        typedArrayObtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean S0() {
        ViewGroup viewGroup;
        return this.F && (viewGroup = this.G) != null && viewGroup.isLaidOut();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void T(Window window) {
        if (this.q != null) {
            e04.a("AppCompat has already installed itself into the Window");
            return;
        }
        Window.Callback callback = window.getCallback();
        if (callback instanceof m) {
            e04.a("AppCompat has already installed itself into the Window");
            return;
        }
        m mVar = new m(callback);
        this.r = mVar;
        window.setCallback(mVar);
        dp4 dp4VarU = dp4.u(this.p, null, q0);
        Drawable drawableH = dp4VarU.h(0);
        if (drawableH != null) {
            window.setBackgroundDrawable(drawableH);
        }
        dp4VarU.x();
        this.q = window;
        if (Build.VERSION.SDK_INT < 33 || this.m0 != null) {
            return;
        }
        J(null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean T0(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.q.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ((View) viewParent).isAttachedToWindow()) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public jz1 U(Context context) {
        jz1 jz1VarQ;
        if (Build.VERSION.SDK_INT >= 33 || (jz1VarQ = h8.q()) == null) {
            return null;
        }
        jz1 jz1VarQ0 = q0(context.getApplicationContext().getResources().getConfiguration());
        jz1 jz1VarB = mz1.b(jz1VarQ, jz1VarQ0);
        return jz1VarB.e() ? jz1VarQ0 : jz1VarB;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean U0() {
        if (this.m0 == null) {
            return false;
        }
        r rVarR0 = r0(0, false);
        return (rVarR0 != null && rVarR0.o) || this.z != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int V() {
        int i2 = this.Y;
        return i2 != -100 ? i2 : h8.m();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public v2 V0(v2.a aVar) {
        b8 b8Var;
        if (aVar == null) {
            jl.a("ActionMode callback can not be null.");
            return null;
        }
        v2 v2Var = this.z;
        if (v2Var != null) {
            v2Var.c();
        }
        h hVar = new h(aVar);
        q2 q2VarR = r();
        if (q2VarR != null) {
            v2 v2VarU = q2VarR.u(hVar);
            this.z = v2VarU;
            if (v2VarU != null && (b8Var = this.s) != null) {
                b8Var.I(v2VarU);
            }
        }
        if (this.z == null) {
            this.z = W0(hVar);
        }
        b1();
        return this.z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void W(int i2, r rVar, Menu menu) {
        if (menu == null) {
            if (rVar == null && i2 >= 0) {
                r[] rVarArr = this.R;
                if (i2 < rVarArr.length) {
                    rVar = rVarArr[i2];
                }
            }
            if (rVar != null) {
                menu = rVar.j;
            }
        }
        if ((rVar == null || rVar.o) && !this.W) {
            this.r.d(this.q.getCallback(), i2, menu);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public v2 W0(v2.a aVar) {
        v2 v2VarZ;
        b8 b8Var;
        h0();
        v2 v2Var = this.z;
        if (v2Var != null) {
            v2Var.c();
        }
        if (!(aVar instanceof h)) {
            aVar = new h(aVar);
        }
        b8 b8Var2 = this.s;
        if (b8Var2 == null || this.W) {
            v2VarZ = null;
        } else {
            try {
                v2VarZ = b8Var2.z(aVar);
            } catch (AbstractMethodError unused) {
                v2VarZ = null;
            }
        }
        if (v2VarZ != null) {
            this.z = v2VarZ;
        } else {
            if (this.A == null) {
                if (this.O) {
                    TypedValue typedValue = new TypedValue();
                    Resources.Theme theme = this.p.getTheme();
                    theme.resolveAttribute(nk3.d, typedValue, true);
                    int i2 = typedValue.resourceId;
                    Context e30Var = this.p;
                    if (i2 != 0) {
                        Resources.Theme themeNewTheme = e30Var.getResources().newTheme();
                        themeNewTheme.setTo(theme);
                        themeNewTheme.applyStyle(typedValue.resourceId, true);
                        e30Var = new e30(this.p, 0);
                        e30Var.getTheme().setTo(themeNewTheme);
                    }
                    this.A = new ActionBarContextView(e30Var);
                    PopupWindow popupWindow = new PopupWindow(e30Var, (AttributeSet) null, nk3.f);
                    this.B = popupWindow;
                    xf3.b(popupWindow, 2);
                    this.B.setContentView(this.A);
                    this.B.setWidth(-1);
                    e30Var.getTheme().resolveAttribute(nk3.b, typedValue, true);
                    this.A.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, e30Var.getResources().getDisplayMetrics()));
                    this.B.setHeight(-2);
                    this.C = new d();
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.G.findViewById(pl3.h);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(m0()));
                        this.A = (ActionBarContextView) viewStubCompat.a();
                    }
                }
            }
            if (this.A != null) {
                h0();
                this.A.k();
                od4 od4Var = new od4(this.A.getContext(), this.A, aVar, this.B == null);
                if (aVar.c(od4Var, od4Var.e())) {
                    od4Var.k();
                    this.A.h(od4Var);
                    this.z = od4Var;
                    boolean zS0 = S0();
                    ActionBarContextView actionBarContextView = this.A;
                    if (zS0) {
                        actionBarContextView.setAlpha(0.0f);
                        s45 s45VarB = l35.e(this.A).b(1.0f);
                        this.D = s45VarB;
                        s45VarB.g(new e());
                    } else {
                        actionBarContextView.setAlpha(1.0f);
                        this.A.setVisibility(0);
                        if (this.A.getParent() instanceof View) {
                            l35.d0((View) this.A.getParent());
                        }
                    }
                    if (this.B != null) {
                        this.q.getDecorView().post(this.C);
                    }
                } else {
                    this.z = null;
                }
            }
        }
        v2 v2Var2 = this.z;
        if (v2Var2 != null && (b8Var = this.s) != null) {
            b8Var.I(v2Var2);
        }
        b1();
        return this.z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void X(androidx.appcompat.view.menu.e eVar) {
        if (this.Q) {
            return;
        }
        this.Q = true;
        this.w.i();
        Window.Callback callbackT0 = t0();
        if (callbackT0 != null && !this.W) {
            callbackT0.onPanelClosed(Token.ASSIGN_ADD, eVar);
        }
        this.Q = false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void X0() {
        if (this.F) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void Y() {
        o oVar = this.c0;
        if (oVar != null) {
            oVar.a();
        }
        o oVar2 = this.d0;
        if (oVar2 != null) {
            oVar2.a();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final x7 Y0() {
        for (Context baseContext = this.p; baseContext != null; baseContext = ((ContextWrapper) baseContext).getBaseContext()) {
            if (baseContext instanceof x7) {
                return (x7) baseContext;
            }
            if (!(baseContext instanceof ContextWrapper)) {
                break;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Z(int i2) {
        a0(r0(i2, true), true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: android.app.Activity */
    /* JADX WARN: Multi-variable type inference failed */
    public final void Z0(Configuration configuration) {
        Activity activity = (Activity) this.o;
        if (activity instanceof bt1) {
            if (((bt1) activity).getLifecycle().b().b(g.b.h)) {
                activity.onConfigurationChanged(configuration);
            }
        } else {
            if (!this.V || this.W) {
                return;
            }
            activity.onConfigurationChanged(configuration);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.view.menu.e.a
    public boolean a(androidx.appcompat.view.menu.e eVar, MenuItem menuItem) {
        r rVarK0;
        Window.Callback callbackT0 = t0();
        if (callbackT0 == null || this.W || (rVarK0 = k0(eVar.F())) == null) {
            return false;
        }
        return callbackT0.onMenuItemSelected(rVarK0.a, menuItem);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void a0(r rVar, boolean z) {
        ViewGroup viewGroup;
        nb0 nb0Var;
        if (z && rVar.a == 0 && (nb0Var = this.w) != null && nb0Var.b()) {
            X(rVar.j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.p.getSystemService("window");
        if (windowManager != null && rVar.o && (viewGroup = rVar.g) != null) {
            windowManager.removeView(viewGroup);
            if (z) {
                W(rVar.a, rVar, null);
            }
        }
        rVar.m = false;
        rVar.n = false;
        rVar.o = false;
        rVar.h = null;
        rVar.q = true;
        if (this.S == rVar) {
            this.S = null;
        }
        if (rVar.a == 0) {
            b1();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean a1(int i2, jz1 jz1Var, boolean z) {
        boolean z2;
        Configuration configurationB0 = b0(this.p, i2, jz1Var, null, false);
        int iN0 = n0(this.p);
        Configuration configuration = this.X;
        if (configuration == null) {
            configuration = this.p.getResources().getConfiguration();
        }
        int i3 = configuration.uiMode & 48;
        int i4 = configurationB0.uiMode & 48;
        jz1 jz1VarQ0 = q0(configuration);
        jz1 jz1VarQ02 = jz1Var == null ? null : q0(configurationB0);
        int i5 = i3 != i4 ? 512 : 0;
        if (jz1VarQ02 != null && !jz1VarQ0.equals(jz1VarQ02)) {
            i5 |= 8196;
        }
        boolean z3 = true;
        if (((~iN0) & i5) != 0 && z && this.U && (r0 || this.V)) {
            Object obj = this.o;
            if ((obj instanceof Activity) && !((Activity) obj).isChild()) {
                if (Build.VERSION.SDK_INT >= 31 && (i5 & 8192) != 0) {
                    ((Activity) this.o).getWindow().getDecorView().setLayoutDirection(configurationB0.getLayoutDirection());
                }
                a3.o((Activity) this.o);
                z2 = true;
            }
        } else {
            z2 = false;
        }
        if (z2 || i5 == 0) {
            z3 = z2;
        } else {
            c1(i4, jz1VarQ02, (i5 & iN0) == i5, null);
        }
        if (z3) {
            Object obj2 = this.o;
            if (obj2 instanceof x7) {
                if ((i5 & 512) != 0) {
                    ((x7) obj2).y1(i2);
                }
                if ((i5 & 4) != 0) {
                    ((x7) this.o).x1(jz1Var);
                }
            }
        }
        if (jz1VarQ02 != null) {
            R0(q0(this.p.getResources().getConfiguration()));
        }
        return z3;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // androidx.appcompat.view.menu.e.a
    public void b(androidx.appcompat.view.menu.e eVar) {
        O0(true);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Configuration b0(Context context, int i2, jz1 jz1Var, Configuration configuration, boolean z) {
        int i3 = i2 != 1 ? i2 != 2 ? z ? 0 : context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & (-49));
        if (jz1Var != null) {
            Q0(configuration2, jz1Var);
        }
        return configuration2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void b1() {
        OnBackInvokedCallback onBackInvokedCallback;
        if (Build.VERSION.SDK_INT >= 33) {
            boolean zU0 = U0();
            if (zU0 && this.n0 == null) {
                this.n0 = l.b(this.m0, this);
            } else {
                if (zU0 || (onBackInvokedCallback = this.n0) == null) {
                    return;
                }
                l.c(this.m0, onBackInvokedCallback);
                this.n0 = null;
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final ViewGroup c0() {
        ViewGroup viewGroup;
        TypedArray typedArrayObtainStyledAttributes = this.p.obtainStyledAttributes(mn3.v0);
        if (!typedArrayObtainStyledAttributes.hasValue(mn3.A0)) {
            typedArrayObtainStyledAttributes.recycle();
            e04.a("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
            return null;
        }
        if (typedArrayObtainStyledAttributes.getBoolean(mn3.J0, false)) {
            F(1);
        } else if (typedArrayObtainStyledAttributes.getBoolean(mn3.A0, false)) {
            F(Token.ASSIGN_ADD);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(mn3.B0, false)) {
            F(Token.ASSIGN_SUB);
        }
        if (typedArrayObtainStyledAttributes.getBoolean(mn3.C0, false)) {
            F(10);
        }
        this.O = typedArrayObtainStyledAttributes.getBoolean(mn3.w0, false);
        typedArrayObtainStyledAttributes.recycle();
        j0();
        this.q.getDecorView();
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.p);
        if (this.P) {
            viewGroup = this.N ? (ViewGroup) layoutInflaterFrom.inflate(hm3.o, (ViewGroup) null) : (ViewGroup) layoutInflaterFrom.inflate(hm3.n, (ViewGroup) null);
        } else if (this.O) {
            viewGroup = (ViewGroup) layoutInflaterFrom.inflate(hm3.f, (ViewGroup) null);
            this.M = false;
            this.L = false;
        } else if (this.L) {
            TypedValue typedValue = new TypedValue();
            this.p.getTheme().resolveAttribute(nk3.d, typedValue, true);
            viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new e30(this.p, typedValue.resourceId) : this.p).inflate(hm3.p, (ViewGroup) null);
            nb0 nb0Var = (nb0) viewGroup.findViewById(pl3.p);
            this.w = nb0Var;
            nb0Var.setWindowCallback(t0());
            if (this.M) {
                this.w.h(Token.ASSIGN_SUB);
            }
            if (this.J) {
                this.w.h(2);
            }
            if (this.K) {
                this.w.h(5);
            }
        } else {
            viewGroup = null;
        }
        if (viewGroup == null) {
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.L + ", windowActionBarOverlay: " + this.M + ", android:windowIsFloating: " + this.O + ", windowActionModeOverlay: " + this.N + ", windowNoTitle: " + this.P + " }");
        }
        l35.p0(viewGroup, new b());
        if (this.w == null) {
            this.H = (TextView) viewGroup.findViewById(pl3.C);
        }
        f55.c(viewGroup);
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(pl3.b);
        ViewGroup viewGroup2 = (ViewGroup) this.q.findViewById(R.id.content);
        if (viewGroup2 != null) {
            while (viewGroup2.getChildCount() > 0) {
                View childAt = viewGroup2.getChildAt(0);
                viewGroup2.removeViewAt(0);
                contentFrameLayout.addView(childAt);
            }
            viewGroup2.setId(-1);
            contentFrameLayout.setId(R.id.content);
            if (viewGroup2 instanceof FrameLayout) {
                ((FrameLayout) viewGroup2).setForeground(null);
            }
        }
        this.q.setContentView(viewGroup);
        contentFrameLayout.setAttachListener(new c());
        return viewGroup;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void c1(int i2, jz1 jz1Var, boolean z, Configuration configuration) {
        Resources resources = this.p.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i2 | (resources.getConfiguration().uiMode & (-49));
        if (jz1Var != null) {
            Q0(configuration2, jz1Var);
        }
        resources.updateConfiguration(configuration2, null);
        if (Build.VERSION.SDK_INT < 26) {
            ss3.a(resources);
        }
        int i3 = this.Z;
        if (i3 != 0) {
            this.p.setTheme(i3);
            this.p.getTheme().applyStyle(this.Z, true);
        }
        if (z && (this.o instanceof Activity)) {
            Z0(configuration2);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r11v0, resolved type: android.view.View */
    /* JADX WARN: Multi-variable type inference failed */
    public View d0(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        if (this.k0 == null) {
            TypedArray typedArrayObtainStyledAttributes = this.p.obtainStyledAttributes(mn3.v0);
            String string = typedArrayObtainStyledAttributes.getString(mn3.z0);
            typedArrayObtainStyledAttributes.recycle();
            if (string == null) {
                this.k0 = new n9();
            } else {
                try {
                    this.k0 = (n9) this.p.getClassLoader().loadClass(string).getDeclaredConstructor(null).newInstance(null);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    this.k0 = new n9();
                }
            }
        }
        boolean z2 = p0;
        boolean zT0 = false;
        if (z2) {
            if (this.l0 == null) {
                this.l0 = new as1();
            }
            if (this.l0.a(attributeSet)) {
                z = true;
            } else {
                if (!(attributeSet instanceof XmlPullParser)) {
                    zT0 = T0((ViewParent) view);
                } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    zT0 = true;
                }
                z = zT0;
            }
        } else {
            z = zT0;
        }
        return this.k0.r(view, str, context, attributeSet, z, z2, true, hz4.c());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int d1(w95 w95Var, Rect rect) {
        boolean z;
        boolean z2;
        int iL = w95Var != null ? w95Var.l() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.A;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.A.getLayoutParams();
            if (this.A.isShown()) {
                if (this.i0 == null) {
                    this.i0 = new Rect();
                    this.j0 = new Rect();
                }
                Rect rect2 = this.i0;
                Rect rect3 = this.j0;
                if (w95Var == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(w95Var.j(), w95Var.l(), w95Var.k(), w95Var.i());
                }
                f55.a(this.G, rect2, rect3);
                int i2 = rect2.top;
                int i3 = rect2.left;
                int i4 = rect2.right;
                w95 w95VarD = l35.D(this.G);
                int iJ = w95VarD == null ? 0 : w95VarD.j();
                int iK = w95VarD == null ? 0 : w95VarD.k();
                if (marginLayoutParams.topMargin == i2 && marginLayoutParams.leftMargin == i3 && marginLayoutParams.rightMargin == i4) {
                    z2 = false;
                } else {
                    marginLayoutParams.topMargin = i2;
                    marginLayoutParams.leftMargin = i3;
                    marginLayoutParams.rightMargin = i4;
                    z2 = true;
                }
                if (i2 <= 0 || this.I != null) {
                    View view = this.I;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        int i5 = marginLayoutParams2.height;
                        int i6 = marginLayoutParams.topMargin;
                        if (i5 != i6 || marginLayoutParams2.leftMargin != iJ || marginLayoutParams2.rightMargin != iK) {
                            marginLayoutParams2.height = i6;
                            marginLayoutParams2.leftMargin = iJ;
                            marginLayoutParams2.rightMargin = iK;
                            this.I.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.p);
                    this.I = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = iJ;
                    layoutParams.rightMargin = iK;
                    this.G.addView(this.I, -1, layoutParams);
                }
                View view3 = this.I;
                z = view3 != null;
                if (z && view3.getVisibility() != 0) {
                    e1(this.I);
                }
                if (!this.N && z) {
                    iL = 0;
                }
                z = z;
                z = z2;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z = false;
            } else {
                z = false;
                z = false;
            }
            if (z) {
                this.A.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.I;
        if (view4 != null) {
            view4.setVisibility(z ? 0 : 8);
        }
        return iL;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.h8
    public void e(View view, ViewGroup.LayoutParams layoutParams) {
        i0();
        ((ViewGroup) this.G.findViewById(R.id.content)).addView(view, layoutParams);
        this.r.c(this.q.getCallback());
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e0() {
        androidx.appcompat.view.menu.e eVar;
        nb0 nb0Var = this.w;
        if (nb0Var != null) {
            nb0Var.i();
        }
        if (this.B != null) {
            this.q.getDecorView().removeCallbacks(this.C);
            if (this.B.isShowing()) {
                try {
                    this.B.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.B = null;
        }
        h0();
        r rVarR0 = r0(0, false);
        if (rVarR0 == null || (eVar = rVarR0.j) == null) {
            return;
        }
        eVar.close();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e1(View view) {
        int iH = l35.H(view) & 8192;
        Context context = this.p;
        view.setBackgroundColor(iH != 0 ? c30.b(context, tk3.b) : c30.b(context, tk3.a));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean f0(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.o;
        if (((obj instanceof xq1.a) || (obj instanceof q8)) && (decorView = this.q.getDecorView()) != null && xq1.d(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.r.b(this.q.getCallback(), keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        return keyEvent.getAction() == 0 ? C0(keyCode, keyEvent) : F0(keyCode, keyEvent);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.h8
    public Context g(Context context) {
        j8 j8Var;
        Context context2;
        this.U = true;
        int iA0 = A0(context, V());
        if (h8.u(context)) {
            h8.O(context);
        }
        jz1 jz1VarU = U(context);
        if (context instanceof ContextThemeWrapper) {
            j8Var = this;
            context2 = context;
            try {
                ((ContextThemeWrapper) context2).applyOverrideConfiguration(j8Var.b0(context2, iA0, jz1VarU, null, false));
                return context2;
            } catch (IllegalStateException unused) {
            }
        } else {
            j8Var = this;
            context2 = context;
        }
        if (context2 instanceof e30) {
            try {
                ((e30) context2).a(j8Var.b0(context2, iA0, jz1VarU, null, false));
                return context2;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!r0) {
            return super.g(context2);
        }
        Configuration configuration = new Configuration();
        configuration.uiMode = -1;
        configuration.fontScale = 0.0f;
        Configuration configuration2 = context2.createConfigurationContext(configuration).getResources().getConfiguration();
        Configuration configuration3 = context2.getResources().getConfiguration();
        configuration2.uiMode = configuration3.uiMode;
        Configuration configurationB0 = j8Var.b0(context2, iA0, jz1VarU, !configuration2.equals(configuration3) ? l0(configuration2, configuration3) : null, true);
        e30 e30Var = new e30(context2, zm3.d);
        e30Var.a(configurationB0);
        try {
            if (context2.getTheme() != null) {
                ps3.f.a(e30Var.getTheme());
            }
        } catch (NullPointerException unused3) {
        }
        return super.g(e30Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g0(int i2) {
        r rVarR0;
        r rVarR02 = r0(i2, true);
        if (rVarR02.j != null) {
            Bundle bundle = new Bundle();
            rVarR02.j.U(bundle);
            if (bundle.size() > 0) {
                rVarR02.s = bundle;
            }
            rVarR02.j.i0();
            rVarR02.j.clear();
        }
        rVarR02.r = true;
        rVarR02.q = true;
        if ((i2 != 108 && i2 != 0) || this.w == null || (rVarR0 = r0(0, false)) == null) {
            return;
        }
        rVarR0.m = false;
        N0(rVarR0, null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void h0() {
        s45 s45Var = this.D;
        if (s45Var != null) {
            s45Var.c();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void i0() {
        if (this.F) {
            return;
        }
        this.G = c0();
        CharSequence charSequenceS0 = s0();
        if (!TextUtils.isEmpty(charSequenceS0)) {
            nb0 nb0Var = this.w;
            if (nb0Var != null) {
                nb0Var.setWindowTitle(charSequenceS0);
            } else if (L0() != null) {
                L0().t(charSequenceS0);
            } else {
                TextView textView = this.H;
                if (textView != null) {
                    textView.setText(charSequenceS0);
                }
            }
        }
        S();
        J0(this.G);
        this.F = true;
        r rVarR0 = r0(0, false);
        if (this.W) {
            return;
        }
        if (rVarR0 == null || rVarR0.j == null) {
            y0(Token.ASSIGN_ADD);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.h8
    public View j(int i2) {
        i0();
        return this.q.findViewById(i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void j0() {
        if (this.q == null) {
            Object obj = this.o;
            if (obj instanceof Activity) {
                T(((Activity) obj).getWindow());
            }
        }
        if (this.q != null) {
            return;
        }
        e04.a("We have not been given a Window");
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public r k0(Menu menu) {
        r[] rVarArr = this.R;
        int length = rVarArr != null ? rVarArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            r rVar = rVarArr[i2];
            if (rVar != null && rVar.j == menu) {
                return rVar;
            }
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.h8
    public Context l() {
        return this.p;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Context m0() {
        q2 q2VarR = r();
        Context contextJ = q2VarR != null ? q2VarR.j() : null;
        return contextJ == null ? this.p : contextJ;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.h8
    public int n() {
        return this.Y;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int n0(Context context) {
        if (!this.b0 && (this.o instanceof Activity)) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return 0;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(context, this.o.getClass()), Build.VERSION.SDK_INT >= 29 ? 269221888 : 786432);
                if (activityInfo != null) {
                    this.a0 = activityInfo.configChanges;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.a0 = 0;
            }
        }
        this.b0 = true;
        return this.a0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final o o0(Context context) {
        if (this.d0 == null) {
            this.d0 = new n(context);
        }
        return this.d0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.LayoutInflater.Factory
    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView(null, str, context, attributeSet);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.h8
    public MenuInflater p() {
        if (this.u == null) {
            u0();
            q2 q2Var = this.t;
            this.u = new dj4(q2Var != null ? q2Var.j() : this.p);
        }
        return this.u;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final o p0(Context context) {
        if (this.c0 == null) {
            this.c0 = new p(hu4.a(context));
        }
        return this.c0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public jz1 q0(Configuration configuration) {
        return j.b(configuration);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.h8
    public q2 r() {
        u0();
        return this.t;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public r r0(int i2, boolean z) {
        r[] rVarArr = this.R;
        if (rVarArr == null || rVarArr.length <= i2) {
            r[] rVarArr2 = new r[i2 + 1];
            if (rVarArr != null) {
                System.arraycopy(rVarArr, 0, rVarArr2, 0, rVarArr.length);
            }
            this.R = rVarArr2;
            rVarArr = rVarArr2;
        }
        r rVar = rVarArr[i2];
        if (rVar != null) {
            return rVar;
        }
        r rVar2 = new r(i2);
        rVarArr[i2] = rVar2;
        return rVar2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.h8
    public void s() {
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(this.p);
        if (layoutInflaterFrom.getFactory() == null) {
            bs1.a(layoutInflaterFrom, this);
        } else {
            if (layoutInflaterFrom.getFactory2() instanceof j8) {
                return;
            }
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final CharSequence s0() {
        Object obj = this.o;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.v;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.h8
    public void t() {
        if (L0() == null || r().k()) {
            return;
        }
        y0(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Window.Callback t0() {
        return this.q.getCallback();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u0() {
        i0();
        if (this.L && this.t == null) {
            Object obj = this.o;
            if (obj instanceof Activity) {
                this.t = new q95((Activity) this.o, this.M);
            } else if (obj instanceof Dialog) {
                this.t = new q95((Dialog) this.o);
            }
            q2 q2Var = this.t;
            if (q2Var != null) {
                q2Var.q(this.h0);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.h8
    public void v(Configuration configuration) {
        q2 q2VarR;
        if (this.L && this.F && (q2VarR = r()) != null) {
            q2VarR.l(configuration);
        }
        s8.b().g(this.p);
        this.X = new Configuration(this.p.getResources().getConfiguration());
        Q(false, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean v0(r rVar) {
        View view = rVar.i;
        if (view != null) {
            rVar.h = view;
            return true;
        }
        if (rVar.j == null) {
            return false;
        }
        if (this.y == null) {
            this.y = new s();
        }
        View view2 = (View) rVar.a(this.y);
        rVar.h = view2;
        return view2 != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.h8
    public void w(Bundle bundle) {
        String strC;
        this.U = true;
        P(false);
        j0();
        Object obj = this.o;
        if (obj instanceof Activity) {
            try {
                strC = y13.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
                strC = null;
            }
            if (strC != null) {
                q2 q2VarL0 = L0();
                if (q2VarL0 == null) {
                    this.h0 = true;
                } else {
                    q2VarL0.q(true);
                }
            }
            h8.d(this);
        }
        this.X = new Configuration(this.p.getResources().getConfiguration());
        this.V = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean w0(r rVar) {
        rVar.d(m0());
        rVar.g = new q(rVar.l);
        rVar.c = 81;
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0045  */
    @Override // defpackage.h8
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void x() {
        if (this.o instanceof Activity) {
            h8.D(this);
        }
        if (this.e0) {
            this.q.getDecorView().removeCallbacks(this.g0);
        }
        this.W = true;
        if (this.Y != -100) {
            Object obj = this.o;
            if ((obj instanceof Activity) && ((Activity) obj).isChangingConfigurations()) {
                o0.put(this.o.getClass().getName(), Integer.valueOf(this.Y));
            } else {
                o0.remove(this.o.getClass().getName());
            }
        }
        q2 q2Var = this.t;
        if (q2Var != null) {
            q2Var.m();
        }
        Y();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean x0(r rVar) {
        Resources.Theme themeNewTheme;
        Context context = this.p;
        int i2 = rVar.a;
        if ((i2 == 0 || i2 == 108) && this.w != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(nk3.d, typedValue, true);
            if (typedValue.resourceId != 0) {
                themeNewTheme = context.getResources().newTheme();
                themeNewTheme.setTo(theme);
                themeNewTheme.applyStyle(typedValue.resourceId, true);
                themeNewTheme.resolveAttribute(nk3.e, typedValue, true);
            } else {
                theme.resolveAttribute(nk3.e, typedValue, true);
                themeNewTheme = null;
            }
            if (typedValue.resourceId != 0) {
                if (themeNewTheme == null) {
                    themeNewTheme = context.getResources().newTheme();
                    themeNewTheme.setTo(theme);
                }
                themeNewTheme.applyStyle(typedValue.resourceId, true);
            }
            if (themeNewTheme != null) {
                e30 e30Var = new e30(context, 0);
                e30Var.getTheme().setTo(themeNewTheme);
                context = e30Var;
            }
        }
        androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(context);
        eVar.W(this);
        rVar.c(eVar);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.h8
    public void y(Bundle bundle) {
        i0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void y0(int i2) {
        this.f0 = (1 << i2) | this.f0;
        if (this.e0) {
            return;
        }
        l35.Y(this.q.getDecorView(), this.g0);
        this.e0 = true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.h8
    public void z() {
        q2 q2VarR = r();
        if (q2VarR != null) {
            q2VarR.s(true);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean z0() {
        return this.E;
    }

    @Override // android.view.LayoutInflater.Factory2
    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return d0(view, str, context, attributeSet);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class m extends o95 {
        public f g;
        public boolean h;
        public boolean i;
        public boolean j;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public m(Window.Callback callback) {
            super(callback);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean b(Window.Callback callback, KeyEvent keyEvent) {
            try {
                this.i = true;
                return callback.dispatchKeyEvent(keyEvent);
            } finally {
                this.i = false;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void c(Window.Callback callback) {
            try {
                this.h = true;
                callback.onContentChanged();
            } finally {
                this.h = false;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void d(Window.Callback callback, int i, Menu menu) {
            try {
                this.j = true;
                callback.onPanelClosed(i, menu);
            } finally {
                this.j = false;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.o95, android.view.Window.Callback
        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.i ? a().dispatchKeyEvent(keyEvent) : j8.this.f0(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.o95, android.view.Window.Callback
        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || j8.this.E0(keyEvent.getKeyCode(), keyEvent);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void e(f fVar) {
            this.g = fVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final ActionMode f(ActionMode.Callback callback) {
            bj4.a aVar = new bj4.a(j8.this.p, callback);
            v2 v2VarV0 = j8.this.V0(aVar);
            if (v2VarV0 != null) {
                return aVar.e(v2VarV0);
            }
            return null;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.Window.Callback
        public void onContentChanged() {
            if (this.h) {
                a().onContentChanged();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.o95, android.view.Window.Callback
        public boolean onCreatePanelMenu(int i, Menu menu) {
            if (i != 0 || (menu instanceof androidx.appcompat.view.menu.e)) {
                return super.onCreatePanelMenu(i, menu);
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.o95, android.view.Window.Callback
        public View onCreatePanelView(int i) {
            View viewOnCreatePanelView;
            f fVar = this.g;
            return (fVar == null || (viewOnCreatePanelView = fVar.onCreatePanelView(i)) == null) ? super.onCreatePanelView(i) : viewOnCreatePanelView;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.o95, android.view.Window.Callback
        public boolean onMenuOpened(int i, Menu menu) {
            super.onMenuOpened(i, menu);
            j8.this.H0(i);
            return true;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.o95, android.view.Window.Callback
        public void onPanelClosed(int i, Menu menu) {
            if (this.j) {
                a().onPanelClosed(i, menu);
            } else {
                super.onPanelClosed(i, menu);
                j8.this.I0(i);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.o95, android.view.Window.Callback
        public boolean onPreparePanel(int i, View view, Menu menu) {
            androidx.appcompat.view.menu.e eVar = menu instanceof androidx.appcompat.view.menu.e ? (androidx.appcompat.view.menu.e) menu : null;
            if (i == 0 && eVar == null) {
                return false;
            }
            if (eVar != null) {
                eVar.f0(true);
            }
            f fVar = this.g;
            boolean zOnPreparePanel = fVar != null && fVar.a(i);
            if (!zOnPreparePanel) {
                zOnPreparePanel = super.onPreparePanel(i, view, menu);
            }
            if (eVar != null) {
                eVar.f0(false);
            }
            return zOnPreparePanel;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.o95, android.view.Window.Callback
        public void onProvideKeyboardShortcuts(List list, Menu menu, int i) {
            androidx.appcompat.view.menu.e eVar;
            r rVarR0 = j8.this.r0(0, true);
            if (rVarR0 == null || (eVar = rVarR0.j) == null) {
                super.onProvideKeyboardShortcuts(list, menu, i);
            } else {
                super.onProvideKeyboardShortcuts(list, eVar, i);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.o95, android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i) {
            return (j8.this.z0() && i == 0) ? f(callback) : super.onWindowStartingActionMode(callback, i);
        }

        @Override // android.view.Window.Callback
        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            return null;
        }
    }

    public j8(Dialog dialog, b8 b8Var) {
        this(dialog.getContext(), dialog.getWindow(), b8Var, dialog);
    }

    public j8(Activity activity, b8 b8Var) {
        this(activity, null, b8Var, activity);
    }
}
