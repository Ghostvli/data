package okhttp3.internal.publicsuffix;

import defpackage.we0;
import okio.FileSystem;
import okio.Path;
import okio.Source;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class ResourcePublicSuffixList extends BasePublicSuffixList {
    public static final Companion Companion = new Companion(null);
    public static final Path PUBLIC_SUFFIX_RESOURCE = Path.Companion.get$default(Path.Companion, "okhttp3/internal/publicsuffix/" + PublicSuffixDatabase.class.getSimpleName() + ".list", false, 1, (Object) null);
    private final FileSystem fileSystem;
    private final Path path;

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x000c: CONSTRUCTOR 
      (wrap:okio.Path:?: TERNARY null = ((wrap:int:0x0000: ARITH (r3v0 int) & (1 int) A[WRAPPED] (LINE:1)) != (0 int)) ? (wrap:okio.Path:0x0004: SGET  A[WRAPPED] (LINE:5) okhttp3.internal.publicsuffix.ResourcePublicSuffixList.PUBLIC_SUFFIX_RESOURCE okio.Path) : (r1v0 okio.Path))
      (wrap:okio.FileSystem:?: TERNARY null = ((wrap:int:0x0006: ARITH (r3v0 int) & (2 int) A[WRAPPED] (LINE:7)) != (0 int)) ? (wrap:okio.FileSystem:0x000a: SGET  A[WRAPPED] (LINE:11) okio.FileSystem.RESOURCES okio.FileSystem) : (r2v0 okio.FileSystem))
     A[MD:(okio.Path, okio.FileSystem):void (m)] (LINE:13) call: okhttp3.internal.publicsuffix.ResourcePublicSuffixList.<init>(okio.Path, okio.FileSystem):void type: THIS */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public /* synthetic */ ResourcePublicSuffixList(Path path, FileSystem fileSystem, int i, we0 we0Var) {
        this((i & 1) != 0 ? PUBLIC_SUFFIX_RESOURCE : path, (i & 2) != 0 ? FileSystem.RESOURCES : fileSystem);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final FileSystem getFileSystem() {
        return this.fileSystem;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // okhttp3.internal.publicsuffix.BasePublicSuffixList
    public Source listSource() {
        return this.fileSystem.source(getPath());
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class Companion {
        /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x0000: CONSTRUCTOR  A[MD:():void (m)] (LINE:1) call: okhttp3.internal.publicsuffix.ResourcePublicSuffixList.Companion.<init>():void type: THIS */
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public /* synthetic */ Companion(we0 we0Var) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX DEBUG: Method merged with bridge method: getPath()Ljava/lang/Object; */
    @Override // okhttp3.internal.publicsuffix.BasePublicSuffixList
    public Path getPath() {
        return this.path;
    }

    public ResourcePublicSuffixList(Path path, FileSystem fileSystem) {
        path.getClass();
        fileSystem.getClass();
        this.path = path;
        this.fileSystem = fileSystem;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r0v1, resolved type: java.lang.Object[] */
    /* JADX DEBUG: Multi-variable search result rejected for r0v2, resolved type: java.lang.Object[] */
    /* JADX WARN: Multi-variable type inference failed */
    public ResourcePublicSuffixList() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }
}
