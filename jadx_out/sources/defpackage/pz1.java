package defpackage;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class pz1 implements Serializable {
    public static final pz1 h = new pz1("en", "GB");
    public final String f;
    public final String g;

    public pz1(String str, String str2) {
        this.f = str;
        this.g = str2;
    }

    public static /* synthetic */ IllegalArgumentException a(String str) {
        return new IllegalArgumentException("Not a localization code: " + str);
    }

    public static pz1 b(Locale locale) {
        return new pz1(locale.getLanguage(), locale.getCountry());
    }

    public static Optional c(String str) {
        return iz1.a(str).map(new Function() { // from class: oz1
            @Override // java.util.function.Function
            public final Object apply(Object obj) {
                return pz1.b((Locale) obj);
            }
        });
    }

    public static Locale f(String str) throws s83 {
        String[] iSOLanguages = Locale.getISOLanguages();
        HashMap map = new HashMap(iSOLanguages.length);
        for (String str2 : iSOLanguages) {
            Locale locale = new Locale(str2);
            map.put(locale.getISO3Language(), locale);
        }
        if (map.containsKey(str)) {
            return (Locale) map.get(str);
        }
        to1.a("Could not get Locale from this three letter language code", str);
        return null;
    }

    public static List h(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (final String str : strArr) {
            arrayList.add((pz1) c(str).orElseThrow(new Supplier() { // from class: nz1
                @Override // java.util.function.Supplier
                public final Object get() {
                    return pz1.a(str);
                }
            }));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String d() {
        String str = this.g;
        return str == null ? "" : str;
    }

    public String e() {
        return this.f;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof pz1)) {
            return false;
        }
        pz1 pz1Var = (pz1) obj;
        return this.f.equals(pz1Var.f) && Objects.equals(this.g, pz1Var.g);
    }

    public String g() {
        String str;
        String str2 = this.f;
        String str3 = this.g;
        if (str3 == null) {
            str = "";
        } else {
            str = "-" + str3;
        }
        return str2 + str;
    }

    public int hashCode() {
        return (this.f.hashCode() * 31) + Objects.hashCode(this.g);
    }

    public String toString() {
        return "Localization[" + g() + "]";
    }

    public pz1(String str) {
        this(str, null);
    }
}
