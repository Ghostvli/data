package defpackage;

import defpackage.t90;
import defpackage.vt2;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class um implements vt2 {
    public final b a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a implements wt2 {

        /* JADX INFO: renamed from: um$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class C0124a implements b {
            public C0124a() {
            }

            @Override // um.b
            public Class a() {
                return ByteBuffer.class;
            }

            @Override // um.b
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public ByteBuffer b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // defpackage.wt2
        public void d() {
        }

        @Override // defpackage.wt2
        public vt2 e(bw2 bw2Var) {
            return new um(new C0124a());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface b {
        Class a();

        Object b(byte[] bArr);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class c implements t90 {
        public final byte[] f;
        public final b g;

        public c(byte[] bArr, b bVar) {
            this.f = bArr;
            this.g = bVar;
        }

        @Override // defpackage.t90
        public Class a() {
            return this.g.a();
        }

        @Override // defpackage.t90
        public void b() {
        }

        @Override // defpackage.t90
        public void c(ug3 ug3Var, t90.a aVar) {
            aVar.f(this.g.b(this.f));
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
    public static class d implements wt2 {

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements b {
            public a() {
            }

            @Override // um.b
            public Class a() {
                return InputStream.class;
            }

            @Override // um.b
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public InputStream b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // defpackage.wt2
        public void d() {
        }

        @Override // defpackage.wt2
        public vt2 e(bw2 bw2Var) {
            return new um(new a());
        }
    }

    public um(b bVar) {
        this.a = bVar;
    }

    @Override // defpackage.vt2
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public vt2.a b(byte[] bArr, int i, int i2, u63 u63Var) {
        return new vt2.a(new t43(bArr), new c(bArr, this.a));
    }

    @Override // defpackage.vt2
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(byte[] bArr) {
        return true;
    }
}
