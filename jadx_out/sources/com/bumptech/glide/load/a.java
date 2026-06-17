package com.bumptech.glide.load;

import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import defpackage.bn;
import defpackage.dp3;
import defpackage.ma;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.bumptech.glide.load.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class C0053a implements l {
        public final /* synthetic */ InputStream a;

        public C0053a(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // com.bumptech.glide.load.a.l
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.c(this.a);
            } finally {
                this.a.reset();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b implements l {
        public final /* synthetic */ ByteBuffer a;

        public b(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
        }

        @Override // com.bumptech.glide.load.a.l
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) {
            try {
                return imageHeaderParser.a(this.a);
            } finally {
                bn.d(this.a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c implements l {
        public final /* synthetic */ ParcelFileDescriptorRewinder a;
        public final /* synthetic */ ma b;

        public c(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, ma maVar) {
            this.a = parcelFileDescriptorRewinder;
            this.b = maVar;
        }

        @Override // com.bumptech.glide.load.a.l
        public ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser) throws Throwable {
            dp3 dp3Var = null;
            try {
                dp3 dp3Var2 = new dp3(new FileInputStream(this.a.a().getFileDescriptor()), this.b);
                try {
                    ImageHeaderParser.ImageType imageTypeC = imageHeaderParser.c(dp3Var2);
                    dp3Var2.h();
                    this.a.a();
                    return imageTypeC;
                } catch (Throwable th) {
                    th = th;
                    dp3Var = dp3Var2;
                    if (dp3Var != null) {
                        dp3Var.h();
                    }
                    this.a.a();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class d implements k {
        public final /* synthetic */ ByteBuffer a;
        public final /* synthetic */ ma b;

        public d(ByteBuffer byteBuffer, ma maVar) {
            this.a = byteBuffer;
            this.b = maVar;
        }

        @Override // com.bumptech.glide.load.a.k
        public int a(ImageHeaderParser imageHeaderParser) {
            try {
                return imageHeaderParser.f(this.a, this.b);
            } finally {
                bn.d(this.a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class e implements k {
        public final /* synthetic */ InputStream a;
        public final /* synthetic */ ma b;

        public e(InputStream inputStream, ma maVar) {
            this.a = inputStream;
            this.b = maVar;
        }

        @Override // com.bumptech.glide.load.a.k
        public int a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.d(this.a, this.b);
            } finally {
                this.a.reset();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class f implements k {
        public final /* synthetic */ ParcelFileDescriptorRewinder a;
        public final /* synthetic */ ma b;

        public f(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, ma maVar) {
            this.a = parcelFileDescriptorRewinder;
            this.b = maVar;
        }

        @Override // com.bumptech.glide.load.a.k
        public int a(ImageHeaderParser imageHeaderParser) throws Throwable {
            dp3 dp3Var = null;
            try {
                dp3 dp3Var2 = new dp3(new FileInputStream(this.a.a().getFileDescriptor()), this.b);
                try {
                    int iD = imageHeaderParser.d(dp3Var2, this.b);
                    dp3Var2.h();
                    this.a.a();
                    return iD;
                } catch (Throwable th) {
                    th = th;
                    dp3Var = dp3Var2;
                    if (dp3Var != null) {
                        dp3Var.h();
                    }
                    this.a.a();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class g implements j {
        public final /* synthetic */ ByteBuffer a;
        public final /* synthetic */ ma b;

        public g(ByteBuffer byteBuffer, ma maVar) {
            this.a = byteBuffer;
            this.b = maVar;
        }

        @Override // com.bumptech.glide.load.a.j
        public boolean a(ImageHeaderParser imageHeaderParser) {
            try {
                return imageHeaderParser.b(this.a, this.b);
            } finally {
                bn.d(this.a);
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class h implements j {
        public final /* synthetic */ InputStream a;
        public final /* synthetic */ ma b;

        public h(InputStream inputStream, ma maVar) {
            this.a = inputStream;
            this.b = maVar;
        }

        @Override // com.bumptech.glide.load.a.j
        public boolean a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.e(this.a, this.b);
            } finally {
                this.a.reset();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class i implements j {
        public final /* synthetic */ ParcelFileDescriptorRewinder a;
        public final /* synthetic */ ma b;

        public i(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, ma maVar) {
            this.a = parcelFileDescriptorRewinder;
            this.b = maVar;
        }

        @Override // com.bumptech.glide.load.a.j
        public boolean a(ImageHeaderParser imageHeaderParser) throws Throwable {
            dp3 dp3Var = null;
            try {
                dp3 dp3Var2 = new dp3(new FileInputStream(this.a.a().getFileDescriptor()), this.b);
                try {
                    boolean zE = imageHeaderParser.e(dp3Var2, this.b);
                    dp3Var2.h();
                    this.a.a();
                    return zE;
                } catch (Throwable th) {
                    th = th;
                    dp3Var = dp3Var2;
                    if (dp3Var != null) {
                        dp3Var.h();
                    }
                    this.a.a();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface j {
        boolean a(ImageHeaderParser imageHeaderParser);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface k {
        int a(ImageHeaderParser imageHeaderParser);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface l {
        ImageHeaderParser.ImageType a(ImageHeaderParser imageHeaderParser);
    }

    public static int a(List list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, ma maVar) {
        return d(list, new f(parcelFileDescriptorRewinder, maVar));
    }

    public static int b(List list, InputStream inputStream, ma maVar) {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new dp3(inputStream, maVar);
        }
        inputStream.mark(5242880);
        return d(list, new e(inputStream, maVar));
    }

    public static int c(List list, ByteBuffer byteBuffer, ma maVar) {
        if (byteBuffer == null) {
            return -1;
        }
        return d(list, new d(byteBuffer, maVar));
    }

    public static int d(List list, k kVar) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            int iA = kVar.a((ImageHeaderParser) list.get(i2));
            if (iA != -1) {
                return iA;
            }
        }
        return -1;
    }

    public static ImageHeaderParser.ImageType e(List list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, ma maVar) {
        return h(list, new c(parcelFileDescriptorRewinder, maVar));
    }

    public static ImageHeaderParser.ImageType f(List list, InputStream inputStream, ma maVar) {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new dp3(inputStream, maVar);
        }
        inputStream.mark(5242880);
        return h(list, new C0053a(inputStream));
    }

    public static ImageHeaderParser.ImageType g(List list, ByteBuffer byteBuffer) {
        return byteBuffer == null ? ImageHeaderParser.ImageType.UNKNOWN : h(list, new b(byteBuffer));
    }

    public static ImageHeaderParser.ImageType h(List list, l lVar) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageHeaderParser.ImageType imageTypeA = lVar.a((ImageHeaderParser) list.get(i2));
            if (imageTypeA != ImageHeaderParser.ImageType.UNKNOWN) {
                return imageTypeA;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    public static boolean i(List list, ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, ma maVar) {
        return l(list, new i(parcelFileDescriptorRewinder, maVar));
    }

    public static boolean j(List list, InputStream inputStream, ma maVar) {
        if (inputStream == null) {
            return false;
        }
        if (!inputStream.markSupported()) {
            inputStream = new dp3(inputStream, maVar);
        }
        inputStream.mark(5242880);
        return l(list, new h(inputStream, maVar));
    }

    public static boolean k(List list, ByteBuffer byteBuffer, ma maVar) {
        if (byteBuffer == null) {
            return false;
        }
        return l(list, new g(byteBuffer, maVar));
    }

    public static boolean l(List list, j jVar) {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (jVar.a((ImageHeaderParser) list.get(i2))) {
                return true;
            }
        }
        return false;
    }
}
