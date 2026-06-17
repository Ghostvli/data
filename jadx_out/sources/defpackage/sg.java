package defpackage;

import android.graphics.Bitmap;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-d258b9486bcf5759e155f5bab92d46ef62bd8d08e8b1f4ee09698e84cf22fec5 */
/* JADX INFO: loaded from: classes3.dex */
public class sg {
    public Result a;
    public eb4 b;
    public final int c = 2;

    public sg(Result result, eb4 eb4Var) {
        this.a = result;
        this.b = eb4Var;
    }

    public static List f(List list, eb4 eb4Var) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(eb4Var.f((ResultPoint) it.next()));
        }
        return arrayList;
    }

    public BarcodeFormat a() {
        return this.a.getBarcodeFormat();
    }

    public Bitmap b() {
        return this.b.b(null, 2);
    }

    public byte[] c() {
        return this.a.getRawBytes();
    }

    public Map d() {
        return this.a.getResultMetadata();
    }

    public String e() {
        return this.a.getText();
    }

    public String toString() {
        return this.a.getText();
    }
}
