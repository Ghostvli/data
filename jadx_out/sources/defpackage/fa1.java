package defpackage;

import android.content.Context;
import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import android.opengl.GLES20;
import android.opengl.GLU;
import android.opengl.Matrix;
import android.os.Build;
import defpackage.xi1;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class fa1 {
    public static final int[] a = {12352, 4, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12325, 0, 12326, 0, 12344};
    public static final int[] b = {12352, 4, 12324, 10, 12323, 10, 12322, 10, 12321, 2, 12325, 0, 12326, 0, 12344};
    public static final int[] c = {12445, 13120, 12344, 12344};
    public static final int[] d = {12445, 13632, 12344, 12344};
    public static final int[] e = {12344};

    public static void a(int i, int i2, int i3) throws a {
        GLES20.glBindTexture(i, i2);
        c();
        GLES20.glTexParameteri(i, 10240, i3);
        c();
        GLES20.glTexParameteri(i, 10241, i3);
        c();
        GLES20.glTexParameteri(i, 10242, 33071);
        c();
        GLES20.glTexParameteri(i, 10243, 33071);
        c();
    }

    public static void b(String str) throws a {
        int iEglGetError = EGL14.eglGetError();
        if (iEglGetError == 12288) {
            return;
        }
        throw new a(str + ", error code: 0x" + Integer.toHexString(iEglGetError), xi1.w(Integer.valueOf(iEglGetError)));
    }

    public static void c() throws a {
        StringBuilder sb = new StringBuilder();
        xi1.a aVar = new xi1.a();
        boolean z = false;
        while (true) {
            int iGlGetError = GLES20.glGetError();
            if (iGlGetError == 0) {
                break;
            }
            if (z) {
                sb.append('\n');
            }
            String strGluErrorString = GLU.gluErrorString(iGlGetError);
            if (strGluErrorString == null) {
                strGluErrorString = "error code: 0x" + Integer.toHexString(iGlGetError);
            }
            sb.append("glError: ");
            sb.append(strGluErrorString);
            aVar.a(Integer.valueOf(iGlGetError));
            z = true;
        }
        if (z) {
            throw new a(sb.toString(), aVar.k());
        }
    }

    public static void d(boolean z, String str) throws a {
        if (!z) {
            throw new a(str);
        }
    }

    public static FloatBuffer e(int i) {
        return ByteBuffer.allocateDirect(i * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
    }

    public static FloatBuffer f(float[] fArr) {
        return (FloatBuffer) e(fArr.length).put(fArr).flip();
    }

    public static int g() throws a {
        int iH = h();
        a(36197, iH, 9729);
        return iH;
    }

    public static int h() throws a {
        int[] iArr = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        c();
        return iArr[0];
    }

    public static EGLDisplay i() throws a {
        EGLDisplay eGLDisplayEglGetDisplay = EGL14.eglGetDisplay(0);
        d(!eGLDisplayEglGetDisplay.equals(EGL14.EGL_NO_DISPLAY), "No EGL display.");
        d(EGL14.eglInitialize(eGLDisplayEglGetDisplay, new int[1], 0, new int[1], 0), "Error in eglInitialize.");
        b("Error in getDefaultEglDisplay");
        return eGLDisplayEglGetDisplay;
    }

    public static boolean j() {
        return m("EGL_EXT_gl_colorspace_bt2020_hlg");
    }

    public static boolean k() {
        return Build.VERSION.SDK_INT >= 33 && m("EGL_EXT_gl_colorspace_bt2020_pq");
    }

    public static boolean l(int i) {
        if (i == 6) {
            return k();
        }
        if (i == 7) {
            return j();
        }
        return true;
    }

    public static boolean m(String str) {
        String strEglQueryString = EGL14.eglQueryString(i(), 12373);
        return strEglQueryString != null && strEglQueryString.contains(str);
    }

    public static boolean n(Context context) {
        int i = Build.VERSION.SDK_INT;
        if (i < 26 && ("samsung".equals(Build.MANUFACTURER) || "XT1650".equals(Build.MODEL))) {
            return false;
        }
        if (i >= 26 || context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) {
            return m("EGL_EXT_protected_content");
        }
        return false;
    }

    public static boolean o() {
        return m("EGL_KHR_surfaceless_context");
    }

    public static void p(float[] fArr) {
        Matrix.setIdentityM(fArr, 0);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a extends Exception {
        public final xi1 f;

        public a(String str, List list) {
            super(str);
            this.f = xi1.p(list);
        }

        public a(String str) {
            this(str, xi1.u());
        }
    }
}
