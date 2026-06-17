package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaMetadataRetriever;
import com.fongmi.android.tv.App;
import com.fongmi.android.tv.bean.Config;
import com.github.catvod.utils.Path;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class m85 extends gh {
    public static final String e = "m85";

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        public static volatile m85 a = new m85();
    }

    public static void D(Config config, to toVar) {
        x().w(config).n(toVar);
    }

    public static m85 x() {
        return a.a;
    }

    public static String y() {
        return x().i().getDesc();
    }

    public final boolean A(File file) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            return "image/gif".equals(options.outMimeType);
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean B(File file) {
        try {
            MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(file.getAbsolutePath());
                boolean zEqualsIgnoreCase = "yes".equalsIgnoreCase(mediaMetadataRetriever.extractMetadata(17));
                d45.a(mediaMetadataRetriever);
                return zEqualsIgnoreCase;
            } finally {
            }
        } catch (Exception unused) {
            return false;
        }
    }

    public void C() {
        if (this.b) {
            return;
        }
        n(new to());
    }

    public final void E(File file) {
        Bitmap bitmap = (Bitmap) ((br3) ((br3) ((br3) ((br3) com.bumptech.glide.a.t(App.b()).e().k(0L)).y0(file).V(vr3.j(), vr3.g())).e0(true)).g(zl0.b)).D0().get();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(w01.l());
            try {
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                fileOutputStream.close();
            } finally {
            }
        } finally {
            bitmap.recycle();
        }
    }

    public final void F(File file) {
        q24.y0(0);
        if (A(file)) {
            q24.y0(1);
        } else if (B(file)) {
            q24.y0(2);
        }
    }

    @Override // defpackage.gh
    public Config e() {
        return Config.wall();
    }

    @Override // defpackage.gh
    public /* bridge */ /* synthetic */ Config i() {
        return super.i();
    }

    @Override // defpackage.gh
    public String j() {
        return e;
    }

    @Override // defpackage.gh
    public boolean l() {
        return false;
    }

    @Override // defpackage.gh
    public /* bridge */ /* synthetic */ void n(to toVar) {
        super.n(toVar);
    }

    @Override // defpackage.gh
    public void o(Config config) throws FileNotFoundException {
        File fileK = w01.k(0);
        v(config.getUrl(), fileK);
        F(fileK);
        E(fileK);
    }

    @Override // defpackage.gh
    public /* bridge */ /* synthetic */ boolean q(String str) {
        return super.q(str);
    }

    @Override // defpackage.gh
    public void r() {
        super.r();
        c00.j();
    }

    public final void v(String str, File file) throws FileNotFoundException {
        if (str.startsWith("file")) {
            Path.copy(Path.local(str), file);
        } else {
            fn0.a(qx4.a(str), file).f(e).d();
        }
        if (!Path.exists(file)) {
            throw new FileNotFoundException();
        }
    }

    public m85 w(Config config) {
        this.c = config;
        if (config.isEmpty()) {
            return this;
        }
        this.b = config.getUrl().equals(b75.I().a0());
        return this;
    }

    public m85 z() {
        return w(Config.wall());
    }
}
