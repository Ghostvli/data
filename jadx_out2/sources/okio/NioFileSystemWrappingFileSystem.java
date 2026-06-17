package okio;

import defpackage.ep1;
import defpackage.jl;
import defpackage.np3;
import defpackage.nw;
import defpackage.p93;
import defpackage.sb1;
import defpackage.sw;
import defpackage.we5;
import defpackage.xe5;
import j$.nio.channels.DesugarChannels;
import j$.nio.file.CopyOption;
import j$.nio.file.Files;
import j$.nio.file.LinkOption;
import j$.nio.file.OpenOption;
import j$.nio.file.StandardCopyOption;
import j$.nio.file.StandardOpenOption;
import j$.nio.file.attribute.FileAttribute;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import okio.Path;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class NioFileSystemWrappingFileSystem extends NioSystemFileSystem {
    private final j$.nio.file.FileSystem nioFileSystem;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public NioFileSystemWrappingFileSystem(j$.nio.file.FileSystem fileSystem) {
        fileSystem.getClass();
        this.nioFileSystem = fileSystem;
    }

    /* JADX DEBUG: Class process forced to load method for inline: p93.b(j$.nio.file.Path, java.lang.String, int, java.lang.Object):java.util.List */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final List<Path> list(Path path, boolean z) throws IOException {
        j$.nio.file.Path pathResolve = resolve(path);
        try {
            List listB = p93.b(pathResolve, null, 1, null);
            ArrayList arrayList = new ArrayList();
            Iterator it = listB.iterator();
            while (it.hasNext()) {
                arrayList.add(Path.Companion.get$default(Path.Companion, (j$.nio.file.Path) it.next(), false, 1, (Object) null));
            }
            sw.u(arrayList);
            return arrayList;
        } catch (Exception unused) {
            if (z) {
                if (!Files.exists(pathResolve, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                    xe5.a("no such file: ", path);
                    return null;
                }
                we5.a("failed to list ", path);
            }
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    private final j$.nio.file.Path resolve(Path path) {
        j$.nio.file.Path path2 = this.nioFileSystem.getPath(path.toString(), new String[0]);
        path2.getClass();
        return path2;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public Sink appendingSink(Path path, boolean z) {
        path.getClass();
        List listC = nw.c();
        listC.add(StandardOpenOption.APPEND);
        if (!z) {
            listC.add(StandardOpenOption.CREATE);
        }
        List listA = nw.a(listC);
        j$.nio.file.Path pathResolve = resolve(path);
        StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) listA.toArray(new StandardOpenOption[0]);
        OpenOption[] openOptionArr = (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length);
        OutputStream outputStreamNewOutputStream = Files.newOutputStream(pathResolve, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
        outputStreamNewOutputStream.getClass();
        return Okio.sink(outputStreamNewOutputStream);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okio.NioSystemFileSystem, okio.JvmSystemFileSystem, okio.FileSystem
    public void atomicMove(Path path, Path path2) throws IOException {
        path.getClass();
        path2.getClass();
        try {
            Files.move(resolve(path), resolve(path2), (CopyOption[]) Arrays.copyOf(new CopyOption[]{StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING}, 2)).getClass();
        } catch (UnsupportedOperationException unused) {
            sb1.a("atomic move not supported");
        } catch (NoSuchFileException e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public Path canonicalize(Path path) throws FileNotFoundException {
        path.getClass();
        try {
            Path.Companion companion = Path.Companion;
            j$.nio.file.Path realPath = resolve(path).toRealPath(new LinkOption[0]);
            realPath.getClass();
            return Path.Companion.get$default(companion, realPath, false, 1, (Object) null);
        } catch (NoSuchFileException unused) {
            xe5.a("no such file: ", path);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okio.FileSystem, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.nioFileSystem.close();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0012  */
    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void createDirectory(Path path, boolean z) throws IOException {
        boolean z2;
        path.getClass();
        FileMetadata fileMetadataMetadataOrNull = metadataOrNull(path);
        if (fileMetadataMetadataOrNull != null) {
            z2 = fileMetadataMetadataOrNull.isDirectory();
        }
        if (z2 && z) {
            ep1.a(path, " already exists.");
            return;
        }
        try {
            Files.createDirectory(resolve(path), (FileAttribute[]) Arrays.copyOf(new FileAttribute[0], 0)).getClass();
        } catch (IOException e) {
            if (z2) {
                return;
            }
            throw new IOException("failed to create directory: " + path, e);
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okio.NioSystemFileSystem, okio.JvmSystemFileSystem, okio.FileSystem
    public void createSymlink(Path path, Path path2) {
        path.getClass();
        path2.getClass();
        Files.createSymbolicLink(resolve(path), resolve(path2), (FileAttribute[]) Arrays.copyOf(new FileAttribute[0], 0)).getClass();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public void delete(Path path, boolean z) throws IOException {
        path.getClass();
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        j$.nio.file.Path pathResolve = resolve(path);
        try {
            Files.delete(pathResolve);
        } catch (NoSuchFileException unused) {
            if (z) {
                xe5.a("no such file: ", path);
            }
        } catch (IOException unused2) {
            if (Files.exists(pathResolve, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0))) {
                we5.a("failed to delete ", path);
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public List<Path> listOrNull(Path path) {
        path.getClass();
        return list(path, false);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okio.NioSystemFileSystem, okio.JvmSystemFileSystem, okio.FileSystem
    public FileMetadata metadataOrNull(Path path) {
        path.getClass();
        return metadataOrNull(resolve(path));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public FileHandle openReadOnly(Path path) throws FileNotFoundException {
        path.getClass();
        try {
            FileChannel fileChannelOpen = DesugarChannels.open(resolve(path), StandardOpenOption.READ);
            fileChannelOpen.getClass();
            return new NioFileSystemFileHandle(false, fileChannelOpen);
        } catch (NoSuchFileException unused) {
            xe5.a("no such file: ", path);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public FileHandle openReadWrite(Path path, boolean z, boolean z2) throws FileNotFoundException {
        path.getClass();
        if (z && z2) {
            jl.a("Cannot require mustCreate and mustExist at the same time.");
            return null;
        }
        List listC = nw.c();
        listC.add(StandardOpenOption.READ);
        listC.add(StandardOpenOption.WRITE);
        if (z) {
            listC.add(StandardOpenOption.CREATE_NEW);
        } else if (!z2) {
            listC.add(StandardOpenOption.CREATE);
        }
        List listA = nw.a(listC);
        try {
            j$.nio.file.Path pathResolve = resolve(path);
            StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) listA.toArray(new StandardOpenOption[0]);
            FileChannel fileChannelOpen = DesugarChannels.open(pathResolve, (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length));
            fileChannelOpen.getClass();
            return new NioFileSystemFileHandle(true, fileChannelOpen);
        } catch (NoSuchFileException unused) {
            xe5.a("no such file: ", path);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public Sink sink(Path path, boolean z) throws FileNotFoundException {
        path.getClass();
        List listC = nw.c();
        if (z) {
            listC.add(StandardOpenOption.CREATE_NEW);
        }
        List listA = nw.a(listC);
        try {
            j$.nio.file.Path pathResolve = resolve(path);
            StandardOpenOption[] standardOpenOptionArr = (StandardOpenOption[]) listA.toArray(new StandardOpenOption[0]);
            OpenOption[] openOptionArr = (OpenOption[]) Arrays.copyOf(standardOpenOptionArr, standardOpenOptionArr.length);
            OutputStream outputStreamNewOutputStream = Files.newOutputStream(pathResolve, (OpenOption[]) Arrays.copyOf(openOptionArr, openOptionArr.length));
            outputStreamNewOutputStream.getClass();
            return Okio.sink(outputStreamNewOutputStream);
        } catch (NoSuchFileException unused) {
            xe5.a("no such file: ", path);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public Source source(Path path) throws FileNotFoundException {
        path.getClass();
        try {
            InputStream inputStreamNewInputStream = Files.newInputStream(resolve(path), (OpenOption[]) Arrays.copyOf(new OpenOption[0], 0));
            inputStreamNewInputStream.getClass();
            return Okio.source(inputStreamNewInputStream);
        } catch (NoSuchFileException unused) {
            xe5.a("no such file: ", path);
            return null;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okio.NioSystemFileSystem, okio.JvmSystemFileSystem
    public String toString() {
        String strC = np3.b(this.nioFileSystem.getClass()).c();
        strC.getClass();
        return strC;
    }

    @Override // okio.JvmSystemFileSystem, okio.FileSystem
    public List<Path> list(Path path) throws IOException {
        path.getClass();
        List<Path> list = list(path, true);
        list.getClass();
        return list;
    }
}
