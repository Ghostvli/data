package defpackage;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class j0 extends m0 implements hu1 {
    public j0(Map map) {
        super(map);
    }

    @Override // defpackage.m0
    public Collection A(Collection collection) {
        return Collections.unmodifiableList((List) collection);
    }

    @Override // defpackage.m0
    public Collection B(Object obj, Collection collection) {
        return C(obj, (List) collection, null);
    }

    @Override // defpackage.m0
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public List w() {
        return Collections.EMPTY_LIST;
    }

    @Override // defpackage.m0, defpackage.dw2
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public List get(Object obj) {
        return (List) super.get(obj);
    }

    @Override // defpackage.q0, defpackage.dw2
    public Map b() {
        return super.b();
    }

    @Override // defpackage.q0
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // defpackage.m0, defpackage.dw2
    public boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }
}
