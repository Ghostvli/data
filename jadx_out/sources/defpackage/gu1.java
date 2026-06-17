package defpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class gu1 extends wt1 {
    @Override // defpackage.wt1
    public String f(String str) {
        return l(str, new ArrayList(0), "");
    }

    @Override // defpackage.wt1
    public String g(String str, String str2) {
        return m(str, new ArrayList(0), "", str2);
    }

    @Override // defpackage.wt1
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public fu1 b(String str, String str2) {
        return new fu1(super.b(str, str2));
    }

    @Override // defpackage.wt1
    /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
    public fu1 c(String str) {
        String strG = yy4.g(str);
        return d(strG, yy4.h(strG));
    }

    @Override // defpackage.wt1
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public fu1 d(String str, String str2) {
        Objects.requireNonNull(str, "URL may not be null");
        return new fu1(super.d(str, str2));
    }

    public abstract String l(String str, List list, String str2);

    public String m(String str, List list, String str2, String str3) {
        return l(str, list, str2);
    }
}
