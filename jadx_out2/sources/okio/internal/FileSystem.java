package okio.internal;

import defpackage.e04;
import defpackage.ep1;
import defpackage.f14;
import defpackage.f30;
import defpackage.fw4;
import defpackage.g30;
import defpackage.gt3;
import defpackage.h14;
import defpackage.ia;
import defpackage.k14;
import defpackage.kl1;
import defpackage.lt3;
import defpackage.mv0;
import defpackage.oc4;
import defpackage.ow;
import defpackage.ra0;
import defpackage.we5;
import defpackage.xe5;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function2;
import okio.BufferedSink;
import okio.FileMetadata;
import okio.Okio;
import okio.Path;
import okio.Source;
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public AnonymousClass1(f30 f30Var) {
            super(f30Var);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C01601(Path path, okio.FileSystem fileSystem, boolean z, f30 f30Var) {
            super(2, f30Var);
            this.$dir = path;
            this.$this_commonListRecursively = fileSystem;
            this.$followSymlinks = z;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        @Override // defpackage.hh
        public final f30 create(Object obj, f30 f30Var) {
            C01601 c01601 = new C01601(this.$dir, this.$this_commonListRecursively, this.$followSymlinks, f30Var);
            c01601.L$0 = obj;
            return c01601;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX DEBUG: Method merged with bridge method: invoke(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object; */
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(h14 h14Var, f30 f30Var) {
            return ((C01601) create(h14Var, f30Var)).invokeSuspend(fw4.a);
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        /* JADX WARN: Removed duplicated region for block: B:11:0x004a  */
        /* JADX WARN: Removed duplicated region for block: B:15:0x006e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0069 -> B:14:0x006c). Please report as a decompilation issue!!! */
        @Override // defpackage.hh
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) throws Throwable {
            ia iaVar;
            Iterator<Path> it;
            h14 h14Var = (h14) this.L$0;
            Object objE = kl1.e();
            int i = this.label;
            if (i == 0) {
                lt3.b(obj);
                ia iaVar2 = new ia();
                iaVar2.addLast(this.$dir);
                iaVar = iaVar2;
                it = this.$this_commonListRecursively.list(this.$dir).iterator();
                if (it.hasNext()) {
                }
            } else {
                if (i != 1) {
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                Iterator<Path> it2 = (Iterator) this.L$2;
                iaVar = (ia) this.L$1;
                lt3.b(obj);
                C01601 c01601 = this;
                it = it2;
                this = c01601;
                if (it.hasNext()) {
                    Path next = it.next();
                    okio.FileSystem fileSystem = this.$this_commonListRecursively;
                    boolean z = this.$followSymlinks;
                    this.L$0 = h14Var;
                    this.L$1 = iaVar;
                    this.L$2 = it;
                    this.L$3 = oc4.a(next);
                    this.label = 1;
                    c01601 = this;
                    if (FileSystem.collectRecursively(h14Var, fileSystem, iaVar, next, z, false, c01601) == objE) {
                        return objE;
                    }
                    this = c01601;
                    if (it.hasNext()) {
                        return fw4.a;
                    }
                }
            }
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
    */
    public static final Object collectRecursively(h14 h14Var, okio.FileSystem fileSystem, ia iaVar, Path path, boolean z, boolean z2, f30 f30Var) throws Throwable {
        AnonymousClass1 anonymousClass1;
        okio.FileSystem fileSystem2;
        ia iaVar2;
        boolean z3;
        h14 h14Var2;
        boolean z4;
        okio.FileSystem fileSystem3;
        List<Path> listListOrNull;
        int i;
        Path path2;
        ia iaVar3;
        boolean z5;
        ia iaVar4;
        boolean z6;
        AnonymousClass1 anonymousClass12;
        okio.FileSystem fileSystem4;
        h14 h14Var3;
        Path path3 = path;
        boolean z7 = z2;
        if (f30Var instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) f30Var;
            int i2 = anonymousClass1.label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(f30Var);
            }
        }
        Object obj = anonymousClass1.result;
        Object objE = kl1.e();
        int i3 = anonymousClass1.label;
        if (i3 == 0) {
            lt3.b(obj);
            if (z7) {
                fileSystem2 = fileSystem;
                iaVar2 = iaVar;
                z3 = z;
            } else {
                anonymousClass1.L$0 = h14Var;
                fileSystem2 = fileSystem;
                anonymousClass1.L$1 = fileSystem2;
                iaVar2 = iaVar;
                anonymousClass1.L$2 = iaVar2;
                anonymousClass1.L$3 = path3;
                z3 = z;
                anonymousClass1.Z$0 = z3;
                anonymousClass1.Z$1 = z7;
                anonymousClass1.label = 1;
            }
            boolean z8 = z3;
            h14Var2 = h14Var;
            z4 = z8;
            fileSystem3 = fileSystem2;
        } else if (i3 == 1) {
            boolean z9 = anonymousClass1.Z$1;
            boolean z10 = anonymousClass1.Z$0;
            Path path4 = (Path) anonymousClass1.L$3;
            iaVar2 = (ia) anonymousClass1.L$2;
            fileSystem3 = (okio.FileSystem) anonymousClass1.L$1;
            h14Var2 = (h14) anonymousClass1.L$0;
            lt3.b(obj);
            z7 = z9;
            z4 = z10;
            path3 = path4;
        } else {
            if (i3 != 2) {
                if (i3 != 3) {
                    e04.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                lt3.b(obj);
                return fw4.a;
            }
            int i4 = anonymousClass1.I$0;
            boolean z11 = anonymousClass1.Z$1;
            boolean z12 = anonymousClass1.Z$0;
            Iterator<Path> it = (Iterator) anonymousClass1.L$6;
            Path path5 = (Path) anonymousClass1.L$5;
            List<Path> list = (List) anonymousClass1.L$4;
            Path path6 = (Path) anonymousClass1.L$3;
            ia iaVar5 = (ia) anonymousClass1.L$2;
            okio.FileSystem fileSystem5 = (okio.FileSystem) anonymousClass1.L$1;
            h14 h14Var4 = (h14) anonymousClass1.L$0;
            try {
                lt3.b(obj);
                i = i4;
                z4 = z12;
                z7 = z11;
                ia iaVar6 = iaVar5;
                path2 = path5;
                fileSystem3 = fileSystem5;
                Path path7 = path6;
                listListOrNull = list;
                try {
                    h14Var2 = h14Var4;
                    if (!it.hasNext()) {
                        try {
                            Path next = it.next();
                            anonymousClass1.L$0 = h14Var2;
                            anonymousClass1.L$1 = fileSystem3;
                            anonymousClass1.L$2 = iaVar6;
                            anonymousClass1.L$3 = path7;
                            anonymousClass1.L$4 = oc4.a(listListOrNull);
                            anonymousClass1.L$5 = oc4.a(path2);
                            anonymousClass1.L$6 = it;
                            anonymousClass1.L$7 = oc4.a(next);
                            anonymousClass1.Z$0 = z4;
                            anonymousClass1.Z$1 = z7;
                            anonymousClass1.I$0 = i;
                            anonymousClass1.label = 2;
                            Object objCollectRecursively = collectRecursively(h14Var3, fileSystem4, iaVar4, next, z5, z6, anonymousClass12);
                            h14Var4 = h14Var3;
                            fileSystem3 = fileSystem4;
                            anonymousClass1 = anonymousClass12;
                            if (objCollectRecursively != objE) {
                                z4 = z5;
                                z7 = z6;
                                iaVar6 = iaVar4;
                                h14Var2 = h14Var4;
                                if (!it.hasNext()) {
                                    ia iaVar7 = iaVar6;
                                    iaVar7.removeLast();
                                    iaVar2 = iaVar7;
                                    z7 = z7;
                                    path3 = path7;
                                    if (z7) {
                                        return fw4.a;
                                    }
                                    anonymousClass1.L$0 = oc4.a(h14Var2);
                                    anonymousClass1.L$1 = oc4.a(fileSystem3);
                                    anonymousClass1.L$2 = oc4.a(iaVar2);
                                    anonymousClass1.L$3 = oc4.a(path3);
                                    anonymousClass1.L$4 = oc4.a(listListOrNull);
                                    anonymousClass1.L$5 = null;
                                    anonymousClass1.L$6 = null;
                                    anonymousClass1.L$7 = null;
                                    anonymousClass1.Z$0 = z4;
                                    anonymousClass1.Z$1 = z7;
                                    anonymousClass1.label = 3;
                                }
                            }
                            return objE;
                        } catch (Throwable th) {
                            th = th;
                            iaVar3 = iaVar4;
                            iaVar5 = iaVar3;
                            iaVar5.removeLast();
                            throw th;
                        }
                        z5 = z4;
                        iaVar4 = iaVar6;
                        z6 = z7;
                        anonymousClass12 = anonymousClass1;
                        fileSystem4 = fileSystem3;
                        h14Var3 = h14Var2;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    iaVar3 = iaVar6;
                }
            } catch (Throwable th3) {
                th = th3;
                iaVar5.removeLast();
                throw th;
            }
        }
        listListOrNull = fileSystem3.listOrNull(path3);
        if (listListOrNull == null) {
            listListOrNull = ow.j();
        }
        if (!listListOrNull.isEmpty()) {
            i = 0;
            path2 = path3;
            while (true) {
                if (z4 && iaVar2.contains(path2)) {
                    we5.a("symlink cycle at ", path3);
                    return null;
                }
                Path pathSymlinkTarget = symlinkTarget(fileSystem3, path2);
                if (pathSymlinkTarget == null) {
                    break;
                }
                i++;
                path2 = pathSymlinkTarget;
            }
        }
        if (z7) {
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX WARN: Removed duplicated region for block: B:21:0x003c A[Catch: all -> 0x0036, TRY_LEAVE, TryCatch #3 {all -> 0x0036, blocks: (B:3:0x0010, B:21:0x003c, B:27:0x0047, B:16:0x0032, B:13:0x002d, B:4:0x0018), top: B:43:0x0010, inners: #0, #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0047 A[Catch: all -> 0x0036, TRY_ENTER, TRY_LEAVE, TryCatch #3 {all -> 0x0036, blocks: (B:3:0x0010, B:21:0x003c, B:27:0x0047, B:16:0x0032, B:13:0x002d, B:4:0x0018), top: B:43:0x0010, inners: #0, #4 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void commonCopy(okio.FileSystem fileSystem, Path path, Path path2) {
        Throwable th;
        Long lValueOf;
        fileSystem.getClass();
        path.getClass();
        path2.getClass();
        Source source = fileSystem.source(path);
        Throwable th2 = null;
        try {
            BufferedSink bufferedSinkBuffer = Okio.buffer(okio.FileSystem.sink$default(fileSystem, path2, false, 2, null));
            try {
                lValueOf = Long.valueOf(bufferedSinkBuffer.writeAll(source));
            } catch (Throwable th3) {
                if (bufferedSinkBuffer != null) {
                    try {
                        bufferedSinkBuffer.close();
                    } catch (Throwable th4) {
                        mv0.a(th3, th4);
                    }
                }
                th = th3;
                lValueOf = null;
            }
            if (bufferedSinkBuffer != null) {
                try {
                    bufferedSinkBuffer.close();
                    th = null;
                } catch (Throwable th5) {
                    th = th5;
                }
                if (th == null) {
                    throw th;
                }
                lValueOf.longValue();
                if (source != null) {
                    try {
                        source.close();
                    } catch (Throwable th6) {
                        th2 = th6;
                    }
                }
            } else {
                th = null;
                if (th == null) {
                }
            }
        } catch (Throwable th7) {
            if (source != null) {
                try {
                    source.close();
                } catch (Throwable th8) {
                    mv0.a(th7, th8);
                }
            }
            th2 = th7;
        }
        if (th2 != null) {
            throw th2;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final void commonDeleteRecursively(okio.FileSystem fileSystem, Path path, boolean z) {
        fileSystem.getClass();
        path.getClass();
        Iterator it = k14.b(new FileSystem$commonDeleteRecursively$sequence$1(fileSystem, path, null)).iterator();
        while (it.hasNext()) {
            fileSystem.delete((Path) it.next(), z && !it.hasNext());
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final boolean commonExists(okio.FileSystem fileSystem, Path path) {
        fileSystem.getClass();
        path.getClass();
        return fileSystem.metadataOrNull(path) != null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public static final f14 commonListRecursively(okio.FileSystem fileSystem, Path path, boolean z) {
        fileSystem.getClass();
        path.getClass();
        return k14.b(new C01601(path, fileSystem, z, null));
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
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
