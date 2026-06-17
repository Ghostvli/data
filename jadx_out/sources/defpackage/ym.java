package defpackage;

import android.util.Log;
import defpackage.t90;
import defpackage.vt2;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class ym implements vt2 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements t90 {
        public final File f;

        public a(File file) {
            this.f = file;
        }

        @Override // defpackage.t90
        public Class a() {
            return ByteBuffer.class;
        }

        @Override // defpackage.t90
        public void b() {
        }

        @Override // defpackage.t90
        public void c(ug3 ug3Var, t90.a aVar) {
            try {
                aVar.f(bn.a(this.f));
            } catch (IOException e) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e);
                }
                aVar.d(e);
            }
        }

        @Override // defpackage.t90
        public void cancel() {
        }

        @Override // defpackage.t90
        public ba0 e() {
            return ba0.LOCAL;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b implements wt2 {
        @Override // defpackage.wt2
        public void d() {
        }

        @Override // defpackage.wt2
        public vt2 e(bw2 bw2Var) {
            return new ym();
        }
    }

    @Override // defpackage.vt2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public vt2.a b(File file, int i, int i2, u63 u63Var) {
        return new vt2.a(new t43(file), new a(file));
    }

    @Override // defpackage.vt2
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(File file) {
        return true;
    }
}
