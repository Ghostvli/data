package defpackage;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import androidx.media3.decoder.VideoDecoderOutputBuffer;
import defpackage.fa1;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.concurrent.atomic.AtomicReference;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import okhttp3.internal.http2.Http2;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class h25 extends GLSurfaceView implements i25 {
    public static final /* synthetic */ int g = 0;
    public final a f;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements GLSurfaceView.Renderer {
        public static final float[] p = {1.164f, 1.164f, 1.164f, 0.0f, -0.392f, 2.017f, 1.596f, -0.813f, 0.0f};
        public static final float[] q = {1.164f, 1.164f, 1.164f, 0.0f, -0.213f, 2.112f, 1.793f, -0.533f, 0.0f};
        public static final float[] r = {1.168f, 1.168f, 1.168f, 0.0f, -0.188f, 2.148f, 1.683f, -0.652f, 0.0f};
        public static final String[] s = {"y_tex", "u_tex", "v_tex"};
        public static final FloatBuffer t = fa1.f(new float[]{-1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f});
        public final GLSurfaceView f;
        public final int[] g = new int[3];
        public final int[] h = new int[3];
        public final int[] i = new int[3];
        public final int[] j = new int[3];
        public final AtomicReference k = new AtomicReference();
        public final FloatBuffer[] l = new FloatBuffer[3];
        public ea1 m;
        public int n;
        public VideoDecoderOutputBuffer o;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(GLSurfaceView gLSurfaceView) {
            this.f = gLSurfaceView;
            for (int i = 0; i < 3; i++) {
                int[] iArr = this.i;
                this.j[i] = -1;
                iArr[i] = -1;
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public void a(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
            VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = (VideoDecoderOutputBuffer) this.k.getAndSet(videoDecoderOutputBuffer);
            if (videoDecoderOutputBuffer2 != null) {
                videoDecoderOutputBuffer2.release();
            }
            this.f.requestRender();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final void b() {
            try {
                GLES20.glGenTextures(3, this.g, 0);
                for (int i = 0; i < 3; i++) {
                    GLES20.glUniform1i(this.m.j(s[i]), i);
                    GLES20.glActiveTexture(33984 + i);
                    fa1.a(3553, this.g[i], 9729);
                }
                fa1.c();
            } catch (fa1.a e) {
                xz1.e("VideoDecoderGLSV", "Failed to set up the textures", e);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.opengl.GLSurfaceView.Renderer
        public void onDrawFrame(GL10 gl10) {
            VideoDecoderOutputBuffer videoDecoderOutputBuffer = (VideoDecoderOutputBuffer) this.k.getAndSet(null);
            if (videoDecoderOutputBuffer == null && this.o == null) {
                return;
            }
            if (videoDecoderOutputBuffer != null) {
                VideoDecoderOutputBuffer videoDecoderOutputBuffer2 = this.o;
                if (videoDecoderOutputBuffer2 != null) {
                    videoDecoderOutputBuffer2.release();
                }
                this.o = videoDecoderOutputBuffer;
            }
            VideoDecoderOutputBuffer videoDecoderOutputBuffer3 = (VideoDecoderOutputBuffer) gg3.q(this.o);
            float[] fArr = q;
            int i = videoDecoderOutputBuffer3.colorspace;
            if (i == 1) {
                fArr = p;
            } else if (i == 3) {
                fArr = r;
            }
            GLES20.glUniformMatrix3fv(this.n, 1, false, fArr, 0);
            int[] iArr = (int[]) gg3.q(videoDecoderOutputBuffer3.yuvStrides);
            ByteBuffer[] byteBufferArr = (ByteBuffer[]) gg3.q(videoDecoderOutputBuffer3.yuvPlanes);
            for (int i2 = 0; i2 < 3; i2++) {
                int i3 = videoDecoderOutputBuffer3.height;
                if (i2 != 0) {
                    i3 = (i3 + 1) / 2;
                }
                int i4 = i3;
                GLES20.glActiveTexture(33984 + i2);
                GLES20.glBindTexture(3553, this.g[i2]);
                GLES20.glPixelStorei(3317, 1);
                GLES20.glTexImage2D(3553, 0, 6409, iArr[i2], i4, 0, 6409, 5121, byteBufferArr[i2]);
            }
            int i5 = videoDecoderOutputBuffer3.width;
            int i6 = (i5 + 1) / 2;
            int[] iArr2 = {i5, i6, i6};
            for (int i7 = 0; i7 < 3; i7++) {
                if (this.i[i7] != iArr2[i7] || this.j[i7] != iArr[i7]) {
                    gg3.v(iArr[i7] != 0);
                    float f = iArr2[i7] / iArr[i7];
                    this.l[i7] = fa1.f(new float[]{0.0f, 0.0f, 0.0f, 1.0f, f, 0.0f, f, 1.0f});
                    GLES20.glVertexAttribPointer(this.h[i7], 2, 5126, false, 0, (Buffer) this.l[i7]);
                    this.i[i7] = iArr2[i7];
                    this.j[i7] = iArr[i7];
                }
            }
            GLES20.glClear(Http2.INITIAL_MAX_FRAME_SIZE);
            GLES20.glDrawArrays(5, 0, 4);
            try {
                fa1.c();
            } catch (fa1.a e) {
                xz1.e("VideoDecoderGLSV", "Failed to draw a frame", e);
            }
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceChanged(GL10 gl10, int i, int i2) {
            GLES20.glViewport(0, 0, i, i2);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // android.opengl.GLSurfaceView.Renderer
        public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            try {
                ea1 ea1Var = new ea1("varying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nattribute vec4 in_pos;\nattribute vec2 in_tc_y;\nattribute vec2 in_tc_u;\nattribute vec2 in_tc_v;\nvoid main() {\n  gl_Position = in_pos;\n  interp_tc_y = in_tc_y;\n  interp_tc_u = in_tc_u;\n  interp_tc_v = in_tc_v;\n}\n", "precision mediump float;\nvarying vec2 interp_tc_y;\nvarying vec2 interp_tc_u;\nvarying vec2 interp_tc_v;\nuniform sampler2D y_tex;\nuniform sampler2D u_tex;\nuniform sampler2D v_tex;\nuniform mat3 mColorConversion;\nvoid main() {\n  vec3 yuv;\n  yuv.x = texture2D(y_tex, interp_tc_y).r - 0.0625;\n  yuv.y = texture2D(u_tex, interp_tc_u).r - 0.5;\n  yuv.z = texture2D(v_tex, interp_tc_v).r - 0.5;\n  gl_FragColor = vec4(mColorConversion * yuv, 1.0);\n}\n");
                this.m = ea1Var;
                GLES20.glVertexAttribPointer(ea1Var.e("in_pos"), 2, 5126, false, 0, (Buffer) t);
                this.h[0] = this.m.e("in_tc_y");
                this.h[1] = this.m.e("in_tc_u");
                this.h[2] = this.m.e("in_tc_v");
                this.n = this.m.j("mColorConversion");
                fa1.c();
                b();
                fa1.c();
            } catch (fa1.a e) {
                xz1.e("VideoDecoderGLSV", "Failed to set up the textures and program", e);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public h25(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a aVar = new a(this);
        this.f = aVar;
        setPreserveEGLContextOnPause(true);
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setRenderMode(0);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Deprecated
    public i25 getVideoDecoderOutputBufferRenderer() {
        return this;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public void setOutputBuffer(VideoDecoderOutputBuffer videoDecoderOutputBuffer) {
        this.f.a(videoDecoderOutputBuffer);
    }

    public h25(Context context) {
        this(context, null);
    }
}
