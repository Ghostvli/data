package okio;

import okio.internal.ZipFilesKt;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
final /* synthetic */ class Okio__ZlibOkioKt {
    /* JADX DEBUG: Class process forced to load method for inline: okio.internal.ZipFilesKt.openZip$default(okio.Path, okio.FileSystem, kotlin.jvm.functions.Function1, int, java.lang.Object):okio.ZipFileSystem */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final FileSystem openZip(FileSystem fileSystem, Path path) {
        fileSystem.getClass();
        path.getClass();
        return ZipFilesKt.openZip$default(path, fileSystem, null, 4, null);
    }
}
