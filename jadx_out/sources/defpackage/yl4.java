package defpackage;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class yl4 implements Iterable {
    public final ArrayList f = new ArrayList();
    public final Context g;

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public interface a {
        Intent a0();
    }

    public yl4(Context context) {
        this.g = context;
    }

    public static yl4 e(Context context) {
        return new yl4(context);
    }

    public yl4 b(Intent intent) {
        this.f.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public yl4 c(Activity activity) {
        Intent intentA0 = activity instanceof a ? ((a) activity).a0() : null;
        if (intentA0 == null) {
            intentA0 = y13.a(activity);
        }
        if (intentA0 != null) {
            ComponentName component = intentA0.getComponent();
            if (component == null) {
                component = intentA0.resolveActivity(this.g.getPackageManager());
            }
            d(component);
            b(intentA0);
        }
        return this;
    }

    public yl4 d(ComponentName componentName) {
        int size = this.f.size();
        try {
            Intent intentB = y13.b(this.g, componentName);
            while (intentB != null) {
                this.f.add(size, intentB);
                intentB = y13.b(this.g, intentB.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public void f() {
        g(null);
    }

    public void g(Bundle bundle) {
        if (this.f.isEmpty()) {
            e04.a("No intents added to TaskStackBuilder; cannot startActivities");
            return;
        }
        Intent[] intentArr = (Intent[]) this.f.toArray(new Intent[0]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (c30.j(this.g, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(268435456);
        this.g.startActivity(intent);
    }

    @Override // java.lang.Iterable
    public Iterator iterator() {
        return this.f.iterator();
    }
}
