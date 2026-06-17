package defpackage;

import android.content.Context;
import android.graphics.Point;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.media3.exoplayer.p;
import defpackage.gi1;
import java.io.IOException;
import java.nio.ByteBuffer;
import okio.internal.Buffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class fk extends b74 implements gi1 {
    public final Context o;
    public final int p;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a extends li1 {
        public a() {
        }

        @Override // androidx.media3.decoder.a
        public void release() {
            fk.this.t(this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements gi1.a {
        public final Context a;
        public int b = -1;

        public b(Context context) {
            this.a = (Context) gg3.q(context);
        }

        @Override // gi1.a
        public int a(t41 t41Var) {
            String str = t41Var.p;
            return (str == null || !nt2.q(str)) ? p.C(0) : fy4.P0(t41Var.p) ? p.C(4) : p.C(1);
        }

        @Override // gi1.a
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public fk b() {
            return new fk(this.a, this.b, null);
        }
    }

    public fk(Context context, int i) {
        super(new DecoderInputBuffer[1], new li1[1]);
        this.o = context;
        this.p = i;
    }

    @Override // defpackage.b74
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public hi1 l(DecoderInputBuffer decoderInputBuffer, li1 li1Var, boolean z) {
        ByteBuffer byteBuffer = (ByteBuffer) gg3.q(decoderInputBuffer.data);
        gg3.v(byteBuffer.hasArray());
        gg3.d(byteBuffer.arrayOffset() == 0);
        try {
            int iMax = this.p;
            if (iMax == -1) {
                Context context = this.o;
                if (context != null) {
                    Point pointD0 = fy4.d0(context);
                    int i = pointD0.x;
                    int i2 = pointD0.y;
                    t41 t41Var = decoderInputBuffer.format;
                    if (t41Var != null) {
                        int i3 = t41Var.O;
                        if (i3 != -1) {
                            i *= i3;
                        }
                        int i4 = t41Var.P;
                        if (i4 != -1) {
                            i2 *= i4;
                        }
                    }
                    iMax = (Math.max(i, i2) * 2) - 1;
                } else {
                    iMax = Buffer.SEGMENTING_THRESHOLD;
                }
            }
            li1Var.f = ok.a(byteBuffer.array(), byteBuffer.remaining(), null, iMax);
            li1Var.timeUs = decoderInputBuffer.timeUs;
            return null;
        } catch (r83 e) {
            return new hi1("Could not decode image data with BitmapFactory.", e);
        } catch (IOException e2) {
            return new hi1(e2);
        }
    }

    @Override // defpackage.b74, defpackage.fb0
    public /* bridge */ /* synthetic */ li1 a() {
        return (li1) super.a();
    }

    @Override // defpackage.b74
    public DecoderInputBuffer i() {
        return new DecoderInputBuffer(1);
    }

    @Override // defpackage.b74
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public li1 j() {
        return new a();
    }

    @Override // defpackage.b74
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public hi1 k(Throwable th) {
        return new hi1("Unexpected decode error", th);
    }

    public /* synthetic */ fk(Context context, int i, a aVar) {
        this(context, i);
    }
}
