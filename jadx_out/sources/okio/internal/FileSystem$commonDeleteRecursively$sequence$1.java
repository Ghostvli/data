package okio.internal;

import defpackage.e04;
import defpackage.f30;
import defpackage.fw4;
import defpackage.gt3;
import defpackage.h14;
import defpackage.ia;
import defpackage.kl1;
import defpackage.lt3;
import defpackage.oc4;
import defpackage.ra0;
import kotlin.jvm.functions.Function2;
import okio.FileSystem;
import okio.Path;
import org.mozilla.javascript.Token;

/* JADX INFO: renamed from: okio.internal.-FileSystem$commonDeleteRecursively$sequence$1, reason: invalid class name */
/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
@ra0(c = "okio.internal.-FileSystem$commonDeleteRecursively$sequence$1", f = "FileSystem.kt", l = {Token.DEL_REF}, m = "invokeSuspend", v = 1)
public final class FileSystem$commonDeleteRecursively$sequence$1 extends gt3 implements Function2<h14, f30, Object> {
    final /* synthetic */ Path $fileOrDirectory;
    final /* synthetic */ FileSystem $this_commonDeleteRecursively;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FileSystem$commonDeleteRecursively$sequence$1(FileSystem fileSystem, Path path, f30 f30Var) {
        super(2, f30Var);
        this.$this_commonDeleteRecursively = fileSystem;
        this.$fileOrDirectory = path;
    }

    @Override // defpackage.hh
    public final f30 create(Object obj, f30 f30Var) {
        FileSystem$commonDeleteRecursively$sequence$1 fileSystem$commonDeleteRecursively$sequence$1 = new FileSystem$commonDeleteRecursively$sequence$1(this.$this_commonDeleteRecursively, this.$fileOrDirectory, f30Var);
        fileSystem$commonDeleteRecursively$sequence$1.L$0 = obj;
        return fileSystem$commonDeleteRecursively$sequence$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(h14 h14Var, f30 f30Var) {
        return ((FileSystem$commonDeleteRecursively$sequence$1) create(h14Var, f30Var)).invokeSuspend(fw4.a);
    }

    @Override // defpackage.hh
    public final Object invokeSuspend(Object obj) throws Throwable {
        h14 h14Var = (h14) this.L$0;
        Object objE = kl1.e();
        int i = this.label;
        if (i == 0) {
            lt3.b(obj);
            FileSystem fileSystem = this.$this_commonDeleteRecursively;
            ia iaVar = new ia();
            Path path = this.$fileOrDirectory;
            this.L$0 = oc4.a(h14Var);
            this.label = 1;
            if (FileSystem.collectRecursively(h14Var, fileSystem, iaVar, path, false, true, this) == objE) {
                return objE;
            }
        } else {
            if (i != 1) {
                e04.a("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            lt3.b(obj);
        }
        return fw4.a;
    }
}
