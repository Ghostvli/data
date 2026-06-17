package defpackage;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public interface mi1 {

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a implements mi1 {
        public final ByteBuffer a;
        public final List b;
        public final ma c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public a(ByteBuffer byteBuffer, List list, ma maVar) {
            this.a = byteBuffer;
            this.b = list;
            this.c = maVar;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.mi1
        public int a() {
            return com.bumptech.glide.load.a.c(this.b, bn.d(this.a), this.c);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.mi1
        public Bitmap b(BitmapFactory.Options options) {
            return ha1.b(f(), options, this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.mi1
        public boolean c() {
            return com.bumptech.glide.load.a.k(this.b, bn.d(this.a), this.c);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.mi1
        public void d() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.mi1
        public ImageHeaderParser.ImageType e() {
            return com.bumptech.glide.load.a.g(this.b, bn.d(this.a));
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public final InputStream f() {
            return bn.g(bn.d(this.a));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class b implements mi1 {
        public final com.bumptech.glide.load.data.c a;
        public final ma b;
        public final List c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(InputStream inputStream, List list, ma maVar) {
            this.b = (ma) fg3.e(maVar);
            this.c = (List) fg3.e(list);
            this.a = new com.bumptech.glide.load.data.c(inputStream, maVar);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.mi1
        public int a() {
            return com.bumptech.glide.load.a.b(this.c, this.a.a(), this.b);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.mi1
        public Bitmap b(BitmapFactory.Options options) {
            return ha1.b(this.a.a(), options, this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.mi1
        public boolean c() {
            return com.bumptech.glide.load.a.j(this.c, this.a.a(), this.b);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.mi1
        public void d() {
            this.a.c();
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.mi1
        public ImageHeaderParser.ImageType e() {
            return com.bumptech.glide.load.a.f(this.c, this.a.a(), this.b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class c implements mi1 {
        public final ma a;
        public final List b;
        public final ParcelFileDescriptorRewinder c;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public c(ParcelFileDescriptor parcelFileDescriptor, List list, ma maVar) {
            this.a = (ma) fg3.e(maVar);
            this.b = (List) fg3.e(list);
            this.c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.mi1
        public int a() {
            return com.bumptech.glide.load.a.a(this.b, this.c, this.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.mi1
        public Bitmap b(BitmapFactory.Options options) {
            return ha1.a(this.c.a().getFileDescriptor(), options, this);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.mi1
        public boolean c() {
            return com.bumptech.glide.load.a.i(this.b, this.c, this.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.mi1
        public void d() {
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.mi1
        public ImageHeaderParser.ImageType e() {
            return com.bumptech.glide.load.a.e(this.b, this.c, this.a);
        }
    }

    int a();

    Bitmap b(BitmapFactory.Options options);

    boolean c();

    void d();

    ImageHeaderParser.ImageType e();
}
