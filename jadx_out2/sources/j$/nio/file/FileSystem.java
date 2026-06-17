package j$.nio.file;

import java.io.Closeable;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class FileSystem implements Closeable {
    public abstract Iterable a();

    public abstract w b(String str);

    public abstract Iterable c();

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public abstract void close();

    public abstract String d();

    public abstract j$.nio.file.attribute.a0 e();

    public abstract boolean f();

    public abstract e0 g();

    public abstract Path getPath(String str, String... strArr);

    public abstract j$.nio.file.spi.c h();

    public abstract Set i();

    public abstract boolean isOpen();
}
