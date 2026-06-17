package defpackage;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import com.google.zxing.client.android.AmbientLightManager;
import com.google.zxing.client.android.camera.open.OpenCameraInterface;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class fp {
    public static final String n = "fp";
    public Camera a;
    public Camera.CameraInfo b;
    public we c;
    public AmbientLightManager d;
    public boolean e;
    public String f;
    public nm0 h;
    public c94 i;
    public c94 j;
    public Context l;
    public jp g = new jp();
    public int k = -1;
    public final a m = new a();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public final class a implements Camera.PreviewCallback {
        public pg3 a;
        public c94 b;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a(pg3 pg3Var) {
            this.a = pg3Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void b(c94 c94Var) {
            this.b = c94Var;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            c94 c94Var = this.b;
            pg3 pg3Var = this.a;
            if (c94Var == null || pg3Var == null) {
                Log.d(fp.n, "Got preview callback, but no handler or resolution available");
                if (pg3Var != null) {
                    pg3Var.a(new Exception("No resolution available"));
                    return;
                }
                return;
            }
            try {
                if (bArr == null) {
                    throw new NullPointerException("No preview data received");
                }
                eb4 eb4Var = new eb4(bArr, c94Var.f, c94Var.g, camera.getParameters().getPreviewFormat(), fp.this.f());
                if (fp.this.b.facing == 1) {
                    eb4Var.e(true);
                }
                pg3Var.b(eb4Var);
            } catch (RuntimeException e) {
                Log.e(fp.n, "Camera preview failed", e);
                pg3Var.a(e);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public fp(Context context) {
        this.l = context;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static List i(Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList();
        if (supportedPreviewSizes == null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                new c94(previewSize.width, previewSize.height);
                arrayList.add(new c94(previewSize.width, previewSize.height));
                return arrayList;
            }
        } else {
            for (Camera.Size size : supportedPreviewSizes) {
                arrayList.add(new c94(size.width, size.height));
            }
        }
        return arrayList;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final int c() {
        int iC = this.h.c();
        int i = 0;
        if (iC != 0) {
            if (iC == 1) {
                i = 90;
            } else if (iC == 2) {
                i = 180;
            } else if (iC == 3) {
                i = 270;
            }
        }
        Camera.CameraInfo cameraInfo = this.b;
        int i2 = cameraInfo.facing == 1 ? (360 - ((cameraInfo.orientation + i) % 360)) % 360 : ((cameraInfo.orientation - i) + 360) % 360;
        Log.i(n, "Camera Display Orientation: " + i2);
        return i2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void d() {
        Camera camera = this.a;
        if (camera != null) {
            camera.release();
            this.a = null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void e() {
        if (this.a != null) {
            r();
        } else {
            zt2.a("Camera not open");
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int f() {
        return this.k;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Camera.Parameters g() {
        Camera.Parameters parameters = this.a.getParameters();
        String str = this.f;
        if (str == null) {
            this.f = parameters.flatten();
            return parameters;
        }
        parameters.unflatten(str);
        return parameters;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public c94 h() {
        if (this.j == null) {
            return null;
        }
        boolean zJ = j();
        c94 c94Var = this.j;
        return zJ ? c94Var.b() : c94Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean j() {
        int i = this.k;
        if (i != -1) {
            return i % 180 != 0;
        }
        e04.a("Rotation not calculated yet. Call configure() first.");
        return false;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean k() {
        String flashMode;
        Camera.Parameters parameters = this.a.getParameters();
        return (parameters == null || (flashMode = parameters.getFlashMode()) == null || (!"on".equals(flashMode) && !"torch".equals(flashMode))) ? false : true;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void l() {
        Camera cameraOpen = OpenCameraInterface.open(this.g.b());
        this.a = cameraOpen;
        if (cameraOpen == null) {
            zt2.a("Failed to open camera");
            return;
        }
        int cameraId = OpenCameraInterface.getCameraId(this.g.b());
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        this.b = cameraInfo;
        Camera.getCameraInfo(cameraId, cameraInfo);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void m(pg3 pg3Var) {
        Camera camera = this.a;
        if (camera == null || !this.e) {
            return;
        }
        this.m.a(pg3Var);
        camera.setOneShotPreviewCallback(this.m);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void n(int i) {
        this.a.setDisplayOrientation(i);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void o(jp jpVar) {
        this.g = jpVar;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void p(boolean z) {
        Camera.Parameters parametersG = g();
        if (parametersG == null) {
            Log.w(n, "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        String str = n;
        Log.i(str, "Initial camera parameters: " + parametersG.flatten());
        if (z) {
            Log.w(str, "In camera config safe mode -- most settings will not be honored");
        }
        ap.g(parametersG, this.g.a(), z);
        if (!z) {
            ap.k(parametersG, false);
            if (this.g.h()) {
                ap.i(parametersG);
            }
            if (this.g.e()) {
                ap.c(parametersG);
            }
            if (this.g.g()) {
                ap.l(parametersG);
                ap.h(parametersG);
                ap.j(parametersG);
            }
        }
        List listI = i(parametersG);
        if (listI.size() == 0) {
            this.i = null;
        } else {
            c94 c94VarA = this.h.a(listI, j());
            this.i = c94VarA;
            parametersG.setPreviewSize(c94VarA.f, c94VarA.g);
        }
        if (Build.DEVICE.equals("glass-1")) {
            ap.e(parametersG);
        }
        Log.i(str, "Final camera parameters: " + parametersG.flatten());
        this.a.setParameters(parametersG);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void q(nm0 nm0Var) {
        this.h = nm0Var;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final void r() {
        try {
            int iC = c();
            this.k = iC;
            n(iC);
        } catch (Exception unused) {
            Log.w(n, "Failed to set rotation.");
        }
        try {
            p(false);
        } catch (Exception unused2) {
            try {
                p(true);
            } catch (Exception unused3) {
                Log.w(n, "Camera rejected even safe-mode parameters! No configuration");
            }
        }
        Camera.Size previewSize = this.a.getParameters().getPreviewSize();
        if (previewSize == null) {
            this.j = this.i;
        } else {
            this.j = new c94(previewSize.width, previewSize.height);
        }
        this.m.b(this.j);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void s(kp kpVar) throws IOException {
        kpVar.a(this.a);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void t(boolean z) {
        if (this.a != null) {
            try {
                if (z != k()) {
                    we weVar = this.c;
                    if (weVar != null) {
                        weVar.j();
                    }
                    Camera.Parameters parameters = this.a.getParameters();
                    ap.k(parameters, z);
                    if (this.g.f()) {
                        ap.d(parameters, z);
                    }
                    this.a.setParameters(parameters);
                    we weVar2 = this.c;
                    if (weVar2 != null) {
                        weVar2.i();
                    }
                }
            } catch (RuntimeException e) {
                Log.e(n, "Failed to set torch", e);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void u() {
        Camera camera = this.a;
        if (camera == null || this.e) {
            return;
        }
        camera.startPreview();
        this.e = true;
        this.c = new we(this.a, this.g);
        AmbientLightManager ambientLightManager = new AmbientLightManager(this.l, this, this.g);
        this.d = ambientLightManager;
        ambientLightManager.start();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void v() {
        we weVar = this.c;
        if (weVar != null) {
            weVar.j();
            this.c = null;
        }
        AmbientLightManager ambientLightManager = this.d;
        if (ambientLightManager != null) {
            ambientLightManager.stop();
            this.d = null;
        }
        Camera camera = this.a;
        if (camera == null || !this.e) {
            return;
        }
        camera.stopPreview();
        this.m.a(null);
        this.e = false;
    }
}
