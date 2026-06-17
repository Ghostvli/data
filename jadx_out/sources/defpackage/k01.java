package defpackage;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class k01 extends hz1 {
    public k01(ContentResolver contentResolver, Uri uri, boolean z) {
        super(contentResolver, uri, z);
    }

    @Override // defpackage.t90
    public Class a() {
        return ParcelFileDescriptor.class;
    }

    @Override // defpackage.hz1
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void d(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        parcelFileDescriptor.close();
    }

    @Override // defpackage.hz1
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public ParcelFileDescriptor f(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorG = g(uri);
        if (assetFileDescriptorG != null) {
            return assetFileDescriptorG.getParcelFileDescriptor();
        }
        xe5.a("FileDescriptor is null for: ", uri);
        return null;
    }
}
