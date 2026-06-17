package j$.desugar.sun.nio.fs;

import j$.nio.file.Path;
import j$.nio.file.attribute.FileAttribute;
import j$.nio.file.w;
import java.nio.file.DirectoryStream;
import java.util.Collections;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class h implements w, DirectoryStream.Filter, FileAttribute {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ h(Object obj, int i) {
        this.a = i;
        this.b = obj;
    }

    @Override // j$.nio.file.w
    public boolean a(Path path) {
        return ((Pattern) this.b).matcher(path.toString()).matches();
    }

    @Override // java.nio.file.DirectoryStream.Filter
    public boolean accept(Object obj) {
        switch (this.a) {
            case 1:
                return ((w) this.b).a(((Path) obj).getFileName());
            default:
                return ((DirectoryStream.Filter) this.b).accept(g.f(obj));
        }
    }

    @Override // j$.nio.file.attribute.FileAttribute
    public String name() {
        return "posix:permissions";
    }

    @Override // j$.nio.file.attribute.FileAttribute
    public Object value() {
        return Collections.unmodifiableSet(g.l((Set) ((java.nio.file.attribute.FileAttribute) this.b).value()));
    }
}
