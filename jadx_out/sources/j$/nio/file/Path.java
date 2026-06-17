package j$.nio.file;

import java.io.File;
import java.net.URI;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public interface Path extends Comparable<Path>, Iterable<Path> {
    boolean A(Path path);

    default Path C(Path path) {
        path.getClass();
        Path parent = getParent();
        return parent == null ? path : parent.t(path);
    }

    Path J(Path path);

    default d0 W(e0 e0Var, b0... b0VarArr) {
        return r(e0Var, b0VarArr, new c0[0]);
    }

    default boolean endsWith(String str) {
        return A(getFileSystem().getPath(str, new String[0]));
    }

    boolean equals(Object obj);

    Path getFileName();

    FileSystem getFileSystem();

    Path getName(int i);

    int getNameCount();

    Path getParent();

    Path getRoot();

    boolean isAbsolute();

    default Iterator iterator() {
        return new n(this);
    }

    Path normalize();

    d0 r(e0 e0Var, b0[] b0VarArr, c0... c0VarArr);

    default Path resolve(String str) {
        return t(getFileSystem().getPath(str, new String[0]));
    }

    default Path resolveSibling(String str) {
        return C(getFileSystem().getPath(str, new String[0]));
    }

    default boolean startsWith(String str) {
        return y(getFileSystem().getPath(str, new String[0]));
    }

    Path subpath(int i, int i2);

    Path t(Path path);

    Path toAbsolutePath();

    default File toFile() {
        if (getFileSystem() == i.a) {
            return new File(toString());
        }
        throw new UnsupportedOperationException("Path not associated with default file system.");
    }

    Path toRealPath(LinkOption... linkOptionArr);

    String toString();

    URI toUri();

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    int compareTo(Path path);

    boolean y(Path path);
}
