package defpackage;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import defpackage.t90;
import defpackage.vt2;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class ul0 implements vt2 {
    public final Context a;
    public final e b;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements wt2, e {
        public final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // ul0.e
        public Class a() {
            return AssetFileDescriptor.class;
        }

        @Override // defpackage.wt2
        public void d() {
        }

        @Override // defpackage.wt2
        public vt2 e(bw2 bw2Var) {
            return new ul0(this.a, this);
        }

        @Override // ul0.e
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(AssetFileDescriptor assetFileDescriptor) throws IOException {
            assetFileDescriptor.close();
        }

        @Override // ul0.e
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public AssetFileDescriptor c(Resources.Theme theme, Resources resources, int i) {
            return resources.openRawResourceFd(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements wt2, e {
        public final Context a;

        public b(Context context) {
            this.a = context;
        }

        @Override // ul0.e
        public Class a() {
            return Drawable.class;
        }

        @Override // defpackage.wt2
        public void d() {
        }

        @Override // defpackage.wt2
        public vt2 e(bw2 bw2Var) {
            return new ul0(this.a, this);
        }

        @Override // ul0.e
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(Drawable drawable) {
        }

        @Override // ul0.e
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public Drawable c(Resources.Theme theme, Resources resources, int i) {
            return un0.a(this.a, i, theme);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c implements wt2, e {
        public final Context a;

        public c(Context context) {
            this.a = context;
        }

        @Override // ul0.e
        public Class a() {
            return InputStream.class;
        }

        @Override // defpackage.wt2
        public void d() {
        }

        @Override // defpackage.wt2
        public vt2 e(bw2 bw2Var) {
            return new ul0(this.a, this);
        }

        @Override // ul0.e
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public void b(InputStream inputStream) throws IOException {
            inputStream.close();
        }

        @Override // ul0.e
        /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
        public InputStream c(Resources.Theme theme, Resources resources, int i) {
            return resources.openRawResource(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class d implements t90 {
        public final Resources.Theme f;
        public final Resources g;
        public final e h;
        public final int i;
        public Object j;

        public d(Resources.Theme theme, Resources resources, e eVar, int i) {
            this.f = theme;
            this.g = resources;
            this.h = eVar;
            this.i = i;
        }

        @Override // defpackage.t90
        public Class a() {
            return this.h.a();
        }

        @Override // defpackage.t90
        public void b() {
            Object obj = this.j;
            if (obj != null) {
                try {
                    this.h.b(obj);
                } catch (IOException unused) {
                }
            }
        }

        @Override // defpackage.t90
        public void c(ug3 ug3Var, t90.a aVar) {
            try {
                Object objC = this.h.c(this.f, this.g, this.i);
                this.j = objC;
                aVar.f(objC);
            } catch (Resources.NotFoundException e) {
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
    public interface e {
        Class a();

        void b(Object obj);

        Object c(Resources.Theme theme, Resources resources, int i);
    }

    public ul0(Context context, e eVar) {
        this.a = context.getApplicationContext();
        this.b = eVar;
    }

    public static wt2 c(Context context) {
        return new a(context);
    }

    public static wt2 e(Context context) {
        return new b(context);
    }

    public static wt2 g(Context context) {
        return new c(context);
    }

    @Override // defpackage.vt2
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public vt2.a b(Integer num, int i, int i2, u63 u63Var) {
        Resources.Theme theme = (Resources.Theme) u63Var.c(fs3.b);
        return new vt2.a(new t43(num), new d(theme, theme != null ? theme.getResources() : this.a.getResources(), this.b, num.intValue()));
    }

    @Override // defpackage.vt2
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean a(Integer num) {
        return true;
    }
}
