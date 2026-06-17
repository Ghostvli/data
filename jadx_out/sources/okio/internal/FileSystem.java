package okio.internal;

import defpackage.ep1;
import defpackage.f14;
import defpackage.f30;
import defpackage.fw4;
import defpackage.g30;
import defpackage.gt3;
import defpackage.h14;
import defpackage.ia;
import defpackage.k14;
import defpackage.ra0;
import defpackage.xe5;
import java.io.FileNotFoundException;
import java.util.Iterator;
import kotlin.jvm.functions.Function2;
import okio.FileMetadata;
import okio.Path;
import org.mozilla.javascript.Token;

/* JADX INFO: renamed from: okio.internal.-FileSystem, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public final class FileSystem {

    /* JADX INFO: renamed from: okio.internal.-FileSystem$collectRecursively$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    @ra0(c = "okio.internal.-FileSystem", f = "FileSystem.kt", l = {Token.COLON, Token.VAR, Token.TARGET}, m = "collectRecursively", v = 1)
    public static final class AnonymousClass1 extends g30 {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        boolean Z$0;
        boolean Z$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(f30 f30Var) {
            super(f30Var);
        }

        @Override // defpackage.hh
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return FileSystem.collectRecursively(null, null, null, null, false, false, this);
        }
    }

    /* JADX INFO: renamed from: okio.internal.-FileSystem$commonListRecursively$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    @ra0(c = "okio.internal.-FileSystem$commonListRecursively$1", f = "FileSystem.kt", l = {Token.LP}, m = "invokeSuspend", v = 1)
    public static final class C01601 extends gt3 implements Function2<h14, f30, Object> {
        final /* synthetic */ Path $dir;
        final /* synthetic */ boolean $followSymlinks;
        final /* synthetic */ okio.FileSystem $this_commonListRecursively;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01601(Path path, okio.FileSystem fileSystem, boolean z, f30 f30Var) {
            super(2, f30Var);
            this.$dir = path;
            this.$this_commonListRecursively = fileSystem;
            this.$followSymlinks = z;
        }

        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            C01601 c01601 = new C01601(this.$dir, this.$this_commonListRecursively, this.$followSymlinks, f30Var);
            c01601.L$0 = obj;
            return c01601;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(h14 h14Var, f30 f30Var) {
            return ((C01601) create(h14Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x006e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0069 -> B:14:0x006c). Please report as a decompilation issue!!! */
        @Override // defpackage.hh
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                r9 = this;
                java.lang.Object r0 = r9.L$0
                r1 = r0
                h14 r1 = (defpackage.h14) r1
                java.lang.Object r0 = defpackage.kl1.e()
                int r2 = r9.label
                r8 = 1
                if (r2 == 0) goto L29
                if (r2 != r8) goto L22
                java.lang.Object r2 = r9.L$3
                okio.Path r2 = (okio.Path) r2
                java.lang.Object r2 = r9.L$2
                java.util.Iterator r2 = (java.util.Iterator) r2
                java.lang.Object r3 = r9.L$1
                ia r3 = (defpackage.ia) r3
                defpackage.lt3.b(r10)
                r7 = r9
                r10 = r2
                goto L6c
            L22:
                java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                defpackage.e04.a(r9)
                r9 = 0
                return r9
            L29:
                defpackage.lt3.b(r10)
                ia r10 = new ia
                r10.<init>()
                okio.Path r2 = r9.$dir
                r10.addLast(r2)
                okio.FileSystem r2 = r9.$this_commonListRecursively
                okio.Path r3 = r9.$dir
                java.util.List r2 = r2.list(r3)
                java.util.Iterator r2 = r2.iterator()
                r3 = r10
                r10 = r2
            L44:
                boolean r2 = r10.hasNext()
                if (r2 == 0) goto L6e
                java.lang.Object r2 = r10.next()
                r4 = r2
                okio.Path r4 = (okio.Path) r4
                okio.FileSystem r2 = r9.$this_commonListRecursively
                boolean r5 = r9.$followSymlinks
                r9.L$0 = r1
                r9.L$1 = r3
                r9.L$2 = r10
                java.lang.Object r6 = defpackage.oc4.a(r4)
                r9.L$3 = r6
                r9.label = r8
                r6 = 0
                r7 = r9
                java.lang.Object r9 = okio.internal.FileSystem.collectRecursively(r1, r2, r3, r4, r5, r6, r7)
                if (r9 != r0) goto L6c
                return r0
            L6c:
                r9 = r7
                goto L44
            L6e:
                fw4 r9 = defpackage.fw4.a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: okio.internal.FileSystem.C01601.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x00c6, code lost:
    
        if (r17.b(r1, r4) == r5) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00fb, code lost:
    
        if (r0 != false) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00fd, code lost:
    
        if (r12 != 0) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00ff, code lost:
    
        r6.addLast(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0106, code lost:
    
        r14 = r1;
        r1 = r6;
        r6 = r3.iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0178, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0179, code lost:
    
        r13 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x01b5, code lost:
    
        if (r11.b(r1, r4) == r5) goto L73;
     */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0112 A[Catch: all -> 0x016a, TRY_LEAVE, TryCatch #3 {all -> 0x016a, blocks: (B:49:0x010c, B:51:0x0112), top: B:84:0x010c }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001b  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x015e -> B:19:0x0085). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object collectRecursively(defpackage.h14 r17, okio.FileSystem r18, defpackage.ia r19, okio.Path r20, boolean r21, boolean r22, defpackage.f30 r23) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 446
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.FileSystem.collectRecursively(h14, okio.FileSystem, ia, okio.Path, boolean, boolean, f30):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x003c A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #3 {all -> 0x0036, blocks: (B:3:0x0010, B:21:0x003c, B:27:0x0047, B:16:0x0032, B:13:0x002d, B:4:0x0018), top: B:43:0x0010, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0047 A[Catch: all -> 0x0036, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0036, blocks: (B:3:0x0010, B:21:0x003c, B:27:0x0047, B:16:0x0032, B:13:0x002d, B:4:0x0018), top: B:43:0x0010, inners: #0, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void commonCopy(okio.FileSystem r3, okio.Path r4, okio.Path r5) {
        /*
            r3.getClass()
            r4.getClass()
            r5.getClass()
            okio.Source r4 = r3.source(r4)
            r0 = 0
            r1 = 2
            r2 = 0
            okio.Sink r3 = okio.FileSystem.sink$default(r3, r5, r0, r1, r2)     // Catch: java.lang.Throwable -> L36
            okio.BufferedSink r3 = okio.Okio.buffer(r3)     // Catch: java.lang.Throwable -> L36
            long r0 = r3.writeAll(r4)     // Catch: java.lang.Throwable -> L2a
            java.lang.Long r5 = java.lang.Long.valueOf(r0)     // Catch: java.lang.Throwable -> L2a
            if (r3 == 0) goto L28
            r3.close()     // Catch: java.lang.Throwable -> L26
            goto L28
        L26:
            r3 = move-exception
            goto L3a
        L28:
            r3 = r2
            goto L3a
        L2a:
            r5 = move-exception
            if (r3 == 0) goto L38
            r3.close()     // Catch: java.lang.Throwable -> L31
            goto L38
        L31:
            r3 = move-exception
            defpackage.mv0.a(r5, r3)     // Catch: java.lang.Throwable -> L36
            goto L38
        L36:
            r3 = move-exception
            goto L48
        L38:
            r3 = r5
            r5 = r2
        L3a:
            if (r3 != 0) goto L47
            r5.longValue()     // Catch: java.lang.Throwable -> L36
            if (r4 == 0) goto L53
            r4.close()     // Catch: java.lang.Throwable -> L45
            goto L53
        L45:
            r2 = move-exception
            goto L53
        L47:
            throw r3     // Catch: java.lang.Throwable -> L36
        L48:
            if (r4 == 0) goto L52
            r4.close()     // Catch: java.lang.Throwable -> L4e
            goto L52
        L4e:
            r4 = move-exception
            defpackage.mv0.a(r3, r4)
        L52:
            r2 = r3
        L53:
            if (r2 != 0) goto L56
            return
        L56:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.FileSystem.commonCopy(okio.FileSystem, okio.Path, okio.Path):void");
    }

    public static final void commonCreateDirectories(okio.FileSystem fileSystem, Path path, boolean z) {
        fileSystem.getClass();
        path.getClass();
        ia iaVar = new ia();
        for (Path pathParent = path; pathParent != null && !fileSystem.exists(pathParent); pathParent = pathParent.parent()) {
            iaVar.addFirst(pathParent);
        }
        if (z && iaVar.isEmpty()) {
            ep1.a(path, " already exists.");
            return;
        }
        Iterator<E> it = iaVar.iterator();
        while (it.hasNext()) {
            okio.FileSystem.createDirectory$default(fileSystem, (Path) it.next(), false, 2, null);
        }
    }

    public static final void commonDeleteRecursively(okio.FileSystem fileSystem, Path path, boolean z) {
        fileSystem.getClass();
        path.getClass();
        Iterator it = k14.b(new FileSystem$commonDeleteRecursively$sequence$1(fileSystem, path, null)).iterator();
        while (it.hasNext()) {
            fileSystem.delete((Path) it.next(), z && !it.hasNext());
        }
    }

    public static final boolean commonExists(okio.FileSystem fileSystem, Path path) {
        fileSystem.getClass();
        path.getClass();
        return fileSystem.metadataOrNull(path) != null;
    }

    public static final f14 commonListRecursively(okio.FileSystem fileSystem, Path path, boolean z) {
        fileSystem.getClass();
        path.getClass();
        return k14.b(new C01601(path, fileSystem, z, null));
    }

    public static final FileMetadata commonMetadata(okio.FileSystem fileSystem, Path path) throws FileNotFoundException {
        fileSystem.getClass();
        path.getClass();
        FileMetadata fileMetadataMetadataOrNull = fileSystem.metadataOrNull(path);
        if (fileMetadataMetadataOrNull != null) {
            return fileMetadataMetadataOrNull;
        }
        xe5.a("no such file: ", path);
        return null;
    }

    public static final Path symlinkTarget(okio.FileSystem fileSystem, Path path) {
        fileSystem.getClass();
        path.getClass();
        Path symlinkTarget = fileSystem.metadata(path).getSymlinkTarget();
        if (symlinkTarget == null) {
            return null;
        }
        Path pathParent = path.parent();
        pathParent.getClass();
        return pathParent.resolve(symlinkTarget);
    }
}
