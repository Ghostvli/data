package defpackage;

import defpackage.m0;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a1 extends m0 implements j24 {
    public a1(Map map) {
        super(map);
    }

    @Override // defpackage.m0
    public Collection A(Collection collection) {
        return Collections.unmodifiableSet((Set) collection);
    }

    @Override // defpackage.m0
    public Collection B(Object obj, Collection collection) {
        return new m0.m(obj, (Set) collection);
    }

    @Override // defpackage.m0
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public Set w() {
        return Collections.EMPTY_SET;
    }

    @Override // defpackage.m0, defpackage.q0, defpackage.dw2
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public Set a() {
        return (Set) super.a();
    }

    @Override // defpackage.m0, defpackage.dw2
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public Set get(Object obj) {
        return (Set) super.get(obj);
    }

    public Set G(Object obj) {
        return (Set) super.y(obj);
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
