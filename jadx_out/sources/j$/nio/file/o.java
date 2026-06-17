package j$.nio.file;

import java.io.File;
import java.net.URI;
import java.nio.file.WatchEvent;
import java.nio.file.WatchService;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class o implements Path {
    public final /* synthetic */ java.nio.file.Path a;

    public /* synthetic */ o(java.nio.file.Path path) {
        this.a = path;
    }

    public static /* synthetic */ Path u(java.nio.file.Path path) {
        if (path == null) {
            return null;
        }
        return path instanceof p ? ((p) path).a : new o(path);
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ boolean A(Path path) {
        return this.a.endsWith(p.u(path));
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ Path C(Path path) {
        return u(this.a.resolveSibling(p.u(path)));
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ Path J(Path path) {
        return u(this.a.relativize(p.u(path)));
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ d0 W(e0 e0Var, b0[] b0VarArr) {
        return d0.a(this.a.register(e0Var == null ? null : e0Var.a, j$.desugar.sun.nio.fs.g.v(b0VarArr)));
    }

    @Override // j$.nio.file.Path, java.lang.Comparable
    public final /* synthetic */ int compareTo(Path path) {
        return this.a.compareTo(j$.desugar.sun.nio.fs.g.f(path));
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ boolean endsWith(String str) {
        return this.a.endsWith(str);
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ boolean equals(Object obj) {
        java.nio.file.Path path = this.a;
        if (obj instanceof o) {
            obj = ((o) obj).a;
        }
        return path.equals(obj);
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ void forEach(Consumer<? super Path> consumer) {
        this.a.forEach(consumer);
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ Path getFileName() {
        return u(this.a.getFileName());
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ FileSystem getFileSystem() {
        return f.j(this.a.getFileSystem());
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ Path getName(int i) {
        return u(this.a.getName(i));
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ int getNameCount() {
        return this.a.getNameCount();
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ Path getParent() {
        return u(this.a.getParent());
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ Path getRoot() {
        return u(this.a.getRoot());
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ boolean isAbsolute() {
        return this.a.isAbsolute();
    }

    @Override // j$.nio.file.Path, java.lang.Iterable
    public final Iterator iterator() {
        return new t(this.a.iterator());
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ Path normalize() {
        return u(this.a.normalize());
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ d0 r(e0 e0Var, b0[] b0VarArr, c0[] c0VarArr) {
        java.nio.file.Path path = this.a;
        WatchEvent.Modifier[] modifierArr = null;
        WatchService watchService = e0Var == null ? null : e0Var.a;
        WatchEvent.Kind<?>[] kindArrV = j$.desugar.sun.nio.fs.g.v(b0VarArr);
        if (c0VarArr != null) {
            int length = c0VarArr.length;
            WatchEvent.Modifier[] modifierArr2 = new WatchEvent.Modifier[length];
            for (int i = 0; i < length; i++) {
                c0 c0Var = c0VarArr[i];
                modifierArr2[i] = c0Var == null ? null : c0Var.a;
            }
            modifierArr = modifierArr2;
        }
        return d0.a(path.register(watchService, kindArrV, modifierArr));
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ Path resolve(String str) {
        return u(this.a.resolve(str));
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ Path resolveSibling(String str) {
        return u(this.a.resolveSibling(str));
    }

    @Override // java.lang.Iterable
    public final /* synthetic */ Spliterator<Path> spliterator() {
        return this.a.spliterator();
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ boolean startsWith(String str) {
        return this.a.startsWith(str);
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ Path subpath(int i, int i2) {
        return u(this.a.subpath(i, i2));
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ Path t(Path path) {
        return u(this.a.resolve(p.u(path)));
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ Path toAbsolutePath() {
        return u(this.a.toAbsolutePath());
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ File toFile() {
        return this.a.toFile();
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ Path toRealPath(LinkOption[] linkOptionArr) {
        return u(this.a.toRealPath(j$.desugar.sun.nio.fs.g.u(linkOptionArr)));
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ String toString() {
        return this.a.toString();
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ URI toUri() {
        return this.a.toUri();
    }

    @Override // j$.nio.file.Path
    /* JADX INFO: renamed from: w */
    public final /* synthetic */ int compareTo(Path path) {
        return this.a.compareTo(p.u(path));
    }

    @Override // j$.nio.file.Path
    public final /* synthetic */ boolean y(Path path) {
        return this.a.startsWith(p.u(path));
    }
}
