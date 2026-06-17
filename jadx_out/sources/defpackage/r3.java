package defpackage;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.lifecycle.g;
import androidx.lifecycle.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public abstract class r3 {
    public final Map a = new HashMap();
    public final Map b = new HashMap();
    public final Map c = new HashMap();
    public ArrayList d = new ArrayList();
    public final transient Map e = new HashMap();
    public final Map f = new HashMap();
    public final Bundle g = new Bundle();

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class a implements i {
        public final /* synthetic */ String f;
        public final /* synthetic */ l3 g;
        public final /* synthetic */ m3 h;

        public a(String str, l3 l3Var, m3 m3Var) {
            this.f = str;
            this.g = l3Var;
            this.h = m3Var;
        }

        @Override // androidx.lifecycle.i
        public void c(bt1 bt1Var, g.a aVar) {
            if (!g.a.ON_START.equals(aVar)) {
                if (g.a.ON_STOP.equals(aVar)) {
                    r3.this.e.remove(this.f);
                    return;
                } else {
                    if (g.a.ON_DESTROY.equals(aVar)) {
                        r3.this.l(this.f);
                        return;
                    }
                    return;
                }
            }
            r3.this.e.put(this.f, new d(this.g, this.h));
            if (r3.this.f.containsKey(this.f)) {
                Object obj = r3.this.f.get(this.f);
                r3.this.f.remove(this.f);
                this.g.a(obj);
            }
            k3 k3Var = (k3) r3.this.g.getParcelable(this.f);
            if (k3Var != null) {
                r3.this.g.remove(this.f);
                this.g.a(this.h.c(k3Var.d(), k3Var.c()));
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class b extends q3 {
        public final /* synthetic */ String a;
        public final /* synthetic */ m3 b;

        public b(String str, m3 m3Var) {
            this.a = str;
            this.b = m3Var;
        }

        @Override // defpackage.q3
        public void b(Object obj, i3 i3Var) throws Exception {
            Integer num = (Integer) r3.this.b.get(this.a);
            if (num == null) {
                v22.a("Attempting to launch an unregistered ActivityResultLauncher with contract ", this.b, " and input ", obj, ". You must ensure the ActivityResultLauncher is registered before calling launch().");
                return;
            }
            r3.this.d.add(this.a);
            try {
                r3.this.f(num.intValue(), this.b, obj, i3Var);
            } catch (Exception e) {
                r3.this.d.remove(this.a);
                throw e;
            }
        }

        @Override // defpackage.q3
        public void c() {
            r3.this.l(this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public class c extends q3 {
        public final /* synthetic */ String a;
        public final /* synthetic */ m3 b;

        public c(String str, m3 m3Var) {
            this.a = str;
            this.b = m3Var;
        }

        @Override // defpackage.q3
        public void b(Object obj, i3 i3Var) throws Exception {
            Integer num = (Integer) r3.this.b.get(this.a);
            if (num == null) {
                v22.a("Attempting to launch an unregistered ActivityResultLauncher with contract ", this.b, " and input ", obj, ". You must ensure the ActivityResultLauncher is registered before calling launch().");
                return;
            }
            r3.this.d.add(this.a);
            try {
                r3.this.f(num.intValue(), this.b, obj, i3Var);
            } catch (Exception e) {
                r3.this.d.remove(this.a);
                throw e;
            }
        }

        @Override // defpackage.q3
        public void c() {
            r3.this.l(this.a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class d {
        public final l3 a;
        public final m3 b;

        public d(l3 l3Var, m3 m3Var) {
            this.a = l3Var;
            this.b = m3Var;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static class e {
        public final g a;
        public final ArrayList b = new ArrayList();

        public e(g gVar) {
            this.a = gVar;
        }

        public void a(i iVar) {
            this.a.a(iVar);
            this.b.add(iVar);
        }

        public void b() {
            Iterator it = this.b.iterator();
            while (it.hasNext()) {
                this.a.c((i) it.next());
            }
            this.b.clear();
        }
    }

    public final void a(int i, String str) {
        this.a.put(Integer.valueOf(i), str);
        this.b.put(str, Integer.valueOf(i));
    }

    public final boolean b(int i, int i2, Intent intent) {
        String str = (String) this.a.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        d(str, i2, intent, (d) this.e.get(str));
        return true;
    }

    public final boolean c(int i, Object obj) {
        l3 l3Var;
        String str = (String) this.a.get(Integer.valueOf(i));
        if (str == null) {
            return false;
        }
        d dVar = (d) this.e.get(str);
        if (dVar == null || (l3Var = dVar.a) == null) {
            this.g.remove(str);
            this.f.put(str, obj);
            return true;
        }
        if (!this.d.remove(str)) {
            return true;
        }
        l3Var.a(obj);
        return true;
    }

    public final void d(String str, int i, Intent intent, d dVar) {
        if (dVar == null || dVar.a == null || !this.d.contains(str)) {
            this.f.remove(str);
            this.g.putParcelable(str, new k3(i, intent));
        } else {
            dVar.a.a(dVar.b.c(i, intent));
            this.d.remove(str);
        }
    }

    public final int e() {
        int iB = pn3.f.b(2147418112);
        while (true) {
            int i = iB + 65536;
            if (!this.a.containsKey(Integer.valueOf(i))) {
                return i;
            }
            iB = pn3.f.b(2147418112);
        }
    }

    public abstract void f(int i, m3 m3Var, Object obj, i3 i3Var);

    public final void g(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS");
        ArrayList<String> stringArrayList = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS");
        if (stringArrayList == null || integerArrayList == null) {
            return;
        }
        this.d = bundle.getStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS");
        this.g.putAll(bundle.getBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT"));
        for (int i = 0; i < stringArrayList.size(); i++) {
            String str = stringArrayList.get(i);
            if (this.b.containsKey(str)) {
                Integer num = (Integer) this.b.remove(str);
                if (!this.g.containsKey(str)) {
                    this.a.remove(num);
                }
            }
            a(integerArrayList.get(i).intValue(), stringArrayList.get(i));
        }
    }

    public final void h(Bundle bundle) {
        bundle.putIntegerArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_RCS", new ArrayList<>(this.b.values()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_REGISTERED_KEYS", new ArrayList<>(this.b.keySet()));
        bundle.putStringArrayList("KEY_COMPONENT_ACTIVITY_LAUNCHED_KEYS", new ArrayList<>(this.d));
        bundle.putBundle("KEY_COMPONENT_ACTIVITY_PENDING_RESULT", (Bundle) this.g.clone());
    }

    public final q3 i(String str, m3 m3Var, l3 l3Var) {
        k(str);
        this.e.put(str, new d(l3Var, m3Var));
        if (this.f.containsKey(str)) {
            Object obj = this.f.get(str);
            this.f.remove(str);
            l3Var.a(obj);
        }
        k3 k3Var = (k3) this.g.getParcelable(str);
        if (k3Var != null) {
            this.g.remove(str);
            l3Var.a(m3Var.c(k3Var.d(), k3Var.c()));
        }
        return new c(str, m3Var);
    }

    public final q3 j(String str, bt1 bt1Var, m3 m3Var, l3 l3Var) {
        g lifecycle = bt1Var.getLifecycle();
        if (lifecycle.b().b(g.b.i)) {
            StringBuilder sb = new StringBuilder("LifecycleOwner ");
            sb.append(bt1Var);
            g.b bVarB = lifecycle.b();
            sb.append(" is attempting to register while current state is ");
            sb.append(bVarB);
            sb.append(". LifecycleOwners must call register before they are STARTED.");
            throw new IllegalStateException(sb.toString());
        }
        k(str);
        e eVar = (e) this.c.get(str);
        if (eVar == null) {
            eVar = new e(lifecycle);
        }
        eVar.a(new a(str, l3Var, m3Var));
        this.c.put(str, eVar);
        return new b(str, m3Var);
    }

    public final void k(String str) {
        if (((Integer) this.b.get(str)) != null) {
            return;
        }
        a(e(), str);
    }

    public final void l(String str) {
        Integer num;
        if (!this.d.contains(str) && (num = (Integer) this.b.remove(str)) != null) {
            this.a.remove(num);
        }
        this.e.remove(str);
        if (this.f.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.f.get(str));
            this.f.remove(str);
        }
        if (this.g.containsKey(str)) {
            Log.w("ActivityResultRegistry", "Dropping pending result for request " + str + ": " + this.g.getParcelable(str));
            this.g.remove(str);
        }
        e eVar = (e) this.c.get(str);
        if (eVar != null) {
            eVar.b();
            this.c.remove(str);
        }
    }
}
