package defpackage;

import java.security.Permission;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes3.dex */
public class m50 extends Permission {
    public final Set f;

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public m50(String str) {
        super(str);
        HashSet hashSet = new HashSet();
        this.f = hashSet;
        hashSet.add(str);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean equals(Object obj) {
        return (obj instanceof m50) && this.f.equals(((m50) obj).f);
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.security.Permission
    public String getActions() {
        return this.f.toString();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public int hashCode() {
        return this.f.hashCode();
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    @Override // java.security.Permission
    public boolean implies(Permission permission) {
        if (!(permission instanceof m50)) {
            return false;
        }
        m50 m50Var = (m50) permission;
        return getName().equals(m50Var.getName()) || this.f.containsAll(m50Var.f);
    }
}
