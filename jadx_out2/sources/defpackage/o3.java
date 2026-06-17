package defpackage;

import android.content.Context;
import android.content.Intent;
import defpackage.m3;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes.dex */
public final class o3 extends m3 {
    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: a(Landroid/content/Context;Ljava/lang/Object;)Landroid/content/Intent; */
    @Override // defpackage.m3
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public Intent a(Context context, String str) {
        context.getClass();
        str.getClass();
        return n3.a.a(new String[]{str});
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: b(Landroid/content/Context;Ljava/lang/Object;)Lm3$a; */
    @Override // defpackage.m3
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public m3.a b(Context context, String str) {
        context.getClass();
        str.getClass();
        if (c30.a(context, str) == 0) {
            return new m3.a(Boolean.TRUE);
        }
        return null;
    }

    /* JADX DEBUG: Don't trust debug lines info. Lines numbers was adjusted: min line is 1 */
    /* JADX DEBUG: Method merged with bridge method: c(ILandroid/content/Intent;)Ljava/lang/Object; */
    @Override // defpackage.m3
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public Boolean c(int i, Intent intent) {
        if (intent == null || i != -1) {
            return Boolean.FALSE;
        }
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        boolean z = false;
        if (intArrayExtra != null) {
            int length = intArrayExtra.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                if (intArrayExtra[i2] == 0) {
                    z = true;
                    break;
                }
                i2++;
            }
        }
        return Boolean.valueOf(z);
    }
}
