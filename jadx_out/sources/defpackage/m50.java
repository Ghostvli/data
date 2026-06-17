package defpackage;

import java.security.Permission;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class m50 extends Permission {
    public final Set f;

    public m50(String str) {
        super(str);
        HashSet hashSet = new HashSet();
        this.f = hashSet;
        hashSet.add(str);
    }

    public boolean equals(Object obj) {
        return (obj instanceof m50) && this.f.equals(((m50) obj).f);
    }

    @Override // java.security.Permission
    public String getActions() {
        return this.f.toString();
    }

    public int hashCode() {
        return this.f.hashCode();
    }

    @Override // java.security.Permission
    public boolean implies(Permission permission) {
        if (!(permission instanceof m50)) {
            return false;
        }
        m50 m50Var = (m50) permission;
        return getName().equals(m50Var.getName()) || this.f.containsAll(m50Var.f);
    }
}
