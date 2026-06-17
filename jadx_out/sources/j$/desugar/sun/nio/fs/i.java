package j$.desugar.sun.nio.fs;

import j$.nio.file.FileSystem;
import j$.nio.file.Path;
import j$.nio.file.attribute.a0;
import j$.nio.file.e0;
import java.util.Set;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final class i extends FileSystem {
    public final String a;
    public final String b;
    public final m c;

    public i(m mVar, String str, String str2) {
        this.c = mVar;
        this.a = str;
        this.b = str2;
    }

    @Override // j$.nio.file.FileSystem
    public final Iterable a() {
        throw new UnsupportedOperationException("");
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x0120, code lost:
    
        r3 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x013b, code lost:
    
        if (r7 != ']') goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x013d, code lost:
    
        r1.append("]]");
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x014d, code lost:
    
        throw new java.util.regex.PatternSyntaxException("Missing ']", r0, r3 - 1);
     */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0128 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:141:0x00fe A[SYNTHETIC] */
    @Override // j$.nio.file.FileSystem
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final j$.nio.file.w b(java.lang.String r17) {
        /*
            Method dump skipped, instruction units count: 495
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.desugar.sun.nio.fs.i.b(java.lang.String):j$.nio.file.w");
    }

    @Override // j$.nio.file.FileSystem
    public final Iterable c() {
        return g.o(new Object[]{new o(this, ServiceReference.DELIMITER, this.a, this.b)});
    }

    @Override // j$.nio.file.FileSystem, java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        throw new UnsupportedOperationException();
    }

    @Override // j$.nio.file.FileSystem
    public final String d() {
        return ServiceReference.DELIMITER;
    }

    @Override // j$.nio.file.FileSystem
    public final a0 e() {
        throw new UnsupportedOperationException();
    }

    @Override // j$.nio.file.FileSystem
    public final boolean f() {
        return false;
    }

    @Override // j$.nio.file.FileSystem
    public final e0 g() {
        throw new UnsupportedOperationException();
    }

    @Override // j$.nio.file.FileSystem
    public final Path getPath(String str, String[] strArr) {
        if (strArr.length != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            for (String str2 : strArr) {
                if (!str2.isEmpty()) {
                    if (sb.length() > 0) {
                        sb.append('/');
                    }
                    sb.append(str2);
                }
            }
            str = sb.toString();
        }
        return new o(this, str, this.a, this.b);
    }

    @Override // j$.nio.file.FileSystem
    public final j$.nio.file.spi.c h() {
        return this.c;
    }

    @Override // j$.nio.file.FileSystem
    public final Set i() {
        return g.p(new Object[]{"basic"});
    }

    @Override // j$.nio.file.FileSystem
    public final boolean isOpen() {
        return true;
    }
}
