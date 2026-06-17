package com.journeyapps.barcodescanner;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.google.zxing.client.android.R;
import com.journeyapps.barcodescanner.a;
import defpackage.c94;
import defpackage.e04;
import defpackage.ep;
import defpackage.hr;
import defpackage.jl;
import defpackage.jp;
import defpackage.ju3;
import defpackage.kp;
import defpackage.ku3;
import defpackage.ly4;
import defpackage.nm0;
import defpackage.qg3;
import defpackage.r11;
import defpackage.t11;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a extends ViewGroup {
    public static final String F = "a";
    public boolean A;
    public final SurfaceHolder.Callback B;
    public final Handler.Callback C;
    public ju3 D;
    public final f E;
    public ep f;
    public WindowManager g;
    public Handler h;
    public boolean i;
    public SurfaceView j;
    public TextureView k;
    public boolean l;
    public ku3 m;
    public int n;
    public List o;
    public nm0 p;
    public jp q;
    public c94 r;
    public c94 s;
    public Rect t;
    public c94 u;
    public Rect v;
    public Rect w;
    public c94 x;
    public double y;
    public qg3 z;

    /* JADX INFO: renamed from: com.journeyapps.barcodescanner.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class TextureViewSurfaceTextureListenerC0072a implements TextureView.SurfaceTextureListener {
        public TextureViewSurfaceTextureListenerC0072a() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            a.this.u = new c94(i, i2);
            a.this.C();
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements SurfaceHolder.Callback {
        public b() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            if (surfaceHolder == null) {
                Log.e(a.F, "*** WARNING *** surfaceChanged() gave us a null surface!");
                return;
            }
            a.this.u = new c94(i2, i3);
            a.this.C();
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            a.this.u = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements Handler.Callback {
        public c() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == R.id.zxing_prewiew_size_ready) {
                a.this.w((c94) message.obj);
                return true;
            }
            if (i != R.id.zxing_camera_error) {
                if (i != R.id.zxing_camera_closed) {
                    return false;
                }
                a.this.E.d();
                return false;
            }
            Exception exc = (Exception) message.obj;
            if (!a.this.r()) {
                return false;
            }
            a.this.u();
            a.this.E.b(exc);
            return false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d implements ju3 {
        public d() {
        }

        @Override // defpackage.ju3
        public void a(int i) {
            a.this.h.postDelayed(new Runnable() { // from class: ip
                @Override // java.lang.Runnable
                public final void run() {
                    a.this.z();
                }
            }, 250L);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e implements f {
        public e() {
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void a() {
            Iterator it = a.this.o.iterator();
            while (it.hasNext()) {
                ((f) it.next()).a();
            }
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void b(Exception exc) {
            Iterator it = a.this.o.iterator();
            while (it.hasNext()) {
                ((f) it.next()).b(exc);
            }
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void c() {
            Iterator it = a.this.o.iterator();
            while (it.hasNext()) {
                ((f) it.next()).c();
            }
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void d() {
            Iterator it = a.this.o.iterator();
            while (it.hasNext()) {
                ((f) it.next()).d();
            }
        }

        @Override // com.journeyapps.barcodescanner.a.f
        public void e() {
            Iterator it = a.this.o.iterator();
            while (it.hasNext()) {
                ((f) it.next()).e();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface f {
        void a();

        void b(Exception exc);

        void c();

        void d();

        void e();
    }

    public a(Context context) {
        super(context);
        this.i = false;
        this.l = false;
        this.n = -1;
        this.o = new ArrayList();
        this.q = new jp();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = 0.1d;
        this.z = null;
        this.A = false;
        this.B = new b();
        this.C = new c();
        this.D = new d();
        this.E = new e();
        p(context, null, 0, 0);
    }

    private int getDisplayRotation() {
        return this.g.getDefaultDisplay().getRotation();
    }

    public final void A() {
        if (this.i) {
            TextureView textureView = new TextureView(getContext());
            this.k = textureView;
            textureView.setSurfaceTextureListener(D());
            addView(this.k);
            return;
        }
        SurfaceView surfaceView = new SurfaceView(getContext());
        this.j = surfaceView;
        surfaceView.getHolder().addCallback(this.B);
        addView(this.j);
    }

    public final void B(kp kpVar) {
        if (this.l || this.f == null) {
            return;
        }
        Log.i(F, "Starting preview");
        this.f.w(kpVar);
        this.f.y();
        this.l = true;
        x();
        this.E.e();
    }

    public final void C() {
        Rect rect;
        c94 c94Var = this.u;
        if (c94Var == null || this.s == null || (rect = this.t) == null) {
            return;
        }
        if (this.j != null && c94Var.equals(new c94(rect.width(), this.t.height()))) {
            B(new kp(this.j.getHolder()));
            return;
        }
        TextureView textureView = this.k;
        if (textureView == null || textureView.getSurfaceTexture() == null) {
            return;
        }
        if (this.s != null) {
            this.k.setTransform(l(new c94(this.k.getWidth(), this.k.getHeight()), this.s));
        }
        B(new kp(this.k.getSurfaceTexture()));
    }

    public final TextureView.SurfaceTextureListener D() {
        return new TextureViewSurfaceTextureListenerC0072a();
    }

    public ep getCameraInstance() {
        return this.f;
    }

    public jp getCameraSettings() {
        return this.q;
    }

    public Rect getFramingRect() {
        return this.v;
    }

    public c94 getFramingRectSize() {
        return this.x;
    }

    public double getMarginFraction() {
        return this.y;
    }

    public Rect getPreviewFramingRect() {
        return this.w;
    }

    public qg3 getPreviewScalingStrategy() {
        qg3 qg3Var = this.z;
        return qg3Var != null ? qg3Var : this.k != null ? new hr() : new r11();
    }

    public c94 getPreviewSize() {
        return this.s;
    }

    public void i(f fVar) {
        this.o.add(fVar);
    }

    public final void j() {
        c94 c94Var;
        nm0 nm0Var;
        c94 c94Var2 = this.r;
        if (c94Var2 == null || (c94Var = this.s) == null || (nm0Var = this.p) == null) {
            this.w = null;
            this.v = null;
            this.t = null;
            e04.a("containerSize or previewSize is not set yet");
            return;
        }
        int i = c94Var.f;
        int i2 = c94Var.g;
        int i3 = c94Var2.f;
        int i4 = c94Var2.g;
        Rect rectD = nm0Var.d(c94Var);
        if (rectD.width() <= 0 || rectD.height() <= 0) {
            return;
        }
        this.t = rectD;
        this.v = k(new Rect(0, 0, i3, i4), this.t);
        Rect rect = new Rect(this.v);
        Rect rect2 = this.t;
        rect.offset(-rect2.left, -rect2.top);
        Rect rect3 = new Rect((rect.left * i) / this.t.width(), (rect.top * i2) / this.t.height(), (rect.right * i) / this.t.width(), (rect.bottom * i2) / this.t.height());
        this.w = rect3;
        if (rect3.width() > 0 && this.w.height() > 0) {
            this.E.a();
            return;
        }
        this.w = null;
        this.v = null;
        Log.w(F, "Preview frame is too small");
    }

    public Rect k(Rect rect, Rect rect2) {
        Rect rect3 = new Rect(rect);
        rect3.intersect(rect2);
        if (this.x != null) {
            rect3.inset(Math.max(0, (rect3.width() - this.x.f) / 2), Math.max(0, (rect3.height() - this.x.g) / 2));
            return rect3;
        }
        int iMin = (int) Math.min(((double) rect3.width()) * this.y, ((double) rect3.height()) * this.y);
        rect3.inset(iMin, iMin);
        if (rect3.height() > rect3.width()) {
            rect3.inset(0, (rect3.height() - rect3.width()) / 2);
        }
        return rect3;
    }

    public Matrix l(c94 c94Var, c94 c94Var2) {
        float f2;
        float f3 = c94Var.f / c94Var.g;
        float f4 = c94Var2.f / c94Var2.g;
        float f5 = 1.0f;
        if (f3 < f4) {
            float f6 = f4 / f3;
            f2 = 1.0f;
            f5 = f6;
        } else {
            f2 = f3 / f4;
        }
        Matrix matrix = new Matrix();
        matrix.setScale(f5, f2);
        int i = c94Var.f;
        int i2 = c94Var.g;
        matrix.postTranslate((i - (i * f5)) / 2.0f, (i2 - (i2 * f2)) / 2.0f);
        return matrix;
    }

    public final void m(c94 c94Var) {
        this.r = c94Var;
        ep epVar = this.f;
        if (epVar == null || epVar.n() != null) {
            return;
        }
        nm0 nm0Var = new nm0(getDisplayRotation(), c94Var);
        this.p = nm0Var;
        nm0Var.e(getPreviewScalingStrategy());
        this.f.u(this.p);
        this.f.m();
        boolean z = this.A;
        if (z) {
            this.f.x(z);
        }
    }

    public ep n() {
        ep epVar = new ep(getContext());
        epVar.t(this.q);
        return epVar;
    }

    public final void o() {
        if (this.f != null) {
            Log.w(F, "initCamera called twice");
            return;
        }
        ep epVarN = n();
        this.f = epVarN;
        epVarN.v(this.h);
        this.f.r();
        this.n = getDisplayRotation();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        A();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        m(new c94(i3 - i, i4 - i2));
        SurfaceView surfaceView = this.j;
        if (surfaceView == null) {
            TextureView textureView = this.k;
            if (textureView != null) {
                textureView.layout(0, 0, getWidth(), getHeight());
                return;
            }
            return;
        }
        Rect rect = this.t;
        if (rect == null) {
            surfaceView.layout(0, 0, getWidth(), getHeight());
        } else {
            surfaceView.layout(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof Bundle)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        Bundle bundle = (Bundle) parcelable;
        super.onRestoreInstanceState(bundle.getParcelable("super"));
        setTorch(bundle.getBoolean("torch"));
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        Bundle bundle = new Bundle();
        bundle.putParcelable("super", parcelableOnSaveInstanceState);
        bundle.putBoolean("torch", this.A);
        return bundle;
    }

    public final void p(Context context, AttributeSet attributeSet, int i, int i2) {
        if (getBackground() == null) {
            setBackgroundColor(-16777216);
        }
        q(attributeSet);
        this.g = (WindowManager) context.getSystemService("window");
        this.h = new Handler(this.C);
        this.m = new ku3();
    }

    public void q(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.zxing_camera_preview);
        int dimension = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.zxing_camera_preview_zxing_framing_rect_width, -1.0f);
        int dimension2 = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.zxing_camera_preview_zxing_framing_rect_height, -1.0f);
        if (dimension > 0 && dimension2 > 0) {
            this.x = new c94(dimension, dimension2);
        }
        this.i = typedArrayObtainStyledAttributes.getBoolean(R.styleable.zxing_camera_preview_zxing_use_texture_view, true);
        int integer = typedArrayObtainStyledAttributes.getInteger(R.styleable.zxing_camera_preview_zxing_preview_scaling_strategy, -1);
        if (integer == 1) {
            this.z = new hr();
        } else if (integer == 2) {
            this.z = new r11();
        } else if (integer == 3) {
            this.z = new t11();
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    public boolean r() {
        return this.f != null;
    }

    public boolean s() {
        ep epVar = this.f;
        return epVar == null || epVar.p();
    }

    public void setCameraSettings(jp jpVar) {
        this.q = jpVar;
    }

    public void setFramingRectSize(c94 c94Var) {
        this.x = c94Var;
    }

    public void setMarginFraction(double d2) {
        if (d2 < 0.5d) {
            this.y = d2;
        } else {
            jl.a("The margin fraction must be less than 0.5");
        }
    }

    public void setPreviewScalingStrategy(qg3 qg3Var) {
        this.z = qg3Var;
    }

    public void setTorch(boolean z) {
        this.A = z;
        ep epVar = this.f;
        if (epVar != null) {
            epVar.x(z);
        }
    }

    public void setUseTextureView(boolean z) {
        this.i = z;
    }

    public boolean t() {
        return this.l;
    }

    public void u() {
        TextureView textureView;
        SurfaceView surfaceView;
        ly4.a();
        Log.d(F, "pause()");
        this.n = -1;
        ep epVar = this.f;
        if (epVar != null) {
            epVar.l();
            this.f = null;
            this.l = false;
        } else {
            this.h.sendEmptyMessage(R.id.zxing_camera_closed);
        }
        if (this.u == null && (surfaceView = this.j) != null) {
            surfaceView.getHolder().removeCallback(this.B);
        }
        if (this.u == null && (textureView = this.k) != null) {
            textureView.setSurfaceTextureListener(null);
        }
        this.r = null;
        this.s = null;
        this.w = null;
        this.m.f();
        this.E.c();
    }

    public void v() {
        ep cameraInstance = getCameraInstance();
        u();
        long jNanoTime = System.nanoTime();
        while (cameraInstance != null && !cameraInstance.p() && System.nanoTime() - jNanoTime <= 2000000000) {
            try {
                Thread.sleep(1L);
            } catch (InterruptedException unused) {
                return;
            }
        }
    }

    public final void w(c94 c94Var) {
        this.s = c94Var;
        if (this.r != null) {
            j();
            requestLayout();
            C();
        }
    }

    public void x() {
    }

    public void y() {
        ly4.a();
        Log.d(F, "resume()");
        o();
        if (this.u != null) {
            C();
        } else {
            SurfaceView surfaceView = this.j;
            if (surfaceView != null) {
                surfaceView.getHolder().addCallback(this.B);
            } else {
                TextureView textureView = this.k;
                if (textureView != null) {
                    if (textureView.isAvailable()) {
                        D().onSurfaceTextureAvailable(this.k.getSurfaceTexture(), this.k.getWidth(), this.k.getHeight());
                    } else {
                        this.k.setSurfaceTextureListener(D());
                    }
                }
            }
        }
        requestLayout();
        this.m.e(getContext(), this.D);
    }

    public final void z() {
        if (!r() || getDisplayRotation() == this.n) {
            return;
        }
        u();
        y();
    }

    public a(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.i = false;
        this.l = false;
        this.n = -1;
        this.o = new ArrayList();
        this.q = new jp();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = 0.1d;
        this.z = null;
        this.A = false;
        this.B = new b();
        this.C = new c();
        this.D = new d();
        this.E = new e();
        p(context, attributeSet, 0, 0);
    }

    public a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.i = false;
        this.l = false;
        this.n = -1;
        this.o = new ArrayList();
        this.q = new jp();
        this.v = null;
        this.w = null;
        this.x = null;
        this.y = 0.1d;
        this.z = null;
        this.A = false;
        this.B = new b();
        this.C = new c();
        this.D = new d();
        this.E = new e();
        p(context, attributeSet, i, 0);
    }
}
