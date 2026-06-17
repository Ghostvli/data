package androidx.media3.ui;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.ui.b;
import androidx.media3.ui.d;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.am3;
import defpackage.br4;
import defpackage.ce;
import defpackage.ck3;
import defpackage.cm3;
import defpackage.de3;
import defpackage.e04;
import defpackage.el3;
import defpackage.fi0;
import defpackage.fr4;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.gn3;
import defpackage.hd3;
import defpackage.il3;
import defpackage.jr4;
import defpackage.kg2;
import defpackage.lm3;
import defpackage.lr4;
import defpackage.lu1;
import defpackage.no4;
import defpackage.nq3;
import defpackage.om3;
import defpackage.ps3;
import defpackage.t41;
import defpackage.v81;
import defpackage.wg1;
import defpackage.wk3;
import defpackage.wl3;
import defpackage.wm3;
import defpackage.x45;
import defpackage.x81;
import defpackage.xi1;
import defpackage.xr4;
import defpackage.xz1;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class b extends FrameLayout {
    public static final float[] N0;
    public final ImageView A;
    public boolean A0;
    public final View B;
    public boolean B0;
    public final View C;
    public boolean C0;
    public final TextView D;
    public int D0;
    public final TextView E;
    public boolean E0;
    public final ImageView F;
    public int F0;
    public final ImageView G;
    public int G0;
    public final ImageView H;
    public long[] H0;
    public final ImageView I;
    public boolean[] I0;
    public final ImageView J;
    public long[] J0;
    public final ImageView K;
    public boolean[] K0;
    public final View L;
    public long L0;
    public final View M;
    public boolean M0;
    public final View N;
    public final TextView O;
    public final TextView P;
    public final androidx.media3.ui.d Q;
    public final StringBuilder R;
    public final Formatter S;
    public final no4.b T;
    public final no4.d U;
    public final Runnable V;
    public final Drawable W;
    public final Drawable a0;
    public final Drawable b0;
    public final Drawable c0;
    public final Drawable d0;
    public final String e0;
    public final de3 f;
    public final String f0;
    public final Resources g;
    public final String g0;
    public final Handler h;
    public final Drawable h0;
    public final c i;
    public final Drawable i0;
    public final Class j;
    public final float j0;
    public final Method k;
    public final float k0;
    public final Method l;
    public final String l0;
    public final Class m;
    public final String m0;
    public final Method n;
    public final Drawable n0;
    public final Method o;
    public final Drawable o0;
    public final CopyOnWriteArrayList p;
    public final String p0;
    public final RecyclerView q;
    public final String q0;
    public final h r;
    public final Drawable r0;
    public final e s;
    public final Drawable s0;
    public final j t;
    public final String t0;
    public final C0034b u;
    public final String u0;
    public final fr4 v;
    public hd3 v0;
    public final PopupWindow w;
    public d w0;
    public final int x;
    public boolean x0;
    public final ImageView y;
    public boolean y0;
    public final ImageView z;
    public boolean z0;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements v81 {
        public final /* synthetic */ View a;
        public final /* synthetic */ ViewGroup b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(View view, ViewGroup viewGroup) {
            this.a = view;
            this.b = viewGroup;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.v81
        public void b(Throwable th) {
            this.a.setVisibility(8);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: a(Ljava/lang/Object;)V */
        @Override // defpackage.v81
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public void a(View view) {
            ViewGroup.LayoutParams layoutParams = this.a.getLayoutParams();
            if (layoutParams == null) {
                e04.a("The media route button placeholder missing layout params.");
                return;
            }
            view.setId(wl3.w);
            view.setLayoutParams(layoutParams);
            int iIndexOfChild = this.b.indexOfChild(this.a);
            this.b.removeView(this.a);
            this.b.addView(view, iIndexOfChild);
            view.setVisibility(0);
            b.this.f.V(view, true);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
        void a(boolean z);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class e extends RecyclerView.h {
        public final String[] d;
        public final float[] e;
        public int f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public e(String[] strArr, float[] fArr) {
            this.d = strArr;
            this.e = fArr;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ void G(e eVar, int i, View view) {
            if (i != eVar.f) {
                b.this.setPlaybackSpeed(eVar.e[i]);
            }
            b.this.w.dismiss();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public String H() {
            return this.d[this.f];
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: v(Landroidx/recyclerview/widget/RecyclerView$g0;I)V */
        @Override // androidx.recyclerview.widget.RecyclerView.h
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public void v(i iVar, final int i) {
            String[] strArr = this.d;
            if (i < strArr.length) {
                iVar.z.setText(strArr[i]);
            }
            if (i == this.f) {
                iVar.f.setSelected(true);
                iVar.A.setVisibility(0);
            } else {
                iVar.f.setSelected(false);
                iVar.A.setVisibility(4);
            }
            iVar.f.setOnClickListener(new View.OnClickListener() { // from class: md3
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.e.G(this.f, i, view);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: x(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$g0; */
        @Override // androidx.recyclerview.widget.RecyclerView.h
        /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
        public i x(ViewGroup viewGroup, int i) {
            return new i(LayoutInflater.from(b.this.getContext()).inflate(cm3.e, viewGroup, false));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void K(float f) {
            int i = 0;
            float f2 = Float.MAX_VALUE;
            int i2 = 0;
            while (true) {
                float[] fArr = this.e;
                if (i >= fArr.length) {
                    this.f = i2;
                    return;
                }
                float fAbs = Math.abs(f - fArr[i]);
                if (fAbs < f2) {
                    i2 = i;
                    f2 = fAbs;
                }
                i++;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.h
        public int g() {
            return this.d.length;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface f {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class g extends RecyclerView.g0 {
        public final TextView A;
        public final ImageView B;
        public final TextView z;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public g(View view) {
            super(view);
            if (Build.VERSION.SDK_INT < 26) {
                view.setFocusable(true);
            }
            this.z = (TextView) view.findViewById(wl3.v);
            this.A = (TextView) view.findViewById(wl3.P);
            this.B = (ImageView) view.findViewById(wl3.t);
            view.setOnClickListener(new View.OnClickListener() { // from class: nd3
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    b.g gVar = this.f;
                    b.this.r0(gVar.k());
                }
            });
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class h extends RecyclerView.h {
        public final String[] d;
        public final String[] e;
        public final Drawable[] f;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public h(String[] strArr, Drawable[] drawableArr) {
            this.d = strArr;
            this.e = new String[strArr.length];
            this.f = drawableArr;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean G() {
            return K(1) || K(0);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: v(Landroidx/recyclerview/widget/RecyclerView$g0;I)V */
        @Override // androidx.recyclerview.widget.RecyclerView.h
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public void v(g gVar, int i) {
            if (K(i)) {
                gVar.f.setLayoutParams(new RecyclerView.r(-1, -2));
            } else {
                gVar.f.setLayoutParams(new RecyclerView.r(0, 0));
            }
            gVar.z.setText(this.d[i]);
            if (this.e[i] == null) {
                gVar.A.setVisibility(8);
            } else {
                gVar.A.setText(this.e[i]);
            }
            if (this.f[i] == null) {
                gVar.B.setVisibility(8);
            } else {
                gVar.B.setImageDrawable(this.f[i]);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: x(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$g0; */
        @Override // androidx.recyclerview.widget.RecyclerView.h
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public g x(ViewGroup viewGroup, int i) {
            return b.this.new g(LayoutInflater.from(b.this.getContext()).inflate(cm3.d, viewGroup, false));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void J(int i, String str) {
            this.e[i] = str;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean K(int i) {
            if (b.this.v0 == null) {
                return false;
            }
            if (i == 0) {
                return b.this.v0.isCommandAvailable(13);
            }
            if (i != 1) {
                return true;
            }
            return b.this.v0.isCommandAvailable(30) && b.this.v0.isCommandAvailable(29);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.h
        public int g() {
            return this.d.length;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.h
        public long h(int i) {
            return i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class i extends RecyclerView.g0 {
        public final View A;
        public final TextView z;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public i(View view) {
            super(view);
            if (Build.VERSION.SDK_INT < 26) {
                view.setFocusable(true);
            }
            this.z = (TextView) view.findViewById(wl3.S);
            this.A = view.findViewById(wl3.h);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class k {
        public final xr4.a a;
        public final int b;
        public final String c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public k(xr4 xr4Var, int i, int i2, String str) {
            this.a = (xr4.a) xr4Var.b().get(i);
            this.b = i2;
            this.c = str;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public boolean a() {
            return this.a.h(this.b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public abstract class l extends RecyclerView.h {
        public List d = new ArrayList();

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public l() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ void G(l lVar, hd3 hd3Var, br4 br4Var, k kVar, View view) {
            lVar.getClass();
            if (hd3Var.isCommandAvailable(29)) {
                hd3Var.setTrackSelectionParameters(hd3Var.getTrackSelectionParameters().M().U(new jr4(br4Var, xi1.w(Integer.valueOf(kVar.b)))).a0(kVar.a.e(), false).K());
                lVar.L(kVar.c);
                b.this.w.dismiss();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void H() {
            this.d = Collections.EMPTY_LIST;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: v(Landroidx/recyclerview/widget/RecyclerView$g0;I)V */
        @Override // androidx.recyclerview.widget.RecyclerView.h
        /* JADX INFO: renamed from: I */
        public void v(i iVar, int i) {
            final hd3 hd3Var = b.this.v0;
            if (hd3Var == null) {
                return;
            }
            if (i == 0) {
                J(iVar);
                return;
            }
            final k kVar = (k) this.d.get(i - 1);
            final br4 br4VarC = kVar.a.c();
            boolean z = hd3Var.getTrackSelectionParameters().H.get(br4VarC) != null && kVar.a();
            iVar.z.setText(kVar.c);
            iVar.A.setVisibility(z ? 0 : 4);
            iVar.f.setOnClickListener(new View.OnClickListener() { // from class: pd3
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.l.G(this.f, hd3Var, br4VarC, kVar, view);
                }
            });
        }

        public abstract void J(i iVar);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: x(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/RecyclerView$g0; */
        @Override // androidx.recyclerview.widget.RecyclerView.h
        /* JADX INFO: renamed from: K, reason: merged with bridge method [inline-methods] */
        public i x(ViewGroup viewGroup, int i) {
            return new i(LayoutInflater.from(b.this.getContext()).inflate(cm3.e, viewGroup, false));
        }

        public abstract void L(String str);

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.recyclerview.widget.RecyclerView.h
        public int g() {
            if (this.d.isEmpty()) {
                return 0;
            }
            return this.d.size() + 1;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface m {
        void s(int i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    static {
        kg2.a("media3.ui");
        N0 = new float[]{0.25f, 0.5f, 0.75f, 1.0f, 1.25f, 1.5f, 2.0f};
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:36:0x027f  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x02c1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x02d0  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0303  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x038f  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x03a0  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x03dc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x042f  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0440  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0451  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0478  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x05e8  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x05ea  */
    /* JADX WARN: Type inference failed for: r12v8, types: [android.view.LayoutInflater] */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v3, types: [androidx.media3.ui.d] */
    /* JADX WARN: Type inference failed for: r9v4 */
    /* JADX WARN: Type inference failed for: r9v5, types: [android.view.View, android.view.ViewGroup, android.widget.TextView, androidx.media3.ui.b$a] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public b(Context context, AttributeSet attributeSet, int i2, AttributeSet attributeSet2) throws NoSuchMethodException {
        final b bVar;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i13;
        int i14;
        boolean z5;
        boolean z6;
        boolean z7;
        int resourceId;
        int i15;
        boolean z8;
        String str;
        String str2;
        Method method;
        int i16;
        Method method2;
        Method method3;
        Method method4;
        Class<?> cls;
        Method method5;
        ImageView imageView;
        View viewFindViewById;
        View viewFindViewById2;
        View viewFindViewById3;
        androidx.media3.ui.d dVar;
        int i17;
        int i18;
        ImageView imageView2;
        int i19;
        int i20;
        int i21;
        int i22;
        final b bVar2;
        int i23;
        int i24;
        int i25;
        int i26;
        Context context2;
        ?? r9;
        androidx.media3.ui.d dVar2;
        ImageView imageView3;
        ImageView imageView4;
        ImageView imageView5;
        ImageView imageView6;
        View view;
        ImageView imageView7;
        View view2;
        ImageView imageView8;
        ImageView imageView9;
        ImageView imageView10;
        super(context, attributeSet, i2);
        Class cls2 = Boolean.TYPE;
        int resourceId2 = cm3.a;
        int resourceId3 = el3.j;
        int i27 = el3.i;
        int i28 = el3.h;
        int i29 = el3.q;
        int i30 = el3.k;
        int i31 = el3.r;
        int i32 = el3.g;
        int i33 = el3.f;
        int i34 = el3.m;
        int i35 = el3.n;
        int i36 = el3.l;
        int i37 = el3.p;
        int i38 = el3.o;
        int i39 = el3.u;
        int resourceId4 = el3.t;
        int i40 = el3.v;
        this.A0 = true;
        this.D0 = 5000;
        this.G0 = 0;
        this.F0 = 200;
        if (attributeSet2 != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet2, gn3.r, i2, 0);
            try {
                resourceId2 = typedArrayObtainStyledAttributes.getResourceId(gn3.t, resourceId2);
                resourceId3 = typedArrayObtainStyledAttributes.getResourceId(gn3.z, resourceId3);
                int resourceId5 = typedArrayObtainStyledAttributes.getResourceId(gn3.y, i27);
                int resourceId6 = typedArrayObtainStyledAttributes.getResourceId(gn3.x, i28);
                int resourceId7 = typedArrayObtainStyledAttributes.getResourceId(gn3.u, i29);
                int resourceId8 = typedArrayObtainStyledAttributes.getResourceId(gn3.A, i30);
                int resourceId9 = typedArrayObtainStyledAttributes.getResourceId(gn3.F, i31);
                int resourceId10 = typedArrayObtainStyledAttributes.getResourceId(gn3.w, i32);
                int resourceId11 = typedArrayObtainStyledAttributes.getResourceId(gn3.v, i33);
                int resourceId12 = typedArrayObtainStyledAttributes.getResourceId(gn3.C, i34);
                int resourceId13 = typedArrayObtainStyledAttributes.getResourceId(gn3.D, i35);
                int resourceId14 = typedArrayObtainStyledAttributes.getResourceId(gn3.B, i36);
                int resourceId15 = typedArrayObtainStyledAttributes.getResourceId(gn3.P, i37);
                int resourceId16 = typedArrayObtainStyledAttributes.getResourceId(gn3.O, i38);
                int resourceId17 = typedArrayObtainStyledAttributes.getResourceId(gn3.R, i39);
                resourceId4 = typedArrayObtainStyledAttributes.getResourceId(gn3.Q, resourceId4);
                resourceId = typedArrayObtainStyledAttributes.getResourceId(gn3.U, i40);
                bVar = this;
                bVar.D0 = typedArrayObtainStyledAttributes.getInt(gn3.M, bVar.D0);
                bVar.G0 = d0(typedArrayObtainStyledAttributes, bVar.G0);
                boolean z9 = typedArrayObtainStyledAttributes.getBoolean(gn3.J, true);
                boolean z10 = typedArrayObtainStyledAttributes.getBoolean(gn3.G, true);
                z2 = typedArrayObtainStyledAttributes.getBoolean(gn3.I, true);
                boolean z11 = typedArrayObtainStyledAttributes.getBoolean(gn3.H, true);
                boolean z12 = typedArrayObtainStyledAttributes.getBoolean(gn3.K, false);
                boolean z13 = typedArrayObtainStyledAttributes.getBoolean(gn3.L, false);
                boolean z14 = typedArrayObtainStyledAttributes.getBoolean(gn3.N, false);
                bVar.E0 = typedArrayObtainStyledAttributes.getBoolean(gn3.T, false);
                bVar.setTimeBarMinUpdateInterval(typedArrayObtainStyledAttributes.getInt(gn3.S, bVar.F0));
                boolean z15 = typedArrayObtainStyledAttributes.getBoolean(gn3.s, true);
                typedArrayObtainStyledAttributes.recycle();
                z8 = z15;
                i15 = resourceId12;
                i4 = resourceId5;
                i5 = resourceId13;
                i6 = resourceId6;
                i7 = resourceId10;
                i8 = resourceId7;
                i9 = resourceId11;
                i10 = resourceId8;
                i11 = resourceId9;
                z3 = z9;
                z7 = z12;
                z4 = z10;
                z = z11;
                i3 = resourceId17;
                z5 = z14;
                i14 = resourceId14;
                i12 = resourceId16;
                z6 = z13;
                i13 = resourceId15;
            } catch (Throwable th) {
                typedArrayObtainStyledAttributes.recycle();
                throw th;
            }
        } else {
            bVar = this;
            i3 = i39;
            i4 = i27;
            i5 = i35;
            i6 = i28;
            i7 = i32;
            i8 = i29;
            i9 = i33;
            i10 = i30;
            i11 = i31;
            i12 = i38;
            z = true;
            z2 = true;
            z3 = true;
            z4 = true;
            i13 = i37;
            i14 = i36;
            z5 = false;
            z6 = false;
            z7 = false;
            resourceId = i40;
            i15 = i34;
            z8 = true;
        }
        LayoutInflater.from(context).inflate(resourceId2, bVar);
        bVar.setDescendantFocusability(262144);
        bVar.i = new c(bVar, null);
        bVar.p = new CopyOnWriteArrayList();
        bVar.T = new no4.b();
        bVar.U = new no4.d();
        StringBuilder sb = new StringBuilder();
        bVar.R = sb;
        int i41 = i3;
        bVar.S = new Formatter(sb, Locale.getDefault());
        bVar.H0 = new long[0];
        bVar.I0 = new boolean[0];
        bVar.J0 = new long[0];
        bVar.K0 = new boolean[0];
        bVar.V = new Runnable() { // from class: id3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                this.f.F0();
            }
        };
        try {
            Class[] clsArr = {cls2};
            str2 = "setScrubbingModeEnabled";
            try {
                method = ExoPlayer.class.getMethod(str2, clsArr);
                str = "isScrubbingModeEnabled";
                try {
                    i16 = resourceId3;
                    method2 = ExoPlayer.class.getMethod(str, null);
                } catch (ClassNotFoundException | NoSuchMethodException unused) {
                    i16 = resourceId3;
                    method2 = null;
                }
            } catch (ClassNotFoundException | NoSuchMethodException unused2) {
                str = "isScrubbingModeEnabled";
                method = null;
                i16 = resourceId3;
                method2 = null;
                Method method6 = method;
                bVar.j = ExoPlayer.class;
                bVar.k = method6;
                bVar.l = method2;
                cls = Class.forName("androidx.media3.transformer.CompositionPlayer");
                method4 = cls.getMethod(str2, cls2);
                method3 = null;
                method5 = cls.getMethod(str, null);
                bVar.m = cls;
                bVar.n = method4;
                bVar.o = method5;
                bVar.O = (TextView) bVar.findViewById(wl3.m);
                bVar.P = (TextView) bVar.findViewById(wl3.F);
                imageView = (ImageView) bVar.findViewById(wl3.Q);
                bVar.I = imageView;
                if (imageView != null) {
                }
                ImageView imageView11 = (ImageView) bVar.findViewById(wl3.s);
                bVar.J = imageView11;
                h0(imageView11, new View.OnClickListener() { // from class: jd3
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        this.f.p0(view3);
                    }
                });
                ImageView imageView12 = (ImageView) bVar.findViewById(wl3.y);
                bVar.K = imageView12;
                h0(imageView12, new View.OnClickListener() { // from class: jd3
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        this.f.p0(view3);
                    }
                });
                viewFindViewById = bVar.findViewById(wl3.M);
                bVar.L = viewFindViewById;
                if (viewFindViewById != null) {
                }
                viewFindViewById2 = bVar.findViewById(wl3.E);
                bVar.M = viewFindViewById2;
                if (viewFindViewById2 != null) {
                }
                viewFindViewById3 = bVar.findViewById(wl3.c);
                bVar.N = viewFindViewById3;
                if (viewFindViewById3 != null) {
                }
                dVar = (androidx.media3.ui.d) bVar.findViewById(wl3.H);
                View viewFindViewById4 = bVar.findViewById(wl3.I);
                if (dVar == null) {
                }
                dVar2 = bVar2.Q;
                if (dVar2 != null) {
                }
                bVar2.h = fy4.E();
                Resources resources = context2.getResources();
                bVar2.g = resources;
                imageView3 = (ImageView) bVar2.findViewById(wl3.D);
                bVar2.A = imageView3;
                if (imageView3 != null) {
                }
                imageView4 = (ImageView) bVar2.findViewById(wl3.G);
                bVar2.y = imageView4;
                if (imageView4 != null) {
                }
                imageView5 = (ImageView) bVar2.findViewById(wl3.z);
                bVar2.z = imageView5;
                if (imageView5 != null) {
                }
                Typeface typefaceG = ps3.g(context2, il3.a);
                imageView6 = (ImageView) bVar2.findViewById(wl3.K);
                TextView textView = (TextView) bVar2.findViewById(wl3.L);
                if (imageView6 == null) {
                }
                view = bVar2.C;
                if (view != null) {
                }
                imageView7 = (ImageView) bVar2.findViewById(wl3.q);
                TextView textView2 = (TextView) bVar2.findViewById(wl3.r);
                if (imageView7 == null) {
                }
                view2 = bVar2.B;
                if (view2 != null) {
                }
                imageView8 = (ImageView) bVar2.findViewById(wl3.J);
                bVar2.F = imageView8;
                if (imageView8 != null) {
                }
                imageView9 = (ImageView) bVar2.findViewById(wl3.N);
                bVar2.G = imageView9;
                if (imageView9 != null) {
                }
                bVar2.j0 = resources.getInteger(am3.b) / 100.0f;
                bVar2.k0 = resources.getInteger(am3.a) / 100.0f;
                imageView10 = (ImageView) bVar2.findViewById(wl3.V);
                bVar2.H = imageView10;
                if (imageView10 == null) {
                }
                de3 de3Var = new de3(bVar2);
                bVar2.f = de3Var;
                de3Var.U(z8);
                h hVar = bVar2.new h(new String[]{resources.getString(om3.i), resources.getString(om3.A)}, new Drawable[]{fy4.i0(context2, resources, el3.s), fy4.i0(context2, resources, el3.e)});
                bVar2.r = hVar;
                bVar2.x = resources.getDimensionPixelSize(wk3.a);
                RecyclerView recyclerView = (RecyclerView) LayoutInflater.from(context2).inflate(cm3.c, r9);
                bVar2.q = recyclerView;
                recyclerView.setAdapter(hVar);
                recyclerView.setLayoutManager(new LinearLayoutManager(bVar2.getContext()));
                PopupWindow popupWindow = new PopupWindow((View) recyclerView, -2, -2, true);
                bVar2.w = popupWindow;
                popupWindow.setOnDismissListener(bVar2.i);
                bVar2.M0 = true;
                bVar2.v = new fi0(bVar2.getResources());
                bVar2.n0 = fy4.i0(context2, resources, i25);
                bVar2.o0 = fy4.i0(context2, resources, i21);
                bVar2.p0 = resources.getString(om3.b);
                bVar2.q0 = resources.getString(om3.a);
                bVar2.t = new j(bVar2, r9);
                bVar2.u = new C0034b(bVar2, r9);
                bVar2.s = bVar2.new e(resources.getStringArray(ck3.a), N0);
                bVar2.W = fy4.i0(context2, resources, i24);
                bVar2.a0 = fy4.i0(context2, resources, i20);
                bVar2.r0 = fy4.i0(context2, resources, i23);
                bVar2.s0 = fy4.i0(context2, resources, i26);
                bVar2.b0 = fy4.i0(context2, resources, i18);
                bVar2.c0 = fy4.i0(context2, resources, i19);
                bVar2.d0 = fy4.i0(context2, resources, i14);
                bVar2.h0 = fy4.i0(context2, resources, i13);
                bVar2.i0 = fy4.i0(context2, resources, i17);
                bVar2.t0 = resources.getString(om3.d);
                bVar2.u0 = resources.getString(om3.c);
                bVar2.e0 = resources.getString(om3.k);
                bVar2.f0 = resources.getString(om3.l);
                bVar2.g0 = resources.getString(om3.j);
                bVar2.l0 = resources.getString(om3.o);
                bVar2.m0 = resources.getString(om3.n);
                de3Var.V((ViewGroup) bVar2.findViewById(wl3.e), true);
                de3Var.V(bVar2.B, z4);
                de3Var.V(bVar2.C, z3);
                de3Var.V(imageView4, z2);
                de3Var.V(imageView5, z);
                de3Var.V(imageView9, z7);
                de3Var.V(imageView2, z6);
                de3Var.V(imageView10, z5);
                de3Var.V(imageView8, bVar2.G0 == 0);
                bVar2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: kd3
                    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                    @Override // android.view.View.OnLayoutChangeListener
                    public final void onLayoutChange(View view3, int i42, int i43, int i44, int i45, int i46, int i47, int i48, int i49) {
                        this.a.q0(view3, i42, i43, i44, i45, i46, i47, i48, i49);
                    }
                });
            }
        } catch (ClassNotFoundException | NoSuchMethodException unused3) {
            str = "isScrubbingModeEnabled";
            str2 = "setScrubbingModeEnabled";
        }
        Method method62 = method;
        bVar.j = ExoPlayer.class;
        bVar.k = method62;
        bVar.l = method2;
        try {
            cls = Class.forName("androidx.media3.transformer.CompositionPlayer");
            try {
                method4 = cls.getMethod(str2, cls2);
                method3 = null;
            } catch (ClassNotFoundException | NoSuchMethodException unused4) {
                method3 = null;
                method4 = null;
            }
        } catch (ClassNotFoundException | NoSuchMethodException unused5) {
            method3 = null;
            method4 = null;
            cls = null;
        }
        try {
            method5 = cls.getMethod(str, null);
        } catch (ClassNotFoundException | NoSuchMethodException unused6) {
            method5 = method3;
        }
        bVar.m = cls;
        bVar.n = method4;
        bVar.o = method5;
        bVar.O = (TextView) bVar.findViewById(wl3.m);
        bVar.P = (TextView) bVar.findViewById(wl3.F);
        imageView = (ImageView) bVar.findViewById(wl3.Q);
        bVar.I = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(bVar.i);
        }
        ImageView imageView112 = (ImageView) bVar.findViewById(wl3.s);
        bVar.J = imageView112;
        h0(imageView112, new View.OnClickListener() { // from class: jd3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f.p0(view3);
            }
        });
        ImageView imageView122 = (ImageView) bVar.findViewById(wl3.y);
        bVar.K = imageView122;
        h0(imageView122, new View.OnClickListener() { // from class: jd3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view3) {
                this.f.p0(view3);
            }
        });
        viewFindViewById = bVar.findViewById(wl3.M);
        bVar.L = viewFindViewById;
        if (viewFindViewById != null) {
            viewFindViewById.setOnClickListener(bVar.i);
        }
        viewFindViewById2 = bVar.findViewById(wl3.E);
        bVar.M = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setOnClickListener(bVar.i);
        }
        viewFindViewById3 = bVar.findViewById(wl3.c);
        bVar.N = viewFindViewById3;
        if (viewFindViewById3 != null) {
            viewFindViewById3.setOnClickListener(bVar.i);
        }
        dVar = (androidx.media3.ui.d) bVar.findViewById(wl3.H);
        View viewFindViewById42 = bVar.findViewById(wl3.I);
        if (dVar == null) {
            bVar.Q = dVar;
            i17 = i12;
            i18 = i15;
            imageView2 = imageView;
            i19 = i5;
            i20 = i4;
            i21 = resourceId4;
            i22 = resourceId;
            bVar2 = bVar;
            i23 = i7;
            i24 = i16;
            i25 = i41;
            i26 = i9;
            r9 = method3;
            context2 = context;
        } else if (viewFindViewById42 != null) {
            i17 = i12;
            i19 = i5;
            i20 = i4;
            imageView2 = imageView;
            i21 = resourceId4;
            bVar2 = this;
            i18 = i15;
            i23 = i7;
            i22 = resourceId;
            i25 = i41;
            i24 = i16;
            i26 = i9;
            r9 = method3;
            context2 = context;
            DefaultTimeBar defaultTimeBar = new DefaultTimeBar(context2, null, 0, attributeSet2, wm3.a);
            defaultTimeBar.setId(wl3.H);
            defaultTimeBar.setLayoutParams(viewFindViewById42.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById42.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById42);
            viewGroup.removeView(viewFindViewById42);
            viewGroup.addView(defaultTimeBar, iIndexOfChild);
            bVar2.Q = defaultTimeBar;
        } else {
            i17 = i12;
            i18 = i15;
            imageView2 = imageView;
            i19 = i5;
            i20 = i4;
            i21 = resourceId4;
            i22 = resourceId;
            bVar2 = bVar;
            i23 = i7;
            i24 = i16;
            i25 = i41;
            i26 = i9;
            ?? r92 = method3;
            context2 = context;
            bVar2.Q = r92;
            r9 = r92;
        }
        dVar2 = bVar2.Q;
        if (dVar2 != null) {
            dVar2.a(bVar2.i);
        }
        bVar2.h = fy4.E();
        Resources resources2 = context2.getResources();
        bVar2.g = resources2;
        imageView3 = (ImageView) bVar2.findViewById(wl3.D);
        bVar2.A = imageView3;
        if (imageView3 != null) {
            imageView3.setOnClickListener(bVar2.i);
        }
        imageView4 = (ImageView) bVar2.findViewById(wl3.G);
        bVar2.y = imageView4;
        if (imageView4 != null) {
            imageView4.setImageDrawable(fy4.i0(context2, resources2, i10));
            imageView4.setOnClickListener(bVar2.i);
        }
        imageView5 = (ImageView) bVar2.findViewById(wl3.z);
        bVar2.z = imageView5;
        if (imageView5 != null) {
            imageView5.setImageDrawable(fy4.i0(context2, resources2, i6));
            imageView5.setOnClickListener(bVar2.i);
        }
        Typeface typefaceG2 = ps3.g(context2, il3.a);
        imageView6 = (ImageView) bVar2.findViewById(wl3.K);
        TextView textView3 = (TextView) bVar2.findViewById(wl3.L);
        if (imageView6 == null) {
            imageView6.setImageDrawable(fy4.i0(context2, resources2, i11));
            bVar2.C = imageView6;
            bVar2.E = r9;
        } else if (textView3 != null) {
            textView3.setTypeface(typefaceG2);
            bVar2.E = textView3;
            bVar2.C = textView3;
        } else {
            bVar2.E = r9;
            bVar2.C = r9;
        }
        view = bVar2.C;
        if (view != null) {
            view.setOnClickListener(bVar2.i);
        }
        imageView7 = (ImageView) bVar2.findViewById(wl3.q);
        TextView textView22 = (TextView) bVar2.findViewById(wl3.r);
        if (imageView7 == null) {
            imageView7.setImageDrawable(fy4.i0(context2, resources2, i8));
            bVar2.B = imageView7;
            bVar2.D = r9;
        } else if (textView22 != null) {
            textView22.setTypeface(typefaceG2);
            bVar2.D = textView22;
            bVar2.B = textView22;
        } else {
            bVar2.D = r9;
            bVar2.B = r9;
        }
        view2 = bVar2.B;
        if (view2 != null) {
            view2.setOnClickListener(bVar2.i);
        }
        imageView8 = (ImageView) bVar2.findViewById(wl3.J);
        bVar2.F = imageView8;
        if (imageView8 != null) {
            imageView8.setOnClickListener(bVar2.i);
        }
        imageView9 = (ImageView) bVar2.findViewById(wl3.N);
        bVar2.G = imageView9;
        if (imageView9 != null) {
            imageView9.setOnClickListener(bVar2.i);
        }
        bVar2.j0 = resources2.getInteger(am3.b) / 100.0f;
        bVar2.k0 = resources2.getInteger(am3.a) / 100.0f;
        imageView10 = (ImageView) bVar2.findViewById(wl3.V);
        bVar2.H = imageView10;
        if (imageView10 == null) {
            imageView10.setImageDrawable(fy4.i0(context2, resources2, i22));
            bVar2.x0(false, imageView10);
        }
        de3 de3Var2 = new de3(bVar2);
        bVar2.f = de3Var2;
        de3Var2.U(z8);
        h hVar2 = bVar2.new h(new String[]{resources2.getString(om3.i), resources2.getString(om3.A)}, new Drawable[]{fy4.i0(context2, resources2, el3.s), fy4.i0(context2, resources2, el3.e)});
        bVar2.r = hVar2;
        bVar2.x = resources2.getDimensionPixelSize(wk3.a);
        RecyclerView recyclerView2 = (RecyclerView) LayoutInflater.from(context2).inflate(cm3.c, r9);
        bVar2.q = recyclerView2;
        recyclerView2.setAdapter(hVar2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(bVar2.getContext()));
        PopupWindow popupWindow2 = new PopupWindow((View) recyclerView2, -2, -2, true);
        bVar2.w = popupWindow2;
        popupWindow2.setOnDismissListener(bVar2.i);
        bVar2.M0 = true;
        bVar2.v = new fi0(bVar2.getResources());
        bVar2.n0 = fy4.i0(context2, resources2, i25);
        bVar2.o0 = fy4.i0(context2, resources2, i21);
        bVar2.p0 = resources2.getString(om3.b);
        bVar2.q0 = resources2.getString(om3.a);
        bVar2.t = new j(bVar2, r9);
        bVar2.u = new C0034b(bVar2, r9);
        bVar2.s = bVar2.new e(resources2.getStringArray(ck3.a), N0);
        bVar2.W = fy4.i0(context2, resources2, i24);
        bVar2.a0 = fy4.i0(context2, resources2, i20);
        bVar2.r0 = fy4.i0(context2, resources2, i23);
        bVar2.s0 = fy4.i0(context2, resources2, i26);
        bVar2.b0 = fy4.i0(context2, resources2, i18);
        bVar2.c0 = fy4.i0(context2, resources2, i19);
        bVar2.d0 = fy4.i0(context2, resources2, i14);
        bVar2.h0 = fy4.i0(context2, resources2, i13);
        bVar2.i0 = fy4.i0(context2, resources2, i17);
        bVar2.t0 = resources2.getString(om3.d);
        bVar2.u0 = resources2.getString(om3.c);
        bVar2.e0 = resources2.getString(om3.k);
        bVar2.f0 = resources2.getString(om3.l);
        bVar2.g0 = resources2.getString(om3.j);
        bVar2.l0 = resources2.getString(om3.o);
        bVar2.m0 = resources2.getString(om3.n);
        de3Var2.V((ViewGroup) bVar2.findViewById(wl3.e), true);
        de3Var2.V(bVar2.B, z4);
        de3Var2.V(bVar2.C, z3);
        de3Var2.V(imageView4, z2);
        de3Var2.V(imageView5, z);
        de3Var2.V(imageView9, z7);
        de3Var2.V(imageView2, z6);
        de3Var2.V(imageView10, z5);
        de3Var2.V(imageView8, bVar2.G0 == 0);
        bVar2.addOnLayoutChangeListener(new View.OnLayoutChangeListener() { // from class: kd3
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // android.view.View.OnLayoutChangeListener
            public final void onLayoutChange(View view3, int i42, int i43, int i44, int i45, int i46, int i47, int i48, int i49) {
                this.a.q0(view3, i42, i43, i44, i45, i46, i47, i48, i49);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void A0(View view, boolean z) {
        if (view == null) {
            return;
        }
        if (z) {
            view.setVisibility(0);
        } else {
            view.setVisibility(8);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean Z(hd3 hd3Var, no4.d dVar) {
        no4 currentTimeline;
        int iV;
        if (!hd3Var.isCommandAvailable(17) || (iV = (currentTimeline = hd3Var.getCurrentTimeline()).v()) <= 1 || iV > 100) {
            return false;
        }
        for (int i2 = 0; i2 < iV; i2++) {
            if (currentTimeline.t(i2, dVar).m == -9223372036854775807L) {
                return false;
            }
        }
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static int d0(TypedArray typedArray, int i2) {
        return typedArray.getInt(gn3.E, i2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void h0(View view, View.OnClickListener onClickListener) {
        if (view == null) {
            return;
        }
        view.setVisibility(8);
        view.setOnClickListener(onClickListener);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static boolean l0(int i2) {
        return i2 == 90 || i2 == 89 || i2 == 85 || i2 == 79 || i2 == 126 || i2 == 127 || i2 == 87 || i2 == 88;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX INFO: Access modifiers changed from: private */
    public void setPlaybackSpeed(float f2) {
        hd3 hd3Var = this.v0;
        if (hd3Var == null || !hd3Var.isCommandAvailable(13)) {
            return;
        }
        hd3 hd3Var2 = this.v0;
        hd3Var2.setPlaybackParameters(hd3Var2.getPlaybackParameters().d(f2));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void B0(boolean z) {
        if (this.x0 == z) {
            return;
        }
        this.x0 = z;
        z0(this.J, z);
        z0(this.K, z);
        d dVar = this.w0;
        if (dVar != null) {
            dVar.a(z);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void C0() {
        boolean zIsCommandAvailable;
        boolean zIsCommandAvailable2;
        boolean zIsCommandAvailable3;
        boolean zIsCommandAvailable4;
        boolean zIsCommandAvailable5;
        if (n0() && this.y0) {
            hd3 hd3Var = this.v0;
            if (hd3Var != null) {
                zIsCommandAvailable = (this.z0 && Z(hd3Var, this.U)) ? hd3Var.isCommandAvailable(10) : hd3Var.isCommandAvailable(5);
                zIsCommandAvailable3 = hd3Var.isCommandAvailable(7);
                zIsCommandAvailable4 = hd3Var.isCommandAvailable(11);
                zIsCommandAvailable5 = hd3Var.isCommandAvailable(12);
                zIsCommandAvailable2 = hd3Var.isCommandAvailable(9);
            } else {
                zIsCommandAvailable = false;
                zIsCommandAvailable2 = false;
                zIsCommandAvailable3 = false;
                zIsCommandAvailable4 = false;
                zIsCommandAvailable5 = false;
            }
            if (zIsCommandAvailable4) {
                H0();
            }
            if (zIsCommandAvailable5) {
                y0();
            }
            x0(zIsCommandAvailable3, this.y);
            x0(zIsCommandAvailable4, this.C);
            x0(zIsCommandAvailable5, this.B);
            x0(zIsCommandAvailable2, this.z);
            androidx.media3.ui.d dVar = this.Q;
            if (dVar != null) {
                dVar.setEnabled(zIsCommandAvailable);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void D0() {
        if (n0() && this.y0 && this.A != null) {
            boolean zD1 = fy4.D1(this.v0, this.A0);
            Drawable drawable = zD1 ? this.W : this.a0;
            int i2 = zD1 ? om3.h : om3.g;
            this.A.setImageDrawable(drawable);
            this.A.setContentDescription(this.g.getString(i2));
            x0(fy4.C1(this.v0), this.A);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void E0() {
        hd3 hd3Var = this.v0;
        if (hd3Var == null) {
            return;
        }
        this.s.K(hd3Var.getPlaybackParameters().a);
        this.r.J(0, this.s.H());
        I0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void F0() {
        long contentPosition;
        long contentBufferedPosition;
        if (n0() && this.y0) {
            hd3 hd3Var = this.v0;
            if (hd3Var == null || !hd3Var.isCommandAvailable(16)) {
                contentPosition = 0;
                contentBufferedPosition = 0;
            } else {
                contentPosition = this.L0 + hd3Var.getContentPosition();
                contentBufferedPosition = this.L0 + hd3Var.getContentBufferedPosition();
            }
            TextView textView = this.P;
            if (textView != null && !this.C0) {
                textView.setText(fy4.y0(this.R, this.S, contentPosition));
            }
            androidx.media3.ui.d dVar = this.Q;
            if (dVar != null) {
                dVar.setPosition(contentPosition);
                androidx.media3.ui.d dVar2 = this.Q;
                if (m0(hd3Var)) {
                    contentBufferedPosition = contentPosition;
                }
                dVar2.setBufferedPosition(contentBufferedPosition);
            }
            removeCallbacks(this.V);
            int playbackState = hd3Var == null ? 1 : hd3Var.getPlaybackState();
            if (hd3Var == null || !hd3Var.isPlaying()) {
                if (playbackState == 4 || playbackState == 1) {
                    return;
                }
                postDelayed(this.V, 1000L);
                return;
            }
            androidx.media3.ui.d dVar3 = this.Q;
            long jMin = Math.min(dVar3 != null ? dVar3.getPreferredUpdateDelay() : 1000L, 1000 - (contentPosition % 1000));
            float f2 = hd3Var.getPlaybackParameters().a;
            postDelayed(this.V, fy4.t(f2 > 0.0f ? (long) (jMin / f2) : 1000L, this.F0, 1000L));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void G0() {
        ImageView imageView;
        if (n0() && this.y0 && (imageView = this.F) != null) {
            if (this.G0 == 0) {
                x0(false, imageView);
                return;
            }
            hd3 hd3Var = this.v0;
            if (hd3Var == null || !hd3Var.isCommandAvailable(15)) {
                x0(false, this.F);
                this.F.setImageDrawable(this.b0);
                this.F.setContentDescription(this.e0);
                return;
            }
            x0(true, this.F);
            int repeatMode = hd3Var.getRepeatMode();
            if (repeatMode == 0) {
                this.F.setImageDrawable(this.b0);
                this.F.setContentDescription(this.e0);
            } else if (repeatMode == 1) {
                this.F.setImageDrawable(this.c0);
                this.F.setContentDescription(this.f0);
            } else {
                if (repeatMode != 2) {
                    return;
                }
                this.F.setImageDrawable(this.d0);
                this.F.setContentDescription(this.g0);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void H0() {
        hd3 hd3Var = this.v0;
        int seekBackIncrement = (int) ((hd3Var != null ? hd3Var.getSeekBackIncrement() : 5000L) / 1000);
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(String.valueOf(seekBackIncrement));
        }
        View view = this.C;
        if (view != null) {
            view.setContentDescription(this.g.getQuantityString(lm3.b, seekBackIncrement, Integer.valueOf(seekBackIncrement)));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void I0() {
        x0(this.r.G(), this.L);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void J0() {
        this.q.measure(0, 0);
        this.w.setWidth(Math.min(this.q.getMeasuredWidth(), getWidth() - (this.x * 2)));
        this.w.setHeight(Math.min(getHeight() - (this.x * 2), this.q.getMeasuredHeight()));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void K0() {
        ImageView imageView;
        if (n0() && this.y0 && (imageView = this.G) != null) {
            hd3 hd3Var = this.v0;
            if (!this.f.B(imageView)) {
                x0(false, this.G);
                return;
            }
            if (hd3Var == null || !hd3Var.isCommandAvailable(14)) {
                x0(false, this.G);
                this.G.setImageDrawable(this.i0);
                this.G.setContentDescription(this.m0);
            } else {
                x0(true, this.G);
                this.G.setImageDrawable(hd3Var.getShuffleModeEnabled() ? this.h0 : this.i0);
                this.G.setContentDescription(hd3Var.getShuffleModeEnabled() ? this.l0 : this.m0);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0116  */
    /* JADX WARN: Type inference failed for: r9v6, types: [int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    /* JADX WARN: Type inference failed for: r9v8 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void L0() {
        int i2;
        long jC1;
        no4.d dVar;
        long j2;
        hd3 hd3Var = this.v0;
        if (hd3Var == null) {
            return;
        }
        boolean z = true;
        this.B0 = this.z0 && Z(hd3Var, this.U);
        long j3 = 0;
        this.L0 = 0L;
        no4 currentTimeline = hd3Var.isCommandAvailable(17) ? hd3Var.getCurrentTimeline() : no4.a;
        long j4 = -9223372036854775807L;
        if (!currentTimeline.w()) {
            int currentMediaItemIndex = hd3Var.getCurrentMediaItemIndex();
            boolean z2 = this.B0;
            int i3 = z2 ? 0 : currentMediaItemIndex;
            int iV = z2 ? currentTimeline.v() - 1 : currentMediaItemIndex;
            i2 = 0;
            long j5 = 0;
            while (true) {
                if (i3 > iV) {
                    break;
                }
                if (i3 == currentMediaItemIndex) {
                    this.L0 = fy4.S1(j5);
                }
                currentTimeline.t(i3, this.U);
                no4.d dVar2 = this.U;
                boolean z3 = z;
                long j6 = j3;
                if (dVar2.m == j4) {
                    gg3.v(this.B0 ^ z3);
                    break;
                }
                int i4 = dVar2.n;
                while (true) {
                    dVar = this.U;
                    if (i4 <= dVar.o) {
                        currentTimeline.l(i4, this.T);
                        int iQ = this.T.q();
                        int iD = this.T.d();
                        while (iQ < iD) {
                            long jG = this.T.g(iQ);
                            if (jG == Long.MIN_VALUE) {
                                j2 = j4;
                                long j7 = this.T.d;
                                if (j7 == j2) {
                                    iQ++;
                                    j4 = j2;
                                } else {
                                    jG = j7;
                                }
                            } else {
                                j2 = j4;
                            }
                            long jP = jG + this.T.p();
                            if (jP >= j6) {
                                long[] jArr = this.H0;
                                if (i2 == jArr.length) {
                                    ?? length = jArr.length == 0 ? z3 : jArr.length * 2;
                                    this.H0 = Arrays.copyOf(jArr, (int) length);
                                    this.I0 = Arrays.copyOf(this.I0, (int) length);
                                }
                                this.H0[i2] = fy4.S1(j5 + jP);
                                this.I0[i2] = this.T.r(iQ);
                                i2++;
                            }
                            iQ++;
                            j4 = j2;
                        }
                        i4++;
                    }
                }
                j5 += dVar.m;
                i3++;
                z = z3;
                j3 = j6;
            }
            jC1 = j5;
        } else if (hd3Var.isCommandAvailable(16)) {
            long contentDuration = hd3Var.getContentDuration();
            if (contentDuration != -9223372036854775807L) {
                jC1 = fy4.c1(contentDuration);
                i2 = 0;
            } else {
                i2 = 0;
                jC1 = 0;
            }
        }
        long jS1 = fy4.S1(jC1);
        TextView textView = this.O;
        if (textView != null) {
            textView.setText(fy4.y0(this.R, this.S, jS1));
        }
        androidx.media3.ui.d dVar3 = this.Q;
        if (dVar3 != null) {
            dVar3.setDuration(jS1);
            int length2 = this.J0.length;
            int i5 = i2 + length2;
            long[] jArr2 = this.H0;
            if (i5 > jArr2.length) {
                this.H0 = Arrays.copyOf(jArr2, i5);
                this.I0 = Arrays.copyOf(this.I0, i5);
            }
            System.arraycopy(this.J0, 0, this.H0, i2, length2);
            System.arraycopy(this.K0, 0, this.I0, i2, length2);
            this.Q.b(this.H0, this.I0, i5);
        }
        F0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void M0() {
        g0();
        x0(this.t.g() > 0, this.I);
        I0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void Y(m mVar) {
        gg3.q(mVar);
        this.p.add(mVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean a0(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        hd3 hd3Var = this.v0;
        if (hd3Var == null || !l0(keyCode)) {
            return false;
        }
        if (keyEvent.getAction() != 0) {
            return true;
        }
        if (keyCode == 90) {
            if (hd3Var.getPlaybackState() == 4 || !hd3Var.isCommandAvailable(12)) {
                return true;
            }
            hd3Var.seekForward();
            return true;
        }
        if (keyCode == 89 && hd3Var.isCommandAvailable(11)) {
            hd3Var.seekBack();
            return true;
        }
        if (keyEvent.getRepeatCount() != 0) {
            return true;
        }
        if (keyCode == 79 || keyCode == 85) {
            fy4.I0(hd3Var, this.A0);
            return true;
        }
        if (keyCode == 87) {
            if (!hd3Var.isCommandAvailable(9)) {
                return true;
            }
            hd3Var.seekToNext();
            return true;
        }
        if (keyCode == 88) {
            if (!hd3Var.isCommandAvailable(7)) {
                return true;
            }
            hd3Var.seekToPrevious();
            return true;
        }
        if (keyCode == 126) {
            fy4.H0(hd3Var);
            return true;
        }
        if (keyCode != 127) {
            return true;
        }
        fy4.G0(hd3Var);
        return true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void b0(RecyclerView.h hVar, View view) {
        this.q.setAdapter(hVar);
        J0();
        this.M0 = false;
        this.w.dismiss();
        this.M0 = true;
        this.w.showAsDropDown(view, (getWidth() - this.w.getWidth()) - this.x, (-this.w.getHeight()) - this.x);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final xi1 c0(xr4 xr4Var, int i2) {
        xi1.a aVar = new xi1.a();
        xi1 xi1VarB = xr4Var.b();
        for (int i3 = 0; i3 < xi1VarB.size(); i3++) {
            xr4.a aVar2 = (xr4.a) xi1VarB.get(i3);
            if (aVar2.e() == i2) {
                for (int i4 = 0; i4 < aVar2.a; i4++) {
                    if (aVar2.i(i4)) {
                        t41 t41VarD = aVar2.d(i4);
                        if ((t41VarD.e & 2) == 0) {
                            aVar.a(new k(xr4Var, i3, i4, this.v.a(t41VarD)));
                        }
                    }
                }
            }
        }
        return aVar.k();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return a0(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e0() {
        this.f.D();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void f0() {
        this.f.G();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void g0() {
        this.t.H();
        this.u.H();
        hd3 hd3Var = this.v0;
        if (hd3Var != null && hd3Var.isCommandAvailable(30) && this.v0.isCommandAvailable(29)) {
            xr4 currentTracks = this.v0.getCurrentTracks();
            this.u.O(c0(currentTracks, 1));
            boolean zB = this.f.B(this.I);
            j jVar = this.t;
            if (zB) {
                jVar.N(c0(currentTracks, 3));
            } else {
                jVar.N(xi1.u());
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public hd3 getPlayer() {
        return this.v0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getRepeatToggleModes() {
        return this.G0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean getShowShuffleButton() {
        return this.f.B(this.G);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean getShowSubtitleButton() {
        return this.f.B(this.I);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int getShowTimeoutMs() {
        return this.D0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean getShowVrButton() {
        return this.f.B(this.H);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.View
    public boolean hasOverlappingRendering() {
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean i0(hd3 hd3Var) {
        Class cls;
        return (hd3Var == null || (cls = this.m) == null || !cls.isAssignableFrom(hd3Var.getClass())) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean j0(hd3 hd3Var) {
        Class cls;
        return (hd3Var == null || (cls = this.j) == null || !cls.isAssignableFrom(hd3Var.getClass())) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean k0() {
        return this.f.J();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean m0(hd3 hd3Var) {
        try {
            if (j0(hd3Var) && ((Boolean) gg3.q(((Method) gg3.q(this.l)).invoke(hd3Var, null))).booleanValue()) {
                return true;
            }
            if (i0(hd3Var)) {
                return ((Boolean) gg3.q(((Method) gg3.q(this.o)).invoke(hd3Var, null))).booleanValue();
            }
            return false;
        } catch (IllegalAccessException | InvocationTargetException e2) {
            wg1.a(e2);
            return false;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean n0() {
        return getVisibility() == 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void o0() {
        Iterator it = this.p.iterator();
        while (it.hasNext()) {
            ((m) it.next()).s(getVisibility());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f.L();
        this.y0 = true;
        if (k0()) {
            this.f.T();
        }
        w0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f.M();
        this.y0 = false;
        removeCallbacks(this.V);
        this.f.S();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        this.f.N(z, i2, i3, i4, i5);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void p0(View view) {
        B0(!this.x0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void q0(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
        int i10 = i5 - i3;
        int i11 = i9 - i7;
        if (!(i4 - i2 == i8 - i6 && i10 == i11) && this.w.isShowing()) {
            J0();
            this.w.update(view, (getWidth() - this.w.getWidth()) - this.x, (-this.w.getHeight()) - this.x, -1, -1);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void r0(int i2) {
        if (i2 == 0) {
            b0(this.s, (View) gg3.q(this.L));
        } else if (i2 == 1) {
            b0(this.u, (View) gg3.q(this.L));
        } else {
            this.w.dismiss();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void s0(m mVar) {
        this.p.remove(mVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setAnimationEnabled(boolean z) {
        this.f.U(z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setMediaRouteButtonViewProvider(x45 x45Var) {
        View viewFindViewById = findViewById(wl3.w);
        if (viewFindViewById == null) {
            e04.a("The media route button placeholder is missing.");
            return;
        }
        if (x45Var == null) {
            viewFindViewById.setVisibility(8);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) viewFindViewById.getParent();
        if (viewGroup == null) {
            e04.a("The media route button placeholder has no parent view.");
            return;
        }
        lu1 lu1VarA = x45Var.a(viewGroup);
        a aVar = new a(viewFindViewById, viewGroup);
        Handler handler = this.h;
        Objects.requireNonNull(handler);
        x81.a(lu1VarA, aVar, new ce(handler));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public void setOnFullScreenModeChangedListener(d dVar) {
        this.w0 = dVar;
        A0(this.J, dVar != null);
        A0(this.K, dVar != null);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setPlayer(hd3 hd3Var) {
        gg3.v(Looper.myLooper() == Looper.getMainLooper());
        gg3.d(hd3Var == null || hd3Var.getApplicationLooper() == Looper.getMainLooper());
        hd3 hd3Var2 = this.v0;
        if (hd3Var2 == hd3Var) {
            return;
        }
        if (hd3Var2 != null) {
            hd3Var2.removeListener(this.i);
        }
        this.v0 = hd3Var;
        if (hd3Var != null) {
            hd3Var.addListener(this.i);
        }
        w0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setProgressUpdateListener(f fVar) {
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setRepeatToggleModes(int i2) {
        this.G0 = i2;
        hd3 hd3Var = this.v0;
        if (hd3Var != null && hd3Var.isCommandAvailable(15)) {
            int repeatMode = this.v0.getRepeatMode();
            if (i2 == 0 && repeatMode != 0) {
                this.v0.setRepeatMode(0);
            } else if (i2 == 1 && repeatMode == 2) {
                this.v0.setRepeatMode(1);
            } else if (i2 == 2 && repeatMode == 1) {
                this.v0.setRepeatMode(2);
            }
        }
        this.f.V(this.F, i2 != 0);
        G0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setShowFastForwardButton(boolean z) {
        this.f.V(this.B, z);
        C0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z) {
        this.z0 = z;
        L0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setShowNextButton(boolean z) {
        this.f.V(this.z, z);
        C0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z) {
        this.A0 = z;
        D0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setShowPreviousButton(boolean z) {
        this.f.V(this.y, z);
        C0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setShowRewindButton(boolean z) {
        this.f.V(this.C, z);
        C0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setShowShuffleButton(boolean z) {
        this.f.V(this.G, z);
        K0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setShowSubtitleButton(boolean z) {
        this.f.V(this.I, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setShowTimeoutMs(int i2) {
        this.D0 = i2;
        if (k0()) {
            this.f.T();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setShowVrButton(boolean z) {
        this.f.V(this.H, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTimeBarMinUpdateInterval(int i2) {
        this.F0 = fy4.s(i2, 16, 1000);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setTimeBarScrubbingEnabled(boolean z) {
        this.E0 = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setVrButtonListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.H;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
            x0(onClickListener != null, this.H);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void t0() {
        ImageView imageView = this.A;
        if (imageView != null) {
            imageView.requestFocus();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void u0(hd3 hd3Var, long j2) {
        if (this.B0) {
            if (hd3Var.isCommandAvailable(17) && hd3Var.isCommandAvailable(10)) {
                no4 currentTimeline = hd3Var.getCurrentTimeline();
                int iV = currentTimeline.v();
                int i2 = 0;
                while (true) {
                    long jE = currentTimeline.t(i2, this.U).e();
                    if (j2 < jE) {
                        break;
                    }
                    if (i2 == iV - 1) {
                        j2 = jE;
                        break;
                    } else {
                        j2 -= jE;
                        i2++;
                    }
                }
                hd3Var.seekTo(i2, j2);
            }
        } else if (hd3Var.isCommandAvailable(5)) {
            hd3Var.seekTo(j2);
        }
        F0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void v0() {
        this.f.Y();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void w0() {
        D0();
        C0();
        G0();
        K0();
        M0();
        E0();
        L0();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void x0(boolean z, View view) {
        if (view == null) {
            return;
        }
        view.setEnabled(z);
        view.setAlpha(z ? this.j0 : this.k0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void y0() {
        hd3 hd3Var = this.v0;
        int seekForwardIncrement = (int) ((hd3Var != null ? hd3Var.getSeekForwardIncrement() : 15000L) / 1000);
        TextView textView = this.D;
        if (textView != null) {
            textView.setText(String.valueOf(seekForwardIncrement));
        }
        View view = this.B;
        if (view != null) {
            view.setContentDescription(this.g.getQuantityString(lm3.a, seekForwardIncrement, Integer.valueOf(seekForwardIncrement)));
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void z0(ImageView imageView, boolean z) {
        if (imageView == null) {
            return;
        }
        if (z) {
            imageView.setImageDrawable(this.r0);
            imageView.setContentDescription(this.t0);
        } else {
            imageView.setImageDrawable(this.s0);
            imageView.setContentDescription(this.u0);
        }
    }

    /* JADX INFO: renamed from: androidx.media3.ui.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class C0034b extends l {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public C0034b() {
            super();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ void M(C0034b c0034b, View view) {
            if (b.this.v0 == null || !b.this.v0.isCommandAvailable(29)) {
                return;
            }
            ((hd3) fy4.l(b.this.v0)).setTrackSelectionParameters(b.this.v0.getTrackSelectionParameters().M().M(1).a0(1, false).K());
            b.this.r.J(1, b.this.getResources().getString(om3.y));
            b.this.w.dismiss();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.ui.b.l
        public void J(i iVar) {
            iVar.z.setText(om3.y);
            iVar.A.setVisibility(N(((hd3) gg3.q(b.this.v0)).getTrackSelectionParameters()) ? 4 : 0);
            iVar.f.setOnClickListener(new View.OnClickListener() { // from class: ld3
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.C0034b.M(this.f, view);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.ui.b.l
        public void L(String str) {
            b.this.r.J(1, str);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final boolean N(lr4 lr4Var) {
            for (int i = 0; i < this.d.size(); i++) {
                if (lr4Var.H.containsKey(((k) this.d.get(i)).a.c())) {
                    return true;
                }
            }
            return false;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void O(List list) {
            this.d = list;
            lr4 trackSelectionParameters = ((hd3) gg3.q(b.this.v0)).getTrackSelectionParameters();
            if (list.isEmpty()) {
                b.this.r.J(1, b.this.getResources().getString(om3.z));
                return;
            }
            if (!N(trackSelectionParameters)) {
                b.this.r.J(1, b.this.getResources().getString(om3.y));
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                k kVar = (k) list.get(i);
                if (kVar.a()) {
                    b.this.r.J(1, kVar.c);
                    return;
                }
            }
        }

        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR (r1v0 androidx.media3.ui.b) A[MD:(androidx.media3.ui.b):void (m)] (LINE:7) call: androidx.media3.ui.b.b.<init>(androidx.media3.ui.b):void type: THIS */
        public /* synthetic */ C0034b(b bVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class c implements hd3.d, d.a, View.OnClickListener, PopupWindow.OnDismissListener {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.ui.d.a
        public void a(androidx.media3.ui.d dVar, long j) {
            b.this.C0 = true;
            if (b.this.P != null) {
                b.this.P.setText(fy4.y0(b.this.R, b.this.S, j));
            }
            b.this.f.S();
            if (b.this.v0 != null && b.this.E0) {
                b bVar = b.this;
                boolean zJ0 = bVar.j0(bVar.v0);
                b bVar2 = b.this;
                if (zJ0) {
                    try {
                        ((Method) gg3.q(bVar2.k)).invoke(b.this.v0, Boolean.TRUE);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        wg1.a(e);
                        return;
                    }
                } else {
                    boolean zI0 = bVar2.i0(bVar2.v0);
                    b bVar3 = b.this;
                    if (zI0) {
                        try {
                            ((Method) gg3.q(bVar3.n)).invoke(b.this.v0, Boolean.TRUE);
                        } catch (IllegalAccessException | InvocationTargetException e2) {
                            wg1.a(e2);
                            return;
                        }
                    } else {
                        xz1.i("PlayerControlView", "Time bar scrubbing is enabled, but player is not an ExoPlayer or CompositionPlayer instance, so ignoring (because we can't enable scrubbing mode). player.class=" + ((hd3) gg3.q(bVar3.v0)).getClass());
                    }
                }
            }
            b bVar4 = b.this;
            if (bVar4.m0(bVar4.v0)) {
                b bVar5 = b.this;
                bVar5.u0(bVar5.v0, j);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            hd3 hd3Var = b.this.v0;
            if (hd3Var == null) {
                return;
            }
            b.this.f.T();
            if (b.this.z == view) {
                if (hd3Var.isCommandAvailable(9)) {
                    hd3Var.seekToNext();
                    return;
                }
                return;
            }
            if (b.this.y == view) {
                if (hd3Var.isCommandAvailable(7)) {
                    hd3Var.seekToPrevious();
                    return;
                }
                return;
            }
            if (b.this.B == view) {
                if (hd3Var.getPlaybackState() == 4 || !hd3Var.isCommandAvailable(12)) {
                    return;
                }
                hd3Var.seekForward();
                return;
            }
            if (b.this.C == view) {
                if (hd3Var.isCommandAvailable(11)) {
                    hd3Var.seekBack();
                    return;
                }
                return;
            }
            ImageView imageView = b.this.A;
            b bVar = b.this;
            if (imageView == view) {
                fy4.I0(hd3Var, bVar.A0);
                return;
            }
            if (bVar.F == view) {
                if (hd3Var.isCommandAvailable(15)) {
                    hd3Var.setRepeatMode(nq3.a(hd3Var.getRepeatMode(), b.this.G0));
                    return;
                }
                return;
            }
            if (b.this.G == view) {
                if (hd3Var.isCommandAvailable(14)) {
                    hd3Var.setShuffleModeEnabled(!hd3Var.getShuffleModeEnabled());
                    return;
                }
                return;
            }
            View view2 = b.this.L;
            b bVar2 = b.this;
            if (view2 == view) {
                bVar2.f.S();
                b bVar3 = b.this;
                bVar3.b0(bVar3.r, b.this.L);
                return;
            }
            View view3 = bVar2.M;
            b bVar4 = b.this;
            if (view3 == view) {
                bVar4.f.S();
                b bVar5 = b.this;
                bVar5.b0(bVar5.s, b.this.M);
                return;
            }
            View view4 = bVar4.N;
            b bVar6 = b.this;
            if (view4 == view) {
                bVar6.f.S();
                b bVar7 = b.this;
                bVar7.b0(bVar7.u, b.this.N);
            } else if (bVar6.I == view) {
                b.this.f.S();
                b bVar8 = b.this;
                bVar8.b0(bVar8.t, b.this.I);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.widget.PopupWindow.OnDismissListener
        public void onDismiss() {
            if (b.this.M0) {
                b.this.f.T();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // hd3.d
        public void onEvents(hd3 hd3Var, hd3.c cVar) {
            if (cVar.a(4, 5, 13)) {
                b.this.D0();
            }
            if (cVar.a(4, 5, 7, 13)) {
                b.this.F0();
            }
            if (cVar.a(8, 13)) {
                b.this.G0();
            }
            if (cVar.a(9, 13)) {
                b.this.K0();
            }
            if (cVar.a(8, 9, 11, 0, 16, 17, 13)) {
                b.this.C0();
            }
            if (cVar.a(11, 0, 13)) {
                b.this.L0();
            }
            if (cVar.a(12, 13)) {
                b.this.E0();
            }
            if (cVar.a(2, 13)) {
                b.this.M0();
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.ui.d.a
        public void s(androidx.media3.ui.d dVar, long j) {
            if (b.this.P != null) {
                b.this.P.setText(fy4.y0(b.this.R, b.this.S, j));
            }
            b bVar = b.this;
            if (bVar.m0(bVar.v0)) {
                b bVar2 = b.this;
                bVar2.u0(bVar2.v0, j);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.ui.d.a
        public void v(androidx.media3.ui.d dVar, long j, boolean z) {
            b.this.C0 = false;
            if (b.this.v0 != null) {
                if (!z) {
                    b bVar = b.this;
                    bVar.u0(bVar.v0, j);
                }
                b bVar2 = b.this;
                boolean zJ0 = bVar2.j0(bVar2.v0);
                b bVar3 = b.this;
                if (zJ0) {
                    try {
                        ((Method) gg3.q(bVar3.k)).invoke(b.this.v0, Boolean.FALSE);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        wg1.a(e);
                        return;
                    }
                } else if (bVar3.i0(bVar3.v0)) {
                    try {
                        ((Method) gg3.q(b.this.n)).invoke(b.this.v0, Boolean.FALSE);
                    } catch (IllegalAccessException | InvocationTargetException e2) {
                        wg1.a(e2);
                        return;
                    }
                }
            }
            b.this.f.T();
        }

        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR (r1v0 androidx.media3.ui.b) A[MD:(androidx.media3.ui.b):void (m)] (LINE:7) call: androidx.media3.ui.b.c.<init>(androidx.media3.ui.b):void type: THIS */
        public /* synthetic */ c(b bVar, a aVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class j extends l {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public j() {
            super();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static /* synthetic */ void M(j jVar, View view) {
            if (b.this.v0 == null || !b.this.v0.isCommandAvailable(29)) {
                return;
            }
            b.this.v0.setTrackSelectionParameters(b.this.v0.getTrackSelectionParameters().M().M(3).T(-3).X(null).Z(0).K());
            b.this.w.dismiss();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: v(Landroidx/recyclerview/widget/RecyclerView$g0;I)V */
        @Override // androidx.media3.ui.b.l, androidx.recyclerview.widget.RecyclerView.h
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public void v(i iVar, int i) {
            super.v(iVar, i);
            if (i > 0) {
                iVar.A.setVisibility(((k) this.d.get(i + (-1))).a() ? 0 : 4);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.ui.b.l
        public void J(i iVar) {
            boolean z;
            iVar.z.setText(om3.z);
            int i = 0;
            while (true) {
                if (i >= this.d.size()) {
                    z = true;
                    break;
                } else {
                    if (((k) this.d.get(i)).a()) {
                        z = false;
                        break;
                    }
                    i++;
                }
            }
            iVar.A.setVisibility(z ? 0 : 4);
            iVar.f.setOnClickListener(new View.OnClickListener() { // from class: od3
                /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    b.j.M(this.f, view);
                }
            });
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // androidx.media3.ui.b.l
        public void L(String str) {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void N(List list) {
            boolean z = false;
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    break;
                }
                if (((k) list.get(i)).a()) {
                    z = true;
                    break;
                }
                i++;
            }
            if (b.this.I != null) {
                ImageView imageView = b.this.I;
                b bVar = b.this;
                imageView.setImageDrawable(z ? bVar.n0 : bVar.o0);
                ImageView imageView2 = b.this.I;
                b bVar2 = b.this;
                imageView2.setContentDescription(z ? bVar2.p0 : bVar2.q0);
            }
            this.d = list;
        }

        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR (r1v0 androidx.media3.ui.b) A[MD:(androidx.media3.ui.b):void (m)] (LINE:7) call: androidx.media3.ui.b.j.<init>(androidx.media3.ui.b):void type: THIS */
        public /* synthetic */ j(b bVar, a aVar) {
            this();
        }
    }
}
