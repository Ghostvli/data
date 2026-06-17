package defpackage;

import android.os.LocaleList;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class lz1 implements kz1 {
    public final LocaleList a;

    public lz1(Object obj) {
        this.a = (LocaleList) obj;
    }

    @Override // defpackage.kz1
    public String a() {
        return this.a.toLanguageTags();
    }

    @Override // defpackage.kz1
    public Object b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return this.a.equals(((kz1) obj).b());
    }

    @Override // defpackage.kz1
    public Locale get(int i) {
        return this.a.get(i);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // defpackage.kz1
    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    @Override // defpackage.kz1
    public int size() {
        return this.a.size();
    }

    public String toString() {
        return this.a.toString();
    }
}
