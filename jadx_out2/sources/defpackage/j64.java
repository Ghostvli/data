package defpackage;

import android.app.Person;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jupnp.model.ServiceReference;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public class j64 {
    public Context a;
    public String b;
    public Intent[] c;
    public ComponentName d;
    public CharSequence e;
    public CharSequence f;
    public CharSequence g;
    public IconCompat h;
    public boolean i;
    public va3[] j;
    public Set k;
    public wz1 l;
    public boolean m;
    public int n;
    public PersistableBundle o;
    public boolean p = true;
    public int q;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class a {
        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public static void a(ShortcutInfo.Builder builder, int i) {
            builder.setExcludedFromSurfaces(i);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class b {
        public final j64 a;
        public boolean b;
        public Set c;
        public Map d;
        public Uri e;

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b(Context context, String str) {
            j64 j64Var = new j64();
            this.a = j64Var;
            j64Var.a = context;
            j64Var.b = str;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public j64 a() {
            if (TextUtils.isEmpty(this.a.e)) {
                jl.a("Shortcut must have a non-empty label");
                return null;
            }
            j64 j64Var = this.a;
            Intent[] intentArr = j64Var.c;
            if (intentArr == null || intentArr.length == 0) {
                jl.a("Shortcut must have an intent");
                return null;
            }
            if (this.b) {
                if (j64Var.l == null) {
                    j64Var.l = new wz1(j64Var.b);
                }
                this.a.m = true;
            }
            if (this.c != null) {
                j64 j64Var2 = this.a;
                if (j64Var2.k == null) {
                    j64Var2.k = new HashSet();
                }
                this.a.k.addAll(this.c);
            }
            if (this.d != null) {
                j64 j64Var3 = this.a;
                if (j64Var3.o == null) {
                    j64Var3.o = new PersistableBundle();
                }
                for (String str : this.d.keySet()) {
                    Map map = (Map) this.d.get(str);
                    this.a.o.putStringArray(str, (String[]) map.keySet().toArray(new String[0]));
                    for (String str2 : map.keySet()) {
                        List list = (List) map.get(str2);
                        this.a.o.putStringArray(str + ServiceReference.DELIMITER + str2, list == null ? new String[0] : (String[]) list.toArray(new String[0]));
                    }
                }
            }
            if (this.e != null) {
                j64 j64Var4 = this.a;
                if (j64Var4.o == null) {
                    j64Var4.o = new PersistableBundle();
                }
                this.a.o.putString("extraSliceUri", ix4.a(this.e));
            }
            return this.a;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b b(IconCompat iconCompat) {
            this.a.h = iconCompat;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b c(Intent intent) {
            return d(new Intent[]{intent});
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b d(Intent[] intentArr) {
            this.a.c = intentArr;
            return this;
        }

        /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
        public b e(CharSequence charSequence) {
            this.a.e = charSequence;
            return this;
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public Intent a(Intent intent) {
        intent.putExtra("android.intent.extra.shortcut.INTENT", this.c[r0.length - 1]).putExtra("android.intent.extra.shortcut.NAME", this.e.toString());
        if (this.h != null) {
            Drawable activityIcon = null;
            if (this.i) {
                PackageManager packageManager = this.a.getPackageManager();
                ComponentName componentName = this.d;
                if (componentName != null) {
                    try {
                        activityIcon = packageManager.getActivityIcon(componentName);
                    } catch (PackageManager.NameNotFoundException unused) {
                    }
                }
                if (activityIcon == null) {
                    activityIcon = this.a.getApplicationInfo().loadIcon(packageManager);
                }
            }
            this.h.a(intent, activityIcon, this.a);
        }
        return intent;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public final PersistableBundle b() {
        if (this.o == null) {
            this.o = new PersistableBundle();
        }
        va3[] va3VarArr = this.j;
        if (va3VarArr != null && va3VarArr.length > 0) {
            this.o.putInt("extraPersonCount", va3VarArr.length);
            if (this.j.length > 0) {
                new StringBuilder("extraPerson_").append(1);
                va3 va3Var = this.j[0];
                throw null;
            }
        }
        wz1 wz1Var = this.l;
        if (wz1Var != null) {
            this.o.putString("extraLocusId", wz1Var.a());
        }
        this.o.putBoolean("extraLongLived", this.m);
        return this.o;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public boolean c(int i) {
        return (this.q & i) != 0;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    public ShortcutInfo d() {
        i64.a();
        ShortcutInfo.Builder intents = h64.a(this.a, this.b).setShortLabel(this.e).setIntents(this.c);
        IconCompat iconCompat = this.h;
        if (iconCompat != null) {
            intents.setIcon(iconCompat.p(this.a));
        }
        if (!TextUtils.isEmpty(this.f)) {
            intents.setLongLabel(this.f);
        }
        if (!TextUtils.isEmpty(this.g)) {
            intents.setDisabledMessage(this.g);
        }
        ComponentName componentName = this.d;
        if (componentName != null) {
            intents.setActivity(componentName);
        }
        Set<String> set = this.k;
        if (set != null) {
            intents.setCategories(set);
        }
        intents.setRank(this.n);
        PersistableBundle persistableBundle = this.o;
        if (persistableBundle != null) {
            intents.setExtras(persistableBundle);
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 29) {
            va3[] va3VarArr = this.j;
            if (va3VarArr != null && va3VarArr.length > 0) {
                int length = va3VarArr.length;
                Person[] personArr = new Person[length];
                if (length > 0) {
                    va3 va3Var = va3VarArr[0];
                    throw null;
                }
                intents.setPersons(personArr);
            }
            wz1 wz1Var = this.l;
            if (wz1Var != null) {
                intents.setLocusId(wz1Var.c());
            }
            intents.setLongLived(this.m);
        } else {
            intents.setExtras(b());
        }
        if (i >= 33) {
            a.a(intents, this.q);
        }
        return intents.build();
    }
}
