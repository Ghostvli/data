package okhttp3.internal;

import defpackage.dp1;
import defpackage.hp1;
import defpackage.il1;
import defpackage.n14;
import defpackage.p14;
import defpackage.ww;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
final class LinkedTags<K> extends Tags {
    private final hp1 key;
    private final Tags next;
    private final K value;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkedTags(hp1 hp1Var, K k, Tags tags) {
        super(null);
        hp1Var.getClass();
        k.getClass();
        tags.getClass();
        this.key = hp1Var;
        this.value = k;
        this.next = tags;
    }

    public static LinkedTags a(LinkedTags linkedTags) {
        linkedTags.getClass();
        Tags tags = linkedTags.next;
        if (tags instanceof LinkedTags) {
            return (LinkedTags) tags;
        }
        return null;
    }

    public static CharSequence b(LinkedTags linkedTags) {
        linkedTags.getClass();
        StringBuilder sb = new StringBuilder();
        sb.append(linkedTags.key);
        sb.append('=');
        sb.append(linkedTags.value);
        return sb.toString();
    }

    @Override // okhttp3.internal.Tags
    public <T> T get(hp1 hp1Var) {
        hp1Var.getClass();
        return il1.a(hp1Var, this.key) ? (T) dp1.a(hp1Var).cast(this.value) : (T) this.next.get(hp1Var);
    }

    @Override // okhttp3.internal.Tags
    public <T> Tags plus(hp1 hp1Var, T t) {
        hp1Var.getClass();
        boolean zA = il1.a(hp1Var, this.key);
        Tags tags = this.next;
        if (!zA) {
            Tags tagsPlus = tags.plus(hp1Var, null);
            if (tagsPlus != this.next) {
                this = new LinkedTags<>(this.key, this.value, tagsPlus);
            }
            tags = this;
        }
        return t != null ? new LinkedTags(hp1Var, t, tags) : tags;
    }

    public String toString() {
        return ww.P(ww.V(p14.n(n14.f(this, new Function1() { // from class: okhttp3.internal.a
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LinkedTags.a((LinkedTags) obj);
            }
        }))), null, "{", "}", 0, null, new Function1() { // from class: okhttp3.internal.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return LinkedTags.b((LinkedTags) obj);
            }
        }, 25, null);
    }
}
