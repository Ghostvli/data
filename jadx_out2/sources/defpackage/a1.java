package defpackage;

import defpackage.m0;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a1 extends m0 implements j24 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public a1(Map map) {
        super(map);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.m0
    public Collection A(Collection collection) {
        return Collections.unmodifiableSet((Set) collection);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.m0
    public Collection B(Object obj, Collection collection) {
        return new m0.m(obj, (Set) collection);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: w()Ljava/util/Collection; */
    @Override // defpackage.m0
    /* JADX INFO: renamed from: D, reason: merged with bridge method [inline-methods] */
    public Set w() {
        return Collections.EMPTY_SET;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a()Ljava/util/Collection; */
    @Override // defpackage.m0, defpackage.q0, defpackage.dw2
    /* JADX INFO: renamed from: E, reason: merged with bridge method [inline-methods] */
    public Set a() {
        return (Set) super.a();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: get(Ljava/lang/Object;)Ljava/util/Collection; */
    @Override // defpackage.m0, defpackage.dw2
    /* JADX INFO: renamed from: F, reason: merged with bridge method [inline-methods] */
    public Set get(Object obj) {
        return (Set) super.get(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Set G(Object obj) {
        return (Set) super.y(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q0, defpackage.dw2
    public Map b() {
        return super.b();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.q0
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // defpackage.m0, defpackage.dw2
    public boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }
}
