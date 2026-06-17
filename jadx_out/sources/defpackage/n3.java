package defpackage;

import android.content.Context;
import android.content.Intent;
import defpackage.m3;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class n3 extends m3 {
    public static final a a = new a(null);

    @Override // defpackage.m3
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String[] strArr) {
        context.getClass();
        strArr.getClass();
        return a.a(strArr);
    }

    @Override // defpackage.m3
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public m3.a b(Context context, String[] strArr) {
        context.getClass();
        strArr.getClass();
        if (strArr.length == 0) {
            return new m3.a(y42.h());
        }
        for (String str : strArr) {
            if (c30.a(context, str) != 0) {
                return null;
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(xn3.b(x42.e(strArr.length), 16));
        for (String str2 : strArr) {
            i73 i73VarA = fu4.a(str2, Boolean.TRUE);
            linkedHashMap.put(i73VarA.c(), i73VarA.d());
        }
        return new m3.a(linkedHashMap);
    }

    @Override // defpackage.m3
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Map c(int i, Intent intent) {
        if (i != -1) {
            return y42.h();
        }
        if (intent == null) {
            return y42.h();
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (intArrayExtra == null || stringArrayExtra == null) {
            return y42.h();
        }
        ArrayList arrayList = new ArrayList(intArrayExtra.length);
        for (int i2 : intArrayExtra) {
            arrayList.add(Boolean.valueOf(i2 == 0));
        }
        return y42.o(ww.f0(ua.y(stringArrayExtra), arrayList));
    }

    /* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
    public static final class a {
        public /* synthetic */ a(we0 we0Var) {
            this();
        }

        public final Intent a(String[] strArr) {
            strArr.getClass();
            Intent intentPutExtra = new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
            intentPutExtra.getClass();
            return intentPutExtra;
        }

        public a() {
        }
    }
}
