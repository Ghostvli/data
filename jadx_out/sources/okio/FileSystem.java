package okio;

import defpackage.dk1;
import defpackage.f14;
import defpackage.fn;
import defpackage.mv0;
import defpackage.we0;
import java.io.Closeable;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import kotlin.jvm.functions.Function1;
import okio.Path;
import okio.internal.ResourceFileSystem;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class FileSystem implements Closeable {
    public static final Companion Companion = new Companion(null);
    public static final FileSystem RESOURCES;
    public static final FileSystem SYSTEM;
    public static final Path SYSTEM_TEMPORARY_DIRECTORY;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX INFO: renamed from: -write$default, reason: not valid java name */
    public static /* synthetic */ Object m173write$default(FileSystem fileSystem, Path path, boolean z, Function1 function1, int i, Object obj) throws IllegalAccessException, InvocationTargetException {
        ?? r4;
        Object th = null;
        if (obj != null) {
            fn.a("Super calls with default arguments not supported in this target, function: write");
            return null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        path.getClass();
        function1.getClass();
        BufferedSink bufferedSinkBuffer = Okio.buffer(fileSystem.sink(path, z));
        try {
            Object objInvoke = function1.invoke(bufferedSinkBuffer);
            dk1.b(1);
            if (bufferedSinkBuffer != null) {
                try {
                    bufferedSinkBuffer.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            dk1.a(1);
            Object obj2 = th;
            th = objInvoke;
            r4 = obj2;
        } catch (Throwable th3) {
            dk1.b(1);
            if (bufferedSinkBuffer != null) {
                try {
                    bufferedSinkBuffer.close();
                } catch (Throwable th4) {
                    mv0.a(th3, th4);
                }
            }
            dk1.a(1);
            r4 = th3;
        }
        if (r4 == 0) {
            return th;
        }
        throw r4;
    }

    static {
        FileSystem jvmSystemFileSystem;
        try {
            Class.forName("j$.nio.file.Files");
            jvmSystemFileSystem = new NioSystemFileSystem();
        } catch (ClassNotFoundException unused) {
            jvmSystemFileSystem = new JvmSystemFileSystem();
        }
        SYSTEM = jvmSystemFileSystem;
        Path.Companion companion = Path.Companion;
        String property = System.getProperty("java.io.tmpdir");
        property.getClass();
        SYSTEM_TEMPORARY_DIRECTORY = Path.Companion.get$default(companion, property, false, 1, (Object) null);
        ClassLoader classLoader = ResourceFileSystem.class.getClassLoader();
        classLoader.getClass();
        RESOURCES = new ResourceFileSystem(classLoader, false, null, 4, null);
    }

    public static /* synthetic */ Sink appendingSink$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if (obj != null) {
            fn.a("Super calls with default arguments not supported in this target, function: appendingSink");
            return null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return fileSystem.appendingSink(path, z);
    }

    public static /* synthetic */ void createDirectories$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if (obj != null) {
            fn.a("Super calls with default arguments not supported in this target, function: createDirectories");
            return;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        fileSystem.createDirectories(path, z);
    }

    public static /* synthetic */ void createDirectory$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if (obj != null) {
            fn.a("Super calls with default arguments not supported in this target, function: createDirectory");
            return;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        fileSystem.createDirectory(path, z);
    }

    public static /* synthetic */ void delete$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if (obj != null) {
            fn.a("Super calls with default arguments not supported in this target, function: delete");
            return;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        fileSystem.delete(path, z);
    }

    public static /* synthetic */ void deleteRecursively$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if (obj != null) {
            fn.a("Super calls with default arguments not supported in this target, function: deleteRecursively");
            return;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        fileSystem.deleteRecursively(path, z);
    }

    public static final FileSystem get(j$.nio.file.FileSystem fileSystem) {
        return Companion.get(fileSystem);
    }

    public static /* synthetic */ f14 listRecursively$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if (obj != null) {
            fn.a("Super calls with default arguments not supported in this target, function: listRecursively");
            return null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return fileSystem.listRecursively(path, z);
    }

    public static /* synthetic */ FileHandle openReadWrite$default(FileSystem fileSystem, Path path, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            fn.a("Super calls with default arguments not supported in this target, function: openReadWrite");
            return null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return fileSystem.openReadWrite(path, z, z2);
    }

    public static /* synthetic */ Sink sink$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if (obj != null) {
            fn.a("Super calls with default arguments not supported in this target, function: sink");
            return null;
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return fileSystem.sink(path, z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX INFO: renamed from: -read, reason: not valid java name */
    public final <T> T m174read(Path path, Function1<? super BufferedSource, ? extends T> function1) throws IllegalAccessException, InvocationTargetException {
        ?? r4;
        path.getClass();
        function1.getClass();
        BufferedSource bufferedSourceBuffer = Okio.buffer(source(path));
        T th = null;
        try {
            T tInvoke = function1.invoke(bufferedSourceBuffer);
            dk1.b(1);
            if (bufferedSourceBuffer != null) {
                try {
                    bufferedSourceBuffer.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            dk1.a(1);
            T t = th;
            th = tInvoke;
            r4 = t;
        } catch (Throwable th3) {
            dk1.b(1);
            if (bufferedSourceBuffer != null) {
                try {
                    bufferedSourceBuffer.close();
                } catch (Throwable th4) {
                    mv0.a(th3, th4);
                }
            }
            dk1.a(1);
            r4 = th3;
        }
        if (r4 == 0) {
            return th;
        }
        throw r4;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX INFO: renamed from: -write, reason: not valid java name */
    public final <T> T m175write(Path path, boolean z, Function1<? super BufferedSink, ? extends T> function1) throws IllegalAccessException, InvocationTargetException {
        ?? r4;
        path.getClass();
        function1.getClass();
        BufferedSink bufferedSinkBuffer = Okio.buffer(sink(path, z));
        T th = null;
        try {
            T tInvoke = function1.invoke(bufferedSinkBuffer);
            dk1.b(1);
            if (bufferedSinkBuffer != null) {
                try {
                    bufferedSinkBuffer.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            dk1.a(1);
            r4 = th;
            th = tInvoke;
        } catch (Throwable th3) {
            dk1.b(1);
            if (bufferedSinkBuffer != null) {
                try {
                    bufferedSinkBuffer.close();
                } catch (Throwable th4) {
                    mv0.a(th3, th4);
                }
            }
            dk1.a(1);
            r4 = th3;
        }
        if (r4 == 0) {
            return th;
        }
        throw r4;
    }

    public final Sink appendingSink(Path path) {
        path.getClass();
        return appendingSink(path, false);
    }

    public abstract Sink appendingSink(Path path, boolean z);

    public abstract void atomicMove(Path path, Path path2);

    public abstract Path canonicalize(Path path);

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
    }

    public void copy(Path path, Path path2) {
        path.getClass();
        path2.getClass();
        okio.internal.FileSystem.commonCopy(this, path, path2);
    }

    public final void createDirectories(Path path) {
        path.getClass();
        createDirectories(path, false);
    }

    public final void createDirectory(Path path) {
        path.getClass();
        createDirectory(path, false);
    }

    public abstract void createDirectory(Path path, boolean z);

    public abstract void createSymlink(Path path, Path path2);

    public final void delete(Path path) {
        path.getClass();
        delete(path, false);
    }

    public abstract void delete(Path path, boolean z);

    public final void deleteRecursively(Path path) {
        path.getClass();
        deleteRecursively(path, false);
    }

    public final boolean exists(Path path) {
        path.getClass();
        return okio.internal.FileSystem.commonExists(this, path);
    }

    public abstract List<Path> list(Path path);

    public abstract List<Path> listOrNull(Path path);

    public final f14 listRecursively(Path path) {
        path.getClass();
        return listRecursively(path, false);
    }

    public final FileMetadata metadata(Path path) {
        path.getClass();
        return okio.internal.FileSystem.commonMetadata(this, path);
    }

    public abstract FileMetadata metadataOrNull(Path path);

    public abstract FileHandle openReadOnly(Path path);

    public final FileHandle openReadWrite(Path path) {
        path.getClass();
        return openReadWrite(path, false, false);
    }

    public abstract FileHandle openReadWrite(Path path, boolean z, boolean z2);

    public final Sink sink(Path path) {
        path.getClass();
        return sink(path, false);
    }

    public abstract Sink sink(Path path, boolean z);

    public abstract Source source(Path path);

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        public final FileSystem get(j$.nio.file.FileSystem fileSystem) {
            fileSystem.getClass();
            return new NioFileSystemWrappingFileSystem(fileSystem);
        }

        private Companion() {
        }
    }

    public final void createDirectories(Path path, boolean z) {
        path.getClass();
        okio.internal.FileSystem.commonCreateDirectories(this, path, z);
    }

    public void deleteRecursively(Path path, boolean z) {
        path.getClass();
        okio.internal.FileSystem.commonDeleteRecursively(this, path, z);
    }

    public f14 listRecursively(Path path, boolean z) {
        path.getClass();
        return okio.internal.FileSystem.commonListRecursively(this, path, z);
    }
}
