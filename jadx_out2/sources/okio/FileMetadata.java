package okio;

import defpackage.hp1;
import defpackage.jp1;
import defpackage.we0;
import defpackage.ww;
import defpackage.y42;
import java.util.ArrayList;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class FileMetadata {
    private final Long createdAtMillis;
    private final Map<hp1, Object> extras;
    private final boolean isDirectory;
    private final boolean isRegularFile;
    private final Long lastAccessedAtMillis;
    private final Long lastModifiedAtMillis;
    private final Long size;
    private final Path symlinkTarget;

    /* JADX DEBUG: Can't inline method, not implemented redirect type for insn: 0x002d: CONSTRUCTOR 
      (wrap:boolean:?: TERNARY null = ((wrap:int:0x0000: ARITH (r10v0 int) & (1 int) A[WRAPPED] (LINE:1)) != (0 int)) ? false : (r2v0 boolean))
      (wrap:boolean:?: TERNARY null = ((wrap:int:0x0006: ARITH (r10v0 int) & (2 int) A[WRAPPED] (LINE:7)) != (0 int)) ? false : (r3v0 boolean))
      (wrap:okio.Path:?: TERNARY null = ((wrap:int:0x000b: ARITH (r10v0 int) & (4 int) A[WRAPPED] (LINE:12)) != (0 int)) ? (null okio.Path) : (r4v0 okio.Path))
      (wrap:java.lang.Long:?: TERNARY null = ((wrap:int:0x0011: ARITH (r10v0 int) & (8 int) A[WRAPPED] (LINE:18)) != (0 int)) ? (null java.lang.Long) : (r5v0 java.lang.Long))
      (wrap:java.lang.Long:?: TERNARY null = ((wrap:int:0x0016: ARITH (r10v0 int) & (16 int) A[WRAPPED] (LINE:23)) != (0 int)) ? (null java.lang.Long) : (r6v0 java.lang.Long))
      (wrap:java.lang.Long:?: TERNARY null = ((wrap:int:0x001b: ARITH (r10v0 int) & (32 int) A[WRAPPED] (LINE:28)) != (0 int)) ? (null java.lang.Long) : (r7v0 java.lang.Long))
      (wrap:java.lang.Long:?: TERNARY null = ((wrap:int:0x0020: ARITH (r10v0 int) & (64 int) A[WRAPPED] (LINE:33)) != (0 int)) ? (null java.lang.Long) : (r8v0 java.lang.Long))
      (wrap:java.util.Map:?: TERNARY null = ((wrap:int:0x0025: ARITH (r10v0 int) & (128 int) A[WRAPPED] (LINE:38)) != (0 int)) ? (wrap:java.util.Map:0x0029: INVOKE  STATIC call: y42.h():java.util.Map A[MD:():java.util.Map (m), WRAPPED] (LINE:42)) : (r9v0 java.util.Map))
     A[MD:(boolean, boolean, okio.Path, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.util.Map<hp1, ? extends java.lang.Object>):void (m)] (LINE:46) call: okio.FileMetadata.<init>(boolean, boolean, okio.Path, java.lang.Long, java.lang.Long, java.lang.Long, java.lang.Long, java.util.Map):void type: THIS */
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public /* synthetic */ FileMetadata(boolean z, boolean z2, Path path, Long l, Long l2, Long l3, Long l4, Map map, int i, we0 we0Var) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? false : z2, (i & 4) != 0 ? null : path, (i & 8) != 0 ? null : l, (i & 16) != 0 ? null : l2, (i & 32) != 0 ? null : l3, (i & 64) != 0 ? null : l4, (i & 128) != 0 ? y42.h() : map);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Multi-variable search result rejected for r0v0, resolved type: okio.FileMetadata */
    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FileMetadata copy$default(FileMetadata fileMetadata, boolean z, boolean z2, Path path, Long l, Long l2, Long l3, Long l4, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            z = fileMetadata.isRegularFile;
        }
        if ((i & 2) != 0) {
            z2 = fileMetadata.isDirectory;
        }
        if ((i & 4) != 0) {
            path = fileMetadata.symlinkTarget;
        }
        if ((i & 8) != 0) {
            l = fileMetadata.size;
        }
        if ((i & 16) != 0) {
            l2 = fileMetadata.createdAtMillis;
        }
        if ((i & 32) != 0) {
            l3 = fileMetadata.lastModifiedAtMillis;
        }
        if ((i & 64) != 0) {
            l4 = fileMetadata.lastAccessedAtMillis;
        }
        if ((i & 128) != 0) {
            map = fileMetadata.extras;
        }
        Long l5 = l4;
        Map map2 = map;
        Long l6 = l2;
        Long l7 = l3;
        return fileMetadata.copy(z, z2, path, l, l6, l7, l5, map2);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final FileMetadata copy(boolean z, boolean z2, Path path, Long l, Long l2, Long l3, Long l4, Map<hp1, ? extends Object> map) {
        map.getClass();
        return new FileMetadata(z, z2, path, l, l2, l3, l4, map);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final <T> T extra(hp1 hp1Var) {
        hp1Var.getClass();
        Object obj = this.extras.get(hp1Var);
        if (obj == null) {
            return null;
        }
        return (T) jp1.a(hp1Var, obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Long getCreatedAtMillis() {
        return this.createdAtMillis;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Map<hp1, Object> getExtras() {
        return this.extras;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Long getLastAccessedAtMillis() {
        return this.lastAccessedAtMillis;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Long getLastModifiedAtMillis() {
        return this.lastModifiedAtMillis;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Long getSize() {
        return this.size;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final Path getSymlinkTarget() {
        return this.symlinkTarget;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean isDirectory() {
        return this.isDirectory;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final boolean isRegularFile() {
        return this.isRegularFile;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public String toString() {
        ArrayList arrayList = new ArrayList();
        if (this.isRegularFile) {
            arrayList.add("isRegularFile");
        }
        if (this.isDirectory) {
            arrayList.add("isDirectory");
        }
        if (this.size != null) {
            arrayList.add("byteCount=" + this.size.longValue());
        }
        if (this.createdAtMillis != null) {
            arrayList.add("createdAt=" + this.createdAtMillis.longValue());
        }
        if (this.lastModifiedAtMillis != null) {
            arrayList.add("lastModifiedAt=" + this.lastModifiedAtMillis.longValue());
        }
        if (this.lastAccessedAtMillis != null) {
            arrayList.add("lastAccessedAt=" + this.lastAccessedAtMillis.longValue());
        }
        if (!this.extras.isEmpty()) {
            arrayList.add("extras=" + this.extras);
        }
        return ww.P(arrayList, ", ", "FileMetadata(", ")", 0, null, null, 56, null);
    }

    public FileMetadata(boolean z, boolean z2, Path path, Long l, Long l2, Long l3, Long l4, Map<hp1, ? extends Object> map) {
        map.getClass();
        this.isRegularFile = z;
        this.isDirectory = z2;
        this.symlinkTarget = path;
        this.size = l;
        this.createdAtMillis = l2;
        this.lastModifiedAtMillis = l3;
        this.lastAccessedAtMillis = l4;
        this.extras = y42.q(map);
    }

    public FileMetadata() {
        this(false, false, null, null, null, null, null, null, 255, null);
    }
}
