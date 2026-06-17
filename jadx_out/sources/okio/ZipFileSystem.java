package okio;

import defpackage.mv0;
import defpackage.we0;
import defpackage.we5;
import defpackage.ww;
import defpackage.xe5;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import okio.Path;
import okio.internal.FixedLengthSource;
import okio.internal.ZipEntry;
import okio.internal.ZipFilesKt;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ZipFileSystem extends FileSystem {
    private static final Companion Companion = new Companion(null);
    private static final Path ROOT = Path.Companion.get$default(Path.Companion, ServiceReference.DELIMITER, false, 1, (Object) null);
    private final String comment;
    private final Map<Path, ZipEntry> entries;
    private final FileSystem fileSystem;
    private final Path zipPath;

    public ZipFileSystem(Path path, FileSystem fileSystem, Map<Path, ZipEntry> map, String str) {
        path.getClass();
        fileSystem.getClass();
        map.getClass();
        this.zipPath = path;
        this.fileSystem = fileSystem;
        this.entries = map;
        this.comment = str;
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    private final List<Path> list(Path path, boolean z) throws IOException {
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(path));
        if (zipEntry != null) {
            return ww.a0(zipEntry.getChildren());
        }
        if (!z) {
            return null;
        }
        we5.a("not a directory: ", path);
        return null;
    }

    @Override // okio.FileSystem
    public Sink appendingSink(Path path, boolean z) throws IOException {
        path.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void atomicMove(Path path, Path path2) throws IOException {
        path.getClass();
        path2.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public Path canonicalize(Path path) throws FileNotFoundException {
        path.getClass();
        Path pathCanonicalizeInternal = canonicalizeInternal(path);
        if (this.entries.containsKey(pathCanonicalizeInternal)) {
            return pathCanonicalizeInternal;
        }
        throw new FileNotFoundException(String.valueOf(path));
    }

    @Override // okio.FileSystem
    public void createDirectory(Path path, boolean z) throws IOException {
        path.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void createSymlink(Path path, Path path2) throws IOException {
        path.getClass();
        path2.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public void delete(Path path, boolean z) throws IOException {
        path.getClass();
        throw new IOException("zip file systems are read-only");
    }

    @Override // okio.FileSystem
    public List<Path> listOrNull(Path path) {
        path.getClass();
        return list(path, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x005e A[Catch: all -> 0x004c, TRY_ENTER, TRY_LEAVE, TryCatch #4 {all -> 0x004c, blocks: (B:8:0x0025, B:34:0x005e, B:22:0x0048, B:19:0x0043, B:9:0x0031), top: B:58:0x0025, inners: #1, #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x006f  */
    @Override // okio.FileSystem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public okio.FileMetadata metadataOrNull(okio.Path r14) throws java.lang.Throwable {
        /*
            r13 = this;
            r14.getClass()
            okio.Path r14 = r13.canonicalizeInternal(r14)
            java.util.Map<okio.Path, okio.internal.ZipEntry> r0 = r13.entries
            java.lang.Object r14 = r0.get(r14)
            okio.internal.ZipEntry r14 = (okio.internal.ZipEntry) r14
            r1 = 0
            if (r14 != 0) goto L13
            return r1
        L13:
            long r2 = r14.getOffset()
            r4 = -1
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 == 0) goto L70
            okio.FileSystem r0 = r13.fileSystem
            okio.Path r13 = r13.zipPath
            okio.FileHandle r13 = r0.openReadOnly(r13)
            long r2 = r14.getOffset()     // Catch: java.lang.Throwable -> L4c
            okio.Source r0 = r13.source(r2)     // Catch: java.lang.Throwable -> L4c
            okio.BufferedSource r2 = okio.Okio.buffer(r0)     // Catch: java.lang.Throwable -> L4c
            okio.internal.ZipEntry r14 = okio.internal.ZipFilesKt.readLocalHeader(r2, r14)     // Catch: java.lang.Throwable -> L3f
            if (r2 == 0) goto L3d
            r2.close()     // Catch: java.lang.Throwable -> L3b
            goto L3d
        L3b:
            r0 = move-exception
            goto L51
        L3d:
            r0 = r1
            goto L51
        L3f:
            r0 = move-exception
            r14 = r0
            if (r2 == 0) goto L4f
            r2.close()     // Catch: java.lang.Throwable -> L47
            goto L4f
        L47:
            r0 = move-exception
            defpackage.mv0.a(r14, r0)     // Catch: java.lang.Throwable -> L4c
            goto L4f
        L4c:
            r0 = move-exception
            r14 = r0
            goto L5f
        L4f:
            r0 = r14
            r14 = r1
        L51:
            if (r0 != 0) goto L5e
            if (r13 == 0) goto L5c
            r13.close()     // Catch: java.lang.Throwable -> L59
            goto L5c
        L59:
            r0 = move-exception
            r13 = r0
            goto L6c
        L5c:
            r13 = r1
            goto L6c
        L5e:
            throw r0     // Catch: java.lang.Throwable -> L4c
        L5f:
            if (r13 == 0) goto L6a
            r13.close()     // Catch: java.lang.Throwable -> L65
            goto L6a
        L65:
            r0 = move-exception
            r13 = r0
            defpackage.mv0.a(r14, r13)
        L6a:
            r13 = r14
            r14 = r1
        L6c:
            if (r13 != 0) goto L6f
            goto L70
        L6f:
            throw r13
        L70:
            okio.FileMetadata r2 = new okio.FileMetadata
            boolean r13 = r14.isDirectory()
            r3 = r13 ^ 1
            boolean r4 = r14.isDirectory()
            boolean r13 = r14.isDirectory()
            if (r13 == 0) goto L84
        L82:
            r6 = r1
            goto L8d
        L84:
            long r0 = r14.getSize()
            java.lang.Long r1 = java.lang.Long.valueOf(r0)
            goto L82
        L8d:
            java.lang.Long r7 = r14.getCreatedAtMillis$okio()
            java.lang.Long r8 = r14.getLastModifiedAtMillis$okio()
            java.lang.Long r9 = r14.getLastAccessedAtMillis$okio()
            r11 = 128(0x80, float:1.8E-43)
            r12 = 0
            r5 = 0
            r10 = 0
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ZipFileSystem.metadataOrNull(okio.Path):okio.FileMetadata");
    }

    @Override // okio.FileSystem
    public FileHandle openReadOnly(Path path) {
        path.getClass();
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override // okio.FileSystem
    public FileHandle openReadWrite(Path path, boolean z, boolean z2) throws IOException {
        path.getClass();
        throw new IOException("zip entries are not writable");
    }

    @Override // okio.FileSystem
    public Sink sink(Path path, boolean z) throws IOException {
        path.getClass();
        throw new IOException("zip file systems are read-only");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r7v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r7v8 */
    @Override // okio.FileSystem
    public Source source(Path path) throws IllegalAccessException, IOException, InvocationTargetException {
        path.getClass();
        ZipEntry zipEntry = this.entries.get(canonicalizeInternal(path));
        BufferedSource th = null;
        if (zipEntry == null) {
            xe5.a("no such file: ", path);
            return null;
        }
        FileHandle fileHandleOpenReadOnly = this.fileSystem.openReadOnly(this.zipPath);
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(fileHandleOpenReadOnly.source(zipEntry.getOffset()));
            if (fileHandleOpenReadOnly != null) {
                try {
                    fileHandleOpenReadOnly.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            BufferedSource bufferedSource = th;
            th = bufferedSourceBuffer;
            th = bufferedSource;
        } catch (Throwable th3) {
            th = th3;
            if (fileHandleOpenReadOnly != null) {
                try {
                    fileHandleOpenReadOnly.close();
                } catch (Throwable th4) {
                    mv0.a(th, th4);
                }
            }
        }
        if (th != 0) {
            throw th;
        }
        ZipFilesKt.skipLocalHeader(th);
        return zipEntry.getCompressionMethod() == 0 ? new FixedLengthSource(th, zipEntry.getSize(), true) : new FixedLengthSource(new InflaterSource(new FixedLengthSource(th, zipEntry.getCompressedSize(), true), new Inflater(true)), zipEntry.getSize(), false);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        public final Path getROOT() {
            return ZipFileSystem.ROOT;
        }

        private Companion() {
        }
    }

    @Override // okio.FileSystem
    public List<Path> list(Path path) throws IOException {
        path.getClass();
        List<Path> list = list(path, true);
        list.getClass();
        return list;
    }
}
