package okio.internal;

import defpackage.cs1;
import defpackage.fu4;
import defpackage.i73;
import defpackage.il1;
import defpackage.is1;
import defpackage.pw;
import defpackage.sg4;
import defpackage.tw;
import defpackage.we0;
import defpackage.wg4;
import defpackage.ww;
import defpackage.xe5;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import okio.FileHandle;
import okio.FileMetadata;
import okio.FileSystem;
import okio.Okio;
import okio.Path;
import okio.Sink;
import okio.Source;
import okio.internal.ResourceFileSystem;
import okio.internal.ZipEntry;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ResourceFileSystem extends FileSystem {
    private static final Companion Companion = new Companion(null);
    private static final Path ROOT = Path.Companion.get$default(Path.Companion, ServiceReference.DELIMITER, false, 1, (Object) null);
    private final ClassLoader classLoader;
    private final cs1 roots$delegate;
    private final FileSystem systemFileSystem;

    public ResourceFileSystem(ClassLoader classLoader, boolean z, FileSystem fileSystem) {
        classLoader.getClass();
        fileSystem.getClass();
        this.classLoader = classLoader;
        this.systemFileSystem = fileSystem;
        this.roots$delegate = is1.b(new Function0() { // from class: js3
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ResourceFileSystem.c(this.f);
            }
        });
        if (z) {
            getRoots().size();
        }
    }

    public static boolean a(ZipEntry zipEntry) {
        zipEntry.getClass();
        return Companion.keepPath(zipEntry.getCanonicalPath());
    }

    public static List c(ResourceFileSystem resourceFileSystem) {
        return resourceFileSystem.toClasspathRoots(resourceFileSystem.classLoader);
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    private final List<i73> getRoots() {
        return (List) this.roots$delegate.getValue();
    }

    private final List<i73> toClasspathRoots(ClassLoader classLoader) throws IOException {
        Enumeration<URL> resources = classLoader.getResources("");
        resources.getClass();
        ArrayList<URL> list = Collections.list(resources);
        list.getClass();
        ArrayList arrayList = new ArrayList();
        for (URL url : list) {
            url.getClass();
            i73 fileRoot = toFileRoot(url);
            if (fileRoot != null) {
                arrayList.add(fileRoot);
            }
        }
        Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
        resources2.getClass();
        ArrayList<URL> list2 = Collections.list(resources2);
        list2.getClass();
        ArrayList arrayList2 = new ArrayList();
        for (URL url2 : list2) {
            url2.getClass();
            i73 jarRoot = toJarRoot(url2);
            if (jarRoot != null) {
                arrayList2.add(jarRoot);
            }
        }
        return ww.T(arrayList, arrayList2);
    }

    private final i73 toFileRoot(URL url) {
        if (il1.a(url.getProtocol(), "file")) {
            return fu4.a(this.systemFileSystem, Path.Companion.get$default(Path.Companion, new File(url.toURI()), false, 1, (Object) null));
        }
        return null;
    }

    private final i73 toJarRoot(URL url) {
        int iG0;
        String string = url.toString();
        string.getClass();
        if (sg4.K(string, "jar:file:", false, 2, null) && (iG0 = wg4.g0(string, "!", 0, false, 6, null)) != -1) {
            return fu4.a(ZipFilesKt.openZip(Path.Companion.get$default(Path.Companion, new File(URI.create(string.substring(4, iG0))), false, 1, (Object) null), this.systemFileSystem, new Function1() { // from class: is3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(ResourceFileSystem.a((ZipEntry) obj));
                }
            }), ROOT);
        }
        return null;
    }

    private final String toRelativePath(Path path) {
        return canonicalizeInternal(path).relativeTo(ROOT).toString();
    }

    @Override // okio.FileSystem
    public Sink appendingSink(Path path, boolean z) throws IOException {
        path.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void atomicMove(Path path, Path path2) throws IOException {
        path.getClass();
        path2.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public Path canonicalize(Path path) {
        path.getClass();
        return canonicalizeInternal(path);
    }

    @Override // okio.FileSystem
    public void createDirectory(Path path, boolean z) throws IOException {
        path.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void createSymlink(Path path, Path path2) throws IOException {
        path.getClass();
        path2.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public void delete(Path path, boolean z) throws IOException {
        path.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public List<Path> list(Path path) throws FileNotFoundException {
        path.getClass();
        String relativePath = toRelativePath(path);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        boolean z = false;
        for (i73 i73Var : getRoots()) {
            FileSystem fileSystem = (FileSystem) i73Var.a();
            Path path2 = (Path) i73Var.b();
            try {
                List<Path> list = fileSystem.list(path2.resolve(relativePath));
                ArrayList arrayList = new ArrayList();
                for (Object obj : list) {
                    if (Companion.keepPath((Path) obj)) {
                        arrayList.add(obj);
                    }
                }
                ArrayList arrayList2 = new ArrayList(pw.t(arrayList, 10));
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    arrayList2.add(Companion.removeBase((Path) it.next(), path2));
                }
                tw.w(linkedHashSet, arrayList2);
                z = true;
            } catch (IOException unused) {
            }
        }
        if (z) {
            return ww.a0(linkedHashSet);
        }
        xe5.a("file not found: ", path);
        return null;
    }

    @Override // okio.FileSystem
    public List<Path> listOrNull(Path path) {
        path.getClass();
        String relativePath = toRelativePath(path);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        Iterator<i73> it = getRoots().iterator();
        boolean z = false;
        while (true) {
            ArrayList arrayList = null;
            if (!it.hasNext()) {
                break;
            }
            i73 next = it.next();
            FileSystem fileSystem = (FileSystem) next.a();
            Path path2 = (Path) next.b();
            List<Path> listListOrNull = fileSystem.listOrNull(path2.resolve(relativePath));
            if (listListOrNull != null) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : listListOrNull) {
                    if (Companion.keepPath((Path) obj)) {
                        arrayList2.add(obj);
                    }
                }
                ArrayList arrayList3 = new ArrayList(pw.t(arrayList2, 10));
                Iterator it2 = arrayList2.iterator();
                while (it2.hasNext()) {
                    arrayList3.add(Companion.removeBase((Path) it2.next(), path2));
                }
                arrayList = arrayList3;
            }
            if (arrayList != null) {
                tw.w(linkedHashSet, arrayList);
                z = true;
            }
        }
        if (z) {
            return ww.a0(linkedHashSet);
        }
        return null;
    }

    @Override // okio.FileSystem
    public FileMetadata metadataOrNull(Path path) {
        path.getClass();
        if (!Companion.keepPath(path)) {
            return null;
        }
        String relativePath = toRelativePath(path);
        for (i73 i73Var : getRoots()) {
            FileMetadata fileMetadataMetadataOrNull = ((FileSystem) i73Var.a()).metadataOrNull(((Path) i73Var.b()).resolve(relativePath));
            if (fileMetadataMetadataOrNull != null) {
                return fileMetadataMetadataOrNull;
            }
        }
        return null;
    }

    @Override // okio.FileSystem
    public FileHandle openReadOnly(Path path) throws FileNotFoundException {
        path.getClass();
        if (!Companion.keepPath(path)) {
            xe5.a("file not found: ", path);
            return null;
        }
        String relativePath = toRelativePath(path);
        Iterator<i73> it = getRoots().iterator();
        while (it.hasNext()) {
            i73 next = it.next();
            try {
                return ((FileSystem) next.a()).openReadOnly(((Path) next.b()).resolve(relativePath));
            } catch (FileNotFoundException unused) {
            }
        }
        xe5.a("file not found: ", path);
        return null;
    }

    @Override // okio.FileSystem
    public FileHandle openReadWrite(Path path, boolean z, boolean z2) throws IOException {
        path.getClass();
        throw new IOException("resources are not writable");
    }

    @Override // okio.FileSystem
    public Sink sink(Path path, boolean z) throws IOException {
        path.getClass();
        throw new IOException(this + " is read-only");
    }

    @Override // okio.FileSystem
    public Source source(Path path) throws IOException {
        path.getClass();
        if (!Companion.keepPath(path)) {
            xe5.a("file not found: ", path);
            return null;
        }
        Path path2 = ROOT;
        URL resource = this.classLoader.getResource(Path.resolve$default(path2, path, false, 2, (Object) null).relativeTo(path2).toString());
        if (resource == null) {
            xe5.a("file not found: ", path);
            return null;
        }
        URLConnection uRLConnectionOpenConnection = resource.openConnection();
        if (uRLConnectionOpenConnection instanceof JarURLConnection) {
            ((JarURLConnection) uRLConnectionOpenConnection).setUseCaches(false);
        }
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        inputStream.getClass();
        return Okio.source(inputStream);
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final boolean keepPath(Path path) {
            return !sg4.w(path.name(), ".class", true);
        }

        public final Path getROOT() {
            return ResourceFileSystem.ROOT;
        }

        public final Path removeBase(Path path, Path path2) {
            path.getClass();
            path2.getClass();
            return getROOT().resolve(sg4.F(wg4.q0(path.toString(), path2.toString()), '\\', '/', false, 4, null));
        }

        private Companion() {
        }
    }

    public /* synthetic */ ResourceFileSystem(ClassLoader classLoader, boolean z, FileSystem fileSystem, int i, we0 we0Var) {
        this(classLoader, z, (i & 4) != 0 ? FileSystem.SYSTEM : fileSystem);
    }
}
