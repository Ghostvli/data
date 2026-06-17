package defpackage;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.Surface;
import android.view.WindowManager;
import defpackage.cq4;
import defpackage.y63;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class dc4 extends GLSurfaceView {
    public static final /* synthetic */ int r = 0;
    public final CopyOnWriteArrayList f;
    public final SensorManager g;
    public final Sensor h;
    public final y63 i;
    public final Handler j;
    public final cq4 k;
    public final my3 l;
    public SurfaceTexture m;
    public Surface n;
    public boolean o;
    public boolean p;
    public boolean q;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class a implements GLSurfaceView.Renderer, cq4.a, y63.a {
        public final my3 f;
        public final float[] i;
        public final float[] j;
        public final float[] k;
        public float l;
        public float m;
        public final float[] g = new float[16];
        public final float[] h = new float[16];
        public final float[] n = new float[16];
        public final float[] o = new float[16];

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(my3 my3Var) {
            float[] fArr = new float[16];
            this.i = fArr;
            float[] fArr2 = new float[16];
            this.j = fArr2;
            float[] fArr3 = new float[16];
            this.k = fArr3;
            this.f = my3Var;
            fa1.p(fArr);
            fa1.p(fArr2);
            fa1.p(fArr3);
            this.m = 3.1415927f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // y63.a
        public synchronized void a(float[] fArr, float f) {
            float[] fArr2 = this.i;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.m = -f;
            d();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // cq4.a
        public synchronized void b(PointF pointF) {
            this.l = pointF.y;
            d();
            Matrix.setRotateM(this.k, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final float c(float f) {
            if (f > 1.0f) {
                return (float) (Math.toDegrees(Math.atan(Math.tan(Math.toRadians(45.0d)) / ((double) f))) * 2.0d);
            }
            return 90.0f;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void d() {
            Matrix.setRotateM(this.j, 0, -this.l, (float) Math.cos(this.m), (float) Math.sin(this.m), 0.0f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                Matrix.multiplyMM(this.o, 0, this.i, 0, this.k, 0);
                Matrix.multiplyMM(this.n, 0, this.j, 0, this.o, 0);
            }
            Matrix.multiplyMM(this.h, 0, this.g, 0, this.n, 0);
            this.f.c(this.h, false);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // cq4.a
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return dc4.this.performClick();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
            float f = i / i2;
            Matrix.perspectiveM(this.g, 0, c(f), f, 0.1f, 100.0f);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.opengl.GLSurfaceView.Renderer
        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            dc4.this.e(this.f.d());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        void A(Surface surface);

        void y(Surface surface);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public dc4(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f = new CopyOnWriteArrayList();
        this.j = new Handler(Looper.getMainLooper());
        SensorManager sensorManager = (SensorManager) gg3.q(context.getSystemService("sensor"));
        this.g = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(15);
        this.h = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        my3 my3Var = new my3();
        this.l = my3Var;
        a aVar = new a(my3Var);
        cq4 cq4Var = new cq4(context, aVar, 25.0f);
        this.k = cq4Var;
        this.i = new y63(((WindowManager) gg3.q((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), cq4Var, aVar);
        this.o = true;
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setOnTouchListener(cq4Var);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void a(dc4 dc4Var) {
        Surface surface = dc4Var.n;
        if (surface != null) {
            Iterator it = dc4Var.f.iterator();
            while (it.hasNext()) {
                ((b) it.next()).y(surface);
            }
        }
        f(dc4Var.m, surface);
        dc4Var.m = null;
        dc4Var.n = null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ void b(dc4 dc4Var, SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = dc4Var.m;
        Surface surface = dc4Var.n;
        Surface surface2 = new Surface(surfaceTexture);
        dc4Var.m = surfaceTexture;
        dc4Var.n = surface2;
        Iterator it = dc4Var.f.iterator();
        while (it.hasNext()) {
            ((b) it.next()).A(surface2);
        }
        f(surfaceTexture2, surface);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static void f(SurfaceTexture surfaceTexture, Surface surface) {
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d(b bVar) {
        this.f.add(bVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void e(final SurfaceTexture surfaceTexture) {
        this.j.post(new Runnable() { // from class: cc4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                dc4.b(this.f, surfaceTexture);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void g(b bVar) {
        this.f.remove(bVar);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public gp getCameraMotionListener() {
        return this.l;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public j25 getVideoFrameMetadataListener() {
        return this.l;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Surface getVideoSurface() {
        return this.n;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void h() {
        boolean z = this.o && this.p;
        Sensor sensor = this.h;
        if (sensor == null || z == this.q) {
            return;
        }
        SensorManager sensorManager = this.g;
        if (z) {
            sensorManager.registerListener(this.i, sensor, 0);
        } else {
            sensorManager.unregisterListener(this.i);
        }
        this.q = z;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.j.post(new Runnable() { // from class: bc4
            /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
            @Override // java.lang.Runnable
            public final void run() {
                dc4.a(this.f);
            }
        });
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.opengl.GLSurfaceView
    public void onPause() {
        this.p = false;
        h();
        super.onPause();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // android.opengl.GLSurfaceView
    public void onResume() {
        super.onResume();
        this.p = true;
        h();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setDefaultStereoMode(int i) {
        this.l.f(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setUseSensorRotation(boolean z) {
        this.o = z;
        h();
    }

    public dc4(Context context) {
        this(context, null);
    }
}
