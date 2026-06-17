package defpackage;

import java.util.List;
import java.util.Map;
import kotlin.reflect.KAnnotatedElement;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public interface gp1 extends KAnnotatedElement {
    Object call(Object... objArr);

    Object callBy(Map map);

    List getParameters();

    tp1 getReturnType();

    List getTypeParameters();

    up1 getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();
}
