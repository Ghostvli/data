package androidx.media3.ui;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.AttachedSurfaceControl;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.window.SurfaceSyncGroup;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.image.ImageOutput;
import androidx.media3.ui.AspectRatioFrameLayout;
import androidx.media3.ui.PlayerView;
import androidx.media3.ui.b;
import defpackage.c30;
import defpackage.cm3;
import defpackage.dc4;
import defpackage.e35;
import defpackage.el3;
import defpackage.fy4;
import defpackage.gg3;
import defpackage.gn3;
import defpackage.h25;
import defpackage.hd3;
import defpackage.l02;
import defpackage.lu0;
import defpackage.no4;
import defpackage.om3;
import defpackage.qe3;
import defpackage.qk3;
import defpackage.re3;
import defpackage.w3;
import defpackage.w50;
import defpackage.wg1;
import defpackage.wl3;
import defpackage.x45;
import defpackage.xi1;
import defpackage.xr4;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class PlayerView extends FrameLayout {
    public int A;
    public int B;
    public Drawable C;
    public int D;
    public boolean E;
    public CharSequence F;
    public int G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public final c f;
    public final AspectRatioFrameLayout g;
    public final View h;
    public final View i;
    public final boolean j;
    public final f k;
    public final ImageView l;
    public final ImageView m;
    public final SubtitleView n;
    public final View o;
    public final TextView p;
    public final androidx.media3.ui.b q;
    public final FrameLayout r;
    public final FrameLayout s;
    public final Handler t;
    public final Class u;
    public final Method v;
    public final Object w;
    public hd3 x;
    public boolean y;
    public b.m z;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public static void a(SurfaceView surfaceView) {
            surfaceView.setSurfaceLifecycle(2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class c implements hd3.d, View.OnClickListener, b.m, b.d {
        public final no4.b f = new no4.b();
        public Object g;

        public c() {
        }

        @Override // androidx.media3.ui.b.d
        public void a(boolean z) {
            PlayerView.p(PlayerView.this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            PlayerView.this.U();
        }

        @Override // hd3.d
        public void onCues(w50 w50Var) {
            if (PlayerView.this.n != null) {
                PlayerView.this.n.setCues(w50Var.a);
            }
        }

        @Override // hd3.d
        public void onPlayWhenReadyChanged(boolean z, int i) {
            PlayerView.this.W();
            PlayerView.this.Y();
        }

        @Override // hd3.d
        public void onPlaybackStateChanged(int i) {
            PlayerView.this.W();
            PlayerView.this.Z();
            PlayerView.this.Y();
        }

        @Override // hd3.d
        public void onPositionDiscontinuity(hd3.e eVar, hd3.e eVar2, int i) {
            if (PlayerView.this.J() && PlayerView.this.I) {
                PlayerView.this.F();
            }
        }

        @Override // hd3.d
        public void onRenderedFirstFrame() {
            if (PlayerView.this.h != null) {
                PlayerView.this.h.setVisibility(4);
                boolean zB = PlayerView.this.B();
                PlayerView playerView = PlayerView.this;
                if (zB) {
                    playerView.G();
                } else {
                    playerView.D();
                }
            }
        }

        @Override // hd3.d
        public void onSurfaceSizeChanged(int i, int i2) {
            if (Build.VERSION.SDK_INT == 34 && (PlayerView.this.i instanceof SurfaceView) && PlayerView.this.K) {
                f fVar = (f) gg3.q(PlayerView.this.k);
                Handler handler = PlayerView.this.t;
                SurfaceView surfaceView = (SurfaceView) PlayerView.this.i;
                final PlayerView playerView = PlayerView.this;
                fVar.d(handler, surfaceView, new Runnable() { // from class: pe3
                    @Override // java.lang.Runnable
                    public final void run() {
                        playerView.invalidate();
                    }
                });
            }
        }

        @Override // hd3.d
        public void onTracksChanged(xr4 xr4Var) {
            hd3 hd3Var = (hd3) gg3.q(PlayerView.this.x);
            no4 currentTimeline = hd3Var.isCommandAvailable(17) ? hd3Var.getCurrentTimeline() : no4.a;
            if (currentTimeline.w()) {
                this.g = null;
            } else if (!hd3Var.isCommandAvailable(30) || hd3Var.getCurrentTracks().c()) {
                Object obj = this.g;
                if (obj != null) {
                    int iH = currentTimeline.h(obj);
                    if (iH != -1) {
                        if (hd3Var.getCurrentMediaItemIndex() == currentTimeline.l(iH, this.f).c) {
                            return;
                        }
                    }
                    this.g = null;
                }
            } else {
                this.g = currentTimeline.m(hd3Var.getCurrentPeriodIndex(), this.f, true).b;
            }
            PlayerView.this.a0(false);
        }

        @Override // hd3.d
        public void onVideoSizeChanged(e35 e35Var) {
            if (e35Var.equals(e35.e) || PlayerView.this.x == null || PlayerView.this.x.getPlaybackState() == 1) {
                return;
            }
            PlayerView.this.V();
        }

        @Override // androidx.media3.ui.b.m
        public void s(int i) {
            PlayerView.this.X();
            PlayerView.o(PlayerView.this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface d {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface e {
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class f {
        public SurfaceSyncGroup a;

        public f() {
        }

        public static /* synthetic */ void a(f fVar, SurfaceView surfaceView, Runnable runnable) {
            fVar.getClass();
            AttachedSurfaceControl rootSurfaceControl = surfaceView.getRootSurfaceControl();
            if (rootSurfaceControl == null) {
                return;
            }
            SurfaceSyncGroup surfaceSyncGroupA = qe3.a("exo-sync-b-334901521");
            fVar.a = surfaceSyncGroupA;
            gg3.v(surfaceSyncGroupA.add(rootSurfaceControl, new Runnable() { // from class: te3
                @Override // java.lang.Runnable
                public final void run() {
                    PlayerView.f.b();
                }
            }));
            runnable.run();
            rootSurfaceControl.applyTransactionOnDraw(re3.a());
        }

        public static /* synthetic */ void b() {
        }

        public void c() {
            SurfaceSyncGroup surfaceSyncGroup = this.a;
            if (surfaceSyncGroup != null) {
                surfaceSyncGroup.markSyncReady();
                this.a = null;
            }
        }

        public void d(Handler handler, final SurfaceView surfaceView, final Runnable runnable) {
            handler.post(new Runnable() { // from class: se3
                @Override // java.lang.Runnable
                public final void run() {
                    PlayerView.f.a(this.f, surfaceView, runnable);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r22v0, types: [android.view.View, android.view.ViewGroup, androidx.media3.ui.PlayerView] */
    /* JADX WARN: Type inference failed for: r3v1, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r3v2, types: [androidx.media3.ui.PlayerView$a] */
    /* JADX WARN: Type inference failed for: r3v38 */
    /* JADX WARN: Type inference failed for: r3v40 */
    /* JADX WARN: Type inference failed for: r5v5 */
    /* JADX WARN: Type inference failed for: r5v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r5v7 */
    public PlayerView(Context context, AttributeSet attributeSet, int i) throws Throwable {
        Throwable th;
        int i2;
        int i3;
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        boolean z5;
        boolean z6;
        boolean z7;
        ?? r3;
        Class<ExoPlayer> cls;
        Object objNewProxyInstance;
        Method method;
        int i11;
        super(context, attributeSet, i);
        c cVar = new c();
        this.f = cVar;
        this.t = new Handler(Looper.getMainLooper());
        if (isInEditMode()) {
            this.g = null;
            this.h = null;
            this.i = null;
            this.j = false;
            this.k = null;
            this.l = null;
            this.m = null;
            this.n = null;
            this.o = null;
            this.p = null;
            this.q = null;
            this.r = null;
            this.s = null;
            this.u = null;
            this.v = null;
            this.w = null;
            ImageView imageView = new ImageView(context);
            z(context, getResources(), imageView);
            addView(imageView);
            return;
        }
        int i12 = cm3.b;
        if (attributeSet != null) {
            TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, gn3.V, i, 0);
            try {
                boolean zHasValue = typedArrayObtainStyledAttributes.hasValue(gn3.h0);
                int color = typedArrayObtainStyledAttributes.getColor(gn3.h0, 0);
                int resourceId = typedArrayObtainStyledAttributes.getResourceId(gn3.d0, i12);
                boolean z8 = typedArrayObtainStyledAttributes.getBoolean(gn3.j0, true);
                int i13 = typedArrayObtainStyledAttributes.getInt(gn3.W, 1);
                int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(gn3.Y, 0);
                int i14 = typedArrayObtainStyledAttributes.getInt(gn3.b0, 0);
                th = null;
                boolean z9 = typedArrayObtainStyledAttributes.getBoolean(gn3.k0, true);
                int i15 = typedArrayObtainStyledAttributes.getInt(gn3.i0, 1);
                int i16 = typedArrayObtainStyledAttributes.getInt(gn3.e0, 0);
                i2 = typedArrayObtainStyledAttributes.getInt(gn3.g0, 5000);
                boolean z10 = typedArrayObtainStyledAttributes.getBoolean(gn3.a0, true);
                boolean z11 = typedArrayObtainStyledAttributes.getBoolean(gn3.X, true);
                int integer = typedArrayObtainStyledAttributes.getInteger(gn3.f0, 0);
                this.E = typedArrayObtainStyledAttributes.getBoolean(gn3.c0, this.E);
                boolean z12 = typedArrayObtainStyledAttributes.getBoolean(gn3.Z, true);
                typedArrayObtainStyledAttributes.recycle();
                i5 = resourceId2;
                z2 = z10;
                z5 = zHasValue;
                i6 = i16;
                z4 = z12;
                i3 = resourceId;
                z = z9;
                z3 = z11;
                z6 = z8;
                i8 = i14;
                i10 = i13;
                i9 = color;
                i7 = i15;
                i4 = integer;
            } catch (Throwable th2) {
                typedArrayObtainStyledAttributes.recycle();
                throw th2;
            }
        } else {
            th = null;
            i2 = 5000;
            i3 = i12;
            z = true;
            z2 = true;
            z3 = true;
            z4 = true;
            i4 = 0;
            i5 = 0;
            i6 = 0;
            i7 = 1;
            i8 = 0;
            i9 = 0;
            i10 = 1;
            z5 = false;
            z6 = true;
        }
        LayoutInflater.from(context).inflate(i3, (ViewGroup) this);
        setDescendantFocusability(262144);
        AspectRatioFrameLayout aspectRatioFrameLayout = (AspectRatioFrameLayout) findViewById(wl3.i);
        this.g = aspectRatioFrameLayout;
        if (aspectRatioFrameLayout != null) {
            P(aspectRatioFrameLayout, i6);
        }
        View viewFindViewById = findViewById(wl3.O);
        this.h = viewFindViewById;
        if (viewFindViewById != null && z5) {
            viewFindViewById.setBackgroundColor(i9);
        }
        if (aspectRatioFrameLayout == null || i7 == 0) {
            ?? r32 = th;
            this.i = r32;
            z7 = false;
            r3 = r32;
        } else {
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (i7 == 2) {
                this.i = new TextureView(context);
            } else if (i7 == 3) {
                try {
                    int i17 = dc4.r;
                    this.i = (View) dc4.class.getConstructor(Context.class).newInstance(context);
                    z7 = true;
                    this.i.setLayoutParams(layoutParams);
                    this.i.setOnClickListener(cVar);
                    this.i.setClickable(false);
                    aspectRatioFrameLayout.addView(this.i, 0);
                    r3 = th;
                } catch (Exception e2) {
                    l02.a("spherical_gl_surface_view requires an ExoPlayer dependency", e2);
                    throw th;
                }
            } else if (i7 != 4) {
                SurfaceView surfaceView = new SurfaceView(context);
                if (Build.VERSION.SDK_INT >= 34) {
                    b.a(surfaceView);
                }
                this.i = surfaceView;
            } else {
                try {
                    int i18 = h25.g;
                    this.i = (View) h25.class.getConstructor(Context.class).newInstance(context);
                } catch (Exception e3) {
                    l02.a("video_decoder_gl_surface_view requires an ExoPlayer dependency", e3);
                    throw th;
                }
            }
            z7 = false;
            this.i.setLayoutParams(layoutParams);
            this.i.setOnClickListener(cVar);
            this.i.setClickable(false);
            aspectRatioFrameLayout.addView(this.i, 0);
            r3 = th;
        }
        this.j = z7;
        this.k = Build.VERSION.SDK_INT == 34 ? new f() : null;
        this.r = (FrameLayout) findViewById(wl3.a);
        this.s = (FrameLayout) findViewById(wl3.C);
        this.l = (ImageView) findViewById(wl3.u);
        this.B = i8;
        try {
            cls = ExoPlayer.class;
            ImageOutput imageOutput = ImageOutput.a;
            method = cls.getMethod("setImageOutput", ImageOutput.class);
            objNewProxyInstance = Proxy.newProxyInstance(ImageOutput.class.getClassLoader(), new Class[]{ImageOutput.class}, new InvocationHandler() { // from class: ne3
                @Override // java.lang.reflect.InvocationHandler
                public final Object invoke(Object obj, Method method2, Object[] objArr) {
                    return PlayerView.b(this.a, obj, method2, objArr);
                }
            });
        } catch (ClassNotFoundException | NoSuchMethodException unused) {
            cls = null;
            objNewProxyInstance = null;
            method = null;
        }
        this.u = cls;
        this.v = method;
        this.w = objNewProxyInstance;
        ImageView imageView2 = (ImageView) findViewById(wl3.b);
        this.m = imageView2;
        this.A = (!z6 || i10 == 0 || imageView2 == null) ? 0 : i10;
        if (i5 != 0) {
            this.C = c30.e(getContext(), i5);
        }
        SubtitleView subtitleView = (SubtitleView) findViewById(wl3.R);
        this.n = subtitleView;
        if (subtitleView != null) {
            subtitleView.d();
            subtitleView.e();
        }
        View viewFindViewById2 = findViewById(wl3.f);
        this.o = viewFindViewById2;
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(8);
        }
        this.D = i4;
        TextView textView = (TextView) findViewById(wl3.n);
        this.p = textView;
        if (textView != null) {
            textView.setVisibility(8);
        }
        androidx.media3.ui.b bVar = (androidx.media3.ui.b) findViewById(wl3.j);
        View viewFindViewById3 = findViewById(wl3.k);
        if (bVar != null) {
            this.q = bVar;
            i11 = 0;
        } else if (viewFindViewById3 != null) {
            i11 = 0;
            androidx.media3.ui.b bVar2 = new androidx.media3.ui.b(context, null, 0, attributeSet);
            this.q = bVar2;
            bVar2.setId(wl3.j);
            bVar2.setLayoutParams(viewFindViewById3.getLayoutParams());
            ViewGroup viewGroup = (ViewGroup) viewFindViewById3.getParent();
            int iIndexOfChild = viewGroup.indexOfChild(viewFindViewById3);
            viewGroup.removeView(viewFindViewById3);
            viewGroup.addView(bVar2, iIndexOfChild);
        } else {
            i11 = 0;
            this.q = null;
        }
        androidx.media3.ui.b bVar3 = this.q;
        this.G = bVar3 != null ? i2 : i11;
        this.J = z2;
        this.H = z3;
        this.I = z4;
        this.y = (!z || bVar3 == null) ? i11 : 1;
        if (bVar3 != null) {
            bVar3.f0();
            this.q.Y(this.f);
        }
        if (z) {
            setClickable(true);
        }
        X();
    }

    public static void P(AspectRatioFrameLayout aspectRatioFrameLayout, int i) {
        aspectRatioFrameLayout.setResizeMode(i);
    }

    public static /* synthetic */ void a(PlayerView playerView, Bitmap bitmap) {
        playerView.getClass();
        playerView.setImage(new BitmapDrawable(playerView.getResources(), bitmap));
        if (playerView.C()) {
            return;
        }
        playerView.T();
        playerView.y();
    }

    public static /* synthetic */ Object b(PlayerView playerView, Object obj, Method method, Object[] objArr) {
        playerView.getClass();
        if (!method.getName().equals("onImageAvailable")) {
            return null;
        }
        playerView.M((Bitmap) objArr[1]);
        return null;
    }

    public static /* synthetic */ d o(PlayerView playerView) {
        playerView.getClass();
        return null;
    }

    public static /* synthetic */ e p(PlayerView playerView) {
        playerView.getClass();
        return null;
    }

    private void setImage(Drawable drawable) {
        ImageView imageView = this.l;
        if (imageView == null) {
            return;
        }
        imageView.setImageDrawable(drawable);
        b0();
    }

    private void setImageOutput(hd3 hd3Var) {
        Class cls = this.u;
        if (cls == null || !cls.isAssignableFrom(hd3Var.getClass())) {
            return;
        }
        try {
            ((Method) gg3.q(this.v)).invoke(hd3Var, gg3.q(this.w));
        } catch (IllegalAccessException | InvocationTargetException e2) {
            wg1.a(e2);
        }
    }

    public static void z(Context context, Resources resources, ImageView imageView) {
        imageView.setImageDrawable(fy4.i0(context, resources, el3.a));
        imageView.setBackgroundColor(resources.getColor(qk3.a, null));
    }

    public boolean A(KeyEvent keyEvent) {
        return d0() && this.q.a0(keyEvent);
    }

    public final boolean B() {
        hd3 hd3Var = this.x;
        return hd3Var != null && this.w != null && hd3Var.isCommandAvailable(30) && hd3Var.getCurrentTracks().d(4);
    }

    public final boolean C() {
        hd3 hd3Var = this.x;
        return hd3Var != null && hd3Var.isCommandAvailable(30) && hd3Var.getCurrentTracks().d(2);
    }

    public final void D() {
        G();
        ImageView imageView = this.l;
        if (imageView != null) {
            imageView.setImageResource(R.color.transparent);
        }
    }

    public final void E() {
        ImageView imageView = this.m;
        if (imageView != null) {
            imageView.setImageResource(R.color.transparent);
            this.m.setVisibility(4);
        }
    }

    public void F() {
        androidx.media3.ui.b bVar = this.q;
        if (bVar != null) {
            bVar.e0();
        }
    }

    public final void G() {
        ImageView imageView = this.l;
        if (imageView != null) {
            imageView.setVisibility(4);
        }
    }

    public final boolean H(int i) {
        return i == 19 || i == 270 || i == 22 || i == 271 || i == 20 || i == 269 || i == 21 || i == 268 || i == 23;
    }

    public final boolean I() {
        Drawable drawable;
        ImageView imageView = this.l;
        return (imageView == null || (drawable = imageView.getDrawable()) == null || drawable.getAlpha() == 0) ? false : true;
    }

    public final boolean J() {
        hd3 hd3Var = this.x;
        return hd3Var != null && hd3Var.isCommandAvailable(16) && this.x.isPlayingAd() && this.x.getPlayWhenReady();
    }

    public final void K(boolean z) {
        if (!(J() && this.I) && d0()) {
            boolean z2 = this.q.k0() && this.q.getShowTimeoutMs() <= 0;
            boolean zQ = Q();
            if (z || z2 || zQ) {
                S(zQ);
            }
        }
    }

    public void L(AspectRatioFrameLayout aspectRatioFrameLayout, float f2) {
        if (aspectRatioFrameLayout != null) {
            aspectRatioFrameLayout.setAspectRatio(f2);
        }
    }

    public final void M(final Bitmap bitmap) {
        this.t.post(new Runnable() { // from class: oe3
            @Override // java.lang.Runnable
            public final void run() {
                PlayerView.a(this.f, bitmap);
            }
        });
    }

    public final boolean N(hd3 hd3Var) {
        byte[] bArr;
        if (hd3Var == null || !hd3Var.isCommandAvailable(18) || (bArr = hd3Var.getMediaMetadata().k) == null) {
            return false;
        }
        return O(new BitmapDrawable(getResources(), BitmapFactory.decodeByteArray(bArr, 0, bArr.length)));
    }

    public final boolean O(Drawable drawable) {
        if (this.m != null && drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            if (intrinsicWidth > 0 && intrinsicHeight > 0) {
                float width = intrinsicWidth / intrinsicHeight;
                ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
                if (this.A == 2) {
                    width = getWidth() / getHeight();
                    scaleType = ImageView.ScaleType.CENTER_CROP;
                }
                L(this.g, width);
                this.m.setScaleType(scaleType);
                this.m.setImageDrawable(drawable);
                this.m.setVisibility(0);
                return true;
            }
        }
        return false;
    }

    public final boolean Q() {
        hd3 hd3Var = this.x;
        if (hd3Var == null) {
            return true;
        }
        int playbackState = hd3Var.getPlaybackState();
        if (!this.H) {
            return false;
        }
        if (this.x.isCommandAvailable(17) && this.x.getCurrentTimeline().w()) {
            return false;
        }
        return playbackState == 1 || playbackState == 4 || !((hd3) gg3.q(this.x)).getPlayWhenReady();
    }

    public void R() {
        S(Q());
    }

    public final void S(boolean z) {
        if (d0()) {
            this.q.setShowTimeoutMs(z ? 0 : this.G);
            this.q.v0();
        }
    }

    public final void T() {
        ImageView imageView = this.l;
        if (imageView != null) {
            imageView.setVisibility(0);
            b0();
        }
    }

    public final void U() {
        if (!d0() || this.x == null) {
            return;
        }
        if (!this.q.k0()) {
            K(true);
        } else if (this.J) {
            this.q.e0();
        }
    }

    public final void V() {
        hd3 hd3Var = this.x;
        e35 videoSize = hd3Var != null ? hd3Var.getVideoSize() : e35.e;
        int i = videoSize.a;
        int i2 = videoSize.b;
        L(this.g, this.j ? 0.0f : (i2 == 0 || i == 0) ? 0.0f : (i * videoSize.d) / i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void W() {
        /*
            r4 = this;
            android.view.View r0 = r4.o
            if (r0 == 0) goto L2b
            hd3 r0 = r4.x
            r1 = 0
            if (r0 == 0) goto L20
            int r0 = r0.getPlaybackState()
            r2 = 2
            if (r0 != r2) goto L20
            int r0 = r4.D
            r3 = 1
            if (r0 == r2) goto L21
            if (r0 != r3) goto L20
            hd3 r0 = r4.x
            boolean r0 = r0.getPlayWhenReady()
            if (r0 == 0) goto L20
            goto L21
        L20:
            r3 = r1
        L21:
            android.view.View r4 = r4.o
            if (r3 == 0) goto L26
            goto L28
        L26:
            r1 = 8
        L28:
            r4.setVisibility(r1)
        L2b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.ui.PlayerView.W():void");
    }

    public final void X() {
        androidx.media3.ui.b bVar = this.q;
        if (bVar == null || !this.y) {
            setContentDescription(null);
        } else if (bVar.k0()) {
            setContentDescription(this.J ? getResources().getString(om3.e) : null);
        } else {
            setContentDescription(getResources().getString(om3.m));
        }
    }

    public final void Y() {
        if (J() && this.I) {
            F();
        } else {
            K(false);
        }
    }

    public final void Z() {
        TextView textView = this.p;
        if (textView != null) {
            CharSequence charSequence = this.F;
            if (charSequence != null) {
                textView.setText(charSequence);
                this.p.setVisibility(0);
            } else {
                hd3 hd3Var = this.x;
                if (hd3Var != null) {
                    hd3Var.getPlayerError();
                }
                this.p.setVisibility(8);
            }
        }
    }

    public final void a0(boolean z) {
        hd3 hd3Var = this.x;
        boolean z2 = false;
        boolean z3 = (hd3Var == null || !hd3Var.isCommandAvailable(30) || hd3Var.getCurrentTracks().c()) ? false : true;
        if (!this.E && (!z3 || z)) {
            E();
            y();
            D();
        }
        if (z3) {
            boolean zC = C();
            boolean zB = B();
            if (!zC && !zB) {
                y();
                D();
            }
            View view = this.h;
            if (view != null && view.getVisibility() == 4 && I()) {
                z2 = true;
            }
            if (zB && !zC && z2) {
                y();
                T();
            } else if (zC && !zB && z2) {
                D();
            }
            if (zC || zB || !c0() || !(N(hd3Var) || O(this.C))) {
                E();
            }
        }
    }

    public final void b0() {
        Drawable drawable;
        ImageView imageView = this.l;
        if (imageView == null || (drawable = imageView.getDrawable()) == null) {
            return;
        }
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            return;
        }
        float width = intrinsicWidth / intrinsicHeight;
        ImageView.ScaleType scaleType = ImageView.ScaleType.FIT_XY;
        if (this.B == 1) {
            width = getWidth() / getHeight();
            scaleType = ImageView.ScaleType.CENTER_CROP;
        }
        if (this.l.getVisibility() == 0) {
            L(this.g, width);
        }
        this.l.setScaleType(scaleType);
    }

    public final boolean c0() {
        if (this.A == 0) {
            return false;
        }
        gg3.q(this.m);
        return true;
    }

    public final boolean d0() {
        if (!this.y) {
            return false;
        }
        gg3.q(this.q);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        f fVar;
        super.dispatchDraw(canvas);
        if (Build.VERSION.SDK_INT == 34 && (fVar = this.k) != null && this.K) {
            fVar.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        hd3 hd3Var = this.x;
        if (hd3Var != null && hd3Var.isCommandAvailable(16) && this.x.isPlayingAd()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean zH = H(keyEvent.getKeyCode());
        if (zH && d0() && !this.q.k0()) {
            K(true);
            return true;
        }
        if (A(keyEvent) || super.dispatchKeyEvent(keyEvent)) {
            K(true);
            return true;
        }
        if (zH && d0()) {
            K(true);
        }
        return false;
    }

    public List<w3> getAdOverlayInfos() {
        ArrayList arrayList = new ArrayList();
        FrameLayout frameLayout = this.s;
        if (frameLayout != null) {
            arrayList.add(new w3.a(frameLayout, 4).b("Transparent overlay does not impact viewability").a());
        }
        androidx.media3.ui.b bVar = this.q;
        if (bVar != null) {
            arrayList.add(new w3.a(bVar, 1).a());
        }
        return xi1.p(arrayList);
    }

    public ViewGroup getAdViewGroup() {
        return (ViewGroup) gg3.r(this.r, "exo_ad_overlay must be present for ad playback");
    }

    public int getArtworkDisplayMode() {
        return this.A;
    }

    public boolean getControllerAutoShow() {
        return this.H;
    }

    public boolean getControllerHideOnTouch() {
        return this.J;
    }

    public int getControllerShowTimeoutMs() {
        return this.G;
    }

    public Drawable getDefaultArtwork() {
        return this.C;
    }

    public int getImageDisplayMode() {
        return this.B;
    }

    public FrameLayout getOverlayFrameLayout() {
        return this.s;
    }

    public hd3 getPlayer() {
        return this.x;
    }

    public int getResizeMode() {
        gg3.q(this.g);
        return this.g.getResizeMode();
    }

    public SubtitleView getSubtitleView() {
        return this.n;
    }

    @Deprecated
    public boolean getUseArtwork() {
        return this.A != 0;
    }

    public boolean getUseController() {
        return this.y;
    }

    public View getVideoSurfaceView() {
        return this.i;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!d0() || this.x == null) {
            return false;
        }
        K(true);
        return true;
    }

    @Override // android.view.View
    public boolean performClick() {
        U();
        return super.performClick();
    }

    public void setArtworkDisplayMode(int i) {
        gg3.v(i == 0 || this.m != null);
        if (this.A != i) {
            this.A = i;
            a0(false);
        }
    }

    public void setAspectRatioListener(AspectRatioFrameLayout.b bVar) {
        gg3.q(this.g);
        this.g.setAspectRatioListener(bVar);
    }

    public void setControllerAnimationEnabled(boolean z) {
        gg3.q(this.q);
        this.q.setAnimationEnabled(z);
    }

    public void setControllerAutoShow(boolean z) {
        this.H = z;
    }

    public void setControllerHideDuringAds(boolean z) {
        this.I = z;
    }

    public void setControllerHideOnTouch(boolean z) {
        gg3.q(this.q);
        this.J = z;
        X();
    }

    @Deprecated
    public void setControllerOnFullScreenModeChangedListener(b.d dVar) {
        gg3.q(this.q);
        this.q.setOnFullScreenModeChangedListener(dVar);
    }

    public void setControllerShowTimeoutMs(int i) {
        gg3.q(this.q);
        this.G = i;
        if (this.q.k0()) {
            R();
        }
    }

    @Deprecated
    public void setControllerVisibilityListener(b.m mVar) {
        gg3.q(this.q);
        b.m mVar2 = this.z;
        if (mVar2 == mVar) {
            return;
        }
        if (mVar2 != null) {
            this.q.s0(mVar2);
        }
        this.z = mVar;
        if (mVar != null) {
            this.q.Y(mVar);
            setControllerVisibilityListener((d) null);
        }
    }

    public void setCustomErrorMessage(CharSequence charSequence) {
        gg3.v(this.p != null);
        this.F = charSequence;
        Z();
    }

    public void setDefaultArtwork(Drawable drawable) {
        if (this.C != drawable) {
            this.C = drawable;
            a0(false);
        }
    }

    public void setEnableComposeSurfaceSyncWorkaround(boolean z) {
        this.K = z;
    }

    public void setErrorMessageProvider(lu0 lu0Var) {
        if (lu0Var != null) {
            Z();
        }
    }

    public void setFullscreenButtonClickListener(e eVar) {
        gg3.q(this.q);
        this.q.setOnFullScreenModeChangedListener(this.f);
    }

    public void setFullscreenButtonState(boolean z) {
        gg3.q(this.q);
        this.q.B0(z);
    }

    public void setImageDisplayMode(int i) {
        gg3.v(this.l != null);
        if (this.B != i) {
            this.B = i;
            b0();
        }
    }

    public void setKeepContentOnPlayerReset(boolean z) {
        if (this.E != z) {
            this.E = z;
            a0(false);
        }
    }

    public void setMediaRouteButtonViewProvider(x45 x45Var) {
        gg3.q(this.q);
        this.q.setMediaRouteButtonViewProvider(x45Var);
    }

    public void setPlayer(hd3 hd3Var) {
        gg3.v(Looper.myLooper() == Looper.getMainLooper());
        gg3.d(hd3Var == null || hd3Var.getApplicationLooper() == Looper.getMainLooper());
        hd3 hd3Var2 = this.x;
        if (hd3Var2 == hd3Var) {
            return;
        }
        if (hd3Var2 != null) {
            hd3Var2.removeListener(this.f);
            if (hd3Var2.isCommandAvailable(27)) {
                View view = this.i;
                if (view instanceof TextureView) {
                    hd3Var2.clearVideoTextureView((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    hd3Var2.clearVideoSurfaceView((SurfaceView) view);
                }
            }
            x(hd3Var2);
        }
        SubtitleView subtitleView = this.n;
        if (subtitleView != null) {
            subtitleView.setCues(null);
        }
        this.x = hd3Var;
        if (d0()) {
            this.q.setPlayer(hd3Var);
        }
        W();
        Z();
        a0(true);
        if (hd3Var == null) {
            F();
            return;
        }
        if (hd3Var.isCommandAvailable(27)) {
            View view2 = this.i;
            if (view2 instanceof TextureView) {
                hd3Var.setVideoTextureView((TextureView) view2);
            } else if (view2 instanceof SurfaceView) {
                hd3Var.setVideoSurfaceView((SurfaceView) view2);
            }
            if (!hd3Var.isCommandAvailable(30) || hd3Var.getCurrentTracks().e(2)) {
                V();
            }
        }
        if (this.n != null && hd3Var.isCommandAvailable(28)) {
            this.n.setCues(hd3Var.getCurrentCues().a);
        }
        hd3Var.addListener(this.f);
        setImageOutput(hd3Var);
        K(false);
    }

    public void setRepeatToggleModes(int i) {
        gg3.q(this.q);
        this.q.setRepeatToggleModes(i);
    }

    public void setResizeMode(int i) {
        gg3.q(this.g);
        this.g.setResizeMode(i);
    }

    public void setShowBuffering(int i) {
        if (this.D != i) {
            this.D = i;
            W();
        }
    }

    public void setShowFastForwardButton(boolean z) {
        gg3.q(this.q);
        this.q.setShowFastForwardButton(z);
    }

    @Deprecated
    public void setShowMultiWindowTimeBar(boolean z) {
        gg3.q(this.q);
        this.q.setShowMultiWindowTimeBar(z);
    }

    public void setShowNextButton(boolean z) {
        gg3.q(this.q);
        this.q.setShowNextButton(z);
    }

    public void setShowPlayButtonIfPlaybackIsSuppressed(boolean z) {
        gg3.q(this.q);
        this.q.setShowPlayButtonIfPlaybackIsSuppressed(z);
    }

    public void setShowPreviousButton(boolean z) {
        gg3.q(this.q);
        this.q.setShowPreviousButton(z);
    }

    public void setShowRewindButton(boolean z) {
        gg3.q(this.q);
        this.q.setShowRewindButton(z);
    }

    public void setShowShuffleButton(boolean z) {
        gg3.q(this.q);
        this.q.setShowShuffleButton(z);
    }

    public void setShowSubtitleButton(boolean z) {
        gg3.q(this.q);
        this.q.setShowSubtitleButton(z);
    }

    public void setShowVrButton(boolean z) {
        gg3.q(this.q);
        this.q.setShowVrButton(z);
    }

    public void setShutterBackgroundColor(int i) {
        View view = this.h;
        if (view != null) {
            view.setBackgroundColor(i);
        }
    }

    public void setTimeBarScrubbingEnabled(boolean z) {
        gg3.q(this.q);
        this.q.setTimeBarScrubbingEnabled(z);
    }

    @Deprecated
    public void setUseArtwork(boolean z) {
        setArtworkDisplayMode(!z ? 1 : 0);
    }

    public void setUseController(boolean z) {
        boolean z2 = true;
        gg3.v((z && this.q == null) ? false : true);
        if (!z && !hasOnClickListeners()) {
            z2 = false;
        }
        setClickable(z2);
        if (this.y == z) {
            return;
        }
        this.y = z;
        boolean zD0 = d0();
        androidx.media3.ui.b bVar = this.q;
        if (zD0) {
            bVar.setPlayer(this.x);
        } else if (bVar != null) {
            bVar.e0();
            this.q.setPlayer(null);
        }
        X();
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        View view = this.i;
        if (view instanceof SurfaceView) {
            view.setVisibility(i);
        }
    }

    public final void x(hd3 hd3Var) {
        Class cls = this.u;
        if (cls == null || !cls.isAssignableFrom(hd3Var.getClass())) {
            return;
        }
        try {
            ((Method) gg3.q(this.v)).invoke(hd3Var, null);
        } catch (IllegalAccessException | InvocationTargetException e2) {
            wg1.a(e2);
        }
    }

    public final void y() {
        View view = this.h;
        if (view != null) {
            view.setVisibility(0);
        }
    }

    public void setControllerVisibilityListener(d dVar) {
        if (dVar != null) {
            setControllerVisibilityListener((b.m) null);
        }
    }

    public PlayerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public PlayerView(Context context) {
        this(context, null);
    }
}
