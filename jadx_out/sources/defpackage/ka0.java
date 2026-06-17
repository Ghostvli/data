package defpackage;

import android.util.Base64;
import defpackage.t90;
import defpackage.vt2;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ka0 implements vt2 {
    public final a a;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        Class a();

        void b(Object obj);

        Object c(String str);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements t90 {
        public final String f;
        public final a g;
        public Object h;

        public b(String str, a aVar) {
            this.f = str;
            this.g = aVar;
        }

        @Override // defpackage.t90
        public Class a() {
            return this.g.a();
        }

        @Override // defpackage.t90
        public void b() {
            try {
                this.g.b(this.h);
            } catch (IOException unused) {
            }
        }

        @Override // defpackage.t90
        public void c(ug3 ug3Var, t90.a aVar) {
            try {
                Object objC = this.g.c(this.f);
                this.h = objC;
                aVar.f(objC);
            } catch (IllegalArgumentException e) {
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
    public static final class c implements wt2 {
        public final a a = new a();

        /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
        public class a implements a {
            public a() {
            }

            @Override // ka0.a
            public Class a() {
                return InputStream.class;
            }

            @Override // ka0.a
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // ka0.a
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public InputStream c(String str) {
                if (!str.startsWith("data:image")) {
                    jl.a("Not a valid image data URL.");
                    return null;
                }
                int iIndexOf = str.indexOf(44);
                if (iIndexOf == -1) {
                    jl.a("Missing comma in data URL.");
                    return null;
                }
                if (str.substring(0, iIndexOf).endsWith(";base64")) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
                }
                jl.a("Not a base64 image data URL.");
                return null;
            }
        }

        @Override // defpackage.wt2
        public void d() {
        }

        @Override // defpackage.wt2
        public vt2 e(bw2 bw2Var) {
            return new ka0(this.a);
        }
    }

    public ka0(a aVar) {
        this.a = aVar;
    }

    @Override // defpackage.vt2
    public boolean a(Object obj) {
        return obj.toString().startsWith("data:image");
    }

    @Override // defpackage.vt2
    public vt2.a b(Object obj, int i, int i2, u63 u63Var) {
        return new vt2.a(new t43(obj), new b(obj.toString(), this.a));
    }
}
