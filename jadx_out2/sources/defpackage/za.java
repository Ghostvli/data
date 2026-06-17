package defpackage;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import java.io.FileNotFoundException;
import java.io.IOException;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class za extends hz1 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public za(ContentResolver contentResolver, Uri uri, boolean z) {
        super(contentResolver, uri, z);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.t90
    public Class a() {
        return AssetFileDescriptor.class;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: d(Ljava/lang/Object;)V */
    @Override // defpackage.hz1
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public void d(AssetFileDescriptor assetFileDescriptor) throws IOException {
        assetFileDescriptor.close();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: f(Landroid/net/Uri;Landroid/content/ContentResolver;)Ljava/lang/Object; */
    @Override // defpackage.hz1
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public AssetFileDescriptor f(Uri uri, ContentResolver contentResolver) throws FileNotFoundException {
        AssetFileDescriptor assetFileDescriptorG = g(uri);
        if (assetFileDescriptorG != null) {
            return assetFileDescriptorG;
        }
        xe5.a("FileDescriptor is null for: ", uri);
        return null;
    }
}
