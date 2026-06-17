package defpackage;

import j$.nio.file.Files;
import j$.nio.file.Path;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.DirectoryStream;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p93 extends o93 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Finally have unexpected throw blocks count: 2, expect 1 */
    public static final List a(Path path, String str) throws IllegalAccessException, IOException, InvocationTargetException {
        path.getClass();
        str.getClass();
        DirectoryStream<Path> directoryStreamNewDirectoryStream = Files.newDirectoryStream(path, str);
        try {
            directoryStreamNewDirectoryStream.getClass();
            List listA0 = ww.a0(directoryStreamNewDirectoryStream);
            bv.a(directoryStreamNewDirectoryStream, null);
            return listA0;
        } finally {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static /* synthetic */ List b(Path path, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "*";
        }
        return a(path, str);
    }
}
