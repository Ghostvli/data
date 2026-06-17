package defpackage;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class so implements gp1, Serializable {
    public static final Object NO_RECEIVER = a.f;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient gp1 reflected;
    private final String signature;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a implements Serializable {
        public static final a f = new a();
    }

    public so(Object obj, Class cls, String str, String str2, boolean z) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z;
    }

    @Override // defpackage.gp1
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // defpackage.gp1
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public gp1 compute() {
        gp1 gp1Var = this.reflected;
        if (gp1Var != null) {
            return gp1Var;
        }
        gp1 gp1VarComputeReflected = computeReflected();
        this.reflected = gp1VarComputeReflected;
        return gp1VarComputeReflected;
    }

    public abstract gp1 computeReflected();

    @Override // kotlin.reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public mp1 getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        return this.isTopLevel ? np3.c(cls) : np3.b(cls);
    }

    @Override // defpackage.gp1
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    public gp1 getReflected() {
        gp1 gp1VarCompute = compute();
        if (gp1VarCompute != this) {
            return gp1VarCompute;
        }
        throw new lr1();
    }

    @Override // defpackage.gp1
    public tp1 getReturnType() {
        getReflected().getReturnType();
        return null;
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // defpackage.gp1
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // defpackage.gp1
    public up1 getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // defpackage.gp1
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // defpackage.gp1
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // defpackage.gp1
    public boolean isOpen() {
        return getReflected().isOpen();
    }
}
