package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class m20 implements Serializable {
    public static final m20 g = new m20(pz1.h.d());
    public final String f;

    public m20(String str) {
        this.f = str;
    }

    public static List b(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            arrayList.add(new m20(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String a() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof m20) {
            return this.f.equals(((m20) obj).f);
        }
        return false;
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    public String toString() {
        return a();
    }
}
